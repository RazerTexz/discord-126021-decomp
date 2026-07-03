package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11423b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.n */
/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11421n {

    /* JADX INFO: renamed from: a */
    public static final C11421n f23027a = new C11421n();

    public final String constructorDesc(Constructor<?> constructor) {
        C12238m.checkNotNullParameter(constructor, "constructor");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        C12238m.checkNotNullExpressionValue(parameterTypes, "constructor.parameterTypes");
        int length = parameterTypes.length;
        int i = 0;
        while (i < length) {
            Class<?> cls = parameterTypes[i];
            i++;
            C12238m.checkNotNullExpressionValue(cls, "parameterType");
            sb.append(C11423b.getDesc(cls));
        }
        sb.append(")V");
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public final String fieldDesc(Field field) {
        C12238m.checkNotNullParameter(field, "field");
        Class<?> type = field.getType();
        C12238m.checkNotNullExpressionValue(type, "field.type");
        return C11423b.getDesc(type);
    }

    public final String methodDesc(Method method) {
        C12238m.checkNotNullParameter(method, "method");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        C12238m.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
        int length = parameterTypes.length;
        int i = 0;
        while (i < length) {
            Class<?> cls = parameterTypes[i];
            i++;
            C12238m.checkNotNullExpressionValue(cls, "parameterType");
            sb.append(C11423b.getDesc(cls));
        }
        sb.append(")");
        Class<?> returnType = method.getReturnType();
        C12238m.checkNotNullExpressionValue(returnType, "method.returnType");
        sb.append(C11423b.getDesc(returnType));
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }
}
