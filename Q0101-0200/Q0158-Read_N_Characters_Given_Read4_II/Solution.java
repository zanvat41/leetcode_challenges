/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */

    char[] readBuf = new char[4];
    int index = 0;
    int size = 0;
    public int read(char[] buf, int n) {
        int res = 0;

        while (res < n){
            // call api for new read if we are at end of our current readbuf
            if (index == 0){
                size = read4(readBuf);
            }
            if (size == 0){
                break; // nothing left
            }
            buf[res++] = readBuf[index++];
            if (index >= size){ // weve reached end of previous read, reset our index so that we can signal to read again
                index = 0;
            }
        }

        // always read from our buf, and set at 0
        return res;

    }
}
