package p007b.p449n.p450a.p451a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.n.a.a.b */
/* JADX INFO: compiled from: ISAService.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC5101b extends IInterface {

    /* JADX INFO: renamed from: b.n.a.a.b$a */
    /* JADX INFO: compiled from: ISAService.java */
    public static abstract class a extends Binder implements InterfaceC5101b {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int f13676a = 0;

        /* JADX INFO: renamed from: b.n.a.a.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ISAService.java */
        public static class C13241a implements InterfaceC5101b {

            /* JADX INFO: renamed from: a */
            public IBinder f13677a;

            public C13241a(IBinder iBinder) {
                this.f13677a = iBinder;
            }

            @Override // p007b.p449n.p450a.p451a.InterfaceC5101b
            /* JADX INFO: renamed from: Q */
            public String mo7153Q(String str, String str2, String str3, InterfaceC5100a interfaceC5100a) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.msc.sa.aidl.ISAService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongBinder(interfaceC5100a != null ? interfaceC5100a.asBinder() : null);
                    if (!this.f13677a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = a.f13676a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13677a;
            }

            @Override // p007b.p449n.p450a.p451a.InterfaceC5101b
            /* JADX INFO: renamed from: h0 */
            public boolean mo7154h0(int i, String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.msc.sa.aidl.ISAService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(1);
                    bundle.writeToParcel(parcelObtain, 0);
                    if (!this.f13677a.transact(6, parcelObtain, parcelObtain2, 0)) {
                        int i2 = a.f13676a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    /* JADX INFO: renamed from: Q */
    String mo7153Q(String str, String str2, String str3, InterfaceC5100a interfaceC5100a) throws RemoteException;

    /* JADX INFO: renamed from: h0 */
    boolean mo7154h0(int i, String str, Bundle bundle) throws RemoteException;
}
