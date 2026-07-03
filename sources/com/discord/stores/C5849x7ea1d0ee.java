package com.discord.stores;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.stores.StoreCollapsedChannelCategories$Companion$fromCache$1$guildChannelIdsCollapsed$1 */
/* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C5849x7ea1d0ee extends AbstractC12240o implements Function1<String, Long> {
    public static final C5849x7ea1d0ee INSTANCE = new C5849x7ea1d0ee();

    public C5849x7ea1d0ee() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(String str) {
        return Long.valueOf(invoke2(str));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(String str) {
        C12238m.checkNotNullParameter(str, "it");
        return Long.parseLong(str);
    }
}
