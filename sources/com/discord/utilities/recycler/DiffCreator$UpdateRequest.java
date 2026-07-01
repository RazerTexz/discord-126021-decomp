package com.discord.utilities.recycler;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DiffCreator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DiffCreator$UpdateRequest<T, VH extends RecyclerView$ViewHolder> {
    private final RecyclerView$Adapter<VH> adapter;
    private final T newItems;
    private final T oldItems;
    private final Function1<T, Unit> setItems;

    /* JADX WARN: Multi-variable type inference failed */
    public DiffCreator$UpdateRequest(RecyclerView$Adapter<VH> recyclerView$Adapter, Function1<? super T, Unit> function1, T t, T t2) {
        m.checkNotNullParameter(recyclerView$Adapter, "adapter");
        m.checkNotNullParameter(function1, "setItems");
        this.adapter = recyclerView$Adapter;
        this.setItems = function1;
        this.oldItems = t;
        this.newItems = t2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DiffCreator$UpdateRequest copy$default(DiffCreator$UpdateRequest diffCreator$UpdateRequest, RecyclerView$Adapter recyclerView$Adapter, Function1 function1, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            recyclerView$Adapter = diffCreator$UpdateRequest.adapter;
        }
        if ((i & 2) != 0) {
            function1 = diffCreator$UpdateRequest.setItems;
        }
        if ((i & 4) != 0) {
            obj = diffCreator$UpdateRequest.oldItems;
        }
        if ((i & 8) != 0) {
            obj2 = diffCreator$UpdateRequest.newItems;
        }
        return diffCreator$UpdateRequest.copy(recyclerView$Adapter, function1, obj, obj2);
    }

    public final RecyclerView$Adapter<VH> component1() {
        return this.adapter;
    }

    public final Function1<T, Unit> component2() {
        return this.setItems;
    }

    public final T component3() {
        return this.oldItems;
    }

    public final T component4() {
        return this.newItems;
    }

    public final DiffCreator$UpdateRequest<T, VH> copy(RecyclerView$Adapter<VH> adapter, Function1<? super T, Unit> setItems, T oldItems, T newItems) {
        m.checkNotNullParameter(adapter, "adapter");
        m.checkNotNullParameter(setItems, "setItems");
        return new DiffCreator$UpdateRequest<>(adapter, setItems, oldItems, newItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiffCreator$UpdateRequest)) {
            return false;
        }
        DiffCreator$UpdateRequest diffCreator$UpdateRequest = (DiffCreator$UpdateRequest) other;
        return m.areEqual(this.adapter, diffCreator$UpdateRequest.adapter) && m.areEqual(this.setItems, diffCreator$UpdateRequest.setItems) && m.areEqual(this.oldItems, diffCreator$UpdateRequest.oldItems) && m.areEqual(this.newItems, diffCreator$UpdateRequest.newItems);
    }

    public final RecyclerView$Adapter<VH> getAdapter() {
        return this.adapter;
    }

    public final T getNewItems() {
        return this.newItems;
    }

    public final T getOldItems() {
        return this.oldItems;
    }

    public final Function1<T, Unit> getSetItems() {
        return this.setItems;
    }

    public int hashCode() {
        RecyclerView$Adapter<VH> recyclerView$Adapter = this.adapter;
        int iHashCode = (recyclerView$Adapter != null ? recyclerView$Adapter.hashCode() : 0) * 31;
        Function1<T, Unit> function1 = this.setItems;
        int iHashCode2 = (iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31;
        T t = this.oldItems;
        int iHashCode3 = (iHashCode2 + (t != null ? t.hashCode() : 0)) * 31;
        T t2 = this.newItems;
        return iHashCode3 + (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UpdateRequest(adapter=");
        sbU.append(this.adapter);
        sbU.append(", setItems=");
        sbU.append(this.setItems);
        sbU.append(", oldItems=");
        sbU.append(this.oldItems);
        sbU.append(", newItems=");
        sbU.append(this.newItems);
        sbU.append(")");
        return sbU.toString();
    }
}
