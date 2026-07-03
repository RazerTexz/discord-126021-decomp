package p007b.p225i.p226a.p288f.p298d;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cloudmessaging.zza;

/* JADX INFO: renamed from: b.i.a.f.d.d */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3229d implements Parcelable.Creator<zza> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza createFromParcel(Parcel parcel) {
        return new zza(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza[] newArray(int i) {
        return new zza[i];
    }
}
