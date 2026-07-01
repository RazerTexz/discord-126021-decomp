package b.a.y;

import android.content.Context;
import com.discord.BuildConfig;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.views.OverlayMenuView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class t extends d0.z.d.o implements Function1<ModelInvite, Unit> {
    public final /* synthetic */ OverlayMenuView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(OverlayMenuView overlayMenuView) {
        super(1);
        this.this$0 = overlayMenuView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ModelInvite modelInvite) {
        ModelInvite modelInvite2 = modelInvite;
        d0.z.d.m.checkNotNullParameter(modelInvite2, "invite");
        AnalyticsTracker.inviteCopied(modelInvite2, "Mobile Voice Overlay");
        Context context = this.this$0.getContext();
        d0.z.d.m.checkNotNullExpressionValue(context, "context");
        String link = modelInvite2.toLink(this.this$0.getResources(), BuildConfig.HOST_INVITE);
        d0.z.d.m.checkNotNullExpressionValue(link, "invite.toLink(resources, BuildConfig.HOST_INVITE)");
        b.a.d.m.a(context, link, 2131892298);
        this.this$0.getOnDismissRequested$app_productionGoogleRelease().invoke();
        return Unit.a;
    }
}
