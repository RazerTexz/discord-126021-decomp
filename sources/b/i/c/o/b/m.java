package b.i.c.o.b;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.firebase.dynamiclinks.internal.zzo;
import com.google.firebase.dynamiclinks.internal.zzr;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements Parcelable.Creator<zzo> {
    @Override // android.os.Parcelable.Creator
    public final zzo createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        Uri uri = null;
        Uri uri2 = null;
        ArrayList arrayListV = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                uri = (Uri) AnimatableValueParser.Q(parcel, i, Uri.CREATOR);
            } else if (c == 2) {
                uri2 = (Uri) AnimatableValueParser.Q(parcel, i, Uri.CREATOR);
            } else if (c != 3) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                arrayListV = AnimatableValueParser.V(parcel, i, zzr.CREATOR);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzo(uri, uri2, arrayListV);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo[] newArray(int i) {
        return new zzo[i];
    }
}
