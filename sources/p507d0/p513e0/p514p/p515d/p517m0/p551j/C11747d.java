package p507d0.p513e0.p514p.p515d.p517m0.p551j;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11287g;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11320a1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11328d0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11449l0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11333f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11327d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11329d1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11402j0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11448l;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11451m0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11455o0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11456p;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11457p0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11468v;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11469v0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.EnumC11342e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11718g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11807a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11809b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11826r;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11938k1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11906a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11919e0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11929h1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11968m0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12003s;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p579g0.C12108y;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12150o0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.d */
/* JADX INFO: compiled from: DescriptorRendererImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11747d extends AbstractC11746c implements InterfaceC11751h {

    /* JADX INFO: renamed from: d */
    public final C11752i f24239d;

    /* JADX INFO: renamed from: e */
    public final Lazy f24240e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.d$a */
    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    public final class a implements InterfaceC11454o<Unit, StringBuilder> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ C11747d f24241a;

        public a(C11747d c11747d) {
            C12238m.checkNotNullParameter(c11747d, "this$0");
            this.f24241a = c11747d;
        }

        /* JADX INFO: renamed from: a */
        public final void m9908a(InterfaceC11451m0 interfaceC11451m0, StringBuilder sb, String str) throws IOException {
            int iOrdinal = this.f24241a.getPropertyAccessorRenderingPolicy().ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    return;
                }
                visitFunctionDescriptor2((InterfaceC11472x) interfaceC11451m0, sb);
            } else {
                this.f24241a.m9897p(interfaceC11451m0, sb);
                sb.append(C12238m.stringPlus(str, " for "));
                C11747d c11747d = this.f24241a;
                InterfaceC11453n0 correspondingProperty = interfaceC11451m0.getCorrespondingProperty();
                C12238m.checkNotNullExpressionValue(correspondingProperty, "descriptor.correspondingProperty");
                C11747d.access$renderProperty(c11747d, correspondingProperty, sb);
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
        public /* bridge */ /* synthetic */ Unit visitClassDescriptor(InterfaceC11330e interfaceC11330e, StringBuilder sb) throws IOException {
            visitClassDescriptor2(interfaceC11330e, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
        public /* bridge */ /* synthetic */ Unit visitConstructorDescriptor(InterfaceC11448l interfaceC11448l, StringBuilder sb) throws IOException {
            visitConstructorDescriptor2(interfaceC11448l, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
        public /* bridge */ /* synthetic */ Unit visitFunctionDescriptor(InterfaceC11472x interfaceC11472x, StringBuilder sb) throws IOException {
            visitFunctionDescriptor2(interfaceC11472x, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
        public /* bridge */ /* synthetic */ Unit visitModuleDeclaration(InterfaceC11325c0 interfaceC11325c0, StringBuilder sb) {
            visitModuleDeclaration2(interfaceC11325c0, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
        public /* bridge */ /* synthetic */ Unit visitPackageFragmentDescriptor(InterfaceC11331e0 interfaceC11331e0, StringBuilder sb) {
            visitPackageFragmentDescriptor2(interfaceC11331e0, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
        public /* bridge */ /* synthetic */ Unit visitPackageViewDescriptor(InterfaceC11402j0 interfaceC11402j0, StringBuilder sb) {
            visitPackageViewDescriptor2(interfaceC11402j0, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
        public /* bridge */ /* synthetic */ Unit visitPropertyDescriptor(InterfaceC11453n0 interfaceC11453n0, StringBuilder sb) throws IOException {
            visitPropertyDescriptor2(interfaceC11453n0, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
        public /* bridge */ /* synthetic */ Unit visitPropertyGetterDescriptor(InterfaceC11455o0 interfaceC11455o0, StringBuilder sb) throws IOException {
            visitPropertyGetterDescriptor2(interfaceC11455o0, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
        public /* bridge */ /* synthetic */ Unit visitPropertySetterDescriptor(InterfaceC11457p0 interfaceC11457p0, StringBuilder sb) throws IOException {
            visitPropertySetterDescriptor2(interfaceC11457p0, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
        public /* bridge */ /* synthetic */ Unit visitReceiverParameterDescriptor(InterfaceC11459q0 interfaceC11459q0, StringBuilder sb) {
            visitReceiverParameterDescriptor2(interfaceC11459q0, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
        public /* bridge */ /* synthetic */ Unit visitTypeAliasDescriptor(InterfaceC11475y0 interfaceC11475y0, StringBuilder sb) {
            visitTypeAliasDescriptor2(interfaceC11475y0, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
        public /* bridge */ /* synthetic */ Unit visitTypeParameterDescriptor(InterfaceC11477z0 interfaceC11477z0, StringBuilder sb) {
            visitTypeParameterDescriptor2(interfaceC11477z0, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
        public /* bridge */ /* synthetic */ Unit visitValueParameterDescriptor(InterfaceC11326c1 interfaceC11326c1, StringBuilder sb) {
            visitValueParameterDescriptor2(interfaceC11326c1, sb);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: visitClassDescriptor, reason: avoid collision after fix types in other method */
        public void visitClassDescriptor2(InterfaceC11330e interfaceC11330e, StringBuilder sb) throws IOException {
            C12238m.checkNotNullParameter(interfaceC11330e, "descriptor");
            C12238m.checkNotNullParameter(sb, "builder");
            C11747d.access$renderClass(this.f24241a, interfaceC11330e, sb);
        }

        /* JADX INFO: renamed from: visitConstructorDescriptor, reason: avoid collision after fix types in other method */
        public void visitConstructorDescriptor2(InterfaceC11448l interfaceC11448l, StringBuilder sb) throws IOException {
            C12238m.checkNotNullParameter(interfaceC11448l, "constructorDescriptor");
            C12238m.checkNotNullParameter(sb, "builder");
            C11747d.access$renderConstructor(this.f24241a, interfaceC11448l, sb);
        }

        /* JADX INFO: renamed from: visitFunctionDescriptor, reason: avoid collision after fix types in other method */
        public void visitFunctionDescriptor2(InterfaceC11472x interfaceC11472x, StringBuilder sb) throws IOException {
            C12238m.checkNotNullParameter(interfaceC11472x, "descriptor");
            C12238m.checkNotNullParameter(sb, "builder");
            C11747d.access$renderFunction(this.f24241a, interfaceC11472x, sb);
        }

        /* JADX INFO: renamed from: visitModuleDeclaration, reason: avoid collision after fix types in other method */
        public void visitModuleDeclaration2(InterfaceC11325c0 interfaceC11325c0, StringBuilder sb) {
            C12238m.checkNotNullParameter(interfaceC11325c0, "descriptor");
            C12238m.checkNotNullParameter(sb, "builder");
            this.f24241a.m9901t(interfaceC11325c0, sb, true);
        }

        /* JADX INFO: renamed from: visitPackageFragmentDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageFragmentDescriptor2(InterfaceC11331e0 interfaceC11331e0, StringBuilder sb) {
            C12238m.checkNotNullParameter(interfaceC11331e0, "descriptor");
            C12238m.checkNotNullParameter(sb, "builder");
            C11747d.access$renderPackageFragment(this.f24241a, interfaceC11331e0, sb);
        }

        /* JADX INFO: renamed from: visitPackageViewDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageViewDescriptor2(InterfaceC11402j0 interfaceC11402j0, StringBuilder sb) {
            C12238m.checkNotNullParameter(interfaceC11402j0, "descriptor");
            C12238m.checkNotNullParameter(sb, "builder");
            C11747d.access$renderPackageView(this.f24241a, interfaceC11402j0, sb);
        }

        /* JADX INFO: renamed from: visitPropertyDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyDescriptor2(InterfaceC11453n0 interfaceC11453n0, StringBuilder sb) throws IOException {
            C12238m.checkNotNullParameter(interfaceC11453n0, "descriptor");
            C12238m.checkNotNullParameter(sb, "builder");
            C11747d.access$renderProperty(this.f24241a, interfaceC11453n0, sb);
        }

        /* JADX INFO: renamed from: visitPropertyGetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyGetterDescriptor2(InterfaceC11455o0 interfaceC11455o0, StringBuilder sb) throws IOException {
            C12238m.checkNotNullParameter(interfaceC11455o0, "descriptor");
            C12238m.checkNotNullParameter(sb, "builder");
            m9908a(interfaceC11455o0, sb, "getter");
        }

        /* JADX INFO: renamed from: visitPropertySetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertySetterDescriptor2(InterfaceC11457p0 interfaceC11457p0, StringBuilder sb) throws IOException {
            C12238m.checkNotNullParameter(interfaceC11457p0, "descriptor");
            C12238m.checkNotNullParameter(sb, "builder");
            m9908a(interfaceC11457p0, sb, "setter");
        }

        /* JADX INFO: renamed from: visitReceiverParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitReceiverParameterDescriptor2(InterfaceC11459q0 interfaceC11459q0, StringBuilder sb) {
            C12238m.checkNotNullParameter(interfaceC11459q0, "descriptor");
            C12238m.checkNotNullParameter(sb, "builder");
            sb.append(interfaceC11459q0.getName());
        }

        /* JADX INFO: renamed from: visitTypeAliasDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeAliasDescriptor2(InterfaceC11475y0 interfaceC11475y0, StringBuilder sb) {
            C12238m.checkNotNullParameter(interfaceC11475y0, "descriptor");
            C12238m.checkNotNullParameter(sb, "builder");
            C11747d.access$renderTypeAlias(this.f24241a, interfaceC11475y0, sb);
        }

        /* JADX INFO: renamed from: visitTypeParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeParameterDescriptor2(InterfaceC11477z0 interfaceC11477z0, StringBuilder sb) {
            C12238m.checkNotNullParameter(interfaceC11477z0, "descriptor");
            C12238m.checkNotNullParameter(sb, "builder");
            this.f24241a.m9873C(interfaceC11477z0, sb, true);
        }

        /* JADX INFO: renamed from: visitValueParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitValueParameterDescriptor2(InterfaceC11326c1 interfaceC11326c1, StringBuilder sb) {
            C12238m.checkNotNullParameter(interfaceC11326c1, "descriptor");
            C12238m.checkNotNullParameter(sb, "builder");
            this.f24241a.m9877G(interfaceC11326c1, true, sb, true);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.d$b */
    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    public static final class b extends AbstractC12240o implements Function1<InterfaceC12012w0, CharSequence> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(InterfaceC12012w0 interfaceC12012w0) {
            C12238m.checkNotNullParameter(interfaceC12012w0, "it");
            if (interfaceC12012w0.isStarProjection()) {
                return "*";
            }
            C11747d c11747d = C11747d.this;
            AbstractC11913c0 type = interfaceC12012w0.getType();
            C12238m.checkNotNullExpressionValue(type, "it.type");
            String strRenderType = c11747d.renderType(type);
            if (interfaceC12012w0.getProjectionKind() == EnumC11935j1.INVARIANT) {
                return strRenderType;
            }
            return interfaceC12012w0.getProjectionKind() + ' ' + strRenderType;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.d$c */
    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    public static final class c extends AbstractC12240o implements Function0<C11747d> {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.j.d$c$a */
        /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
        public static final class a extends AbstractC12240o implements Function1<InterfaceC11751h, Unit> {

            /* JADX INFO: renamed from: j */
            public static final a f24242j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InterfaceC11751h interfaceC11751h) {
                invoke2(interfaceC11751h);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InterfaceC11751h interfaceC11751h) {
                C12238m.checkNotNullParameter(interfaceC11751h, "<this>");
                interfaceC11751h.setExcludedTypeAnnotationClasses(C12150o0.plus((Set) interfaceC11751h.getExcludedTypeAnnotationClasses(), (Iterable) C12145m.listOf(C11291k.a.f22569x)));
                interfaceC11751h.setAnnotationArgumentsRenderingPolicy(EnumC11744a.ALWAYS_PARENTHESIZED);
            }
        }

        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final C11747d invoke() {
            return (C11747d) C11747d.this.withOptions(a.f24242j);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.d$d */
    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    public static final class d extends AbstractC12240o implements Function1<AbstractC11815g<?>, CharSequence> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(AbstractC11815g<?> abstractC11815g) {
            C12238m.checkNotNullParameter(abstractC11815g, "it");
            return C11747d.this.m9892k(abstractC11815g);
        }
    }

    public C11747d(C11752i c11752i) {
        C12238m.checkNotNullParameter(c11752i, "options");
        this.f24239d = c11752i;
        c11752i.isLocked();
        this.f24240e = C12083g.lazy(new c());
    }

    public static final void access$renderClass(C11747d c11747d, InterfaceC11330e interfaceC11330e, StringBuilder sb) throws IOException {
        InterfaceC11327d unsubstitutedPrimaryConstructor;
        Objects.requireNonNull(c11747d);
        boolean z2 = interfaceC11330e.getKind() == EnumC11333f.ENUM_ENTRY;
        if (!c11747d.getStartFromName()) {
            c11747d.m9890h(sb, interfaceC11330e, null);
            if (!z2) {
                AbstractC11466u visibility = interfaceC11330e.getVisibility();
                C12238m.checkNotNullExpressionValue(visibility, "klass.visibility");
                c11747d.m9879I(visibility, sb);
            }
            if ((interfaceC11330e.getKind() != EnumC11333f.INTERFACE || interfaceC11330e.getModality() != EnumC11476z.ABSTRACT) && (!interfaceC11330e.getKind().isSingleton() || interfaceC11330e.getModality() != EnumC11476z.FINAL)) {
                EnumC11476z modality = interfaceC11330e.getModality();
                C12238m.checkNotNullExpressionValue(modality, "klass.modality");
                c11747d.m9898q(modality, sb, c11747d.m9887e(interfaceC11330e));
            }
            c11747d.m9897p(interfaceC11330e, sb);
            c11747d.m9900s(sb, c11747d.getModifiers().contains(EnumC11750g.INNER) && interfaceC11330e.isInner(), "inner");
            c11747d.m9900s(sb, c11747d.getModifiers().contains(EnumC11750g.DATA) && interfaceC11330e.isData(), "data");
            c11747d.m9900s(sb, c11747d.getModifiers().contains(EnumC11750g.INLINE) && interfaceC11330e.isInline(), "inline");
            c11747d.m9900s(sb, c11747d.getModifiers().contains(EnumC11750g.VALUE) && interfaceC11330e.isValue(), "value");
            c11747d.m9900s(sb, c11747d.getModifiers().contains(EnumC11750g.FUN) && interfaceC11330e.isFun(), "fun");
            sb.append(c11747d.m9895n(AbstractC11746c.f24225a.getClassifierKindPrefix(interfaceC11330e)));
        }
        if (C11787e.isCompanionObject(interfaceC11330e)) {
            if (c11747d.getRenderCompanionObjectName()) {
                if (c11747d.getStartFromName()) {
                    sb.append("companion object");
                }
                c11747d.m9872B(sb);
                InterfaceC11450m containingDeclaration = interfaceC11330e.getContainingDeclaration();
                if (containingDeclaration != null) {
                    sb.append("of ");
                    C11716e name = containingDeclaration.getName();
                    C12238m.checkNotNullExpressionValue(name, "containingDeclaration.name");
                    sb.append(c11747d.renderName(name, false));
                }
            }
            if (c11747d.getVerbose() || !C12238m.areEqual(interfaceC11330e.getName(), C11718g.f24093b)) {
                if (!c11747d.getStartFromName()) {
                    c11747d.m9872B(sb);
                }
                C11716e name2 = interfaceC11330e.getName();
                C12238m.checkNotNullExpressionValue(name2, "descriptor.name");
                sb.append(c11747d.renderName(name2, true));
            }
        } else {
            if (!c11747d.getStartFromName()) {
                c11747d.m9872B(sb);
            }
            c11747d.m9901t(interfaceC11330e, sb, true);
        }
        if (z2) {
            return;
        }
        List<InterfaceC11477z0> declaredTypeParameters = interfaceC11330e.getDeclaredTypeParameters();
        C12238m.checkNotNullExpressionValue(declaredTypeParameters, "klass.declaredTypeParameters");
        c11747d.m9875E(declaredTypeParameters, sb, false);
        c11747d.m9891j(interfaceC11330e, sb);
        if (!interfaceC11330e.getKind().isSingleton() && c11747d.getClassWithPrimaryConstructor() && (unsubstitutedPrimaryConstructor = interfaceC11330e.getUnsubstitutedPrimaryConstructor()) != null) {
            sb.append(" ");
            c11747d.m9890h(sb, unsubstitutedPrimaryConstructor, null);
            AbstractC11466u visibility2 = unsubstitutedPrimaryConstructor.getVisibility();
            C12238m.checkNotNullExpressionValue(visibility2, "primaryConstructor.visibility");
            c11747d.m9879I(visibility2, sb);
            sb.append(c11747d.m9895n("constructor"));
            List<InterfaceC11326c1> valueParameters = unsubstitutedPrimaryConstructor.getValueParameters();
            C12238m.checkNotNullExpressionValue(valueParameters, "primaryConstructor.valueParameters");
            c11747d.m9878H(valueParameters, unsubstitutedPrimaryConstructor.hasSynthesizedParameterNames(), sb);
        }
        if (!c11747d.getWithoutSuperTypes() && !AbstractC11288h.isNothing(interfaceC11330e.getDefaultType())) {
            Collection<AbstractC11913c0> supertypes = interfaceC11330e.getTypeConstructor().getSupertypes();
            C12238m.checkNotNullExpressionValue(supertypes, "klass.typeConstructor.supertypes");
            if (!supertypes.isEmpty() && (supertypes.size() != 1 || !AbstractC11288h.isAnyOrNullableAny(supertypes.iterator().next()))) {
                c11747d.m9872B(sb);
                sb.append(": ");
                C12163u.joinTo(supertypes, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new C11749f(c11747d));
            }
        }
        c11747d.m9880J(declaredTypeParameters, sb);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0031  */
    public static final void access$renderConstructor(C11747d c11747d, InterfaceC11448l interfaceC11448l, StringBuilder sb) throws IOException {
        boolean z2;
        InterfaceC11327d unsubstitutedPrimaryConstructor;
        c11747d.m9890h(sb, interfaceC11448l, null);
        if (c11747d.f24239d.getRenderDefaultVisibility() || interfaceC11448l.getConstructedClass().getModality() != EnumC11476z.SEALED) {
            AbstractC11466u visibility = interfaceC11448l.getVisibility();
            C12238m.checkNotNullExpressionValue(visibility, "constructor.visibility");
            if (c11747d.m9879I(visibility, sb)) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        c11747d.m9896o(interfaceC11448l, sb);
        boolean z3 = c11747d.getRenderConstructorKeyword() || !interfaceC11448l.isPrimary() || z2;
        if (z3) {
            sb.append(c11747d.m9895n("constructor"));
        }
        InterfaceC11359i containingDeclaration = interfaceC11448l.getContainingDeclaration();
        C12238m.checkNotNullExpressionValue(containingDeclaration, "constructor.containingDeclaration");
        if (c11747d.getSecondaryConstructorsAsPrimary()) {
            if (z3) {
                sb.append(" ");
            }
            c11747d.m9901t(containingDeclaration, sb, true);
            List<InterfaceC11477z0> typeParameters = interfaceC11448l.getTypeParameters();
            C12238m.checkNotNullExpressionValue(typeParameters, "constructor.typeParameters");
            c11747d.m9875E(typeParameters, sb, false);
        }
        List<InterfaceC11326c1> valueParameters = interfaceC11448l.getValueParameters();
        C12238m.checkNotNullExpressionValue(valueParameters, "constructor.valueParameters");
        c11747d.m9878H(valueParameters, interfaceC11448l.hasSynthesizedParameterNames(), sb);
        if (c11747d.getRenderConstructorDelegation() && !interfaceC11448l.isPrimary() && (containingDeclaration instanceof InterfaceC11330e) && (unsubstitutedPrimaryConstructor = ((InterfaceC11330e) containingDeclaration).getUnsubstitutedPrimaryConstructor()) != null) {
            List<InterfaceC11326c1> valueParameters2 = unsubstitutedPrimaryConstructor.getValueParameters();
            ArrayList arrayListM840a0 = C1643a.m840a0(valueParameters2, "primaryConstructor.valueParameters");
            for (Object obj : valueParameters2) {
                InterfaceC11326c1 interfaceC11326c1 = (InterfaceC11326c1) obj;
                if (!interfaceC11326c1.declaresDefaultValue() && interfaceC11326c1.getVarargElementType() == null) {
                    arrayListM840a0.add(obj);
                }
            }
            if (!arrayListM840a0.isEmpty()) {
                sb.append(" : ");
                sb.append(c11747d.m9895n("this"));
                sb.append(C12163u.joinToString$default(arrayListM840a0, ", ", "(", ")", 0, null, C11748e.f24243j, 24, null));
            }
        }
        if (c11747d.getSecondaryConstructorsAsPrimary()) {
            List<InterfaceC11477z0> typeParameters2 = interfaceC11448l.getTypeParameters();
            C12238m.checkNotNullExpressionValue(typeParameters2, "constructor.typeParameters");
            c11747d.m9880J(typeParameters2, sb);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0070  */
    public static final void access$renderFunction(C11747d c11747d, InterfaceC11472x interfaceC11472x, StringBuilder sb) throws IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        if (!c11747d.getStartFromName()) {
            if (!c11747d.getStartFromDeclarationKeyword()) {
                c11747d.m9890h(sb, interfaceC11472x, null);
                AbstractC11466u visibility = interfaceC11472x.getVisibility();
                C12238m.checkNotNullExpressionValue(visibility, "function.visibility");
                c11747d.m9879I(visibility, sb);
                c11747d.m9899r(interfaceC11472x, sb);
                if (c11747d.getIncludeAdditionalModifiers()) {
                    c11747d.m9897p(interfaceC11472x, sb);
                }
                c11747d.m9904w(interfaceC11472x, sb);
                if (c11747d.getIncludeAdditionalModifiers()) {
                    boolean z5 = false;
                    if (interfaceC11472x.isOperator()) {
                        Collection<? extends InterfaceC11472x> overriddenDescriptors = interfaceC11472x.getOverriddenDescriptors();
                        C12238m.checkNotNullExpressionValue(overriddenDescriptors, "functionDescriptor.overriddenDescriptors");
                        if (!overriddenDescriptors.isEmpty()) {
                            Iterator<T> it = overriddenDescriptors.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z4 = true;
                                    break;
                                } else if (((InterfaceC11472x) it.next()).isOperator()) {
                                    z4 = false;
                                    break;
                                }
                            }
                        } else {
                            z4 = true;
                            break;
                        }
                        if (z4 || c11747d.getAlwaysRenderModifiers()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    if (interfaceC11472x.isInfix()) {
                        Collection<? extends InterfaceC11472x> overriddenDescriptors2 = interfaceC11472x.getOverriddenDescriptors();
                        C12238m.checkNotNullExpressionValue(overriddenDescriptors2, "functionDescriptor.overriddenDescriptors");
                        if (!overriddenDescriptors2.isEmpty()) {
                            Iterator<T> it2 = overriddenDescriptors2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z3 = true;
                                    break;
                                } else if (((InterfaceC11472x) it2.next()).isInfix()) {
                                    z3 = false;
                                    break;
                                }
                            }
                        } else {
                            z3 = true;
                            break;
                        }
                        if (z3 || c11747d.getAlwaysRenderModifiers()) {
                            z5 = true;
                        }
                    }
                    c11747d.m9900s(sb, interfaceC11472x.isTailrec(), "tailrec");
                    c11747d.m9900s(sb, interfaceC11472x.isSuspend(), "suspend");
                    c11747d.m9900s(sb, interfaceC11472x.isInline(), "inline");
                    c11747d.m9900s(sb, z5, "infix");
                    c11747d.m9900s(sb, z2, "operator");
                } else {
                    c11747d.m9900s(sb, interfaceC11472x.isSuspend(), "suspend");
                }
                c11747d.m9896o(interfaceC11472x, sb);
                if (c11747d.getVerbose()) {
                    if (interfaceC11472x.isHiddenToOvercomeSignatureClash()) {
                        sb.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (interfaceC11472x.isHiddenForResolutionEverywhereBesideSupercalls()) {
                        sb.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb.append(c11747d.m9895n("fun"));
            sb.append(" ");
            List<InterfaceC11477z0> typeParameters = interfaceC11472x.getTypeParameters();
            C12238m.checkNotNullExpressionValue(typeParameters, "function.typeParameters");
            c11747d.m9875E(typeParameters, sb, true);
            c11747d.m9907z(interfaceC11472x, sb);
        }
        c11747d.m9901t(interfaceC11472x, sb, true);
        List<InterfaceC11326c1> valueParameters = interfaceC11472x.getValueParameters();
        C12238m.checkNotNullExpressionValue(valueParameters, "function.valueParameters");
        c11747d.m9878H(valueParameters, interfaceC11472x.hasSynthesizedParameterNames(), sb);
        c11747d.m9871A(interfaceC11472x, sb);
        AbstractC11913c0 returnType = interfaceC11472x.getReturnType();
        if (!c11747d.getWithoutReturnType() && (c11747d.getUnitReturnType() || returnType == null || !AbstractC11288h.isUnit(returnType))) {
            sb.append(": ");
            sb.append(returnType == null ? "[NULL]" : c11747d.renderType(returnType));
        }
        List<InterfaceC11477z0> typeParameters2 = interfaceC11472x.getTypeParameters();
        C12238m.checkNotNullExpressionValue(typeParameters2, "function.typeParameters");
        c11747d.m9880J(typeParameters2, sb);
    }

    public static final void access$renderPackageFragment(C11747d c11747d, InterfaceC11331e0 interfaceC11331e0, StringBuilder sb) {
        Objects.requireNonNull(c11747d);
        c11747d.m9905x(interfaceC11331e0.getFqName(), "package-fragment", sb);
        if (c11747d.getDebugMode()) {
            sb.append(" in ");
            c11747d.m9901t(interfaceC11331e0.getContainingDeclaration(), sb, false);
        }
    }

    public static final void access$renderPackageView(C11747d c11747d, InterfaceC11402j0 interfaceC11402j0, StringBuilder sb) {
        Objects.requireNonNull(c11747d);
        c11747d.m9905x(interfaceC11402j0.getFqName(), "package", sb);
        if (c11747d.getDebugMode()) {
            sb.append(" in context of ");
            c11747d.m9901t(interfaceC11402j0.getModule(), sb, false);
        }
    }

    public static final void access$renderProperty(C11747d c11747d, InterfaceC11453n0 interfaceC11453n0, StringBuilder sb) throws IOException {
        if (!c11747d.getStartFromName()) {
            if (!c11747d.getStartFromDeclarationKeyword()) {
                if (c11747d.getModifiers().contains(EnumC11750g.ANNOTATIONS)) {
                    c11747d.m9890h(sb, interfaceC11453n0, null);
                    InterfaceC11468v backingField = interfaceC11453n0.getBackingField();
                    if (backingField != null) {
                        c11747d.m9890h(sb, backingField, EnumC11342e.FIELD);
                    }
                    InterfaceC11468v delegateField = interfaceC11453n0.getDelegateField();
                    if (delegateField != null) {
                        c11747d.m9890h(sb, delegateField, EnumC11342e.PROPERTY_DELEGATE_FIELD);
                    }
                    if (c11747d.getPropertyAccessorRenderingPolicy() == EnumC11758o.NONE) {
                        InterfaceC11455o0 getter = interfaceC11453n0.getGetter();
                        if (getter != null) {
                            c11747d.m9890h(sb, getter, EnumC11342e.PROPERTY_GETTER);
                        }
                        InterfaceC11457p0 setter = interfaceC11453n0.getSetter();
                        if (setter != null) {
                            c11747d.m9890h(sb, setter, EnumC11342e.PROPERTY_SETTER);
                            List<InterfaceC11326c1> valueParameters = setter.getValueParameters();
                            C12238m.checkNotNullExpressionValue(valueParameters, "setter.valueParameters");
                            InterfaceC11326c1 interfaceC11326c1 = (InterfaceC11326c1) C12163u.single((List) valueParameters);
                            C12238m.checkNotNullExpressionValue(interfaceC11326c1, "it");
                            c11747d.m9890h(sb, interfaceC11326c1, EnumC11342e.SETTER_PARAMETER);
                        }
                    }
                }
                AbstractC11466u visibility = interfaceC11453n0.getVisibility();
                C12238m.checkNotNullExpressionValue(visibility, "property.visibility");
                c11747d.m9879I(visibility, sb);
                c11747d.m9900s(sb, c11747d.getModifiers().contains(EnumC11750g.CONST) && interfaceC11453n0.isConst(), "const");
                c11747d.m9897p(interfaceC11453n0, sb);
                c11747d.m9899r(interfaceC11453n0, sb);
                c11747d.m9904w(interfaceC11453n0, sb);
                c11747d.m9900s(sb, c11747d.getModifiers().contains(EnumC11750g.LATEINIT) && interfaceC11453n0.isLateInit(), "lateinit");
                c11747d.m9896o(interfaceC11453n0, sb);
            }
            c11747d.m9876F(interfaceC11453n0, sb, false);
            List<InterfaceC11477z0> typeParameters = interfaceC11453n0.getTypeParameters();
            C12238m.checkNotNullExpressionValue(typeParameters, "property.typeParameters");
            c11747d.m9875E(typeParameters, sb, true);
            c11747d.m9907z(interfaceC11453n0, sb);
        }
        c11747d.m9901t(interfaceC11453n0, sb, true);
        sb.append(": ");
        AbstractC11913c0 type = interfaceC11453n0.getType();
        C12238m.checkNotNullExpressionValue(type, "property.type");
        sb.append(c11747d.renderType(type));
        c11747d.m9871A(interfaceC11453n0, sb);
        c11747d.m9894m(interfaceC11453n0, sb);
        List<InterfaceC11477z0> typeParameters2 = interfaceC11453n0.getTypeParameters();
        C12238m.checkNotNullExpressionValue(typeParameters2, "property.typeParameters");
        c11747d.m9880J(typeParameters2, sb);
    }

    public static final void access$renderTypeAlias(C11747d c11747d, InterfaceC11475y0 interfaceC11475y0, StringBuilder sb) {
        c11747d.m9890h(sb, interfaceC11475y0, null);
        AbstractC11466u visibility = interfaceC11475y0.getVisibility();
        C12238m.checkNotNullExpressionValue(visibility, "typeAlias.visibility");
        c11747d.m9879I(visibility, sb);
        c11747d.m9897p(interfaceC11475y0, sb);
        sb.append(c11747d.m9895n("typealias"));
        sb.append(" ");
        c11747d.m9901t(interfaceC11475y0, sb, true);
        List<InterfaceC11477z0> declaredTypeParameters = interfaceC11475y0.getDeclaredTypeParameters();
        C12238m.checkNotNullExpressionValue(declaredTypeParameters, "typeAlias.declaredTypeParameters");
        c11747d.m9875E(declaredTypeParameters, sb, false);
        c11747d.m9891j(interfaceC11475y0, sb);
        sb.append(" = ");
        sb.append(c11747d.renderType(interfaceC11475y0.getUnderlyingType()));
    }

    /* JADX INFO: renamed from: i */
    public static /* synthetic */ void m9870i(C11747d c11747d, StringBuilder sb, InterfaceC11338a interfaceC11338a, EnumC11342e enumC11342e, int i) {
        int i2 = i & 2;
        c11747d.m9890h(sb, interfaceC11338a, null);
    }

    /* JADX INFO: renamed from: A */
    public final void m9871A(InterfaceC11318a interfaceC11318a, StringBuilder sb) {
        InterfaceC11459q0 extensionReceiverParameter;
        if (getReceiverAfterName() && (extensionReceiverParameter = interfaceC11318a.getExtensionReceiverParameter()) != null) {
            sb.append(" on ");
            AbstractC11913c0 type = extensionReceiverParameter.getType();
            C12238m.checkNotNullExpressionValue(type, "receiver.type");
            sb.append(renderType(type));
        }
    }

    /* JADX INFO: renamed from: B */
    public final void m9872B(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    /* JADX INFO: renamed from: C */
    public final void m9873C(InterfaceC11477z0 interfaceC11477z0, StringBuilder sb, boolean z2) {
        if (z2) {
            sb.append(m9888f());
        }
        if (getVerbose()) {
            sb.append("/*");
            sb.append(interfaceC11477z0.getIndex());
            sb.append("*/ ");
        }
        m9900s(sb, interfaceC11477z0.isReified(), "reified");
        String label = interfaceC11477z0.getVariance().getLabel();
        boolean z3 = true;
        m9900s(sb, label.length() > 0, label);
        m9890h(sb, interfaceC11477z0, null);
        m9901t(interfaceC11477z0, sb, z2);
        int size = interfaceC11477z0.getUpperBounds().size();
        if ((size > 1 && !z2) || size == 1) {
            AbstractC11913c0 next = interfaceC11477z0.getUpperBounds().iterator().next();
            if (!AbstractC11288h.isDefaultBound(next)) {
                sb.append(" : ");
                C12238m.checkNotNullExpressionValue(next, "upperBound");
                sb.append(renderType(next));
            }
        } else if (z2) {
            for (AbstractC11913c0 abstractC11913c0 : interfaceC11477z0.getUpperBounds()) {
                if (!AbstractC11288h.isDefaultBound(abstractC11913c0)) {
                    if (z3) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    C12238m.checkNotNullExpressionValue(abstractC11913c0, "upperBound");
                    sb.append(renderType(abstractC11913c0));
                    z3 = false;
                }
            }
        }
        if (z2) {
            sb.append(m9886d());
        }
    }

    /* JADX INFO: renamed from: D */
    public final void m9874D(StringBuilder sb, List<? extends InterfaceC11477z0> list) {
        Iterator<? extends InterfaceC11477z0> it = list.iterator();
        while (it.hasNext()) {
            m9873C(it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    /* JADX INFO: renamed from: E */
    public final void m9875E(List<? extends InterfaceC11477z0> list, StringBuilder sb, boolean z2) {
        if (!getWithoutTypeParameters() && (!list.isEmpty())) {
            sb.append(m9888f());
            m9874D(sb, list);
            sb.append(m9886d());
            if (z2) {
                sb.append(" ");
            }
        }
    }

    /* JADX INFO: renamed from: F */
    public final void m9876F(InterfaceC11329d1 interfaceC11329d1, StringBuilder sb, boolean z2) {
        if (z2 || !(interfaceC11329d1 instanceof InterfaceC11326c1)) {
            sb.append(m9895n(interfaceC11329d1.isVar() ? "var" : "val"));
            sb.append(" ");
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0067  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e4  */
    /* JADX INFO: renamed from: G */
    public final void m9877G(InterfaceC11326c1 interfaceC11326c1, boolean z2, StringBuilder sb, boolean z3) {
        boolean z4;
        boolean z5;
        if (z3) {
            sb.append(m9895n("value-parameter"));
            sb.append(" ");
        }
        if (getVerbose()) {
            sb.append("/*");
            sb.append(interfaceC11326c1.getIndex());
            sb.append("*/ ");
        }
        m9890h(sb, interfaceC11326c1, null);
        m9900s(sb, interfaceC11326c1.isCrossinline(), "crossinline");
        m9900s(sb, interfaceC11326c1.isNoinline(), "noinline");
        if (getRenderPrimaryConstructorParametersAsProperties()) {
            InterfaceC11318a containingDeclaration = interfaceC11326c1.getContainingDeclaration();
            InterfaceC11327d interfaceC11327d = containingDeclaration instanceof InterfaceC11327d ? (InterfaceC11327d) containingDeclaration : null;
            if (C12238m.areEqual(interfaceC11327d == null ? null : Boolean.valueOf(interfaceC11327d.isPrimary()), Boolean.TRUE)) {
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            z4 = false;
        }
        if (z4) {
            m9900s(sb, getActualPropertiesInPrimaryConstructor(), "actual");
        }
        AbstractC11913c0 type = interfaceC11326c1.getType();
        C12238m.checkNotNullExpressionValue(type, "variable.type");
        AbstractC11913c0 varargElementType = interfaceC11326c1 != null ? interfaceC11326c1.getVarargElementType() : null;
        AbstractC11913c0 abstractC11913c0 = varargElementType == null ? type : varargElementType;
        m9900s(sb, varargElementType != null, "vararg");
        if (z4 || (z3 && !getStartFromName())) {
            m9876F(interfaceC11326c1, sb, z4);
        }
        if (z2) {
            m9901t(interfaceC11326c1, sb, z3);
            sb.append(": ");
        }
        sb.append(renderType(abstractC11913c0));
        m9894m(interfaceC11326c1, sb);
        if (getVerbose() && varargElementType != null) {
            sb.append(" /*");
            sb.append(renderType(type));
            sb.append("*/");
        }
        if (getDefaultParameterValueRenderer() != null) {
            z5 = getDebugMode() ? interfaceC11326c1.declaresDefaultValue() : C11836a.declaresOrInheritsDefaultValue(interfaceC11326c1);
        }
        if (z5) {
            Function1<InterfaceC11326c1, String> defaultParameterValueRenderer = getDefaultParameterValueRenderer();
            C12238m.checkNotNull(defaultParameterValueRenderer);
            sb.append(C12238m.stringPlus(" = ", defaultParameterValueRenderer.invoke(interfaceC11326c1)));
        }
    }

    /* JADX INFO: renamed from: H */
    public final void m9878H(Collection<? extends InterfaceC11326c1> collection, boolean z2, StringBuilder sb) {
        int iOrdinal = getParameterNameRenderingPolicy().ordinal();
        boolean z3 = true;
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (z2) {
            }
            z3 = false;
        }
        int size = collection.size();
        getValueParametersHandler().appendBeforeValueParameters(size, sb);
        int i = 0;
        for (InterfaceC11326c1 interfaceC11326c1 : collection) {
            getValueParametersHandler().appendBeforeValueParameter(interfaceC11326c1, i, size, sb);
            m9877G(interfaceC11326c1, z3, sb, false);
            getValueParametersHandler().appendAfterValueParameter(interfaceC11326c1, i, size, sb);
            i++;
        }
        getValueParametersHandler().appendAfterValueParameters(size, sb);
    }

    /* JADX INFO: renamed from: I */
    public final boolean m9879I(AbstractC11466u abstractC11466u, StringBuilder sb) {
        if (!getModifiers().contains(EnumC11750g.VISIBILITY)) {
            return false;
        }
        if (getNormalizedVisibilities()) {
            abstractC11466u = abstractC11466u.normalize();
        }
        if (!getRenderDefaultVisibility() && C12238m.areEqual(abstractC11466u, C11464t.f23093k)) {
            return false;
        }
        sb.append(m9895n(abstractC11466u.getInternalDisplayName()));
        sb.append(" ");
        return true;
    }

    /* JADX INFO: renamed from: J */
    public final void m9880J(List<? extends InterfaceC11477z0> list, StringBuilder sb) throws IOException {
        if (getWithoutTypeParameters()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        for (InterfaceC11477z0 interfaceC11477z0 : list) {
            List<AbstractC11913c0> upperBounds = interfaceC11477z0.getUpperBounds();
            C12238m.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
            for (AbstractC11913c0 abstractC11913c0 : C12163u.drop(upperBounds, 1)) {
                StringBuilder sb2 = new StringBuilder();
                C11716e name = interfaceC11477z0.getName();
                C12238m.checkNotNullExpressionValue(name, "typeParameter.name");
                sb2.append(renderName(name, false));
                sb2.append(" : ");
                C12238m.checkNotNullExpressionValue(abstractC11913c0, "it");
                sb2.append(renderType(abstractC11913c0));
                arrayList.add(sb2.toString());
            }
        }
        if (!arrayList.isEmpty()) {
            sb.append(" ");
            sb.append(m9895n("where"));
            sb.append(" ");
            C12163u.joinTo(arrayList, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
    }

    /* JADX INFO: renamed from: K */
    public final String m9881K(String str, String str2, String str3, String str4, String str5) {
        if (C12103t.startsWith$default(str, str2, false, 2, null) && C12103t.startsWith$default(str3, str4, false, 2, null)) {
            int length = str2.length();
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = str.substring(length);
            C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            int length2 = str4.length();
            Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
            String strSubstring2 = str3.substring(length2);
            C12238m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            String strStringPlus = C12238m.stringPlus(str5, strSubstring);
            if (C12238m.areEqual(strSubstring, strSubstring2)) {
                return strStringPlus;
            }
            if (m9884b(strSubstring, strSubstring2)) {
                return C12238m.stringPlus(strStringPlus, "!");
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: L */
    public final boolean m9882L(AbstractC11913c0 abstractC11913c0) {
        boolean z2;
        if (!C11287g.isBuiltinFunctionalType(abstractC11913c0)) {
            return false;
        }
        List<InterfaceC12012w0> arguments = abstractC11913c0.getArguments();
        if ((arguments instanceof Collection) && arguments.isEmpty()) {
            z2 = true;
        } else {
            Iterator<T> it = arguments.iterator();
            while (it.hasNext()) {
                if (((InterfaceC12012w0) it.next()).isStarProjection()) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    /* JADX INFO: renamed from: a */
    public final void m9883a(StringBuilder sb, List<? extends InterfaceC12012w0> list) throws IOException {
        C12163u.joinTo(list, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new b());
    }

    /* JADX INFO: renamed from: b */
    public final boolean m9884b(String str, String str2) {
        if (!C12238m.areEqual(str, C12103t.replace$default(str2, "?", "", false, 4, (Object) null)) && (!C12103t.endsWith$default(str2, "?", false, 2, null) || !C12238m.areEqual(C12238m.stringPlus(str, "?"), str2))) {
            if (!C12238m.areEqual('(' + str + ")?", str2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    public final String m9885c(String str) {
        return getTextFormat().escape(str);
    }

    /* JADX INFO: renamed from: d */
    public final String m9886d() {
        return getTextFormat().escape(">");
    }

    /* JADX INFO: renamed from: e */
    public final EnumC11476z m9887e(InterfaceC11474y interfaceC11474y) {
        EnumC11333f enumC11333f = EnumC11333f.INTERFACE;
        if (interfaceC11474y instanceof InterfaceC11330e) {
            return ((InterfaceC11330e) interfaceC11474y).getKind() == enumC11333f ? EnumC11476z.ABSTRACT : EnumC11476z.FINAL;
        }
        InterfaceC11450m containingDeclaration = interfaceC11474y.getContainingDeclaration();
        InterfaceC11330e interfaceC11330e = containingDeclaration instanceof InterfaceC11330e ? (InterfaceC11330e) containingDeclaration : null;
        if (interfaceC11330e != null && (interfaceC11474y instanceof InterfaceC11321b)) {
            InterfaceC11321b interfaceC11321b = (InterfaceC11321b) interfaceC11474y;
            Collection<? extends InterfaceC11321b> overriddenDescriptors = interfaceC11321b.getOverriddenDescriptors();
            C12238m.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
            if ((!overriddenDescriptors.isEmpty()) && interfaceC11330e.getModality() != EnumC11476z.FINAL) {
                return EnumC11476z.OPEN;
            }
            if (interfaceC11330e.getKind() != enumC11333f || C12238m.areEqual(interfaceC11321b.getVisibility(), C11464t.f23083a)) {
                return EnumC11476z.FINAL;
            }
            EnumC11476z modality = interfaceC11321b.getModality();
            EnumC11476z enumC11476z = EnumC11476z.ABSTRACT;
            return modality == enumC11476z ? enumC11476z : EnumC11476z.OPEN;
        }
        return EnumC11476z.FINAL;
    }

    /* JADX INFO: renamed from: f */
    public final String m9888f() {
        return getTextFormat().escape("<");
    }

    /* JADX INFO: renamed from: g */
    public final void m9889g(StringBuilder sb, C11906a c11906a) {
        EnumC11759p textFormat = getTextFormat();
        EnumC11759p enumC11759p = EnumC11759p.HTML;
        if (textFormat == enumC11759p) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* = ");
        m9903v(sb, c11906a.getExpandedType());
        sb.append(" */");
        if (getTextFormat() == enumC11759p) {
            sb.append("</i></font>");
        }
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return this.f24239d.getActualPropertiesInPrimaryConstructor();
    }

    public boolean getAlwaysRenderModifiers() {
        return this.f24239d.getAlwaysRenderModifiers();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public EnumC11744a getAnnotationArgumentsRenderingPolicy() {
        return this.f24239d.getAnnotationArgumentsRenderingPolicy();
    }

    public Function1<InterfaceC11340c, Boolean> getAnnotationFilter() {
        return this.f24239d.getAnnotationFilter();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return this.f24239d.getBoldOnlyForNamesInHtml();
    }

    public boolean getClassWithPrimaryConstructor() {
        return this.f24239d.getClassWithPrimaryConstructor();
    }

    public InterfaceC11745b getClassifierNamePolicy() {
        return this.f24239d.getClassifierNamePolicy();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public boolean getDebugMode() {
        return this.f24239d.getDebugMode();
    }

    public Function1<InterfaceC11326c1, String> getDefaultParameterValueRenderer() {
        return this.f24239d.getDefaultParameterValueRenderer();
    }

    public boolean getEachAnnotationOnNewLine() {
        return this.f24239d.getEachAnnotationOnNewLine();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public boolean getEnhancedTypes() {
        return this.f24239d.getEnhancedTypes();
    }

    public Set<C11713b> getExcludedAnnotationClasses() {
        return this.f24239d.getExcludedAnnotationClasses();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public Set<C11713b> getExcludedTypeAnnotationClasses() {
        return this.f24239d.getExcludedTypeAnnotationClasses();
    }

    public boolean getIncludeAdditionalModifiers() {
        return this.f24239d.getIncludeAdditionalModifiers();
    }

    public boolean getIncludeAnnotationArguments() {
        return this.f24239d.getIncludeAnnotationArguments();
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return this.f24239d.getIncludeEmptyAnnotationArguments();
    }

    public boolean getIncludePropertyConstant() {
        return this.f24239d.getIncludePropertyConstant();
    }

    public boolean getInformativeErrorType() {
        return this.f24239d.getInformativeErrorType();
    }

    public Set<EnumC11750g> getModifiers() {
        return this.f24239d.getModifiers();
    }

    public boolean getNormalizedVisibilities() {
        return this.f24239d.getNormalizedVisibilities();
    }

    public final C11752i getOptions() {
        return this.f24239d;
    }

    public EnumC11756m getOverrideRenderingPolicy() {
        return this.f24239d.getOverrideRenderingPolicy();
    }

    public EnumC11757n getParameterNameRenderingPolicy() {
        return this.f24239d.getParameterNameRenderingPolicy();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return this.f24239d.getParameterNamesInFunctionalTypes();
    }

    public boolean getPresentableUnresolvedTypes() {
        return this.f24239d.getPresentableUnresolvedTypes();
    }

    public EnumC11758o getPropertyAccessorRenderingPolicy() {
        return this.f24239d.getPropertyAccessorRenderingPolicy();
    }

    public boolean getReceiverAfterName() {
        return this.f24239d.getReceiverAfterName();
    }

    public boolean getRenderCompanionObjectName() {
        return this.f24239d.getRenderCompanionObjectName();
    }

    public boolean getRenderConstructorDelegation() {
        return this.f24239d.getRenderConstructorDelegation();
    }

    public boolean getRenderConstructorKeyword() {
        return this.f24239d.getRenderConstructorKeyword();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return this.f24239d.getRenderDefaultAnnotationArguments();
    }

    public boolean getRenderDefaultModality() {
        return this.f24239d.getRenderDefaultModality();
    }

    public boolean getRenderDefaultVisibility() {
        return this.f24239d.getRenderDefaultVisibility();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return this.f24239d.getRenderPrimaryConstructorParametersAsProperties();
    }

    public boolean getRenderTypeExpansions() {
        return this.f24239d.getRenderTypeExpansions();
    }

    public boolean getRenderUnabbreviatedType() {
        return this.f24239d.getRenderUnabbreviatedType();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return this.f24239d.getSecondaryConstructorsAsPrimary();
    }

    public boolean getStartFromDeclarationKeyword() {
        return this.f24239d.getStartFromDeclarationKeyword();
    }

    public boolean getStartFromName() {
        return this.f24239d.getStartFromName();
    }

    public EnumC11759p getTextFormat() {
        return this.f24239d.getTextFormat();
    }

    public Function1<AbstractC11913c0, AbstractC11913c0> getTypeNormalizer() {
        return this.f24239d.getTypeNormalizer();
    }

    public boolean getUninferredTypeParameterAsName() {
        return this.f24239d.getUninferredTypeParameterAsName();
    }

    public boolean getUnitReturnType() {
        return this.f24239d.getUnitReturnType();
    }

    public AbstractC11746c.l getValueParametersHandler() {
        return this.f24239d.getValueParametersHandler();
    }

    public boolean getVerbose() {
        return this.f24239d.getVerbose();
    }

    public boolean getWithDefinedIn() {
        return this.f24239d.getWithDefinedIn();
    }

    public boolean getWithSourceFileForTopLevel() {
        return this.f24239d.getWithSourceFileForTopLevel();
    }

    public boolean getWithoutReturnType() {
        return this.f24239d.getWithoutReturnType();
    }

    public boolean getWithoutSuperTypes() {
        return this.f24239d.getWithoutSuperTypes();
    }

    public boolean getWithoutTypeParameters() {
        return this.f24239d.getWithoutTypeParameters();
    }

    /* JADX INFO: renamed from: h */
    public final void m9890h(StringBuilder sb, InterfaceC11338a interfaceC11338a, EnumC11342e enumC11342e) {
        if (getModifiers().contains(EnumC11750g.ANNOTATIONS)) {
            Set<C11713b> excludedTypeAnnotationClasses = interfaceC11338a instanceof AbstractC11913c0 ? getExcludedTypeAnnotationClasses() : getExcludedAnnotationClasses();
            Function1<InterfaceC11340c, Boolean> annotationFilter = getAnnotationFilter();
            for (InterfaceC11340c interfaceC11340c : interfaceC11338a.getAnnotations()) {
                if (!C12163u.contains(excludedTypeAnnotationClasses, interfaceC11340c.getFqName()) && !C12238m.areEqual(interfaceC11340c.getFqName(), C11291k.a.f22570y) && (annotationFilter == null || annotationFilter.invoke(interfaceC11340c).booleanValue())) {
                    sb.append(renderAnnotation(interfaceC11340c, enumC11342e));
                    if (getEachAnnotationOnNewLine()) {
                        sb.append('\n');
                        C12238m.checkNotNullExpressionValue(sb, "append('\\n')");
                    } else {
                        sb.append(" ");
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public final void m9891j(InterfaceC11359i interfaceC11359i, StringBuilder sb) {
        List<InterfaceC11477z0> declaredTypeParameters = interfaceC11359i.getDeclaredTypeParameters();
        C12238m.checkNotNullExpressionValue(declaredTypeParameters, "classifier.declaredTypeParameters");
        List<InterfaceC11477z0> parameters = interfaceC11359i.getTypeConstructor().getParameters();
        C12238m.checkNotNullExpressionValue(parameters, "classifier.typeConstructor.parameters");
        if (getVerbose() && interfaceC11359i.isInner() && parameters.size() > declaredTypeParameters.size()) {
            sb.append(" /*captured type parameters: ");
            m9874D(sb, parameters.subList(declaredTypeParameters.size(), parameters.size()));
            sb.append("*/");
        }
    }

    /* JADX INFO: renamed from: k */
    public final String m9892k(AbstractC11815g<?> abstractC11815g) {
        if (abstractC11815g instanceof C11809b) {
            return C12163u.joinToString$default(((C11809b) abstractC11815g).getValue(), ", ", "{", "}", 0, null, new d(), 24, null);
        }
        if (abstractC11815g instanceof C11807a) {
            return C12106w.removePrefix(AbstractC11746c.renderAnnotation$default(this, ((C11807a) abstractC11815g).getValue(), null, 2, null), "@");
        }
        if (!(abstractC11815g instanceof C11826r)) {
            return abstractC11815g.toString();
        }
        C11826r.b value = ((C11826r) abstractC11815g).getValue();
        if (value instanceof C11826r.b.a) {
            return ((C11826r.b.a) value).getType() + "::class";
        }
        if (!(value instanceof C11826r.b.C13329b)) {
            throw new NoWhenBranchMatchedException();
        }
        C11826r.b.C13329b c13329b = (C11826r.b.C13329b) value;
        String strAsString = c13329b.getClassId().asSingleFqName().asString();
        C12238m.checkNotNullExpressionValue(strAsString, "classValue.classId.asSingleFqName().asString()");
        for (int i = 0; i < c13329b.getArrayDimensions(); i++) {
            strAsString = "kotlin.Array<" + strAsString + '>';
        }
        return C12238m.stringPlus(strAsString, "::class");
    }

    /* JADX INFO: renamed from: l */
    public final void m9893l(StringBuilder sb, AbstractC11913c0 abstractC11913c0) {
        m9890h(sb, abstractC11913c0, null);
        if (C11919e0.isError(abstractC11913c0)) {
            if ((abstractC11913c0 instanceof C11929h1) && getPresentableUnresolvedTypes()) {
                sb.append(((C11929h1) abstractC11913c0).getPresentableName());
            } else if (!(abstractC11913c0 instanceof C12003s) || getInformativeErrorType()) {
                sb.append(abstractC11913c0.getConstructor().toString());
            } else {
                sb.append(((C12003s) abstractC11913c0).getPresentableName());
            }
            sb.append(renderTypeArguments(abstractC11913c0.getArguments()));
        } else {
            InterfaceC12008u0 constructor = abstractC11913c0.getConstructor();
            C11449l0 c11449l0BuildPossiblyInnerType = C11320a1.buildPossiblyInnerType(abstractC11913c0);
            if (c11449l0BuildPossiblyInnerType == null) {
                sb.append(renderTypeConstructor(constructor));
                sb.append(renderTypeArguments(abstractC11913c0.getArguments()));
            } else {
                m9906y(sb, c11449l0BuildPossiblyInnerType);
            }
        }
        if (abstractC11913c0.isMarkedNullable()) {
            sb.append("?");
        }
        if (C11968m0.isDefinitelyNotNullType(abstractC11913c0)) {
            sb.append("!!");
        }
    }

    /* JADX INFO: renamed from: m */
    public final void m9894m(InterfaceC11329d1 interfaceC11329d1, StringBuilder sb) {
        AbstractC11815g<?> compileTimeInitializer;
        if (!getIncludePropertyConstant() || (compileTimeInitializer = interfaceC11329d1.getCompileTimeInitializer()) == null) {
            return;
        }
        sb.append(" = ");
        sb.append(m9885c(m9892k(compileTimeInitializer)));
    }

    /* JADX INFO: renamed from: n */
    public final String m9895n(String str) {
        int iOrdinal = getTextFormat().ordinal();
        if (iOrdinal == 0) {
            return str;
        }
        if (iOrdinal == 1) {
            return getBoldOnlyForNamesInHtml() ? str : C1643a.m886y("<b>", str, "</b>");
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: o */
    public final void m9896o(InterfaceC11321b interfaceC11321b, StringBuilder sb) {
        if (getModifiers().contains(EnumC11750g.MEMBER_KIND) && getVerbose() && interfaceC11321b.getKind() != InterfaceC11321b.a.DECLARATION) {
            sb.append("/*");
            String strName = interfaceC11321b.getKind().name();
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strName.toLowerCase();
            C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            sb.append(lowerCase);
            sb.append("*/ ");
        }
    }

    /* JADX INFO: renamed from: p */
    public final void m9897p(InterfaceC11474y interfaceC11474y, StringBuilder sb) {
        m9900s(sb, interfaceC11474y.isExternal(), "external");
        boolean z2 = false;
        m9900s(sb, getModifiers().contains(EnumC11750g.EXPECT) && interfaceC11474y.isExpect(), "expect");
        if (getModifiers().contains(EnumC11750g.ACTUAL) && interfaceC11474y.isActual()) {
            z2 = true;
        }
        m9900s(sb, z2, "actual");
    }

    /* JADX INFO: renamed from: q */
    public final void m9898q(EnumC11476z enumC11476z, StringBuilder sb, EnumC11476z enumC11476z2) {
        if (getRenderDefaultModality() || enumC11476z != enumC11476z2) {
            boolean zContains = getModifiers().contains(EnumC11750g.MODALITY);
            String strName = enumC11476z.name();
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strName.toLowerCase();
            C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            m9900s(sb, zContains, lowerCase);
        }
    }

    /* JADX INFO: renamed from: r */
    public final void m9899r(InterfaceC11321b interfaceC11321b, StringBuilder sb) {
        if (C11787e.isTopLevelDeclaration(interfaceC11321b) && interfaceC11321b.getModality() == EnumC11476z.FINAL) {
            return;
        }
        if (getOverrideRenderingPolicy() == EnumC11756m.RENDER_OVERRIDE && interfaceC11321b.getModality() == EnumC11476z.OPEN && (!interfaceC11321b.getOverriddenDescriptors().isEmpty())) {
            return;
        }
        EnumC11476z modality = interfaceC11321b.getModality();
        C12238m.checkNotNullExpressionValue(modality, "callable.modality");
        m9898q(modality, sb, m9887e(interfaceC11321b));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c
    public String render(InterfaceC11450m interfaceC11450m) {
        String name;
        C12238m.checkNotNullParameter(interfaceC11450m, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        interfaceC11450m.accept(new a(this), sb);
        if (getWithDefinedIn() && !(interfaceC11450m instanceof InterfaceC11331e0) && !(interfaceC11450m instanceof InterfaceC11402j0)) {
            if (interfaceC11450m instanceof InterfaceC11325c0) {
                sb.append(" is a module");
            } else {
                InterfaceC11450m containingDeclaration = interfaceC11450m.getContainingDeclaration();
                if (containingDeclaration != null && !(containingDeclaration instanceof InterfaceC11325c0)) {
                    sb.append(" ");
                    sb.append(renderMessage("defined in"));
                    sb.append(" ");
                    C11714c fqName = C11787e.getFqName(containingDeclaration);
                    C12238m.checkNotNullExpressionValue(fqName, "getFqName(containingDeclaration)");
                    sb.append(fqName.isRoot() ? "root package" : renderFqName(fqName));
                    if (getWithSourceFileForTopLevel() && (containingDeclaration instanceof InterfaceC11331e0) && (interfaceC11450m instanceof InterfaceC11456p) && (name = ((InterfaceC11469v0.a) ((InterfaceC11456p) interfaceC11450m).getSource().getContainingFile()).getName()) != null) {
                        sb.append(" ");
                        sb.append(renderMessage("in file"));
                        sb.append(" ");
                        sb.append(name);
                    }
                }
            }
        }
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c
    public String renderAnnotation(InterfaceC11340c interfaceC11340c, EnumC11342e enumC11342e) throws IOException {
        InterfaceC11327d unsubstitutedPrimaryConstructor;
        C12238m.checkNotNullParameter(interfaceC11340c, "annotation");
        StringBuilder sb = new StringBuilder();
        sb.append(MentionUtilsKt.MENTIONS_CHAR);
        if (enumC11342e != null) {
            sb.append(C12238m.stringPlus(enumC11342e.getRenderName(), ":"));
        }
        AbstractC11913c0 type = interfaceC11340c.getType();
        sb.append(renderType(type));
        if (getIncludeAnnotationArguments()) {
            Map<C11716e, AbstractC11815g<?>> allValueArguments = interfaceC11340c.getAllValueArguments();
            List listEmptyList = null;
            InterfaceC11330e annotationClass = getRenderDefaultAnnotationArguments() ? C11836a.getAnnotationClass(interfaceC11340c) : null;
            List<InterfaceC11326c1> valueParameters = (annotationClass == null || (unsubstitutedPrimaryConstructor = annotationClass.getUnsubstitutedPrimaryConstructor()) == null) ? null : unsubstitutedPrimaryConstructor.getValueParameters();
            if (valueParameters != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : valueParameters) {
                    if (((InterfaceC11326c1) obj).declaresDefaultValue()) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((InterfaceC11326c1) it.next()).getName());
                }
                listEmptyList = arrayList2;
            }
            if (listEmptyList == null) {
                listEmptyList = C12147n.emptyList();
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : listEmptyList) {
                C11716e c11716e = (C11716e) obj2;
                C12238m.checkNotNullExpressionValue(c11716e, "it");
                if (!allValueArguments.containsKey(c11716e)) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(C12238m.stringPlus(((C11716e) it2.next()).asString(), " = ..."));
            }
            Set<Map.Entry<C11716e, AbstractC11815g<?>>> setEntrySet = allValueArguments.entrySet();
            ArrayList arrayList5 = new ArrayList(C12149o.collectionSizeOrDefault(setEntrySet, 10));
            Iterator<T> it3 = setEntrySet.iterator();
            while (it3.hasNext()) {
                Map.Entry entry = (Map.Entry) it3.next();
                C11716e c11716e2 = (C11716e) entry.getKey();
                AbstractC11815g<?> abstractC11815g = (AbstractC11815g) entry.getValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(c11716e2.asString());
                sb2.append(" = ");
                sb2.append(!listEmptyList.contains(c11716e2) ? m9892k(abstractC11815g) : "...");
                arrayList5.add(sb2.toString());
            }
            List listSorted = C12163u.sorted(C12163u.plus((Collection) arrayList4, (Iterable) arrayList5));
            if (getIncludeEmptyAnnotationArguments() || (!listSorted.isEmpty())) {
                C12163u.joinTo(listSorted, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
            }
        }
        if (getVerbose() && (C11919e0.isError(type) || (type.getConstructor().getDeclarationDescriptor() instanceof C11328d0.b))) {
            sb.append(" /* annotation class not found */");
        }
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public String renderClassifierName(InterfaceC11352h interfaceC11352h) {
        C12238m.checkNotNullParameter(interfaceC11352h, "klass");
        return C12005t.isError(interfaceC11352h) ? interfaceC11352h.getTypeConstructor().toString() : getClassifierNamePolicy().renderClassifier(interfaceC11352h, this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c
    public String renderFlexibleType(String str, String str2, AbstractC11288h abstractC11288h) {
        C12238m.checkNotNullParameter(str, "lowerRendered");
        C12238m.checkNotNullParameter(str2, "upperRendered");
        C12238m.checkNotNullParameter(abstractC11288h, "builtIns");
        if (m9884b(str, str2)) {
            if (!C12103t.startsWith$default(str2, "(", false, 2, null)) {
                return C12238m.stringPlus(str, "!");
            }
            return '(' + str + ")!";
        }
        InterfaceC11745b classifierNamePolicy = getClassifierNamePolicy();
        InterfaceC11330e collection = abstractC11288h.getCollection();
        C12238m.checkNotNullExpressionValue(collection, "builtIns.collection");
        String strSubstringBefore$default = C12106w.substringBefore$default(classifierNamePolicy.renderClassifier(collection, this), "Collection", (String) null, 2, (Object) null);
        String strM9881K = m9881K(str, C12238m.stringPlus(strSubstringBefore$default, "Mutable"), str2, strSubstringBefore$default, strSubstringBefore$default + "(Mutable)");
        if (strM9881K != null) {
            return strM9881K;
        }
        String strM9881K2 = m9881K(str, C12238m.stringPlus(strSubstringBefore$default, "MutableMap.MutableEntry"), str2, C12238m.stringPlus(strSubstringBefore$default, "Map.Entry"), C12238m.stringPlus(strSubstringBefore$default, "(Mutable)Map.(Mutable)Entry"));
        if (strM9881K2 != null) {
            return strM9881K2;
        }
        InterfaceC11745b classifierNamePolicy2 = getClassifierNamePolicy();
        InterfaceC11330e array = abstractC11288h.getArray();
        C12238m.checkNotNullExpressionValue(array, "builtIns.array");
        String strSubstringBefore$default2 = C12106w.substringBefore$default(classifierNamePolicy2.renderClassifier(array, this), "Array", (String) null, 2, (Object) null);
        String strM9881K3 = m9881K(str, C12238m.stringPlus(strSubstringBefore$default2, getTextFormat().escape("Array<")), str2, C12238m.stringPlus(strSubstringBefore$default2, getTextFormat().escape("Array<out ")), C12238m.stringPlus(strSubstringBefore$default2, getTextFormat().escape("Array<(out) ")));
        if (strM9881K3 != null) {
            return strM9881K3;
        }
        return '(' + str + ".." + str2 + ')';
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c
    public String renderFqName(C11714c c11714c) {
        C12238m.checkNotNullParameter(c11714c, "fqName");
        List<C11716e> listPathSegments = c11714c.pathSegments();
        C12238m.checkNotNullExpressionValue(listPathSegments, "fqName.pathSegments()");
        return m9885c(C11760q.renderFqName(listPathSegments));
    }

    public String renderMessage(String str) {
        C12238m.checkNotNullParameter(str, "message");
        int iOrdinal = getTextFormat().ordinal();
        if (iOrdinal == 0) {
            return str;
        }
        if (iOrdinal == 1) {
            return C1643a.m886y("<i>", str, "</i>");
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c
    public String renderName(C11716e c11716e, boolean z2) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strM9885c = m9885c(C11760q.render(c11716e));
        return (getBoldOnlyForNamesInHtml() && getTextFormat() == EnumC11759p.HTML && z2) ? C1643a.m886y("<b>", strM9885c, "</b>") : strM9885c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c
    public String renderType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "type");
        StringBuilder sb = new StringBuilder();
        m9902u(sb, getTypeNormalizer().invoke(abstractC11913c0));
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public String renderTypeArguments(List<? extends InterfaceC12012w0> list) throws IOException {
        C12238m.checkNotNullParameter(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m9888f());
        m9883a(sb, list);
        sb.append(m9886d());
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public String renderTypeConstructor(InterfaceC12008u0 interfaceC12008u0) {
        C12238m.checkNotNullParameter(interfaceC12008u0, "typeConstructor");
        InterfaceC11352h declarationDescriptor = interfaceC12008u0.getDeclarationDescriptor();
        if (declarationDescriptor instanceof InterfaceC11477z0 ? true : declarationDescriptor instanceof InterfaceC11330e ? true : declarationDescriptor instanceof InterfaceC11475y0) {
            return renderClassifierName(declarationDescriptor);
        }
        if (declarationDescriptor == null) {
            return interfaceC12008u0.toString();
        }
        throw new IllegalStateException(C12238m.stringPlus("Unexpected classifier: ", declarationDescriptor.getClass()).toString());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c
    public String renderTypeProjection(InterfaceC12012w0 interfaceC12012w0) throws IOException {
        C12238m.checkNotNullParameter(interfaceC12012w0, "typeProjection");
        StringBuilder sb = new StringBuilder();
        m9883a(sb, C12145m.listOf(interfaceC12012w0));
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX INFO: renamed from: s */
    public final void m9900s(StringBuilder sb, boolean z2, String str) {
        if (z2) {
            sb.append(m9895n(str));
            sb.append(" ");
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setAnnotationArgumentsRenderingPolicy(EnumC11744a enumC11744a) {
        C12238m.checkNotNullParameter(enumC11744a, "<set-?>");
        this.f24239d.setAnnotationArgumentsRenderingPolicy(enumC11744a);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setClassifierNamePolicy(InterfaceC11745b interfaceC11745b) {
        C12238m.checkNotNullParameter(interfaceC11745b, "<set-?>");
        this.f24239d.setClassifierNamePolicy(interfaceC11745b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setDebugMode(boolean z2) {
        this.f24239d.setDebugMode(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setExcludedTypeAnnotationClasses(Set<C11713b> set) {
        C12238m.checkNotNullParameter(set, "<set-?>");
        this.f24239d.setExcludedTypeAnnotationClasses(set);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setModifiers(Set<? extends EnumC11750g> set) {
        C12238m.checkNotNullParameter(set, "<set-?>");
        this.f24239d.setModifiers(set);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setParameterNameRenderingPolicy(EnumC11757n enumC11757n) {
        C12238m.checkNotNullParameter(enumC11757n, "<set-?>");
        this.f24239d.setParameterNameRenderingPolicy(enumC11757n);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setReceiverAfterName(boolean z2) {
        this.f24239d.setReceiverAfterName(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setRenderCompanionObjectName(boolean z2) {
        this.f24239d.setRenderCompanionObjectName(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setStartFromName(boolean z2) {
        this.f24239d.setStartFromName(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setTextFormat(EnumC11759p enumC11759p) {
        C12238m.checkNotNullParameter(enumC11759p, "<set-?>");
        this.f24239d.setTextFormat(enumC11759p);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setWithDefinedIn(boolean z2) {
        this.f24239d.setWithDefinedIn(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setWithoutSuperTypes(boolean z2) {
        this.f24239d.setWithoutSuperTypes(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setWithoutTypeParameters(boolean z2) {
        this.f24239d.setWithoutTypeParameters(z2);
    }

    /* JADX INFO: renamed from: t */
    public final void m9901t(InterfaceC11450m interfaceC11450m, StringBuilder sb, boolean z2) {
        C11716e name = interfaceC11450m.getName();
        C12238m.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(renderName(name, z2));
    }

    /* JADX INFO: renamed from: u */
    public final void m9902u(StringBuilder sb, AbstractC11913c0 abstractC11913c0) {
        AbstractC11932i1 abstractC11932i1Unwrap = abstractC11913c0.unwrap();
        C11906a c11906a = abstractC11932i1Unwrap instanceof C11906a ? (C11906a) abstractC11932i1Unwrap : null;
        if (c11906a == null) {
            m9903v(sb, abstractC11913c0);
            return;
        }
        if (getRenderTypeExpansions()) {
            m9903v(sb, c11906a.getExpandedType());
            return;
        }
        m9903v(sb, c11906a.getAbbreviation());
        if (getRenderUnabbreviatedType()) {
            m9889g(sb, c11906a);
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0124  */
    /* JADX INFO: renamed from: v */
    public final void m9903v(StringBuilder sb, AbstractC11913c0 abstractC11913c0) {
        String strEscape;
        C11716e c11716eExtractParameterNameFromFunctionTypeArgument;
        boolean z2;
        if ((abstractC11913c0 instanceof AbstractC11938k1) && getDebugMode() && !((AbstractC11938k1) abstractC11913c0).isComputed()) {
            sb.append("<Not computed yet>");
            return;
        }
        AbstractC11932i1 abstractC11932i1Unwrap = abstractC11913c0.unwrap();
        if (abstractC11932i1Unwrap instanceof AbstractC12009v) {
            sb.append(((AbstractC12009v) abstractC11932i1Unwrap).render(this, this));
            return;
        }
        if (abstractC11932i1Unwrap instanceof AbstractC11934j0) {
            AbstractC11934j0 abstractC11934j0 = (AbstractC11934j0) abstractC11932i1Unwrap;
            if (C12238m.areEqual(abstractC11934j0, C11920e1.f24754b) || C11920e1.isDontCarePlaceholder(abstractC11934j0)) {
                sb.append("???");
                return;
            }
            if (C12005t.isUninferredParameter(abstractC11934j0)) {
                if (!getUninferredTypeParameterAsName()) {
                    sb.append("???");
                    return;
                }
                String string = ((C12005t.f) abstractC11934j0.getConstructor()).getTypeParameterDescriptor().getName().toString();
                C12238m.checkNotNullExpressionValue(string, "type.constructor as UninferredParameterTypeConstructor).typeParameterDescriptor.name.toString()");
                int iOrdinal = getTextFormat().ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    string = C1643a.m886y("<font color=red><b>", string, "</b></font>");
                }
                sb.append(string);
                return;
            }
            if (C11919e0.isError(abstractC11934j0)) {
                m9893l(sb, abstractC11934j0);
                return;
            }
            if (!m9882L(abstractC11934j0)) {
                m9893l(sb, abstractC11934j0);
                return;
            }
            int length = sb.length();
            m9870i((C11747d) this.f24240e.getValue(), sb, abstractC11934j0, null, 2);
            boolean z3 = sb.length() != length;
            boolean zIsSuspendFunctionType = C11287g.isSuspendFunctionType(abstractC11934j0);
            boolean zIsMarkedNullable = abstractC11934j0.isMarkedNullable();
            AbstractC11913c0 receiverTypeFromFunctionType = C11287g.getReceiverTypeFromFunctionType(abstractC11934j0);
            boolean z4 = zIsMarkedNullable || (z3 && receiverTypeFromFunctionType != null);
            if (z4) {
                if (zIsSuspendFunctionType) {
                    sb.insert(length, '(');
                } else {
                    if (z3) {
                        C12108y.last(sb);
                        if (sb.charAt(C12106w.getLastIndex(sb) - 1) != ')') {
                            sb.insert(C12106w.getLastIndex(sb), "()");
                        }
                    }
                    sb.append("(");
                }
            }
            m9900s(sb, zIsSuspendFunctionType, "suspend");
            if (receiverTypeFromFunctionType != null) {
                if (m9882L(receiverTypeFromFunctionType) && !receiverTypeFromFunctionType.isMarkedNullable()) {
                    z2 = true;
                } else if (C11287g.isSuspendFunctionType(receiverTypeFromFunctionType) || !receiverTypeFromFunctionType.getAnnotations().isEmpty()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    sb.append("(");
                }
                m9902u(sb, receiverTypeFromFunctionType);
                if (z2) {
                    sb.append(")");
                }
                sb.append(".");
            }
            sb.append("(");
            int i = 0;
            for (InterfaceC12012w0 interfaceC12012w0 : C11287g.getValueParameterTypesFromFunctionType(abstractC11934j0)) {
                int i2 = i + 1;
                if (i > 0) {
                    sb.append(", ");
                }
                if (getParameterNamesInFunctionalTypes()) {
                    AbstractC11913c0 type = interfaceC12012w0.getType();
                    C12238m.checkNotNullExpressionValue(type, "typeProjection.type");
                    c11716eExtractParameterNameFromFunctionTypeArgument = C11287g.extractParameterNameFromFunctionTypeArgument(type);
                } else {
                    c11716eExtractParameterNameFromFunctionTypeArgument = null;
                }
                if (c11716eExtractParameterNameFromFunctionTypeArgument != null) {
                    sb.append(renderName(c11716eExtractParameterNameFromFunctionTypeArgument, false));
                    sb.append(": ");
                }
                sb.append(renderTypeProjection(interfaceC12012w0));
                i = i2;
            }
            sb.append(") ");
            int iOrdinal2 = getTextFormat().ordinal();
            if (iOrdinal2 == 0) {
                strEscape = getTextFormat().escape("->");
            } else {
                if (iOrdinal2 != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                strEscape = "&rarr;";
            }
            sb.append(strEscape);
            sb.append(" ");
            m9902u(sb, C11287g.getReturnTypeFromFunctionType(abstractC11934j0));
            if (z4) {
                sb.append(")");
            }
            if (zIsMarkedNullable) {
                sb.append("?");
            }
        }
    }

    /* JADX INFO: renamed from: w */
    public final void m9904w(InterfaceC11321b interfaceC11321b, StringBuilder sb) {
        if (getModifiers().contains(EnumC11750g.OVERRIDE) && (!interfaceC11321b.getOverriddenDescriptors().isEmpty()) && getOverrideRenderingPolicy() != EnumC11756m.RENDER_OPEN) {
            m9900s(sb, true, "override");
            if (getVerbose()) {
                sb.append("/*");
                sb.append(interfaceC11321b.getOverriddenDescriptors().size());
                sb.append("*/ ");
            }
        }
    }

    /* JADX INFO: renamed from: x */
    public final void m9905x(C11713b c11713b, String str, StringBuilder sb) {
        sb.append(m9895n(str));
        C11714c unsafe = c11713b.toUnsafe();
        C12238m.checkNotNullExpressionValue(unsafe, "fqName.toUnsafe()");
        String strRenderFqName = renderFqName(unsafe);
        if (strRenderFqName.length() > 0) {
            sb.append(" ");
            sb.append(strRenderFqName);
        }
    }

    /* JADX INFO: renamed from: y */
    public final void m9906y(StringBuilder sb, C11449l0 c11449l0) {
        StringBuilder sb2;
        C11449l0 outerType = c11449l0.getOuterType();
        if (outerType == null) {
            sb2 = null;
        } else {
            m9906y(sb, outerType);
            sb.append('.');
            C11716e name = c11449l0.getClassifierDescriptor().getName();
            C12238m.checkNotNullExpressionValue(name, "possiblyInnerType.classifierDescriptor.name");
            sb.append(renderName(name, false));
            sb2 = sb;
        }
        if (sb2 == null) {
            InterfaceC12008u0 typeConstructor = c11449l0.getClassifierDescriptor().getTypeConstructor();
            C12238m.checkNotNullExpressionValue(typeConstructor, "possiblyInnerType.classifierDescriptor.typeConstructor");
            sb.append(renderTypeConstructor(typeConstructor));
        }
        sb.append(renderTypeArguments(c11449l0.getArguments()));
    }

    /* JADX INFO: renamed from: z */
    public final void m9907z(InterfaceC11318a interfaceC11318a, StringBuilder sb) {
        InterfaceC11459q0 extensionReceiverParameter = interfaceC11318a.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            m9890h(sb, extensionReceiverParameter, EnumC11342e.RECEIVER);
            AbstractC11913c0 type = extensionReceiverParameter.getType();
            C12238m.checkNotNullExpressionValue(type, "receiver.type");
            String strRenderType = renderType(type);
            if (m9882L(type) && !C11920e1.isNullableType(type)) {
                strRenderType = '(' + strRenderType + ')';
            }
            sb.append(strRenderType);
            sb.append(".");
        }
    }
}
