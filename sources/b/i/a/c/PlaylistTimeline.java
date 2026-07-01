package b.i.a.c;

import b.i.a.c.a3.ShuffleOrder;
import java.util.Collection;
import java.util.HashMap;

/* JADX INFO: renamed from: b.i.a.c.c2, reason: use source file name */
/* JADX INFO: compiled from: PlaylistTimeline.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PlaylistTimeline extends AbstractConcatenatedTimeline {
    public final int n;
    public final int o;
    public final int[] p;
    public final int[] q;
    public final Timeline[] r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Object[] f895s;
    public final HashMap<Object, Integer> t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaylistTimeline(Collection<? extends MediaSourceInfoHolder> collection, ShuffleOrder shuffleOrder) {
        super(false, shuffleOrder);
        int iP = 0;
        int size = collection.size();
        this.p = new int[size];
        this.q = new int[size];
        this.r = new Timeline[size];
        this.f895s = new Object[size];
        this.t = new HashMap<>();
        int i = 0;
        int i2 = 0;
        for (MediaSourceInfoHolder mediaSourceInfoHolder : collection) {
            this.r[i2] = mediaSourceInfoHolder.a();
            this.q[i2] = iP;
            this.p[i2] = i;
            iP += this.r[i2].p();
            i += this.r[i2].i();
            this.f895s[i2] = mediaSourceInfoHolder.getUid();
            this.t.put(this.f895s[i2], Integer.valueOf(i2));
            i2++;
        }
        this.n = iP;
        this.o = i;
    }

    @Override // b.i.a.c.Timeline
    public int i() {
        return this.o;
    }

    @Override // b.i.a.c.Timeline
    public int p() {
        return this.n;
    }
}
