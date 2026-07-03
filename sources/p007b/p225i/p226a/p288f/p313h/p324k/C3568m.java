package p007b.p225i.p226a.p288f.p313h.p324k;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.icing.zzh;
import com.google.android.gms.internal.icing.zzk;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.h.k.m */
/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3568m implements Parcelable.Creator<zzh> {
    @Override // android.os.Parcelable.Creator
    public final zzh createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        zzk[] zzkVarArr = null;
        String strM468R = null;
        Account account = null;
        boolean zM431E1 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                zzkVarArr = (zzk[]) C1460d.m477U(parcel, i, zzk.CREATOR);
            } else if (c == 2) {
                strM468R = C1460d.m468R(parcel, i);
            } else if (c == 3) {
                zM431E1 = C1460d.m431E1(parcel, i);
            } else if (c != 4) {
                C1460d.m510d2(parcel, i);
            } else {
                account = (Account) C1460d.m465Q(parcel, i, Account.CREATOR);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzh(zzkVarArr, strM468R, zM431E1, account);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzh[] newArray(int i) {
        return new zzh[i];
    }
}
