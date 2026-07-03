package p007b.p225i.p226a.p288f.p313h.p325l;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.f.h.l.t3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3837t3 implements Serializable, Iterable<Byte> {

    /* JADX INFO: renamed from: j */
    public static final AbstractC3837t3 f10322j = new C3915z3(C3877w4.f10380b);

    /* JADX INFO: renamed from: k */
    public static final InterfaceC3889x3 f10323k;
    private int zzc = 0;

    static {
        f10323k = C3798q3.m5185a() ? new C3610c4(null) : new C3876w3(null);
    }

    /* JADX INFO: renamed from: h */
    public static AbstractC3837t3 m5279h(byte[] bArr, int i, int i2) {
        m5280l(i, i + i2, bArr.length);
        return new C3915z3(f10323k.mo4603a(bArr, i, i2));
    }

    /* JADX INFO: renamed from: l */
    public static int m5280l(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i >= 0) {
            if (i2 < i) {
                throw new IndexOutOfBoundsException(C1643a.m853h(66, "Beginning index larger than ending index: ", i, ", ", i2));
            }
            throw new IndexOutOfBoundsException(C1643a.m853h(37, "End index: ", i2, " >= ", i3));
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append("Beginning index: ");
        sb.append(i);
        sb.append(" < 0");
        throw new IndexOutOfBoundsException(sb.toString());
    }

    /* JADX INFO: renamed from: c */
    public abstract byte mo5281c(int i);

    /* JADX INFO: renamed from: d */
    public abstract int mo5282d();

    /* JADX INFO: renamed from: e */
    public abstract int mo5283e(int i, int i2, int i3);

    public abstract boolean equals(Object obj);

    /* JADX INFO: renamed from: g */
    public abstract AbstractC3837t3 mo5284g(int i, int i2);

    public final int hashCode() {
        int iMo5283e = this.zzc;
        if (iMo5283e == 0) {
            int iMo5282d = mo5282d();
            iMo5283e = mo5283e(iMo5282d, 0, iMo5282d);
            if (iMo5283e == 0) {
                iMo5283e = 1;
            }
            this.zzc = iMo5283e;
        }
        return iMo5283e;
    }

    /* JADX INFO: renamed from: i */
    public abstract String mo5285i(Charset charset);

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new C3863v3(this);
    }

    /* JADX INFO: renamed from: j */
    public abstract void mo5286j(AbstractC3850u3 abstractC3850u3) throws IOException;

    /* JADX INFO: renamed from: k */
    public abstract byte mo5287k(int i);

    /* JADX INFO: renamed from: m */
    public abstract boolean mo5288m();

    /* JADX INFO: renamed from: n */
    public final int m5289n() {
        return this.zzc;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(mo5282d());
        objArr[2] = mo5282d() <= 50 ? C3404f.m4257W1(this) : String.valueOf(C3404f.m4257W1(mo5284g(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }
}
