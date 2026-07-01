package b.i.a.f.c.a.d;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.IdToken;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements Parcelable$Creator<Credential> {
    @Override // android.os.Parcelable$Creator
    public final Credential createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        String strR2 = null;
        Uri uri = null;
        ArrayList arrayListV = null;
        String strR3 = null;
        String strR4 = null;
        String strR5 = null;
        String strR6 = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    strR = b.c.a.a0.d.R(parcel, i);
                    break;
                case 2:
                    strR2 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 3:
                    uri = (Uri) b.c.a.a0.d.Q(parcel, i, Uri.CREATOR);
                    break;
                case 4:
                    arrayListV = b.c.a.a0.d.V(parcel, i, IdToken.CREATOR);
                    break;
                case 5:
                    strR3 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 6:
                    strR4 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 7:
                case '\b':
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
                case '\t':
                    strR5 = b.c.a.a0.d.R(parcel, i);
                    break;
                case '\n':
                    strR6 = b.c.a.a0.d.R(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new Credential(strR, strR2, uri, arrayListV, strR3, strR4, strR5, strR6);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ Credential[] newArray(int i) {
        return new Credential[i];
    }
}
