package p668x.p669a.p670a.p671d;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: x.a.a.d.a */
/* JADX INFO: compiled from: ITrustedWebActivityCallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC13179a extends IInterface {

    /* JADX INFO: renamed from: x.a.a.d.a$a */
    /* JADX INFO: compiled from: ITrustedWebActivityCallback.java */
    public static abstract class a extends Binder implements InterfaceC13179a {
        private static final String DESCRIPTOR = "android.support.customtabs.trusted.ITrustedWebActivityCallback";
        public static final int TRANSACTION_onExtraCallback = 2;

        /* JADX INFO: renamed from: x.a.a.d.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ITrustedWebActivityCallback.java */
        public static class C13358a implements InterfaceC13179a {

            /* JADX INFO: renamed from: a */
            public static InterfaceC13179a f27937a;

            /* JADX INFO: renamed from: b */
            public IBinder f27938b;

            public C13358a(IBinder iBinder) {
                this.f27938b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27938b;
            }

            @Override // p668x.p669a.p670a.p671d.InterfaceC13179a
            public void onExtraCallback(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f27938b.transact(2, parcelObtain, parcelObtain2, 0) || a.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.getDefaultImpl().onExtraCallback(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static InterfaceC13179a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC13179a)) ? new C13358a(iBinder) : (InterfaceC13179a) iInterfaceQueryLocalInterface;
        }

        public static InterfaceC13179a getDefaultImpl() {
            return C13358a.f27937a;
        }

        public static boolean setDefaultImpl(InterfaceC13179a interfaceC13179a) {
            if (C13358a.f27937a != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (interfaceC13179a == null) {
                return false;
            }
            C13358a.f27937a = interfaceC13179a;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onExtraCallback(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void onExtraCallback(String str, Bundle bundle) throws RemoteException;
}
