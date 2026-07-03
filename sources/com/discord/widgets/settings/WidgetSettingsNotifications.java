package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsNotificationsBinding;
import com.discord.stores.StoreNotifications;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsNotifications extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsNotifications.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsNotificationsBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetSettingsNotifications.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsNotifications$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsNotifications.kt */
    public static final class C96531 extends AbstractC12240o implements Function1<NotificationClient.SettingsV2, Unit> {
        public C96531() {
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
            LinearLayout linearLayout = WidgetSettingsNotifications.this.getBinding().f18028g;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.settingsNotificationsWrap");
            linearLayout.setVisibility(settingsV2.isEnabled() ? 0 : 8);
            CheckedSetting checkedSetting = WidgetSettingsNotifications.this.getBinding().f18025d;
            C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsNotificationsEnabled");
            checkedSetting.setChecked(settingsV2.isEnabled());
            CheckedSetting checkedSetting2 = WidgetSettingsNotifications.this.getBinding().f18023b;
            C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsInappNotifsSwitch");
            checkedSetting2.setChecked(settingsV2.isEnabledInApp());
            CheckedSetting checkedSetting3 = WidgetSettingsNotifications.this.getBinding().f18024c;
            C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.settingsNotificationsBlink");
            checkedSetting3.setChecked(settingsV2.isDisableBlink());
            CheckedSetting checkedSetting4 = WidgetSettingsNotifications.this.getBinding().f18027f;
            C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.settingsNotificationsVibrations");
            checkedSetting4.setChecked(settingsV2.isDisableVibrate());
            CheckedSetting checkedSetting5 = WidgetSettingsNotifications.this.getBinding().f18026e;
            C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.settingsNotificationsMuteAll");
            checkedSetting5.setChecked(settingsV2.isDisableSound());
        }
    }

    public WidgetSettingsNotifications() {
        super(C5419R.layout.widget_settings_notifications);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsNotifications$binding$2.INSTANCE, null, 2, null);
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
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.notifications);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        final StoreNotifications storeNotifications = this.notificationStore;
        getBinding().f18025d.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsNotifications$onViewBound$1$1
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreNotifications storeNotifications2 = storeNotifications;
                C12238m.checkNotNullExpressionValue(bool, "isChecked");
                storeNotifications2.setEnabled(bool.booleanValue());
            }
        });
        getBinding().f18023b.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsNotifications$onViewBound$1$2
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreNotifications storeNotifications2 = storeNotifications;
                C12238m.checkNotNullExpressionValue(bool, "isChecked");
                StoreNotifications.setEnabledInApp$default(storeNotifications2, bool.booleanValue(), false, 2, null);
            }
        });
        getBinding().f18024c.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsNotifications$onViewBound$1$3
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreNotifications storeNotifications2 = storeNotifications;
                C12238m.checkNotNullExpressionValue(bool, "isChecked");
                storeNotifications2.setNotificationLightDisabled(bool.booleanValue());
            }
        });
        getBinding().f18027f.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsNotifications$onViewBound$1$4
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreNotifications storeNotifications2 = storeNotifications;
                C12238m.checkNotNullExpressionValue(bool, "isChecked");
                storeNotifications2.setNotificationsVibrateDisabled(bool.booleanValue());
            }
        });
        getBinding().f18026e.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsNotifications$onViewBound$1$5
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreNotifications storeNotifications2 = storeNotifications;
                C12238m.checkNotNullExpressionValue(bool, "isChecked");
                storeNotifications2.setNotificationSoundDisabled(bool.booleanValue());
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getNotifications().getSettings(), this, null, 2, null), (Class<?>) WidgetSettingsNotifications.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C96531());
    }
}
