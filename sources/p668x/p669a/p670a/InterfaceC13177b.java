package p668x.p669a.p670a;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: renamed from: x.a.a.b */
/* JADX INFO: compiled from: ICustomTabsService.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC13177b extends IInterface {

    /* JADX INFO: renamed from: x.a.a.b$a */
    /* JADX INFO: compiled from: ICustomTabsService.java */
    public static abstract class a extends Binder implements InterfaceC13177b {
        private static final String DESCRIPTOR = "android.support.customtabs.ICustomTabsService";
        public static final int TRANSACTION_extraCommand = 5;
        public static final int TRANSACTION_mayLaunchUrl = 4;
        public static final int TRANSACTION_newSession = 3;
        public static final int TRANSACTION_newSessionWithExtras = 10;
        public static final int TRANSACTION_postMessage = 8;
        public static final int TRANSACTION_receiveFile = 12;
        public static final int TRANSACTION_requestPostMessageChannel = 7;
        public static final int TRANSACTION_requestPostMessageChannelWithExtras = 11;
        public static final int TRANSACTION_updateVisuals = 6;
        public static final int TRANSACTION_validateRelationship = 9;
        public static final int TRANSACTION_warmup = 2;

        /* JADX INFO: renamed from: x.a.a.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ICustomTabsService.java */
        public static class C13356a implements InterfaceC13177b {

            /* JADX INFO: renamed from: a */
            public static InterfaceC13177b f27933a;

            /* JADX INFO: renamed from: b */
            public IBinder f27934b;

            public C13356a(IBinder iBinder) {
                this.f27934b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27934b;
            }

            @Override // p668x.p669a.p670a.InterfaceC13177b
            public Bundle extraCommand(String str, Bundle bundle) throws RemoteException {
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
                    if (!this.f27934b.transact(5, parcelObtain, parcelObtain2, 0) && a.getDefaultImpl() != null) {
                        return a.getDefaultImpl().extraCommand(str, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13177b
            public boolean mayLaunchUrl(InterfaceC13176a interfaceC13176a, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(interfaceC13176a != null ? interfaceC13176a.asBinder() : null);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeTypedList(list);
                    if (!this.f27934b.transact(4, parcelObtain, parcelObtain2, 0) && a.getDefaultImpl() != null) {
                        return a.getDefaultImpl().mayLaunchUrl(interfaceC13176a, uri, bundle, list);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13177b
            public boolean newSession(InterfaceC13176a interfaceC13176a) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(interfaceC13176a != null ? interfaceC13176a.asBinder() : null);
                    if (!this.f27934b.transact(3, parcelObtain, parcelObtain2, 0) && a.getDefaultImpl() != null) {
                        return a.getDefaultImpl().newSession(interfaceC13176a);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13177b
            public boolean newSessionWithExtras(InterfaceC13176a interfaceC13176a, Bundle bundle) throws RemoteException {
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
                    if (!this.f27934b.transact(10, parcelObtain, parcelObtain2, 0) && a.getDefaultImpl() != null) {
                        return a.getDefaultImpl().newSessionWithExtras(interfaceC13176a, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13177b
            public int postMessage(InterfaceC13176a interfaceC13176a, String str, Bundle bundle) throws RemoteException {
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
                    if (!this.f27934b.transact(8, parcelObtain, parcelObtain2, 0) && a.getDefaultImpl() != null) {
                        return a.getDefaultImpl().postMessage(interfaceC13176a, str, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13177b
            public boolean receiveFile(InterfaceC13176a interfaceC13176a, Uri uri, int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(interfaceC13176a != null ? interfaceC13176a.asBinder() : null);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f27934b.transact(12, parcelObtain, parcelObtain2, 0) && a.getDefaultImpl() != null) {
                        return a.getDefaultImpl().receiveFile(interfaceC13176a, uri, i, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13177b
            public boolean requestPostMessageChannel(InterfaceC13176a interfaceC13176a, Uri uri) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(interfaceC13176a != null ? interfaceC13176a.asBinder() : null);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f27934b.transact(7, parcelObtain, parcelObtain2, 0) && a.getDefaultImpl() != null) {
                        return a.getDefaultImpl().requestPostMessageChannel(interfaceC13176a, uri);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13177b
            public boolean requestPostMessageChannelWithExtras(InterfaceC13176a interfaceC13176a, Uri uri, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(interfaceC13176a != null ? interfaceC13176a.asBinder() : null);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f27934b.transact(11, parcelObtain, parcelObtain2, 0) && a.getDefaultImpl() != null) {
                        return a.getDefaultImpl().requestPostMessageChannelWithExtras(interfaceC13176a, uri, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13177b
            public boolean updateVisuals(InterfaceC13176a interfaceC13176a, Bundle bundle) throws RemoteException {
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
                    if (!this.f27934b.transact(6, parcelObtain, parcelObtain2, 0) && a.getDefaultImpl() != null) {
                        return a.getDefaultImpl().updateVisuals(interfaceC13176a, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13177b
            public boolean validateRelationship(InterfaceC13176a interfaceC13176a, int i, Uri uri, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(interfaceC13176a != null ? interfaceC13176a.asBinder() : null);
                    parcelObtain.writeInt(i);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f27934b.transact(9, parcelObtain, parcelObtain2, 0) && a.getDefaultImpl() != null) {
                        return a.getDefaultImpl().validateRelationship(interfaceC13176a, i, uri, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p670a.InterfaceC13177b
            public boolean warmup(long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    if (!this.f27934b.transact(2, parcelObtain, parcelObtain2, 0) && a.getDefaultImpl() != null) {
                        return a.getDefaultImpl().warmup(j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static InterfaceC13177b asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC13177b)) ? new C13356a(iBinder) : (InterfaceC13177b) iInterfaceQueryLocalInterface;
        }

        public static InterfaceC13177b getDefaultImpl() {
            return C13356a.f27933a;
        }

        public static boolean setDefaultImpl(InterfaceC13177b interfaceC13177b) {
            if (C13356a.f27933a != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (interfaceC13177b == null) {
                return false;
            }
            C13356a.f27933a = interfaceC13177b;
            return true;
        }

        @Override // android.os.IInterface
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
                    boolean zWarmup = warmup(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zWarmup ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zNewSession = newSession(InterfaceC13176a.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zNewSession ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zMayLaunchUrl = mayLaunchUrl(InterfaceC13176a.a.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.createTypedArrayList(Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zMayLaunchUrl ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle bundleExtraCommand = extraCommand(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleExtraCommand != null) {
                        parcel2.writeInt(1);
                        bundleExtraCommand.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zUpdateVisuals = updateVisuals(InterfaceC13176a.a.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zUpdateVisuals ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zRequestPostMessageChannel = requestPostMessageChannel(InterfaceC13176a.a.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestPostMessageChannel ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iPostMessage = postMessage(InterfaceC13176a.a.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(iPostMessage);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zValidateRelationship = validateRelationship(InterfaceC13176a.a.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zValidateRelationship ? 1 : 0);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zNewSessionWithExtras = newSessionWithExtras(InterfaceC13176a.a.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zNewSessionWithExtras ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zRequestPostMessageChannelWithExtras = requestPostMessageChannelWithExtras(InterfaceC13176a.a.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestPostMessageChannelWithExtras ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zReceiveFile = receiveFile(InterfaceC13176a.a.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zReceiveFile ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Bundle extraCommand(String str, Bundle bundle) throws RemoteException;

    boolean mayLaunchUrl(InterfaceC13176a interfaceC13176a, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException;

    boolean newSession(InterfaceC13176a interfaceC13176a) throws RemoteException;

    boolean newSessionWithExtras(InterfaceC13176a interfaceC13176a, Bundle bundle) throws RemoteException;

    int postMessage(InterfaceC13176a interfaceC13176a, String str, Bundle bundle) throws RemoteException;

    boolean receiveFile(InterfaceC13176a interfaceC13176a, Uri uri, int i, Bundle bundle) throws RemoteException;

    boolean requestPostMessageChannel(InterfaceC13176a interfaceC13176a, Uri uri) throws RemoteException;

    boolean requestPostMessageChannelWithExtras(InterfaceC13176a interfaceC13176a, Uri uri, Bundle bundle) throws RemoteException;

    boolean updateVisuals(InterfaceC13176a interfaceC13176a, Bundle bundle) throws RemoteException;

    boolean validateRelationship(InterfaceC13176a interfaceC13176a, int i, Uri uri, Bundle bundle) throws RemoteException;

    boolean warmup(long j) throws RemoteException;
}
