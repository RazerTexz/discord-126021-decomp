package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import androidx.annotation.NonNull;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTabHost$SavedState extends View$BaseSavedState {
    public static final Parcelable$Creator<FragmentTabHost$SavedState> CREATOR = new FragmentTabHost$SavedState$1();
    public String curTab;

    public FragmentTabHost$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    @NonNull
    public String toString() {
        StringBuilder sbU = a.U("FragmentTabHost.SavedState{");
        sbU.append(Integer.toHexString(System.identityHashCode(this)));
        sbU.append(" curTab=");
        return a.J(sbU, this.curTab, "}");
    }

    @Override // android.view.View$BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.curTab);
    }

    public FragmentTabHost$SavedState(Parcel parcel) {
        super(parcel);
        this.curTab = parcel.readString();
    }
}
