package b.i.a.f.c.a.f.b;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements Parcelable$Creator<SignInConfiguration> {
    @Override // android.os.Parcelable$Creator
    public final SignInConfiguration createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strR = b.c.a.a0.d.R(parcel, i);
            } else if (c != 5) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                googleSignInOptions = (GoogleSignInOptions) b.c.a.a0.d.Q(parcel, i, GoogleSignInOptions.CREATOR);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new SignInConfiguration(strR, googleSignInOptions);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ SignInConfiguration[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
