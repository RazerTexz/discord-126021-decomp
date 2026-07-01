package b.i.a.f.h.c;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.internal.p001authapi.zzt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements Parcelable$Creator<zzt> {
    @Override // android.os.Parcelable$Creator
    public final zzt createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        Credential credential = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            if (((char) i) != 1) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                credential = (Credential) b.c.a.a0.d.Q(parcel, i, Credential.CREATOR);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzt(credential);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzt[] newArray(int i) {
        return new zzt[i];
    }
}
