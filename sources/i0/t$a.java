package i0;

import java.io.IOException;
import java.lang.reflect.Method;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t$a<T> extends t<T> {
    public final Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3745b;
    public final h<T, RequestBody> c;

    public t$a(Method method, int i, h<T, RequestBody> hVar) {
        this.a = method;
        this.f3745b = i;
        this.c = hVar;
    }

    @Override // i0.t
    public void a(v vVar, T t) {
        if (t == null) {
            throw c0.l(this.a, this.f3745b, "Body parameter value must not be null.", new Object[0]);
        }
        try {
            vVar.m = this.c.convert(t);
        } catch (IOException e) {
            throw c0.m(this.a, e, this.f3745b, "Unable to convert " + t + " to RequestBody", new Object[0]);
        }
    }
}
