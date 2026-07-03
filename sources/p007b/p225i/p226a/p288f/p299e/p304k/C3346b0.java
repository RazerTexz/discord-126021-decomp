package p007b.p225i.p226a.p288f.p299e.p304k;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.GetServiceRequest;
import p007b.p225i.p226a.p288f.p313h.p320g.BinderC3482b;

/* JADX INFO: renamed from: b.i.a.f.e.k.b0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3346b0 implements InterfaceC3359i {

    /* JADX INFO: renamed from: a */
    public final IBinder f9500a;

    public C3346b0(IBinder iBinder) {
        this.f9500a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f9500a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3359i
    /* JADX INFO: renamed from: w */
    public final void mo4147w(InterfaceC3357h interfaceC3357h, @Nullable GetServiceRequest getServiceRequest) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder((BinderC3482b) interfaceC3357h);
            parcelObtain.writeInt(1);
            C3374p0.m4174a(getServiceRequest, parcelObtain, 0);
            this.f9500a.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
