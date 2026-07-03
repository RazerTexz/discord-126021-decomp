package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11904n;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.r0 */
/* JADX INFO: compiled from: ScopesHolderForClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11461r0<T extends InterfaceC11770i> {

    /* JADX INFO: renamed from: a */
    public static final a f23077a = new a(null);

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ KProperty<Object>[] f23078b = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11461r0.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* JADX INFO: renamed from: c */
    public final InterfaceC11330e f23079c;

    /* JADX INFO: renamed from: d */
    public final Function1<AbstractC11947g, T> f23080d;

    /* JADX INFO: renamed from: e */
    public final AbstractC11947g f23081e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC11900j f23082f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.r0$a */
    /* JADX INFO: compiled from: ScopesHolderForClass.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final <T extends InterfaceC11770i> C11461r0<T> create(InterfaceC11330e interfaceC11330e, InterfaceC11905o interfaceC11905o, AbstractC11947g abstractC11947g, Function1<? super AbstractC11947g, ? extends T> function1) {
            C12238m.checkNotNullParameter(interfaceC11330e, "classDescriptor");
            C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
            C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefinerForOwnerModule");
            C12238m.checkNotNullParameter(function1, "scopeFactory");
            return new C11461r0<>(interfaceC11330e, interfaceC11905o, function1, abstractC11947g, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.r0$b */
    /* JADX INFO: compiled from: ScopesHolderForClass.kt */
    public static final class b extends AbstractC12240o implements Function0<T> {
        public final /* synthetic */ AbstractC11947g $kotlinTypeRefiner;
        public final /* synthetic */ C11461r0<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C11461r0<T> c11461r0, AbstractC11947g abstractC11947g) {
            super(0);
            this.this$0 = c11461r0;
            this.$kotlinTypeRefiner = abstractC11947g;
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            return (T) this.this$0.f23080d.invoke(this.$kotlinTypeRefiner);
        }
    }

    public C11461r0(InterfaceC11330e interfaceC11330e, InterfaceC11905o interfaceC11905o, Function1 function1, AbstractC11947g abstractC11947g, DefaultConstructorMarker defaultConstructorMarker) {
        this.f23079c = interfaceC11330e;
        this.f23080d = function1;
        this.f23081e = abstractC11947g;
        this.f23082f = interfaceC11905o.createLazyValue(new C11463s0(this));
    }

    public final T getScope(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        if (!abstractC11947g.isRefinementNeededForModule(C11836a.getModule(this.f23079c))) {
            return (T) C11904n.getValue(this.f23082f, this, (KProperty<?>) f23078b[0]);
        }
        InterfaceC12008u0 typeConstructor = this.f23079c.getTypeConstructor();
        C12238m.checkNotNullExpressionValue(typeConstructor, "classDescriptor.typeConstructor");
        return !abstractC11947g.isRefinementNeededForTypeConstructor(typeConstructor) ? (T) C11904n.getValue(this.f23082f, this, (KProperty<?>) f23078b[0]) : (T) abstractC11947g.getOrPutScopeForClass(this.f23079c, new b(this, abstractC11947g));
    }
}
