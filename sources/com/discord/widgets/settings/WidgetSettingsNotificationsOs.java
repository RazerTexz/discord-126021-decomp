package com.discord.widgets.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetSettingsNotificationOsBinding;
import com.discord.stores.StoreNotifications;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.navigation.SystemSettingNavigators;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(26)
public final class WidgetSettingsNotificationsOs extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsNotificationsOs.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsNotificationOsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            new WidgetSettingsNotificationsOs().show(fragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsNotificationsOs$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<NotificationClient.SettingsV2, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NotificationClient.SettingsV2 settingsV2) {
            invoke2(settingsV2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NotificationClient.SettingsV2 settingsV2) {
            Intrinsics3.checkNotNullParameter(settingsV2, "settings");
            CheckedSetting checkedSetting = WidgetSettingsNotificationsOs.this.getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsNotificationSwitch");
            checkedSetting.setChecked(settingsV2.isEnabled());
            CheckedSetting checkedSetting2 = WidgetSettingsNotificationsOs.this.getBinding().f2631b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsInappNotifsSwitch");
            checkedSetting2.setChecked(settingsV2.isEnabledInApp());
        }
    }

    public WidgetSettingsNotificationsOs() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsNotificationsOs2.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsNotificationOsBinding getBinding() {
        return (WidgetSettingsNotificationOsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager) {
        INSTANCE.show(fragmentManager);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_settings_notification_os;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getNotifications().getSettings(), this, null, 2, null), (Class<?>) WidgetSettingsNotificationsOs.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().d.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsNotificationsOs.onViewCreated.1
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreNotifications notifications = StoreStream.INSTANCE.getNotifications();
                Intrinsics3.checkNotNullExpressionValue(bool, "it");
                notifications.setEnabled(bool.booleanValue());
            }
        });
        getBinding().f2631b.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsNotificationsOs.onViewCreated.2
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreNotifications notifications = StoreStream.INSTANCE.getNotifications();
                Intrinsics3.checkNotNullExpressionValue(bool, "it");
                StoreNotifications.setEnabledInApp$default(notifications, bool.booleanValue(), false, 2, null);
            }
        });
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsNotificationsOs.onViewCreated.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SystemSettingNavigators systemSettingNavigators = SystemSettingNavigators.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                systemSettingNavigators.openSystemNotification(context);
                WidgetSettingsNotificationsOs.this.dismiss();
            }
        });
    }
}
