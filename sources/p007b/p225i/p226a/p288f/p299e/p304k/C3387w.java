package p007b.p225i.p226a.p288f.p299e.p304k;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.zas;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.k.w */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3387w implements Parcelable.Creator<zas> {
    @Override // android.os.Parcelable.Creator
    public final zas createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        int iM437G1 = 0;
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int iM437G2 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iM437G1 = C1460d.m437G1(parcel, i);
            } else if (c == 2) {
                account = (Account) C1460d.m465Q(parcel, i, Account.CREATOR);
            } else if (c == 3) {
                iM437G2 = C1460d.m437G1(parcel, i);
            } else if (c != 4) {
                C1460d.m510d2(parcel, i);
            } else {
                googleSignInAccount = (GoogleSignInAccount) C1460d.m465Q(parcel, i, GoogleSignInAccount.CREATOR);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zas(iM437G1, account, iM437G2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zas[] newArray(int i) {
        return new zas[i];
    }
}
