package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import b.a.d.d0;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams$VerifyEmail;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubEmailViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailViewModel extends d0<HubEmailState> {
    private final boolean multiDomainEnabled;
    private final RestAPI restAPI;

    public WidgetHubEmailViewModel() {
        this(null, false, 3, null);
    }

    public /* synthetic */ WidgetHubEmailViewModel(RestAPI restAPI, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 2) != 0 ? GrowthTeamFeatures.INSTANCE.isMultiDomainEnabled() : z2);
    }

    public static final /* synthetic */ HubEmailState access$requireViewState(WidgetHubEmailViewModel widgetHubEmailViewModel) {
        return widgetHubEmailViewModel.requireViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubEmailViewModel widgetHubEmailViewModel, HubEmailState hubEmailState) {
        widgetHubEmailViewModel.updateViewState(hubEmailState);
    }

    public final boolean getMultiDomainEnabled() {
        return this.multiDomainEnabled;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void reset() {
        HubEmailState viewState = getViewState();
        m.checkNotNull(viewState);
        updateViewState(HubEmailState.copy$default(viewState, null, null, null, Default.INSTANCE, 5, null));
    }

    public final void setHubWaitlistResult(HubWaitlistResult waitlistResult) {
        m.checkNotNullParameter(waitlistResult, "waitlistResult");
        HubEmailState viewState = getViewState();
        m.checkNotNull(viewState);
        updateViewState(HubEmailState.copy$default(viewState, null, null, waitlistResult, null, 11, null));
    }

    public final void submitEmail(String email) {
        m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        RestCallStateKt.executeRequest(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.ui$default(this.restAPI.verifyEmail(new RestAPIParams$VerifyEmail(email, null, this.multiDomainEnabled, false, 10, null)), this, null, 2, null), WidgetHubEmailViewModel$submitEmail$1.INSTANCE), new WidgetHubEmailViewModel$submitEmail$2(this));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEmailViewModel(RestAPI restAPI, boolean z2) {
        super(new HubEmailState(null, null, null, null, 15, null));
        m.checkNotNullParameter(restAPI, "restAPI");
        this.restAPI = restAPI;
        this.multiDomainEnabled = z2;
    }
}
