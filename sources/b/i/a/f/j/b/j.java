package b.i.a.f.j.b;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.nearby.messages.Strategy;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Parcelable$Creator<Strategy> {
    @Override // android.os.Parcelable$Creator
    public final Strategy createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        int iG1 = 0;
        int iG2 = 0;
        int iG3 = 0;
        int iG4 = 0;
        boolean zE1 = false;
        int iG5 = 0;
        int iG6 = 0;
        int iG7 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c != 1000) {
                switch (c) {
                    case 1:
                        iG2 = b.c.a.a0.d.G1(parcel, i);
                        break;
                    case 2:
                        iG3 = b.c.a.a0.d.G1(parcel, i);
                        break;
                    case 3:
                        iG4 = b.c.a.a0.d.G1(parcel, i);
                        break;
                    case 4:
                        zE1 = b.c.a.a0.d.E1(parcel, i);
                        break;
                    case 5:
                        iG5 = b.c.a.a0.d.G1(parcel, i);
                        break;
                    case 6:
                        iG6 = b.c.a.a0.d.G1(parcel, i);
                        break;
                    case 7:
                        iG7 = b.c.a.a0.d.G1(parcel, i);
                        break;
                    default:
                        b.c.a.a0.d.d2(parcel, i);
                        break;
                }
            } else {
                iG1 = b.c.a.a0.d.G1(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new Strategy(iG1, iG2, iG3, iG4, zE1, iG5, iG6, iG7);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ Strategy[] newArray(int i) {
        return new Strategy[i];
    }
}
