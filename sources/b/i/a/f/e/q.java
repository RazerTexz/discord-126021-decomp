package b.i.a.f.e;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements Parcelable.Creator<ConnectionResult> {
    @Override // android.os.Parcelable.Creator
    public final ConnectionResult createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        int iG1 = 0;
        PendingIntent pendingIntent = null;
        String strR = null;
        int iG2 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iG1 = AnimatableValueParser.G1(parcel, i);
            } else if (c == 2) {
                iG2 = AnimatableValueParser.G1(parcel, i);
            } else if (c == 3) {
                pendingIntent = (PendingIntent) AnimatableValueParser.Q(parcel, i, PendingIntent.CREATOR);
            } else if (c != 4) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                strR = AnimatableValueParser.R(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new ConnectionResult(iG1, iG2, pendingIntent, strR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ConnectionResult[] newArray(int i) {
        return new ConnectionResult[i];
    }
}
