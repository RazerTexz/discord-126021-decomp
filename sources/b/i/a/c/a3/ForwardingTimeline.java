package b.i.a.c.a3;

import b.i.a.c.Timeline;

/* JADX INFO: renamed from: b.i.a.c.a3.r, reason: use source file name */
/* JADX INFO: compiled from: ForwardingTimeline.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ForwardingTimeline extends Timeline {
    public final Timeline k;

    public ForwardingTimeline(Timeline timeline) {
        this.k = timeline;
    }

    @Override // b.i.a.c.Timeline
    public int a(boolean z2) {
        return this.k.a(z2);
    }

    @Override // b.i.a.c.Timeline
    public int b(Object obj) {
        return this.k.b(obj);
    }

    @Override // b.i.a.c.Timeline
    public int c(boolean z2) {
        return this.k.c(z2);
    }

    @Override // b.i.a.c.Timeline
    public int e(int i, int i2, boolean z2) {
        return this.k.e(i, i2, z2);
    }

    @Override // b.i.a.c.Timeline
    public int i() {
        return this.k.i();
    }

    @Override // b.i.a.c.Timeline
    public int l(int i, int i2, boolean z2) {
        return this.k.l(i, i2, z2);
    }

    @Override // b.i.a.c.Timeline
    public Object m(int i) {
        return this.k.m(i);
    }

    @Override // b.i.a.c.Timeline
    public int p() {
        return this.k.p();
    }
}
