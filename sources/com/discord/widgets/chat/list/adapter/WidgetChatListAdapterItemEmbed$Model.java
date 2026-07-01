package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import android.content.Context;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreMessageState$State;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.widgets.chat.list.entries.EmbedEntry;
import d0.g0.w;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemEmbed$Model {
    private final Map<Long, String> channelNames;
    private final EmbedEntry embedEntry;
    private final boolean isEmbedUrlFoundInVisibleSpoilerNode;
    private final boolean isSpoilerHidden;
    private final long myId;
    private final Collection<Node<MessageRenderContext>> parsedDescription;
    private final List<WidgetChatListAdapterItemEmbed$Model$ParsedField> parsedFields;
    private final Map<Long, GuildRole> roles;
    private final List<SpoilerNode<?>> spoilers;
    private final Map<Long, String> userNames;

    /* JADX WARN: Code duplicated, block: B:23:0x009c  */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatListAdapterItemEmbed$Model(EmbedEntry embedEntry, Collection<? extends Node<MessageRenderContext>> collection, List<WidgetChatListAdapterItemEmbed$Model$ParsedField> list, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, long j) {
        boolean z2;
        boolean z3;
        Set<Integer> visibleSpoilerNodeIndices;
        m.checkNotNullParameter(embedEntry, "embedEntry");
        this.embedEntry = embedEntry;
        this.parsedDescription = collection;
        this.parsedFields = list;
        this.channelNames = map;
        this.userNames = map2;
        this.roles = map3;
        this.myId = j;
        Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parserCreateTitlesParser = WidgetChatListAdapterItemEmbed.Companion.createTitlesParser();
        String content = embedEntry.getMessage().getContent();
        List list2 = Parser.parse$default(parserCreateTitlesParser, content == null ? "" : content, MessageParseState.Companion.getInitialState(), null, 4, null);
        MessagePreprocessor messagePreprocessor = new MessagePreprocessor(j, embedEntry.getMessageState());
        messagePreprocessor.process(list2);
        List<SpoilerNode<?>> spoilers = messagePreprocessor.getSpoilers();
        this.spoilers = spoilers;
        if (spoilers == null) {
            z2 = false;
        } else {
            StoreMessageState$State messageState = embedEntry.getMessageState();
            if (messageState == null || (visibleSpoilerNodeIndices = messageState.getVisibleSpoilerNodeIndices()) == null) {
                z3 = false;
            } else {
                ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(visibleSpoilerNodeIndices, 10));
                Iterator<T> it = visibleSpoilerNodeIndices.iterator();
                while (it.hasNext()) {
                    arrayList.add(this.spoilers.get(((Number) it.next()).intValue()));
                }
                try {
                    d.i2(arrayList, new WidgetChatListAdapterItemEmbed$Model$isEmbedUrlFoundInVisibleSpoilerNode$1$2$1(embedEntry.getEmbed().getUrl()));
                    z3 = false;
                } catch (WidgetChatListAdapterItemEmbed$Model$isEmbedUrlFoundInVisibleSpoilerNode$1$2$MatchFoundException unused) {
                    z3 = true;
                }
            }
            if (z3) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        this.isEmbedUrlFoundInVisibleSpoilerNode = z2;
        this.isSpoilerHidden = !isSpoilerEmbedRevealed(this.embedEntry) && isSpoilerEmbed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChatListAdapterItemEmbed$Model copy$default(WidgetChatListAdapterItemEmbed$Model widgetChatListAdapterItemEmbed$Model, EmbedEntry embedEntry, Collection collection, List list, Map map, Map map2, Map map3, long j, int i, Object obj) {
        return widgetChatListAdapterItemEmbed$Model.copy((i & 1) != 0 ? widgetChatListAdapterItemEmbed$Model.embedEntry : embedEntry, (i & 2) != 0 ? widgetChatListAdapterItemEmbed$Model.parsedDescription : collection, (i & 4) != 0 ? widgetChatListAdapterItemEmbed$Model.parsedFields : list, (i & 8) != 0 ? widgetChatListAdapterItemEmbed$Model.channelNames : map, (i & 16) != 0 ? widgetChatListAdapterItemEmbed$Model.userNames : map2, (i & 32) != 0 ? widgetChatListAdapterItemEmbed$Model.roles : map3, (i & 64) != 0 ? widgetChatListAdapterItemEmbed$Model.myId : j);
    }

    private final boolean isSpoilerEmbed() {
        boolean z2;
        List<SpoilerNode<?>> list = this.spoilers;
        if (list != null) {
            if (!list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    if (w.contains$default((CharSequence) ((SpoilerNode) it.next()).getContent(), (CharSequence) "http", false, 2, (Object) null)) {
                        z2 = true;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
            if (z2 && !this.isEmbedUrlFoundInVisibleSpoilerNode) {
                return true;
            }
        }
        return false;
    }

    private final boolean isSpoilerEmbedRevealed(EmbedEntry embedEntry) {
        Map<Integer, Set<String>> visibleSpoilerEmbedMap;
        StoreMessageState$State messageState = embedEntry.getMessageState();
        return (messageState == null || (visibleSpoilerEmbedMap = messageState.getVisibleSpoilerEmbedMap()) == null || !visibleSpoilerEmbedMap.containsKey(Integer.valueOf(embedEntry.getEmbedIndex()))) ? false : true;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EmbedEntry getEmbedEntry() {
        return this.embedEntry;
    }

    public final Collection<Node<MessageRenderContext>> component2() {
        return this.parsedDescription;
    }

    public final List<WidgetChatListAdapterItemEmbed$Model$ParsedField> component3() {
        return this.parsedFields;
    }

    public final Map<Long, String> component4() {
        return this.channelNames;
    }

    public final Map<Long, String> component5() {
        return this.userNames;
    }

    public final Map<Long, GuildRole> component6() {
        return this.roles;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getMyId() {
        return this.myId;
    }

    public final WidgetChatListAdapterItemEmbed$Model copy(EmbedEntry embedEntry, Collection<? extends Node<MessageRenderContext>> parsedDescription, List<WidgetChatListAdapterItemEmbed$Model$ParsedField> parsedFields, Map<Long, String> channelNames, Map<Long, String> userNames, Map<Long, GuildRole> roles, long myId) {
        m.checkNotNullParameter(embedEntry, "embedEntry");
        return new WidgetChatListAdapterItemEmbed$Model(embedEntry, parsedDescription, parsedFields, channelNames, userNames, roles, myId);
    }

    public final MessageRenderContext createRenderContext(Context androidContext, WidgetChatListAdapter$EventHandler eventHandler) {
        m.checkNotNullParameter(androidContext, "androidContext");
        m.checkNotNullParameter(eventHandler, "eventHandler");
        return new MessageRenderContext(androidContext, this.myId, this.embedEntry.getAllowAnimatedEmojis(), this.userNames, this.channelNames, this.roles, 0, null, new WidgetChatListAdapterItemEmbed$Model$createRenderContext$1(eventHandler), 0, 0, null, null, null, 16064, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListAdapterItemEmbed$Model)) {
            return false;
        }
        WidgetChatListAdapterItemEmbed$Model widgetChatListAdapterItemEmbed$Model = (WidgetChatListAdapterItemEmbed$Model) other;
        return m.areEqual(this.embedEntry, widgetChatListAdapterItemEmbed$Model.embedEntry) && m.areEqual(this.parsedDescription, widgetChatListAdapterItemEmbed$Model.parsedDescription) && m.areEqual(this.parsedFields, widgetChatListAdapterItemEmbed$Model.parsedFields) && m.areEqual(this.channelNames, widgetChatListAdapterItemEmbed$Model.channelNames) && m.areEqual(this.userNames, widgetChatListAdapterItemEmbed$Model.userNames) && m.areEqual(this.roles, widgetChatListAdapterItemEmbed$Model.roles) && this.myId == widgetChatListAdapterItemEmbed$Model.myId;
    }

    public final Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    public final EmbedEntry getEmbedEntry() {
        return this.embedEntry;
    }

    public final long getMyId() {
        return this.myId;
    }

    public final Collection<Node<MessageRenderContext>> getParsedDescription() {
        return this.parsedDescription;
    }

    public final List<WidgetChatListAdapterItemEmbed$Model$ParsedField> getParsedFields() {
        return this.parsedFields;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    public final Map<Long, String> getUserNames() {
        return this.userNames;
    }

    public int hashCode() {
        EmbedEntry embedEntry = this.embedEntry;
        int iHashCode = (embedEntry != null ? embedEntry.hashCode() : 0) * 31;
        Collection<Node<MessageRenderContext>> collection = this.parsedDescription;
        int iHashCode2 = (iHashCode + (collection != null ? collection.hashCode() : 0)) * 31;
        List<WidgetChatListAdapterItemEmbed$Model$ParsedField> list = this.parsedFields;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Map<Long, String> map = this.channelNames;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, String> map2 = this.userNames;
        int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map3 = this.roles;
        return b.a(this.myId) + ((iHashCode5 + (map3 != null ? map3.hashCode() : 0)) * 31);
    }

    /* JADX INFO: renamed from: isSpoilerHidden, reason: from getter */
    public final boolean getIsSpoilerHidden() {
        return this.isSpoilerHidden;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(embedEntry=");
        sbU.append(this.embedEntry);
        sbU.append(", parsedDescription=");
        sbU.append(this.parsedDescription);
        sbU.append(", parsedFields=");
        sbU.append(this.parsedFields);
        sbU.append(", channelNames=");
        sbU.append(this.channelNames);
        sbU.append(", userNames=");
        sbU.append(this.userNames);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", myId=");
        return a.C(sbU, this.myId, ")");
    }

    public /* synthetic */ WidgetChatListAdapterItemEmbed$Model(EmbedEntry embedEntry, Collection collection, List list, Map map, Map map2, Map map3, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(embedEntry, collection, list, (i & 8) != 0 ? null : map, (i & 16) != 0 ? null : map2, (i & 32) != 0 ? null : map3, (i & 64) != 0 ? 0L : j);
    }
}
