package com.discord.utilities.recycler;

import androidx.recyclerview.widget.DiffUtil$Callback;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: DiffCreator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiffCreator$createDiffUtilCallback$1 extends DiffUtil$Callback {
    public final /* synthetic */ List $newItems;
    public final /* synthetic */ List $oldItems;

    public DiffCreator$createDiffUtilCallback$1(List list, List list2) {
        this.$oldItems = list;
        this.$newItems = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return m.areEqual((DiffKeyProvider) this.$oldItems.get(oldItemPosition), (DiffKeyProvider) this.$newItems.get(newItemPosition));
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return m.areEqual(((DiffKeyProvider) this.$oldItems.get(oldItemPosition)).getKey(), ((DiffKeyProvider) this.$newItems.get(newItemPosition)).getKey());
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public int getNewListSize() {
        return this.$newItems.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public int getOldListSize() {
        return this.$oldItems.size();
    }
}
