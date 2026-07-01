package defpackage;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends Lambda implements Function0<Unit> {
    public static final q j = new q(0);
    public static final q k = new q(1);
    public final /* synthetic */ int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(int i) {
        super(0);
        this.l = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.l;
        if (i == 0) {
            return Unit.a;
        }
        if (i == 1) {
            return Unit.a;
        }
        throw null;
    }
}
