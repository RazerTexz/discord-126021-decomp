package b.i.a.f.h.k;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.icing.zzh;
import com.google.android.gms.internal.icing.zzk;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements Parcelable$Creator<zzh> {
    @Override // android.os.Parcelable$Creator
    public final zzh createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        zzk[] zzkVarArr = null;
        String strR = null;
        Account account = null;
        boolean zE1 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                zzkVarArr = (zzk[]) b.c.a.a0.d.U(parcel, i, zzk.CREATOR);
            } else if (c == 2) {
                strR = b.c.a.a0.d.R(parcel, i);
            } else if (c == 3) {
                zE1 = b.c.a.a0.d.E1(parcel, i);
            } else if (c != 4) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                account = (Account) b.c.a.a0.d.Q(parcel, i, Account.CREATOR);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzh(zzkVarArr, strR, zE1, account);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzh[] newArray(int i) {
        return new zzh[i];
    }
}
