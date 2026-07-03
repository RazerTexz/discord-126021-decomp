package com.discord.widgets.settings.connections;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppComponent;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetConnectionsAddXboxBinding;
import com.discord.models.domain.ModelConnectionState;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAddXbox extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsUserConnectionsAddXbox.class, "binding", "getBinding()Lcom/discord/databinding/WidgetConnectionsAddXboxBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetSettingsUserConnectionsAddXbox.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
    public static final class C98372 extends AbstractC12240o implements Function1<String, Unit> {
        public C98372() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "verificationCode");
            if (str.length() == 6) {
                WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox = WidgetSettingsUserConnectionsAddXbox.this;
                Platform platform = Platform.XBOX;
                DimmerView dimmerView = widgetSettingsUserConnectionsAddXbox.getBinding().f16408d;
                WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox2 = WidgetSettingsUserConnectionsAddXbox.this;
                widgetSettingsUserConnectionsAddXbox.submitPinCode(str, platform, dimmerView, widgetSettingsUserConnectionsAddXbox2, widgetSettingsUserConnectionsAddXbox2.m95e(), new Action1<Error>() { // from class: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox.onViewBound.2.1
                    @Override // p658rx.functions.Action1
                    public final void call(Error error) {
                        WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox3 = WidgetSettingsUserConnectionsAddXbox.this;
                        C12238m.checkNotNullExpressionValue(error, "error");
                        widgetSettingsUserConnectionsAddXbox3.trackXboxLinkFailed(error);
                        if (error.getType() == Error.Type.DISCORD_REQUEST_ERROR) {
                            error.setShowErrorToasts(false);
                            WidgetSettingsUserConnectionsAddXbox.this.showPinError();
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox$submitPinCode$2 */
    /* JADX INFO: compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
    public static final class C98392 extends AbstractC12240o implements Function1<Void, Unit> {
        public final /* synthetic */ Activity $activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C98392(Activity activity) {
            super(1);
            this.$activity = activity;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            Activity activity = this.$activity;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public WidgetSettingsUserConnectionsAddXbox() {
        super(C5419R.layout.widget_connections_add_xbox);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsUserConnectionsAddXbox$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetConnectionsAddXboxBinding getBinding() {
        return (WidgetConnectionsAddXboxBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    private final void showPinError() {
        C0876m.m169g(getContext(), C5419R.string.connection_invalid_pin, 0, null, 12);
        getBinding().f16406b.m8538b();
    }

    private final void trackXboxLinkFailed(Error error) {
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        String bodyText = error.getBodyText();
        Error.Response response = error.getResponse();
        C12238m.checkNotNullExpressionValue(response, "error.response");
        analyticsTracker.accountLinkFailed(bodyText, Integer.valueOf(response.getCode()), "pin", "PIN code entry", Platform.XBOX.getPlatformId());
    }

    private final void trackXboxLinkStep() {
        AnalyticsTracker.accountLinkStep$default(AnalyticsTracker.INSTANCE, "mobile connections", "PIN code entry", null, Platform.XBOX.getPlatformId(), 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.connections);
        trackXboxLinkStep();
        getBinding().f16407c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StoreUserConnections userConnections = StoreStream.INSTANCE.getUserConnections();
                String platformId = Platform.XBOX.getPlatformId();
                C12238m.checkNotNullExpressionValue(view2, "v");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "v.context");
                userConnections.authorizeConnection(platformId, context, Traits.Location.Page.USER_SETTINGS);
            }
        });
        getBinding().f16406b.setOnCodeEntered(new C98372());
    }

    public final void submitPinCode(String verificationCode, final Platform platform, DimmerView dimmer, AppComponent appComponent, Activity activity, Action1<Error> errorHandler) {
        C12238m.checkNotNullParameter(verificationCode, "verificationCode");
        C12238m.checkNotNullParameter(platform, "platform");
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        C12238m.checkNotNullParameter(errorHandler, "errorHandler");
        Observable observableM11082A = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getConnectionState(platform.getPlatformId(), verificationCode), false, 1, null).m11082A(new InterfaceC12589b<ModelConnectionState, Observable<? extends Void>>() { // from class: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox.submitPinCode.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Void> call(ModelConnectionState modelConnectionState) {
                AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                C12238m.checkNotNullExpressionValue(modelConnectionState, "state");
                analyticsTracker.accountLinkStep("PIN code entry", "PIN success", modelConnectionState.getState(), platform.getPlatformId());
                RestAPI api = RestAPI.INSTANCE.getApi();
                String platformId = platform.getPlatformId();
                String code = modelConnectionState.getCode();
                String state = modelConnectionState.getState();
                Boolean bool = Boolean.TRUE;
                return api.submitConnectionState(platformId, new RestAPIParams.ConnectionState(code, state, bool, bool));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11082A, "RestAPI\n        .api\n   …              )\n        }");
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(observableM11082A, appComponent, null, 2, null), dimmer, 0L, 2, null).m11108k(C0879o.f566a.m184g(activity, new C98392(activity), errorHandler));
    }
}
