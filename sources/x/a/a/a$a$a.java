package x.a.a;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: ICustomTabsCallback.java */
/* JADX INFO: loaded from: classes.dex */
public class a$a$a implements a {
    public static a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f3850b;

    public a$a$a(IBinder iBinder) {
        this.f3850b = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3850b;
    }

    @Override // x.a.a.a
    public void extraCallback(String str, Bundle bundle) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
            parcelObtain.writeString(str);
            if (bundle != null) {
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (this.f3850b.transact(3, parcelObtain, parcelObtain2, 0) || a$a.getDefaultImpl() == null) {
                parcelObtain2.readException();
            } else {
                a$a.getDefaultImpl().extraCallback(str, bundle);
            }
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // x.a.a.a
    public Bundle extraCallbackWithResult(String str, Bundle bundle) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
            parcelObtain.writeString(str);
            if (bundle != null) {
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (!this.f3850b.transact(7, parcelObtain, parcelObtain2, 0) && a$a.getDefaultImpl() != null) {
                return a$a.getDefaultImpl().extraCallbackWithResult(str, bundle);
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // x.a.a.a
    public void onMessageChannelReady(Bundle bundle) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
            if (bundle != null) {
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (this.f3850b.transact(4, parcelObtain, parcelObtain2, 0) || a$a.getDefaultImpl() == null) {
                parcelObtain2.readException();
            } else {
                a$a.getDefaultImpl().onMessageChannelReady(bundle);
            }
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // x.a.a.a
    public void onNavigationEvent(int i, Bundle bundle) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
            parcelObtain.writeInt(i);
            if (bundle != null) {
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (this.f3850b.transact(2, parcelObtain, parcelObtain2, 0) || a$a.getDefaultImpl() == null) {
                parcelObtain2.readException();
            } else {
                a$a.getDefaultImpl().onNavigationEvent(i, bundle);
            }
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // x.a.a.a
    public void onPostMessage(String str, Bundle bundle) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
            parcelObtain.writeString(str);
            if (bundle != null) {
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (this.f3850b.transact(5, parcelObtain, parcelObtain2, 0) || a$a.getDefaultImpl() == null) {
                parcelObtain2.readException();
            } else {
                a$a.getDefaultImpl().onPostMessage(str, bundle);
            }
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // x.a.a.a
    public void onRelationshipValidationResult(int i, Uri uri, boolean z2, Bundle bundle) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
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
            if (this.f3850b.transact(6, parcelObtain, parcelObtain2, 0) || a$a.getDefaultImpl() == null) {
                parcelObtain2.readException();
            } else {
                a$a.getDefaultImpl().onRelationshipValidationResult(i, uri, z2, bundle);
            }
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
