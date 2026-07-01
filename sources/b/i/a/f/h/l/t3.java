package b.i.a.f.h.l;

import b.d.b.a.outline;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t3 implements Serializable, Iterable<Byte> {
    public static final t3 j = new z3(w4.f1500b);
    public static final x3 k;
    private int zzc = 0;

    static {
        k = q3.a() ? new c4(null) : new w3(null);
    }

    public static t3 h(byte[] bArr, int i, int i2) {
        l(i, i + i2, bArr.length);
        return new z3(k.a(bArr, i, i2));
    }

    public static int l(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i >= 0) {
            if (i2 < i) {
                throw new IndexOutOfBoundsException(outline.h(66, "Beginning index larger than ending index: ", i, ", ", i2));
            }
            throw new IndexOutOfBoundsException(outline.h(37, "End index: ", i2, " >= ", i3));
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append("Beginning index: ");
        sb.append(i);
        sb.append(" < 0");
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public abstract byte c(int i);

    public abstract int d();

    public abstract int e(int i, int i2, int i3);

    public abstract boolean equals(Object obj);

    public abstract t3 g(int i, int i2);

    public final int hashCode() {
        int iE = this.zzc;
        if (iE == 0) {
            int iD = d();
            iE = e(iD, 0, iD);
            if (iE == 0) {
                iE = 1;
            }
            this.zzc = iE;
        }
        return iE;
    }

    public abstract String i(Charset charset);

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new v3(this);
    }

    public abstract void j(u3 u3Var) throws IOException;

    public abstract byte k(int i);

    public abstract boolean m();

    public final int n() {
        return this.zzc;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(d());
        objArr[2] = d() <= 50 ? b.i.a.f.e.o.f.W1(this) : String.valueOf(b.i.a.f.e.o.f.W1(g(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }
}
