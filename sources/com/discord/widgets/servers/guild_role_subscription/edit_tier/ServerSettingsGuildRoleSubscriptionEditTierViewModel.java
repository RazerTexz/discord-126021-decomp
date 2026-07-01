package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
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
import com.discord.nullserializable.NullSerializable$a;
import com.discord.nullserializable.NullSerializable$b;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Failed;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loading;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.channel.GuildChannelIconUtilsKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtilsKt;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit$ChannelBenefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit$IntangibleBenefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.g0.t;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionEditTierViewModel extends d0<ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState> {
    public static final ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion Companion = new ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion(null);
    private NullSerializable<Integer> editedActiveTrialUserLimit;
    private Boolean editedCanAccessAllChannelsFlag;
    private List<Benefit$ChannelBenefit> editedChannelBenefits;
    private List<Benefit$IntangibleBenefit> editedIntangibleBenefits;
    private Integer editedMemberColor;
    private String editedMemberIcon;
    private String editedTierDescription;
    private String editedTierImage;
    private String editedTierName;
    private Integer editedTierPrice;
    private NullSerializable<SubscriptionTrialInterval> editedTrialInterval;
    private final PublishSubject<ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event> eventSubject;
    private final long guildId;
    private final long guildRoleSubscriptionGroupListingId;
    private final long guildRoleSubscriptionTierListingId;
    private Boolean isFullServerGating;
    private final RestAPI restApi;
    private final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions;
    private GuildRoleSubscriptionTier storedGuildRoleSubscriptionTier;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel(long j, long j2, long j3, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreChannels storeChannels, StoreEmoji storeEmoji, StoreGuilds storeGuilds, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 8) != 0 ? RestAPI.Companion.getApi() : restAPI;
        StoreGuildRoleSubscriptions guildRoleSubscriptions = (i & 16) != 0 ? StoreStream.Companion.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions;
        StoreChannels channels = (i & 32) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StoreEmoji emojis = (i & 64) != 0 ? StoreStream.Companion.getEmojis() : storeEmoji;
        StoreGuilds guilds = (i & 128) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        this(j, j2, j3, api, guildRoleSubscriptions, channels, emojis, guilds, (i & 256) != 0 ? ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion.access$observeStoreState(Companion, j, j2, ObservationDeckProvider.get(), guildRoleSubscriptions, channels, emojis, guilds) : observable);
    }

    public static final /* synthetic */ void access$emitEvent(ServerSettingsGuildRoleSubscriptionEditTierViewModel serverSettingsGuildRoleSubscriptionEditTierViewModel, ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event serverSettingsGuildRoleSubscriptionEditTierViewModel$Event) {
        serverSettingsGuildRoleSubscriptionEditTierViewModel.emitEvent(serverSettingsGuildRoleSubscriptionEditTierViewModel$Event);
    }

    public static final /* synthetic */ void access$handleStoreState(ServerSettingsGuildRoleSubscriptionEditTierViewModel serverSettingsGuildRoleSubscriptionEditTierViewModel, ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState) {
        serverSettingsGuildRoleSubscriptionEditTierViewModel.handleStoreState(serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState);
    }

    public static final /* synthetic */ void access$updateViewState(ServerSettingsGuildRoleSubscriptionEditTierViewModel serverSettingsGuildRoleSubscriptionEditTierViewModel, ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState) {
        serverSettingsGuildRoleSubscriptionEditTierViewModel.updateViewState(serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState);
    }

    @MainThread
    private final void emitEvent(ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event event) {
        this.eventSubject.k.onNext(event);
    }

    private final void handleLoadedStoreState(StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded storeState, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial, Map<Long, Channel> channels, EmojiSet emojiSet, Map<Long, GuildRole> guildRoles) {
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
                            arrayList.add(new Benefit$ChannelBenefit(ChannelUtils.c(channel), emoji, guildRoleSubscriptionBenefit.getDescription(), Integer.valueOf(GuildChannelIconUtilsKt.guildChannelIcon(channel)), channel.getId()));
                        }
                    } else if (iOrdinal == 2) {
                        arrayList2.add(new Benefit$IntangibleBenefit(guildRoleSubscriptionBenefit.getName(), emoji, guildRoleSubscriptionBenefit.getDescription()));
                    }
                }
            }
            GuildRole guildRole = guildRoles != null ? guildRoles.get(Long.valueOf(guildRoleSubscriptionTierListing.getRoleId())) : null;
            ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState = requireViewState();
            if (!(serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded)) {
                serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState = null;
            }
            ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded = (ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded) serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState;
            boolean zIsSubmitting = serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded != null ? serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.isSubmitting() : false;
            boolean hasChanges = serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded != null ? serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.getHasChanges() : false;
            if (hasChanges) {
                updateViewState(new ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded(hasChanges, guildRoleSubscriptionTierListing.getPublished(), null, false, 12, null));
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
            GuildRoleSubscriptionTier guildRoleSubscriptionTier = new GuildRoleSubscriptionTier(name, lValueOf, Integer.valueOf(GuildRoleSubscriptionUtilsKt.getPrice(guildRoleSubscriptionTierListing)), numValueOf, null, guildRole, null, imageAsset != null ? Long.valueOf(imageAsset.getId()) : null, description, Boolean.valueOf(guildRoleSubscriptionTierListing.getPublished()), Boolean.valueOf(zCanRole), arrayList, arrayList2, subscriptionTrialInterval, guildRoleSubscriptionTierFreeTrial != null ? guildRoleSubscriptionTierFreeTrial.getMaxNumActiveTrialUsers() : null, 80, null);
            Boolean fullServerGatingOverwrite = GuildRoleSubscriptionUtilsKt.getFullServerGatingOverwrite(storeState.getGuildRoleSubscriptionGroupListing(), guildRoles);
            boolean zBooleanValue = fullServerGatingOverwrite != null ? fullServerGatingOverwrite.booleanValue() : storeState.getGuildRoleSubscriptionGroupListing().getFullServerGate();
            this.isFullServerGating = Boolean.valueOf(zBooleanValue);
            this.storedGuildRoleSubscriptionTier = guildRoleSubscriptionTier;
            this.eventSubject.k.onNext(new ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate(guildRoleSubscriptionTier, zBooleanValue));
            updateViewState(new ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded(false, guildRoleSubscriptionTierListing.getPublished(), guildRoleSubscriptionTierListing.getName(), zIsSubmitting, 1, null));
        }
    }

    private final void handleStoreState(ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState storeState) {
        StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupListingState = storeState.getGuildRoleSubscriptionStoreData().getGuildRoleSubscriptionGroupListingState();
        if (guildRoleSubscriptionGroupListingState != null) {
            if (guildRoleSubscriptionGroupListingState instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loading) {
                updateViewState(ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loading.INSTANCE);
            } else if (guildRoleSubscriptionGroupListingState instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded) {
                handleLoadedStoreState((StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded) guildRoleSubscriptionGroupListingState, storeState.getGuildRoleSubscriptionStoreData().getGuildRoleSubscriptionFreeTrial(), storeState.getChannels(), storeState.getGuildEmojis(), storeState.getGuildRoleSubscriptionStoreData().getGuildRoles());
            } else if (guildRoleSubscriptionGroupListingState instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Failed) {
                updateViewState(ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Failed.INSTANCE);
            }
        }
    }

    public final void deleteTier() {
        ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState = requireViewState();
        if (!(serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded)) {
            serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState = null;
        }
        ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded = (ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded) serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState;
        if (serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded != null) {
            updateViewState(ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.copy$default(serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded, false, false, null, true, 7, null));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.INSTANCE.deleteGuildRoleSubscriptionTierListing(this.restApi, this.storeGuildRoleSubscriptions, this.guildId, this.guildRoleSubscriptionGroupListingId, this.guildRoleSubscriptionTierListingId), this, null, 2, null), ServerSettingsGuildRoleSubscriptionEditTierViewModel.class, (Context) null, (Function1) null, new ServerSettingsGuildRoleSubscriptionEditTierViewModel$deleteTier$2(this, serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded), (Function0) null, (Function0) null, new ServerSettingsGuildRoleSubscriptionEditTierViewModel$deleteTier$1(this, serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded), 54, (Object) null);
        }
    }

    public final Observable<ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event> observeEvents() {
        PublishSubject<ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    /* JADX WARN: Code duplicated, block: B:36:0x0074  */
    public final void onTierUpdated(GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        boolean z2;
        boolean z3;
        String name;
        m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState = requireViewState();
        if (!(serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded)) {
            serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState = null;
        }
        ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded = (ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded) serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState;
        if (serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded != null) {
            String name2 = guildRoleSubscriptionTier.getName();
            GuildRoleSubscriptionTier guildRoleSubscriptionTier2 = this.storedGuildRoleSubscriptionTier;
            if (!m.areEqual(name2, guildRoleSubscriptionTier2 != null ? guildRoleSubscriptionTier2.getName() : null)) {
                String name3 = guildRoleSubscriptionTier.getName();
                if (name3 == null || t.isBlank(name3)) {
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
            if (!m.areEqual(description, guildRoleSubscriptionTier3 != null ? guildRoleSubscriptionTier3.getDescription() : null)) {
                String description2 = guildRoleSubscriptionTier.getDescription();
                if (description2 == null || t.isBlank(description2)) {
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
            if (!m.areEqual(priceTier, guildRoleSubscriptionTier4 != null ? guildRoleSubscriptionTier4.getPriceTier() : null)) {
                this.editedTierPrice = guildRoleSubscriptionTier.getPriceTier();
                z2 = true;
            } else {
                this.editedTierPrice = null;
            }
            Integer memberColor = guildRoleSubscriptionTier.getMemberColor();
            GuildRoleSubscriptionTier guildRoleSubscriptionTier5 = this.storedGuildRoleSubscriptionTier;
            if (!m.areEqual(memberColor, guildRoleSubscriptionTier5 != null ? guildRoleSubscriptionTier5.getMemberColor() : null)) {
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
            List<Benefit$ChannelBenefit> channelBenefits = guildRoleSubscriptionTier.getChannelBenefits();
            GuildRoleSubscriptionTier guildRoleSubscriptionTier6 = this.storedGuildRoleSubscriptionTier;
            if (!m.areEqual(channelBenefits, guildRoleSubscriptionTier6 != null ? guildRoleSubscriptionTier6.getChannelBenefits() : null)) {
                this.editedChannelBenefits = guildRoleSubscriptionTier.getChannelBenefits();
                z2 = true;
            } else {
                this.editedChannelBenefits = null;
            }
            List<Benefit$IntangibleBenefit> intangibleBenefits = guildRoleSubscriptionTier.getIntangibleBenefits();
            GuildRoleSubscriptionTier guildRoleSubscriptionTier7 = this.storedGuildRoleSubscriptionTier;
            if (!m.areEqual(intangibleBenefits, guildRoleSubscriptionTier7 != null ? guildRoleSubscriptionTier7.getIntangibleBenefits() : null)) {
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
            if (!m.areEqual(trialInterval, guildRoleSubscriptionTier9 != null ? guildRoleSubscriptionTier9.getTrialInterval() : null)) {
                this.editedTrialInterval = guildRoleSubscriptionTier.getTrialInterval() == null ? new NullSerializable$a<>(null, 1) : new NullSerializable$b<>(guildRoleSubscriptionTier.getTrialInterval());
                z2 = true;
            } else {
                this.editedTrialInterval = null;
            }
            Integer activeTrialUserLimit = guildRoleSubscriptionTier.getActiveTrialUserLimit();
            GuildRoleSubscriptionTier guildRoleSubscriptionTier10 = this.storedGuildRoleSubscriptionTier;
            if (!m.areEqual(activeTrialUserLimit, guildRoleSubscriptionTier10 != null ? guildRoleSubscriptionTier10.getActiveTrialUserLimit() : null)) {
                this.editedActiveTrialUserLimit = guildRoleSubscriptionTier.getActiveTrialUserLimit() == null ? new NullSerializable$a<>(null, 1) : new NullSerializable$b(guildRoleSubscriptionTier.getActiveTrialUserLimit());
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
            updateViewState(ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.copy$default(serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded, z3, false, name, false, 10, null));
        }
    }

    public final void publishTier() {
        ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState = requireViewState();
        if (!(serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded)) {
            serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState = null;
        }
        ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded = (ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded) serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState;
        if (serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded != null) {
            updateViewState(ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.copy$default(serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded, false, false, null, true, 7, null));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionTierListing$default(GuildRoleSubscriptionUtils.INSTANCE, this.restApi, this.storeGuildRoleSubscriptions, this.guildId, this.guildRoleSubscriptionGroupListingId, this.guildRoleSubscriptionTierListingId, null, null, null, null, null, null, null, null, null, Boolean.TRUE, null, null, 114656, null), this, null, 2, null), ServerSettingsGuildRoleSubscriptionEditTierViewModel.class, (Context) null, (Function1) null, new ServerSettingsGuildRoleSubscriptionEditTierViewModel$publishTier$2(this, serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded), (Function0) null, (Function0) null, new ServerSettingsGuildRoleSubscriptionEditTierViewModel$publishTier$1(this, serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded), 54, (Object) null);
        }
    }

    public final void submitChanges() {
        Integer numValueOf;
        List<Benefit$ChannelBenefit> list;
        List<Benefit$IntangibleBenefit> list2;
        ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState = requireViewState();
        if (!(serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded)) {
            serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState = null;
        }
        ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded = (ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded) serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewStateRequireViewState;
        if (serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded != null) {
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
            List<Benefit$ChannelBenefit> channelBenefits = this.editedChannelBenefits;
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
            List<Benefit$IntangibleBenefit> intangibleBenefits = this.editedIntangibleBenefits;
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
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionTierListing$default(guildRoleSubscriptionUtils, restAPI, storeGuildRoleSubscriptions, j, j2, j3, str, str2, str3, num2, numValueOf, str4, bool, list, list2, null, this.editedTrialInterval, this.editedActiveTrialUserLimit, 16384, null), this, null, 2, null), ServerSettingsGuildRoleSubscriptionEditTierViewModel.class, (Context) null, (Function1) null, new ServerSettingsGuildRoleSubscriptionEditTierViewModel$submitChanges$3(this, serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded), (Function0) null, (Function0) null, new ServerSettingsGuildRoleSubscriptionEditTierViewModel$submitChanges$2(this, serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded), 54, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionEditTierViewModel(long j, long j2, long j3, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreChannels storeChannels, StoreEmoji storeEmoji, StoreGuilds storeGuilds, Observable<ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState> observable) {
        super(ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(restAPI, "restApi");
        m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeEmoji, "storeEmoji");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.guildRoleSubscriptionTierListingId = j2;
        this.guildRoleSubscriptionGroupListingId = j3;
        this.restApi = restAPI;
        this.storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.eventSubject = PublishSubject.k0();
        storeGuildRoleSubscriptions.fetchGuildRoleSubscriptionGroupsForGuild(j);
        Observable<ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState> observableR = observable.r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), ServerSettingsGuildRoleSubscriptionEditTierViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ServerSettingsGuildRoleSubscriptionEditTierViewModel$1(this), 62, (Object) null);
    }
}
