package com.discord.widgets.guild_role_subscriptions.tier.create;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierViewModel.kt */
    public static final /* data */ class ViewState {
        private final GuildRoleSubscriptionTier guildRoleSubscriptionTier;
        private final Boolean isFullServerGating;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public ViewState(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean bool) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
            this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
            this.isFullServerGating = bool;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionTier = viewState.guildRoleSubscriptionTier;
            }
            if ((i & 2) != 0) {
                bool = viewState.isFullServerGating;
            }
            return viewState.copy(guildRoleSubscriptionTier, bool);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
            return this.guildRoleSubscriptionTier;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getIsFullServerGating() {
            return this.isFullServerGating;
        }

        public final ViewState copy(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean isFullServerGating) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
            return new ViewState(guildRoleSubscriptionTier, isFullServerGating);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.guildRoleSubscriptionTier, viewState.guildRoleSubscriptionTier) && Intrinsics3.areEqual(this.isFullServerGating, viewState.isFullServerGating);
        }

        public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
            return this.guildRoleSubscriptionTier;
        }

        public int hashCode() {
            GuildRoleSubscriptionTier guildRoleSubscriptionTier = this.guildRoleSubscriptionTier;
            int iHashCode = (guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.hashCode() : 0) * 31;
            Boolean bool = this.isFullServerGating;
            return iHashCode + (bool != null ? bool.hashCode() : 0);
        }

        public final Boolean isFullServerGating() {
            return this.isFullServerGating;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(guildRoleSubscriptionTier=");
            sbU.append(this.guildRoleSubscriptionTier);
            sbU.append(", isFullServerGating=");
            return outline.D(sbU, this.isFullServerGating, ")");
        }

        public /* synthetic */ ViewState(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new GuildRoleSubscriptionTier(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null) : guildRoleSubscriptionTier, (i & 2) != 0 ? null : bool);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildRoleSubscriptionTierViewModel() {
        super(new ViewState(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    private final void addChannelBenefit(Benefit.ChannelBenefit channelBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : null, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : null, (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : null, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : null, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : null, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : null, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : null, (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : _Collections.plus((Collection<? extends Benefit.ChannelBenefit>) guildRoleSubscriptionTier.getChannelBenefits(), channelBenefit), (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : null, (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : null, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : null), null, 2, null));
    }

    private final void addIntangibleBenefit(Benefit.IntangibleBenefit intangibleBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : null, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : null, (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : null, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : null, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : null, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : null, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : null, (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : null, (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : _Collections.plus((Collection<? extends Benefit.IntangibleBenefit>) guildRoleSubscriptionTier.getIntangibleBenefits(), intangibleBenefit), (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : null, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : null), null, 2, null));
    }

    private final void removeChannelBenefit(Benefit.ChannelBenefit channelBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : null, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : null, (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : null, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : null, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : null, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : null, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : null, (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : _Collections.minus(guildRoleSubscriptionTier.getChannelBenefits(), channelBenefit), (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : null, (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : null, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : null), null, 2, null));
    }

    private final void removeIntangibleBenefit(Benefit.IntangibleBenefit intangibleBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : null, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : null, (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : null, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : null, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : null, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : null, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : null, (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : null, (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : _Collections.minus(guildRoleSubscriptionTier.getIntangibleBenefits(), intangibleBenefit), (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : null, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : null), null, 2, null));
    }

    private final void replaceChannelBenefit(Benefit.ChannelBenefit existingChannelBenefit, Benefit.ChannelBenefit newChannelBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        List mutableList = _Collections.toMutableList((Collection) guildRoleSubscriptionTier.getChannelBenefits());
        int iIndexOf = mutableList.indexOf(existingChannelBenefit);
        if (iIndexOf != -1) {
            mutableList.set(iIndexOf, newChannelBenefit);
            updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : null, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : null, (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : null, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : null, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : null, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : null, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : null, (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : mutableList, (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : null, (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : null, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : null), null, 2, null));
        }
    }

    private final void replaceIntangibleBenefit(Benefit.IntangibleBenefit existingIntangibleBenefit, Benefit.IntangibleBenefit newIntangibleBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        List mutableList = _Collections.toMutableList((Collection) guildRoleSubscriptionTier.getIntangibleBenefits());
        int iIndexOf = mutableList.indexOf(existingIntangibleBenefit);
        if (iIndexOf != -1) {
            mutableList.set(iIndexOf, newIntangibleBenefit);
            updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : null, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : null, (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : null, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : null, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : null, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : null, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : null, (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : null, (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : mutableList, (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : null, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : null), null, 2, null));
        }
    }

    public static /* synthetic */ void updateFreeTrialInterval$default(GuildRoleSubscriptionTierViewModel guildRoleSubscriptionTierViewModel, SubscriptionTrialInterval subscriptionTrialInterval, int i, Object obj) {
        if ((i & 1) != 0) {
            subscriptionTrialInterval = null;
        }
        guildRoleSubscriptionTierViewModel.updateFreeTrialInterval(subscriptionTrialInterval);
    }

    public static /* synthetic */ void updateFreeTrialLimit$default(GuildRoleSubscriptionTierViewModel guildRoleSubscriptionTierViewModel, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        guildRoleSubscriptionTierViewModel.updateFreeTrialLimit(num);
    }

    public static /* synthetic */ void updateImage$default(GuildRoleSubscriptionTierViewModel guildRoleSubscriptionTierViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        guildRoleSubscriptionTierViewModel.updateImage(str);
    }

    public static /* synthetic */ void updateMemberIcon$default(GuildRoleSubscriptionTierViewModel guildRoleSubscriptionTierViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        guildRoleSubscriptionTierViewModel.updateMemberIcon(str);
    }

    public final void setCanAccessAllChannels(boolean canAccessAllChannels) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : null, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : null, (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : null, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : null, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : null, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : null, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : Boolean.valueOf(canAccessAllChannels), (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : null, (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : null, (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : null, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : null), null, 2, null));
    }

    public final void setDefaultMemberColor(int defaultMemberColor) {
        if (requireViewState().getGuildRoleSubscriptionTier().getMemberColor() == null) {
            updateMemberColor(Integer.valueOf(defaultMemberColor));
        }
    }

    public final void setFullServerGating(boolean isFullServerGating) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(requireViewState().copy(guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : null, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : null, (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : null, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : null, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : null, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : null, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : Boolean.valueOf(guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(Boolean.valueOf(isFullServerGating))), (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : null, (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : null, (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : null, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : null), Boolean.valueOf(isFullServerGating)));
    }

    public final void setTier(GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier, null, 2, null));
    }

    public final void updateBenefit(Benefit existingBenefit, Benefit newBenefit) {
        boolean z2 = existingBenefit instanceof Benefit.ChannelBenefit;
        if (z2 || (newBenefit instanceof Benefit.ChannelBenefit)) {
            if (!z2) {
                existingBenefit = null;
            }
            Benefit.ChannelBenefit channelBenefit = (Benefit.ChannelBenefit) existingBenefit;
            if (!(newBenefit instanceof Benefit.ChannelBenefit)) {
                newBenefit = null;
            }
            updateChannelBenefit(channelBenefit, (Benefit.ChannelBenefit) newBenefit);
            return;
        }
        if (!(existingBenefit instanceof Benefit.IntangibleBenefit)) {
            existingBenefit = null;
        }
        Benefit.IntangibleBenefit intangibleBenefit = (Benefit.IntangibleBenefit) existingBenefit;
        if (!(newBenefit instanceof Benefit.IntangibleBenefit)) {
            newBenefit = null;
        }
        updateIntangibleBenefit(intangibleBenefit, (Benefit.IntangibleBenefit) newBenefit);
    }

    public final void updateChannelBenefit(Benefit.ChannelBenefit existingChannelBenefit, Benefit.ChannelBenefit newChannelBenefit) {
        if (existingChannelBenefit == null && newChannelBenefit != null) {
            addChannelBenefit(newChannelBenefit);
            return;
        }
        if (existingChannelBenefit != null && newChannelBenefit == null) {
            removeChannelBenefit(existingChannelBenefit);
        } else {
            if (existingChannelBenefit == null || newChannelBenefit == null) {
                return;
            }
            replaceChannelBenefit(existingChannelBenefit, newChannelBenefit);
        }
    }

    public final void updateDescription(String description) {
        Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : null, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : null, (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : null, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : null, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : null, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : description, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : null, (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : null, (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : null, (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : null, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : null), null, 2, null));
    }

    public final void updateFreeTrialInterval(SubscriptionTrialInterval trialInterval) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : null, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : null, (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : null, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : null, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : null, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : null, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : null, (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : null, (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : null, (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : trialInterval, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : null), null, 2, null));
    }

    public final void updateFreeTrialLimit(Integer limit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : null, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : null, (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : null, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : null, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : null, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : null, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : null, (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : null, (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : null, (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : null, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : limit), null, 2, null));
    }

    public final void updateImage(String image) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        requireViewState();
        updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : null, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : null, (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : null, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : null, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : image, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : null, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : null, (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : null, (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : null, (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : null, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : null), null, 2, null));
    }

    public final void updateIntangibleBenefit(Benefit.IntangibleBenefit existingIntangibleBenefit, Benefit.IntangibleBenefit newIntangibleBenefit) {
        if (existingIntangibleBenefit == null && newIntangibleBenefit != null) {
            addIntangibleBenefit(newIntangibleBenefit);
            return;
        }
        if (existingIntangibleBenefit != null && newIntangibleBenefit == null) {
            removeIntangibleBenefit(existingIntangibleBenefit);
        } else {
            if (existingIntangibleBenefit == null || newIntangibleBenefit == null) {
                return;
            }
            replaceIntangibleBenefit(existingIntangibleBenefit, newIntangibleBenefit);
        }
    }

    public final void updateMemberColor(Integer memberColor) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : null, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : null, (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : memberColor, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : null, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : null, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : null, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : null, (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : null, (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : null, (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : null, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : null), null, 2, null));
    }

    public final void updateMemberIcon(String memberIcon) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : null, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : null, (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : null, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : memberIcon, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : null, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : null, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : null, (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : null, (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : null, (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : null, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : null), null, 2, null));
    }

    public final void updatePriceTier(int priceTier) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : null, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : Integer.valueOf(priceTier), (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : null, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : null, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : null, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : null, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : null, (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : null, (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : null, (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : null, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : null), null, 2, null));
    }

    public final void updateTierName(String tierName) {
        Intrinsics3.checkNotNullParameter(tierName, "tierName");
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier.copy((30719 & 1) != 0 ? guildRoleSubscriptionTier.name : tierName, (30719 & 2) != 0 ? guildRoleSubscriptionTier.applicationId : null, (30719 & 4) != 0 ? guildRoleSubscriptionTier.priceTier : null, (30719 & 8) != 0 ? guildRoleSubscriptionTier.memberColor : null, (30719 & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : null, (30719 & 32) != 0 ? guildRoleSubscriptionTier.guildRole : null, (30719 & 64) != 0 ? guildRoleSubscriptionTier.image : null, (30719 & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : null, (30719 & 256) != 0 ? guildRoleSubscriptionTier.description : null, (30719 & 512) != 0 ? guildRoleSubscriptionTier.isPublished : null, (30719 & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : null, (30719 & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : null, (30719 & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : null, (30719 & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : null, (30719 & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : null), null, 2, null));
    }
}
