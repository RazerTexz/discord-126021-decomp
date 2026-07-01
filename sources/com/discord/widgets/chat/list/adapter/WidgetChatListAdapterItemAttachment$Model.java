package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import android.content.Context;
import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.stores.StoreMessageState$State;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.widgets.chat.list.entries.AttachmentEntry;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemAttachment$Model {
    private final AttachmentEntry attachmentEntry;
    private final Map<Long, String> channelNames;
    private final boolean isSpoilerHidden;
    private final long myId;
    private final Map<Long, GuildRole> roles;
    private final Map<Long, String> userNames;

    public WidgetChatListAdapterItemAttachment$Model(AttachmentEntry attachmentEntry, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, long j) {
        m.checkNotNullParameter(attachmentEntry, "attachmentEntry");
        this.attachmentEntry = attachmentEntry;
        this.channelNames = map;
        this.userNames = map2;
        this.roles = map3;
        this.myId = j;
        this.isSpoilerHidden = attachmentEntry.getAttachment().h() && !isSpoilerEmbedRevealed(attachmentEntry);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChatListAdapterItemAttachment$Model copy$default(WidgetChatListAdapterItemAttachment$Model widgetChatListAdapterItemAttachment$Model, AttachmentEntry attachmentEntry, Map map, Map map2, Map map3, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            attachmentEntry = widgetChatListAdapterItemAttachment$Model.attachmentEntry;
        }
        if ((i & 2) != 0) {
            map = widgetChatListAdapterItemAttachment$Model.channelNames;
        }
        Map map4 = map;
        if ((i & 4) != 0) {
            map2 = widgetChatListAdapterItemAttachment$Model.userNames;
        }
        Map map5 = map2;
        if ((i & 8) != 0) {
            map3 = widgetChatListAdapterItemAttachment$Model.roles;
        }
        Map map6 = map3;
        if ((i & 16) != 0) {
            j = widgetChatListAdapterItemAttachment$Model.myId;
        }
        return widgetChatListAdapterItemAttachment$Model.copy(attachmentEntry, map4, map5, map6, j);
    }

    private final boolean isSpoilerEmbedRevealed(AttachmentEntry attachmentEntry) {
        Map<Integer, Set<String>> visibleSpoilerEmbedMap;
        StoreMessageState$State messageState = attachmentEntry.getMessageState();
        return (messageState == null || (visibleSpoilerEmbedMap = messageState.getVisibleSpoilerEmbedMap()) == null || !visibleSpoilerEmbedMap.containsKey(Integer.valueOf(attachmentEntry.getEmbedIndex()))) ? false : true;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AttachmentEntry getAttachmentEntry() {
        return this.attachmentEntry;
    }

    public final Map<Long, String> component2() {
        return this.channelNames;
    }

    public final Map<Long, String> component3() {
        return this.userNames;
    }

    public final Map<Long, GuildRole> component4() {
        return this.roles;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getMyId() {
        return this.myId;
    }

    public final WidgetChatListAdapterItemAttachment$Model copy(AttachmentEntry attachmentEntry, Map<Long, String> channelNames, Map<Long, String> userNames, Map<Long, GuildRole> roles, long myId) {
        m.checkNotNullParameter(attachmentEntry, "attachmentEntry");
        return new WidgetChatListAdapterItemAttachment$Model(attachmentEntry, channelNames, userNames, roles, myId);
    }

    public final MessageRenderContext createRenderContext(Context androidContext, WidgetChatListAdapter$EventHandler eventHandler) {
        m.checkNotNullParameter(androidContext, "androidContext");
        m.checkNotNullParameter(eventHandler, "eventHandler");
        return new MessageRenderContext(androidContext, this.myId, this.attachmentEntry.getAllowAnimatedEmojis(), this.userNames, this.channelNames, this.roles, 0, null, new WidgetChatListAdapterItemAttachment$Model$createRenderContext$1(eventHandler), 0, 0, null, null, null, 16064, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListAdapterItemAttachment$Model)) {
            return false;
        }
        WidgetChatListAdapterItemAttachment$Model widgetChatListAdapterItemAttachment$Model = (WidgetChatListAdapterItemAttachment$Model) other;
        return m.areEqual(this.attachmentEntry, widgetChatListAdapterItemAttachment$Model.attachmentEntry) && m.areEqual(this.channelNames, widgetChatListAdapterItemAttachment$Model.channelNames) && m.areEqual(this.userNames, widgetChatListAdapterItemAttachment$Model.userNames) && m.areEqual(this.roles, widgetChatListAdapterItemAttachment$Model.roles) && this.myId == widgetChatListAdapterItemAttachment$Model.myId;
    }

    public final AttachmentEntry getAttachmentEntry() {
        return this.attachmentEntry;
    }

    public final Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    public final long getMyId() {
        return this.myId;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    public final Map<Long, String> getUserNames() {
        return this.userNames;
    }

    public int hashCode() {
        AttachmentEntry attachmentEntry = this.attachmentEntry;
        int iHashCode = (attachmentEntry != null ? attachmentEntry.hashCode() : 0) * 31;
        Map<Long, String> map = this.channelNames;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, String> map2 = this.userNames;
        int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map3 = this.roles;
        return b.a(this.myId) + ((iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31);
    }

    /* JADX INFO: renamed from: isSpoilerHidden, reason: from getter */
    public final boolean getIsSpoilerHidden() {
        return this.isSpoilerHidden;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(attachmentEntry=");
        sbU.append(this.attachmentEntry);
        sbU.append(", channelNames=");
        sbU.append(this.channelNames);
        sbU.append(", userNames=");
        sbU.append(this.userNames);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", myId=");
        return a.C(sbU, this.myId, ")");
    }

    public /* synthetic */ WidgetChatListAdapterItemAttachment$Model(AttachmentEntry attachmentEntry, Map map, Map map2, Map map3, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(attachmentEntry, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : map2, (i & 8) == 0 ? map3 : null, (i & 16) != 0 ? 0L : j);
    }
}
