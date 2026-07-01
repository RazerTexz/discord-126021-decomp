package com.discord.widgets.chat.list.utils;

import android.content.Context;
import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState$State;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: EmbeddedMessageParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmbeddedMessageParser$ParserData {
    private final WidgetChatListAdapter adapter;
    private final boolean animateEmojis;
    private final Context context;
    private final Integer maxNodes;
    private final Message message;
    private final StoreMessageState$State messageState;
    private final Map<Long, String> nickOrUsernames;
    private final Map<Long, GuildRole> roleMentions;

    public EmbeddedMessageParser$ParserData(Context context, Map<Long, GuildRole> map, Map<Long, String> map2, boolean z2, StoreMessageState$State storeMessageState$State, Integer num, Message message, WidgetChatListAdapter widgetChatListAdapter) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(map2, "nickOrUsernames");
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        this.context = context;
        this.roleMentions = map;
        this.nickOrUsernames = map2;
        this.animateEmojis = z2;
        this.messageState = storeMessageState$State;
        this.maxNodes = num;
        this.message = message;
        this.adapter = widgetChatListAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmbeddedMessageParser$ParserData copy$default(EmbeddedMessageParser$ParserData embeddedMessageParser$ParserData, Context context, Map map, Map map2, boolean z2, StoreMessageState$State storeMessageState$State, Integer num, Message message, WidgetChatListAdapter widgetChatListAdapter, int i, Object obj) {
        return embeddedMessageParser$ParserData.copy((i & 1) != 0 ? embeddedMessageParser$ParserData.context : context, (i & 2) != 0 ? embeddedMessageParser$ParserData.roleMentions : map, (i & 4) != 0 ? embeddedMessageParser$ParserData.nickOrUsernames : map2, (i & 8) != 0 ? embeddedMessageParser$ParserData.animateEmojis : z2, (i & 16) != 0 ? embeddedMessageParser$ParserData.messageState : storeMessageState$State, (i & 32) != 0 ? embeddedMessageParser$ParserData.maxNodes : num, (i & 64) != 0 ? embeddedMessageParser$ParserData.message : message, (i & 128) != 0 ? embeddedMessageParser$ParserData.adapter : widgetChatListAdapter);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final Map<Long, GuildRole> component2() {
        return this.roleMentions;
    }

    public final Map<Long, String> component3() {
        return this.nickOrUsernames;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final StoreMessageState$State getMessageState() {
        return this.messageState;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getMaxNodes() {
        return this.maxNodes;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final WidgetChatListAdapter getAdapter() {
        return this.adapter;
    }

    public final EmbeddedMessageParser$ParserData copy(Context context, Map<Long, GuildRole> roleMentions, Map<Long, String> nickOrUsernames, boolean animateEmojis, StoreMessageState$State messageState, Integer maxNodes, Message message, WidgetChatListAdapter adapter) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(nickOrUsernames, "nickOrUsernames");
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(adapter, "adapter");
        return new EmbeddedMessageParser$ParserData(context, roleMentions, nickOrUsernames, animateEmojis, messageState, maxNodes, message, adapter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbeddedMessageParser$ParserData)) {
            return false;
        }
        EmbeddedMessageParser$ParserData embeddedMessageParser$ParserData = (EmbeddedMessageParser$ParserData) other;
        return m.areEqual(this.context, embeddedMessageParser$ParserData.context) && m.areEqual(this.roleMentions, embeddedMessageParser$ParserData.roleMentions) && m.areEqual(this.nickOrUsernames, embeddedMessageParser$ParserData.nickOrUsernames) && this.animateEmojis == embeddedMessageParser$ParserData.animateEmojis && m.areEqual(this.messageState, embeddedMessageParser$ParserData.messageState) && m.areEqual(this.maxNodes, embeddedMessageParser$ParserData.maxNodes) && m.areEqual(this.message, embeddedMessageParser$ParserData.message) && m.areEqual(this.adapter, embeddedMessageParser$ParserData.adapter);
    }

    public final WidgetChatListAdapter getAdapter() {
        return this.adapter;
    }

    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Integer getMaxNodes() {
        return this.maxNodes;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final StoreMessageState$State getMessageState() {
        return this.messageState;
    }

    public final Map<Long, String> getNickOrUsernames() {
        return this.nickOrUsernames;
    }

    public final Map<Long, GuildRole> getRoleMentions() {
        return this.roleMentions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public int hashCode() {
        Context context = this.context;
        int iHashCode = (context != null ? context.hashCode() : 0) * 31;
        Map<Long, GuildRole> map = this.roleMentions;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, String> map2 = this.nickOrUsernames;
        int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        boolean z2 = this.animateEmojis;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode3 + r2) * 31;
        StoreMessageState$State storeMessageState$State = this.messageState;
        int iHashCode4 = (i + (storeMessageState$State != null ? storeMessageState$State.hashCode() : 0)) * 31;
        Integer num = this.maxNodes;
        int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        Message message = this.message;
        int iHashCode6 = (iHashCode5 + (message != null ? message.hashCode() : 0)) * 31;
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        return iHashCode6 + (widgetChatListAdapter != null ? widgetChatListAdapter.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ParserData(context=");
        sbU.append(this.context);
        sbU.append(", roleMentions=");
        sbU.append(this.roleMentions);
        sbU.append(", nickOrUsernames=");
        sbU.append(this.nickOrUsernames);
        sbU.append(", animateEmojis=");
        sbU.append(this.animateEmojis);
        sbU.append(", messageState=");
        sbU.append(this.messageState);
        sbU.append(", maxNodes=");
        sbU.append(this.maxNodes);
        sbU.append(", message=");
        sbU.append(this.message);
        sbU.append(", adapter=");
        sbU.append(this.adapter);
        sbU.append(")");
        return sbU.toString();
    }
}
