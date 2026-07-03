package p007b.p225i.p226a.p288f.p292c.p293a.p296f;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.g */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3222g implements Parcelable.Creator<SignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final SignInAccount createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = "";
        GoogleSignInAccount googleSignInAccount = null;
        String strM468R2 = "";
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 4) {
                strM468R = C1460d.m468R(parcel, i);
            } else if (c == 7) {
                googleSignInAccount = (GoogleSignInAccount) C1460d.m465Q(parcel, i, GoogleSignInAccount.CREATOR);
            } else if (c != '\b') {
                C1460d.m510d2(parcel, i);
            } else {
                strM468R2 = C1460d.m468R(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new SignInAccount(strM468R, googleSignInAccount, strM468R2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInAccount[] newArray(int i) {
        return new SignInAccount[i];
    }
}
