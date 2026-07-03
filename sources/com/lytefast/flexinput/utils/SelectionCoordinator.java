package com.lytefast.flexinput.utils;

import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Objects;
import p007b.p076b.p077a.p082g.C1450b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12224e0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SelectionCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public class SelectionCoordinator<I, T extends I> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public RecyclerView.Adapter<?> adapter;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final ArrayMap<T, Integer> selectedItemPositionMap;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public ItemSelectionListener<? super I> itemSelectionListener;

    /* JADX INFO: compiled from: SelectionCoordinator.kt */
    public interface ItemSelectionListener<I> {
        void onItemSelected(I item);

        void onItemUnselected(I item);

        void unregister();
    }

    /* JADX INFO: compiled from: SelectionCoordinator.kt */
    public static final class RestorationException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RestorationException(String str) {
            super(str);
            C12238m.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        }
    }

    /* JADX INFO: renamed from: com.lytefast.flexinput.utils.SelectionCoordinator$a */
    /* JADX INFO: compiled from: SelectionCoordinator.kt */
    public static final class C11192a<T> {

        /* JADX INFO: renamed from: a */
        public final T f22089a;

        /* JADX INFO: renamed from: b */
        public final boolean f22090b;

        public C11192a(T t, boolean z2) {
            this.f22089a = t;
            this.f22090b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C11192a)) {
                return false;
            }
            C11192a c11192a = (C11192a) obj;
            return C12238m.areEqual(this.f22089a, c11192a.f22089a) && this.f22090b == c11192a.f22090b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            T t = this.f22089a;
            int iHashCode = (t != null ? t.hashCode() : 0) * 31;
            boolean z2 = this.f22090b;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("SelectionEvent(item=");
            sbM833U.append(this.f22089a);
            sbM833U.append(", isSelected=");
            return C1643a.m827O(sbM833U, this.f22090b, ")");
        }
    }

    public SelectionCoordinator() {
        this(null, null, 3);
    }

    public SelectionCoordinator(ArrayMap arrayMap, ItemSelectionListener itemSelectionListener, int i) {
        ArrayMap<T, Integer> arrayMap2 = (i & 1) != 0 ? new ArrayMap<>(4) : null;
        C1450b c1450b = (i & 2) != 0 ? new C1450b() : null;
        C12238m.checkNotNullParameter(arrayMap2, "selectedItemPositionMap");
        C12238m.checkNotNullParameter(c1450b, "itemSelectionListener");
        this.selectedItemPositionMap = arrayMap2;
        this.itemSelectionListener = c1450b;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m9298a(T item, int position) {
        Integer num = this.selectedItemPositionMap.get(item);
        if (num == null) {
            return false;
        }
        if (position == num.intValue()) {
            return true;
        }
        this.selectedItemPositionMap.put(item, Integer.valueOf(position));
        return true;
    }

    /* JADX INFO: renamed from: b */
    public final void m9299b(ArrayList<? extends I> selectedItems) throws RestorationException {
        C12238m.checkNotNullParameter(selectedItems, "selectedItems");
        if (this.adapter != null) {
            throw new RestorationException("cannot restoreSelections after adapter set: prevents mismatches");
        }
        for (I i : selectedItems) {
            if (!(i instanceof Object)) {
                i = null;
            }
            if (i != null) {
                this.selectedItemPositionMap.put(i, -1);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m9300c(T item, int position) {
        this.selectedItemPositionMap.put(item, Integer.valueOf(position));
        RecyclerView.Adapter<?> adapter = this.adapter;
        if (adapter != null) {
            adapter.notifyItemChanged(position, new C11192a(item, true));
        }
        this.itemSelectionListener.onItemSelected(item);
    }

    /* JADX INFO: renamed from: d */
    public final boolean m9301d(I item) {
        ArrayMap<T, Integer> arrayMap = this.selectedItemPositionMap;
        Objects.requireNonNull(arrayMap, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        Integer num = (Integer) C12224e0.asMutableMap(arrayMap).remove(item);
        if (num == null) {
            return false;
        }
        int iIntValue = num.intValue();
        RecyclerView.Adapter<?> adapter = this.adapter;
        if (adapter != null) {
            adapter.notifyItemChanged(iIntValue, new C11192a(item, false));
        }
        this.itemSelectionListener.onItemUnselected(item);
        return true;
    }
}
