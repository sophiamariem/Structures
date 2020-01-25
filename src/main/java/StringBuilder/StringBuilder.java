package StringBuilder;

public class StringBuilder {
    private static int SIZE = 16;
    private int size;
    private char[] str;
    private int count;

    public StringBuilder() {
        this.size = SIZE;
        this.str = new char[SIZE];
    }

    public StringBuilder append(String str) {
        int newStringLength = str.length();
        while (needsResize(newStringLength)) {
            resize();
        }
        // src, srcPos, dest, destPos, length
        System.arraycopy(str.toCharArray(), 0, this.str, this.count, newStringLength);
        this.count += newStringLength;
        return this;
    }

    public StringBuilder insert(int offset, String str) {
        int newStringLength = str.length();
        while (needsResize(newStringLength)) {
            resize();
        }
        // src, srcPos, dest, destPos, length
        System.arraycopy(this.str, offset, this.str, offset + newStringLength, this.count - offset);
        System.arraycopy(str.toCharArray(), 0, this.str, offset, newStringLength);

        this.count += newStringLength;
        return this;
    }

    private void resize() {
        int oldSize = this.size;
        this.size *= 2;
        char[] newStr = new char[this.size];
        System.arraycopy(this.str, 0, newStr, 0, oldSize);
        this.str = newStr;
    }

    private boolean needsResize(int newStringLength) {
        return this.count + newStringLength > this.size;
    }

    @Override
    public String toString() {
        // Create a copy, don't share the array
        return new String(this.str, 0, count);
    }

}
