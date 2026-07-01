package b.a.y;

import com.discord.utilities.error.Error;
import com.discord.views.OverlayMenuView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s extends d0.z.d.o implements Function1<Error, Unit> {
    public final /* synthetic */ OverlayMenuView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(OverlayMenuView overlayMenuView) {
        super(1);
        this.this$0 = overlayMenuView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Error error) {
        d0.z.d.m.checkNotNullParameter(error, "it");
        b.a.d.m.g(this.this$0.getContext(), 2131892065, 0, null, 12);
        return Unit.a;
    }
}
