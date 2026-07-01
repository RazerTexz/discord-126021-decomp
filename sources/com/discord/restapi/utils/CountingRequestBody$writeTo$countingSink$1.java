package com.discord.restapi.utils;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CountingRequestBody.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CountingRequestBody$writeTo$countingSink$1 extends k implements Function1<Long, Unit> {
    public CountingRequestBody$writeTo$countingSink$1(CountingRequestBody countingRequestBody) {
        super(1, countingRequestBody, CountingRequestBody.class, "updateProgress", "updateProgress(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        CountingRequestBody.access$updateProgress((CountingRequestBody) this.receiver, j);
    }
}
