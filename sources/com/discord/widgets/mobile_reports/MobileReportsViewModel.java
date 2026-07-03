package com.discord.widgets.mobile_reports;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.report.MenuAPIResponse;
import com.discord.api.report.NodeElementResult;
import com.discord.api.report.NodeResult;
import com.discord.api.report.ReportNode;
import com.discord.api.report.ReportNodeBottomButton;
import com.discord.api.report.ReportNodeChild;
import com.discord.api.report.ReportNodeElement;
import com.discord.api.report.ReportNodeElementData;
import com.discord.api.report.ReportSubmissionBody;
import com.discord.api.stageinstance.StageInstance;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.mobile_reports.MobileReportArgs;
import com.discord.widgets.mobile_reports.MobileReportsViewModel;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.functions.Func8;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MobileReportsViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MobileReportArgs args;
    private final Clock clock;
    private final WeakReference<Context> context;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$2 */
    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final class C90752 extends AbstractC12240o implements Function1<Pair<? extends StoreState, ? extends MenuAPIResponse>, Unit> {
        public C90752() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends StoreState, ? extends MenuAPIResponse> pair) {
            invoke2((Pair<StoreState, MenuAPIResponse>) pair);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<StoreState, MenuAPIResponse> pair) {
            ReportNode reportNode;
            StoreState storeStateComponent1 = pair.component1();
            MenuAPIResponse menuAPIResponseComponent2 = pair.component2();
            if (menuAPIResponseComponent2 != null) {
                reportNode = menuAPIResponseComponent2.m8161c().get(Integer.valueOf(menuAPIResponseComponent2.getRoot_node_id()));
            } else {
                reportNode = null;
            }
            if (menuAPIResponseComponent2 == null || reportNode == null) {
                MobileReportsViewModel.this.updateViewState(ViewState.Invalid.INSTANCE);
                return;
            }
            MobileReportsViewModel mobileReportsViewModel = MobileReportsViewModel.this;
            C12238m.checkNotNullExpressionValue(storeStateComponent1, "storeState");
            MessagePreview messagePreview = mobileReportsViewModel.parseMessagePreview(storeStateComponent1);
            MobileReportsViewModel mobileReportsViewModel2 = MobileReportsViewModel.this;
            ViewState viewStateAccess$getViewState$p = MobileReportsViewModel.access$getViewState$p(mobileReportsViewModel2);
            if (viewStateAccess$getViewState$p == null) {
                viewStateAccess$getViewState$p = new ViewState.Menu(menuAPIResponseComponent2, messagePreview, MobileReportsViewModel.this.parseChannelPreview(storeStateComponent1), MobileReportsViewModel.this.parseDirectoryServerPreview(storeStateComponent1), MobileReportsViewModel.this.parseEventPreview(storeStateComponent1), new NodeNavigationType.Initial(reportNode), null, C12147n.emptyList(), messagePreview != null ? new BlockUserElement(storeStateComponent1.getBlockedUsers().containsKey(Long.valueOf(messagePreview.getAuthor().getId())), messagePreview.getAuthor()) : null, 64, null);
            }
            mobileReportsViewModel2.updateViewState(viewStateAccess$getViewState$p);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$3 */
    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final class C90763 extends AbstractC12240o implements Function1<Error, Unit> {
        public C90763() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            Logger.e$default(AppLog.f14950g, "Can't parse report message? Closing report screen.", null, null, 6, null);
            MobileReportsViewModel.this.updateViewState(ViewState.Invalid.INSTANCE);
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final /* data */ class BlockUserElement {
        private final boolean isBlocked;
        private final User user;

        public BlockUserElement(boolean z2, User user) {
            C12238m.checkNotNullParameter(user, "user");
            this.isBlocked = z2;
            this.user = user;
        }

        public static /* synthetic */ BlockUserElement copy$default(BlockUserElement blockUserElement, boolean z2, User user, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = blockUserElement.isBlocked;
            }
            if ((i & 2) != 0) {
                user = blockUserElement.user;
            }
            return blockUserElement.copy(z2, user);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsBlocked() {
            return this.isBlocked;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final BlockUserElement copy(boolean isBlocked, User user) {
            C12238m.checkNotNullParameter(user, "user");
            return new BlockUserElement(isBlocked, user);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BlockUserElement)) {
                return false;
            }
            BlockUserElement blockUserElement = (BlockUserElement) other;
            return this.isBlocked == blockUserElement.isBlocked && C12238m.areEqual(this.user, blockUserElement.user);
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z2 = this.isBlocked;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            User user = this.user;
            return i + (user != null ? user.hashCode() : 0);
        }

        public final boolean isBlocked() {
            return this.isBlocked;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("BlockUserElement(isBlocked=");
            sbM833U.append(this.isBlocked);
            sbM833U.append(", user=");
            sbM833U.append(this.user);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final /* data */ class ChannelPreview {
        private final Guild guild;
        private final StageInstance stageInstance;

        public ChannelPreview(Guild guild, StageInstance stageInstance) {
            C12238m.checkNotNullParameter(guild, "guild");
            C12238m.checkNotNullParameter(stageInstance, "stageInstance");
            this.guild = guild;
            this.stageInstance = stageInstance;
        }

        public static /* synthetic */ ChannelPreview copy$default(ChannelPreview channelPreview, Guild guild, StageInstance stageInstance, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = channelPreview.guild;
            }
            if ((i & 2) != 0) {
                stageInstance = channelPreview.stageInstance;
            }
            return channelPreview.copy(guild, stageInstance);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public final ChannelPreview copy(Guild guild, StageInstance stageInstance) {
            C12238m.checkNotNullParameter(guild, "guild");
            C12238m.checkNotNullParameter(stageInstance, "stageInstance");
            return new ChannelPreview(guild, stageInstance);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelPreview)) {
                return false;
            }
            ChannelPreview channelPreview = (ChannelPreview) other;
            return C12238m.areEqual(this.guild, channelPreview.guild) && C12238m.areEqual(this.stageInstance, channelPreview.stageInstance);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            StageInstance stageInstance = this.stageInstance;
            return iHashCode + (stageInstance != null ? stageInstance.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ChannelPreview(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", stageInstance=");
            sbM833U.append(this.stageInstance);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final /* data */ class CheckboxElement {
        private final List<ReportNodeElementData> data;
        private final String name;
        private final HashSet<ReportNodeElementData> selections;

        public CheckboxElement(String str, List<ReportNodeElementData> list, HashSet<ReportNodeElementData> hashSet) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(list, "data");
            C12238m.checkNotNullParameter(hashSet, "selections");
            this.name = str;
            this.data = list;
            this.selections = hashSet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CheckboxElement copy$default(CheckboxElement checkboxElement, String str, List list, HashSet hashSet, int i, Object obj) {
            if ((i & 1) != 0) {
                str = checkboxElement.name;
            }
            if ((i & 2) != 0) {
                list = checkboxElement.data;
            }
            if ((i & 4) != 0) {
                hashSet = checkboxElement.selections;
            }
            return checkboxElement.copy(str, list, hashSet);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final List<ReportNodeElementData> component2() {
            return this.data;
        }

        public final HashSet<ReportNodeElementData> component3() {
            return this.selections;
        }

        public final CheckboxElement copy(String name, List<ReportNodeElementData> data, HashSet<ReportNodeElementData> selections) {
            C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(data, "data");
            C12238m.checkNotNullParameter(selections, "selections");
            return new CheckboxElement(name, data, selections);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CheckboxElement)) {
                return false;
            }
            CheckboxElement checkboxElement = (CheckboxElement) other;
            return C12238m.areEqual(this.name, checkboxElement.name) && C12238m.areEqual(this.data, checkboxElement.data) && C12238m.areEqual(this.selections, checkboxElement.selections);
        }

        public final List<ReportNodeElementData> getData() {
            return this.data;
        }

        public final String getName() {
            return this.name;
        }

        public final HashSet<ReportNodeElementData> getSelections() {
            return this.selections;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            List<ReportNodeElementData> list = this.data;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            HashSet<ReportNodeElementData> hashSet = this.selections;
            return iHashCode2 + (hashSet != null ? hashSet.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("CheckboxElement(name=");
            sbM833U.append(this.name);
            sbM833U.append(", data=");
            sbM833U.append(this.data);
            sbM833U.append(", selections=");
            sbM833U.append(this.selections);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final String getLocation(ReportNode node) {
            return "REPORT_MENU_NODE_" + node + ".id";
        }

        private final Observable<StoreState> getStoreState(final MobileReportArgs args) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreMessages messages = companion.getMessages();
            long channelId = args.getChannelId();
            MobileReportArgs.Message message = (MobileReportArgs.Message) (!(args instanceof MobileReportArgs.Message) ? null : args);
            Observable<Message> observableObserveMessagesForChannel = messages.observeMessagesForChannel(channelId, message != null ? message.getMessageId() : -1L);
            Observable<Channel> observableObserveChannel = companion.getChannels().observeChannel(args.getChannelId());
            Observable<Guild> observableObserveFromChannelId = companion.getGuilds().observeFromChannelId(args.getChannelId());
            Observable<StageInstance> observableObserveStageInstanceForChannel = companion.getStageInstances().observeStageInstanceForChannel(args.getChannelId());
            Observable<Map<Long, Integer>> observableObserveForType = companion.getUserRelationships().observeForType(2);
            Observable<RestCallState<List<DirectoryEntryGuild>>> observableObserveDirectoriesForChannel = companion.getDirectories().observeDirectoriesForChannel(args.getChannelId());
            StoreGuildScheduledEvents guildScheduledEvents = companion.getGuildScheduledEvents();
            boolean z2 = args instanceof MobileReportArgs.GuildScheduledEvent;
            MobileReportArgs.GuildScheduledEvent guildScheduledEvent = (MobileReportArgs.GuildScheduledEvent) (!z2 ? null : args);
            Long lValueOf = guildScheduledEvent != null ? Long.valueOf(guildScheduledEvent.getEventId()) : null;
            MobileReportArgs.GuildScheduledEvent guildScheduledEvent2 = (MobileReportArgs.GuildScheduledEvent) (!z2 ? null : args);
            Observable<GuildScheduledEvent> observableObserveGuildScheduledEvent = guildScheduledEvents.observeGuildScheduledEvent(lValueOf, guildScheduledEvent2 != null ? Long.valueOf(guildScheduledEvent2.getGuildId()) : null);
            StoreGuilds guilds = companion.getGuilds();
            MobileReportArgs.GuildScheduledEvent guildScheduledEvent3 = (MobileReportArgs.GuildScheduledEvent) (z2 ? args : null);
            Observable<StoreState> observableM11067d = Observable.m11067d(observableObserveMessagesForChannel, observableObserveChannel, observableObserveFromChannelId, observableObserveStageInstanceForChannel, observableObserveForType, observableObserveDirectoriesForChannel, observableObserveGuildScheduledEvent, guilds.observeGuild(guildScheduledEvent3 != null ? guildScheduledEvent3.getGuildId() : -1L), new Func8<Message, Channel, Guild, StageInstance, Map<Long, ? extends Integer>, RestCallState<? extends List<? extends DirectoryEntryGuild>>, GuildScheduledEvent, Guild, StoreState>() { // from class: com.discord.widgets.mobile_reports.MobileReportsViewModel$Companion$getStoreState$1
                @Override // p658rx.functions.Func8
                public /* bridge */ /* synthetic */ MobileReportsViewModel.StoreState call(Message message2, Channel channel, Guild guild, StageInstance stageInstance, Map<Long, ? extends Integer> map, RestCallState<? extends List<? extends DirectoryEntryGuild>> restCallState, GuildScheduledEvent guildScheduledEvent4, Guild guild2) {
                    return call2(message2, channel, guild, stageInstance, (Map<Long, Integer>) map, (RestCallState<? extends List<DirectoryEntryGuild>>) restCallState, guildScheduledEvent4, guild2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final MobileReportsViewModel.StoreState call2(Message message2, Channel channel, Guild guild, StageInstance stageInstance, Map<Long, Integer> map, RestCallState<? extends List<DirectoryEntryGuild>> restCallState, GuildScheduledEvent guildScheduledEvent4, Guild guild2) {
                    List<DirectoryEntryGuild> listInvoke;
                    MobileReportArgs mobileReportArgs = args;
                    Object obj = null;
                    if (!(mobileReportArgs instanceof MobileReportArgs.DirectoryServer)) {
                        mobileReportArgs = null;
                    }
                    MobileReportArgs.DirectoryServer directoryServer = (MobileReportArgs.DirectoryServer) mobileReportArgs;
                    Long lValueOf2 = directoryServer != null ? Long.valueOf(directoryServer.getGuildId()) : null;
                    Guild guild3 = guild != null ? guild : guild2;
                    C12238m.checkNotNullExpressionValue(map, "blockedUsers");
                    if (restCallState != null && (listInvoke = restCallState.invoke()) != null) {
                        for (Object obj2 : listInvoke) {
                            if (lValueOf2 != null && ((DirectoryEntryGuild) obj2).getGuild().getId() == lValueOf2.longValue()) {
                                obj = obj2;
                                break;
                            }
                        }
                        obj = (DirectoryEntryGuild) obj;
                    }
                    return new MobileReportsViewModel.StoreState(message2, channel, guild3, obj, stageInstance, map, guildScheduledEvent4);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11067d, "Observable.combineLatest…nt = event,\n      )\n    }");
            return observableM11067d;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final /* data */ class DirectoryServerPreview {
        private final DirectoryEntryGuild directoryEntry;
        private final Guild hub;

        public DirectoryServerPreview(Guild guild, DirectoryEntryGuild directoryEntryGuild) {
            C12238m.checkNotNullParameter(guild, "hub");
            C12238m.checkNotNullParameter(directoryEntryGuild, "directoryEntry");
            this.hub = guild;
            this.directoryEntry = directoryEntryGuild;
        }

        public static /* synthetic */ DirectoryServerPreview copy$default(DirectoryServerPreview directoryServerPreview, Guild guild, DirectoryEntryGuild directoryEntryGuild, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = directoryServerPreview.hub;
            }
            if ((i & 2) != 0) {
                directoryEntryGuild = directoryServerPreview.directoryEntry;
            }
            return directoryServerPreview.copy(guild, directoryEntryGuild);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getHub() {
            return this.hub;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final DirectoryEntryGuild getDirectoryEntry() {
            return this.directoryEntry;
        }

        public final DirectoryServerPreview copy(Guild hub, DirectoryEntryGuild directoryEntry) {
            C12238m.checkNotNullParameter(hub, "hub");
            C12238m.checkNotNullParameter(directoryEntry, "directoryEntry");
            return new DirectoryServerPreview(hub, directoryEntry);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DirectoryServerPreview)) {
                return false;
            }
            DirectoryServerPreview directoryServerPreview = (DirectoryServerPreview) other;
            return C12238m.areEqual(this.hub, directoryServerPreview.hub) && C12238m.areEqual(this.directoryEntry, directoryServerPreview.directoryEntry);
        }

        public final DirectoryEntryGuild getDirectoryEntry() {
            return this.directoryEntry;
        }

        public final Guild getHub() {
            return this.hub;
        }

        public int hashCode() {
            Guild guild = this.hub;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            DirectoryEntryGuild directoryEntryGuild = this.directoryEntry;
            return iHashCode + (directoryEntryGuild != null ? directoryEntryGuild.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("DirectoryServerPreview(hub=");
            sbM833U.append(this.hub);
            sbM833U.append(", directoryEntry=");
            sbM833U.append(this.directoryEntry);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final /* data */ class GuildScheduledEventPreview {
        private final GuildScheduledEvent event;
        private final Guild guild;

        public GuildScheduledEventPreview(Guild guild, GuildScheduledEvent guildScheduledEvent) {
            C12238m.checkNotNullParameter(guild, "guild");
            C12238m.checkNotNullParameter(guildScheduledEvent, "event");
            this.guild = guild;
            this.event = guildScheduledEvent;
        }

        public static /* synthetic */ GuildScheduledEventPreview copy$default(GuildScheduledEventPreview guildScheduledEventPreview, Guild guild, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = guildScheduledEventPreview.guild;
            }
            if ((i & 2) != 0) {
                guildScheduledEvent = guildScheduledEventPreview.event;
            }
            return guildScheduledEventPreview.copy(guild, guildScheduledEvent);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final GuildScheduledEvent getEvent() {
            return this.event;
        }

        public final GuildScheduledEventPreview copy(Guild guild, GuildScheduledEvent event) {
            C12238m.checkNotNullParameter(guild, "guild");
            C12238m.checkNotNullParameter(event, "event");
            return new GuildScheduledEventPreview(guild, event);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildScheduledEventPreview)) {
                return false;
            }
            GuildScheduledEventPreview guildScheduledEventPreview = (GuildScheduledEventPreview) other;
            return C12238m.areEqual(this.guild, guildScheduledEventPreview.guild) && C12238m.areEqual(this.event, guildScheduledEventPreview.event);
        }

        public final GuildScheduledEvent getEvent() {
            return this.event;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            GuildScheduledEvent guildScheduledEvent = this.event;
            return iHashCode + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("GuildScheduledEventPreview(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", event=");
            sbM833U.append(this.event);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final /* data */ class MessagePreview {
        private final User author;
        private final String authorName;
        private final int authorNameColor;
        private final boolean hasEmbeds;
        private final DraweeSpanStringBuilder text;

        public MessagePreview(DraweeSpanStringBuilder draweeSpanStringBuilder, String str, int i, User user, boolean z2) {
            C12238m.checkNotNullParameter(draweeSpanStringBuilder, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            C12238m.checkNotNullParameter(str, "authorName");
            C12238m.checkNotNullParameter(user, "author");
            this.text = draweeSpanStringBuilder;
            this.authorName = str;
            this.authorNameColor = i;
            this.author = user;
            this.hasEmbeds = z2;
        }

        public static /* synthetic */ MessagePreview copy$default(MessagePreview messagePreview, DraweeSpanStringBuilder draweeSpanStringBuilder, String str, int i, User user, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                draweeSpanStringBuilder = messagePreview.text;
            }
            if ((i2 & 2) != 0) {
                str = messagePreview.authorName;
            }
            String str2 = str;
            if ((i2 & 4) != 0) {
                i = messagePreview.authorNameColor;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                user = messagePreview.author;
            }
            User user2 = user;
            if ((i2 & 16) != 0) {
                z2 = messagePreview.hasEmbeds;
            }
            return messagePreview.copy(draweeSpanStringBuilder, str2, i3, user2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DraweeSpanStringBuilder getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getAuthorName() {
            return this.authorName;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getAuthorNameColor() {
            return this.authorNameColor;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final User getAuthor() {
            return this.author;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getHasEmbeds() {
            return this.hasEmbeds;
        }

        public final MessagePreview copy(DraweeSpanStringBuilder text, String authorName, int authorNameColor, User author, boolean hasEmbeds) {
            C12238m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            C12238m.checkNotNullParameter(authorName, "authorName");
            C12238m.checkNotNullParameter(author, "author");
            return new MessagePreview(text, authorName, authorNameColor, author, hasEmbeds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessagePreview)) {
                return false;
            }
            MessagePreview messagePreview = (MessagePreview) other;
            return C12238m.areEqual(this.text, messagePreview.text) && C12238m.areEqual(this.authorName, messagePreview.authorName) && this.authorNameColor == messagePreview.authorNameColor && C12238m.areEqual(this.author, messagePreview.author) && this.hasEmbeds == messagePreview.hasEmbeds;
        }

        public final User getAuthor() {
            return this.author;
        }

        public final String getAuthorName() {
            return this.authorName;
        }

        public final int getAuthorNameColor() {
            return this.authorNameColor;
        }

        public final boolean getHasEmbeds() {
            return this.hasEmbeds;
        }

        public final DraweeSpanStringBuilder getText() {
            return this.text;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            DraweeSpanStringBuilder draweeSpanStringBuilder = this.text;
            int iHashCode = (draweeSpanStringBuilder != null ? draweeSpanStringBuilder.hashCode() : 0) * 31;
            String str = this.authorName;
            int iHashCode2 = (((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.authorNameColor) * 31;
            User user = this.author;
            int iHashCode3 = (iHashCode2 + (user != null ? user.hashCode() : 0)) * 31;
            boolean z2 = this.hasEmbeds;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode3 + r1;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("MessagePreview(text=");
            sbM833U.append((Object) this.text);
            sbM833U.append(", authorName=");
            sbM833U.append(this.authorName);
            sbM833U.append(", authorNameColor=");
            sbM833U.append(this.authorNameColor);
            sbM833U.append(", author=");
            sbM833U.append(this.author);
            sbM833U.append(", hasEmbeds=");
            return C1643a.m827O(sbM833U, this.hasEmbeds, ")");
        }

        public /* synthetic */ MessagePreview(DraweeSpanStringBuilder draweeSpanStringBuilder, String str, int i, User user, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(draweeSpanStringBuilder, str, i, user, (i2 & 16) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static abstract class NodeNavigationType {
        private final ReportNode node;

        /* JADX INFO: compiled from: MobileReportsViewModel.kt */
        public static final /* data */ class Back extends NodeNavigationType {
            private final ReportNode prevNode;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Back(ReportNode reportNode) {
                super(reportNode, null);
                C12238m.checkNotNullParameter(reportNode, "prevNode");
                this.prevNode = reportNode;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            private final ReportNode getPrevNode() {
                return this.prevNode;
            }

            public static /* synthetic */ Back copy$default(Back back, ReportNode reportNode, int i, Object obj) {
                if ((i & 1) != 0) {
                    reportNode = back.prevNode;
                }
                return back.copy(reportNode);
            }

            public final Back copy(ReportNode prevNode) {
                C12238m.checkNotNullParameter(prevNode, "prevNode");
                return new Back(prevNode);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Back) && C12238m.areEqual(this.prevNode, ((Back) other).prevNode);
                }
                return true;
            }

            public int hashCode() {
                ReportNode reportNode = this.prevNode;
                if (reportNode != null) {
                    return reportNode.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Back(prevNode=");
                sbM833U.append(this.prevNode);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: MobileReportsViewModel.kt */
        public static final /* data */ class Initial extends NodeNavigationType {
            private final ReportNode initialNode;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initial(ReportNode reportNode) {
                super(reportNode, null);
                C12238m.checkNotNullParameter(reportNode, "initialNode");
                this.initialNode = reportNode;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            private final ReportNode getInitialNode() {
                return this.initialNode;
            }

            public static /* synthetic */ Initial copy$default(Initial initial, ReportNode reportNode, int i, Object obj) {
                if ((i & 1) != 0) {
                    reportNode = initial.initialNode;
                }
                return initial.copy(reportNode);
            }

            public final Initial copy(ReportNode initialNode) {
                C12238m.checkNotNullParameter(initialNode, "initialNode");
                return new Initial(initialNode);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Initial) && C12238m.areEqual(this.initialNode, ((Initial) other).initialNode);
                }
                return true;
            }

            public int hashCode() {
                ReportNode reportNode = this.initialNode;
                if (reportNode != null) {
                    return reportNode.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Initial(initialNode=");
                sbM833U.append(this.initialNode);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: MobileReportsViewModel.kt */
        public static final /* data */ class Next extends NodeNavigationType {
            private final ReportNode nextNode;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Next(ReportNode reportNode) {
                super(reportNode, null);
                C12238m.checkNotNullParameter(reportNode, "nextNode");
                this.nextNode = reportNode;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            private final ReportNode getNextNode() {
                return this.nextNode;
            }

            public static /* synthetic */ Next copy$default(Next next, ReportNode reportNode, int i, Object obj) {
                if ((i & 1) != 0) {
                    reportNode = next.nextNode;
                }
                return next.copy(reportNode);
            }

            public final Next copy(ReportNode nextNode) {
                C12238m.checkNotNullParameter(nextNode, "nextNode");
                return new Next(nextNode);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Next) && C12238m.areEqual(this.nextNode, ((Next) other).nextNode);
                }
                return true;
            }

            public int hashCode() {
                ReportNode reportNode = this.nextNode;
                if (reportNode != null) {
                    return reportNode.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Next(nextNode=");
                sbM833U.append(this.nextNode);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private NodeNavigationType(ReportNode reportNode) {
            this.node = reportNode;
        }

        public final ReportNode getNode() {
            return this.node;
        }

        public /* synthetic */ NodeNavigationType(ReportNode reportNode, DefaultConstructorMarker defaultConstructorMarker) {
            this(reportNode);
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final /* data */ class NodeState {
        private final BlockUserElement blockUserElement;
        private final ReportNodeBottomButton bottomButton;
        private final List<NodeResult> breadcrumbsElement;
        private final ChannelPreview channelPreviewElement;
        private final CheckboxElement checkboxElement;
        private final DirectoryServerPreview directoryServerPreviewElement;
        private final GuildScheduledEventPreview eventPreviewElement;
        private final MessagePreview messagePreviewElement;
        private final ReportNode node;
        private final SubmitState submitState;
        private final boolean successElement;

        public NodeState(ReportNode reportNode, CheckboxElement checkboxElement, MessagePreview messagePreview, ChannelPreview channelPreview, DirectoryServerPreview directoryServerPreview, GuildScheduledEventPreview guildScheduledEventPreview, BlockUserElement blockUserElement, List<NodeResult> list, boolean z2, SubmitState submitState, ReportNodeBottomButton reportNodeBottomButton) {
            C12238m.checkNotNullParameter(reportNode, "node");
            this.node = reportNode;
            this.checkboxElement = checkboxElement;
            this.messagePreviewElement = messagePreview;
            this.channelPreviewElement = channelPreview;
            this.directoryServerPreviewElement = directoryServerPreview;
            this.eventPreviewElement = guildScheduledEventPreview;
            this.blockUserElement = blockUserElement;
            this.breadcrumbsElement = list;
            this.successElement = z2;
            this.submitState = submitState;
            this.bottomButton = reportNodeBottomButton;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ReportNode getNode() {
            return this.node;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final SubmitState getSubmitState() {
            return this.submitState;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final ReportNodeBottomButton getBottomButton() {
            return this.bottomButton;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CheckboxElement getCheckboxElement() {
            return this.checkboxElement;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final MessagePreview getMessagePreviewElement() {
            return this.messagePreviewElement;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ChannelPreview getChannelPreviewElement() {
            return this.channelPreviewElement;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final DirectoryServerPreview getDirectoryServerPreviewElement() {
            return this.directoryServerPreviewElement;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final GuildScheduledEventPreview getEventPreviewElement() {
            return this.eventPreviewElement;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final BlockUserElement getBlockUserElement() {
            return this.blockUserElement;
        }

        public final List<NodeResult> component8() {
            return this.breadcrumbsElement;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getSuccessElement() {
            return this.successElement;
        }

        public final NodeState copy(ReportNode node, CheckboxElement checkboxElement, MessagePreview messagePreviewElement, ChannelPreview channelPreviewElement, DirectoryServerPreview directoryServerPreviewElement, GuildScheduledEventPreview eventPreviewElement, BlockUserElement blockUserElement, List<NodeResult> breadcrumbsElement, boolean successElement, SubmitState submitState, ReportNodeBottomButton bottomButton) {
            C12238m.checkNotNullParameter(node, "node");
            return new NodeState(node, checkboxElement, messagePreviewElement, channelPreviewElement, directoryServerPreviewElement, eventPreviewElement, blockUserElement, breadcrumbsElement, successElement, submitState, bottomButton);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NodeState)) {
                return false;
            }
            NodeState nodeState = (NodeState) other;
            return C12238m.areEqual(this.node, nodeState.node) && C12238m.areEqual(this.checkboxElement, nodeState.checkboxElement) && C12238m.areEqual(this.messagePreviewElement, nodeState.messagePreviewElement) && C12238m.areEqual(this.channelPreviewElement, nodeState.channelPreviewElement) && C12238m.areEqual(this.directoryServerPreviewElement, nodeState.directoryServerPreviewElement) && C12238m.areEqual(this.eventPreviewElement, nodeState.eventPreviewElement) && C12238m.areEqual(this.blockUserElement, nodeState.blockUserElement) && C12238m.areEqual(this.breadcrumbsElement, nodeState.breadcrumbsElement) && this.successElement == nodeState.successElement && C12238m.areEqual(this.submitState, nodeState.submitState) && C12238m.areEqual(this.bottomButton, nodeState.bottomButton);
        }

        public final BlockUserElement getBlockUserElement() {
            return this.blockUserElement;
        }

        public final ReportNodeBottomButton getBottomButton() {
            return this.bottomButton;
        }

        public final List<NodeResult> getBreadcrumbsElement() {
            return this.breadcrumbsElement;
        }

        public final ChannelPreview getChannelPreviewElement() {
            return this.channelPreviewElement;
        }

        public final CheckboxElement getCheckboxElement() {
            return this.checkboxElement;
        }

        public final DirectoryServerPreview getDirectoryServerPreviewElement() {
            return this.directoryServerPreviewElement;
        }

        public final GuildScheduledEventPreview getEventPreviewElement() {
            return this.eventPreviewElement;
        }

        public final MessagePreview getMessagePreviewElement() {
            return this.messagePreviewElement;
        }

        public final ReportNode getNode() {
            return this.node;
        }

        public final SubmitState getSubmitState() {
            return this.submitState;
        }

        public final boolean getSuccessElement() {
            return this.successElement;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r2v22, types: [int] */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v36 */
        public int hashCode() {
            ReportNode reportNode = this.node;
            int iHashCode = (reportNode != null ? reportNode.hashCode() : 0) * 31;
            CheckboxElement checkboxElement = this.checkboxElement;
            int iHashCode2 = (iHashCode + (checkboxElement != null ? checkboxElement.hashCode() : 0)) * 31;
            MessagePreview messagePreview = this.messagePreviewElement;
            int iHashCode3 = (iHashCode2 + (messagePreview != null ? messagePreview.hashCode() : 0)) * 31;
            ChannelPreview channelPreview = this.channelPreviewElement;
            int iHashCode4 = (iHashCode3 + (channelPreview != null ? channelPreview.hashCode() : 0)) * 31;
            DirectoryServerPreview directoryServerPreview = this.directoryServerPreviewElement;
            int iHashCode5 = (iHashCode4 + (directoryServerPreview != null ? directoryServerPreview.hashCode() : 0)) * 31;
            GuildScheduledEventPreview guildScheduledEventPreview = this.eventPreviewElement;
            int iHashCode6 = (iHashCode5 + (guildScheduledEventPreview != null ? guildScheduledEventPreview.hashCode() : 0)) * 31;
            BlockUserElement blockUserElement = this.blockUserElement;
            int iHashCode7 = (iHashCode6 + (blockUserElement != null ? blockUserElement.hashCode() : 0)) * 31;
            List<NodeResult> list = this.breadcrumbsElement;
            int iHashCode8 = (iHashCode7 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.successElement;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode8 + r2) * 31;
            SubmitState submitState = this.submitState;
            int iHashCode9 = (i + (submitState != null ? submitState.hashCode() : 0)) * 31;
            ReportNodeBottomButton reportNodeBottomButton = this.bottomButton;
            return iHashCode9 + (reportNodeBottomButton != null ? reportNodeBottomButton.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("NodeState(node=");
            sbM833U.append(this.node);
            sbM833U.append(", checkboxElement=");
            sbM833U.append(this.checkboxElement);
            sbM833U.append(", messagePreviewElement=");
            sbM833U.append(this.messagePreviewElement);
            sbM833U.append(", channelPreviewElement=");
            sbM833U.append(this.channelPreviewElement);
            sbM833U.append(", directoryServerPreviewElement=");
            sbM833U.append(this.directoryServerPreviewElement);
            sbM833U.append(", eventPreviewElement=");
            sbM833U.append(this.eventPreviewElement);
            sbM833U.append(", blockUserElement=");
            sbM833U.append(this.blockUserElement);
            sbM833U.append(", breadcrumbsElement=");
            sbM833U.append(this.breadcrumbsElement);
            sbM833U.append(", successElement=");
            sbM833U.append(this.successElement);
            sbM833U.append(", submitState=");
            sbM833U.append(this.submitState);
            sbM833U.append(", bottomButton=");
            sbM833U.append(this.bottomButton);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final /* data */ class StoreState {
        private final Map<Long, Integer> blockedUsers;
        private final Channel channel;
        private final DirectoryEntryGuild directoryEntry;
        private final GuildScheduledEvent event;
        private final Guild guild;
        private final Message message;
        private final StageInstance stageInstance;

        public StoreState(Message message, Channel channel, Guild guild, DirectoryEntryGuild directoryEntryGuild, StageInstance stageInstance, Map<Long, Integer> map, GuildScheduledEvent guildScheduledEvent) {
            C12238m.checkNotNullParameter(map, "blockedUsers");
            this.message = message;
            this.channel = channel;
            this.guild = guild;
            this.directoryEntry = directoryEntryGuild;
            this.stageInstance = stageInstance;
            this.blockedUsers = map;
            this.event = guildScheduledEvent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, Message message, Channel channel, Guild guild, DirectoryEntryGuild directoryEntryGuild, StageInstance stageInstance, Map map, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                message = storeState.message;
            }
            if ((i & 2) != 0) {
                channel = storeState.channel;
            }
            Channel channel2 = channel;
            if ((i & 4) != 0) {
                guild = storeState.guild;
            }
            Guild guild2 = guild;
            if ((i & 8) != 0) {
                directoryEntryGuild = storeState.directoryEntry;
            }
            DirectoryEntryGuild directoryEntryGuild2 = directoryEntryGuild;
            if ((i & 16) != 0) {
                stageInstance = storeState.stageInstance;
            }
            StageInstance stageInstance2 = stageInstance;
            if ((i & 32) != 0) {
                map = storeState.blockedUsers;
            }
            Map map2 = map;
            if ((i & 64) != 0) {
                guildScheduledEvent = storeState.event;
            }
            return storeState.copy(message, channel2, guild2, directoryEntryGuild2, stageInstance2, map2, guildScheduledEvent);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final DirectoryEntryGuild getDirectoryEntry() {
            return this.directoryEntry;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public final Map<Long, Integer> component6() {
            return this.blockedUsers;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final GuildScheduledEvent getEvent() {
            return this.event;
        }

        public final StoreState copy(Message message, Channel channel, Guild guild, DirectoryEntryGuild directoryEntry, StageInstance stageInstance, Map<Long, Integer> blockedUsers, GuildScheduledEvent event) {
            C12238m.checkNotNullParameter(blockedUsers, "blockedUsers");
            return new StoreState(message, channel, guild, directoryEntry, stageInstance, blockedUsers, event);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.message, storeState.message) && C12238m.areEqual(this.channel, storeState.channel) && C12238m.areEqual(this.guild, storeState.guild) && C12238m.areEqual(this.directoryEntry, storeState.directoryEntry) && C12238m.areEqual(this.stageInstance, storeState.stageInstance) && C12238m.areEqual(this.blockedUsers, storeState.blockedUsers) && C12238m.areEqual(this.event, storeState.event);
        }

        public final Map<Long, Integer> getBlockedUsers() {
            return this.blockedUsers;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final DirectoryEntryGuild getDirectoryEntry() {
            return this.directoryEntry;
        }

        public final GuildScheduledEvent getEvent() {
            return this.event;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public int hashCode() {
            Message message = this.message;
            int iHashCode = (message != null ? message.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
            DirectoryEntryGuild directoryEntryGuild = this.directoryEntry;
            int iHashCode4 = (iHashCode3 + (directoryEntryGuild != null ? directoryEntryGuild.hashCode() : 0)) * 31;
            StageInstance stageInstance = this.stageInstance;
            int iHashCode5 = (iHashCode4 + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
            Map<Long, Integer> map = this.blockedUsers;
            int iHashCode6 = (iHashCode5 + (map != null ? map.hashCode() : 0)) * 31;
            GuildScheduledEvent guildScheduledEvent = this.event;
            return iHashCode6 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(message=");
            sbM833U.append(this.message);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", directoryEntry=");
            sbM833U.append(this.directoryEntry);
            sbM833U.append(", stageInstance=");
            sbM833U.append(this.stageInstance);
            sbM833U.append(", blockedUsers=");
            sbM833U.append(this.blockedUsers);
            sbM833U.append(", event=");
            sbM833U.append(this.event);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static abstract class SubmitState {

        /* JADX INFO: compiled from: MobileReportsViewModel.kt */
        public static final class Error extends SubmitState {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MobileReportsViewModel.kt */
        public static final class Loading extends SubmitState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MobileReportsViewModel.kt */
        public static final class None extends SubmitState {
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }
        }

        private SubmitState() {
        }

        public /* synthetic */ SubmitState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: MobileReportsViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MobileReportsViewModel.kt */
        public static final /* data */ class Menu extends ViewState {
            private final BlockUserElement blockUserElement;
            private final ChannelPreview channelPreview;
            private final DirectoryServerPreview directoryServerPreview;
            private final GuildScheduledEventPreview eventPreview;
            private final List<NodeResult> history;
            private final MenuAPIResponse menu;
            private final MessagePreview messagePreview;
            private final NodeNavigationType nodeNavigationType;
            private final SubmitState submitState;

            public /* synthetic */ Menu(MenuAPIResponse menuAPIResponse, MessagePreview messagePreview, ChannelPreview channelPreview, DirectoryServerPreview directoryServerPreview, GuildScheduledEventPreview guildScheduledEventPreview, NodeNavigationType nodeNavigationType, SubmitState submitState, List list, BlockUserElement blockUserElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(menuAPIResponse, messagePreview, channelPreview, directoryServerPreview, guildScheduledEventPreview, nodeNavigationType, (i & 64) != 0 ? SubmitState.None.INSTANCE : submitState, list, blockUserElement);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Menu copy$default(Menu menu, MenuAPIResponse menuAPIResponse, MessagePreview messagePreview, ChannelPreview channelPreview, DirectoryServerPreview directoryServerPreview, GuildScheduledEventPreview guildScheduledEventPreview, NodeNavigationType nodeNavigationType, SubmitState submitState, List list, BlockUserElement blockUserElement, int i, Object obj) {
                return menu.copy((i & 1) != 0 ? menu.menu : menuAPIResponse, (i & 2) != 0 ? menu.messagePreview : messagePreview, (i & 4) != 0 ? menu.channelPreview : channelPreview, (i & 8) != 0 ? menu.directoryServerPreview : directoryServerPreview, (i & 16) != 0 ? menu.eventPreview : guildScheduledEventPreview, (i & 32) != 0 ? menu.nodeNavigationType : nodeNavigationType, (i & 64) != 0 ? menu.submitState : submitState, (i & 128) != 0 ? menu.history : list, (i & 256) != 0 ? menu.blockUserElement : blockUserElement);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final MenuAPIResponse getMenu() {
                return this.menu;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final MessagePreview getMessagePreview() {
                return this.messagePreview;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final ChannelPreview getChannelPreview() {
                return this.channelPreview;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final DirectoryServerPreview getDirectoryServerPreview() {
                return this.directoryServerPreview;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final GuildScheduledEventPreview getEventPreview() {
                return this.eventPreview;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final NodeNavigationType getNodeNavigationType() {
                return this.nodeNavigationType;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final SubmitState getSubmitState() {
                return this.submitState;
            }

            public final List<NodeResult> component8() {
                return this.history;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final BlockUserElement getBlockUserElement() {
                return this.blockUserElement;
            }

            public final Menu copy(MenuAPIResponse menu, MessagePreview messagePreview, ChannelPreview channelPreview, DirectoryServerPreview directoryServerPreview, GuildScheduledEventPreview eventPreview, NodeNavigationType nodeNavigationType, SubmitState submitState, List<NodeResult> history, BlockUserElement blockUserElement) {
                C12238m.checkNotNullParameter(menu, "menu");
                C12238m.checkNotNullParameter(nodeNavigationType, "nodeNavigationType");
                C12238m.checkNotNullParameter(submitState, "submitState");
                C12238m.checkNotNullParameter(history, "history");
                return new Menu(menu, messagePreview, channelPreview, directoryServerPreview, eventPreview, nodeNavigationType, submitState, history, blockUserElement);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Menu)) {
                    return false;
                }
                Menu menu = (Menu) other;
                return C12238m.areEqual(this.menu, menu.menu) && C12238m.areEqual(this.messagePreview, menu.messagePreview) && C12238m.areEqual(this.channelPreview, menu.channelPreview) && C12238m.areEqual(this.directoryServerPreview, menu.directoryServerPreview) && C12238m.areEqual(this.eventPreview, menu.eventPreview) && C12238m.areEqual(this.nodeNavigationType, menu.nodeNavigationType) && C12238m.areEqual(this.submitState, menu.submitState) && C12238m.areEqual(this.history, menu.history) && C12238m.areEqual(this.blockUserElement, menu.blockUserElement);
            }

            public final NodeState genNodeState() {
                Object obj;
                Object next;
                CheckboxElement checkboxElement;
                Object next2;
                Object next3;
                Object next4;
                Object next5;
                Object next6;
                Object next7;
                ReportNodeElement reportNodeElement;
                ReportNodeElement reportNodeElement2;
                ReportNodeElement reportNodeElement3;
                ReportNodeElement reportNodeElement4;
                ReportNodeElement reportNodeElement5;
                ReportNodeElement reportNodeElement6;
                ReportNodeElement reportNodeElement7;
                ReportNode node = this.nodeNavigationType.getNode();
                List<ReportNodeElement> listM8173c = node.m8173c();
                ReportNodeElement.Companion companion = ReportNodeElement.INSTANCE;
                Iterator<T> it = listM8173c.iterator();
                do {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    reportNodeElement7 = (ReportNodeElement) next;
                    Objects.requireNonNull(companion);
                    C12238m.checkNotNullParameter(reportNodeElement7, "element");
                } while (!C12238m.areEqual(reportNodeElement7.getType(), "checkbox"));
                ReportNodeElement reportNodeElement8 = (ReportNodeElement) next;
                if (reportNodeElement8 != null) {
                    List<ReportNodeElementData> listM8182a = reportNodeElement8.m8182a();
                    checkboxElement = listM8182a == null ? null : new CheckboxElement(reportNodeElement8.getName(), listM8182a, new HashSet());
                } else {
                    checkboxElement = null;
                }
                List<ReportNodeElement> listM8173c2 = node.m8173c();
                ReportNodeElement.Companion companion2 = ReportNodeElement.INSTANCE;
                Iterator<T> it2 = listM8173c2.iterator();
                do {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    reportNodeElement6 = (ReportNodeElement) next2;
                    Objects.requireNonNull(companion2);
                    C12238m.checkNotNullParameter(reportNodeElement6, "element");
                } while (!C12238m.areEqual(reportNodeElement6.getType(), "message_preview"));
                MessagePreview messagePreview = ((ReportNodeElement) next2) != null ? this.messagePreview : null;
                List<ReportNodeElement> listM8173c3 = node.m8173c();
                ReportNodeElement.Companion companion3 = ReportNodeElement.INSTANCE;
                Iterator<T> it3 = listM8173c3.iterator();
                do {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    reportNodeElement5 = (ReportNodeElement) next3;
                    Objects.requireNonNull(companion3);
                    C12238m.checkNotNullParameter(reportNodeElement5, "element");
                } while (!C12238m.areEqual(reportNodeElement5.getType(), "channel_preview"));
                ChannelPreview channelPreview = ((ReportNodeElement) next3) != null ? this.channelPreview : null;
                List<ReportNodeElement> listM8173c4 = node.m8173c();
                ReportNodeElement.Companion companion4 = ReportNodeElement.INSTANCE;
                Iterator<T> it4 = listM8173c4.iterator();
                do {
                    if (!it4.hasNext()) {
                        next4 = null;
                        break;
                    }
                    next4 = it4.next();
                    reportNodeElement4 = (ReportNodeElement) next4;
                    Objects.requireNonNull(companion4);
                    C12238m.checkNotNullParameter(reportNodeElement4, "element");
                } while (!C12238m.areEqual(reportNodeElement4.getType(), "guild_directory_entry_preview"));
                DirectoryServerPreview directoryServerPreview = ((ReportNodeElement) next4) != null ? this.directoryServerPreview : null;
                List<ReportNodeElement> listM8173c5 = node.m8173c();
                ReportNodeElement.Companion companion5 = ReportNodeElement.INSTANCE;
                Iterator<T> it5 = listM8173c5.iterator();
                do {
                    if (!it5.hasNext()) {
                        next5 = null;
                        break;
                    }
                    next5 = it5.next();
                    reportNodeElement3 = (ReportNodeElement) next5;
                    Objects.requireNonNull(companion5);
                    C12238m.checkNotNullParameter(reportNodeElement3, "element");
                } while (!C12238m.areEqual(reportNodeElement3.getType(), "guild_scheduled_event_preview"));
                GuildScheduledEventPreview guildScheduledEventPreview = ((ReportNodeElement) next5) != null ? this.eventPreview : null;
                List<ReportNodeElement> listM8173c6 = node.m8173c();
                ReportNodeElement.Companion companion6 = ReportNodeElement.INSTANCE;
                Iterator<T> it6 = listM8173c6.iterator();
                do {
                    if (!it6.hasNext()) {
                        next6 = null;
                        break;
                    }
                    next6 = it6.next();
                    reportNodeElement2 = (ReportNodeElement) next6;
                    Objects.requireNonNull(companion6);
                    C12238m.checkNotNullParameter(reportNodeElement2, "element");
                } while (!C12238m.areEqual(reportNodeElement2.getType(), "block_users"));
                BlockUserElement blockUserElement = ((ReportNodeElement) next6) != null ? this.blockUserElement : null;
                List<ReportNodeElement> listM8173c7 = node.m8173c();
                ReportNodeElement.Companion companion7 = ReportNodeElement.INSTANCE;
                Iterator<T> it7 = listM8173c7.iterator();
                do {
                    if (!it7.hasNext()) {
                        next7 = null;
                        break;
                    }
                    next7 = it7.next();
                    reportNodeElement = (ReportNodeElement) next7;
                    Objects.requireNonNull(companion7);
                    C12238m.checkNotNullParameter(reportNodeElement, "element");
                } while (!C12238m.areEqual(reportNodeElement.getType(), "breadcrumbs"));
                List<NodeResult> list = ((ReportNodeElement) next7) != null ? this.history : null;
                List<ReportNodeElement> listM8173c8 = node.m8173c();
                ReportNodeElement.Companion companion8 = ReportNodeElement.INSTANCE;
                for (Object obj2 : listM8173c8) {
                    ReportNodeElement reportNodeElement9 = (ReportNodeElement) obj2;
                    Objects.requireNonNull(companion8);
                    C12238m.checkNotNullParameter(reportNodeElement9, "element");
                    if (C12238m.areEqual(reportNodeElement9.getType(), "success")) {
                        obj = obj2;
                        break;
                    }
                }
                return new NodeState(node, checkboxElement, messagePreview, channelPreview, directoryServerPreview, guildScheduledEventPreview, blockUserElement, list, obj != null, this.submitState, node.getButton());
            }

            public final BlockUserElement getBlockUserElement() {
                return this.blockUserElement;
            }

            public final ChannelPreview getChannelPreview() {
                return this.channelPreview;
            }

            public final DirectoryServerPreview getDirectoryServerPreview() {
                return this.directoryServerPreview;
            }

            public final GuildScheduledEventPreview getEventPreview() {
                return this.eventPreview;
            }

            public final List<NodeResult> getHistory() {
                return this.history;
            }

            public final MenuAPIResponse getMenu() {
                return this.menu;
            }

            public final MessagePreview getMessagePreview() {
                return this.messagePreview;
            }

            public final NodeNavigationType getNodeNavigationType() {
                return this.nodeNavigationType;
            }

            public final SubmitState getSubmitState() {
                return this.submitState;
            }

            public int hashCode() {
                MenuAPIResponse menuAPIResponse = this.menu;
                int iHashCode = (menuAPIResponse != null ? menuAPIResponse.hashCode() : 0) * 31;
                MessagePreview messagePreview = this.messagePreview;
                int iHashCode2 = (iHashCode + (messagePreview != null ? messagePreview.hashCode() : 0)) * 31;
                ChannelPreview channelPreview = this.channelPreview;
                int iHashCode3 = (iHashCode2 + (channelPreview != null ? channelPreview.hashCode() : 0)) * 31;
                DirectoryServerPreview directoryServerPreview = this.directoryServerPreview;
                int iHashCode4 = (iHashCode3 + (directoryServerPreview != null ? directoryServerPreview.hashCode() : 0)) * 31;
                GuildScheduledEventPreview guildScheduledEventPreview = this.eventPreview;
                int iHashCode5 = (iHashCode4 + (guildScheduledEventPreview != null ? guildScheduledEventPreview.hashCode() : 0)) * 31;
                NodeNavigationType nodeNavigationType = this.nodeNavigationType;
                int iHashCode6 = (iHashCode5 + (nodeNavigationType != null ? nodeNavigationType.hashCode() : 0)) * 31;
                SubmitState submitState = this.submitState;
                int iHashCode7 = (iHashCode6 + (submitState != null ? submitState.hashCode() : 0)) * 31;
                List<NodeResult> list = this.history;
                int iHashCode8 = (iHashCode7 + (list != null ? list.hashCode() : 0)) * 31;
                BlockUserElement blockUserElement = this.blockUserElement;
                return iHashCode8 + (blockUserElement != null ? blockUserElement.hashCode() : 0);
            }

            public final boolean shouldHideBackArrow() {
                return (this.submitState instanceof SubmitState.Loading) || this.nodeNavigationType.getNode().getId() == this.menu.getSuccess_node_id() || this.nodeNavigationType.getNode().getId() == this.menu.getRoot_node_id();
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Menu(menu=");
                sbM833U.append(this.menu);
                sbM833U.append(", messagePreview=");
                sbM833U.append(this.messagePreview);
                sbM833U.append(", channelPreview=");
                sbM833U.append(this.channelPreview);
                sbM833U.append(", directoryServerPreview=");
                sbM833U.append(this.directoryServerPreview);
                sbM833U.append(", eventPreview=");
                sbM833U.append(this.eventPreview);
                sbM833U.append(", nodeNavigationType=");
                sbM833U.append(this.nodeNavigationType);
                sbM833U.append(", submitState=");
                sbM833U.append(this.submitState);
                sbM833U.append(", history=");
                sbM833U.append(this.history);
                sbM833U.append(", blockUserElement=");
                sbM833U.append(this.blockUserElement);
                sbM833U.append(")");
                return sbM833U.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Menu(MenuAPIResponse menuAPIResponse, MessagePreview messagePreview, ChannelPreview channelPreview, DirectoryServerPreview directoryServerPreview, GuildScheduledEventPreview guildScheduledEventPreview, NodeNavigationType nodeNavigationType, SubmitState submitState, List<NodeResult> list, BlockUserElement blockUserElement) {
                super(null);
                C12238m.checkNotNullParameter(menuAPIResponse, "menu");
                C12238m.checkNotNullParameter(nodeNavigationType, "nodeNavigationType");
                C12238m.checkNotNullParameter(submitState, "submitState");
                C12238m.checkNotNullParameter(list, "history");
                this.menu = menuAPIResponse;
                this.messagePreview = messagePreview;
                this.channelPreview = channelPreview;
                this.directoryServerPreview = directoryServerPreview;
                this.eventPreview = guildScheduledEventPreview;
                this.nodeNavigationType = nodeNavigationType;
                this.submitState = submitState;
                this.history = list;
                this.blockUserElement = blockUserElement;
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$handleBlockUser$1 */
    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final class C90771 extends AbstractC12240o implements Function1<Void, Unit> {
        public static final C90771 INSTANCE = new C90771();

        public C90771() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$handleSubmit$1 */
    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final class C90781 extends AbstractC12240o implements Function1<Unit, Unit> {
        public final /* synthetic */ ViewState.Menu $currentViewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C90781(ViewState.Menu menu) {
            super(1);
            this.$currentViewState = menu;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            C12238m.checkNotNullParameter(unit, "it");
            MobileReportsViewModel.this.handleNext(new ReportNodeChild("", this.$currentViewState.getMenu().getSuccess_node_id()), null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$handleSubmit$2 */
    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final class C90792 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ ViewState.Menu $currentViewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C90792(ViewState.Menu menu) {
            super(1);
            this.$currentViewState = menu;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            MobileReportsViewModel.this.updateViewState(ViewState.Menu.copy$default(this.$currentViewState, null, null, null, null, null, null, SubmitState.Error.INSTANCE, null, null, 447, null));
        }
    }

    public /* synthetic */ MobileReportsViewModel(WeakReference weakReference, MobileReportArgs mobileReportArgs, RestAPI restAPI, Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference, mobileReportArgs, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? ClockFactory.get() : clock, (i & 16) != 0 ? INSTANCE.getStoreState(mobileReportArgs) : observable);
    }

    public static final /* synthetic */ ViewState access$getViewState$p(MobileReportsViewModel mobileReportsViewModel) {
        return mobileReportsViewModel.getViewState();
    }

    private final ChannelPreview parseChannelPreview(StoreState storeState) {
        StageInstance stageInstance;
        Guild guild = storeState.getGuild();
        if (guild == null || (stageInstance = storeState.getStageInstance()) == null) {
            return null;
        }
        return new ChannelPreview(guild, stageInstance);
    }

    private final DirectoryServerPreview parseDirectoryServerPreview(StoreState storeState) {
        DirectoryEntryGuild directoryEntry;
        Guild guild = storeState.getGuild();
        if (guild == null || (directoryEntry = storeState.getDirectoryEntry()) == null) {
            return null;
        }
        return new DirectoryServerPreview(guild, directoryEntry);
    }

    private final GuildScheduledEventPreview parseEventPreview(StoreState storeState) {
        Guild guild;
        GuildScheduledEvent event = storeState.getEvent();
        if (event == null || (guild = storeState.getGuild()) == null) {
            return null;
        }
        return new GuildScheduledEventPreview(guild, event);
    }

    private final MessagePreview parseMessagePreview(StoreState storeState) {
        Message message;
        Context context = this.context.get();
        if (context != null) {
            C12238m.checkNotNullExpressionValue(context, "context.get() ?: return null");
            Channel channel = storeState.getChannel();
            if (channel != null && (message = storeState.getMessage()) != null) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Map<Long, User> users = companion.getUsers().getUsers();
                com.discord.api.user.User author = message.getAuthor();
                User user = users.get(author != null ? Long.valueOf(author.getId()) : null);
                if (user == null || (getViewState() instanceof ViewState.Invalid)) {
                    return null;
                }
                long id2 = companion.getUsers().getMeSnapshot().getId();
                Map map = (Map) C1643a.m843c(channel, companion.getGuilds().getMembers());
                if (map == null) {
                    map = new HashMap();
                }
                Map map2 = map;
                Map map3 = (Map) C1643a.m843c(channel, companion.getGuilds().getRoles());
                Map<Long, String> channelNames = companion.getChannels().getChannelNames();
                Map<Long, String> nickOrUsernames = MessageUtils.getNickOrUsernames(message, channel, map2, channel.m7650q());
                String content = message.getContent();
                DraweeSpanStringBuilder channelMessage = DiscordParser.parseChannelMessage(context, content != null ? new Regex("\n").replace(content, " ") : null, new MessageRenderContext(context, id2, false, nickOrUsernames, channelNames, map3, 0, null, null, 0, 0, null, null, null, 16320, null), new MessagePreprocessor(id2, null, null, false, 50, 6, null), DiscordParser.ParserOptions.REPLY, false);
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
                GuildMember.Companion companion2 = GuildMember.INSTANCE;
                com.discord.api.user.User author4 = message.getAuthor();
                return new MessagePreview(channelMessage, str, companion2.getColor((GuildMember) map2.get(author4 != null ? Long.valueOf(author4.getId()) : null), ColorCompat.getThemedColor(context, C5419R.attr.colorHeaderPrimary)), user, message.hasEmbeds() || message.hasAttachments());
            }
        }
        return null;
    }

    public final boolean handleBack() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Menu)) {
            viewState = null;
        }
        ViewState.Menu menu = (ViewState.Menu) viewState;
        if (menu == null) {
            return false;
        }
        NodeResult nodeResult = (NodeResult) C12163u.lastOrNull((List) menu.getHistory());
        ReportNode node = nodeResult != null ? nodeResult.getNode() : null;
        ReportNode node2 = menu.getNodeNavigationType().getNode();
        MenuAPIResponse menu2 = menu.getMenu();
        if (menu2.getSuccess_node_id() != node2.getId() && !(menu.getSubmitState() instanceof SubmitState.Loading)) {
            if (node == null || menu2.getRoot_node_id() == node2.getId()) {
                return false;
            }
            updateViewState(ViewState.Menu.copy$default(menu, null, null, null, null, null, new NodeNavigationType.Back(node), null, C12163u.dropLast(menu.getHistory(), 1), null, 351, null));
        }
        return true;
    }

    public final void handleBlockUser() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Menu)) {
            viewState = null;
        }
        ViewState.Menu menu = (ViewState.Menu) viewState;
        if (menu != null) {
            ReportNode node = menu.getNodeNavigationType().getNode();
            BlockUserElement blockUserElement = menu.getBlockUserElement();
            if (blockUserElement != null) {
                updateViewState(ViewState.Menu.copy$default(menu, null, null, null, null, null, null, null, null, BlockUserElement.copy$default(blockUserElement, true, null, 2, null), 255, null));
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.addRelationship(INSTANCE.getLocation(node), blockUserElement.getUser().getId(), (28 & 4) != 0 ? null : 2, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null), false, 1, null), this, null, 2, null), (Class<?>) MobileReportsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C90771.INSTANCE);
            }
        }
    }

    public final void handleNext(ReportNodeChild destination, NodeElementResult elementResult) {
        ReportNode reportNode;
        C12238m.checkNotNullParameter(destination, "destination");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Menu)) {
            viewState = null;
        }
        ViewState.Menu menu = (ViewState.Menu) viewState;
        if (menu == null || (reportNode = menu.getMenu().m8161c().get(Integer.valueOf(destination.getRef()))) == null) {
            return;
        }
        updateViewState(ViewState.Menu.copy$default(menu, null, null, null, null, null, new NodeNavigationType.Next(reportNode), SubmitState.None.INSTANCE, C12163u.plus((Collection<? extends NodeResult>) menu.getHistory(), new NodeResult(menu.getNodeNavigationType().getNode(), destination, elementResult)), null, 287, null));
    }

    public final void handleSubmit() {
        ReportSubmissionBody reportSubmissionBody;
        Guild guild;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Menu)) {
            viewState = null;
        }
        ViewState.Menu menu = (ViewState.Menu) viewState;
        if (menu == null || (menu.getSubmitState() instanceof SubmitState.Loading)) {
            return;
        }
        updateViewState(ViewState.Menu.copy$default(menu, null, null, null, null, null, null, SubmitState.Loading.INSTANCE, null, null, 447, null));
        MobileReportArgs mobileReportArgs = this.args;
        if (mobileReportArgs instanceof MobileReportArgs.Message) {
            ReportSubmissionBody.Companion companion = ReportSubmissionBody.INSTANCE;
            long jCurrentTimeMillis = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long channelId = this.args.getChannelId();
            long messageId = ((MobileReportArgs.Message) this.args).getMessageId();
            MenuAPIResponse menu2 = menu.getMenu();
            List<NodeResult> history = menu.getHistory();
            Objects.requireNonNull(companion);
            C12238m.checkNotNullParameter(menu2, "menu");
            C12238m.checkNotNullParameter(history, "results");
            Pair<List<Integer>, Map<String, List<String>>> pairM8190a = companion.m8190a(history);
            List<Integer> listComponent1 = pairM8190a.component1();
            Map<String, List<String>> mapComponent2 = pairM8190a.component2();
            Long lValueOf = Long.valueOf(messageId);
            Long lValueOf2 = Long.valueOf(channelId);
            String name = menu2.getName();
            String language = menu2.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis, lValueOf, lValueOf2, null, null, null, language != null ? language : "en", menu2.getVariant(), name, menu2.getVersion(), listComponent1, mapComponent2, 56);
        } else if (mobileReportArgs instanceof MobileReportArgs.StageChannel) {
            ChannelPreview channelPreview = menu.getChannelPreview();
            if (channelPreview == null || (guild = channelPreview.getGuild()) == null) {
                Logger.e$default(AppLog.f14950g, "Tried to send report for stage channel, but without guild id?", null, null, 6, null);
                return;
            }
            long id2 = guild.getId();
            ReportSubmissionBody.Companion companion2 = ReportSubmissionBody.INSTANCE;
            long jCurrentTimeMillis2 = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long channelId2 = this.args.getChannelId();
            MenuAPIResponse menu3 = menu.getMenu();
            List<NodeResult> history2 = menu.getHistory();
            Objects.requireNonNull(companion2);
            C12238m.checkNotNullParameter(menu3, "menu");
            C12238m.checkNotNullParameter(history2, "results");
            Pair<List<Integer>, Map<String, List<String>>> pairM8190a2 = companion2.m8190a(history2);
            List<Integer> listComponent2 = pairM8190a2.component1();
            Map<String, List<String>> mapComponent3 = pairM8190a2.component2();
            Long lValueOf3 = Long.valueOf(id2);
            Long lValueOf4 = Long.valueOf(channelId2);
            String name2 = menu3.getName();
            String language2 = menu3.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis2, null, lValueOf4, lValueOf3, null, null, language2 != null ? language2 : "en", menu3.getVariant(), name2, menu3.getVersion(), listComponent2, mapComponent3, 50);
        } else if (mobileReportArgs instanceof MobileReportArgs.DirectoryServer) {
            ReportSubmissionBody.Companion companion3 = ReportSubmissionBody.INSTANCE;
            long jCurrentTimeMillis3 = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long channelId3 = this.args.getChannelId();
            long guildId = ((MobileReportArgs.DirectoryServer) this.args).getGuildId();
            long hubId = ((MobileReportArgs.DirectoryServer) this.args).getHubId();
            MenuAPIResponse menu4 = menu.getMenu();
            List<NodeResult> history3 = menu.getHistory();
            Objects.requireNonNull(companion3);
            C12238m.checkNotNullParameter(menu4, "menu");
            C12238m.checkNotNullParameter(history3, "results");
            Pair<List<Integer>, Map<String, List<String>>> pairM8190a3 = companion3.m8190a(history3);
            List<Integer> listComponent3 = pairM8190a3.component1();
            Map<String, List<String>> mapComponent4 = pairM8190a3.component2();
            Long lValueOf5 = Long.valueOf(guildId);
            Long lValueOf6 = Long.valueOf(channelId3);
            Long lValueOf7 = Long.valueOf(hubId);
            String name3 = menu4.getName();
            String language3 = menu4.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis3, null, lValueOf6, lValueOf5, lValueOf7, null, language3 != null ? language3 : "en", menu4.getVariant(), name3, menu4.getVersion(), listComponent3, mapComponent4, 34);
        } else {
            if (!(mobileReportArgs instanceof MobileReportArgs.GuildScheduledEvent)) {
                throw new NoWhenBranchMatchedException();
            }
            ReportSubmissionBody.Companion companion4 = ReportSubmissionBody.INSTANCE;
            long jCurrentTimeMillis4 = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long guildId2 = ((MobileReportArgs.GuildScheduledEvent) this.args).getGuildId();
            long eventId = ((MobileReportArgs.GuildScheduledEvent) this.args).getEventId();
            MenuAPIResponse menu5 = menu.getMenu();
            List<NodeResult> history4 = menu.getHistory();
            Objects.requireNonNull(companion4);
            C12238m.checkNotNullParameter(menu5, "menu");
            C12238m.checkNotNullParameter(history4, "results");
            Pair<List<Integer>, Map<String, List<String>>> pairM8190a4 = companion4.m8190a(history4);
            List<Integer> listComponent4 = pairM8190a4.component1();
            Map<String, List<String>> mapComponent5 = pairM8190a4.component2();
            Long lValueOf8 = Long.valueOf(guildId2);
            Long lValueOf9 = Long.valueOf(eventId);
            String name4 = menu5.getName();
            String language4 = menu5.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis4, null, null, lValueOf8, null, lValueOf9, language4 != null ? language4 : "en", menu5.getVariant(), name4, menu5.getVersion(), listComponent4, mapComponent5, 22);
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.submitReport(this.args.getReportType().getPathValue(), reportSubmissionBody), false, 1, null), this, null, 2, null), (Class<?>) MobileReportsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C90792(menu)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C90781(menu));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileReportsViewModel(WeakReference<Context> weakReference, MobileReportArgs mobileReportArgs, RestAPI restAPI, Clock clock, Observable<StoreState> observable) {
        super(null);
        C12238m.checkNotNullParameter(weakReference, "context");
        C12238m.checkNotNullParameter(mobileReportArgs, "args");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.context = weakReference;
        this.args = mobileReportArgs;
        this.restAPI = restAPI;
        this.clock = clock;
        Observable observableM11076j = Observable.m11076j(ObservableExtensionsKt.computationLatest(observable), ObservableExtensionsKt.restSubscribeOn$default(restAPI.getReportMenu(mobileReportArgs.getReportType().getPathValue()), false, 1, null), new Func2<StoreState, MenuAPIResponse, Pair<? extends StoreState, ? extends MenuAPIResponse>>() { // from class: com.discord.widgets.mobile_reports.MobileReportsViewModel.1
            @Override // p658rx.functions.Func2
            public final Pair<StoreState, MenuAPIResponse> call(StoreState storeState, MenuAPIResponse menuAPIResponse) {
                return C12116o.m10073to(storeState, menuAPIResponse);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable\n        .comb…> storeState to menuAPI }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11076j, this, null, 2, null), (Class<?>) MobileReportsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C90763()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C90752());
    }
}
