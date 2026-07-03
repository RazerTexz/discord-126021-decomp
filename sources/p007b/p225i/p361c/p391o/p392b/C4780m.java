package p007b.p225i.p361c.p391o.p392b;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.dynamiclinks.internal.zzo;
import com.google.firebase.dynamiclinks.internal.zzr;
import java.util.ArrayList;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.c.o.b.m */
/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4780m implements Parcelable.Creator<zzo> {
    @Override // android.os.Parcelable.Creator
    public final zzo createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        Uri uri = null;
        Uri uri2 = null;
        ArrayList arrayListM480V = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                uri = (Uri) C1460d.m465Q(parcel, i, Uri.CREATOR);
            } else if (c == 2) {
                uri2 = (Uri) C1460d.m465Q(parcel, i, Uri.CREATOR);
            } else if (c != 3) {
                C1460d.m510d2(parcel, i);
            } else {
                arrayListM480V = C1460d.m480V(parcel, i, zzr.CREATOR);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzo(uri, uri2, arrayListM480V);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo[] newArray(int i) {
        return new zzo[i];
    }
}
