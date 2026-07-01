package com.discord.stores;

import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMentions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMentions$observeMentionCounts$1 extends o implements Function0<Map<Long, ? extends Integer>> {
    public final /* synthetic */ StoreMentions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMentions$observeMentionCounts$1(StoreMentions storeMentions) {
        super(0);
        this.this$0 = storeMentions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Integer> invoke2() {
        return this.this$0.getMentionCounts();
    }
}
