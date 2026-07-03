package p007b.p008a.p062y;

import com.discord.C5419R;
import com.discord.utilities.error.Error;
import com.discord.views.OverlayMenuView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0876m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.s */
/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1381s extends AbstractC12240o implements Function1<Error, Unit> {
    public final /* synthetic */ OverlayMenuView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1381s(OverlayMenuView overlayMenuView) {
        super(1);
        this.this$0 = overlayMenuView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Error error) {
        C12238m.checkNotNullParameter(error, "it");
        C0876m.m169g(this.this$0.getContext(), C5419R.string.instant_invite_failed_to_generate, 0, null, 12);
        return Unit.f27425a;
    }
}
