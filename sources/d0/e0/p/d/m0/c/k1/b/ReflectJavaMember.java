package d0.e0.p.d.m0.c.k1.b;

import d0.z.d.Intrinsics3;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.a, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaMember.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaMember {
    public static final ReflectJavaMember a = new ReflectJavaMember();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f3289b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.a$a */
    /* JADX INFO: compiled from: ReflectJavaMember.kt */
    public static final class a {
        public final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f3290b;

        public a(Method method, Method method2) {
            this.a = method;
            this.f3290b = method2;
        }

        public final Method getGetName() {
            return this.f3290b;
        }

        public final Method getGetParameters() {
            return this.a;
        }
    }

    public final a buildCache(Member member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new a(cls.getMethod("getParameters", new Class[0]), reflectClassUtil.getSafeClassLoader(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    public final List<String> loadParameterNames(Member member) throws IllegalAccessException, InvocationTargetException {
        Method getName;
        Intrinsics3.checkNotNullParameter(member, "member");
        a aVarBuildCache = f3289b;
        if (aVarBuildCache == null) {
            aVarBuildCache = buildCache(member);
            f3289b = aVarBuildCache;
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
