package com.google.android.material.bottomsheet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior$SavedState extends AbsSavedState {
    public static final Parcelable$Creator<BottomSheetBehavior$SavedState> CREATOR = new BottomSheetBehavior$SavedState$a();
    public boolean fitToContents;
    public boolean hideable;
    public int peekHeight;
    public boolean skipCollapsed;
    public final int state;

    public BottomSheetBehavior$SavedState(@NonNull Parcel parcel) {
        this(parcel, (ClassLoader) null);
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.state);
        parcel.writeInt(this.peekHeight);
        parcel.writeInt(this.fitToContents ? 1 : 0);
        parcel.writeInt(this.hideable ? 1 : 0);
        parcel.writeInt(this.skipCollapsed ? 1 : 0);
    }

    public BottomSheetBehavior$SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.state = parcel.readInt();
        this.peekHeight = parcel.readInt();
        this.fitToContents = parcel.readInt() == 1;
        this.hideable = parcel.readInt() == 1;
        this.skipCollapsed = parcel.readInt() == 1;
    }

    public BottomSheetBehavior$SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
        super(parcelable);
        this.state = bottomSheetBehavior.state;
        this.peekHeight = BottomSheetBehavior.access$600(bottomSheetBehavior);
        this.fitToContents = BottomSheetBehavior.access$500(bottomSheetBehavior);
        this.hideable = bottomSheetBehavior.hideable;
        this.skipCollapsed = BottomSheetBehavior.access$700(bottomSheetBehavior);
    }

    @Deprecated
    public BottomSheetBehavior$SavedState(Parcelable parcelable, int i) {
        super(parcelable);
        this.state = i;
    }
}
