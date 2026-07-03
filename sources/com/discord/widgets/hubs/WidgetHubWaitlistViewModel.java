package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import com.discord.api.hubs.WaitlistSignup;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubWaitlistViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubWaitlistViewModel extends AbstractC0859d0<HubWaitlistState> {
    private final String email;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubWaitlistViewModel$joinWaitlist$1 */
    /* JADX INFO: compiled from: WidgetHubWaitlistViewModel.kt */
    public static final class C90471 extends AbstractC12240o implements Function1<RestCallState<? extends WaitlistSignup>, Unit> {
        public C90471() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends WaitlistSignup> restCallState) {
            invoke2((RestCallState<WaitlistSignup>) restCallState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<WaitlistSignup> restCallState) {
            C12238m.checkNotNullParameter(restCallState, "async");
            HubWaitlistState hubWaitlistStateAccess$getViewState$p = WidgetHubWaitlistViewModel.access$getViewState$p(WidgetHubWaitlistViewModel.this);
            if (hubWaitlistStateAccess$getViewState$p != null) {
                WidgetHubWaitlistViewModel.this.updateViewState(hubWaitlistStateAccess$getViewState$p.copy(restCallState));
            }
        }
    }

    public /* synthetic */ WidgetHubWaitlistViewModel(String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ HubWaitlistState access$getViewState$p(WidgetHubWaitlistViewModel widgetHubWaitlistViewModel) {
        return widgetHubWaitlistViewModel.getViewState();
    }

    public final String getEmail() {
        return this.email;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void joinWaitlist(String school) {
        C12238m.checkNotNullParameter(school, "school");
        RestCallStateKt.executeRequest(this.restAPI.joinHubWaitlist(new RestAPIParams.HubWaitlist(this.email, school)), new C90471());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubWaitlistViewModel(String str, RestAPI restAPI) {
        super(new HubWaitlistState(null, 1, null));
        C12238m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.email = str;
        this.restAPI = restAPI;
    }
}
