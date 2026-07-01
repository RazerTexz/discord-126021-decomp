package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories$Companion$fromCache$1$guildChannelIdsCollapsed$1 extends o implements Function1<String, Long> {
    public static final StoreCollapsedChannelCategories$Companion$fromCache$1$guildChannelIdsCollapsed$1 INSTANCE = new StoreCollapsedChannelCategories$Companion$fromCache$1$guildChannelIdsCollapsed$1();

    public StoreCollapsedChannelCategories$Companion$fromCache$1$guildChannelIdsCollapsed$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(String str) {
        return Long.valueOf(invoke2(str));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(String str) {
        m.checkNotNullParameter(str, "it");
        return Long.parseLong(str);
    }
}
