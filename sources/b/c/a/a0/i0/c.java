package b.c.a.a0.i0;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: JsonReader.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Closeable {
    public static final String[] j = new String[128];
    public int k;
    public int[] l = new int[32];
    public String[] m = new String[32];
    public int[] n = new int[32];

    static {
        for (int i = 0; i <= 31; i++) {
            j[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public abstract void A() throws IOException;

    public abstract void C() throws IOException;

    public final b D(String str) throws b {
        StringBuilder sbX = b.d.b.a.a.X(str, " at path ");
        sbX.append(getPath());
        throw new b(sbX.toString());
    }

    public abstract void a() throws IOException;

    public abstract void b() throws IOException;

    public abstract void c() throws IOException;

    public abstract void d() throws IOException;

    public abstract boolean e() throws IOException;

    public abstract boolean f() throws IOException;

    public final String getPath() {
        int i = this.k;
        int[] iArr = this.l;
        String[] strArr = this.m;
        int[] iArr2 = this.n;
        StringBuilder sbQ = b.d.b.a.a.Q('$');
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 == 1 || i3 == 2) {
                sbQ.append('[');
                sbQ.append(iArr2[i2]);
                sbQ.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sbQ.append('.');
                if (strArr[i2] != null) {
                    sbQ.append(strArr[i2]);
                }
            }
        }
        return sbQ.toString();
    }

    public abstract double n() throws IOException;

    public abstract int q() throws IOException;

    public abstract String s() throws IOException;

    public abstract String t() throws IOException;

    public abstract c$b u() throws IOException;

    public final void x(int i) {
        int i2 = this.k;
        int[] iArr = this.l;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                StringBuilder sbU = b.d.b.a.a.U("Nesting too deep at ");
                sbU.append(getPath());
                throw new a(sbU.toString());
            }
            this.l = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.m;
            this.m = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.n;
            this.n = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.l;
        int i3 = this.k;
        this.k = i3 + 1;
        iArr3[i3] = i;
    }

    public abstract int y(c$a c_a) throws IOException;
}
