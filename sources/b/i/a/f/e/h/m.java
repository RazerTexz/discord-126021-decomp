package b.i.a.f.e.h;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements Parcelable.Creator<Status> {
    @Override // android.os.Parcelable.Creator
    public final Status createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        String strR = null;
        PendingIntent pendingIntent = null;
        ConnectionResult connectionResult = null;
        int iG1 = 0;
        int iG2 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iG2 = AnimatableValueParser.G1(parcel, i);
            } else if (c == 2) {
                strR = AnimatableValueParser.R(parcel, i);
            } else if (c == 3) {
                pendingIntent = (PendingIntent) AnimatableValueParser.Q(parcel, i, PendingIntent.CREATOR);
            } else if (c == 4) {
                connectionResult = (ConnectionResult) AnimatableValueParser.Q(parcel, i, ConnectionResult.CREATOR);
            } else if (c != 1000) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                iG1 = AnimatableValueParser.G1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new Status(iG1, iG2, strR, pendingIntent, connectionResult);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Status[] newArray(int i) {
        return new Status[i];
    }
}
