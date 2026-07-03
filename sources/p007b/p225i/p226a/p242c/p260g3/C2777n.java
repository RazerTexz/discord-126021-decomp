package p007b.p225i.p226a.p242c.p260g3;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;
import p007b.p225i.p226a.p242c.InterfaceC2963w0;

/* JADX INFO: renamed from: b.i.a.c.g3.n */
/* JADX INFO: compiled from: ColorInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2777n implements InterfaceC2963w0 {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f6843j = 0;

    /* JADX INFO: renamed from: k */
    public final int f6844k;

    /* JADX INFO: renamed from: l */
    public final int f6845l;

    /* JADX INFO: renamed from: m */
    public final int f6846m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public final byte[] f6847n;

    /* JADX INFO: renamed from: o */
    public int f6848o;

    public C2777n(int i, int i2, int i3, @Nullable byte[] bArr) {
        this.f6844k = i;
        this.f6845l = i2;
        this.f6846m = i3;
        this.f6847n = bArr;
    }

    @Pure
    /* JADX INFO: renamed from: a */
    public static int m3123a(int i) {
        if (i == 1) {
            return 1;
        }
        if (i != 9) {
            return (i == 4 || i == 5 || i == 6 || i == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    /* JADX INFO: renamed from: b */
    public static int m3124b(int i) {
        if (i == 1) {
            return 3;
        }
        if (i == 16) {
            return 6;
        }
        if (i != 18) {
            return (i == 6 || i == 7) ? 3 : -1;
        }
        return 7;
    }

    /* JADX INFO: renamed from: c */
    public static String m3125c(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2777n.class != obj.getClass()) {
            return false;
        }
        C2777n c2777n = (C2777n) obj;
        return this.f6844k == c2777n.f6844k && this.f6845l == c2777n.f6845l && this.f6846m == c2777n.f6846m && Arrays.equals(this.f6847n, c2777n.f6847n);
    }

    public int hashCode() {
        if (this.f6848o == 0) {
            this.f6848o = Arrays.hashCode(this.f6847n) + ((((((527 + this.f6844k) * 31) + this.f6845l) * 31) + this.f6846m) * 31);
        }
        return this.f6848o;
    }

    public String toString() {
        int i = this.f6844k;
        int i2 = this.f6845l;
        int i3 = this.f6846m;
        boolean z2 = this.f6847n != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(z2);
        sb.append(")");
        return sb.toString();
    }
}
