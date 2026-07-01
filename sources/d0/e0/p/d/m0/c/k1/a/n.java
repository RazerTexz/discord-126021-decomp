package d0.e0.p.d.m0.c.k1.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static final n a = new n();

    public final String constructorDesc(Constructor<?> constructor) {
        d0.z.d.m.checkNotNullParameter(constructor, "constructor");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        d0.z.d.m.checkNotNullExpressionValue(parameterTypes, "constructor.parameterTypes");
        int length = parameterTypes.length;
        int i = 0;
        while (i < length) {
            Class<?> cls = parameterTypes[i];
            i++;
            d0.z.d.m.checkNotNullExpressionValue(cls, "parameterType");
            sb.append(d0.e0.p.d.m0.c.k1.b.b.getDesc(cls));
        }
        sb.append(")V");
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public final String fieldDesc(Field field) {
        d0.z.d.m.checkNotNullParameter(field, "field");
        Class<?> type = field.getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "field.type");
        return d0.e0.p.d.m0.c.k1.b.b.getDesc(type);
    }

    public final String methodDesc(Method method) {
        d0.z.d.m.checkNotNullParameter(method, "method");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        d0.z.d.m.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
        int length = parameterTypes.length;
        int i = 0;
        while (i < length) {
            Class<?> cls = parameterTypes[i];
            i++;
            d0.z.d.m.checkNotNullExpressionValue(cls, "parameterType");
            sb.append(d0.e0.p.d.m0.c.k1.b.b.getDesc(cls));
        }
        sb.append(")");
        Class<?> returnType = method.getReturnType();
        d0.z.d.m.checkNotNullExpressionValue(returnType, "method.returnType");
        sb.append(d0.e0.p.d.m0.c.k1.b.b.getDesc(returnType));
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }
}
