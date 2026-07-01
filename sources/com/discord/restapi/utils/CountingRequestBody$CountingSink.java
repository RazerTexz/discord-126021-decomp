package com.discord.restapi.utils;

import d0.z.d.m;
import g0.e;
import g0.i;
import g0.v;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CountingRequestBody.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CountingRequestBody$CountingSink extends i {
    private long bytesWritten;
    private final Function1<Long, Unit> listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CountingRequestBody$CountingSink(v vVar, Function1<? super Long, Unit> function1) {
        super(vVar);
        m.checkNotNullParameter(vVar, "delegate");
        m.checkNotNullParameter(function1, "listener");
        this.listener = function1;
    }

    @Override // g0.i, g0.v
    public void write(e source, long byteCount) throws IOException {
        m.checkNotNullParameter(source, "source");
        super.write(source, byteCount);
        long j = this.bytesWritten + byteCount;
        this.bytesWritten = j;
        this.listener.invoke(Long.valueOf(j));
    }
}
