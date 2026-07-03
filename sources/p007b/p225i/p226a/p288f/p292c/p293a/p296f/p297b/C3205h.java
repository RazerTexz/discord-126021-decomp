package p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.b.h */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3205h extends AbstractC3208k<Status> {
    public C3205h(AbstractC3268c abstractC3268c) {
        super(abstractC3268c);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* JADX INFO: renamed from: d */
    public final /* synthetic */ InterfaceC3273h mo3987d(Status status) {
        return status;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3284d
    /* JADX INFO: renamed from: k */
    public final void mo3988k(C3266a.b bVar) throws RemoteException {
        C3203f c3203f = (C3203f) bVar;
        ((InterfaceC3212o) c3203f.m4142w()).mo3993k0(new BinderC3207j(this), c3203f.f9234A);
    }
}
