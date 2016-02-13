package com.lvbo.guavatest.files;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.*;
import org.junit.Test;

import java.io.*;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by lvbo on 16/2/13.
 */
public class FilesTest {

    @Test
    public void testFileCopy() throws IOException {
        File original = new File("path/to/original");
        File copy = new File("path/to/copy");
        Files.copy(original, copy);
    }

    @Test
    public void testMoveFile() {
        File original = new File("src/main/resources/copy.txt");
        File newFile = new File("src/main/resources/newFile.txt");
        try {
            Files.move(original, newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readFileIntoListOfStringsTest() throws Exception {
        File file = new File("src/main/resources/lines.txt");
        List<String> expectedLines = Lists.newArrayList("The quick brown", "fox jumps over", "the lazy dog");
        List<String> readLines = Files.readLines(file, Charsets.UTF_8);
        assertThat(expectedLines, is(readLines));
    }

    @Test
    public void readLinesWithProcessor() throws Exception {
//        "Savage, Tom",Being A Great Cook,Acme Publishers,ISBN-123456,29.99,1
//        "Smith, Jeff",Art is Fun,Acme Publishers,ISBN-456789,19.99,2
//        "Vandeley, Art",Be an Architect,Acme Publishers,ISBN-234567,49.99,3
//        "Jones, Fred",History of Football,Acme Publishers,ISBN-345678,24.99,4
//        "Timpton, Patty",Gardening My Way,Acme Publishers,ISBN-4567891,34.99,5
        File file = new File("src/main/resources/books.csv");
        List<String> expectedLines = Lists.newArrayList("Being A Great Cook","Art is Fun","Be an Architect","History of Football","Gardening My Way");
        List<String> readLines = Files.readLines(file, Charsets.UTF_8, new ToListLineProcessor());
        assertThat(expectedLines,is(readLines));
    }

    @Test
    public void testHashFile() throws IOException {
        File file = new File("src/main/resources/sampleTextFileOne.txt");
        HashCode hashCode = Files.hash(file, Hashing.md5());
        System.out.println(hashCode);
    }

    @Test
    public void appendingWritingToFileTest() throws IOException {
        File file = new File("src/test/resources/quote.txt");
        file.deleteOnExit();
        String hamletQuoteStart = "To be, or not to be";
        Files.write(hamletQuoteStart,file, Charsets.UTF_8);
        assertThat(Files.toString(file,Charsets.UTF_8),is(hamletQuoteStart));
        String hamletQuoteEnd = ",that is the question";
        Files.append(hamletQuoteEnd,file,Charsets.UTF_8);
        assertThat(Files.toString(file, Charsets.UTF_8), is(hamletQuoteStart + hamletQuoteEnd));
        String overwrite = "Overwriting the file";
        Files.write(overwrite, file, Charsets.UTF_8);
        assertThat(Files.toString(file, Charsets.UTF_8), is(overwrite));
    }

    @Test
    public void copyToByteSinkTest() throws Exception {
        File dest = new File("src/test/resources/sampleCompany.pdf");
        dest.deleteOnExit();
        File source = new File("src/main/resources/sample.pdf");
        ByteSource byteSource = Files.asByteSource(source);
        ByteSink byteSink = Files.asByteSink(dest);
        byteSource.copyTo(byteSink);
        assertThat(Files.toByteArray(dest), is(Files.toByteArray(source)));
    }

    @Test
    public void limitByteStreamTest() throws Exception {
        File binaryFile = new File("src/main/resources/sample.pdf");
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(binaryFile));
        InputStream limitedInputStream = ByteStreams.limit(inputStream,10);
        assertThat(limitedInputStream.available(),is(10));
        assertThat(inputStream.available(),is(218882));
    }
}
