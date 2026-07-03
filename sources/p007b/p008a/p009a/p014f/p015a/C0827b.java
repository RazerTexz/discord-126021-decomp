package p007b.p008a.p009a.p014f.p015a;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.a.f.a.b */
/* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0827b extends AbstractC12240o implements Function1<Long, Unit> {
    public final /* synthetic */ C0826a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0827b(C0826a c0826a) {
        super(1);
        this.this$0 = c0826a;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Long l) {
        this.this$0.requireDialog().cancel();
        return Unit.f27425a;
    }
}
