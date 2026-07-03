package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12083g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11329d1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.l0 */
/* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11384l0 extends AbstractC11386m0 implements InterfaceC11326c1 {

    /* JADX INFO: renamed from: o */
    public static final a f22898o = new a(null);

    /* JADX INFO: renamed from: p */
    public final int f22899p;

    /* JADX INFO: renamed from: q */
    public final boolean f22900q;

    /* JADX INFO: renamed from: r */
    public final boolean f22901r;

    /* JADX INFO: renamed from: s */
    public final boolean f22902s;

    /* JADX INFO: renamed from: t */
    public final AbstractC11913c0 f22903t;

    /* JADX INFO: renamed from: u */
    public final InterfaceC11326c1 f22904u;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.l0$a */
    /* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11384l0 createWithDestructuringDeclarations(InterfaceC11318a interfaceC11318a, InterfaceC11326c1 interfaceC11326c1, int i, InterfaceC11344g interfaceC11344g, C11716e c11716e, AbstractC11913c0 abstractC11913c0, boolean z2, boolean z3, boolean z4, AbstractC11913c0 abstractC11913c1, InterfaceC11467u0 interfaceC11467u0, Function0<? extends List<? extends InterfaceC11329d1>> function0) {
            C12238m.checkNotNullParameter(interfaceC11318a, "containingDeclaration");
            C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(abstractC11913c0, "outType");
            C12238m.checkNotNullParameter(interfaceC11467u0, "source");
            return function0 == null ? new C11384l0(interfaceC11318a, interfaceC11326c1, i, interfaceC11344g, c11716e, abstractC11913c0, z2, z3, z4, abstractC11913c1, interfaceC11467u0) : new b(interfaceC11318a, interfaceC11326c1, i, interfaceC11344g, c11716e, abstractC11913c0, z2, z3, z4, abstractC11913c1, interfaceC11467u0, function0);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.l0$b */
    /* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
    public static final class b extends C11384l0 {

        /* JADX INFO: renamed from: v */
        public final Lazy f22905v;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.l0$b$a */
        /* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
        public static final class a extends AbstractC12240o implements Function0<List<? extends InterfaceC11329d1>> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends InterfaceC11329d1> invoke() {
                return b.this.getDestructuringVariables();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC11318a interfaceC11318a, InterfaceC11326c1 interfaceC11326c1, int i, InterfaceC11344g interfaceC11344g, C11716e c11716e, AbstractC11913c0 abstractC11913c0, boolean z2, boolean z3, boolean z4, AbstractC11913c0 abstractC11913c1, InterfaceC11467u0 interfaceC11467u0, Function0<? extends List<? extends InterfaceC11329d1>> function0) {
            super(interfaceC11318a, interfaceC11326c1, i, interfaceC11344g, c11716e, abstractC11913c0, z2, z3, z4, abstractC11913c1, interfaceC11467u0);
            C12238m.checkNotNullParameter(interfaceC11318a, "containingDeclaration");
            C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(abstractC11913c0, "outType");
            C12238m.checkNotNullParameter(interfaceC11467u0, "source");
            C12238m.checkNotNullParameter(function0, "destructuringVariables");
            this.f22905v = C12083g.lazy(function0);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11384l0, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1
        public InterfaceC11326c1 copy(InterfaceC11318a interfaceC11318a, C11716e c11716e, int i) {
            C12238m.checkNotNullParameter(interfaceC11318a, "newOwner");
            C12238m.checkNotNullParameter(c11716e, "newName");
            InterfaceC11344g annotations = getAnnotations();
            C12238m.checkNotNullExpressionValue(annotations, "annotations");
            AbstractC11913c0 type = getType();
            C12238m.checkNotNullExpressionValue(type, "type");
            boolean zDeclaresDefaultValue = declaresDefaultValue();
            boolean zIsCrossinline = isCrossinline();
            boolean zIsNoinline = isNoinline();
            AbstractC11913c0 varargElementType = getVarargElementType();
            InterfaceC11467u0 interfaceC11467u0 = InterfaceC11467u0.f23099a;
            C12238m.checkNotNullExpressionValue(interfaceC11467u0, "NO_SOURCE");
            return new b(interfaceC11318a, null, i, annotations, c11716e, type, zDeclaresDefaultValue, zIsCrossinline, zIsNoinline, varargElementType, interfaceC11467u0, new a());
        }

        public final List<InterfaceC11329d1> getDestructuringVariables() {
            return (List) this.f22905v.getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11384l0(InterfaceC11318a interfaceC11318a, InterfaceC11326c1 interfaceC11326c1, int i, InterfaceC11344g interfaceC11344g, C11716e c11716e, AbstractC11913c0 abstractC11913c0, boolean z2, boolean z3, boolean z4, AbstractC11913c0 abstractC11913c1, InterfaceC11467u0 interfaceC11467u0) {
        super(interfaceC11318a, interfaceC11344g, c11716e, abstractC11913c0, interfaceC11467u0);
        C12238m.checkNotNullParameter(interfaceC11318a, "containingDeclaration");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(abstractC11913c0, "outType");
        C12238m.checkNotNullParameter(interfaceC11467u0, "source");
        this.f22899p = i;
        this.f22900q = z2;
        this.f22901r = z3;
        this.f22902s = z4;
        this.f22903t = abstractC11913c1;
        this.f22904u = interfaceC11326c1 == null ? this : interfaceC11326c1;
    }

    public static final C11384l0 createWithDestructuringDeclarations(InterfaceC11318a interfaceC11318a, InterfaceC11326c1 interfaceC11326c1, int i, InterfaceC11344g interfaceC11344g, C11716e c11716e, AbstractC11913c0 abstractC11913c0, boolean z2, boolean z3, boolean z4, AbstractC11913c0 abstractC11913c1, InterfaceC11467u0 interfaceC11467u0, Function0<? extends List<? extends InterfaceC11329d1>> function0) {
        return f22898o.createWithDestructuringDeclarations(interfaceC11318a, interfaceC11326c1, i, interfaceC11344g, c11716e, abstractC11913c0, z2, z3, z4, abstractC11913c1, interfaceC11467u0, function0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public <R, D> R accept(InterfaceC11454o<R, D> interfaceC11454o, D d) {
        C12238m.checkNotNullParameter(interfaceC11454o, "visitor");
        return interfaceC11454o.visitValueParameterDescriptor(this, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1
    public InterfaceC11326c1 copy(InterfaceC11318a interfaceC11318a, C11716e c11716e, int i) {
        C12238m.checkNotNullParameter(interfaceC11318a, "newOwner");
        C12238m.checkNotNullParameter(c11716e, "newName");
        InterfaceC11344g annotations = getAnnotations();
        C12238m.checkNotNullExpressionValue(annotations, "annotations");
        AbstractC11913c0 type = getType();
        C12238m.checkNotNullExpressionValue(type, "type");
        boolean zDeclaresDefaultValue = declaresDefaultValue();
        boolean zIsCrossinline = isCrossinline();
        boolean zIsNoinline = isNoinline();
        AbstractC11913c0 varargElementType = getVarargElementType();
        InterfaceC11467u0 interfaceC11467u0 = InterfaceC11467u0.f23099a;
        C12238m.checkNotNullExpressionValue(interfaceC11467u0, "NO_SOURCE");
        return new C11384l0(interfaceC11318a, null, i, annotations, c11716e, type, zDeclaresDefaultValue, zIsCrossinline, zIsNoinline, varargElementType, interfaceC11467u0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1
    public boolean declaresDefaultValue() {
        return this.f22900q && ((InterfaceC11321b) getContainingDeclaration()).getKind().isReal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11329d1
    public /* bridge */ /* synthetic */ AbstractC11815g getCompileTimeInitializer() {
        return (AbstractC11815g) m11462getCompileTimeInitializer();
    }

    /* JADX INFO: renamed from: getCompileTimeInitializer, reason: collision with other method in class */
    public Void m11462getCompileTimeInitializer() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1
    public int getIndex() {
        return this.f22899p;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public Collection<InterfaceC11326c1> getOverriddenDescriptors() {
        Collection<? extends InterfaceC11318a> overriddenDescriptors = getContainingDeclaration().getOverriddenDescriptors();
        C12238m.checkNotNullExpressionValue(overriddenDescriptors, "containingDeclaration.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(overriddenDescriptors, 10));
        Iterator<T> it = overriddenDescriptors.iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC11318a) it.next()).getValueParameters().get(getIndex()));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1
    public AbstractC11913c0 getVarargElementType() {
        return this.f22903t;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11458q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public AbstractC11466u getVisibility() {
        AbstractC11466u abstractC11466u = C11464t.f23088f;
        C12238m.checkNotNullExpressionValue(abstractC11466u, "LOCAL");
        return abstractC11466u;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1
    public boolean isCrossinline() {
        return this.f22901r;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1
    public boolean isNoinline() {
        return this.f22902s;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11329d1
    public boolean isVar() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11383l, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11318a getContainingDeclaration() {
        return (InterfaceC11318a) super.getContainingDeclaration();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11471w0
    public InterfaceC11326c1 substitute(C11914c1 c11914c1) {
        C12238m.checkNotNullParameter(c11914c1, "substitutor");
        if (c11914c1.isEmpty()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11383l, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11326c1 getOriginal() {
        InterfaceC11326c1 interfaceC11326c1 = this.f22904u;
        return interfaceC11326c1 == this ? this : interfaceC11326c1.getOriginal();
    }
}
