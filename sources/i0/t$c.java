package i0;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t$c<T> extends t<Map<String, T>> {
    public final Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3747b;
    public final h<T, String> c;
    public final boolean d;

    public t$c(Method method, int i, h<T, String> hVar, boolean z2) {
        this.a = method;
        this.f3747b = i;
        this.c = hVar;
        this.d = z2;
    }

    @Override // i0.t
    public void a(v vVar, Object obj) throws IOException {
        Map map = (Map) obj;
        if (map == null) {
            throw c0.l(this.a, this.f3747b, "Field map was null.", new Object[0]);
        }
        for (Map$Entry map$Entry : map.entrySet()) {
            String str = (String) map$Entry.getKey();
            if (str == null) {
                throw c0.l(this.a, this.f3747b, "Field map contained null key.", new Object[0]);
            }
            Object value = map$Entry.getValue();
            if (value == null) {
                throw c0.l(this.a, this.f3747b, b.d.b.a.a.y("Field map contained null value for key '", str, "'."), new Object[0]);
            }
            String strConvert = this.c.convert((T) value);
            if (strConvert == null) {
                throw c0.l(this.a, this.f3747b, "Field map value '" + value + "' converted to null by " + this.c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
            }
            vVar.a(str, strConvert, this.d);
        }
    }
}
