package b.i.a.d.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import b.i.a.a.BaseProxy;
import b.i.a.a.BaseStub;
import b.i.a.a.Codecs;

/* JADX INFO: renamed from: b.i.a.d.a.a, reason: use source file name */
/* JADX INFO: compiled from: IGetInstallReferrerService.java */
/* JADX INFO: loaded from: classes3.dex */
public interface IGetInstallReferrerService extends IInterface {

    /* JADX INFO: renamed from: b.i.a.d.a.a$a */
    /* JADX INFO: compiled from: IGetInstallReferrerService.java */
    public static abstract class a extends BaseStub implements IGetInstallReferrerService {
        public static final /* synthetic */ int a = 0;

        /* JADX INFO: renamed from: b.i.a.d.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IGetInstallReferrerService.java */
        public static class C0032a extends BaseProxy implements IGetInstallReferrerService {
            public C0032a(IBinder iBinder) {
                super(iBinder);
            }

            @Override // b.i.a.d.a.IGetInstallReferrerService
            public final Bundle B(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.writeInterfaceToken("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                int i = Codecs.a;
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    try {
                        this.a.transact(1, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        parcelObtain.recycle();
                        Bundle bundle2 = (Bundle) (parcelObtain2.readInt() == 0 ? null : (Parcelable) Bundle.CREATOR.createFromParcel(parcelObtain2));
                        parcelObtain2.recycle();
                        return bundle2;
                    } catch (RuntimeException e) {
                        parcelObtain2.recycle();
                        throw e;
                    }
                } catch (Throwable th) {
                    parcelObtain.recycle();
                    throw th;
                }
            }
        }
    }

    Bundle B(Bundle bundle) throws RemoteException;
}
