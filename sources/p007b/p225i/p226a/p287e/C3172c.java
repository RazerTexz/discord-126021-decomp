package p007b.p225i.p226a.p287e;

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
import com.google.android.flexbox.FlexItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.e.c */
/* JADX INFO: compiled from: FlexboxHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class C3172c {

    /* JADX INFO: renamed from: a */
    public final InterfaceC3170a f9181a;

    /* JADX INFO: renamed from: b */
    public boolean[] f9182b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public int[] f9183c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public long[] f9184d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public long[] f9185e;

    /* JADX INFO: renamed from: b.i.a.e.c$b */
    /* JADX INFO: compiled from: FlexboxHelper.java */
    public static class b {

        /* JADX INFO: renamed from: a */
        public List<C3171b> f9186a;

        /* JADX INFO: renamed from: b */
        public int f9187b;

        /* JADX INFO: renamed from: a */
        public void m3964a() {
            this.f9186a = null;
            this.f9187b = 0;
        }
    }

    /* JADX INFO: renamed from: b.i.a.e.c$c */
    /* JADX INFO: compiled from: FlexboxHelper.java */
    public static class c implements Comparable<c> {

        /* JADX INFO: renamed from: j */
        public int f9188j;

        /* JADX INFO: renamed from: k */
        public int f9189k;

        public c() {
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull c cVar) {
            c cVar2 = cVar;
            int i = this.f9189k;
            int i2 = cVar2.f9189k;
            return i != i2 ? i - i2 : this.f9188j - cVar2.f9188j;
        }

        @NonNull
        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Order{order=");
            sbM833U.append(this.f9189k);
            sbM833U.append(", index=");
            return C1643a.m813A(sbM833U, this.f9188j, '}');
        }

        public c(a aVar) {
        }
    }

    public C3172c(InterfaceC3170a interfaceC3170a) {
        this.f9181a = interfaceC3170a;
    }

    /* JADX INFO: renamed from: A */
    public void m3936A(int i) {
        View viewMo3926c;
        if (i >= this.f9181a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f9181a.getFlexDirection();
        if (this.f9181a.getAlignItems() != 4) {
            for (C3171b c3171b : this.f9181a.getFlexLinesInternal()) {
                for (Integer num : c3171b.f9176n) {
                    View viewMo3926c2 = this.f9181a.mo3926c(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        m3963z(viewMo3926c2, c3171b.f9169g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException(C1643a.m871q("Invalid flex direction: ", flexDirection));
                        }
                        m3962y(viewMo3926c2, c3171b.f9169g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f9183c;
        List<C3171b> flexLinesInternal = this.f9181a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
            C3171b c3171b2 = flexLinesInternal.get(i2);
            int i3 = c3171b2.f9170h;
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = c3171b2.f9177o + i4;
                if (i4 < this.f9181a.getFlexItemCount() && (viewMo3926c = this.f9181a.mo3926c(i5)) != null && viewMo3926c.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) viewMo3926c.getLayoutParams();
                    if (flexItem.mo8968u() == -1 || flexItem.mo8968u() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            m3963z(viewMo3926c, c3171b2.f9169g, i5);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException(C1643a.m871q("Invalid flex direction: ", flexDirection));
                            }
                            m3962y(viewMo3926c, c3171b2.f9169g, i5);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: B */
    public final void m3937B(int i, int i2, int i3, View view) {
        long[] jArr = this.f9184d;
        if (jArr != null) {
            jArr[i] = (((long) i2) & 4294967295L) | (((long) i3) << 32);
        }
        long[] jArr2 = this.f9185e;
        if (jArr2 != null) {
            jArr2[i] = (((long) view.getMeasuredWidth()) & 4294967295L) | (((long) view.getMeasuredHeight()) << 32);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3938a(List<C3171b> list, C3171b c3171b, int i, int i2) {
        c3171b.f9175m = i2;
        this.f9181a.mo3925b(c3171b);
        c3171b.f9178p = i;
        list.add(c3171b);
    }

    /* JADX WARN: Code duplicated, block: B:77:0x0207  */
    /* JADX INFO: renamed from: b */
    public void m3939b(b bVar, int i, int i2, int i3, int i4, int i5, @Nullable List<C3171b> list) {
        int i6;
        int i7;
        int iMo3931h;
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
        boolean zMo3932i = this.f9181a.mo3932i();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<C3171b> arrayList = list == null ? new ArrayList<>() : list;
        bVar.f9186a = arrayList;
        boolean z4 = i5 == -1;
        int paddingStart = zMo3932i ? this.f9181a.getPaddingStart() : this.f9181a.getPaddingTop();
        int paddingEnd = zMo3932i ? this.f9181a.getPaddingEnd() : this.f9181a.getPaddingBottom();
        int paddingTop = zMo3932i ? this.f9181a.getPaddingTop() : this.f9181a.getPaddingStart();
        int paddingBottom = zMo3932i ? this.f9181a.getPaddingBottom() : this.f9181a.getPaddingEnd();
        C3171b c3171b = new C3171b();
        int i16 = i4;
        c3171b.f9177o = i16;
        int i17 = paddingStart + paddingEnd;
        c3171b.f9167e = i17;
        int flexItemCount = this.f9181a.getFlexItemCount();
        int i18 = Integer.MIN_VALUE;
        boolean z5 = z4;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        while (i16 < flexItemCount) {
            int i22 = i19;
            View viewMo3926c = this.f9181a.mo3926c(i16);
            if (viewMo3926c == null) {
                if (m3957t(i16, flexItemCount, c3171b)) {
                    m3938a(arrayList, c3171b, i16, i21);
                }
                i6 = i20;
            } else {
                i6 = i20;
                if (viewMo3926c.getVisibility() != 8) {
                    if (viewMo3926c instanceof CompoundButton) {
                        CompoundButton compoundButton = (CompoundButton) viewMo3926c;
                        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
                        int iMo8955D = flexItem.mo8955D();
                        int iMo8964f0 = flexItem.mo8964f0();
                        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
                        int minimumWidth = buttonDrawable == null ? 0 : buttonDrawable.getMinimumWidth();
                        if (buttonDrawable == null) {
                            i15 = -1;
                            minimumHeight = 0;
                        } else {
                            minimumHeight = buttonDrawable.getMinimumHeight();
                            i15 = -1;
                        }
                        if (iMo8955D == i15) {
                            iMo8955D = minimumWidth;
                        }
                        flexItem.mo8956H(iMo8955D);
                        if (iMo8964f0 == i15) {
                            iMo8964f0 = minimumHeight;
                        }
                        flexItem.mo8960O(iMo8964f0);
                    }
                    FlexItem flexItem2 = (FlexItem) viewMo3926c.getLayoutParams();
                    if (flexItem2.mo8968u() == 4) {
                        c3171b.f9176n.add(Integer.valueOf(i16));
                    }
                    int width = zMo3932i ? flexItem2.getWidth() : flexItem2.getHeight();
                    if (flexItem2.mo8962W() != -1.0f && mode == 1073741824) {
                        width = Math.round(flexItem2.mo8962W() * size);
                    }
                    if (zMo3932i) {
                        iMo3931h = this.f9181a.mo3927d(i, m3954q(flexItem2, true) + m3956s(flexItem2, true) + i17, width);
                        i7 = i2;
                        int iMo3931h2 = this.f9181a.mo3931h(i7, m3953p(flexItem2, true) + m3955r(flexItem2, true) + paddingTop + paddingBottom + i21, flexItem2.getHeight());
                        viewMo3926c.measure(iMo3931h, iMo3931h2);
                        m3937B(i16, iMo3931h, iMo3931h2, viewMo3926c);
                    } else {
                        i7 = i2;
                        int iMo3927d = this.f9181a.mo3927d(i7, m3953p(flexItem2, false) + m3955r(flexItem2, false) + paddingTop + paddingBottom + i21, flexItem2.getWidth());
                        iMo3931h = this.f9181a.mo3931h(i, m3954q(flexItem2, false) + m3956s(flexItem2, false) + i17, width);
                        viewMo3926c.measure(iMo3927d, iMo3931h);
                        m3937B(i16, iMo3927d, iMo3931h, viewMo3926c);
                    }
                    this.f9181a.mo3928e(i16, viewMo3926c);
                    m3940c(viewMo3926c, i16);
                    int iCombineMeasuredStates = View.combineMeasuredStates(i6, viewMo3926c.getMeasuredState());
                    int i23 = c3171b.f9167e;
                    int iM3954q = m3954q(flexItem2, zMo3932i) + m3956s(flexItem2, zMo3932i) + (zMo3932i ? viewMo3926c.getMeasuredWidth() : viewMo3926c.getMeasuredHeight());
                    int size2 = arrayList.size();
                    if (this.f9181a.getFlexWrap() != 0) {
                        if (flexItem2.mo8965j0()) {
                            i8 = iCombineMeasuredStates;
                            i9 = i22;
                            i10 = size;
                        } else {
                            if (mode == 0) {
                                i8 = iCombineMeasuredStates;
                            } else {
                                int maxLine = this.f9181a.getMaxLine();
                                i8 = iCombineMeasuredStates;
                                if (maxLine == -1 || maxLine > size2 + 1) {
                                    i9 = i22;
                                    int iMo3930g = this.f9181a.mo3930g(viewMo3926c, i16, i9);
                                    if (iMo3930g > 0) {
                                        iM3954q += iMo3930g;
                                    }
                                    i10 = size;
                                    if (i10 < i23 + iM3954q) {
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
                        if (c3171b.m3934a() > 0) {
                            arrayList = arrayList;
                            m3938a(arrayList, c3171b, i16 > 0 ? i16 - 1 : 0, i21);
                            i21 += c3171b.f9169g;
                        }
                        if (zMo3932i) {
                            arrayList = arrayList;
                            if (flexItem2.getHeight() == -1) {
                                InterfaceC3170a interfaceC3170a = this.f9181a;
                                viewMo3926c.measure(iMo3931h, interfaceC3170a.mo3931h(i7, flexItem2.mo8957I() + flexItem2.mo8959N() + this.f9181a.getPaddingBottom() + interfaceC3170a.getPaddingTop() + i21, flexItem2.getHeight()));
                                m3940c(viewMo3926c, i16);
                            }
                        } else {
                            arrayList = arrayList;
                            if (flexItem2.getWidth() == -1) {
                                InterfaceC3170a interfaceC3170a2 = this.f9181a;
                                viewMo3926c.measure(interfaceC3170a2.mo3927d(i7, flexItem2.mo8963d0() + flexItem2.mo8958J() + this.f9181a.getPaddingRight() + interfaceC3170a2.getPaddingLeft() + i21, flexItem2.getWidth()), iMo3931h);
                                m3940c(viewMo3926c, i16);
                            }
                        }
                        c3171b = new C3171b();
                        c3171b.f9170h = 1;
                        c3171b.f9167e = i17;
                        c3171b.f9177o = i16;
                        i11 = 0;
                        i12 = Integer.MIN_VALUE;
                    } else {
                        arrayList = arrayList;
                        c3171b.f9170h++;
                        i11 = i9 + 1;
                        i12 = i18;
                    }
                    c3171b.f9179q |= flexItem2.mo8961S() != 0.0f;
                    c3171b.f9180r |= flexItem2.mo8969x() != 0.0f;
                    int[] iArr = this.f9183c;
                    if (iArr != null) {
                        iArr[i16] = arrayList.size();
                    }
                    c3171b.f9167e = m3954q(flexItem2, zMo3932i) + m3956s(flexItem2, zMo3932i) + (zMo3932i ? viewMo3926c.getMeasuredWidth() : viewMo3926c.getMeasuredHeight()) + c3171b.f9167e;
                    c3171b.f9172j = flexItem2.mo8961S() + c3171b.f9172j;
                    c3171b.f9173k = flexItem2.mo8969x() + c3171b.f9173k;
                    this.f9181a.mo3924a(viewMo3926c, i16, i11, c3171b);
                    i13 = i10;
                    int iMax = Math.max(i12, this.f9181a.mo3933j(viewMo3926c) + m3953p(flexItem2, zMo3932i) + m3955r(flexItem2, zMo3932i) + (zMo3932i ? viewMo3926c.getMeasuredHeight() : viewMo3926c.getMeasuredWidth()));
                    c3171b.f9169g = Math.max(c3171b.f9169g, iMax);
                    if (zMo3932i) {
                        if (this.f9181a.getFlexWrap() != 2) {
                            c3171b.f9174l = Math.max(c3171b.f9174l, flexItem2.mo8959N() + viewMo3926c.getBaseline());
                        } else {
                            c3171b.f9174l = Math.max(c3171b.f9174l, flexItem2.mo8957I() + (viewMo3926c.getMeasuredHeight() - viewMo3926c.getBaseline()));
                        }
                    }
                    i14 = flexItemCount;
                    if (m3957t(i16, i14, c3171b)) {
                        m3938a(arrayList, c3171b, i16, i21);
                        i21 += c3171b.f9169g;
                    }
                    if (i5 == -1 || arrayList.size() <= 0 || arrayList.get(arrayList.size() - 1).f9178p < i5 || i16 < i5 || z5) {
                        z3 = z5;
                    } else {
                        i21 = -c3171b.f9169g;
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
                    c3171b.f9171i++;
                    c3171b.f9170h++;
                    if (m3957t(i16, flexItemCount, c3171b)) {
                        m3938a(arrayList, c3171b, i16, i21);
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
        bVar.f9187b = i20;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: c */
    public final void m3940c(View view, int i) {
        boolean z2;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z3 = true;
        if (measuredWidth >= flexItem.mo8955D()) {
            if (measuredWidth > flexItem.mo8967t0()) {
                measuredWidth = flexItem.mo8967t0();
            } else {
                z2 = false;
            }
            if (measuredHeight < flexItem.mo8964f0()) {
                measuredHeight = flexItem.mo8964f0();
            } else if (measuredHeight > flexItem.mo8966m0()) {
                measuredHeight = flexItem.mo8966m0();
            } else {
                z3 = z2;
            }
            if (z3) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                m3937B(i, iMakeMeasureSpec, iMakeMeasureSpec2, view);
                this.f9181a.mo3928e(i, view);
            }
        }
        measuredWidth = flexItem.mo8955D();
        z2 = true;
        if (measuredHeight < flexItem.mo8964f0()) {
            measuredHeight = flexItem.mo8964f0();
        } else if (measuredHeight > flexItem.mo8966m0()) {
            measuredHeight = flexItem.mo8966m0();
        } else {
            z3 = z2;
        }
        if (z3) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY);
            int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY);
            view.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
            m3937B(i, iMakeMeasureSpec3, iMakeMeasureSpec4, view);
            this.f9181a.mo3928e(i, view);
        }
    }

    /* JADX INFO: renamed from: d */
    public void m3941d(List<C3171b> list, int i) {
        int i2 = this.f9183c[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int[] iArr = this.f9183c;
        int length = iArr.length - 1;
        if (i > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i, length, -1);
        }
        long[] jArr = this.f9184d;
        int length2 = jArr.length - 1;
        if (i > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i, length2, 0L);
        }
    }

    /* JADX INFO: renamed from: e */
    public final List<C3171b> m3942e(List<C3171b> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        C3171b c3171b = new C3171b();
        c3171b.f9169g = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(c3171b);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(c3171b);
            }
        }
        return arrayList;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public final List<c> m3943f(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            FlexItem flexItem = (FlexItem) this.f9181a.mo3929f(i2).getLayoutParams();
            c cVar = new c(null);
            cVar.f9189k = flexItem.getOrder();
            cVar.f9188j = i2;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: g */
    public void m3944g(int i, int i2, int i3) {
        int mode;
        int size;
        int flexDirection = this.f9181a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            mode = mode2;
            size = size2;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException(C1643a.m871q("Invalid flex direction: ", flexDirection));
            }
            mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
        }
        List<C3171b> flexLinesInternal = this.f9181a.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.f9181a.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f9169g = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f9181a.getAlignContent();
                if (alignContent == 1) {
                    int i5 = size - sumOfCrossSize;
                    C3171b c3171b = new C3171b();
                    c3171b.f9169g = i5;
                    flexLinesInternal.add(0, c3171b);
                    return;
                }
                if (alignContent == 2) {
                    this.f9181a.setFlexLines(m3942e(flexLinesInternal, size, sumOfCrossSize));
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
                            C3171b c3171b2 = new C3171b();
                            if (i4 == flexLinesInternal.size() - 2) {
                                c3171b2.f9169g = Math.round(f + size3);
                                f = 0.0f;
                            } else {
                                c3171b2.f9169g = Math.round(size3);
                            }
                            int i6 = c3171b2.f9169g;
                            float f2 = (size3 - i6) + f;
                            if (f2 > 1.0f) {
                                c3171b2.f9169g = i6 + 1;
                                f2 -= 1.0f;
                            } else if (f2 < -1.0f) {
                                c3171b2.f9169g = i6 - 1;
                                f2 += 1.0f;
                            }
                            arrayList.add(c3171b2);
                            f = f2;
                        }
                        i4++;
                    }
                    this.f9181a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.f9181a.setFlexLines(m3942e(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    C3171b c3171b3 = new C3171b();
                    c3171b3.f9169g = size5;
                    for (C3171b c3171b4 : flexLinesInternal) {
                        arrayList2.add(c3171b3);
                        arrayList2.add(c3171b4);
                        arrayList2.add(c3171b3);
                    }
                    this.f9181a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f3 = 0.0f;
                    while (i4 < size7) {
                        C3171b c3171b5 = flexLinesInternal.get(i4);
                        float f4 = c3171b5.f9169g + size6;
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
                        c3171b5.f9169g = iRound;
                        i4++;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public void m3945h(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        int flexItemCount = this.f9181a.getFlexItemCount();
        boolean[] zArr = this.f9182b;
        if (zArr == null) {
            if (flexItemCount < 10) {
                flexItemCount = 10;
            }
            this.f9182b = new boolean[flexItemCount];
        } else if (zArr.length < flexItemCount) {
            int length = zArr.length * 2;
            if (length >= flexItemCount) {
                flexItemCount = length;
            }
            this.f9182b = new boolean[flexItemCount];
        } else {
            Arrays.fill(zArr, false);
        }
        if (i3 >= this.f9181a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f9181a.getFlexDirection();
        int flexDirection2 = this.f9181a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.f9181a.getLargestMainSize();
            if (mode != 1073741824 && largestMainSize <= size) {
                size = largestMainSize;
            }
            paddingLeft = this.f9181a.getPaddingLeft();
            paddingRight = this.f9181a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException(C1643a.m871q("Invalid flex direction: ", flexDirection));
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.f9181a.getLargestMainSize();
            }
            paddingLeft = this.f9181a.getPaddingTop();
            paddingRight = this.f9181a.getPaddingBottom();
        }
        int i4 = paddingRight + paddingLeft;
        int[] iArr = this.f9183c;
        List<C3171b> flexLinesInternal = this.f9181a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i5 = iArr != null ? iArr[i3] : 0; i5 < size2; i5++) {
            C3171b c3171b = flexLinesInternal.get(i5);
            int i6 = c3171b.f9167e;
            if (i6 < size && c3171b.f9179q) {
                m3949l(i, i2, c3171b, size, i4, false);
            } else if (i6 > size && c3171b.f9180r) {
                m3960w(i, i2, c3171b, size, i4, false);
            }
        }
    }

    /* JADX INFO: renamed from: i */
    public void m3946i(int i) {
        int[] iArr = this.f9183c;
        if (iArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.f9183c = new int[i];
        } else if (iArr.length < i) {
            int length = iArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.f9183c = Arrays.copyOf(iArr, i);
        }
    }

    /* JADX INFO: renamed from: j */
    public void m3947j(int i) {
        long[] jArr = this.f9184d;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.f9184d = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.f9184d = Arrays.copyOf(jArr, i);
        }
    }

    /* JADX INFO: renamed from: k */
    public void m3948k(int i) {
        long[] jArr = this.f9185e;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.f9185e = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.f9185e = Arrays.copyOf(jArr, i);
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m3949l(int i, int i2, C3171b c3171b, int i3, int i4, boolean z2) {
        int i5;
        int i6;
        int iMax;
        double d;
        int i7;
        double d2;
        float f = c3171b.f9172j;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 < (i5 = c3171b.f9167e)) {
            return;
        }
        float f3 = (i3 - i5) / f;
        c3171b.f9167e = i4 + c3171b.f9168f;
        if (!z2) {
            c3171b.f9169g = Integer.MIN_VALUE;
        }
        int i8 = 0;
        boolean z3 = false;
        int i9 = 0;
        float f4 = 0.0f;
        while (i8 < c3171b.f9170h) {
            int i10 = c3171b.f9177o + i8;
            View viewMo3926c = this.f9181a.mo3926c(i10);
            if (viewMo3926c == null || viewMo3926c.getVisibility() == 8) {
                i6 = i5;
            } else {
                FlexItem flexItem = (FlexItem) viewMo3926c.getLayoutParams();
                int flexDirection = this.f9181a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i11 = i5;
                    int measuredWidth = viewMo3926c.getMeasuredWidth();
                    long[] jArr = this.f9185e;
                    if (jArr != null) {
                        measuredWidth = (int) jArr[i10];
                    }
                    int measuredHeight = viewMo3926c.getMeasuredHeight();
                    long[] jArr2 = this.f9185e;
                    i6 = i11;
                    if (jArr2 != null) {
                        measuredHeight = m3950m(jArr2[i10]);
                    }
                    if (!this.f9182b[i10] && flexItem.mo8961S() > 0.0f) {
                        float fMo8961S = (flexItem.mo8961S() * f3) + measuredWidth;
                        if (i8 == c3171b.f9170h - 1) {
                            fMo8961S += f4;
                            f4 = 0.0f;
                        }
                        int iRound = Math.round(fMo8961S);
                        if (iRound > flexItem.mo8967t0()) {
                            iRound = flexItem.mo8967t0();
                            this.f9182b[i10] = true;
                            c3171b.f9172j -= flexItem.mo8961S();
                            z3 = true;
                        } else {
                            float f5 = (fMo8961S - iRound) + f4;
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
                        int iM3951n = m3951n(i2, flexItem, c3171b.f9175m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, BasicMeasure.EXACTLY);
                        viewMo3926c.measure(iMakeMeasureSpec, iM3951n);
                        int measuredWidth2 = viewMo3926c.getMeasuredWidth();
                        int measuredHeight2 = viewMo3926c.getMeasuredHeight();
                        m3937B(i10, iMakeMeasureSpec, iM3951n, viewMo3926c);
                        this.f9181a.mo3928e(i10, viewMo3926c);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i9, this.f9181a.mo3933j(viewMo3926c) + flexItem.mo8957I() + flexItem.mo8959N() + measuredHeight);
                    c3171b.f9167e = flexItem.mo8963d0() + flexItem.mo8958J() + measuredWidth + c3171b.f9167e;
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewMo3926c.getMeasuredHeight();
                    long[] jArr3 = this.f9185e;
                    if (jArr3 != null) {
                        measuredHeight3 = m3950m(jArr3[i10]);
                    }
                    int measuredWidth3 = viewMo3926c.getMeasuredWidth();
                    long[] jArr4 = this.f9185e;
                    if (jArr4 != null) {
                        measuredWidth3 = (int) jArr4[i10];
                    }
                    if (this.f9182b[i10] || flexItem.mo8961S() <= f2) {
                        i7 = i5;
                    } else {
                        float fMo8961S2 = (flexItem.mo8961S() * f3) + measuredHeight3;
                        if (i8 == c3171b.f9170h - 1) {
                            fMo8961S2 += f4;
                            f4 = 0.0f;
                        }
                        int iRound2 = Math.round(fMo8961S2);
                        if (iRound2 > flexItem.mo8966m0()) {
                            iRound2 = flexItem.mo8966m0();
                            this.f9182b[i10] = true;
                            c3171b.f9172j -= flexItem.mo8961S();
                            i7 = i5;
                            z3 = true;
                        } else {
                            float f6 = (fMo8961S2 - iRound2) + f4;
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
                        int iM3952o = m3952o(i, flexItem, c3171b.f9175m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, BasicMeasure.EXACTLY);
                        viewMo3926c.measure(iM3952o, iMakeMeasureSpec2);
                        measuredWidth3 = viewMo3926c.getMeasuredWidth();
                        int measuredHeight4 = viewMo3926c.getMeasuredHeight();
                        m3937B(i10, iM3952o, iMakeMeasureSpec2, viewMo3926c);
                        this.f9181a.mo3928e(i10, viewMo3926c);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i9, this.f9181a.mo3933j(viewMo3926c) + flexItem.mo8963d0() + flexItem.mo8958J() + measuredWidth3);
                    c3171b.f9167e = flexItem.mo8957I() + flexItem.mo8959N() + measuredHeight3 + c3171b.f9167e;
                    i6 = i7;
                }
                c3171b.f9169g = Math.max(c3171b.f9169g, iMax);
                i9 = iMax;
            }
            i8++;
            i5 = i6;
            f2 = 0.0f;
        }
        int i12 = i5;
        if (!z3 || i12 == c3171b.f9167e) {
            return;
        }
        m3949l(i, i2, c3171b, i3, i4, true);
    }

    /* JADX INFO: renamed from: m */
    public int m3950m(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: n */
    public final int m3951n(int i, FlexItem flexItem, int i2) {
        InterfaceC3170a interfaceC3170a = this.f9181a;
        int iMo3931h = interfaceC3170a.mo3931h(i, flexItem.mo8957I() + flexItem.mo8959N() + this.f9181a.getPaddingBottom() + interfaceC3170a.getPaddingTop() + i2, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(iMo3931h);
        if (size > flexItem.mo8966m0()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.mo8966m0(), View.MeasureSpec.getMode(iMo3931h));
        }
        return size < flexItem.mo8964f0() ? View.MeasureSpec.makeMeasureSpec(flexItem.mo8964f0(), View.MeasureSpec.getMode(iMo3931h)) : iMo3931h;
    }

    /* JADX INFO: renamed from: o */
    public final int m3952o(int i, FlexItem flexItem, int i2) {
        InterfaceC3170a interfaceC3170a = this.f9181a;
        int iMo3927d = interfaceC3170a.mo3927d(i, flexItem.mo8963d0() + flexItem.mo8958J() + this.f9181a.getPaddingRight() + interfaceC3170a.getPaddingLeft() + i2, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(iMo3927d);
        if (size > flexItem.mo8967t0()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.mo8967t0(), View.MeasureSpec.getMode(iMo3927d));
        }
        return size < flexItem.mo8955D() ? View.MeasureSpec.makeMeasureSpec(flexItem.mo8955D(), View.MeasureSpec.getMode(iMo3927d)) : iMo3927d;
    }

    /* JADX INFO: renamed from: p */
    public final int m3953p(FlexItem flexItem, boolean z2) {
        return z2 ? flexItem.mo8957I() : flexItem.mo8963d0();
    }

    /* JADX INFO: renamed from: q */
    public final int m3954q(FlexItem flexItem, boolean z2) {
        return z2 ? flexItem.mo8963d0() : flexItem.mo8957I();
    }

    /* JADX INFO: renamed from: r */
    public final int m3955r(FlexItem flexItem, boolean z2) {
        return z2 ? flexItem.mo8959N() : flexItem.mo8958J();
    }

    /* JADX INFO: renamed from: s */
    public final int m3956s(FlexItem flexItem, boolean z2) {
        return z2 ? flexItem.mo8958J() : flexItem.mo8959N();
    }

    /* JADX INFO: renamed from: t */
    public final boolean m3957t(int i, int i2, C3171b c3171b) {
        return i == i2 - 1 && c3171b.m3934a() != 0;
    }

    /* JADX INFO: renamed from: u */
    public void m3958u(View view, C3171b c3171b, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f9181a.getAlignItems();
        if (flexItem.mo8968u() != -1) {
            alignItems = flexItem.mo8968u();
        }
        int i5 = c3171b.f9169g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.f9181a.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - flexItem.mo8957I(), i3, i6 - flexItem.mo8957I());
                    return;
                }
                view.layout(i, flexItem.mo8959N() + view.getMeasuredHeight() + (i2 - i5), i3, flexItem.mo8959N() + view.getMeasuredHeight() + (i4 - i5));
                return;
            }
            if (alignItems == 2) {
                int iMo8959N = ((flexItem.mo8959N() + (i5 - view.getMeasuredHeight())) - flexItem.mo8957I()) / 2;
                if (this.f9181a.getFlexWrap() != 2) {
                    int i7 = i2 + iMo8959N;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - iMo8959N;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.f9181a.getFlexWrap() != 2) {
                    int iMax = Math.max(c3171b.f9174l - view.getBaseline(), flexItem.mo8959N());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max(view.getBaseline() + (c3171b.f9174l - view.getMeasuredHeight()), flexItem.mo8957I());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.f9181a.getFlexWrap() != 2) {
            view.layout(i, flexItem.mo8959N() + i2, i3, flexItem.mo8959N() + i4);
        } else {
            view.layout(i, i2 - flexItem.mo8957I(), i3, i4 - flexItem.mo8957I());
        }
    }

    /* JADX INFO: renamed from: v */
    public void m3959v(View view, C3171b c3171b, boolean z2, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f9181a.getAlignItems();
        if (flexItem.mo8968u() != -1) {
            alignItems = flexItem.mo8968u();
        }
        int i5 = c3171b.f9169g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z2) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - flexItem.mo8963d0(), i2, ((i3 + i5) - view.getMeasuredWidth()) - flexItem.mo8963d0(), i4);
                    return;
                }
                view.layout(flexItem.mo8958J() + view.getMeasuredWidth() + (i - i5), i2, flexItem.mo8958J() + view.getMeasuredWidth() + (i3 - i5), i4);
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
            view.layout(i - flexItem.mo8963d0(), i2, i3 - flexItem.mo8963d0(), i4);
        } else {
            view.layout(flexItem.mo8958J() + i, i2, flexItem.mo8958J() + i3, i4);
        }
    }

    /* JADX INFO: renamed from: w */
    public final void m3960w(int i, int i2, C3171b c3171b, int i3, int i4, boolean z2) {
        int iMax;
        int iMo8955D;
        int i5 = c3171b.f9167e;
        float f = c3171b.f9173k;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 > i5) {
            return;
        }
        float f3 = (i5 - i3) / f;
        c3171b.f9167e = i4 + c3171b.f9168f;
        if (!z2) {
            c3171b.f9169g = Integer.MIN_VALUE;
        }
        int i6 = 0;
        boolean z3 = false;
        int i7 = 0;
        float f4 = 0.0f;
        while (i6 < c3171b.f9170h) {
            int i8 = c3171b.f9177o + i6;
            View viewMo3926c = this.f9181a.mo3926c(i8);
            if (viewMo3926c == null || viewMo3926c.getVisibility() == 8) {
                i5 = i5;
                i6 = i6;
            } else {
                FlexItem flexItem = (FlexItem) viewMo3926c.getLayoutParams();
                int flexDirection = this.f9181a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i5 = i5;
                    int i9 = i6;
                    int measuredWidth = viewMo3926c.getMeasuredWidth();
                    long[] jArr = this.f9185e;
                    if (jArr != null) {
                        measuredWidth = (int) jArr[i8];
                    }
                    int measuredHeight = viewMo3926c.getMeasuredHeight();
                    long[] jArr2 = this.f9185e;
                    if (jArr2 != null) {
                        measuredHeight = m3950m(jArr2[i8]);
                    }
                    if (this.f9182b[i8] || flexItem.mo8969x() <= 0.0f) {
                        i6 = i9;
                    } else {
                        float fMo8969x = measuredWidth - (flexItem.mo8969x() * f3);
                        if (i6 == c3171b.f9170h - 1) {
                            i6 = i9;
                            fMo8969x += f4;
                            f4 = 0.0f;
                        }
                        i6 = i9;
                        int iRound = Math.round(fMo8969x);
                        if (iRound < flexItem.mo8955D()) {
                            iMo8955D = flexItem.mo8955D();
                            this.f9182b[i8] = true;
                            c3171b.f9173k -= flexItem.mo8969x();
                            z3 = true;
                        } else {
                            float f5 = (fMo8969x - iRound) + f4;
                            double d = f5;
                            if (d > 1.0d) {
                                iRound++;
                                f5 -= 1.0f;
                            } else if (d < -1.0d) {
                                iRound--;
                                f5 += 1.0f;
                            }
                            f4 = f5;
                            iMo8955D = iRound;
                        }
                        int iM3951n = m3951n(i2, flexItem, c3171b.f9175m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMo8955D, BasicMeasure.EXACTLY);
                        viewMo3926c.measure(iMakeMeasureSpec, iM3951n);
                        int measuredWidth2 = viewMo3926c.getMeasuredWidth();
                        int measuredHeight2 = viewMo3926c.getMeasuredHeight();
                        m3937B(i8, iMakeMeasureSpec, iM3951n, viewMo3926c);
                        this.f9181a.mo3928e(i8, viewMo3926c);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i7, this.f9181a.mo3933j(viewMo3926c) + flexItem.mo8957I() + flexItem.mo8959N() + measuredHeight);
                    c3171b.f9167e = flexItem.mo8963d0() + flexItem.mo8958J() + measuredWidth + c3171b.f9167e;
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewMo3926c.getMeasuredHeight();
                    long[] jArr3 = this.f9185e;
                    if (jArr3 != null) {
                        measuredHeight3 = m3950m(jArr3[i8]);
                    }
                    int measuredWidth3 = viewMo3926c.getMeasuredWidth();
                    long[] jArr4 = this.f9185e;
                    if (jArr4 != null) {
                        measuredWidth3 = (int) jArr4[i8];
                    }
                    if (this.f9182b[i8] || flexItem.mo8969x() <= f2) {
                        i5 = i5;
                        i6 = i6;
                    } else {
                        float fMo8969x2 = measuredHeight3 - (flexItem.mo8969x() * f3);
                        if (i6 == c3171b.f9170h - 1) {
                            fMo8969x2 += f4;
                            f4 = 0.0f;
                        }
                        int iRound2 = Math.round(fMo8969x2);
                        if (iRound2 < flexItem.mo8964f0()) {
                            int iMo8964f0 = flexItem.mo8964f0();
                            this.f9182b[i8] = true;
                            c3171b.f9173k -= flexItem.mo8969x();
                            iRound2 = iMo8964f0;
                            z3 = true;
                        } else {
                            float f6 = (fMo8969x2 - iRound2) + f4;
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
                        int iM3952o = m3952o(i, flexItem, c3171b.f9175m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, BasicMeasure.EXACTLY);
                        viewMo3926c.measure(iM3952o, iMakeMeasureSpec2);
                        measuredWidth3 = viewMo3926c.getMeasuredWidth();
                        int measuredHeight4 = viewMo3926c.getMeasuredHeight();
                        m3937B(i8, iM3952o, iMakeMeasureSpec2, viewMo3926c);
                        this.f9181a.mo3928e(i8, viewMo3926c);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i7, this.f9181a.mo3933j(viewMo3926c) + flexItem.mo8963d0() + flexItem.mo8958J() + measuredWidth3);
                    c3171b.f9167e = flexItem.mo8957I() + flexItem.mo8959N() + measuredHeight3 + c3171b.f9167e;
                }
                c3171b.f9169g = Math.max(c3171b.f9169g, iMax);
                i7 = iMax;
            }
            i6++;
            i5 = i5;
            f2 = 0.0f;
        }
        int i10 = i5;
        if (!z3 || i10 == c3171b.f9167e) {
            return;
        }
        m3960w(i, i2, c3171b, i3, i4, true);
    }

    /* JADX INFO: renamed from: x */
    public final int[] m3961x(int i, List<c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (c cVar : list) {
            int i3 = cVar.f9188j;
            iArr[i2] = i3;
            sparseIntArray.append(i3, cVar.f9189k);
            i2++;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: y */
    public final void m3962y(View view, int i, int i2) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - flexItem.mo8958J()) - flexItem.mo8963d0()) - this.f9181a.mo3933j(view), flexItem.mo8955D()), flexItem.mo8967t0());
        long[] jArr = this.f9185e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? m3950m(jArr[i2]) : view.getMeasuredHeight(), BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        m3937B(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.f9181a.mo3928e(i2, view);
    }

    /* JADX INFO: renamed from: z */
    public final void m3963z(View view, int i, int i2) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - flexItem.mo8959N()) - flexItem.mo8957I()) - this.f9181a.mo3933j(view), flexItem.mo8964f0()), flexItem.mo8966m0());
        long[] jArr = this.f9185e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? (int) jArr[i2] : view.getMeasuredWidth(), BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        m3937B(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.f9181a.mo3928e(i2, view);
    }
}
