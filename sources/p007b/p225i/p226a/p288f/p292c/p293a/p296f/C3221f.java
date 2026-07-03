package p007b.p225i.p226a.p288f.p292c.p293a.p296f;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.f */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3221f implements Parcelable.Creator<GoogleSignInOptions> {
    @Override // android.os.Parcelable.Creator
    public final GoogleSignInOptions createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        ArrayList arrayListM480V = null;
        ArrayList arrayListM480V2 = null;
        Account account = null;
        String strM468R = null;
        String strM468R2 = null;
        String strM468R3 = null;
        int iM437G1 = 0;
        boolean zM431E1 = false;
        boolean zM431E2 = false;
        boolean zM431E3 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iM437G1 = C1460d.m437G1(parcel, i);
                    break;
                case 2:
                    arrayListM480V2 = C1460d.m480V(parcel, i, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) C1460d.m465Q(parcel, i, Account.CREATOR);
                    break;
                case 4:
                    zM431E1 = C1460d.m431E1(parcel, i);
                    break;
                case 5:
                    zM431E2 = C1460d.m431E1(parcel, i);
                    break;
                case 6:
                    zM431E3 = C1460d.m431E1(parcel, i);
                    break;
                case 7:
                    strM468R = C1460d.m468R(parcel, i);
                    break;
                case '\b':
                    strM468R2 = C1460d.m468R(parcel, i);
                    break;
                case '\t':
                    arrayListM480V = C1460d.m480V(parcel, i, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case '\n':
                    strM468R3 = C1460d.m468R(parcel, i);
                    break;
                default:
                    C1460d.m510d2(parcel, i);
                    break;
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new GoogleSignInOptions(iM437G1, arrayListM480V2, account, zM431E1, zM431E2, zM431E3, strM468R, strM468R2, GoogleSignInOptions.m9013y0(arrayListM480V), strM468R3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
