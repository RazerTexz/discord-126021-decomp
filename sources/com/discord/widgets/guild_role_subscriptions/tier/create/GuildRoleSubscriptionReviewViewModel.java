package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierListItemGeneratorKt;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildRoleSubscriptionReviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionReviewViewModel extends d0<GuildRoleSubscriptionReviewViewModel$ViewState> {
    public static final GuildRoleSubscriptionReviewViewModel$Companion Companion = new GuildRoleSubscriptionReviewViewModel$Companion(null);
    private Integer guildChannelCount;
    private GuildRoleSubscriptionTier guildRoleSubscriptionTier;
    private Boolean isFullServerGating;
    private String planCoverImage;
    private String planDescription;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildRoleSubscriptionReviewViewModel(long j, StoreChannels storeChannels, ObservationDeck observationDeck, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 2) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        ObservationDeck observationDeck2 = (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck;
        this(j, channels, observationDeck2, (i & 8) != 0 ? GuildRoleSubscriptionReviewViewModel$Companion.access$observeStoreState(Companion, j, observationDeck2, channels) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildRoleSubscriptionReviewViewModel guildRoleSubscriptionReviewViewModel, GuildRoleSubscriptionReviewViewModel$StoreState guildRoleSubscriptionReviewViewModel$StoreState) {
        guildRoleSubscriptionReviewViewModel.handleStoreState(guildRoleSubscriptionReviewViewModel$StoreState);
    }

    private final void handleStoreState(GuildRoleSubscriptionReviewViewModel$StoreState storeState) {
        this.guildChannelCount = Integer.valueOf(storeState.getGuildChannelCount());
        updateList();
    }

    private final void updateList() {
        updateViewState(new GuildRoleSubscriptionReviewViewModel$ViewState(GuildRoleSubscriptionTierListItemGeneratorKt.generateGuildRoleSubscriptionReviewListItems(this.guildRoleSubscriptionTier, this.isFullServerGating, this.guildChannelCount, this.planDescription, this.planCoverImage)));
    }

    public final void updatePlanDetails(String description, String coverImage) {
        m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        m.checkNotNullParameter(coverImage, "coverImage");
        this.planDescription = description;
        this.planCoverImage = coverImage;
        updateList();
    }

    public final void updateTier(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean isFullServerGating) {
        m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
        this.isFullServerGating = isFullServerGating;
        updateList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionReviewViewModel(long j, StoreChannels storeChannels, ObservationDeck observationDeck, Observable<GuildRoleSubscriptionReviewViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(observable, "storeStateObservable");
        Observable<GuildRoleSubscriptionReviewViewModel$StoreState> observableR = observable.r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), GuildRoleSubscriptionReviewViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildRoleSubscriptionReviewViewModel$1(this), 62, (Object) null);
    }
}
