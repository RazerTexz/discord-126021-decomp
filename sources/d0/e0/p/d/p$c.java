package d0.e0.p.d;

import java.lang.reflect.Field;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;

/* JADX INFO: compiled from: KProperty0Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p$c extends d0.z.d.o implements Function0<Object> {
    public final /* synthetic */ p this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p$c(p pVar) {
        super(0);
        this.this$0 = pVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws IllegalPropertyDelegateAccessException {
        p pVar = this.this$0;
        Field fieldC = pVar.c();
        Object boundReceiver = this.this$0.getBoundReceiver();
        Objects.requireNonNull(pVar);
        try {
            if (boundReceiver == s.n && pVar.getDescriptor().getExtensionReceiverParameter() == null) {
                throw new RuntimeException('\'' + pVar + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
            if (fieldC != null) {
                return fieldC.get(boundReceiver);
            }
            return null;
        } catch (IllegalAccessException e) {
            throw new IllegalPropertyDelegateAccessException(e);
        }
    }
}
