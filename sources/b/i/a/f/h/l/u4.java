package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;
import b.i.a.f.h.l.u4$b;
import com.google.android.gms.internal.measurement.zzhi;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u4<MessageType extends u4<MessageType, BuilderType>, BuilderType extends u4$b<MessageType, BuilderType>> extends l3<MessageType, BuilderType> {
    private static Map<Object, u4<?, ?>> zzd = new ConcurrentHashMap();
    public c7 zzb = c7.a;
    private int zzc = -1;

    public static <T extends u4<?, ?>> T m(Class<T> cls) {
        u4<?, ?> u4Var = zzd.get(cls);
        if (u4Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                u4Var = zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (u4Var == null) {
            u4Var = (T) ((u4) j7.c(cls)).p(6, null, null);
            if (u4Var == null) {
                throw new IllegalStateException();
            }
            zzd.put(cls, u4Var);
        }
        return (T) u4Var;
    }

    public static <E> b5<E> n(b5<E> b5Var) {
        int size = b5Var.size();
        return b5Var.f(size == 0 ? 10 : size << 1);
    }

    public static c5 o(c5 c5Var) {
        int i = ((q5) c5Var).m;
        return ((q5) c5Var).g(i == 0 ? 10 : i << 1);
    }

    public static Object q(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
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

    public static <T extends u4<?, ?>> void r(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    @Override // b.i.a.f.h.l.l3
    public final int e() {
        return this.zzc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return n6.a.b(this).f(this, (u4) obj);
        }
        return false;
    }

    @Override // b.i.a.f.h.l.c6
    public final /* synthetic */ b6 f() {
        u4$b u4_b = (u4$b) p(5, null, null);
        u4_b.l(this);
        return u4_b;
    }

    @Override // b.i.a.f.h.l.c6
    public final int g() {
        if (this.zzc == -1) {
            this.zzc = n6.a.b(this).e(this);
        }
        return this.zzc;
    }

    @Override // b.i.a.f.h.l.c6
    public final /* synthetic */ b6 h() {
        return (u4$b) p(5, null, null);
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iB = n6.a.b(this).b(this);
        this.zza = iB;
        return iB;
    }

    @Override // b.i.a.f.h.l.c6
    public final void i(zzhi zzhiVar) throws IOException {
        q6 q6VarB = n6.a.b(this);
        g4 g4Var = zzhiVar.c;
        if (g4Var == null) {
            g4Var = new g4(zzhiVar);
        }
        q6VarB.g(this, g4Var);
    }

    @Override // b.i.a.f.h.l.d6
    public final boolean j() {
        byte bByteValue = ((Byte) p(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zC = n6.a.b(this).c(this);
        p(2, zC ? this : null, null);
        return zC;
    }

    @Override // b.i.a.f.h.l.d6
    public final /* synthetic */ c6 k() {
        return (u4) p(6, null, null);
    }

    @Override // b.i.a.f.h.l.l3
    public final void l(int i) {
        this.zzc = i;
    }

    public abstract Object p(int i, Object obj, Object obj2);

    public final <MessageType extends u4<MessageType, BuilderType>, BuilderType extends u4$b<MessageType, BuilderType>> BuilderType s() {
        return (BuilderType) p(5, null, null);
    }

    public final BuilderType t() {
        BuilderType buildertype = (BuilderType) p(5, null, null);
        buildertype.l(this);
        return buildertype;
    }

    public String toString() {
        String string = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        b.i.a.f.e.o.f.e2(this, sb, 0);
        return sb.toString();
    }
}
