package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories$setCollapsedCategory$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $categoryId;
    public final /* synthetic */ boolean $collapsed;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreCollapsedChannelCategories this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreCollapsedChannelCategories$setCollapsedCategory$1(StoreCollapsedChannelCategories storeCollapsedChannelCategories, long j, long j2, boolean z2) {
        super(0);
        this.this$0 = storeCollapsedChannelCategories;
        this.$guildId = j;
        this.$categoryId = j2;
        this.$collapsed = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreCollapsedChannelCategories.access$setCollapsedState(this.this$0, this.$guildId, this.$categoryId, this.$collapsed);
    }
}
