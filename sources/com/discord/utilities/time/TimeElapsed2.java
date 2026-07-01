package com.discord.utilities.time;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.time.TimeElapsed$milliseconds$2, reason: use source file name */
/* JADX INFO: compiled from: TimeElapsed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TimeElapsed2 extends Lambda implements Function0<Long> {
    public final /* synthetic */ Clock $clock;
    public final /* synthetic */ TimeElapsed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeElapsed2(TimeElapsed timeElapsed, Clock clock) {
        super(0);
        this.this$0 = timeElapsed;
        this.$clock = clock;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.$clock.currentTimeMillis() - this.this$0.startTime;
    }
}
