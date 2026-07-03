package p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.b.s */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3216s implements Parcelable.Creator<SignInConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final SignInConfiguration createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strM468R = C1460d.m468R(parcel, i);
            } else if (c != 5) {
                C1460d.m510d2(parcel, i);
            } else {
                googleSignInOptions = (GoogleSignInOptions) C1460d.m465Q(parcel, i, GoogleSignInOptions.CREATOR);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new SignInConfiguration(strM468R, googleSignInOptions);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInConfiguration[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
