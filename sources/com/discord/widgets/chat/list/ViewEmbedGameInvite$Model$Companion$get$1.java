package com.discord.widgets.chat.list;

import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.widgets.chat.list.entries.GameInviteEntry;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.functions.Function5;

/* JADX INFO: compiled from: ViewEmbedGameInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ViewEmbedGameInvite$Model$Companion$get$1 extends k implements Function5<GameInviteEntry, MeUser, Application, Activity, Map<Long, ? extends User>, ViewEmbedGameInvite$Model> {
    public ViewEmbedGameInvite$Model$Companion$get$1(ViewEmbedGameInvite$Model$Companion viewEmbedGameInvite$Model$Companion) {
        super(5, viewEmbedGameInvite$Model$Companion, ViewEmbedGameInvite$Model$Companion.class, "create", "create(Lcom/discord/widgets/chat/list/entries/GameInviteEntry;Lcom/discord/models/user/MeUser;Lcom/discord/api/application/Application;Lcom/discord/api/activity/Activity;Ljava/util/Map;)Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ ViewEmbedGameInvite$Model invoke(GameInviteEntry gameInviteEntry, MeUser meUser, Application application, Activity activity, Map<Long, ? extends User> map) {
        return invoke2(gameInviteEntry, meUser, application, activity, map);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ViewEmbedGameInvite$Model invoke2(GameInviteEntry gameInviteEntry, MeUser meUser, Application application, Activity activity, Map<Long, ? extends User> map) {
        m.checkNotNullParameter(gameInviteEntry, "p1");
        m.checkNotNullParameter(meUser, "p2");
        m.checkNotNullParameter(map, "p5");
        return ViewEmbedGameInvite$Model$Companion.access$create((ViewEmbedGameInvite$Model$Companion) this.receiver, gameInviteEntry, meUser, application, activity, map);
    }
}
