package f0.e0.j;

import java.io.IOException;
import java.util.Objects;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$d$c extends f0.e0.f.a {
    public final /* synthetic */ e$d e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ s g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$d$c(String str, boolean z2, String str2, boolean z3, e$d e_d, boolean z4, s sVar) {
        super(str2, z3);
        this.e = e_d;
        this.f = z4;
        this.g = sVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [T, f0.e0.j.s, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, f0.e0.j.s] */
    @Override // f0.e0.f.a
    public long a() throws Throwable {
        o oVar;
        e eVar;
        T t;
        e$d e_d = this.e;
        boolean z2 = this.f;
        ?? r10 = this.g;
        Objects.requireNonNull(e_d);
        d0.z.d.m.checkParameterIsNotNull(r10, "settings");
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        o oVar2 = e_d.k.K;
        synchronized (oVar2) {
            try {
                e eVar2 = e_d.k;
                try {
                    synchronized (eVar2) {
                        try {
                            s sVar = e_d.k.E;
                            if (z2) {
                                ref$ObjectRef2.element = r10;
                            } else {
                                ?? sVar2 = new s();
                                sVar2.b(sVar);
                                sVar2.b(r10);
                                ref$ObjectRef2.element = sVar2;
                            }
                            long jA = ((long) ((s) ref$ObjectRef2.element).a()) - ((long) sVar.a());
                            ref$LongRef.element = jA;
                            if (jA == 0 || e_d.k.n.isEmpty()) {
                                t = 0;
                            } else {
                                Object[] array = e_d.k.n.values().toArray(new n[0]);
                                if (array == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                                t = (n[]) array;
                            }
                            ref$ObjectRef.element = t;
                            e eVar3 = e_d.k;
                            s sVar3 = (s) ref$ObjectRef2.element;
                            Objects.requireNonNull(eVar3);
                            d0.z.d.m.checkParameterIsNotNull(sVar3, "<set-?>");
                            eVar3.E = sVar3;
                            f0.e0.f.c cVar = e_d.k.v;
                            String str = e_d.k.o + " onSettings";
                            eVar = eVar2;
                            oVar = oVar2;
                            try {
                                cVar.c(new f(str, true, str, true, e_d, z2, ref$ObjectRef2, r10, ref$LongRef, ref$ObjectRef), 0L);
                                try {
                                    e_d.k.K.a((s) ref$ObjectRef2.element);
                                } catch (IOException e) {
                                    e eVar4 = e_d.k;
                                    a aVar = a.PROTOCOL_ERROR;
                                    eVar4.a(aVar, aVar, e);
                                }
                                n[] nVarArr = (n[]) ref$ObjectRef.element;
                                if (nVarArr == null) {
                                    return -1L;
                                }
                                if (nVarArr == null) {
                                    d0.z.d.m.throwNpe();
                                }
                                for (n nVar : nVarArr) {
                                    synchronized (nVar) {
                                        long j = ref$LongRef.element;
                                        nVar.d += j;
                                        if (j > 0) {
                                            nVar.notifyAll();
                                        }
                                    }
                                }
                                return -1L;
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            eVar = eVar2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                oVar = oVar2;
            }
        }
    }
}
