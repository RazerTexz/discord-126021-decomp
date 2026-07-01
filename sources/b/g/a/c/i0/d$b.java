package b.g.a.c.i0;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.EnumSet;

/* JADX INFO: compiled from: ClassUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$b {
    public static final d$b a = new d$b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Field f728b = a(EnumSet.class, "elementType", Class.class);
    public final Field c = a(EnumMap.class, "elementType", Class.class);

    public static Field a(Class<?> cls, String str, Class<?> cls2) {
        Field field;
        Field[] declaredFields = cls.getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                field = null;
                break;
            }
            field = declaredFields[i];
            if (str.equals(field.getName()) && field.getType() == cls2) {
                break;
            }
            i++;
        }
        if (field == null) {
            for (Field field2 : declaredFields) {
                if (field2.getType() == cls2) {
                    if (field != null) {
                        return null;
                    }
                    field = field2;
                }
            }
        }
        if (field != null) {
            try {
                field.setAccessible(true);
            } catch (Throwable unused) {
            }
        }
        return field;
    }
}
