package b.i.d.q;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public class f<T> implements r<T> {
    public final w a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f1807b;
    public final /* synthetic */ Type c;

    public f(g gVar, Class cls, Type type) {
        w vVar;
        this.f1807b = cls;
        this.c = type;
        try {
            Class<?> cls2 = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls2.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            vVar = new s(cls2.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    vVar = new t(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    vVar = new u(declaredMethod3);
                }
            } catch (Exception unused3) {
                vVar = new v();
            }
        }
        this.a = vVar;
    }

    @Override // b.i.d.q.r
    public T a() {
        try {
            return (T) this.a.b(this.f1807b);
        } catch (Exception e) {
            StringBuilder sbU = b.d.b.a.a.U("Unable to invoke no-args constructor for ");
            sbU.append(this.c);
            sbU.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
            throw new RuntimeException(sbU.toString(), e);
        }
    }
}
