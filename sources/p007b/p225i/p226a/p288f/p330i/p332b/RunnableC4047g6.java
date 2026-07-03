package p007b.p225i.p226a.p288f.p330i.p332b;

/* JADX INFO: renamed from: b.i.a.f.i.b.g6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4047g6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ boolean f10753j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C3999c6 f10754k;

    public RunnableC4047g6(C3999c6 c3999c6, boolean z2) {
        this.f10754k = c3999c6;
        this.f10753j = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zM5940d = this.f10754k.f11202a.m5940d();
        boolean zM5938B = this.f10754k.f11202a.m5938B();
        this.f10754k.f11202a.f11247B = Boolean.valueOf(this.f10753j);
        if (zM5938B == this.f10753j) {
            this.f10754k.f11202a.mo5726g().f11149n.m5861b("Default data collection state already set to", Boolean.valueOf(this.f10753j));
        }
        if (this.f10754k.f11202a.m5940d() == zM5940d || this.f10754k.f11202a.m5940d() != this.f10754k.f11202a.m5938B()) {
            this.f10754k.f11202a.mo5726g().f11146k.m5862c("Default data collection is different than actual status", Boolean.valueOf(this.f10753j), Boolean.valueOf(zM5940d));
        }
        this.f10754k.m5553P();
    }
}
