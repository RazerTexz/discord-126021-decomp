package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class MultiSelectListPreference$SavedState$1 implements Parcelable$Creator<MultiSelectListPreference$SavedState> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ MultiSelectListPreference$SavedState createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ MultiSelectListPreference$SavedState[] newArray(int i) {
        return newArray(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public MultiSelectListPreference$SavedState createFromParcel(Parcel parcel) {
        return new MultiSelectListPreference$SavedState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public MultiSelectListPreference$SavedState[] newArray(int i) {
        return new MultiSelectListPreference$SavedState[i];
    }
}
