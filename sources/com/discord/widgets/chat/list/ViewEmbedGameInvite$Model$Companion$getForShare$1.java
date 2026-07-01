package com.discord.widgets.chat.list;

import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.message.activity.MessageActivity;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.functions.Function6;

/* JADX INFO: compiled from: ViewEmbedGameInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ViewEmbedGameInvite$Model$Companion$getForShare$1 extends k implements Function6<MeUser, Long, MessageActivity, Activity, Map<Long, ? extends User>, Application, ViewEmbedGameInvite$Model> {
    public ViewEmbedGameInvite$Model$Companion$getForShare$1(ViewEmbedGameInvite$Model$Companion viewEmbedGameInvite$Model$Companion) {
        super(6, viewEmbedGameInvite$Model$Companion, ViewEmbedGameInvite$Model$Companion.class, "createForShare", "createForShare(Lcom/discord/models/user/MeUser;JLcom/discord/api/message/activity/MessageActivity;Lcom/discord/api/activity/Activity;Ljava/util/Map;Lcom/discord/api/application/Application;)Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", 0);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ ViewEmbedGameInvite$Model invoke(MeUser meUser, Long l, MessageActivity messageActivity, Activity activity, Map<Long, ? extends User> map, Application application) {
        return invoke(meUser, l.longValue(), messageActivity, activity, map, application);
    }

    public final ViewEmbedGameInvite$Model invoke(MeUser meUser, long j, MessageActivity messageActivity, Activity activity, Map<Long, ? extends User> map, Application application) {
        m.checkNotNullParameter(meUser, "p1");
        m.checkNotNullParameter(messageActivity, "p3");
        m.checkNotNullParameter(map, "p5");
        return ViewEmbedGameInvite$Model$Companion.access$createForShare((ViewEmbedGameInvite$Model$Companion) this.receiver, meUser, j, messageActivity, activity, map, application);
    }
}
