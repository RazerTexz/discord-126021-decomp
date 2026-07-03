package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.c.j2 */
/* JADX INFO: compiled from: SeekParameters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2812j2 {

    /* JADX INFO: renamed from: a */
    public static final C2812j2 f7189a;

    /* JADX INFO: renamed from: b */
    public static final C2812j2 f7190b;

    /* JADX INFO: renamed from: c */
    public final long f7191c;

    /* JADX INFO: renamed from: d */
    public final long f7192d;

    static {
        C2812j2 c2812j2 = new C2812j2(0L, 0L);
        f7189a = c2812j2;
        C1460d.m531j(RecyclerView.FOREVER_NS >= 0);
        C1460d.m531j(RecyclerView.FOREVER_NS >= 0);
        C1460d.m531j(RecyclerView.FOREVER_NS >= 0);
        C1460d.m531j(0 >= 0);
        C1460d.m531j(0 >= 0);
        C1460d.m531j(RecyclerView.FOREVER_NS >= 0);
        f7190b = c2812j2;
    }

    public C2812j2(long j, long j2) {
        C1460d.m531j(j >= 0);
        C1460d.m531j(j2 >= 0);
        this.f7191c = j;
        this.f7192d = j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2812j2.class != obj.getClass()) {
            return false;
        }
        C2812j2 c2812j2 = (C2812j2) obj;
        return this.f7191c == c2812j2.f7191c && this.f7192d == c2812j2.f7192d;
    }

    public int hashCode() {
        return (((int) this.f7191c) * 31) + ((int) this.f7192d);
    }
}
