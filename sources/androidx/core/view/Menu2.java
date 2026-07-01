package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: androidx.core.view.MenuKt, reason: use source file name */
/* JADX INFO: compiled from: Menu.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Menu2 {

    /* JADX INFO: renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: Menu.kt */
    public static final class AnonymousClass1 implements Iterator<MenuItem>, KMarkers {
        public final /* synthetic */ Menu $this_iterator;
        private int index;

        public AnonymousClass1(Menu menu) {
            this.$this_iterator = menu;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.size();
        }

        @Override // java.util.Iterator
        public void remove() {
            Menu menu = this.$this_iterator;
            int i = this.index - 1;
            this.index = i;
            menu.removeItem(i);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public MenuItem next() {
            Menu menu = this.$this_iterator;
            int i = this.index;
            this.index = i + 1;
            MenuItem item = menu.getItem(i);
            if (item != null) {
                return item;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(Menu menu, MenuItem menuItem) {
        Intrinsics3.checkNotNullParameter(menu, "<this>");
        Intrinsics3.checkNotNullParameter(menuItem, "item");
        int size = menu.size();
        if (size > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (Intrinsics3.areEqual(menu.getItem(i), menuItem)) {
                    return true;
                }
                if (i2 < size) {
                    i = i2;
                }
            }
        }
        return false;
    }

    public static final void forEach(Menu menu, Function1<? super MenuItem, Unit> function1) {
        Intrinsics3.checkNotNullParameter(menu, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        int size = menu.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            MenuItem item = menu.getItem(i);
            Intrinsics3.checkNotNullExpressionValue(item, "getItem(index)");
            function1.invoke(item);
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final void forEachIndexed(Menu menu, Function2<? super Integer, ? super MenuItem, Unit> function2) {
        Intrinsics3.checkNotNullParameter(menu, "<this>");
        Intrinsics3.checkNotNullParameter(function2, "action");
        int size = menu.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            Integer numValueOf = Integer.valueOf(i);
            MenuItem item = menu.getItem(i);
            Intrinsics3.checkNotNullExpressionValue(item, "getItem(index)");
            function2.invoke(numValueOf, item);
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final MenuItem get(Menu menu, int i) {
        Intrinsics3.checkNotNullParameter(menu, "<this>");
        MenuItem item = menu.getItem(i);
        Intrinsics3.checkNotNullExpressionValue(item, "getItem(index)");
        return item;
    }

    public static final Sequence<MenuItem> getChildren(final Menu menu) {
        Intrinsics3.checkNotNullParameter(menu, "<this>");
        return new Sequence<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // kotlin.sequences.Sequence
            public Iterator<MenuItem> iterator() {
                return Menu2.iterator(menu);
            }
        };
    }

    public static final int getSize(Menu menu) {
        Intrinsics3.checkNotNullParameter(menu, "<this>");
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        Intrinsics3.checkNotNullParameter(menu, "<this>");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(Menu menu) {
        Intrinsics3.checkNotNullParameter(menu, "<this>");
        return menu.size() != 0;
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        Intrinsics3.checkNotNullParameter(menu, "<this>");
        return new AnonymousClass1(menu);
    }

    public static final void minusAssign(Menu menu, MenuItem menuItem) {
        Intrinsics3.checkNotNullParameter(menu, "<this>");
        Intrinsics3.checkNotNullParameter(menuItem, "item");
        menu.removeItem(menuItem.getItemId());
    }
}
