package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceGroup$SavedState extends Preference$BaseSavedState {
    public static final Parcelable$Creator<PreferenceGroup$SavedState> CREATOR = new PreferenceGroup$SavedState$1();
    public int mInitialExpandedChildrenCount;

    public PreferenceGroup$SavedState(Parcel parcel) {
        super(parcel);
        this.mInitialExpandedChildrenCount = parcel.readInt();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mInitialExpandedChildrenCount);
    }

    public PreferenceGroup$SavedState(Parcelable parcelable, int i) {
        super(parcelable);
        this.mInitialExpandedChildrenCount = i;
    }
}
