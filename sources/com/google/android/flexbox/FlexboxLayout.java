package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.d.b.a.outline;
import b.i.a.e.FlexContainer;
import b.i.a.e.FlexLine;
import b.i.a.e.FlexboxHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FlexboxLayout extends ViewGroup implements FlexContainer {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    @Nullable
    public Drawable p;

    @Nullable
    public Drawable q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f2982s;
    public int t;
    public int u;
    public int[] v;
    public SparseIntArray w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public FlexboxHelper f2983x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List<FlexLine> f2984y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public FlexboxHelper.b f2985z;

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.o = -1;
        this.f2983x = new FlexboxHelper(this);
        this.f2984y = new ArrayList();
        this.f2985z = new FlexboxHelper.b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.FlexboxLayout, 0, 0);
        this.j = typedArrayObtainStyledAttributes.getInt(R.a.FlexboxLayout_flexDirection, 0);
        this.k = typedArrayObtainStyledAttributes.getInt(R.a.FlexboxLayout_flexWrap, 0);
        this.l = typedArrayObtainStyledAttributes.getInt(R.a.FlexboxLayout_justifyContent, 0);
        this.m = typedArrayObtainStyledAttributes.getInt(R.a.FlexboxLayout_alignItems, 0);
        this.n = typedArrayObtainStyledAttributes.getInt(R.a.FlexboxLayout_alignContent, 0);
        this.o = typedArrayObtainStyledAttributes.getInt(R.a.FlexboxLayout_maxLine, -1);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.a.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R.a.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(R.a.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i = typedArrayObtainStyledAttributes.getInt(R.a.FlexboxLayout_showDivider, 0);
        if (i != 0) {
            this.f2982s = i;
            this.r = i;
        }
        int i2 = typedArrayObtainStyledAttributes.getInt(R.a.FlexboxLayout_showDividerVertical, 0);
        if (i2 != 0) {
            this.f2982s = i2;
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(R.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i3 != 0) {
            this.r = i3;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // b.i.a.e.FlexContainer
    public void a(View view, int i, int i2, FlexLine flexLine) {
        if (p(i, i2)) {
            if (i()) {
                int i3 = flexLine.e;
                int i4 = this.u;
                flexLine.e = i3 + i4;
                flexLine.f += i4;
                return;
            }
            int i5 = flexLine.e;
            int i6 = this.t;
            flexLine.e = i5 + i6;
            flexLine.f += i6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.w == null) {
            this.w = new SparseIntArray(getChildCount());
        }
        FlexboxHelper flexboxHelper = this.f2983x;
        SparseIntArray sparseIntArray = this.w;
        int flexItemCount = flexboxHelper.a.getFlexItemCount();
        List<FlexboxHelper.c> listF = flexboxHelper.f(flexItemCount);
        FlexboxHelper.c cVar = new FlexboxHelper.c(null);
        if (view == null || !(layoutParams instanceof FlexItem)) {
            cVar.k = 1;
        } else {
            cVar.k = ((FlexItem) layoutParams).getOrder();
        }
        if (i == -1 || i == flexItemCount || i >= flexboxHelper.a.getFlexItemCount()) {
            cVar.j = flexItemCount;
        } else {
            cVar.j = i;
            for (int i2 = i; i2 < flexItemCount; i2++) {
                ((FlexboxHelper.c) ((ArrayList) listF).get(i2)).j++;
            }
        }
        ((ArrayList) listF).add(cVar);
        this.v = flexboxHelper.x(flexItemCount + 1, listF, sparseIntArray);
        super.addView(view, i, layoutParams);
    }

    @Override // b.i.a.e.FlexContainer
    public void b(FlexLine flexLine) {
        if (i()) {
            if ((this.f2982s & 4) > 0) {
                int i = flexLine.e;
                int i2 = this.u;
                flexLine.e = i + i2;
                flexLine.f += i2;
                return;
            }
            return;
        }
        if ((this.r & 4) > 0) {
            int i3 = flexLine.e;
            int i4 = this.t;
            flexLine.e = i3 + i4;
            flexLine.f += i4;
        }
    }

    @Override // b.i.a.e.FlexContainer
    public View c(int i) {
        return o(i);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // b.i.a.e.FlexContainer
    public int d(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // b.i.a.e.FlexContainer
    public void e(int i, View view) {
    }

    @Override // b.i.a.e.FlexContainer
    public View f(int i) {
        return getChildAt(i);
    }

    @Override // b.i.a.e.FlexContainer
    public int g(View view, int i, int i2) {
        int i3;
        int i4;
        if (i()) {
            i3 = p(i, i2) ? 0 + this.u : 0;
            if ((this.f2982s & 4) <= 0) {
                return i3;
            }
            i4 = this.u;
        } else {
            i3 = p(i, i2) ? 0 + this.t : 0;
            if ((this.r & 4) <= 0) {
                return i3;
            }
            i4 = this.t;
        }
        return i3 + i4;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // b.i.a.e.FlexContainer
    public int getAlignContent() {
        return this.n;
    }

    @Override // b.i.a.e.FlexContainer
    public int getAlignItems() {
        return this.m;
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.p;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.q;
    }

    @Override // b.i.a.e.FlexContainer
    public int getFlexDirection() {
        return this.j;
    }

    @Override // b.i.a.e.FlexContainer
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<FlexLine> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f2984y.size());
        for (FlexLine flexLine : this.f2984y) {
            if (flexLine.a() != 0) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @Override // b.i.a.e.FlexContainer
    public List<FlexLine> getFlexLinesInternal() {
        return this.f2984y;
    }

    @Override // b.i.a.e.FlexContainer
    public int getFlexWrap() {
        return this.k;
    }

    public int getJustifyContent() {
        return this.l;
    }

    @Override // b.i.a.e.FlexContainer
    public int getLargestMainSize() {
        Iterator<FlexLine> it = this.f2984y.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().e);
        }
        return iMax;
    }

    @Override // b.i.a.e.FlexContainer
    public int getMaxLine() {
        return this.o;
    }

    public int getShowDividerHorizontal() {
        return this.r;
    }

    public int getShowDividerVertical() {
        return this.f2982s;
    }

    @Override // b.i.a.e.FlexContainer
    public int getSumOfCrossSize() {
        int size = this.f2984y.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            FlexLine flexLine = this.f2984y.get(i2);
            if (q(i2)) {
                i += i() ? this.t : this.u;
            }
            if (r(i2)) {
                i += i() ? this.t : this.u;
            }
            i += flexLine.g;
        }
        return i;
    }

    @Override // b.i.a.e.FlexContainer
    public int h(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // b.i.a.e.FlexContainer
    public boolean i() {
        int i = this.j;
        return i == 0 || i == 1;
    }

    @Override // b.i.a.e.FlexContainer
    public int j(View view) {
        return 0;
    }

    public final void k(Canvas canvas, boolean z2, boolean z3) {
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.f2984y.size();
        for (int i = 0; i < size; i++) {
            FlexLine flexLine = this.f2984y.get(i);
            for (int i2 = 0; i2 < flexLine.h; i2++) {
                int i3 = flexLine.o + i2;
                View viewO = o(i3);
                if (viewO != null && viewO.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) viewO.getLayoutParams();
                    if (p(i3, i2)) {
                        n(canvas, z2 ? viewO.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : (viewO.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.u, flexLine.f1327b, flexLine.g);
                    }
                    if (i2 == flexLine.h - 1 && (this.f2982s & 4) > 0) {
                        n(canvas, z2 ? (viewO.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.u : viewO.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, flexLine.f1327b, flexLine.g);
                    }
                }
            }
            if (q(i)) {
                m(canvas, paddingLeft, z3 ? flexLine.d : flexLine.f1327b - this.t, iMax);
            }
            if (r(i) && (this.r & 4) > 0) {
                m(canvas, paddingLeft, z3 ? flexLine.f1327b - this.t : flexLine.d, iMax);
            }
        }
    }

    public final void l(Canvas canvas, boolean z2, boolean z3) {
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.f2984y.size();
        for (int i = 0; i < size; i++) {
            FlexLine flexLine = this.f2984y.get(i);
            for (int i2 = 0; i2 < flexLine.h; i2++) {
                int i3 = flexLine.o + i2;
                View viewO = o(i3);
                if (viewO != null && viewO.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) viewO.getLayoutParams();
                    if (p(i3, i2)) {
                        m(canvas, flexLine.a, z3 ? viewO.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : (viewO.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.t, flexLine.g);
                    }
                    if (i2 == flexLine.h - 1 && (this.r & 4) > 0) {
                        m(canvas, flexLine.a, z3 ? (viewO.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.t : viewO.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, flexLine.g);
                    }
                }
            }
            if (q(i)) {
                n(canvas, z2 ? flexLine.c : flexLine.a - this.u, paddingTop, iMax);
            }
            if (r(i) && (this.f2982s & 4) > 0) {
                n(canvas, z2 ? flexLine.a - this.u : flexLine.c, paddingTop, iMax);
            }
        }
    }

    public final void m(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.p;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.t + i2);
        this.p.draw(canvas);
    }

    public final void n(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.q;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.u + i, i3 + i2);
        this.q.draw(canvas);
    }

    public View o(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.v;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.q == null && this.p == null) {
            return;
        }
        if (this.r == 0 && this.f2982s == 0) {
            return;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i = this.j;
        if (i == 0) {
            k(canvas, layoutDirection == 1, this.k == 2);
            return;
        }
        if (i == 1) {
            k(canvas, layoutDirection != 1, this.k == 2);
            return;
        }
        if (i == 2) {
            boolean z2 = layoutDirection == 1;
            if (this.k == 2) {
                z2 = !z2;
            }
            l(canvas, z2, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z3 = layoutDirection == 1;
        if (this.k == 2) {
            z3 = !z3;
        }
        l(canvas, z3, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i5 = this.j;
        if (i5 == 0) {
            s(layoutDirection == 1, i, i2, i3, i4);
            return;
        }
        if (i5 == 1) {
            s(layoutDirection != 1, i, i2, i3, i4);
            return;
        }
        if (i5 == 2) {
            z3 = layoutDirection == 1;
            if (this.k == 2) {
                z3 = !z3;
            }
            t(z3, false, i, i2, i3, i4);
            return;
        }
        if (i5 != 3) {
            StringBuilder sbU = outline.U("Invalid flex direction is set: ");
            sbU.append(this.j);
            throw new IllegalStateException(sbU.toString());
        }
        z3 = layoutDirection == 1;
        if (this.k == 2) {
            z3 = !z3;
        }
        t(z3, true, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        boolean z2;
        if (this.w == null) {
            this.w = new SparseIntArray(getChildCount());
        }
        FlexboxHelper flexboxHelper = this.f2983x;
        SparseIntArray sparseIntArray = this.w;
        int flexItemCount = flexboxHelper.a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            z2 = true;
            break;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= flexItemCount) {
                z2 = false;
                break;
            }
            View viewF = flexboxHelper.a.f(i3);
            if (viewF != null && ((FlexItem) viewF.getLayoutParams()).getOrder() != sparseIntArray.get(i3)) {
                z2 = true;
                break;
            }
            i3++;
        }
        if (z2) {
            FlexboxHelper flexboxHelper2 = this.f2983x;
            SparseIntArray sparseIntArray2 = this.w;
            int flexItemCount2 = flexboxHelper2.a.getFlexItemCount();
            this.v = flexboxHelper2.x(flexItemCount2, flexboxHelper2.f(flexItemCount2), sparseIntArray2);
        }
        int i4 = this.j;
        if (i4 != 0 && i4 != 1) {
            if (i4 != 2 && i4 != 3) {
                StringBuilder sbU = outline.U("Invalid value for the flex direction is set: ");
                sbU.append(this.j);
                throw new IllegalStateException(sbU.toString());
            }
            this.f2984y.clear();
            this.f2985z.a();
            this.f2983x.b(this.f2985z, i2, i, Integer.MAX_VALUE, 0, -1, null);
            this.f2984y = this.f2985z.a;
            this.f2983x.h(i, i2, 0);
            this.f2983x.g(i, i2, getPaddingRight() + getPaddingLeft());
            this.f2983x.A(0);
            u(this.j, i, i2, this.f2985z.f1329b);
            return;
        }
        this.f2984y.clear();
        this.f2985z.a();
        this.f2983x.b(this.f2985z, i, i2, Integer.MAX_VALUE, 0, -1, null);
        this.f2984y = this.f2985z.a;
        this.f2983x.h(i, i2, 0);
        if (this.m == 3) {
            for (FlexLine flexLine : this.f2984y) {
                int iMax = Integer.MIN_VALUE;
                for (int i5 = 0; i5 < flexLine.h; i5++) {
                    View viewO = o(flexLine.o + i5);
                    if (viewO != null && viewO.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) viewO.getLayoutParams();
                        iMax = this.k != 2 ? Math.max(iMax, viewO.getMeasuredHeight() + Math.max(flexLine.l - viewO.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : Math.max(iMax, viewO.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max(viewO.getBaseline() + (flexLine.l - viewO.getMeasuredHeight()), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                    }
                }
                flexLine.g = iMax;
            }
        }
        this.f2983x.g(i, i2, getPaddingBottom() + getPaddingTop());
        this.f2983x.A(0);
        u(this.j, i, i2, this.f2985z.f1329b);
    }

    public final boolean p(int i, int i2) {
        boolean z2;
        int i3 = 1;
        while (true) {
            if (i3 > i2) {
                z2 = true;
                break;
            }
            View viewO = o(i - i3);
            if (viewO != null && viewO.getVisibility() != 8) {
                z2 = false;
                break;
            }
            i3++;
        }
        if (z2) {
            if (i()) {
                return (this.f2982s & 1) != 0;
            }
            return (this.r & 1) != 0;
        }
        if (i()) {
            return (this.f2982s & 2) != 0;
        }
        return (this.r & 2) != 0;
    }

    public final boolean q(int i) {
        boolean z2;
        if (i < 0 || i >= this.f2984y.size()) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z2 = true;
                break;
            }
            if (this.f2984y.get(i2).a() > 0) {
                z2 = false;
                break;
            }
            i2++;
        }
        if (z2) {
            if (i()) {
                return (this.r & 1) != 0;
            }
            return (this.f2982s & 1) != 0;
        }
        if (i()) {
            return (this.r & 2) != 0;
        }
        return (this.f2982s & 2) != 0;
    }

    public final boolean r(int i) {
        if (i < 0 || i >= this.f2984y.size()) {
            return false;
        }
        for (int i2 = i + 1; i2 < this.f2984y.size(); i2++) {
            if (this.f2984y.get(i2).a() > 0) {
                return false;
            }
        }
        if (i()) {
            return (this.r & 4) != 0;
        }
        return (this.f2982s & 4) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:70:0x01f2  */
    public final void s(boolean z2, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        int i5;
        View viewO;
        int i6;
        int i7;
        float f4;
        float f5;
        int i8;
        LayoutParams layoutParams;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i9 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.f2984y.size();
        int i10 = 0;
        while (i10 < size) {
            FlexLine flexLine = this.f2984y.get(i10);
            if (q(i10)) {
                int i11 = this.t;
                paddingBottom -= i11;
                paddingTop += i11;
            }
            int i12 = this.l;
            int i13 = 1;
            if (i12 == 0) {
                f = paddingLeft;
                f2 = i9 - paddingRight;
            } else if (i12 != 1) {
                if (i12 == 2) {
                    int i14 = flexLine.e;
                    f2 = (i9 - paddingRight) - ((i9 - i14) / 2.0f);
                    f = ((i9 - i14) / 2.0f) + paddingLeft;
                } else if (i12 == 3) {
                    f = paddingLeft;
                    int iA = flexLine.a();
                    f3 = (i9 - flexLine.e) / (iA != 1 ? iA - 1 : 1.0f);
                    f2 = i9 - paddingRight;
                } else if (i12 == 4) {
                    int iA2 = flexLine.a();
                    f3 = iA2 != 0 ? (i9 - flexLine.e) / iA2 : 0.0f;
                    float f6 = f3 / 2.0f;
                    f = paddingLeft + f6;
                    f2 = (i9 - paddingRight) - f6;
                } else {
                    if (i12 != 5) {
                        StringBuilder sbU = outline.U("Invalid justifyContent is set: ");
                        sbU.append(this.l);
                        throw new IllegalStateException(sbU.toString());
                    }
                    int iA3 = flexLine.a();
                    f3 = iA3 != 0 ? (i9 - flexLine.e) / (iA3 + 1) : 0.0f;
                    f = paddingLeft + f3;
                    f2 = (i9 - paddingRight) - f3;
                }
                float fMax = Math.max(f3, 0.0f);
                i5 = 0;
                while (i5 < flexLine.h) {
                    int i15 = flexLine.o + i5;
                    viewO = o(i15);
                    if (viewO != null || viewO.getVisibility() == 8) {
                        i6 = paddingLeft;
                        i7 = i5;
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) viewO.getLayoutParams();
                        float f7 = f + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                        float f8 = f2 - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                        if (p(i15, i5)) {
                            int i16 = this.u;
                            float f9 = i16;
                            f4 = f7 + f9;
                            i8 = i16;
                            f5 = f8 - f9;
                        } else {
                            f4 = f7;
                            f5 = f8;
                            i8 = 0;
                        }
                        int i17 = (i5 != flexLine.h - i13 || (this.f2982s & 4) <= 0) ? 0 : this.u;
                        if (this.k != 2) {
                            i6 = paddingLeft;
                            layoutParams = layoutParams2;
                            i7 = i5;
                            if (z2) {
                                this.f2983x.u(viewO, flexLine, Math.round(f5) - viewO.getMeasuredWidth(), paddingTop, Math.round(f5), viewO.getMeasuredHeight() + paddingTop);
                            } else {
                                this.f2983x.u(viewO, flexLine, Math.round(f4), paddingTop, viewO.getMeasuredWidth() + Math.round(f4), viewO.getMeasuredHeight() + paddingTop);
                            }
                        } else if (z2) {
                            i6 = paddingLeft;
                            layoutParams = layoutParams2;
                            i7 = i5;
                            this.f2983x.u(viewO, flexLine, Math.round(f5) - viewO.getMeasuredWidth(), paddingBottom - viewO.getMeasuredHeight(), Math.round(f5), paddingBottom);
                        } else {
                            i6 = paddingLeft;
                            layoutParams = layoutParams2;
                            i7 = i5;
                            this.f2983x.u(viewO, flexLine, Math.round(f4), paddingBottom - viewO.getMeasuredHeight(), viewO.getMeasuredWidth() + Math.round(f4), paddingBottom);
                        }
                        float measuredWidth = viewO.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + f4;
                        float measuredWidth2 = f5 - ((viewO.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
                        if (z2) {
                            flexLine.b(viewO, i17, 0, i8, 0);
                        } else {
                            flexLine.b(viewO, i8, 0, i17, 0);
                        }
                        f = measuredWidth;
                        f2 = measuredWidth2;
                    }
                    i5 = i7 + 1;
                    i13 = 1;
                    paddingLeft = i6;
                }
                int i18 = paddingLeft;
                int i19 = flexLine.g;
                paddingTop += i19;
                paddingBottom -= i19;
                i10++;
                paddingLeft = i18;
            } else {
                int i20 = flexLine.e;
                f2 = i20 - paddingLeft;
                f = (i9 - i20) + paddingRight;
            }
            f3 = 0.0f;
            float fMax2 = Math.max(f3, 0.0f);
            i5 = 0;
            while (i5 < flexLine.h) {
                int i110 = flexLine.o + i5;
                viewO = o(i110);
                if (viewO != null) {
                    i6 = paddingLeft;
                    i7 = i5;
                } else {
                    i6 = paddingLeft;
                    i7 = i5;
                }
                i5 = i7 + 1;
                i13 = 1;
                paddingLeft = i6;
            }
            int i111 = paddingLeft;
            int i112 = flexLine.g;
            paddingTop += i112;
            paddingBottom -= i112;
            i10++;
            paddingLeft = i111;
        }
    }

    public void setAlignContent(int i) {
        if (this.n != i) {
            this.n = i;
            requestLayout();
        }
    }

    public void setAlignItems(int i) {
        if (this.m != i) {
            this.m = i;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable == this.p) {
            return;
        }
        this.p = drawable;
        if (drawable != null) {
            this.t = drawable.getIntrinsicHeight();
        } else {
            this.t = 0;
        }
        if (this.p == null && this.q == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
        requestLayout();
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable == this.q) {
            return;
        }
        this.q = drawable;
        if (drawable != null) {
            this.u = drawable.getIntrinsicWidth();
        } else {
            this.u = 0;
        }
        if (this.p == null && this.q == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
        requestLayout();
    }

    public void setFlexDirection(int i) {
        if (this.j != i) {
            this.j = i;
            requestLayout();
        }
    }

    @Override // b.i.a.e.FlexContainer
    public void setFlexLines(List<FlexLine> list) {
        this.f2984y = list;
    }

    public void setFlexWrap(int i) {
        if (this.k != i) {
            this.k = i;
            requestLayout();
        }
    }

    public void setJustifyContent(int i) {
        if (this.l != i) {
            this.l = i;
            requestLayout();
        }
    }

    public void setMaxLine(int i) {
        if (this.o != i) {
            this.o = i;
            requestLayout();
        }
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.r) {
            this.r = i;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i) {
        if (i != this.f2982s) {
            this.f2982s = i;
            requestLayout();
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:70:0x01f3  */
    public final void t(boolean z2, boolean z3, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        float f2;
        float f3;
        float f4;
        int i6;
        View viewO;
        int i7;
        float f5;
        float f6;
        int i8;
        LayoutParams layoutParams;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i9 = i4 - i2;
        int i10 = (i3 - i) - paddingRight;
        int size = this.f2984y.size();
        for (int i11 = 0; i11 < size; i11++) {
            FlexLine flexLine = this.f2984y.get(i11);
            if (q(i11)) {
                int i12 = this.u;
                paddingLeft += i12;
                i10 -= i12;
            }
            int i13 = this.l;
            if (i13 != 0) {
                if (i13 == 1) {
                    int i14 = flexLine.e;
                    f = (i9 - i14) + paddingBottom;
                    i5 = i14 - paddingTop;
                } else if (i13 == 2) {
                    int i15 = flexLine.e;
                    f2 = (i9 - paddingBottom) - ((i9 - i15) / 2.0f);
                    f3 = ((i9 - i15) / 2.0f) + paddingTop;
                    f4 = 0.0f;
                } else if (i13 == 3) {
                    f3 = paddingTop;
                    int iA = flexLine.a();
                    f4 = (i9 - flexLine.e) / (iA != 1 ? iA - 1 : 1.0f);
                    f2 = i9 - paddingBottom;
                } else if (i13 == 4) {
                    int iA2 = flexLine.a();
                    f4 = iA2 != 0 ? (i9 - flexLine.e) / iA2 : 0.0f;
                    float f7 = f4 / 2.0f;
                    f3 = paddingTop + f7;
                    f2 = (i9 - paddingBottom) - f7;
                } else {
                    if (i13 != 5) {
                        StringBuilder sbU = outline.U("Invalid justifyContent is set: ");
                        sbU.append(this.l);
                        throw new IllegalStateException(sbU.toString());
                    }
                    int iA3 = flexLine.a();
                    f4 = iA3 != 0 ? (i9 - flexLine.e) / (iA3 + 1) : 0.0f;
                    f3 = paddingTop + f4;
                    f2 = (i9 - paddingBottom) - f4;
                }
                float fMax = Math.max(f4, 0.0f);
                i6 = 0;
                while (i6 < flexLine.h) {
                    int i16 = flexLine.o + i6;
                    viewO = o(i16);
                    if (viewO != null || viewO.getVisibility() == 8) {
                        i7 = i6;
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) viewO.getLayoutParams();
                        float f8 = f3 + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                        float f9 = f2 - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                        if (p(i16, i6)) {
                            int i17 = this.t;
                            float f10 = i17;
                            f5 = f8 + f10;
                            i8 = i17;
                            f6 = f9 - f10;
                        } else {
                            f5 = f8;
                            f6 = f9;
                            i8 = 0;
                        }
                        int i18 = (i6 != flexLine.h + (-1) || (this.r & 4) <= 0) ? 0 : this.t;
                        if (!z2) {
                            layoutParams = layoutParams2;
                            i7 = i6;
                            if (z3) {
                                this.f2983x.v(viewO, flexLine, false, paddingLeft, Math.round(f6) - viewO.getMeasuredHeight(), viewO.getMeasuredWidth() + paddingLeft, Math.round(f6));
                            } else {
                                this.f2983x.v(viewO, flexLine, false, paddingLeft, Math.round(f5), viewO.getMeasuredWidth() + paddingLeft, viewO.getMeasuredHeight() + Math.round(f5));
                            }
                        } else if (z3) {
                            layoutParams = layoutParams2;
                            i7 = i6;
                            this.f2983x.v(viewO, flexLine, true, i10 - viewO.getMeasuredWidth(), Math.round(f6) - viewO.getMeasuredHeight(), i10, Math.round(f6));
                        } else {
                            layoutParams = layoutParams2;
                            i7 = i6;
                            this.f2983x.v(viewO, flexLine, true, i10 - viewO.getMeasuredWidth(), Math.round(f5), i10, viewO.getMeasuredHeight() + Math.round(f5));
                        }
                        LayoutParams layoutParams3 = layoutParams;
                        float measuredHeight = viewO.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + f5;
                        float measuredHeight2 = f6 - ((viewO.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin);
                        if (z3) {
                            flexLine.b(viewO, 0, i18, 0, i8);
                        } else {
                            flexLine.b(viewO, 0, i8, 0, i18);
                        }
                        f3 = measuredHeight;
                        f2 = measuredHeight2;
                    }
                    i6 = i7 + 1;
                }
                int i19 = flexLine.g;
                paddingLeft += i19;
                i10 -= i19;
            } else {
                f = paddingTop;
                i5 = i9 - paddingBottom;
            }
            f2 = i5;
            f3 = f;
            f4 = 0.0f;
            float fMax2 = Math.max(f4, 0.0f);
            i6 = 0;
            while (i6 < flexLine.h) {
                int i110 = flexLine.o + i6;
                viewO = o(i110);
                if (viewO != null) {
                    i7 = i6;
                } else {
                    i7 = i6;
                }
                i6 = i7 + 1;
            }
            int i111 = flexLine.g;
            paddingLeft += i111;
            i10 -= i111;
        }
    }

    public final void u(int i, int i2, int i3, int i4) {
        int paddingBottom;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            paddingBottom = getPaddingBottom() + getPaddingTop() + getSumOfCrossSize();
            largestMainSize = getLargestMainSize();
        } else {
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException(outline.q("Invalid flex direction: ", i));
            }
            paddingBottom = getLargestMainSize();
            largestMainSize = getPaddingRight() + getPaddingLeft() + getSumOfCrossSize();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i2, i4);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException(outline.q("Unknown width mode is set: ", mode));
            }
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < paddingBottom) {
                i4 = View.combineMeasuredStates(i4, 256);
            } else {
                size2 = paddingBottom;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(paddingBottom, i3, i4);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException(outline.q("Unknown height mode is set: ", mode2));
            }
            if (size2 < paddingBottom) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
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

        public static class a implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
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
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.FlexboxLayout_Layout);
            this.j = typedArrayObtainStyledAttributes.getInt(R.a.FlexboxLayout_Layout_layout_order, 1);
            this.k = typedArrayObtainStyledAttributes.getFloat(R.a.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.l = typedArrayObtainStyledAttributes.getFloat(R.a.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.m = typedArrayObtainStyledAttributes.getInt(R.a.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.n = typedArrayObtainStyledAttributes.getFraction(R.a.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.a.FlexboxLayout_Layout_layout_minWidth, -1);
            this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.a.FlexboxLayout_Layout_layout_minHeight, -1);
            this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.a.FlexboxLayout_Layout_layout_maxWidth, ViewCompat.MEASURED_SIZE_MASK);
            this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.a.FlexboxLayout_Layout_layout_maxHeight, ViewCompat.MEASURED_SIZE_MASK);
            this.f2986s = typedArrayObtainStyledAttributes.getBoolean(R.a.FlexboxLayout_Layout_layout_wrapBefore, false);
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
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int J() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int N() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
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
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
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
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.j;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
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
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.FlexItem
        public float x() {
            return this.l;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.j = 1;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = -1;
            this.n = -1.0f;
            this.o = -1;
            this.p = -1;
            this.q = ViewCompat.MEASURED_SIZE_MASK;
            this.r = ViewCompat.MEASURED_SIZE_MASK;
            this.j = layoutParams.j;
            this.k = layoutParams.k;
            this.l = layoutParams.l;
            this.m = layoutParams.m;
            this.n = layoutParams.n;
            this.o = layoutParams.o;
            this.p = layoutParams.p;
            this.q = layoutParams.q;
            this.r = layoutParams.r;
            this.f2986s = layoutParams.f2986s;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
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

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
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

        public LayoutParams(Parcel parcel) {
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
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
