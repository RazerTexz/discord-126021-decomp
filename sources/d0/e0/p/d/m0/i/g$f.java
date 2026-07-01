package d0.e0.p.d.m0.i;

import d0.e0.p.d.m0.i.n;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: GeneratedMessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public class g$f<ContainingType extends n, Type> {
    public final ContainingType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f3431b;
    public final n c;
    public final g$e d;
    public final Method e;

    public g$f(ContainingType containingtype, Type type, n nVar, g$e g_e, Class cls) {
        if (containingtype == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if (g_e.getLiteType() == w$b.t && nVar == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.a = containingtype;
        this.f3431b = type;
        this.c = nVar;
        this.d = g_e;
        if (!h$a.class.isAssignableFrom(cls)) {
            this.e = null;
            return;
        }
        try {
            this.e = cls.getMethod("valueOf", Integer.TYPE);
        } catch (NoSuchMethodException e) {
            String name = cls.getName();
            StringBuilder sb = new StringBuilder(name.length() + 45 + 7);
            b.d.b.a.a.s0(sb, "Generated message class \"", name, "\" missing method \"", "valueOf");
            sb.append("\".");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public Object a(Object obj) {
        if (this.d.getLiteJavaType() != w$c.ENUM) {
            return obj;
        }
        try {
            return this.e.invoke(null, (Integer) obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public Object b(Object obj) {
        return this.d.getLiteJavaType() == w$c.ENUM ? Integer.valueOf(((h$a) obj).getNumber()) : obj;
    }

    public ContainingType getContainingTypeDefaultInstance() {
        return this.a;
    }

    public n getMessageDefaultInstance() {
        return this.c;
    }

    public int getNumber() {
        return this.d.getNumber();
    }
}
