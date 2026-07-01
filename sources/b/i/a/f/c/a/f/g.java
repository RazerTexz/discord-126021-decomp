package b.i.a.f.c.a.f;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements Parcelable.Creator<SignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final SignInAccount createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        String strR = "";
        GoogleSignInAccount googleSignInAccount = null;
        String strR2 = "";
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 4) {
                strR = AnimatableValueParser.R(parcel, i);
            } else if (c == 7) {
                googleSignInAccount = (GoogleSignInAccount) AnimatableValueParser.Q(parcel, i, GoogleSignInAccount.CREATOR);
            } else if (c != '\b') {
                AnimatableValueParser.d2(parcel, i);
            } else {
                strR2 = AnimatableValueParser.R(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new SignInAccount(strR, googleSignInAccount, strR2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInAccount[] newArray(int i) {
        return new SignInAccount[i];
    }
}
