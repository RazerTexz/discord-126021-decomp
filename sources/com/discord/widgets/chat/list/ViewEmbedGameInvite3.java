package com.discord.widgets.chat.list;

import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.message.activity.MessageActivity;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.jvm.functions.Function6;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.ViewEmbedGameInvite$Model$Companion$getForShare$1, reason: use source file name */
/* JADX INFO: compiled from: ViewEmbedGameInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ViewEmbedGameInvite3 extends FunctionReferenceImpl implements Function6<MeUser, Long, MessageActivity, Activity, Map<Long, ? extends User>, Application, ViewEmbedGameInvite.Model> {
    public ViewEmbedGameInvite3(ViewEmbedGameInvite.Model.Companion companion) {
        super(6, companion, ViewEmbedGameInvite.Model.Companion.class, "createForShare", "createForShare(Lcom/discord/models/user/MeUser;JLcom/discord/api/message/activity/MessageActivity;Lcom/discord/api/activity/Activity;Ljava/util/Map;Lcom/discord/api/application/Application;)Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", 0);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ ViewEmbedGameInvite.Model invoke(MeUser meUser, Long l, MessageActivity messageActivity, Activity activity, Map<Long, ? extends User> map, Application application) {
        return invoke(meUser, l.longValue(), messageActivity, activity, map, application);
    }

    public final ViewEmbedGameInvite.Model invoke(MeUser meUser, long j, MessageActivity messageActivity, Activity activity, Map<Long, ? extends User> map, Application application) {
        Intrinsics3.checkNotNullParameter(meUser, "p1");
        Intrinsics3.checkNotNullParameter(messageActivity, "p3");
        Intrinsics3.checkNotNullParameter(map, "p5");
        return ((ViewEmbedGameInvite.Model.Companion) this.receiver).createForShare(meUser, j, messageActivity, activity, map, application);
    }
}
