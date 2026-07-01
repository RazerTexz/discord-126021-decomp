package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManager$LaunchedFragmentInfo$1 implements Parcelable$Creator<FragmentManager$LaunchedFragmentInfo> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ FragmentManager$LaunchedFragmentInfo createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ FragmentManager$LaunchedFragmentInfo[] newArray(int i) {
        return newArray(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public FragmentManager$LaunchedFragmentInfo createFromParcel(Parcel parcel) {
        return new FragmentManager$LaunchedFragmentInfo(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public FragmentManager$LaunchedFragmentInfo[] newArray(int i) {
        return new FragmentManager$LaunchedFragmentInfo[i];
    }
}
