package com.discord.widgets.guild_role_subscriptions.setup;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.g0.t;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionPlanSetupViewModel extends d0<GuildRoleSubscriptionPlanSetupViewModel$ViewState> {
    public static final GuildRoleSubscriptionPlanSetupViewModel$Companion Companion = new GuildRoleSubscriptionPlanSetupViewModel$Companion(null);
    private static final int DETAILS_STEP = 1;
    private static final int FORMAT_TYPE_STEP = 0;
    private static final int TIER_CHANNEL_BENEFITS_STEP = 3;
    private static final int TIER_DESIGN_STEP = 5;
    private static final int TIER_DETAILS_STEP = 2;
    private static final int TIER_INTANGIBLE_BENEFITS_STEP = 4;
    private final PublishSubject<GuildRoleSubscriptionPlanSetupViewModel$Event> eventSubject;
    private final long guildId;
    private final RestAPI restApi;
    private final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions;

    public /* synthetic */ GuildRoleSubscriptionPlanSetupViewModel(long j, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 4) != 0 ? StoreStream.Companion.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions);
    }

    public static final /* synthetic */ void access$emitEvent(GuildRoleSubscriptionPlanSetupViewModel guildRoleSubscriptionPlanSetupViewModel, GuildRoleSubscriptionPlanSetupViewModel$Event guildRoleSubscriptionPlanSetupViewModel$Event) {
        guildRoleSubscriptionPlanSetupViewModel.emitEvent(guildRoleSubscriptionPlanSetupViewModel$Event);
    }

    public static final /* synthetic */ GuildRoleSubscriptionPlanSetupViewModel$ViewState access$requireViewState(GuildRoleSubscriptionPlanSetupViewModel guildRoleSubscriptionPlanSetupViewModel) {
        return guildRoleSubscriptionPlanSetupViewModel.requireViewState();
    }

    private final boolean computeCanProceedToNextStep(GuildRoleSubscriptionPlanSetupViewModel$ViewState viewState) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewState.getGuildRoleSubscriptionTier();
        int currentStep = viewState.getCurrentStep();
        if (currentStep != 0) {
            if (currentStep == 1) {
                String coverImage = viewState.getCoverImage();
                if (coverImage == null || t.isBlank(coverImage)) {
                    return false;
                }
                String planDescription = viewState.getPlanDescription();
                if (planDescription == null || t.isBlank(planDescription)) {
                    return false;
                }
            } else if (currentStep == 2) {
                String name = guildRoleSubscriptionTier.getName();
                if ((name == null || t.isBlank(name)) || guildRoleSubscriptionTier.getPriceTier() == null) {
                    return false;
                }
                String image = guildRoleSubscriptionTier.getImage();
                if (image == null || t.isBlank(image)) {
                    return false;
                }
            } else if (currentStep != 3 && currentStep != 4 && (currentStep != 5 || guildRoleSubscriptionTier.getMemberColor() == null)) {
                return false;
            }
        }
        return true;
    }

    @MainThread
    private final void emitEvent(GuildRoleSubscriptionPlanSetupViewModel$Event event) {
        this.eventSubject.k.onNext(event);
    }

    public final void goToNextStep() {
        GuildRoleSubscriptionPlanSetupViewModel$ViewState guildRoleSubscriptionPlanSetupViewModel$ViewStateRequireViewState = requireViewState();
        updateViewState2(GuildRoleSubscriptionPlanSetupViewModel$ViewState.copy$default(guildRoleSubscriptionPlanSetupViewModel$ViewStateRequireViewState, guildRoleSubscriptionPlanSetupViewModel$ViewStateRequireViewState.getCurrentStep() + 1, false, false, null, null, null, null, 126, null));
    }

    public final void goToPreviousStep() {
        GuildRoleSubscriptionPlanSetupViewModel$ViewState guildRoleSubscriptionPlanSetupViewModel$ViewStateRequireViewState = requireViewState();
        updateViewState2(GuildRoleSubscriptionPlanSetupViewModel$ViewState.copy$default(guildRoleSubscriptionPlanSetupViewModel$ViewStateRequireViewState, guildRoleSubscriptionPlanSetupViewModel$ViewStateRequireViewState.getCurrentStep() - 1, false, false, null, null, null, null, 126, null));
    }

    public final Observable<GuildRoleSubscriptionPlanSetupViewModel$Event> observeEvents() {
        PublishSubject<GuildRoleSubscriptionPlanSetupViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onSubscriptionPlanUpdated(String coverImage, String description, boolean isFullServerGating) {
        updateViewState2(GuildRoleSubscriptionPlanSetupViewModel$ViewState.copy$default(requireViewState(), 0, false, false, coverImage, description, Boolean.valueOf(isFullServerGating), null, 71, null));
    }

    public final void onTierUpdated(GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        updateViewState2(GuildRoleSubscriptionPlanSetupViewModel$ViewState.copy$default(requireViewState(), 0, false, false, null, null, null, guildRoleSubscriptionTier, 63, null));
    }

    public final void submit() {
        GuildRoleSubscriptionPlanSetupViewModel$ViewState guildRoleSubscriptionPlanSetupViewModel$ViewStateRequireViewState = requireViewState();
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = guildRoleSubscriptionPlanSetupViewModel$ViewStateRequireViewState.getGuildRoleSubscriptionTier();
        String name = guildRoleSubscriptionTier.getName();
        if ((name == null || t.isBlank(name)) || guildRoleSubscriptionTier.getPriceTier() == null || guildRoleSubscriptionTier.getMemberColor() == null) {
            return;
        }
        updateViewState2(GuildRoleSubscriptionPlanSetupViewModel$ViewState.copy$default(guildRoleSubscriptionPlanSetupViewModel$ViewStateRequireViewState, 0, true, false, null, null, null, null, Opcodes.LUSHR, null));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.INSTANCE.createGuildRoleSubscriptionGroupListing(this.restApi, this.storeGuildRoleSubscriptions, this.guildId, guildRoleSubscriptionPlanSetupViewModel$ViewStateRequireViewState.getCoverImage(), guildRoleSubscriptionPlanSetupViewModel$ViewStateRequireViewState.getPlanDescription(), guildRoleSubscriptionPlanSetupViewModel$ViewStateRequireViewState.isFullServerGating(), guildRoleSubscriptionTier.getName(), guildRoleSubscriptionTier.getDescription(), guildRoleSubscriptionTier.getPriceTier().intValue(), guildRoleSubscriptionTier.getImage(), ColorCompat.INSTANCE.removeAlphaComponent(guildRoleSubscriptionTier.getMemberColor().intValue()), guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(guildRoleSubscriptionPlanSetupViewModel$ViewStateRequireViewState.isFullServerGating()), guildRoleSubscriptionTier.getChannelBenefits(), guildRoleSubscriptionTier.getIntangibleBenefits()), this, null, 2, null), GuildRoleSubscriptionPlanSetupViewModel.class, (Context) null, (Function1) null, new GuildRoleSubscriptionPlanSetupViewModel$submit$2(this), (Function0) null, (Function0) null, new GuildRoleSubscriptionPlanSetupViewModel$submit$1(this), 54, (Object) null);
    }

    @Override // b.a.d.d0
    public /* bridge */ /* synthetic */ void updateViewState(GuildRoleSubscriptionPlanSetupViewModel$ViewState guildRoleSubscriptionPlanSetupViewModel$ViewState) {
        updateViewState2(guildRoleSubscriptionPlanSetupViewModel$ViewState);
    }

    /* JADX INFO: renamed from: updateViewState, reason: avoid collision after fix types in other method */
    public void updateViewState2(GuildRoleSubscriptionPlanSetupViewModel$ViewState viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        super.updateViewState(GuildRoleSubscriptionPlanSetupViewModel$ViewState.copy$default(viewState, 0, false, computeCanProceedToNextStep(viewState), null, null, null, null, 123, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionPlanSetupViewModel(long j, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        super(new GuildRoleSubscriptionPlanSetupViewModel$ViewState(0, false, false, null, null, null, null, Opcodes.LAND, null));
        m.checkNotNullParameter(restAPI, "restApi");
        m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        this.guildId = j;
        this.restApi = restAPI;
        this.storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.eventSubject = PublishSubject.k0();
    }
}
