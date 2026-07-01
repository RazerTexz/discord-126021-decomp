package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ActivityResult$1 implements Parcelable$Creator<ActivityResult> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ActivityResult createFromParcel(@NonNull Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ActivityResult[] newArray(int i) {
        return newArray(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public ActivityResult createFromParcel(@NonNull Parcel parcel) {
        return new ActivityResult(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public ActivityResult[] newArray(int i) {
        return new ActivityResult[i];
    }
}
