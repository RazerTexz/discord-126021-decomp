package p007b.p225i.p226a.p285d.p286a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import p007b.p225i.p226a.p227a.BinderC2404b;
import p007b.p225i.p226a.p227a.C2403a;
import p007b.p225i.p226a.p227a.C2405c;

/* JADX INFO: renamed from: b.i.a.d.a.a */
/* JADX INFO: compiled from: IGetInstallReferrerService.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC3169a extends IInterface {

    /* JADX INFO: renamed from: b.i.a.d.a.a$a */
    /* JADX INFO: compiled from: IGetInstallReferrerService.java */
    public static abstract class a extends BinderC2404b implements InterfaceC3169a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int f9162a = 0;

        /* JADX INFO: renamed from: b.i.a.d.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IGetInstallReferrerService.java */
        public static class C13227a extends C2403a implements InterfaceC3169a {
            public C13227a(IBinder iBinder) {
                super(iBinder);
            }

            @Override // p007b.p225i.p226a.p285d.p286a.InterfaceC3169a
            /* JADX INFO: renamed from: B */
            public final Bundle mo3923B(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.writeInterfaceToken("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                int i = C2405c.f5115a;
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    try {
                        this.f5114a.transact(1, parcelObtain, parcelObtain2, 0);
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

    /* JADX INFO: renamed from: B */
    Bundle mo3923B(Bundle bundle) throws RemoteException;
}
