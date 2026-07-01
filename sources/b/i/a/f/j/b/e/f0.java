package b.i.a.f.j.b.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzaf;
import com.google.android.gms.nearby.messages.internal.zzbz;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements Parcelable.Creator<zzbz> {
    @Override // android.os.Parcelable.Creator
    public final zzbz createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        zzaf zzafVar = null;
        Strategy strategy = null;
        IBinder iBinderF1 = null;
        String strR = null;
        String strR2 = null;
        IBinder iBinderF2 = null;
        ClientAppContext clientAppContext = null;
        int iG1 = 0;
        boolean zE1 = false;
        boolean zE2 = false;
        int iG2 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iG1 = AnimatableValueParser.G1(parcel, i);
                    break;
                case 2:
                    zzafVar = (zzaf) AnimatableValueParser.Q(parcel, i, zzaf.CREATOR);
                    break;
                case 3:
                    strategy = (Strategy) AnimatableValueParser.Q(parcel, i, Strategy.CREATOR);
                    break;
                case 4:
                    iBinderF1 = AnimatableValueParser.F1(parcel, i);
                    break;
                case 5:
                    strR = AnimatableValueParser.R(parcel, i);
                    break;
                case 6:
                    strR2 = AnimatableValueParser.R(parcel, i);
                    break;
                case 7:
                    zE1 = AnimatableValueParser.E1(parcel, i);
                    break;
                case '\b':
                    iBinderF2 = AnimatableValueParser.F1(parcel, i);
                    break;
                case '\t':
                    zE2 = AnimatableValueParser.E1(parcel, i);
                    break;
                case '\n':
                    clientAppContext = (ClientAppContext) AnimatableValueParser.Q(parcel, i, ClientAppContext.CREATOR);
                    break;
                case 11:
                    iG2 = AnimatableValueParser.G1(parcel, i);
                    break;
                default:
                    AnimatableValueParser.d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzbz(iG1, zzafVar, strategy, iBinderF1, strR, strR2, zE1, iBinderF2, zE2, clientAppContext, iG2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbz[] newArray(int i) {
        return new zzbz[i];
    }
}
