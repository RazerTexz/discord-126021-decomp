package com.discord.widgets.voice.fullscreen;

import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.user.MeUser;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.stores.StoreApplication;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.voice.VoiceChannelJoinability;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreenViewModel;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func7;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreenViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private Set<String> fetchedPreviews;
    private final StoreMediaSettings mediaSettingsStore;
    private StoreState mostRecentStoreState;
    private final StoreApplication storeApplication;
    private final StoreApplicationStreamPreviews storeApplicationStreamPreviews;
    private final StoreChannels storeChannels;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreMentions storeMentions;
    private final StoreNavigation storeNavigation;
    private final StoreUser storeUser;
    private final StoreUserSettings storeUserSettings;
    private final StoreVoiceChannelSelected storeVoiceChannelSelected;
    private long voiceChannelId;

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreenViewModel$1 */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
    public static final class C105451 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C105451() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetCallPreviewFullscreenViewModel widgetCallPreviewFullscreenViewModel = WidgetCallPreviewFullscreenViewModel.this;
            C12238m.checkNotNullExpressionValue(storeState, "it");
            widgetCallPreviewFullscreenViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final long voiceChannelId, final StoreUser storeUser, StoreChannels storeChannels, final StoreChannelsSelected storeChannelsSelected, final StoreMentions storeMentions, final StoreVoiceChannelSelected storeVoiceChannelSelected) {
            Observable observableM11099Y = storeChannels.observeChannel(voiceChannelId).m11099Y(new InterfaceC12589b<Channel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreenViewModel$Companion$observeStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetCallPreviewFullscreenViewModel.StoreState> call(final Channel channel) {
                    return Observable.m11069e(StoreUser.observeMe$default(storeUser, false, 1, null), storeChannelsSelected.observeSelectedChannel(), TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().observeEnabled(channel != null ? Long.valueOf(channel.getGuildId()) : null), storeMentions.observeTotalMentions(), storeMentions.observeMentionCounts(), CallModel.INSTANCE.get(voiceChannelId), storeVoiceChannelSelected.observeSelectedChannel(), new Func7<MeUser, Channel, Boolean, Integer, Map<Long, ? extends Integer>, CallModel, Channel, WidgetCallPreviewFullscreenViewModel.StoreState>() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreenViewModel$Companion$observeStoreState$1.1
                        @Override // p658rx.functions.Func7
                        public /* bridge */ /* synthetic */ WidgetCallPreviewFullscreenViewModel.StoreState call(MeUser meUser, Channel channel2, Boolean bool, Integer num, Map<Long, ? extends Integer> map, CallModel callModel, Channel channel3) {
                            return call2(meUser, channel2, bool, num, (Map<Long, Integer>) map, callModel, channel3);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final WidgetCallPreviewFullscreenViewModel.StoreState call2(MeUser meUser, Channel channel2, Boolean bool, Integer num, Map<Long, Integer> map, CallModel callModel, Channel channel3) {
                            if (callModel == null || channel == null || channel2 == null) {
                                return WidgetCallPreviewFullscreenViewModel.StoreState.Invalid.INSTANCE;
                            }
                            boolean z2 = !StoreStream.INSTANCE.getGuildsNsfw().isGuildNsfwGateAgreed(channel.getGuildId());
                            boolean nsfw = channel.getNsfw();
                            NsfwAllowance nsfwAllowance = meUser != null ? meUser.getNsfwAllowance() : null;
                            Channel channel4 = channel;
                            C12238m.checkNotNullExpressionValue(bool, "isTextInVoiceEnabled");
                            boolean zBooleanValue = bool.booleanValue();
                            C12238m.checkNotNullExpressionValue(num, "totalMentionsCount");
                            int iIntValue = num.intValue();
                            Integer num2 = (Integer) C1643a.m845d(channel, map);
                            return new WidgetCallPreviewFullscreenViewModel.StoreState.Valid(channel4, channel2, zBooleanValue, iIntValue, num2 != null ? num2.intValue() : 0, z2, nsfw, nsfwAllowance, callModel, channel3);
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "storeChannels.observeCha…  }\n          }\n        }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
        public static final /* data */ class LaunchVideoCall extends Event {
            private final String autoTargetStreamKey;
            private final long channelId;

            public LaunchVideoCall(long j, String str) {
                super(null);
                this.channelId = j;
                this.autoTargetStreamKey = str;
            }

            public static /* synthetic */ LaunchVideoCall copy$default(LaunchVideoCall launchVideoCall, long j, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchVideoCall.channelId;
                }
                if ((i & 2) != 0) {
                    str = launchVideoCall.autoTargetStreamKey;
                }
                return launchVideoCall.copy(j, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getAutoTargetStreamKey() {
                return this.autoTargetStreamKey;
            }

            public final LaunchVideoCall copy(long channelId, String autoTargetStreamKey) {
                return new LaunchVideoCall(channelId, autoTargetStreamKey);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchVideoCall)) {
                    return false;
                }
                LaunchVideoCall launchVideoCall = (LaunchVideoCall) other;
                return this.channelId == launchVideoCall.channelId && C12238m.areEqual(this.autoTargetStreamKey, launchVideoCall.autoTargetStreamKey);
            }

            public final String getAutoTargetStreamKey() {
                return this.autoTargetStreamKey;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                int iM3a = C0002b.m3a(this.channelId) * 31;
                String str = this.autoTargetStreamKey;
                return iM3a + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("LaunchVideoCall(channelId=");
                sbM833U.append(this.channelId);
                sbM833U.append(", autoTargetStreamKey=");
                return C1643a.m822J(sbM833U, this.autoTargetStreamKey, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
        public static final class ShowGuildVideoAtCapacityDialog extends Event {
            public static final ShowGuildVideoAtCapacityDialog INSTANCE = new ShowGuildVideoAtCapacityDialog();

            private ShowGuildVideoAtCapacityDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
        public static final class ShowOverlayNux extends Event {
            public static final ShowOverlayNux INSTANCE = new ShowOverlayNux();

            private ShowOverlayNux() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
    public static abstract class ParticipantsList {

        /* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
        public static final /* data */ class Empty extends ParticipantsList {
            private final List<CallParticipantsAdapter.ListItem> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Empty(List<? extends CallParticipantsAdapter.ListItem> list) {
                super(null);
                C12238m.checkNotNullParameter(list, "items");
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Empty copy$default(Empty empty, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = empty.items;
                }
                return empty.copy(list);
            }

            public final List<CallParticipantsAdapter.ListItem> component1() {
                return this.items;
            }

            public final Empty copy(List<? extends CallParticipantsAdapter.ListItem> items) {
                C12238m.checkNotNullParameter(items, "items");
                return new Empty(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Empty) && C12238m.areEqual(this.items, ((Empty) other).items);
                }
                return true;
            }

            public final List<CallParticipantsAdapter.ListItem> getItems() {
                return this.items;
            }

            public int hashCode() {
                List<CallParticipantsAdapter.ListItem> list = this.items;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m824L(C1643a.m833U("Empty(items="), this.items, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
        public static final /* data */ class ListItems extends ParticipantsList {
            private final List<CallParticipantsAdapter.ListItem> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public ListItems(List<? extends CallParticipantsAdapter.ListItem> list) {
                super(null);
                C12238m.checkNotNullParameter(list, "items");
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ListItems copy$default(ListItems listItems, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = listItems.items;
                }
                return listItems.copy(list);
            }

            public final List<CallParticipantsAdapter.ListItem> component1() {
                return this.items;
            }

            public final ListItems copy(List<? extends CallParticipantsAdapter.ListItem> items) {
                C12238m.checkNotNullParameter(items, "items");
                return new ListItems(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ListItems) && C12238m.areEqual(this.items, ((ListItems) other).items);
                }
                return true;
            }

            public final List<CallParticipantsAdapter.ListItem> getItems() {
                return this.items;
            }

            public int hashCode() {
                List<CallParticipantsAdapter.ListItem> list = this.items;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m824L(C1643a.m833U("ListItems(items="), this.items, ")");
            }
        }

        private ParticipantsList() {
        }

        public /* synthetic */ ParticipantsList(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final CallModel callModel;
            private final int channelMentionsCount;
            private final boolean isChannelNsfw;
            private final boolean isNsfwUnconsented;
            private final boolean isTextInVoiceEnabled;
            private final NsfwAllowance nsfwAllowed;
            private final Channel selectedTextChannel;
            private final Channel selectedVoiceChannel;
            private final int totalMentionsCount;
            private final Channel voiceChannel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Channel channel, Channel channel2, boolean z2, int i, int i2, boolean z3, boolean z4, NsfwAllowance nsfwAllowance, CallModel callModel, Channel channel3) {
                super(null);
                C12238m.checkNotNullParameter(channel, "voiceChannel");
                C12238m.checkNotNullParameter(channel2, "selectedTextChannel");
                C12238m.checkNotNullParameter(callModel, "callModel");
                this.voiceChannel = channel;
                this.selectedTextChannel = channel2;
                this.isTextInVoiceEnabled = z2;
                this.totalMentionsCount = i;
                this.channelMentionsCount = i2;
                this.isNsfwUnconsented = z3;
                this.isChannelNsfw = z4;
                this.nsfwAllowed = nsfwAllowance;
                this.callModel = callModel;
                this.selectedVoiceChannel = channel3;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getVoiceChannel() {
                return this.voiceChannel;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsTextInVoiceEnabled() {
                return this.isTextInVoiceEnabled;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final int getTotalMentionsCount() {
                return this.totalMentionsCount;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final int getChannelMentionsCount() {
                return this.channelMentionsCount;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getIsNsfwUnconsented() {
                return this.isNsfwUnconsented;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final boolean getIsChannelNsfw() {
                return this.isChannelNsfw;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final NsfwAllowance getNsfwAllowed() {
                return this.nsfwAllowed;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final CallModel getCallModel() {
                return this.callModel;
            }

            public final Valid copy(Channel voiceChannel, Channel selectedTextChannel, boolean isTextInVoiceEnabled, int totalMentionsCount, int channelMentionsCount, boolean isNsfwUnconsented, boolean isChannelNsfw, NsfwAllowance nsfwAllowed, CallModel callModel, Channel selectedVoiceChannel) {
                C12238m.checkNotNullParameter(voiceChannel, "voiceChannel");
                C12238m.checkNotNullParameter(selectedTextChannel, "selectedTextChannel");
                C12238m.checkNotNullParameter(callModel, "callModel");
                return new Valid(voiceChannel, selectedTextChannel, isTextInVoiceEnabled, totalMentionsCount, channelMentionsCount, isNsfwUnconsented, isChannelNsfw, nsfwAllowed, callModel, selectedVoiceChannel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return C12238m.areEqual(this.voiceChannel, valid.voiceChannel) && C12238m.areEqual(this.selectedTextChannel, valid.selectedTextChannel) && this.isTextInVoiceEnabled == valid.isTextInVoiceEnabled && this.totalMentionsCount == valid.totalMentionsCount && this.channelMentionsCount == valid.channelMentionsCount && this.isNsfwUnconsented == valid.isNsfwUnconsented && this.isChannelNsfw == valid.isChannelNsfw && C12238m.areEqual(this.nsfwAllowed, valid.nsfwAllowed) && C12238m.areEqual(this.callModel, valid.callModel) && C12238m.areEqual(this.selectedVoiceChannel, valid.selectedVoiceChannel);
            }

            public final CallModel getCallModel() {
                return this.callModel;
            }

            public final int getChannelMentionsCount() {
                return this.channelMentionsCount;
            }

            public final NsfwAllowance getNsfwAllowed() {
                return this.nsfwAllowed;
            }

            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            public final int getTotalMentionsCount() {
                return this.totalMentionsCount;
            }

            public final Channel getVoiceChannel() {
                return this.voiceChannel;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r2v19 */
            /* JADX WARN: Type inference failed for: r2v20 */
            /* JADX WARN: Type inference failed for: r2v22 */
            /* JADX WARN: Type inference failed for: r2v23 */
            /* JADX WARN: Type inference failed for: r2v4, types: [int] */
            /* JADX WARN: Type inference failed for: r2v8, types: [int] */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                Channel channel = this.voiceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Channel channel2 = this.selectedTextChannel;
                int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                boolean z2 = this.isTextInVoiceEnabled;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (((((iHashCode2 + r2) * 31) + this.totalMentionsCount) * 31) + this.channelMentionsCount) * 31;
                boolean z3 = this.isNsfwUnconsented;
                ?? r3 = z3;
                if (z3) {
                    r3 = 1;
                }
                int i2 = (i + r3) * 31;
                boolean z4 = this.isChannelNsfw;
                int i3 = (i2 + (z4 ? 1 : z4)) * 31;
                NsfwAllowance nsfwAllowance = this.nsfwAllowed;
                int iHashCode3 = (i3 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31;
                CallModel callModel = this.callModel;
                int iHashCode4 = (iHashCode3 + (callModel != null ? callModel.hashCode() : 0)) * 31;
                Channel channel3 = this.selectedVoiceChannel;
                return iHashCode4 + (channel3 != null ? channel3.hashCode() : 0);
            }

            public final boolean isChannelNsfw() {
                return this.isChannelNsfw;
            }

            public final boolean isNsfwUnconsented() {
                return this.isNsfwUnconsented;
            }

            public final boolean isTextInVoiceEnabled() {
                return this.isTextInVoiceEnabled;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Valid(voiceChannel=");
                sbM833U.append(this.voiceChannel);
                sbM833U.append(", selectedTextChannel=");
                sbM833U.append(this.selectedTextChannel);
                sbM833U.append(", isTextInVoiceEnabled=");
                sbM833U.append(this.isTextInVoiceEnabled);
                sbM833U.append(", totalMentionsCount=");
                sbM833U.append(this.totalMentionsCount);
                sbM833U.append(", channelMentionsCount=");
                sbM833U.append(this.channelMentionsCount);
                sbM833U.append(", isNsfwUnconsented=");
                sbM833U.append(this.isNsfwUnconsented);
                sbM833U.append(", isChannelNsfw=");
                sbM833U.append(this.isChannelNsfw);
                sbM833U.append(", nsfwAllowed=");
                sbM833U.append(this.nsfwAllowed);
                sbM833U.append(", callModel=");
                sbM833U.append(this.callModel);
                sbM833U.append(", selectedVoiceChannel=");
                sbM833U.append(this.selectedVoiceChannel);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
    public static final /* data */ class ViewState {
        private final int channelMentionsCount;
        private final boolean isChannelNsfw;
        private final boolean isConnectEnabled;
        private final boolean isNsfwUnconsented;
        private final boolean isTextInVoiceChannelSelected;
        private final NsfwAllowance nsfwAllowed;
        private final int otherChannelsMentionsCount;
        private final ParticipantsList participantsList;
        private final boolean textInVoiceEnabled;
        private final String titleText;
        private final Channel voiceChannel;

        public ViewState(Channel channel, boolean z2, boolean z3, String str, int i, int i2, boolean z4, ParticipantsList participantsList, boolean z5, boolean z6, NsfwAllowance nsfwAllowance) {
            C12238m.checkNotNullParameter(channel, "voiceChannel");
            C12238m.checkNotNullParameter(participantsList, "participantsList");
            this.voiceChannel = channel;
            this.isTextInVoiceChannelSelected = z2;
            this.textInVoiceEnabled = z3;
            this.titleText = str;
            this.otherChannelsMentionsCount = i;
            this.channelMentionsCount = i2;
            this.isConnectEnabled = z4;
            this.participantsList = participantsList;
            this.isNsfwUnconsented = z5;
            this.isChannelNsfw = z6;
            this.nsfwAllowed = nsfwAllowance;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getVoiceChannel() {
            return this.voiceChannel;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getIsChannelNsfw() {
            return this.isChannelNsfw;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsTextInVoiceChannelSelected() {
            return this.isTextInVoiceChannelSelected;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getTextInVoiceEnabled() {
            return this.textInVoiceEnabled;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTitleText() {
            return this.titleText;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getOtherChannelsMentionsCount() {
            return this.otherChannelsMentionsCount;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getChannelMentionsCount() {
            return this.channelMentionsCount;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsConnectEnabled() {
            return this.isConnectEnabled;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final ParticipantsList getParticipantsList() {
            return this.participantsList;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getIsNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        public final ViewState copy(Channel voiceChannel, boolean isTextInVoiceChannelSelected, boolean textInVoiceEnabled, String titleText, int otherChannelsMentionsCount, int channelMentionsCount, boolean isConnectEnabled, ParticipantsList participantsList, boolean isNsfwUnconsented, boolean isChannelNsfw, NsfwAllowance nsfwAllowed) {
            C12238m.checkNotNullParameter(voiceChannel, "voiceChannel");
            C12238m.checkNotNullParameter(participantsList, "participantsList");
            return new ViewState(voiceChannel, isTextInVoiceChannelSelected, textInVoiceEnabled, titleText, otherChannelsMentionsCount, channelMentionsCount, isConnectEnabled, participantsList, isNsfwUnconsented, isChannelNsfw, nsfwAllowed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return C12238m.areEqual(this.voiceChannel, viewState.voiceChannel) && this.isTextInVoiceChannelSelected == viewState.isTextInVoiceChannelSelected && this.textInVoiceEnabled == viewState.textInVoiceEnabled && C12238m.areEqual(this.titleText, viewState.titleText) && this.otherChannelsMentionsCount == viewState.otherChannelsMentionsCount && this.channelMentionsCount == viewState.channelMentionsCount && this.isConnectEnabled == viewState.isConnectEnabled && C12238m.areEqual(this.participantsList, viewState.participantsList) && this.isNsfwUnconsented == viewState.isNsfwUnconsented && this.isChannelNsfw == viewState.isChannelNsfw && C12238m.areEqual(this.nsfwAllowed, viewState.nsfwAllowed);
        }

        public final int getChannelMentionsCount() {
            return this.channelMentionsCount;
        }

        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        public final int getOtherChannelsMentionsCount() {
            return this.otherChannelsMentionsCount;
        }

        public final ParticipantsList getParticipantsList() {
            return this.participantsList;
        }

        public final boolean getTextInVoiceEnabled() {
            return this.textInVoiceEnabled;
        }

        public final String getTitleText() {
            return this.titleText;
        }

        public final Channel getVoiceChannel() {
            return this.voiceChannel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v15, types: [int] */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v25 */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            Channel channel = this.voiceChannel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.isTextInVoiceChannelSelected;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode + r2) * 31;
            boolean z3 = this.textInVoiceEnabled;
            ?? r3 = z3;
            if (z3) {
                r3 = 1;
            }
            int i2 = (i + r3) * 31;
            String str = this.titleText;
            int iHashCode2 = (((((i2 + (str != null ? str.hashCode() : 0)) * 31) + this.otherChannelsMentionsCount) * 31) + this.channelMentionsCount) * 31;
            boolean z4 = this.isConnectEnabled;
            ?? r4 = z4;
            if (z4) {
                r4 = 1;
            }
            int i3 = (iHashCode2 + r4) * 31;
            ParticipantsList participantsList = this.participantsList;
            int iHashCode3 = (i3 + (participantsList != null ? participantsList.hashCode() : 0)) * 31;
            boolean z5 = this.isNsfwUnconsented;
            ?? r5 = z5;
            if (z5) {
                r5 = 1;
            }
            int i4 = (iHashCode3 + r5) * 31;
            boolean z6 = this.isChannelNsfw;
            int i5 = (i4 + (z6 ? 1 : z6)) * 31;
            NsfwAllowance nsfwAllowance = this.nsfwAllowed;
            return i5 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0);
        }

        public final boolean isChannelNsfw() {
            return this.isChannelNsfw;
        }

        public final boolean isConnectEnabled() {
            return this.isConnectEnabled;
        }

        public final boolean isNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        public final boolean isTextInVoiceChannelSelected() {
            return this.isTextInVoiceChannelSelected;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(voiceChannel=");
            sbM833U.append(this.voiceChannel);
            sbM833U.append(", isTextInVoiceChannelSelected=");
            sbM833U.append(this.isTextInVoiceChannelSelected);
            sbM833U.append(", textInVoiceEnabled=");
            sbM833U.append(this.textInVoiceEnabled);
            sbM833U.append(", titleText=");
            sbM833U.append(this.titleText);
            sbM833U.append(", otherChannelsMentionsCount=");
            sbM833U.append(this.otherChannelsMentionsCount);
            sbM833U.append(", channelMentionsCount=");
            sbM833U.append(this.channelMentionsCount);
            sbM833U.append(", isConnectEnabled=");
            sbM833U.append(this.isConnectEnabled);
            sbM833U.append(", participantsList=");
            sbM833U.append(this.participantsList);
            sbM833U.append(", isNsfwUnconsented=");
            sbM833U.append(this.isNsfwUnconsented);
            sbM833U.append(", isChannelNsfw=");
            sbM833U.append(this.isChannelNsfw);
            sbM833U.append(", nsfwAllowed=");
            sbM833U.append(this.nsfwAllowed);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetCallPreviewFullscreenViewModel(long j, StoreChannels storeChannels, StoreMentions storeMentions, StoreNavigation storeNavigation, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannelsSelected storeChannelsSelected, StoreApplicationStreamPreviews storeApplicationStreamPreviews, StoreApplication storeApplication, StoreUser storeUser, Observable observable, StoreMediaSettings storeMediaSettings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreMentions mentions = (i & 4) != 0 ? StoreStream.INSTANCE.getMentions() : storeMentions;
        StoreNavigation navigation = (i & 8) != 0 ? StoreStream.INSTANCE.getNavigation() : storeNavigation;
        StoreUserSettings userSettings = (i & 16) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreChannelsSelected channelsSelected = (i & 64) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreApplicationStreamPreviews applicationStreamPreviews = (i & 128) != 0 ? StoreStream.INSTANCE.getApplicationStreamPreviews() : storeApplicationStreamPreviews;
        StoreApplication application = (i & 256) != 0 ? StoreStream.INSTANCE.getApplication() : storeApplication;
        StoreUser users = (i & 512) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        this(j, channels, mentions, navigation, userSettings, voiceChannelSelected, channelsSelected, applicationStreamPreviews, application, users, (i & 1024) != 0 ? INSTANCE.observeStoreState(j, users, channels, channelsSelected, mentions, voiceChannelSelected) : observable, (i & 2048) != 0 ? StoreStream.INSTANCE.getMediaSettings() : storeMediaSettings);
    }

    private final void handleStoreState(StoreState storeState) {
        ModelApplicationStream stream;
        if (storeState instanceof StoreState.Valid) {
            this.mostRecentStoreState = storeState;
            StoreState.Valid valid = (StoreState.Valid) storeState;
            Map<Long, EmbeddedActivity> embeddedActivitiesForChannel = valid.getCallModel().getEmbeddedActivitiesForChannel();
            StoreApplicationStreaming.ActiveApplicationStream activeStream = valid.getCallModel().getActiveStream();
            List<CallParticipantsAdapter.ListItem> listCreateConnectedListItems = ParticipantsListItemGenerator.INSTANCE.createConnectedListItems(valid.getCallModel().getParticipants(), (activeStream == null || (stream = activeStream.getStream()) == null) ? null : stream.getEncodedStreamKey(), valid.getVoiceChannel(), valid.getCallModel(), C12163u.toList(embeddedActivitiesForChannel.values()), valid.getCallModel().getApplications());
            Channel selectedVoiceChannel = valid.getSelectedVoiceChannel();
            if (selectedVoiceChannel != null) {
                long id2 = selectedVoiceChannel.getId();
                long j = this.voiceChannelId;
                if (id2 == j) {
                    this.eventSubject.f27650k.onNext(new Event.LaunchVideoCall(j, null));
                    return;
                }
            }
            Iterator<Long> it = embeddedActivitiesForChannel.keySet().iterator();
            while (it.hasNext()) {
                this.storeApplication.fetchIfNonexisting(it.next().longValue());
            }
            updateViewState(new ViewState(valid.getVoiceChannel(), ChannelUtils.m7675J(valid.getSelectedTextChannel()), valid.isTextInVoiceEnabled(), ChannelUtils.m7679c(valid.getVoiceChannel()), C11226f.coerceAtLeast(valid.getTotalMentionsCount() - valid.getChannelMentionsCount(), 0), valid.getChannelMentionsCount(), valid.getCallModel().getVoiceChannelJoinability() != VoiceChannelJoinability.PERMISSIONS_MISSING, ParticipantsListItemGenerator.INSTANCE.refreshStreams(listCreateConnectedListItems, this.fetchedPreviews, this.storeApplicationStreamPreviews) ? new ParticipantsList.ListItems(listCreateConnectedListItems) : new ParticipantsList.Empty(listCreateConnectedListItems), valid.isNsfwUnconsented(), valid.isChannelNsfw(), valid.getNsfwAllowed()));
        }
    }

    @MainThread
    private final void joinVoiceChannel(long channelId) {
        this.storeVoiceChannelSelected.selectVoiceChannel(channelId);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.LaunchVideoCall(this.voiceChannelId, null));
    }

    public static /* synthetic */ void tryConnectToVoice$default(WidgetCallPreviewFullscreenViewModel widgetCallPreviewFullscreenViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        widgetCallPreviewFullscreenViewModel.tryConnectToVoice(z2);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onStreamPreviewClicked(String streamKey) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null) {
            if (valid.getCallModel().getVoiceChannelJoinability() == VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY) {
                PublishSubject<Event> publishSubject = this.eventSubject;
                publishSubject.f27650k.onNext(Event.ShowGuildVideoAtCapacityDialog.INSTANCE);
            } else {
                ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey);
                PublishSubject<Event> publishSubject2 = this.eventSubject;
                publishSubject2.f27650k.onNext(new Event.LaunchVideoCall(modelApplicationStreamDecodeStreamKey.getChannelId(), streamKey));
            }
        }
    }

    @MainThread
    public final void onTextInVoiceTapped() {
        ChannelSelector companion = ChannelSelector.INSTANCE.getInstance();
        ViewState viewState = getViewState();
        ChannelSelector.selectChannel$default(companion, viewState != null ? viewState.getVoiceChannel() : null, null, SelectedChannelAnalyticsLocation.TEXT_IN_VOICE, 2, null);
        StoreNavigation.setNavigationPanelAction$default(this.storeNavigation, StoreNavigation.PanelAction.CLOSE, null, 2, null);
    }

    public final void selectTextChannelAfterFinish() {
        Channel voiceChannel;
        ViewState viewState = getViewState();
        if (viewState == null || (voiceChannel = viewState.getVoiceChannel()) == null) {
            return;
        }
        long guildId = voiceChannel.getGuildId();
        if (viewState.isTextInVoiceChannelSelected()) {
            ChannelSelector.INSTANCE.getInstance().selectPreviousChannel(guildId);
        }
    }

    @MainThread
    public final void tryConnectToVoice(boolean muted) {
        StoreState storeState = this.mostRecentStoreState;
        if (storeState instanceof StoreState.Valid) {
            if (((StoreState.Valid) storeState).getCallModel().getVoiceChannelJoinability() == VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY) {
                this.eventSubject.f27650k.onNext(Event.ShowGuildVideoAtCapacityDialog.INSTANCE);
                return;
            }
            if (!this.storeUserSettings.getIsMobileOverlayEnabled()) {
                this.eventSubject.f27650k.onNext(Event.ShowOverlayNux.INSTANCE);
            }
            if (muted) {
                this.mediaSettingsStore.setSelfMuted(true);
            }
            joinVoiceChannel(this.voiceChannelId);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetCallPreviewFullscreenViewModel(long j, StoreChannels storeChannels, StoreMentions storeMentions, StoreNavigation storeNavigation, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannelsSelected storeChannelsSelected, StoreApplicationStreamPreviews storeApplicationStreamPreviews, StoreApplication storeApplication, StoreUser storeUser, Observable<StoreState> observable, StoreMediaSettings storeMediaSettings) {
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeMentions, "storeMentions");
        C12238m.checkNotNullParameter(storeNavigation, "storeNavigation");
        C12238m.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        C12238m.checkNotNullParameter(storeVoiceChannelSelected, "storeVoiceChannelSelected");
        C12238m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        C12238m.checkNotNullParameter(storeApplicationStreamPreviews, "storeApplicationStreamPreviews");
        C12238m.checkNotNullParameter(storeApplication, "storeApplication");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        C12238m.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        DefaultConstructorMarker defaultConstructorMarker = null;
        super(defaultConstructorMarker, 1, defaultConstructorMarker);
        this.voiceChannelId = j;
        this.storeChannels = storeChannels;
        this.storeMentions = storeMentions;
        this.storeNavigation = storeNavigation;
        this.storeUserSettings = storeUserSettings;
        this.storeVoiceChannelSelected = storeVoiceChannelSelected;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeApplicationStreamPreviews = storeApplicationStreamPreviews;
        this.storeApplication = storeApplication;
        this.storeUser = storeUser;
        this.mediaSettingsStore = storeMediaSettings;
        this.eventSubject = PublishSubject.m11133k0();
        this.fetchedPreviews = new LinkedHashSet();
        Observable observableM11112r = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableM11112r, (Class<?>) WidgetCallPreviewFullscreenViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C105451());
    }
}
