package d0.e0.p.d.m0.c.k1.b;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: ReflectJavaMember.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final a a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a$a f3289b;

    public final a$a buildCache(Member member) {
        d0.z.d.m.checkNotNullParameter(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new a$a(cls.getMethod("getParameters", new Class[0]), b.getSafeClassLoader(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new a$a(null, null);
        }
    }

    public final List<String> loadParameterNames(Member member) {
        Method getName;
        d0.z.d.m.checkNotNullParameter(member, "member");
        a$a a_aBuildCache = f3289b;
        if (a_aBuildCache == null) {
            a_aBuildCache = buildCache(member);
            f3289b = a_aBuildCache;
        }
        Method getParameters = a_aBuildCache.getGetParameters();
        if (getParameters == null || (getName = a_aBuildCache.getGetName()) == null) {
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
