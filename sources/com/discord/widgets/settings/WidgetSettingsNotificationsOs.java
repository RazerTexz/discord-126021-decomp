package com.discord.widgets.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetSettingsNotificationOsBinding;
import com.discord.stores.StoreNotifications;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.navigation.SystemSettingNavigators;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(26)
public final class WidgetSettingsNotificationsOs extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsNotificationsOs.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsNotificationOsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            new WidgetSettingsNotificationsOs().show(fragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsNotificationsOs$onResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
    public static final class C96541 extends AbstractC12240o implements Function1<NotificationClient.SettingsV2, Unit> {
        public C96541() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NotificationClient.SettingsV2 settingsV2) {
            invoke2(settingsV2);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NotificationClient.SettingsV2 settingsV2) {
            C12238m.checkNotNullParameter(settingsV2, "settings");
            CheckedSetting checkedSetting = WidgetSettingsNotificationsOs.this.getBinding().f18021d;
            C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsNotificationSwitch");
            checkedSetting.setChecked(settingsV2.isEnabled());
            CheckedSetting checkedSetting2 = WidgetSettingsNotificationsOs.this.getBinding().f18019b;
            C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsInappNotifsSwitch");
            checkedSetting2.setChecked(settingsV2.isEnabledInApp());
        }
    }

    public WidgetSettingsNotificationsOs() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsNotificationsOs$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsNotificationOsBinding getBinding() {
        return (WidgetSettingsNotificationOsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager) {
        INSTANCE.show(fragmentManager);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_settings_notification_os;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getNotifications().getSettings(), this, null, 2, null), (Class<?>) WidgetSettingsNotificationsOs.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C96541());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f18021d.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsNotificationsOs.onViewCreated.1
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreNotifications notifications = StoreStream.INSTANCE.getNotifications();
                C12238m.checkNotNullExpressionValue(bool, "it");
                notifications.setEnabled(bool.booleanValue());
            }
        });
        getBinding().f18019b.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsNotificationsOs.onViewCreated.2
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreNotifications notifications = StoreStream.INSTANCE.getNotifications();
                C12238m.checkNotNullExpressionValue(bool, "it");
                StoreNotifications.setEnabledInApp$default(notifications, bool.booleanValue(), false, 2, null);
            }
        });
        getBinding().f18020c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsNotificationsOs.onViewCreated.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SystemSettingNavigators systemSettingNavigators = SystemSettingNavigators.INSTANCE;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                systemSettingNavigators.openSystemNotification(context);
                WidgetSettingsNotificationsOs.this.dismiss();
            }
        });
    }
}
