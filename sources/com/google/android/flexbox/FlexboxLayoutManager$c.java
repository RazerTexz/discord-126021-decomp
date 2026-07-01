package com.google.android.flexbox;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class FlexboxLayoutManager$c {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2992b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h = 1;
    public int i = 1;
    public boolean j;

    public FlexboxLayoutManager$c(FlexboxLayoutManager$a flexboxLayoutManager$a) {
    }

    public String toString() {
        StringBuilder sbU = a.U("LayoutState{mAvailable=");
        sbU.append(this.a);
        sbU.append(", mFlexLinePosition=");
        sbU.append(this.c);
        sbU.append(", mPosition=");
        sbU.append(this.d);
        sbU.append(", mOffset=");
        sbU.append(this.e);
        sbU.append(", mScrollingOffset=");
        sbU.append(this.f);
        sbU.append(", mLastScrollDelta=");
        sbU.append(this.g);
        sbU.append(", mItemDirection=");
        sbU.append(this.h);
        sbU.append(", mLayoutDirection=");
        return a.A(sbU, this.i, '}');
    }
}
