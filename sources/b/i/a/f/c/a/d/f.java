package b.i.a.f.c.a.d;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements Parcelable$Creator<CredentialPickerConfig> {
    @Override // android.os.Parcelable$Creator
    public final CredentialPickerConfig createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        int iG1 = 0;
        boolean zE1 = false;
        boolean zE2 = false;
        boolean zE3 = false;
        int iG2 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                zE1 = b.c.a.a0.d.E1(parcel, i);
            } else if (c == 2) {
                zE2 = b.c.a.a0.d.E1(parcel, i);
            } else if (c == 3) {
                zE3 = b.c.a.a0.d.E1(parcel, i);
            } else if (c == 4) {
                iG2 = b.c.a.a0.d.G1(parcel, i);
            } else if (c != 1000) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                iG1 = b.c.a.a0.d.G1(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new CredentialPickerConfig(iG1, zE1, zE2, zE3, iG2);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ CredentialPickerConfig[] newArray(int i) {
        return new CredentialPickerConfig[i];
    }
}
