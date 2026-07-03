package p668x.p669a.p672b.p673a;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: x.a.b.a.a */
/* JADX INFO: compiled from: INotificationSideChannel.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC13181a extends IInterface {

    /* JADX INFO: renamed from: x.a.b.a.a$a */
    /* JADX INFO: compiled from: INotificationSideChannel.java */
    public static abstract class a extends Binder implements InterfaceC13181a {
        private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
        public static final int TRANSACTION_cancel = 2;
        public static final int TRANSACTION_cancelAll = 3;
        public static final int TRANSACTION_notify = 1;

        /* JADX INFO: renamed from: x.a.b.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: INotificationSideChannel.java */
        public static class C13360a implements InterfaceC13181a {

            /* JADX INFO: renamed from: a */
            public static InterfaceC13181a f27941a;

            /* JADX INFO: renamed from: b */
            public IBinder f27942b;

            public C13360a(IBinder iBinder) {
                this.f27942b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27942b;
            }

            @Override // p668x.p669a.p672b.p673a.InterfaceC13181a
            public void cancel(String str, int i, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    if (this.f27942b.transact(2, parcelObtain, null, 1) || a.getDefaultImpl() == null) {
                        return;
                    }
                    a.getDefaultImpl().cancel(str, i, str2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p672b.p673a.InterfaceC13181a
            public void cancelAll(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.f27942b.transact(3, parcelObtain, null, 1) || a.getDefaultImpl() == null) {
                        return;
                    }
                    a.getDefaultImpl().cancelAll(str);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // p668x.p669a.p672b.p673a.InterfaceC13181a
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
                    if (this.f27942b.transact(1, parcelObtain, null, 1) || a.getDefaultImpl() == null) {
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

        public static InterfaceC13181a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC13181a)) ? new C13360a(iBinder) : (InterfaceC13181a) iInterfaceQueryLocalInterface;
        }

        public static InterfaceC13181a getDefaultImpl() {
            return C13360a.f27941a;
        }

        public static boolean setDefaultImpl(InterfaceC13181a interfaceC13181a) {
            if (C13360a.f27941a != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (interfaceC13181a == null) {
                return false;
            }
            C13360a.f27941a = interfaceC13181a;
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
