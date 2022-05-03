package ua.lviv.iot;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.lviv.iot.parser.HyphenToUnderscoreParser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HyphenToUnderscoreParserTest {

    private static final HyphenToUnderscoreParser parser = new HyphenToUnderscoreParser();
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    public void nullInputParseToStdOutTest() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseToStdOut(null));
        assertThrows(IllegalArgumentException.class, () -> parser.parseToStdOut(null, 0));
    }

    @Test
    public void nullInputParseTest() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse(null));
        assertThrows(IllegalArgumentException.class, () -> parser.parse(null, 0));
    }

    @ParameterizedTest
    @MethodSource("provideStringsForParserTest")
    public void parsingInputTest(String input, String expected) {
        String actual = parser.parse(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForPartialParserTest")
    public void parsingInputPartiallyTest(String input, int indexToCheckExclusive, String expected) {
        String actual = parser.parse(input, indexToCheckExclusive);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForParserTest")
    public void parsingInputToStdOutTest(String input, String expected) {
        parser.parseToStdOut(input);
        String actual = outContent.toString();
        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @MethodSource("provideStringsForPartialParserTest")
    public void parsingInputPartiallyToStdOutTest(String input, int indexToCheckExclusive, String expected) {
        parser.parseToStdOut(input, indexToCheckExclusive);
        String actual = outContent.toString();
        assertEquals(expected, actual);
    }


    private static Stream<Arguments> provideStringsForParserTest() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("-", "-"),
                Arguments.of("ice-cream", "ice_cream"),
                Arguments.of("free-for-all", "free_for_all"),
                Arguments.of("-internet of what?-things", "-internet of what?-things")
        );
    }

    private static Stream<Arguments> provideStringsForPartialParserTest() {
        return Stream.of(
                Arguments.of("one-for-one", 5, "one_for-one"),
                Arguments.of("mother-in-law came to him- upsetting", 0, "mother-in-law came to him- upsetting"),
                Arguments.of("mother-in-law came to him- upsetting", 20, "mother_in_law came to him- upsetting")
        );
    }
}
