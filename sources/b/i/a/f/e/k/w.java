package b.i.a.f.e.k;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.zas;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class w implements Parcelable.Creator<zas> {
    @Override // android.os.Parcelable.Creator
    public final zas createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        int iG1 = 0;
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int iG2 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iG1 = AnimatableValueParser.G1(parcel, i);
            } else if (c == 2) {
                account = (Account) AnimatableValueParser.Q(parcel, i, Account.CREATOR);
            } else if (c == 3) {
                iG2 = AnimatableValueParser.G1(parcel, i);
            } else if (c != 4) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                googleSignInAccount = (GoogleSignInAccount) AnimatableValueParser.Q(parcel, i, GoogleSignInAccount.CREATOR);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zas(iG1, account, iG2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zas[] newArray(int i) {
        return new zas[i];
    }
}
