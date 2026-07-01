package b.i.a.f.j.b.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 implements Parcelable.Creator<ClientAppContext> {
    @Override // android.os.Parcelable.Creator
    public final ClientAppContext createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        String strR = null;
        String strR2 = null;
        String strR3 = null;
        int iG1 = 0;
        boolean zE1 = false;
        int iG2 = 0;
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
                    zE1 = AnimatableValueParser.E1(parcel, i);
                    break;
                case 5:
                    iG2 = AnimatableValueParser.G1(parcel, i);
                    break;
                case 6:
                    strR3 = AnimatableValueParser.R(parcel, i);
                    break;
                default:
                    AnimatableValueParser.d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new ClientAppContext(iG1, strR, strR2, zE1, iG2, strR3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ClientAppContext[] newArray(int i) {
        return new ClientAppContext[i];
    }
}
