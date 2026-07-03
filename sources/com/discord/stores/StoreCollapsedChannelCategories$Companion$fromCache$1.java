package com.discord.stores;

import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import p507d0.C12116o;
import p507d0.p578f0.C12078q;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories$Companion$fromCache$1 extends AbstractC12240o implements Function2<String, String, Pair<? extends Long, ? extends Set<Long>>> {
    public static final StoreCollapsedChannelCategories$Companion$fromCache$1 INSTANCE = new StoreCollapsedChannelCategories$Companion$fromCache$1();

    public StoreCollapsedChannelCategories$Companion$fromCache$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Pair<Long, Set<Long>> invoke(String str, String str2) {
        C12238m.checkNotNullParameter(str, "key");
        C12238m.checkNotNullParameter(str2, "value");
        long j = Long.parseLong(str);
        return C12116o.m10073to(Long.valueOf(j), C12078q.toHashSet(C12078q.map(C12106w.splitToSequence$default(str2, new String[]{","}, false, 0, 6, null), C5849x7ea1d0ee.INSTANCE)));
    }
}
