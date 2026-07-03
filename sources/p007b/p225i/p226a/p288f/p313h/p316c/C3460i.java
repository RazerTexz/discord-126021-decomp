package p007b.p225i.p226a.p288f.p313h.p316c;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p688authapi.zzz;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;

/* JADX INFO: renamed from: b.i.a.f.h.c.i */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3460i extends AbstractC3464m<Status> {

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Credential f9640l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3460i(AbstractC3268c abstractC3268c, Credential credential) {
        super(abstractC3268c);
        this.f9640l = credential;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* JADX INFO: renamed from: d */
    public final /* synthetic */ InterfaceC3273h mo3987d(Status status) {
        return status;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p316c.AbstractC3464m
    /* JADX INFO: renamed from: m */
    public final void mo4400m(Context context, InterfaceC3471t interfaceC3471t) throws RemoteException {
        interfaceC3471t.mo4405x(new BinderC3465n(this), new zzz(this.f9640l));
    }
}
