package com.discord.widgets.servers.community;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsEnableCommunityBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsEnableCommunity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEnableCommunityBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetServerSettingsEnableCommunity() {
        super(R$layout.widget_server_settings_enable_community);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsEnableCommunity$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new WidgetServerSettingsEnableCommunity$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetServerSettingsEnableCommunity$viewModel$2.INSTANCE));
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsEnableCommunity$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel access$getViewModel$p(WidgetServerSettingsEnableCommunity widgetServerSettingsEnableCommunity) {
        return widgetServerSettingsEnableCommunity.getViewModel();
    }

    private final WidgetServerSettingsEnableCommunityBinding getBinding() {
        return (WidgetServerSettingsEnableCommunityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsEnableCommunityViewModel getViewModel() {
        return (WidgetServerSettingsEnableCommunityViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().f2568b.setOnClickListener(new WidgetServerSettingsEnableCommunity$onViewBoundOrOnResume$1(this));
    }
}
