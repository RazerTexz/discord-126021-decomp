package com.discord.widgets.guild_role_subscriptions.tier.create;

import b.a.d.d0;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit$ChannelBenefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit$IntangibleBenefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierViewModel extends d0<GuildRoleSubscriptionTierViewModel$ViewState> {
    public GuildRoleSubscriptionTierViewModel() {
        super(new GuildRoleSubscriptionTierViewModel$ViewState(null, null, 3, null));
    }

    private final void addChannelBenefit(Benefit$ChannelBenefit channelBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, u.plus((Collection<? extends Benefit$ChannelBenefit>) guildRoleSubscriptionTier.getChannelBenefits(), channelBenefit), null, null, null, 30719, null), null, 2, null));
    }

    private final void addIntangibleBenefit(Benefit$IntangibleBenefit intangibleBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, null, u.plus((Collection<? extends Benefit$IntangibleBenefit>) guildRoleSubscriptionTier.getIntangibleBenefits(), intangibleBenefit), null, null, 28671, null), null, 2, null));
    }

    private final void removeChannelBenefit(Benefit$ChannelBenefit channelBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, u.minus(guildRoleSubscriptionTier.getChannelBenefits(), channelBenefit), null, null, null, 30719, null), null, 2, null));
    }

    private final void removeIntangibleBenefit(Benefit$IntangibleBenefit intangibleBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, null, u.minus(guildRoleSubscriptionTier.getIntangibleBenefits(), intangibleBenefit), null, null, 28671, null), null, 2, null));
    }

    private final void replaceChannelBenefit(Benefit$ChannelBenefit existingChannelBenefit, Benefit$ChannelBenefit newChannelBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        List mutableList = u.toMutableList((Collection) guildRoleSubscriptionTier.getChannelBenefits());
        int iIndexOf = mutableList.indexOf(existingChannelBenefit);
        if (iIndexOf != -1) {
            mutableList.set(iIndexOf, newChannelBenefit);
            updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, mutableList, null, null, null, 30719, null), null, 2, null));
        }
    }

    private final void replaceIntangibleBenefit(Benefit$IntangibleBenefit existingIntangibleBenefit, Benefit$IntangibleBenefit newIntangibleBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        List mutableList = u.toMutableList((Collection) guildRoleSubscriptionTier.getIntangibleBenefits());
        int iIndexOf = mutableList.indexOf(existingIntangibleBenefit);
        if (iIndexOf != -1) {
            mutableList.set(iIndexOf, newIntangibleBenefit);
            updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, null, mutableList, null, null, 28671, null), null, 2, null));
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
        updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(canAccessAllChannels), null, null, null, null, 31743, null), null, 2, null));
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
        m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier, null, 2, null));
    }

    public final void updateBenefit(Benefit existingBenefit, Benefit newBenefit) {
        boolean z2 = existingBenefit instanceof Benefit$ChannelBenefit;
        if (z2 || (newBenefit instanceof Benefit$ChannelBenefit)) {
            if (!z2) {
                existingBenefit = null;
            }
            Benefit$ChannelBenefit benefit$ChannelBenefit = (Benefit$ChannelBenefit) existingBenefit;
            if (!(newBenefit instanceof Benefit$ChannelBenefit)) {
                newBenefit = null;
            }
            updateChannelBenefit(benefit$ChannelBenefit, (Benefit$ChannelBenefit) newBenefit);
            return;
        }
        if (!(existingBenefit instanceof Benefit$IntangibleBenefit)) {
            existingBenefit = null;
        }
        Benefit$IntangibleBenefit benefit$IntangibleBenefit = (Benefit$IntangibleBenefit) existingBenefit;
        if (!(newBenefit instanceof Benefit$IntangibleBenefit)) {
            newBenefit = null;
        }
        updateIntangibleBenefit(benefit$IntangibleBenefit, (Benefit$IntangibleBenefit) newBenefit);
    }

    public final void updateChannelBenefit(Benefit$ChannelBenefit existingChannelBenefit, Benefit$ChannelBenefit newChannelBenefit) {
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
        m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, null, null, null, null, null, description, null, null, null, null, null, null, 32511, null), null, 2, null));
    }

    public final void updateFreeTrialInterval(SubscriptionTrialInterval trialInterval) {
        updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, null, null, null, null, null, null, null, null, null, null, trialInterval, null, 24575, null), null, 2, null));
    }

    public final void updateFreeTrialLimit(Integer limit) {
        updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, limit, 16383, null), null, 2, null));
    }

    public final void updateImage(String image) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        requireViewState();
        updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, image, null, null, null, null, null, null, null, null, 32703, null), null, 2, null));
    }

    public final void updateIntangibleBenefit(Benefit$IntangibleBenefit existingIntangibleBenefit, Benefit$IntangibleBenefit newIntangibleBenefit) {
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
        updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, memberColor, null, null, null, null, null, null, null, null, null, null, null, 32759, null), null, 2, null));
    }

    public final void updateMemberIcon(String memberIcon) {
        updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, null, memberIcon, null, null, null, null, null, null, null, null, null, null, 32751, null), null, 2, null));
    }

    public final void updatePriceTier(int priceTier) {
        updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, Integer.valueOf(priceTier), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null), null, 2, null));
    }

    public final void updateTierName(String tierName) {
        m.checkNotNullParameter(tierName, "tierName");
        updateViewState(GuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), tierName, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null), null, 2, null));
    }
}
