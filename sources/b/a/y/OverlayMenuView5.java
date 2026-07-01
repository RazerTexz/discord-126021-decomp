package b.a.y;

import android.content.Context;
import b.a.d.AppToast;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.views.OverlayMenuView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.y.t, reason: use source file name */
/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuView5 extends Lambda implements Function1<ModelInvite, Unit> {
    public final /* synthetic */ OverlayMenuView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayMenuView5(OverlayMenuView overlayMenuView) {
        super(1);
        this.this$0 = overlayMenuView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ModelInvite modelInvite) {
        ModelInvite modelInvite2 = modelInvite;
        Intrinsics3.checkNotNullParameter(modelInvite2, "invite");
        AnalyticsTracker.inviteCopied(modelInvite2, "Mobile Voice Overlay");
        Context context = this.this$0.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        String link = modelInvite2.toLink(this.this$0.getResources(), BuildConfig.HOST_INVITE);
        Intrinsics3.checkNotNullExpressionValue(link, "invite.toLink(resources, BuildConfig.HOST_INVITE)");
        AppToast.a(context, link, R.string.invite_link_copied);
        this.this$0.getOnDismissRequested$app_productionGoogleRelease().invoke();
        return Unit.a;
    }
}
