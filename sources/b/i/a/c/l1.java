package b.i.a.c;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: HeartRating.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l1 extends d2 {
    public final boolean k;
    public final boolean l;

    public l1() {
        this.k = false;
        this.l = false;
    }

    public static String a(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof l1)) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return this.l == l1Var.l && this.k == l1Var.k;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.k), Boolean.valueOf(this.l)});
    }

    public l1(boolean z2) {
        this.k = true;
        this.l = z2;
    }
}
