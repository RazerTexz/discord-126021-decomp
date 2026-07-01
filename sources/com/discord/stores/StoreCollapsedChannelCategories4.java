package com.discord.stores;

import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreCollapsedChannelCategories$Companion$toCache$1$1, reason: use source file name */
/* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories4 extends Lambda implements Function1<Set<Long>, String> {
    public static final StoreCollapsedChannelCategories4 INSTANCE = new StoreCollapsedChannelCategories4();

    public StoreCollapsedChannelCategories4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(Set<Long> set) {
        Intrinsics3.checkNotNullParameter(set, "value");
        return _Collections.joinToString$default(set, ",", null, null, 0, null, null, 62, null);
    }
}
