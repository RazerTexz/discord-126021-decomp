package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.a */
/* JADX INFO: compiled from: ReflectJavaMember.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11422a {

    /* JADX INFO: renamed from: a */
    public static final C11422a f23028a = new C11422a();

    /* JADX INFO: renamed from: b */
    public static a f23029b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.a$a */
    /* JADX INFO: compiled from: ReflectJavaMember.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final Method f23030a;

        /* JADX INFO: renamed from: b */
        public final Method f23031b;

        public a(Method method, Method method2) {
            this.f23030a = method;
            this.f23031b = method2;
        }

        public final Method getGetName() {
            return this.f23031b;
        }

        public final Method getGetParameters() {
            return this.f23030a;
        }
    }

    public final a buildCache(Member member) {
        C12238m.checkNotNullParameter(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new a(cls.getMethod("getParameters", new Class[0]), C11423b.getSafeClassLoader(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    public final List<String> loadParameterNames(Member member) throws IllegalAccessException, InvocationTargetException {
        Method getName;
        C12238m.checkNotNullParameter(member, "member");
        a aVarBuildCache = f23029b;
        if (aVarBuildCache == null) {
            aVarBuildCache = buildCache(member);
            f23029b = aVarBuildCache;
        }
        Method getParameters = aVarBuildCache.getGetParameters();
        if (getParameters == null || (getName = aVarBuildCache.getGetName()) == null) {
            return null;
        }
        Object objInvoke = getParameters.invoke(member, new Object[0]);
        Objects.requireNonNull(objInvoke, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) objInvoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object objInvoke2 = getName.invoke(obj, new Object[0]);
            Objects.requireNonNull(objInvoke2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) objInvoke2);
        }
        return arrayList;
    }
}
