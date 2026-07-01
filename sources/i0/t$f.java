package i0;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.Headers$a;

/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t$f extends t<Headers> {
    public final Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3750b;

    public t$f(Method method, int i) {
        this.a = method;
        this.f3750b = i;
    }

    @Override // i0.t
    public void a(v vVar, Headers headers) throws IOException {
        Headers headers2 = headers;
        if (headers2 == null) {
            throw c0.l(this.a, this.f3750b, "Headers parameter must not be null.", new Object[0]);
        }
        Headers$a headers$a = vVar.h;
        Objects.requireNonNull(headers$a);
        d0.z.d.m.checkParameterIsNotNull(headers2, "headers");
        int size = headers2.size();
        for (int i = 0; i < size; i++) {
            headers$a.b(headers2.d(i), headers2.g(i));
        }
    }
}
