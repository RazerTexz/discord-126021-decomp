package defpackage;

import android.view.View;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class o extends Lambda implements Function1<View, Unit> {
    public static final o j = new o(0);
    public static final o k = new o(1);
    public static final o l = new o(2);
    public static final o m = new o(3);
    public static final o n = new o(4);
    public final /* synthetic */ int o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(int i) {
        super(1);
        this.o = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View view) {
        int i = this.o;
        if (i == 0) {
            Intrinsics3.checkNotNullParameter(view, "it");
            return Unit.a;
        }
        if (i == 1) {
            Intrinsics3.checkNotNullParameter(view, "it");
            return Unit.a;
        }
        if (i == 2) {
            Intrinsics3.checkNotNullParameter(view, "it");
            return Unit.a;
        }
        if (i == 3) {
            Intrinsics3.checkNotNullParameter(view, "it");
            return Unit.a;
        }
        if (i != 4) {
            throw null;
        }
        Intrinsics3.checkNotNullParameter(view, "it");
        return Unit.a;
    }
}
