package p007b.p225i.p226a.p288f.p299e.p303j;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.j.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3342a implements Parcelable.Creator<DataHolder> {
    @Override // android.os.Parcelable.Creator
    public final DataHolder createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        int i = 0;
        String[] strArrM471S = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundleM453M = null;
        int iM437G1 = 0;
        int iM437G2 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i2 = parcel.readInt();
            char c = (char) i2;
            if (c == 1) {
                strArrM471S = C1460d.m471S(parcel, i2);
            } else if (c == 2) {
                cursorWindowArr = (CursorWindow[]) C1460d.m477U(parcel, i2, CursorWindow.CREATOR);
            } else if (c == 3) {
                iM437G2 = C1460d.m437G1(parcel, i2);
            } else if (c == 4) {
                bundleM453M = C1460d.m453M(parcel, i2);
            } else if (c != 1000) {
                C1460d.m510d2(parcel, i2);
            } else {
                iM437G1 = C1460d.m437G1(parcel, i2);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        DataHolder dataHolder = new DataHolder(iM437G1, strArrM471S, cursorWindowArr, iM437G2, bundleM453M);
        dataHolder.f20514l = new Bundle();
        int i3 = 0;
        while (true) {
            String[] strArr = dataHolder.f20513k;
            if (i3 >= strArr.length) {
                break;
            }
            dataHolder.f20514l.putInt(strArr[i3], i3);
            i3++;
        }
        dataHolder.f20518p = new int[dataHolder.f20515m.length];
        int numRows = 0;
        while (true) {
            CursorWindow[] cursorWindowArr2 = dataHolder.f20515m;
            if (i >= cursorWindowArr2.length) {
                return dataHolder;
            }
            dataHolder.f20518p[i] = numRows;
            numRows += dataHolder.f20515m[i].getNumRows() - (numRows - cursorWindowArr2[i].getStartPosition());
            i++;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }
}
