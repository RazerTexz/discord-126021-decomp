package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.util.AttributeSet;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public class FlexboxLayout$LayoutParams extends ViewGroup$MarginLayoutParams implements FlexItem {
    public static final Parcelable$Creator<FlexboxLayout$LayoutParams> CREATOR = new FlexboxLayout$LayoutParams$a();
    public int j;
    public float k;
    public float l;
    public int m;
    public float n;
    public int o;
    public int p;
    public int q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2986s;

    public FlexboxLayout$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = 1;
        this.k = 0.0f;
        this.l = 1.0f;
        this.m = -1;
        this.n = -1.0f;
        this.o = -1;
        this.p = -1;
        this.q = ViewCompat.MEASURED_SIZE_MASK;
        this.r = ViewCompat.MEASURED_SIZE_MASK;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$a.FlexboxLayout_Layout);
        this.j = typedArrayObtainStyledAttributes.getInt(R$a.FlexboxLayout_Layout_layout_order, 1);
        this.k = typedArrayObtainStyledAttributes.getFloat(R$a.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
        this.l = typedArrayObtainStyledAttributes.getFloat(R$a.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
        this.m = typedArrayObtainStyledAttributes.getInt(R$a.FlexboxLayout_Layout_layout_alignSelf, -1);
        this.n = typedArrayObtainStyledAttributes.getFraction(R$a.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
        this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$a.FlexboxLayout_Layout_layout_minWidth, -1);
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$a.FlexboxLayout_Layout_layout_minHeight, -1);
        this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$a.FlexboxLayout_Layout_layout_maxWidth, ViewCompat.MEASURED_SIZE_MASK);
        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$a.FlexboxLayout_Layout_layout_maxHeight, ViewCompat.MEASURED_SIZE_MASK);
        this.f2986s = typedArrayObtainStyledAttributes.getBoolean(R$a.FlexboxLayout_Layout_layout_wrapBefore, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.google.android.flexbox.FlexItem
    public int D() {
        return this.o;
    }

    @Override // com.google.android.flexbox.FlexItem
    public void H(int i) {
        this.o = i;
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
        this.p = i;
    }

    @Override // com.google.android.flexbox.FlexItem
    public float S() {
        return this.k;
    }

    @Override // com.google.android.flexbox.FlexItem
    public float W() {
        return this.n;
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
        return this.p;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getHeight() {
        return ((ViewGroup$MarginLayoutParams) this).height;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getOrder() {
        return this.j;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getWidth() {
        return ((ViewGroup$MarginLayoutParams) this).width;
    }

    @Override // com.google.android.flexbox.FlexItem
    public boolean j0() {
        return this.f2986s;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int m0() {
        return this.r;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int t0() {
        return this.q;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int u() {
        return this.m;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j);
        parcel.writeFloat(this.k);
        parcel.writeFloat(this.l);
        parcel.writeInt(this.m);
        parcel.writeFloat(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        parcel.writeInt(this.r);
        parcel.writeByte(this.f2986s ? (byte) 1 : (byte) 0);
        parcel.writeInt(((ViewGroup$MarginLayoutParams) this).bottomMargin);
        parcel.writeInt(((ViewGroup$MarginLayoutParams) this).leftMargin);
        parcel.writeInt(((ViewGroup$MarginLayoutParams) this).rightMargin);
        parcel.writeInt(((ViewGroup$MarginLayoutParams) this).topMargin);
        parcel.writeInt(((ViewGroup$MarginLayoutParams) this).height);
        parcel.writeInt(((ViewGroup$MarginLayoutParams) this).width);
    }

    @Override // com.google.android.flexbox.FlexItem
    public float x() {
        return this.l;
    }

    public FlexboxLayout$LayoutParams(FlexboxLayout$LayoutParams flexboxLayout$LayoutParams) {
        super((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams);
        this.j = 1;
        this.k = 0.0f;
        this.l = 1.0f;
        this.m = -1;
        this.n = -1.0f;
        this.o = -1;
        this.p = -1;
        this.q = ViewCompat.MEASURED_SIZE_MASK;
        this.r = ViewCompat.MEASURED_SIZE_MASK;
        this.j = flexboxLayout$LayoutParams.j;
        this.k = flexboxLayout$LayoutParams.k;
        this.l = flexboxLayout$LayoutParams.l;
        this.m = flexboxLayout$LayoutParams.m;
        this.n = flexboxLayout$LayoutParams.n;
        this.o = flexboxLayout$LayoutParams.o;
        this.p = flexboxLayout$LayoutParams.p;
        this.q = flexboxLayout$LayoutParams.q;
        this.r = flexboxLayout$LayoutParams.r;
        this.f2986s = flexboxLayout$LayoutParams.f2986s;
    }

    public FlexboxLayout$LayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.j = 1;
        this.k = 0.0f;
        this.l = 1.0f;
        this.m = -1;
        this.n = -1.0f;
        this.o = -1;
        this.p = -1;
        this.q = ViewCompat.MEASURED_SIZE_MASK;
        this.r = ViewCompat.MEASURED_SIZE_MASK;
    }

    public FlexboxLayout$LayoutParams(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.j = 1;
        this.k = 0.0f;
        this.l = 1.0f;
        this.m = -1;
        this.n = -1.0f;
        this.o = -1;
        this.p = -1;
        this.q = ViewCompat.MEASURED_SIZE_MASK;
        this.r = ViewCompat.MEASURED_SIZE_MASK;
    }

    public FlexboxLayout$LayoutParams(Parcel parcel) {
        super(0, 0);
        this.j = 1;
        this.k = 0.0f;
        this.l = 1.0f;
        this.m = -1;
        this.n = -1.0f;
        this.o = -1;
        this.p = -1;
        this.q = ViewCompat.MEASURED_SIZE_MASK;
        this.r = ViewCompat.MEASURED_SIZE_MASK;
        this.j = parcel.readInt();
        this.k = parcel.readFloat();
        this.l = parcel.readFloat();
        this.m = parcel.readInt();
        this.n = parcel.readFloat();
        this.o = parcel.readInt();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.r = parcel.readInt();
        this.f2986s = parcel.readByte() != 0;
        ((ViewGroup$MarginLayoutParams) this).bottomMargin = parcel.readInt();
        ((ViewGroup$MarginLayoutParams) this).leftMargin = parcel.readInt();
        ((ViewGroup$MarginLayoutParams) this).rightMargin = parcel.readInt();
        ((ViewGroup$MarginLayoutParams) this).topMargin = parcel.readInt();
        ((ViewGroup$MarginLayoutParams) this).height = parcel.readInt();
        ((ViewGroup$MarginLayoutParams) this).width = parcel.readInt();
    }
}
