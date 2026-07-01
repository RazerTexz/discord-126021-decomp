package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.i.a.e.a;
import b.i.a.e.b;
import b.i.a.e.c;
import b.i.a.e.c$b;
import b.i.a.e.c$c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FlexboxLayout extends ViewGroup implements a {
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
    public c f2983x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List<b> f2984y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public c$b f2985z;

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.o = -1;
        this.f2983x = new c(this);
        this.f2984y = new ArrayList();
        this.f2985z = new c$b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$a.FlexboxLayout, 0, 0);
        this.j = typedArrayObtainStyledAttributes.getInt(R$a.FlexboxLayout_flexDirection, 0);
        this.k = typedArrayObtainStyledAttributes.getInt(R$a.FlexboxLayout_flexWrap, 0);
        this.l = typedArrayObtainStyledAttributes.getInt(R$a.FlexboxLayout_justifyContent, 0);
        this.m = typedArrayObtainStyledAttributes.getInt(R$a.FlexboxLayout_alignItems, 0);
        this.n = typedArrayObtainStyledAttributes.getInt(R$a.FlexboxLayout_alignContent, 0);
        this.o = typedArrayObtainStyledAttributes.getInt(R$a.FlexboxLayout_maxLine, -1);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$a.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R$a.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(R$a.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i = typedArrayObtainStyledAttributes.getInt(R$a.FlexboxLayout_showDivider, 0);
        if (i != 0) {
            this.f2982s = i;
            this.r = i;
        }
        int i2 = typedArrayObtainStyledAttributes.getInt(R$a.FlexboxLayout_showDividerVertical, 0);
        if (i2 != 0) {
            this.f2982s = i2;
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(R$a.FlexboxLayout_showDividerHorizontal, 0);
        if (i3 != 0) {
            this.r = i3;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // b.i.a.e.a
    public void a(View view, int i, int i2, b bVar) {
        if (p(i, i2)) {
            if (i()) {
                int i3 = bVar.e;
                int i4 = this.u;
                bVar.e = i3 + i4;
                bVar.f += i4;
                return;
            }
            int i5 = bVar.e;
            int i6 = this.t;
            bVar.e = i5 + i6;
            bVar.f += i6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (this.w == null) {
            this.w = new SparseIntArray(getChildCount());
        }
        c cVar = this.f2983x;
        SparseIntArray sparseIntArray = this.w;
        int flexItemCount = cVar.a.getFlexItemCount();
        List<c$c> listF = cVar.f(flexItemCount);
        c$c c_c = new c$c(null);
        if (view == null || !(viewGroup$LayoutParams instanceof FlexItem)) {
            c_c.k = 1;
        } else {
            c_c.k = ((FlexItem) viewGroup$LayoutParams).getOrder();
        }
        if (i == -1 || i == flexItemCount || i >= cVar.a.getFlexItemCount()) {
            c_c.j = flexItemCount;
        } else {
            c_c.j = i;
            for (int i2 = i; i2 < flexItemCount; i2++) {
                ((c$c) ((ArrayList) listF).get(i2)).j++;
            }
        }
        ((ArrayList) listF).add(c_c);
        this.v = cVar.x(flexItemCount + 1, listF, sparseIntArray);
        super.addView(view, i, viewGroup$LayoutParams);
    }

    @Override // b.i.a.e.a
    public void b(b bVar) {
        if (i()) {
            if ((this.f2982s & 4) > 0) {
                int i = bVar.e;
                int i2 = this.u;
                bVar.e = i + i2;
                bVar.f += i2;
                return;
            }
            return;
        }
        if ((this.r & 4) > 0) {
            int i3 = bVar.e;
            int i4 = this.t;
            bVar.e = i3 + i4;
            bVar.f += i4;
        }
    }

    @Override // b.i.a.e.a
    public View c(int i) {
        return o(i);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof FlexboxLayout$LayoutParams;
    }

    @Override // b.i.a.e.a
    public int d(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // b.i.a.e.a
    public void e(int i, View view) {
    }

    @Override // b.i.a.e.a
    public View f(int i) {
        return getChildAt(i);
    }

    @Override // b.i.a.e.a
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
    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new FlexboxLayout$LayoutParams(getContext(), attributeSet);
    }

    @Override // b.i.a.e.a
    public int getAlignContent() {
        return this.n;
    }

    @Override // b.i.a.e.a
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

    @Override // b.i.a.e.a
    public int getFlexDirection() {
        return this.j;
    }

    @Override // b.i.a.e.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f2984y.size());
        for (b bVar : this.f2984y) {
            if (bVar.a() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // b.i.a.e.a
    public List<b> getFlexLinesInternal() {
        return this.f2984y;
    }

    @Override // b.i.a.e.a
    public int getFlexWrap() {
        return this.k;
    }

    public int getJustifyContent() {
        return this.l;
    }

    @Override // b.i.a.e.a
    public int getLargestMainSize() {
        Iterator<b> it = this.f2984y.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().e);
        }
        return iMax;
    }

    @Override // b.i.a.e.a
    public int getMaxLine() {
        return this.o;
    }

    public int getShowDividerHorizontal() {
        return this.r;
    }

    public int getShowDividerVertical() {
        return this.f2982s;
    }

    @Override // b.i.a.e.a
    public int getSumOfCrossSize() {
        int size = this.f2984y.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f2984y.get(i2);
            if (q(i2)) {
                i += i() ? this.t : this.u;
            }
            if (r(i2)) {
                i += i() ? this.t : this.u;
            }
            i += bVar.g;
        }
        return i;
    }

    @Override // b.i.a.e.a
    public int h(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // b.i.a.e.a
    public boolean i() {
        int i = this.j;
        return i == 0 || i == 1;
    }

    @Override // b.i.a.e.a
    public int j(View view) {
        return 0;
    }

    public final void k(Canvas canvas, boolean z2, boolean z3) {
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.f2984y.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f2984y.get(i);
            for (int i2 = 0; i2 < bVar.h; i2++) {
                int i3 = bVar.o + i2;
                View viewO = o(i3);
                if (viewO != null && viewO.getVisibility() != 8) {
                    FlexboxLayout$LayoutParams flexboxLayout$LayoutParams = (FlexboxLayout$LayoutParams) viewO.getLayoutParams();
                    if (p(i3, i2)) {
                        n(canvas, z2 ? viewO.getRight() + ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams).rightMargin : (viewO.getLeft() - ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams).leftMargin) - this.u, bVar.f1327b, bVar.g);
                    }
                    if (i2 == bVar.h - 1 && (this.f2982s & 4) > 0) {
                        n(canvas, z2 ? (viewO.getLeft() - ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams).leftMargin) - this.u : viewO.getRight() + ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams).rightMargin, bVar.f1327b, bVar.g);
                    }
                }
            }
            if (q(i)) {
                m(canvas, paddingLeft, z3 ? bVar.d : bVar.f1327b - this.t, iMax);
            }
            if (r(i) && (this.r & 4) > 0) {
                m(canvas, paddingLeft, z3 ? bVar.f1327b - this.t : bVar.d, iMax);
            }
        }
    }

    public final void l(Canvas canvas, boolean z2, boolean z3) {
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.f2984y.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f2984y.get(i);
            for (int i2 = 0; i2 < bVar.h; i2++) {
                int i3 = bVar.o + i2;
                View viewO = o(i3);
                if (viewO != null && viewO.getVisibility() != 8) {
                    FlexboxLayout$LayoutParams flexboxLayout$LayoutParams = (FlexboxLayout$LayoutParams) viewO.getLayoutParams();
                    if (p(i3, i2)) {
                        m(canvas, bVar.a, z3 ? viewO.getBottom() + ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams).bottomMargin : (viewO.getTop() - ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams).topMargin) - this.t, bVar.g);
                    }
                    if (i2 == bVar.h - 1 && (this.r & 4) > 0) {
                        m(canvas, bVar.a, z3 ? (viewO.getTop() - ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams).topMargin) - this.t : viewO.getBottom() + ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams).bottomMargin, bVar.g);
                    }
                }
            }
            if (q(i)) {
                n(canvas, z2 ? bVar.c : bVar.a - this.u, paddingTop, iMax);
            }
            if (r(i) && (this.f2982s & 4) > 0) {
                n(canvas, z2 ? bVar.a - this.u : bVar.c, paddingTop, iMax);
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
            StringBuilder sbU = b.d.b.a.a.U("Invalid flex direction is set: ");
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
        c cVar = this.f2983x;
        SparseIntArray sparseIntArray = this.w;
        int flexItemCount = cVar.a.getFlexItemCount();
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
            View viewF = cVar.a.f(i3);
            if (viewF != null && ((FlexItem) viewF.getLayoutParams()).getOrder() != sparseIntArray.get(i3)) {
                z2 = true;
                break;
            }
            i3++;
        }
        if (z2) {
            c cVar2 = this.f2983x;
            SparseIntArray sparseIntArray2 = this.w;
            int flexItemCount2 = cVar2.a.getFlexItemCount();
            this.v = cVar2.x(flexItemCount2, cVar2.f(flexItemCount2), sparseIntArray2);
        }
        int i4 = this.j;
        if (i4 != 0 && i4 != 1) {
            if (i4 != 2 && i4 != 3) {
                StringBuilder sbU = b.d.b.a.a.U("Invalid value for the flex direction is set: ");
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
            for (b bVar : this.f2984y) {
                int iMax = Integer.MIN_VALUE;
                for (int i5 = 0; i5 < bVar.h; i5++) {
                    View viewO = o(bVar.o + i5);
                    if (viewO != null && viewO.getVisibility() != 8) {
                        FlexboxLayout$LayoutParams flexboxLayout$LayoutParams = (FlexboxLayout$LayoutParams) viewO.getLayoutParams();
                        iMax = this.k != 2 ? Math.max(iMax, viewO.getMeasuredHeight() + Math.max(bVar.l - viewO.getBaseline(), ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams).topMargin) + ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams).bottomMargin) : Math.max(iMax, viewO.getMeasuredHeight() + ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams).topMargin + Math.max(viewO.getBaseline() + (bVar.l - viewO.getMeasuredHeight()), ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams).bottomMargin));
                    }
                }
                bVar.g = iMax;
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
        FlexboxLayout$LayoutParams flexboxLayout$LayoutParams;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i9 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.f2984y.size();
        int i10 = 0;
        while (i10 < size) {
            b bVar = this.f2984y.get(i10);
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
                    int i14 = bVar.e;
                    f2 = (i9 - paddingRight) - ((i9 - i14) / 2.0f);
                    f = ((i9 - i14) / 2.0f) + paddingLeft;
                } else if (i12 == 3) {
                    f = paddingLeft;
                    int iA = bVar.a();
                    f3 = (i9 - bVar.e) / (iA != 1 ? iA - 1 : 1.0f);
                    f2 = i9 - paddingRight;
                } else if (i12 == 4) {
                    int iA2 = bVar.a();
                    f3 = iA2 != 0 ? (i9 - bVar.e) / iA2 : 0.0f;
                    float f6 = f3 / 2.0f;
                    f = paddingLeft + f6;
                    f2 = (i9 - paddingRight) - f6;
                } else {
                    if (i12 != 5) {
                        StringBuilder sbU = b.d.b.a.a.U("Invalid justifyContent is set: ");
                        sbU.append(this.l);
                        throw new IllegalStateException(sbU.toString());
                    }
                    int iA3 = bVar.a();
                    f3 = iA3 != 0 ? (i9 - bVar.e) / (iA3 + 1) : 0.0f;
                    f = paddingLeft + f3;
                    f2 = (i9 - paddingRight) - f3;
                }
                float fMax = Math.max(f3, 0.0f);
                i5 = 0;
                while (i5 < bVar.h) {
                    int i15 = bVar.o + i5;
                    viewO = o(i15);
                    if (viewO != null || viewO.getVisibility() == 8) {
                        i6 = paddingLeft;
                        i7 = i5;
                    } else {
                        FlexboxLayout$LayoutParams flexboxLayout$LayoutParams2 = (FlexboxLayout$LayoutParams) viewO.getLayoutParams();
                        float f7 = f + ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams2).leftMargin;
                        float f8 = f2 - ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams2).rightMargin;
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
                        int i17 = (i5 != bVar.h - i13 || (this.f2982s & 4) <= 0) ? 0 : this.u;
                        if (this.k != 2) {
                            i6 = paddingLeft;
                            flexboxLayout$LayoutParams = flexboxLayout$LayoutParams2;
                            i7 = i5;
                            if (z2) {
                                this.f2983x.u(viewO, bVar, Math.round(f5) - viewO.getMeasuredWidth(), paddingTop, Math.round(f5), viewO.getMeasuredHeight() + paddingTop);
                            } else {
                                this.f2983x.u(viewO, bVar, Math.round(f4), paddingTop, viewO.getMeasuredWidth() + Math.round(f4), viewO.getMeasuredHeight() + paddingTop);
                            }
                        } else if (z2) {
                            i6 = paddingLeft;
                            flexboxLayout$LayoutParams = flexboxLayout$LayoutParams2;
                            i7 = i5;
                            this.f2983x.u(viewO, bVar, Math.round(f5) - viewO.getMeasuredWidth(), paddingBottom - viewO.getMeasuredHeight(), Math.round(f5), paddingBottom);
                        } else {
                            i6 = paddingLeft;
                            flexboxLayout$LayoutParams = flexboxLayout$LayoutParams2;
                            i7 = i5;
                            this.f2983x.u(viewO, bVar, Math.round(f4), paddingBottom - viewO.getMeasuredHeight(), viewO.getMeasuredWidth() + Math.round(f4), paddingBottom);
                        }
                        float measuredWidth = viewO.getMeasuredWidth() + fMax + ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams).rightMargin + f4;
                        float measuredWidth2 = f5 - ((viewO.getMeasuredWidth() + fMax) + ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams).leftMargin);
                        if (z2) {
                            bVar.b(viewO, i17, 0, i8, 0);
                        } else {
                            bVar.b(viewO, i8, 0, i17, 0);
                        }
                        f = measuredWidth;
                        f2 = measuredWidth2;
                    }
                    i5 = i7 + 1;
                    i13 = 1;
                    paddingLeft = i6;
                }
                int i18 = paddingLeft;
                int i19 = bVar.g;
                paddingTop += i19;
                paddingBottom -= i19;
                i10++;
                paddingLeft = i18;
            } else {
                int i20 = bVar.e;
                f2 = i20 - paddingLeft;
                f = (i9 - i20) + paddingRight;
            }
            f3 = 0.0f;
            float fMax2 = Math.max(f3, 0.0f);
            i5 = 0;
            while (i5 < bVar.h) {
                int i110 = bVar.o + i5;
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
            int i112 = bVar.g;
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

    @Override // b.i.a.e.a
    public void setFlexLines(List<b> list) {
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
        FlexboxLayout$LayoutParams flexboxLayout$LayoutParams;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i9 = i4 - i2;
        int i10 = (i3 - i) - paddingRight;
        int size = this.f2984y.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f2984y.get(i11);
            if (q(i11)) {
                int i12 = this.u;
                paddingLeft += i12;
                i10 -= i12;
            }
            int i13 = this.l;
            if (i13 != 0) {
                if (i13 == 1) {
                    int i14 = bVar.e;
                    f = (i9 - i14) + paddingBottom;
                    i5 = i14 - paddingTop;
                } else if (i13 == 2) {
                    int i15 = bVar.e;
                    f2 = (i9 - paddingBottom) - ((i9 - i15) / 2.0f);
                    f3 = ((i9 - i15) / 2.0f) + paddingTop;
                    f4 = 0.0f;
                } else if (i13 == 3) {
                    f3 = paddingTop;
                    int iA = bVar.a();
                    f4 = (i9 - bVar.e) / (iA != 1 ? iA - 1 : 1.0f);
                    f2 = i9 - paddingBottom;
                } else if (i13 == 4) {
                    int iA2 = bVar.a();
                    f4 = iA2 != 0 ? (i9 - bVar.e) / iA2 : 0.0f;
                    float f7 = f4 / 2.0f;
                    f3 = paddingTop + f7;
                    f2 = (i9 - paddingBottom) - f7;
                } else {
                    if (i13 != 5) {
                        StringBuilder sbU = b.d.b.a.a.U("Invalid justifyContent is set: ");
                        sbU.append(this.l);
                        throw new IllegalStateException(sbU.toString());
                    }
                    int iA3 = bVar.a();
                    f4 = iA3 != 0 ? (i9 - bVar.e) / (iA3 + 1) : 0.0f;
                    f3 = paddingTop + f4;
                    f2 = (i9 - paddingBottom) - f4;
                }
                float fMax = Math.max(f4, 0.0f);
                i6 = 0;
                while (i6 < bVar.h) {
                    int i16 = bVar.o + i6;
                    viewO = o(i16);
                    if (viewO != null || viewO.getVisibility() == 8) {
                        i7 = i6;
                    } else {
                        FlexboxLayout$LayoutParams flexboxLayout$LayoutParams2 = (FlexboxLayout$LayoutParams) viewO.getLayoutParams();
                        float f8 = f3 + ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams2).topMargin;
                        float f9 = f2 - ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams2).bottomMargin;
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
                        int i18 = (i6 != bVar.h + (-1) || (this.r & 4) <= 0) ? 0 : this.t;
                        if (!z2) {
                            flexboxLayout$LayoutParams = flexboxLayout$LayoutParams2;
                            i7 = i6;
                            if (z3) {
                                this.f2983x.v(viewO, bVar, false, paddingLeft, Math.round(f6) - viewO.getMeasuredHeight(), viewO.getMeasuredWidth() + paddingLeft, Math.round(f6));
                            } else {
                                this.f2983x.v(viewO, bVar, false, paddingLeft, Math.round(f5), viewO.getMeasuredWidth() + paddingLeft, viewO.getMeasuredHeight() + Math.round(f5));
                            }
                        } else if (z3) {
                            flexboxLayout$LayoutParams = flexboxLayout$LayoutParams2;
                            i7 = i6;
                            this.f2983x.v(viewO, bVar, true, i10 - viewO.getMeasuredWidth(), Math.round(f6) - viewO.getMeasuredHeight(), i10, Math.round(f6));
                        } else {
                            flexboxLayout$LayoutParams = flexboxLayout$LayoutParams2;
                            i7 = i6;
                            this.f2983x.v(viewO, bVar, true, i10 - viewO.getMeasuredWidth(), Math.round(f5), i10, viewO.getMeasuredHeight() + Math.round(f5));
                        }
                        FlexboxLayout$LayoutParams flexboxLayout$LayoutParams3 = flexboxLayout$LayoutParams;
                        float measuredHeight = viewO.getMeasuredHeight() + fMax + ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams3).bottomMargin + f5;
                        float measuredHeight2 = f6 - ((viewO.getMeasuredHeight() + fMax) + ((ViewGroup$MarginLayoutParams) flexboxLayout$LayoutParams3).topMargin);
                        if (z3) {
                            bVar.b(viewO, 0, i18, 0, i8);
                        } else {
                            bVar.b(viewO, 0, i8, 0, i18);
                        }
                        f3 = measuredHeight;
                        f2 = measuredHeight2;
                    }
                    i6 = i7 + 1;
                }
                int i19 = bVar.g;
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
            while (i6 < bVar.h) {
                int i110 = bVar.o + i6;
                viewO = o(i110);
                if (viewO != null) {
                    i7 = i6;
                } else {
                    i7 = i6;
                }
                i6 = i7 + 1;
            }
            int i111 = bVar.g;
            paddingLeft += i111;
            i10 -= i111;
        }
    }

    public final void u(int i, int i2, int i3, int i4) {
        int paddingBottom;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View$MeasureSpec.getMode(i2);
        int size = View$MeasureSpec.getSize(i2);
        int mode2 = View$MeasureSpec.getMode(i3);
        int size2 = View$MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            paddingBottom = getPaddingBottom() + getPaddingTop() + getSumOfCrossSize();
            largestMainSize = getLargestMainSize();
        } else {
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException(b.d.b.a.a.q("Invalid flex direction: ", i));
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
                throw new IllegalStateException(b.d.b.a.a.q("Unknown width mode is set: ", mode));
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
                throw new IllegalStateException(b.d.b.a.a.q("Unknown height mode is set: ", mode2));
            }
            if (size2 < paddingBottom) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof FlexboxLayout$LayoutParams) {
            return new FlexboxLayout$LayoutParams((FlexboxLayout$LayoutParams) viewGroup$LayoutParams);
        }
        return viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams ? new FlexboxLayout$LayoutParams((ViewGroup$MarginLayoutParams) viewGroup$LayoutParams) : new FlexboxLayout$LayoutParams(viewGroup$LayoutParams);
    }
}
