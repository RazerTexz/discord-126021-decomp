package p615g0;

import java.io.IOException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.j */
/* JADX INFO: compiled from: ForwardingSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12393j implements InterfaceC12407x {

    /* JADX INFO: renamed from: j */
    public final InterfaceC12407x f26093j;

    public AbstractC12393j(InterfaceC12407x interfaceC12407x) {
        C12238m.checkParameterIsNotNull(interfaceC12407x, "delegate");
        this.f26093j = interfaceC12407x;
    }

    @Override // p615g0.InterfaceC12407x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26093j.close();
    }

    @Override // p615g0.InterfaceC12407x
    public C12408y timeout() {
        return this.f26093j.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f26093j + ')';
    }
}
