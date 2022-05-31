package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberWorkerTest {
    NumberWorker numberWorker;

    @BeforeEach
    void crateNumberWorker() {
        numberWorker = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 37, 317, 1831, 3469})
    void isPrimeForPrimes(int argument) {
        Assertions.assertTrue(numberWorker.isPrime(argument));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 38, 319, 1845, 3470})
    void isPrimeForNotPrimes(int argument) {
        Assertions.assertFalse(numberWorker.isPrime(argument));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, -5, -149, -560})
    void isPrimeForIncorrectNumbers(int argument) {
        Assertions.assertThrows(IllegalNumberException.class, () -> numberWorker.isPrime(argument));
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/data.csv"}, delimiter = ',')
    void digitsSum(int number, int result) {
        Assertions.assertEquals(numberWorker.digitsSum(number), result);
    }
}