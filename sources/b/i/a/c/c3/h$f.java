package b.i.a.c.c3;

import androidx.annotation.Nullable;
import b.i.a.c.w0;
import java.util.Arrays;

/* JADX INFO: compiled from: DefaultTrackSelector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h$f implements w0 {
    public final int j;
    public final int[] k;
    public final int l;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h$f.class != obj.getClass()) {
            return false;
        }
        h$f h_f = (h$f) obj;
        return this.j == h_f.j && Arrays.equals(this.k, h_f.k) && this.l == h_f.l;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.k) + (this.j * 31)) * 31) + this.l;
    }
}
