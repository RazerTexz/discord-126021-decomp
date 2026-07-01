package com.discord.widgets.share;

import android.content.Context;
import android.content.res.Resources;
import com.discord.R$plurals;
import com.discord.app.AppActivity;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.error.Error;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.messagesend.MessageResult$CaptchaRequired;
import com.discord.utilities.messagesend.MessageResult$Slowmode;
import com.discord.utilities.messagesend.MessageResult$Success;
import com.discord.utilities.messagesend.MessageResult$UnknownFailure;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet$Companion;
import com.discord.widgets.chat.list.ViewEmbedGameInvite$Model;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload;
import com.lytefast.flexinput.model.Attachment;
import d0.d0.f;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$onSendClicked$3 extends o implements Function1<Pair<? extends MeUser, ? extends MessageResult>, Unit> {
    public final /* synthetic */ WidgetIncomingShare$ContentModel $contentModel;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ List $data;
    public final /* synthetic */ ViewEmbedGameInvite$Model $gameInviteModel;
    public final /* synthetic */ boolean $hasGif;
    public final /* synthetic */ boolean $hasImage;
    public final /* synthetic */ boolean $hasVideo;
    public final /* synthetic */ boolean $isOnCooldown;
    public final /* synthetic */ boolean $isUserPremium;
    public final /* synthetic */ int $maxFileSizeMB;
    public final /* synthetic */ WidgetGlobalSearchModel$ItemDataPayload $receiver;
    public final /* synthetic */ WidgetIncomingShare this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare$onSendClicked$3(WidgetIncomingShare widgetIncomingShare, List list, Context context, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload, ViewEmbedGameInvite$Model viewEmbedGameInvite$Model, WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel, boolean z2, int i, boolean z3, boolean z4, boolean z5, boolean z6) {
        super(1);
        this.this$0 = widgetIncomingShare;
        this.$data = list;
        this.$context = context;
        this.$receiver = widgetGlobalSearchModel$ItemDataPayload;
        this.$gameInviteModel = viewEmbedGameInvite$Model;
        this.$contentModel = widgetIncomingShare$ContentModel;
        this.$isOnCooldown = z2;
        this.$maxFileSizeMB = i;
        this.$isUserPremium = z3;
        this.$hasImage = z4;
        this.$hasVideo = z5;
        this.$hasGif = z6;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends MeUser, ? extends MessageResult> pair) {
        invoke2((Pair<MeUser, ? extends MessageResult>) pair);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<MeUser, ? extends MessageResult> pair) {
        MeUser meUserComponent1 = pair.component1();
        MessageResult messageResultComponent2 = pair.component2();
        if (messageResultComponent2 instanceof MessageResult$Success) {
            WidgetIncomingShare.access$onSendCompleted(this.this$0);
            Attachment attachment = (Attachment) u.firstOrNull(this.$data);
            if (attachment != null) {
                AnalyticsTracker.INSTANCE.externalShare(attachment.getUri());
                return;
            }
            return;
        }
        if (messageResultComponent2 instanceof MessageResult$Slowmode) {
            int iCoerceAtLeast = f.coerceAtLeast((int) (((MessageResult$Slowmode) messageResultComponent2).getCooldownMs() / 1000), 1);
            Resources resources = this.$context.getResources();
            m.checkNotNullExpressionValue(resources, "context.resources");
            b.a.d.m.h(this.$context, StringResourceUtilsKt.getQuantityString(resources, this.$context, R$plurals.channel_slowmode_cooldown_seconds, iCoerceAtLeast, Integer.valueOf(iCoerceAtLeast)), 0, null, 12);
            return;
        }
        if (messageResultComponent2 instanceof MessageResult$CaptchaRequired) {
            MessageResult$CaptchaRequired messageResult$CaptchaRequired = (MessageResult$CaptchaRequired) messageResultComponent2;
            if (messageResult$CaptchaRequired.getNonce() != null) {
                StoreStream.Companion.getMessages().deleteLocalMessage(messageResult$CaptchaRequired.getChannelId(), messageResult$CaptchaRequired.getNonce());
            }
            WidgetCaptchaBottomSheet$Companion.enqueue$default(WidgetCaptchaBottomSheet.Companion, "Message Captcha", new WidgetIncomingShare$onSendClicked$3$2(this), null, CaptchaErrorBody.Companion.createFromError(messageResult$CaptchaRequired.getError()), 4, null);
            return;
        }
        if (messageResultComponent2 instanceof MessageResult$UnknownFailure) {
            SendUtils sendUtils = SendUtils.INSTANCE;
            Error error = ((MessageResult$UnknownFailure) messageResultComponent2).getError();
            AppActivity appActivity = this.this$0.getAppActivity();
            if (appActivity != null) {
                SendUtils.handleSendError$default(sendUtils, error, appActivity, new WidgetIncomingShare$onSendClicked$3$3(this, meUserComponent1), null, 8, null);
            }
        }
    }
}
