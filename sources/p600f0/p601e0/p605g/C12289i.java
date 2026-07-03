package p600f0.p601e0.p605g;

import okio.BufferedSink;
import p600f0.p601e0.p613n.C12355d;
import p615g0.InterfaceC12390g;

/* JADX INFO: renamed from: f0.e0.g.i */
/* JADX INFO: compiled from: RealConnection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12289i extends C12355d.c {

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C12283c f25488m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ InterfaceC12390g f25489n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ BufferedSink f25490o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12289i(C12283c c12283c, InterfaceC12390g interfaceC12390g, BufferedSink bufferedSink, boolean z2, InterfaceC12390g interfaceC12390g2, BufferedSink bufferedSink2) {
        super(z2, interfaceC12390g2, bufferedSink2);
        this.f25488m = c12283c;
        this.f25489n = interfaceC12390g;
        this.f25490o = bufferedSink;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f25488m.m10167a(-1L, true, true, null);
    }
}
