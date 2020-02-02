import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertToIPv4Test {
    @Test
    public void sampleTest() {
        assertEquals("128.114.17.104", ConvertToIPv4.longToIP(2154959208L));
        assertEquals("0.0.0.0", ConvertToIPv4.longToIP(0));
        assertEquals("128.32.10.1", ConvertToIPv4.longToIP(2149583361L));
    }
}