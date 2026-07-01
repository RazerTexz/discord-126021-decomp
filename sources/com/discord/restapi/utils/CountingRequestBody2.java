package com.discord.restapi.utils;

import d0.z.d.FunctionReferenceImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.restapi.utils.CountingRequestBody$writeTo$countingSink$1, reason: use source file name */
/* JADX INFO: compiled from: CountingRequestBody.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CountingRequestBody2 extends FunctionReferenceImpl implements Function1<Long, Unit> {
    public CountingRequestBody2(CountingRequestBody countingRequestBody) {
        super(1, countingRequestBody, CountingRequestBody.class, "updateProgress", "updateProgress(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        ((CountingRequestBody) this.receiver).updateProgress(j);
    }
}
