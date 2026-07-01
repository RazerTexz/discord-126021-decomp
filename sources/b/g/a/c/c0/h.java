package b.g.a.c.c0;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: AnnotatedFieldCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends u {
    public final b.g.a.c.h0.n d;
    public final t$a e;
    public final boolean f;

    public h(b.g.a.c.b bVar, b.g.a.c.h0.n nVar, t$a t_a, boolean z2) {
        super(bVar);
        this.d = nVar;
        this.e = bVar == null ? null : t_a;
        this.f = z2;
    }

    public final Map<String, h$a> f(e0 e0Var, b.g.a.c.j jVar, Map<String, h$a> map) {
        t$a t_a;
        Class<?> clsA;
        h$a h_a;
        b.g.a.c.j jVarQ = jVar.q();
        if (jVarQ == null) {
            return map;
        }
        Class<?> cls = jVar._class;
        Map<String, h$a> mapF = f(new e0$a(this.d, jVarQ.j()), jVarQ, map);
        for (Field field : cls.getDeclaredFields()) {
            if (g(field)) {
                if (mapF == null) {
                    mapF = new LinkedHashMap<>();
                }
                h$a h_a2 = new h$a(e0Var, field);
                if (this.f) {
                    h_a2.c = b(h_a2.c, field.getDeclaredAnnotations());
                }
                mapF.put(field.getName(), h_a2);
            }
        }
        if (mapF != null && (t_a = this.e) != null && (clsA = t_a.a(cls)) != null) {
            Iterator it = ((ArrayList) b.g.a.c.i0.d.j(clsA, cls, true)).iterator();
            while (it.hasNext()) {
                for (Field field2 : ((Class) it.next()).getDeclaredFields()) {
                    if (g(field2) && (h_a = mapF.get(field2.getName())) != null) {
                        h_a.c = b(h_a.c, field2.getDeclaredAnnotations());
                    }
                }
            }
        }
        return mapF;
    }

    public final boolean g(Field field) {
        return (field.isSynthetic() || Modifier.isStatic(field.getModifiers())) ? false : true;
    }
}
