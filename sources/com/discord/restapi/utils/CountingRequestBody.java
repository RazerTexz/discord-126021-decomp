package com.discord.restapi.utils;

import b.d.b.a.a;
import d0.g0.c;
import d0.z.d.m;
import g0.q;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.ByteString;
import okio.ByteString$a;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: CountingRequestBody.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CountingRequestBody extends RequestBody {
    private final BehaviorSubject<Long> bytesWrittenSubject;
    private final RequestBody delegate;
    private final long estimatedContentLength;
    private final int ignoreWriteToCount;
    private int numWriteToCalls;

    public /* synthetic */ CountingRequestBody(RequestBody requestBody, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(requestBody, (i2 & 2) != 0 ? 0 : i);
    }

    public static final /* synthetic */ void access$updateProgress(CountingRequestBody countingRequestBody, long j) {
        countingRequestBody.updateProgress(j);
    }

    private final void updateProgress(long bytesWritten) {
        if (this.numWriteToCalls > this.ignoreWriteToCount) {
            this.bytesWrittenSubject.onNext(Long.valueOf(bytesWritten));
        }
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return -1L;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.delegate.contentType();
    }

    public final Observable<Long> getBytesWrittenObservable() {
        Observable<Long> observableL = this.bytesWrittenSubject.r().L();
        m.checkNotNullExpressionValue(observableL, "bytesWrittenSubject.dist…().onBackpressureLatest()");
        return observableL;
    }

    public final long getEstimatedContentLength() {
        return this.estimatedContentLength;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        m.checkNotNullParameter(sink, "sink");
        int i = this.numWriteToCalls;
        this.numWriteToCalls = i + 1;
        if (i < this.ignoreWriteToCount) {
            ByteString$a byteString$a = ByteString.k;
            StringBuilder sbQ = a.Q('<');
            sbQ.append(this.delegate);
            sbQ.append('>');
            sink.e0(byteString$a.b(sbQ.toString(), c.a));
            return;
        }
        CountingRequestBody$CountingSink countingRequestBody$CountingSink = new CountingRequestBody$CountingSink(sink, new CountingRequestBody$writeTo$countingSink$1(this));
        m.checkParameterIsNotNull(countingRequestBody$CountingSink, "$this$buffer");
        q qVar = new q(countingRequestBody$CountingSink);
        this.delegate.writeTo(qVar);
        qVar.flush();
    }

    public CountingRequestBody(RequestBody requestBody, int i) {
        m.checkNotNullParameter(requestBody, "delegate");
        this.delegate = requestBody;
        this.ignoreWriteToCount = i;
        this.bytesWrittenSubject = BehaviorSubject.l0(0L);
        this.estimatedContentLength = requestBody.contentLength();
    }
}
