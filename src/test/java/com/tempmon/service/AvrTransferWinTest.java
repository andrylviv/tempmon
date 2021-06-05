package com.tempmon.service;

import com.tempmon.service.AvrTransferWin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvrTransferWinTest {
    @ParameterizedTest
    @CsvSource(
            {"1, -111, 25.0625",
                    "5,   80, 85",
                    "0,    0, 0",
                    "-2, 111,-25.0625",
                    "-4,-112,-55"
            }
    )

    void convert(byte hsb,byte lsb,  double expectedResult) {
        AvrTransferWin i = new AvrTransferWin();
        byte data[]= new byte[2];
        data[0]= hsb;
        data[1]= lsb;
        assertEquals(expectedResult, i.convert(data));
    }
}