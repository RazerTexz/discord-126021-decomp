package p668x.p669a.p672b.p674b.p675a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: x.a.b.b.a.b */
/* JADX INFO: compiled from: IMediaSession.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC13183b extends IInterface {

    /* JADX INFO: renamed from: x.a.b.b.a.b$a */
    /* JADX INFO: compiled from: IMediaSession.java */
    public static abstract class a extends Binder implements InterfaceC13183b {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int f27943a = 0;

        /* JADX INFO: renamed from: x.a.b.b.a.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IMediaSession.java */
        public static class C13361a implements InterfaceC13183b {

            /* JADX INFO: renamed from: a */
            public IBinder f27944a;

            public C13361a(IBinder iBinder) {
                this.f27944a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27944a;
            }

            @Override // p668x.p669a.p672b.p674b.p675a.InterfaceC13183b
            /* JADX INFO: renamed from: k */
            public void mo11355k(InterfaceC13182a interfaceC13182a) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcelObtain.writeStrongBinder((InterfaceC13182a.a) interfaceC13182a);
                    if (!this.f27944a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = a.f27943a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* JADX INFO: renamed from: c */
        public static InterfaceC13183b m11356c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC13183b)) ? new C13361a(iBinder) : (InterfaceC13183b) iInterfaceQueryLocalInterface;
        }
    }

    /* JADX INFO: renamed from: k */
    void mo11355k(InterfaceC13182a interfaceC13182a) throws RemoteException;
}
