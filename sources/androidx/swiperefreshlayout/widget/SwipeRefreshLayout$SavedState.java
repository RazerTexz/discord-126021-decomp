package androidx.swiperefreshlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout$SavedState extends View$BaseSavedState {
    public static final Parcelable$Creator<SwipeRefreshLayout$SavedState> CREATOR = new SwipeRefreshLayout$SavedState$1();
    public final boolean mRefreshing;

    public SwipeRefreshLayout$SavedState(Parcelable parcelable, boolean z2) {
        super(parcelable);
        this.mRefreshing = z2;
    }

    @Override // android.view.View$BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.mRefreshing ? (byte) 1 : (byte) 0);
    }

    public SwipeRefreshLayout$SavedState(Parcel parcel) {
        super(parcel);
        this.mRefreshing = parcel.readByte() != 0;
    }
}
