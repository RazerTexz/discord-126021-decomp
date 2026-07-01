package b.i.a.f.c.a.f.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements Parcelable$Creator<GoogleSignInOptionsExtensionParcelable> {
    @Override // android.os.Parcelable$Creator
    public final GoogleSignInOptionsExtensionParcelable createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        int iG1 = 0;
        Bundle bundleM = null;
        int iG2 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iG1 = b.c.a.a0.d.G1(parcel, i);
            } else if (c == 2) {
                iG2 = b.c.a.a0.d.G1(parcel, i);
            } else if (c != 3) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                bundleM = b.c.a.a0.d.M(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new GoogleSignInOptionsExtensionParcelable(iG1, iG2, bundleM);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ GoogleSignInOptionsExtensionParcelable[] newArray(int i) {
        return new GoogleSignInOptionsExtensionParcelable[i];
    }
}
