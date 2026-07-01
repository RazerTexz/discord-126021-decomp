package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.e0.p.d.m0.c.n0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements d0.z.d.e {
    public static final i$a l = new i$a(null);
    public static final Class<?> j = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
    public static final Regex k = new Regex("<v#(\\d+)>");

    public static final /* synthetic */ Regex access$getLOCAL_PROPERTY_SIGNATURE$cp() {
        return k;
    }

    public final void a(List<Class<?>> list, String str, boolean z2) {
        List<Class<?>> listD = d(str);
        list.addAll(listD);
        int size = ((((ArrayList) listD).size() + 32) - 1) / 32;
        for (int i = 0; i < size; i++) {
            Class<?> cls = Integer.TYPE;
            d0.z.d.m.checkNotNullExpressionValue(cls, "Integer.TYPE");
            list.add(cls);
        }
        Class<?> cls2 = z2 ? j : Object.class;
        d0.z.d.m.checkNotNullExpressionValue(cls2, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(cls2);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x004e  */
    public final Collection<f<?>> b(d0.e0.p.d.m0.k.a0.i iVar, i$c i_c) {
        f fVar;
        d0.z.d.m.checkNotNullParameter(iVar, "scope");
        d0.z.d.m.checkNotNullParameter(i_c, "belonginess");
        i$g i_g = new i$g(this, this);
        Collection<d0.e0.p.d.m0.c.m> contributedDescriptors$default = d0.e0.p.d.m0.k.a0.l$a.getContributedDescriptors$default(iVar, null, null, 3, null);
        ArrayList arrayList = new ArrayList();
        for (d0.e0.p.d.m0.c.m mVar : contributedDescriptors$default) {
            if (mVar instanceof d0.e0.p.d.m0.c.b) {
                d0.e0.p.d.m0.c.b bVar = (d0.e0.p.d.m0.c.b) mVar;
                if ((!d0.z.d.m.areEqual(bVar.getVisibility(), d0.e0.p.d.m0.c.t.h)) && i_c.accept(bVar)) {
                    fVar = (f) mVar.accept(i_g, Unit.a);
                } else {
                    fVar = null;
                }
            } else {
                fVar = null;
            }
            if (fVar != null) {
                arrayList.add(fVar);
            }
        }
        return d0.t.u.toList(arrayList);
    }

    public Class<?> c() {
        Class<?> wrapperByPrimitive = d0.e0.p.d.m0.c.k1.b.b.getWrapperByPrimitive(getJClass());
        return wrapperByPrimitive != null ? wrapperByPrimitive : getJClass();
    }

    public final List<Class<?>> d(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (str.charAt(i) != ')') {
            int iIndexOf$default = i;
            while (str.charAt(iIndexOf$default) == '[') {
                iIndexOf$default++;
            }
            char cCharAt = str.charAt(iIndexOf$default);
            if (!d0.g0.w.contains$default((CharSequence) "VZCBSIFJD", cCharAt, false, 2, (Object) null)) {
                if (cCharAt != 'L') {
                    throw new a0(b.d.b.a.a.w("Unknown type prefix in the method signature: ", str));
                }
                iIndexOf$default = d0.g0.w.indexOf$default((CharSequence) str, ';', i, false, 4, (Object) null);
            }
            int i2 = iIndexOf$default + 1;
            arrayList.add(g(str, i, i2));
            i = i2;
        }
        return arrayList;
    }

    public final Class<?> e(String str) {
        return g(str, d0.g0.w.indexOf$default((CharSequence) str, ')', 0, false, 6, (Object) null) + 1, str.length());
    }

    public final Method f(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z2) {
        Method methodF;
        if (z2) {
            clsArr[0] = cls;
        }
        Method methodI = i(cls, str, clsArr, cls2);
        if (methodI != null) {
            return methodI;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && (methodF = f(superclass, str, clsArr, cls2, z2)) != null) {
            return methodF;
        }
        for (Class<?> cls3 : cls.getInterfaces()) {
            d0.z.d.m.checkNotNullExpressionValue(cls3, "superInterface");
            Method methodF2 = f(cls3, str, clsArr, cls2, z2);
            if (methodF2 != null) {
                return methodF2;
            }
            if (z2) {
                Class<?> clsTryLoadClass = d0.e0.p.d.m0.c.k1.a.e.tryLoadClass(d0.e0.p.d.m0.c.k1.b.b.getSafeClassLoader(cls3), cls3.getName() + "$DefaultImpls");
                if (clsTryLoadClass != null) {
                    clsArr[0] = cls3;
                    Method methodI2 = i(clsTryLoadClass, str, clsArr, cls2);
                    if (methodI2 != null) {
                        return methodI2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public final Constructor<?> findConstructorBySignature(String str) {
        d0.z.d.m.checkNotNullParameter(str, "desc");
        return h(getJClass(), d(str));
    }

    public final Constructor<?> findDefaultConstructor(String str) {
        d0.z.d.m.checkNotNullParameter(str, "desc");
        Class<?> jClass = getJClass();
        ArrayList arrayList = new ArrayList();
        a(arrayList, str, true);
        return h(jClass, arrayList);
    }

    public final Method findDefaultMethod(String str, String str2, boolean z2) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "desc");
        if (d0.z.d.m.areEqual(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            arrayList.add(getJClass());
        }
        a(arrayList, str2, false);
        Class<?> clsC = c();
        String strW = b.d.b.a.a.w(str, "$default");
        Object[] array = arrayList.toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return f(clsC, strW, (Class[]) array, e(str2), z2);
    }

    public final d0.e0.p.d.m0.c.x findFunctionDescriptor(String str, String str2) {
        Collection<d0.e0.p.d.m0.c.x> functions;
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "signature");
        if (d0.z.d.m.areEqual(str, "<init>")) {
            functions = d0.t.u.toList(getConstructorDescriptors());
        } else {
            d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(str);
            d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "Name.identifier(name)");
            functions = getFunctions(eVarIdentifier);
        }
        Collection<d0.e0.p.d.m0.c.x> collection = functions;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (d0.z.d.m.areEqual(f0.f3198b.mapSignature((d0.e0.p.d.m0.c.x) obj).asString(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 1) {
            return (d0.e0.p.d.m0.c.x) d0.t.u.single((List) arrayList);
        }
        String strJoinToString$default = d0.t.u.joinToString$default(collection, "\n", null, null, 0, null, i$d.j, 30, null);
        StringBuilder sb = new StringBuilder();
        sb.append("Function '");
        sb.append(str);
        sb.append("' (JVM signature: ");
        sb.append(str2);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        sb.append(strJoinToString$default.length() == 0 ? " no members found" : '\n' + strJoinToString$default);
        throw new a0(sb.toString());
    }

    public final Method findMethodBySignature(String str, String str2) {
        Method methodF;
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "desc");
        if (d0.z.d.m.areEqual(str, "<init>")) {
            return null;
        }
        Object[] array = d(str2).toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Class<?>[] clsArr = (Class[]) array;
        Class<?> clsE = e(str2);
        Method methodF2 = f(c(), str, clsArr, clsE, false);
        if (methodF2 != null) {
            return methodF2;
        }
        if (!c().isInterface() || (methodF = f(Object.class, str, clsArr, clsE, false)) == null) {
            return null;
        }
        return methodF;
    }

    public final n0 findPropertyDescriptor(String str, String str2) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "signature");
        MatchResult matchResultMatchEntire = k.matchEntire(str2);
        if (matchResultMatchEntire != null) {
            String str3 = matchResultMatchEntire.getDestructured().getMatch().getGroupValues().get(1);
            n0 localProperty = getLocalProperty(Integer.parseInt(str3));
            if (localProperty != null) {
                return localProperty;
            }
            StringBuilder sbY = b.d.b.a.a.Y("Local property #", str3, " not found in ");
            sbY.append(getJClass());
            throw new a0(sbY.toString());
        }
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(str);
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "Name.identifier(name)");
        Collection<n0> properties = getProperties(eVarIdentifier);
        ArrayList arrayList = new ArrayList();
        for (Object obj : properties) {
            if (d0.z.d.m.areEqual(f0.f3198b.mapPropertySignature((n0) obj).asString(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new a0("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + this);
        }
        if (arrayList.size() == 1) {
            return (n0) d0.t.u.single((List) arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList) {
            d0.e0.p.d.m0.c.u visibility = ((n0) obj2).getVisibility();
            Object arrayList2 = linkedHashMap.get(visibility);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(visibility, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        Collection collectionValues = d0.t.g0.toSortedMap(linkedHashMap, i$f.j).values();
        d0.z.d.m.checkNotNullExpressionValue(collectionValues, "properties\n             …                }).values");
        List list = (List) d0.t.u.last(collectionValues);
        if (list.size() == 1) {
            d0.z.d.m.checkNotNullExpressionValue(list, "mostVisibleProperties");
            return (n0) d0.t.u.first(list);
        }
        d0.e0.p.d.m0.g.e eVarIdentifier2 = d0.e0.p.d.m0.g.e.identifier(str);
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier2, "Name.identifier(name)");
        String strJoinToString$default = d0.t.u.joinToString$default(getProperties(eVarIdentifier2), "\n", null, null, 0, null, i$e.j, 30, null);
        StringBuilder sb = new StringBuilder();
        sb.append("Property '");
        sb.append(str);
        sb.append("' (JVM signature: ");
        sb.append(str2);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        sb.append(strJoinToString$default.length() == 0 ? " no members found" : '\n' + strJoinToString$default);
        throw new a0(sb.toString());
    }

    public final Class<?> g(String str, int i, int i2) throws ClassNotFoundException {
        char cCharAt = str.charAt(i);
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'L') {
            ClassLoader safeClassLoader = d0.e0.p.d.m0.c.k1.b.b.getSafeClassLoader(getJClass());
            String strSubstring = str.substring(i + 1, i2 - 1);
            d0.z.d.m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Class<?> clsLoadClass = safeClassLoader.loadClass(d0.g0.t.replace$default(strSubstring, MentionUtilsKt.SLASH_CHAR, '.', false, 4, (Object) null));
            d0.z.d.m.checkNotNullExpressionValue(clsLoadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
            return clsLoadClass;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'V') {
            Class<?> cls = Void.TYPE;
            d0.z.d.m.checkNotNullExpressionValue(cls, "Void.TYPE");
            return cls;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == '[') {
            return d0.e0.p.d.m0.c.k1.b.b.createArrayType(g(str, i + 1, i2));
        }
        switch (cCharAt) {
            case 'B':
                return Byte.TYPE;
            case 'C':
                return Character.TYPE;
            case 'D':
                return Double.TYPE;
            default:
                throw new a0(b.d.b.a.a.w("Unknown type prefix in the method signature: ", str));
        }
    }

    public abstract Collection<d0.e0.p.d.m0.c.l> getConstructorDescriptors();

    public abstract Collection<d0.e0.p.d.m0.c.x> getFunctions(d0.e0.p.d.m0.g.e eVar);

    public abstract n0 getLocalProperty(int i);

    public abstract Collection<n0> getProperties(d0.e0.p.d.m0.g.e eVar);

    public final Constructor<?> h(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Class[] clsArr = (Class[]) array;
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0055  */
    public final Method i(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        boolean z2;
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            d0.z.d.m.checkNotNullExpressionValue(declaredMethod, "result");
            if (d0.z.d.m.areEqual(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            d0.z.d.m.checkNotNullExpressionValue(declaredMethods, "declaredMethods");
            for (Method method : declaredMethods) {
                d0.z.d.m.checkNotNullExpressionValue(method, "method");
                if (d0.z.d.m.areEqual(method.getName(), str) && d0.z.d.m.areEqual(method.getReturnType(), cls2)) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    d0.z.d.m.checkNotNull(parameterTypes);
                    if (Arrays.equals(parameterTypes, clsArr)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                if (z2) {
                    return method;
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
