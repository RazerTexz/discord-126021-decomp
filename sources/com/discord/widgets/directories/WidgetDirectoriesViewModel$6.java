package com.discord.widgets.directories;

import com.discord.stores.StoreReadStates;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel$6 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ StoreReadStates $readStatesStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesViewModel$6(StoreReadStates storeReadStates) {
        super(1);
        this.$readStatesStore = storeReadStates;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        this.$readStatesStore.markAsRead(l);
    }
}
