package p000;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: o */
/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class C12929o extends AbstractC12240o implements Function1<View, Unit> {

    /* JADX INFO: renamed from: j */
    public static final C12929o f27504j = new C12929o(0);

    /* JADX INFO: renamed from: k */
    public static final C12929o f27505k = new C12929o(1);

    /* JADX INFO: renamed from: l */
    public static final C12929o f27506l = new C12929o(2);

    /* JADX INFO: renamed from: m */
    public static final C12929o f27507m = new C12929o(3);

    /* JADX INFO: renamed from: n */
    public static final C12929o f27508n = new C12929o(4);

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ int f27509o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12929o(int i) {
        super(1);
        this.f27509o = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View view) {
        int i = this.f27509o;
        if (i == 0) {
            C12238m.checkNotNullParameter(view, "it");
            return Unit.f27425a;
        }
        if (i == 1) {
            C12238m.checkNotNullParameter(view, "it");
            return Unit.f27425a;
        }
        if (i == 2) {
            C12238m.checkNotNullParameter(view, "it");
            return Unit.f27425a;
        }
        if (i == 3) {
            C12238m.checkNotNullParameter(view, "it");
            return Unit.f27425a;
        }
        if (i != 4) {
            throw null;
        }
        C12238m.checkNotNullParameter(view, "it");
        return Unit.f27425a;
    }
}
