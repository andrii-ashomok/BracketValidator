package com.example;

import org.junit.Test;

public class BracketValidatorTest {

    @Test
    public void validCase() {
        BracketValidator.main(new String[]{"(", ")", "hello(Andrey), this test from (robot)"});
    }

    @Test
    public void openBracketCase() {
        BracketValidator.main(new String[]{"[", "]", "hello[([Andrey]), this test from ([robot])"});
    }

    @Test
    public void closeBracketCase() {
        BracketValidator.main(new String[]{"{", "}", "hello{Andrey}, this test from ({{robot)}}}"});
    }

    @Test
    public void trickyCase() {
        BracketValidator.main(new String[]{"(", ")", "hello)){Andrey}, this test from ({{robot)}}(("});
    }

}
