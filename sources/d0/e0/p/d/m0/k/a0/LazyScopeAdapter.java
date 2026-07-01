package d0.e0.p.d.m0.k.a0;

import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.h, reason: use source file name */
/* JADX INFO: compiled from: LazyScopeAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyScopeAdapter extends AbstractScopeAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final storage5<MemberScope3> f3459b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.h$a */
    /* JADX INFO: compiled from: LazyScopeAdapter.kt */
    public static final class a extends Lambda implements Function0<MemberScope3> {
        public final /* synthetic */ Function0<MemberScope3> $getScope;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<? extends MemberScope3> function0) {
            super(0);
            this.$getScope = function0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MemberScope3 invoke() {
            MemberScope3 memberScope3Invoke = this.$getScope.invoke();
            return memberScope3Invoke instanceof AbstractScopeAdapter ? ((AbstractScopeAdapter) memberScope3Invoke).getActualScope() : memberScope3Invoke;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LazyScopeAdapter(StorageManager storageManager, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            storageManager = LockBasedStorageManager.f3514b;
            Intrinsics3.checkNotNullExpressionValue(storageManager, "NO_LOCKS");
        }
        this(storageManager, function0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyScopeAdapter(Function0<? extends MemberScope3> function0) {
        this(null, function0, 1, 0 == true ? 1 : 0);
        Intrinsics3.checkNotNullParameter(function0, "getScope");
    }

    @Override // d0.e0.p.d.m0.k.a0.AbstractScopeAdapter
    public MemberScope3 a() {
        return this.f3459b.invoke();
    }

    public LazyScopeAdapter(StorageManager storageManager, Function0<? extends MemberScope3> function0) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(function0, "getScope");
        this.f3459b = storageManager.createLazyValue(new a(function0));
    }
}
