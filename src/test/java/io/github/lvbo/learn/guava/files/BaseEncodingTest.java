package io.github.lvbo.learn.guava.files;

import com.google.common.io.BaseEncoding;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by lvbo on 16/2/13.
 */
public class BaseEncodingTest {

    @Test
    public void encodeDecodeTest() throws Exception {
        File file = new File("src/main/resources/sample.pdf");
        byte[] bytes = Files.toByteArray(file);
        BaseEncoding baseEncoding = BaseEncoding.base64();
        String encoded = baseEncoding.encode(bytes);
        assertThat(Pattern.matches("[A-Za-z0-9+/=]+",encoded),is(true));
        assertThat(baseEncoding.decode(encoded),is(bytes));
    }


}
