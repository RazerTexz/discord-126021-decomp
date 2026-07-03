package p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import p007b.p225i.p226a.p288f.p313h.p316c.C3454c;
import p007b.p225i.p226a.p288f.p313h.p316c.C3455d;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.b.r */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3215r extends C3454c implements InterfaceC3212o {
    public C3215r(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b.InterfaceC3212o
    /* JADX INFO: renamed from: a0 */
    public final void mo3992a0(InterfaceC3211n interfaceC3211n, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelM4394c = m4394c();
        C3455d.m4397b(parcelM4394c, interfaceC3211n);
        C3455d.m4398c(parcelM4394c, googleSignInOptions);
        m4395g(103, parcelM4394c);
    }

    @Override // p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b.InterfaceC3212o
    /* JADX INFO: renamed from: k0 */
    public final void mo3993k0(InterfaceC3211n interfaceC3211n, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelM4394c = m4394c();
        C3455d.m4397b(parcelM4394c, interfaceC3211n);
        C3455d.m4398c(parcelM4394c, googleSignInOptions);
        m4395g(102, parcelM4394c);
    }
}
