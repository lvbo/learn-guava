/*
 * Copyright (C) 2007 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.lvbo.learn.guava.collect.newcollect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.*;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * Tests for {@link Multisets}.
 *
 * @author Mike Bostock
 * @author Jared Levy
 * @author Louis Wasserman
 */
public class MultisetsTest extends TestCase {

  public void testNewTreeMultisetComparator() {
    TreeMultiset<String> multiset = TreeMultiset.create(Collections.reverseOrder());
    multiset.add("bar", 3);
    multiset.add("foo", 2);
  }

  public void testRetainOccurrencesEmpty() {
    Multiset<String> multiset = HashMultiset.create();
    Multiset<String> toRetain = HashMultiset.create(Arrays.asList("a", "b", "a"));
    assertFalse(Multisets.retainOccurrences(multiset, toRetain));
  }

  public void testRemoveOccurrencesIterableEmpty() {
    Multiset<String> multiset = HashMultiset.create();
    Iterable<String> toRemove = Arrays.asList("a", "b", "a");
    assertFalse(Multisets.removeOccurrences(multiset, toRemove));
    assertTrue(multiset.isEmpty());
  }

  public void testRemoveOccurrencesMultisetEmpty() {
    Multiset<String> multiset = HashMultiset.create();
    Multiset<String> toRemove = HashMultiset.create(Arrays.asList("a", "b", "a"));
    assertFalse(Multisets.removeOccurrences(multiset, toRemove));
    assertTrue(multiset.isEmpty());
  }

  public void testUnion() {
    Multiset<String> ms1 = HashMultiset.create(Arrays.asList("a", "b", "a"));
    Multiset<String> ms2 = HashMultiset.create(Arrays.asList("a", "b", "b", "c"));
    Multisets.union(ms1, ms2);
  }

  public void testUnionEqualMultisets() {
    Multiset<String> ms1 = HashMultiset.create(Arrays.asList("a", "b", "a"));
    Multiset<String> ms2 = HashMultiset.create(Arrays.asList("a", "b", "a"));
    assertEquals(ms1, Multisets.union(ms1, ms2));
  }

  public void testUnionEmptyNonempty() {
    Multiset<String> ms1 = HashMultiset.create();
    Multiset<String> ms2 = HashMultiset.create(Arrays.asList("a", "b", "a"));
    assertEquals(ms2, Multisets.union(ms1, ms2));
  }

  public void testUnionNonemptyEmpty() {
    Multiset<String> ms1 = HashMultiset.create(Arrays.asList("a", "b", "a"));
    Multiset<String> ms2 = HashMultiset.create();
    assertEquals(ms1, Multisets.union(ms1, ms2));
  }

  public void testDifferenceWithMoreElementsInSecondMultiset() {
    Multiset<String> ms1 = HashMultiset.create(Arrays.asList("a", "b", "a"));
    Multiset<String> ms2 = HashMultiset.create(Arrays.asList("a", "b", "b", "b"));
    Multiset<String> diff = Multisets.difference(ms1, ms2);
    assertEquals(0, diff.count("b"));
    assertEquals(1, diff.count("a"));
    assertFalse(diff.contains("b"));
    assertTrue(diff.contains("a"));
  }

  public void testDifferenceEmptyNonempty() {
    Multiset<String> ms1 = HashMultiset.create();
    Multiset<String> ms2 = HashMultiset.create(Arrays.asList("a", "b", "a"));
    assertEquals(ms1, Multisets.difference(ms1, ms2));
  }

  public void testDifferenceNonemptyEmpty() {
    Multiset<String> ms1 = HashMultiset.create(Arrays.asList("a", "b", "a"));
    Multiset<String> ms2 = HashMultiset.create();
    assertEquals(ms1, Multisets.difference(ms1, ms2));
  }

  public void testContainsOccurrencesEmpty() {
    Multiset<String> superMultiset = HashMultiset.create(Arrays.asList("a", "b", "a"));
    Multiset<String> subMultiset = HashMultiset.create();
    assertTrue(Multisets.containsOccurrences(superMultiset, subMultiset));
    assertFalse(Multisets.containsOccurrences(subMultiset, superMultiset));
  }

  public void testContainsOccurrences() {
    Multiset<String> superMultiset = HashMultiset.create(Arrays.asList("a", "b", "a"));
    Multiset<String> subMultiset = HashMultiset.create(Arrays.asList("a", "b"));
    assertTrue(Multisets.containsOccurrences(superMultiset, subMultiset));
    assertFalse(Multisets.containsOccurrences(subMultiset, superMultiset));
    Multiset<String> diffMultiset = HashMultiset.create(Arrays.asList("a", "b", "c"));
    assertFalse(Multisets.containsOccurrences(superMultiset, diffMultiset));
    assertTrue(Multisets.containsOccurrences(diffMultiset, subMultiset));
  }

  public void testRetainEmptyOccurrences() {
    Multiset<String> multiset = HashMultiset.create(Arrays.asList("a", "b", "a"));
    Multiset<String> toRetain = HashMultiset.create();
    assertTrue(Multisets.retainOccurrences(multiset, toRetain));
    assertTrue(multiset.isEmpty());
  }

  public void testRetainOccurrences() {
    Multiset<String> multiset = TreeMultiset.create(Arrays.asList("a", "b", "a", "c"));
    Multiset<String> toRetain = HashMultiset.create(Arrays.asList("a", "b", "b"));
    assertTrue(Multisets.retainOccurrences(multiset, toRetain));
//    assertThat(multiset).containsExactly("a", "b").inOrder();
  }

  public void testRemoveEmptyOccurrencesMultiset() {
    Multiset<String> multiset = TreeMultiset.create(Arrays.asList("a", "b", "a"));
    Multiset<String> toRemove = HashMultiset.create();
    assertFalse(Multisets.removeOccurrences(multiset, toRemove));
//    assertThat(multiset).containsExactly("a", "a", "b").inOrder();
  }

  public void testRemoveOccurrencesMultiset() {
    Multiset<String> multiset = TreeMultiset.create(Arrays.asList("a", "b", "a", "c"));
    Multiset<String> toRemove = HashMultiset.create(Arrays.asList("a", "b", "b"));
    assertTrue(Multisets.removeOccurrences(multiset, toRemove));
//    assertThat(multiset).containsExactly("a", "c").inOrder();
  }

  public void testRemoveEmptyOccurrencesIterable() {
    Multiset<String> multiset = TreeMultiset.create(Arrays.asList("a", "b", "a"));
    Iterable<String> toRemove = ImmutableList.of();
    assertFalse(Multisets.removeOccurrences(multiset, toRemove));
//    assertThat(multiset).containsExactly("a", "a", "b").inOrder();
  }

  public void testRemoveOccurrencesMultisetIterable() {
    Multiset<String> multiset = TreeMultiset.create(Arrays.asList("a", "b", "a", "c"));
    List<String> toRemove = Arrays.asList("a", "b", "b");
    assertTrue(Multisets.removeOccurrences(multiset, toRemove));
//    assertThat(multiset).containsExactly("a", "c").inOrder();
  }
}
