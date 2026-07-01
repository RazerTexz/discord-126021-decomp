package f0.e0.f;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends a {
    public final /* synthetic */ Function0 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Function0 function0, String str, boolean z2, String str2, boolean z3) {
        super(str2, z3);
        this.e = function0;
    }

    @Override // f0.e0.f.a
    public long a() {
        this.e.invoke();
        return -1L;
    }
}
