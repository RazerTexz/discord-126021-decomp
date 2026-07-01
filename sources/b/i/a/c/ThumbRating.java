package b.i.a.c;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.n2, reason: use source file name */
/* JADX INFO: compiled from: ThumbRating.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ThumbRating extends Rating {
    public final boolean k;
    public final boolean l;

    public ThumbRating() {
        this.k = false;
        this.l = false;
    }

    public static String a(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ThumbRating)) {
            return false;
        }
        ThumbRating thumbRating = (ThumbRating) obj;
        return this.l == thumbRating.l && this.k == thumbRating.k;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.k), Boolean.valueOf(this.l)});
    }

    public ThumbRating(boolean z2) {
        this.k = true;
        this.l = z2;
    }
}
