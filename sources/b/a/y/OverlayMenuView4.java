package b.a.y;

import b.a.d.AppToast;
import com.discord.R;
import com.discord.utilities.error.Error;
import com.discord.views.OverlayMenuView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.y.s, reason: use source file name */
/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuView4 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ OverlayMenuView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayMenuView4(OverlayMenuView overlayMenuView) {
        super(1);
        this.this$0 = overlayMenuView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Error error) {
        Intrinsics3.checkNotNullParameter(error, "it");
        AppToast.g(this.this$0.getContext(), R.string.instant_invite_failed_to_generate, 0, null, 12);
        return Unit.a;
    }
}
