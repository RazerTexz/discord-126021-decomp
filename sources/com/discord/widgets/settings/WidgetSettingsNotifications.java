package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsNotificationsBinding;
import com.discord.stores.StoreNotifications;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
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

/* JADX INFO: compiled from: WidgetSettingsNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsNotifications extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsNotifications.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsNotificationsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StoreNotifications notificationStore;

    /* JADX INFO: compiled from: WidgetSettingsNotifications.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsNotifications.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsNotifications$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsNotifications.kt */
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
            LinearLayout linearLayout = WidgetSettingsNotifications.this.getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsNotificationsWrap");
            linearLayout.setVisibility(settingsV2.isEnabled() ? 0 : 8);
            CheckedSetting checkedSetting = WidgetSettingsNotifications.this.getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsNotificationsEnabled");
            checkedSetting.setChecked(settingsV2.isEnabled());
            CheckedSetting checkedSetting2 = WidgetSettingsNotifications.this.getBinding().f2632b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsInappNotifsSwitch");
            checkedSetting2.setChecked(settingsV2.isEnabledInApp());
            CheckedSetting checkedSetting3 = WidgetSettingsNotifications.this.getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.settingsNotificationsBlink");
            checkedSetting3.setChecked(settingsV2.isDisableBlink());
            CheckedSetting checkedSetting4 = WidgetSettingsNotifications.this.getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.settingsNotificationsVibrations");
            checkedSetting4.setChecked(settingsV2.isDisableVibrate());
            CheckedSetting checkedSetting5 = WidgetSettingsNotifications.this.getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.settingsNotificationsMuteAll");
            checkedSetting5.setChecked(settingsV2.isDisableSound());
        }
    }

    public WidgetSettingsNotifications() {
        super(R.layout.widget_settings_notifications);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsNotifications2.INSTANCE, null, 2, null);
        this.notificationStore = StoreStream.INSTANCE.getNotifications();
    }

    private final WidgetSettingsNotificationsBinding getBinding() {
        return (WidgetSettingsNotificationsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.notifications);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        final StoreNotifications storeNotifications = this.notificationStore;
        getBinding().d.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsNotifications$onViewBound$1$1
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreNotifications storeNotifications2 = storeNotifications;
                Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
                storeNotifications2.setEnabled(bool.booleanValue());
            }
        });
        getBinding().f2632b.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsNotifications$onViewBound$1$2
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreNotifications storeNotifications2 = storeNotifications;
                Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
                StoreNotifications.setEnabledInApp$default(storeNotifications2, bool.booleanValue(), false, 2, null);
            }
        });
        getBinding().c.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsNotifications$onViewBound$1$3
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreNotifications storeNotifications2 = storeNotifications;
                Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
                storeNotifications2.setNotificationLightDisabled(bool.booleanValue());
            }
        });
        getBinding().f.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsNotifications$onViewBound$1$4
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreNotifications storeNotifications2 = storeNotifications;
                Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
                storeNotifications2.setNotificationsVibrateDisabled(bool.booleanValue());
            }
        });
        getBinding().e.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsNotifications$onViewBound$1$5
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreNotifications storeNotifications2 = storeNotifications;
                Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
                storeNotifications2.setNotificationSoundDisabled(bool.booleanValue());
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getNotifications().getSettings(), this, null, 2, null), (Class<?>) WidgetSettingsNotifications.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
