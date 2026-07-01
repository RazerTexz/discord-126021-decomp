package com.discord.utilities.time;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.time.TimeElapsed$seconds$2, reason: use source file name */
/* JADX INFO: compiled from: TimeElapsed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TimeElapsed3 extends Lambda implements Function0<Float> {
    public final /* synthetic */ TimeElapsed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeElapsed3(TimeElapsed timeElapsed) {
        super(0);
        this.this$0 = timeElapsed;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Float invoke() {
        return Float.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final float invoke2() {
        return this.this$0.getMilliseconds() / 1000.0f;
    }
}
