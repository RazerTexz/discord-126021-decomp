package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
public class Preference$BaseSavedState extends AbsSavedState {
    public static final Parcelable$Creator<Preference$BaseSavedState> CREATOR = new Preference$BaseSavedState$1();

    public Preference$BaseSavedState(Parcel parcel) {
        super(parcel);
    }

    public Preference$BaseSavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
