package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import b.a.d.d0;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams$VerifyEmail;
import com.discord.restapi.RestAPIParams$VerifyEmailCode;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthenticationViewModel extends d0<HubAuthenticationState> {
    private final String email;
    private final Long guildId;
    private final boolean multiDomainEnabled;
    private final RestAPI restAPI;

    public /* synthetic */ WidgetHubAuthenticationViewModel(String str, Long l, RestAPI restAPI, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, l, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 8) != 0 ? GrowthTeamFeatures.INSTANCE.isMultiDomainEnabled() : z2);
    }

    public static final /* synthetic */ HubAuthenticationState access$requireViewState(WidgetHubAuthenticationViewModel widgetHubAuthenticationViewModel) {
        return widgetHubAuthenticationViewModel.requireViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubAuthenticationViewModel widgetHubAuthenticationViewModel, HubAuthenticationState hubAuthenticationState) {
        widgetHubAuthenticationViewModel.updateViewState(hubAuthenticationState);
    }

    public final void resendEmail() {
        RestCallStateKt.executeRequest(RestCallStateKt.logNetworkAction(this.restAPI.verifyEmail(new RestAPIParams$VerifyEmail(this.email, this.guildId, this.multiDomainEnabled, false, 8, null)), WidgetHubAuthenticationViewModel$resendEmail$1.INSTANCE), new WidgetHubAuthenticationViewModel$resendEmail$2(this));
    }

    public final void verifyCode(String code) {
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        RestCallStateKt.executeRequest(RestCallStateKt.logNetworkAction(this.restAPI.verifyEmailCode(new RestAPIParams$VerifyEmailCode(this.email, code, this.guildId)), WidgetHubAuthenticationViewModel$verifyCode$1.INSTANCE), new WidgetHubAuthenticationViewModel$verifyCode$2(this));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAuthenticationViewModel(String str, Long l, RestAPI restAPI, boolean z2) {
        super(new HubAuthenticationState(null, null, null, 7, null));
        m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        m.checkNotNullParameter(restAPI, "restAPI");
        this.email = str;
        this.guildId = l;
        this.restAPI = restAPI;
        this.multiDomainEnabled = z2;
    }
}
