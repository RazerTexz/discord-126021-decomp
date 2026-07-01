package x.a.b.a;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: x.a.b.a.a, reason: use source file name */
/* JADX INFO: compiled from: INotificationSideChannel.java */
/* JADX INFO: loaded from: classes.dex */
public interface INotificationSideChannel extends IInterface {

    /* JADX INFO: renamed from: x.a.b.a.a$a */
    /* JADX INFO: compiled from: INotificationSideChannel.java */
    public static abstract class a extends Binder implements INotificationSideChannel {
        private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
        public static final int TRANSACTION_cancel = 2;
        public static final int TRANSACTION_cancelAll = 3;
        public static final int TRANSACTION_notify = 1;

        /* JADX INFO: renamed from: x.a.b.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: INotificationSideChannel.java */
        public static class C0442a implements INotificationSideChannel {
            public static INotificationSideChannel a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public IBinder f3855b;

            public C0442a(IBinder iBinder) {
                this.f3855b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3855b;
            }

            @Override // x.a.b.a.INotificationSideChannel
            public void cancel(String str, int i, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    if (this.f3855b.transact(2, parcelObtain, null, 1) || a.getDefaultImpl() == null) {
                        return;
                    }
                    a.getDefaultImpl().cancel(str, i, str2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // x.a.b.a.INotificationSideChannel
            public void cancelAll(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.f3855b.transact(3, parcelObtain, null, 1) || a.getDefaultImpl() == null) {
                        return;
                    }
                    a.getDefaultImpl().cancelAll(str);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // x.a.b.a.INotificationSideChannel
            public void notify(String str, int i, String str2, Notification notification) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    if (notification != null) {
                        parcelObtain.writeInt(1);
                        notification.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f3855b.transact(1, parcelObtain, null, 1) || a.getDefaultImpl() == null) {
                        return;
                    }
                    a.getDefaultImpl().notify(str, i, str2, notification);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static INotificationSideChannel asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof INotificationSideChannel)) ? new C0442a(iBinder) : (INotificationSideChannel) iInterfaceQueryLocalInterface;
        }

        public static INotificationSideChannel getDefaultImpl() {
            return C0442a.a;
        }

        public static boolean setDefaultImpl(INotificationSideChannel iNotificationSideChannel) {
            if (C0442a.a != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iNotificationSideChannel == null) {
                return false;
            }
            C0442a.a = iNotificationSideChannel;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                notify(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                cancel(parcel.readString(), parcel.readInt(), parcel.readString());
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                cancelAll(parcel.readString());
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void cancel(String str, int i, String str2) throws RemoteException;

    void cancelAll(String str) throws RemoteException;

    void notify(String str, int i, String str2, Notification notification) throws RemoteException;
}
