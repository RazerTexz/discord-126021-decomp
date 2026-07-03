package p007b.p225i.p408d.p410q;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.i.d.q.f */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4921f<T> implements InterfaceC4933r<T> {

    /* JADX INFO: renamed from: a */
    public final AbstractC4938w f13112a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Class f13113b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Type f13114c;

    public C4921f(C4922g c4922g, Class cls, Type type) {
        AbstractC4938w c4937v;
        this.f13113b = cls;
        this.f13114c = type;
        try {
            Class<?> cls2 = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls2.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            c4937v = new C4934s(cls2.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    c4937v = new C4935t(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    c4937v = new C4936u(declaredMethod3);
                }
            } catch (Exception unused3) {
                c4937v = new C4937v();
            }
        }
        this.f13112a = c4937v;
    }

    @Override // p007b.p225i.p408d.p410q.InterfaceC4933r
    /* JADX INFO: renamed from: a */
    public T mo6869a() {
        try {
            return (T) this.f13112a.mo6871b(this.f13113b);
        } catch (Exception e) {
            StringBuilder sbM833U = C1643a.m833U("Unable to invoke no-args constructor for ");
            sbM833U.append(this.f13114c);
            sbM833U.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
            throw new RuntimeException(sbM833U.toString(), e);
        }
    }
}
