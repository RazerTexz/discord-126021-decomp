package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsActivityStatusBinding;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.error.Error;
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

/* JADX INFO: compiled from: WidgetSettingsActivityStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsActivityStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsActivityStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsActivityStatusBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetSettingsActivityStatus.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsActivityStatus.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsActivityStatus$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsActivityStatus.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetSettingsActivityStatus.this.configureUI(z2);
        }
    }

    public WidgetSettingsActivityStatus() {
        super(R.layout.widget_settings_activity_status);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsActivityStatus2.INSTANCE, null, 2, null);
    }

    private final void configureUI(boolean showCurrentGame) {
        CheckedSetting checkedSetting = getBinding().f2601b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.showCurrentActivity");
        checkedSetting.setChecked(showCurrentGame);
        getBinding().f2601b.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsActivityStatus.configureUI.1
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
                AppActivity appActivity = WidgetSettingsActivityStatus.this.getAppActivity();
                Intrinsics3.checkNotNullExpressionValue(bool, "checked");
                userSettings.setIsShowCurrentGameEnabled(appActivity, bool.booleanValue());
            }
        });
    }

    private final WidgetSettingsActivityStatusBinding getBinding() {
        return (WidgetSettingsActivityStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.activity_status);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getUserSettings().observeIsShowCurrentGameEnabled(), this, null, 2, null), (Class<?>) WidgetSettingsActivityStatus.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
