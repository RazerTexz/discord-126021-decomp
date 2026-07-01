package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.util.SparseArray;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout$SavedState extends AbsSavedState {
    public static final Parcelable$Creator<CoordinatorLayout$SavedState> CREATOR = new CoordinatorLayout$SavedState$1();
    public SparseArray<Parcelable> behaviorStates;

    public CoordinatorLayout$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i = parcel.readInt();
        int[] iArr = new int[i];
        parcel.readIntArray(iArr);
        Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
        this.behaviorStates = new SparseArray<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.behaviorStates.append(iArr[i2], parcelableArray[i2]);
        }
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        SparseArray<Parcelable> sparseArray = this.behaviorStates;
        int size = sparseArray != null ? sparseArray.size() : 0;
        parcel.writeInt(size);
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = this.behaviorStates.keyAt(i2);
            parcelableArr[i2] = this.behaviorStates.valueAt(i2);
        }
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i);
    }

    public CoordinatorLayout$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
