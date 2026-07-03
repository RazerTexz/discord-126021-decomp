package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11688m;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11690o;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11691p;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.AbstractC11702a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11705d;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.C11864i;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11861f;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.o */
/* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11879o extends AbstractC11878n {

    /* JADX INFO: renamed from: p */
    public final AbstractC11702a f24670p;

    /* JADX INFO: renamed from: q */
    public final InterfaceC11861f f24671q;

    /* JADX INFO: renamed from: r */
    public final C11705d f24672r;

    /* JADX INFO: renamed from: s */
    public final C11888x f24673s;

    /* JADX INFO: renamed from: t */
    public C11688m f24674t;

    /* JADX INFO: renamed from: u */
    public InterfaceC11770i f24675u;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.o$a */
    /* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
    public static final class a extends AbstractC12240o implements Function1<C11712a, InterfaceC11467u0> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11467u0 invoke(C11712a c11712a) {
            C12238m.checkNotNullParameter(c11712a, "it");
            InterfaceC11861f interfaceC11861f = AbstractC11879o.this.f24671q;
            if (interfaceC11861f != null) {
                return interfaceC11861f;
            }
            InterfaceC11467u0 interfaceC11467u0 = InterfaceC11467u0.f23099a;
            C12238m.checkNotNullExpressionValue(interfaceC11467u0, "NO_SOURCE");
            return interfaceC11467u0;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.o$b */
    /* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
    public static final class b extends AbstractC12240o implements Function0<Collection<? extends C11716e>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Collection<? extends C11716e> invoke() {
            Collection<C11712a> allClassIds = AbstractC11879o.this.getClassDataFinder().getAllClassIds();
            ArrayList arrayList = new ArrayList();
            for (Object obj : allClassIds) {
                C11712a c11712a = (C11712a) obj;
                if ((c11712a.isNestedClass() || C11872h.f24629a.getBLACK_LIST().contains(c11712a)) ? false : true) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((C11712a) it.next()).getShortClassName());
            }
            return arrayList2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC11879o(C11713b c11713b, InterfaceC11905o interfaceC11905o, InterfaceC11325c0 interfaceC11325c0, C11688m c11688m, AbstractC11702a abstractC11702a, InterfaceC11861f interfaceC11861f) {
        super(c11713b, interfaceC11905o, interfaceC11325c0);
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        C12238m.checkNotNullParameter(c11688m, "proto");
        C12238m.checkNotNullParameter(abstractC11702a, "metadataVersion");
        this.f24670p = abstractC11702a;
        this.f24671q = interfaceC11861f;
        C11691p strings = c11688m.getStrings();
        C12238m.checkNotNullExpressionValue(strings, "proto.strings");
        C11690o qualifiedNames = c11688m.getQualifiedNames();
        C12238m.checkNotNullExpressionValue(qualifiedNames, "proto.qualifiedNames");
        C11705d c11705d = new C11705d(strings, qualifiedNames);
        this.f24672r = c11705d;
        this.f24673s = new C11888x(c11688m, c11705d, abstractC11702a, new a());
        this.f24674t = c11688m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0
    public InterfaceC11770i getMemberScope() {
        InterfaceC11770i interfaceC11770i = this.f24675u;
        if (interfaceC11770i != null) {
            return interfaceC11770i;
        }
        C12238m.throwUninitializedPropertyAccessException("_memberScope");
        throw null;
    }

    public void initialize(C11874j c11874j) {
        C12238m.checkNotNullParameter(c11874j, "components");
        C11688m c11688m = this.f24674t;
        if (c11688m == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
        }
        this.f24674t = null;
        C11687l c11687l = c11688m.getPackage();
        C12238m.checkNotNullExpressionValue(c11687l, "proto.`package`");
        this.f24675u = new C11864i(this, c11687l, this.f24672r, this.f24670p, this.f24671q, c11874j, new b());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AbstractC11878n
    public C11888x getClassDataFinder() {
        return this.f24673s;
    }
}
