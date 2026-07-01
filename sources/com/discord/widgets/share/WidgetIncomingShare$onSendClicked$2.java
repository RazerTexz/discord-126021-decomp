package com.discord.widgets.share;

import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.list.ViewEmbedGameInvite$Model;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import j0.k.b;
import j0.l.a.c;
import java.util.List;
import kotlin.Pair;
import rx.Observable;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$onSendClicked$2<T, R> implements b<Pair<? extends MeUser, ? extends Channel>, Observable<? extends Pair<? extends MeUser, ? extends MessageResult>>> {
    public final /* synthetic */ CaptchaHelper$CaptchaPayload $captchaPayload;
    public final /* synthetic */ List $data;
    public final /* synthetic */ ViewEmbedGameInvite$Model $gameInviteModel;
    public final /* synthetic */ WidgetIncomingShare this$0;

    public WidgetIncomingShare$onSendClicked$2(WidgetIncomingShare widgetIncomingShare, List list, ViewEmbedGameInvite$Model viewEmbedGameInvite$Model, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        this.this$0 = widgetIncomingShare;
        this.$data = list;
        this.$gameInviteModel = viewEmbedGameInvite$Model;
        this.$captchaPayload = captchaHelper$CaptchaPayload;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Pair<? extends MeUser, ? extends MessageResult>> call(Pair<? extends MeUser, ? extends Channel> pair) {
        return call2((Pair<MeUser, Channel>) pair);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Pair<MeUser, MessageResult>> call2(Pair<MeUser, Channel> pair) {
        MeUser meUserComponent1 = pair.component1();
        Channel channelComponent2 = pair.component2();
        if (channelComponent2 == null) {
            return c.k;
        }
        StoreMessages messages = StoreStream.Companion.getMessages();
        long id2 = channelComponent2.getId();
        m.checkNotNullExpressionValue(meUserComponent1, "meUser");
        TextInputLayout textInputLayout = WidgetIncomingShare.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.externalShareComment");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        List list = this.$data;
        ViewEmbedGameInvite$Model viewEmbedGameInvite$Model = this.$gameInviteModel;
        Application application = viewEmbedGameInvite$Model != null ? viewEmbedGameInvite$Model.getApplication() : null;
        ViewEmbedGameInvite$Model viewEmbedGameInvite$Model2 = this.$gameInviteModel;
        Activity activity = viewEmbedGameInvite$Model2 != null ? viewEmbedGameInvite$Model2.getActivity() : null;
        ViewEmbedGameInvite$Model viewEmbedGameInvite$Model3 = this.$gameInviteModel;
        return StoreMessages.sendMessage$default(messages, id2, meUserComponent1, textOrEmpty, null, list, null, null, null, application, activity, viewEmbedGameInvite$Model3 != null ? viewEmbedGameInvite$Model3.getMessageActivity() : null, null, null, null, this.$captchaPayload, 14464, null).G(new WidgetIncomingShare$onSendClicked$2$$special$$inlined$let$lambda$1(this, meUserComponent1));
    }
}
