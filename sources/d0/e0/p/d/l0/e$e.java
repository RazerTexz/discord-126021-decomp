package d0.e0.p.d.l0;

import d0.z.d.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$e extends e<Constructor<?>> {
    /* JADX WARN: Illegal instructions before constructor call */
    public e$e(Constructor<?> constructor) {
        m.checkNotNullParameter(constructor, "constructor");
        Class<?> declaringClass = constructor.getDeclaringClass();
        m.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
        Class<?> declaringClass2 = constructor.getDeclaringClass();
        m.checkNotNullExpressionValue(declaringClass2, "klass");
        Class<?> declaringClass3 = declaringClass2.getDeclaringClass();
        Class<?> cls = (declaringClass3 == null || Modifier.isStatic(declaringClass2.getModifiers())) ? null : declaringClass3;
        Type[] genericParameterTypes = constructor.getGenericParameterTypes();
        m.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
        super(constructor, declaringClass, cls, genericParameterTypes, null);
    }

    @Override // d0.e0.p.d.l0.d
    public Object call(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        return mo80getMember().newInstance(Arrays.copyOf(objArr, objArr.length));
    }
}
