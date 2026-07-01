package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsActivityStatusBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsActivityStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsActivityStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsActivityStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsActivityStatusBinding;", 0)};
    public static final WidgetSettingsActivityStatus$Companion Companion = new WidgetSettingsActivityStatus$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetSettingsActivityStatus() {
        super(R$layout.widget_settings_activity_status);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsActivityStatus$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsActivityStatus widgetSettingsActivityStatus, boolean z2) {
        widgetSettingsActivityStatus.configureUI(z2);
    }

    private final void configureUI(boolean showCurrentGame) {
        CheckedSetting checkedSetting = getBinding().f2601b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.showCurrentActivity");
        checkedSetting.setChecked(showCurrentGame);
        getBinding().f2601b.setOnCheckedListener(new WidgetSettingsActivityStatus$configureUI$1(this));
    }

    private final WidgetSettingsActivityStatusBinding getBinding() {
        return (WidgetSettingsActivityStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131886307);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.Companion.getUserSettings().observeIsShowCurrentGameEnabled(), this, null, 2, null), WidgetSettingsActivityStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsActivityStatus$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
