package com.discord.restapi.utils;

import b.d.b.a.outline;
import d0.g0.Charsets2;
import d0.z.d.Intrinsics3;
import g0.Buffer3;
import g0.ForwardingSink;
import g0.RealBufferedSink;
import g0.Sink;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.ByteString;
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

    /* JADX INFO: compiled from: CountingRequestBody.kt */
    public static final class CountingSink extends ForwardingSink {
        private long bytesWritten;
        private final Function1<Long, Unit> listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public CountingSink(Sink sink, Function1<? super Long, Unit> function1) {
            super(sink);
            Intrinsics3.checkNotNullParameter(sink, "delegate");
            Intrinsics3.checkNotNullParameter(function1, "listener");
            this.listener = function1;
        }

        @Override // g0.ForwardingSink, g0.Sink
        public void write(Buffer3 source, long byteCount) throws IOException {
            Intrinsics3.checkNotNullParameter(source, "source");
            super.write(source, byteCount);
            long j = this.bytesWritten + byteCount;
            this.bytesWritten = j;
            this.listener.invoke(Long.valueOf(j));
        }
    }

    public /* synthetic */ CountingRequestBody(RequestBody requestBody, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(requestBody, (i2 & 2) != 0 ? 0 : i);
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
        Intrinsics3.checkNotNullExpressionValue(observableL, "bytesWrittenSubject.dist…().onBackpressureLatest()");
        return observableL;
    }

    public final long getEstimatedContentLength() {
        return this.estimatedContentLength;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        Intrinsics3.checkNotNullParameter(sink, "sink");
        int i = this.numWriteToCalls;
        this.numWriteToCalls = i + 1;
        if (i < this.ignoreWriteToCount) {
            ByteString.Companion companion = ByteString.INSTANCE;
            StringBuilder sbQ = outline.Q('<');
            sbQ.append(this.delegate);
            sbQ.append('>');
            sink.e0(companion.b(sbQ.toString(), Charsets2.a));
            return;
        }
        CountingSink countingSink = new CountingSink(sink, new CountingRequestBody2(this));
        Intrinsics3.checkParameterIsNotNull(countingSink, "$this$buffer");
        RealBufferedSink realBufferedSink = new RealBufferedSink(countingSink);
        this.delegate.writeTo(realBufferedSink);
        realBufferedSink.flush();
    }

    public CountingRequestBody(RequestBody requestBody, int i) {
        Intrinsics3.checkNotNullParameter(requestBody, "delegate");
        this.delegate = requestBody;
        this.ignoreWriteToCount = i;
        this.bytesWrittenSubject = BehaviorSubject.l0(0L);
        this.estimatedContentLength = requestBody.contentLength();
    }
}
