package i0;

import java.io.IOException;
import java.lang.reflect.Method;
import okhttp3.Headers;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t$g<T> extends t<T> {
    public final Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3751b;
    public final Headers c;
    public final h<T, RequestBody> d;

    public t$g(Method method, int i, Headers headers, h<T, RequestBody> hVar) {
        this.a = method;
        this.f3751b = i;
        this.c = headers;
        this.d = hVar;
    }

    @Override // i0.t
    public void a(v vVar, T t) {
        if (t == null) {
            return;
        }
        try {
            vVar.c(this.c, this.d.convert(t));
        } catch (IOException e) {
            throw c0.l(this.a, this.f3751b, "Unable to convert " + t + " to RequestBody", e);
        }
    }
}
