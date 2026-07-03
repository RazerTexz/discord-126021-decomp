package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3287e;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.t */
/* JADX INFO: loaded from: classes3.dex */
public final class C4308t implements InterfaceC3287e<Status> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ TaskCompletionSource f11433a;

    public C4308t(TaskCompletionSource taskCompletionSource) {
        this.f11433a = taskCompletionSource;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3287e
    /* JADX INFO: renamed from: a */
    public final void mo4067a(Status status) {
        TaskCompletionSource taskCompletionSource = this.f11433a;
        taskCompletionSource.f20845a.m6025t(new ApiException(status));
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3287e
    /* JADX INFO: renamed from: b */
    public final void mo3989b(Object obj) {
        this.f11433a.f20845a.m6024s(null);
    }
}
