package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutManager$Properties;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider;
import androidx.recyclerview.widget.RecyclerView$State;
import b.i.a.e.a;
import b.i.a.e.b;
import b.i.a.e.c;
import b.i.a.e.c$b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FlexboxLayoutManager extends RecyclerView$LayoutManager implements a, RecyclerView$SmoothScroller$ScrollVectorProvider {
    public static final Rect j = new Rect();
    public final Context E;
    public View F;
    public int k;
    public int l;
    public int m;
    public boolean o;
    public boolean p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView$Recycler f2987s;
    public RecyclerView$State t;
    public FlexboxLayoutManager$c u;
    public OrientationHelper w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public OrientationHelper f2988x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public FlexboxLayoutManager$SavedState f2989y;
    public int n = -1;
    public List<b> q = new ArrayList();
    public final c r = new c(this);
    public FlexboxLayoutManager$b v = new FlexboxLayoutManager$b(this, null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2990z = -1;
    public int A = Integer.MIN_VALUE;
    public int B = Integer.MIN_VALUE;
    public int C = Integer.MIN_VALUE;
    public SparseArray<View> D = new SparseArray<>();
    public int G = -1;
    public c$b H = new c$b();

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView$LayoutManager$Properties properties = RecyclerView$LayoutManager.getProperties(context, attributeSet, i, i2);
        int i3 = properties.orientation;
        if (i3 != 0) {
            if (i3 == 1) {
                if (properties.reverseLayout) {
                    x(3);
                } else {
                    x(2);
                }
            }
        } else if (properties.reverseLayout) {
            x(1);
        } else {
            x(0);
        }
        int i4 = this.l;
        if (i4 != 1) {
            if (i4 == 0) {
                removeAllViews();
                k();
            }
            this.l = 1;
            this.w = null;
            this.f2988x = null;
            requestLayout();
        }
        if (this.m != 4) {
            removeAllViews();
            k();
            this.m = 4;
            requestLayout();
        }
        setAutoMeasureEnabled(true);
        this.E = context;
    }

    public static boolean isMeasurementUpToDate(int i, int i2, int i3) {
        int mode = View$MeasureSpec.getMode(i2);
        int size = View$MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i;
        }
        return true;
    }

    private boolean shouldMeasureChild(View view, int i, int i2, RecyclerView$LayoutParams recyclerView$LayoutParams) {
        return (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).width) && isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).height)) ? false : true;
    }

    public final void A(FlexboxLayoutManager$b flexboxLayoutManager$b, boolean z2, boolean z3) {
        if (z3) {
            w();
        } else {
            this.u.f2992b = false;
        }
        if (i() || !this.o) {
            this.u.a = flexboxLayoutManager$b.c - this.w.getStartAfterPadding();
        } else {
            this.u.a = (this.F.getWidth() - flexboxLayoutManager$b.c) - this.w.getStartAfterPadding();
        }
        FlexboxLayoutManager$c flexboxLayoutManager$c = this.u;
        flexboxLayoutManager$c.d = flexboxLayoutManager$b.a;
        flexboxLayoutManager$c.h = 1;
        flexboxLayoutManager$c.i = -1;
        flexboxLayoutManager$c.e = flexboxLayoutManager$b.c;
        flexboxLayoutManager$c.f = Integer.MIN_VALUE;
        int i = flexboxLayoutManager$b.f2991b;
        flexboxLayoutManager$c.c = i;
        if (!z2 || i <= 0) {
            return;
        }
        int size = this.q.size();
        int i2 = flexboxLayoutManager$b.f2991b;
        if (size > i2) {
            b bVar = this.q.get(i2);
            FlexboxLayoutManager$c flexboxLayoutManager$c2 = this.u;
            flexboxLayoutManager$c2.c--;
            flexboxLayoutManager$c2.d -= bVar.h;
        }
    }

    @Override // b.i.a.e.a
    public void a(View view, int i, int i2, b bVar) {
        calculateItemDecorationsForChild(view, j);
        if (i()) {
            int rightDecorationWidth = getRightDecorationWidth(view) + getLeftDecorationWidth(view);
            bVar.e += rightDecorationWidth;
            bVar.f += rightDecorationWidth;
            return;
        }
        int bottomDecorationHeight = getBottomDecorationHeight(view) + getTopDecorationHeight(view);
        bVar.e += bottomDecorationHeight;
        bVar.f += bottomDecorationHeight;
    }

    @Override // b.i.a.e.a
    public void b(b bVar) {
    }

    @Override // b.i.a.e.a
    public View c(int i) {
        return f(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean canScrollHorizontally() {
        if (this.l == 0) {
            return i();
        }
        if (i()) {
            int width = getWidth();
            View view = this.F;
            if (width <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean canScrollVertically() {
        if (this.l == 0) {
            return !i();
        }
        if (i()) {
            return true;
        }
        int height = getHeight();
        View view = this.F;
        return height > (view != null ? view.getHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean checkLayoutParams(RecyclerView$LayoutParams recyclerView$LayoutParams) {
        return recyclerView$LayoutParams instanceof FlexboxLayoutManager$LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView$State recyclerView$State) {
        return computeScrollExtent(recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView$State recyclerView$State) {
        return computeScrollOffset(recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeHorizontalScrollRange(RecyclerView$State recyclerView$State) {
        return computeScrollRange(recyclerView$State);
    }

    public final int computeScrollExtent(RecyclerView$State recyclerView$State) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = recyclerView$State.getItemCount();
        l();
        View viewN = n(itemCount);
        View viewP = p(itemCount);
        if (recyclerView$State.getItemCount() == 0 || viewN == null || viewP == null) {
            return 0;
        }
        return Math.min(this.w.getTotalSpace(), this.w.getDecoratedEnd(viewP) - this.w.getDecoratedStart(viewN));
    }

    public final int computeScrollOffset(RecyclerView$State recyclerView$State) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = recyclerView$State.getItemCount();
        View viewN = n(itemCount);
        View viewP = p(itemCount);
        if (recyclerView$State.getItemCount() != 0 && viewN != null && viewP != null) {
            int position = getPosition(viewN);
            int position2 = getPosition(viewP);
            int iAbs = Math.abs(this.w.getDecoratedEnd(viewP) - this.w.getDecoratedStart(viewN));
            int[] iArr = this.r.c;
            int i = iArr[position];
            if (i != 0 && i != -1) {
                return Math.round((i * (iAbs / ((iArr[position2] - i) + 1))) + (this.w.getStartAfterPadding() - this.w.getDecoratedStart(viewN)));
            }
        }
        return 0;
    }

    public final int computeScrollRange(RecyclerView$State recyclerView$State) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = recyclerView$State.getItemCount();
        View viewN = n(itemCount);
        View viewP = p(itemCount);
        if (recyclerView$State.getItemCount() == 0 || viewN == null || viewP == null) {
            return 0;
        }
        View viewR = r(0, getChildCount(), false);
        return (int) ((Math.abs(this.w.getDecoratedEnd(viewP) - this.w.getDecoratedStart(viewN)) / ((findLastVisibleItemPosition() - (viewR == null ? -1 : getPosition(viewR))) + 1)) * recyclerView$State.getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        return i() ? new PointF(0.0f, i2) : new PointF(i2, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeVerticalScrollExtent(RecyclerView$State recyclerView$State) {
        return computeScrollExtent(recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeVerticalScrollOffset(RecyclerView$State recyclerView$State) {
        return computeScrollOffset(recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeVerticalScrollRange(RecyclerView$State recyclerView$State) {
        return computeScrollRange(recyclerView$State);
    }

    @Override // b.i.a.e.a
    public int d(int i, int i2, int i3) {
        return RecyclerView$LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i2, i3, canScrollHorizontally());
    }

    @Override // b.i.a.e.a
    public void e(int i, View view) {
        this.D.put(i, view);
    }

    @Override // b.i.a.e.a
    public View f(int i) {
        View view = this.D.get(i);
        return view != null ? view : this.f2987s.getViewForPosition(i);
    }

    public int findLastVisibleItemPosition() {
        View viewR = r(getChildCount() - 1, -1, false);
        if (viewR == null) {
            return -1;
        }
        return getPosition(viewR);
    }

    public final int fixLayoutEndGap(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, boolean z2) {
        int iT;
        int endAfterPadding;
        if (!i() && this.o) {
            int startAfterPadding = i - this.w.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            iT = t(startAfterPadding, recyclerView$Recycler, recyclerView$State);
        } else {
            int endAfterPadding2 = this.w.getEndAfterPadding() - i;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            iT = -t(-endAfterPadding2, recyclerView$Recycler, recyclerView$State);
        }
        int i2 = i + iT;
        if (!z2 || (endAfterPadding = this.w.getEndAfterPadding() - i2) <= 0) {
            return iT;
        }
        this.w.offsetChildren(endAfterPadding);
        return endAfterPadding + iT;
    }

    public final int fixLayoutStartGap(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, boolean z2) {
        int iT;
        int startAfterPadding;
        if (i() || !this.o) {
            int startAfterPadding2 = i - this.w.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            iT = -t(startAfterPadding2, recyclerView$Recycler, recyclerView$State);
        } else {
            int endAfterPadding = this.w.getEndAfterPadding() - i;
            if (endAfterPadding <= 0) {
                return 0;
            }
            iT = t(-endAfterPadding, recyclerView$Recycler, recyclerView$State);
        }
        int i2 = i + iT;
        if (!z2 || (startAfterPadding = i2 - this.w.getStartAfterPadding()) <= 0) {
            return iT;
        }
        this.w.offsetChildren(-startAfterPadding);
        return iT - startAfterPadding;
    }

    @Override // b.i.a.e.a
    public int g(View view, int i, int i2) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (i()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return bottomDecorationHeight + topDecorationHeight;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public RecyclerView$LayoutParams generateDefaultLayoutParams() {
        return new FlexboxLayoutManager$LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public RecyclerView$LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new FlexboxLayoutManager$LayoutParams(context, attributeSet);
    }

    @Override // b.i.a.e.a
    public int getAlignContent() {
        return 5;
    }

    @Override // b.i.a.e.a
    public int getAlignItems() {
        return this.m;
    }

    @Override // b.i.a.e.a
    public int getFlexDirection() {
        return this.k;
    }

    @Override // b.i.a.e.a
    public int getFlexItemCount() {
        return this.t.getItemCount();
    }

    @Override // b.i.a.e.a
    public List<b> getFlexLinesInternal() {
        return this.q;
    }

    @Override // b.i.a.e.a
    public int getFlexWrap() {
        return this.l;
    }

    @Override // b.i.a.e.a
    public int getLargestMainSize() {
        if (this.q.size() == 0) {
            return 0;
        }
        int iMax = Integer.MIN_VALUE;
        int size = this.q.size();
        for (int i = 0; i < size; i++) {
            iMax = Math.max(iMax, this.q.get(i).e);
        }
        return iMax;
    }

    @Override // b.i.a.e.a
    public int getMaxLine() {
        return this.n;
    }

    @Override // b.i.a.e.a
    public int getSumOfCrossSize() {
        int size = this.q.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.q.get(i2).g;
        }
        return i;
    }

    @Override // b.i.a.e.a
    public int h(int i, int i2, int i3) {
        return RecyclerView$LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i2, i3, canScrollVertically());
    }

    @Override // b.i.a.e.a
    public boolean i() {
        int i = this.k;
        return i == 0 || i == 1;
    }

    @Override // b.i.a.e.a
    public int j(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (i()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return rightDecorationWidth + leftDecorationWidth;
    }

    public final void k() {
        this.q.clear();
        FlexboxLayoutManager$b.b(this.v);
        this.v.d = 0;
    }

    public final void l() {
        if (this.w != null) {
            return;
        }
        if (i()) {
            if (this.l == 0) {
                this.w = OrientationHelper.createHorizontalHelper(this);
                this.f2988x = OrientationHelper.createVerticalHelper(this);
                return;
            } else {
                this.w = OrientationHelper.createVerticalHelper(this);
                this.f2988x = OrientationHelper.createHorizontalHelper(this);
                return;
            }
        }
        if (this.l == 0) {
            this.w = OrientationHelper.createVerticalHelper(this);
            this.f2988x = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.w = OrientationHelper.createHorizontalHelper(this);
            this.f2988x = OrientationHelper.createVerticalHelper(this);
        }
    }

    public final int m(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, FlexboxLayoutManager$c flexboxLayoutManager$c) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = flexboxLayoutManager$c.f;
        if (i10 != Integer.MIN_VALUE) {
            int i11 = flexboxLayoutManager$c.a;
            if (i11 < 0) {
                flexboxLayoutManager$c.f = i10 + i11;
            }
            v(recyclerView$Recycler, flexboxLayoutManager$c);
        }
        int i12 = flexboxLayoutManager$c.a;
        boolean zI = i();
        int i13 = i12;
        int i14 = 0;
        while (true) {
            if (i13 <= 0 && !this.u.f2992b) {
                break;
            }
            List<b> list = this.q;
            int i15 = flexboxLayoutManager$c.d;
            if (!(i15 >= 0 && i15 < recyclerView$State.getItemCount() && (i9 = flexboxLayoutManager$c.c) >= 0 && i9 < list.size())) {
                break;
            }
            b bVar = this.q.get(flexboxLayoutManager$c.c);
            flexboxLayoutManager$c.d = bVar.o;
            if (i()) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int width = getWidth();
                int i16 = flexboxLayoutManager$c.e;
                if (flexboxLayoutManager$c.i == -1) {
                    i16 -= bVar.g;
                }
                int i17 = flexboxLayoutManager$c.d;
                float f = width - paddingRight;
                float f2 = this.v.d;
                float f3 = paddingLeft - f2;
                float leftDecorationWidth = f - f2;
                float fMax = Math.max(0.0f, 0.0f);
                int i18 = i17;
                int i19 = 0;
                for (int i20 = bVar.h; i18 < i17 + i20; i20 = i20) {
                    View viewF = f(i18);
                    if (viewF == null) {
                        i18 = i18;
                    } else {
                        if (flexboxLayoutManager$c.i == 1) {
                            calculateItemDecorationsForChild(viewF, j);
                            addView(viewF);
                        } else {
                            calculateItemDecorationsForChild(viewF, j);
                            addView(viewF, i19);
                            i19++;
                        }
                        int i21 = i19;
                        c cVar = this.r;
                        long j2 = cVar.d[i18];
                        int i22 = (int) j2;
                        int iM = cVar.m(j2);
                        FlexboxLayoutManager$LayoutParams flexboxLayoutManager$LayoutParams = (FlexboxLayoutManager$LayoutParams) viewF.getLayoutParams();
                        if (shouldMeasureChild(viewF, i22, iM, flexboxLayoutManager$LayoutParams)) {
                            viewF.measure(i22, iM);
                        }
                        float leftDecorationWidth2 = f3 + getLeftDecorationWidth(viewF) + ((ViewGroup$MarginLayoutParams) flexboxLayoutManager$LayoutParams).leftMargin;
                        float rightDecorationWidth = leftDecorationWidth - (getRightDecorationWidth(viewF) + ((ViewGroup$MarginLayoutParams) flexboxLayoutManager$LayoutParams).rightMargin);
                        int topDecorationHeight = getTopDecorationHeight(viewF) + i16;
                        if (this.o) {
                            this.r.u(viewF, bVar, Math.round(rightDecorationWidth) - viewF.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), viewF.getMeasuredHeight() + topDecorationHeight);
                        } else {
                            this.r.u(viewF, bVar, Math.round(leftDecorationWidth2), topDecorationHeight, viewF.getMeasuredWidth() + Math.round(leftDecorationWidth2), viewF.getMeasuredHeight() + topDecorationHeight);
                        }
                        float rightDecorationWidth2 = getRightDecorationWidth(viewF) + viewF.getMeasuredWidth() + ((ViewGroup$MarginLayoutParams) flexboxLayoutManager$LayoutParams).rightMargin + fMax + leftDecorationWidth2;
                        leftDecorationWidth = rightDecorationWidth - ((getLeftDecorationWidth(viewF) + (viewF.getMeasuredWidth() + ((ViewGroup$MarginLayoutParams) flexboxLayoutManager$LayoutParams).leftMargin)) + fMax);
                        f3 = rightDecorationWidth2;
                        i19 = i21;
                    }
                    i18++;
                    i17 = i17;
                    i12 = i12;
                }
                i = i12;
                flexboxLayoutManager$c.c += this.u.i;
                i5 = bVar.g;
                i3 = i13;
                i4 = i14;
            } else {
                i = i12;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i23 = flexboxLayoutManager$c.e;
                if (flexboxLayoutManager$c.i == -1) {
                    int i24 = bVar.g;
                    int i25 = i23 - i24;
                    i2 = i23 + i24;
                    i23 = i25;
                } else {
                    i2 = i23;
                }
                int i26 = flexboxLayoutManager$c.d;
                float f4 = height - paddingBottom;
                float f5 = this.v.d;
                float f6 = paddingTop - f5;
                float topDecorationHeight2 = f4 - f5;
                float fMax2 = Math.max(0.0f, 0.0f);
                int i27 = bVar.h;
                int i28 = i26;
                int i29 = 0;
                while (i28 < i26 + i27) {
                    View viewF2 = f(i28);
                    if (viewF2 == null) {
                        i6 = i28;
                        i7 = i27;
                        i8 = i26;
                    } else {
                        int i30 = i27;
                        c cVar2 = this.r;
                        int i31 = i26;
                        long j3 = cVar2.d[i28];
                        int i32 = (int) j3;
                        int iM2 = cVar2.m(j3);
                        FlexboxLayoutManager$LayoutParams flexboxLayoutManager$LayoutParams2 = (FlexboxLayoutManager$LayoutParams) viewF2.getLayoutParams();
                        if (shouldMeasureChild(viewF2, i32, iM2, flexboxLayoutManager$LayoutParams2)) {
                            viewF2.measure(i32, iM2);
                        }
                        float topDecorationHeight3 = f6 + getTopDecorationHeight(viewF2) + ((ViewGroup$MarginLayoutParams) flexboxLayoutManager$LayoutParams2).topMargin;
                        float bottomDecorationHeight = topDecorationHeight2 - (getBottomDecorationHeight(viewF2) + ((ViewGroup$MarginLayoutParams) flexboxLayoutManager$LayoutParams2).rightMargin);
                        if (flexboxLayoutManager$c.i == 1) {
                            calculateItemDecorationsForChild(viewF2, j);
                            addView(viewF2);
                        } else {
                            calculateItemDecorationsForChild(viewF2, j);
                            addView(viewF2, i29);
                            i29++;
                        }
                        int i33 = i29;
                        int leftDecorationWidth3 = getLeftDecorationWidth(viewF2) + i23;
                        int rightDecorationWidth3 = i2 - getRightDecorationWidth(viewF2);
                        boolean z2 = this.o;
                        if (!z2) {
                            i6 = i28;
                            i7 = i30;
                            i8 = i31;
                            if (this.p) {
                                this.r.v(viewF2, bVar, z2, leftDecorationWidth3, Math.round(bottomDecorationHeight) - viewF2.getMeasuredHeight(), viewF2.getMeasuredWidth() + leftDecorationWidth3, Math.round(bottomDecorationHeight));
                            } else {
                                this.r.v(viewF2, bVar, z2, leftDecorationWidth3, Math.round(topDecorationHeight3), viewF2.getMeasuredWidth() + leftDecorationWidth3, viewF2.getMeasuredHeight() + Math.round(topDecorationHeight3));
                            }
                        } else if (this.p) {
                            i6 = i28;
                            i7 = i30;
                            i8 = i31;
                            this.r.v(viewF2, bVar, z2, rightDecorationWidth3 - viewF2.getMeasuredWidth(), Math.round(bottomDecorationHeight) - viewF2.getMeasuredHeight(), rightDecorationWidth3, Math.round(bottomDecorationHeight));
                        } else {
                            i6 = i28;
                            i7 = i30;
                            i8 = i31;
                            this.r.v(viewF2, bVar, z2, rightDecorationWidth3 - viewF2.getMeasuredWidth(), Math.round(topDecorationHeight3), rightDecorationWidth3, viewF2.getMeasuredHeight() + Math.round(topDecorationHeight3));
                        }
                        float bottomDecorationHeight2 = getBottomDecorationHeight(viewF2) + viewF2.getMeasuredHeight() + ((ViewGroup$MarginLayoutParams) flexboxLayoutManager$LayoutParams2).topMargin + fMax2 + topDecorationHeight3;
                        topDecorationHeight2 = bottomDecorationHeight - ((getTopDecorationHeight(viewF2) + (viewF2.getMeasuredHeight() + ((ViewGroup$MarginLayoutParams) flexboxLayoutManager$LayoutParams2).bottomMargin)) + fMax2);
                        f6 = bottomDecorationHeight2;
                        i29 = i33;
                    }
                    i28 = i6 + 1;
                    i13 = i13;
                    i14 = i14;
                    i27 = i7;
                    i26 = i8;
                }
                i3 = i13;
                i4 = i14;
                flexboxLayoutManager$c.c += this.u.i;
                i5 = bVar.g;
            }
            i14 = i4 + i5;
            if (zI || !this.o) {
                flexboxLayoutManager$c.e = (bVar.g * flexboxLayoutManager$c.i) + flexboxLayoutManager$c.e;
            } else {
                flexboxLayoutManager$c.e -= bVar.g * flexboxLayoutManager$c.i;
            }
            i13 = i3 - bVar.g;
            i12 = i;
        }
        int i34 = i12;
        int i35 = i14;
        int i36 = flexboxLayoutManager$c.a - i35;
        flexboxLayoutManager$c.a = i36;
        int i37 = flexboxLayoutManager$c.f;
        if (i37 != Integer.MIN_VALUE) {
            int i38 = i37 + i35;
            flexboxLayoutManager$c.f = i38;
            if (i36 < 0) {
                flexboxLayoutManager$c.f = i38 + i36;
            }
            v(recyclerView$Recycler, flexboxLayoutManager$c);
        }
        return i34 - flexboxLayoutManager$c.a;
    }

    public final View n(int i) {
        View viewS = s(0, getChildCount(), i);
        if (viewS == null) {
            return null;
        }
        int i2 = this.r.c[getPosition(viewS)];
        if (i2 == -1) {
            return null;
        }
        return o(viewS, this.q.get(i2));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    public final View o(View view, b bVar) {
        boolean zI = i();
        int i = bVar.h;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.o || zI) {
                    if (this.w.getDecoratedStart(view) > this.w.getDecoratedStart(childAt)) {
                        view = childAt;
                    }
                } else if (this.w.getDecoratedEnd(view) < this.w.getDecoratedEnd(childAt)) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onAdapterChanged(RecyclerView$Adapter recyclerView$Adapter, RecyclerView$Adapter recyclerView$Adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.F = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView$Recycler recyclerView$Recycler) {
        super.onDetachedFromWindow(recyclerView, recyclerView$Recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        y(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onItemsMoved(@NonNull RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        y(Math.min(i, i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        y(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        y(i);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0181  */
    /* JADX WARN: Code duplicated, block: B:102:0x0183  */
    /* JADX WARN: Code duplicated, block: B:105:0x018a  */
    /* JADX WARN: Code duplicated, block: B:110:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:169:0x0290  */
    /* JADX WARN: Code duplicated, block: B:79:0x0100  */
    /* JADX WARN: Code duplicated, block: B:81:0x0104  */
    /* JADX WARN: Code duplicated, block: B:83:0x010c  */
    /* JADX WARN: Code duplicated, block: B:85:0x011a  */
    /* JADX WARN: Code duplicated, block: B:86:0x011f  */
    /* JADX WARN: Code duplicated, block: B:88:0x012e  */
    /* JADX WARN: Code duplicated, block: B:89:0x013a  */
    /* JADX WARN: Code duplicated, block: B:91:0x0149  */
    /* JADX WARN: Code duplicated, block: B:92:0x0154  */
    /* JADX WARN: Code duplicated, block: B:94:0x0158  */
    /* JADX WARN: Code duplicated, block: B:95:0x0166  */
    /* JADX WARN: Code duplicated, block: B:97:0x016f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0175  */
    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onLayoutChildren(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        boolean z2;
        boolean z3;
        int i;
        View viewFindViewByPosition;
        boolean z4;
        int decoratedStart;
        boolean z5;
        int i2;
        int i3;
        int i4;
        this.f2987s = recyclerView$Recycler;
        this.t = recyclerView$State;
        int itemCount = recyclerView$State.getItemCount();
        if (itemCount == 0 && recyclerView$State.isPreLayout()) {
            return;
        }
        int layoutDirection = getLayoutDirection();
        int i5 = this.k;
        if (i5 == 0) {
            this.o = layoutDirection == 1;
            this.p = this.l == 2;
        } else if (i5 == 1) {
            this.o = layoutDirection != 1;
            this.p = this.l == 2;
        } else if (i5 == 2) {
            boolean z6 = layoutDirection == 1;
            this.o = z6;
            if (this.l == 2) {
                this.o = !z6;
            }
            this.p = false;
        } else if (i5 != 3) {
            this.o = false;
            this.p = false;
        } else {
            boolean z7 = layoutDirection == 1;
            this.o = z7;
            if (this.l == 2) {
                this.o = !z7;
            }
            this.p = true;
        }
        l();
        if (this.u == null) {
            this.u = new FlexboxLayoutManager$c(null);
        }
        this.r.j(itemCount);
        this.r.k(itemCount);
        this.r.i(itemCount);
        this.u.j = false;
        FlexboxLayoutManager$SavedState flexboxLayoutManager$SavedState = this.f2989y;
        if (flexboxLayoutManager$SavedState != null) {
            int i6 = flexboxLayoutManager$SavedState.j;
            if (i6 >= 0 && i6 < itemCount) {
                this.f2990z = i6;
            }
        }
        FlexboxLayoutManager$b flexboxLayoutManager$b = this.v;
        if (!flexboxLayoutManager$b.f || this.f2990z != -1 || flexboxLayoutManager$SavedState != null) {
            FlexboxLayoutManager$b.b(flexboxLayoutManager$b);
            FlexboxLayoutManager$b flexboxLayoutManager$b2 = this.v;
            FlexboxLayoutManager$SavedState flexboxLayoutManager$SavedState2 = this.f2989y;
            if (recyclerView$State.isPreLayout() || (i = this.f2990z) == -1) {
                z2 = false;
            } else if (i < 0 || i >= recyclerView$State.getItemCount()) {
                this.f2990z = -1;
                this.A = Integer.MIN_VALUE;
                z2 = false;
            } else {
                int i7 = this.f2990z;
                flexboxLayoutManager$b2.a = i7;
                flexboxLayoutManager$b2.f2991b = this.r.c[i7];
                FlexboxLayoutManager$SavedState flexboxLayoutManager$SavedState3 = this.f2989y;
                if (flexboxLayoutManager$SavedState3 != null) {
                    int itemCount2 = recyclerView$State.getItemCount();
                    int i8 = flexboxLayoutManager$SavedState3.j;
                    if (i8 >= 0 && i8 < itemCount2) {
                        flexboxLayoutManager$b2.c = this.w.getStartAfterPadding() + flexboxLayoutManager$SavedState2.k;
                        flexboxLayoutManager$b2.g = true;
                        flexboxLayoutManager$b2.f2991b = -1;
                    } else if (this.A == Integer.MIN_VALUE) {
                        viewFindViewByPosition = findViewByPosition(this.f2990z);
                        if (viewFindViewByPosition != null) {
                            if (getChildCount() > 0) {
                                if (this.f2990z < getPosition(getChildAt(0))) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                flexboxLayoutManager$b2.e = z4;
                            }
                            FlexboxLayoutManager$b.a(flexboxLayoutManager$b2);
                        } else if (this.w.getDecoratedMeasurement(viewFindViewByPosition) > this.w.getTotalSpace()) {
                            FlexboxLayoutManager$b.a(flexboxLayoutManager$b2);
                        } else if (this.w.getDecoratedStart(viewFindViewByPosition) - this.w.getStartAfterPadding() < 0) {
                            flexboxLayoutManager$b2.c = this.w.getStartAfterPadding();
                            flexboxLayoutManager$b2.e = false;
                        } else if (this.w.getEndAfterPadding() - this.w.getDecoratedEnd(viewFindViewByPosition) < 0) {
                            flexboxLayoutManager$b2.c = this.w.getEndAfterPadding();
                            flexboxLayoutManager$b2.e = true;
                        } else {
                            if (flexboxLayoutManager$b2.e) {
                                decoratedStart = this.w.getTotalSpaceChange() + this.w.getDecoratedEnd(viewFindViewByPosition);
                            } else {
                                decoratedStart = this.w.getDecoratedStart(viewFindViewByPosition);
                            }
                            flexboxLayoutManager$b2.c = decoratedStart;
                        }
                    } else if (i() && this.o) {
                        flexboxLayoutManager$b2.c = this.A - this.w.getEndPadding();
                    } else {
                        flexboxLayoutManager$b2.c = this.w.getStartAfterPadding() + this.A;
                    }
                } else if (this.A == Integer.MIN_VALUE) {
                    viewFindViewByPosition = findViewByPosition(this.f2990z);
                    if (viewFindViewByPosition != null) {
                        if (getChildCount() > 0) {
                            if (this.f2990z < getPosition(getChildAt(0))) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            flexboxLayoutManager$b2.e = z4;
                        }
                        FlexboxLayoutManager$b.a(flexboxLayoutManager$b2);
                    } else if (this.w.getDecoratedMeasurement(viewFindViewByPosition) > this.w.getTotalSpace()) {
                        FlexboxLayoutManager$b.a(flexboxLayoutManager$b2);
                    } else if (this.w.getDecoratedStart(viewFindViewByPosition) - this.w.getStartAfterPadding() < 0) {
                        flexboxLayoutManager$b2.c = this.w.getStartAfterPadding();
                        flexboxLayoutManager$b2.e = false;
                    } else if (this.w.getEndAfterPadding() - this.w.getDecoratedEnd(viewFindViewByPosition) < 0) {
                        flexboxLayoutManager$b2.c = this.w.getEndAfterPadding();
                        flexboxLayoutManager$b2.e = true;
                    } else {
                        if (flexboxLayoutManager$b2.e) {
                            decoratedStart = this.w.getTotalSpaceChange() + this.w.getDecoratedEnd(viewFindViewByPosition);
                        } else {
                            decoratedStart = this.w.getDecoratedStart(viewFindViewByPosition);
                        }
                        flexboxLayoutManager$b2.c = decoratedStart;
                    }
                } else if (i()) {
                    flexboxLayoutManager$b2.c = this.w.getStartAfterPadding() + this.A;
                } else {
                    flexboxLayoutManager$b2.c = this.w.getStartAfterPadding() + this.A;
                }
                z2 = true;
            }
            if (!z2) {
                if (getChildCount() != 0) {
                    View viewP = flexboxLayoutManager$b2.e ? p(recyclerView$State.getItemCount()) : n(recyclerView$State.getItemCount());
                    if (viewP != null) {
                        FlexboxLayoutManager flexboxLayoutManager = flexboxLayoutManager$b2.h;
                        OrientationHelper orientationHelper = flexboxLayoutManager.l == 0 ? flexboxLayoutManager.f2988x : flexboxLayoutManager.w;
                        if (flexboxLayoutManager.i() || !flexboxLayoutManager$b2.h.o) {
                            if (flexboxLayoutManager$b2.e) {
                                flexboxLayoutManager$b2.c = orientationHelper.getTotalSpaceChange() + orientationHelper.getDecoratedEnd(viewP);
                            } else {
                                flexboxLayoutManager$b2.c = orientationHelper.getDecoratedStart(viewP);
                            }
                        } else if (flexboxLayoutManager$b2.e) {
                            flexboxLayoutManager$b2.c = orientationHelper.getTotalSpaceChange() + orientationHelper.getDecoratedStart(viewP);
                        } else {
                            flexboxLayoutManager$b2.c = orientationHelper.getDecoratedEnd(viewP);
                        }
                        int position = flexboxLayoutManager$b2.h.getPosition(viewP);
                        flexboxLayoutManager$b2.a = position;
                        flexboxLayoutManager$b2.g = false;
                        FlexboxLayoutManager flexboxLayoutManager2 = flexboxLayoutManager$b2.h;
                        int[] iArr = flexboxLayoutManager2.r.c;
                        if (position == -1) {
                            position = 0;
                        }
                        int i9 = iArr[position];
                        if (i9 == -1) {
                            i9 = 0;
                        }
                        flexboxLayoutManager$b2.f2991b = i9;
                        int size = flexboxLayoutManager2.q.size();
                        int i10 = flexboxLayoutManager$b2.f2991b;
                        if (size > i10) {
                            flexboxLayoutManager$b2.a = flexboxLayoutManager$b2.h.q.get(i10).o;
                        }
                        if (!recyclerView$State.isPreLayout() && supportsPredictiveItemAnimations()) {
                            if (this.w.getDecoratedStart(viewP) >= this.w.getEndAfterPadding() || this.w.getDecoratedEnd(viewP) < this.w.getStartAfterPadding()) {
                                flexboxLayoutManager$b2.c = flexboxLayoutManager$b2.e ? this.w.getEndAfterPadding() : this.w.getStartAfterPadding();
                            }
                        }
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                } else {
                    z3 = false;
                }
                if (!z3) {
                    FlexboxLayoutManager$b.a(flexboxLayoutManager$b2);
                    flexboxLayoutManager$b2.a = 0;
                    flexboxLayoutManager$b2.f2991b = 0;
                }
            }
            this.v.f = true;
        }
        detachAndScrapAttachedViews(recyclerView$Recycler);
        FlexboxLayoutManager$b flexboxLayoutManager$b3 = this.v;
        if (flexboxLayoutManager$b3.e) {
            A(flexboxLayoutManager$b3, false, true);
        } else {
            z(flexboxLayoutManager$b3, false, true);
        }
        int iMakeMeasureSpec = View$MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View$MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (i()) {
            int i11 = this.B;
            z5 = (i11 == Integer.MIN_VALUE || i11 == width) ? false : true;
            FlexboxLayoutManager$c flexboxLayoutManager$c = this.u;
            i2 = flexboxLayoutManager$c.f2992b ? this.E.getResources().getDisplayMetrics().heightPixels : flexboxLayoutManager$c.a;
        } else {
            int i12 = this.C;
            z5 = (i12 == Integer.MIN_VALUE || i12 == height) ? false : true;
            FlexboxLayoutManager$c flexboxLayoutManager$c2 = this.u;
            i2 = flexboxLayoutManager$c2.f2992b ? this.E.getResources().getDisplayMetrics().widthPixels : flexboxLayoutManager$c2.a;
        }
        int i13 = i2;
        this.B = width;
        this.C = height;
        int i14 = this.G;
        if (i14 != -1 || (this.f2990z == -1 && !z5)) {
            int iMin = i14 != -1 ? Math.min(i14, this.v.a) : this.v.a;
            this.H.a();
            if (i()) {
                if (this.q.size() > 0) {
                    this.r.d(this.q, iMin);
                    this.r.b(this.H, iMakeMeasureSpec, iMakeMeasureSpec2, i13, iMin, this.v.a, this.q);
                } else {
                    this.r.i(itemCount);
                    this.r.b(this.H, iMakeMeasureSpec, iMakeMeasureSpec2, i13, 0, -1, this.q);
                }
            } else if (this.q.size() > 0) {
                this.r.d(this.q, iMin);
                this.r.b(this.H, iMakeMeasureSpec2, iMakeMeasureSpec, i13, iMin, this.v.a, this.q);
            } else {
                this.r.i(itemCount);
                this.r.b(this.H, iMakeMeasureSpec2, iMakeMeasureSpec, i13, 0, -1, this.q);
            }
            this.q = this.H.a;
            this.r.h(iMakeMeasureSpec, iMakeMeasureSpec2, iMin);
            this.r.A(iMin);
        } else if (!this.v.e) {
            this.q.clear();
            this.H.a();
            if (i()) {
                this.r.b(this.H, iMakeMeasureSpec, iMakeMeasureSpec2, i13, 0, this.v.a, this.q);
            } else {
                this.r.b(this.H, iMakeMeasureSpec2, iMakeMeasureSpec, i13, 0, this.v.a, this.q);
            }
            this.q = this.H.a;
            this.r.h(iMakeMeasureSpec, iMakeMeasureSpec2, 0);
            this.r.A(0);
            FlexboxLayoutManager$b flexboxLayoutManager$b4 = this.v;
            int i15 = this.r.c[flexboxLayoutManager$b4.a];
            flexboxLayoutManager$b4.f2991b = i15;
            this.u.c = i15;
        }
        if (this.v.e) {
            m(recyclerView$Recycler, recyclerView$State, this.u);
            i4 = this.u.e;
            z(this.v, true, false);
            m(recyclerView$Recycler, recyclerView$State, this.u);
            i3 = this.u.e;
        } else {
            m(recyclerView$Recycler, recyclerView$State, this.u);
            i3 = this.u.e;
            A(this.v, true, false);
            m(recyclerView$Recycler, recyclerView$State, this.u);
            i4 = this.u.e;
        }
        if (getChildCount() > 0) {
            if (this.v.e) {
                fixLayoutStartGap(fixLayoutEndGap(i3, recyclerView$Recycler, recyclerView$State, true) + i4, recyclerView$Recycler, recyclerView$State, false);
            } else {
                fixLayoutEndGap(fixLayoutStartGap(i4, recyclerView$Recycler, recyclerView$State, true) + i3, recyclerView$Recycler, recyclerView$State, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onLayoutCompleted(RecyclerView$State recyclerView$State) {
        super.onLayoutCompleted(recyclerView$State);
        this.f2989y = null;
        this.f2990z = -1;
        this.A = Integer.MIN_VALUE;
        this.G = -1;
        FlexboxLayoutManager$b.b(this.v);
        this.D.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof FlexboxLayoutManager$SavedState) {
            this.f2989y = (FlexboxLayoutManager$SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public Parcelable onSaveInstanceState() {
        FlexboxLayoutManager$SavedState flexboxLayoutManager$SavedState = this.f2989y;
        if (flexboxLayoutManager$SavedState != null) {
            return new FlexboxLayoutManager$SavedState(flexboxLayoutManager$SavedState, (FlexboxLayoutManager$a) null);
        }
        FlexboxLayoutManager$SavedState flexboxLayoutManager$SavedState2 = new FlexboxLayoutManager$SavedState();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            flexboxLayoutManager$SavedState2.j = getPosition(childAt);
            flexboxLayoutManager$SavedState2.k = this.w.getDecoratedStart(childAt) - this.w.getStartAfterPadding();
        } else {
            flexboxLayoutManager$SavedState2.j = -1;
        }
        return flexboxLayoutManager$SavedState2;
    }

    public final View p(int i) {
        View viewS = s(getChildCount() - 1, -1, i);
        if (viewS == null) {
            return null;
        }
        return q(viewS, this.q.get(this.r.c[getPosition(viewS)]));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    public final View q(View view, b bVar) {
        boolean zI = i();
        int childCount = (getChildCount() - bVar.h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.o || zI) {
                    if (this.w.getDecoratedEnd(view) < this.w.getDecoratedEnd(childAt)) {
                        view = childAt;
                    }
                } else if (this.w.getDecoratedStart(view) > this.w.getDecoratedStart(childAt)) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final View r(int i, int i2, boolean z2) {
        int i3 = i;
        int i4 = i2 > i3 ? 1 : -1;
        while (i3 != i2) {
            View childAt = getChildAt(i3);
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int decoratedLeft = getDecoratedLeft(childAt) - ((ViewGroup$MarginLayoutParams) ((RecyclerView$LayoutParams) childAt.getLayoutParams())).leftMargin;
            int decoratedTop = getDecoratedTop(childAt) - ((ViewGroup$MarginLayoutParams) ((RecyclerView$LayoutParams) childAt.getLayoutParams())).topMargin;
            int decoratedRight = getDecoratedRight(childAt) + ((ViewGroup$MarginLayoutParams) ((RecyclerView$LayoutParams) childAt.getLayoutParams())).rightMargin;
            int decoratedBottom = getDecoratedBottom(childAt) + ((ViewGroup$MarginLayoutParams) ((RecyclerView$LayoutParams) childAt.getLayoutParams())).bottomMargin;
            boolean z3 = false;
            boolean z4 = paddingLeft <= decoratedLeft && width >= decoratedRight;
            boolean z5 = decoratedLeft >= width || decoratedRight >= paddingLeft;
            boolean z6 = paddingTop <= decoratedTop && height >= decoratedBottom;
            boolean z7 = decoratedTop >= height || decoratedBottom >= paddingTop;
            if (!z2 ? !(!z5 || !z7) : !(!z4 || !z6)) {
                z3 = true;
            }
            if (z3) {
                return childAt;
            }
            i3 += i4;
        }
        return null;
    }

    public final View s(int i, int i2, int i3) {
        l();
        View view = null;
        if (this.u == null) {
            this.u = new FlexboxLayoutManager$c(null);
        }
        int startAfterPadding = this.w.getStartAfterPadding();
        int endAfterPadding = this.w.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView$LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.w.getDecoratedStart(childAt) >= startAfterPadding && this.w.getDecoratedEnd(childAt) <= endAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        if (!i() || (this.l == 0 && i())) {
            int iT = t(i, recyclerView$Recycler, recyclerView$State);
            this.D.clear();
            return iT;
        }
        int iU = u(i);
        this.v.d += iU;
        this.f2988x.offsetChildren(-iU);
        return iU;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void scrollToPosition(int i) {
        this.f2990z = i;
        this.A = Integer.MIN_VALUE;
        FlexboxLayoutManager$SavedState flexboxLayoutManager$SavedState = this.f2989y;
        if (flexboxLayoutManager$SavedState != null) {
            flexboxLayoutManager$SavedState.j = -1;
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        if (i() || (this.l == 0 && !i())) {
            int iT = t(i, recyclerView$Recycler, recyclerView$State);
            this.D.clear();
            return iT;
        }
        int iU = u(i);
        this.v.d += iU;
        this.f2988x.offsetChildren(-iU);
        return iU;
    }

    @Override // b.i.a.e.a
    public void setFlexLines(List<b> list) {
        this.q = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView$State recyclerView$State, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    /* JADX WARN: Code duplicated, block: B:75:0x01ee  */
    public final int t(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        int i2;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        l();
        this.u.j = true;
        boolean z2 = !i() && this.o;
        int i3 = (!z2 ? i > 0 : i < 0) ? -1 : 1;
        int iAbs = Math.abs(i);
        this.u.i = i3;
        boolean zI = i();
        int iMakeMeasureSpec = View$MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View$MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z3 = !zI && this.o;
        if (i3 == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.u.e = this.w.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View viewQ = q(childAt, this.q.get(this.r.c[position]));
            FlexboxLayoutManager$c flexboxLayoutManager$c = this.u;
            flexboxLayoutManager$c.h = 1;
            int i4 = position + 1;
            flexboxLayoutManager$c.d = i4;
            int[] iArr = this.r.c;
            if (iArr.length <= i4) {
                flexboxLayoutManager$c.c = -1;
            } else {
                flexboxLayoutManager$c.c = iArr[i4];
            }
            if (z3) {
                flexboxLayoutManager$c.e = this.w.getDecoratedStart(viewQ);
                this.u.f = this.w.getStartAfterPadding() + (-this.w.getDecoratedStart(viewQ));
                FlexboxLayoutManager$c flexboxLayoutManager$c2 = this.u;
                int i5 = flexboxLayoutManager$c2.f;
                if (i5 < 0) {
                    i5 = 0;
                }
                flexboxLayoutManager$c2.f = i5;
            } else {
                flexboxLayoutManager$c.e = this.w.getDecoratedEnd(viewQ);
                this.u.f = this.w.getDecoratedEnd(viewQ) - this.w.getEndAfterPadding();
            }
            int i6 = this.u.c;
            if ((i6 == -1 || i6 > this.q.size() - 1) && this.u.d <= getFlexItemCount()) {
                int i7 = iAbs - this.u.f;
                this.H.a();
                if (i7 > 0) {
                    if (zI) {
                        this.r.b(this.H, iMakeMeasureSpec, iMakeMeasureSpec2, i7, this.u.d, -1, this.q);
                    } else {
                        this.r.b(this.H, iMakeMeasureSpec2, iMakeMeasureSpec, i7, this.u.d, -1, this.q);
                    }
                    this.r.h(iMakeMeasureSpec, iMakeMeasureSpec2, this.u.d);
                    this.r.A(this.u.d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.u.e = this.w.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View viewO = o(childAt2, this.q.get(this.r.c[position2]));
            FlexboxLayoutManager$c flexboxLayoutManager$c3 = this.u;
            flexboxLayoutManager$c3.h = 1;
            int i8 = this.r.c[position2];
            if (i8 == -1) {
                i8 = 0;
            }
            if (i8 > 0) {
                this.u.d = position2 - this.q.get(i8 - 1).h;
            } else {
                flexboxLayoutManager$c3.d = -1;
            }
            FlexboxLayoutManager$c flexboxLayoutManager$c4 = this.u;
            flexboxLayoutManager$c4.c = i8 > 0 ? i8 - 1 : 0;
            if (z3) {
                flexboxLayoutManager$c4.e = this.w.getDecoratedEnd(viewO);
                this.u.f = this.w.getDecoratedEnd(viewO) - this.w.getEndAfterPadding();
                FlexboxLayoutManager$c flexboxLayoutManager$c5 = this.u;
                int i9 = flexboxLayoutManager$c5.f;
                if (i9 < 0) {
                    i9 = 0;
                }
                flexboxLayoutManager$c5.f = i9;
            } else {
                flexboxLayoutManager$c4.e = this.w.getDecoratedStart(viewO);
                this.u.f = this.w.getStartAfterPadding() + (-this.w.getDecoratedStart(viewO));
            }
        }
        FlexboxLayoutManager$c flexboxLayoutManager$c6 = this.u;
        int i10 = flexboxLayoutManager$c6.f;
        flexboxLayoutManager$c6.a = iAbs - i10;
        int iM = m(recyclerView$Recycler, recyclerView$State, flexboxLayoutManager$c6) + i10;
        if (iM < 0) {
            return 0;
        }
        if (z2) {
            if (iAbs > iM) {
                i2 = (-i3) * iM;
            } else {
                i2 = i;
            }
        } else if (iAbs > iM) {
            i2 = i3 * iM;
        } else {
            i2 = i;
        }
        this.w.offsetChildren(-i2);
        this.u.g = i2;
        return i2;
    }

    public final int u(int i) {
        int i2;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        l();
        boolean zI = i();
        View view = this.F;
        int width = zI ? view.getWidth() : view.getHeight();
        int width2 = zI ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int iAbs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.v.d) - width, iAbs);
            }
            i2 = this.v.d;
            if (i2 + i <= 0) {
                return i;
            }
        } else {
            if (i > 0) {
                return Math.min((width2 - this.v.d) - width, i);
            }
            i2 = this.v.d;
            if (i2 + i >= 0) {
                return i;
            }
        }
        return -i2;
    }

    public final void v(RecyclerView$Recycler recyclerView$Recycler, FlexboxLayoutManager$c flexboxLayoutManager$c) {
        int childCount;
        if (flexboxLayoutManager$c.j) {
            int i = -1;
            if (flexboxLayoutManager$c.i != -1) {
                if (flexboxLayoutManager$c.f >= 0 && (childCount = getChildCount()) != 0) {
                    int i2 = this.r.c[getPosition(getChildAt(0))];
                    if (i2 == -1) {
                        return;
                    }
                    b bVar = this.q.get(i2);
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = getChildAt(i3);
                        int i4 = flexboxLayoutManager$c.f;
                        if (!(i() || !this.o ? this.w.getDecoratedEnd(childAt) <= i4 : this.w.getEnd() - this.w.getDecoratedStart(childAt) <= i4)) {
                            break;
                        }
                        if (bVar.p == getPosition(childAt)) {
                            if (i2 >= this.q.size() - 1) {
                                i = i3;
                                break;
                            } else {
                                i2 += flexboxLayoutManager$c.i;
                                bVar = this.q.get(i2);
                                i = i3;
                            }
                        }
                    }
                    while (i >= 0) {
                        removeAndRecycleViewAt(i, recyclerView$Recycler);
                        i--;
                    }
                    return;
                }
                return;
            }
            if (flexboxLayoutManager$c.f < 0) {
                return;
            }
            this.w.getEnd();
            int childCount2 = getChildCount();
            if (childCount2 == 0) {
                return;
            }
            int i5 = childCount2 - 1;
            int i6 = this.r.c[getPosition(getChildAt(i5))];
            if (i6 == -1) {
                return;
            }
            b bVar2 = this.q.get(i6);
            for (int i7 = i5; i7 >= 0; i7--) {
                View childAt2 = getChildAt(i7);
                int i8 = flexboxLayoutManager$c.f;
                if (!(i() || !this.o ? this.w.getDecoratedStart(childAt2) >= this.w.getEnd() - i8 : this.w.getDecoratedEnd(childAt2) <= i8)) {
                    break;
                }
                if (bVar2.o == getPosition(childAt2)) {
                    if (i6 <= 0) {
                        childCount2 = i7;
                        break;
                    } else {
                        i6 += flexboxLayoutManager$c.i;
                        bVar2 = this.q.get(i6);
                        childCount2 = i7;
                    }
                }
            }
            while (i5 >= childCount2) {
                removeAndRecycleViewAt(i5, recyclerView$Recycler);
                i5--;
            }
        }
    }

    public final void w() {
        int heightMode = i() ? getHeightMode() : getWidthMode();
        this.u.f2992b = heightMode == 0 || heightMode == Integer.MIN_VALUE;
    }

    public void x(int i) {
        if (this.k != i) {
            removeAllViews();
            this.k = i;
            this.w = null;
            this.f2988x = null;
            k();
            requestLayout();
        }
    }

    public final void y(int i) {
        if (i >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.r.j(childCount);
        this.r.k(childCount);
        this.r.i(childCount);
        if (i >= this.r.c.length) {
            return;
        }
        this.G = i;
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        this.f2990z = getPosition(childAt);
        if (i() || !this.o) {
            this.A = this.w.getDecoratedStart(childAt) - this.w.getStartAfterPadding();
        } else {
            this.A = this.w.getEndPadding() + this.w.getDecoratedEnd(childAt);
        }
    }

    public final void z(FlexboxLayoutManager$b flexboxLayoutManager$b, boolean z2, boolean z3) {
        int i;
        if (z3) {
            w();
        } else {
            this.u.f2992b = false;
        }
        if (i() || !this.o) {
            this.u.a = this.w.getEndAfterPadding() - flexboxLayoutManager$b.c;
        } else {
            this.u.a = flexboxLayoutManager$b.c - getPaddingRight();
        }
        FlexboxLayoutManager$c flexboxLayoutManager$c = this.u;
        flexboxLayoutManager$c.d = flexboxLayoutManager$b.a;
        flexboxLayoutManager$c.h = 1;
        flexboxLayoutManager$c.i = 1;
        flexboxLayoutManager$c.e = flexboxLayoutManager$b.c;
        flexboxLayoutManager$c.f = Integer.MIN_VALUE;
        flexboxLayoutManager$c.c = flexboxLayoutManager$b.f2991b;
        if (!z2 || this.q.size() <= 1 || (i = flexboxLayoutManager$b.f2991b) < 0 || i >= this.q.size() - 1) {
            return;
        }
        b bVar = this.q.get(flexboxLayoutManager$b.f2991b);
        FlexboxLayoutManager$c flexboxLayoutManager$c2 = this.u;
        flexboxLayoutManager$c2.c++;
        flexboxLayoutManager$c2.d += bVar.h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        y(i);
    }
}
