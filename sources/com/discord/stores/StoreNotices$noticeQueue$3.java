package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotices$noticeQueue$3 extends o implements Function1<StoreNotices$Notice, Comparable<?>> {
    public static final StoreNotices$noticeQueue$3 INSTANCE = new StoreNotices$noticeQueue$3();

    public StoreNotices$noticeQueue$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Comparable<?> invoke(StoreNotices$Notice storeNotices$Notice) {
        return invoke2(storeNotices$Notice);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Comparable<?> invoke2(StoreNotices$Notice storeNotices$Notice) {
        return Long.valueOf(storeNotices$Notice.getRequestedShowTimestamp());
    }
}
