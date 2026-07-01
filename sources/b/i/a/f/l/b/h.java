package b.i.a.f.l.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.signin.internal.zag;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements Parcelable.Creator<zag> {
    @Override // android.os.Parcelable.Creator
    public final zag createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        ArrayList<String> arrayListT = null;
        String strR = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                arrayListT = AnimatableValueParser.T(parcel, i);
            } else if (c != 2) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                strR = AnimatableValueParser.R(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zag(arrayListT, strR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zag[] newArray(int i) {
        return new zag[i];
    }
}
