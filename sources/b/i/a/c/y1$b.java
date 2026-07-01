package b.i.a.c;

import androidx.annotation.Nullable;
import b.i.a.c.f3.n$b;

/* JADX INFO: compiled from: Player.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y1$b implements w0 {
    public static final y1$b j = new y1$b(new n$b().b(), null);
    public final b.i.a.c.f3.n k;

    public y1$b(b.i.a.c.f3.n nVar, y1$a y1_a) {
        this.k = nVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y1$b) {
            return this.k.equals(((y1$b) obj).k);
        }
        return false;
    }

    public int hashCode() {
        return this.k.hashCode();
    }
}
