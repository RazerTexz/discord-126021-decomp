package i0;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map$Entry;
import okhttp3.Headers;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t$h<T> extends t<Map<String, T>> {
    public final Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3752b;
    public final h<T, RequestBody> c;
    public final String d;

    public t$h(Method method, int i, h<T, RequestBody> hVar, String str) {
        this.a = method;
        this.f3752b = i;
        this.c = hVar;
        this.d = str;
    }

    @Override // i0.t
    public void a(v vVar, Object obj) throws IOException {
        Map map = (Map) obj;
        if (map == null) {
            throw c0.l(this.a, this.f3752b, "Part map was null.", new Object[0]);
        }
        for (Map$Entry map$Entry : map.entrySet()) {
            String str = (String) map$Entry.getKey();
            if (str == null) {
                throw c0.l(this.a, this.f3752b, "Part map contained null key.", new Object[0]);
            }
            Object value = map$Entry.getValue();
            if (value == null) {
                throw c0.l(this.a, this.f3752b, b.d.b.a.a.y("Part map contained null value for key '", str, "'."), new Object[0]);
            }
            vVar.c(Headers.j.c("Content-Disposition", b.d.b.a.a.y("form-data; name=\"", str, "\""), "Content-Transfer-Encoding", this.d), this.c.convert((T) value));
        }
    }
}
