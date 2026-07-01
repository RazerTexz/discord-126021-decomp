package com.discord.stores;


/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum StoreNotices$Dialog$Type {
    REQUEST_RATING_MODAL,
    DELETE_CONNECTION_MODAL;

    public static /* synthetic */ StoreNotices$PassiveNotice buildPassiveNotice$default(StoreNotices$Dialog$Type storeNotices$Dialog$Type, int i, long j, long j2, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 10;
        }
        if ((i2 & 2) != 0) {
            j = 31536000000L;
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            j2 = 21600000;
        }
        return storeNotices$Dialog$Type.buildPassiveNotice(i, j3, j2, (i2 & 8) != 0 ? false : z2);
    }

    public final StoreNotices$PassiveNotice buildPassiveNotice(int priority, long sinceLastPeriodMs, long delayPeriodMs, boolean persist) {
        return new StoreNotices$PassiveNotice(name(), priority, persist, sinceLastPeriodMs, delayPeriodMs, new StoreNotices$Dialog$Type$buildPassiveNotice$1(this));
    }
}
