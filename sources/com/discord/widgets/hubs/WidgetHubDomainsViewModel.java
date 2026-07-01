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

/* JADX INFO: compiled from: WidgetHubDomainsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomainsViewModel extends d0<DomainsState> {
    private final boolean multiDomainEnabled;
    private final RestAPI restAPI;

    public WidgetHubDomainsViewModel() {
        this(null, false, 3, null);
    }

    public /* synthetic */ WidgetHubDomainsViewModel(RestAPI restAPI, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 2) != 0 ? GrowthTeamFeatures.INSTANCE.isMultiDomainEnabled() : z2);
    }

    public static final /* synthetic */ DomainsState access$requireViewState(WidgetHubDomainsViewModel widgetHubDomainsViewModel) {
        return widgetHubDomainsViewModel.requireViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubDomainsViewModel widgetHubDomainsViewModel, DomainsState domainsState) {
        widgetHubDomainsViewModel.updateViewState(domainsState);
    }

    public final boolean getMultiDomainEnabled() {
        return this.multiDomainEnabled;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void onGuildClicked(long guildId, String email) {
        m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        RestCallStateKt.executeRequest(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.ui$default(this.restAPI.verifyEmail(new RestAPIParams$VerifyEmail(email, Long.valueOf(guildId), this.multiDomainEnabled, false, 8, null)), this, null, 2, null), WidgetHubDomainsViewModel$onGuildClicked$1.INSTANCE), new WidgetHubDomainsViewModel$onGuildClicked$2(this, guildId));
    }

    public final void reset() {
        updateViewState(requireViewState().copy(null, Default.INSTANCE));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomainsViewModel(RestAPI restAPI, boolean z2) {
        super(new DomainsState(null, null, 3, null));
        m.checkNotNullParameter(restAPI, "restAPI");
        this.restAPI = restAPI;
        this.multiDomainEnabled = z2;
    }
}
