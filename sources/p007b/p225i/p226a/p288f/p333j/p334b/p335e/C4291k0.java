package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.nearby.zzgs;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.internal.Update;
import com.google.android.gms.nearby.messages.internal.zza;
import com.google.android.gms.nearby.messages.internal.zze;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.k0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4291k0 implements Parcelable.Creator<Update> {
    @Override // android.os.Parcelable.Creator
    public final Update createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        Message message = null;
        zze zzeVar = null;
        zza zzaVar = null;
        zzgs zzgsVar = null;
        byte[] bArrM456N = null;
        int iM437G1 = 0;
        int iM437G2 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iM437G1 = C1460d.m437G1(parcel, i);
                    break;
                case 2:
                    iM437G2 = C1460d.m437G1(parcel, i);
                    break;
                case 3:
                    message = (Message) C1460d.m465Q(parcel, i, Message.CREATOR);
                    break;
                case 4:
                    zzeVar = (zze) C1460d.m465Q(parcel, i, zze.CREATOR);
                    break;
                case 5:
                    zzaVar = (zza) C1460d.m465Q(parcel, i, zza.CREATOR);
                    break;
                case 6:
                    zzgsVar = (zzgs) C1460d.m465Q(parcel, i, zzgs.CREATOR);
                    break;
                case 7:
                    bArrM456N = C1460d.m456N(parcel, i);
                    break;
                default:
                    C1460d.m510d2(parcel, i);
                    break;
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new Update(iM437G1, iM437G2, message, zzeVar, zzaVar, zzgsVar, bArrM456N);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Update[] newArray(int i) {
        return new Update[i];
    }
}
