package com.discord.stores;

import d0.f0.q;
import d0.g0.w;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories$Companion$fromCache$1 extends o implements Function2<String, String, Pair<? extends Long, ? extends Set<Long>>> {
    public static final StoreCollapsedChannelCategories$Companion$fromCache$1 INSTANCE = new StoreCollapsedChannelCategories$Companion$fromCache$1();

    public StoreCollapsedChannelCategories$Companion$fromCache$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Pair<? extends Long, ? extends Set<Long>> invoke(String str, String str2) {
        return invoke2(str, str2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<Long, Set<Long>> invoke2(String str, String str2) {
        m.checkNotNullParameter(str, "key");
        m.checkNotNullParameter(str2, "value");
        long j = Long.parseLong(str);
        return d0.o.to(Long.valueOf(j), q.toHashSet(q.map(w.splitToSequence$default(str2, new String[]{","}, false, 0, 6, null), StoreCollapsedChannelCategories$Companion$fromCache$1$guildChannelIdsCollapsed$1.INSTANCE)));
    }
}
