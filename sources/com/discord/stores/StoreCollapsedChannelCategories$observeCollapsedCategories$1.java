package com.discord.stores;

import d0.t.n0;
import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories$observeCollapsedCategories$1 extends o implements Function0<Set<? extends Long>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreCollapsedChannelCategories this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreCollapsedChannelCategories$observeCollapsedCategories$1(StoreCollapsedChannelCategories storeCollapsedChannelCategories, long j) {
        super(0);
        this.this$0 = storeCollapsedChannelCategories;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends Long> invoke2() {
        Set<Long> setEmptySet = this.this$0.getCollapsedCategories().get(Long.valueOf(this.$guildId));
        if (setEmptySet == null) {
            setEmptySet = n0.emptySet();
        }
        return setEmptySet;
    }
}
