package p007b.p195g.p196a.p205c.p210c0;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: renamed from: b.g.a.c.c0.h */
/* JADX INFO: compiled from: AnnotatedFieldCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2187h extends C2200u {

    /* JADX INFO: renamed from: d */
    public final C2335n f4710d;

    /* JADX INFO: renamed from: e */
    public final AbstractC2199t.a f4711e;

    /* JADX INFO: renamed from: f */
    public final boolean f4712f;

    /* JADX INFO: renamed from: b.g.a.c.c0.h$a */
    /* JADX INFO: compiled from: AnnotatedFieldCollector.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final InterfaceC2182e0 f4713a;

        /* JADX INFO: renamed from: b */
        public final Field f4714b;

        /* JADX INFO: renamed from: c */
        public AbstractC2194o f4715c = AbstractC2194o.a.f4727c;

        public a(InterfaceC2182e0 interfaceC2182e0, Field field) {
            this.f4713a = interfaceC2182e0;
            this.f4714b = field;
        }
    }

    public C2187h(AbstractC2165b abstractC2165b, C2335n c2335n, AbstractC2199t.a aVar, boolean z2) {
        super(abstractC2165b);
        this.f4710d = c2335n;
        this.f4711e = abstractC2165b == null ? null : aVar;
        this.f4712f = z2;
    }

    /* JADX INFO: renamed from: f */
    public final Map<String, a> m1900f(InterfaceC2182e0 interfaceC2182e0, AbstractC2360j abstractC2360j, Map<String, a> map) {
        AbstractC2199t.a aVar;
        Class<?> clsMo1885a;
        a aVar2;
        AbstractC2360j abstractC2360jMo2137q = abstractC2360j.mo2137q();
        if (abstractC2360jMo2137q == null) {
            return map;
        }
        Class<?> cls = abstractC2360j._class;
        Map<String, a> mapM1900f = m1900f(new InterfaceC2182e0.a(this.f4710d, abstractC2360jMo2137q.mo2136j()), abstractC2360jMo2137q, map);
        for (Field field : cls.getDeclaredFields()) {
            if (m1901g(field)) {
                if (mapM1900f == null) {
                    mapM1900f = new LinkedHashMap<>();
                }
                a aVar3 = new a(interfaceC2182e0, field);
                if (this.f4712f) {
                    aVar3.f4715c = m1924b(aVar3.f4715c, field.getDeclaredAnnotations());
                }
                mapM1900f.put(field.getName(), aVar3);
            }
        }
        if (mapM1900f != null && (aVar = this.f4711e) != null && (clsMo1885a = aVar.mo1885a(cls)) != null) {
            Iterator it = ((ArrayList) C2342d.m2178j(clsMo1885a, cls, true)).iterator();
            while (it.hasNext()) {
                for (Field field2 : ((Class) it.next()).getDeclaredFields()) {
                    if (m1901g(field2) && (aVar2 = mapM1900f.get(field2.getName())) != null) {
                        aVar2.f4715c = m1924b(aVar2.f4715c, field2.getDeclaredAnnotations());
                    }
                }
            }
        }
        return mapM1900f;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m1901g(Field field) {
        return (field.isSynthetic() || Modifier.isStatic(field.getModifiers())) ? false : true;
    }
}
