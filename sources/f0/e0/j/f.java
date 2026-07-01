package f0.e0.j;

import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends f0.e0.f.a {
    public final /* synthetic */ e$d e;
    public final /* synthetic */ Ref$ObjectRef f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, boolean z2, String str2, boolean z3, e$d e_d, boolean z4, Ref$ObjectRef ref$ObjectRef, s sVar, Ref$LongRef ref$LongRef, Ref$ObjectRef ref$ObjectRef2) {
        super(str2, z3);
        this.e = e_d;
        this.f = ref$ObjectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f0.e0.f.a
    public long a() {
        e eVar = this.e.k;
        eVar.m.a(eVar, (s) this.f.element);
        return -1L;
    }
}
