package d0.e0.p.d;

import java.lang.reflect.Type;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KCallableImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$c$a extends d0.z.d.o implements Function0<Type> {
    public final /* synthetic */ f$c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$c$a(f$c f_c) {
        super(0);
        this.this$0 = f_c;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Type invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Type invoke2() {
        Type typeAccess$extractContinuationArgument = f.access$extractContinuationArgument(this.this$0.this$0);
        return typeAccess$extractContinuationArgument != null ? typeAccess$extractContinuationArgument : this.this$0.this$0.getCaller().getReturnType();
    }
}
