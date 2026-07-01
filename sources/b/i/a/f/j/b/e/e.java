package b.i.a.f.j.b.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.internal.zzaf;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Parcelable.Creator<zzaf> {
    @Override // android.os.Parcelable.Creator
    public final zzaf createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        int iG1 = 0;
        Message message = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                message = (Message) AnimatableValueParser.Q(parcel, i, Message.CREATOR);
            } else if (c != 1000) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                iG1 = AnimatableValueParser.G1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzaf(iG1, message);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf[] newArray(int i) {
        return new zzaf[i];
    }
}
