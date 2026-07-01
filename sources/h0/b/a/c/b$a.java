package h0.b.a.c;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamClass;

/* JADX INFO: compiled from: ObjectInputStreamInstantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a extends InputStream {
    public static final int[] j = {1, 2, 2};
    public static byte[] k;
    public static byte[] l;
    public byte[][] p;
    public final byte[] q;
    public int m = 0;
    public int o = 0;
    public byte[] n = k;

    static {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeShort(-21267);
            dataOutputStream.writeShort(5);
            k = byteArrayOutputStream.toByteArray();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream2);
            dataOutputStream2.writeByte(115);
            dataOutputStream2.writeByte(113);
            dataOutputStream2.writeInt(8257536);
            l = byteArrayOutputStream2.toByteArray();
        } catch (IOException e) {
            StringBuilder sbU = b.d.b.a.a.U("IOException: ");
            sbU.append(e.getMessage());
            throw new Error(sbU.toString());
        }
    }

    public b$a(Class<?> cls) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeByte(115);
            dataOutputStream.writeByte(114);
            dataOutputStream.writeUTF(cls.getName());
            dataOutputStream.writeLong(ObjectStreamClass.lookup(cls).getSerialVersionUID());
            dataOutputStream.writeByte(2);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeByte(120);
            dataOutputStream.writeByte(112);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.q = byteArray;
            this.p = new byte[][]{k, byteArray, l};
        } catch (IOException e) {
            StringBuilder sbU = b.d.b.a.a.U("IOException: ");
            sbU.append(e.getMessage());
            throw new Error(sbU.toString());
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return Integer.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = this.n;
        int i = this.m;
        int i2 = i + 1;
        this.m = i2;
        byte b2 = bArr[i];
        if (i2 >= bArr.length) {
            this.m = 0;
            int i3 = j[this.o];
            this.o = i3;
            this.n = this.p[i3];
        }
        return b2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int length = this.n.length - this.m;
        int i3 = i2;
        while (length <= i3) {
            System.arraycopy(this.n, this.m, bArr, i, length);
            i += length;
            i3 -= length;
            this.m = 0;
            int i4 = j[this.o];
            this.o = i4;
            byte[] bArr2 = this.p[i4];
            this.n = bArr2;
            length = 0 + bArr2.length;
        }
        if (i3 > 0) {
            System.arraycopy(this.n, this.m, bArr, i, i3);
            this.m += i3;
        }
        return i2;
    }
}
