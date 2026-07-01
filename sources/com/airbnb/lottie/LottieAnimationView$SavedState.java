package com.airbnb.lottie;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView$SavedState extends View$BaseSavedState {
    public static final Parcelable$Creator<LottieAnimationView$SavedState> CREATOR = new LottieAnimationView$SavedState$a();
    public String j;
    public int k;
    public float l;
    public boolean m;
    public String n;
    public int o;
    public int p;

    public LottieAnimationView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    @Override // android.view.View$BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.j);
        parcel.writeFloat(this.l);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeString(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
    }

    public LottieAnimationView$SavedState(Parcel parcel, LottieAnimationView$a lottieAnimationView$a) {
        super(parcel);
        this.j = parcel.readString();
        this.l = parcel.readFloat();
        this.m = parcel.readInt() == 1;
        this.n = parcel.readString();
        this.o = parcel.readInt();
        this.p = parcel.readInt();
    }
}
