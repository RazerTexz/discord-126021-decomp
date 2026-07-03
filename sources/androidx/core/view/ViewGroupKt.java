package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p578f0.C12073l;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: compiled from: ViewGroup.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupKt {

    /* JADX INFO: renamed from: androidx.core.view.ViewGroupKt$iterator$1 */
    /* JADX INFO: compiled from: ViewGroup.kt */
    public static final class C02881 implements Iterator<View>, InterfaceC12228a {
        public final /* synthetic */ ViewGroup $this_iterator;
        private int index;

        public C02881(ViewGroup viewGroup) {
            this.$this_iterator = viewGroup;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.$this_iterator;
            int i = this.index - 1;
            this.index = i;
            viewGroup.removeViewAt(i);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public View next() {
            ViewGroup viewGroup = this.$this_iterator;
            int i = this.index;
            this.index = i + 1;
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(ViewGroup viewGroup, View view) {
        C12238m.checkNotNullParameter(viewGroup, "<this>");
        C12238m.checkNotNullParameter(view, "view");
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(ViewGroup viewGroup, Function1<? super View, Unit> function1) {
        C12238m.checkNotNullParameter(viewGroup, "<this>");
        C12238m.checkNotNullParameter(function1, "action");
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            View childAt = viewGroup.getChildAt(i);
            C12238m.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            function1.invoke(childAt);
            if (i2 >= childCount) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, Function2<? super Integer, ? super View, Unit> function2) {
        C12238m.checkNotNullParameter(viewGroup, "<this>");
        C12238m.checkNotNullParameter(function2, "action");
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            Integer numValueOf = Integer.valueOf(i);
            View childAt = viewGroup.getChildAt(i);
            C12238m.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            function2.invoke(numValueOf, childAt);
            if (i2 >= childCount) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final View get(ViewGroup viewGroup, int i) {
        C12238m.checkNotNullParameter(viewGroup, "<this>");
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        StringBuilder sbM834V = C1643a.m834V("Index: ", i, ", Size: ");
        sbM834V.append(viewGroup.getChildCount());
        throw new IndexOutOfBoundsException(sbM834V.toString());
    }

    public static final Sequence<View> getChildren(final ViewGroup viewGroup) {
        C12238m.checkNotNullParameter(viewGroup, "<this>");
        return new Sequence<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // kotlin.sequences.Sequence
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    public static final Sequence<View> getDescendants(ViewGroup viewGroup) {
        C12238m.checkNotNullParameter(viewGroup, "<this>");
        return C12073l.sequence(new ViewGroupKt$descendants$1(viewGroup, null));
    }

    public static final int getSize(ViewGroup viewGroup) {
        C12238m.checkNotNullParameter(viewGroup, "<this>");
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        C12238m.checkNotNullParameter(viewGroup, "<this>");
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup) {
        C12238m.checkNotNullParameter(viewGroup, "<this>");
        return viewGroup.getChildCount() != 0;
    }

    public static final Iterator<View> iterator(ViewGroup viewGroup) {
        C12238m.checkNotNullParameter(viewGroup, "<this>");
        return new C02881(viewGroup);
    }

    public static final void minusAssign(ViewGroup viewGroup, View view) {
        C12238m.checkNotNullParameter(viewGroup, "<this>");
        C12238m.checkNotNullParameter(view, "view");
        viewGroup.removeView(view);
    }

    public static final void plusAssign(ViewGroup viewGroup, View view) {
        C12238m.checkNotNullParameter(viewGroup, "<this>");
        C12238m.checkNotNullParameter(view, "view");
        viewGroup.addView(view);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i) {
        C12238m.checkNotNullParameter(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i, i, i, i);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        C12238m.checkNotNullParameter(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i, i2, i3, i4);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = marginLayoutParams.leftMargin;
        }
        if ((i5 & 2) != 0) {
            i2 = marginLayoutParams.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = marginLayoutParams.rightMargin;
        }
        if ((i5 & 8) != 0) {
            i4 = marginLayoutParams.bottomMargin;
        }
        C12238m.checkNotNullParameter(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i, i2, i3, i4);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        C12238m.checkNotNullParameter(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.setMarginEnd(i3);
        marginLayoutParams.bottomMargin = i4;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = marginLayoutParams.getMarginStart();
        }
        if ((i5 & 2) != 0) {
            i2 = marginLayoutParams.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = marginLayoutParams.getMarginEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = marginLayoutParams.bottomMargin;
        }
        C12238m.checkNotNullParameter(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.setMarginEnd(i3);
        marginLayoutParams.bottomMargin = i4;
    }
}
