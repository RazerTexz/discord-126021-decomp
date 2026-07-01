package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY})
public class RecyclerView$SavedState extends AbsSavedState {
    public static final Parcelable$Creator<RecyclerView$SavedState> CREATOR = new RecyclerView$SavedState$1();
    public Parcelable mLayoutState;

    public RecyclerView$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.mLayoutState = parcel.readParcelable(classLoader == null ? RecyclerView$LayoutManager.class.getClassLoader() : classLoader);
    }

    public void copyFrom(RecyclerView$SavedState recyclerView$SavedState) {
        this.mLayoutState = recyclerView$SavedState.mLayoutState;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mLayoutState, 0);
    }

    public RecyclerView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
