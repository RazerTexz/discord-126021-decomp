package b.i.a.f.h.k;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.internal.icing.zzh;
import com.google.android.gms.internal.icing.zzk;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements Parcelable.Creator<zzh> {
    @Override // android.os.Parcelable.Creator
    public final zzh createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        zzk[] zzkVarArr = null;
        String strR = null;
        Account account = null;
        boolean zE1 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                zzkVarArr = (zzk[]) AnimatableValueParser.U(parcel, i, zzk.CREATOR);
            } else if (c == 2) {
                strR = AnimatableValueParser.R(parcel, i);
            } else if (c == 3) {
                zE1 = AnimatableValueParser.E1(parcel, i);
            } else if (c != 4) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                account = (Account) AnimatableValueParser.Q(parcel, i, Account.CREATOR);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzh(zzkVarArr, strR, zE1, account);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzh[] newArray(int i) {
        return new zzh[i];
    }
}
