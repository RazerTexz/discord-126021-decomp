package p007b.p225i.p226a.p288f.p299e.p304k;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p313h.p320g.C3481a;
import p007b.p225i.p226a.p288f.p313h.p320g.C3483c;

/* JADX INFO: renamed from: b.i.a.f.e.k.w0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3388w0 extends C3481a implements InterfaceC3355g {
    public C3388w0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3355g
    /* JADX INFO: renamed from: b */
    public final Account mo4156b() throws RemoteException {
        Parcel parcelM4407c = m4407c(2, m4408g());
        Account account = (Account) C3483c.m4409a(parcelM4407c, Account.CREATOR);
        parcelM4407c.recycle();
        return account;
    }
}
