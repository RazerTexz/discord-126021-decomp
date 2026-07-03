package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.n2 */
/* JADX INFO: compiled from: ThumbRating.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2828n2 extends AbstractC2656d2 {

    /* JADX INFO: renamed from: k */
    public final boolean f7257k;

    /* JADX INFO: renamed from: l */
    public final boolean f7258l;

    public C2828n2() {
        this.f7257k = false;
        this.f7258l = false;
    }

    /* JADX INFO: renamed from: a */
    public static String m3318a(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof C2828n2)) {
            return false;
        }
        C2828n2 c2828n2 = (C2828n2) obj;
        return this.f7258l == c2828n2.f7258l && this.f7257k == c2828n2.f7257k;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f7257k), Boolean.valueOf(this.f7258l)});
    }

    public C2828n2(boolean z2) {
        this.f7257k = true;
        this.f7258l = z2;
    }
}
