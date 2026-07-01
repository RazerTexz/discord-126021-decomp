package com.google.android.flexbox;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.util.AttributeSet;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;

/* JADX INFO: loaded from: classes3.dex */
public class FlexboxLayoutManager$LayoutParams extends RecyclerView$LayoutParams implements FlexItem {
    public static final Parcelable$Creator<FlexboxLayoutManager$LayoutParams> CREATOR = new FlexboxLayoutManager$LayoutParams$a();
    public float j;
    public float k;
    public int l;
    public float m;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;

    public FlexboxLayoutManager$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = 0.0f;
        this.k = 1.0f;
        this.l = -1;
        this.m = -1.0f;
        this.p = ViewCompat.MEASURED_SIZE_MASK;
        this.q = ViewCompat.MEASURED_SIZE_MASK;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int D() {
        return this.n;
    }

    @Override // com.google.android.flexbox.FlexItem
    public void H(int i) {
        this.n = i;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int I() {
        return ((ViewGroup$MarginLayoutParams) this).bottomMargin;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int J() {
        return ((ViewGroup$MarginLayoutParams) this).leftMargin;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int N() {
        return ((ViewGroup$MarginLayoutParams) this).topMargin;
    }

    @Override // com.google.android.flexbox.FlexItem
    public void O(int i) {
        this.o = i;
    }

    @Override // com.google.android.flexbox.FlexItem
    public float S() {
        return this.j;
    }

    @Override // com.google.android.flexbox.FlexItem
    public float W() {
        return this.m;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int d0() {
        return ((ViewGroup$MarginLayoutParams) this).rightMargin;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int f0() {
        return this.o;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getHeight() {
        return ((ViewGroup$MarginLayoutParams) this).height;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getOrder() {
        return 1;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getWidth() {
        return ((ViewGroup$MarginLayoutParams) this).width;
    }

    @Override // com.google.android.flexbox.FlexItem
    public boolean j0() {
        return this.r;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int m0() {
        return this.q;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int t0() {
        return this.p;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int u() {
        return this.l;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.j);
        parcel.writeFloat(this.k);
        parcel.writeInt(this.l);
        parcel.writeFloat(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        parcel.writeByte(this.r ? (byte) 1 : (byte) 0);
        parcel.writeInt(((ViewGroup$MarginLayoutParams) this).bottomMargin);
        parcel.writeInt(((ViewGroup$MarginLayoutParams) this).leftMargin);
        parcel.writeInt(((ViewGroup$MarginLayoutParams) this).rightMargin);
        parcel.writeInt(((ViewGroup$MarginLayoutParams) this).topMargin);
        parcel.writeInt(((ViewGroup$MarginLayoutParams) this).height);
        parcel.writeInt(((ViewGroup$MarginLayoutParams) this).width);
    }

    @Override // com.google.android.flexbox.FlexItem
    public float x() {
        return this.k;
    }

    public FlexboxLayoutManager$LayoutParams(int i, int i2) {
        super(i, i2);
        this.j = 0.0f;
        this.k = 1.0f;
        this.l = -1;
        this.m = -1.0f;
        this.p = ViewCompat.MEASURED_SIZE_MASK;
        this.q = ViewCompat.MEASURED_SIZE_MASK;
    }

    public FlexboxLayoutManager$LayoutParams(Parcel parcel) {
        super(-2, -2);
        this.j = 0.0f;
        this.k = 1.0f;
        this.l = -1;
        this.m = -1.0f;
        this.p = ViewCompat.MEASURED_SIZE_MASK;
        this.q = ViewCompat.MEASURED_SIZE_MASK;
        this.j = parcel.readFloat();
        this.k = parcel.readFloat();
        this.l = parcel.readInt();
        this.m = parcel.readFloat();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.r = parcel.readByte() != 0;
        ((ViewGroup$MarginLayoutParams) this).bottomMargin = parcel.readInt();
        ((ViewGroup$MarginLayoutParams) this).leftMargin = parcel.readInt();
        ((ViewGroup$MarginLayoutParams) this).rightMargin = parcel.readInt();
        ((ViewGroup$MarginLayoutParams) this).topMargin = parcel.readInt();
        ((ViewGroup$MarginLayoutParams) this).height = parcel.readInt();
        ((ViewGroup$MarginLayoutParams) this).width = parcel.readInt();
    }
}
