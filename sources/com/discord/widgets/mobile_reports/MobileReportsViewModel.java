package com.discord.widgets.mobile_reports;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.mobile_reports.MobileReportsViewModel;
import com.discord.widgets.mobile_reports.WidgetMobileReports2;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.Tuples;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.functions.Func8;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MobileReportsViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final WidgetMobileReports2 args;
    private final Clock clock;
    private final WeakReference<Context> context;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Tuples2<? extends StoreState, ? extends MenuAPIResponse>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends StoreState, ? extends MenuAPIResponse> tuples2) {
            invoke2((Tuples2<StoreState, MenuAPIResponse>) tuples2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<StoreState, MenuAPIResponse> tuples2) {
            ReportNode reportNode;
            StoreState storeStateComponent1 = tuples2.component1();
            MenuAPIResponse menuAPIResponseComponent2 = tuples2.component2();
            if (menuAPIResponseComponent2 != null) {
                reportNode = menuAPIResponseComponent2.c().get(Integer.valueOf(menuAPIResponseComponent2.getRoot_node_id()));
            } else {
                reportNode = null;
            }
            if (menuAPIResponseComponent2 == null || reportNode == null) {
                MobileReportsViewModel.this.updateViewState(ViewState.Invalid.INSTANCE);
                return;
            }
            MobileReportsViewModel mobileReportsViewModel = MobileReportsViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeStateComponent1, "storeState");
            MessagePreview messagePreview = mobileReportsViewModel.parseMessagePreview(storeStateComponent1);
            MobileReportsViewModel mobileReportsViewModel2 = MobileReportsViewModel.this;
            ViewState viewStateAccess$getViewState$p = MobileReportsViewModel.access$getViewState$p(mobileReportsViewModel2);
            if (viewStateAccess$getViewState$p == null) {
                viewStateAccess$getViewState$p = new ViewState.Menu(menuAPIResponseComponent2, messagePreview, MobileReportsViewModel.this.parseChannelPreview(storeStateComponent1), MobileReportsViewModel.this.parseDirectoryServerPreview(storeStateComponent1), MobileReportsViewModel.this.parseEventPreview(storeStateComponent1), new NodeNavigationType.Initial(reportNode), null, Collections2.emptyList(), messagePreview != null ? new BlockUserElement(storeStateComponent1.getBlockedUsers().containsKey(Long.valueOf(messagePreview.getAuthor().getId())), messagePreview.getAuthor()) : null, 64, null);
            }
            mobileReportsViewModel2.updateViewState(viewStateAccess$getViewState$p);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            Logger.e$default(AppLog.g, "Can't parse report message? Closing report screen.", null, null, 6, null);
            MobileReportsViewModel.this.updateViewState(ViewState.Invalid.INSTANCE);
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final /* data */ class BlockUserElement {
        private final boolean isBlocked;
        private final User user;

        public BlockUserElement(boolean z2, User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
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
            Intrinsics3.checkNotNullParameter(user, "user");
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
            return this.isBlocked == blockUserElement.isBlocked && Intrinsics3.areEqual(this.user, blockUserElement.user);
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
            StringBuilder sbU = outline.U("BlockUserElement(isBlocked=");
            sbU.append(this.isBlocked);
            sbU.append(", user=");
            sbU.append(this.user);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final /* data */ class ChannelPreview {
        private final Guild guild;
        private final StageInstance stageInstance;

        public ChannelPreview(Guild guild, StageInstance stageInstance) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(stageInstance, "stageInstance");
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
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(stageInstance, "stageInstance");
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
            return Intrinsics3.areEqual(this.guild, channelPreview.guild) && Intrinsics3.areEqual(this.stageInstance, channelPreview.stageInstance);
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
            StringBuilder sbU = outline.U("ChannelPreview(guild=");
            sbU.append(this.guild);
            sbU.append(", stageInstance=");
            sbU.append(this.stageInstance);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final /* data */ class CheckboxElement {
        private final List<ReportNodeElementData> data;
        private final String name;
        private final HashSet<ReportNodeElementData> selections;

        public CheckboxElement(String str, List<ReportNodeElementData> list, HashSet<ReportNodeElementData> hashSet) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(list, "data");
            Intrinsics3.checkNotNullParameter(hashSet, "selections");
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
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(data, "data");
            Intrinsics3.checkNotNullParameter(selections, "selections");
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
            return Intrinsics3.areEqual(this.name, checkboxElement.name) && Intrinsics3.areEqual(this.data, checkboxElement.data) && Intrinsics3.areEqual(this.selections, checkboxElement.selections);
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
            StringBuilder sbU = outline.U("CheckboxElement(name=");
            sbU.append(this.name);
            sbU.append(", data=");
            sbU.append(this.data);
            sbU.append(", selections=");
            sbU.append(this.selections);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final String getLocation(ReportNode node) {
            return "REPORT_MENU_NODE_" + node + ".id";
        }

        private final Observable<StoreState> getStoreState(final WidgetMobileReports2 args) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreMessages messages = companion.getMessages();
            long channelId = args.getChannelId();
            WidgetMobileReports2.Message message = (WidgetMobileReports2.Message) (!(args instanceof WidgetMobileReports2.Message) ? null : args);
            Observable<Message> observableObserveMessagesForChannel = messages.observeMessagesForChannel(channelId, message != null ? message.getMessageId() : -1L);
            Observable<Channel> observableObserveChannel = companion.getChannels().observeChannel(args.getChannelId());
            Observable<Guild> observableObserveFromChannelId = companion.getGuilds().observeFromChannelId(args.getChannelId());
            Observable<StageInstance> observableObserveStageInstanceForChannel = companion.getStageInstances().observeStageInstanceForChannel(args.getChannelId());
            Observable<Map<Long, Integer>> observableObserveForType = companion.getUserRelationships().observeForType(2);
            Observable<RestCallState<List<DirectoryEntryGuild>>> observableObserveDirectoriesForChannel = companion.getDirectories().observeDirectoriesForChannel(args.getChannelId());
            StoreGuildScheduledEvents guildScheduledEvents = companion.getGuildScheduledEvents();
            boolean z2 = args instanceof WidgetMobileReports2.GuildScheduledEvent;
            WidgetMobileReports2.GuildScheduledEvent guildScheduledEvent = (WidgetMobileReports2.GuildScheduledEvent) (!z2 ? null : args);
            Long lValueOf = guildScheduledEvent != null ? Long.valueOf(guildScheduledEvent.getEventId()) : null;
            WidgetMobileReports2.GuildScheduledEvent guildScheduledEvent2 = (WidgetMobileReports2.GuildScheduledEvent) (!z2 ? null : args);
            Observable<GuildScheduledEvent> observableObserveGuildScheduledEvent = guildScheduledEvents.observeGuildScheduledEvent(lValueOf, guildScheduledEvent2 != null ? Long.valueOf(guildScheduledEvent2.getGuildId()) : null);
            StoreGuilds guilds = companion.getGuilds();
            WidgetMobileReports2.GuildScheduledEvent guildScheduledEvent3 = (WidgetMobileReports2.GuildScheduledEvent) (z2 ? args : null);
            Observable<StoreState> observableD = Observable.d(observableObserveMessagesForChannel, observableObserveChannel, observableObserveFromChannelId, observableObserveStageInstanceForChannel, observableObserveForType, observableObserveDirectoriesForChannel, observableObserveGuildScheduledEvent, guilds.observeGuild(guildScheduledEvent3 != null ? guildScheduledEvent3.getGuildId() : -1L), new Func8<Message, Channel, Guild, StageInstance, Map<Long, ? extends Integer>, RestCallState<? extends List<? extends DirectoryEntryGuild>>, GuildScheduledEvent, Guild, StoreState>() { // from class: com.discord.widgets.mobile_reports.MobileReportsViewModel$Companion$getStoreState$1
                @Override // rx.functions.Func8
                public /* bridge */ /* synthetic */ MobileReportsViewModel.StoreState call(Message message2, Channel channel, Guild guild, StageInstance stageInstance, Map<Long, ? extends Integer> map, RestCallState<? extends List<? extends DirectoryEntryGuild>> restCallState, GuildScheduledEvent guildScheduledEvent4, Guild guild2) {
                    return call2(message2, channel, guild, stageInstance, (Map<Long, Integer>) map, (RestCallState<? extends List<DirectoryEntryGuild>>) restCallState, guildScheduledEvent4, guild2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final MobileReportsViewModel.StoreState call2(Message message2, Channel channel, Guild guild, StageInstance stageInstance, Map<Long, Integer> map, RestCallState<? extends List<DirectoryEntryGuild>> restCallState, GuildScheduledEvent guildScheduledEvent4, Guild guild2) {
                    List<DirectoryEntryGuild> listInvoke;
                    WidgetMobileReports2 widgetMobileReports2 = args;
                    Object obj = null;
                    if (!(widgetMobileReports2 instanceof WidgetMobileReports2.DirectoryServer)) {
                        widgetMobileReports2 = null;
                    }
                    WidgetMobileReports2.DirectoryServer directoryServer = (WidgetMobileReports2.DirectoryServer) widgetMobileReports2;
                    Long lValueOf2 = directoryServer != null ? Long.valueOf(directoryServer.getGuildId()) : null;
                    Guild guild3 = guild != null ? guild : guild2;
                    Intrinsics3.checkNotNullExpressionValue(map, "blockedUsers");
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
            Intrinsics3.checkNotNullExpressionValue(observableD, "Observable.combineLatest…nt = event,\n      )\n    }");
            return observableD;
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
            Intrinsics3.checkNotNullParameter(guild, "hub");
            Intrinsics3.checkNotNullParameter(directoryEntryGuild, "directoryEntry");
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
            Intrinsics3.checkNotNullParameter(hub, "hub");
            Intrinsics3.checkNotNullParameter(directoryEntry, "directoryEntry");
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
            return Intrinsics3.areEqual(this.hub, directoryServerPreview.hub) && Intrinsics3.areEqual(this.directoryEntry, directoryServerPreview.directoryEntry);
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
            StringBuilder sbU = outline.U("DirectoryServerPreview(hub=");
            sbU.append(this.hub);
            sbU.append(", directoryEntry=");
            sbU.append(this.directoryEntry);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final /* data */ class GuildScheduledEventPreview {
        private final GuildScheduledEvent event;
        private final Guild guild;

        public GuildScheduledEventPreview(Guild guild, GuildScheduledEvent guildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
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
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(event, "event");
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
            return Intrinsics3.areEqual(this.guild, guildScheduledEventPreview.guild) && Intrinsics3.areEqual(this.event, guildScheduledEventPreview.event);
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
            StringBuilder sbU = outline.U("GuildScheduledEventPreview(guild=");
            sbU.append(this.guild);
            sbU.append(", event=");
            sbU.append(this.event);
            sbU.append(")");
            return sbU.toString();
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
            Intrinsics3.checkNotNullParameter(draweeSpanStringBuilder, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(str, "authorName");
            Intrinsics3.checkNotNullParameter(user, "author");
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
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(authorName, "authorName");
            Intrinsics3.checkNotNullParameter(author, "author");
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
            return Intrinsics3.areEqual(this.text, messagePreview.text) && Intrinsics3.areEqual(this.authorName, messagePreview.authorName) && this.authorNameColor == messagePreview.authorNameColor && Intrinsics3.areEqual(this.author, messagePreview.author) && this.hasEmbeds == messagePreview.hasEmbeds;
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
            StringBuilder sbU = outline.U("MessagePreview(text=");
            sbU.append((Object) this.text);
            sbU.append(", authorName=");
            sbU.append(this.authorName);
            sbU.append(", authorNameColor=");
            sbU.append(this.authorNameColor);
            sbU.append(", author=");
            sbU.append(this.author);
            sbU.append(", hasEmbeds=");
            return outline.O(sbU, this.hasEmbeds, ")");
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
                Intrinsics3.checkNotNullParameter(reportNode, "prevNode");
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
                Intrinsics3.checkNotNullParameter(prevNode, "prevNode");
                return new Back(prevNode);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Back) && Intrinsics3.areEqual(this.prevNode, ((Back) other).prevNode);
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
                StringBuilder sbU = outline.U("Back(prevNode=");
                sbU.append(this.prevNode);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: MobileReportsViewModel.kt */
        public static final /* data */ class Initial extends NodeNavigationType {
            private final ReportNode initialNode;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initial(ReportNode reportNode) {
                super(reportNode, null);
                Intrinsics3.checkNotNullParameter(reportNode, "initialNode");
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
                Intrinsics3.checkNotNullParameter(initialNode, "initialNode");
                return new Initial(initialNode);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Initial) && Intrinsics3.areEqual(this.initialNode, ((Initial) other).initialNode);
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
                StringBuilder sbU = outline.U("Initial(initialNode=");
                sbU.append(this.initialNode);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: MobileReportsViewModel.kt */
        public static final /* data */ class Next extends NodeNavigationType {
            private final ReportNode nextNode;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Next(ReportNode reportNode) {
                super(reportNode, null);
                Intrinsics3.checkNotNullParameter(reportNode, "nextNode");
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
                Intrinsics3.checkNotNullParameter(nextNode, "nextNode");
                return new Next(nextNode);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Next) && Intrinsics3.areEqual(this.nextNode, ((Next) other).nextNode);
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
                StringBuilder sbU = outline.U("Next(nextNode=");
                sbU.append(this.nextNode);
                sbU.append(")");
                return sbU.toString();
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
            Intrinsics3.checkNotNullParameter(reportNode, "node");
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
            Intrinsics3.checkNotNullParameter(node, "node");
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
            return Intrinsics3.areEqual(this.node, nodeState.node) && Intrinsics3.areEqual(this.checkboxElement, nodeState.checkboxElement) && Intrinsics3.areEqual(this.messagePreviewElement, nodeState.messagePreviewElement) && Intrinsics3.areEqual(this.channelPreviewElement, nodeState.channelPreviewElement) && Intrinsics3.areEqual(this.directoryServerPreviewElement, nodeState.directoryServerPreviewElement) && Intrinsics3.areEqual(this.eventPreviewElement, nodeState.eventPreviewElement) && Intrinsics3.areEqual(this.blockUserElement, nodeState.blockUserElement) && Intrinsics3.areEqual(this.breadcrumbsElement, nodeState.breadcrumbsElement) && this.successElement == nodeState.successElement && Intrinsics3.areEqual(this.submitState, nodeState.submitState) && Intrinsics3.areEqual(this.bottomButton, nodeState.bottomButton);
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
            StringBuilder sbU = outline.U("NodeState(node=");
            sbU.append(this.node);
            sbU.append(", checkboxElement=");
            sbU.append(this.checkboxElement);
            sbU.append(", messagePreviewElement=");
            sbU.append(this.messagePreviewElement);
            sbU.append(", channelPreviewElement=");
            sbU.append(this.channelPreviewElement);
            sbU.append(", directoryServerPreviewElement=");
            sbU.append(this.directoryServerPreviewElement);
            sbU.append(", eventPreviewElement=");
            sbU.append(this.eventPreviewElement);
            sbU.append(", blockUserElement=");
            sbU.append(this.blockUserElement);
            sbU.append(", breadcrumbsElement=");
            sbU.append(this.breadcrumbsElement);
            sbU.append(", successElement=");
            sbU.append(this.successElement);
            sbU.append(", submitState=");
            sbU.append(this.submitState);
            sbU.append(", bottomButton=");
            sbU.append(this.bottomButton);
            sbU.append(")");
            return sbU.toString();
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
            Intrinsics3.checkNotNullParameter(map, "blockedUsers");
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
            Intrinsics3.checkNotNullParameter(blockedUsers, "blockedUsers");
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
            return Intrinsics3.areEqual(this.message, storeState.message) && Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.directoryEntry, storeState.directoryEntry) && Intrinsics3.areEqual(this.stageInstance, storeState.stageInstance) && Intrinsics3.areEqual(this.blockedUsers, storeState.blockedUsers) && Intrinsics3.areEqual(this.event, storeState.event);
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
            StringBuilder sbU = outline.U("StoreState(message=");
            sbU.append(this.message);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", directoryEntry=");
            sbU.append(this.directoryEntry);
            sbU.append(", stageInstance=");
            sbU.append(this.stageInstance);
            sbU.append(", blockedUsers=");
            sbU.append(this.blockedUsers);
            sbU.append(", event=");
            sbU.append(this.event);
            sbU.append(")");
            return sbU.toString();
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
                Intrinsics3.checkNotNullParameter(menu, "menu");
                Intrinsics3.checkNotNullParameter(nodeNavigationType, "nodeNavigationType");
                Intrinsics3.checkNotNullParameter(submitState, "submitState");
                Intrinsics3.checkNotNullParameter(history, "history");
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
                return Intrinsics3.areEqual(this.menu, menu.menu) && Intrinsics3.areEqual(this.messagePreview, menu.messagePreview) && Intrinsics3.areEqual(this.channelPreview, menu.channelPreview) && Intrinsics3.areEqual(this.directoryServerPreview, menu.directoryServerPreview) && Intrinsics3.areEqual(this.eventPreview, menu.eventPreview) && Intrinsics3.areEqual(this.nodeNavigationType, menu.nodeNavigationType) && Intrinsics3.areEqual(this.submitState, menu.submitState) && Intrinsics3.areEqual(this.history, menu.history) && Intrinsics3.areEqual(this.blockUserElement, menu.blockUserElement);
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
                List<ReportNodeElement> listC = node.c();
                ReportNodeElement.Companion companion = ReportNodeElement.INSTANCE;
                Iterator<T> it = listC.iterator();
                do {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    reportNodeElement7 = (ReportNodeElement) next;
                    Objects.requireNonNull(companion);
                    Intrinsics3.checkNotNullParameter(reportNodeElement7, "element");
                } while (!Intrinsics3.areEqual(reportNodeElement7.getType(), "checkbox"));
                ReportNodeElement reportNodeElement8 = (ReportNodeElement) next;
                if (reportNodeElement8 != null) {
                    List<ReportNodeElementData> listA = reportNodeElement8.a();
                    checkboxElement = listA == null ? null : new CheckboxElement(reportNodeElement8.getName(), listA, new HashSet());
                } else {
                    checkboxElement = null;
                }
                List<ReportNodeElement> listC2 = node.c();
                ReportNodeElement.Companion companion2 = ReportNodeElement.INSTANCE;
                Iterator<T> it2 = listC2.iterator();
                do {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    reportNodeElement6 = (ReportNodeElement) next2;
                    Objects.requireNonNull(companion2);
                    Intrinsics3.checkNotNullParameter(reportNodeElement6, "element");
                } while (!Intrinsics3.areEqual(reportNodeElement6.getType(), "message_preview"));
                MessagePreview messagePreview = ((ReportNodeElement) next2) != null ? this.messagePreview : null;
                List<ReportNodeElement> listC3 = node.c();
                ReportNodeElement.Companion companion3 = ReportNodeElement.INSTANCE;
                Iterator<T> it3 = listC3.iterator();
                do {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    reportNodeElement5 = (ReportNodeElement) next3;
                    Objects.requireNonNull(companion3);
                    Intrinsics3.checkNotNullParameter(reportNodeElement5, "element");
                } while (!Intrinsics3.areEqual(reportNodeElement5.getType(), "channel_preview"));
                ChannelPreview channelPreview = ((ReportNodeElement) next3) != null ? this.channelPreview : null;
                List<ReportNodeElement> listC4 = node.c();
                ReportNodeElement.Companion companion4 = ReportNodeElement.INSTANCE;
                Iterator<T> it4 = listC4.iterator();
                do {
                    if (!it4.hasNext()) {
                        next4 = null;
                        break;
                    }
                    next4 = it4.next();
                    reportNodeElement4 = (ReportNodeElement) next4;
                    Objects.requireNonNull(companion4);
                    Intrinsics3.checkNotNullParameter(reportNodeElement4, "element");
                } while (!Intrinsics3.areEqual(reportNodeElement4.getType(), "guild_directory_entry_preview"));
                DirectoryServerPreview directoryServerPreview = ((ReportNodeElement) next4) != null ? this.directoryServerPreview : null;
                List<ReportNodeElement> listC5 = node.c();
                ReportNodeElement.Companion companion5 = ReportNodeElement.INSTANCE;
                Iterator<T> it5 = listC5.iterator();
                do {
                    if (!it5.hasNext()) {
                        next5 = null;
                        break;
                    }
                    next5 = it5.next();
                    reportNodeElement3 = (ReportNodeElement) next5;
                    Objects.requireNonNull(companion5);
                    Intrinsics3.checkNotNullParameter(reportNodeElement3, "element");
                } while (!Intrinsics3.areEqual(reportNodeElement3.getType(), "guild_scheduled_event_preview"));
                GuildScheduledEventPreview guildScheduledEventPreview = ((ReportNodeElement) next5) != null ? this.eventPreview : null;
                List<ReportNodeElement> listC6 = node.c();
                ReportNodeElement.Companion companion6 = ReportNodeElement.INSTANCE;
                Iterator<T> it6 = listC6.iterator();
                do {
                    if (!it6.hasNext()) {
                        next6 = null;
                        break;
                    }
                    next6 = it6.next();
                    reportNodeElement2 = (ReportNodeElement) next6;
                    Objects.requireNonNull(companion6);
                    Intrinsics3.checkNotNullParameter(reportNodeElement2, "element");
                } while (!Intrinsics3.areEqual(reportNodeElement2.getType(), "block_users"));
                BlockUserElement blockUserElement = ((ReportNodeElement) next6) != null ? this.blockUserElement : null;
                List<ReportNodeElement> listC7 = node.c();
                ReportNodeElement.Companion companion7 = ReportNodeElement.INSTANCE;
                Iterator<T> it7 = listC7.iterator();
                do {
                    if (!it7.hasNext()) {
                        next7 = null;
                        break;
                    }
                    next7 = it7.next();
                    reportNodeElement = (ReportNodeElement) next7;
                    Objects.requireNonNull(companion7);
                    Intrinsics3.checkNotNullParameter(reportNodeElement, "element");
                } while (!Intrinsics3.areEqual(reportNodeElement.getType(), "breadcrumbs"));
                List<NodeResult> list = ((ReportNodeElement) next7) != null ? this.history : null;
                List<ReportNodeElement> listC8 = node.c();
                ReportNodeElement.Companion companion8 = ReportNodeElement.INSTANCE;
                for (Object obj2 : listC8) {
                    ReportNodeElement reportNodeElement9 = (ReportNodeElement) obj2;
                    Objects.requireNonNull(companion8);
                    Intrinsics3.checkNotNullParameter(reportNodeElement9, "element");
                    if (Intrinsics3.areEqual(reportNodeElement9.getType(), "success")) {
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
                StringBuilder sbU = outline.U("Menu(menu=");
                sbU.append(this.menu);
                sbU.append(", messagePreview=");
                sbU.append(this.messagePreview);
                sbU.append(", channelPreview=");
                sbU.append(this.channelPreview);
                sbU.append(", directoryServerPreview=");
                sbU.append(this.directoryServerPreview);
                sbU.append(", eventPreview=");
                sbU.append(this.eventPreview);
                sbU.append(", nodeNavigationType=");
                sbU.append(this.nodeNavigationType);
                sbU.append(", submitState=");
                sbU.append(this.submitState);
                sbU.append(", history=");
                sbU.append(this.history);
                sbU.append(", blockUserElement=");
                sbU.append(this.blockUserElement);
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Menu(MenuAPIResponse menuAPIResponse, MessagePreview messagePreview, ChannelPreview channelPreview, DirectoryServerPreview directoryServerPreview, GuildScheduledEventPreview guildScheduledEventPreview, NodeNavigationType nodeNavigationType, SubmitState submitState, List<NodeResult> list, BlockUserElement blockUserElement) {
                super(null);
                Intrinsics3.checkNotNullParameter(menuAPIResponse, "menu");
                Intrinsics3.checkNotNullParameter(nodeNavigationType, "nodeNavigationType");
                Intrinsics3.checkNotNullParameter(submitState, "submitState");
                Intrinsics3.checkNotNullParameter(list, "history");
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

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$handleBlockUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$handleSubmit$1, reason: invalid class name */
    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ ViewState.Menu $currentViewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Menu menu) {
            super(1);
            this.$currentViewState = menu;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            Intrinsics3.checkNotNullParameter(unit, "it");
            MobileReportsViewModel.this.handleNext(new ReportNodeChild("", this.$currentViewState.getMenu().getSuccess_node_id()), null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$handleSubmit$2, reason: invalid class name */
    /* JADX INFO: compiled from: MobileReportsViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ ViewState.Menu $currentViewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ViewState.Menu menu) {
            super(1);
            this.$currentViewState = menu;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            MobileReportsViewModel.this.updateViewState(ViewState.Menu.copy$default(this.$currentViewState, null, null, null, null, null, null, SubmitState.Error.INSTANCE, null, null, 447, null));
        }
    }

    public /* synthetic */ MobileReportsViewModel(WeakReference weakReference, WidgetMobileReports2 widgetMobileReports2, RestAPI restAPI, Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference, widgetMobileReports2, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? ClockFactory.get() : clock, (i & 16) != 0 ? INSTANCE.getStoreState(widgetMobileReports2) : observable);
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
            Intrinsics3.checkNotNullExpressionValue(context, "context.get() ?: return null");
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
                Map map = (Map) outline.c(channel, companion.getGuilds().getMembers());
                if (map == null) {
                    map = new HashMap();
                }
                Map map2 = map;
                Map map3 = (Map) outline.c(channel, companion.getGuilds().getRoles());
                Map<Long, String> channelNames = companion.getChannels().getChannelNames();
                Map<Long, String> nickOrUsernames = MessageUtils.getNickOrUsernames(message, channel, map2, channel.q());
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
                return new MessagePreview(channelMessage, str, companion2.getColor((GuildMember) map2.get(author4 != null ? Long.valueOf(author4.getId()) : null), ColorCompat.getThemedColor(context, R.attr.colorHeaderPrimary)), user, message.hasEmbeds() || message.hasAttachments());
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
        NodeResult nodeResult = (NodeResult) _Collections.lastOrNull((List) menu.getHistory());
        ReportNode node = nodeResult != null ? nodeResult.getNode() : null;
        ReportNode node2 = menu.getNodeNavigationType().getNode();
        MenuAPIResponse menu2 = menu.getMenu();
        if (menu2.getSuccess_node_id() != node2.getId() && !(menu.getSubmitState() instanceof SubmitState.Loading)) {
            if (node == null || menu2.getRoot_node_id() == node2.getId()) {
                return false;
            }
            updateViewState(ViewState.Menu.copy$default(menu, null, null, null, null, null, new NodeNavigationType.Back(node), null, _Collections.dropLast(menu.getHistory(), 1), null, 351, null));
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
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.addRelationship(INSTANCE.getLocation(node), blockUserElement.getUser().getId(), (28 & 4) != 0 ? null : 2, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null), false, 1, null), this, null, 2, null), (Class<?>) MobileReportsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass1.INSTANCE);
            }
        }
    }

    public final void handleNext(ReportNodeChild destination, NodeElementResult elementResult) {
        ReportNode reportNode;
        Intrinsics3.checkNotNullParameter(destination, "destination");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Menu)) {
            viewState = null;
        }
        ViewState.Menu menu = (ViewState.Menu) viewState;
        if (menu == null || (reportNode = menu.getMenu().c().get(Integer.valueOf(destination.getRef()))) == null) {
            return;
        }
        updateViewState(ViewState.Menu.copy$default(menu, null, null, null, null, null, new NodeNavigationType.Next(reportNode), SubmitState.None.INSTANCE, _Collections.plus((Collection<? extends NodeResult>) menu.getHistory(), new NodeResult(menu.getNodeNavigationType().getNode(), destination, elementResult)), null, 287, null));
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
        WidgetMobileReports2 widgetMobileReports2 = this.args;
        if (widgetMobileReports2 instanceof WidgetMobileReports2.Message) {
            ReportSubmissionBody.Companion companion = ReportSubmissionBody.INSTANCE;
            long jCurrentTimeMillis = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long channelId = this.args.getChannelId();
            long messageId = ((WidgetMobileReports2.Message) this.args).getMessageId();
            MenuAPIResponse menu2 = menu.getMenu();
            List<NodeResult> history = menu.getHistory();
            Objects.requireNonNull(companion);
            Intrinsics3.checkNotNullParameter(menu2, "menu");
            Intrinsics3.checkNotNullParameter(history, "results");
            Tuples2<List<Integer>, Map<String, List<String>>> tuples2A = companion.a(history);
            List<Integer> listComponent1 = tuples2A.component1();
            Map<String, List<String>> mapComponent2 = tuples2A.component2();
            Long lValueOf = Long.valueOf(messageId);
            Long lValueOf2 = Long.valueOf(channelId);
            String name = menu2.getName();
            String language = menu2.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis, lValueOf, lValueOf2, null, null, null, language != null ? language : "en", menu2.getVariant(), name, menu2.getVersion(), listComponent1, mapComponent2, 56);
        } else if (widgetMobileReports2 instanceof WidgetMobileReports2.StageChannel) {
            ChannelPreview channelPreview = menu.getChannelPreview();
            if (channelPreview == null || (guild = channelPreview.getGuild()) == null) {
                Logger.e$default(AppLog.g, "Tried to send report for stage channel, but without guild id?", null, null, 6, null);
                return;
            }
            long id2 = guild.getId();
            ReportSubmissionBody.Companion companion2 = ReportSubmissionBody.INSTANCE;
            long jCurrentTimeMillis2 = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long channelId2 = this.args.getChannelId();
            MenuAPIResponse menu3 = menu.getMenu();
            List<NodeResult> history2 = menu.getHistory();
            Objects.requireNonNull(companion2);
            Intrinsics3.checkNotNullParameter(menu3, "menu");
            Intrinsics3.checkNotNullParameter(history2, "results");
            Tuples2<List<Integer>, Map<String, List<String>>> tuples2A2 = companion2.a(history2);
            List<Integer> listComponent2 = tuples2A2.component1();
            Map<String, List<String>> mapComponent3 = tuples2A2.component2();
            Long lValueOf3 = Long.valueOf(id2);
            Long lValueOf4 = Long.valueOf(channelId2);
            String name2 = menu3.getName();
            String language2 = menu3.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis2, null, lValueOf4, lValueOf3, null, null, language2 != null ? language2 : "en", menu3.getVariant(), name2, menu3.getVersion(), listComponent2, mapComponent3, 50);
        } else if (widgetMobileReports2 instanceof WidgetMobileReports2.DirectoryServer) {
            ReportSubmissionBody.Companion companion3 = ReportSubmissionBody.INSTANCE;
            long jCurrentTimeMillis3 = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long channelId3 = this.args.getChannelId();
            long guildId = ((WidgetMobileReports2.DirectoryServer) this.args).getGuildId();
            long hubId = ((WidgetMobileReports2.DirectoryServer) this.args).getHubId();
            MenuAPIResponse menu4 = menu.getMenu();
            List<NodeResult> history3 = menu.getHistory();
            Objects.requireNonNull(companion3);
            Intrinsics3.checkNotNullParameter(menu4, "menu");
            Intrinsics3.checkNotNullParameter(history3, "results");
            Tuples2<List<Integer>, Map<String, List<String>>> tuples2A3 = companion3.a(history3);
            List<Integer> listComponent3 = tuples2A3.component1();
            Map<String, List<String>> mapComponent4 = tuples2A3.component2();
            Long lValueOf5 = Long.valueOf(guildId);
            Long lValueOf6 = Long.valueOf(channelId3);
            Long lValueOf7 = Long.valueOf(hubId);
            String name3 = menu4.getName();
            String language3 = menu4.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis3, null, lValueOf6, lValueOf5, lValueOf7, null, language3 != null ? language3 : "en", menu4.getVariant(), name3, menu4.getVersion(), listComponent3, mapComponent4, 34);
        } else {
            if (!(widgetMobileReports2 instanceof WidgetMobileReports2.GuildScheduledEvent)) {
                throw new NoWhenBranchMatchedException();
            }
            ReportSubmissionBody.Companion companion4 = ReportSubmissionBody.INSTANCE;
            long jCurrentTimeMillis4 = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long guildId2 = ((WidgetMobileReports2.GuildScheduledEvent) this.args).getGuildId();
            long eventId = ((WidgetMobileReports2.GuildScheduledEvent) this.args).getEventId();
            MenuAPIResponse menu5 = menu.getMenu();
            List<NodeResult> history4 = menu.getHistory();
            Objects.requireNonNull(companion4);
            Intrinsics3.checkNotNullParameter(menu5, "menu");
            Intrinsics3.checkNotNullParameter(history4, "results");
            Tuples2<List<Integer>, Map<String, List<String>>> tuples2A4 = companion4.a(history4);
            List<Integer> listComponent4 = tuples2A4.component1();
            Map<String, List<String>> mapComponent5 = tuples2A4.component2();
            Long lValueOf8 = Long.valueOf(guildId2);
            Long lValueOf9 = Long.valueOf(eventId);
            String name4 = menu5.getName();
            String language4 = menu5.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis4, null, null, lValueOf8, null, lValueOf9, language4 != null ? language4 : "en", menu5.getVariant(), name4, menu5.getVersion(), listComponent4, mapComponent5, 22);
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.submitReport(this.args.getReportType().getPathValue(), reportSubmissionBody), false, 1, null), this, null, 2, null), (Class<?>) MobileReportsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2(menu)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(menu));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileReportsViewModel(WeakReference<Context> weakReference, WidgetMobileReports2 widgetMobileReports2, RestAPI restAPI, Clock clock, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(weakReference, "context");
        Intrinsics3.checkNotNullParameter(widgetMobileReports2, "args");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.context = weakReference;
        this.args = widgetMobileReports2;
        this.restAPI = restAPI;
        this.clock = clock;
        Observable observableJ = Observable.j(ObservableExtensionsKt.computationLatest(observable), ObservableExtensionsKt.restSubscribeOn$default(restAPI.getReportMenu(widgetMobileReports2.getReportType().getPathValue()), false, 1, null), new Func2<StoreState, MenuAPIResponse, Tuples2<? extends StoreState, ? extends MenuAPIResponse>>() { // from class: com.discord.widgets.mobile_reports.MobileReportsViewModel.1
            @Override // rx.functions.Func2
            public final Tuples2<StoreState, MenuAPIResponse> call(StoreState storeState, MenuAPIResponse menuAPIResponse) {
                return Tuples.to(storeState, menuAPIResponse);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…> storeState to menuAPI }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableJ, this, null, 2, null), (Class<?>) MobileReportsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
