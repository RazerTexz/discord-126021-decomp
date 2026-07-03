package p507d0.p592z;

import com.adjust.sdk.Constants;
import java.lang.annotation.Annotation;
import java.util.Objects;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.InterfaceC12223e;

/* JADX INFO: renamed from: d0.z.a */
/* JADX INFO: compiled from: JvmClassMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12209a {
    public static final <T extends Annotation> InterfaceC11230c<? extends T> getAnnotationClass(T t) {
        C12238m.checkNotNullParameter(t, "$this$annotationClass");
        Class<? extends Annotation> clsAnnotationType = t.annotationType();
        C12238m.checkNotNullExpressionValue(clsAnnotationType, "(this as java.lang.annot…otation).annotationType()");
        InterfaceC11230c<? extends T> kotlinClass = getKotlinClass(clsAnnotationType);
        Objects.requireNonNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
        return kotlinClass;
    }

    public static final <T> Class<T> getJavaClass(InterfaceC11230c<T> interfaceC11230c) {
        C12238m.checkNotNullParameter(interfaceC11230c, "$this$java");
        Class<T> cls = (Class<T>) ((InterfaceC12223e) interfaceC11230c).getJClass();
        Objects.requireNonNull(cls, "null cannot be cast to non-null type java.lang.Class<T>");
        return cls;
    }

    public static final <T> Class<T> getJavaObjectType(InterfaceC11230c<T> interfaceC11230c) {
        C12238m.checkNotNullParameter(interfaceC11230c, "$this$javaObjectType");
        Class<T> cls = (Class<T>) ((InterfaceC12223e) interfaceC11230c).getJClass();
        if (!cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                return name.equals("double") ? Double.class : cls;
            case 104431:
                return name.equals("int") ? Integer.class : cls;
            case 3039496:
                return name.equals("byte") ? Byte.class : cls;
            case 3052374:
                return name.equals("char") ? Character.class : cls;
            case 3327612:
                return name.equals(Constants.LONG) ? Long.class : cls;
            case 3625364:
                return name.equals("void") ? Void.class : cls;
            case 64711720:
                return name.equals("boolean") ? Boolean.class : cls;
            case 97526364:
                return name.equals("float") ? Float.class : cls;
            case 109413500:
                return name.equals("short") ? Short.class : cls;
            default:
                return cls;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final <T> Class<T> getJavaPrimitiveType(InterfaceC11230c<T> interfaceC11230c) {
        C12238m.checkNotNullParameter(interfaceC11230c, "$this$javaPrimitiveType");
        Class<T> cls = (Class<T>) ((InterfaceC12223e) interfaceC11230c).getJClass();
        if (cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    public static final <T> InterfaceC11230c<T> getKotlinClass(Class<T> cls) {
        C12238m.checkNotNullParameter(cls, "$this$kotlin");
        return C12216a0.getOrCreateKotlinClass(cls);
    }
}
