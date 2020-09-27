package io.github.lvbo.learn.guava.basic;

import com.google.common.base.Throwables;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author tiantiangao
 */
public class ThrowablesTest {

	@Test
	public void test() {
		testPropagate();
		testPropagateIfInstanceOf();
		testPropagateIfPossible();
		testGetRootCause();
		testGetStackTraceAsString();
		testGetCausalChain();
	}

	private void testPropagate() {
		try {
			URL url = new URL("http://www.dianping.com");
			InputStream in = url.openStream();
			in.close();
		} catch (Exception e) {
			try {
				Throwables.throwIfInstanceOf(e, RuntimeException.class);
				throw new RuntimeException(e);
			} catch (Throwable t) {
				assertTrue(true);
			}
		}
	}

	private void testPropagateIfInstanceOf() {
		try {
			throw new NumberFormatException("a");
		} catch (Throwable t) {
			try {
				Throwables.propagateIfInstanceOf(t, NumberFormatException.class);
				fail();
			} catch (Throwable t2) {
				assertTrue(true);
			}
		}
	}

	private void testPropagateIfPossible() {
		try {
			throw new NumberFormatException();
		} catch (Throwable t) {
			try {
				Throwables.propagateIfPossible(t, Exception.class);
				fail();
			} catch (Throwable t1) {
				assertTrue(true);
			}
		}
	}

	private void testGetRootCause() {
		Exception e = new NumberFormatException("a");
		assertEquals(e, Throwables.getRootCause(e));

		IllegalArgumentException e2 = new IllegalArgumentException(e);
		assertEquals(e, Throwables.getRootCause(e2));
	}

	private void testGetStackTraceAsString() {
		try {
			Integer.parseInt("a");
			fail();
		} catch (Exception e) {
			assertTrue(Throwables.getStackTraceAsString(e).startsWith(
					"java.lang.NumberFormatException: For input string: \"a\""));
		}
	}

	private void testGetCausalChain() {
		FileNotFoundException fnfe = new FileNotFoundException();
		IllegalArgumentException iae = new IllegalArgumentException(fnfe);
		RuntimeException re = new RuntimeException(iae);
		IllegalStateException ex = new IllegalStateException(re);

		assertEquals(Arrays.asList(ex, re, iae, fnfe), Throwables.getCausalChain(ex));
		try {
			Throwables.getCausalChain(null);
			fail("Should have throw NPE");
		} catch (NullPointerException expected) {
		}
	}
}
