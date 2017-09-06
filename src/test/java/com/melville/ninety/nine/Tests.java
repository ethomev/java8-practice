package com.melville.ninety.nine;


import static java.util.Arrays.asList;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

public class Tests {

    @Test
    public void shouldFindLastElementFromAListOfAlphabets() throws Exception {
        assertThat(P01.last(asList("a", "b", "c", "d"))).isEqualTo("d");
    }

    @Test
    public void shouldFindSecondLastElementFromAList() throws Exception {
        List<Integer> numbers = asList(1, 2, 11, 4, 5, 8, 10, 6);
        assertThat(P02.secondLast(numbers)).isEqualTo(10);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowExceptionWhenListEmpty() throws Exception {
        P02.secondLast(Collections.emptyList());
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowExceptionWhenListHasSingleElement() throws Exception {
        P02.secondLast(Arrays.asList(1));
    }

    @Test
    public void shouldFindKthElementFromAList() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(P03.kth(numbers, 2)).isEqualTo(3);
    }

    @Test
    public void listOfEmptyListShouldBe0() throws Exception {
        int length = P04.length(Collections.emptyList());
        assertThat(length).isEqualTo(0);
    }

    @Test
    public void shouldFindListOfNonEmptyList() throws Exception {
        assertThat(P04.length(Arrays.asList(1, 2, 3, 4, 5))).isEqualTo(5);
    }

    @Test
    public void shouldReverseAList() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(P05.reverse(numbers)).containsExactly(5, 4, 3, 2, 1);
    }

    @Test
    public void shouldReturnTrueWhenListIsPalindrome() throws Exception {
        assertThat(P06.isPalindrome(Arrays.asList("x", "a", "m", "a", "x"))).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenListIsNotPalindrome() throws Exception {
        assertThat(P06.isPalindrome(Arrays.asList(1, 2, 3, 4, 5))).isFalse();
    }

    @Test
    public void shouldFlattenAListOfList() throws Exception {
        List<String> flatten = P07.flatten(asList("a", asList("b", asList("c", "d")), "e"), String.class);
        assertThat(flatten).hasSize(5);
        assertThat(flatten).containsExactly("a", "b", "c", "d", "e");
    }

    @Test
    public void shouldFlattenDeepNestedLists() throws Exception {
        List<String> flatten = P07.flatten(asList("a", asList("b", asList("c", asList("d", "e", asList("f", "g"))), "h")), String.class);
        assertThat(flatten).hasSize(8);
        assertThat(flatten).containsExactly("a", "b", "c", "d", "e", "f", "g", "h");
    }

    @Test
    public void shouldReturnEmptyListWhenTryingToFlattenAnEmptyList() throws Exception {
        List<String> flatten = P07.flatten(Collections.emptyList(), String.class);
        assertThat(flatten.isEmpty()).isTrue();
    }
}
