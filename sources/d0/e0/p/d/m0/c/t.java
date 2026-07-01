package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.o.g$a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/* JADX INFO: compiled from: DescriptorVisibilities.java */
/* JADX INFO: loaded from: classes3.dex */
public class t {
    public static final u a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f3300b;
    public static final u c;
    public static final u d;
    public static final u e;
    public static final u f;
    public static final u g;
    public static final u h;
    public static final u i;
    public static final Map<u, Integer> j;
    public static final u k;
    public static final d0.e0.p.d.m0.k.a0.p.d l;
    public static final d0.e0.p.d.m0.k.a0.p.d m;

    @Deprecated
    public static final d0.e0.p.d.m0.k.a0.p.d n;
    public static final d0.e0.p.d.m0.o.g o;
    public static final Map<f1, u> p;

    static {
        t$d t_d = new t$d(e1$e.c);
        a = t_d;
        t$e t_e = new t$e(e1$f.c);
        f3300b = t_e;
        t$f t_f = new t$f(e1$g.c);
        c = t_f;
        t$g t_g = new t$g(e1$b.c);
        d = t_g;
        t$h t_h = new t$h(e1$h.c);
        e = t_h;
        t$i t_i = new t$i(e1$d.c);
        f = t_i;
        t$j t_j = new t$j(e1$a.c);
        g = t_j;
        t$k t_k = new t$k(e1$c.c);
        h = t_k;
        t$l t_l = new t$l(e1$i.c);
        i = t_l;
        Collections.unmodifiableSet(d0.t.n0.setOf((Object[]) new u[]{t_d, t_e, t_g, t_i}));
        HashMap mapNewHashMapWithExpectedSize = d0.e0.p.d.m0.p.a.newHashMapWithExpectedSize(4);
        mapNewHashMapWithExpectedSize.put(t_e, 0);
        mapNewHashMapWithExpectedSize.put(t_d, 0);
        mapNewHashMapWithExpectedSize.put(t_g, 1);
        mapNewHashMapWithExpectedSize.put(t_f, 1);
        mapNewHashMapWithExpectedSize.put(t_h, 2);
        j = Collections.unmodifiableMap(mapNewHashMapWithExpectedSize);
        k = t_h;
        l = new t$a();
        m = new t$b();
        n = new t$c();
        Iterator it = ServiceLoader.load(d0.e0.p.d.m0.o.g.class, d0.e0.p.d.m0.o.g.class.getClassLoader()).iterator();
        o = it.hasNext() ? (d0.e0.p.d.m0.o.g) it.next() : g$a.a;
        p = new HashMap();
        b(t_d);
        b(t_e);
        b(t_f);
        b(t_g);
        b(t_h);
        b(t_i);
        b(t_j);
        b(t_k);
        b(t_l);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003a  */
    public static /* synthetic */ void a(int i2) {
        String str = i2 != 16 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 16 ? 3 : 2];
        if (i2 != 1 && i2 != 3 && i2 != 5 && i2 != 7) {
            switch (i2) {
                case 9:
                    objArr[0] = "from";
                    break;
                case 10:
                case 12:
                    objArr[0] = "first";
                    break;
                case 11:
                case 13:
                    objArr[0] = "second";
                    break;
                case 14:
                case 15:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
        } else {
            objArr[0] = "from";
        }
        if (i2 != 16) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        } else {
            objArr[1] = "toDescriptorVisibility";
        }
        switch (i2) {
            case 2:
            case 3:
                objArr[2] = "isVisibleIgnoringReceiver";
                break;
            case 4:
            case 5:
                objArr[2] = "isVisibleWithAnyReceiver";
                break;
            case 6:
            case 7:
                objArr[2] = "inSameFile";
                break;
            case 8:
            case 9:
                objArr[2] = "findInvisibleMember";
                break;
            case 10:
            case 11:
                objArr[2] = "compareLocal";
                break;
            case 12:
            case 13:
                objArr[2] = "compare";
                break;
            case 14:
                objArr[2] = "isPrivate";
                break;
            case 15:
                objArr[2] = "toDescriptorVisibility";
                break;
            case 16:
                break;
            default:
                objArr[2] = "isVisible";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 == 16) {
            throw new IllegalStateException(str2);
        }
    }

    public static void b(u uVar) {
        p.put(uVar.getDelegate(), uVar);
    }

    public static Integer compare(u uVar, u uVar2) {
        if (uVar == null) {
            a(12);
            throw null;
        }
        if (uVar2 == null) {
            a(13);
            throw null;
        }
        Integer numCompareTo = uVar.compareTo(uVar2);
        if (numCompareTo != null) {
            return numCompareTo;
        }
        Integer numCompareTo2 = uVar2.compareTo(uVar);
        if (numCompareTo2 != null) {
            return Integer.valueOf(-numCompareTo2.intValue());
        }
        return null;
    }

    public static q findInvisibleMember(d0.e0.p.d.m0.k.a0.p.d dVar, q qVar, m mVar) {
        q qVarFindInvisibleMember;
        if (qVar == null) {
            a(8);
            throw null;
        }
        if (mVar == null) {
            a(9);
            throw null;
        }
        for (q qVar2 = (q) qVar.getOriginal(); qVar2 != null && qVar2.getVisibility() != f; qVar2 = (q) d0.e0.p.d.m0.k.e.getParentOfType(qVar2, q.class)) {
            if (!qVar2.getVisibility().isVisible(dVar, qVar2, mVar)) {
                return qVar2;
            }
        }
        if (!(qVar instanceof d0.e0.p.d.m0.c.i1.i0) || (qVarFindInvisibleMember = findInvisibleMember(dVar, ((d0.e0.p.d.m0.c.i1.i0) qVar).getUnderlyingConstructorDescriptor(), mVar)) == null) {
            return null;
        }
        return qVarFindInvisibleMember;
    }

    public static boolean inSameFile(m mVar, m mVar2) {
        if (mVar == null) {
            a(6);
            throw null;
        }
        if (mVar2 == null) {
            a(7);
            throw null;
        }
        v0 containingSourceFile = d0.e0.p.d.m0.k.e.getContainingSourceFile(mVar2);
        if (containingSourceFile != v0.a) {
            return containingSourceFile.equals(d0.e0.p.d.m0.k.e.getContainingSourceFile(mVar));
        }
        return false;
    }

    public static boolean isPrivate(u uVar) {
        if (uVar != null) {
            return uVar == a || uVar == f3300b;
        }
        a(14);
        throw null;
    }

    public static boolean isVisibleIgnoringReceiver(q qVar, m mVar) {
        if (qVar == null) {
            a(2);
            throw null;
        }
        if (mVar != null) {
            return findInvisibleMember(m, qVar, mVar) == null;
        }
        a(3);
        throw null;
    }

    public static u toDescriptorVisibility(f1 f1Var) {
        if (f1Var == null) {
            a(15);
            throw null;
        }
        u uVar = p.get(f1Var);
        if (uVar != null) {
            return uVar;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + f1Var);
    }
}
