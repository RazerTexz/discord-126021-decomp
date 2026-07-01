package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import b.d.b.a.a;
import d0.f0.l;
import d0.z.d.m;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: ViewGroup.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupKt {
    public static final boolean contains(ViewGroup viewGroup, View view) {
        m.checkNotNullParameter(viewGroup, "<this>");
        m.checkNotNullParameter(view, "view");
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(ViewGroup viewGroup, Function1<? super View, Unit> function1) {
        m.checkNotNullParameter(viewGroup, "<this>");
        m.checkNotNullParameter(function1, "action");
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            View childAt = viewGroup.getChildAt(i);
            m.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            function1.invoke(childAt);
            if (i2 >= childCount) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, Function2<? super Integer, ? super View, Unit> function2) {
        m.checkNotNullParameter(viewGroup, "<this>");
        m.checkNotNullParameter(function2, "action");
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            Integer numValueOf = Integer.valueOf(i);
            View childAt = viewGroup.getChildAt(i);
            m.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            function2.invoke(numValueOf, childAt);
            if (i2 >= childCount) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final View get(ViewGroup viewGroup, int i) {
        m.checkNotNullParameter(viewGroup, "<this>");
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        StringBuilder sbV = a.V("Index: ", i, ", Size: ");
        sbV.append(viewGroup.getChildCount());
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public static final Sequence<View> getChildren(ViewGroup viewGroup) {
        m.checkNotNullParameter(viewGroup, "<this>");
        return new ViewGroupKt$children$1(viewGroup);
    }

    public static final Sequence<View> getDescendants(ViewGroup viewGroup) {
        m.checkNotNullParameter(viewGroup, "<this>");
        return l.sequence(new ViewGroupKt$descendants$1(viewGroup, null));
    }

    public static final int getSize(ViewGroup viewGroup) {
        m.checkNotNullParameter(viewGroup, "<this>");
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        m.checkNotNullParameter(viewGroup, "<this>");
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup) {
        m.checkNotNullParameter(viewGroup, "<this>");
        return viewGroup.getChildCount() != 0;
    }

    public static final Iterator<View> iterator(ViewGroup viewGroup) {
        m.checkNotNullParameter(viewGroup, "<this>");
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    public static final void minusAssign(ViewGroup viewGroup, View view) {
        m.checkNotNullParameter(viewGroup, "<this>");
        m.checkNotNullParameter(view, "view");
        viewGroup.removeView(view);
    }

    public static final void plusAssign(ViewGroup viewGroup, View view) {
        m.checkNotNullParameter(viewGroup, "<this>");
        m.checkNotNullParameter(view, "view");
        viewGroup.addView(view);
    }

    public static final void setMargins(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, @Px int i) {
        m.checkNotNullParameter(viewGroup$MarginLayoutParams, "<this>");
        viewGroup$MarginLayoutParams.setMargins(i, i, i, i);
    }

    public static final void updateMargins(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        m.checkNotNullParameter(viewGroup$MarginLayoutParams, "<this>");
        viewGroup$MarginLayoutParams.setMargins(i, i2, i3, i4);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = viewGroup$MarginLayoutParams.leftMargin;
        }
        if ((i5 & 2) != 0) {
            i2 = viewGroup$MarginLayoutParams.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = viewGroup$MarginLayoutParams.rightMargin;
        }
        if ((i5 & 8) != 0) {
            i4 = viewGroup$MarginLayoutParams.bottomMargin;
        }
        m.checkNotNullParameter(viewGroup$MarginLayoutParams, "<this>");
        viewGroup$MarginLayoutParams.setMargins(i, i2, i3, i4);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        m.checkNotNullParameter(viewGroup$MarginLayoutParams, "<this>");
        viewGroup$MarginLayoutParams.setMarginStart(i);
        viewGroup$MarginLayoutParams.topMargin = i2;
        viewGroup$MarginLayoutParams.setMarginEnd(i3);
        viewGroup$MarginLayoutParams.bottomMargin = i4;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = viewGroup$MarginLayoutParams.getMarginStart();
        }
        if ((i5 & 2) != 0) {
            i2 = viewGroup$MarginLayoutParams.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = viewGroup$MarginLayoutParams.getMarginEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = viewGroup$MarginLayoutParams.bottomMargin;
        }
        m.checkNotNullParameter(viewGroup$MarginLayoutParams, "<this>");
        viewGroup$MarginLayoutParams.setMarginStart(i);
        viewGroup$MarginLayoutParams.topMargin = i2;
        viewGroup$MarginLayoutParams.setMarginEnd(i3);
        viewGroup$MarginLayoutParams.bottomMargin = i4;
    }
}
