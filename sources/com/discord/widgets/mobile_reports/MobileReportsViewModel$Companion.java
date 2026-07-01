package com.discord.widgets.mobile_reports;

import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.report.ReportNode;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MobileReportsViewModel$Companion {
    private MobileReportsViewModel$Companion() {
    }

    public static final /* synthetic */ String access$getLocation(MobileReportsViewModel$Companion mobileReportsViewModel$Companion, ReportNode reportNode) {
        return mobileReportsViewModel$Companion.getLocation(reportNode);
    }

    public static final /* synthetic */ Observable access$getStoreState(MobileReportsViewModel$Companion mobileReportsViewModel$Companion, MobileReportArgs mobileReportArgs) {
        return mobileReportsViewModel$Companion.getStoreState(mobileReportArgs);
    }

    private final String getLocation(ReportNode node) {
        return "REPORT_MENU_NODE_" + node + ".id";
    }

    private final Observable<MobileReportsViewModel$StoreState> getStoreState(MobileReportArgs args) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreMessages messages = storeStream$Companion.getMessages();
        long channelId = args.getChannelId();
        MobileReportArgs$Message mobileReportArgs$Message = (MobileReportArgs$Message) (!(args instanceof MobileReportArgs$Message) ? null : args);
        Observable<Message> observableObserveMessagesForChannel = messages.observeMessagesForChannel(channelId, mobileReportArgs$Message != null ? mobileReportArgs$Message.getMessageId() : -1L);
        Observable<Channel> observableObserveChannel = storeStream$Companion.getChannels().observeChannel(args.getChannelId());
        Observable<Guild> observableObserveFromChannelId = storeStream$Companion.getGuilds().observeFromChannelId(args.getChannelId());
        Observable<StageInstance> observableObserveStageInstanceForChannel = storeStream$Companion.getStageInstances().observeStageInstanceForChannel(args.getChannelId());
        Observable<Map<Long, Integer>> observableObserveForType = storeStream$Companion.getUserRelationships().observeForType(2);
        Observable<RestCallState<List<DirectoryEntryGuild>>> observableObserveDirectoriesForChannel = storeStream$Companion.getDirectories().observeDirectoriesForChannel(args.getChannelId());
        StoreGuildScheduledEvents guildScheduledEvents = storeStream$Companion.getGuildScheduledEvents();
        boolean z2 = args instanceof MobileReportArgs$GuildScheduledEvent;
        MobileReportArgs$GuildScheduledEvent mobileReportArgs$GuildScheduledEvent = (MobileReportArgs$GuildScheduledEvent) (!z2 ? null : args);
        Long lValueOf = mobileReportArgs$GuildScheduledEvent != null ? Long.valueOf(mobileReportArgs$GuildScheduledEvent.getEventId()) : null;
        MobileReportArgs$GuildScheduledEvent mobileReportArgs$GuildScheduledEvent2 = (MobileReportArgs$GuildScheduledEvent) (!z2 ? null : args);
        Observable<GuildScheduledEvent> observableObserveGuildScheduledEvent = guildScheduledEvents.observeGuildScheduledEvent(lValueOf, mobileReportArgs$GuildScheduledEvent2 != null ? Long.valueOf(mobileReportArgs$GuildScheduledEvent2.getGuildId()) : null);
        StoreGuilds guilds = storeStream$Companion.getGuilds();
        MobileReportArgs$GuildScheduledEvent mobileReportArgs$GuildScheduledEvent3 = (MobileReportArgs$GuildScheduledEvent) (z2 ? args : null);
        Observable<MobileReportsViewModel$StoreState> observableD = Observable.d(observableObserveMessagesForChannel, observableObserveChannel, observableObserveFromChannelId, observableObserveStageInstanceForChannel, observableObserveForType, observableObserveDirectoriesForChannel, observableObserveGuildScheduledEvent, guilds.observeGuild(mobileReportArgs$GuildScheduledEvent3 != null ? mobileReportArgs$GuildScheduledEvent3.getGuildId() : -1L), new MobileReportsViewModel$Companion$getStoreState$1(args));
        m.checkNotNullExpressionValue(observableD, "Observable.combineLatest…nt = event,\n      )\n    }");
        return observableD;
    }

    public /* synthetic */ MobileReportsViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
