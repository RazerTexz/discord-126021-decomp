package b.i.a.c.b3.u;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.Subtitle;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.b3.u.b, reason: use source file name */
/* JADX INFO: compiled from: Tx3gSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Tx3gSubtitle implements Subtitle {
    public static final Tx3gSubtitle j = new Tx3gSubtitle();
    public final List<Cue> k;

    public Tx3gSubtitle(Cue cue) {
        this.k = Collections.singletonList(cue);
    }

    @Override // b.i.a.c.b3.Subtitle
    public int f(long j2) {
        return j2 < 0 ? 0 : -1;
    }

    @Override // b.i.a.c.b3.Subtitle
    public long g(int i) {
        AnimatableValueParser.j(i == 0);
        return 0L;
    }

    @Override // b.i.a.c.b3.Subtitle
    public List<Cue> h(long j2) {
        return j2 >= 0 ? this.k : Collections.emptyList();
    }

    @Override // b.i.a.c.b3.Subtitle
    public int i() {
        return 1;
    }

    public Tx3gSubtitle() {
        this.k = Collections.emptyList();
    }
}
