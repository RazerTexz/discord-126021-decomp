package b.i.d.q.y;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: b.i.d.q.y.c, reason: use source file name */
/* JADX INFO: compiled from: UnsafeReflectionAccessor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class UnsafeReflectionAccessor extends ReflectionAccessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class f1816b;
    public final Object c;
    public final Field d;

    public UnsafeReflectionAccessor() {
        Object obj;
        Field declaredField = null;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f1816b = cls;
            Field declaredField2 = cls.getDeclaredField("theUnsafe");
            declaredField2.setAccessible(true);
            obj = declaredField2.get(null);
        } catch (Exception unused) {
            obj = null;
        }
        this.c = obj;
        try {
            declaredField = AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused2) {
        }
        this.d = declaredField;
    }

    @Override // b.i.d.q.y.ReflectionAccessor
    public void a(AccessibleObject accessibleObject) {
        boolean z2 = false;
        if (this.c != null && this.d != null) {
            try {
                f1816b.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.c, accessibleObject, Long.valueOf(((Long) f1816b.getMethod("objectFieldOffset", Field.class).invoke(this.c, this.d)).longValue()), Boolean.TRUE);
                z2 = true;
            } catch (Exception unused) {
            }
        }
        if (z2) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
        }
    }
}
