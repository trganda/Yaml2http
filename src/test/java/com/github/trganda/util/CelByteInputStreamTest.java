package com.github.trganda.util;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CelByteInputStreamTest {

    @Test
    public void readTest() throws IOException {
        byte[] want = new byte[]{34, -84, -19, 0, 5, 115, 114, 0, 17, 106, 97, 118, 97, 46, 117, 116, 105, 108, 46, 72, 97, 115, 104, 77, 97, 112, 5, 7, -38, -63, -61, 22, 96, -47, 3, 0, 2, 70, 0, 10, 108, 111, 97, 100, 70, 97, 99, 116, 111, 114, 73, 0, 9, 116, 104, 114, 101, 115, 104, 111, 108, 100, 120, 112, 63, 64, 0, 0, 0, 0, 0, 12, 119, 8, 0, 0, 0, 16, 0, 0, 0, 2, 116, 0, 9, 70, 73, 76, 69, 95, 78, 65, 77, 69, 116, 0, 9, 34};
        String str = "b\"\\xac\\xed\\x00\\x05sr\\x00\\x11java.util.HashMap\\x05\\a\\xda\\xc1\\xc3\\x16`\\xd1\\x03\\x00\\x02F\\x00\\nloadFactorI\\x00\\tthresholdxp?@\\x00\\x00\\x00\\x00\\x00\\fw\\b\\x00\\x00\\x00\\x10\\x00\\x00\\x00\\x02t\\x00\\tFILE_NAMEt\\x00\\t\"";
        ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));

        CelBytesInputStream celBytesInputStream = new CelBytesInputStream(bis);
        celBytesInputStream.readCelBytes();

        byte[] ret = Util.getBytes(celBytesInputStream.getBufString());
        assert want.length == ret.length;
        for (int i = 0; i < want.length; i++) {
            assert want[i] == ret[i];
        }
    }
}
