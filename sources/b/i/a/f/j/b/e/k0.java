package b.i.a.f.j.b.e;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.nearby.zzgs;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.internal.Update;
import com.google.android.gms.nearby.messages.internal.zza;
import com.google.android.gms.nearby.messages.internal.zze;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 implements Parcelable$Creator<Update> {
    @Override // android.os.Parcelable$Creator
    public final Update createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        Message message = null;
        zze zzeVar = null;
        zza zzaVar = null;
        zzgs zzgsVar = null;
        byte[] bArrN = null;
        int iG1 = 0;
        int iG2 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iG1 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case 2:
                    iG2 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case 3:
                    message = (Message) b.c.a.a0.d.Q(parcel, i, Message.CREATOR);
                    break;
                case 4:
                    zzeVar = (zze) b.c.a.a0.d.Q(parcel, i, zze.CREATOR);
                    break;
                case 5:
                    zzaVar = (zza) b.c.a.a0.d.Q(parcel, i, zza.CREATOR);
                    break;
                case 6:
                    zzgsVar = (zzgs) b.c.a.a0.d.Q(parcel, i, zzgs.CREATOR);
                    break;
                case 7:
                    bArrN = b.c.a.a0.d.N(parcel, i);
                    break;
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new Update(iG1, iG2, message, zzeVar, zzaVar, zzgsVar, bArrN);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ Update[] newArray(int i) {
        return new Update[i];
    }
}
