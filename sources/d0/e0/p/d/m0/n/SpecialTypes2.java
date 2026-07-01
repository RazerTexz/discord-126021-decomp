package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.f0, reason: use source file name */
/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SpecialTypes2 extends KotlinType5 {
    public final StorageManager k;
    public final Function0<KotlinType> l;
    public final storage5<KotlinType> m;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.f0$a */
    /* JADX INFO: compiled from: SpecialTypes.kt */
    public static final class a extends Lambda implements Function0<KotlinType> {
        public final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner;
        public final /* synthetic */ SpecialTypes2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(KotlinTypeRefiner kotlinTypeRefiner, SpecialTypes2 specialTypes2) {
            super(0);
            this.$kotlinTypeRefiner = kotlinTypeRefiner;
            this.this$0 = specialTypes2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType invoke() {
            return this.$kotlinTypeRefiner.refineType((KotlinType) this.this$0.l.invoke());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpecialTypes2(StorageManager storageManager, Function0<? extends KotlinType> function0) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(function0, "computation");
        this.k = storageManager;
        this.l = function0;
        this.m = storageManager.createLazyValue(function0);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType5
    public KotlinType a() {
        return this.m.invoke();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType5
    public boolean isComputed() {
        return ((LockBasedStorageManager.h) this.m).isComputed();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public SpecialTypes2 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new SpecialTypes2(this.k, new a(kotlinTypeRefiner, this));
    }
}
