package lombok.javac;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentMap;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacTreeMaker$SchroedingerType.SCL.lombok */
class JavacTreeMaker$SchroedingerType {
    final Object value;
    private static Field NOSUCHFIELDEX_MARKER;

    private JavacTreeMaker$SchroedingerType(Object value) {
        this.value = value;
    }

    /* synthetic */ JavacTreeMaker$SchroedingerType(Object obj, JavacTreeMaker$SchroedingerType javacTreeMaker$SchroedingerType) {
        this(obj);
    }

    public int hashCode() {
        if (this.value == null) {
            return -1;
        }
        return this.value.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof JavacTreeMaker$SchroedingerType) {
            Object other = ((JavacTreeMaker$SchroedingerType) obj).value;
            if (this.value == null) {
                return other == null;
            }
            return this.value.equals(other);
        }
        return false;
    }

    static Object getFieldCached(ConcurrentMap<String, Object> cache, String className, String fieldName) {
        Object value = cache.get(fieldName);
        if (value != null) {
            return value;
        }
        try {
            Object value2 = Permit.getField(Class.forName(className), fieldName).get(null);
            cache.putIfAbsent(fieldName, value2);
            return value2;
        } catch (ClassNotFoundException e) {
            throw Javac.sneakyThrow(e);
        } catch (IllegalAccessException e2) {
            throw Javac.sneakyThrow(e2);
        } catch (NoSuchFieldException e3) {
            throw Javac.sneakyThrow(e3);
        }
    }

    static {
        try {
            NOSUCHFIELDEX_MARKER = Permit.getField(JavacTreeMaker$SchroedingerType.class, "NOSUCHFIELDEX_MARKER");
        } catch (NoSuchFieldException e) {
            throw Javac.sneakyThrow(e);
        }
    }

    static Object getFieldCached(ConcurrentMap<Class<?>, Field> cache, Object ref, String fieldName) throws NoSuchFieldException {
        Class<?> c = ref.getClass();
        Field field = cache.get(c);
        if (field == null) {
            try {
                field = Permit.getField(c, fieldName);
                Permit.setAccessible(field);
                Field old = cache.putIfAbsent(c, field);
                if (old != null) {
                    field = old;
                }
            } catch (NoSuchFieldException e) {
                cache.putIfAbsent(c, NOSUCHFIELDEX_MARKER);
                throw Javac.sneakyThrow(e);
            }
        }
        if (field == NOSUCHFIELDEX_MARKER) {
            throw new NoSuchFieldException(fieldName);
        }
        try {
            return field.get(ref);
        } catch (IllegalAccessException e2) {
            throw Javac.sneakyThrow(e2);
        }
    }
}
