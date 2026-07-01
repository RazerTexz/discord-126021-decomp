package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import b.a.d.d0;
import com.discord.restapi.RestAPIParams$HubWaitlist;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubWaitlistViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubWaitlistViewModel extends d0<HubWaitlistState> {
    private final String email;
    private final RestAPI restAPI;

    public /* synthetic */ WidgetHubWaitlistViewModel(String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ HubWaitlistState access$getViewState$p(WidgetHubWaitlistViewModel widgetHubWaitlistViewModel) {
        return widgetHubWaitlistViewModel.getViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubWaitlistViewModel widgetHubWaitlistViewModel, HubWaitlistState hubWaitlistState) {
        widgetHubWaitlistViewModel.updateViewState(hubWaitlistState);
    }

    public final String getEmail() {
        return this.email;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void joinWaitlist(String school) {
        m.checkNotNullParameter(school, "school");
        RestCallStateKt.executeRequest(this.restAPI.joinHubWaitlist(new RestAPIParams$HubWaitlist(this.email, school)), new WidgetHubWaitlistViewModel$joinWaitlist$1(this));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubWaitlistViewModel(String str, RestAPI restAPI) {
        super(new HubWaitlistState(null, 1, null));
        m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        m.checkNotNullParameter(restAPI, "restAPI");
        this.email = str;
        this.restAPI = restAPI;
    }
}
