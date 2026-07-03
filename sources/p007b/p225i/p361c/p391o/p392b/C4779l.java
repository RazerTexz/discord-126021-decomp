package p007b.p225i.p361c.p391o.p392b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p313h.p321h.BinderC3485a;
import p007b.p225i.p226a.p288f.p313h.p321h.C3486b;

/* JADX INFO: renamed from: b.i.c.o.b.l */
/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4779l implements InterfaceC4777j, IInterface {

    /* JADX INFO: renamed from: a */
    public final IBinder f12815a;

    /* JADX INFO: renamed from: b */
    public final String f12816b = "com.google.firebase.dynamiclinks.internal.IDynamicLinksService";

    public C4779l(IBinder iBinder) {
        this.f12815a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f12815a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p225i.p361c.p391o.p392b.InterfaceC4777j
    /* JADX INFO: renamed from: b0 */
    public final void mo6704b0(InterfaceC4775h interfaceC4775h, String str) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f12816b);
        int i = C3486b.f9651a;
        parcelObtain.writeStrongBinder((BinderC3485a) interfaceC4775h);
        parcelObtain.writeString(str);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.f12815a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
