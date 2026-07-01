package com.discord.stores;

import com.discord.stores.StoreNotices;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreNotices$noticeQueue$2, reason: use source file name */
/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotices5 extends Lambda implements Function1<StoreNotices.Notice, Comparable<?>> {
    public static final StoreNotices5 INSTANCE = new StoreNotices5();

    public StoreNotices5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Comparable<?> invoke(StoreNotices.Notice notice) {
        return Integer.valueOf(-notice.getPriority());
    }
}
