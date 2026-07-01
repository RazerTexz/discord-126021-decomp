package com.discord.widgets.mobile_reports;

import android.content.Context;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.report.MenuAPIResponse;
import com.discord.api.report.NodeElementResult;
import com.discord.api.report.NodeResult;
import com.discord.api.report.ReportNode;
import com.discord.api.report.ReportNodeChild;
import com.discord.api.report.ReportSubmissionBody;
import com.discord.api.report.ReportSubmissionBody$Companion;
import com.discord.api.stageinstance.StageInstance;
import com.discord.app.AppLog;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.member.GuildMember$Companion;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.DiscordParser$ParserOptions;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.t.u;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import rx.Observable;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MobileReportsViewModel extends d0<MobileReportsViewModel$ViewState> {
    public static final MobileReportsViewModel$Companion Companion = new MobileReportsViewModel$Companion(null);
    private final MobileReportArgs args;
    private final Clock clock;
    private final WeakReference<Context> context;
    private final RestAPI restAPI;

    public /* synthetic */ MobileReportsViewModel(WeakReference weakReference, MobileReportArgs mobileReportArgs, RestAPI restAPI, Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference, mobileReportArgs, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 8) != 0 ? ClockFactory.get() : clock, (i & 16) != 0 ? MobileReportsViewModel$Companion.access$getStoreState(Companion, mobileReportArgs) : observable);
    }

    public static final /* synthetic */ MobileReportsViewModel$ViewState access$getViewState$p(MobileReportsViewModel mobileReportsViewModel) {
        return mobileReportsViewModel.getViewState();
    }

    public static final /* synthetic */ MobileReportsViewModel$ChannelPreview access$parseChannelPreview(MobileReportsViewModel mobileReportsViewModel, MobileReportsViewModel$StoreState mobileReportsViewModel$StoreState) {
        return mobileReportsViewModel.parseChannelPreview(mobileReportsViewModel$StoreState);
    }

    public static final /* synthetic */ MobileReportsViewModel$DirectoryServerPreview access$parseDirectoryServerPreview(MobileReportsViewModel mobileReportsViewModel, MobileReportsViewModel$StoreState mobileReportsViewModel$StoreState) {
        return mobileReportsViewModel.parseDirectoryServerPreview(mobileReportsViewModel$StoreState);
    }

    public static final /* synthetic */ MobileReportsViewModel$GuildScheduledEventPreview access$parseEventPreview(MobileReportsViewModel mobileReportsViewModel, MobileReportsViewModel$StoreState mobileReportsViewModel$StoreState) {
        return mobileReportsViewModel.parseEventPreview(mobileReportsViewModel$StoreState);
    }

    public static final /* synthetic */ MobileReportsViewModel$MessagePreview access$parseMessagePreview(MobileReportsViewModel mobileReportsViewModel, MobileReportsViewModel$StoreState mobileReportsViewModel$StoreState) {
        return mobileReportsViewModel.parseMessagePreview(mobileReportsViewModel$StoreState);
    }

    public static final /* synthetic */ void access$updateViewState(MobileReportsViewModel mobileReportsViewModel, MobileReportsViewModel$ViewState mobileReportsViewModel$ViewState) {
        mobileReportsViewModel.updateViewState(mobileReportsViewModel$ViewState);
    }

    private final MobileReportsViewModel$ChannelPreview parseChannelPreview(MobileReportsViewModel$StoreState storeState) {
        StageInstance stageInstance;
        Guild guild = storeState.getGuild();
        if (guild == null || (stageInstance = storeState.getStageInstance()) == null) {
            return null;
        }
        return new MobileReportsViewModel$ChannelPreview(guild, stageInstance);
    }

    private final MobileReportsViewModel$DirectoryServerPreview parseDirectoryServerPreview(MobileReportsViewModel$StoreState storeState) {
        DirectoryEntryGuild directoryEntry;
        Guild guild = storeState.getGuild();
        if (guild == null || (directoryEntry = storeState.getDirectoryEntry()) == null) {
            return null;
        }
        return new MobileReportsViewModel$DirectoryServerPreview(guild, directoryEntry);
    }

    private final MobileReportsViewModel$GuildScheduledEventPreview parseEventPreview(MobileReportsViewModel$StoreState storeState) {
        Guild guild;
        GuildScheduledEvent event = storeState.getEvent();
        if (event == null || (guild = storeState.getGuild()) == null) {
            return null;
        }
        return new MobileReportsViewModel$GuildScheduledEventPreview(guild, event);
    }

    private final MobileReportsViewModel$MessagePreview parseMessagePreview(MobileReportsViewModel$StoreState storeState) {
        Message message;
        Context context = this.context.get();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context.get() ?: return null");
            Channel channel = storeState.getChannel();
            if (channel != null && (message = storeState.getMessage()) != null) {
                StoreStream$Companion storeStream$Companion = StoreStream.Companion;
                Map<Long, User> users = storeStream$Companion.getUsers().getUsers();
                com.discord.api.user.User author = message.getAuthor();
                User user = users.get(author != null ? Long.valueOf(author.getId()) : null);
                if (user == null || (getViewState() instanceof MobileReportsViewModel$ViewState$Invalid)) {
                    return null;
                }
                long id2 = storeStream$Companion.getUsers().getMeSnapshot().getId();
                Map map = (Map) a.c(channel, storeStream$Companion.getGuilds().getMembers());
                if (map == null) {
                    map = new HashMap();
                }
                Map map2 = map;
                Map map3 = (Map) a.c(channel, storeStream$Companion.getGuilds().getRoles());
                Map<Long, String> channelNames = storeStream$Companion.getChannels().getChannelNames();
                Map<Long, String> nickOrUsernames = MessageUtils.getNickOrUsernames(message, channel, map2, channel.q());
                String content = message.getContent();
                DraweeSpanStringBuilder channelMessage = DiscordParser.parseChannelMessage(context, content != null ? new Regex("\n").replace(content, " ") : null, new MessageRenderContext(context, id2, false, nickOrUsernames, channelNames, map3, 0, null, null, 0, 0, null, null, null, 16320, null), new MessagePreprocessor(id2, null, null, false, 50, 6, null), DiscordParser$ParserOptions.REPLY, false);
                com.discord.api.user.User author2 = message.getAuthor();
                String username = nickOrUsernames.get(author2 != null ? Long.valueOf(author2.getId()) : null);
                if (username == null) {
                    com.discord.api.user.User author3 = message.getAuthor();
                    username = author3 != null ? author3.getUsername() : null;
                }
                if (username == null) {
                    username = "";
                }
                String str = username;
                GuildMember$Companion guildMember$Companion = GuildMember.Companion;
                com.discord.api.user.User author4 = message.getAuthor();
                return new MobileReportsViewModel$MessagePreview(channelMessage, str, guildMember$Companion.getColor((GuildMember) map2.get(author4 != null ? Long.valueOf(author4.getId()) : null), ColorCompat.getThemedColor(context, 2130968989)), user, message.hasEmbeds() || message.hasAttachments());
            }
        }
        return null;
    }

    public final boolean handleBack() {
        MobileReportsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof MobileReportsViewModel$ViewState$Menu)) {
            viewState = null;
        }
        MobileReportsViewModel$ViewState$Menu mobileReportsViewModel$ViewState$Menu = (MobileReportsViewModel$ViewState$Menu) viewState;
        if (mobileReportsViewModel$ViewState$Menu == null) {
            return false;
        }
        NodeResult nodeResult = (NodeResult) u.lastOrNull((List) mobileReportsViewModel$ViewState$Menu.getHistory());
        ReportNode node = nodeResult != null ? nodeResult.getNode() : null;
        ReportNode node2 = mobileReportsViewModel$ViewState$Menu.getNodeNavigationType().getNode();
        MenuAPIResponse menu = mobileReportsViewModel$ViewState$Menu.getMenu();
        if (menu.getSuccess_node_id() != node2.getId() && !(mobileReportsViewModel$ViewState$Menu.getSubmitState() instanceof MobileReportsViewModel$SubmitState$Loading)) {
            if (node == null || menu.getRoot_node_id() == node2.getId()) {
                return false;
            }
            updateViewState(MobileReportsViewModel$ViewState$Menu.copy$default(mobileReportsViewModel$ViewState$Menu, null, null, null, null, null, new MobileReportsViewModel$NodeNavigationType$Back(node), null, u.dropLast(mobileReportsViewModel$ViewState$Menu.getHistory(), 1), null, 351, null));
        }
        return true;
    }

    public final void handleBlockUser() {
        MobileReportsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof MobileReportsViewModel$ViewState$Menu)) {
            viewState = null;
        }
        MobileReportsViewModel$ViewState$Menu mobileReportsViewModel$ViewState$Menu = (MobileReportsViewModel$ViewState$Menu) viewState;
        if (mobileReportsViewModel$ViewState$Menu != null) {
            ReportNode node = mobileReportsViewModel$ViewState$Menu.getNodeNavigationType().getNode();
            MobileReportsViewModel$BlockUserElement blockUserElement = mobileReportsViewModel$ViewState$Menu.getBlockUserElement();
            if (blockUserElement != null) {
                updateViewState(MobileReportsViewModel$ViewState$Menu.copy$default(mobileReportsViewModel$ViewState$Menu, null, null, null, null, null, null, null, null, MobileReportsViewModel$BlockUserElement.copy$default(blockUserElement, true, null, 2, null), 255, null));
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.addRelationship$default(this.restAPI, MobileReportsViewModel$Companion.access$getLocation(Companion, node), blockUserElement.getUser().getId(), 2, null, null, 24, null), false, 1, null), this, null, 2, null), MobileReportsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, MobileReportsViewModel$handleBlockUser$1.INSTANCE, 62, (Object) null);
            }
        }
    }

    public final void handleNext(ReportNodeChild destination, NodeElementResult elementResult) {
        ReportNode reportNode;
        m.checkNotNullParameter(destination, "destination");
        MobileReportsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof MobileReportsViewModel$ViewState$Menu)) {
            viewState = null;
        }
        MobileReportsViewModel$ViewState$Menu mobileReportsViewModel$ViewState$Menu = (MobileReportsViewModel$ViewState$Menu) viewState;
        if (mobileReportsViewModel$ViewState$Menu == null || (reportNode = mobileReportsViewModel$ViewState$Menu.getMenu().c().get(Integer.valueOf(destination.getRef()))) == null) {
            return;
        }
        updateViewState(MobileReportsViewModel$ViewState$Menu.copy$default(mobileReportsViewModel$ViewState$Menu, null, null, null, null, null, new MobileReportsViewModel$NodeNavigationType$Next(reportNode), MobileReportsViewModel$SubmitState$None.INSTANCE, u.plus((Collection<? extends NodeResult>) mobileReportsViewModel$ViewState$Menu.getHistory(), new NodeResult(mobileReportsViewModel$ViewState$Menu.getNodeNavigationType().getNode(), destination, elementResult)), null, 287, null));
    }

    public final void handleSubmit() {
        ReportSubmissionBody reportSubmissionBody;
        Guild guild;
        MobileReportsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof MobileReportsViewModel$ViewState$Menu)) {
            viewState = null;
        }
        MobileReportsViewModel$ViewState$Menu mobileReportsViewModel$ViewState$Menu = (MobileReportsViewModel$ViewState$Menu) viewState;
        if (mobileReportsViewModel$ViewState$Menu == null || (mobileReportsViewModel$ViewState$Menu.getSubmitState() instanceof MobileReportsViewModel$SubmitState$Loading)) {
            return;
        }
        updateViewState(MobileReportsViewModel$ViewState$Menu.copy$default(mobileReportsViewModel$ViewState$Menu, null, null, null, null, null, null, MobileReportsViewModel$SubmitState$Loading.INSTANCE, null, null, 447, null));
        MobileReportArgs mobileReportArgs = this.args;
        if (mobileReportArgs instanceof MobileReportArgs$Message) {
            ReportSubmissionBody$Companion reportSubmissionBody$Companion = ReportSubmissionBody.Companion;
            long jCurrentTimeMillis = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long channelId = this.args.getChannelId();
            long messageId = ((MobileReportArgs$Message) this.args).getMessageId();
            MenuAPIResponse menu = mobileReportsViewModel$ViewState$Menu.getMenu();
            List<NodeResult> history = mobileReportsViewModel$ViewState$Menu.getHistory();
            Objects.requireNonNull(reportSubmissionBody$Companion);
            m.checkNotNullParameter(menu, "menu");
            m.checkNotNullParameter(history, "results");
            Pair<List<Integer>, Map<String, List<String>>> pairA = reportSubmissionBody$Companion.a(history);
            List<Integer> listComponent1 = pairA.component1();
            Map<String, List<String>> mapComponent2 = pairA.component2();
            Long lValueOf = Long.valueOf(messageId);
            Long lValueOf2 = Long.valueOf(channelId);
            String name = menu.getName();
            String language = menu.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis, lValueOf, lValueOf2, null, null, null, language != null ? language : "en", menu.getVariant(), name, menu.getVersion(), listComponent1, mapComponent2, 56);
        } else if (mobileReportArgs instanceof MobileReportArgs$StageChannel) {
            MobileReportsViewModel$ChannelPreview channelPreview = mobileReportsViewModel$ViewState$Menu.getChannelPreview();
            if (channelPreview == null || (guild = channelPreview.getGuild()) == null) {
                Logger.e$default(AppLog.g, "Tried to send report for stage channel, but without guild id?", null, null, 6, null);
                return;
            }
            long id2 = guild.getId();
            ReportSubmissionBody$Companion reportSubmissionBody$Companion2 = ReportSubmissionBody.Companion;
            long jCurrentTimeMillis2 = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long channelId2 = this.args.getChannelId();
            MenuAPIResponse menu2 = mobileReportsViewModel$ViewState$Menu.getMenu();
            List<NodeResult> history2 = mobileReportsViewModel$ViewState$Menu.getHistory();
            Objects.requireNonNull(reportSubmissionBody$Companion2);
            m.checkNotNullParameter(menu2, "menu");
            m.checkNotNullParameter(history2, "results");
            Pair<List<Integer>, Map<String, List<String>>> pairA2 = reportSubmissionBody$Companion2.a(history2);
            List<Integer> listComponent2 = pairA2.component1();
            Map<String, List<String>> mapComponent3 = pairA2.component2();
            Long lValueOf3 = Long.valueOf(id2);
            Long lValueOf4 = Long.valueOf(channelId2);
            String name2 = menu2.getName();
            String language2 = menu2.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis2, null, lValueOf4, lValueOf3, null, null, language2 != null ? language2 : "en", menu2.getVariant(), name2, menu2.getVersion(), listComponent2, mapComponent3, 50);
        } else if (mobileReportArgs instanceof MobileReportArgs$DirectoryServer) {
            ReportSubmissionBody$Companion reportSubmissionBody$Companion3 = ReportSubmissionBody.Companion;
            long jCurrentTimeMillis3 = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long channelId3 = this.args.getChannelId();
            long guildId = ((MobileReportArgs$DirectoryServer) this.args).getGuildId();
            long hubId = ((MobileReportArgs$DirectoryServer) this.args).getHubId();
            MenuAPIResponse menu3 = mobileReportsViewModel$ViewState$Menu.getMenu();
            List<NodeResult> history3 = mobileReportsViewModel$ViewState$Menu.getHistory();
            Objects.requireNonNull(reportSubmissionBody$Companion3);
            m.checkNotNullParameter(menu3, "menu");
            m.checkNotNullParameter(history3, "results");
            Pair<List<Integer>, Map<String, List<String>>> pairA3 = reportSubmissionBody$Companion3.a(history3);
            List<Integer> listComponent3 = pairA3.component1();
            Map<String, List<String>> mapComponent4 = pairA3.component2();
            Long lValueOf5 = Long.valueOf(guildId);
            Long lValueOf6 = Long.valueOf(channelId3);
            Long lValueOf7 = Long.valueOf(hubId);
            String name3 = menu3.getName();
            String language3 = menu3.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis3, null, lValueOf6, lValueOf5, lValueOf7, null, language3 != null ? language3 : "en", menu3.getVariant(), name3, menu3.getVersion(), listComponent3, mapComponent4, 34);
        } else {
            if (!(mobileReportArgs instanceof MobileReportArgs$GuildScheduledEvent)) {
                throw new NoWhenBranchMatchedException();
            }
            ReportSubmissionBody$Companion reportSubmissionBody$Companion4 = ReportSubmissionBody.Companion;
            long jCurrentTimeMillis4 = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long guildId2 = ((MobileReportArgs$GuildScheduledEvent) this.args).getGuildId();
            long eventId = ((MobileReportArgs$GuildScheduledEvent) this.args).getEventId();
            MenuAPIResponse menu4 = mobileReportsViewModel$ViewState$Menu.getMenu();
            List<NodeResult> history4 = mobileReportsViewModel$ViewState$Menu.getHistory();
            Objects.requireNonNull(reportSubmissionBody$Companion4);
            m.checkNotNullParameter(menu4, "menu");
            m.checkNotNullParameter(history4, "results");
            Pair<List<Integer>, Map<String, List<String>>> pairA4 = reportSubmissionBody$Companion4.a(history4);
            List<Integer> listComponent4 = pairA4.component1();
            Map<String, List<String>> mapComponent5 = pairA4.component2();
            Long lValueOf8 = Long.valueOf(guildId2);
            Long lValueOf9 = Long.valueOf(eventId);
            String name4 = menu4.getName();
            String language4 = menu4.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis4, null, null, lValueOf8, null, lValueOf9, language4 != null ? language4 : "en", menu4.getVariant(), name4, menu4.getVersion(), listComponent4, mapComponent5, 22);
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.submitReport(this.args.getReportType().getPathValue(), reportSubmissionBody), false, 1, null), this, null, 2, null), MobileReportsViewModel.class, (Context) null, (Function1) null, new MobileReportsViewModel$handleSubmit$2(this, mobileReportsViewModel$ViewState$Menu), (Function0) null, (Function0) null, new MobileReportsViewModel$handleSubmit$1(this, mobileReportsViewModel$ViewState$Menu), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileReportsViewModel(WeakReference<Context> weakReference, MobileReportArgs mobileReportArgs, RestAPI restAPI, Clock clock, Observable<MobileReportsViewModel$StoreState> observable) {
        super(null);
        m.checkNotNullParameter(weakReference, "context");
        m.checkNotNullParameter(mobileReportArgs, "args");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.context = weakReference;
        this.args = mobileReportArgs;
        this.restAPI = restAPI;
        this.clock = clock;
        Observable observableJ = Observable.j(ObservableExtensionsKt.computationLatest(observable), ObservableExtensionsKt.restSubscribeOn$default(restAPI.getReportMenu(mobileReportArgs.getReportType().getPathValue()), false, 1, null), MobileReportsViewModel$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…> storeState to menuAPI }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableJ, this, null, 2, null), MobileReportsViewModel.class, (Context) null, (Function1) null, new MobileReportsViewModel$3(this), (Function0) null, (Function0) null, new MobileReportsViewModel$2(this), 54, (Object) null);
    }
}
