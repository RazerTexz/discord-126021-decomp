package d0.e0.p.d.m0.k.a0;

import d0.t.u;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final d$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f3453b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final d m;
    public static final d n;
    public static final d o;
    public static final d p;
    public static final d q;
    public static final List<d$a$a> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final List<d$a$a> f3454s;
    public final List<c> t;
    public final int u;

    static {
        d$a$a d_a_a;
        d$a$a d_a_a2;
        d$a d_a = new d$a(null);
        a = d_a;
        f3453b = 1;
        c = d$a.access$nextMask(d_a);
        d = d$a.access$nextMask(d_a);
        e = d$a.access$nextMask(d_a);
        f = d$a.access$nextMask(d_a);
        g = d$a.access$nextMask(d_a);
        h = d$a.access$nextMask(d_a);
        i = d$a.access$nextMask(d_a) - 1;
        j = d_a.getNON_SINGLETON_CLASSIFIERS_MASK() | d_a.getSINGLETON_CLASSIFIERS_MASK() | d_a.getTYPE_ALIASES_MASK();
        k = d_a.getSINGLETON_CLASSIFIERS_MASK() | d_a.getFUNCTIONS_MASK() | d_a.getVARIABLES_MASK();
        l = d_a.getFUNCTIONS_MASK() | d_a.getVARIABLES_MASK();
        m = new d(d_a.getALL_KINDS_MASK(), null, 2, null);
        n = new d(d_a.getCALLABLES_MASK(), null, 2, null);
        new d(d_a.getNON_SINGLETON_CLASSIFIERS_MASK(), null, 2, null);
        new d(d_a.getSINGLETON_CLASSIFIERS_MASK(), null, 2, null);
        new d(d_a.getTYPE_ALIASES_MASK(), null, 2, null);
        o = new d(d_a.getCLASSIFIERS_MASK(), null, 2, null);
        new d(d_a.getPACKAGES_MASK(), null, 2, null);
        p = new d(d_a.getFUNCTIONS_MASK(), null, 2, null);
        q = new d(d_a.getVARIABLES_MASK(), null, 2, null);
        new d(d_a.getVALUES_MASK(), null, 2, null);
        Field[] fields = d.class.getFields();
        d0.z.d.m.checkNotNullExpressionValue(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            d dVar = obj instanceof d ? (d) obj : null;
            if (dVar != null) {
                int kindMask = dVar.getKindMask();
                String name = field2.getName();
                d0.z.d.m.checkNotNullExpressionValue(name, "field.name");
                d_a_a2 = new d$a$a(kindMask, name);
            } else {
                d_a_a2 = null;
            }
            if (d_a_a2 != null) {
                arrayList2.add(d_a_a2);
            }
        }
        r = arrayList2;
        Field[] fields2 = d.class.getFields();
        d0.z.d.m.checkNotNullExpressionValue(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (d0.z.d.m.areEqual(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj3).intValue();
            if (iIntValue == ((-iIntValue) & iIntValue)) {
                String name2 = field4.getName();
                d0.z.d.m.checkNotNullExpressionValue(name2, "field.name");
                d_a_a = new d$a$a(iIntValue, name2);
            } else {
                d_a_a = null;
            }
            if (d_a_a != null) {
                arrayList5.add(d_a_a);
            }
        }
        f3454s = arrayList5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(int i2, List<? extends c> list) {
        d0.z.d.m.checkNotNullParameter(list, "excludes");
        this.t = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i2 &= ~((c) it.next()).getFullyExcludedDescriptorKinds();
        }
        this.u = i2;
    }

    public static final /* synthetic */ int access$getALL_KINDS_MASK$cp() {
        return i;
    }

    public static final /* synthetic */ int access$getCALLABLES_MASK$cp() {
        return l;
    }

    public static final /* synthetic */ int access$getCLASSIFIERS_MASK$cp() {
        return j;
    }

    public static final /* synthetic */ int access$getFUNCTIONS_MASK$cp() {
        return g;
    }

    public static final /* synthetic */ int access$getNON_SINGLETON_CLASSIFIERS_MASK$cp() {
        return c;
    }

    public static final /* synthetic */ int access$getNextMaskValue$cp() {
        return f3453b;
    }

    public static final /* synthetic */ int access$getPACKAGES_MASK$cp() {
        return f;
    }

    public static final /* synthetic */ int access$getSINGLETON_CLASSIFIERS_MASK$cp() {
        return d;
    }

    public static final /* synthetic */ int access$getTYPE_ALIASES_MASK$cp() {
        return e;
    }

    public static final /* synthetic */ int access$getVALUES_MASK$cp() {
        return k;
    }

    public static final /* synthetic */ int access$getVARIABLES_MASK$cp() {
        return h;
    }

    public static final /* synthetic */ void access$setNextMaskValue$cp(int i2) {
        f3453b = i2;
    }

    public final boolean acceptsKinds(int i2) {
        return (i2 & this.u) != 0;
    }

    public final List<c> getExcludes() {
        return this.t;
    }

    public final int getKindMask() {
        return this.u;
    }

    public final d restrictedToKindsOrNull(int i2) {
        int i3 = i2 & this.u;
        if (i3 == 0) {
            return null;
        }
        return new d(i3, this.t);
    }

    public String toString() {
        Object next;
        Iterator<T> it = r.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((d$a$a) next).getMask() == getKindMask()));
        d$a$a d_a_a = (d$a$a) next;
        String name = d_a_a == null ? null : d_a_a.getName();
        if (name == null) {
            List<d$a$a> list = f3454s;
            ArrayList arrayList = new ArrayList();
            for (d$a$a d_a_a2 : list) {
                String name2 = acceptsKinds(d_a_a2.getMask()) ? d_a_a2.getName() : null;
                if (name2 != null) {
                    arrayList.add(name2);
                }
            }
            name = u.joinToString$default(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        StringBuilder sbY = b.d.b.a.a.Y("DescriptorKindFilter(", name, ", ");
        sbY.append(this.t);
        sbY.append(')');
        return sbY.toString();
    }

    public /* synthetic */ d(int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? d0.t.n.emptyList() : list);
    }
}
