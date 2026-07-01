package b.i.a.f.c.a.d;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements Parcelable.Creator<CredentialRequest> {
    @Override // android.os.Parcelable.Creator
    public final CredentialRequest createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        String[] strArrS = null;
        CredentialPickerConfig credentialPickerConfig = null;
        CredentialPickerConfig credentialPickerConfig2 = null;
        String strR = null;
        String strR2 = null;
        int iG1 = 0;
        boolean zE1 = false;
        boolean zE2 = false;
        boolean zE3 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c != 1000) {
                switch (c) {
                    case 1:
                        zE1 = AnimatableValueParser.E1(parcel, i);
                        break;
                    case 2:
                        strArrS = AnimatableValueParser.S(parcel, i);
                        break;
                    case 3:
                        credentialPickerConfig = (CredentialPickerConfig) AnimatableValueParser.Q(parcel, i, CredentialPickerConfig.CREATOR);
                        break;
                    case 4:
                        credentialPickerConfig2 = (CredentialPickerConfig) AnimatableValueParser.Q(parcel, i, CredentialPickerConfig.CREATOR);
                        break;
                    case 5:
                        zE2 = AnimatableValueParser.E1(parcel, i);
                        break;
                    case 6:
                        strR = AnimatableValueParser.R(parcel, i);
                        break;
                    case 7:
                        strR2 = AnimatableValueParser.R(parcel, i);
                        break;
                    case '\b':
                        zE3 = AnimatableValueParser.E1(parcel, i);
                        break;
                    default:
                        AnimatableValueParser.d2(parcel, i);
                        break;
                }
            } else {
                iG1 = AnimatableValueParser.G1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new CredentialRequest(iG1, zE1, strArrS, credentialPickerConfig, credentialPickerConfig2, zE2, strR, strR2, zE3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialRequest[] newArray(int i) {
        return new CredentialRequest[i];
    }
}
