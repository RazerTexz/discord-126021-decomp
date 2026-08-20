package com.discord.stores;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotices$noticeQueue$2 extends AbstractC12240o implements Function1<StoreNotices.Notice, Comparable<?>> {
    public static final StoreNotices$noticeQueue$2 INSTANCE = new StoreNotices$noticeQueue$2();

    public StoreNotices$noticeQueue$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Comparable<?> invoke(StoreNotices.Notice notice) {
        return Integer.valueOf(-notice.getPriority());
    }
}
