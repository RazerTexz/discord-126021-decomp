package b.i.a.f.c.a.f;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final GoogleSignInAccount createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
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
                    iG1 = AnimatableValueParser.G1(parcel, i);
                    break;
                case 2:
                    strR = AnimatableValueParser.R(parcel, i);
                    break;
                case 3:
                    strR2 = AnimatableValueParser.R(parcel, i);
                    break;
                case 4:
                    strR3 = AnimatableValueParser.R(parcel, i);
                    break;
                case 5:
                    strR4 = AnimatableValueParser.R(parcel, i);
                    break;
                case 6:
                    uri = (Uri) AnimatableValueParser.Q(parcel, i, Uri.CREATOR);
                    break;
                case 7:
                    strR5 = AnimatableValueParser.R(parcel, i);
                    break;
                case '\b':
                    jH1 = AnimatableValueParser.H1(parcel, i);
                    break;
                case '\t':
                    strR6 = AnimatableValueParser.R(parcel, i);
                    break;
                case '\n':
                    arrayListV = AnimatableValueParser.V(parcel, i, Scope.CREATOR);
                    break;
                case 11:
                    strR7 = AnimatableValueParser.R(parcel, i);
                    break;
                case '\f':
                    strR8 = AnimatableValueParser.R(parcel, i);
                    break;
                default:
                    AnimatableValueParser.d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new GoogleSignInAccount(iG1, strR, strR2, strR3, strR4, uri, strR5, jH1, strR6, arrayListV, strR7, strR8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
