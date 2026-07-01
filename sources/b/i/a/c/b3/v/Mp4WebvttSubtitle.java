package b.i.a.c.b3.v;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.Subtitle;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.b3.v.d, reason: use source file name */
/* JADX INFO: compiled from: Mp4WebvttSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Mp4WebvttSubtitle implements Subtitle {
    public final List<Cue> j;

    public Mp4WebvttSubtitle(List<Cue> list) {
        this.j = Collections.unmodifiableList(list);
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
