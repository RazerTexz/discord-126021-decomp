package b.g.a.c.e0.h;

import b.g.a.c.h0.n;
import b.g.a.c.i0.d$b;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/* JADX INFO: compiled from: ClassNameIdResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends k {
    public f(b.g.a.c.j jVar, n nVar, b.g.a.c.e0.c cVar) {
        super(jVar, nVar);
    }

    @Override // b.g.a.c.e0.e
    public String a(Object obj) {
        return d(obj, obj.getClass(), this.a);
    }

    @Override // b.g.a.c.e0.e
    public String c(Object obj, Class<?> cls) {
        return d(obj, cls, this.a);
    }

    public String d(Object obj, Class<?> cls, n nVar) {
        Class<?> declaringClass;
        b.g.a.c.j jVarC;
        b.g.a.c.j jVarC2;
        b.g.a.c.h0.m mVar;
        Class<?> declaringClass2;
        b.g.a.c.h0.m mVar2;
        Class<?> superclass = (!b.g.a.c.i0.d.q(cls) || cls.isEnum()) ? cls : cls.getSuperclass();
        String name = superclass.getName();
        if (!name.startsWith("java.util.")) {
            return (name.indexOf(36) < 0 || b.g.a.c.i0.d.m(superclass) == null || b.g.a.c.i0.d.m(this.f698b._class) != null) ? name : this.f698b._class.getName();
        }
        if (obj instanceof EnumSet) {
            EnumSet enumSet = (EnumSet) obj;
            if (enumSet.isEmpty()) {
                Field field = d$b.a.f728b;
                if (field == null) {
                    throw new IllegalStateException("Cannot figure out type for EnumSet (odd JDK platform?)");
                }
                try {
                    declaringClass2 = (Class) field.get(enumSet);
                } catch (Exception e) {
                    throw new IllegalArgumentException(e);
                }
            } else {
                declaringClass2 = ((Enum) enumSet.iterator().next()).getDeclaringClass();
            }
            b.g.a.c.j jVarC3 = nVar.c(null, declaringClass2, n.l);
            String[] strArr = b.g.a.c.h0.m.j;
            TypeVariable[] typeParameters = EnumSet.class.getTypeParameters();
            int length = typeParameters == null ? 0 : typeParameters.length;
            if (length == 0) {
                mVar2 = b.g.a.c.h0.m.l;
            } else {
                if (length != 1) {
                    StringBuilder sbU = b.d.b.a.a.U("Cannot create TypeBindings for class ");
                    sbU.append(EnumSet.class.getName());
                    sbU.append(" with 1 type parameter: class expects ");
                    sbU.append(length);
                    throw new IllegalArgumentException(sbU.toString());
                }
                mVar2 = new b.g.a.c.h0.m(new String[]{typeParameters[0].getName()}, new b.g.a.c.j[]{jVarC3}, null);
            }
            b.g.a.c.h0.e eVar = (b.g.a.c.h0.e) nVar.c(null, EnumSet.class, mVar2);
            if (mVar2.i()) {
                b.g.a.c.j jVarK = eVar.i(Collection.class).k();
                if (!jVarK.equals(jVarC3)) {
                    throw new IllegalArgumentException(String.format("Non-generic Collection class %s did not resolve to something with element type %s but %s ", b.g.a.c.i0.d.u(EnumSet.class), jVarC3, jVarK));
                }
            }
            return eVar.K();
        }
        if (!(obj instanceof EnumMap)) {
            return name;
        }
        EnumMap enumMap = (EnumMap) obj;
        if (enumMap.isEmpty()) {
            Field field2 = d$b.a.c;
            if (field2 == null) {
                throw new IllegalStateException("Cannot figure out type for EnumMap (odd JDK platform?)");
            }
            try {
                declaringClass = (Class) field2.get(enumMap);
            } catch (Exception e2) {
                throw new IllegalArgumentException(e2);
            }
        } else {
            declaringClass = ((Enum) enumMap.keySet().iterator().next()).getDeclaringClass();
        }
        Objects.requireNonNull(nVar);
        if (EnumMap.class == Properties.class) {
            jVarC = n.f724y;
            jVarC2 = jVarC;
        } else {
            b.g.a.c.h0.m mVar3 = n.l;
            jVarC = nVar.c(null, declaringClass, mVar3);
            jVarC2 = nVar.c(null, Object.class, mVar3);
        }
        b.g.a.c.j[] jVarArr = {jVarC, jVarC2};
        String[] strArr2 = b.g.a.c.h0.m.j;
        TypeVariable[] typeParameters2 = EnumMap.class.getTypeParameters();
        if (typeParameters2 == null || typeParameters2.length == 0) {
            mVar = b.g.a.c.h0.m.l;
        } else {
            int length2 = typeParameters2.length;
            String[] strArr3 = new String[length2];
            for (int i = 0; i < length2; i++) {
                strArr3[i] = typeParameters2[i].getName();
            }
            if (length2 != 2) {
                StringBuilder sbU2 = b.d.b.a.a.U("Cannot create TypeBindings for class ");
                sbU2.append(EnumMap.class.getName());
                sbU2.append(" with ");
                sbU2.append(2);
                sbU2.append(" type parameter");
                sbU2.append("s");
                sbU2.append(": class expects ");
                sbU2.append(length2);
                throw new IllegalArgumentException(sbU2.toString());
            }
            mVar = new b.g.a.c.h0.m(strArr3, jVarArr, null);
        }
        b.g.a.c.h0.g gVar = (b.g.a.c.h0.g) nVar.c(null, EnumMap.class, mVar);
        if (mVar.i()) {
            b.g.a.c.j jVarI = gVar.i(Map.class);
            b.g.a.c.j jVarO = jVarI.o();
            if (!jVarO.equals(jVarC)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with key type %s but %s ", b.g.a.c.i0.d.u(EnumMap.class), jVarC, jVarO));
            }
            b.g.a.c.j jVarK2 = jVarI.k();
            if (!jVarK2.equals(jVarC2)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with value type %s but %s ", b.g.a.c.i0.d.u(EnumMap.class), jVarC2, jVarK2));
            }
        }
        return gVar.K();
    }
}
