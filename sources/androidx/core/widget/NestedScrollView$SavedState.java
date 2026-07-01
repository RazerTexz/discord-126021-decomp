package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import androidx.annotation.NonNull;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView$SavedState extends View$BaseSavedState {
    public static final Parcelable$Creator<NestedScrollView$SavedState> CREATOR = new NestedScrollView$SavedState$1();
    public int scrollPosition;

    public NestedScrollView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    @NonNull
    public String toString() {
        StringBuilder sbU = a.U("HorizontalScrollView.SavedState{");
        sbU.append(Integer.toHexString(System.identityHashCode(this)));
        sbU.append(" scrollPosition=");
        return a.B(sbU, this.scrollPosition, "}");
    }

    @Override // android.view.View$BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.scrollPosition);
    }

    public NestedScrollView$SavedState(Parcel parcel) {
        super(parcel);
        this.scrollPosition = parcel.readInt();
    }
}
