package b.i.a.e;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import b.d.b.a.outline;
import com.google.android.flexbox.FlexItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.e.c, reason: use source file name */
/* JADX INFO: compiled from: FlexboxHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class FlexboxHelper {
    public final FlexContainer a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean[] f1328b;

    @Nullable
    public int[] c;

    @Nullable
    public long[] d;

    @Nullable
    public long[] e;

    /* JADX INFO: renamed from: b.i.a.e.c$b */
    /* JADX INFO: compiled from: FlexboxHelper.java */
    public static class b {
        public List<FlexLine> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1329b;

        public void a() {
            this.a = null;
            this.f1329b = 0;
        }
    }

    /* JADX INFO: renamed from: b.i.a.e.c$c */
    /* JADX INFO: compiled from: FlexboxHelper.java */
    public static class c implements Comparable<c> {
        public int j;
        public int k;

        public c() {
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull c cVar) {
            c cVar2 = cVar;
            int i = this.k;
            int i2 = cVar2.k;
            return i != i2 ? i - i2 : this.j - cVar2.j;
        }

        @NonNull
        public String toString() {
            StringBuilder sbU = outline.U("Order{order=");
            sbU.append(this.k);
            sbU.append(", index=");
            return outline.A(sbU, this.j, '}');
        }

        public c(a aVar) {
        }
    }

    public FlexboxHelper(FlexContainer flexContainer) {
        this.a = flexContainer;
    }

    public void A(int i) {
        View viewC;
        if (i >= this.a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.a.getFlexDirection();
        if (this.a.getAlignItems() != 4) {
            for (FlexLine flexLine : this.a.getFlexLinesInternal()) {
                for (Integer num : flexLine.n) {
                    View viewC2 = this.a.c(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        z(viewC2, flexLine.g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException(outline.q("Invalid flex direction: ", flexDirection));
                        }
                        y(viewC2, flexLine.g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.c;
        List<FlexLine> flexLinesInternal = this.a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
            FlexLine flexLine2 = flexLinesInternal.get(i2);
            int i3 = flexLine2.h;
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = flexLine2.o + i4;
                if (i4 < this.a.getFlexItemCount() && (viewC = this.a.c(i5)) != null && viewC.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) viewC.getLayoutParams();
                    if (flexItem.u() == -1 || flexItem.u() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            z(viewC, flexLine2.g, i5);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException(outline.q("Invalid flex direction: ", flexDirection));
                            }
                            y(viewC, flexLine2.g, i5);
                        }
                    }
                }
            }
        }
    }

    public final void B(int i, int i2, int i3, View view) {
        long[] jArr = this.d;
        if (jArr != null) {
            jArr[i] = (((long) i2) & 4294967295L) | (((long) i3) << 32);
        }
        long[] jArr2 = this.e;
        if (jArr2 != null) {
            jArr2[i] = (((long) view.getMeasuredWidth()) & 4294967295L) | (((long) view.getMeasuredHeight()) << 32);
        }
    }

    public final void a(List<FlexLine> list, FlexLine flexLine, int i, int i2) {
        flexLine.m = i2;
        this.a.b(flexLine);
        flexLine.p = i;
        list.add(flexLine);
    }

    /* JADX WARN: Code duplicated, block: B:77:0x0207  */
    public void b(b bVar, int i, int i2, int i3, int i4, int i5, @Nullable List<FlexLine> list) {
        int i6;
        int i7;
        int iH;
        int i8;
        int i9;
        int i10;
        boolean z2;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z3;
        int minimumHeight;
        int i15;
        boolean zI = this.a.i();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<FlexLine> arrayList = list == null ? new ArrayList<>() : list;
        bVar.a = arrayList;
        boolean z4 = i5 == -1;
        int paddingStart = zI ? this.a.getPaddingStart() : this.a.getPaddingTop();
        int paddingEnd = zI ? this.a.getPaddingEnd() : this.a.getPaddingBottom();
        int paddingTop = zI ? this.a.getPaddingTop() : this.a.getPaddingStart();
        int paddingBottom = zI ? this.a.getPaddingBottom() : this.a.getPaddingEnd();
        FlexLine flexLine = new FlexLine();
        int i16 = i4;
        flexLine.o = i16;
        int i17 = paddingStart + paddingEnd;
        flexLine.e = i17;
        int flexItemCount = this.a.getFlexItemCount();
        int i18 = Integer.MIN_VALUE;
        boolean z5 = z4;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        while (i16 < flexItemCount) {
            int i22 = i19;
            View viewC = this.a.c(i16);
            if (viewC == null) {
                if (t(i16, flexItemCount, flexLine)) {
                    a(arrayList, flexLine, i16, i21);
                }
                i6 = i20;
            } else {
                i6 = i20;
                if (viewC.getVisibility() != 8) {
                    if (viewC instanceof CompoundButton) {
                        CompoundButton compoundButton = (CompoundButton) viewC;
                        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
                        int iD = flexItem.D();
                        int iF0 = flexItem.f0();
                        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
                        int minimumWidth = buttonDrawable == null ? 0 : buttonDrawable.getMinimumWidth();
                        if (buttonDrawable == null) {
                            i15 = -1;
                            minimumHeight = 0;
                        } else {
                            minimumHeight = buttonDrawable.getMinimumHeight();
                            i15 = -1;
                        }
                        if (iD == i15) {
                            iD = minimumWidth;
                        }
                        flexItem.H(iD);
                        if (iF0 == i15) {
                            iF0 = minimumHeight;
                        }
                        flexItem.O(iF0);
                    }
                    FlexItem flexItem2 = (FlexItem) viewC.getLayoutParams();
                    if (flexItem2.u() == 4) {
                        flexLine.n.add(Integer.valueOf(i16));
                    }
                    int width = zI ? flexItem2.getWidth() : flexItem2.getHeight();
                    if (flexItem2.W() != -1.0f && mode == 1073741824) {
                        width = Math.round(flexItem2.W() * size);
                    }
                    if (zI) {
                        iH = this.a.d(i, q(flexItem2, true) + s(flexItem2, true) + i17, width);
                        i7 = i2;
                        int iH2 = this.a.h(i7, p(flexItem2, true) + r(flexItem2, true) + paddingTop + paddingBottom + i21, flexItem2.getHeight());
                        viewC.measure(iH, iH2);
                        B(i16, iH, iH2, viewC);
                    } else {
                        i7 = i2;
                        int iD2 = this.a.d(i7, p(flexItem2, false) + r(flexItem2, false) + paddingTop + paddingBottom + i21, flexItem2.getWidth());
                        iH = this.a.h(i, q(flexItem2, false) + s(flexItem2, false) + i17, width);
                        viewC.measure(iD2, iH);
                        B(i16, iD2, iH, viewC);
                    }
                    this.a.e(i16, viewC);
                    c(viewC, i16);
                    int iCombineMeasuredStates = View.combineMeasuredStates(i6, viewC.getMeasuredState());
                    int i23 = flexLine.e;
                    int iQ = q(flexItem2, zI) + s(flexItem2, zI) + (zI ? viewC.getMeasuredWidth() : viewC.getMeasuredHeight());
                    int size2 = arrayList.size();
                    if (this.a.getFlexWrap() != 0) {
                        if (flexItem2.j0()) {
                            i8 = iCombineMeasuredStates;
                            i9 = i22;
                            i10 = size;
                        } else {
                            if (mode == 0) {
                                i8 = iCombineMeasuredStates;
                            } else {
                                int maxLine = this.a.getMaxLine();
                                i8 = iCombineMeasuredStates;
                                if (maxLine == -1 || maxLine > size2 + 1) {
                                    i9 = i22;
                                    int iG = this.a.g(viewC, i16, i9);
                                    if (iG > 0) {
                                        iQ += iG;
                                    }
                                    i10 = size;
                                    if (i10 < i23 + iQ) {
                                    }
                                }
                                z2 = false;
                            }
                            i9 = i22;
                            i10 = size;
                            z2 = false;
                        }
                        z2 = true;
                    } else {
                        i8 = iCombineMeasuredStates;
                        i9 = i22;
                        i10 = size;
                        z2 = false;
                    }
                    if (z2) {
                        if (flexLine.a() > 0) {
                            arrayList = arrayList;
                            a(arrayList, flexLine, i16 > 0 ? i16 - 1 : 0, i21);
                            i21 += flexLine.g;
                        }
                        if (zI) {
                            arrayList = arrayList;
                            if (flexItem2.getHeight() == -1) {
                                FlexContainer flexContainer = this.a;
                                viewC.measure(iH, flexContainer.h(i7, flexItem2.I() + flexItem2.N() + this.a.getPaddingBottom() + flexContainer.getPaddingTop() + i21, flexItem2.getHeight()));
                                c(viewC, i16);
                            }
                        } else {
                            arrayList = arrayList;
                            if (flexItem2.getWidth() == -1) {
                                FlexContainer flexContainer2 = this.a;
                                viewC.measure(flexContainer2.d(i7, flexItem2.d0() + flexItem2.J() + this.a.getPaddingRight() + flexContainer2.getPaddingLeft() + i21, flexItem2.getWidth()), iH);
                                c(viewC, i16);
                            }
                        }
                        flexLine = new FlexLine();
                        flexLine.h = 1;
                        flexLine.e = i17;
                        flexLine.o = i16;
                        i11 = 0;
                        i12 = Integer.MIN_VALUE;
                    } else {
                        arrayList = arrayList;
                        flexLine.h++;
                        i11 = i9 + 1;
                        i12 = i18;
                    }
                    flexLine.q |= flexItem2.S() != 0.0f;
                    flexLine.r |= flexItem2.x() != 0.0f;
                    int[] iArr = this.c;
                    if (iArr != null) {
                        iArr[i16] = arrayList.size();
                    }
                    flexLine.e = q(flexItem2, zI) + s(flexItem2, zI) + (zI ? viewC.getMeasuredWidth() : viewC.getMeasuredHeight()) + flexLine.e;
                    flexLine.j = flexItem2.S() + flexLine.j;
                    flexLine.k = flexItem2.x() + flexLine.k;
                    this.a.a(viewC, i16, i11, flexLine);
                    i13 = i10;
                    int iMax = Math.max(i12, this.a.j(viewC) + p(flexItem2, zI) + r(flexItem2, zI) + (zI ? viewC.getMeasuredHeight() : viewC.getMeasuredWidth()));
                    flexLine.g = Math.max(flexLine.g, iMax);
                    if (zI) {
                        if (this.a.getFlexWrap() != 2) {
                            flexLine.l = Math.max(flexLine.l, flexItem2.N() + viewC.getBaseline());
                        } else {
                            flexLine.l = Math.max(flexLine.l, flexItem2.I() + (viewC.getMeasuredHeight() - viewC.getBaseline()));
                        }
                    }
                    i14 = flexItemCount;
                    if (t(i16, i14, flexLine)) {
                        a(arrayList, flexLine, i16, i21);
                        i21 += flexLine.g;
                    }
                    if (i5 == -1 || arrayList.size() <= 0 || arrayList.get(arrayList.size() - 1).p < i5 || i16 < i5 || z5) {
                        z3 = z5;
                    } else {
                        i21 = -flexLine.g;
                        z3 = true;
                    }
                    if (i21 > i3 && z3) {
                        i20 = i8;
                        break;
                    } else {
                        i18 = iMax;
                        i22 = i11;
                        i20 = i8;
                    }
                } else {
                    flexLine.i++;
                    flexLine.h++;
                    if (t(i16, flexItemCount, flexLine)) {
                        a(arrayList, flexLine, i16, i21);
                    }
                }
                i16++;
                flexItemCount = i14;
                z5 = z3;
                i19 = i22;
                size = i13;
                mode = mode;
            }
            z3 = z5;
            mode = mode;
            i13 = size;
            i14 = flexItemCount;
            i20 = i6;
            i7 = i2;
            i16++;
            flexItemCount = i14;
            z5 = z3;
            i19 = i22;
            size = i13;
            mode = mode;
        }
        bVar.f1329b = i20;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    public final void c(View view, int i) {
        boolean z2;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z3 = true;
        if (measuredWidth >= flexItem.D()) {
            if (measuredWidth > flexItem.t0()) {
                measuredWidth = flexItem.t0();
            } else {
                z2 = false;
            }
            if (measuredHeight < flexItem.f0()) {
                measuredHeight = flexItem.f0();
            } else if (measuredHeight > flexItem.m0()) {
                measuredHeight = flexItem.m0();
            } else {
                z3 = z2;
            }
            if (z3) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                B(i, iMakeMeasureSpec, iMakeMeasureSpec2, view);
                this.a.e(i, view);
            }
        }
        measuredWidth = flexItem.D();
        z2 = true;
        if (measuredHeight < flexItem.f0()) {
            measuredHeight = flexItem.f0();
        } else if (measuredHeight > flexItem.m0()) {
            measuredHeight = flexItem.m0();
        } else {
            z3 = z2;
        }
        if (z3) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY);
            int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY);
            view.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
            B(i, iMakeMeasureSpec3, iMakeMeasureSpec4, view);
            this.a.e(i, view);
        }
    }

    public void d(List<FlexLine> list, int i) {
        int i2 = this.c[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int[] iArr = this.c;
        int length = iArr.length - 1;
        if (i > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i, length, -1);
        }
        long[] jArr = this.d;
        int length2 = jArr.length - 1;
        if (i > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i, length2, 0L);
        }
    }

    public final List<FlexLine> e(List<FlexLine> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        FlexLine flexLine = new FlexLine();
        flexLine.g = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(flexLine);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @NonNull
    public final List<c> f(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            FlexItem flexItem = (FlexItem) this.a.f(i2).getLayoutParams();
            c cVar = new c(null);
            cVar.k = flexItem.getOrder();
            cVar.j = i2;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public void g(int i, int i2, int i3) {
        int mode;
        int size;
        int flexDirection = this.a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            mode = mode2;
            size = size2;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException(outline.q("Invalid flex direction: ", flexDirection));
            }
            mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
        }
        List<FlexLine> flexLinesInternal = this.a.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.a.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).g = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.a.getAlignContent();
                if (alignContent == 1) {
                    int i5 = size - sumOfCrossSize;
                    FlexLine flexLine = new FlexLine();
                    flexLine.g = i5;
                    flexLinesInternal.add(0, flexLine);
                    return;
                }
                if (alignContent == 2) {
                    this.a.setFlexLines(e(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= size) {
                        return;
                    }
                    float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size4 = flexLinesInternal.size();
                    float f = 0.0f;
                    while (i4 < size4) {
                        arrayList.add(flexLinesInternal.get(i4));
                        if (i4 != flexLinesInternal.size() - 1) {
                            FlexLine flexLine2 = new FlexLine();
                            if (i4 == flexLinesInternal.size() - 2) {
                                flexLine2.g = Math.round(f + size3);
                                f = 0.0f;
                            } else {
                                flexLine2.g = Math.round(size3);
                            }
                            int i6 = flexLine2.g;
                            float f2 = (size3 - i6) + f;
                            if (f2 > 1.0f) {
                                flexLine2.g = i6 + 1;
                                f2 -= 1.0f;
                            } else if (f2 < -1.0f) {
                                flexLine2.g = i6 - 1;
                                f2 += 1.0f;
                            }
                            arrayList.add(flexLine2);
                            f = f2;
                        }
                        i4++;
                    }
                    this.a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.a.setFlexLines(e(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    FlexLine flexLine3 = new FlexLine();
                    flexLine3.g = size5;
                    for (FlexLine flexLine4 : flexLinesInternal) {
                        arrayList2.add(flexLine3);
                        arrayList2.add(flexLine4);
                        arrayList2.add(flexLine3);
                    }
                    this.a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f3 = 0.0f;
                    while (i4 < size7) {
                        FlexLine flexLine5 = flexLinesInternal.get(i4);
                        float f4 = flexLine5.g + size6;
                        if (i4 == flexLinesInternal.size() - 1) {
                            f4 += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(f4);
                        float f5 = (f4 - iRound) + f3;
                        if (f5 > 1.0f) {
                            iRound++;
                            f5 -= 1.0f;
                        } else if (f5 < -1.0f) {
                            iRound--;
                            f5 += 1.0f;
                        }
                        f3 = f5;
                        flexLine5.g = iRound;
                        i4++;
                    }
                }
            }
        }
    }

    public void h(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        int flexItemCount = this.a.getFlexItemCount();
        boolean[] zArr = this.f1328b;
        if (zArr == null) {
            if (flexItemCount < 10) {
                flexItemCount = 10;
            }
            this.f1328b = new boolean[flexItemCount];
        } else if (zArr.length < flexItemCount) {
            int length = zArr.length * 2;
            if (length >= flexItemCount) {
                flexItemCount = length;
            }
            this.f1328b = new boolean[flexItemCount];
        } else {
            Arrays.fill(zArr, false);
        }
        if (i3 >= this.a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.a.getFlexDirection();
        int flexDirection2 = this.a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.a.getLargestMainSize();
            if (mode != 1073741824 && largestMainSize <= size) {
                size = largestMainSize;
            }
            paddingLeft = this.a.getPaddingLeft();
            paddingRight = this.a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException(outline.q("Invalid flex direction: ", flexDirection));
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.a.getLargestMainSize();
            }
            paddingLeft = this.a.getPaddingTop();
            paddingRight = this.a.getPaddingBottom();
        }
        int i4 = paddingRight + paddingLeft;
        int[] iArr = this.c;
        List<FlexLine> flexLinesInternal = this.a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i5 = iArr != null ? iArr[i3] : 0; i5 < size2; i5++) {
            FlexLine flexLine = flexLinesInternal.get(i5);
            int i6 = flexLine.e;
            if (i6 < size && flexLine.q) {
                l(i, i2, flexLine, size, i4, false);
            } else if (i6 > size && flexLine.r) {
                w(i, i2, flexLine, size, i4, false);
            }
        }
    }

    public void i(int i) {
        int[] iArr = this.c;
        if (iArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.c = new int[i];
        } else if (iArr.length < i) {
            int length = iArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.c = Arrays.copyOf(iArr, i);
        }
    }

    public void j(int i) {
        long[] jArr = this.d;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.d = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.d = Arrays.copyOf(jArr, i);
        }
    }

    public void k(int i) {
        long[] jArr = this.e;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.e = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.e = Arrays.copyOf(jArr, i);
        }
    }

    public final void l(int i, int i2, FlexLine flexLine, int i3, int i4, boolean z2) {
        int i5;
        int i6;
        int iMax;
        double d;
        int i7;
        double d2;
        float f = flexLine.j;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 < (i5 = flexLine.e)) {
            return;
        }
        float f3 = (i3 - i5) / f;
        flexLine.e = i4 + flexLine.f;
        if (!z2) {
            flexLine.g = Integer.MIN_VALUE;
        }
        int i8 = 0;
        boolean z3 = false;
        int i9 = 0;
        float f4 = 0.0f;
        while (i8 < flexLine.h) {
            int i10 = flexLine.o + i8;
            View viewC = this.a.c(i10);
            if (viewC == null || viewC.getVisibility() == 8) {
                i6 = i5;
            } else {
                FlexItem flexItem = (FlexItem) viewC.getLayoutParams();
                int flexDirection = this.a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i11 = i5;
                    int measuredWidth = viewC.getMeasuredWidth();
                    long[] jArr = this.e;
                    if (jArr != null) {
                        measuredWidth = (int) jArr[i10];
                    }
                    int measuredHeight = viewC.getMeasuredHeight();
                    long[] jArr2 = this.e;
                    i6 = i11;
                    if (jArr2 != null) {
                        measuredHeight = m(jArr2[i10]);
                    }
                    if (!this.f1328b[i10] && flexItem.S() > 0.0f) {
                        float fS = (flexItem.S() * f3) + measuredWidth;
                        if (i8 == flexLine.h - 1) {
                            fS += f4;
                            f4 = 0.0f;
                        }
                        int iRound = Math.round(fS);
                        if (iRound > flexItem.t0()) {
                            iRound = flexItem.t0();
                            this.f1328b[i10] = true;
                            flexLine.j -= flexItem.S();
                            z3 = true;
                        } else {
                            float f5 = (fS - iRound) + f4;
                            double d3 = f5;
                            if (d3 > 1.0d) {
                                iRound++;
                                d = d3 - 1.0d;
                            } else {
                                if (d3 < -1.0d) {
                                    iRound--;
                                    d = d3 + 1.0d;
                                }
                                f4 = f5;
                            }
                            f5 = (float) d;
                            f4 = f5;
                        }
                        int iN = n(i2, flexItem, flexLine.m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, BasicMeasure.EXACTLY);
                        viewC.measure(iMakeMeasureSpec, iN);
                        int measuredWidth2 = viewC.getMeasuredWidth();
                        int measuredHeight2 = viewC.getMeasuredHeight();
                        B(i10, iMakeMeasureSpec, iN, viewC);
                        this.a.e(i10, viewC);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i9, this.a.j(viewC) + flexItem.I() + flexItem.N() + measuredHeight);
                    flexLine.e = flexItem.d0() + flexItem.J() + measuredWidth + flexLine.e;
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewC.getMeasuredHeight();
                    long[] jArr3 = this.e;
                    if (jArr3 != null) {
                        measuredHeight3 = m(jArr3[i10]);
                    }
                    int measuredWidth3 = viewC.getMeasuredWidth();
                    long[] jArr4 = this.e;
                    if (jArr4 != null) {
                        measuredWidth3 = (int) jArr4[i10];
                    }
                    if (this.f1328b[i10] || flexItem.S() <= f2) {
                        i7 = i5;
                    } else {
                        float fS2 = (flexItem.S() * f3) + measuredHeight3;
                        if (i8 == flexLine.h - 1) {
                            fS2 += f4;
                            f4 = 0.0f;
                        }
                        int iRound2 = Math.round(fS2);
                        if (iRound2 > flexItem.m0()) {
                            iRound2 = flexItem.m0();
                            this.f1328b[i10] = true;
                            flexLine.j -= flexItem.S();
                            i7 = i5;
                            z3 = true;
                        } else {
                            float f6 = (fS2 - iRound2) + f4;
                            i7 = i5;
                            double d4 = f6;
                            if (d4 > 1.0d) {
                                iRound2++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound2--;
                                d2 = d4 + 1.0d;
                            } else {
                                f4 = f6;
                            }
                            f4 = (float) d2;
                        }
                        int iO = o(i, flexItem, flexLine.m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, BasicMeasure.EXACTLY);
                        viewC.measure(iO, iMakeMeasureSpec2);
                        measuredWidth3 = viewC.getMeasuredWidth();
                        int measuredHeight4 = viewC.getMeasuredHeight();
                        B(i10, iO, iMakeMeasureSpec2, viewC);
                        this.a.e(i10, viewC);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i9, this.a.j(viewC) + flexItem.d0() + flexItem.J() + measuredWidth3);
                    flexLine.e = flexItem.I() + flexItem.N() + measuredHeight3 + flexLine.e;
                    i6 = i7;
                }
                flexLine.g = Math.max(flexLine.g, iMax);
                i9 = iMax;
            }
            i8++;
            i5 = i6;
            f2 = 0.0f;
        }
        int i12 = i5;
        if (!z3 || i12 == flexLine.e) {
            return;
        }
        l(i, i2, flexLine, i3, i4, true);
    }

    public int m(long j) {
        return (int) (j >> 32);
    }

    public final int n(int i, FlexItem flexItem, int i2) {
        FlexContainer flexContainer = this.a;
        int iH = flexContainer.h(i, flexItem.I() + flexItem.N() + this.a.getPaddingBottom() + flexContainer.getPaddingTop() + i2, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(iH);
        if (size > flexItem.m0()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.m0(), View.MeasureSpec.getMode(iH));
        }
        return size < flexItem.f0() ? View.MeasureSpec.makeMeasureSpec(flexItem.f0(), View.MeasureSpec.getMode(iH)) : iH;
    }

    public final int o(int i, FlexItem flexItem, int i2) {
        FlexContainer flexContainer = this.a;
        int iD = flexContainer.d(i, flexItem.d0() + flexItem.J() + this.a.getPaddingRight() + flexContainer.getPaddingLeft() + i2, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(iD);
        if (size > flexItem.t0()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.t0(), View.MeasureSpec.getMode(iD));
        }
        return size < flexItem.D() ? View.MeasureSpec.makeMeasureSpec(flexItem.D(), View.MeasureSpec.getMode(iD)) : iD;
    }

    public final int p(FlexItem flexItem, boolean z2) {
        return z2 ? flexItem.I() : flexItem.d0();
    }

    public final int q(FlexItem flexItem, boolean z2) {
        return z2 ? flexItem.d0() : flexItem.I();
    }

    public final int r(FlexItem flexItem, boolean z2) {
        return z2 ? flexItem.N() : flexItem.J();
    }

    public final int s(FlexItem flexItem, boolean z2) {
        return z2 ? flexItem.J() : flexItem.N();
    }

    public final boolean t(int i, int i2, FlexLine flexLine) {
        return i == i2 - 1 && flexLine.a() != 0;
    }

    public void u(View view, FlexLine flexLine, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.a.getAlignItems();
        if (flexItem.u() != -1) {
            alignItems = flexItem.u();
        }
        int i5 = flexLine.g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.a.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - flexItem.I(), i3, i6 - flexItem.I());
                    return;
                }
                view.layout(i, flexItem.N() + view.getMeasuredHeight() + (i2 - i5), i3, flexItem.N() + view.getMeasuredHeight() + (i4 - i5));
                return;
            }
            if (alignItems == 2) {
                int iN = ((flexItem.N() + (i5 - view.getMeasuredHeight())) - flexItem.I()) / 2;
                if (this.a.getFlexWrap() != 2) {
                    int i7 = i2 + iN;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - iN;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.a.getFlexWrap() != 2) {
                    int iMax = Math.max(flexLine.l - view.getBaseline(), flexItem.N());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max(view.getBaseline() + (flexLine.l - view.getMeasuredHeight()), flexItem.I());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.a.getFlexWrap() != 2) {
            view.layout(i, flexItem.N() + i2, i3, flexItem.N() + i4);
        } else {
            view.layout(i, i2 - flexItem.I(), i3, i4 - flexItem.I());
        }
    }

    public void v(View view, FlexLine flexLine, boolean z2, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.a.getAlignItems();
        if (flexItem.u() != -1) {
            alignItems = flexItem.u();
        }
        int i5 = flexLine.g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z2) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - flexItem.d0(), i2, ((i3 + i5) - view.getMeasuredWidth()) - flexItem.d0(), i4);
                    return;
                }
                view.layout(flexItem.J() + view.getMeasuredWidth() + (i - i5), i2, flexItem.J() + view.getMeasuredWidth() + (i3 - i5), i4);
                return;
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int marginStart = ((MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + (i5 - view.getMeasuredWidth())) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (z2) {
                    view.layout(i - marginStart, i2, i3 - marginStart, i4);
                    return;
                } else {
                    view.layout(i + marginStart, i2, i3 + marginStart, i4);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (z2) {
            view.layout(i - flexItem.d0(), i2, i3 - flexItem.d0(), i4);
        } else {
            view.layout(flexItem.J() + i, i2, flexItem.J() + i3, i4);
        }
    }

    public final void w(int i, int i2, FlexLine flexLine, int i3, int i4, boolean z2) {
        int iMax;
        int iD;
        int i5 = flexLine.e;
        float f = flexLine.k;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 > i5) {
            return;
        }
        float f3 = (i5 - i3) / f;
        flexLine.e = i4 + flexLine.f;
        if (!z2) {
            flexLine.g = Integer.MIN_VALUE;
        }
        int i6 = 0;
        boolean z3 = false;
        int i7 = 0;
        float f4 = 0.0f;
        while (i6 < flexLine.h) {
            int i8 = flexLine.o + i6;
            View viewC = this.a.c(i8);
            if (viewC == null || viewC.getVisibility() == 8) {
                i5 = i5;
                i6 = i6;
            } else {
                FlexItem flexItem = (FlexItem) viewC.getLayoutParams();
                int flexDirection = this.a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i5 = i5;
                    int i9 = i6;
                    int measuredWidth = viewC.getMeasuredWidth();
                    long[] jArr = this.e;
                    if (jArr != null) {
                        measuredWidth = (int) jArr[i8];
                    }
                    int measuredHeight = viewC.getMeasuredHeight();
                    long[] jArr2 = this.e;
                    if (jArr2 != null) {
                        measuredHeight = m(jArr2[i8]);
                    }
                    if (this.f1328b[i8] || flexItem.x() <= 0.0f) {
                        i6 = i9;
                    } else {
                        float fX = measuredWidth - (flexItem.x() * f3);
                        if (i6 == flexLine.h - 1) {
                            i6 = i9;
                            fX += f4;
                            f4 = 0.0f;
                        }
                        i6 = i9;
                        int iRound = Math.round(fX);
                        if (iRound < flexItem.D()) {
                            iD = flexItem.D();
                            this.f1328b[i8] = true;
                            flexLine.k -= flexItem.x();
                            z3 = true;
                        } else {
                            float f5 = (fX - iRound) + f4;
                            double d = f5;
                            if (d > 1.0d) {
                                iRound++;
                                f5 -= 1.0f;
                            } else if (d < -1.0d) {
                                iRound--;
                                f5 += 1.0f;
                            }
                            f4 = f5;
                            iD = iRound;
                        }
                        int iN = n(i2, flexItem, flexLine.m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iD, BasicMeasure.EXACTLY);
                        viewC.measure(iMakeMeasureSpec, iN);
                        int measuredWidth2 = viewC.getMeasuredWidth();
                        int measuredHeight2 = viewC.getMeasuredHeight();
                        B(i8, iMakeMeasureSpec, iN, viewC);
                        this.a.e(i8, viewC);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i7, this.a.j(viewC) + flexItem.I() + flexItem.N() + measuredHeight);
                    flexLine.e = flexItem.d0() + flexItem.J() + measuredWidth + flexLine.e;
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewC.getMeasuredHeight();
                    long[] jArr3 = this.e;
                    if (jArr3 != null) {
                        measuredHeight3 = m(jArr3[i8]);
                    }
                    int measuredWidth3 = viewC.getMeasuredWidth();
                    long[] jArr4 = this.e;
                    if (jArr4 != null) {
                        measuredWidth3 = (int) jArr4[i8];
                    }
                    if (this.f1328b[i8] || flexItem.x() <= f2) {
                        i5 = i5;
                        i6 = i6;
                    } else {
                        float fX2 = measuredHeight3 - (flexItem.x() * f3);
                        if (i6 == flexLine.h - 1) {
                            fX2 += f4;
                            f4 = 0.0f;
                        }
                        int iRound2 = Math.round(fX2);
                        if (iRound2 < flexItem.f0()) {
                            int iF0 = flexItem.f0();
                            this.f1328b[i8] = true;
                            flexLine.k -= flexItem.x();
                            iRound2 = iF0;
                            z3 = true;
                        } else {
                            float f6 = (fX2 - iRound2) + f4;
                            double d2 = f6;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f6 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f6 += 1.0f;
                            }
                            f4 = f6;
                        }
                        int iO = o(i, flexItem, flexLine.m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, BasicMeasure.EXACTLY);
                        viewC.measure(iO, iMakeMeasureSpec2);
                        measuredWidth3 = viewC.getMeasuredWidth();
                        int measuredHeight4 = viewC.getMeasuredHeight();
                        B(i8, iO, iMakeMeasureSpec2, viewC);
                        this.a.e(i8, viewC);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i7, this.a.j(viewC) + flexItem.d0() + flexItem.J() + measuredWidth3);
                    flexLine.e = flexItem.I() + flexItem.N() + measuredHeight3 + flexLine.e;
                }
                flexLine.g = Math.max(flexLine.g, iMax);
                i7 = iMax;
            }
            i6++;
            i5 = i5;
            f2 = 0.0f;
        }
        int i10 = i5;
        if (!z3 || i10 == flexLine.e) {
            return;
        }
        w(i, i2, flexLine, i3, i4, true);
    }

    public final int[] x(int i, List<c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (c cVar : list) {
            int i3 = cVar.j;
            iArr[i2] = i3;
            sparseIntArray.append(i3, cVar.k);
            i2++;
        }
        return iArr;
    }

    public final void y(View view, int i, int i2) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - flexItem.J()) - flexItem.d0()) - this.a.j(view), flexItem.D()), flexItem.t0());
        long[] jArr = this.e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? m(jArr[i2]) : view.getMeasuredHeight(), BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        B(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.a.e(i2, view);
    }

    public final void z(View view, int i, int i2) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - flexItem.N()) - flexItem.I()) - this.a.j(view), flexItem.f0()), flexItem.m0());
        long[] jArr = this.e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? (int) jArr[i2] : view.getMeasuredWidth(), BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        B(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.a.e(i2, view);
    }
}
