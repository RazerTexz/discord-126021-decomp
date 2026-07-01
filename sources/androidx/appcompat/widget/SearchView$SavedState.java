package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.customview.view.AbsSavedState;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class SearchView$SavedState extends AbsSavedState {
    public static final Parcelable$Creator<SearchView$SavedState> CREATOR = new SearchView$SavedState$1();
    public boolean isIconified;

    public SearchView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        StringBuilder sbU = a.U("SearchView.SavedState{");
        sbU.append(Integer.toHexString(System.identityHashCode(this)));
        sbU.append(" isIconified=");
        return a.O(sbU, this.isIconified, "}");
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(Boolean.valueOf(this.isIconified));
    }

    public SearchView$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.isIconified = ((Boolean) parcel.readValue(null)).booleanValue();
    }
}
