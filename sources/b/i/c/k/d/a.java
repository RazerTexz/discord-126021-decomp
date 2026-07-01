package b.i.c.k.d;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.firebase.appindexing.internal.zza;
import com.google.firebase.appindexing.internal.zzc;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Parcelable$Creator<zza> {
    @Override // android.os.Parcelable$Creator
    public final zza createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        String strR2 = null;
        String strR3 = null;
        String strR4 = null;
        zzc zzcVar = null;
        String strR5 = null;
        Bundle bundleM = null;
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
                    strR3 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 4:
                    strR4 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 5:
                    zzcVar = (zzc) b.c.a.a0.d.Q(parcel, i, zzc.CREATOR);
                    break;
                case 6:
                    strR5 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 7:
                    bundleM = b.c.a.a0.d.M(parcel, i);
                    break;
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zza(strR, strR2, strR3, strR4, zzcVar, strR5, bundleM);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zza[] newArray(int i) {
        return new zza[i];
    }
}
