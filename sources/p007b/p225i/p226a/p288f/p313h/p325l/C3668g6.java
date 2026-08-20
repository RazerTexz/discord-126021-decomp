package p007b.p225i.p226a.p288f.p313h.p325l;

import com.google.android.gms.internal.measurement.zzij;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.f.h.l.g6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3668g6<T> implements InterfaceC3801q6<T> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC3612c6 f9968a;

    /* JADX INFO: renamed from: b */
    public final AbstractC3627d7<?, ?> f9969b;

    /* JADX INFO: renamed from: c */
    public final boolean f9970c;

    /* JADX INFO: renamed from: d */
    public final AbstractC3708j4<?> f9971d;

    public C3668g6(AbstractC3627d7<?, ?> abstractC3627d7, AbstractC3708j4<?> abstractC3708j4, InterfaceC3612c6 interfaceC3612c6) {
        this.f9969b = abstractC3627d7;
        this.f9970c = abstractC3708j4.mo4973e(interfaceC3612c6);
        this.f9971d = abstractC3708j4;
        this.f9968a = interfaceC3612c6;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: a */
    public final T mo4843a() {
        return (T) ((AbstractC3851u4.b) this.f9968a.mo4607h()).m5319o();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: b */
    public final int mo4844b(T t) {
        int iHashCode = this.f9969b.mo4638e(t).hashCode();
        return this.f9970c ? (iHashCode * 53) + this.f9971d.mo4970b(t).hashCode() : iHashCode;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: c */
    public final boolean mo4845c(T t) {
        return this.f9971d.mo4970b(t).m5136m();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: d */
    public final void mo4846d(T t) {
        this.f9969b.mo4641h(t);
        this.f9971d.mo4975g(t);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: e */
    public final int mo4847e(T t) {
        AbstractC3627d7<?, ?> abstractC3627d7 = this.f9969b;
        int iMo4642i = abstractC3627d7.mo4642i(abstractC3627d7.mo4638e(t)) + 0;
        if (!this.f9970c) {
            return iMo4642i;
        }
        C3760n4<T> c3760n4Mo4970b = this.f9971d.mo4970b(t);
        int iM5130k = 0;
        for (int i = 0; i < c3760n4Mo4970b.f10111b.m5207e(); i++) {
            iM5130k += C3760n4.m5130k(c3760n4Mo4970b.f10111b.m5206d(i));
        }
        Iterator<T> it = c3760n4Mo4970b.f10111b.m5209g().iterator();
        while (it.hasNext()) {
            iM5130k += C3760n4.m5130k((Map.Entry) it.next());
        }
        return iMo4642i + iM5130k;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: f */
    public final boolean mo4848f(T t, T t2) {
        if (!this.f9969b.mo4638e(t).equals(this.f9969b.mo4638e(t2))) {
            return false;
        }
        if (this.f9970c) {
            return this.f9971d.mo4970b(t).equals(this.f9971d.mo4970b(t2));
        }
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: g */
    public final void mo4849g(T t, InterfaceC3867v7 interfaceC3867v7) throws IOException {
        Iterator itM5135l = this.f9971d.mo4970b(t).m5135l();
        while (itM5135l.hasNext()) {
            Map.Entry entry = (Map.Entry) itM5135l.next();
            InterfaceC3786p4 interfaceC3786p4 = (InterfaceC3786p4) entry.getKey();
            if (interfaceC3786p4.mo5176c() != EnumC3880w7.MESSAGE || interfaceC3786p4.mo5178d() || interfaceC3786p4.mo5179e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof C3653f5) {
                ((C3666g4) interfaceC3867v7).m4911c(interfaceC3786p4.mo5174a(), ((C3653f5) entry).f9942j.getValue().m4936c());
            } else {
                ((C3666g4) interfaceC3867v7).m4911c(interfaceC3786p4.mo5174a(), entry.getValue());
            }
        }
        AbstractC3627d7<?, ?> abstractC3627d7 = this.f9969b;
        abstractC3627d7.mo4639f(abstractC3627d7.mo4638e(t), interfaceC3867v7);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x0095 A[EDGE_INSN: B:56:0x0095->B:34:0x0095 BREAK  A[LOOP:1: B:18:0x0050->B:61:0x0050], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: h */
    public final void mo4850h(T t, byte[] bArr, int i, int i2, C3824s3 c3824s3) throws IOException {
        AbstractC3851u4 abstractC3851u4 = (AbstractC3851u4) t;
        C3613c7 c3613c7M4610c = abstractC3851u4.zzb;
        if (c3613c7M4610c == C3613c7.f9877a) {
            c3613c7M4610c = C3613c7.m4610c();
            abstractC3851u4.zzb = c3613c7M4610c;
        }
        ((AbstractC3851u4.d) t).m5321u();
        AbstractC3851u4.f fVar = null;
        while (i < i2) {
            int iM4233O1 = C3404f.m4233O1(bArr, i, c3824s3);
            int i3 = c3824s3.f10307a;
            if (i3 == 11) {
                int i4 = 0;
                AbstractC3837t3 abstractC3837t3 = null;
                while (iM4233O1 < i2) {
                    iM4233O1 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                    int i5 = c3824s3.f10307a;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 == 2) {
                        if (i7 != 0) {
                            if (i5 != 12) {
                                break;
                                break;
                            }
                            iM4233O1 = C3404f.m4209G1(i5, bArr, iM4233O1, i2, c3824s3);
                        } else {
                            iM4233O1 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                            i4 = c3824s3.f10307a;
                            fVar = (AbstractC3851u4.f) this.f9971d.mo4971c(c3824s3.f10310d, this.f9968a, i4);
                        }
                    } else {
                        if (i6 == 3) {
                            if (fVar != null) {
                                C3762n6 c3762n6 = C3762n6.f10114a;
                                throw new NoSuchMethodError();
                            }
                            if (i7 == 2) {
                                iM4233O1 = C3404f.m4354v2(bArr, iM4233O1, c3824s3);
                                abstractC3837t3 = (AbstractC3837t3) c3824s3.f10309c;
                            }
                        }
                        if (i5 != 12) {
                            break;
                        } else {
                            iM4233O1 = C3404f.m4209G1(i5, bArr, iM4233O1, i2, c3824s3);
                        }
                    }
                }
                if (abstractC3837t3 != null) {
                    c3613c7M4610c.m4611a((i4 << 3) | 2, abstractC3837t3);
                }
                i = iM4233O1;
            } else if ((i3 & 7) == 2) {
                fVar = (AbstractC3851u4.f) this.f9971d.mo4971c(c3824s3.f10310d, this.f9968a, i3 >>> 3);
                if (fVar != null) {
                    C3762n6 c3762n7 = C3762n6.f10114a;
                    throw new NoSuchMethodError();
                }
                i = C3404f.m4215I1(i3, bArr, iM4233O1, i2, c3613c7M4610c, c3824s3);
            } else {
                i = C3404f.m4209G1(i3, bArr, iM4233O1, i2, c3824s3);
            }
        }
        if (i != i2) {
            throw zzij.m9106d();
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: i */
    public final void mo4851i(T t, T t2) {
        AbstractC3627d7<?, ?> abstractC3627d7 = this.f9969b;
        Class<?> cls = C3827s6.f10313a;
        abstractC3627d7.mo4637d(t, abstractC3627d7.mo4640g(abstractC3627d7.mo4638e(t), abstractC3627d7.mo4638e(t2)));
        if (this.f9970c) {
            C3827s6.m5243i(this.f9971d, t, t2);
        }
    }
}
