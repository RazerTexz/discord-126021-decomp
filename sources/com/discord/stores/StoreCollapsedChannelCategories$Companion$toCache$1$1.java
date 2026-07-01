package com.discord.stores;

import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories$Companion$toCache$1$1 extends o implements Function1<Set<Long>, String> {
    public static final StoreCollapsedChannelCategories$Companion$toCache$1$1 INSTANCE = new StoreCollapsedChannelCategories$Companion$toCache$1$1();

    public StoreCollapsedChannelCategories$Companion$toCache$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Set<Long> set) {
        return invoke2(set);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Set<Long> set) {
        m.checkNotNullParameter(set, "value");
        return u.joinToString$default(set, ",", null, null, 0, null, null, 62, null);
    }
}
