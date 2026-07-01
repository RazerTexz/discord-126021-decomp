package b.i.a.c;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.l1, reason: use source file name */
/* JADX INFO: compiled from: HeartRating.java */
/* JADX INFO: loaded from: classes3.dex */
public final class HeartRating extends Rating {
    public final boolean k;
    public final boolean l;

    public HeartRating() {
        this.k = false;
        this.l = false;
    }

    public static String a(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof HeartRating)) {
            return false;
        }
        HeartRating heartRating = (HeartRating) obj;
        return this.l == heartRating.l && this.k == heartRating.k;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.k), Boolean.valueOf(this.l)});
    }

    public HeartRating(boolean z2) {
        this.k = true;
        this.l = z2;
    }
}
