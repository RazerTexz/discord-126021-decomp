package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionHubEmailVerifySend;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.hubs.EmailVerification;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubDomainsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomainsViewModel extends AbstractC0859d0<DomainsState> {
    private final boolean multiDomainEnabled;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainsViewModel$onGuildClicked$1 */
    /* JADX INFO: compiled from: WidgetHubDomainsViewModel.kt */
    public static final class C90321 extends AbstractC12240o implements Function1<EmailVerification, TrackNetworkMetadataReceiver> {
        public static final C90321 INSTANCE = new C90321();

        public C90321() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(EmailVerification emailVerification) {
            return new TrackNetworkActionHubEmailVerifySend(emailVerification != null ? Boolean.valueOf(emailVerification.getHasMatchingGuild()) : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainsViewModel$onGuildClicked$2 */
    /* JADX INFO: compiled from: WidgetHubDomainsViewModel.kt */
    public static final class C90332 extends AbstractC12240o implements Function1<RestCallState<? extends EmailVerification>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C90332(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends EmailVerification> restCallState) {
            invoke2((RestCallState<EmailVerification>) restCallState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<EmailVerification> restCallState) {
            C12238m.checkNotNullParameter(restCallState, "it");
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

    public static final /* synthetic */ DomainsState access$requireViewState(WidgetHubDomainsViewModel widgetHubDomainsViewModel) {
        return widgetHubDomainsViewModel.requireViewState();
    }

    public final boolean getMultiDomainEnabled() {
        return this.multiDomainEnabled;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void onGuildClicked(long guildId, String email) {
        C12238m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        RestCallStateKt.executeRequest(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.ui$default(this.restAPI.verifyEmail(new RestAPIParams.VerifyEmail(email, Long.valueOf(guildId), this.multiDomainEnabled, false, 8, null)), this, null, 2, null), C90321.INSTANCE), new C90332(guildId));
    }

    public final void reset() {
        updateViewState(requireViewState().copy(null, Default.INSTANCE));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomainsViewModel(RestAPI restAPI, boolean z2) {
        super(new DomainsState(null, null, 3, null));
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.restAPI = restAPI;
        this.multiDomainEnabled = z2;
    }
}
