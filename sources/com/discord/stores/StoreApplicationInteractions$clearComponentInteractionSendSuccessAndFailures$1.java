package com.discord.stores;

import d0.z.d.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationInteractions$clearComponentInteractionSendSuccessAndFailures$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreApplicationInteractions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationInteractions$clearComponentInteractionSendSuccessAndFailures$1(StoreApplicationInteractions storeApplicationInteractions) {
        super(0);
        this.this$0 = storeApplicationInteractions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator<T> it = this.this$0.getInteractionComponentSendState().keySet().iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            Map<Integer, StoreApplicationInteractions$InteractionSendState> map = this.this$0.getInteractionComponentSendState().get(Long.valueOf(jLongValue));
            if (map != null) {
                linkedHashMap = new LinkedHashMap();
                for (Map$Entry<Integer, StoreApplicationInteractions$InteractionSendState> map$Entry : map.entrySet()) {
                    if (map$Entry.getValue() instanceof StoreApplicationInteractions$InteractionSendState$Loading) {
                        linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
                    }
                }
            } else {
                linkedHashMap = null;
            }
            if (linkedHashMap != null) {
                linkedHashMap2.put(Long.valueOf(jLongValue), linkedHashMap);
            }
        }
        this.this$0.getInteractionComponentSendState().clear();
        this.this$0.getInteractionComponentSendState().putAll(linkedHashMap2);
        this.this$0.markChanged(StoreApplicationInteractions.Companion.getComponentStateUpdate());
    }
}
