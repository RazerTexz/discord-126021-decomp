package b.i.a.c.b3.n;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.Subtitle;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.b3.n.f, reason: use source file name */
/* JADX INFO: compiled from: CeaSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CeaSubtitle implements Subtitle {
    public final List<Cue> j;

    public CeaSubtitle(List<Cue> list) {
        this.j = list;
    }

    @Override // b.i.a.c.b3.Subtitle
    public int f(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // b.i.a.c.b3.Subtitle
    public long g(int i) {
        AnimatableValueParser.j(i == 0);
        return 0L;
    }

    @Override // b.i.a.c.b3.Subtitle
    public List<Cue> h(long j) {
        return j >= 0 ? this.j : Collections.emptyList();
    }

    @Override // b.i.a.c.b3.Subtitle
    public int i() {
        return 1;
    }
}
