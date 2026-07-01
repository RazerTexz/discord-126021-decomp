package b.a.a.f.a;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b extends o implements Function1<Long, Unit> {
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar) {
        super(1);
        this.this$0 = aVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Long l) {
        this.this$0.requireDialog().cancel();
        return Unit.a;
    }
}
