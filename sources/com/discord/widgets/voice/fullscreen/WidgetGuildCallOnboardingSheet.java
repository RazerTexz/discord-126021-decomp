package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.m$a;
import b.a.d.g0;
import b.a.d.i0;
import b.a.y.g;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppTransitionActivity$Transition;
import com.discord.databinding.WidgetGuildCallOnboardingBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.voice.VoiceChannelJoinability;
import com.discord.views.JoinVoiceChannelButton;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$Companion;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$FeatureContext;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildCallOnboardingSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildCallOnboardingBinding;", 0)};
    public static final WidgetGuildCallOnboardingSheet$Companion Companion = new WidgetGuildCallOnboardingSheet$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildCallOnboardingSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildCallOnboardingSheet$binding$2.INSTANCE, null, 2, null);
        WidgetGuildCallOnboardingSheet$viewModel$2 widgetGuildCallOnboardingSheet$viewModel$2 = new WidgetGuildCallOnboardingSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildCallOnboardingSheetViewModel.class), new WidgetGuildCallOnboardingSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildCallOnboardingSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildCallOnboardingSheet widgetGuildCallOnboardingSheet, WidgetGuildCallOnboardingSheetViewModel$ViewState widgetGuildCallOnboardingSheetViewModel$ViewState) {
        widgetGuildCallOnboardingSheet.configureUI(widgetGuildCallOnboardingSheetViewModel$ViewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildCallOnboardingSheet widgetGuildCallOnboardingSheet) {
        return widgetGuildCallOnboardingSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetGuildCallOnboardingSheetViewModel access$getViewModel$p(WidgetGuildCallOnboardingSheet widgetGuildCallOnboardingSheet) {
        return widgetGuildCallOnboardingSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildCallOnboardingSheet widgetGuildCallOnboardingSheet, WidgetGuildCallOnboardingSheetViewModel$Event widgetGuildCallOnboardingSheetViewModel$Event) {
        widgetGuildCallOnboardingSheet.handleEvent(widgetGuildCallOnboardingSheetViewModel$Event);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void configureUI(WidgetGuildCallOnboardingSheetViewModel$ViewState viewState) {
        if (viewState instanceof WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded) {
            JoinVoiceChannelButton joinVoiceChannelButton = getBinding().f2409b;
            VoiceChannelJoinability joinability = ((WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded) viewState).getJoinability();
            WidgetGuildCallOnboardingSheet$configureUI$1 widgetGuildCallOnboardingSheet$configureUI$1 = new WidgetGuildCallOnboardingSheet$configureUI$1(this);
            Objects.requireNonNull(joinVoiceChannelButton);
            m.checkNotNullParameter(joinability, "joinability");
            m.checkNotNullParameter(widgetGuildCallOnboardingSheet$configureUI$1, "joinVoiceClickListener");
            int iOrdinal = joinability.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    joinVoiceChannelButton.setText(2131887550);
                    joinVoiceChannelButton.a(joinVoiceChannelButton, 2131887549);
                    return;
                } else if (iOrdinal != 2) {
                    if (iOrdinal == 3) {
                        joinVoiceChannelButton.setText(2131896558);
                        joinVoiceChannelButton.a(joinVoiceChannelButton, 2131896558);
                        return;
                    } else {
                        if (iOrdinal != 4) {
                            return;
                        }
                        joinVoiceChannelButton.setText(2131887835);
                        joinVoiceChannelButton.a(joinVoiceChannelButton, 2131891400);
                        return;
                    }
                }
            }
            joinVoiceChannelButton.setText(2131887835);
            joinVoiceChannelButton.setOnClickListener(new g(widgetGuildCallOnboardingSheet$configureUI$1));
        }
    }

    private final WidgetGuildCallOnboardingBinding getBinding() {
        return (WidgetGuildCallOnboardingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildCallOnboardingSheetViewModel getViewModel() {
        return (WidgetGuildCallOnboardingSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetGuildCallOnboardingSheetViewModel$Event event) {
        if (m.areEqual(event, WidgetGuildCallOnboardingSheetViewModel$Event$ShowGuildVideoCapacityDialog.INSTANCE)) {
            m$a m_a = b.a.a.m.k;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            m_a.a(parentFragmentManager);
            dismiss();
            return;
        }
        if (event instanceof WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen) {
            WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen widgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen = (WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen) event;
            if (TextInVoiceFeatureFlag.Companion.getINSTANCE().isEnabled(widgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen.getGuildId())) {
                WidgetCallPreviewFullscreen$Companion widgetCallPreviewFullscreen$Companion = WidgetCallPreviewFullscreen.Companion;
                Context contextRequireContext = requireContext();
                m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                widgetCallPreviewFullscreen$Companion.launch(contextRequireContext, widgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen.getChannelId(), AppTransitionActivity$Transition.TYPE_SLIDE_VERTICAL_WITH_FADE);
            } else {
                WidgetVoiceBottomSheet$Companion widgetVoiceBottomSheet$Companion = WidgetVoiceBottomSheet.Companion;
                FragmentManager parentFragmentManager2 = getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                widgetVoiceBottomSheet$Companion.show(parentFragmentManager2, widgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen.getChannelId(), true, WidgetVoiceBottomSheet$FeatureContext.HOME);
            }
            dismiss();
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_guild_call_onboarding;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildCallOnboardingSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildCallOnboardingSheet$onResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildCallOnboardingSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildCallOnboardingSheet$onResume$2(this), 62, (Object) null);
    }
}
