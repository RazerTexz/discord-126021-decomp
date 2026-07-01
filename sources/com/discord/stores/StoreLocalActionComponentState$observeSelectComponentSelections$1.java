package com.discord.stores;

import com.discord.api.botuikit.SelectItem;
import d0.z.d.o;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreLocalActionComponentState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLocalActionComponentState$observeSelectComponentSelections$1 extends o implements Function0<Map<Long, ? extends Map<Integer, ? extends List<? extends SelectItem>>>> {
    public final /* synthetic */ StoreLocalActionComponentState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreLocalActionComponentState$observeSelectComponentSelections$1(StoreLocalActionComponentState storeLocalActionComponentState) {
        super(0);
        this.this$0 = storeLocalActionComponentState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Integer, ? extends List<? extends SelectItem>>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Map<Integer, ? extends List<? extends SelectItem>>> invoke2() {
        return this.this$0.getSelectComponentSelectionsData();
    }
}
