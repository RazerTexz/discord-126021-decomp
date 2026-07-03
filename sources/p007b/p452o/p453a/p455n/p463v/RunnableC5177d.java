package p007b.p452o.p453a.p455n.p463v;

import com.google.android.gms.tasks.Task;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;

/* JADX INFO: renamed from: b.o.a.n.v.d */
/* JADX INFO: compiled from: CameraOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC5177d implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC4357c f14021j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Task f14022k;

    public RunnableC5177d(InterfaceC4357c interfaceC4357c, Task task) {
        this.f14021j = interfaceC4357c;
        this.f14022k = task;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14021j.onComplete(this.f14022k);
    }
}
