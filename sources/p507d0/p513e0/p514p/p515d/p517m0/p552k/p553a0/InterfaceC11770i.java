package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.i */
/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11770i extends InterfaceC11773l {

    /* JADX INFO: renamed from: a */
    public static final a f24369a = a.f24370a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.i$a */
    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ a f24370a = new a();

        /* JADX INFO: renamed from: b */
        public static final Function1<C11716e, Boolean> f24371b = C13328a.f24372j;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MemberScope.kt */
        public static final class C13328a extends AbstractC12240o implements Function1<C11716e, Boolean> {

            /* JADX INFO: renamed from: j */
            public static final C13328a f24372j = new C13328a();

            public C13328a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(C11716e c11716e) {
                return Boolean.valueOf(invoke2(c11716e));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(C11716e c11716e) {
                C12238m.checkNotNullParameter(c11716e, "it");
                return true;
            }
        }

        public final Function1<C11716e, Boolean> getALL_NAME_FILTER() {
            return f24371b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.i$b */
    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class b extends AbstractC11771j {

        /* JADX INFO: renamed from: b */
        public static final b f24373b = new b();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
        public Set<C11716e> getClassifierNames() {
            return C12148n0.emptySet();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
        public Set<C11716e> getFunctionNames() {
            return C12148n0.emptySet();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
        public Set<C11716e> getVariableNames() {
            return C12148n0.emptySet();
        }
    }

    Set<C11716e> getClassifierNames();

    Collection<? extends InterfaceC11465t0> getContributedFunctions(C11716e c11716e, InterfaceC11480b interfaceC11480b);

    Collection<? extends InterfaceC11453n0> getContributedVariables(C11716e c11716e, InterfaceC11480b interfaceC11480b);

    Set<C11716e> getFunctionNames();

    Set<C11716e> getVariableNames();
}
