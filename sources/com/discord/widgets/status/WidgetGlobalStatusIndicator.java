package com.discord.widgets.status;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.stageinstance.StageInstance;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGlobalStatusIndicatorBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.SpannableUtilsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.voice.VoiceViewUtils;
import com.google.android.material.button.MaterialButton;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicator extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGlobalStatusIndicator.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGlobalStatusIndicatorBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private AnimatedVectorDrawableCompat connectingVector;
    private final WidgetGlobalStatusIndicator$connectingVectorReplayCallback$1 connectingVectorReplayCallback;
    private final WidgetGlobalStatusIndicatorState indicatorState;
    private WidgetGlobalStatusIndicatorState$State lastIndicatorState;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGlobalStatusIndicator() {
        super(R$layout.widget_global_status_indicator);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetGlobalStatusIndicator$binding$2.INSTANCE, new WidgetGlobalStatusIndicator$binding$3(this));
        this.indicatorState = WidgetGlobalStatusIndicatorState.Provider.get();
        WidgetGlobalStatusIndicator$viewModel$2 widgetGlobalStatusIndicator$viewModel$2 = WidgetGlobalStatusIndicator$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGlobalStatusIndicatorViewModel.class), new WidgetGlobalStatusIndicator$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGlobalStatusIndicator$viewModel$2));
        this.connectingVectorReplayCallback = new WidgetGlobalStatusIndicator$connectingVectorReplayCallback$1(this);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator, WidgetGlobalStatusIndicatorViewModel$ViewState widgetGlobalStatusIndicatorViewModel$ViewState) {
        widgetGlobalStatusIndicator.configureUI(widgetGlobalStatusIndicatorViewModel$ViewState);
    }

    public static final /* synthetic */ void access$configureUIVisibility(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator, WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$State) {
        widgetGlobalStatusIndicator.configureUIVisibility(widgetGlobalStatusIndicatorState$State);
    }

    public static final /* synthetic */ AnimatedVectorDrawableCompat access$getConnectingVector$p(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
        return widgetGlobalStatusIndicator.connectingVector;
    }

    public static final /* synthetic */ WidgetGlobalStatusIndicatorViewModel access$getViewModel$p(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
        return widgetGlobalStatusIndicator.getViewModel();
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator, WidgetGlobalStatusIndicatorBinding widgetGlobalStatusIndicatorBinding) {
        widgetGlobalStatusIndicator.onViewBindingDestroy(widgetGlobalStatusIndicatorBinding);
    }

    public static final /* synthetic */ void access$setConnectingVector$p(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator, AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        widgetGlobalStatusIndicator.connectingVector = animatedVectorDrawableCompat;
    }

    private final Observable<WidgetGlobalStatusIndicatorViewModel$ViewState> bindDelay(Observable<WidgetGlobalStatusIndicatorViewModel$ViewState> observable) {
        return observable.Y(new WidgetGlobalStatusIndicator$bindDelay$1(observable));
    }

    private final void configureUI(WidgetGlobalStatusIndicatorViewModel$ViewState viewState) {
        WidgetGlobalStatusIndicatorState.updateState$default(this.indicatorState, !m.areEqual(viewState, WidgetGlobalStatusIndicatorViewModel$ViewState$Inactive.INSTANCE), viewState.getIsSpeakingInOngoingCall(), false, 4, null);
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.connectingVector;
        if (animatedVectorDrawableCompat != null) {
            animatedVectorDrawableCompat.unregisterAnimationCallback(this.connectingVectorReplayCallback);
        }
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = this.connectingVector;
        if (animatedVectorDrawableCompat2 != null) {
            animatedVectorDrawableCompat2.stop();
        }
        if (viewState instanceof WidgetGlobalStatusIndicatorViewModel$ViewState$Offline) {
            setupOfflineState(((WidgetGlobalStatusIndicatorViewModel$ViewState$Offline) viewState).getAirplaneMode());
        } else if (viewState instanceof WidgetGlobalStatusIndicatorViewModel$ViewState$Connecting) {
            setupConnectingState();
        } else if (viewState instanceof WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing) {
            WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing = (WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing) viewState;
            setupContainerClicks(widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing);
            setupIndicatorStatus(widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing);
        } else if (viewState instanceof WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing) {
            WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing = (WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing) viewState;
            setupStageContainerClicks(widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing);
            setupStageIndicatorStatus(widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing);
        } else {
            resetContentVisibility(getBinding());
        }
        WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$State = this.lastIndicatorState;
        if (widgetGlobalStatusIndicatorState$State == null || !widgetGlobalStatusIndicatorState$State.isViewingCall()) {
            return;
        }
        LinearLayout linearLayout = getBinding().c;
        m.checkNotNullExpressionValue(linearLayout, "binding.indicator");
        LinearLayout linearLayout2 = getBinding().e;
        m.checkNotNullExpressionValue(linearLayout2, "binding.indicatorActions");
        linearLayout.setVisibility(linearLayout2.getVisibility() == 0 ? 0 : 8);
    }

    private final void configureUIVisibility(WidgetGlobalStatusIndicatorState$State state) {
        this.lastIndicatorState = state;
        LinearLayout linearLayout = getBinding().c;
        m.checkNotNullExpressionValue(linearLayout, "binding.indicator");
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
        LinearLayout linearLayout = binding.f;
        m.checkNotNullExpressionValue(linearLayout, "binding.indicatorContent");
        linearLayout.setVisibility(0);
        TextView textView = binding.f2405b;
        m.checkNotNullExpressionValue(textView, "binding.alertText");
        textView.setVisibility(8);
    }

    private final void setupConnectingState() {
        resetContentVisibility(getBinding());
        getBinding().c.setBackgroundColor(ColorCompat.getThemedColor(requireContext(), 2130968914));
        getBinding().i.setTextColor(ColorCompat.getThemedColor(requireContext(), 2130968989));
        TextView textView = getBinding().i;
        m.checkNotNullExpressionValue(textView, "binding.indicatorText");
        textView.setText(getString(2131887853));
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = null;
        if (this.connectingVector == null && Build$VERSION.SDK_INT != 28) {
            this.connectingVector = AnimatedVectorDrawableCompat.create(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), 2130969519, 0, 2, (Object) null));
        }
        ImageView imageView = getBinding().h;
        imageView.setVisibility(0);
        if (Build$VERSION.SDK_INT == 28) {
            imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(requireContext(), 2130969518, 0, 2, (Object) null));
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

    private final void setupContainerClicks(WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing viewState) {
        getBinding().c.setOnClickListener(new WidgetGlobalStatusIndicator$setupContainerClicks$1(this, viewState));
    }

    private final void setupIndicatorStatus(WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing viewState) {
        String name;
        String strY;
        LinearLayout linearLayout = getBinding().e;
        m.checkNotNullExpressionValue(linearLayout, "binding.indicatorActions");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = getBinding().c;
        VoiceViewUtils voiceViewUtils = VoiceViewUtils.INSTANCE;
        linearLayout2.setBackgroundColor(voiceViewUtils.getConnectionStatusColor(viewState.getConnectionState(), viewState.getConnectionQuality(), requireContext()));
        String strE = ChannelUtils.e(viewState.getSelectedVoiceChannel(), requireContext(), false, 2);
        CharSequence connectedText = voiceViewUtils.getConnectedText(requireContext(), viewState.getConnectionState(), viewState.getStreamContext(), viewState.getHasVideo());
        Guild guild = viewState.getGuild();
        if (guild != null && (name = guild.getName()) != null && (strY = a.y(name, " / ", strE)) != null) {
            strE = strY;
        }
        String str = connectedText + ": " + strE;
        TextView textView = getBinding().i;
        m.checkNotNullExpressionValue(textView, "binding.indicatorText");
        textView.setText(str);
        getBinding().i.setTextColor(ColorCompat.getColor(getContext(), 2131100487));
        ImageView imageView = getBinding().h;
        imageView.setVisibility(0);
        imageView.setImageResource(voiceViewUtils.getCallIndicatorIcon(viewState.getHasVideo(), viewState.getStreamContext()));
    }

    private final void setupOfflineState(boolean isAirplaneMode) {
        resetContentVisibility(getBinding());
        getBinding().c.setBackgroundColor(ColorCompat.getThemedColor(requireContext(), 2130968914));
        getBinding().i.setTextColor(ColorCompat.getThemedColor(requireContext(), 2130968989));
        getBinding().i.setText(isAirplaneMode ? 2131893180 : 2131893179);
        ImageView imageView = getBinding().h;
        imageView.setVisibility(0);
        imageView.setImageResource(isAirplaneMode ? DrawableCompat.getThemedDrawableRes$default(requireContext(), 2130969517, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(requireContext(), 2130969520, 0, 2, (Object) null));
    }

    private final void setupStageContainerClicks(WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing viewState) {
        getBinding().c.setOnClickListener(new WidgetGlobalStatusIndicator$setupStageContainerClicks$1(this, viewState));
        getBinding().d.setOnClickListener(new WidgetGlobalStatusIndicator$setupStageContainerClicks$2(this));
        getBinding().g.setOnClickListener(new WidgetGlobalStatusIndicator$setupStageContainerClicks$3(this));
    }

    private final void setupStageIndicatorStatus(WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing viewState) {
        resetContentVisibility(getBinding());
        int color = viewState.getIsSpeakingInOngoingCall() ? ContextCompat.getColor(requireContext(), 2131100487) : ColorCompat.getThemedColor(requireContext(), 2130968989);
        getBinding().c.setBackgroundColor(viewState.getIsSpeakingInOngoingCall() ? ContextCompat.getColor(requireContext(), 2131100304) : ColorCompat.getThemedColor(requireContext(), 2130968914));
        getBinding().i.setTextColor(color);
        getBinding().g.setTextColor(color);
        LinearLayout linearLayout = getBinding().e;
        m.checkNotNullExpressionValue(linearLayout, "binding.indicatorActions");
        linearLayout.setVisibility(viewState.isInvitedToSpeak() ? 0 : 8);
        ImageView imageView = getBinding().h;
        WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$State = this.lastIndicatorState;
        imageView.setVisibility(widgetGlobalStatusIndicatorState$State != null && !widgetGlobalStatusIndicatorState$State.isViewingCall() ? 0 : 8);
        Drawable drawable = ContextCompat.getDrawable(imageView.getContext(), 2131231624);
        CharSequence name = null;
        if (drawable != null) {
            m.checkNotNullExpressionValue(drawable, "drawable");
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
            TextView textView = getBinding().i;
            m.checkNotNullExpressionValue(textView, "binding.indicatorText");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (topic != null) {
                SpannableUtilsKt.appendWithFont(spannableStringBuilder, contextRequireContext, 2130969396, topic);
                SpannableUtilsKt.appendWithFont(spannableStringBuilder, contextRequireContext, 2130969396, ": ");
            }
            if (name != null) {
                SpannableUtilsKt.appendWithFont(spannableStringBuilder, contextRequireContext, 2130969395, name);
                SpannableUtilsKt.appendWithFont(spannableStringBuilder, contextRequireContext, 2130969395, ": ");
            }
            if (name2 != null) {
                SpannableUtilsKt.appendWithFont(spannableStringBuilder, contextRequireContext, 2130969395, name2);
            }
            textView.setText(spannableStringBuilder);
            return;
        }
        getBinding().i.setText(2131895837);
        getBinding().d.setText(2131895834);
        MaterialButton materialButton = getBinding().d;
        m.checkNotNullExpressionValue(materialButton, "binding.indicatorAccept");
        materialButton.setEnabled(!viewState.isAckingInvitation());
        getBinding().g.setText(2131895836);
        MaterialButton materialButton2 = getBinding().g;
        m.checkNotNullExpressionValue(materialButton2, "binding.indicatorDecline");
        materialButton2.setEnabled(!viewState.isAckingInvitation());
        TextView textView2 = getBinding().f2405b;
        m.checkNotNullExpressionValue(textView2, "binding.alertText");
        textView2.setVisibility(viewState.getBlockedUsersOnStage() != 0 ? 0 : 8);
        TextView textView3 = getBinding().f2405b;
        m.checkNotNullExpressionValue(textView3, "binding.alertText");
        Context context = getContext();
        if (context != null) {
            Object[] objArr = new Object[1];
            Context context2 = getContext();
            objArr[0] = context2 != null ? StringResourceUtilsKt.getI18nPluralString(context2, R$plurals.stage_speak_invite_blocked_users_number, viewState.getBlockedUsersOnStage(), Integer.valueOf(viewState.getBlockedUsersOnStage())) : null;
            name = b.h(context, 2131895835, objArr, null, 4);
        }
        textView3.setText(name);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ViewCompat.setOnApplyWindowInsetsListener(view, WidgetGlobalStatusIndicator$onViewBound$1.INSTANCE);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(this.indicatorState.observeState(), this, null, 2, null), WidgetGlobalStatusIndicator.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGlobalStatusIndicator$onViewBoundOrOnResume$1(this), 62, (Object) null);
        Observable<WidgetGlobalStatusIndicatorViewModel$ViewState> observableBindDelay = bindDelay(getViewModel().observeViewState());
        m.checkNotNullExpressionValue(observableBindDelay, "viewModel\n        .obser…te()\n        .bindDelay()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableBindDelay, this, null, 2, null), WidgetGlobalStatusIndicator.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGlobalStatusIndicator$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
