package p007b.p008a.p062y;

import android.content.Context;
import com.discord.BuildConfig;
import com.discord.C5419R;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.views.OverlayMenuView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0876m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.t */
/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1384t extends AbstractC12240o implements Function1<ModelInvite, Unit> {
    public final /* synthetic */ OverlayMenuView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1384t(OverlayMenuView overlayMenuView) {
        super(1);
        this.this$0 = overlayMenuView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ModelInvite modelInvite) {
        ModelInvite modelInvite2 = modelInvite;
        C12238m.checkNotNullParameter(modelInvite2, "invite");
        AnalyticsTracker.inviteCopied(modelInvite2, "Mobile Voice Overlay");
        Context context = this.this$0.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        String link = modelInvite2.toLink(this.this$0.getResources(), BuildConfig.HOST_INVITE);
        C12238m.checkNotNullExpressionValue(link, "invite.toLink(resources, BuildConfig.HOST_INVITE)");
        C0876m.m163a(context, link, C5419R.string.invite_link_copied);
        this.this$0.getOnDismissRequested$app_productionGoogleRelease().invoke();
        return Unit.f27425a;
    }
}
