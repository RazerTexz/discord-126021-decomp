package d0.e0.p.d;

import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: KClassImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a$m<T> extends d0.z.d.o implements Function0<T> {
    public final /* synthetic */ h$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$a$m(h$a h_a) {
        super(0);
        this.this$0 = h_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public final T invoke() {
        d0.e0.p.d.m0.c.e descriptor = this.this$0.getDescriptor();
        if (descriptor.getKind() != d0.e0.p.d.m0.c.f.OBJECT) {
            return null;
        }
        T t = (T) ((!descriptor.isCompanionObject() || d0.e0.p.d.m0.b.d.isMappedIntrinsicCompanionObject(d0.e0.p.d.m0.b.c.a, descriptor)) ? this.this$0.p.getJClass().getDeclaredField("INSTANCE") : this.this$0.p.getJClass().getEnclosingClass().getDeclaredField(descriptor.getName().asString())).get(null);
        Objects.requireNonNull(t, "null cannot be cast to non-null type T");
        return t;
    }
}
