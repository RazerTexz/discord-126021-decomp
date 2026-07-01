package d0.e0.p.d.m0.k.a0;

import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.g.Name;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.i, reason: use source file name */
/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface MemberScope3 extends ResolutionScope {
    public static final a a = a.a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.i$a */
    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class a {
        public static final /* synthetic */ a a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Function1<Name, Boolean> f3460b = C0404a.j;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MemberScope.kt */
        public static final class C0404a extends Lambda implements Function1<Name, Boolean> {
            public static final C0404a j = new C0404a();

            public C0404a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Name name) {
                return Boolean.valueOf(invoke2(name));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(Name name) {
                Intrinsics3.checkNotNullParameter(name, "it");
                return true;
            }
        }

        public final Function1<Name, Boolean> getALL_NAME_FILTER() {
            return f3460b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.i$b */
    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class b extends MemberScopeImpl {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f3461b = new b();

        @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
        public Set<Name> getClassifierNames() {
            return Sets5.emptySet();
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
        public Set<Name> getFunctionNames() {
            return Sets5.emptySet();
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
        public Set<Name> getVariableNames() {
            return Sets5.emptySet();
        }
    }

    Set<Name> getClassifierNames();

    Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2);

    Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2);

    Set<Name> getFunctionNames();

    Set<Name> getVariableNames();
}
