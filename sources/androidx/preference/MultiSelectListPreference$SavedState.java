package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MultiSelectListPreference$SavedState extends Preference$BaseSavedState {
    public static final Parcelable$Creator<MultiSelectListPreference$SavedState> CREATOR = new MultiSelectListPreference$SavedState$1();
    public Set<String> mValues;

    public MultiSelectListPreference$SavedState(Parcel parcel) {
        super(parcel);
        int i = parcel.readInt();
        this.mValues = new HashSet();
        String[] strArr = new String[i];
        parcel.readStringArray(strArr);
        Collections.addAll(this.mValues, strArr);
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mValues.size());
        Set<String> set = this.mValues;
        parcel.writeStringArray((String[]) set.toArray(new String[set.size()]));
    }

    public MultiSelectListPreference$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
