package b.i.a.f.l.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zau;
import com.google.android.gms.signin.internal.zam;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements Parcelable.Creator<zam> {
    @Override // android.os.Parcelable.Creator
    public final zam createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        ConnectionResult connectionResult = null;
        zau zauVar = null;
        int iG1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iG1 = AnimatableValueParser.G1(parcel, i);
            } else if (c == 2) {
                connectionResult = (ConnectionResult) AnimatableValueParser.Q(parcel, i, ConnectionResult.CREATOR);
            } else if (c != 3) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                zauVar = (zau) AnimatableValueParser.Q(parcel, i, zau.CREATOR);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zam(iG1, connectionResult, zauVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zam[] newArray(int i) {
        return new zam[i];
    }
}
