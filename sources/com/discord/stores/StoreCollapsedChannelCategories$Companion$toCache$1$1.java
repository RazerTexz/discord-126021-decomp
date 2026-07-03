package com.discord.stores;

import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories$Companion$toCache$1$1 extends AbstractC12240o implements Function1<Set<Long>, String> {
    public static final StoreCollapsedChannelCategories$Companion$toCache$1$1 INSTANCE = new StoreCollapsedChannelCategories$Companion$toCache$1$1();

    public StoreCollapsedChannelCategories$Companion$toCache$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(Set<Long> set) {
        C12238m.checkNotNullParameter(set, "value");
        return C12163u.joinToString$default(set, ",", null, null, 0, null, null, 62, null);
    }
}
