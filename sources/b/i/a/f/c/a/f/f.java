package b.i.a.f.c.a.f;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements Parcelable$Creator<GoogleSignInOptions> {
    @Override // android.os.Parcelable$Creator
    public final GoogleSignInOptions createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        ArrayList arrayListV = null;
        ArrayList arrayListV2 = null;
        Account account = null;
        String strR = null;
        String strR2 = null;
        String strR3 = null;
        int iG1 = 0;
        boolean zE1 = false;
        boolean zE2 = false;
        boolean zE3 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iG1 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case 2:
                    arrayListV2 = b.c.a.a0.d.V(parcel, i, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) b.c.a.a0.d.Q(parcel, i, Account.CREATOR);
                    break;
                case 4:
                    zE1 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 5:
                    zE2 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 6:
                    zE3 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 7:
                    strR = b.c.a.a0.d.R(parcel, i);
                    break;
                case '\b':
                    strR2 = b.c.a.a0.d.R(parcel, i);
                    break;
                case '\t':
                    arrayListV = b.c.a.a0.d.V(parcel, i, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case '\n':
                    strR3 = b.c.a.a0.d.R(parcel, i);
                    break;
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new GoogleSignInOptions(iG1, arrayListV2, account, zE1, zE2, zE3, strR, strR2, GoogleSignInOptions.y0(arrayListV), strR3);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ GoogleSignInOptions[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
