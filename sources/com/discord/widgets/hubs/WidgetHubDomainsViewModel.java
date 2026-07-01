package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionHubEmailVerifySend;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.hubs.EmailVerification;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubDomainsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomainsViewModel extends AppViewModel<WidgetHubDomainsViewModel2> {
    private final boolean multiDomainEnabled;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainsViewModel$onGuildClicked$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubDomainsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<EmailVerification, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadata2 invoke(EmailVerification emailVerification) {
            return new TrackNetworkActionHubEmailVerifySend(emailVerification != null ? Boolean.valueOf(emailVerification.getHasMatchingGuild()) : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainsViewModel$onGuildClicked$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubDomainsViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestCallState<? extends EmailVerification>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends EmailVerification> restCallState) {
            invoke2((RestCallState<EmailVerification>) restCallState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<EmailVerification> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "it");
            WidgetHubDomainsViewModel widgetHubDomainsViewModel = WidgetHubDomainsViewModel.this;
            widgetHubDomainsViewModel.updateViewState(WidgetHubDomainsViewModel.access$requireViewState(widgetHubDomainsViewModel).copy(Long.valueOf(this.$guildId), restCallState));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetHubDomainsViewModel() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ WidgetHubDomainsViewModel(RestAPI restAPI, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 2) != 0 ? GrowthTeamFeatures.INSTANCE.isMultiDomainEnabled() : z2);
    }

    public static final /* synthetic */ WidgetHubDomainsViewModel2 access$requireViewState(WidgetHubDomainsViewModel widgetHubDomainsViewModel) {
        return widgetHubDomainsViewModel.requireViewState();
    }

    public final boolean getMultiDomainEnabled() {
        return this.multiDomainEnabled;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void onGuildClicked(long guildId, String email) {
        Intrinsics3.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        RestCallState5.executeRequest(RestCallState5.logNetworkAction(ObservableExtensionsKt.ui$default(this.restAPI.verifyEmail(new RestAPIParams.VerifyEmail(email, Long.valueOf(guildId), this.multiDomainEnabled, false, 8, null)), this, null, 2, null), AnonymousClass1.INSTANCE), new AnonymousClass2(guildId));
    }

    public final void reset() {
        updateViewState(requireViewState().copy(null, RestCallState2.INSTANCE));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomainsViewModel(RestAPI restAPI, boolean z2) {
        super(new WidgetHubDomainsViewModel2(null, null, 3, null));
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.restAPI = restAPI;
        this.multiDomainEnabled = z2;
    }
}
