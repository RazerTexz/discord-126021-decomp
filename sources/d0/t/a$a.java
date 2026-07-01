package d0.t;

import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: AbstractCollection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a<E> extends d0.z.d.o implements Function1<E, CharSequence> {
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$a(a aVar) {
        super(1);
        this.this$0 = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Object obj) {
        return invoke(obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(E e) {
        return e == this.this$0 ? "(this Collection)" : String.valueOf(e);
    }
}
