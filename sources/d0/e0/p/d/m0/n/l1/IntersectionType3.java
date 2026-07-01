package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.KotlinType4;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.w, reason: use source file name */
/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IntersectionType3 extends Lambda implements Function0<String> {
    public final /* synthetic */ Set<KotlinType4> $inputTypes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public IntersectionType3(Set<? extends KotlinType4> set) {
        super(0);
        this.$inputTypes = set;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return Intrinsics3.stringPlus("This collections cannot be empty! input types: ", _Collections.joinToString$default(this.$inputTypes, null, null, null, 0, null, null, 63, null));
    }
}
