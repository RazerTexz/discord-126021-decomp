package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class TwoStatePreference$SavedState extends Preference$BaseSavedState {
    public static final Parcelable$Creator<TwoStatePreference$SavedState> CREATOR = new TwoStatePreference$SavedState$1();
    public boolean mChecked;

    public TwoStatePreference$SavedState(Parcel parcel) {
        super(parcel);
        this.mChecked = parcel.readInt() == 1;
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mChecked ? 1 : 0);
    }

    public TwoStatePreference$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
