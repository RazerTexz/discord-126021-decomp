package p007b.p225i.p226a.p288f.p313h.p316c;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.common.api.Status;
import p007b.p225i.p226a.p288f.p292c.p293a.p294d.InterfaceC3187b;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;

/* JADX INFO: renamed from: b.i.a.f.h.c.g */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3458g extends AbstractC3464m<InterfaceC3187b> {

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ CredentialRequest f9639l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3458g(AbstractC3268c abstractC3268c, CredentialRequest credentialRequest) {
        super(abstractC3268c);
        this.f9639l = credentialRequest;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* JADX INFO: renamed from: d */
    public final InterfaceC3273h mo3987d(Status status) {
        return new C3456e(status, null);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p316c.AbstractC3464m
    /* JADX INFO: renamed from: m */
    public final void mo4400m(Context context, InterfaceC3471t interfaceC3471t) throws RemoteException {
        interfaceC3471t.mo4404t(new BinderC3461j(this), this.f9639l);
    }
}
