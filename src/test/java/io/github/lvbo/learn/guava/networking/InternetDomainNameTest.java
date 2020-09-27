package io.github.lvbo.learn.guava.networking;

import com.google.common.net.InternetDomainName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lvbo
 * @version V1.0
 * @date 2020/9/24 11:11
 */
public class InternetDomainNameTest {

    @Test
    public void testInternetDomainName() {
        InternetDomainName owner = InternetDomainName.from("mail.google.com");
        assertEquals("com", owner.publicSuffix().toString());
        assertEquals("com", owner.registrySuffix().toString());
        assertEquals("google.com", owner.topPrivateDomain().toString());
    }
}
