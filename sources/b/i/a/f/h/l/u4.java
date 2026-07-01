package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;
import b.i.a.f.h.l.u4.b;
import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.internal.measurement.zzkq;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u4<MessageType extends u4<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends l3<MessageType, BuilderType> {
    private static Map<Object, u4<?, ?>> zzd = new ConcurrentHashMap();
    public c7 zzb = c7.a;
    private int zzc = -1;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static class a<T extends u4<T, ?>> extends p3<T> {
        public a(T t) {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static abstract class b<MessageType extends u4<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends n3<MessageType, BuilderType> {
        public final MessageType j;
        public MessageType k;
        public boolean l = false;

        public b(MessageType messagetype) {
            this.j = messagetype;
            this.k = (MessageType) messagetype.p(4, null, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            b bVar = (b) this.j.p(5, null, null);
            bVar.l((u4) o());
            return bVar;
        }

        @Override // b.i.a.f.h.l.d6
        public final /* synthetic */ c6 k() {
            return this.j;
        }

        public final BuilderType l(MessageType messagetype) {
            if (this.l) {
                n();
                this.l = false;
            }
            MessageType messagetype2 = this.k;
            n6.a.b(messagetype2).i(messagetype2, messagetype);
            return this;
        }

        public final b m(byte[] bArr, int i, h4 h4Var) throws zzij {
            if (this.l) {
                n();
                this.l = false;
            }
            try {
                n6.a.b(this.k).h(this.k, bArr, 0, i, new s3(h4Var));
                return this;
            } catch (zzij e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzij.a();
            }
        }

        public void n() {
            MessageType messagetype = (MessageType) this.k.p(4, null, null);
            n6.a.b(messagetype).i(messagetype, this.k);
            this.k = messagetype;
        }

        public c6 o() {
            if (this.l) {
                return this.k;
            }
            MessageType messagetype = this.k;
            n6.a.b(messagetype).d(messagetype);
            this.l = true;
            return this.k;
        }

        public c6 p() {
            u4 u4Var = (u4) o();
            if (u4Var.j()) {
                return u4Var;
            }
            throw new zzkq();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class c implements p4<c> {
        @Override // b.i.a.f.h.l.p4
        public final b6 X(b6 b6Var, c6 c6Var) {
            throw new NoSuchMethodError();
        }

        @Override // b.i.a.f.h.l.p4
        public final int a() {
            throw new NoSuchMethodError();
        }

        @Override // b.i.a.f.h.l.p4
        public final p7 b() {
            throw new NoSuchMethodError();
        }

        @Override // b.i.a.f.h.l.p4
        public final w7 c() {
            throw new NoSuchMethodError();
        }

        @Override // b.i.a.f.h.l.p4
        public final f6 c0(f6 f6Var, f6 f6Var2) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // b.i.a.f.h.l.p4
        public final boolean d() {
            throw new NoSuchMethodError();
        }

        @Override // b.i.a.f.h.l.p4
        public final boolean e() {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType> extends u4<MessageType, BuilderType> implements d6 {
        public n4<c> zzc = n4.a;

        public final n4<c> u() {
            n4<c> n4Var = this.zzc;
            if (n4Var.c) {
                this.zzc = (n4) n4Var.clone();
            }
            return this.zzc;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final enum e {
        public static final /* synthetic */ int[] a = {1, 2, 3, 4, 5, 6, 7};

        public static int[] a() {
            return (int[]) a.clone();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static class f<ContainingType extends c6, Type> extends i4<ContainingType, Type> {
    }

    public static <T extends u4<?, ?>> T m(Class<T> cls) {
        u4<?, ?> u4Var = zzd.get(cls);
        if (u4Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                u4Var = zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
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
        return ((q5) c5Var).f(i == 0 ? 10 : i << 1);
    }

    public static Object q(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
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
        b bVar = (b) p(5, null, null);
        bVar.l(this);
        return bVar;
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
        return (b) p(5, null, null);
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

    public final <MessageType extends u4<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> BuilderType s() {
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
