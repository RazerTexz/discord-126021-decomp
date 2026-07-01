package com.discord.workers;

import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: BackgroundMessageSendWorker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BackgroundMessageSendWorker$a<T, R> implements b<Boolean, Boolean> {
    public static final BackgroundMessageSendWorker$a j = new BackgroundMessageSendWorker$a();

    @Override // j0.k.b
    public Boolean call(Boolean bool) {
        return Boolean.valueOf(m.areEqual(bool, Boolean.TRUE));
    }
}
