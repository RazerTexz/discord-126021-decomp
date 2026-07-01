package com.discord.widgets.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetSettingsNotificationOsBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(26)
public final class WidgetSettingsNotificationsOs extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsNotificationsOs.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsNotificationOsBinding;", 0)};
    public static final WidgetSettingsNotificationsOs$Companion Companion = new WidgetSettingsNotificationsOs$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetSettingsNotificationsOs() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsNotificationsOs$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ WidgetSettingsNotificationOsBinding access$getBinding$p(WidgetSettingsNotificationsOs widgetSettingsNotificationsOs) {
        return widgetSettingsNotificationsOs.getBinding();
    }

    private final WidgetSettingsNotificationOsBinding getBinding() {
        return (WidgetSettingsNotificationOsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager) {
        Companion.show(fragmentManager);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_settings_notification_os;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.Companion.getNotifications().getSettings(), this, null, 2, null), WidgetSettingsNotificationsOs.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsNotificationsOs$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().d.setOnCheckedListener(WidgetSettingsNotificationsOs$onViewCreated$1.INSTANCE);
        getBinding().f2631b.setOnCheckedListener(WidgetSettingsNotificationsOs$onViewCreated$2.INSTANCE);
        getBinding().c.setOnClickListener(new WidgetSettingsNotificationsOs$onViewCreated$3(this));
    }
}
