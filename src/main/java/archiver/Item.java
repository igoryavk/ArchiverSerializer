package archiver;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private byte[] buffer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }
}
