package b.i.a.f.c.a.f;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Parcelable$Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable$Creator
    public final GoogleSignInAccount createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        String strR2 = null;
        String strR3 = null;
        String strR4 = null;
        Uri uri = null;
        String strR5 = null;
        String strR6 = null;
        ArrayList arrayListV = null;
        String strR7 = null;
        String strR8 = null;
        long jH1 = 0;
        int iG1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iG1 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case 2:
                    strR = b.c.a.a0.d.R(parcel, i);
                    break;
                case 3:
                    strR2 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 4:
                    strR3 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 5:
                    strR4 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 6:
                    uri = (Uri) b.c.a.a0.d.Q(parcel, i, Uri.CREATOR);
                    break;
                case 7:
                    strR5 = b.c.a.a0.d.R(parcel, i);
                    break;
                case '\b':
                    jH1 = b.c.a.a0.d.H1(parcel, i);
                    break;
                case '\t':
                    strR6 = b.c.a.a0.d.R(parcel, i);
                    break;
                case '\n':
                    arrayListV = b.c.a.a0.d.V(parcel, i, Scope.CREATOR);
                    break;
                case 11:
                    strR7 = b.c.a.a0.d.R(parcel, i);
                    break;
                case '\f':
                    strR8 = b.c.a.a0.d.R(parcel, i);
                    break;
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new GoogleSignInAccount(iG1, strR, strR2, strR3, strR4, uri, strR5, jH1, strR6, arrayListV, strR7, strR8);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
