package com.discord.utilities.networking;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Backoff.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface Backoff$Scheduler {
    void cancel();

    void schedule(Function0<Unit> action, long delayMs);
}
