package b.i.a.f.c.a.d;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.auth.api.credentials.IdToken;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements Parcelable$Creator<IdToken> {
    @Override // android.os.Parcelable$Creator
    public final IdToken createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        String strR2 = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strR = b.c.a.a0.d.R(parcel, i);
            } else if (c != 2) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                strR2 = b.c.a.a0.d.R(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new IdToken(strR, strR2);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ IdToken[] newArray(int i) {
        return new IdToken[i];
    }
}
