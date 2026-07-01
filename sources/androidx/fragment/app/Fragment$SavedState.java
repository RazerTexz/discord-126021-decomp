package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
public class Fragment$SavedState implements Parcelable {

    @NonNull
    public static final Parcelable$Creator<Fragment$SavedState> CREATOR = new Fragment$SavedState$1();
    public final Bundle mState;

    public Fragment$SavedState(Bundle bundle) {
        this.mState = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeBundle(this.mState);
    }

    public Fragment$SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
        Bundle bundle = parcel.readBundle();
        this.mState = bundle;
        if (classLoader == null || bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
    }
}
