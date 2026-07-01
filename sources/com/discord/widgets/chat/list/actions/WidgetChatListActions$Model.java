package com.discord.widgets.chat.list.actions;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.ManageMessageContext;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListActions$Model {
    public static final WidgetChatListActions$Model$Companion Companion = new WidgetChatListActions$Model$Companion(null);
    private final Channel channel;
    private final Guild guild;
    private final boolean isDeveloper;
    private final ManageMessageContext manageMessageContext;
    private final MeUser me;
    private final Message message;
    private final String messageAuthorName;
    private final CharSequence messageContent;
    private final Long permissions;
    private final List<Emoji> recentEmojis;
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatListActions$Model(Message message, Guild guild, String str, CharSequence charSequence, ManageMessageContext manageMessageContext, int i, boolean z2, List<? extends Emoji> list, Channel channel, Long l, MeUser meUser) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(str, "messageAuthorName");
        m.checkNotNullParameter(manageMessageContext, "manageMessageContext");
        m.checkNotNullParameter(list, "recentEmojis");
        m.checkNotNullParameter(meUser, "me");
        this.message = message;
        this.guild = guild;
        this.messageAuthorName = str;
        this.messageContent = charSequence;
        this.manageMessageContext = manageMessageContext;
        this.type = i;
        this.isDeveloper = z2;
        this.recentEmojis = list;
        this.channel = channel;
        this.permissions = l;
        this.me = meUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChatListActions$Model copy$default(WidgetChatListActions$Model widgetChatListActions$Model, Message message, Guild guild, String str, CharSequence charSequence, ManageMessageContext manageMessageContext, int i, boolean z2, List list, Channel channel, Long l, MeUser meUser, int i2, Object obj) {
        return widgetChatListActions$Model.copy((i2 & 1) != 0 ? widgetChatListActions$Model.message : message, (i2 & 2) != 0 ? widgetChatListActions$Model.guild : guild, (i2 & 4) != 0 ? widgetChatListActions$Model.messageAuthorName : str, (i2 & 8) != 0 ? widgetChatListActions$Model.messageContent : charSequence, (i2 & 16) != 0 ? widgetChatListActions$Model.manageMessageContext : manageMessageContext, (i2 & 32) != 0 ? widgetChatListActions$Model.type : i, (i2 & 64) != 0 ? widgetChatListActions$Model.isDeveloper : z2, (i2 & 128) != 0 ? widgetChatListActions$Model.recentEmojis : list, (i2 & 256) != 0 ? widgetChatListActions$Model.channel : channel, (i2 & 512) != 0 ? widgetChatListActions$Model.permissions : l, (i2 & 1024) != 0 ? widgetChatListActions$Model.me : meUser);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Long getPermissions() {
        return this.permissions;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessageAuthorName() {
        return this.messageAuthorName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CharSequence getMessageContent() {
        return this.messageContent;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ManageMessageContext getManageMessageContext() {
        return this.manageMessageContext;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsDeveloper() {
        return this.isDeveloper;
    }

    public final List<Emoji> component8() {
        return this.recentEmojis;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final WidgetChatListActions$Model copy(Message message, Guild guild, String messageAuthorName, CharSequence messageContent, ManageMessageContext manageMessageContext, int type, boolean isDeveloper, List<? extends Emoji> recentEmojis, Channel channel, Long permissions, MeUser me2) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(messageAuthorName, "messageAuthorName");
        m.checkNotNullParameter(manageMessageContext, "manageMessageContext");
        m.checkNotNullParameter(recentEmojis, "recentEmojis");
        m.checkNotNullParameter(me2, "me");
        return new WidgetChatListActions$Model(message, guild, messageAuthorName, messageContent, manageMessageContext, type, isDeveloper, recentEmojis, channel, permissions, me2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListActions$Model)) {
            return false;
        }
        WidgetChatListActions$Model widgetChatListActions$Model = (WidgetChatListActions$Model) other;
        return m.areEqual(this.message, widgetChatListActions$Model.message) && m.areEqual(this.guild, widgetChatListActions$Model.guild) && m.areEqual(this.messageAuthorName, widgetChatListActions$Model.messageAuthorName) && m.areEqual(this.messageContent, widgetChatListActions$Model.messageContent) && m.areEqual(this.manageMessageContext, widgetChatListActions$Model.manageMessageContext) && this.type == widgetChatListActions$Model.type && this.isDeveloper == widgetChatListActions$Model.isDeveloper && m.areEqual(this.recentEmojis, widgetChatListActions$Model.recentEmojis) && m.areEqual(this.channel, widgetChatListActions$Model.channel) && m.areEqual(this.permissions, widgetChatListActions$Model.permissions) && m.areEqual(this.me, widgetChatListActions$Model.me);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final ManageMessageContext getManageMessageContext() {
        return this.manageMessageContext;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final String getMessageAuthorName() {
        return this.messageAuthorName;
    }

    public final CharSequence getMessageContent() {
        return this.messageContent;
    }

    public final Long getPermissions() {
        return this.permissions;
    }

    public final List<Emoji> getRecentEmojis() {
        return this.recentEmojis;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v33 */
    public int hashCode() {
        Message message = this.message;
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        String str = this.messageAuthorName;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        CharSequence charSequence = this.messageContent;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        ManageMessageContext manageMessageContext = this.manageMessageContext;
        int iHashCode5 = (((iHashCode4 + (manageMessageContext != null ? manageMessageContext.hashCode() : 0)) * 31) + this.type) * 31;
        boolean z2 = this.isDeveloper;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode5 + r2) * 31;
        List<Emoji> list = this.recentEmojis;
        int iHashCode6 = (i + (list != null ? list.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode7 = (iHashCode6 + (channel != null ? channel.hashCode() : 0)) * 31;
        Long l = this.permissions;
        int iHashCode8 = (iHashCode7 + (l != null ? l.hashCode() : 0)) * 31;
        MeUser meUser = this.me;
        return iHashCode8 + (meUser != null ? meUser.hashCode() : 0);
    }

    public final boolean isDeveloper() {
        return this.isDeveloper;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(message=");
        sbU.append(this.message);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", messageAuthorName=");
        sbU.append(this.messageAuthorName);
        sbU.append(", messageContent=");
        sbU.append(this.messageContent);
        sbU.append(", manageMessageContext=");
        sbU.append(this.manageMessageContext);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", isDeveloper=");
        sbU.append(this.isDeveloper);
        sbU.append(", recentEmojis=");
        sbU.append(this.recentEmojis);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", permissions=");
        sbU.append(this.permissions);
        sbU.append(", me=");
        sbU.append(this.me);
        sbU.append(")");
        return sbU.toString();
    }
}
