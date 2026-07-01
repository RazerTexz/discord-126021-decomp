package com.discord.utilities.mg_recycler;

import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: MGRecyclerAdapterSimple.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGRecyclerAdapterSimple$setData$1<V> implements Callable<DiffUtil$DiffResult> {
    public final /* synthetic */ List $newData;
    public final /* synthetic */ List $oldData;
    public final /* synthetic */ MGRecyclerAdapterSimple this$0;

    public MGRecyclerAdapterSimple$setData$1(MGRecyclerAdapterSimple mGRecyclerAdapterSimple, List list, List list2) {
        this.this$0 = mGRecyclerAdapterSimple;
        this.$oldData = list;
        this.$newData = list2;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ DiffUtil$DiffResult call() {
        return call();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public final DiffUtil$DiffResult call() {
        return MGRecyclerAdapterSimple.access$getDiffCreator$p(this.this$0).calculateDiffResult(this.$oldData, this.$newData);
    }
}
