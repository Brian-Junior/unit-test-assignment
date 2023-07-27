package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);

		}

	}

	static Stream<Object> argumentsForAddPositive() {

		return (Stream.of(arguments(1, 2, 3, false), arguments(4, 0, 4, true), arguments(3, -4, -1, true),
				arguments(-4, -5, -9, true), arguments(0, 0, 0, true), arguments(5, 3, 8, false),
				arguments(55, 55, 110, false), arguments(-9, 2, -7, true), arguments(13, 200, 213, false),
				arguments(999, 1, 1000, false)));
	}

	// assert that the sum of 2 numbers equal 100
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForEqualsOneHundred")
	void assertThatTwoNumbersAddedEqualOneHundred(int a, int b, boolean expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.equalsOneHundred(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.equalsOneHundred(a, b)).isInstanceOf(IllegalArgumentException.class);

		}
	}

	static Stream<Arguments> argumentsForEqualsOneHundred() {

		return (Stream.of(arguments(49, 50, false, true), arguments(25, 75, true, false)));
	}

	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}

}
