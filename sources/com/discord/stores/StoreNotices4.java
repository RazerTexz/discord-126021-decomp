package com.discord.stores;

import com.discord.stores.StoreNotices;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreNotices$noticeQueue$1, reason: use source file name */
/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotices4 extends Lambda implements Function1<StoreNotices.Notice, Comparable<?>> {
    public static final StoreNotices4 INSTANCE = new StoreNotices4();

    public StoreNotices4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Comparable<?> invoke(StoreNotices.Notice notice) {
        return Boolean.valueOf(notice instanceof StoreNotices.PassiveNotice);
    }
}
