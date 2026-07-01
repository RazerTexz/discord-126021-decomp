package com.discord.widgets.servers.member_verification;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelMemberVerificationForm;
import com.discord.models.domain.ModelMemberVerificationFormResponse;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildMemberVerificationForm;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DialogState dialogState;
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
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
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            MemberVerificationPendingViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableI = Observable.i(companion.getMemberVerificationForms().observeMemberVerificationFormData(guildId), companion.getGuilds().observeGuild(guildId), companion.getGuildJoinRequests().observeGuildJoinRequest(guildId), new Func3<StoreGuildMemberVerificationForm.MemberVerificationFormData, Guild, GuildJoinRequest, StoreState>() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$Companion$observeStores$1
                @Override // rx.functions.Func3
                public final MemberVerificationPendingViewModel.StoreState call(StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData, Guild guild, GuildJoinRequest guildJoinRequest) {
                    ApplicationStatus applicationStatus;
                    ModelMemberVerificationForm form;
                    boolean z2 = (memberVerificationFormData == null || (form = memberVerificationFormData.getForm()) == null || !form.isFormOutdated()) ? false : true;
                    boolean zHasFeature = guild != null ? guild.hasFeature(GuildFeature.PREVIEW_ENABLED) : false;
                    if (guildJoinRequest == null || (applicationStatus = guildJoinRequest.getApplicationStatus()) == null) {
                        applicationStatus = ApplicationStatus.STARTED;
                    }
                    return new MemberVerificationPendingViewModel.StoreState(z2, zHasFeature, applicationStatus, guildJoinRequest != null ? guildJoinRequest.getRejectionReason() : null);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…Reason,\n        )\n      }");
            return observableI;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
    public enum DialogState {
        UPGRADE,
        PENDING,
        CANCEL,
        REJECTED,
        LEAVE
    }

    /* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
        public static final class Error extends Event {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
        public static final class Success extends Event {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
    public static final /* data */ class StoreState {
        private final ApplicationStatus applicationStatus;
        private final boolean isFormOutdated;
        private final boolean isPreviewEnabled;
        private final String rejectionReason;

        public StoreState(boolean z2, boolean z3, ApplicationStatus applicationStatus, String str) {
            Intrinsics3.checkNotNullParameter(applicationStatus, "applicationStatus");
            this.isFormOutdated = z2;
            this.isPreviewEnabled = z3;
            this.applicationStatus = applicationStatus;
            this.rejectionReason = str;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, boolean z2, boolean z3, ApplicationStatus applicationStatus, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = storeState.isFormOutdated;
            }
            if ((i & 2) != 0) {
                z3 = storeState.isPreviewEnabled;
            }
            if ((i & 4) != 0) {
                applicationStatus = storeState.applicationStatus;
            }
            if ((i & 8) != 0) {
                str = storeState.rejectionReason;
            }
            return storeState.copy(z2, z3, applicationStatus, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsFormOutdated() {
            return this.isFormOutdated;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsPreviewEnabled() {
            return this.isPreviewEnabled;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ApplicationStatus getApplicationStatus() {
            return this.applicationStatus;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getRejectionReason() {
            return this.rejectionReason;
        }

        public final StoreState copy(boolean isFormOutdated, boolean isPreviewEnabled, ApplicationStatus applicationStatus, String rejectionReason) {
            Intrinsics3.checkNotNullParameter(applicationStatus, "applicationStatus");
            return new StoreState(isFormOutdated, isPreviewEnabled, applicationStatus, rejectionReason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.isFormOutdated == storeState.isFormOutdated && this.isPreviewEnabled == storeState.isPreviewEnabled && Intrinsics3.areEqual(this.applicationStatus, storeState.applicationStatus) && Intrinsics3.areEqual(this.rejectionReason, storeState.rejectionReason);
        }

        public final ApplicationStatus getApplicationStatus() {
            return this.applicationStatus;
        }

        public final String getRejectionReason() {
            return this.rejectionReason;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            boolean z2 = this.isFormOutdated;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isPreviewEnabled;
            int i2 = (i + (z3 ? 1 : z3)) * 31;
            ApplicationStatus applicationStatus = this.applicationStatus;
            int iHashCode = (i2 + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
            String str = this.rejectionReason;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public final boolean isFormOutdated() {
            return this.isFormOutdated;
        }

        public final boolean isPreviewEnabled() {
            return this.isPreviewEnabled;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(isFormOutdated=");
            sbU.append(this.isFormOutdated);
            sbU.append(", isPreviewEnabled=");
            sbU.append(this.isPreviewEnabled);
            sbU.append(", applicationStatus=");
            sbU.append(this.applicationStatus);
            sbU.append(", rejectionReason=");
            return outline.J(sbU, this.rejectionReason, ")");
        }
    }

    /* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final DialogState dialogState;
            private final boolean isPreviewEnabled;
            private final String rejectionReason;
            private final boolean showPendingImage;
            private final boolean showTertiaryButton;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(DialogState dialogState, boolean z2, boolean z3, boolean z4, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(dialogState, "dialogState");
                this.dialogState = dialogState;
                this.showPendingImage = z2;
                this.showTertiaryButton = z3;
                this.isPreviewEnabled = z4;
                this.rejectionReason = str;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, DialogState dialogState, boolean z2, boolean z3, boolean z4, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    dialogState = loaded.dialogState;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.showPendingImage;
                }
                boolean z5 = z2;
                if ((i & 4) != 0) {
                    z3 = loaded.showTertiaryButton;
                }
                boolean z6 = z3;
                if ((i & 8) != 0) {
                    z4 = loaded.isPreviewEnabled;
                }
                boolean z7 = z4;
                if ((i & 16) != 0) {
                    str = loaded.rejectionReason;
                }
                return loaded.copy(dialogState, z5, z6, z7, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DialogState getDialogState() {
                return this.dialogState;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getShowPendingImage() {
                return this.showPendingImage;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getShowTertiaryButton() {
                return this.showTertiaryButton;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsPreviewEnabled() {
                return this.isPreviewEnabled;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getRejectionReason() {
                return this.rejectionReason;
            }

            public final Loaded copy(DialogState dialogState, boolean showPendingImage, boolean showTertiaryButton, boolean isPreviewEnabled, String rejectionReason) {
                Intrinsics3.checkNotNullParameter(dialogState, "dialogState");
                return new Loaded(dialogState, showPendingImage, showTertiaryButton, isPreviewEnabled, rejectionReason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.dialogState, loaded.dialogState) && this.showPendingImage == loaded.showPendingImage && this.showTertiaryButton == loaded.showTertiaryButton && this.isPreviewEnabled == loaded.isPreviewEnabled && Intrinsics3.areEqual(this.rejectionReason, loaded.rejectionReason);
            }

            public final DialogState getDialogState() {
                return this.dialogState;
            }

            public final String getRejectionReason() {
                return this.rejectionReason;
            }

            public final boolean getShowPendingImage() {
                return this.showPendingImage;
            }

            public final boolean getShowTertiaryButton() {
                return this.showTertiaryButton;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3, types: [int] */
            /* JADX WARN: Type inference failed for: r2v6 */
            /* JADX WARN: Type inference failed for: r2v7 */
            /* JADX WARN: Type inference failed for: r2v8 */
            /* JADX WARN: Type inference failed for: r2v9 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                DialogState dialogState = this.dialogState;
                int iHashCode = (dialogState != null ? dialogState.hashCode() : 0) * 31;
                boolean z2 = this.showPendingImage;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode + r2) * 31;
                boolean z3 = this.showTertiaryButton;
                ?? r3 = z3;
                if (z3) {
                    r3 = 1;
                }
                int i2 = (i + r3) * 31;
                boolean z4 = this.isPreviewEnabled;
                int i3 = (i2 + (z4 ? 1 : z4)) * 31;
                String str = this.rejectionReason;
                return i3 + (str != null ? str.hashCode() : 0);
            }

            public final boolean isPreviewEnabled() {
                return this.isPreviewEnabled;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(dialogState=");
                sbU.append(this.dialogState);
                sbU.append(", showPendingImage=");
                sbU.append(this.showPendingImage);
                sbU.append(", showTertiaryButton=");
                sbU.append(this.showTertiaryButton);
                sbU.append(", isPreviewEnabled=");
                sbU.append(this.isPreviewEnabled);
                sbU.append(", rejectionReason=");
                return outline.J(sbU, this.rejectionReason, ")");
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
            ApplicationStatus.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationStatus.PENDING.ordinal()] = 1;
            iArr[ApplicationStatus.REJECTED.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$deleteGuildJoinRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            MemberVerificationPendingViewModel.this.eventSubject.k.onNext((T) Event.Error.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$deleteGuildJoinRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<ModelMemberVerificationFormResponse, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            invoke2(modelMemberVerificationFormResponse);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            MemberVerificationPendingViewModel.this.onResetSuccess();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$leaveGuild$1, reason: invalid class name */
    /* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            MemberVerificationPendingViewModel.this.eventSubject.k.onNext((T) Event.Error.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$leaveGuild$2, reason: invalid class name */
    /* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            MemberVerificationPendingViewModel.this.eventSubject.k.onNext((T) Event.Success.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$resetGuildJoinRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            MemberVerificationPendingViewModel.this.eventSubject.k.onNext((T) Event.Error.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$resetGuildJoinRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<ModelMemberVerificationFormResponse, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            invoke2(modelMemberVerificationFormResponse);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            Intrinsics3.checkNotNullParameter(modelMemberVerificationFormResponse, "it");
            MemberVerificationPendingViewModel.this.onResetSuccess();
        }
    }

    public /* synthetic */ MemberVerificationPendingViewModel(long j, DialogState dialogState, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, dialogState, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? INSTANCE.observeStores(j) : observable);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        DialogState dialogState = this.dialogState;
        if (dialogState == null) {
            int iOrdinal = storeState.getApplicationStatus().ordinal();
            if (iOrdinal != 1) {
                dialogState = iOrdinal != 2 ? null : DialogState.REJECTED;
            } else {
                dialogState = storeState.isPreviewEnabled() ? DialogState.CANCEL : DialogState.PENDING;
            }
        }
        DialogState dialogState2 = dialogState;
        if (storeState.isFormOutdated()) {
            updateViewState(new ViewState.Loaded(DialogState.UPGRADE, true, false, storeState.isPreviewEnabled(), storeState.getRejectionReason()));
        } else if (dialogState2 != null) {
            updateViewState(new ViewState.Loaded(dialogState2, true, false, storeState.isPreviewEnabled(), storeState.getRejectionReason()));
        }
    }

    private final void onResetSuccess() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Success.INSTANCE);
    }

    public final void deleteGuildJoinRequest() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.deleteGuildJoinRequest(this.guildId), false, 1, null), this, null, 2, null), (Class<?>) MemberVerificationPendingViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    public final void leaveGuild() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.leaveGuild(this.guildId), false, 1, null), this, null, 2, null), (Class<?>) MemberVerificationPendingViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    public final Observable<Event> observeEvents() {
        return this.eventSubject;
    }

    public final void resetGuildJoinRequest() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.resetGuildJoinRequest(this.guildId), false, 1, null), this, null, 2, null), (Class<?>) MemberVerificationPendingViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    public final void updateDialogState(DialogState dialogState) {
        Intrinsics3.checkNotNullParameter(dialogState, "dialogState");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            DialogState dialogState2 = DialogState.PENDING;
            updateViewState(ViewState.Loaded.copy$default(loaded, dialogState, dialogState == dialogState2, dialogState == dialogState2 && !loaded.isPreviewEnabled(), false, null, 24, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationPendingViewModel(long j, DialogState dialogState, RestAPI restAPI, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.dialogState = dialogState;
        this.restAPI = restAPI;
        PublishSubject<Event> publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) MemberVerificationPendingViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
