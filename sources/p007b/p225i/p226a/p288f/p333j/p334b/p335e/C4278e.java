package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.internal.zzaf;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.e */
/* JADX INFO: loaded from: classes3.dex */
public final class C4278e implements Parcelable.Creator<zzaf> {
    @Override // android.os.Parcelable.Creator
    public final zzaf createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        int iM437G1 = 0;
        Message message = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                message = (Message) C1460d.m465Q(parcel, i, Message.CREATOR);
            } else if (c != 1000) {
                C1460d.m510d2(parcel, i);
            } else {
                iM437G1 = C1460d.m437G1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzaf(iM437G1, message);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf[] newArray(int i) {
        return new zzaf[i];
    }
}
