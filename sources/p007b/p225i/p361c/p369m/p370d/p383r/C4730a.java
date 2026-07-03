package p007b.p225i.p361c.p369m.p370d.p383r;

import com.google.android.gms.tasks.TaskCompletionSource;
import p007b.p225i.p226a.p228b.InterfaceC2413h;
import p007b.p225i.p361c.p369m.p370d.p373k.AbstractC4646o0;
import p007b.p225i.p361c.p369m.p370d.p375m.p376x.C4704h;

/* JADX INFO: renamed from: b.i.c.m.d.r.a */
/* JADX INFO: compiled from: DataTransportCrashlyticsReportSender.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4730a implements InterfaceC2413h {

    /* JADX INFO: renamed from: a */
    public final TaskCompletionSource f12720a;

    /* JADX INFO: renamed from: b */
    public final AbstractC4646o0 f12721b;

    public C4730a(TaskCompletionSource taskCompletionSource, AbstractC4646o0 abstractC4646o0) {
        this.f12720a = taskCompletionSource;
        this.f12721b = abstractC4646o0;
    }

    @Override // p007b.p225i.p226a.p228b.InterfaceC2413h
    /* JADX INFO: renamed from: a */
    public void mo2292a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f12720a;
        AbstractC4646o0 abstractC4646o0 = this.f12721b;
        C4704h c4704h = C4732c.f12723a;
        if (exc != null) {
            taskCompletionSource.m9125a(exc);
        } else {
            taskCompletionSource.m9126b(abstractC4646o0);
        }
    }
}
