package p000;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: l */
/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class C12807l extends AbstractC12240o implements Function1<View, Unit> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f27464j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Object f27465k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12807l(int i, Object obj) {
        super(1);
        this.f27464j = i;
        this.f27465k = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View view) {
        int i = this.f27464j;
        if (i == 0) {
            C12238m.checkNotNullParameter(view, "<anonymous parameter 0>");
            ((Function0) this.f27465k).invoke();
            return Unit.f27425a;
        }
        if (i != 1) {
            throw null;
        }
        C12238m.checkNotNullParameter(view, "<anonymous parameter 0>");
        ((Function0) this.f27465k).invoke();
        return Unit.f27425a;
    }
}
