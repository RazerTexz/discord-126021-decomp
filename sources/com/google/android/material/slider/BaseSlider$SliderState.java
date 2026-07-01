package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class BaseSlider$SliderState extends View$BaseSavedState {
    public static final Parcelable$Creator<BaseSlider$SliderState> CREATOR = new BaseSlider$SliderState$a();
    public float j;
    public float k;
    public ArrayList<Float> l;
    public float m;
    public boolean n;

    public BaseSlider$SliderState(Parcelable parcelable) {
        super(parcelable);
    }

    @Override // android.view.View$BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.j);
        parcel.writeFloat(this.k);
        parcel.writeList(this.l);
        parcel.writeFloat(this.m);
        parcel.writeBooleanArray(new boolean[]{this.n});
    }

    public BaseSlider$SliderState(Parcel parcel, BaseSlider$a baseSlider$a) {
        super(parcel);
        this.j = parcel.readFloat();
        this.k = parcel.readFloat();
        ArrayList<Float> arrayList = new ArrayList<>();
        this.l = arrayList;
        parcel.readList(arrayList, Float.class.getClassLoader());
        this.m = parcel.readFloat();
        this.n = parcel.createBooleanArray()[0];
    }
}
