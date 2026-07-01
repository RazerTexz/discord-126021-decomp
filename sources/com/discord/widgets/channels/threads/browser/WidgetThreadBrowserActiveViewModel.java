package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.user.User;
import com.discord.models.message.Message;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildMemberRequester;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadMessages$ThreadState;
import com.discord.stores.StoreThreadsActive;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel extends d0<WidgetThreadBrowserActiveViewModel$ViewState> {
    public static final WidgetThreadBrowserActiveViewModel$Companion Companion = new WidgetThreadBrowserActiveViewModel$Companion(null);
    private final long channelId;
    private final long guildId;
    private final StoreChannels storeChannels;
    private final StoreGuildMemberRequester storeGuildMemberRequester;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreThreadMessages storeThreadMessages;
    private final StoreThreadsActive storeThreadsActive;
    private final StoreThreadsActiveJoined storeThreadsActiveJoined;
    private final StoreUser storeUser;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetThreadBrowserActiveViewModel(long j, long j2, StoreUser storeUser, StoreGuildMemberRequester storeGuildMemberRequester, StoreThreadsActive storeThreadsActive, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreUser users = (i & 4) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        StoreGuildMemberRequester guildMemberRequester = (i & 8) != 0 ? StoreStream.Companion.getGuildMemberRequester() : storeGuildMemberRequester;
        StoreThreadsActive threadsActive = (i & 16) != 0 ? StoreStream.Companion.getThreadsActive() : storeThreadsActive;
        StoreThreadsActiveJoined threadsActiveJoined = (i & 32) != 0 ? StoreStream.Companion.getThreadsActiveJoined() : storeThreadsActiveJoined;
        StoreThreadMessages threadMessages = (i & 64) != 0 ? StoreStream.Companion.getThreadMessages() : storeThreadMessages;
        StoreGuilds guilds = (i & 128) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        StoreChannels channels = (i & 256) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StorePermissions permissions = (i & 512) != 0 ? StoreStream.Companion.getPermissions() : storePermissions;
        this(j, j2, users, guildMemberRequester, threadsActive, threadsActiveJoined, threadMessages, guilds, channels, permissions, (i & 1024) != 0 ? WidgetThreadBrowserActiveViewModel$Companion.access$observeStoreState(Companion, j, j2, users, threadsActive, threadsActiveJoined, threadMessages, guilds, channels, permissions) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetThreadBrowserActiveViewModel widgetThreadBrowserActiveViewModel, WidgetThreadBrowserActiveViewModel$StoreState widgetThreadBrowserActiveViewModel$StoreState) {
        widgetThreadBrowserActiveViewModel.handleStoreState(widgetThreadBrowserActiveViewModel$StoreState);
    }

    @MainThread
    private final void handleStoreState(WidgetThreadBrowserActiveViewModel$StoreState storeState) {
        int i;
        User author;
        User author2;
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z2 = true;
        List listListOf = n.listOf((Object[]) new Triple[]{new Triple("joined", 2131896358, storeState.getActiveJoinedThreads()), new Triple("other", 2131896362, storeState.getActiveThreads())});
        Channel channel = storeState.getChannel();
        Message message = null;
        if (channel != null && channel.getType() == 15) {
            arrayList.add(new WidgetThreadBrowserAdapter$Item$Warning(null, 1, null));
        }
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            Triple triple = (Triple) it.next();
            String str = (String) triple.component1();
            int iIntValue = ((Number) triple.component2()).intValue();
            Map map = (Map) triple.component3();
            if (map.isEmpty()) {
                i = 0;
            } else {
                Iterator it2 = map.entrySet().iterator();
                i = 0;
                while (it2.hasNext()) {
                    if (linkedHashSet.contains(Long.valueOf(((Number) ((Map$Entry) it2.next()).getKey()).longValue())) ^ z2) {
                        i++;
                    }
                }
            }
            if (i != 0) {
                arrayList.add(new WidgetThreadBrowserAdapter$Item$Header(str, iIntValue, i));
                Iterator it3 = map.entrySet().iterator();
                while (it3.hasNext()) {
                    Map$Entry map$Entry = (Map$Entry) it3.next();
                    long jLongValue = ((Number) map$Entry.getKey()).longValue();
                    Channel channel2 = (Channel) map$Entry.getValue();
                    if (linkedHashSet.contains(Long.valueOf(jLongValue))) {
                        it = it;
                        it3 = it3;
                    } else {
                        com.discord.models.user.User user = storeState.getUsers().get(Long.valueOf(channel2.getOwnerId()));
                        if (user == null || !storeState.getGuildMembers().containsKey(Long.valueOf(channel2.getOwnerId()))) {
                            this.storeGuildMemberRequester.queueRequest(channel2.getGuildId(), channel2.getOwnerId());
                        }
                        StoreThreadMessages$ThreadState storeThreadMessages$ThreadState = storeState.getThreadStates().get(Long.valueOf(jLongValue));
                        Message mostRecentMessage = storeThreadMessages$ThreadState != null ? storeThreadMessages$ThreadState.getMostRecentMessage() : message;
                        if (mostRecentMessage != null && (author2 = mostRecentMessage.getAuthor()) != null && !storeState.getGuildMembers().containsKey(Long.valueOf(author2.getId()))) {
                            this.storeGuildMemberRequester.queueRequest(channel2.getGuildId(), author2.getId());
                        }
                        arrayList.add(new WidgetThreadBrowserAdapter$Item$Thread(new ThreadBrowserThreadView$ThreadData$ActiveThread(channel2, user, mostRecentMessage, storeState.getMeUser().getId(), storeState.getGuildMembers(), storeState.getGuildRoles(), storeState.getChannelNames(), storeState.getBlockedUsers().containsKey((mostRecentMessage == null || (author = mostRecentMessage.getAuthor()) == null) ? null : Long.valueOf(author.getId())))));
                        linkedHashSet.add(Long.valueOf(jLongValue));
                    }
                    it = it;
                    it3 = it3;
                    message = null;
                }
            }
            it = it;
            z2 = true;
            message = null;
        }
        if (linkedHashSet.isEmpty()) {
            arrayList.clear();
        }
        this.storeGuildMemberRequester.performQueuedRequests();
        updateViewState(new WidgetThreadBrowserActiveViewModel$ViewState(arrayList, ThreadUtils.INSTANCE.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild())));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserActiveViewModel(long j, long j2, StoreUser storeUser, StoreGuildMemberRequester storeGuildMemberRequester, StoreThreadsActive storeThreadsActive, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, Observable<WidgetThreadBrowserActiveViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeGuildMemberRequester, "storeGuildMemberRequester");
        m.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        m.checkNotNullParameter(storeThreadsActiveJoined, "storeThreadsActiveJoined");
        m.checkNotNullParameter(storeThreadMessages, "storeThreadMessages");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.channelId = j2;
        this.storeUser = storeUser;
        this.storeGuildMemberRequester = storeGuildMemberRequester;
        this.storeThreadsActive = storeThreadsActive;
        this.storeThreadsActiveJoined = storeThreadsActiveJoined;
        this.storeThreadMessages = storeThreadMessages;
        this.storeGuilds = storeGuilds;
        this.storeChannels = storeChannels;
        this.storePermissions = storePermissions;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetThreadBrowserActiveViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetThreadBrowserActiveViewModel$1(this), 62, (Object) null);
    }
}
