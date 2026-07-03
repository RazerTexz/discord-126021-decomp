package p007b.p452o.p453a.p455n;

import p007b.p452o.p453a.p473x.C5236b;

/* JADX INFO: renamed from: b.o.a.n.h */
/* JADX INFO: compiled from: CameraBaseEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC5134h implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AbstractC5133g f13917j;

    public RunnableC5134h(AbstractC5133g abstractC5133g) {
        this.f13917j = abstractC5133g;
    }

    @Override // java.lang.Runnable
    public void run() {
        C5236b c5236bM7272R0 = this.f13917j.m7272R0();
        if (c5236bM7272R0.equals(this.f13917j.f13899s)) {
            AbstractC5135i.f13918j.m7159a(1, "onSurfaceChanged:", "The computed preview size is identical. No op.");
            return;
        }
        AbstractC5135i.f13918j.m7159a(1, "onSurfaceChanged:", "Computed a new preview size. Calling onPreviewStreamSizeChanged().");
        AbstractC5133g abstractC5133g = this.f13917j;
        abstractC5133g.f13899s = c5236bM7272R0;
        abstractC5133g.mo7201X0();
    }
}
