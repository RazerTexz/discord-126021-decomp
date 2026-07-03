package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.d */
/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11765d {

    /* JADX INFO: renamed from: a */
    public static final a f24339a;

    /* JADX INFO: renamed from: b */
    public static int f24340b;

    /* JADX INFO: renamed from: c */
    public static final int f24341c;

    /* JADX INFO: renamed from: d */
    public static final int f24342d;

    /* JADX INFO: renamed from: e */
    public static final int f24343e;

    /* JADX INFO: renamed from: f */
    public static final int f24344f;

    /* JADX INFO: renamed from: g */
    public static final int f24345g;

    /* JADX INFO: renamed from: h */
    public static final int f24346h;

    /* JADX INFO: renamed from: i */
    public static final int f24347i;

    /* JADX INFO: renamed from: j */
    public static final int f24348j;

    /* JADX INFO: renamed from: k */
    public static final int f24349k;

    /* JADX INFO: renamed from: l */
    public static final int f24350l;

    /* JADX INFO: renamed from: m */
    public static final C11765d f24351m;

    /* JADX INFO: renamed from: n */
    public static final C11765d f24352n;

    /* JADX INFO: renamed from: o */
    public static final C11765d f24353o;

    /* JADX INFO: renamed from: p */
    public static final C11765d f24354p;

    /* JADX INFO: renamed from: q */
    public static final C11765d f24355q;

    /* JADX INFO: renamed from: r */
    public static final List<a.C13327a> f24356r;

    /* JADX INFO: renamed from: s */
    public static final List<a.C13327a> f24357s;

    /* JADX INFO: renamed from: t */
    public final List<AbstractC11764c> f24358t;

    /* JADX INFO: renamed from: u */
    public final int f24359u;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.d$a */
    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class a {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MemberScope.kt */
        public static final class C13327a {

            /* JADX INFO: renamed from: a */
            public final int f24360a;

            /* JADX INFO: renamed from: b */
            public final String f24361b;

            public C13327a(int i, String str) {
                C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                this.f24360a = i;
                this.f24361b = str;
            }

            public final int getMask() {
                return this.f24360a;
            }

            public final String getName() {
                return this.f24361b;
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final int access$nextMask(a aVar) {
            Objects.requireNonNull(aVar);
            int i = C11765d.f24340b;
            C11765d.f24340b <<= 1;
            return i;
        }

        public final int getALL_KINDS_MASK() {
            return C11765d.f24347i;
        }

        public final int getCALLABLES_MASK() {
            return C11765d.f24350l;
        }

        public final int getCLASSIFIERS_MASK() {
            return C11765d.f24348j;
        }

        public final int getFUNCTIONS_MASK() {
            return C11765d.f24345g;
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return C11765d.f24341c;
        }

        public final int getPACKAGES_MASK() {
            return C11765d.f24344f;
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return C11765d.f24342d;
        }

        public final int getTYPE_ALIASES_MASK() {
            return C11765d.f24343e;
        }

        public final int getVALUES_MASK() {
            return C11765d.f24349k;
        }

        public final int getVARIABLES_MASK() {
            return C11765d.f24346h;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        a.C13327a c13327a;
        a.C13327a c13327a2;
        a aVar = new a(null);
        f24339a = aVar;
        f24340b = 1;
        f24341c = a.access$nextMask(aVar);
        f24342d = a.access$nextMask(aVar);
        f24343e = a.access$nextMask(aVar);
        f24344f = a.access$nextMask(aVar);
        f24345g = a.access$nextMask(aVar);
        f24346h = a.access$nextMask(aVar);
        f24347i = a.access$nextMask(aVar) - 1;
        f24348j = aVar.getNON_SINGLETON_CLASSIFIERS_MASK() | aVar.getSINGLETON_CLASSIFIERS_MASK() | aVar.getTYPE_ALIASES_MASK();
        f24349k = aVar.getSINGLETON_CLASSIFIERS_MASK() | aVar.getFUNCTIONS_MASK() | aVar.getVARIABLES_MASK();
        f24350l = aVar.getFUNCTIONS_MASK() | aVar.getVARIABLES_MASK();
        int i = 2;
        f24351m = new C11765d(aVar.getALL_KINDS_MASK(), null, i, 0 == true ? 1 : 0);
        f24352n = new C11765d(aVar.getCALLABLES_MASK(), 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        new C11765d(aVar.getNON_SINGLETON_CLASSIFIERS_MASK(), 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        new C11765d(aVar.getSINGLETON_CLASSIFIERS_MASK(), 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        new C11765d(aVar.getTYPE_ALIASES_MASK(), 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        f24353o = new C11765d(aVar.getCLASSIFIERS_MASK(), 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        new C11765d(aVar.getPACKAGES_MASK(), 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        f24354p = new C11765d(aVar.getFUNCTIONS_MASK(), 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        f24355q = new C11765d(aVar.getVARIABLES_MASK(), 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        new C11765d(aVar.getVALUES_MASK(), 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        Field[] fields = C11765d.class.getFields();
        C12238m.checkNotNullExpressionValue(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            C11765d c11765d = obj instanceof C11765d ? (C11765d) obj : null;
            if (c11765d != null) {
                int kindMask = c11765d.getKindMask();
                String name = field2.getName();
                C12238m.checkNotNullExpressionValue(name, "field.name");
                c13327a2 = new a.C13327a(kindMask, name);
            } else {
                c13327a2 = null;
            }
            if (c13327a2 != null) {
                arrayList2.add(c13327a2);
            }
        }
        f24356r = arrayList2;
        Field[] fields2 = C11765d.class.getFields();
        C12238m.checkNotNullExpressionValue(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (C12238m.areEqual(((Field) obj2).getType(), Integer.TYPE)) {
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
                C12238m.checkNotNullExpressionValue(name2, "field.name");
                c13327a = new a.C13327a(iIntValue, name2);
            } else {
                c13327a = null;
            }
            if (c13327a != null) {
                arrayList5.add(c13327a);
            }
        }
        f24357s = arrayList5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11765d(int i, List<? extends AbstractC11764c> list) {
        C12238m.checkNotNullParameter(list, "excludes");
        this.f24358t = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i &= ~((AbstractC11764c) it.next()).getFullyExcludedDescriptorKinds();
        }
        this.f24359u = i;
    }

    public final boolean acceptsKinds(int i) {
        return (i & this.f24359u) != 0;
    }

    public final List<AbstractC11764c> getExcludes() {
        return this.f24358t;
    }

    public final int getKindMask() {
        return this.f24359u;
    }

    public final C11765d restrictedToKindsOrNull(int i) {
        int i2 = i & this.f24359u;
        if (i2 == 0) {
            return null;
        }
        return new C11765d(i2, this.f24358t);
    }

    public String toString() {
        Object next;
        Iterator<T> it = f24356r.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((a.C13327a) next).getMask() == getKindMask()));
        a.C13327a c13327a = (a.C13327a) next;
        String name = c13327a == null ? null : c13327a.getName();
        if (name == null) {
            List<a.C13327a> list = f24357s;
            ArrayList arrayList = new ArrayList();
            for (a.C13327a c13327a2 : list) {
                String name2 = acceptsKinds(c13327a2.getMask()) ? c13327a2.getName() : null;
                if (name2 != null) {
                    arrayList.add(name2);
                }
            }
            name = C12163u.joinToString$default(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        StringBuilder sbM837Y = C1643a.m837Y("DescriptorKindFilter(", name, ", ");
        sbM837Y.append(this.f24358t);
        sbM837Y.append(')');
        return sbM837Y.toString();
    }

    public /* synthetic */ C11765d(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? C12147n.emptyList() : list);
    }
}
