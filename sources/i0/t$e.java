package i0;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t$e<T> extends t<Map<String, T>> {
    public final Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3749b;
    public final h<T, String> c;

    public t$e(Method method, int i, h<T, String> hVar) {
        this.a = method;
        this.f3749b = i;
        this.c = hVar;
    }

    @Override // i0.t
    public void a(v vVar, Object obj) throws IOException {
        Map map = (Map) obj;
        if (map == null) {
            throw c0.l(this.a, this.f3749b, "Header map was null.", new Object[0]);
        }
        for (Map$Entry map$Entry : map.entrySet()) {
            String str = (String) map$Entry.getKey();
            if (str == null) {
                throw c0.l(this.a, this.f3749b, "Header map contained null key.", new Object[0]);
            }
            Object value = map$Entry.getValue();
            if (value == null) {
                throw c0.l(this.a, this.f3749b, b.d.b.a.a.y("Header map contained null value for key '", str, "'."), new Object[0]);
            }
            vVar.b(str, this.c.convert((T) value));
        }
    }
}
