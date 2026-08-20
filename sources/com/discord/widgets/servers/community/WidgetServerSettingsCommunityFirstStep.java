package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsCommunitySetupFirstStepBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.ToastManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityFirstStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityFirstStep extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsCommunityFirstStep.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunitySetupFirstStepBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m156d(context, WidgetServerSettingsCommunityFirstStep.class, new Intent());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityFirstStep.kt */
    public static final /* synthetic */ class C93571 extends C12236k implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded, Unit> {
        public C93571(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep) {
            super(1, widgetServerSettingsCommunityFirstStep, WidgetServerSettingsCommunityFirstStep.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            C12238m.checkNotNullParameter(loaded, "p1");
            ((WidgetServerSettingsCommunityFirstStep) this.receiver).configureUI(loaded);
        }
    }

    public WidgetServerSettingsCommunityFirstStep() {
        super(C5419R.layout.widget_server_settings_community_setup_first_step);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsCommunityFirstStep$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new C9351x10f0ed5c(this), new C0863f0(WidgetServerSettingsCommunityFirstStep$viewModel$2.INSTANCE));
        this.toastManager = new ToastManager();
    }

    private final void configureUI(final WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded viewState) {
        CheckedSetting checkedSetting = getBinding().f17583c;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.communitySettingsVerifiedEmailedSwitch");
        checkedSetting.setChecked(viewState.getCommunityGuildConfig().getVerificationLevel());
        CheckedSetting checkedSetting2 = getBinding().f17582b;
        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.communitySettingsScanMessagesSwitch");
        checkedSetting2.setChecked(viewState.getCommunityGuildConfig().getExplicitContentFilter());
        Guild guild = viewState.getCommunityGuildConfig().getGuild();
        final boolean z2 = guild != null && guild.getVerificationLevel().compareTo(GuildVerificationLevel.NONE) > 0;
        final boolean z3 = guild != null && guild.getExplicitContentFilter().compareTo(GuildExplicitContentFilter.NONE) > 0;
        getBinding().f17583c.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep.configureUI.1

            /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$configureUI$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetServerSettingsCommunityFirstStep.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function1<WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig> {
                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                    C12238m.checkNotNullParameter(communityGuildConfig, "it");
                    CheckedSetting checkedSetting = WidgetServerSettingsCommunityFirstStep.this.getBinding().f17583c;
                    C12238m.checkNotNullExpressionValue(checkedSetting, "binding.communitySettingsVerifiedEmailedSwitch");
                    return communityGuildConfig.copy((4031 & 1) != 0 ? communityGuildConfig.rulesChannel : null, (4031 & 2) != 0 ? communityGuildConfig.updatesChannel : null, (4031 & 4) != 0 ? communityGuildConfig.rulesChannelId : null, (4031 & 8) != 0 ? communityGuildConfig.updatesChannelId : null, (4031 & 16) != 0 ? communityGuildConfig.isPrivacyPolicyAccepted : false, (4031 & 32) != 0 ? communityGuildConfig.defaultMessageNotifications : false, (4031 & 64) != 0 ? communityGuildConfig.verificationLevel : !checkedSetting.isChecked(), (4031 & 128) != 0 ? communityGuildConfig.explicitContentFilter : false, (4031 & 256) != 0 ? communityGuildConfig.guild : null, (4031 & 512) != 0 ? communityGuildConfig.everyonePermissions : false, (4031 & 1024) != 0 ? communityGuildConfig.features : null, (4031 & 2048) != 0 ? communityGuildConfig.roles : null);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (viewState.getCommunityGuildConfig().getVerificationLevel() && z2) {
                    C0876m.m166d(WidgetServerSettingsCommunityFirstStep.this.getContext(), C5419R.string.enable_community_modal_requirement_satisfied_tooltip, 0, WidgetServerSettingsCommunityFirstStep.this.toastManager);
                } else {
                    WidgetServerSettingsCommunityFirstStep.this.getViewModel().modifyGuildConfig(new AnonymousClass1());
                }
            }
        });
        getBinding().f17582b.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep.configureUI.2

            /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$configureUI$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetServerSettingsCommunityFirstStep.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function1<WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig> {
                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                    C12238m.checkNotNullParameter(communityGuildConfig, "it");
                    CheckedSetting checkedSetting = WidgetServerSettingsCommunityFirstStep.this.getBinding().f17582b;
                    C12238m.checkNotNullExpressionValue(checkedSetting, "binding.communitySettingsScanMessagesSwitch");
                    return communityGuildConfig.copy((4031 & 1) != 0 ? communityGuildConfig.rulesChannel : null, (4031 & 2) != 0 ? communityGuildConfig.updatesChannel : null, (4031 & 4) != 0 ? communityGuildConfig.rulesChannelId : null, (4031 & 8) != 0 ? communityGuildConfig.updatesChannelId : null, (4031 & 16) != 0 ? communityGuildConfig.isPrivacyPolicyAccepted : false, (4031 & 32) != 0 ? communityGuildConfig.defaultMessageNotifications : false, (4031 & 64) != 0 ? communityGuildConfig.verificationLevel : false, (4031 & 128) != 0 ? communityGuildConfig.explicitContentFilter : !checkedSetting.isChecked(), (4031 & 256) != 0 ? communityGuildConfig.guild : null, (4031 & 512) != 0 ? communityGuildConfig.everyonePermissions : false, (4031 & 1024) != 0 ? communityGuildConfig.features : null, (4031 & 2048) != 0 ? communityGuildConfig.roles : null);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (viewState.getCommunityGuildConfig().getExplicitContentFilter() && z3) {
                    C0876m.m166d(WidgetServerSettingsCommunityFirstStep.this.getContext(), C5419R.string.enable_community_modal_requirement_satisfied_tooltip, 0, WidgetServerSettingsCommunityFirstStep.this.toastManager);
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
        Observable observableM11083G = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).m11118y(new InterfaceC12589b<Object, Boolean>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$onViewBoundOrOnResume$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded);
            }
        }).m11083G(new InterfaceC12589b<Object, T>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$onViewBoundOrOnResume$$inlined$filterIs$2
            @Override // p637j0.p641k.InterfaceC12589b
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded");
                return (T) ((WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded) obj);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe(observableM11083G, (Class<?>) WidgetServerSettingsCommunityFirstStep.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C93571(this));
    }
}
