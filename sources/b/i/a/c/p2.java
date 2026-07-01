package b.i.a.c;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: TracksInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p2 implements w0 {
    public static final p2 j;
    public final b.i.b.b.p<p2$a> k;

    static {
        b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
        j = new p2(b.i.b.b.h0.l);
    }

    public p2(List<p2$a> list) {
        this.k = b.i.b.b.p.n(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p2.class != obj.getClass()) {
            return false;
        }
        return this.k.equals(((p2) obj).k);
    }

    public int hashCode() {
        return this.k.hashCode();
    }
}
