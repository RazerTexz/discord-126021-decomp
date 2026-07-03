package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionHubEmailVerify;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionHubEmailVerifySend;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerificationCode;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthenticationViewModel extends AbstractC0859d0<HubAuthenticationState> {
    private final String email;
    private final Long guildId;
    private final boolean multiDomainEnabled;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$resendEmail$1 */
    /* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
    public static final class C90051 extends AbstractC12240o implements Function1<EmailVerification, TrackNetworkMetadataReceiver> {
        public static final C90051 INSTANCE = new C90051();

        public C90051() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(EmailVerification emailVerification) {
            return new TrackNetworkActionHubEmailVerifySend(emailVerification != null ? Boolean.valueOf(emailVerification.getHasMatchingGuild()) : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$resendEmail$2 */
    /* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
    public static final class C90062 extends AbstractC12240o implements Function1<RestCallState<? extends EmailVerification>, Unit> {
        public C90062() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends EmailVerification> restCallState) {
            invoke2((RestCallState<EmailVerification>) restCallState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<EmailVerification> restCallState) {
            C12238m.checkNotNullParameter(restCallState, "it");
            WidgetHubAuthenticationViewModel widgetHubAuthenticationViewModel = WidgetHubAuthenticationViewModel.this;
            widgetHubAuthenticationViewModel.updateViewState(HubAuthenticationState.copy$default(WidgetHubAuthenticationViewModel.access$requireViewState(widgetHubAuthenticationViewModel), null, restCallState, null, 5, null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$verifyCode$1 */
    /* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
    public static final class C90071 extends AbstractC12240o implements Function1<EmailVerificationCode, TrackNetworkMetadataReceiver> {
        public static final C90071 INSTANCE = new C90071();

        public C90071() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(EmailVerificationCode emailVerificationCode) {
            return new TrackNetworkActionHubEmailVerify();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$verifyCode$2 */
    /* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
    public static final class C90082 extends AbstractC12240o implements Function1<RestCallState<? extends EmailVerificationCode>, Unit> {
        public C90082() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends EmailVerificationCode> restCallState) {
            invoke2((RestCallState<EmailVerificationCode>) restCallState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<EmailVerificationCode> restCallState) {
            C12238m.checkNotNullParameter(restCallState, "response");
            WidgetHubAuthenticationViewModel widgetHubAuthenticationViewModel = WidgetHubAuthenticationViewModel.this;
            widgetHubAuthenticationViewModel.updateViewState(HubAuthenticationState.copy$default(WidgetHubAuthenticationViewModel.access$requireViewState(widgetHubAuthenticationViewModel), null, null, restCallState, 3, null));
        }
    }

    public /* synthetic */ WidgetHubAuthenticationViewModel(String str, Long l, RestAPI restAPI, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, l, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? GrowthTeamFeatures.INSTANCE.isMultiDomainEnabled() : z2);
    }

    public static final /* synthetic */ HubAuthenticationState access$requireViewState(WidgetHubAuthenticationViewModel widgetHubAuthenticationViewModel) {
        return widgetHubAuthenticationViewModel.requireViewState();
    }

    public final void resendEmail() {
        RestCallStateKt.executeRequest(RestCallStateKt.logNetworkAction(this.restAPI.verifyEmail(new RestAPIParams.VerifyEmail(this.email, this.guildId, this.multiDomainEnabled, false, 8, null)), C90051.INSTANCE), new C90062());
    }

    public final void verifyCode(String code) {
        C12238m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        RestCallStateKt.executeRequest(RestCallStateKt.logNetworkAction(this.restAPI.verifyEmailCode(new RestAPIParams.VerifyEmailCode(this.email, code, this.guildId)), C90071.INSTANCE), new C90082());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAuthenticationViewModel(String str, Long l, RestAPI restAPI, boolean z2) {
        super(new HubAuthenticationState(null, null, null, 7, null));
        C12238m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.email = str;
        this.guildId = l;
        this.restAPI = restAPI;
        this.multiDomainEnabled = z2;
    }
}
