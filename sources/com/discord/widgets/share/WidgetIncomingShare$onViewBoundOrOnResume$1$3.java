package com.discord.widgets.share;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.list.ViewEmbedGameInvite$Model;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemChannel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemGuild;
import d0.z.d.m;
import rx.functions.Func6;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$onViewBoundOrOnResume$1$3<T1, T2, T3, T4, T5, T6, R> implements Func6<WidgetIncomingShare$ContentModel, ViewEmbedGameInvite$Model, String, WidgetGlobalSearchModel, Boolean, MeUser, WidgetIncomingShare$Model> {
    public final /* synthetic */ WidgetGlobalSearchModel$ItemDataPayload $receiver;

    public WidgetIncomingShare$onViewBoundOrOnResume$1$3(WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload) {
        this.$receiver = widgetGlobalSearchModel$ItemDataPayload;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetIncomingShare$Model call(WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel, ViewEmbedGameInvite$Model viewEmbedGameInvite$Model, String str, WidgetGlobalSearchModel widgetGlobalSearchModel, Boolean bool, MeUser meUser) {
        return call2(widgetIncomingShare$ContentModel, viewEmbedGameInvite$Model, str, widgetGlobalSearchModel, bool, meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetIncomingShare$Model call2(WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel, ViewEmbedGameInvite$Model viewEmbedGameInvite$Model, String str, WidgetGlobalSearchModel widgetGlobalSearchModel, Boolean bool, MeUser meUser) {
        Guild guild;
        WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload = this.$receiver;
        int maxFileSizeMB = 0;
        if (widgetGlobalSearchModel$ItemDataPayload instanceof WidgetGlobalSearchModel$ItemGuild) {
            maxFileSizeMB = GuildUtilsKt.getMaxFileSizeMB(((WidgetGlobalSearchModel$ItemGuild) widgetGlobalSearchModel$ItemDataPayload).getGuild());
        } else if ((widgetGlobalSearchModel$ItemDataPayload instanceof WidgetGlobalSearchModel$ItemChannel) && (guild = ((WidgetGlobalSearchModel$ItemChannel) widgetGlobalSearchModel$ItemDataPayload).getGuild()) != null) {
            maxFileSizeMB = GuildUtilsKt.getMaxFileSizeMB(guild);
        }
        m.checkNotNullExpressionValue(widgetIncomingShare$ContentModel, "contentModel");
        m.checkNotNullExpressionValue(widgetGlobalSearchModel, "searchModel");
        WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload2 = this.$receiver;
        m.checkNotNullExpressionValue(bool, "isOnCooldown");
        boolean zBooleanValue = bool.booleanValue();
        int iMax = Math.max(maxFileSizeMB, PremiumUtils.INSTANCE.getMaxFileSizeMB(meUser));
        UserUtils userUtils = UserUtils.INSTANCE;
        m.checkNotNullExpressionValue(meUser, "meUser");
        return new WidgetIncomingShare$Model(widgetIncomingShare$ContentModel, viewEmbedGameInvite$Model, str, widgetGlobalSearchModel, widgetGlobalSearchModel$ItemDataPayload2, zBooleanValue, iMax, userUtils.isPremium(meUser));
    }
}
