package p668x.p669a.p670a;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: x.a.a.a */
/* JADX INFO: compiled from: ICustomTabsCallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC13176a extends IInterface {

    /* JADX INFO: renamed from: x.a.a.a$a */
    /* JADX INFO: compiled from: ICustomTabsCallback.java */
    public static abstract class a extends Binder implements InterfaceC13176a {
        private static final String DESCRIPTOR = "android.support.customtabs.ICustomTabsCallback";
        public static final int TRANSACTION_extraCallback = 3;
        public static final int TRANSACTION_extraCallbackWithResult = 7;
        public static final int TRANSACTION_onMessageChannelReady = 4;
        public static final int TRANSACTION_onNavigationEvent = 2;
        public static final int TRANSACTION_onPostMessage = 5;
        public static final int TRANSACTION_onRelationshipValidationResult = 6;

        /* JADX INFO: renamed from: x.a.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ICustomTabsCallback.java */
        public static class C13355a implements InterfaceC13176a {

            /* JADX INFO: renamed from: a */
            public static InterfaceC13176a f27931a;

            /* JADX INFO: renamed from: b */
            public IBinder f27932b;

            public C13355a(IBinder iBinder) {
                this.f27932b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27932b;
            }

            @Override // p668x.p669a.p670a.InterfaceC13176a
            public void extraCallback(String str, Bundle bundle) throws RemoteException {
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
                    if (this.f27932b.transact(3, parcelObtain, parcelObtain2, 0) || a.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.getDefaultImpl().extraCallback(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13176a
            public Bundle extraCallbackWithResult(String str, Bundle bundle) throws RemoteException {
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
                    if (!this.f27932b.transact(7, parcelObtain, parcelObtain2, 0) && a.getDefaultImpl() != null) {
                        return a.getDefaultImpl().extraCallbackWithResult(str, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13176a
            public void onMessageChannelReady(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f27932b.transact(4, parcelObtain, parcelObtain2, 0) || a.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.getDefaultImpl().onMessageChannelReady(bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13176a
            public void onNavigationEvent(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f27932b.transact(2, parcelObtain, parcelObtain2, 0) || a.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.getDefaultImpl().onNavigationEvent(i, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13176a
            public void onPostMessage(String str, Bundle bundle) throws RemoteException {
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
                    if (this.f27932b.transact(5, parcelObtain, parcelObtain2, 0) || a.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.getDefaultImpl().onPostMessage(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13176a
            public void onRelationshipValidationResult(int i, Uri uri, boolean z2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f27932b.transact(6, parcelObtain, parcelObtain2, 0) || a.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.getDefaultImpl().onRelationshipValidationResult(i, uri, z2, bundle);
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

        public static InterfaceC13176a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC13176a)) ? new C13355a(iBinder) : (InterfaceC13176a) iInterfaceQueryLocalInterface;
        }

        public static InterfaceC13176a getDefaultImpl() {
            return C13355a.f27931a;
        }

        public static boolean setDefaultImpl(InterfaceC13176a interfaceC13176a) {
            if (C13355a.f27931a != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (interfaceC13176a == null) {
                return false;
            }
            C13355a.f27931a = interfaceC13176a;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onNavigationEvent(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    extraCallback(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    onMessageChannelReady(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPostMessage(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onRelationshipValidationResult(parcel.readInt(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle bundleExtraCallbackWithResult = extraCallbackWithResult(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleExtraCallbackWithResult != null) {
                        parcel2.writeInt(1);
                        bundleExtraCallbackWithResult.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void extraCallback(String str, Bundle bundle) throws RemoteException;

    Bundle extraCallbackWithResult(String str, Bundle bundle) throws RemoteException;

    void onMessageChannelReady(Bundle bundle) throws RemoteException;

    void onNavigationEvent(int i, Bundle bundle) throws RemoteException;

    void onPostMessage(String str, Bundle bundle) throws RemoteException;

    void onRelationshipValidationResult(int i, Uri uri, boolean z2, Bundle bundle) throws RemoteException;
}
