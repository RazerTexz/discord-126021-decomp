package p007b.p225i.p226a.p288f.p292c.p293a.p296f;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.d */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3219d implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final GoogleSignInAccount createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        String strM468R2 = null;
        String strM468R3 = null;
        String strM468R4 = null;
        Uri uri = null;
        String strM468R5 = null;
        String strM468R6 = null;
        ArrayList arrayListM480V = null;
        String strM468R7 = null;
        String strM468R8 = null;
        long jM440H1 = 0;
        int iM437G1 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iM437G1 = C1460d.m437G1(parcel, i);
                    break;
                case 2:
                    strM468R = C1460d.m468R(parcel, i);
                    break;
                case 3:
                    strM468R2 = C1460d.m468R(parcel, i);
                    break;
                case 4:
                    strM468R3 = C1460d.m468R(parcel, i);
                    break;
                case 5:
                    strM468R4 = C1460d.m468R(parcel, i);
                    break;
                case 6:
                    uri = (Uri) C1460d.m465Q(parcel, i, Uri.CREATOR);
                    break;
                case 7:
                    strM468R5 = C1460d.m468R(parcel, i);
                    break;
                case '\b':
                    jM440H1 = C1460d.m440H1(parcel, i);
                    break;
                case '\t':
                    strM468R6 = C1460d.m468R(parcel, i);
                    break;
                case '\n':
                    arrayListM480V = C1460d.m480V(parcel, i, Scope.CREATOR);
                    break;
                case 11:
                    strM468R7 = C1460d.m468R(parcel, i);
                    break;
                case '\f':
                    strM468R8 = C1460d.m468R(parcel, i);
                    break;
                default:
                    C1460d.m510d2(parcel, i);
                    break;
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new GoogleSignInAccount(iM437G1, strM468R, strM468R2, strM468R3, strM468R4, uri, strM468R5, jM440H1, strM468R6, arrayListM480V, strM468R7, strM468R8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
