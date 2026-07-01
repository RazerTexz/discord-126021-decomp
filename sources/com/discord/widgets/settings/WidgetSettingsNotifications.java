package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsNotificationsBinding;
import com.discord.stores.StoreNotifications;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsNotifications extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsNotifications.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsNotificationsBinding;", 0)};
    public static final WidgetSettingsNotifications$Companion Companion = new WidgetSettingsNotifications$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StoreNotifications notificationStore;

    public WidgetSettingsNotifications() {
        super(R$layout.widget_settings_notifications);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsNotifications$binding$2.INSTANCE, null, 2, null);
        this.notificationStore = StoreStream.Companion.getNotifications();
    }

    public static final /* synthetic */ WidgetSettingsNotificationsBinding access$getBinding$p(WidgetSettingsNotifications widgetSettingsNotifications) {
        return widgetSettingsNotifications.getBinding();
    }

    private final WidgetSettingsNotificationsBinding getBinding() {
        return (WidgetSettingsNotificationsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        Companion.launch(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131893385);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        StoreNotifications storeNotifications = this.notificationStore;
        getBinding().d.setOnCheckedListener(new WidgetSettingsNotifications$onViewBound$1$1(storeNotifications));
        getBinding().f2632b.setOnCheckedListener(new WidgetSettingsNotifications$onViewBound$1$2(storeNotifications));
        getBinding().c.setOnCheckedListener(new WidgetSettingsNotifications$onViewBound$1$3(storeNotifications));
        getBinding().f.setOnCheckedListener(new WidgetSettingsNotifications$onViewBound$1$4(storeNotifications));
        getBinding().e.setOnCheckedListener(new WidgetSettingsNotifications$onViewBound$1$5(storeNotifications));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.Companion.getNotifications().getSettings(), this, null, 2, null), WidgetSettingsNotifications.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsNotifications$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
