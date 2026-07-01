package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsCommunitySetupFirstStepBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.ToastManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityFirstStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityFirstStep extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsCommunityFirstStep.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunitySetupFirstStepBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ToastManager toastManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetServerSettingsCommunityFirstStep.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetServerSettingsCommunityFirstStep.class, new Intent());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityFirstStep.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass1(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep) {
            super(1, widgetServerSettingsCommunityFirstStep, WidgetServerSettingsCommunityFirstStep.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "p1");
            ((WidgetServerSettingsCommunityFirstStep) this.receiver).configureUI(loaded);
        }
    }

    public WidgetServerSettingsCommunityFirstStep() {
        super(R.layout.widget_server_settings_community_setup_first_step);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsCommunityFirstStep2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new WidgetServerSettingsCommunityFirstStep$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetServerSettingsCommunityFirstStep3.INSTANCE));
        this.toastManager = new ToastManager();
    }

    private final void configureUI(final WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded viewState) {
        CheckedSetting checkedSetting = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.communitySettingsVerifiedEmailedSwitch");
        checkedSetting.setChecked(viewState.getCommunityGuildConfig().getVerificationLevel());
        CheckedSetting checkedSetting2 = getBinding().f2554b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.communitySettingsScanMessagesSwitch");
        checkedSetting2.setChecked(viewState.getCommunityGuildConfig().getExplicitContentFilter());
        Guild guild = viewState.getCommunityGuildConfig().getGuild();
        final boolean z2 = guild != null && guild.getVerificationLevel().compareTo(GuildVerificationLevel.NONE) > 0;
        final boolean z3 = guild != null && guild.getExplicitContentFilter().compareTo(GuildExplicitContentFilter.NONE) > 0;
        getBinding().c.e(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep.configureUI.1

            /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$configureUI$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetServerSettingsCommunityFirstStep.kt */
            public static final class C03181 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig> {
                public C03181() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                    Intrinsics3.checkNotNullParameter(communityGuildConfig, "it");
                    CheckedSetting checkedSetting = WidgetServerSettingsCommunityFirstStep.this.getBinding().c;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.communitySettingsVerifiedEmailedSwitch");
                    return communityGuildConfig.copy((4031 & 1) != 0 ? communityGuildConfig.rulesChannel : null, (4031 & 2) != 0 ? communityGuildConfig.updatesChannel : null, (4031 & 4) != 0 ? communityGuildConfig.rulesChannelId : null, (4031 & 8) != 0 ? communityGuildConfig.updatesChannelId : null, (4031 & 16) != 0 ? communityGuildConfig.isPrivacyPolicyAccepted : false, (4031 & 32) != 0 ? communityGuildConfig.defaultMessageNotifications : false, (4031 & 64) != 0 ? communityGuildConfig.verificationLevel : !checkedSetting.isChecked(), (4031 & 128) != 0 ? communityGuildConfig.explicitContentFilter : false, (4031 & 256) != 0 ? communityGuildConfig.guild : null, (4031 & 512) != 0 ? communityGuildConfig.everyonePermissions : false, (4031 & 1024) != 0 ? communityGuildConfig.features : null, (4031 & 2048) != 0 ? communityGuildConfig.roles : null);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (viewState.getCommunityGuildConfig().getVerificationLevel() && z2) {
                    AppToast.d(WidgetServerSettingsCommunityFirstStep.this.getContext(), R.string.enable_community_modal_requirement_satisfied_tooltip, 0, WidgetServerSettingsCommunityFirstStep.this.toastManager);
                } else {
                    WidgetServerSettingsCommunityFirstStep.this.getViewModel().modifyGuildConfig(new C03181());
                }
            }
        });
        getBinding().f2554b.e(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep.configureUI.2

            /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$configureUI$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetServerSettingsCommunityFirstStep.kt */
            public static final class AnonymousClass1 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig> {
                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                    Intrinsics3.checkNotNullParameter(communityGuildConfig, "it");
                    CheckedSetting checkedSetting = WidgetServerSettingsCommunityFirstStep.this.getBinding().f2554b;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.communitySettingsScanMessagesSwitch");
                    return communityGuildConfig.copy((4031 & 1) != 0 ? communityGuildConfig.rulesChannel : null, (4031 & 2) != 0 ? communityGuildConfig.updatesChannel : null, (4031 & 4) != 0 ? communityGuildConfig.rulesChannelId : null, (4031 & 8) != 0 ? communityGuildConfig.updatesChannelId : null, (4031 & 16) != 0 ? communityGuildConfig.isPrivacyPolicyAccepted : false, (4031 & 32) != 0 ? communityGuildConfig.defaultMessageNotifications : false, (4031 & 64) != 0 ? communityGuildConfig.verificationLevel : false, (4031 & 128) != 0 ? communityGuildConfig.explicitContentFilter : !checkedSetting.isChecked(), (4031 & 256) != 0 ? communityGuildConfig.guild : null, (4031 & 512) != 0 ? communityGuildConfig.everyonePermissions : false, (4031 & 1024) != 0 ? communityGuildConfig.features : null, (4031 & 2048) != 0 ? communityGuildConfig.roles : null);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (viewState.getCommunityGuildConfig().getExplicitContentFilter() && z3) {
                    AppToast.d(WidgetServerSettingsCommunityFirstStep.this.getContext(), R.string.enable_community_modal_requirement_satisfied_tooltip, 0, WidgetServerSettingsCommunityFirstStep.this.toastManager);
                } else {
                    WidgetServerSettingsCommunityFirstStep.this.getViewModel().modifyGuildConfig(new AnonymousClass1());
                }
            }
        });
    }

    public static final void create(Context context) {
        INSTANCE.create(context);
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
        Observable observableG = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).y(new Func1<Object, Boolean>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$onViewBoundOrOnResume$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j0.k.Func1
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded);
            }
        }).G(new Func1<Object, T>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$onViewBoundOrOnResume$$inlined$filterIs$2
            @Override // j0.k.Func1
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded");
                return (T) ((WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded) obj);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe(observableG, (Class<?>) WidgetServerSettingsCommunityFirstStep.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
