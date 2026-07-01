package b.i.a.f.k;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.safetynet.SafeBrowsingData;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Parcelable$Creator<SafeBrowsingData> {
    public static void a(SafeBrowsingData safeBrowsingData, Parcel parcel, int i) {
        int iY2 = b.c.a.a0.d.y2(parcel, 20293);
        b.c.a.a0.d.t2(parcel, 2, safeBrowsingData.j, false);
        b.c.a.a0.d.s2(parcel, 3, safeBrowsingData.k, i, false);
        b.c.a.a0.d.s2(parcel, 4, safeBrowsingData.l, i, false);
        long j = safeBrowsingData.m;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        b.c.a.a0.d.q2(parcel, 6, safeBrowsingData.n, false);
        b.c.a.a0.d.A2(parcel, iY2);
    }

    @Override // android.os.Parcelable$Creator
    public final SafeBrowsingData createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        DataHolder dataHolder = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        byte[] bArrN = null;
        long jH1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strR = b.c.a.a0.d.R(parcel, i);
            } else if (c == 3) {
                dataHolder = (DataHolder) b.c.a.a0.d.Q(parcel, i, DataHolder.CREATOR);
            } else if (c == 4) {
                parcelFileDescriptor = (ParcelFileDescriptor) b.c.a.a0.d.Q(parcel, i, ParcelFileDescriptor.CREATOR);
            } else if (c == 5) {
                jH1 = b.c.a.a0.d.H1(parcel, i);
            } else if (c != 6) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                bArrN = b.c.a.a0.d.N(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new SafeBrowsingData(strR, dataHolder, parcelFileDescriptor, jH1, bArrN);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ SafeBrowsingData[] newArray(int i) {
        return new SafeBrowsingData[i];
    }
}
