package p668x.p669a.p670a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: x.a.a.c */
/* JADX INFO: compiled from: IPostMessageService.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC13178c extends IInterface {

    /* JADX INFO: renamed from: x.a.a.c$a */
    /* JADX INFO: compiled from: IPostMessageService.java */
    public static abstract class a extends Binder implements InterfaceC13178c {
        private static final String DESCRIPTOR = "android.support.customtabs.IPostMessageService";
        public static final int TRANSACTION_onMessageChannelReady = 2;
        public static final int TRANSACTION_onPostMessage = 3;

        /* JADX INFO: renamed from: x.a.a.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IPostMessageService.java */
        public static class C13357a implements InterfaceC13178c {

            /* JADX INFO: renamed from: a */
            public static InterfaceC13178c f27935a;

            /* JADX INFO: renamed from: b */
            public IBinder f27936b;

            public C13357a(IBinder iBinder) {
                this.f27936b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27936b;
            }

            @Override // p668x.p669a.p670a.InterfaceC13178c
            public void onMessageChannelReady(InterfaceC13176a interfaceC13176a, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(interfaceC13176a != null ? interfaceC13176a.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f27936b.transact(2, parcelObtain, parcelObtain2, 0) || a.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.getDefaultImpl().onMessageChannelReady(interfaceC13176a, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13178c
            public void onPostMessage(InterfaceC13176a interfaceC13176a, String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(interfaceC13176a != null ? interfaceC13176a.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f27936b.transact(3, parcelObtain, parcelObtain2, 0) || a.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.getDefaultImpl().onPostMessage(interfaceC13176a, str, bundle);
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

        public static InterfaceC13178c asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC13178c)) ? new C13357a(iBinder) : (InterfaceC13178c) iInterfaceQueryLocalInterface;
        }

        public static InterfaceC13178c getDefaultImpl() {
            return C13357a.f27935a;
        }

        public static boolean setDefaultImpl(InterfaceC13178c interfaceC13178c) {
            if (C13357a.f27935a != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (interfaceC13178c == null) {
                return false;
            }
            C13357a.f27935a = interfaceC13178c;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onMessageChannelReady(InterfaceC13176a.a.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onPostMessage(InterfaceC13176a.a.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void onMessageChannelReady(InterfaceC13176a interfaceC13176a, Bundle bundle) throws RemoteException;

    void onPostMessage(InterfaceC13176a interfaceC13176a, String str, Bundle bundle) throws RemoteException;
}
