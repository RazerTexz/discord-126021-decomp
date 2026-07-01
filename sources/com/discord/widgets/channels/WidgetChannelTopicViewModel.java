package com.discord.widgets.channels;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.member.GuildMember;
import com.discord.models.member.GuildMember$Companion;
import com.discord.models.user.User;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import d0.t.g0;
import d0.t.n0;
import d0.t.o0;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel extends d0<WidgetChannelTopicViewModel$ViewState> {
    public static final WidgetChannelTopicViewModel$Companion Companion = new WidgetChannelTopicViewModel$Companion(null);
    private final PublishSubject<WidgetChannelTopicViewModel$Event> eventSubject;
    private Long previousChannelId;
    private Set<Integer> revealedIndices;
    private Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> topicParser;
    private boolean wasOnHomeTab;
    private boolean wasRightPanelOpened;

    public WidgetChannelTopicViewModel() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChannelTopicViewModel(Observable observable, Parser parser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            observable = WidgetChannelTopicViewModel$Companion.observeNavState$default(Companion, null, null, 3, null).Y(WidgetChannelTopicViewModel$1.INSTANCE);
            m.checkNotNullExpressionValue(observable, "observeNavState().switch…avState\n    ).take(1)\n  }");
        }
        this(observable, (i & 2) != 0 ? DiscordParser.createParser$default(false, true, false, false, false, 28, null) : parser);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChannelTopicViewModel widgetChannelTopicViewModel, WidgetChannelTopicViewModel$StoreState widgetChannelTopicViewModel$StoreState) {
        widgetChannelTopicViewModel.handleStoreState(widgetChannelTopicViewModel$StoreState);
    }

    private final List<Node<MessageRenderContext>> generateAST(CharSequence rawTopicString) {
        return Parser.parse$default(this.topicParser, rawTopicString, MessageParseState.Companion.getInitialState(), null, 4, null);
    }

    private final void handleGuildStoreState(WidgetChannelTopicViewModel$StoreState$Guild storeState) {
        String username;
        if (storeState instanceof WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic) {
            WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic widgetChannelTopicViewModel$StoreState$Guild$DefaultTopic = (WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic) storeState;
            updateViewState(new WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic(widgetChannelTopicViewModel$StoreState$Guild$DefaultTopic.getChannelIconType(), widgetChannelTopicViewModel$StoreState$Guild$DefaultTopic.getChannel(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
            return;
        }
        if (!(storeState instanceof WidgetChannelTopicViewModel$StoreState$Guild$Topic)) {
            throw new NoWhenBranchMatchedException();
        }
        WidgetChannelTopicViewModel$StoreState$Guild$Topic widgetChannelTopicViewModel$StoreState$Guild$Topic = (WidgetChannelTopicViewModel$StoreState$Guild$Topic) storeState;
        String topic = widgetChannelTopicViewModel$StoreState$Guild$Topic.getChannel().getTopic();
        List<Node<MessageRenderContext>> listGenerateAST = generateAST(topic != null ? topic : "");
        MessagePreprocessor messagePreprocessor = new MessagePreprocessor(-1L, this.revealedIndices, null, false, null, 28, null);
        messagePreprocessor.process(listGenerateAST);
        Map<Long, User> users = widgetChannelTopicViewModel$StoreState$Guild$Topic.getUsers();
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(users.size()));
        Iterator<T> it = users.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            Object key = map$Entry.getKey();
            long jLongValue = ((Number) map$Entry.getKey()).longValue();
            User user = (User) map$Entry.getValue();
            GuildMember guildMember = widgetChannelTopicViewModel$StoreState$Guild$Topic.getMembers().get(Long.valueOf(jLongValue));
            if (guildMember == null || (username = guildMember.getNick()) == null) {
                username = user.getUsername();
            }
            linkedHashMap.put(key, username);
        }
        String str = topic != null ? topic : "";
        Map<Long, Channel> channels = widgetChannelTopicViewModel$StoreState$Guild$Topic.getChannels();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(channels.size()));
        Iterator<T> it2 = channels.entrySet().iterator();
        while (it2.hasNext()) {
            Map$Entry map$Entry2 = (Map$Entry) it2.next();
            linkedHashMap2.put(map$Entry2.getKey(), ChannelUtils.c((Channel) map$Entry2.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map$Entry map$Entry3 : linkedHashMap2.entrySet()) {
            if (((String) map$Entry3.getValue()).length() > 0) {
                linkedHashMap3.put(map$Entry3.getKey(), map$Entry3.getValue());
            }
        }
        updateViewState(new WidgetChannelTopicViewModel$ViewState$Guild$Topic(str, linkedHashMap3, linkedHashMap, widgetChannelTopicViewModel$StoreState$Guild$Topic.getRoles(), widgetChannelTopicViewModel$StoreState$Guild$Topic.getAllowAnimatedEmojis(), listGenerateAST, messagePreprocessor.isLinkifyConflicting(), widgetChannelTopicViewModel$StoreState$Guild$Topic.getChannelIconType(), widgetChannelTopicViewModel$StoreState$Guild$Topic.getChannel(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
    }

    private final void handlePrivateStoreState(WidgetChannelTopicViewModel$StoreState storeState) {
        if (!(storeState instanceof WidgetChannelTopicViewModel$StoreState$DM)) {
            if (storeState instanceof WidgetChannelTopicViewModel$StoreState$GDM) {
                WidgetChannelTopicViewModel$StoreState$GDM widgetChannelTopicViewModel$StoreState$GDM = (WidgetChannelTopicViewModel$StoreState$GDM) storeState;
                updateViewState(new WidgetChannelTopicViewModel$ViewState$GDM(widgetChannelTopicViewModel$StoreState$GDM.getChannel(), widgetChannelTopicViewModel$StoreState$GDM.getChannel().getId(), widgetChannelTopicViewModel$StoreState$GDM.getDeveloperModeEnabled(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
                return;
            }
            return;
        }
        WidgetChannelTopicViewModel$StoreState$DM widgetChannelTopicViewModel$StoreState$DM = (WidgetChannelTopicViewModel$StoreState$DM) storeState;
        User userA = ChannelUtils.a(widgetChannelTopicViewModel$StoreState$DM.getChannel());
        String nickOrUsername$default = userA != null ? GuildMember$Companion.getNickOrUsername$default(GuildMember.Companion, userA, null, widgetChannelTopicViewModel$StoreState$DM.getChannel(), null, 8, null) : null;
        User userA2 = ChannelUtils.a(widgetChannelTopicViewModel$StoreState$DM.getChannel());
        Long lValueOf = userA2 != null ? Long.valueOf(userA2.getId()) : null;
        long id2 = widgetChannelTopicViewModel$StoreState$DM.getChannel().getId();
        Collection<Map<Long, GuildMember>> guildMembers = widgetChannelTopicViewModel$StoreState$DM.getGuildMembers();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = guildMembers.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            User userA3 = ChannelUtils.a(widgetChannelTopicViewModel$StoreState$DM.getChannel());
            GuildMember guildMember = (GuildMember) map.get(userA3 != null ? Long.valueOf(userA3.getId()) : null);
            String nick = guildMember != null ? guildMember.getNick() : null;
            if (nick != null) {
                arrayList.add(nick);
            }
        }
        Set set = u.toSet(arrayList);
        Collection<Map<Long, GuildMember>> guildMembers2 = widgetChannelTopicViewModel$StoreState$DM.getGuildMembers();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = guildMembers2.iterator();
        while (it2.hasNext()) {
            Map map2 = (Map) it2.next();
            User userA4 = ChannelUtils.a(widgetChannelTopicViewModel$StoreState$DM.getChannel());
            GuildMember guildMember2 = (GuildMember) map2.get(userA4 != null ? Long.valueOf(userA4.getId()) : null);
            if (guildMember2 != null) {
                arrayList2.add(guildMember2);
            }
        }
        updateViewState(new WidgetChannelTopicViewModel$ViewState$DM(nickOrUsername$default, lValueOf, set, u.toList(arrayList2), id2, widgetChannelTopicViewModel$StoreState$DM.getDeveloperModeEnabled(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
    }

    @MainThread
    private final void handleStoreState(WidgetChannelTopicViewModel$StoreState storeState) {
        Long lValueOf;
        if (storeState instanceof WidgetChannelTopicViewModel$StoreState$Guild$Topic) {
            long id2 = ((WidgetChannelTopicViewModel$StoreState$Guild$Topic) storeState).getChannel().getId();
            Long l = this.previousChannelId;
            this.revealedIndices = (l != null && id2 == l.longValue()) ? this.revealedIndices : n0.emptySet();
            lValueOf = Long.valueOf(id2);
        } else if (storeState instanceof WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic) {
            lValueOf = Long.valueOf(((WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic) storeState).getChannel().getId());
        } else if (storeState instanceof WidgetChannelTopicViewModel$StoreState$DM) {
            lValueOf = Long.valueOf(((WidgetChannelTopicViewModel$StoreState$DM) storeState).getChannel().getId());
        } else {
            lValueOf = storeState instanceof WidgetChannelTopicViewModel$StoreState$GDM ? Long.valueOf(((WidgetChannelTopicViewModel$StoreState$GDM) storeState).getChannel().getId()) : null;
        }
        this.previousChannelId = lValueOf;
        if (storeState.getIsRightPanelOpened() != this.wasRightPanelOpened || storeState.getIsOnHomeTab() != this.wasOnHomeTab) {
            if (storeState.getIsRightPanelOpened() && storeState.getIsOnHomeTab()) {
                this.eventSubject.k.onNext(WidgetChannelTopicViewModel$Event$FocusFirstElement.INSTANCE);
            }
            this.wasRightPanelOpened = storeState.getIsRightPanelOpened();
            this.wasOnHomeTab = storeState.getIsOnHomeTab();
        }
        if (storeState instanceof WidgetChannelTopicViewModel$StoreState$NoChannel) {
            updateViewState(new WidgetChannelTopicViewModel$ViewState$NoChannel(storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
        } else if (storeState instanceof WidgetChannelTopicViewModel$StoreState$Guild) {
            handleGuildStoreState((WidgetChannelTopicViewModel$StoreState$Guild) storeState);
        } else {
            handlePrivateStoreState(storeState);
        }
    }

    public final Unit handleClosePrivateChannel(Context context) {
        m.checkNotNullParameter(context, "context");
        Long l = this.previousChannelId;
        if (l == null) {
            return null;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().deleteChannel(l.longValue()), false, 1, null), this, null, 2, null), context, "javaClass", (Function1) null, new WidgetChannelTopicViewModel$handleClosePrivateChannel$$inlined$let$lambda$1(this, context), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
        return Unit.a;
    }

    @MainThread
    public final void handleOnIndexClicked(SpoilerNode<?> spoilerNode) {
        m.checkNotNullParameter(spoilerNode, "spoilerNode");
        WidgetChannelTopicViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetChannelTopicViewModel$ViewState$Guild$Topic)) {
            viewState = null;
        }
        WidgetChannelTopicViewModel$ViewState$Guild$Topic widgetChannelTopicViewModel$ViewState$Guild$Topic = (WidgetChannelTopicViewModel$ViewState$Guild$Topic) viewState;
        if (widgetChannelTopicViewModel$ViewState$Guild$Topic != null) {
            List<Node<MessageRenderContext>> listGenerateAST = generateAST(widgetChannelTopicViewModel$ViewState$Guild$Topic.getRawTopicString());
            this.revealedIndices = o0.plus(this.revealedIndices, Integer.valueOf(spoilerNode.getId()));
            MessagePreprocessor messagePreprocessor = new MessagePreprocessor(-1L, this.revealedIndices, null, false, null, 28, null);
            messagePreprocessor.process(listGenerateAST);
            updateViewState(WidgetChannelTopicViewModel$ViewState$Guild$Topic.copy$default(widgetChannelTopicViewModel$ViewState$Guild$Topic, null, null, null, null, false, listGenerateAST, messagePreprocessor.isLinkifyConflicting(), null, null, false, false, 1951, null));
        }
    }

    public final Observable<WidgetChannelTopicViewModel$Event> listenForEvents() {
        PublishSubject<WidgetChannelTopicViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelTopicViewModel(Observable<WidgetChannelTopicViewModel$StoreState> observable, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser) {
        super(new WidgetChannelTopicViewModel$ViewState$NoChannel(false, false));
        m.checkNotNullParameter(observable, "storeStateObservable");
        m.checkNotNullParameter(parser, "topicParser");
        this.topicParser = parser;
        this.revealedIndices = n0.emptySet();
        this.previousChannelId = 0L;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetChannelTopicViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelTopicViewModel$2(this), 62, (Object) null);
    }
}
