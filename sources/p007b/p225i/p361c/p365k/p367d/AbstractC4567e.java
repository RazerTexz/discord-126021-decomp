package p007b.p225i.p361c.p365k.p367d;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3311p;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3287e;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p313h.p324k.BinderC3563h;
import p007b.p225i.p226a.p288f.p313h.p324k.C3562g;
import p007b.p225i.p226a.p288f.p313h.p324k.InterfaceC3557b;

/* JADX INFO: renamed from: b.i.c.k.d.e */
/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4567e extends AbstractC3311p<C3562g, Void> implements InterfaceC3287e<Status> {

    /* JADX INFO: renamed from: c */
    public TaskCompletionSource<Void> f12172c;

    public AbstractC4567e(C4566d c4566d) {
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3287e
    /* JADX INFO: renamed from: a */
    public void mo4067a(Status status) {
        C1460d.m551o(!status.m9030w0(), "Failed result must not be success.");
        this.f12172c.f20845a.m6025t(C3404f.m4242R1(status, status.f20496q));
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3287e
    /* JADX INFO: renamed from: b */
    public void mo3989b(Object obj) {
        Status status = (Status) obj;
        if (status.m9030w0()) {
            this.f12172c.f20845a.m6024s(null);
            return;
        }
        TaskCompletionSource<Void> taskCompletionSource = this.f12172c;
        taskCompletionSource.f20845a.m6025t(C3404f.m4242R1(status, "User Action indexing error, please try again."));
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3311p
    /* JADX INFO: renamed from: c */
    public void mo4109c(C3266a.b bVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        this.f12172c = taskCompletionSource;
        C4566d c4566d = (C4566d) this;
        ((InterfaceC3557b) ((C3562g) bVar).m4142w()).mo4516S(new BinderC3563h(c4566d), c4566d.f12171d);
    }
}
