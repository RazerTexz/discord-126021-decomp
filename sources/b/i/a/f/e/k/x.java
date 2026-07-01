package b.i.a.f.e.k;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zau;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements Parcelable.Creator<zau> {
    @Override // android.os.Parcelable.Creator
    public final zau createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        IBinder iBinderF1 = null;
        ConnectionResult connectionResult = null;
        int iG1 = 0;
        boolean zE1 = false;
        boolean zE2 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iG1 = AnimatableValueParser.G1(parcel, i);
            } else if (c == 2) {
                iBinderF1 = AnimatableValueParser.F1(parcel, i);
            } else if (c == 3) {
                connectionResult = (ConnectionResult) AnimatableValueParser.Q(parcel, i, ConnectionResult.CREATOR);
            } else if (c == 4) {
                zE1 = AnimatableValueParser.E1(parcel, i);
            } else if (c != 5) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                zE2 = AnimatableValueParser.E1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zau(iG1, iBinderF1, connectionResult, zE1, zE2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zau[] newArray(int i) {
        return new zau[i];
    }
}
