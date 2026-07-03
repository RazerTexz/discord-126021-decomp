package p007b.p225i.p226a.p288f.p336k;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.safetynet.SafeBrowsingData;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.k.g */
/* JADX INFO: loaded from: classes3.dex */
public final class C4333g implements Parcelable.Creator<SafeBrowsingData> {
    /* JADX INFO: renamed from: a */
    public static void m5997a(SafeBrowsingData safeBrowsingData, Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 2, safeBrowsingData.f20821j, false);
        C1460d.m570s2(parcel, 3, safeBrowsingData.f20822k, i, false);
        C1460d.m570s2(parcel, 4, safeBrowsingData.f20823l, i, false);
        long j = safeBrowsingData.f20824m;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        C1460d.m562q2(parcel, 6, safeBrowsingData.f20825n, false);
        C1460d.m418A2(parcel, iM594y2);
    }

    @Override // android.os.Parcelable.Creator
    public final SafeBrowsingData createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        DataHolder dataHolder = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        byte[] bArrM456N = null;
        long jM440H1 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strM468R = C1460d.m468R(parcel, i);
            } else if (c == 3) {
                dataHolder = (DataHolder) C1460d.m465Q(parcel, i, DataHolder.CREATOR);
            } else if (c == 4) {
                parcelFileDescriptor = (ParcelFileDescriptor) C1460d.m465Q(parcel, i, ParcelFileDescriptor.CREATOR);
            } else if (c == 5) {
                jM440H1 = C1460d.m440H1(parcel, i);
            } else if (c != 6) {
                C1460d.m510d2(parcel, i);
            } else {
                bArrM456N = C1460d.m456N(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new SafeBrowsingData(strM468R, dataHolder, parcelFileDescriptor, jM440H1, bArrM456N);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeBrowsingData[] newArray(int i) {
        return new SafeBrowsingData[i];
    }
}
