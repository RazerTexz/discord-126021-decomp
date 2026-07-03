package p007b.p225i.p226a.p288f.p313h.p325l;

import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.internal.measurement.zzkq;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4.b;

/* JADX INFO: renamed from: b.i.a.f.h.l.u4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3851u4<MessageType extends AbstractC3851u4<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends AbstractC3733l3<MessageType, BuilderType> {
    private static Map<Object, AbstractC3851u4<?, ?>> zzd = new ConcurrentHashMap();
    public C3613c7 zzb = C3613c7.f9877a;
    private int zzc = -1;

    /* JADX INFO: renamed from: b.i.a.f.h.l.u4$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static class a<T extends AbstractC3851u4<T, ?>> extends C3785p3<T> {
        public a(T t) {
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.h.l.u4$b */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static abstract class b<MessageType extends AbstractC3851u4<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends AbstractC3759n3<MessageType, BuilderType> {

        /* JADX INFO: renamed from: j */
        public final MessageType f10346j;

        /* JADX INFO: renamed from: k */
        public MessageType f10347k;

        /* JADX INFO: renamed from: l */
        public boolean f10348l = false;

        public b(MessageType messagetype) {
            this.f10346j = messagetype;
            this.f10347k = (MessageType) messagetype.mo4541p(4, null, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            b bVar = (b) this.f10346j.mo4541p(5, null, null);
            bVar.m5316l((AbstractC3851u4) m5319o());
            return bVar;
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3626d6
        /* JADX INFO: renamed from: k */
        public final /* synthetic */ InterfaceC3612c6 mo4633k() {
            return this.f10346j;
        }

        /* JADX INFO: renamed from: l */
        public final BuilderType m5316l(MessageType messagetype) {
            if (this.f10348l) {
                m5318n();
                this.f10348l = false;
            }
            MessageType messagetype2 = this.f10347k;
            C3762n6.f10114a.m5139b(messagetype2).mo4851i(messagetype2, messagetype);
            return this;
        }

        /* JADX INFO: renamed from: m */
        public final b m5317m(byte[] bArr, int i, C3680h4 c3680h4) throws zzij {
            if (this.f10348l) {
                m5318n();
                this.f10348l = false;
            }
            try {
                C3762n6.f10114a.m5139b(this.f10347k).mo4850h(this.f10347k, bArr, 0, i, new C3824s3(c3680h4));
                return this;
            } catch (zzij e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzij.m9103a();
            }
        }

        /* JADX INFO: renamed from: n */
        public void m5318n() {
            MessageType messagetype = (MessageType) this.f10347k.mo4541p(4, null, null);
            C3762n6.f10114a.m5139b(messagetype).mo4851i(messagetype, this.f10347k);
            this.f10347k = messagetype;
        }

        /* JADX INFO: renamed from: o */
        public InterfaceC3612c6 m5319o() {
            if (this.f10348l) {
                return this.f10347k;
            }
            MessageType messagetype = this.f10347k;
            C3762n6.f10114a.m5139b(messagetype).mo4846d(messagetype);
            this.f10348l = true;
            return this.f10347k;
        }

        /* JADX INFO: renamed from: p */
        public InterfaceC3612c6 m5320p() {
            AbstractC3851u4 abstractC3851u4 = (AbstractC3851u4) m5319o();
            if (abstractC3851u4.mo4632j()) {
                return abstractC3851u4;
            }
            throw new zzkq();
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.h.l.u4$c */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class c implements InterfaceC3786p4<c> {
        @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3786p4
        /* JADX INFO: renamed from: X */
        public final InterfaceC3598b6 mo5173X(InterfaceC3598b6 interfaceC3598b6, InterfaceC3612c6 interfaceC3612c6) {
            throw new NoSuchMethodError();
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3786p4
        /* JADX INFO: renamed from: a */
        public final int mo5174a() {
            throw new NoSuchMethodError();
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3786p4
        /* JADX INFO: renamed from: b */
        public final EnumC3789p7 mo5175b() {
            throw new NoSuchMethodError();
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3786p4
        /* JADX INFO: renamed from: c */
        public final EnumC3880w7 mo5176c() {
            throw new NoSuchMethodError();
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3786p4
        /* JADX INFO: renamed from: c0 */
        public final InterfaceC3654f6 mo5177c0(InterfaceC3654f6 interfaceC3654f6, InterfaceC3654f6 interfaceC3654f7) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3786p4
        /* JADX INFO: renamed from: d */
        public final boolean mo5178d() {
            throw new NoSuchMethodError();
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3786p4
        /* JADX INFO: renamed from: e */
        public final boolean mo5179e() {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.h.l.u4$d */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType> extends AbstractC3851u4<MessageType, BuilderType> implements InterfaceC3626d6 {
        public C3760n4<c> zzc = C3760n4.f10110a;

        /* JADX INFO: renamed from: u */
        public final C3760n4<c> m5321u() {
            C3760n4<c> c3760n4 = this.zzc;
            if (c3760n4.f10112c) {
                this.zzc = (C3760n4) c3760n4.clone();
            }
            return this.zzc;
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.h.l.u4$e */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final enum e {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f10349a = {1, 2, 3, 4, 5, 6, 7};

        /* JADX INFO: renamed from: a */
        public static int[] m5322a() {
            return (int[]) f10349a.clone();
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.h.l.u4$f */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static class f<ContainingType extends InterfaceC3612c6, Type> extends C3694i4<ContainingType, Type> {
    }

    /* JADX INFO: renamed from: m */
    public static <T extends AbstractC3851u4<?, ?>> T m5309m(Class<T> cls) {
        AbstractC3851u4<?, ?> abstractC3851u4 = zzd.get(cls);
        if (abstractC3851u4 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC3851u4 = zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (abstractC3851u4 == null) {
            abstractC3851u4 = (T) ((AbstractC3851u4) C3711j7.m4978c(cls)).mo4541p(6, null, null);
            if (abstractC3851u4 == null) {
                throw new IllegalStateException();
            }
            zzd.put(cls, abstractC3851u4);
        }
        return (T) abstractC3851u4;
    }

    /* JADX INFO: renamed from: n */
    public static <E> InterfaceC3597b5<E> m5310n(InterfaceC3597b5<E> interfaceC3597b5) {
        int size = interfaceC3597b5.size();
        return interfaceC3597b5.mo4569f(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: renamed from: o */
    public static InterfaceC3611c5 m5311o(InterfaceC3611c5 interfaceC3611c5) {
        int i = ((C3800q5) interfaceC3611c5).f10273m;
        return ((C3800q5) interfaceC3611c5).mo4569f(i == 0 ? 10 : i << 1);
    }

    /* JADX INFO: renamed from: q */
    public static Object m5312q(Method method, Object obj, Object... objArr) {
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

    /* JADX INFO: renamed from: r */
    public static <T extends AbstractC3851u4<?, ?>> void m5313r(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3733l3
    /* JADX INFO: renamed from: e */
    public final int mo5053e() {
        return this.zzc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return C3762n6.f10114a.m5139b(this).mo4848f(this, (AbstractC3851u4) obj);
        }
        return false;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3612c6
    /* JADX INFO: renamed from: f */
    public final /* synthetic */ InterfaceC3598b6 mo4605f() {
        b bVar = (b) mo4541p(5, null, null);
        bVar.m5316l(this);
        return bVar;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3612c6
    /* JADX INFO: renamed from: g */
    public final int mo4606g() {
        if (this.zzc == -1) {
            this.zzc = C3762n6.f10114a.m5139b(this).mo4847e(this);
        }
        return this.zzc;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3612c6
    /* JADX INFO: renamed from: h */
    public final /* synthetic */ InterfaceC3598b6 mo4607h() {
        return (b) mo4541p(5, null, null);
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iMo4844b = C3762n6.f10114a.m5139b(this).mo4844b(this);
        this.zza = iMo4844b;
        return iMo4844b;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3612c6
    /* JADX INFO: renamed from: i */
    public final void mo4608i(zzhi zzhiVar) throws IOException {
        InterfaceC3801q6 interfaceC3801q6M5139b = C3762n6.f10114a.m5139b(this);
        C3666g4 c3666g4 = zzhiVar.f20630c;
        if (c3666g4 == null) {
            c3666g4 = new C3666g4(zzhiVar);
        }
        interfaceC3801q6M5139b.mo4849g(this, c3666g4);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3626d6
    /* JADX INFO: renamed from: j */
    public final boolean mo4632j() {
        byte bByteValue = ((Byte) mo4541p(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zMo4845c = C3762n6.f10114a.m5139b(this).mo4845c(this);
        mo4541p(2, zMo4845c ? this : null, null);
        return zMo4845c;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3626d6
    /* JADX INFO: renamed from: k */
    public final /* synthetic */ InterfaceC3612c6 mo4633k() {
        return (AbstractC3851u4) mo4541p(6, null, null);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3733l3
    /* JADX INFO: renamed from: l */
    public final void mo5054l(int i) {
        this.zzc = i;
    }

    /* JADX INFO: renamed from: p */
    public abstract Object mo4541p(int i, Object obj, Object obj2);

    /* JADX INFO: renamed from: s */
    public final <MessageType extends AbstractC3851u4<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> BuilderType m5314s() {
        return (BuilderType) mo4541p(5, null, null);
    }

    /* JADX INFO: renamed from: t */
    public final BuilderType m5315t() {
        BuilderType buildertype = (BuilderType) mo4541p(5, null, null);
        buildertype.m5316l(this);
        return buildertype;
    }

    public String toString() {
        String string = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        C3404f.m4286e2(this, sb, 0);
        return sb.toString();
    }
}
