package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.l1 */
/* JADX INFO: compiled from: HeartRating.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2819l1 extends AbstractC2656d2 {

    /* JADX INFO: renamed from: k */
    public final boolean f7238k;

    /* JADX INFO: renamed from: l */
    public final boolean f7239l;

    public C2819l1() {
        this.f7238k = false;
        this.f7239l = false;
    }

    /* JADX INFO: renamed from: a */
    public static String m3303a(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof C2819l1)) {
            return false;
        }
        C2819l1 c2819l1 = (C2819l1) obj;
        return this.f7239l == c2819l1.f7239l && this.f7238k == c2819l1.f7238k;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f7238k), Boolean.valueOf(this.f7239l)});
    }

    public C2819l1(boolean z2) {
        this.f7238k = true;
        this.f7239l = z2;
    }
}
