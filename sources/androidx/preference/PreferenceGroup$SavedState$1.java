package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceGroup$SavedState$1 implements Parcelable$Creator<PreferenceGroup$SavedState> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ PreferenceGroup$SavedState createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ PreferenceGroup$SavedState[] newArray(int i) {
        return newArray(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public PreferenceGroup$SavedState createFromParcel(Parcel parcel) {
        return new PreferenceGroup$SavedState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public PreferenceGroup$SavedState[] newArray(int i) {
        return new PreferenceGroup$SavedState[i];
    }
}
