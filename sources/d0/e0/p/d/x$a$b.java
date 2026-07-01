package d0.e0.p.d;

import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KTypeImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x$a$b extends d0.z.d.o implements Function0<List<? extends Type>> {
    public final /* synthetic */ x$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x$a$b(x$a x_a) {
        super(0);
        this.this$0 = x_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends Type> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends Type> invoke2() {
        Type javaType = this.this$0.this$0.getJavaType();
        d0.z.d.m.checkNotNull(javaType);
        return d0.e0.p.d.m0.c.k1.b.b.getParameterizedTypeArguments(javaType);
    }
}
