package com.discord.stores;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreCollapsedChannelCategories$Companion$fromCache$1$guildChannelIdsCollapsed$1, reason: use source file name */
/* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories3 extends Lambda implements Function1<String, Long> {
    public static final StoreCollapsedChannelCategories3 INSTANCE = new StoreCollapsedChannelCategories3();

    public StoreCollapsedChannelCategories3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(String str) {
        return Long.valueOf(invoke2(str));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
        return Long.parseLong(str);
    }
}
