package com.discord.widgets.guild_role_subscriptions.setup;

import b.a.d.d0;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.ImageAsset;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionPlanDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionPlanDetailsViewModel extends d0<GuildRoleSubscriptionPlanDetailsViewModel$ViewState> {
    public GuildRoleSubscriptionPlanDetailsViewModel() {
        super(new GuildRoleSubscriptionPlanDetailsViewModel$ViewState(null, null, null, null, false, 31, null));
    }

    public final void setGroupPlanDetails(GuildRoleSubscriptionGroupListing subscriptionGroupListing, Boolean fullServerGatingOverwrite) {
        m.checkNotNullParameter(subscriptionGroupListing, "subscriptionGroupListing");
        Long lValueOf = Long.valueOf(subscriptionGroupListing.getApplicationId());
        ImageAsset imageAsset = subscriptionGroupListing.getImageAsset();
        updateViewState(new GuildRoleSubscriptionPlanDetailsViewModel$ViewState(null, lValueOf, imageAsset != null ? Long.valueOf(imageAsset.getId()) : null, subscriptionGroupListing.getDescription(), fullServerGatingOverwrite != null ? fullServerGatingOverwrite.booleanValue() : subscriptionGroupListing.getFullServerGate(), 1, null));
    }

    public final void updateCoverImage(String coverImage) {
        updateViewState(GuildRoleSubscriptionPlanDetailsViewModel$ViewState.copy$default(requireViewState(), coverImage, null, null, null, false, 30, null));
    }

    public final void updateDescription(String description) {
        updateViewState(GuildRoleSubscriptionPlanDetailsViewModel$ViewState.copy$default(requireViewState(), null, null, null, description, false, 23, null));
    }

    public final void updateFullServerGate(boolean isFullServerGate) {
        updateViewState(GuildRoleSubscriptionPlanDetailsViewModel$ViewState.copy$default(requireViewState(), null, null, null, null, isFullServerGate, 15, null));
    }
}
