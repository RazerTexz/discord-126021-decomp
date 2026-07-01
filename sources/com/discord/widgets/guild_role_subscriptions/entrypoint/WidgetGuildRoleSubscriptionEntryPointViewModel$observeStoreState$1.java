package com.discord.widgets.guild_role_subscriptions.entrypoint;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Loaded;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtilsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionEntryPointViewModel$observeStoreState$1 extends o implements Function0<WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetGuildRoleSubscriptionEntryPointViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionEntryPointViewModel$observeStoreState$1(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel, long j) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionEntryPointViewModel;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState invoke() {
        StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState guildRoleSubscriptionState = WidgetGuildRoleSubscriptionEntryPointViewModel.access$getGuildRoleSubscriptionsStore$p(this.this$0).getGuildRoleSubscriptionState(this.$guildId);
        Boolean boolValueOf = null;
        if (!(guildRoleSubscriptionState instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded)) {
            guildRoleSubscriptionState = null;
        }
        StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded = (StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded) guildRoleSubscriptionState;
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded != null ? storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded.getGuildRoleSubscriptionGroupListing() : null;
        StoreSubscriptions$SubscriptionsState subscriptionsStateSnapshot = WidgetGuildRoleSubscriptionEntryPointViewModel.access$getSubscriptionsStore$p(this.this$0).getSubscriptionsStateSnapshot();
        if (!(subscriptionsStateSnapshot instanceof StoreSubscriptions$SubscriptionsState$Loaded)) {
            subscriptionsStateSnapshot = null;
        }
        StoreSubscriptions$SubscriptionsState$Loaded storeSubscriptions$SubscriptionsState$Loaded = (StoreSubscriptions$SubscriptionsState$Loaded) subscriptionsStateSnapshot;
        List<ModelSubscription> subscriptions = storeSubscriptions$SubscriptionsState$Loaded != null ? storeSubscriptions$SubscriptionsState$Loaded.getSubscriptions() : null;
        Long lValueOf = guildRoleSubscriptionGroupListing != null ? Long.valueOf(guildRoleSubscriptionGroupListing.getId()) : null;
        if (subscriptions != null && guildRoleSubscriptionGroupListing != null) {
            boolValueOf = Boolean.valueOf(GuildRoleSubscriptionUtilsKt.hasUserActiveSubscriptionFor(guildRoleSubscriptionGroupListing, subscriptions));
        }
        return new WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState(WidgetGuildRoleSubscriptionEntryPointViewModel.access$getConnectivityStore$p(this.this$0).isConnected(), GuildRoleSubscriptionsFeatureFlag.Companion.getINSTANCE().canGuildSeePremiumMemberships(this.$guildId), WidgetGuildRoleSubscriptionEntryPointViewModel.access$getGuildsStore$p(this.this$0).getGuild(this.$guildId), boolValueOf, lValueOf);
    }
}
