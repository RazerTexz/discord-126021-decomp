package b.i.a.c.c3;

import androidx.annotation.Nullable;
import b.i.a.c.a3.n0;
import b.i.a.c.w0;
import b.i.a.c.w0$a;
import b.i.b.b.i0;
import java.util.Map;

/* JADX INFO: compiled from: TrackSelectionOverrides.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements w0 {
    public static final o j = new o(i0.m);
    public static final w0$a<o> k = d.a;
    public final b.i.b.b.q<n0, o$a> l;

    public o(Map<n0, o$a> map) {
        this.l = b.i.b.b.q.a(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        return this.l.equals(((o) obj).l);
    }

    public int hashCode() {
        return this.l.hashCode();
    }
}
