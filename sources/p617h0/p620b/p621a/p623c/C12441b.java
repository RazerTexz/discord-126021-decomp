package p617h0.p620b.p621a.p623c;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import org.objenesis.ObjenesisException;
import p007b.p100d.p104b.p105a.C1643a;
import p617h0.p620b.p621a.InterfaceC12436a;

/* JADX INFO: renamed from: h0.b.a.c.b */
/* JADX INFO: compiled from: ObjectInputStreamInstantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12441b<T> implements InterfaceC12436a<T> {

    /* JADX INFO: renamed from: a */
    public ObjectInputStream f26385a;

    public C12441b(Class<T> cls) {
        if (!Serializable.class.isAssignableFrom(cls)) {
            throw new ObjenesisException(new NotSerializableException(cls + " not serializable"));
        }
        try {
            this.f26385a = new ObjectInputStream(new a(cls));
        } catch (IOException e) {
            StringBuilder sbM833U = C1643a.m833U("IOException: ");
            sbM833U.append(e.getMessage());
            throw new Error(sbM833U.toString());
        }
    }

    @Override // p617h0.p620b.p621a.InterfaceC12436a
    public T newInstance() {
        try {
            return (T) this.f26385a.readObject();
        } catch (ClassNotFoundException e) {
            StringBuilder sbM833U = C1643a.m833U("ClassNotFoundException: ");
            sbM833U.append(e.getMessage());
            throw new Error(sbM833U.toString());
        } catch (Exception e2) {
            throw new ObjenesisException(e2);
        }
    }

    /* JADX INFO: renamed from: h0.b.a.c.b$a */
    /* JADX INFO: compiled from: ObjectInputStreamInstantiator.java */
    public static class a extends InputStream {

        /* JADX INFO: renamed from: j */
        public static final int[] f26386j = {1, 2, 2};

        /* JADX INFO: renamed from: k */
        public static byte[] f26387k;

        /* JADX INFO: renamed from: l */
        public static byte[] f26388l;

        /* JADX INFO: renamed from: p */
        public byte[][] f26392p;

        /* JADX INFO: renamed from: q */
        public final byte[] f26393q;

        /* JADX INFO: renamed from: m */
        public int f26389m = 0;

        /* JADX INFO: renamed from: o */
        public int f26391o = 0;

        /* JADX INFO: renamed from: n */
        public byte[] f26390n = f26387k;

        static {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeShort(-21267);
                dataOutputStream.writeShort(5);
                f26387k = byteArrayOutputStream.toByteArray();
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream2);
                dataOutputStream2.writeByte(115);
                dataOutputStream2.writeByte(113);
                dataOutputStream2.writeInt(8257536);
                f26388l = byteArrayOutputStream2.toByteArray();
            } catch (IOException e) {
                StringBuilder sbM833U = C1643a.m833U("IOException: ");
                sbM833U.append(e.getMessage());
                throw new Error(sbM833U.toString());
            }
        }

        public a(Class<?> cls) {
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
                this.f26393q = byteArray;
                this.f26392p = new byte[][]{f26387k, byteArray, f26388l};
            } catch (IOException e) {
                StringBuilder sbM833U = C1643a.m833U("IOException: ");
                sbM833U.append(e.getMessage());
                throw new Error(sbM833U.toString());
            }
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return Integer.MAX_VALUE;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            byte[] bArr = this.f26390n;
            int i = this.f26389m;
            int i2 = i + 1;
            this.f26389m = i2;
            byte b2 = bArr[i];
            if (i2 >= bArr.length) {
                this.f26389m = 0;
                int i3 = f26386j[this.f26391o];
                this.f26391o = i3;
                this.f26390n = this.f26392p[i3];
            }
            return b2;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int length = this.f26390n.length - this.f26389m;
            int i3 = i2;
            while (length <= i3) {
                System.arraycopy(this.f26390n, this.f26389m, bArr, i, length);
                i += length;
                i3 -= length;
                this.f26389m = 0;
                int i4 = f26386j[this.f26391o];
                this.f26391o = i4;
                byte[] bArr2 = this.f26392p[i4];
                this.f26390n = bArr2;
                length = 0 + bArr2.length;
            }
            if (i3 > 0) {
                System.arraycopy(this.f26390n, this.f26389m, bArr, i, i3);
                this.f26389m += i3;
            }
            return i2;
        }
    }
}
