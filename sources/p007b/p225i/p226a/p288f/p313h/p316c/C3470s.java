package p007b.p225i.p226a.p288f.p313h.p316c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.internal.p688authapi.zzt;
import com.google.android.gms.internal.p688authapi.zzz;

/* JADX INFO: renamed from: b.i.a.f.h.c.s */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3470s extends C3454c implements InterfaceC3471t {
    public C3470s(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p316c.InterfaceC3471t
    /* JADX INFO: renamed from: L */
    public final void mo4402L(InterfaceC3469r interfaceC3469r, zzt zztVar) throws RemoteException {
        Parcel parcelM4394c = m4394c();
        C3455d.m4397b(parcelM4394c, interfaceC3469r);
        C3455d.m4398c(parcelM4394c, zztVar);
        m4395g(3, parcelM4394c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p316c.InterfaceC3471t
    /* JADX INFO: renamed from: M */
    public final void mo4403M(InterfaceC3469r interfaceC3469r) throws RemoteException {
        Parcel parcelM4394c = m4394c();
        C3455d.m4397b(parcelM4394c, interfaceC3469r);
        m4395g(4, parcelM4394c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p316c.InterfaceC3471t
    /* JADX INFO: renamed from: t */
    public final void mo4404t(InterfaceC3469r interfaceC3469r, CredentialRequest credentialRequest) throws RemoteException {
        Parcel parcelM4394c = m4394c();
        C3455d.m4397b(parcelM4394c, interfaceC3469r);
        C3455d.m4398c(parcelM4394c, credentialRequest);
        m4395g(1, parcelM4394c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p316c.InterfaceC3471t
    /* JADX INFO: renamed from: x */
    public final void mo4405x(InterfaceC3469r interfaceC3469r, zzz zzzVar) throws RemoteException {
        Parcel parcelM4394c = m4394c();
        C3455d.m4397b(parcelM4394c, interfaceC3469r);
        C3455d.m4398c(parcelM4394c, zzzVar);
        m4395g(2, parcelM4394c);
    }
}
