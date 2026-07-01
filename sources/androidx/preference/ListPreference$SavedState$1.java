package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class ListPreference$SavedState$1 implements Parcelable$Creator<ListPreference$SavedState> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ListPreference$SavedState createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ListPreference$SavedState[] newArray(int i) {
        return newArray(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public ListPreference$SavedState createFromParcel(Parcel parcel) {
        return new ListPreference$SavedState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public ListPreference$SavedState[] newArray(int i) {
        return new ListPreference$SavedState[i];
    }
}
