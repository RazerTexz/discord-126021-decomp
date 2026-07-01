package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import com.discord.api.hubs.WaitlistSignup;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubWaitlistViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubWaitlistViewModel extends AppViewModel<WidgetHubWaitlistViewModel3> {
    private final String email;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubWaitlistViewModel$joinWaitlist$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubWaitlistViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestCallState<? extends WaitlistSignup>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends WaitlistSignup> restCallState) {
            invoke2((RestCallState<WaitlistSignup>) restCallState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<WaitlistSignup> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "async");
            WidgetHubWaitlistViewModel3 widgetHubWaitlistViewModel3Access$getViewState$p = WidgetHubWaitlistViewModel.access$getViewState$p(WidgetHubWaitlistViewModel.this);
            if (widgetHubWaitlistViewModel3Access$getViewState$p != null) {
                WidgetHubWaitlistViewModel.this.updateViewState(widgetHubWaitlistViewModel3Access$getViewState$p.copy(restCallState));
            }
        }
    }

    public /* synthetic */ WidgetHubWaitlistViewModel(String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ WidgetHubWaitlistViewModel3 access$getViewState$p(WidgetHubWaitlistViewModel widgetHubWaitlistViewModel) {
        return widgetHubWaitlistViewModel.getViewState();
    }

    public final String getEmail() {
        return this.email;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void joinWaitlist(String school) {
        Intrinsics3.checkNotNullParameter(school, "school");
        RestCallState5.executeRequest(this.restAPI.joinHubWaitlist(new RestAPIParams.HubWaitlist(this.email, school)), new AnonymousClass1());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubWaitlistViewModel(String str, RestAPI restAPI) {
        super(new WidgetHubWaitlistViewModel3(null, 1, null));
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.email = str;
        this.restAPI = restAPI;
    }
}
