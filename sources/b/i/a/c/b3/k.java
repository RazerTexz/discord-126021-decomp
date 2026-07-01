package b.i.a.c.b3;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: SubtitleOutputBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends b.i.a.c.v2.f implements g {

    @Nullable
    public g l;
    public long m;

    @Override // b.i.a.c.b3.g
    public int f(long j) {
        g gVar = this.l;
        Objects.requireNonNull(gVar);
        return gVar.f(j - this.m);
    }

    @Override // b.i.a.c.b3.g
    public long g(int i) {
        g gVar = this.l;
        Objects.requireNonNull(gVar);
        return gVar.g(i) + this.m;
    }

    @Override // b.i.a.c.b3.g
    public List<b> h(long j) {
        g gVar = this.l;
        Objects.requireNonNull(gVar);
        return gVar.h(j - this.m);
    }

    @Override // b.i.a.c.b3.g
    public int i() {
        g gVar = this.l;
        Objects.requireNonNull(gVar);
        return gVar.i();
    }

    public void q() {
        this.j = 0;
        this.l = null;
    }

    public void r(long j, g gVar, long j2) {
        this.k = j;
        this.l = gVar;
        if (j2 != RecyclerView.FOREVER_NS) {
            j = j2;
        }
        this.m = j;
    }
}
