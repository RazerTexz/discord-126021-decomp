package b.i.a.f.e.k;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class w0 extends b.i.a.f.h.g.a implements g {
    public w0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // b.i.a.f.e.k.g
    public final Account b() throws RemoteException {
        Parcel parcelC = c(2, g());
        Account account = (Account) b.i.a.f.h.g.c.a(parcelC, Account.CREATOR);
        parcelC.recycle();
        return account;
    }
}
