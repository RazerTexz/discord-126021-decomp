package com.discord.stores;

import com.discord.api.botuikit.SelectItem;
import d0.t.h0;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreLocalActionComponentState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLocalActionComponentState$setSelectComponentSelection$1 extends o implements Function0<Unit> {
    public final /* synthetic */ int $componentIndex;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ List $selectedItems;
    public final /* synthetic */ StoreLocalActionComponentState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreLocalActionComponentState$setSelectComponentSelection$1(StoreLocalActionComponentState storeLocalActionComponentState, long j, List list, int i) {
        super(0);
        this.this$0 = storeLocalActionComponentState;
        this.$messageId = j;
        this.$selectedItems = list;
        this.$componentIndex = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Map<Integer, List<SelectItem>> linkedHashMap;
        Map<Integer, List<SelectItem>> map = this.this$0.getSelectComponentSelections().get(Long.valueOf(this.$messageId));
        if (map == null || (linkedHashMap = h0.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        linkedHashMap.put(Integer.valueOf(this.$componentIndex), this.$selectedItems);
        this.this$0.getSelectComponentSelections().put(Long.valueOf(this.$messageId), linkedHashMap);
        this.this$0.markChanged();
    }
}
