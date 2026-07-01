package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class IntentSenderRequest$1 implements Parcelable$Creator<IntentSenderRequest> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ IntentSenderRequest createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ IntentSenderRequest[] newArray(int i) {
        return newArray(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public IntentSenderRequest createFromParcel(Parcel parcel) {
        return new IntentSenderRequest(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public IntentSenderRequest[] newArray(int i) {
        return new IntentSenderRequest[i];
    }
}
