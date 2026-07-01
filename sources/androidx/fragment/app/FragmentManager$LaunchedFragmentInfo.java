package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class FragmentManager$LaunchedFragmentInfo implements Parcelable {
    public static final Parcelable$Creator<FragmentManager$LaunchedFragmentInfo> CREATOR = new FragmentManager$LaunchedFragmentInfo$1();
    public int mRequestCode;
    public String mWho;

    public FragmentManager$LaunchedFragmentInfo(@NonNull String str, int i) {
        this.mWho = str;
        this.mRequestCode = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mWho);
        parcel.writeInt(this.mRequestCode);
    }

    public FragmentManager$LaunchedFragmentInfo(@NonNull Parcel parcel) {
        this.mWho = parcel.readString();
        this.mRequestCode = parcel.readInt();
    }
}
