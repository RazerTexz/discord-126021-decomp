package defpackage;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class n extends o implements Function1<View, Unit> {
    public static final n j = new n(0);
    public static final n k = new n(1);
    public final /* synthetic */ int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(int i) {
        super(1);
        this.l = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View view) {
        int i = this.l;
        if (i == 0) {
            m.checkNotNullParameter(view, "it");
            return Unit.a;
        }
        if (i != 1) {
            throw null;
        }
        m.checkNotNullParameter(view, "it");
        return Unit.a;
    }
}
