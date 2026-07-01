package b.i.a.f.h.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.internal.p001authapi.zzz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements Parcelable.Creator<zzz> {
    @Override // android.os.Parcelable.Creator
    public final zzz createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        Credential credential = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            if (((char) i) != 1) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                credential = (Credential) AnimatableValueParser.Q(parcel, i, Credential.CREATOR);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzz(credential);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz[] newArray(int i) {
        return new zzz[i];
    }
}
