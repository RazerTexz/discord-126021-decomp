package b.i.a.c;

import android.util.Pair;
import b.i.a.c.Timeline;
import b.i.a.c.a3.ShuffleOrder;
import b.i.a.c.f3.Util2;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.r0, reason: use source file name */
/* JADX INFO: compiled from: AbstractConcatenatedTimeline.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractConcatenatedTimeline extends Timeline {
    public final int k;
    public final ShuffleOrder l;
    public final boolean m;

    public AbstractConcatenatedTimeline(boolean z2, ShuffleOrder shuffleOrder) {
        this.m = z2;
        this.l = shuffleOrder;
        this.k = shuffleOrder.b();
    }

    @Override // b.i.a.c.Timeline
    public int a(boolean z2) {
        if (this.k == 0) {
            return -1;
        }
        if (this.m) {
            z2 = false;
        }
        int iC = z2 ? this.l.c() : 0;
        do {
            PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
            if (!playlistTimeline.r[iC].q()) {
                return playlistTimeline.r[iC].a(z2) + playlistTimeline.q[iC];
            }
            iC = r(iC, z2);
        } while (iC != -1);
        return -1;
    }

    @Override // b.i.a.c.Timeline
    public final int b(Object obj) {
        int iB;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
        Integer num = playlistTimeline.t.get(obj2);
        int iIntValue = num == null ? -1 : num.intValue();
        if (iIntValue == -1 || (iB = playlistTimeline.r[iIntValue].b(obj3)) == -1) {
            return -1;
        }
        return playlistTimeline.p[iIntValue] + iB;
    }

    @Override // b.i.a.c.Timeline
    public int c(boolean z2) {
        int i = this.k;
        if (i == 0) {
            return -1;
        }
        if (this.m) {
            z2 = false;
        }
        int iG = z2 ? this.l.g() : i - 1;
        do {
            PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
            if (!playlistTimeline.r[iG].q()) {
                return playlistTimeline.r[iG].c(z2) + playlistTimeline.q[iG];
            }
            iG = s(iG, z2);
        } while (iG != -1);
        return -1;
    }

    @Override // b.i.a.c.Timeline
    public int e(int i, int i2, boolean z2) {
        if (this.m) {
            if (i2 == 1) {
                i2 = 2;
            }
            z2 = false;
        }
        PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
        int iD = Util2.d(playlistTimeline.q, i + 1, false, false);
        int i3 = playlistTimeline.q[iD];
        int iE = playlistTimeline.r[iD].e(i - i3, i2 != 2 ? i2 : 0, z2);
        if (iE != -1) {
            return i3 + iE;
        }
        int iR = r(iD, z2);
        while (iR != -1 && playlistTimeline.r[iR].q()) {
            iR = r(iR, z2);
        }
        if (iR != -1) {
            return playlistTimeline.r[iR].a(z2) + playlistTimeline.q[iR];
        }
        if (i2 == 2) {
            return a(z2);
        }
        return -1;
    }

    @Override // b.i.a.c.Timeline
    public final Timeline.b g(int i, Timeline.b bVar, boolean z2) {
        PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
        int iD = Util2.d(playlistTimeline.p, i + 1, false, false);
        int i2 = playlistTimeline.q[iD];
        playlistTimeline.r[iD].g(i - playlistTimeline.p[iD], bVar, z2);
        bVar.l += i2;
        if (z2) {
            Object obj = playlistTimeline.f895s[iD];
            Object obj2 = bVar.k;
            Objects.requireNonNull(obj2);
            bVar.k = Pair.create(obj, obj2);
        }
        return bVar;
    }

    @Override // b.i.a.c.Timeline
    public final Timeline.b h(Object obj, Timeline.b bVar) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
        Integer num = playlistTimeline.t.get(obj2);
        int iIntValue = num == null ? -1 : num.intValue();
        int i = playlistTimeline.q[iIntValue];
        playlistTimeline.r[iIntValue].h(obj3, bVar);
        bVar.l += i;
        bVar.k = obj;
        return bVar;
    }

    @Override // b.i.a.c.Timeline
    public int l(int i, int i2, boolean z2) {
        if (this.m) {
            if (i2 == 1) {
                i2 = 2;
            }
            z2 = false;
        }
        PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
        int iD = Util2.d(playlistTimeline.q, i + 1, false, false);
        int i3 = playlistTimeline.q[iD];
        int iL = playlistTimeline.r[iD].l(i - i3, i2 != 2 ? i2 : 0, z2);
        if (iL != -1) {
            return i3 + iL;
        }
        int iS = s(iD, z2);
        while (iS != -1 && playlistTimeline.r[iS].q()) {
            iS = s(iS, z2);
        }
        if (iS != -1) {
            return playlistTimeline.r[iS].c(z2) + playlistTimeline.q[iS];
        }
        if (i2 == 2) {
            return c(z2);
        }
        return -1;
    }

    @Override // b.i.a.c.Timeline
    public final Object m(int i) {
        PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
        int iD = Util2.d(playlistTimeline.p, i + 1, false, false);
        return Pair.create(playlistTimeline.f895s[iD], playlistTimeline.r[iD].m(i - playlistTimeline.p[iD]));
    }

    @Override // b.i.a.c.Timeline
    public final Timeline.c o(int i, Timeline.c cVar, long j) {
        PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
        int iD = Util2.d(playlistTimeline.q, i + 1, false, false);
        int i2 = playlistTimeline.q[iD];
        int i3 = playlistTimeline.p[iD];
        playlistTimeline.r[iD].o(i - i2, cVar, j);
        Object objCreate = playlistTimeline.f895s[iD];
        if (!Timeline.c.j.equals(cVar.n)) {
            objCreate = Pair.create(objCreate, cVar.n);
        }
        cVar.n = objCreate;
        cVar.B += i3;
        cVar.C += i3;
        return cVar;
    }

    public final int r(int i, boolean z2) {
        if (z2) {
            return this.l.e(i);
        }
        if (i < this.k - 1) {
            return i + 1;
        }
        return -1;
    }

    public final int s(int i, boolean z2) {
        if (z2) {
            return this.l.d(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }
}
