package b.g.a.c.g0;

import b.g.a.a.c0$a;
import b.g.a.a.i$c;
import b.g.a.a.i$d;
import b.g.a.a.i0;
import b.g.a.a.l0;
import b.g.a.a.n$a;
import b.g.a.a.p$a;
import b.g.a.a.p$b;
import b.g.a.a.q$a;
import b.g.a.c.b$a;
import b.g.a.c.c0.a0;
import b.g.a.c.c0.b0;
import b.g.a.c.d$a;
import b.g.a.c.g0.u.d0;
import b.g.a.c.g0.u.f0;
import b.g.a.c.g0.u.j0;
import b.g.a.c.g0.u.s0;
import b.g.a.c.g0.u.t0;
import b.g.a.c.i0.e$a;
import b.g.a.c.t;
import b.g.a.c.v;
import b.g.a.c.w;
import b.g.a.c.x;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: BeanSerializerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends b implements Serializable {
    public static final f l = new f(null);
    private static final long serialVersionUID = 1;

    public f(b.g.a.c.z.o oVar) {
        super(null);
    }

    @Override // b.g.a.c.g0.q
    public b.g.a.c.n<Object> b(x xVar, b.g.a.c.j jVar) throws JsonMappingException {
        b.g.a.c.j jVarE0;
        Object objH;
        v vVar = xVar._config;
        b.g.a.c.c cVarU = vVar.u(jVar);
        b.g.a.c.n<?> nVarF = f(xVar, ((b.g.a.c.c0.q) cVarU).f);
        if (nVarF != null) {
            return nVarF;
        }
        b.g.a.c.b bVarE = vVar.e();
        boolean z2 = false;
        b.g.a.c.i0.e eVar = null;
        if (bVarE == null) {
            jVarE0 = jVar;
        } else {
            try {
                jVarE0 = bVarE.e0(vVar, ((b.g.a.c.c0.q) cVarU).f, jVar);
            } catch (JsonMappingException e) {
                xVar.F(cVarU, e.getMessage(), new Object[0]);
                throw null;
            }
        }
        if (jVarE0 != jVar) {
            if (!jVarE0.t(jVar._class)) {
                cVarU = vVar.u(jVarE0);
            }
            z2 = true;
        }
        b.g.a.c.c0.q qVar = (b.g.a.c.c0.q) cVarU;
        b.g.a.c.b bVar = qVar.e;
        if (bVar != null && (objH = bVar.H(qVar.f)) != null) {
            if (objH instanceof b.g.a.c.i0.e) {
                eVar = (b.g.a.c.i0.e) objH;
            } else {
                if (!(objH instanceof Class)) {
                    StringBuilder sbU = b.d.b.a.a.U("AnnotationIntrospector returned Converter definition of type ");
                    sbU.append(objH.getClass().getName());
                    sbU.append("; expected type Converter or Class<Converter> instead");
                    throw new IllegalStateException(sbU.toString());
                }
                Class cls = (Class) objH;
                if (cls != e$a.class && !b.g.a.c.i0.d.p(cls)) {
                    if (!b.g.a.c.i0.e.class.isAssignableFrom(cls)) {
                        throw new IllegalStateException(b.d.b.a.a.o(cls, b.d.b.a.a.U("AnnotationIntrospector returned Class "), "; expected Class<Converter>"));
                    }
                    Objects.requireNonNull(qVar.d._base);
                    eVar = (b.g.a.c.i0.e) b.g.a.c.i0.d.g(cls, qVar.d.b());
                }
            }
        }
        if (eVar == null) {
            return i(xVar, jVarE0, cVarU, z2);
        }
        b.g.a.c.j jVarA = eVar.a(xVar.d());
        if (!jVarA.t(jVarE0._class)) {
            cVarU = vVar.u(jVarA);
            nVarF = f(xVar, ((b.g.a.c.c0.q) cVarU).f);
        }
        if (nVarF == null && !jVarA.y()) {
            nVarF = i(xVar, jVarA, cVarU, true);
        }
        return new j0(eVar, jVarA, nVarF);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0259  */
    /* JADX WARN: Code duplicated, block: B:123:0x0261  */
    /* JADX WARN: Code duplicated, block: B:125:0x0267  */
    /* JADX WARN: Code duplicated, block: B:126:0x0269  */
    /* JADX WARN: Code duplicated, block: B:128:0x0271  */
    /* JADX WARN: Code duplicated, block: B:135:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:138:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:139:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:97:0x020f  */
    /* JADX WARN: Multi-variable type inference failed */
    public c h(x xVar, b.g.a.c.c0.s sVar, l lVar, boolean z2, b.g.a.c.c0.i iVar) throws JsonMappingException {
        b.g.a.c.e0.g gVarC;
        boolean z3;
        boolean z4;
        boolean zB;
        Object obj;
        Class<?>[] clsArrI;
        c cVar;
        Object objQ;
        b.g.a.c.c0.q qVar;
        b.g.a.c.b bVar;
        Class<?>[] clsArrR;
        Object objT0;
        t tVarM = sVar.m();
        b.g.a.c.j jVarE = iVar.e();
        d$a d_a = new d$a(tVarM, jVarE, sVar.t(), iVar, sVar.o());
        b.g.a.c.n<Object> nVarF = f(xVar, iVar);
        if (nVarF instanceof o) {
            ((o) nVarF).b(xVar);
        }
        b.g.a.c.n<?> nVarY = xVar.y(nVarF, d_a);
        if (jVarE.v() || jVarE.b()) {
            v vVar = xVar._config;
            b.g.a.c.j jVarK = jVarE.k();
            b.g.a.c.e0.f<?> fVarU = vVar.e().u(vVar, iVar, jVarE);
            gVarC = fVarU == null ? c(vVar, jVarK) : fVarU.e(vVar, jVarK, vVar._subtypeResolver.a(vVar, iVar, jVarK));
        } else {
            gVarC = null;
        }
        v vVar2 = xVar._config;
        b.g.a.c.e0.f<?> fVarC = vVar2.e().C(vVar2, iVar, jVarE);
        b.g.a.c.e0.g gVarC2 = fVarC == null ? c(vVar2, jVarE) : fVarC.e(vVar2, jVarE, vVar2._subtypeResolver.a(vVar2, iVar, jVarE));
        Object obj2 = p$a.NON_EMPTY;
        try {
            b.g.a.c.j jVarA = lVar.a(iVar, z2, jVarE);
            if (gVarC != null) {
                if (jVarA == null) {
                    jVarA = jVarE;
                }
                if (jVarA.k() == null) {
                    xVar.E(lVar.f702b, sVar, "serialization type " + jVarA + " has no content", new Object[0]);
                    throw null;
                }
                b.g.a.c.j jVarE2 = jVarA.E(gVarC);
                jVarE2.k();
                jVarA = jVarE2;
            }
            b.g.a.c.j jVar = jVarA == null ? jVarE : jVarA;
            b.g.a.c.c0.i iVarJ = sVar.j();
            if (iVarJ == null) {
                xVar.E(lVar.f702b, sVar, "could not determine property type", new Object[0]);
                throw null;
            }
            Class<?> clsD = iVarJ.d();
            v vVar3 = lVar.a;
            Class<?> cls = jVar._class;
            p$b p_b = lVar.e;
            vVar3.f(cls);
            vVar3.f(clsD);
            p$b[] p_bArr = {p_b, null, null};
            p$b p_b2 = p$b.j;
            int i = 0;
            p$b p_b3 = null;
            for (int i2 = 3; i < i2; i2 = 3) {
                p$b p_bA = p_bArr[i];
                if (p_bA != null) {
                    if (p_b3 != null) {
                        p_bA = p_b3.a(p_bA);
                    }
                    p_b3 = p_bA;
                }
                i++;
            }
            p$b p_bA2 = p_b3.a(sVar.g());
            p$a p_a = p_bA2._valueInclusion;
            if (p_a == p$a.USE_DEFAULTS) {
                p_a = p$a.ALWAYS;
            }
            int iOrdinal = p_a.ordinal();
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    if (!jVar.b()) {
                        z4 = true;
                        zB = z4;
                        obj = null;
                        clsArrI = sVar.i();
                        if (clsArrI == null) {
                            qVar = (b.g.a.c.c0.q) lVar.f702b;
                            if (!qVar.h) {
                                qVar.h = true;
                                bVar = qVar.e;
                                if (bVar == null) {
                                    clsArrR = null;
                                } else {
                                    clsArrR = bVar.R(qVar.f);
                                }
                                if (clsArrR == null) {
                                    clsArrR = b.g.a.c.c0.q.f693b;
                                }
                                qVar.g = clsArrR;
                            }
                            clsArrI = qVar.g;
                        }
                        cVar = new c(sVar, iVar, ((b.g.a.c.c0.q) lVar.f702b).f.t, jVarE, nVarY, gVarC2, jVarA, zB, obj, clsArrI);
                        objQ = lVar.c.q(iVar);
                        if (objQ != null) {
                            cVar.e(xVar.H(iVar, objQ));
                        }
                        b.g.a.c.i0.n nVarQ = lVar.c.Q(iVar);
                        if (nVarQ != null) {
                        }
                    }
                    int i3 = c.j;
                } else if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        if (iOrdinal != 5) {
                            z3 = false;
                        } else {
                            objT0 = xVar.A(sVar, p_bA2._valueFilter);
                            if (objT0 != null) {
                                obj = objT0;
                                zB = xVar.B(objT0);
                            }
                        }
                        clsArrI = sVar.i();
                        if (clsArrI == null) {
                            qVar = (b.g.a.c.c0.q) lVar.f702b;
                            if (!qVar.h) {
                                qVar.h = true;
                                bVar = qVar.e;
                                if (bVar == null) {
                                    clsArrR = null;
                                } else {
                                    clsArrR = bVar.R(qVar.f);
                                }
                                if (clsArrR == null && !qVar.d.q(b.g.a.c.p.DEFAULT_VIEW_INCLUSION)) {
                                    clsArrR = b.g.a.c.c0.q.f693b;
                                }
                                qVar.g = clsArrR;
                            }
                            clsArrI = qVar.g;
                        }
                        cVar = new c(sVar, iVar, ((b.g.a.c.c0.q) lVar.f702b).f.t, jVarE, nVarY, gVarC2, jVarA, zB, obj, clsArrI);
                        objQ = lVar.c.q(iVar);
                        if (objQ != null) {
                            cVar.e(xVar.H(iVar, objQ));
                        }
                        b.g.a.c.i0.n nVarQ2 = lVar.c.Q(iVar);
                        return nVarQ2 != null ? new b.g.a.c.g0.t.s(cVar, nVarQ2) : cVar;
                    }
                    if (lVar.f) {
                        Object objNewInstance = lVar.d;
                        if (objNewInstance == null) {
                            b.g.a.c.c cVar2 = lVar.f702b;
                            boolean zB2 = lVar.a.b();
                            b.g.a.c.c0.q qVar2 = (b.g.a.c.c0.q) cVar2;
                            b.g.a.c.c0.e eVar = qVar2.f.f().a;
                            if (eVar == null) {
                                objNewInstance = null;
                            } else {
                                if (zB2) {
                                    eVar.f(qVar2.d.q(b.g.a.c.p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                                }
                                try {
                                    objNewInstance = eVar._constructor.newInstance(new Object[0]);
                                } catch (Exception e) {
                                    e = e;
                                    while (e.getCause() != null) {
                                        e = e.getCause();
                                    }
                                    b.g.a.c.i0.d.w(e);
                                    b.g.a.c.i0.d.x(e);
                                    StringBuilder sbU = b.d.b.a.a.U("Failed to instantiate bean of type ");
                                    sbU.append(qVar2.f.l.getName());
                                    sbU.append(": (");
                                    sbU.append(e.getClass().getName());
                                    sbU.append(") ");
                                    sbU.append(b.g.a.c.i0.d.h(e));
                                    throw new IllegalArgumentException(sbU.toString(), e);
                                }
                            }
                            if (objNewInstance == null) {
                                objNewInstance = Boolean.FALSE;
                            }
                            lVar.d = objNewInstance;
                        }
                        Object obj3 = objNewInstance == Boolean.FALSE ? null : lVar.d;
                        if (obj3 != null) {
                            if (xVar.C(b.g.a.c.p.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                                iVar.f(lVar.a.q(b.g.a.c.p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                            }
                            try {
                                objT0 = iVar.j(obj3);
                                z3 = false;
                            } catch (Exception e2) {
                                e = e2;
                                String strP = sVar.p();
                                while (e.getCause() != null) {
                                    e = e.getCause();
                                }
                                b.g.a.c.i0.d.w(e);
                                b.g.a.c.i0.d.x(e);
                                StringBuilder sbY = b.d.b.a.a.Y("Failed to get property '", strP, "' of default ");
                                sbY.append(obj3.getClass().getName());
                                sbY.append(" instance");
                                throw new IllegalArgumentException(sbY.toString());
                            }
                        } else {
                            objT0 = b.c.a.a0.d.t0(jVar);
                            z3 = true;
                        }
                    } else {
                        objT0 = b.c.a.a0.d.t0(jVar);
                        z3 = true;
                    }
                    if (objT0 != null) {
                        if (objT0.getClass().isArray()) {
                            objT0 = b.c.a.a0.d.q0(objT0);
                        }
                        obj2 = objT0;
                        zB = z3;
                        obj = obj2;
                        clsArrI = sVar.i();
                        if (clsArrI == null) {
                            qVar = (b.g.a.c.c0.q) lVar.f702b;
                            if (!qVar.h) {
                                qVar.h = true;
                                bVar = qVar.e;
                                if (bVar == null) {
                                    clsArrR = null;
                                } else {
                                    clsArrR = bVar.R(qVar.f);
                                }
                                if (clsArrR == null) {
                                    clsArrR = b.g.a.c.c0.q.f693b;
                                }
                                qVar.g = clsArrR;
                            }
                            clsArrI = qVar.g;
                        }
                        cVar = new c(sVar, iVar, ((b.g.a.c.c0.q) lVar.f702b).f.t, jVarE, nVarY, gVarC2, jVarA, zB, obj, clsArrI);
                        objQ = lVar.c.q(iVar);
                        if (objQ != null) {
                            cVar.e(xVar.H(iVar, objQ));
                        }
                        b.g.a.c.i0.n nVarQ3 = lVar.c.Q(iVar);
                        if (nVarQ3 != null) {
                        }
                    }
                    obj2 = objT0;
                } else {
                    int i4 = c.j;
                }
                obj = obj2;
                zB = true;
                clsArrI = sVar.i();
                if (clsArrI == null) {
                    qVar = (b.g.a.c.c0.q) lVar.f702b;
                    if (!qVar.h) {
                        qVar.h = true;
                        bVar = qVar.e;
                        if (bVar == null) {
                            clsArrR = null;
                        } else {
                            clsArrR = bVar.R(qVar.f);
                        }
                        if (clsArrR == null) {
                            clsArrR = b.g.a.c.c0.q.f693b;
                        }
                        qVar.g = clsArrR;
                    }
                    clsArrI = qVar.g;
                }
                cVar = new c(sVar, iVar, ((b.g.a.c.c0.q) lVar.f702b).f.t, jVarE, nVarY, gVarC2, jVarA, zB, obj, clsArrI);
                objQ = lVar.c.q(iVar);
                if (objQ != null) {
                    cVar.e(xVar.H(iVar, objQ));
                }
                b.g.a.c.i0.n nVarQ4 = lVar.c.Q(iVar);
                if (nVarQ4 != null) {
                }
            }
            z3 = true;
            w wVar = w.WRITE_EMPTY_JSON_ARRAYS;
            if (!jVar.v() || lVar.a.v(wVar)) {
                z4 = z3;
                zB = z4;
                obj = null;
                clsArrI = sVar.i();
                if (clsArrI == null) {
                    qVar = (b.g.a.c.c0.q) lVar.f702b;
                    if (!qVar.h) {
                        qVar.h = true;
                        bVar = qVar.e;
                        if (bVar == null) {
                            clsArrR = null;
                        } else {
                            clsArrR = bVar.R(qVar.f);
                        }
                        if (clsArrR == null) {
                            clsArrR = b.g.a.c.c0.q.f693b;
                        }
                        qVar.g = clsArrR;
                    }
                    clsArrI = qVar.g;
                }
                cVar = new c(sVar, iVar, ((b.g.a.c.c0.q) lVar.f702b).f.t, jVarE, nVarY, gVarC2, jVarA, zB, obj, clsArrI);
                objQ = lVar.c.q(iVar);
                if (objQ != null) {
                    cVar.e(xVar.H(iVar, objQ));
                }
                b.g.a.c.i0.n nVarQ5 = lVar.c.Q(iVar);
                if (nVarQ5 != null) {
                }
            }
            int i5 = c.j;
            zB = z3;
            obj = obj2;
            clsArrI = sVar.i();
            if (clsArrI == null) {
                qVar = (b.g.a.c.c0.q) lVar.f702b;
                if (!qVar.h) {
                    qVar.h = true;
                    bVar = qVar.e;
                    if (bVar == null) {
                        clsArrR = null;
                    } else {
                        clsArrR = bVar.R(qVar.f);
                    }
                    if (clsArrR == null) {
                        clsArrR = b.g.a.c.c0.q.f693b;
                    }
                    qVar.g = clsArrR;
                }
                clsArrI = qVar.g;
            }
            cVar = new c(sVar, iVar, ((b.g.a.c.c0.q) lVar.f702b).f.t, jVarE, nVarY, gVarC2, jVarA, zB, obj, clsArrI);
            objQ = lVar.c.q(iVar);
            if (objQ != null) {
                cVar.e(xVar.H(iVar, objQ));
            }
            b.g.a.c.i0.n nVarQ6 = lVar.c.Q(iVar);
            if (nVarQ6 != null) {
            }
        } catch (JsonMappingException e3) {
            xVar.E(lVar.f702b, sVar, b.g.a.c.i0.d.h(e3), new Object[0]);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:164:0x02f3 A[PHI: r4
      0x02f3: PHI (r4v88 b.g.a.c.n<?>) = (r4v87 b.g.a.c.n<?>), (r4v89 b.g.a.c.n<?>), (r4v91 b.g.a.c.n<?>) binds: [B:131:0x0273, B:133:0x0279, B:161:0x02e8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:215:0x0404 A[PHI: r11 r12 r13 r14 r15
      0x0404: PHI (r11v5 java.lang.Class<java.lang.Enum>) = (r11v4 java.lang.Class<java.lang.Enum>), (r11v10 java.lang.Class<java.lang.Enum>) binds: [B:189:0x0384, B:135:0x0284] A[DONT_GENERATE, DONT_INLINE]
      0x0404: PHI (r12v4 b.g.a.c.c) = (r12v3 b.g.a.c.c), (r12v10 b.g.a.c.c) binds: [B:189:0x0384, B:135:0x0284] A[DONT_GENERATE, DONT_INLINE]
      0x0404: PHI (r13v10 b.g.a.a.p$a) = (r13v9 b.g.a.a.p$a), (r13v13 b.g.a.a.p$a) binds: [B:189:0x0384, B:135:0x0284] A[DONT_GENERATE, DONT_INLINE]
      0x0404: PHI (r14v40 b.g.a.a.p$a) = (r14v39 b.g.a.a.p$a), (r14v43 b.g.a.a.p$a) binds: [B:189:0x0384, B:135:0x0284] A[DONT_GENERATE, DONT_INLINE]
      0x0404: PHI (r15v13 b.g.a.a.i$c) = (r15v12 b.g.a.a.i$c), (r15v16 b.g.a.a.i$c) binds: [B:189:0x0384, B:135:0x0284] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:262:0x04bf A[PHI: r4
      0x04bf: PHI (r4v14 int) = (r4v13 int), (r4v16 int) binds: [B:260:0x04ba, B:247:0x048b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:349:0x0658  */
    /* JADX WARN: Code duplicated, block: B:408:0x0729  */
    /* JADX WARN: Code duplicated, block: B:429:0x078f  */
    /* JADX WARN: Code duplicated, block: B:431:0x0792  */
    /* JADX WARN: Code duplicated, block: B:432:0x0795  */
    /* JADX WARN: Code duplicated, block: B:435:0x07ba  */
    /* JADX WARN: Code duplicated, block: B:440:0x07d6  */
    /* JADX WARN: Code duplicated, block: B:442:0x07e7  */
    /* JADX WARN: Code duplicated, block: B:449:0x07fe  */
    /* JADX WARN: Code duplicated, block: B:452:0x0808  */
    /* JADX WARN: Code duplicated, block: B:459:0x0824  */
    /* JADX WARN: Code duplicated, block: B:460:0x0829  */
    /* JADX WARN: Code duplicated, block: B:463:0x0846  */
    /* JADX WARN: Code duplicated, block: B:468:0x085d  */
    /* JADX WARN: Code duplicated, block: B:473:0x0883  */
    /* JADX WARN: Code duplicated, block: B:475:0x0888  */
    /* JADX WARN: Code duplicated, block: B:476:0x088a  */
    /* JADX WARN: Code duplicated, block: B:478:0x088d  */
    /* JADX WARN: Code duplicated, block: B:479:0x0891  */
    /* JADX WARN: Code duplicated, block: B:481:0x0895  */
    /* JADX WARN: Code duplicated, block: B:482:0x08ac  */
    /* JADX WARN: Code duplicated, block: B:487:0x08cb  */
    /* JADX WARN: Code duplicated, block: B:488:0x08d1  */
    /* JADX WARN: Code duplicated, block: B:490:0x08d8  */
    /* JADX WARN: Code duplicated, block: B:511:0x0925  */
    /* JADX WARN: Code duplicated, block: B:517:0x093f  */
    /* JADX WARN: Code duplicated, block: B:520:0x094d A[LOOP:3: B:518:0x0947->B:520:0x094d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:523:0x0963  */
    /* JADX WARN: Code duplicated, block: B:524:0x0968  */
    /* JADX WARN: Code duplicated, block: B:527:0x0975  */
    /* JADX WARN: Code duplicated, block: B:528:0x0977  */
    /* JADX WARN: Code duplicated, block: B:530:0x097d  */
    /* JADX WARN: Code duplicated, block: B:531:0x0980  */
    /* JADX WARN: Code duplicated, block: B:536:0x098b  */
    /* JADX WARN: Code duplicated, block: B:539:0x0995  */
    /* JADX WARN: Code duplicated, block: B:544:0x09b1  */
    /* JADX WARN: Code duplicated, block: B:547:0x09bf A[LOOP:4: B:545:0x09b9->B:547:0x09bf, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:550:0x09cd  */
    /* JADX WARN: Code duplicated, block: B:551:0x09d0  */
    /* JADX WARN: Code duplicated, block: B:553:0x09d6  */
    /* JADX WARN: Code duplicated, block: B:557:0x09f1  */
    /* JADX WARN: Code duplicated, block: B:558:0x09f4  */
    /* JADX WARN: Code duplicated, block: B:561:0x0a04  */
    /* JADX WARN: Code duplicated, block: B:564:0x0a16  */
    /* JADX WARN: Code duplicated, block: B:566:0x0a2c A[LOOP:7: B:554:0x09df->B:566:0x0a2c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:567:0x0a2f  */
    /* JADX WARN: Code duplicated, block: B:570:0x0a62  */
    /* JADX WARN: Code duplicated, block: B:572:0x0a66  */
    /* JADX WARN: Code duplicated, block: B:575:0x0a6d  */
    /* JADX WARN: Code duplicated, block: B:577:0x0a73  */
    /* JADX WARN: Code duplicated, block: B:578:0x0a7c  */
    /* JADX WARN: Code duplicated, block: B:580:0x0a97  */
    /* JADX WARN: Code duplicated, block: B:582:0x0a9a  */
    /* JADX WARN: Code duplicated, block: B:585:0x0aa7  */
    /* JADX WARN: Code duplicated, block: B:587:0x0abc  */
    /* JADX WARN: Code duplicated, block: B:589:0x0ac2  */
    /* JADX WARN: Code duplicated, block: B:592:0x0ac9  */
    /* JADX WARN: Code duplicated, block: B:594:0x0acf  */
    /* JADX WARN: Code duplicated, block: B:595:0x0ad8  */
    /* JADX WARN: Code duplicated, block: B:597:0x0af3  */
    /* JADX WARN: Code duplicated, block: B:599:0x0af6  */
    /* JADX WARN: Code duplicated, block: B:602:0x0b03  */
    /* JADX WARN: Code duplicated, block: B:604:0x0b18  */
    /* JADX WARN: Code duplicated, block: B:606:0x0b1b  */
    /* JADX WARN: Code duplicated, block: B:608:0x0b2d  */
    /* JADX WARN: Code duplicated, block: B:612:0x0b6e  */
    /* JADX WARN: Code duplicated, block: B:622:0x0b95  */
    /* JADX WARN: Code duplicated, block: B:624:0x0b99  */
    /* JADX WARN: Code duplicated, block: B:629:0x0ba5  */
    /* JADX WARN: Code duplicated, block: B:631:0x0bad  */
    /* JADX WARN: Code duplicated, block: B:634:0x0bb7  */
    /* JADX WARN: Code duplicated, block: B:637:0x0bc5 A[LOOP:6: B:635:0x0bbf->B:637:0x0bc5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:640:0x0bd5  */
    /* JADX WARN: Code duplicated, block: B:642:0x0bdb  */
    /* JADX WARN: Code duplicated, block: B:643:0x0be9  */
    /* JADX WARN: Code duplicated, block: B:645:0x0bf3  */
    /* JADX WARN: Code duplicated, block: B:651:0x0c08  */
    /* JADX WARN: Code duplicated, block: B:653:0x0c18  */
    /* JADX WARN: Code duplicated, block: B:655:0x0c22  */
    /* JADX WARN: Code duplicated, block: B:661:0x0c37  */
    /* JADX WARN: Code duplicated, block: B:663:0x0c45  */
    /* JADX WARN: Code duplicated, block: B:665:0x0c4d  */
    /* JADX WARN: Code duplicated, block: B:666:0x0c50  */
    /* JADX WARN: Code duplicated, block: B:669:0x0c54  */
    /* JADX WARN: Code duplicated, block: B:671:0x0c5e  */
    /* JADX WARN: Code duplicated, block: B:672:0x0c60  */
    /* JADX WARN: Code duplicated, block: B:674:0x0c63  */
    /* JADX WARN: Code duplicated, block: B:676:0x0c71  */
    /* JADX WARN: Code duplicated, block: B:680:0x0c9d  */
    /* JADX WARN: Code duplicated, block: B:696:0x07ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:697:0x07c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:698:0x07f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:700:0x07b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:715:0x0b9b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:716:0x0a14 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:717:0x09e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:719:0x09a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:721:0x098f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:733:0x087d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:734:0x0859 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:736:0x0860 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:737:0x0857 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:740:0x0840 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0180  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v111, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r1v114 */
    /* JADX WARN: Type inference failed for: r1v120 */
    /* JADX WARN: Type inference failed for: r1v121, types: [b.g.a.c.g0.d] */
    /* JADX WARN: Type inference failed for: r1v127, types: [b.g.a.c.g0.d] */
    /* JADX WARN: Type inference failed for: r1v155 */
    /* JADX WARN: Type inference failed for: r1v162 */
    /* JADX WARN: Type inference failed for: r1v163, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r1v164 */
    /* JADX WARN: Type inference failed for: r1v194 */
    /* JADX WARN: Type inference failed for: r1v195 */
    /* JADX WARN: Type inference failed for: r1v196 */
    /* JADX WARN: Type inference failed for: r1v197 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v203 */
    /* JADX WARN: Type inference failed for: r1v204, types: [b.g.a.c.g0.u.d0] */
    /* JADX WARN: Type inference failed for: r1v207, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r1v208 */
    /* JADX WARN: Type inference failed for: r1v210 */
    /* JADX WARN: Type inference failed for: r1v211 */
    /* JADX WARN: Type inference failed for: r1v217 */
    /* JADX WARN: Type inference failed for: r1v218 */
    /* JADX WARN: Type inference failed for: r1v229 */
    /* JADX WARN: Type inference failed for: r1v235, types: [b.g.a.c.n<?>] */
    /* JADX WARN: Type inference failed for: r1v236 */
    /* JADX WARN: Type inference failed for: r1v237 */
    /* JADX WARN: Type inference failed for: r1v239 */
    /* JADX WARN: Type inference failed for: r1v242 */
    /* JADX WARN: Type inference failed for: r1v243 */
    /* JADX WARN: Type inference failed for: r1v247 */
    /* JADX WARN: Type inference failed for: r1v249 */
    /* JADX WARN: Type inference failed for: r1v250 */
    /* JADX WARN: Type inference failed for: r1v251 */
    /* JADX WARN: Type inference failed for: r1v252 */
    /* JADX WARN: Type inference failed for: r1v253 */
    /* JADX WARN: Type inference failed for: r1v254 */
    /* JADX WARN: Type inference failed for: r1v255 */
    /* JADX WARN: Type inference failed for: r1v256 */
    /* JADX WARN: Type inference failed for: r1v257 */
    /* JADX WARN: Type inference failed for: r1v258 */
    /* JADX WARN: Type inference failed for: r1v259 */
    /* JADX WARN: Type inference failed for: r1v260 */
    /* JADX WARN: Type inference failed for: r1v261 */
    /* JADX WARN: Type inference failed for: r1v262 */
    /* JADX WARN: Type inference failed for: r1v263 */
    /* JADX WARN: Type inference failed for: r1v264 */
    /* JADX WARN: Type inference failed for: r1v265 */
    /* JADX WARN: Type inference failed for: r1v266 */
    /* JADX WARN: Type inference failed for: r1v267 */
    /* JADX WARN: Type inference failed for: r1v268 */
    /* JADX WARN: Type inference failed for: r1v269 */
    /* JADX WARN: Type inference failed for: r1v270 */
    /* JADX WARN: Type inference failed for: r1v271 */
    /* JADX WARN: Type inference failed for: r1v272 */
    /* JADX WARN: Type inference failed for: r1v3, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31, types: [b.g.a.c.n<?>] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v70 */
    /* JADX WARN: Type inference failed for: r26v0, types: [b.g.a.c.g0.b, b.g.a.c.g0.f] */
    /* JADX WARN: Type inference failed for: r5v33, types: [b.g.a.c.g0.t.i] */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v8, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public b.g.a.c.n<?> i(x xVar, b.g.a.c.j jVar, b.g.a.c.c cVar, boolean z2) throws JsonMappingException {
        p$a p_a;
        p$a p_a2;
        i$c i_c;
        Class<Enum> cls;
        b.g.a.c.c cVar2;
        int i;
        ?? E;
        b.g.a.c.n<?> nVarA;
        int i2;
        Object objT0;
        boolean zB;
        int i3;
        char c;
        int iOrdinal;
        t0 t0Var;
        b.g.a.c.g0.u.v vVar;
        t0 t0Var2;
        s0 s0Var;
        b.g.a.c.g0.u.q qVar;
        b.g.a.c.g0.u.p pVar;
        b.g.a.c.g0.u.g gVar;
        Object objT1;
        boolean zB2;
        b.g.a.c.g0.u.k kVar;
        b.g.a.c.g0.u.h hVar;
        String str;
        boolean z3;
        String str2;
        String str3;
        String str4;
        b.g.a.c.g0.t.r rVar;
        v vVar2;
        e eVar;
        b.g.a.c.c0.q qVar2;
        List<b.g.a.c.c0.s> listD;
        v vVar3;
        b.g.a.c.b bVarE;
        HashMap map;
        Iterator<b.g.a.c.c0.s> it;
        boolean zG;
        l lVar;
        ArrayList arrayList;
        boolean z4;
        ArrayList<c> arrayList2;
        b.g.a.c.c0.i iVarJ;
        b$a b_aH;
        ArrayList arrayList3;
        boolean z5;
        int size;
        int i4;
        b.g.a.c.e0.g gVar2;
        boolean zEquals;
        n$a n_aS;
        Set<String> setD;
        b.g.a.c.c0.c cVar3;
        b.g.a.c.b bVarE2;
        q$a q_aA;
        Set<String> set;
        Iterator it2;
        a0 a0Var;
        Class<? extends i0<?>> cls2;
        b.g.a.c.g0.t.j jVarA;
        String str5;
        int size2;
        int i5;
        String strC;
        c cVar4;
        b0 b0Var;
        b.g.a.c.c0.i first;
        List<c> list;
        boolean zQ;
        int size3;
        c[] cVarArr;
        int i6;
        Class<?> cls3;
        boolean z6;
        t0 t0Var3;
        b.g.a.c.j[] jVarArrI;
        b.g.a.c.j jVarK;
        boolean z7;
        b.g.a.c.j[] jVarArrI2;
        b.g.a.c.j jVarK2;
        b.g.a.c.i0.b bVar;
        c cVar5;
        Class<?>[] clsArr;
        List<c> list2;
        b.g.a.c.j jVarE;
        b.g.a.c.e0.g gVarC;
        b.g.a.c.n nVarF;
        LinkedList<b.g.a.c.c0.i> linkedList;
        b0 b0Var2;
        LinkedList<b.g.a.c.c0.i> linkedList2;
        b.g.a.c.i0.b bVar2;
        b.g.a.c.i0.b bVar3;
        Iterator<b.g.a.c.c0.s> it3;
        b.g.a.c.c0.s next;
        b.g.a.c.c0.s next2;
        Class<?> clsR;
        Boolean boolC0;
        b.g.a.c.n<Object> nVarX;
        b.g.a.c.g0.u.m mVar;
        Class<? extends b.g.a.c.n<?>> cls4;
        b.g.a.c.n nVar;
        boolean z8;
        b.g.a.c.n<?> nVarE;
        boolean z9;
        b.g.a.c.e0.g gVar3;
        b.g.a.c.n<Object> nVar2;
        h jVar2;
        i$c i_c2;
        b.g.a.c.n<?> nVarE2;
        v vVar4;
        b.g.a.c.n<Object> nVar3;
        b.g.a.c.c0.q qVar3;
        boolean z10;
        b.g.a.c.e0.g gVar4;
        Object objT2;
        boolean zB3;
        b.g.a.c.c cVar6 = cVar;
        boolean z11 = z2;
        Class<Enum> cls5 = Enum.class;
        i$c i_c3 = i$c.OBJECT;
        p$a p_a3 = p$a.ALWAYS;
        p$a p_a4 = p$a.USE_DEFAULTS;
        v vVar5 = xVar._config;
        if (jVar.v()) {
            boolean zG2 = !z11 ? g(vVar5, cVar6, null) : z11;
            v vVar6 = xVar._config;
            boolean z12 = (zG2 || !jVar._asStatic || (jVar.v() && jVar.k().y())) ? zG2 : true;
            b.g.a.c.e0.g gVarC2 = c(vVar6, jVar.k());
            boolean z13 = gVarC2 != null ? false : z12;
            b.g.a.c.c0.q qVar4 = (b.g.a.c.c0.q) cVar6;
            b.g.a.c.c0.c cVar7 = qVar4.f;
            Object objC = xVar.v().c(cVar7);
            b.g.a.c.n<Object> nVarH = objC != null ? xVar.H(cVar7, objC) : null;
            if (jVar.z()) {
                b.g.a.c.h0.f fVar = (b.g.a.c.h0.f) jVar;
                b.g.a.c.c0.c cVar8 = qVar4.f;
                Object objL = xVar.v().l(cVar8);
                b.g.a.c.n<Object> nVarH2 = objL != null ? xVar.H(cVar8, objL) : null;
                if (fVar instanceof b.g.a.c.h0.g) {
                    b.g.a.c.h0.g gVar5 = (b.g.a.c.h0.g) fVar;
                    if (cVar6.a(null).e() == i_c3) {
                        E = 0;
                        i_c2 = i_c3;
                    } else {
                        v vVar7 = xVar._config;
                        b.g.a.c.i0.b bVar4 = (b.g.a.c.i0.b) j();
                        b.g.a.c.n<?> nVarE3 = null;
                        while (true) {
                            if (!bVar4.hasNext()) {
                                i_c2 = i_c3;
                                vVar4 = vVar7;
                                nVar3 = nVarH;
                                qVar3 = qVar4;
                                z10 = z13;
                                gVar4 = gVarC2;
                                break;
                            }
                            vVar4 = vVar7;
                            nVar3 = nVarH;
                            i_c2 = i_c3;
                            qVar3 = qVar4;
                            z10 = z13;
                            gVar4 = gVarC2;
                            nVarE3 = ((r) bVar4.next()).c(vVar7, gVar5, cVar, nVarH2, gVarC2, nVar3);
                            if (nVarE3 != null) {
                                break;
                            }
                            vVar7 = vVar4;
                            qVar4 = qVar3;
                            z13 = z10;
                            gVarC2 = gVar4;
                            nVarH = nVar3;
                            i_c3 = i_c2;
                        }
                        if (nVarE3 == null && (nVarE3 = e(xVar, gVar5, cVar6)) == null) {
                            Object objG = vVar4.e().g(qVar3.f);
                            v vVar8 = vVar4;
                            n$a n_aS2 = vVar8.s(Map.class, qVar3.f);
                            Set<String> setD2 = n_aS2 == null ? null : n_aS2.d();
                            b.g.a.c.c0.c cVar9 = qVar3.f;
                            b.g.a.c.b bVarE3 = vVar8.e();
                            q$a q_aA2 = bVarE3 == null ? null : bVarE3.A(vVar8, cVar9);
                            b.g.a.c.g0.u.t tVarS = b.g.a.c.g0.u.t.s(setD2, q_aA2 == null ? null : q_aA2._included, gVar5, z10, gVar4, nVarH2, nVar3, objG);
                            b.g.a.c.j jVar3 = tVarS._valueType;
                            p$b p_bD = d(xVar, cVar6, jVar3, Map.class);
                            p$a p_a5 = p_bD == null ? p_a4 : p_bD._contentInclusion;
                            if (p_a5 == p_a4 || p_a5 == p_a3) {
                                E = tVarS;
                                if (!xVar.D(w.WRITE_NULL_MAP_VALUES)) {
                                    E = tVarS.v(null, true);
                                }
                            } else {
                                int iOrdinal2 = p_a5.ordinal();
                                if (iOrdinal2 != 2) {
                                    if (iOrdinal2 == 3) {
                                        objT2 = b.g.a.c.g0.u.t.l;
                                    } else if (iOrdinal2 == 4) {
                                        objT2 = b.c.a.a0.d.t0(jVar3);
                                        if (objT2 != null && objT2.getClass().isArray()) {
                                            objT2 = b.c.a.a0.d.q0(objT2);
                                        }
                                    } else if (iOrdinal2 != 5) {
                                        zB3 = true;
                                        objT2 = null;
                                    } else {
                                        objT2 = xVar.A(null, p_bD._contentFilter);
                                        if (objT2 != null) {
                                            zB3 = xVar.B(objT2);
                                        }
                                    }
                                    zB3 = true;
                                } else if (jVar3.b()) {
                                    objT2 = b.g.a.c.g0.u.t.l;
                                    zB3 = true;
                                } else {
                                    zB3 = true;
                                    objT2 = null;
                                }
                                E = tVarS.v(objT2, zB3);
                            }
                        } else {
                            E = nVarE3;
                        }
                        if (this._factoryConfig.a()) {
                            b.g.a.c.i0.b bVar5 = (b.g.a.c.i0.b) this._factoryConfig.b();
                            while (bVar5.hasNext()) {
                                Objects.requireNonNull((g) bVar5.next());
                            }
                        }
                    }
                } else {
                    i_c2 = i_c3;
                    b.g.a.c.n<?> nVarF2 = null;
                    b.g.a.c.i0.b bVar6 = (b.g.a.c.i0.b) j();
                    while (bVar6.hasNext()) {
                        b.g.a.c.h0.f fVar2 = fVar;
                        nVarF2 = ((r) bVar6.next()).f(vVar6, fVar, cVar, nVarH2, gVarC2, nVarH);
                        if (nVarF2 != null) {
                            break;
                        }
                        fVar = fVar2;
                    }
                    if (nVarF2 == null) {
                        nVarE2 = e(xVar, jVar, cVar);
                    } else {
                        E = nVarF2;
                    }
                    if (E != 0 && this._factoryConfig.a()) {
                        E = nVarE2;
                        b.g.a.c.i0.b bVar7 = (b.g.a.c.i0.b) this._factoryConfig.b();
                        while (bVar7.hasNext()) {
                            Objects.requireNonNull((g) bVar7.next());
                        }
                    }
                }
                E = nVarE2;
                E = nVarE2;
                p_a = p_a4;
                p_a2 = p_a3;
                cls = cls5;
                cVar2 = cVar6;
                i_c = i_c2;
            } else {
                i$c i_c4 = i_c3;
                boolean z14 = z13;
                b.g.a.c.n<?> nVarE4 = null;
                if (jVar.u()) {
                    b.g.a.c.h0.d dVar = (b.g.a.c.h0.d) jVar;
                    if (dVar instanceof b.g.a.c.h0.e) {
                        b.g.a.c.h0.e eVar2 = (b.g.a.c.h0.e) dVar;
                        v vVar9 = xVar._config;
                        b.g.a.c.i0.b bVar8 = (b.g.a.c.i0.b) j();
                        while (true) {
                            if (!bVar8.hasNext()) {
                                p_a = p_a4;
                                p_a2 = p_a3;
                                cls = cls5;
                                cVar2 = cVar6;
                                i_c = i_c4;
                                break;
                            }
                            r rVar2 = (r) bVar8.next();
                            p_a = p_a4;
                            v vVar10 = vVar9;
                            p_a2 = p_a3;
                            i_c = i_c4;
                            v vVar11 = vVar9;
                            cls = cls5;
                            b.g.a.c.i0.b bVar9 = bVar8;
                            cVar2 = cVar6;
                            nVarE4 = rVar2.g(vVar10, eVar2, cVar, gVarC2, nVarH);
                            if (nVarE4 != null) {
                                break;
                            }
                            cls5 = cls;
                            cVar6 = cVar2;
                            p_a4 = p_a;
                            p_a3 = p_a2;
                            i_c4 = i_c;
                            vVar9 = vVar11;
                            bVar8 = bVar9;
                        }
                        if (nVarE4 != null || (nVarE4 = e(xVar, eVar2, cVar2)) != null) {
                            E = nVarE4;
                        } else if (cVar2.a(null).e() == i_c) {
                            E = 0;
                        } else {
                            Class<?> cls6 = eVar2._class;
                            if (EnumSet.class.isAssignableFrom(cls6)) {
                                b.g.a.c.j jVar4 = eVar2._elementType;
                                if (!(b.g.a.c.i0.d.q(jVar4._class) && jVar4._class != cls)) {
                                    jVar4 = null;
                                }
                                jVar2 = new b.g.a.c.g0.u.n(jVar4);
                            } else {
                                Class<?> cls7 = eVar2._elementType._class;
                                if (!RandomAccess.class.isAssignableFrom(cls6)) {
                                    z9 = z14;
                                    gVar3 = gVarC2;
                                    nVar2 = nVarH;
                                    if (cls7 == String.class && b.g.a.c.i0.d.s(nVar2)) {
                                        nVarE4 = b.g.a.c.g0.t.o.k;
                                    }
                                } else if (cls7 == String.class) {
                                    if (b.g.a.c.i0.d.s(nVarH)) {
                                        nVarE4 = b.g.a.c.g0.t.g.k;
                                    }
                                    z9 = z14;
                                    gVar3 = gVarC2;
                                    nVar2 = nVarH;
                                } else {
                                    z9 = z14;
                                    gVar3 = gVarC2;
                                    nVar2 = nVarH;
                                    nVarE4 = new b.g.a.c.g0.t.f(eVar2._elementType, z9, gVar3, nVar2);
                                }
                                if (nVarE4 == null) {
                                    jVar2 = new b.g.a.c.g0.u.j(eVar2._elementType, z9, gVar3, nVar2);
                                } else {
                                    E = nVarE4;
                                }
                            }
                            E = jVar2;
                        }
                        if (this._factoryConfig.a()) {
                            b.g.a.c.i0.b bVar10 = (b.g.a.c.i0.b) this._factoryConfig.b();
                            while (bVar10.hasNext()) {
                                Objects.requireNonNull((g) bVar10.next());
                            }
                        }
                    } else {
                        p_a = p_a4;
                        p_a2 = p_a3;
                        cls = cls5;
                        cVar2 = cVar6;
                        b.g.a.c.e0.g gVar6 = gVarC2;
                        b.g.a.c.n<Object> nVar4 = nVarH;
                        i_c = i_c4;
                        b.g.a.c.i0.b bVar11 = (b.g.a.c.i0.b) j();
                        b.g.a.c.n<?> nVarD = null;
                        while (bVar11.hasNext()) {
                            v vVar12 = vVar6;
                            b.g.a.c.n<Object> nVar5 = nVar4;
                            b.g.a.c.e0.g gVar7 = gVar6;
                            nVarD = ((r) bVar11.next()).d(vVar12, dVar, cVar, gVar6, nVar5);
                            if (nVarD != null) {
                                break;
                            }
                            vVar6 = vVar12;
                            gVar6 = gVar7;
                            nVar4 = nVar5;
                        }
                        if (nVarD == null) {
                            nVarE = e(xVar, jVar, cVar);
                        } else {
                            E = nVarD;
                        }
                        if (E != 0 && this._factoryConfig.a()) {
                            E = nVarE;
                            b.g.a.c.i0.b bVar12 = (b.g.a.c.i0.b) this._factoryConfig.b();
                            while (bVar12.hasNext()) {
                                Objects.requireNonNull((g) bVar12.next());
                            }
                        }
                    }
                } else {
                    p_a = p_a4;
                    p_a2 = p_a3;
                    cls = cls5;
                    cVar2 = cVar6;
                    boolean z15 = z14;
                    i_c = i_c4;
                    if (jVar instanceof b.g.a.c.h0.a) {
                        b.g.a.c.h0.a aVar = (b.g.a.c.h0.a) jVar;
                        v vVar13 = xVar._config;
                        b.g.a.c.i0.b bVar13 = (b.g.a.c.i0.b) j();
                        E = 0;
                        while (true) {
                            if (!bVar13.hasNext()) {
                                z8 = z15;
                                break;
                            }
                            v vVar14 = vVar13;
                            v vVar15 = vVar13;
                            z8 = z15;
                            E = ((r) bVar13.next()).e(vVar14, aVar, cVar, gVarC2, nVarH);
                            if (E != 0) {
                                break;
                            }
                            z15 = z8;
                            vVar13 = vVar15;
                            E = E;
                        }
                        if (E == 0) {
                            Class<?> cls8 = aVar._class;
                            if (nVarH == null || b.g.a.c.i0.d.s(nVarH)) {
                                E = E;
                                E = String[].class == cls8 ? b.g.a.c.g0.t.n.k : b.g.a.c.g0.u.i0.a.get(cls8.getName());
                            }
                            if (E == 0) {
                                E = new d0(aVar._componentType, z8, gVarC2, nVarH);
                            }
                        }
                        if (this._factoryConfig.a()) {
                            b.g.a.c.i0.b bVar14 = (b.g.a.c.i0.b) this._factoryConfig.b();
                            while (bVar14.hasNext()) {
                                Objects.requireNonNull((g) bVar14.next());
                            }
                        }
                    } else {
                        E = 0;
                    }
                }
            }
            if (E != 0) {
                return E;
            }
            i = 3;
            z11 = zG2;
        } else {
            p_a = p_a4;
            p_a2 = p_a3;
            i_c = i_c3;
            cls = cls5;
            cVar2 = cVar6;
            if (jVar.b()) {
                b.g.a.c.h0.i iVar = (b.g.a.c.h0.i) jVar;
                b.g.a.c.j jVar5 = iVar._referencedType;
                b.g.a.c.e0.g gVarC3 = (b.g.a.c.e0.g) jVar5._typeHandler;
                v vVar16 = xVar._config;
                if (gVarC3 == null) {
                    gVarC3 = c(vVar16, jVar5);
                }
                b.g.a.c.e0.g gVar8 = gVarC3;
                b.g.a.c.n<Object> nVar6 = (b.g.a.c.n) jVar5._valueHandler;
                b.g.a.c.i0.b bVar15 = (b.g.a.c.i0.b) j();
                while (true) {
                    if (bVar15.hasNext()) {
                        b.g.a.c.n<Object> nVar7 = nVar6;
                        b.g.a.c.e0.g gVar9 = gVar8;
                        v vVar17 = vVar16;
                        nVarA = ((r) bVar15.next()).a(vVar16, iVar, cVar, gVar8, nVar7);
                        if (nVarA == null) {
                            nVar6 = nVar7;
                            gVar8 = gVar9;
                            vVar16 = vVar17;
                        }
                    } else {
                        b.g.a.c.n<Object> nVar8 = nVar6;
                        b.g.a.c.e0.g gVar10 = gVar8;
                        if (iVar.B(AtomicReference.class)) {
                            b.g.a.c.j jVar6 = iVar._referencedType;
                            p$b p_bD2 = d(xVar, cVar2, jVar6, AtomicReference.class);
                            p$a p_a6 = p_bD2 == null ? p_a : p_bD2._contentInclusion;
                            if (p_a6 == p_a || p_a6 == p_a2) {
                                i2 = 3;
                                objT0 = null;
                                zB = false;
                            } else {
                                int iOrdinal3 = p_a6.ordinal();
                                if (iOrdinal3 != 2) {
                                    i2 = 3;
                                    if (iOrdinal3 == 3) {
                                        objT0 = b.g.a.c.g0.u.t.l;
                                    } else if (iOrdinal3 == 4) {
                                        objT0 = b.c.a.a0.d.t0(jVar6);
                                        if (objT0 != null && objT0.getClass().isArray()) {
                                            objT0 = b.c.a.a0.d.q0(objT0);
                                        }
                                    } else if (iOrdinal3 != 5) {
                                        objT0 = null;
                                    } else {
                                        objT0 = xVar.A(null, p_bD2._contentFilter);
                                        if (objT0 != null) {
                                            zB = xVar.B(objT0);
                                        }
                                    }
                                    zB = true;
                                } else {
                                    i2 = 3;
                                    if (jVar6.b()) {
                                        objT0 = b.g.a.c.g0.u.t.l;
                                    } else {
                                        objT0 = null;
                                    }
                                    zB = true;
                                }
                            }
                            f0<AtomicReference<?>> f0VarT = new b.g.a.c.g0.u.c(iVar, z11, gVar10, nVar8).t(objT0, zB);
                            i = i2;
                            E = f0VarT;
                            break;
                        }
                        nVarA = null;
                    }
                    i = 3;
                    E = nVarA;
                    break;
                }
            }
            i = 3;
            b.g.a.c.i0.b bVar16 = (b.g.a.c.i0.b) j();
            b.g.a.c.n<?> nVarB = null;
            while (bVar16.hasNext() && (nVarB = ((r) bVar16.next()).b(vVar5, jVar, cVar2)) == null) {
            }
            E = nVarB;
            if (E == 0) {
                E = e(xVar, jVar, cVar);
            }
        }
        if (E == 0) {
            String name = jVar._class.getName();
            b.g.a.c.n<?> nVar9 = b.j.get(name);
            if (nVar9 != null || (cls4 = b.k.get(name)) == null) {
                E = nVar9;
                i3 = 0;
            } else {
                i3 = 0;
                nVar = (b.g.a.c.n) b.g.a.c.i0.d.g(cls4, false);
            }
            if (E == 0) {
                if (jVar.w()) {
                    v vVar18 = xVar._config;
                    i$d i_dA = cVar2.a(null);
                    if (i_dA.e() == i_c) {
                        E = nVar;
                        Iterator<b.g.a.c.c0.s> it4 = ((b.g.a.c.c0.q) cVar2).d().iterator();
                        while (it4.hasNext()) {
                            if (it4.next().p().equals("declaringClass")) {
                                it4.remove();
                                break;
                            }
                        }
                        mVar = null;
                    } else {
                        Class<?> cls9 = jVar._class;
                        int i7 = b.g.a.c.g0.u.m.k;
                        b.g.a.c.g0.u.m mVar2 = new b.g.a.c.g0.u.m(b.g.a.c.i0.f.a(vVar18, cls9), b.g.a.c.g0.u.m.p(cls9, i_dA, true, null));
                        if (this._factoryConfig.a()) {
                            E = nVar;
                            b.g.a.c.i0.b bVar17 = (b.g.a.c.i0.b) this._factoryConfig.b();
                            while (bVar17.hasNext()) {
                                Objects.requireNonNull((g) bVar17.next());
                            }
                        }
                        E = nVar;
                        mVar = mVar2;
                    }
                    c = 1;
                    E = mVar;
                } else {
                    c = 1;
                    Class<?> cls10 = jVar._class;
                    ?? A = b.g.a.c.b0.f.l.a(xVar._config, jVar, cVar2);
                    if (A != 0) {
                        E = nVar;
                        E = A;
                    } else if (Calendar.class.isAssignableFrom(cls10)) {
                        hVar = b.g.a.c.g0.u.h.k;
                    } else if (Date.class.isAssignableFrom(cls10)) {
                        kVar = b.g.a.c.g0.u.k.k;
                    } else if (Map$Entry.class.isAssignableFrom(cls10)) {
                        b.g.a.c.j jVarI = jVar.i(Map$Entry.class);
                        b.g.a.c.j jVarH = jVarI.h(i3);
                        b.g.a.c.j jVarH2 = jVarI.h(1);
                        i$d i_dI = xVar._config.i(Map$Entry.class);
                        i$d i_dA2 = cVar2.a(null);
                        if (i_dA2 != null) {
                            E = nVar;
                            i_dI = i_dA2.k(i_dI);
                        }
                        E = nVar;
                        if (i_dI.e() == i_c) {
                            A = 0;
                        } else {
                            A = new b.g.a.c.g0.t.i(jVarH2, jVarH, jVarH2, z11, c(xVar._config, jVarH2), null);
                            b.g.a.c.j jVar7 = A._valueType;
                            p$b p_bD3 = d(xVar, cVar2, jVar7, Map$Entry.class);
                            p$a p_a7 = p_bD3 == null ? p_a : p_bD3._contentInclusion;
                            if (p_a7 != p_a && p_a7 != p_a2) {
                                int iOrdinal4 = p_a7.ordinal();
                                if (iOrdinal4 != 2) {
                                    if (iOrdinal4 == i) {
                                        objT1 = b.g.a.c.g0.u.t.l;
                                    } else if (iOrdinal4 == 4) {
                                        objT1 = b.c.a.a0.d.t0(jVar7);
                                        if (objT1 != null && objT1.getClass().isArray()) {
                                            objT1 = b.c.a.a0.d.q0(objT1);
                                        }
                                    } else if (iOrdinal4 != 5) {
                                        objT1 = null;
                                    } else {
                                        objT1 = xVar.A(null, p_bD3._contentFilter);
                                        if (objT1 != null) {
                                            zB2 = xVar.B(objT1);
                                        }
                                    }
                                    zB2 = true;
                                } else {
                                    if (jVar7.b()) {
                                        objT1 = b.g.a.c.g0.u.t.l;
                                    } else {
                                        objT1 = null;
                                    }
                                    zB2 = true;
                                }
                                if (A._suppressableValue != objT1 || A._suppressNulls != zB2) {
                                    A = new b.g.a.c.g0.t.i(A, A._keySerializer, A._valueSerializer, objT1, zB2);
                                }
                            }
                        }
                        E = nVar;
                        E = A;
                    } else if (ByteBuffer.class.isAssignableFrom(cls10)) {
                        gVar = new b.g.a.c.g0.u.g();
                    } else if (InetAddress.class.isAssignableFrom(cls10)) {
                        pVar = new b.g.a.c.g0.u.p();
                    } else if (InetSocketAddress.class.isAssignableFrom(cls10)) {
                        qVar = new b.g.a.c.g0.u.q();
                    } else if (TimeZone.class.isAssignableFrom(cls10)) {
                        s0Var = new s0();
                    } else if (Charset.class.isAssignableFrom(cls10)) {
                        t0Var2 = t0.k;
                    } else if (!Number.class.isAssignableFrom(cls10) || (iOrdinal = cVar2.a(null).e().ordinal()) == i || iOrdinal == 4) {
                        E = nVar;
                        E = nVar;
                        E = nVar;
                        E = 0;
                    } else if (iOrdinal != 8) {
                        vVar = b.g.a.c.g0.u.v.k;
                    } else {
                        t0Var = t0.k;
                    }
                }
                if (E == 0) {
                    E = nVar;
                    E = t0Var;
                    E = nVar;
                    E = vVar;
                    E = nVar;
                    E = t0Var2;
                    E = nVar;
                    E = s0Var;
                    E = nVar;
                    E = qVar;
                    E = nVar;
                    E = pVar;
                    E = nVar;
                    E = gVar;
                    E = nVar;
                    E = kVar;
                    E = nVar;
                    E = hVar;
                    Class<?> cls11 = jVar._class;
                    Annotation[] annotationArr = b.g.a.c.i0.d.a;
                    if (cls11.isAnnotation()) {
                        str = "annotation";
                    } else if (cls11.isArray()) {
                        str = "array";
                    } else if (cls.isAssignableFrom(cls11)) {
                        str = "enum";
                    } else {
                        str = cls11.isPrimitive() ? "primitive" : null;
                    }
                    if (str == null) {
                        String name2 = cls11.getName();
                        if (name2.startsWith("net.sf.cglib.proxy.") || name2.startsWith("org.hibernate.proxy.")) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                    } else {
                        z3 = false;
                    }
                    if (z3 || b.g.a.c.i0.d.q(jVar._class)) {
                        if (cVar2.a._class == Object.class) {
                            nVarX = xVar.x(Object.class);
                        } else {
                            Class<?> cls12 = jVar._class;
                            if (cls12.getName().startsWith("java.time.")) {
                                str3 = "Java 8 date/time";
                                str4 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310";
                            } else {
                                if (cls12.getName().startsWith("org.joda.time.")) {
                                    str3 = "Joda date/time";
                                    str4 = "com.fasterxml.jackson.datatype:jackson-datatype-joda";
                                } else {
                                    str2 = null;
                                }
                                if (str2 == null && xVar._config.a(jVar._class) == null) {
                                    rVar = new b.g.a.c.g0.t.r(jVar, str2);
                                } else {
                                    rVar = null;
                                }
                                if (rVar != null) {
                                    E = rVar;
                                } else {
                                    vVar2 = xVar._config;
                                    eVar = new e(cVar2);
                                    eVar.c = vVar2;
                                    qVar2 = (b.g.a.c.c0.q) cVar2;
                                    listD = qVar2.d();
                                    vVar3 = xVar._config;
                                    bVarE = vVar3.e();
                                    map = new HashMap();
                                    it = listD.iterator();
                                    while (it.hasNext()) {
                                        next2 = it.next();
                                        if (next2.j() == null) {
                                            it.remove();
                                        } else {
                                            clsR = next2.r();
                                            boolC0 = (Boolean) map.get(clsR);
                                            if (boolC0 == null) {
                                                vVar3.f(clsR);
                                                boolC0 = bVarE.c0(((b.g.a.c.c0.q) vVar3.o(clsR)).f);
                                                if (boolC0 == null) {
                                                    boolC0 = Boolean.FALSE;
                                                }
                                                map.put(clsR, boolC0);
                                            }
                                            if (boolC0.booleanValue()) {
                                                it.remove();
                                            }
                                        }
                                    }
                                    if (vVar3.q(b.g.a.c.p.REQUIRE_SETTERS_FOR_GETTERS)) {
                                        it3 = listD.iterator();
                                        while (it3.hasNext()) {
                                            next = it3.next();
                                            if (next.f() && !next.u()) {
                                                it3.remove();
                                            }
                                        }
                                    }
                                    if (listD.isEmpty()) {
                                        arrayList2 = null;
                                        z4 = z11;
                                    } else {
                                        zG = g(vVar3, cVar2, null);
                                        lVar = new l(vVar3, cVar2);
                                        arrayList = new ArrayList(listD.size());
                                        for (b.g.a.c.c0.s sVar : listD) {
                                            iVarJ = sVar.j();
                                            if (sVar.v()) {
                                                b_aH = sVar.h();
                                                if (b_aH == null) {
                                                    if (b_aH.a == 2) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    if (z5) {
                                                        arrayList3 = arrayList;
                                                    } else if (iVarJ instanceof b.g.a.c.c0.j) {
                                                        arrayList3 = arrayList;
                                                        arrayList3.add(h(xVar, sVar, lVar, zG, (b.g.a.c.c0.j) iVarJ));
                                                    } else {
                                                        arrayList3 = arrayList;
                                                        arrayList3.add(h(xVar, sVar, lVar, zG, (b.g.a.c.c0.g) iVarJ));
                                                    }
                                                } else if (iVarJ instanceof b.g.a.c.c0.j) {
                                                    arrayList3 = arrayList;
                                                    arrayList3.add(h(xVar, sVar, lVar, zG, (b.g.a.c.c0.j) iVarJ));
                                                } else {
                                                    arrayList3 = arrayList;
                                                    arrayList3.add(h(xVar, sVar, lVar, zG, (b.g.a.c.c0.g) iVarJ));
                                                }
                                                arrayList = arrayList3;
                                                z11 = z11;
                                            } else if (iVarJ == null) {
                                                continue;
                                            } else {
                                                if (eVar.h == null) {
                                                    StringBuilder sbU = b.d.b.a.a.U("Multiple type ids specified with ");
                                                    sbU.append(eVar.h);
                                                    sbU.append(" and ");
                                                    sbU.append(iVarJ);
                                                    throw new IllegalArgumentException(sbU.toString());
                                                }
                                                eVar.h = iVarJ;
                                            }
                                        }
                                        z4 = z11;
                                        arrayList2 = arrayList;
                                    }
                                    if (arrayList2 == null) {
                                        arrayList2 = new ArrayList();
                                    } else {
                                        size = arrayList2.size();
                                        for (i4 = 0; i4 < size; i4++) {
                                            c cVar10 = (c) arrayList2.get(i4);
                                            gVar2 = cVar10._typeSerializer;
                                            if (gVar2 == null && gVar2.c() == c0$a.EXTERNAL_PROPERTY) {
                                                t tVarA = t.a(gVar2.b());
                                                for (c cVar11 : arrayList2) {
                                                    if (cVar11 != cVar10) {
                                                        t tVar = cVar11._wrapperName;
                                                        if (tVar != null) {
                                                            zEquals = tVar.equals(tVarA);
                                                        } else if (!tVarA._simpleName.equals(cVar11._name._value)) {
                                                            zEquals = false;
                                                        } else if (tVarA._namespace != null) {
                                                            zEquals = false;
                                                        } else {
                                                            zEquals = true;
                                                        }
                                                        if (zEquals) {
                                                            cVar10._typeSerializer = null;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    xVar.v().a(vVar2, qVar2.f, arrayList2);
                                    if (this._factoryConfig.a()) {
                                        bVar3 = (b.g.a.c.i0.b) this._factoryConfig.b();
                                        while (bVar3.hasNext()) {
                                            Objects.requireNonNull((g) bVar3.next());
                                        }
                                    }
                                    n_aS = vVar2.s(cVar2.a._class, qVar2.f);
                                    if (n_aS != null) {
                                        setD = n_aS.d();
                                    } else {
                                        setD = null;
                                    }
                                    Class<?> cls13 = cVar2.a._class;
                                    cVar3 = qVar2.f;
                                    bVarE2 = vVar2.e();
                                    if (bVarE2 == null) {
                                        q_aA = null;
                                    } else {
                                        q_aA = bVarE2.A(vVar2, cVar3);
                                    }
                                    if (q_aA != null) {
                                        set = q_aA._included;
                                    } else {
                                        set = null;
                                    }
                                    if (set == null || (setD != null && !setD.isEmpty())) {
                                        it2 = arrayList2.iterator();
                                        while (it2.hasNext()) {
                                            if (b.c.a.a0.d.b2(((c) it2.next())._name._value, setD, set)) {
                                                it2.remove();
                                            }
                                        }
                                    }
                                    if (this._factoryConfig.a()) {
                                        bVar2 = (b.g.a.c.i0.b) this._factoryConfig.b();
                                        while (bVar2.hasNext()) {
                                            Objects.requireNonNull((g) bVar2.next());
                                        }
                                    }
                                    a0Var = qVar2.j;
                                    if (a0Var == null) {
                                        jVarA = null;
                                    } else {
                                        cls2 = a0Var.c;
                                        if (cls2 == l0.class) {
                                            str5 = a0Var.f681b._simpleName;
                                            size2 = arrayList2.size();
                                            i5 = 0;
                                            while (true) {
                                                if (i5 == size2) {
                                                    Object[] objArr = new Object[2];
                                                    objArr[0] = b.g.a.c.i0.d.n(cVar2.a);
                                                    if (str5 == null) {
                                                        strC = "[null]";
                                                    } else {
                                                        strC = b.g.a.c.i0.d.c(str5);
                                                    }
                                                    objArr[1] = strC;
                                                    throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr));
                                                }
                                                cVar4 = (c) arrayList2.get(i5);
                                                if (str5.equals(cVar4._name._value)) {
                                                    if (i5 > 0) {
                                                        arrayList2.remove(i5);
                                                        arrayList2.add(0, cVar4);
                                                    }
                                                    jVarA = b.g.a.c.g0.t.j.a(cVar4._declaredType, null, new b.g.a.c.g0.t.k(a0Var, cVar4), a0Var.f);
                                                    break;
                                                }
                                                i5++;
                                            }
                                        } else {
                                            jVarA = b.g.a.c.g0.t.j.a(xVar.d().i(xVar.b(cls2), i0.class)[0], a0Var.f681b, xVar.e(qVar2.f, a0Var), a0Var.f);
                                        }
                                    }
                                    eVar.i = jVarA;
                                    eVar.d = arrayList2;
                                    eVar.g = vVar2.e().g(qVar2.f);
                                    b0Var = qVar2.c;
                                    if (b0Var == null) {
                                        first = null;
                                    } else {
                                        if (!b0Var.i) {
                                            b0Var.h();
                                        }
                                        linkedList = b0Var.m;
                                        if (linkedList != null) {
                                            first = null;
                                        } else {
                                            if (linkedList.size() <= 1) {
                                                b0Var.i("Multiple 'any-getter' methods defined (%s vs %s)", b0Var.m.get(0), b0Var.m.get(1));
                                                throw null;
                                            }
                                            first = b0Var.m.getFirst();
                                        }
                                        if (first != null) {
                                            b0Var2 = qVar2.c;
                                            if (!b0Var2.i) {
                                                b0Var2.h();
                                            }
                                            linkedList2 = b0Var2.n;
                                            if (linkedList2 != null) {
                                                first = null;
                                            } else {
                                                if (linkedList2.size() <= 1) {
                                                    b0Var2.i("Multiple 'any-getter' fields defined (%s vs %s)", b0Var2.n.get(0), b0Var2.n.get(1));
                                                    throw null;
                                                }
                                                first = b0Var2.n.getFirst();
                                            }
                                            if (first != null) {
                                                first = null;
                                            } else if (!Map.class.isAssignableFrom(first.d())) {
                                                throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", first.c()));
                                            }
                                        } else if (!Map.class.isAssignableFrom(first.d())) {
                                            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", first.c()));
                                        }
                                    }
                                    if (first != null) {
                                        jVarE = first.e();
                                        b.g.a.c.j jVarK3 = jVarE.k();
                                        gVarC = c(vVar2, jVarK3);
                                        nVarF = f(xVar, first);
                                        if (nVarF == null) {
                                            nVarF = b.g.a.c.g0.u.t.s(null, null, jVarE, vVar2.q(b.g.a.c.p.USE_STATIC_TYPING), gVarC, null, null, null);
                                        }
                                        eVar.f = new a(new d$a(t.a(first.c()), jVarK3, null, first, b.g.a.c.s.k), first, nVarF);
                                    }
                                    list = eVar.d;
                                    zQ = vVar2.q(b.g.a.c.p.DEFAULT_VIEW_INCLUSION);
                                    size3 = list.size();
                                    cVarArr = new c[size3];
                                    i6 = 0;
                                    int i8 = 0;
                                    while (i6 < size3) {
                                        cVar5 = list.get(i6);
                                        clsArr = cVar5._includeInViews;
                                        if (clsArr != null || clsArr.length == 0) {
                                            list2 = list;
                                            if (zQ) {
                                                cVarArr[i6] = cVar5;
                                            }
                                        } else {
                                            i8++;
                                            list2 = list;
                                            cVarArr[i6] = clsArr.length == 1 ? new b.g.a.c.g0.t.e(cVar5, clsArr[0]) : new b.g.a.c.g0.t.d(cVar5, clsArr);
                                        }
                                        i6++;
                                        list = list2;
                                    }
                                    if (zQ || i8 != 0) {
                                        if (size3 != eVar.d.size()) {
                                            throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", Integer.valueOf(size3), Integer.valueOf(eVar.d.size())));
                                        }
                                        eVar.e = cVarArr;
                                    }
                                    if (this._factoryConfig.a()) {
                                        bVar = (b.g.a.c.i0.b) this._factoryConfig.b();
                                        while (bVar.hasNext()) {
                                            Objects.requireNonNull((g) bVar.next());
                                        }
                                    }
                                    try {
                                        E = eVar.a();
                                        if (E == 0) {
                                            if (jVar.A()) {
                                                E = new d(eVar.f701b.a, eVar, b.g.a.c.g0.u.d.k, null);
                                            } else {
                                                cls3 = jVar._class;
                                                if (Iterator.class.isAssignableFrom(cls3)) {
                                                    jVarArrI2 = vVar2._base._typeFactory.i(jVar, Iterator.class);
                                                    if (jVarArrI2 == null && jVarArrI2.length == 1) {
                                                        jVarK2 = jVarArrI2[0];
                                                    } else {
                                                        jVarK2 = b.g.a.c.h0.n.k();
                                                    }
                                                    E = new b.g.a.c.g0.t.h(jVarK2, z4, c(vVar2, jVarK2));
                                                } else {
                                                    z6 = z4;
                                                    if (Iterable.class.isAssignableFrom(cls3)) {
                                                        jVarArrI = vVar2._base._typeFactory.i(jVar, Iterable.class);
                                                        if (jVarArrI == null && jVarArrI.length == 1) {
                                                            jVarK = jVarArrI[0];
                                                        } else {
                                                            jVarK = b.g.a.c.h0.n.k();
                                                        }
                                                        E = new b.g.a.c.g0.u.r(jVarK, z6, c(vVar2, jVarK));
                                                    } else {
                                                        if (CharSequence.class.isAssignableFrom(cls3)) {
                                                            t0Var3 = t0.k;
                                                        } else {
                                                            t0Var3 = null;
                                                        }
                                                        E = t0Var3;
                                                    }
                                                }
                                                if (E == 0) {
                                                    if (qVar2.f.t.size() > 0) {
                                                        z7 = true;
                                                    } else {
                                                        z7 = false;
                                                    }
                                                    if (z7) {
                                                        E = new d(eVar.f701b.a, eVar, b.g.a.c.g0.u.d.k, null);
                                                    }
                                                }
                                            }
                                        }
                                    } catch (RuntimeException e) {
                                        xVar.F(cVar2, "Failed to construct BeanSerializer for %s: (%s) %s", cVar2.a, e.getClass().getName(), e.getMessage());
                                        throw null;
                                    }
                                }
                            }
                            Object[] objArr2 = new Object[i];
                            objArr2[i3] = str3;
                            objArr2[c] = b.g.a.c.i0.d.n(jVar);
                            objArr2[2] = str4;
                            str2 = String.format("%s type %s not supported by default: add Module \"%s\" to enable handling", objArr2);
                            if (str2 == null) {
                                rVar = null;
                            } else {
                                rVar = null;
                            }
                            if (rVar != null) {
                                E = rVar;
                            } else {
                                vVar2 = xVar._config;
                                eVar = new e(cVar2);
                                eVar.c = vVar2;
                                qVar2 = (b.g.a.c.c0.q) cVar2;
                                listD = qVar2.d();
                                vVar3 = xVar._config;
                                bVarE = vVar3.e();
                                map = new HashMap();
                                it = listD.iterator();
                                while (it.hasNext()) {
                                    next2 = it.next();
                                    if (next2.j() == null) {
                                        it.remove();
                                    } else {
                                        clsR = next2.r();
                                        boolC0 = (Boolean) map.get(clsR);
                                        if (boolC0 == null) {
                                            vVar3.f(clsR);
                                            boolC0 = bVarE.c0(((b.g.a.c.c0.q) vVar3.o(clsR)).f);
                                            if (boolC0 == null) {
                                                boolC0 = Boolean.FALSE;
                                            }
                                            map.put(clsR, boolC0);
                                        }
                                        if (boolC0.booleanValue()) {
                                            it.remove();
                                        }
                                    }
                                }
                                if (vVar3.q(b.g.a.c.p.REQUIRE_SETTERS_FOR_GETTERS)) {
                                    it3 = listD.iterator();
                                    while (it3.hasNext()) {
                                        next = it3.next();
                                        if (next.f()) {
                                        }
                                    }
                                }
                                if (listD.isEmpty()) {
                                    arrayList2 = null;
                                    z4 = z11;
                                } else {
                                    zG = g(vVar3, cVar2, null);
                                    lVar = new l(vVar3, cVar2);
                                    arrayList = new ArrayList(listD.size());
                                    while (r16.hasNext()) {
                                        iVarJ = sVar.j();
                                        if (sVar.v()) {
                                            b_aH = sVar.h();
                                            if (b_aH == null) {
                                                if (b_aH.a == 2) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                if (z5) {
                                                    arrayList3 = arrayList;
                                                } else if (iVarJ instanceof b.g.a.c.c0.j) {
                                                    arrayList3 = arrayList;
                                                    arrayList3.add(h(xVar, sVar, lVar, zG, (b.g.a.c.c0.j) iVarJ));
                                                } else {
                                                    arrayList3 = arrayList;
                                                    arrayList3.add(h(xVar, sVar, lVar, zG, (b.g.a.c.c0.g) iVarJ));
                                                }
                                            } else if (iVarJ instanceof b.g.a.c.c0.j) {
                                                arrayList3 = arrayList;
                                                arrayList3.add(h(xVar, sVar, lVar, zG, (b.g.a.c.c0.j) iVarJ));
                                            } else {
                                                arrayList3 = arrayList;
                                                arrayList3.add(h(xVar, sVar, lVar, zG, (b.g.a.c.c0.g) iVarJ));
                                            }
                                            arrayList = arrayList3;
                                            z11 = z11;
                                        } else if (iVarJ == null) {
                                            continue;
                                        } else {
                                            if (eVar.h == null) {
                                                StringBuilder sbU2 = b.d.b.a.a.U("Multiple type ids specified with ");
                                                sbU2.append(eVar.h);
                                                sbU2.append(" and ");
                                                sbU2.append(iVarJ);
                                                throw new IllegalArgumentException(sbU2.toString());
                                            }
                                            eVar.h = iVarJ;
                                        }
                                    }
                                    z4 = z11;
                                    arrayList2 = arrayList;
                                }
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                } else {
                                    size = arrayList2.size();
                                    while (i4 < size) {
                                        c cVar12 = (c) arrayList2.get(i4);
                                        gVar2 = cVar12._typeSerializer;
                                        if (gVar2 == null) {
                                        }
                                    }
                                }
                                xVar.v().a(vVar2, qVar2.f, arrayList2);
                                if (this._factoryConfig.a()) {
                                    bVar3 = (b.g.a.c.i0.b) this._factoryConfig.b();
                                    while (bVar3.hasNext()) {
                                        Objects.requireNonNull((g) bVar3.next());
                                    }
                                }
                                n_aS = vVar2.s(cVar2.a._class, qVar2.f);
                                if (n_aS != null) {
                                    setD = n_aS.d();
                                } else {
                                    setD = null;
                                }
                                Class<?> cls14 = cVar2.a._class;
                                cVar3 = qVar2.f;
                                bVarE2 = vVar2.e();
                                if (bVarE2 == null) {
                                    q_aA = null;
                                } else {
                                    q_aA = bVarE2.A(vVar2, cVar3);
                                }
                                if (q_aA != null) {
                                    set = q_aA._included;
                                } else {
                                    set = null;
                                }
                                if (set == null) {
                                    it2 = arrayList2.iterator();
                                    while (it2.hasNext()) {
                                        if (b.c.a.a0.d.b2(((c) it2.next())._name._value, setD, set)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    it2 = arrayList2.iterator();
                                    while (it2.hasNext()) {
                                        if (b.c.a.a0.d.b2(((c) it2.next())._name._value, setD, set)) {
                                            it2.remove();
                                        }
                                    }
                                }
                                if (this._factoryConfig.a()) {
                                    bVar2 = (b.g.a.c.i0.b) this._factoryConfig.b();
                                    while (bVar2.hasNext()) {
                                        Objects.requireNonNull((g) bVar2.next());
                                    }
                                }
                                a0Var = qVar2.j;
                                if (a0Var == null) {
                                    jVarA = null;
                                } else {
                                    cls2 = a0Var.c;
                                    if (cls2 == l0.class) {
                                        str5 = a0Var.f681b._simpleName;
                                        size2 = arrayList2.size();
                                        i5 = 0;
                                        while (true) {
                                            if (i5 == size2) {
                                                Object[] objArr3 = new Object[2];
                                                objArr3[0] = b.g.a.c.i0.d.n(cVar2.a);
                                                if (str5 == null) {
                                                    strC = "[null]";
                                                } else {
                                                    strC = b.g.a.c.i0.d.c(str5);
                                                }
                                                objArr3[1] = strC;
                                                throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr3));
                                            }
                                            cVar4 = (c) arrayList2.get(i5);
                                            if (str5.equals(cVar4._name._value)) {
                                                if (i5 > 0) {
                                                    arrayList2.remove(i5);
                                                    arrayList2.add(0, cVar4);
                                                }
                                                jVarA = b.g.a.c.g0.t.j.a(cVar4._declaredType, null, new b.g.a.c.g0.t.k(a0Var, cVar4), a0Var.f);
                                                break;
                                            }
                                            i5++;
                                        }
                                    } else {
                                        jVarA = b.g.a.c.g0.t.j.a(xVar.d().i(xVar.b(cls2), i0.class)[0], a0Var.f681b, xVar.e(qVar2.f, a0Var), a0Var.f);
                                    }
                                }
                                eVar.i = jVarA;
                                eVar.d = arrayList2;
                                eVar.g = vVar2.e().g(qVar2.f);
                                b0Var = qVar2.c;
                                if (b0Var == null) {
                                    first = null;
                                } else {
                                    if (!b0Var.i) {
                                        b0Var.h();
                                    }
                                    linkedList = b0Var.m;
                                    if (linkedList != null) {
                                        first = null;
                                    } else {
                                        if (linkedList.size() <= 1) {
                                            b0Var.i("Multiple 'any-getter' methods defined (%s vs %s)", b0Var.m.get(0), b0Var.m.get(1));
                                            throw null;
                                        }
                                        first = b0Var.m.getFirst();
                                    }
                                    if (first != null) {
                                        b0Var2 = qVar2.c;
                                        if (!b0Var2.i) {
                                            b0Var2.h();
                                        }
                                        linkedList2 = b0Var2.n;
                                        if (linkedList2 != null) {
                                            first = null;
                                        } else {
                                            if (linkedList2.size() <= 1) {
                                                b0Var2.i("Multiple 'any-getter' fields defined (%s vs %s)", b0Var2.n.get(0), b0Var2.n.get(1));
                                                throw null;
                                            }
                                            first = b0Var2.n.getFirst();
                                        }
                                        if (first != null) {
                                            first = null;
                                        } else if (!Map.class.isAssignableFrom(first.d())) {
                                            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", first.c()));
                                        }
                                    } else if (!Map.class.isAssignableFrom(first.d())) {
                                        throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", first.c()));
                                    }
                                }
                                if (first != null) {
                                    jVarE = first.e();
                                    b.g.a.c.j jVarK4 = jVarE.k();
                                    gVarC = c(vVar2, jVarK4);
                                    nVarF = f(xVar, first);
                                    if (nVarF == null) {
                                        nVarF = b.g.a.c.g0.u.t.s(null, null, jVarE, vVar2.q(b.g.a.c.p.USE_STATIC_TYPING), gVarC, null, null, null);
                                    }
                                    eVar.f = new a(new d$a(t.a(first.c()), jVarK4, null, first, b.g.a.c.s.k), first, nVarF);
                                }
                                list = eVar.d;
                                zQ = vVar2.q(b.g.a.c.p.DEFAULT_VIEW_INCLUSION);
                                size3 = list.size();
                                cVarArr = new c[size3];
                                i6 = 0;
                                int i9 = 0;
                                while (i6 < size3) {
                                    cVar5 = list.get(i6);
                                    clsArr = cVar5._includeInViews;
                                    if (clsArr != null) {
                                        list2 = list;
                                        if (zQ) {
                                            cVarArr[i6] = cVar5;
                                        }
                                    } else {
                                        list2 = list;
                                        if (zQ) {
                                            cVarArr[i6] = cVar5;
                                        }
                                    }
                                    i6++;
                                    list = list2;
                                }
                                if (zQ) {
                                    if (size3 != eVar.d.size()) {
                                        throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", Integer.valueOf(size3), Integer.valueOf(eVar.d.size())));
                                    }
                                    eVar.e = cVarArr;
                                } else {
                                    if (size3 != eVar.d.size()) {
                                        throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", Integer.valueOf(size3), Integer.valueOf(eVar.d.size())));
                                    }
                                    eVar.e = cVarArr;
                                }
                                if (this._factoryConfig.a()) {
                                    bVar = (b.g.a.c.i0.b) this._factoryConfig.b();
                                    while (bVar.hasNext()) {
                                        Objects.requireNonNull((g) bVar.next());
                                    }
                                }
                                E = eVar.a();
                                if (E == 0) {
                                    if (jVar.A()) {
                                        E = new d(eVar.f701b.a, eVar, b.g.a.c.g0.u.d.k, null);
                                    } else {
                                        cls3 = jVar._class;
                                        if (Iterator.class.isAssignableFrom(cls3)) {
                                            jVarArrI2 = vVar2._base._typeFactory.i(jVar, Iterator.class);
                                            if (jVarArrI2 == null) {
                                                jVarK2 = b.g.a.c.h0.n.k();
                                            } else {
                                                jVarK2 = b.g.a.c.h0.n.k();
                                            }
                                            E = new b.g.a.c.g0.t.h(jVarK2, z4, c(vVar2, jVarK2));
                                        } else {
                                            z6 = z4;
                                            if (Iterable.class.isAssignableFrom(cls3)) {
                                                jVarArrI = vVar2._base._typeFactory.i(jVar, Iterable.class);
                                                if (jVarArrI == null) {
                                                    jVarK = b.g.a.c.h0.n.k();
                                                } else {
                                                    jVarK = b.g.a.c.h0.n.k();
                                                }
                                                E = new b.g.a.c.g0.u.r(jVarK, z6, c(vVar2, jVarK));
                                            } else {
                                                if (CharSequence.class.isAssignableFrom(cls3)) {
                                                    t0Var3 = t0.k;
                                                } else {
                                                    t0Var3 = null;
                                                }
                                                E = t0Var3;
                                            }
                                        }
                                        if (E == 0) {
                                            if (qVar2.f.t.size() > 0) {
                                                z7 = true;
                                            } else {
                                                z7 = false;
                                            }
                                            if (z7) {
                                                E = new d(eVar.f701b.a, eVar, b.g.a.c.g0.u.d.k, null);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (E == 0) {
                            E = xVar.x(cVar2.a._class);
                        }
                    } else {
                        nVarX = null;
                    }
                    E = nVarX;
                    if (E == 0) {
                        E = xVar.x(cVar2.a._class);
                    }
                }
            }
        }
        if (E != 0 && this._factoryConfig.a()) {
            b.g.a.c.i0.b bVar18 = (b.g.a.c.i0.b) this._factoryConfig.b();
            while (bVar18.hasNext()) {
                Objects.requireNonNull((g) bVar18.next());
            }
        }
        return E;
    }

    public Iterable<r> j() {
        return new b.g.a.c.i0.b(this._factoryConfig._additionalSerializers);
    }
}
