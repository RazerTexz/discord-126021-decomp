package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.w */
/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11963w extends AbstractC12240o implements Function0<String> {
    public final /* synthetic */ Set<AbstractC11934j0> $inputTypes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C11963w(Set<? extends AbstractC11934j0> set) {
        super(0);
        this.$inputTypes = set;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return C12238m.stringPlus("This collections cannot be empty! input types: ", C12163u.joinToString$default(this.$inputTypes, null, null, null, 0, null, null, 63, null));
    }
}
