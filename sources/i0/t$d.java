package i0;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t$d<T> extends t<T> {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h<T, String> f3748b;

    public t$d(String str, h<T, String> hVar) {
        Objects.requireNonNull(str, "name == null");
        this.a = str;
        this.f3748b = hVar;
    }

    @Override // i0.t
    public void a(v vVar, T t) throws IOException {
        String strConvert;
        if (t == null || (strConvert = this.f3748b.convert(t)) == null) {
            return;
        }
        vVar.b(this.a, strConvert);
    }
}
