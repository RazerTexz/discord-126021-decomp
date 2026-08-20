package com.discord.stores;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotices$noticeQueue$1 extends AbstractC12240o implements Function1<StoreNotices.Notice, Comparable<?>> {
    public static final StoreNotices$noticeQueue$1 INSTANCE = new StoreNotices$noticeQueue$1();

    public StoreNotices$noticeQueue$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Comparable<?> invoke(StoreNotices.Notice notice) {
        return Boolean.valueOf(notice instanceof StoreNotices.PassiveNotice);
    }
}
