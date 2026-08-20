package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.preference.PreferenceManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetGuildCallOnboardingBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.voice.VoiceChannelJoinability;
import com.discord.views.JoinVoiceChannelButton;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.C0836m;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p062y.ViewOnClickListenerC1331g;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildCallOnboardingSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildCallOnboardingBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final boolean hasUserSeenVoiceChannelOnboarding(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("CACHE_KEY_VOICE_CHANNEL_ONBOARDED", false);
        }

        public final void markSeenUserVoiceChannelOnboarding(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("CACHE_KEY_VOICE_CHANNEL_ONBOARDED", true).apply();
        }

        public final void show(FragmentManager fragmentManager, long channelId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetGuildCallOnboardingSheet widgetGuildCallOnboardingSheet = new WidgetGuildCallOnboardingSheet();
            Bundle bundle = new Bundle();
            bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            widgetGuildCallOnboardingSheet.setArguments(bundle);
            widgetGuildCallOnboardingSheet.show(fragmentManager, WidgetGuildCallOnboardingSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet$configureUI$1 */
    /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheet.kt */
    public static final class C105481 extends AbstractC12240o implements Function0<Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet$configureUI$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheet.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Companion companion = WidgetGuildCallOnboardingSheet.INSTANCE;
                Context contextRequireContext = WidgetGuildCallOnboardingSheet.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.markSeenUserVoiceChannelOnboarding(contextRequireContext);
                WidgetGuildCallOnboardingSheet.this.getViewModel().onConnectPressed();
            }
        }

        public C105481() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            C1460d.m473S1(WidgetGuildCallOnboardingSheet.this, null, new AnonymousClass1(), 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheet.kt */
    public static final class C105491 extends AbstractC12240o implements Function1<WidgetGuildCallOnboardingSheetViewModel.ViewState, Unit> {
        public C105491() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCallOnboardingSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildCallOnboardingSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetGuildCallOnboardingSheet.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet$onResume$2 */
    /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheet.kt */
    public static final class C105502 extends AbstractC12240o implements Function1<WidgetGuildCallOnboardingSheetViewModel.Event, Unit> {
        public C105502() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCallOnboardingSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildCallOnboardingSheetViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            WidgetGuildCallOnboardingSheet.this.handleEvent(event);
        }
    }

    public WidgetGuildCallOnboardingSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildCallOnboardingSheet$binding$2.INSTANCE, null, 2, null);
        WidgetGuildCallOnboardingSheet$viewModel$2 widgetGuildCallOnboardingSheet$viewModel$2 = new WidgetGuildCallOnboardingSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetGuildCallOnboardingSheetViewModel.class), new C10547x328ca378(c0865g0), new C0869i0(widgetGuildCallOnboardingSheet$viewModel$2));
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
    private final void configureUI(WidgetGuildCallOnboardingSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetGuildCallOnboardingSheetViewModel.ViewState.Loaded) {
            JoinVoiceChannelButton joinVoiceChannelButton = getBinding().f16750b;
            VoiceChannelJoinability joinability = ((WidgetGuildCallOnboardingSheetViewModel.ViewState.Loaded) viewState).getJoinability();
            C105481 c105481 = new C105481();
            Objects.requireNonNull(joinVoiceChannelButton);
            C12238m.checkNotNullParameter(joinability, "joinability");
            C12238m.checkNotNullParameter(c105481, "joinVoiceClickListener");
            int iOrdinal = joinability.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    joinVoiceChannelButton.setText(C5419R.string.channel_locked_short);
                    joinVoiceChannelButton.m8547a(joinVoiceChannelButton, C5419R.string.channel_locked);
                    return;
                } else if (iOrdinal != 2) {
                    if (iOrdinal == 3) {
                        joinVoiceChannelButton.setText(C5419R.string.unable_to_join_channel_full);
                        joinVoiceChannelButton.m8547a(joinVoiceChannelButton, C5419R.string.unable_to_join_channel_full);
                        return;
                    } else {
                        if (iOrdinal != 4) {
                            return;
                        }
                        joinVoiceChannelButton.setText(C5419R.string.connect_to_voice);
                        joinVoiceChannelButton.m8547a(joinVoiceChannelButton, C5419R.string.guild_settings_public_welcome_invalid_channel);
                        return;
                    }
                }
            }
            joinVoiceChannelButton.setText(C5419R.string.connect_to_voice);
            joinVoiceChannelButton.setOnClickListener(new ViewOnClickListenerC1331g(c105481));
        }
    }

    private final WidgetGuildCallOnboardingBinding getBinding() {
        return (WidgetGuildCallOnboardingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildCallOnboardingSheetViewModel getViewModel() {
        return (WidgetGuildCallOnboardingSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetGuildCallOnboardingSheetViewModel.Event event) {
        if (C12238m.areEqual(event, WidgetGuildCallOnboardingSheetViewModel.Event.ShowGuildVideoCapacityDialog.INSTANCE)) {
            C0836m.Companion companion = C0836m.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.m140a(parentFragmentManager);
            dismiss();
            return;
        }
        if (event instanceof WidgetGuildCallOnboardingSheetViewModel.Event.LaunchGuildCallScreen) {
            WidgetGuildCallOnboardingSheetViewModel.Event.LaunchGuildCallScreen launchGuildCallScreen = (WidgetGuildCallOnboardingSheetViewModel.Event.LaunchGuildCallScreen) event;
            if (TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(launchGuildCallScreen.getGuildId())) {
                WidgetCallPreviewFullscreen.Companion companion2 = WidgetCallPreviewFullscreen.INSTANCE;
                Context contextRequireContext = requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion2.launch(contextRequireContext, launchGuildCallScreen.getChannelId(), AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE);
            } else {
                WidgetVoiceBottomSheet.Companion companion3 = WidgetVoiceBottomSheet.INSTANCE;
                FragmentManager parentFragmentManager2 = getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                companion3.show(parentFragmentManager2, launchGuildCallScreen.getChannelId(), true, WidgetVoiceBottomSheet.FeatureContext.HOME);
            }
            dismiss();
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_guild_call_onboarding;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildCallOnboardingSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C105491());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetGuildCallOnboardingSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C105502());
    }
}
