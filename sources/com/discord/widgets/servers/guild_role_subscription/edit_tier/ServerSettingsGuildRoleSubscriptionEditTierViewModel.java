package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.ImageAsset;
import com.discord.api.guildrolesubscription.SubscriptionTrial;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.nullserializable.NullSerializable;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils2;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionEditTierViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private NullSerializable<Integer> editedActiveTrialUserLimit;
    private Boolean editedCanAccessAllChannelsFlag;
    private List<Benefit.ChannelBenefit> editedChannelBenefits;
    private List<Benefit.IntangibleBenefit> editedIntangibleBenefits;
    private Integer editedMemberColor;
    private String editedMemberIcon;
    private String editedTierDescription;
    private String editedTierImage;
    private String editedTierName;
    private Integer editedTierPrice;
    private NullSerializable<SubscriptionTrialInterval> editedTrialInterval;
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final long guildRoleSubscriptionGroupListingId;
    private final long guildRoleSubscriptionTierListingId;
    private Boolean isFullServerGating;
    private final RestAPI restApi;
    private final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions;
    private GuildRoleSubscriptionTier storedGuildRoleSubscriptionTier;

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            ServerSettingsGuildRoleSubscriptionEditTierViewModel serverSettingsGuildRoleSubscriptionEditTierViewModel = ServerSettingsGuildRoleSubscriptionEditTierViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            serverSettingsGuildRoleSubscriptionEditTierViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, long guildRoleSubscriptionTierListingId, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreChannels storeChannels, StoreEmoji storeEmoji, StoreGuilds storeGuilds) {
            Observable<StoreState> observableJ = Observable.j(storeEmoji.getEmojiSet(new StoreEmoji.EmojiContext.Guild(guildId), false, false), ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuildRoleSubscriptions, storeChannels, storeGuilds}, false, null, null, new ServerSettingsGuildRoleSubscriptionEditTierViewModel2(storeGuildRoleSubscriptions, guildId, storeChannels, storeGuilds, guildRoleSubscriptionTierListingId), 14, null), new Func2<EmojiSet, Tuples2<? extends GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>>, StoreState>() { // from class: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion$observeStoreState$2
                @Override // rx.functions.Func2
                public /* bridge */ /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel.StoreState call(EmojiSet emojiSet, Tuples2<? extends ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>> tuples2) {
                    return call2(emojiSet, (Tuples2<ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, Channel>>) tuples2);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final ServerSettingsGuildRoleSubscriptionEditTierViewModel.StoreState call2(EmojiSet emojiSet, Tuples2<ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, Channel>> tuples2) {
                    ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreDataComponent1 = tuples2.component1();
                    Map<Long, Channel> mapComponent2 = tuples2.component2();
                    Intrinsics3.checkNotNullExpressionValue(emojiSet, "emojiSet");
                    return new ServerSettingsGuildRoleSubscriptionEditTierViewModel.StoreState(mapComponent2, emojiSet, guildRoleSubscriptionStoreDataComponent1);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…oreData\n        )\n      }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        public static final /* data */ class DeleteFailure extends Event {
            private final Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DeleteFailure(Error error) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ DeleteFailure copy$default(DeleteFailure deleteFailure, Error error, int i, Object obj) {
                if ((i & 1) != 0) {
                    error = deleteFailure.error;
                }
                return deleteFailure.copy(error);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            public final DeleteFailure copy(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                return new DeleteFailure(error);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof DeleteFailure) && Intrinsics3.areEqual(this.error, ((DeleteFailure) other).error);
                }
                return true;
            }

            public final Error getError() {
                return this.error;
            }

            public int hashCode() {
                Error error = this.error;
                if (error != null) {
                    return error.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("DeleteFailure(error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        public static final class DeleteSuccess extends Event {
            public static final DeleteSuccess INSTANCE = new DeleteSuccess();

            private DeleteSuccess() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        public static final /* data */ class StoredStateUpdate extends Event {
            private final GuildRoleSubscriptionTier guildRoleSubscriptionTier;
            private final boolean isFullServerGating;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StoredStateUpdate(GuildRoleSubscriptionTier guildRoleSubscriptionTier, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
                this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
                this.isFullServerGating = z2;
            }

            public static /* synthetic */ StoredStateUpdate copy$default(StoredStateUpdate storedStateUpdate, GuildRoleSubscriptionTier guildRoleSubscriptionTier, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildRoleSubscriptionTier = storedStateUpdate.guildRoleSubscriptionTier;
                }
                if ((i & 2) != 0) {
                    z2 = storedStateUpdate.isFullServerGating;
                }
                return storedStateUpdate.copy(guildRoleSubscriptionTier, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
                return this.guildRoleSubscriptionTier;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsFullServerGating() {
                return this.isFullServerGating;
            }

            public final StoredStateUpdate copy(GuildRoleSubscriptionTier guildRoleSubscriptionTier, boolean isFullServerGating) {
                Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
                return new StoredStateUpdate(guildRoleSubscriptionTier, isFullServerGating);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StoredStateUpdate)) {
                    return false;
                }
                StoredStateUpdate storedStateUpdate = (StoredStateUpdate) other;
                return Intrinsics3.areEqual(this.guildRoleSubscriptionTier, storedStateUpdate.guildRoleSubscriptionTier) && this.isFullServerGating == storedStateUpdate.isFullServerGating;
            }

            public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
                return this.guildRoleSubscriptionTier;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                GuildRoleSubscriptionTier guildRoleSubscriptionTier = this.guildRoleSubscriptionTier;
                int iHashCode = (guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.hashCode() : 0) * 31;
                boolean z2 = this.isFullServerGating;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public final boolean isFullServerGating() {
                return this.isFullServerGating;
            }

            public String toString() {
                StringBuilder sbU = outline.U("StoredStateUpdate(guildRoleSubscriptionTier=");
                sbU.append(this.guildRoleSubscriptionTier);
                sbU.append(", isFullServerGating=");
                return outline.O(sbU, this.isFullServerGating, ")");
            }
        }

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        public static final /* data */ class SubmitFailure extends Event {
            private final Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SubmitFailure(Error error) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ SubmitFailure copy$default(SubmitFailure submitFailure, Error error, int i, Object obj) {
                if ((i & 1) != 0) {
                    error = submitFailure.error;
                }
                return submitFailure.copy(error);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            public final SubmitFailure copy(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                return new SubmitFailure(error);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SubmitFailure) && Intrinsics3.areEqual(this.error, ((SubmitFailure) other).error);
                }
                return true;
            }

            public final Error getError() {
                return this.error;
            }

            public int hashCode() {
                Error error = this.error;
                if (error != null) {
                    return error.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SubmitFailure(error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        public static final class SubmitSuccess extends Event {
            public static final SubmitSuccess INSTANCE = new SubmitSuccess();

            private SubmitSuccess() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    public static final /* data */ class GuildRoleSubscriptionStoreData {
        private final GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionFreeTrial;
        private final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupListingState;
        private final Map<Long, GuildRole> guildRoles;

        public GuildRoleSubscriptionStoreData(StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState, Map<Long, GuildRole> map, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
            this.guildRoleSubscriptionGroupListingState = guildRoleSubscriptionGroupState;
            this.guildRoles = map;
            this.guildRoleSubscriptionFreeTrial = guildRoleSubscriptionTierFreeTrial;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildRoleSubscriptionStoreData copy$default(GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData, StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState, Map map, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionGroupState = guildRoleSubscriptionStoreData.guildRoleSubscriptionGroupListingState;
            }
            if ((i & 2) != 0) {
                map = guildRoleSubscriptionStoreData.guildRoles;
            }
            if ((i & 4) != 0) {
                guildRoleSubscriptionTierFreeTrial = guildRoleSubscriptionStoreData.guildRoleSubscriptionFreeTrial;
            }
            return guildRoleSubscriptionStoreData.copy(guildRoleSubscriptionGroupState, map, guildRoleSubscriptionTierFreeTrial);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupListingState() {
            return this.guildRoleSubscriptionGroupListingState;
        }

        public final Map<Long, GuildRole> component2() {
            return this.guildRoles;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final GuildRoleSubscriptionTierFreeTrial getGuildRoleSubscriptionFreeTrial() {
            return this.guildRoleSubscriptionFreeTrial;
        }

        public final GuildRoleSubscriptionStoreData copy(StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupListingState, Map<Long, GuildRole> guildRoles, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionFreeTrial) {
            return new GuildRoleSubscriptionStoreData(guildRoleSubscriptionGroupListingState, guildRoles, guildRoleSubscriptionFreeTrial);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildRoleSubscriptionStoreData)) {
                return false;
            }
            GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData = (GuildRoleSubscriptionStoreData) other;
            return Intrinsics3.areEqual(this.guildRoleSubscriptionGroupListingState, guildRoleSubscriptionStoreData.guildRoleSubscriptionGroupListingState) && Intrinsics3.areEqual(this.guildRoles, guildRoleSubscriptionStoreData.guildRoles) && Intrinsics3.areEqual(this.guildRoleSubscriptionFreeTrial, guildRoleSubscriptionStoreData.guildRoleSubscriptionFreeTrial);
        }

        public final GuildRoleSubscriptionTierFreeTrial getGuildRoleSubscriptionFreeTrial() {
            return this.guildRoleSubscriptionFreeTrial;
        }

        public final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupListingState() {
            return this.guildRoleSubscriptionGroupListingState;
        }

        public final Map<Long, GuildRole> getGuildRoles() {
            return this.guildRoles;
        }

        public int hashCode() {
            StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState = this.guildRoleSubscriptionGroupListingState;
            int iHashCode = (guildRoleSubscriptionGroupState != null ? guildRoleSubscriptionGroupState.hashCode() : 0) * 31;
            Map<Long, GuildRole> map = this.guildRoles;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial = this.guildRoleSubscriptionFreeTrial;
            return iHashCode2 + (guildRoleSubscriptionTierFreeTrial != null ? guildRoleSubscriptionTierFreeTrial.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildRoleSubscriptionStoreData(guildRoleSubscriptionGroupListingState=");
            sbU.append(this.guildRoleSubscriptionGroupListingState);
            sbU.append(", guildRoles=");
            sbU.append(this.guildRoles);
            sbU.append(", guildRoleSubscriptionFreeTrial=");
            sbU.append(this.guildRoleSubscriptionFreeTrial);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    public static final /* data */ class StoreState {
        private final Map<Long, Channel> channels;
        private final EmojiSet guildEmojis;
        private final GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData;

        public StoreState(Map<Long, Channel> map, EmojiSet emojiSet, GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData) {
            Intrinsics3.checkNotNullParameter(map, "channels");
            Intrinsics3.checkNotNullParameter(emojiSet, "guildEmojis");
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionStoreData, "guildRoleSubscriptionStoreData");
            this.channels = map;
            this.guildEmojis = emojiSet;
            this.guildRoleSubscriptionStoreData = guildRoleSubscriptionStoreData;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, Map map, EmojiSet emojiSet, GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData, int i, Object obj) {
            if ((i & 1) != 0) {
                map = storeState.channels;
            }
            if ((i & 2) != 0) {
                emojiSet = storeState.guildEmojis;
            }
            if ((i & 4) != 0) {
                guildRoleSubscriptionStoreData = storeState.guildRoleSubscriptionStoreData;
            }
            return storeState.copy(map, emojiSet, guildRoleSubscriptionStoreData);
        }

        public final Map<Long, Channel> component1() {
            return this.channels;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final EmojiSet getGuildEmojis() {
            return this.guildEmojis;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final GuildRoleSubscriptionStoreData getGuildRoleSubscriptionStoreData() {
            return this.guildRoleSubscriptionStoreData;
        }

        public final StoreState copy(Map<Long, Channel> channels, EmojiSet guildEmojis, GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData) {
            Intrinsics3.checkNotNullParameter(channels, "channels");
            Intrinsics3.checkNotNullParameter(guildEmojis, "guildEmojis");
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionStoreData, "guildRoleSubscriptionStoreData");
            return new StoreState(channels, guildEmojis, guildRoleSubscriptionStoreData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.channels, storeState.channels) && Intrinsics3.areEqual(this.guildEmojis, storeState.guildEmojis) && Intrinsics3.areEqual(this.guildRoleSubscriptionStoreData, storeState.guildRoleSubscriptionStoreData);
        }

        public final Map<Long, Channel> getChannels() {
            return this.channels;
        }

        public final EmojiSet getGuildEmojis() {
            return this.guildEmojis;
        }

        public final GuildRoleSubscriptionStoreData getGuildRoleSubscriptionStoreData() {
            return this.guildRoleSubscriptionStoreData;
        }

        public int hashCode() {
            Map<Long, Channel> map = this.channels;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            EmojiSet emojiSet = this.guildEmojis;
            int iHashCode2 = (iHashCode + (emojiSet != null ? emojiSet.hashCode() : 0)) * 31;
            GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData = this.guildRoleSubscriptionStoreData;
            return iHashCode2 + (guildRoleSubscriptionStoreData != null ? guildRoleSubscriptionStoreData.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(channels=");
            sbU.append(this.channels);
            sbU.append(", guildEmojis=");
            sbU.append(this.guildEmojis);
            sbU.append(", guildRoleSubscriptionStoreData=");
            sbU.append(this.guildRoleSubscriptionStoreData);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        public static final class Failed extends ViewState {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean hasChanges;
            private final boolean isPublished;
            private final boolean isSubmitting;
            private final String tierName;

            public Loaded() {
                this(false, false, null, false, 15, null);
            }

            public /* synthetic */ Loaded(boolean z2, boolean z3, String str, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? null : str, (i & 8) != 0 ? false : z4);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, boolean z2, boolean z3, String str, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = loaded.hasChanges;
                }
                if ((i & 2) != 0) {
                    z3 = loaded.isPublished;
                }
                if ((i & 4) != 0) {
                    str = loaded.tierName;
                }
                if ((i & 8) != 0) {
                    z4 = loaded.isSubmitting;
                }
                return loaded.copy(z2, z3, str, z4);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getHasChanges() {
                return this.hasChanges;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsPublished() {
                return this.isPublished;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getTierName() {
                return this.tierName;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsSubmitting() {
                return this.isSubmitting;
            }

            public final Loaded copy(boolean hasChanges, boolean isPublished, String tierName, boolean isSubmitting) {
                return new Loaded(hasChanges, isPublished, tierName, isSubmitting);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.hasChanges == loaded.hasChanges && this.isPublished == loaded.isPublished && Intrinsics3.areEqual(this.tierName, loaded.tierName) && this.isSubmitting == loaded.isSubmitting;
            }

            public final boolean getHasChanges() {
                return this.hasChanges;
            }

            public final String getTierName() {
                return this.tierName;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r0v7, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8 */
            /* JADX WARN: Type inference failed for: r0v9 */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v7 */
            /* JADX WARN: Type inference failed for: r2v8 */
            public int hashCode() {
                boolean z2 = this.hasChanges;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean z3 = this.isPublished;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                String str = this.tierName;
                int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
                boolean z4 = this.isSubmitting;
                return iHashCode + (z4 ? 1 : z4);
            }

            public final boolean isPublished() {
                return this.isPublished;
            }

            public final boolean isSubmitting() {
                return this.isSubmitting;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(hasChanges=");
                sbU.append(this.hasChanges);
                sbU.append(", isPublished=");
                sbU.append(this.isPublished);
                sbU.append(", tierName=");
                sbU.append(this.tierName);
                sbU.append(", isSubmitting=");
                return outline.O(sbU, this.isSubmitting, ")");
            }

            public Loaded(boolean z2, boolean z3, String str, boolean z4) {
                super(null);
                this.hasChanges = z2;
                this.isPublished = z3;
                this.tierName = str;
                this.isSubmitting = z4;
            }
        }

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildRoleSubscriptionBenefitType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildRoleSubscriptionBenefitType.INTANGIBLE.ordinal()] = 1;
            iArr[GuildRoleSubscriptionBenefitType.CHANNEL.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$deleteTier$1, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r8) {
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.this.updateViewState(ViewState.Loaded.copy$default(this.$viewState, false, false, null, false, 7, null));
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.this.emitEvent(Event.DeleteSuccess.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$deleteTier$2, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.this.updateViewState(ViewState.Loaded.copy$default(this.$viewState, false, false, null, false, 7, null));
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.this.emitEvent(new Event.DeleteFailure(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$publishTier$1, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionTierListing, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            invoke2(guildRoleSubscriptionTierListing);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierListing, "it");
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.this.updateViewState(ViewState.Loaded.copy$default(this.$viewState, false, false, null, false, 7, null));
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.this.emitEvent(Event.SubmitSuccess.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$publishTier$2, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.this.updateViewState(ViewState.Loaded.copy$default(this.$viewState, false, false, null, false, 7, null));
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.this.emitEvent(new Event.SubmitFailure(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$submitChanges$2, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildRoleSubscriptionTierListing, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            invoke2(guildRoleSubscriptionTierListing);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierListing, "it");
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.this.updateViewState(ViewState.Loaded.copy$default(this.$viewState, false, false, null, false, 6, null));
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.this.emitEvent(Event.SubmitSuccess.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$submitChanges$3, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.this.updateViewState(ViewState.Loaded.copy$default(this.$viewState, false, false, null, false, 7, null));
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.this.emitEvent(new Event.SubmitFailure(error));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel(long j, long j2, long j3, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreChannels storeChannels, StoreEmoji storeEmoji, StoreGuilds storeGuilds, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreGuildRoleSubscriptions guildRoleSubscriptions = (i & 16) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions;
        StoreChannels channels = (i & 32) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreEmoji emojis = (i & 64) != 0 ? StoreStream.INSTANCE.getEmojis() : storeEmoji;
        StoreGuilds guilds = (i & 128) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        this(j, j2, j3, api, guildRoleSubscriptions, channels, emojis, guilds, (i & 256) != 0 ? INSTANCE.observeStoreState(j, j2, ObservationDeck4.get(), guildRoleSubscriptions, channels, emojis, guilds) : observable);
    }

    @MainThread
    private final void emitEvent(Event event) {
        this.eventSubject.k.onNext(event);
    }

    private final void handleLoadedStoreState(StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded storeState, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial, Map<Long, Channel> channels, EmojiSet emojiSet, Map<Long, GuildRole> guildRoles) {
        List<GuildRoleSubscriptionTierListing> listH;
        Object next;
        String emojiName;
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = storeState.getGuildRoleSubscriptionGroupListing();
        if (guildRoleSubscriptionGroupListing == null || (listH = guildRoleSubscriptionGroupListing.h()) == null) {
            return;
        }
        Iterator<T> it = listH.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((GuildRoleSubscriptionTierListing) next).getId() == this.guildRoleSubscriptionTierListingId));
        GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing = (GuildRoleSubscriptionTierListing) next;
        if (guildRoleSubscriptionTierListing != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (GuildRoleSubscriptionBenefit guildRoleSubscriptionBenefit : guildRoleSubscriptionTierListing.getRoleBenefits().a()) {
                Long emojiId = guildRoleSubscriptionBenefit.getEmojiId();
                if (emojiId == null || (emojiName = String.valueOf(emojiId.longValue())) == null) {
                    emojiName = guildRoleSubscriptionBenefit.getEmojiName();
                }
                Emoji emoji = emojiSet.emojiIndex.get(emojiName);
                if (emoji != null) {
                    int iOrdinal = guildRoleSubscriptionBenefit.getRefType().ordinal();
                    if (iOrdinal == 1) {
                        Channel channel = channels.get(guildRoleSubscriptionBenefit.getRefId());
                        if (channel != null) {
                            arrayList.add(new Benefit.ChannelBenefit(ChannelUtils.c(channel), emoji, guildRoleSubscriptionBenefit.getDescription(), Integer.valueOf(GuildChannelIconUtils2.guildChannelIcon(channel)), channel.getId()));
                        }
                    } else if (iOrdinal == 2) {
                        arrayList2.add(new Benefit.IntangibleBenefit(guildRoleSubscriptionBenefit.getName(), emoji, guildRoleSubscriptionBenefit.getDescription()));
                    }
                }
            }
            GuildRole guildRole = guildRoles != null ? guildRoles.get(Long.valueOf(guildRoleSubscriptionTierListing.getRoleId())) : null;
            ViewState viewStateRequireViewState = requireViewState();
            if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
                viewStateRequireViewState = null;
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
            boolean zIsSubmitting = loaded != null ? loaded.isSubmitting() : false;
            boolean hasChanges = loaded != null ? loaded.getHasChanges() : false;
            if (hasChanges) {
                updateViewState(new ViewState.Loaded(hasChanges, guildRoleSubscriptionTierListing.getPublished(), null, false, 12, null));
                return;
            }
            Integer numValueOf = ((guildRole != null ? Integer.valueOf(guildRole.getColor()) : null) == null || guildRole.getColor() == 0) ? null : Integer.valueOf(RoleUtils.getOpaqueColor(guildRole));
            boolean zCanRole = PermissionUtils.INSTANCE.canRole(Permission.VIEW_CHANNEL, guildRole, null);
            SubscriptionTrial activeTrial = guildRoleSubscriptionTierFreeTrial != null ? guildRoleSubscriptionTierFreeTrial.getActiveTrial() : null;
            SubscriptionTrialInterval subscriptionTrialInterval = activeTrial != null ? new SubscriptionTrialInterval(activeTrial.getInterval(), activeTrial.getIntervalCount()) : null;
            String name = guildRoleSubscriptionTierListing.getName();
            Long lValueOf = Long.valueOf(guildRoleSubscriptionTierListing.getApplicationId());
            String description = guildRoleSubscriptionTierListing.getDescription();
            ImageAsset imageAsset = guildRoleSubscriptionTierListing.getImageAsset();
            GuildRoleSubscriptionTier guildRoleSubscriptionTier = new GuildRoleSubscriptionTier(name, lValueOf, Integer.valueOf(GuildRoleSubscriptionUtils2.getPrice(guildRoleSubscriptionTierListing)), numValueOf, null, guildRole, null, imageAsset != null ? Long.valueOf(imageAsset.getId()) : null, description, Boolean.valueOf(guildRoleSubscriptionTierListing.getPublished()), Boolean.valueOf(zCanRole), arrayList, arrayList2, subscriptionTrialInterval, guildRoleSubscriptionTierFreeTrial != null ? guildRoleSubscriptionTierFreeTrial.getMaxNumActiveTrialUsers() : null, 80, null);
            Boolean fullServerGatingOverwrite = GuildRoleSubscriptionUtils2.getFullServerGatingOverwrite(storeState.getGuildRoleSubscriptionGroupListing(), guildRoles);
            boolean zBooleanValue = fullServerGatingOverwrite != null ? fullServerGatingOverwrite.booleanValue() : storeState.getGuildRoleSubscriptionGroupListing().getFullServerGate();
            this.isFullServerGating = Boolean.valueOf(zBooleanValue);
            this.storedGuildRoleSubscriptionTier = guildRoleSubscriptionTier;
            this.eventSubject.k.onNext(new Event.StoredStateUpdate(guildRoleSubscriptionTier, zBooleanValue));
            updateViewState(new ViewState.Loaded(false, guildRoleSubscriptionTierListing.getPublished(), guildRoleSubscriptionTierListing.getName(), zIsSubmitting, 1, null));
        }
    }

    private final void handleStoreState(StoreState storeState) {
        StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupListingState = storeState.getGuildRoleSubscriptionStoreData().getGuildRoleSubscriptionGroupListingState();
        if (guildRoleSubscriptionGroupListingState != null) {
            if (guildRoleSubscriptionGroupListingState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loading) {
                updateViewState(ViewState.Loading.INSTANCE);
            } else if (guildRoleSubscriptionGroupListingState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded) {
                handleLoadedStoreState((StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded) guildRoleSubscriptionGroupListingState, storeState.getGuildRoleSubscriptionStoreData().getGuildRoleSubscriptionFreeTrial(), storeState.getChannels(), storeState.getGuildEmojis(), storeState.getGuildRoleSubscriptionStoreData().getGuildRoles());
            } else if (guildRoleSubscriptionGroupListingState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Failed) {
                updateViewState(ViewState.Failed.INSTANCE);
            }
        }
    }

    public final void deleteTier() {
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, null, true, 7, null));
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.INSTANCE.deleteGuildRoleSubscriptionTierListing(this.restApi, this.storeGuildRoleSubscriptions, this.guildId, this.guildRoleSubscriptionGroupListingId, this.guildRoleSubscriptionTierListingId), this, null, 2, null), (Class<?>) ServerSettingsGuildRoleSubscriptionEditTierViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2(loaded)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(loaded));
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    /* JADX WARN: Code duplicated, block: B:36:0x0074  */
    public final void onTierUpdated(GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        boolean z2;
        boolean z3;
        String name;
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        if (loaded != null) {
            String name2 = guildRoleSubscriptionTier.getName();
            GuildRoleSubscriptionTier guildRoleSubscriptionTier2 = this.storedGuildRoleSubscriptionTier;
            if (!Intrinsics3.areEqual(name2, guildRoleSubscriptionTier2 != null ? guildRoleSubscriptionTier2.getName() : null)) {
                String name3 = guildRoleSubscriptionTier.getName();
                if (name3 == null || StringsJVM.isBlank(name3)) {
                    this.editedTierName = null;
                    z2 = false;
                } else {
                    this.editedTierName = guildRoleSubscriptionTier.getName();
                    z2 = true;
                }
            } else {
                this.editedTierName = null;
                z2 = false;
            }
            String description = guildRoleSubscriptionTier.getDescription();
            GuildRoleSubscriptionTier guildRoleSubscriptionTier3 = this.storedGuildRoleSubscriptionTier;
            if (!Intrinsics3.areEqual(description, guildRoleSubscriptionTier3 != null ? guildRoleSubscriptionTier3.getDescription() : null)) {
                String description2 = guildRoleSubscriptionTier.getDescription();
                if (description2 == null || StringsJVM.isBlank(description2)) {
                    this.editedTierDescription = null;
                } else {
                    this.editedTierDescription = guildRoleSubscriptionTier.getDescription();
                    z2 = true;
                }
            } else {
                this.editedTierDescription = null;
            }
            if (guildRoleSubscriptionTier.getImage() != null) {
                this.editedTierImage = guildRoleSubscriptionTier.getImage();
                z2 = true;
            } else {
                this.editedTierImage = null;
            }
            Integer priceTier = guildRoleSubscriptionTier.getPriceTier();
            GuildRoleSubscriptionTier guildRoleSubscriptionTier4 = this.storedGuildRoleSubscriptionTier;
            if (!Intrinsics3.areEqual(priceTier, guildRoleSubscriptionTier4 != null ? guildRoleSubscriptionTier4.getPriceTier() : null)) {
                this.editedTierPrice = guildRoleSubscriptionTier.getPriceTier();
                z2 = true;
            } else {
                this.editedTierPrice = null;
            }
            Integer memberColor = guildRoleSubscriptionTier.getMemberColor();
            GuildRoleSubscriptionTier guildRoleSubscriptionTier5 = this.storedGuildRoleSubscriptionTier;
            if (!Intrinsics3.areEqual(memberColor, guildRoleSubscriptionTier5 != null ? guildRoleSubscriptionTier5.getMemberColor() : null)) {
                this.editedMemberColor = guildRoleSubscriptionTier.getMemberColor();
                z2 = true;
            } else {
                this.editedMemberColor = null;
            }
            if (guildRoleSubscriptionTier.getMemberIcon() != null) {
                this.editedMemberIcon = guildRoleSubscriptionTier.getMemberIcon();
                z2 = true;
            } else {
                this.editedMemberIcon = null;
            }
            List<Benefit.ChannelBenefit> channelBenefits = guildRoleSubscriptionTier.getChannelBenefits();
            GuildRoleSubscriptionTier guildRoleSubscriptionTier6 = this.storedGuildRoleSubscriptionTier;
            if (!Intrinsics3.areEqual(channelBenefits, guildRoleSubscriptionTier6 != null ? guildRoleSubscriptionTier6.getChannelBenefits() : null)) {
                this.editedChannelBenefits = guildRoleSubscriptionTier.getChannelBenefits();
                z2 = true;
            } else {
                this.editedChannelBenefits = null;
            }
            List<Benefit.IntangibleBenefit> intangibleBenefits = guildRoleSubscriptionTier.getIntangibleBenefits();
            GuildRoleSubscriptionTier guildRoleSubscriptionTier7 = this.storedGuildRoleSubscriptionTier;
            if (!Intrinsics3.areEqual(intangibleBenefits, guildRoleSubscriptionTier7 != null ? guildRoleSubscriptionTier7.getIntangibleBenefits() : null)) {
                this.editedIntangibleBenefits = guildRoleSubscriptionTier.getIntangibleBenefits();
                z2 = true;
            } else {
                this.editedIntangibleBenefits = null;
            }
            boolean zCanAccessAllChannelsOrDefault = guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(this.isFullServerGating);
            GuildRoleSubscriptionTier guildRoleSubscriptionTier8 = this.storedGuildRoleSubscriptionTier;
            if (guildRoleSubscriptionTier8 == null || zCanAccessAllChannelsOrDefault != guildRoleSubscriptionTier8.canAccessAllChannelsOrDefault(this.isFullServerGating)) {
                this.editedCanAccessAllChannelsFlag = Boolean.valueOf(guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(this.isFullServerGating));
                z2 = true;
            } else {
                this.editedCanAccessAllChannelsFlag = null;
            }
            SubscriptionTrialInterval trialInterval = guildRoleSubscriptionTier.getTrialInterval();
            GuildRoleSubscriptionTier guildRoleSubscriptionTier9 = this.storedGuildRoleSubscriptionTier;
            if (!Intrinsics3.areEqual(trialInterval, guildRoleSubscriptionTier9 != null ? guildRoleSubscriptionTier9.getTrialInterval() : null)) {
                this.editedTrialInterval = guildRoleSubscriptionTier.getTrialInterval() == null ? new NullSerializable.a<>(null, 1) : new NullSerializable.b<>(guildRoleSubscriptionTier.getTrialInterval());
                z2 = true;
            } else {
                this.editedTrialInterval = null;
            }
            Integer activeTrialUserLimit = guildRoleSubscriptionTier.getActiveTrialUserLimit();
            GuildRoleSubscriptionTier guildRoleSubscriptionTier10 = this.storedGuildRoleSubscriptionTier;
            if (!Intrinsics3.areEqual(activeTrialUserLimit, guildRoleSubscriptionTier10 != null ? guildRoleSubscriptionTier10.getActiveTrialUserLimit() : null)) {
                this.editedActiveTrialUserLimit = guildRoleSubscriptionTier.getActiveTrialUserLimit() == null ? new NullSerializable.a<>(null, 1) : new NullSerializable.b(guildRoleSubscriptionTier.getActiveTrialUserLimit());
                z3 = true;
            } else {
                this.editedActiveTrialUserLimit = null;
                z3 = z2;
            }
            String str = this.editedTierName;
            if (str != null) {
                name = str;
            } else {
                GuildRoleSubscriptionTier guildRoleSubscriptionTier11 = this.storedGuildRoleSubscriptionTier;
                name = guildRoleSubscriptionTier11 != null ? guildRoleSubscriptionTier11.getName() : null;
            }
            updateViewState(ViewState.Loaded.copy$default(loaded, z3, false, name, false, 10, null));
        }
    }

    public final void publishTier() {
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, null, true, 7, null));
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.INSTANCE.updateGuildRoleSubscriptionTierListing(this.restApi, this.storeGuildRoleSubscriptions, this.guildId, this.guildRoleSubscriptionGroupListingId, this.guildRoleSubscriptionTierListingId, (114656 & 32) != 0 ? null : null, (114656 & 64) != 0 ? null : null, (114656 & 128) != 0 ? null : null, (114656 & 256) != 0 ? null : null, (114656 & 512) != 0 ? null : null, (114656 & 1024) != 0 ? null : null, (114656 & 2048) != 0 ? null : null, (114656 & 4096) != 0 ? null : null, (114656 & 8192) != 0 ? null : null, (114656 & 16384) != 0 ? null : Boolean.TRUE, (32768 & 114656) != 0 ? null : null, (114656 & 65536) != 0 ? null : null), this, null, 2, null), (Class<?>) ServerSettingsGuildRoleSubscriptionEditTierViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2(loaded)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(loaded));
        }
    }

    public final void submitChanges() {
        Integer numValueOf;
        List<Benefit.ChannelBenefit> list;
        List<Benefit.IntangibleBenefit> list2;
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        if (loaded != null) {
            Integer num = this.editedMemberColor;
            if (num != null) {
                numValueOf = Integer.valueOf(ColorCompat.INSTANCE.removeAlphaComponent(num.intValue()));
            } else {
                numValueOf = null;
            }
            GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
            RestAPI restAPI = this.restApi;
            StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.storeGuildRoleSubscriptions;
            long j = this.guildId;
            long j2 = this.guildRoleSubscriptionGroupListingId;
            long j3 = this.guildRoleSubscriptionTierListingId;
            String str = this.editedTierName;
            String str2 = this.editedTierDescription;
            String str3 = this.editedTierImage;
            Integer num2 = this.editedTierPrice;
            String str4 = this.editedMemberIcon;
            Boolean bool = this.editedCanAccessAllChannelsFlag;
            List<Benefit.ChannelBenefit> channelBenefits = this.editedChannelBenefits;
            if (channelBenefits == null) {
                GuildRoleSubscriptionTier guildRoleSubscriptionTier = this.storedGuildRoleSubscriptionTier;
                if (guildRoleSubscriptionTier != null) {
                    channelBenefits = guildRoleSubscriptionTier.getChannelBenefits();
                    list = channelBenefits;
                } else {
                    list = null;
                }
            } else {
                list = channelBenefits;
            }
            List<Benefit.IntangibleBenefit> intangibleBenefits = this.editedIntangibleBenefits;
            if (intangibleBenefits == null) {
                GuildRoleSubscriptionTier guildRoleSubscriptionTier2 = this.storedGuildRoleSubscriptionTier;
                if (guildRoleSubscriptionTier2 != null) {
                    intangibleBenefits = guildRoleSubscriptionTier2.getIntangibleBenefits();
                    list2 = intangibleBenefits;
                } else {
                    list2 = null;
                }
            } else {
                list2 = intangibleBenefits;
            }
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(guildRoleSubscriptionUtils.updateGuildRoleSubscriptionTierListing(restAPI, storeGuildRoleSubscriptions, j, j2, j3, (114656 & 32) != 0 ? null : str, (114656 & 64) != 0 ? null : str2, (114656 & 128) != 0 ? null : str3, (114656 & 256) != 0 ? null : num2, (114656 & 512) != 0 ? null : numValueOf, (114656 & 1024) != 0 ? null : str4, (114656 & 2048) != 0 ? null : bool, (114656 & 4096) != 0 ? null : list, (114656 & 8192) != 0 ? null : list2, (114656 & 16384) != 0 ? null : null, (32768 & 114656) != 0 ? null : this.editedTrialInterval, (114656 & 65536) != 0 ? null : this.editedActiveTrialUserLimit), this, null, 2, null), (Class<?>) ServerSettingsGuildRoleSubscriptionEditTierViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3(loaded)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(loaded));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionEditTierViewModel(long j, long j2, long j3, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreChannels storeChannels, StoreEmoji storeEmoji, StoreGuilds storeGuilds, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeEmoji, "storeEmoji");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.guildRoleSubscriptionTierListingId = j2;
        this.guildRoleSubscriptionGroupListingId = j3;
        this.restApi = restAPI;
        this.storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.eventSubject = PublishSubject.k0();
        storeGuildRoleSubscriptions.fetchGuildRoleSubscriptionGroupsForGuild(j);
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) ServerSettingsGuildRoleSubscriptionEditTierViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
