package i0;

import java.io.IOException;

/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t$l<T> extends t<T> {
    public final h<T, String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3756b;

    public t$l(h<T, String> hVar, boolean z2) {
        this.a = hVar;
        this.f3756b = z2;
    }

    @Override // i0.t
    public void a(v vVar, T t) throws IOException {
        if (t == null) {
            return;
        }
        vVar.d(this.a.convert(t), null, this.f3756b);
    }
}
