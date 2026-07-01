package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference$SavedState extends Preference$BaseSavedState {
    public static final Parcelable$Creator<SeekBarPreference$SavedState> CREATOR = new SeekBarPreference$SavedState$1();
    public int mMax;
    public int mMin;
    public int mSeekBarValue;

    public SeekBarPreference$SavedState(Parcel parcel) {
        super(parcel);
        this.mSeekBarValue = parcel.readInt();
        this.mMin = parcel.readInt();
        this.mMax = parcel.readInt();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mSeekBarValue);
        parcel.writeInt(this.mMin);
        parcel.writeInt(this.mMax);
    }

    public SeekBarPreference$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
