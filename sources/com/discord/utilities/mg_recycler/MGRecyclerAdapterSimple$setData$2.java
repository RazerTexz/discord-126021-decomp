package com.discord.utilities.mg_recycler;

import androidx.recyclerview.widget.DiffUtil$DiffResult;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MGRecyclerAdapterSimple.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGRecyclerAdapterSimple$setData$2 extends o implements Function1<DiffUtil$DiffResult, Unit> {
    public final /* synthetic */ List $newData;
    public final /* synthetic */ List $oldData;
    public final /* synthetic */ MGRecyclerAdapterSimple this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MGRecyclerAdapterSimple$setData$2(MGRecyclerAdapterSimple mGRecyclerAdapterSimple, List list, List list2) {
        super(1);
        this.this$0 = mGRecyclerAdapterSimple;
        this.$oldData = list;
        this.$newData = list2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DiffUtil$DiffResult diffUtil$DiffResult) {
        invoke2(diffUtil$DiffResult);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DiffUtil$DiffResult diffUtil$DiffResult) {
        MGRecyclerAdapterSimple.access$dispatchUpdates(this.this$0, diffUtil$DiffResult, this.$oldData, this.$newData);
    }
}
