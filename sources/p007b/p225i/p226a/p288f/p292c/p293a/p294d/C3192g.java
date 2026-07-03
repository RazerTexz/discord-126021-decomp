package p007b.p225i.p226a.p288f.p292c.p293a.p294d;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.c.a.d.g */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3192g implements Parcelable.Creator<CredentialRequest> {
    @Override // android.os.Parcelable.Creator
    public final CredentialRequest createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String[] strArrM471S = null;
        CredentialPickerConfig credentialPickerConfig = null;
        CredentialPickerConfig credentialPickerConfig2 = null;
        String strM468R = null;
        String strM468R2 = null;
        int iM437G1 = 0;
        boolean zM431E1 = false;
        boolean zM431E2 = false;
        boolean zM431E3 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c != 1000) {
                switch (c) {
                    case 1:
                        zM431E1 = C1460d.m431E1(parcel, i);
                        break;
                    case 2:
                        strArrM471S = C1460d.m471S(parcel, i);
                        break;
                    case 3:
                        credentialPickerConfig = (CredentialPickerConfig) C1460d.m465Q(parcel, i, CredentialPickerConfig.CREATOR);
                        break;
                    case 4:
                        credentialPickerConfig2 = (CredentialPickerConfig) C1460d.m465Q(parcel, i, CredentialPickerConfig.CREATOR);
                        break;
                    case 5:
                        zM431E2 = C1460d.m431E1(parcel, i);
                        break;
                    case 6:
                        strM468R = C1460d.m468R(parcel, i);
                        break;
                    case 7:
                        strM468R2 = C1460d.m468R(parcel, i);
                        break;
                    case '\b':
                        zM431E3 = C1460d.m431E1(parcel, i);
                        break;
                    default:
                        C1460d.m510d2(parcel, i);
                        break;
                }
            } else {
                iM437G1 = C1460d.m437G1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new CredentialRequest(iM437G1, zM431E1, strArrM471S, credentialPickerConfig, credentialPickerConfig2, zM431E2, strM468R, strM468R2, zM431E3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialRequest[] newArray(int i) {
        return new CredentialRequest[i];
    }
}
