package p007b.p225i.p226a.p288f.p313h.p316c;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;

/* JADX INFO: renamed from: b.i.a.f.h.c.k */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3462k extends AbstractC3464m<Status> {
    public C3462k(AbstractC3268c abstractC3268c) {
        super(abstractC3268c);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* JADX INFO: renamed from: d */
    public final /* synthetic */ InterfaceC3273h mo3987d(Status status) {
        return status;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p316c.AbstractC3464m
    /* JADX INFO: renamed from: m */
    public final void mo4400m(Context context, InterfaceC3471t interfaceC3471t) throws RemoteException {
        interfaceC3471t.mo4403M(new BinderC3465n(this));
    }
}
