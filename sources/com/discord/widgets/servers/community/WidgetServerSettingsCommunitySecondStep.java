package com.discord.widgets.servers.community;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsCommunitySetupSecondStepBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.channels.WidgetChannelSelector$Companion;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsCommunitySecondStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunitySecondStep extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsCommunitySecondStep.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunitySetupSecondStepBinding;", 0)};
    public static final WidgetServerSettingsCommunitySecondStep$Companion Companion = new WidgetServerSettingsCommunitySecondStep$Companion(null);
    private static final String REQUEST_KEY_RULES_CHANNEL = "REQUEST_KEY_RULES_CHANNEL";
    private static final String REQUEST_KEY_UPDATES_CHANNEL = "REQUEST_KEY_UPDATES_CHANNEL";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetServerSettingsCommunitySecondStep() {
        super(R$layout.widget_server_settings_community_setup_second_step);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsCommunitySecondStep$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new WidgetServerSettingsCommunitySecondStep$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetServerSettingsCommunitySecondStep$viewModel$2.INSTANCE));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep, WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) {
        widgetServerSettingsCommunitySecondStep.configureUI(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel access$getViewModel$p(WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep) {
        return widgetServerSettingsCommunitySecondStep.getViewModel();
    }

    private final void configureUI(WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded viewState) {
        String string = viewState.getCommunityGuildConfig().getRulesChannel() == null ? requireContext().getString(2131888859) : ChannelUtils.e(viewState.getCommunityGuildConfig().getRulesChannel(), requireContext(), false, 2);
        m.checkNotNullExpressionValue(string, "when (viewState.communit…t(requireContext())\n    }");
        String string2 = viewState.getCommunityGuildConfig().getUpdatesChannel() == null ? requireContext().getString(2131888859) : ChannelUtils.e(viewState.getCommunityGuildConfig().getUpdatesChannel(), requireContext(), false, 2);
        m.checkNotNullExpressionValue(string2, "when (viewState.communit…t(requireContext())\n    }");
        getBinding().f2555b.setSubtitle(string);
        getBinding().c.setSubtitle(string2);
        getBinding().f2555b.setOnClickListener(new WidgetServerSettingsCommunitySecondStep$configureUI$1(this));
        getBinding().c.setOnClickListener(new WidgetServerSettingsCommunitySecondStep$configureUI$2(this));
    }

    public static final void create(Context context) {
        Companion.create(context);
    }

    private final WidgetServerSettingsCommunitySetupSecondStepBinding getBinding() {
        return (WidgetServerSettingsCommunitySetupSecondStepBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsEnableCommunityViewModel getViewModel() {
        return (WidgetServerSettingsEnableCommunityViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetChannelSelector$Companion widgetChannelSelector$Companion = WidgetChannelSelector.Companion;
        WidgetChannelSelector$Companion.registerForResult$default(widgetChannelSelector$Companion, this, REQUEST_KEY_RULES_CHANNEL, false, new WidgetServerSettingsCommunitySecondStep$onViewBound$1(this), 4, null);
        WidgetChannelSelector$Companion.registerForResult$default(widgetChannelSelector$Companion, this, REQUEST_KEY_UPDATES_CHANNEL, false, new WidgetServerSettingsCommunitySecondStep$onViewBound$2(this), 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableG = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).y(WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).G(WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(observableG, WidgetServerSettingsCommunitySecondStep.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
