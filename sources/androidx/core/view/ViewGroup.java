package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import b.d.b.a.outline;
import d0.f0.SequenceBuilder3;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: androidx.core.view.ViewGroupKt, reason: use source file name */
/* JADX INFO: compiled from: ViewGroup.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewGroup {

    /* JADX INFO: renamed from: androidx.core.view.ViewGroupKt$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: ViewGroup.kt */
    public static final class AnonymousClass1 implements Iterator<View>, KMarkers {
        public final /* synthetic */ android.view.ViewGroup $this_iterator;
        private int index;

        public AnonymousClass1(android.view.ViewGroup viewGroup) {
            this.$this_iterator = viewGroup;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            android.view.ViewGroup viewGroup = this.$this_iterator;
            int i = this.index - 1;
            this.index = i;
            viewGroup.removeViewAt(i);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public View next() {
            android.view.ViewGroup viewGroup = this.$this_iterator;
            int i = this.index;
            this.index = i + 1;
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(android.view.ViewGroup viewGroup, View view) {
        Intrinsics3.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics3.checkNotNullParameter(view, "view");
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(android.view.ViewGroup viewGroup, Function1<? super View, Unit> function1) {
        Intrinsics3.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            View childAt = viewGroup.getChildAt(i);
            Intrinsics3.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            function1.invoke(childAt);
            if (i2 >= childCount) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final void forEachIndexed(android.view.ViewGroup viewGroup, Function2<? super Integer, ? super View, Unit> function2) {
        Intrinsics3.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics3.checkNotNullParameter(function2, "action");
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            Integer numValueOf = Integer.valueOf(i);
            View childAt = viewGroup.getChildAt(i);
            Intrinsics3.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            function2.invoke(numValueOf, childAt);
            if (i2 >= childCount) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final View get(android.view.ViewGroup viewGroup, int i) {
        Intrinsics3.checkNotNullParameter(viewGroup, "<this>");
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        StringBuilder sbV = outline.V("Index: ", i, ", Size: ");
        sbV.append(viewGroup.getChildCount());
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public static final Sequence<View> getChildren(final android.view.ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(viewGroup, "<this>");
        return new Sequence<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // kotlin.sequences.Sequence
            public Iterator<View> iterator() {
                return ViewGroup.iterator(viewGroup);
            }
        };
    }

    public static final Sequence<View> getDescendants(android.view.ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(viewGroup, "<this>");
        return SequenceBuilder3.sequence(new ViewGroup3(viewGroup, null));
    }

    public static final int getSize(android.view.ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(viewGroup, "<this>");
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(android.view.ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(viewGroup, "<this>");
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(android.view.ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(viewGroup, "<this>");
        return viewGroup.getChildCount() != 0;
    }

    public static final Iterator<View> iterator(android.view.ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(viewGroup, "<this>");
        return new AnonymousClass1(viewGroup);
    }

    public static final void minusAssign(android.view.ViewGroup viewGroup, View view) {
        Intrinsics3.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics3.checkNotNullParameter(view, "view");
        viewGroup.removeView(view);
    }

    public static final void plusAssign(android.view.ViewGroup viewGroup, View view) {
        Intrinsics3.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics3.checkNotNullParameter(view, "view");
        viewGroup.addView(view);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i) {
        Intrinsics3.checkNotNullParameter(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i, i, i, i);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        Intrinsics3.checkNotNullParameter(marginLayoutParams, "<this>");
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
        Intrinsics3.checkNotNullParameter(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i, i2, i3, i4);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        Intrinsics3.checkNotNullParameter(marginLayoutParams, "<this>");
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
        Intrinsics3.checkNotNullParameter(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.setMarginEnd(i3);
        marginLayoutParams.bottomMargin = i4;
    }
}
