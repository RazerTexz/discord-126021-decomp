package b.i.a.f.d;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.cloudmessaging.zza;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Parcelable$Creator<zza> {
    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zza createFromParcel(Parcel parcel) {
        return new zza(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zza[] newArray(int i) {
        return new zza[i];
    }
}
