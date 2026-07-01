package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ListPreference$SavedState extends Preference$BaseSavedState {
    public static final Parcelable$Creator<ListPreference$SavedState> CREATOR = new ListPreference$SavedState$1();
    public String mValue;

    public ListPreference$SavedState(Parcel parcel) {
        super(parcel);
        this.mValue = parcel.readString();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mValue);
    }

    public ListPreference$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
