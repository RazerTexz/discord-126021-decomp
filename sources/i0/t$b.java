package i0;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t$b<T> extends t<T> {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h<T, String> f3746b;
    public final boolean c;

    public t$b(String str, h<T, String> hVar, boolean z2) {
        Objects.requireNonNull(str, "name == null");
        this.a = str;
        this.f3746b = hVar;
        this.c = z2;
    }

    @Override // i0.t
    public void a(v vVar, T t) throws IOException {
        String strConvert;
        if (t == null || (strConvert = this.f3746b.convert(t)) == null) {
            return;
        }
        vVar.a(this.a, strConvert, this.c);
    }
}
