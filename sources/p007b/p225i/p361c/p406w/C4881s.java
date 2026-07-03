package p007b.p225i.p361c.p406w;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.RemoteMessage;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.c.w.s */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4881s implements Parcelable.Creator<RemoteMessage> {
    @Override // android.os.Parcelable.Creator
    public RemoteMessage createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        Bundle bundleM453M = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            if (((char) i) != 2) {
                C1460d.m510d2(parcel, i);
            } else {
                bundleM453M = C1460d.m453M(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new RemoteMessage(bundleM453M);
    }

    @Override // android.os.Parcelable.Creator
    public RemoteMessage[] newArray(int i) {
        return new RemoteMessage[i];
    }
}
