package p007b.p225i.p226a.p341g.p345d;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.g.d.d */
/* JADX INFO: compiled from: DateFormatTextWatcher.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC4393d implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ long f11600j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ AbstractC4392c f11601k;

    public RunnableC4393d(AbstractC4392c abstractC4392c, long j) {
        this.f11601k = abstractC4392c;
        this.f11600j = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        AbstractC4392c abstractC4392c = this.f11601k;
        abstractC4392c.f11592j.setError(String.format(abstractC4392c.f11595m, C3404f.m4292g0(this.f11600j)));
        this.f11601k.mo6060a();
    }
}
