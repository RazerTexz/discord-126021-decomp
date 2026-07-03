package p007b.p225i.p226a.p288f.p337l.p338b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.signin.internal.zag;
import java.util.ArrayList;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.l.b.h */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4343h implements Parcelable.Creator<zag> {
    @Override // android.os.Parcelable.Creator
    public final zag createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        ArrayList<String> arrayListM474T = null;
        String strM468R = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                arrayListM474T = C1460d.m474T(parcel, i);
            } else if (c != 2) {
                C1460d.m510d2(parcel, i);
            } else {
                strM468R = C1460d.m468R(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zag(arrayListM474T, strM468R);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zag[] newArray(int i) {
        return new zag[i];
    }
}
