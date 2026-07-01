package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner$SavedState extends View$BaseSavedState {
    public static final Parcelable$Creator<AppCompatSpinner$SavedState> CREATOR = new AppCompatSpinner$SavedState$1();
    public boolean mShowDropdown;

    public AppCompatSpinner$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    @Override // android.view.View$BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.mShowDropdown ? (byte) 1 : (byte) 0);
    }

    public AppCompatSpinner$SavedState(Parcel parcel) {
        super(parcel);
        this.mShowDropdown = parcel.readByte() != 0;
    }
}
