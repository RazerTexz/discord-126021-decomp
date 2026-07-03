package p007b.p225i.p226a.p288f.p299e.p300h;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.h.m */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3335m implements Parcelable.Creator<Status> {
    @Override // android.os.Parcelable.Creator
    public final Status createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        PendingIntent pendingIntent = null;
        ConnectionResult connectionResult = null;
        int iM437G1 = 0;
        int iM437G2 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iM437G2 = C1460d.m437G1(parcel, i);
            } else if (c == 2) {
                strM468R = C1460d.m468R(parcel, i);
            } else if (c == 3) {
                pendingIntent = (PendingIntent) C1460d.m465Q(parcel, i, PendingIntent.CREATOR);
            } else if (c == 4) {
                connectionResult = (ConnectionResult) C1460d.m465Q(parcel, i, ConnectionResult.CREATOR);
            } else if (c != 1000) {
                C1460d.m510d2(parcel, i);
            } else {
                iM437G1 = C1460d.m437G1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new Status(iM437G1, iM437G2, strM468R, pendingIntent, connectionResult);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Status[] newArray(int i) {
        return new Status[i];
    }
}
