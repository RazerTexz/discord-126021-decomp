package com.discord.widgets.guild_role_subscriptions.tier.create;

import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierViewModel.kt */
    public static final /* data */ class ViewState {
        private final GuildRoleSubscriptionTier guildRoleSubscriptionTier;
        private final Boolean isFullServerGating;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public ViewState(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean bool) {
            C12238m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
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
            C12238m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
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
            return C12238m.areEqual(this.guildRoleSubscriptionTier, viewState.guildRoleSubscriptionTier) && C12238m.areEqual(this.isFullServerGating, viewState.isFullServerGating);
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
            StringBuilder sbM833U = C1643a.m833U("ViewState(guildRoleSubscriptionTier=");
            sbM833U.append(this.guildRoleSubscriptionTier);
            sbM833U.append(", isFullServerGating=");
            return C1643a.m816D(sbM833U, this.isFullServerGating, ")");
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
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, C12163u.plus((Collection<? extends Benefit.ChannelBenefit>) guildRoleSubscriptionTier.getChannelBenefits(), channelBenefit), null, null, null, 30719, null), null, 2, null));
    }

    private final void addIntangibleBenefit(Benefit.IntangibleBenefit intangibleBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, null, C12163u.plus((Collection<? extends Benefit.IntangibleBenefit>) guildRoleSubscriptionTier.getIntangibleBenefits(), intangibleBenefit), null, null, 28671, null), null, 2, null));
    }

    private final void removeChannelBenefit(Benefit.ChannelBenefit channelBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, C12163u.minus(guildRoleSubscriptionTier.getChannelBenefits(), channelBenefit), null, null, null, 30719, null), null, 2, null));
    }

    private final void removeIntangibleBenefit(Benefit.IntangibleBenefit intangibleBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, null, C12163u.minus(guildRoleSubscriptionTier.getIntangibleBenefits(), intangibleBenefit), null, null, 28671, null), null, 2, null));
    }

    private final void replaceChannelBenefit(Benefit.ChannelBenefit existingChannelBenefit, Benefit.ChannelBenefit newChannelBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        List mutableList = C12163u.toMutableList((Collection) guildRoleSubscriptionTier.getChannelBenefits());
        int iIndexOf = mutableList.indexOf(existingChannelBenefit);
        if (iIndexOf != -1) {
            mutableList.set(iIndexOf, newChannelBenefit);
            updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, mutableList, null, null, null, 30719, null), null, 2, null));
        }
    }

    private final void replaceIntangibleBenefit(Benefit.IntangibleBenefit existingIntangibleBenefit, Benefit.IntangibleBenefit newIntangibleBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        List mutableList = C12163u.toMutableList((Collection) guildRoleSubscriptionTier.getIntangibleBenefits());
        int iIndexOf = mutableList.indexOf(existingIntangibleBenefit);
        if (iIndexOf != -1) {
            mutableList.set(iIndexOf, newIntangibleBenefit);
            updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, null, mutableList, null, null, 28671, null), null, 2, null));
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
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(canAccessAllChannels), null, null, null, null, 31743, null), null, 2, null));
    }

    public final void setDefaultMemberColor(int defaultMemberColor) {
        if (requireViewState().getGuildRoleSubscriptionTier().getMemberColor() == null) {
            updateMemberColor(Integer.valueOf(defaultMemberColor));
        }
    }

    public final void setFullServerGating(boolean isFullServerGating) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(requireViewState().copy(GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(Boolean.valueOf(isFullServerGating))), null, null, null, null, 31743, null), Boolean.valueOf(isFullServerGating)));
    }

    public final void setTier(GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        C12238m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
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
        C12238m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, null, null, null, null, null, description, null, null, null, null, null, null, 32511, null), null, 2, null));
    }

    public final void updateFreeTrialInterval(SubscriptionTrialInterval trialInterval) {
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, null, null, null, null, null, null, null, null, null, null, trialInterval, null, 24575, null), null, 2, null));
    }

    public final void updateFreeTrialLimit(Integer limit) {
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, limit, 16383, null), null, 2, null));
    }

    public final void updateImage(String image) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        requireViewState();
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, image, null, null, null, null, null, null, null, null, 32703, null), null, 2, null));
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
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, memberColor, null, null, null, null, null, null, null, null, null, null, null, 32759, null), null, 2, null));
    }

    public final void updateMemberIcon(String memberIcon) {
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, null, memberIcon, null, null, null, null, null, null, null, null, null, null, 32751, null), null, 2, null));
    }

    public final void updatePriceTier(int priceTier) {
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, Integer.valueOf(priceTier), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null), null, 2, null));
    }

    public final void updateTierName(String tierName) {
        C12238m.checkNotNullParameter(tierName, "tierName");
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), tierName, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null), null, 2, null));
    }
}
