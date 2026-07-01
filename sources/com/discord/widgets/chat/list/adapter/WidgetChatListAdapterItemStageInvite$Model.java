package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelInvite;
import com.discord.models.user.User;
import com.discord.widgets.stage.StageCardSpeaker;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStageInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemStageInvite$Model {
    public static final WidgetChatListAdapterItemStageInvite$Model$Companion Companion = new WidgetChatListAdapterItemStageInvite$Model$Companion(null);
    private final User authorUser;
    private final Channel channel;
    private final ModelInvite invite;
    private final Integer listenersCount;
    private final long meId;
    private final boolean shouldAnimateGuildIcon;
    private final List<StageCardSpeaker> speakers;
    private final StageInstance stageInstance;

    public WidgetChatListAdapterItemStageInvite$Model(ModelInvite modelInvite, long j, User user, Channel channel, boolean z2, StageInstance stageInstance, List<StageCardSpeaker> list, Integer num) {
        m.checkNotNullParameter(modelInvite, "invite");
        m.checkNotNullParameter(list, "speakers");
        this.invite = modelInvite;
        this.meId = j;
        this.authorUser = user;
        this.channel = channel;
        this.shouldAnimateGuildIcon = z2;
        this.stageInstance = stageInstance;
        this.speakers = list;
        this.listenersCount = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChatListAdapterItemStageInvite$Model copy$default(WidgetChatListAdapterItemStageInvite$Model widgetChatListAdapterItemStageInvite$Model, ModelInvite modelInvite, long j, User user, Channel channel, boolean z2, StageInstance stageInstance, List list, Integer num, int i, Object obj) {
        return widgetChatListAdapterItemStageInvite$Model.copy((i & 1) != 0 ? widgetChatListAdapterItemStageInvite$Model.invite : modelInvite, (i & 2) != 0 ? widgetChatListAdapterItemStageInvite$Model.meId : j, (i & 4) != 0 ? widgetChatListAdapterItemStageInvite$Model.authorUser : user, (i & 8) != 0 ? widgetChatListAdapterItemStageInvite$Model.channel : channel, (i & 16) != 0 ? widgetChatListAdapterItemStageInvite$Model.shouldAnimateGuildIcon : z2, (i & 32) != 0 ? widgetChatListAdapterItemStageInvite$Model.stageInstance : stageInstance, (i & 64) != 0 ? widgetChatListAdapterItemStageInvite$Model.speakers : list, (i & 128) != 0 ? widgetChatListAdapterItemStageInvite$Model.listenersCount : num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMeId() {
        return this.meId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final User getAuthorUser() {
        return this.authorUser;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShouldAnimateGuildIcon() {
        return this.shouldAnimateGuildIcon;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    public final List<StageCardSpeaker> component7() {
        return this.speakers;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getListenersCount() {
        return this.listenersCount;
    }

    public final WidgetChatListAdapterItemStageInvite$Model copy(ModelInvite invite, long meId, User authorUser, Channel channel, boolean shouldAnimateGuildIcon, StageInstance stageInstance, List<StageCardSpeaker> speakers, Integer listenersCount) {
        m.checkNotNullParameter(invite, "invite");
        m.checkNotNullParameter(speakers, "speakers");
        return new WidgetChatListAdapterItemStageInvite$Model(invite, meId, authorUser, channel, shouldAnimateGuildIcon, stageInstance, speakers, listenersCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListAdapterItemStageInvite$Model)) {
            return false;
        }
        WidgetChatListAdapterItemStageInvite$Model widgetChatListAdapterItemStageInvite$Model = (WidgetChatListAdapterItemStageInvite$Model) other;
        return m.areEqual(this.invite, widgetChatListAdapterItemStageInvite$Model.invite) && this.meId == widgetChatListAdapterItemStageInvite$Model.meId && m.areEqual(this.authorUser, widgetChatListAdapterItemStageInvite$Model.authorUser) && m.areEqual(this.channel, widgetChatListAdapterItemStageInvite$Model.channel) && this.shouldAnimateGuildIcon == widgetChatListAdapterItemStageInvite$Model.shouldAnimateGuildIcon && m.areEqual(this.stageInstance, widgetChatListAdapterItemStageInvite$Model.stageInstance) && m.areEqual(this.speakers, widgetChatListAdapterItemStageInvite$Model.speakers) && m.areEqual(this.listenersCount, widgetChatListAdapterItemStageInvite$Model.listenersCount);
    }

    public final User getAuthorUser() {
        return this.authorUser;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final Integer getListenersCount() {
        return this.listenersCount;
    }

    public final long getMeId() {
        return this.meId;
    }

    public final boolean getShouldAnimateGuildIcon() {
        return this.shouldAnimateGuildIcon;
    }

    public final List<StageCardSpeaker> getSpeakers() {
        return this.speakers;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public int hashCode() {
        ModelInvite modelInvite = this.invite;
        int iA = (b.a(this.meId) + ((modelInvite != null ? modelInvite.hashCode() : 0) * 31)) * 31;
        User user = this.authorUser;
        int iHashCode = (iA + (user != null ? user.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        boolean z2 = this.shouldAnimateGuildIcon;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode2 + r0) * 31;
        StageInstance stageInstance = this.stageInstance;
        int iHashCode3 = (i + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
        List<StageCardSpeaker> list = this.speakers;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        Integer num = this.listenersCount;
        return iHashCode4 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(invite=");
        sbU.append(this.invite);
        sbU.append(", meId=");
        sbU.append(this.meId);
        sbU.append(", authorUser=");
        sbU.append(this.authorUser);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", shouldAnimateGuildIcon=");
        sbU.append(this.shouldAnimateGuildIcon);
        sbU.append(", stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(", speakers=");
        sbU.append(this.speakers);
        sbU.append(", listenersCount=");
        return a.F(sbU, this.listenersCount, ")");
    }
}
