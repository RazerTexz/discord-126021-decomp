package b.i.a.c.b3.o;

import b.i.a.c.b3.Cue;
import b.i.a.c.b3.Subtitle;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.b3.o.c, reason: use source file name */
/* JADX INFO: compiled from: DvbSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DvbSubtitle implements Subtitle {
    public final List<Cue> j;

    public DvbSubtitle(List<Cue> list) {
        this.j = list;
    }

    @Override // b.i.a.c.b3.Subtitle
    public int f(long j) {
        return -1;
    }

    @Override // b.i.a.c.b3.Subtitle
    public long g(int i) {
        return 0L;
    }

    @Override // b.i.a.c.b3.Subtitle
    public List<Cue> h(long j) {
        return this.j;
    }

    @Override // b.i.a.c.b3.Subtitle
    public int i() {
        return 1;
    }
}
