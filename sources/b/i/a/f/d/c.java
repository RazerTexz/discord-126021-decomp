package b.i.a.f.d;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.cloudmessaging.CloudMessage;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements Parcelable.Creator<CloudMessage> {
    @Override // android.os.Parcelable.Creator
    public final CloudMessage createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            if (((char) i) != 1) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                intent = (Intent) AnimatableValueParser.Q(parcel, i, Intent.CREATOR);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new CloudMessage(intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CloudMessage[] newArray(int i) {
        return new CloudMessage[i];
    }
}
