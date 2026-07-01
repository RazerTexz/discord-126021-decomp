package androidx.viewpager2.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager2$SavedState extends View$BaseSavedState {
    public static final Parcelable$Creator<ViewPager2$SavedState> CREATOR = new ViewPager2$SavedState$1();
    public Parcelable mAdapterState;
    public int mCurrentItem;
    public int mRecyclerViewId;

    @RequiresApi(24)
    public ViewPager2$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        readValues(parcel, classLoader);
    }

    private void readValues(Parcel parcel, ClassLoader classLoader) {
        this.mRecyclerViewId = parcel.readInt();
        this.mCurrentItem = parcel.readInt();
        this.mAdapterState = parcel.readParcelable(classLoader);
    }

    @Override // android.view.View$BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mRecyclerViewId);
        parcel.writeInt(this.mCurrentItem);
        parcel.writeParcelable(this.mAdapterState, i);
    }

    public ViewPager2$SavedState(Parcel parcel) {
        super(parcel);
        readValues(parcel, null);
    }

    public ViewPager2$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
