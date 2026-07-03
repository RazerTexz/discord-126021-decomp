package p007b.p225i.p226a.p288f.p313h.p316c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.internal.p688authapi.zzt;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.h.c.p */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3467p implements Parcelable.Creator<zzt> {
    @Override // android.os.Parcelable.Creator
    public final zzt createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        Credential credential = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            if (((char) i) != 1) {
                C1460d.m510d2(parcel, i);
            } else {
                credential = (Credential) C1460d.m465Q(parcel, i, Credential.CREATOR);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzt(credential);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzt[] newArray(int i) {
        return new zzt[i];
    }
}
