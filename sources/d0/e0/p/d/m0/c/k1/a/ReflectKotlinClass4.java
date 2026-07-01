package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.c.k1.b.reflectClassUtil;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.n, reason: use source file name */
/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectKotlinClass4 {
    public static final ReflectKotlinClass4 a = new ReflectKotlinClass4();

    public final String constructorDesc(Constructor<?> constructor) {
        Intrinsics3.checkNotNullParameter(constructor, "constructor");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Intrinsics3.checkNotNullExpressionValue(parameterTypes, "constructor.parameterTypes");
        int length = parameterTypes.length;
        int i = 0;
        while (i < length) {
            Class<?> cls = parameterTypes[i];
            i++;
            Intrinsics3.checkNotNullExpressionValue(cls, "parameterType");
            sb.append(reflectClassUtil.getDesc(cls));
        }
        sb.append(")V");
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public final String fieldDesc(Field field) {
        Intrinsics3.checkNotNullParameter(field, "field");
        Class<?> type = field.getType();
        Intrinsics3.checkNotNullExpressionValue(type, "field.type");
        return reflectClassUtil.getDesc(type);
    }

    public final String methodDesc(Method method) {
        Intrinsics3.checkNotNullParameter(method, "method");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        Intrinsics3.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
        int length = parameterTypes.length;
        int i = 0;
        while (i < length) {
            Class<?> cls = parameterTypes[i];
            i++;
            Intrinsics3.checkNotNullExpressionValue(cls, "parameterType");
            sb.append(reflectClassUtil.getDesc(cls));
        }
        sb.append(")");
        Class<?> returnType = method.getReturnType();
        Intrinsics3.checkNotNullExpressionValue(returnType, "method.returnType");
        sb.append(reflectClassUtil.getDesc(returnType));
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }
}
