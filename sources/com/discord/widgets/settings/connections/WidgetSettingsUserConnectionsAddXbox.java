package com.discord.widgets.settings.connections;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import b.a.d.m;
import b.a.d.o;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppComponent;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetConnectionsAddXboxBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAddXbox extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsUserConnectionsAddXbox.class, "binding", "getBinding()Lcom/discord/databinding/WidgetConnectionsAddXboxBinding;", 0)};
    public static final WidgetSettingsUserConnectionsAddXbox$Companion Companion = new WidgetSettingsUserConnectionsAddXbox$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetSettingsUserConnectionsAddXbox() {
        super(R$layout.widget_connections_add_xbox);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsUserConnectionsAddXbox$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ WidgetConnectionsAddXboxBinding access$getBinding$p(WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox) {
        return widgetSettingsUserConnectionsAddXbox.getBinding();
    }

    public static final /* synthetic */ void access$showPinError(WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox) {
        widgetSettingsUserConnectionsAddXbox.showPinError();
    }

    public static final /* synthetic */ void access$trackXboxLinkFailed(WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox, Error error) {
        widgetSettingsUserConnectionsAddXbox.trackXboxLinkFailed(error);
    }

    private final WidgetConnectionsAddXboxBinding getBinding() {
        return (WidgetConnectionsAddXboxBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        Companion.launch(context);
    }

    private final void showPinError() {
        m.g(getContext(), 2131887856, 0, null, 12);
        getBinding().f2354b.b();
    }

    private final void trackXboxLinkFailed(Error error) {
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        String bodyText = error.getBodyText();
        Error$Response response = error.getResponse();
        d0.z.d.m.checkNotNullExpressionValue(response, "error.response");
        analyticsTracker.accountLinkFailed(bodyText, Integer.valueOf(response.getCode()), "pin", "PIN code entry", Platform.XBOX.getPlatformId());
    }

    private final void trackXboxLinkStep() {
        AnalyticsTracker.accountLinkStep$default(AnalyticsTracker.INSTANCE, "mobile connections", "PIN code entry", null, Platform.XBOX.getPlatformId(), 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131887872);
        trackXboxLinkStep();
        getBinding().c.setOnClickListener(WidgetSettingsUserConnectionsAddXbox$onViewBound$1.INSTANCE);
        getBinding().f2354b.setOnCodeEntered(new WidgetSettingsUserConnectionsAddXbox$onViewBound$2(this));
    }

    public final void submitPinCode(String verificationCode, Platform platform, DimmerView dimmer, AppComponent appComponent, Activity activity, Action1<Error> errorHandler) {
        d0.z.d.m.checkNotNullParameter(verificationCode, "verificationCode");
        d0.z.d.m.checkNotNullParameter(platform, "platform");
        d0.z.d.m.checkNotNullParameter(appComponent, "appComponent");
        d0.z.d.m.checkNotNullParameter(errorHandler, "errorHandler");
        Observable observableA = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getConnectionState(platform.getPlatformId(), verificationCode), false, 1, null).A(new WidgetSettingsUserConnectionsAddXbox$submitPinCode$1(platform));
        d0.z.d.m.checkNotNullExpressionValue(observableA, "RestAPI\n        .api\n   …              )\n        }");
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(observableA, appComponent, null, 2, null), dimmer, 0L, 2, null).k(o.a.g(activity, new WidgetSettingsUserConnectionsAddXbox$submitPinCode$2(activity), errorHandler));
    }
}
