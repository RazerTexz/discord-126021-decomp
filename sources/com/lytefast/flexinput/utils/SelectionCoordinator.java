package com.lytefast.flexinput.utils;

import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import b.b.a.g.b;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.e0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: SelectionCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public class SelectionCoordinator<I, T extends I> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public RecyclerView$Adapter<?> adapter;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ArrayMap<T, Integer> selectedItemPositionMap;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public SelectionCoordinator$ItemSelectionListener<? super I> itemSelectionListener;

    public SelectionCoordinator() {
        this(null, null, 3);
    }

    public SelectionCoordinator(ArrayMap arrayMap, SelectionCoordinator$ItemSelectionListener selectionCoordinator$ItemSelectionListener, int i) {
        ArrayMap<T, Integer> arrayMap2 = (i & 1) != 0 ? new ArrayMap<>(4) : null;
        b bVar = (i & 2) != 0 ? new b() : null;
        m.checkNotNullParameter(arrayMap2, "selectedItemPositionMap");
        m.checkNotNullParameter(bVar, "itemSelectionListener");
        this.selectedItemPositionMap = arrayMap2;
        this.itemSelectionListener = bVar;
    }

    public final boolean a(T item, int position) {
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

    public final void b(ArrayList<? extends I> selectedItems) throws SelectionCoordinator$RestorationException {
        m.checkNotNullParameter(selectedItems, "selectedItems");
        if (this.adapter != null) {
            throw new SelectionCoordinator$RestorationException("cannot restoreSelections after adapter set: prevents mismatches");
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

    public final void c(T item, int position) {
        this.selectedItemPositionMap.put(item, Integer.valueOf(position));
        RecyclerView$Adapter<?> recyclerView$Adapter = this.adapter;
        if (recyclerView$Adapter != null) {
            recyclerView$Adapter.notifyItemChanged(position, new SelectionCoordinator$a(item, true));
        }
        this.itemSelectionListener.onItemSelected(item);
    }

    public final boolean d(I item) {
        ArrayMap<T, Integer> arrayMap = this.selectedItemPositionMap;
        Objects.requireNonNull(arrayMap, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        Integer num = (Integer) e0.asMutableMap(arrayMap).remove(item);
        if (num == null) {
            return false;
        }
        int iIntValue = num.intValue();
        RecyclerView$Adapter<?> recyclerView$Adapter = this.adapter;
        if (recyclerView$Adapter != null) {
            recyclerView$Adapter.notifyItemChanged(iIntValue, new SelectionCoordinator$a(item, false));
        }
        this.itemSelectionListener.onItemUnselected(item);
        return true;
    }
}
