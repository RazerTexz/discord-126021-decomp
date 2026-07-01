package b.i.c.w;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.firebase.messaging.RemoteMessage;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class s implements Parcelable$Creator<RemoteMessage> {
    @Override // android.os.Parcelable$Creator
    public RemoteMessage createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        Bundle bundleM = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            if (((char) i) != 2) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                bundleM = b.c.a.a0.d.M(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new RemoteMessage(bundleM);
    }

    @Override // android.os.Parcelable$Creator
    public RemoteMessage[] newArray(int i) {
        return new RemoteMessage[i];
    }
}
