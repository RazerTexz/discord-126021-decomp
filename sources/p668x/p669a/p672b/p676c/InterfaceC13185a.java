package p668x.p669a.p672b.p676c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.os.ResultReceiver;

/* JADX INFO: renamed from: x.a.b.c.a */
/* JADX INFO: compiled from: IResultReceiver.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC13185a extends IInterface {

    /* JADX INFO: renamed from: x.a.b.c.a$a */
    /* JADX INFO: compiled from: IResultReceiver.java */
    public static abstract class a extends Binder implements InterfaceC13185a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int f27948a = 0;

        /* JADX INFO: renamed from: x.a.b.c.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IResultReceiver.java */
        public static class C13362a implements InterfaceC13185a {

            /* JADX INFO: renamed from: a */
            public IBinder f27949a;

            public C13362a(IBinder iBinder) {
                this.f27949a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27949a;
            }

            @Override // p668x.p669a.p672b.p676c.InterfaceC13185a
            /* JADX INFO: renamed from: r0 */
            public void mo74r0(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.os.IResultReceiver");
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f27949a.transact(1, parcelObtain, null, 1)) {
                        int i2 = a.f27948a;
                    }
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                ((ResultReceiver.BinderC0031b) this).mo74r0(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("android.support.v4.os.IResultReceiver");
            return true;
        }
    }

    /* JADX INFO: renamed from: r0 */
    void mo74r0(int i, Bundle bundle) throws RemoteException;
}
