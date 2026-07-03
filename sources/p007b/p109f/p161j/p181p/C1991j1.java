package p007b.p109f.p161j.p181p;

import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p161j.p169d.C1884e;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.j1 */
/* JADX INFO: compiled from: ThumbnailBranchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1991j1 implements InterfaceC2018w0<C1919e> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1994k1<C1919e>[] f4111a;

    /* JADX INFO: renamed from: b.f.j.p.j1$a */
    /* JADX INFO: compiled from: ThumbnailBranchProducer.java */
    public class a extends AbstractC2003p<C1919e, C1919e> {

        /* JADX INFO: renamed from: c */
        public final InterfaceC2020x0 f4112c;

        /* JADX INFO: renamed from: d */
        public final int f4113d;

        /* JADX INFO: renamed from: e */
        public final C1884e f4114e;

        public a(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0, int i) {
            super(interfaceC1995l);
            this.f4112c = interfaceC2020x0;
            this.f4113d = i;
            this.f4114e = interfaceC2020x0.mo1447e().f19592j;
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
        @Override // p007b.p109f.p161j.p181p.AbstractC2003p, p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: h */
        public void mo1319h(Throwable th) {
            if (C1991j1.this.m1480c(this.f4113d + 1, this.f4179b, this.f4112c)) {
                return;
            }
            this.f4179b.mo1425c(th);
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
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(Object obj, int i) {
            C1919e c1919e = (C1919e) obj;
            if (c1919e != null && (AbstractC1965b.m1420f(i) || C1460d.m475T0(c1919e, this.f4114e))) {
                this.f4179b.mo1424b(c1919e, i);
                return;
            }
            if (AbstractC1965b.m1419e(i)) {
                if (c1919e != null) {
                    c1919e.close();
                }
                if (C1991j1.this.m1480c(this.f4113d + 1, this.f4179b, this.f4112c)) {
                    return;
                }
                this.f4179b.mo1424b(null, 1);
            }
        }
    }

    public C1991j1(InterfaceC1994k1<C1919e>... interfaceC1994k1Arr) {
        Objects.requireNonNull(interfaceC1994k1Arr);
        this.f4111a = interfaceC1994k1Arr;
        int length = interfaceC1994k1Arr.length;
        if (length <= 0) {
            if (length < 0) {
                throw new IllegalArgumentException(C1643a.m871q("negative size: ", length));
            }
            throw new IndexOutOfBoundsException(C1460d.m536k0("%s (%s) must be less than size (%s)", "index", 0, Integer.valueOf(length)));
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        if (interfaceC2020x0.mo1447e().f19592j == null) {
            interfaceC1995l.mo1424b(null, 1);
        } else {
            if (m1480c(0, interfaceC1995l, interfaceC2020x0)) {
                return;
            }
            interfaceC1995l.mo1424b(null, 1);
        }
    }

    /* JADX INFO: renamed from: c */
    public final boolean m1480c(int i, InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        C1884e c1884e = interfaceC2020x0.mo1447e().f19592j;
        while (true) {
            InterfaceC1994k1<C1919e>[] interfaceC1994k1Arr = this.f4111a;
            if (i >= interfaceC1994k1Arr.length) {
                i = -1;
                break;
            }
            if (interfaceC1994k1Arr[i].mo1474a(c1884e)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return false;
        }
        this.f4111a[i].mo1417b(new a(interfaceC1995l, interfaceC2020x0, i), interfaceC2020x0);
        return true;
    }
}
