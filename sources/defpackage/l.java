package defpackage;

import android.view.View;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class l extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(int i, Object obj) {
        super(1);
        this.j = i;
        this.k = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View view) {
        int i = this.j;
        if (i == 0) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            ((Function0) this.k).invoke();
            return Unit.a;
        }
        if (i != 1) {
            throw null;
        }
        Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
        ((Function0) this.k).invoke();
        return Unit.a;
    }
}
