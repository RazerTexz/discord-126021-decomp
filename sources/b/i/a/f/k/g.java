package b.i.a.f.k;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.safetynet.SafeBrowsingData;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Parcelable.Creator<SafeBrowsingData> {
    public static void a(SafeBrowsingData safeBrowsingData, Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.t2(parcel, 2, safeBrowsingData.j, false);
        AnimatableValueParser.s2(parcel, 3, safeBrowsingData.k, i, false);
        AnimatableValueParser.s2(parcel, 4, safeBrowsingData.l, i, false);
        long j = safeBrowsingData.m;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        AnimatableValueParser.q2(parcel, 6, safeBrowsingData.n, false);
        AnimatableValueParser.A2(parcel, iY2);
    }

    @Override // android.os.Parcelable.Creator
    public final SafeBrowsingData createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        String strR = null;
        DataHolder dataHolder = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        byte[] bArrN = null;
        long jH1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strR = AnimatableValueParser.R(parcel, i);
            } else if (c == 3) {
                dataHolder = (DataHolder) AnimatableValueParser.Q(parcel, i, DataHolder.CREATOR);
            } else if (c == 4) {
                parcelFileDescriptor = (ParcelFileDescriptor) AnimatableValueParser.Q(parcel, i, ParcelFileDescriptor.CREATOR);
            } else if (c == 5) {
                jH1 = AnimatableValueParser.H1(parcel, i);
            } else if (c != 6) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                bArrN = AnimatableValueParser.N(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new SafeBrowsingData(strR, dataHolder, parcelFileDescriptor, jH1, bArrN);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeBrowsingData[] newArray(int i) {
        return new SafeBrowsingData[i];
    }
}
