package io.github.lvbo.learn.guava.files;

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
        File original = new File("src/main/resources/sample.pdf");
        File copy = new File("src/main/resources/sample_copy.pdf");
        Files.asByteSource(original).copyTo(Files.asByteSink(copy));
    }

    @Test
    public void readFileIntoListOfStringsTest() throws Exception {
        File file = new File("src/main/resources/lines.txt");
        List<String> readLines = Files.asCharSource(file, Charsets.UTF_8).readLines();
        System.out.println(readLines);
    }

    @Test
    public void testHashFile() throws IOException {
        File file = new File("src/main/resources/lines.txt");
        HashCode hashCode = Files.asByteSource(file).hash(Hashing.sha256());
        System.out.println(hashCode);
    }

    @Test
    public void appendingWritingToFileTest() throws IOException {
        File file = new File("src/main/resources/quote.txt");
        String hamletQuoteStart = "To be, or not to be";
        Files.asCharSink(file, Charsets.UTF_8, FileWriteMode.APPEND).write(hamletQuoteStart);
    }
}
