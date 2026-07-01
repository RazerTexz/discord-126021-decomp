package b.i.a.f.j.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.internal.nearby.zzgs;
import com.google.android.gms.nearby.messages.Message;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Parcelable.Creator<Message> {
    @Override // android.os.Parcelable.Creator
    public final Message createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        byte[] bArrN = null;
        String strR = null;
        String strR2 = null;
        zzgs[] zzgsVarArr = null;
        long jH1 = 0;
        int iG1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                bArrN = AnimatableValueParser.N(parcel, i);
            } else if (c == 2) {
                strR2 = AnimatableValueParser.R(parcel, i);
            } else if (c == 3) {
                strR = AnimatableValueParser.R(parcel, i);
            } else if (c == 4) {
                zzgsVarArr = (zzgs[]) AnimatableValueParser.U(parcel, i, zzgs.CREATOR);
            } else if (c == 5) {
                jH1 = AnimatableValueParser.H1(parcel, i);
            } else if (c != 1000) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                iG1 = AnimatableValueParser.G1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new Message(iG1, bArrN, strR, strR2, zzgsVarArr, jH1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Message[] newArray(int i) {
        return new Message[i];
    }
}
