package com.discord.widgets.status;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.stageinstance.StageInstance;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetGlobalStatusIndicatorBinding;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.textprocessing.SpannableUtilsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.voice.VoiceViewUtils;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import com.google.android.material.button.MaterialButton;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicator extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGlobalStatusIndicator.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGlobalStatusIndicatorBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private AnimatedVectorDrawableCompat connectingVector;
    private final WidgetGlobalStatusIndicator$connectingVectorReplayCallback$1 connectingVectorReplayCallback;
    private final WidgetGlobalStatusIndicatorState indicatorState;
    private WidgetGlobalStatusIndicatorState.State lastIndicatorState;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
    public static final /* synthetic */ class C101021 extends C12236k implements Function1<WidgetGlobalStatusIndicatorState.State, Unit> {
        public C101021(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
            super(1, widgetGlobalStatusIndicator, WidgetGlobalStatusIndicator.class, "configureUIVisibility", "configureUIVisibility(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorState.State state) {
            invoke2(state);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGlobalStatusIndicatorState.State state) {
            C12238m.checkNotNullParameter(state, "p1");
            ((WidgetGlobalStatusIndicator) this.receiver).configureUIVisibility(state);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
    public static final /* synthetic */ class C101032 extends C12236k implements Function1<WidgetGlobalStatusIndicatorViewModel.ViewState, Unit> {
        public C101032(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
            super(1, widgetGlobalStatusIndicator, WidgetGlobalStatusIndicator.class, "configureUI", "configureUI(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGlobalStatusIndicatorViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetGlobalStatusIndicator) this.receiver).configureUI(viewState);
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.discord.widgets.status.WidgetGlobalStatusIndicator$connectingVectorReplayCallback$1] */
    public WidgetGlobalStatusIndicator() {
        super(C5419R.layout.widget_global_status_indicator);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetGlobalStatusIndicator$binding$2.INSTANCE, new WidgetGlobalStatusIndicator$binding$3(this));
        this.indicatorState = WidgetGlobalStatusIndicatorState.INSTANCE.get();
        WidgetGlobalStatusIndicator$viewModel$2 widgetGlobalStatusIndicator$viewModel$2 = WidgetGlobalStatusIndicator$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetGlobalStatusIndicatorViewModel.class), new WidgetGlobalStatusIndicator$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetGlobalStatusIndicator$viewModel$2));
        this.connectingVectorReplayCallback = new Animatable2Compat.AnimationCallback() { // from class: com.discord.widgets.status.WidgetGlobalStatusIndicator$connectingVectorReplayCallback$1
            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public void onAnimationEnd(Drawable drawable) {
                C12238m.checkNotNullParameter(drawable, "drawable");
                AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.this$0.connectingVector;
                if (animatedVectorDrawableCompat != null) {
                    animatedVectorDrawableCompat.start();
                }
            }
        };
    }

    private final Observable<WidgetGlobalStatusIndicatorViewModel.ViewState> bindDelay(final Observable<WidgetGlobalStatusIndicatorViewModel.ViewState> observable) {
        return observable.m11099Y(new InterfaceC12589b<WidgetGlobalStatusIndicatorViewModel.ViewState, Observable<? extends WidgetGlobalStatusIndicatorViewModel.ViewState>>() { // from class: com.discord.widgets.status.WidgetGlobalStatusIndicator.bindDelay.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends WidgetGlobalStatusIndicatorViewModel.ViewState> call(WidgetGlobalStatusIndicatorViewModel.ViewState viewState) {
                Long lValueOf;
                if (viewState instanceof WidgetGlobalStatusIndicatorViewModel.ViewState.Offline) {
                    lValueOf = Long.valueOf(((WidgetGlobalStatusIndicatorViewModel.ViewState.Offline) viewState).getDelay());
                } else {
                    lValueOf = viewState instanceof WidgetGlobalStatusIndicatorViewModel.ViewState.Connecting ? Long.valueOf(((WidgetGlobalStatusIndicatorViewModel.ViewState.Connecting) viewState).getDelay()) : null;
                }
                if (lValueOf == null) {
                    return observable;
                }
                lValueOf.longValue();
                return new C12721k(viewState).m11111q(lValueOf.longValue(), TimeUnit.MILLISECONDS);
            }
        });
    }

    private final void configureUI(WidgetGlobalStatusIndicatorViewModel.ViewState viewState) {
        WidgetGlobalStatusIndicatorState.updateState$default(this.indicatorState, !C12238m.areEqual(viewState, WidgetGlobalStatusIndicatorViewModel.ViewState.Inactive.INSTANCE), viewState.getIsSpeakingInOngoingCall(), false, 4, null);
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.connectingVector;
        if (animatedVectorDrawableCompat != null) {
            animatedVectorDrawableCompat.unregisterAnimationCallback(this.connectingVectorReplayCallback);
        }
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = this.connectingVector;
        if (animatedVectorDrawableCompat2 != null) {
            animatedVectorDrawableCompat2.stop();
        }
        if (viewState instanceof WidgetGlobalStatusIndicatorViewModel.ViewState.Offline) {
            setupOfflineState(((WidgetGlobalStatusIndicatorViewModel.ViewState.Offline) viewState).getAirplaneMode());
        } else if (viewState instanceof WidgetGlobalStatusIndicatorViewModel.ViewState.Connecting) {
            setupConnectingState();
        } else if (viewState instanceof WidgetGlobalStatusIndicatorViewModel.ViewState.CallOngoing) {
            WidgetGlobalStatusIndicatorViewModel.ViewState.CallOngoing callOngoing = (WidgetGlobalStatusIndicatorViewModel.ViewState.CallOngoing) viewState;
            setupContainerClicks(callOngoing);
            setupIndicatorStatus(callOngoing);
        } else if (viewState instanceof WidgetGlobalStatusIndicatorViewModel.ViewState.StageChannelOngoing) {
            WidgetGlobalStatusIndicatorViewModel.ViewState.StageChannelOngoing stageChannelOngoing = (WidgetGlobalStatusIndicatorViewModel.ViewState.StageChannelOngoing) viewState;
            setupStageContainerClicks(stageChannelOngoing);
            setupStageIndicatorStatus(stageChannelOngoing);
        } else {
            resetContentVisibility(getBinding());
        }
        WidgetGlobalStatusIndicatorState.State state = this.lastIndicatorState;
        if (state == null || !state.isViewingCall()) {
            return;
        }
        LinearLayout linearLayout = getBinding().f16720c;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.indicator");
        LinearLayout linearLayout2 = getBinding().f16722e;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.indicatorActions");
        linearLayout.setVisibility(linearLayout2.getVisibility() == 0 ? 0 : 8);
    }

    private final void configureUIVisibility(WidgetGlobalStatusIndicatorState.State state) {
        this.lastIndicatorState = state;
        LinearLayout linearLayout = getBinding().f16720c;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.indicator");
        linearLayout.setVisibility(state.isVisible() ? 0 : 8);
    }

    private final WidgetGlobalStatusIndicatorBinding getBinding() {
        return (WidgetGlobalStatusIndicatorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGlobalStatusIndicatorViewModel getViewModel() {
        return (WidgetGlobalStatusIndicatorViewModel) this.viewModel.getValue();
    }

    private final void onViewBindingDestroy(WidgetGlobalStatusIndicatorBinding binding) {
        resetContentVisibility(binding);
    }

    private final void resetContentVisibility(WidgetGlobalStatusIndicatorBinding binding) {
        LinearLayout linearLayout = binding.f16723f;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.indicatorContent");
        linearLayout.setVisibility(0);
        TextView textView = binding.f16719b;
        C12238m.checkNotNullExpressionValue(textView, "binding.alertText");
        textView.setVisibility(8);
    }

    private final void setupConnectingState() {
        resetContentVisibility(getBinding());
        getBinding().f16720c.setBackgroundColor(ColorCompat.getThemedColor(requireContext(), C5419R.attr.colorBackgroundTertiary));
        getBinding().f16726i.setTextColor(ColorCompat.getThemedColor(requireContext(), C5419R.attr.colorHeaderPrimary));
        TextView textView = getBinding().f16726i;
        C12238m.checkNotNullExpressionValue(textView, "binding.indicatorText");
        textView.setText(getString(C5419R.string.connecting));
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = null;
        if (this.connectingVector == null && Build.VERSION.SDK_INT != 28) {
            this.connectingVector = AnimatedVectorDrawableCompat.create(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), C5419R.attr.ic_network_connecting_animated_vector, 0, 2, (Object) null));
        }
        ImageView imageView = getBinding().f16725h;
        imageView.setVisibility(0);
        if (Build.VERSION.SDK_INT == 28) {
            imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(requireContext(), C5419R.attr.ic_network_connecting, 0, 2, (Object) null));
            return;
        }
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = this.connectingVector;
        if (animatedVectorDrawableCompat2 != null) {
            animatedVectorDrawableCompat2.registerAnimationCallback(this.connectingVectorReplayCallback);
            animatedVectorDrawableCompat2.start();
            animatedVectorDrawableCompat = animatedVectorDrawableCompat2;
        }
        imageView.setImageDrawable(animatedVectorDrawableCompat);
    }

    private final void setupContainerClicks(final WidgetGlobalStatusIndicatorViewModel.ViewState.CallOngoing viewState) {
        getBinding().f16720c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.status.WidgetGlobalStatusIndicator.setupContainerClicks.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModelApplicationStream stream;
                ModelApplicationStream stream2;
                StreamContext streamContext;
                if (ChannelUtils.m7667B(viewState.getSelectedVoiceChannel())) {
                    WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, WidgetGlobalStatusIndicator.this.requireContext(), viewState.getSelectedVoiceChannel().getId(), false, null, null, 28, null);
                    return;
                }
                TextInVoiceFeatureFlag instance = TextInVoiceFeatureFlag.INSTANCE.getINSTANCE();
                Channel selectedTextChannel = viewState.getSelectedTextChannel();
                String encodedStreamKey = null;
                if (!instance.isEnabled(selectedTextChannel != null ? Long.valueOf(selectedTextChannel.getGuildId()) : null) && ((streamContext = viewState.getStreamContext()) == null || !streamContext.isCurrentUserParticipating())) {
                    WidgetVoiceBottomSheet.Companion companion = WidgetVoiceBottomSheet.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetGlobalStatusIndicator.this.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager, viewState.getSelectedVoiceChannel().getId(), true, WidgetVoiceBottomSheet.FeatureContext.HOME);
                    return;
                }
                Channel selectedTextChannel2 = viewState.getSelectedTextChannel();
                AppTransitionActivity.Transition transition = (selectedTextChannel2 == null || !ChannelUtils.m7675J(selectedTextChannel2)) ? AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE : AppTransitionActivity.Transition.TYPE_SLIDE_HORIZONTAL_REVERSE;
                WidgetCallFullscreen.Companion companion2 = WidgetCallFullscreen.INSTANCE;
                Context contextRequireContext = WidgetGlobalStatusIndicator.this.requireContext();
                StreamContext streamContext2 = viewState.getStreamContext();
                long id2 = (streamContext2 == null || (stream2 = streamContext2.getStream()) == null) ? viewState.getSelectedVoiceChannel().getId() : stream2.getChannelId();
                StreamContext streamContext3 = viewState.getStreamContext();
                if (streamContext3 != null && (stream = streamContext3.getStream()) != null) {
                    encodedStreamKey = stream.getEncodedStreamKey();
                }
                WidgetCallFullscreen.Companion.launch$default(companion2, contextRequireContext, id2, false, encodedStreamKey, transition, 4, null);
            }
        });
    }

    private final void setupIndicatorStatus(WidgetGlobalStatusIndicatorViewModel.ViewState.CallOngoing viewState) {
        String name;
        String strM886y;
        LinearLayout linearLayout = getBinding().f16722e;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.indicatorActions");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = getBinding().f16720c;
        VoiceViewUtils voiceViewUtils = VoiceViewUtils.INSTANCE;
        linearLayout2.setBackgroundColor(voiceViewUtils.getConnectionStatusColor(viewState.getConnectionState(), viewState.getConnectionQuality(), requireContext()));
        String strM7681e = ChannelUtils.m7681e(viewState.getSelectedVoiceChannel(), requireContext(), false, 2);
        CharSequence connectedText = voiceViewUtils.getConnectedText(requireContext(), viewState.getConnectionState(), viewState.getStreamContext(), viewState.getHasVideo());
        Guild guild = viewState.getGuild();
        if (guild != null && (name = guild.getName()) != null && (strM886y = C1643a.m886y(name, " / ", strM7681e)) != null) {
            strM7681e = strM886y;
        }
        String str = connectedText + ": " + strM7681e;
        TextView textView = getBinding().f16726i;
        C12238m.checkNotNullExpressionValue(textView, "binding.indicatorText");
        textView.setText(str);
        getBinding().f16726i.setTextColor(ColorCompat.getColor(getContext(), C5419R.color.white));
        ImageView imageView = getBinding().f16725h;
        imageView.setVisibility(0);
        imageView.setImageResource(voiceViewUtils.getCallIndicatorIcon(viewState.getHasVideo(), viewState.getStreamContext()));
    }

    private final void setupOfflineState(boolean isAirplaneMode) {
        resetContentVisibility(getBinding());
        getBinding().f16720c.setBackgroundColor(ColorCompat.getThemedColor(requireContext(), C5419R.attr.colorBackgroundTertiary));
        getBinding().f16726i.setTextColor(ColorCompat.getThemedColor(requireContext(), C5419R.attr.colorHeaderPrimary));
        getBinding().f16726i.setText(isAirplaneMode ? C5419R.string.network_offline_airplane_mode : C5419R.string.network_offline);
        ImageView imageView = getBinding().f16725h;
        imageView.setVisibility(0);
        imageView.setImageResource(isAirplaneMode ? DrawableCompat.getThemedDrawableRes$default(requireContext(), C5419R.attr.ic_network_airplane_mode, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(requireContext(), C5419R.attr.ic_network_offline, 0, 2, (Object) null));
    }

    private final void setupStageContainerClicks(final WidgetGlobalStatusIndicatorViewModel.ViewState.StageChannelOngoing viewState) {
        getBinding().f16720c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.status.WidgetGlobalStatusIndicator.setupStageContainerClicks.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, WidgetGlobalStatusIndicator.this.requireContext(), viewState.getSelectedVoiceChannel().getId(), false, null, null, 28, null);
            }
        });
        getBinding().f16721d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.status.WidgetGlobalStatusIndicator.setupStageContainerClicks.2

            /* JADX INFO: renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$setupStageContainerClicks$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
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
                    C0876m.m169g(WidgetGlobalStatusIndicator.this.getContext(), C5419R.string.stage_channel_permission_microphone_denied, 0, null, 12);
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$setupStageContainerClicks$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
            public static final class AnonymousClass2 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass2() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetGlobalStatusIndicator.this.getViewModel().ackStageInvitationToSpeak(true);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGlobalStatusIndicator.this.requestMicrophone(new AnonymousClass1(), new AnonymousClass2());
            }
        });
        getBinding().f16724g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.status.WidgetGlobalStatusIndicator.setupStageContainerClicks.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGlobalStatusIndicator.this.getViewModel().ackStageInvitationToSpeak(false);
            }
        });
    }

    private final void setupStageIndicatorStatus(WidgetGlobalStatusIndicatorViewModel.ViewState.StageChannelOngoing viewState) {
        resetContentVisibility(getBinding());
        int color = viewState.getIsSpeakingInOngoingCall() ? ContextCompat.getColor(requireContext(), C5419R.color.white) : ColorCompat.getThemedColor(requireContext(), C5419R.attr.colorHeaderPrimary);
        getBinding().f16720c.setBackgroundColor(viewState.getIsSpeakingInOngoingCall() ? ContextCompat.getColor(requireContext(), C5419R.color.status_green_600) : ColorCompat.getThemedColor(requireContext(), C5419R.attr.colorBackgroundTertiary));
        getBinding().f16726i.setTextColor(color);
        getBinding().f16724g.setTextColor(color);
        LinearLayout linearLayout = getBinding().f16722e;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.indicatorActions");
        linearLayout.setVisibility(viewState.isInvitedToSpeak() ? 0 : 8);
        ImageView imageView = getBinding().f16725h;
        WidgetGlobalStatusIndicatorState.State state = this.lastIndicatorState;
        imageView.setVisibility(state != null && !state.isViewingCall() ? 0 : 8);
        Drawable drawable = ContextCompat.getDrawable(imageView.getContext(), C5419R.drawable.ic_channel_stage_16dp);
        CharSequence name = null;
        if (drawable != null) {
            C12238m.checkNotNullExpressionValue(drawable, "drawable");
            ColorCompatKt.setTint(drawable, color, false);
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
        if (!viewState.isInvitedToSpeak()) {
            StageInstance stageInstance = viewState.getStageInstance();
            String topic = stageInstance != null ? stageInstance.getTopic() : null;
            Guild guild = viewState.getGuild();
            name = guild != null ? guild.getName() : null;
            String name2 = viewState.getSelectedVoiceChannel().getName();
            Context contextRequireContext = requireContext();
            TextView textView = getBinding().f16726i;
            C12238m.checkNotNullExpressionValue(textView, "binding.indicatorText");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (topic != null) {
                SpannableUtilsKt.appendWithFont(spannableStringBuilder, contextRequireContext, C5419R.attr.font_primary_semibold, topic);
                SpannableUtilsKt.appendWithFont(spannableStringBuilder, contextRequireContext, C5419R.attr.font_primary_semibold, ": ");
            }
            if (name != null) {
                SpannableUtilsKt.appendWithFont(spannableStringBuilder, contextRequireContext, C5419R.attr.font_primary_normal, name);
                SpannableUtilsKt.appendWithFont(spannableStringBuilder, contextRequireContext, C5419R.attr.font_primary_normal, ": ");
            }
            if (name2 != null) {
                SpannableUtilsKt.appendWithFont(spannableStringBuilder, contextRequireContext, C5419R.attr.font_primary_normal, name2);
            }
            textView.setText(spannableStringBuilder);
            return;
        }
        getBinding().f16726i.setText(C5419R.string.stage_speak_invite_header);
        getBinding().f16721d.setText(C5419R.string.stage_speak_invite_accept);
        MaterialButton materialButton = getBinding().f16721d;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.indicatorAccept");
        materialButton.setEnabled(!viewState.isAckingInvitation());
        getBinding().f16724g.setText(C5419R.string.stage_speak_invite_decline);
        MaterialButton materialButton2 = getBinding().f16724g;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.indicatorDecline");
        materialButton2.setEnabled(!viewState.isAckingInvitation());
        TextView textView2 = getBinding().f16719b;
        C12238m.checkNotNullExpressionValue(textView2, "binding.alertText");
        textView2.setVisibility(viewState.getBlockedUsersOnStage() != 0 ? 0 : 8);
        TextView textView3 = getBinding().f16719b;
        C12238m.checkNotNullExpressionValue(textView3, "binding.alertText");
        Context context = getContext();
        if (context != null) {
            Object[] objArr = new Object[1];
            Context context2 = getContext();
            objArr[0] = context2 != null ? StringResourceUtilsKt.getI18nPluralString(context2, C5419R.plurals.stage_speak_invite_blocked_users_number, viewState.getBlockedUsersOnStage(), Integer.valueOf(viewState.getBlockedUsersOnStage())) : null;
            name = C1107b.m216h(context, C5419R.string.stage_speak_invite_blocked_users, objArr, null, 4);
        }
        textView3.setText(name);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.status.WidgetGlobalStatusIndicator.onViewBound.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                C12238m.checkNotNullParameter(view2, "container");
                C12238m.checkNotNullParameter(windowInsetsCompat, "insets");
                view2.setPadding(view2.getPaddingLeft(), windowInsetsCompat.getSystemWindowInsetTop(), view2.getPaddingRight(), view2.getPaddingBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(this.indicatorState.observeState(), this, null, 2, null), (Class<?>) WidgetGlobalStatusIndicator.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C101021(this));
        Observable<WidgetGlobalStatusIndicatorViewModel.ViewState> observableBindDelay = bindDelay(getViewModel().observeViewState());
        C12238m.checkNotNullExpressionValue(observableBindDelay, "viewModel\n        .obser…te()\n        .bindDelay()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableBindDelay, this, null, 2, null), (Class<?>) WidgetGlobalStatusIndicator.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C101032(this));
    }
}
