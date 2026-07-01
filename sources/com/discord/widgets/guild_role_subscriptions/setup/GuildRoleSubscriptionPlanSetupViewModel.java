package com.discord.widgets.guild_role_subscriptions.setup;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionPlanSetupViewModel extends AppViewModel<ViewState> {
    private static final int DETAILS_STEP = 1;
    private static final int FORMAT_TYPE_STEP = 0;
    private static final int TIER_CHANNEL_BENEFITS_STEP = 3;
    private static final int TIER_DESIGN_STEP = 5;
    private static final int TIER_DETAILS_STEP = 2;
    private static final int TIER_INTANGIBLE_BENEFITS_STEP = 4;
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final RestAPI restApi;
    private final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions;

    /* JADX INFO: compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
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

        /* JADX INFO: compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
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

    /* JADX INFO: compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean canProceedToNextStep;
        private final String coverImage;
        private final int currentStep;
        private final GuildRoleSubscriptionTier guildRoleSubscriptionTier;
        private final Boolean isFullServerGating;
        private final boolean isSubmitting;
        private final String planDescription;

        public ViewState() {
            this(0, false, false, null, null, null, null, Opcodes.LAND, null);
        }

        public ViewState(int i, boolean z2, boolean z3, String str, String str2, Boolean bool, GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
            this.currentStep = i;
            this.isSubmitting = z2;
            this.canProceedToNextStep = z3;
            this.coverImage = str;
            this.planDescription = str2;
            this.isFullServerGating = bool;
            this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, int i, boolean z2, boolean z3, String str, String str2, Boolean bool, GuildRoleSubscriptionTier guildRoleSubscriptionTier, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = viewState.currentStep;
            }
            if ((i2 & 2) != 0) {
                z2 = viewState.isSubmitting;
            }
            boolean z4 = z2;
            if ((i2 & 4) != 0) {
                z3 = viewState.canProceedToNextStep;
            }
            boolean z5 = z3;
            if ((i2 & 8) != 0) {
                str = viewState.coverImage;
            }
            String str3 = str;
            if ((i2 & 16) != 0) {
                str2 = viewState.planDescription;
            }
            String str4 = str2;
            if ((i2 & 32) != 0) {
                bool = viewState.isFullServerGating;
            }
            Boolean bool2 = bool;
            if ((i2 & 64) != 0) {
                guildRoleSubscriptionTier = viewState.guildRoleSubscriptionTier;
            }
            return viewState.copy(i, z4, z5, str3, str4, bool2, guildRoleSubscriptionTier);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCurrentStep() {
            return this.currentStep;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsSubmitting() {
            return this.isSubmitting;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getCanProceedToNextStep() {
            return this.canProceedToNextStep;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCoverImage() {
            return this.coverImage;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getPlanDescription() {
            return this.planDescription;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getIsFullServerGating() {
            return this.isFullServerGating;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
            return this.guildRoleSubscriptionTier;
        }

        public final ViewState copy(int currentStep, boolean isSubmitting, boolean canProceedToNextStep, String coverImage, String planDescription, Boolean isFullServerGating, GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
            return new ViewState(currentStep, isSubmitting, canProceedToNextStep, coverImage, planDescription, isFullServerGating, guildRoleSubscriptionTier);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.currentStep == viewState.currentStep && this.isSubmitting == viewState.isSubmitting && this.canProceedToNextStep == viewState.canProceedToNextStep && Intrinsics3.areEqual(this.coverImage, viewState.coverImage) && Intrinsics3.areEqual(this.planDescription, viewState.planDescription) && Intrinsics3.areEqual(this.isFullServerGating, viewState.isFullServerGating) && Intrinsics3.areEqual(this.guildRoleSubscriptionTier, viewState.guildRoleSubscriptionTier);
        }

        public final boolean getCanProceedToNextStep() {
            return this.canProceedToNextStep;
        }

        public final String getCoverImage() {
            return this.coverImage;
        }

        public final int getCurrentStep() {
            return this.currentStep;
        }

        public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
            return this.guildRoleSubscriptionTier;
        }

        public final String getPlanDescription() {
            return this.planDescription;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5 */
        public int hashCode() {
            int i = this.currentStep * 31;
            boolean z2 = this.isSubmitting;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i2 = (i + r1) * 31;
            boolean z3 = this.canProceedToNextStep;
            int i3 = (i2 + (z3 ? 1 : z3)) * 31;
            String str = this.coverImage;
            int iHashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.planDescription;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Boolean bool = this.isFullServerGating;
            int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
            GuildRoleSubscriptionTier guildRoleSubscriptionTier = this.guildRoleSubscriptionTier;
            return iHashCode3 + (guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.hashCode() : 0);
        }

        public final Boolean isFullServerGating() {
            return this.isFullServerGating;
        }

        public final boolean isSubmitting() {
            return this.isSubmitting;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(currentStep=");
            sbU.append(this.currentStep);
            sbU.append(", isSubmitting=");
            sbU.append(this.isSubmitting);
            sbU.append(", canProceedToNextStep=");
            sbU.append(this.canProceedToNextStep);
            sbU.append(", coverImage=");
            sbU.append(this.coverImage);
            sbU.append(", planDescription=");
            sbU.append(this.planDescription);
            sbU.append(", isFullServerGating=");
            sbU.append(this.isFullServerGating);
            sbU.append(", guildRoleSubscriptionTier=");
            sbU.append(this.guildRoleSubscriptionTier);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ViewState(int i, boolean z2, boolean z3, String str, String str2, Boolean bool, GuildRoleSubscriptionTier guildRoleSubscriptionTier, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z2, (i2 & 4) == 0 ? z3 : false, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : str2, (i2 & 32) == 0 ? bool : null, (i2 & 64) != 0 ? new GuildRoleSubscriptionTier(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null) : guildRoleSubscriptionTier);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanSetupViewModel$submit$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionTierListing, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            invoke2(guildRoleSubscriptionTierListing);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierListing, "it");
            GuildRoleSubscriptionPlanSetupViewModel guildRoleSubscriptionPlanSetupViewModel = GuildRoleSubscriptionPlanSetupViewModel.this;
            guildRoleSubscriptionPlanSetupViewModel.updateViewState(ViewState.copy$default(GuildRoleSubscriptionPlanSetupViewModel.access$requireViewState(guildRoleSubscriptionPlanSetupViewModel), 0, false, false, null, null, null, null, Opcodes.LUSHR, null));
            GuildRoleSubscriptionPlanSetupViewModel.this.emitEvent(Event.SubmitSuccess.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanSetupViewModel$submit$2, reason: invalid class name */
    /* JADX INFO: compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            GuildRoleSubscriptionPlanSetupViewModel guildRoleSubscriptionPlanSetupViewModel = GuildRoleSubscriptionPlanSetupViewModel.this;
            guildRoleSubscriptionPlanSetupViewModel.updateViewState(ViewState.copy$default(GuildRoleSubscriptionPlanSetupViewModel.access$requireViewState(guildRoleSubscriptionPlanSetupViewModel), 0, false, false, null, null, null, null, Opcodes.LUSHR, null));
            GuildRoleSubscriptionPlanSetupViewModel.this.emitEvent(new Event.SubmitFailure(error));
        }
    }

    public /* synthetic */ GuildRoleSubscriptionPlanSetupViewModel(long j, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions);
    }

    public static final /* synthetic */ ViewState access$requireViewState(GuildRoleSubscriptionPlanSetupViewModel guildRoleSubscriptionPlanSetupViewModel) {
        return guildRoleSubscriptionPlanSetupViewModel.requireViewState();
    }

    private final boolean computeCanProceedToNextStep(ViewState viewState) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewState.getGuildRoleSubscriptionTier();
        int currentStep = viewState.getCurrentStep();
        if (currentStep != 0) {
            if (currentStep == 1) {
                String coverImage = viewState.getCoverImage();
                if (coverImage == null || StringsJVM.isBlank(coverImage)) {
                    return false;
                }
                String planDescription = viewState.getPlanDescription();
                if (planDescription == null || StringsJVM.isBlank(planDescription)) {
                    return false;
                }
            } else if (currentStep == 2) {
                String name = guildRoleSubscriptionTier.getName();
                if ((name == null || StringsJVM.isBlank(name)) || guildRoleSubscriptionTier.getPriceTier() == null) {
                    return false;
                }
                String image = guildRoleSubscriptionTier.getImage();
                if (image == null || StringsJVM.isBlank(image)) {
                    return false;
                }
            } else if (currentStep != 3 && currentStep != 4 && (currentStep != 5 || guildRoleSubscriptionTier.getMemberColor() == null)) {
                return false;
            }
        }
        return true;
    }

    @MainThread
    private final void emitEvent(Event event) {
        this.eventSubject.k.onNext(event);
    }

    public final void goToNextStep() {
        ViewState viewStateRequireViewState = requireViewState();
        updateViewState(ViewState.copy$default(viewStateRequireViewState, viewStateRequireViewState.getCurrentStep() + 1, false, false, null, null, null, null, 126, null));
    }

    public final void goToPreviousStep() {
        ViewState viewStateRequireViewState = requireViewState();
        updateViewState(ViewState.copy$default(viewStateRequireViewState, viewStateRequireViewState.getCurrentStep() - 1, false, false, null, null, null, null, 126, null));
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onSubscriptionPlanUpdated(String coverImage, String description, boolean isFullServerGating) {
        updateViewState(ViewState.copy$default(requireViewState(), 0, false, false, coverImage, description, Boolean.valueOf(isFullServerGating), null, 71, null));
    }

    public final void onTierUpdated(GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        updateViewState(ViewState.copy$default(requireViewState(), 0, false, false, null, null, null, guildRoleSubscriptionTier, 63, null));
    }

    public final void submit() {
        ViewState viewStateRequireViewState = requireViewState();
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewStateRequireViewState.getGuildRoleSubscriptionTier();
        String name = guildRoleSubscriptionTier.getName();
        if ((name == null || StringsJVM.isBlank(name)) || guildRoleSubscriptionTier.getPriceTier() == null || guildRoleSubscriptionTier.getMemberColor() == null) {
            return;
        }
        updateViewState(ViewState.copy$default(viewStateRequireViewState, 0, true, false, null, null, null, null, Opcodes.LUSHR, null));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.INSTANCE.createGuildRoleSubscriptionGroupListing(this.restApi, this.storeGuildRoleSubscriptions, this.guildId, viewStateRequireViewState.getCoverImage(), viewStateRequireViewState.getPlanDescription(), viewStateRequireViewState.isFullServerGating(), guildRoleSubscriptionTier.getName(), guildRoleSubscriptionTier.getDescription(), guildRoleSubscriptionTier.getPriceTier().intValue(), guildRoleSubscriptionTier.getImage(), ColorCompat.INSTANCE.removeAlphaComponent(guildRoleSubscriptionTier.getMemberColor().intValue()), guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(viewStateRequireViewState.isFullServerGating()), guildRoleSubscriptionTier.getChannelBenefits(), guildRoleSubscriptionTier.getIntangibleBenefits()), this, null, 2, null), (Class<?>) GuildRoleSubscriptionPlanSetupViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // b.a.d.AppViewModel
    public void updateViewState(ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        super.updateViewState(ViewState.copy$default(viewState, 0, false, computeCanProceedToNextStep(viewState), null, null, null, null, 123, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionPlanSetupViewModel(long j, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        super(new ViewState(0, false, false, null, null, null, null, Opcodes.LAND, null));
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        this.guildId = j;
        this.restApi = restAPI;
        this.storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.eventSubject = PublishSubject.k0();
    }
}
