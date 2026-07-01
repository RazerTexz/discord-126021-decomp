package com.discord.widgets.servers.community;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsCommunitySetupFirstStepBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.ToastManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityFirstStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityFirstStep extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsCommunityFirstStep.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunitySetupFirstStepBinding;", 0)};
    public static final WidgetServerSettingsCommunityFirstStep$Companion Companion = new WidgetServerSettingsCommunityFirstStep$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ToastManager toastManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetServerSettingsCommunityFirstStep() {
        super(R$layout.widget_server_settings_community_setup_first_step);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsCommunityFirstStep$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new WidgetServerSettingsCommunityFirstStep$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetServerSettingsCommunityFirstStep$viewModel$2.INSTANCE));
        this.toastManager = new ToastManager();
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep, WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) {
        widgetServerSettingsCommunityFirstStep.configureUI(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ WidgetServerSettingsCommunitySetupFirstStepBinding access$getBinding$p(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep) {
        return widgetServerSettingsCommunityFirstStep.getBinding();
    }

    public static final /* synthetic */ ToastManager access$getToastManager$p(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep) {
        return widgetServerSettingsCommunityFirstStep.toastManager;
    }

    public static final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel access$getViewModel$p(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep) {
        return widgetServerSettingsCommunityFirstStep.getViewModel();
    }

    public static final /* synthetic */ void access$setToastManager$p(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep, ToastManager toastManager) {
        widgetServerSettingsCommunityFirstStep.toastManager = toastManager;
    }

    private final void configureUI(WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded viewState) {
        CheckedSetting checkedSetting = getBinding().c;
        m.checkNotNullExpressionValue(checkedSetting, "binding.communitySettingsVerifiedEmailedSwitch");
        checkedSetting.setChecked(viewState.getCommunityGuildConfig().getVerificationLevel());
        CheckedSetting checkedSetting2 = getBinding().f2554b;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.communitySettingsScanMessagesSwitch");
        checkedSetting2.setChecked(viewState.getCommunityGuildConfig().getExplicitContentFilter());
        Guild guild = viewState.getCommunityGuildConfig().getGuild();
        boolean z2 = guild != null && guild.getVerificationLevel().compareTo(GuildVerificationLevel.NONE) > 0;
        boolean z3 = guild != null && guild.getExplicitContentFilter().compareTo(GuildExplicitContentFilter.NONE) > 0;
        getBinding().c.e(new WidgetServerSettingsCommunityFirstStep$configureUI$1(this, viewState, z2));
        getBinding().f2554b.e(new WidgetServerSettingsCommunityFirstStep$configureUI$2(this, viewState, z3));
    }

    public static final void create(Context context) {
        Companion.create(context);
    }

    private final WidgetServerSettingsCommunitySetupFirstStepBinding getBinding() {
        return (WidgetServerSettingsCommunitySetupFirstStepBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsEnableCommunityViewModel getViewModel() {
        return (WidgetServerSettingsEnableCommunityViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.toastManager.close();
        super.onDestroyView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableG = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).y(WidgetServerSettingsCommunityFirstStep$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).G(WidgetServerSettingsCommunityFirstStep$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(observableG, WidgetServerSettingsCommunityFirstStep.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsCommunityFirstStep$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
