package p007b.p225i.p226a.p288f.p292c.p293a.p294d;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.IdToken;
import java.util.ArrayList;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.c.a.d.e */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3190e implements Parcelable.Creator<Credential> {
    @Override // android.os.Parcelable.Creator
    public final Credential createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        String strM468R2 = null;
        Uri uri = null;
        ArrayList arrayListM480V = null;
        String strM468R3 = null;
        String strM468R4 = null;
        String strM468R5 = null;
        String strM468R6 = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    strM468R = C1460d.m468R(parcel, i);
                    break;
                case 2:
                    strM468R2 = C1460d.m468R(parcel, i);
                    break;
                case 3:
                    uri = (Uri) C1460d.m465Q(parcel, i, Uri.CREATOR);
                    break;
                case 4:
                    arrayListM480V = C1460d.m480V(parcel, i, IdToken.CREATOR);
                    break;
                case 5:
                    strM468R3 = C1460d.m468R(parcel, i);
                    break;
                case 6:
                    strM468R4 = C1460d.m468R(parcel, i);
                    break;
                case 7:
                case '\b':
                default:
                    C1460d.m510d2(parcel, i);
                    break;
                case '\t':
                    strM468R5 = C1460d.m468R(parcel, i);
                    break;
                case '\n':
                    strM468R6 = C1460d.m468R(parcel, i);
                    break;
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new Credential(strM468R, strM468R2, uri, arrayListM480V, strM468R3, strM468R4, strM468R5, strM468R6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Credential[] newArray(int i) {
        return new Credential[i];
    }
}
