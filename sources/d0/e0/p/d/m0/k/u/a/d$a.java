package d0.e0.p.d.m0.k.u.a;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.w0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a extends o implements Function0<c0> {
    public final /* synthetic */ w0 $this_createCapturedIfNeeded;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$a(w0 w0Var) {
        super(0);
        this.$this_createCapturedIfNeeded = w0Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ c0 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final c0 invoke() {
        c0 type = this.$this_createCapturedIfNeeded.getType();
        m.checkNotNullExpressionValue(type, "this@createCapturedIfNeeded.type");
        return type;
    }
}
