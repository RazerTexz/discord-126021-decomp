package com.discord.restapi.utils;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.ByteString;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12086c;
import p507d0.p592z.p594d.C12238m;
import p615g0.AbstractC12392i;
import p615g0.C12388e;
import p615g0.C12400q;
import p615g0.InterfaceC12405v;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: CountingRequestBody.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CountingRequestBody extends RequestBody {
    private final BehaviorSubject<Long> bytesWrittenSubject;
    private final RequestBody delegate;
    private final long estimatedContentLength;
    private final int ignoreWriteToCount;
    private int numWriteToCalls;

    /* JADX INFO: compiled from: CountingRequestBody.kt */
    public static final class CountingSink extends AbstractC12392i {
        private long bytesWritten;
        private final Function1<Long, Unit> listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public CountingSink(InterfaceC12405v interfaceC12405v, Function1<? super Long, Unit> function1) {
            super(interfaceC12405v);
            C12238m.checkNotNullParameter(interfaceC12405v, "delegate");
            C12238m.checkNotNullParameter(function1, "listener");
            this.listener = function1;
        }

        @Override // p615g0.AbstractC12392i, p615g0.InterfaceC12405v
        public void write(C12388e source, long byteCount) throws IOException {
            C12238m.checkNotNullParameter(source, "source");
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
        Observable<Long> observableM11086L = this.bytesWrittenSubject.m11112r().m11086L();
        C12238m.checkNotNullExpressionValue(observableM11086L, "bytesWrittenSubject.dist…().onBackpressureLatest()");
        return observableM11086L;
    }

    public final long getEstimatedContentLength() {
        return this.estimatedContentLength;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        C12238m.checkNotNullParameter(sink, "sink");
        int i = this.numWriteToCalls;
        this.numWriteToCalls = i + 1;
        if (i < this.ignoreWriteToCount) {
            ByteString.Companion companion = ByteString.INSTANCE;
            StringBuilder sbM829Q = C1643a.m829Q('<');
            sbM829Q.append(this.delegate);
            sbM829Q.append('>');
            sink.mo10455e0(companion.m11011b(sbM829Q.toString(), C12086c.f25136a));
            return;
        }
        CountingSink countingSink = new CountingSink(sink, new CountingRequestBody$writeTo$countingSink$1(this));
        C12238m.checkParameterIsNotNull(countingSink, "$this$buffer");
        C12400q c12400q = new C12400q(countingSink);
        this.delegate.writeTo(c12400q);
        c12400q.flush();
    }

    public CountingRequestBody(RequestBody requestBody, int i) {
        C12238m.checkNotNullParameter(requestBody, "delegate");
        this.delegate = requestBody;
        this.ignoreWriteToCount = i;
        this.bytesWrittenSubject = BehaviorSubject.m11130l0(0L);
        this.estimatedContentLength = requestBody.contentLength();
    }
}
