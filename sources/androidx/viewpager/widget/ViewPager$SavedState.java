package androidx.viewpager.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import androidx.customview.view.AbsSavedState;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager$SavedState extends AbsSavedState {
    public static final Parcelable$Creator<ViewPager$SavedState> CREATOR = new ViewPager$SavedState$1();
    public Parcelable adapterState;
    public ClassLoader loader;
    public int position;

    public ViewPager$SavedState(@NonNull Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        StringBuilder sbU = a.U("FragmentPager.SavedState{");
        sbU.append(Integer.toHexString(System.identityHashCode(this)));
        sbU.append(" position=");
        return a.B(sbU, this.position, "}");
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.position);
        parcel.writeParcelable(this.adapterState, i);
    }

    public ViewPager$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
        this.position = parcel.readInt();
        this.adapterState = parcel.readParcelable(classLoader);
        this.loader = classLoader;
    }
}
