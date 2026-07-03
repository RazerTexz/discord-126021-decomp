package p615g0;

import java.io.IOException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.i */
/* JADX INFO: compiled from: ForwardingSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12392i implements InterfaceC12405v {
    private final InterfaceC12405v delegate;

    public AbstractC12392i(InterfaceC12405v interfaceC12405v) {
        C12238m.checkParameterIsNotNull(interfaceC12405v, "delegate");
        this.delegate = interfaceC12405v;
    }

    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final InterfaceC12405v m11491deprecated_delegate() {
        return this.delegate;
    }

    @Override // p615g0.InterfaceC12405v, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final InterfaceC12405v delegate() {
        return this.delegate;
    }

    @Override // p615g0.InterfaceC12405v, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // p615g0.InterfaceC12405v
    public C12408y timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // p615g0.InterfaceC12405v
    public void write(C12388e c12388e, long j) throws IOException {
        C12238m.checkParameterIsNotNull(c12388e, "source");
        this.delegate.write(c12388e, j);
    }
}
