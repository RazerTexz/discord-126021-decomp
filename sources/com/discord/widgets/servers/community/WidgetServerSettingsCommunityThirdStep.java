package com.discord.widgets.servers.community;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f;
import b.a.d.f0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.role.GuildRole;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsCommunitySetupThirdStepBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.ToastManager;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityThirdStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityThirdStep extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsCommunityThirdStep.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunitySetupThirdStepBinding;", 0)};
    public static final WidgetServerSettingsCommunityThirdStep$Companion Companion = new WidgetServerSettingsCommunityThirdStep$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ToastManager toastManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetServerSettingsCommunityThirdStep() {
        super(R$layout.widget_server_settings_community_setup_third_step);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsCommunityThirdStep$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new WidgetServerSettingsCommunityThirdStep$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetServerSettingsCommunityThirdStep$viewModel$2.INSTANCE));
        this.toastManager = new ToastManager();
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsCommunityThirdStep widgetServerSettingsCommunityThirdStep, WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) {
        widgetServerSettingsCommunityThirdStep.configureUI(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ WidgetServerSettingsCommunitySetupThirdStepBinding access$getBinding$p(WidgetServerSettingsCommunityThirdStep widgetServerSettingsCommunityThirdStep) {
        return widgetServerSettingsCommunityThirdStep.getBinding();
    }

    public static final /* synthetic */ ToastManager access$getToastManager$p(WidgetServerSettingsCommunityThirdStep widgetServerSettingsCommunityThirdStep) {
        return widgetServerSettingsCommunityThirdStep.toastManager;
    }

    public static final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel access$getViewModel$p(WidgetServerSettingsCommunityThirdStep widgetServerSettingsCommunityThirdStep) {
        return widgetServerSettingsCommunityThirdStep.getViewModel();
    }

    public static final /* synthetic */ void access$setToastManager$p(WidgetServerSettingsCommunityThirdStep widgetServerSettingsCommunityThirdStep, ToastManager toastManager) {
        widgetServerSettingsCommunityThirdStep.toastManager = toastManager;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0088  */
    private final void configureUI(WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded viewState) {
        long permissions;
        CheckedSetting checkedSetting = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting, "binding.communitySetting…ficationsToMentionsSwitch");
        checkedSetting.setChecked(viewState.getCommunityGuildConfig().getDefaultMessageNotifications());
        CheckedSetting checkedSetting2 = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.communitySettingManagePermissionsSwitch");
        checkedSetting2.setChecked(viewState.getCommunityGuildConfig().getEveryonePermissions());
        CheckedSetting checkedSetting3 = getBinding().f2556b;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.communitySettingCommunityGuidelinesSwitch");
        checkedSetting3.setChecked(viewState.getCommunityGuildConfig().isPrivacyPolicyAccepted());
        Guild guild = viewState.getCommunityGuildConfig().getGuild();
        boolean z2 = false;
        boolean z3 = guild != null && guild.getDefaultMessageNotifications() == 1;
        Map<Long, GuildRole> roles = viewState.getCommunityGuildConfig().getRoles();
        if (roles == null) {
            permissions = 0;
        } else {
            Guild guild2 = viewState.getCommunityGuildConfig().getGuild();
            GuildRole guildRole = roles.get(guild2 != null ? Long.valueOf(guild2.getId()) : null);
            if (guildRole != null) {
                permissions = guildRole.getPermissions();
            } else {
                permissions = 0;
            }
        }
        long j = (-1116960071743L) & permissions;
        Map<Long, GuildRole> roles2 = viewState.getCommunityGuildConfig().getRoles();
        if (roles2 != null) {
            Guild guild3 = viewState.getCommunityGuildConfig().getGuild();
            GuildRole guildRole2 = roles2.get(guild3 != null ? Long.valueOf(guild3.getId()) : null);
            if (guildRole2 != null && j == guildRole2.getPermissions()) {
                z2 = true;
            }
        }
        getBinding().e.e(new WidgetServerSettingsCommunityThirdStep$configureUI$1(this, viewState, z3));
        getBinding().d.e(new WidgetServerSettingsCommunityThirdStep$configureUI$2(this, viewState, z2));
        getBinding().f2556b.e(new WidgetServerSettingsCommunityThirdStep$configureUI$3(this));
    }

    public static final void create(Context context) {
        Companion.create(context);
    }

    private final WidgetServerSettingsCommunitySetupThirdStepBinding getBinding() {
        return (WidgetServerSettingsCommunitySetupThirdStepBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
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
        Observable observableG = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).y(WidgetServerSettingsCommunityThirdStep$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).G(WidgetServerSettingsCommunityThirdStep$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(observableG, WidgetServerSettingsCommunityThirdStep.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsCommunityThirdStep$onViewBoundOrOnResume$1(this), 62, (Object) null);
        CheckedSetting checkedSetting = getBinding().e;
        Context context = getContext();
        checkedSetting.setText(context != null ? b.b(context, 2131888829, new Object[0], new WidgetServerSettingsCommunityThirdStep$onViewBoundOrOnResume$2(this)) : null);
        CheckedSetting checkedSetting2 = getBinding().d;
        Context context2 = getContext();
        checkedSetting2.setText(context2 != null ? b.b(context2, 2131888832, new Object[0], new WidgetServerSettingsCommunityThirdStep$onViewBoundOrOnResume$3(this)) : null);
        LinkifiedTextView linkifiedTextView = getBinding().c;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.communitySettingGuidelines");
        b.n(linkifiedTextView, 2131887813, new Object[]{f.a.a(360035969312L, null)}, null, 4);
    }
}
