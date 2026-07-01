package b.i.a.c.b3.s;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.Subtitle;
import b.i.a.c.f3.Util2;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.b3.s.b, reason: use source file name */
/* JADX INFO: compiled from: SubripSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SubripSubtitle implements Subtitle {
    public final Cue[] j;
    public final long[] k;

    public SubripSubtitle(Cue[] cueArr, long[] jArr) {
        this.j = cueArr;
        this.k = jArr;
    }

    @Override // b.i.a.c.b3.Subtitle
    public int f(long j) {
        int iB = Util2.b(this.k, j, false, false);
        if (iB < this.k.length) {
            return iB;
        }
        return -1;
    }

    @Override // b.i.a.c.b3.Subtitle
    public long g(int i) {
        AnimatableValueParser.j(i >= 0);
        AnimatableValueParser.j(i < this.k.length);
        return this.k[i];
    }

    @Override // b.i.a.c.b3.Subtitle
    public List<Cue> h(long j) {
        int iE = Util2.e(this.k, j, true, false);
        if (iE != -1) {
            Cue[] cueArr = this.j;
            if (cueArr[iE] != Cue.j) {
                return Collections.singletonList(cueArr[iE]);
            }
        }
        return Collections.emptyList();
    }

    @Override // b.i.a.c.b3.Subtitle
    public int i() {
        return this.k.length;
    }
}
