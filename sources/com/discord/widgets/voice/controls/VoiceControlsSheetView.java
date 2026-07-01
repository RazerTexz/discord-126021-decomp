package com.discord.widgets.voice.controls;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup$LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import b.a.k.b;
import com.discord.R$drawable;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.VoiceControlsSheetViewBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.press.OnPressListener;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.NumericBadgingView;
import com.discord.views.calls.VolumeSliderView;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.model.CallModel;
import com.google.android.material.textview.MaterialTextView;
import d0.a0.a;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: VoiceControlsSheetView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceControlsSheetView extends LinearLayout {
    private final VoiceControlsSheetViewBinding binding;
    private boolean isGestureNavigationEnabled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceControlsSheetView(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        VoiceControlsSheetViewBinding voiceControlsSheetViewBindingA = VoiceControlsSheetViewBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(voiceControlsSheetViewBindingA, "VoiceControlsSheetViewBi…ater.from(context), this)");
        this.binding = voiceControlsSheetViewBindingA;
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        this.isGestureNavigationEnabled = DisplayUtils.isGestureNavigationEnabled(resources);
        CardView cardView = voiceControlsSheetViewBindingA.r;
        m.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility(this.isGestureNavigationEnabled ? 0 : 4);
    }

    private final void configureInviteButtons(CallModel callModel, Function0<Unit> onInviteClick, boolean showInTopRow) {
        this.binding.h.setOnClickListener(new VoiceControlsSheetView$configureInviteButtons$1(onInviteClick));
        this.binding.i.setOnClickListener(new VoiceControlsSheetView$configureInviteButtons$2(onInviteClick));
        ImageView imageView = this.binding.h;
        m.checkNotNullExpressionValue(imageView, "binding.inviteButton");
        imageView.setVisibility(callModel.canInvite() && showInTopRow ? 0 : 8);
        TextView textView = this.binding.i;
        m.checkNotNullExpressionValue(textView, "binding.inviteSecondaryButton");
        textView.setVisibility(callModel.canInvite() && !showInTopRow ? 0 : 8);
        ImageView imageView2 = this.binding.h;
        m.checkNotNullExpressionValue(imageView2, "binding.inviteButton");
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        imageView2.setBackgroundTintList(ColorStateList.valueOf(getDefaultButtonBackgroundTint(context, false)));
    }

    /* JADX INFO: renamed from: configureMoveToAudienceButton-yox5PQY, reason: not valid java name */
    private final void m61configureMoveToAudienceButtonyox5PQY(StageRoles stageRoles, Function0<Unit> onMoveToAudienceClick) {
        ImageView imageView = this.binding.j;
        imageView.setVisibility((stageRoles == null || !StageRoles.m33isSpeakerimpl(stageRoles.m35unboximpl()) || StageRoles.m32isModeratorimpl(stageRoles.m35unboximpl())) ? false : true ? 0 : 8);
        ImageView imageView2 = this.binding.j;
        m.checkNotNullExpressionValue(imageView2, "binding.moveToAudienceButton");
        imageView2.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(imageView.getContext(), 2131100523)));
        imageView.setOnClickListener(new VoiceControlsSheetView$configureMoveToAudienceButton$$inlined$apply$lambda$1(this, stageRoles, onMoveToAudienceClick));
    }

    /* JADX INFO: renamed from: configureMuteButton-P2fzehM, reason: not valid java name */
    private final void m62configureMuteButtonP2fzehM(CallModel model, StageRoles stageRoles, Function0<Unit> onMuteClick) {
        if (stageRoles != null && !StageRoles.m33isSpeakerimpl(stageRoles.m35unboximpl())) {
            ImageView imageView = this.binding.k;
            m.checkNotNullExpressionValue(imageView, "binding.muteButton");
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.binding.k;
        m.checkNotNullExpressionValue(imageView2, "binding.muteButton");
        imageView2.setVisibility(0);
        boolean zIsMeMutedByAnySource = model.isMeMutedByAnySource();
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, zIsMeMutedByAnySource);
        ImageView imageView3 = this.binding.k;
        m.checkNotNullExpressionValue(imageView3, "binding.muteButton");
        imageView3.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        this.binding.k.setImageResource(zIsMeMutedByAnySource ? 2131231923 : 2131231934);
        this.binding.k.setOnClickListener(new VoiceControlsSheetView$configureMuteButton$1(onMuteClick));
        ImageView imageView4 = this.binding.k;
        m.checkNotNullExpressionValue(imageView4, "binding.muteButton");
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        imageView4.setContentDescription(b.h(context2, zIsMeMutedByAnySource ? 2131896587 : 2131893137, new Object[0], null, 4));
    }

    private final void configureOutputSelectors(VoiceControlsOutputSelectorState outputSelectorState, Function0<Unit> onAudioOutputClick, boolean showInTopRow) {
        FrameLayout frameLayout = this.binding.c;
        m.checkNotNullExpressionValue(frameLayout, "binding.audioOutputContainer");
        frameLayout.setVisibility(showInTopRow ? 0 : 8);
        this.binding.f2217b.setImageDrawable(ContextCompat.getDrawable(getContext(), outputSelectorState.getAudioOutputIconRes()));
        ImageView imageView = this.binding.f2217b;
        m.checkNotNullExpressionValue(imageView, "binding.audioOutputButton");
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        imageView.setBackgroundTintList(ColorStateList.valueOf(getDefaultButtonBackgroundTint(context, outputSelectorState.getIsButtonActive())));
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.audioOutputSecondaryButton");
        textView.setVisibility(showInTopRow ^ true ? 0 : 8);
        TextView textView2 = this.binding.e;
        m.checkNotNullExpressionValue(textView2, "binding.audioOutputSecondaryButton");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, outputSelectorState.getAudioOutputIconRes(), 0, 0, 0, 14, null);
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        int defaultButtonIconTint = getDefaultButtonIconTint(context2, outputSelectorState.getIsButtonActive());
        ImageView imageView2 = this.binding.f2217b;
        m.checkNotNullExpressionValue(imageView2, "binding.audioOutputButton");
        ColorCompatKt.tintWithColor(imageView2, defaultButtonIconTint);
        ImageView imageView3 = this.binding.d;
        m.checkNotNullExpressionValue(imageView3, "binding.audioOutputMore");
        ColorCompatKt.tintWithColor(imageView3, defaultButtonIconTint);
        ImageView imageView4 = this.binding.d;
        m.checkNotNullExpressionValue(imageView4, "binding.audioOutputMore");
        imageView4.setVisibility(outputSelectorState.getShowMoreOptions() ? 0 : 8);
        this.binding.f2217b.setOnClickListener(new VoiceControlsSheetView$configureOutputSelectors$1(onAudioOutputClick));
        this.binding.e.setOnClickListener(new VoiceControlsSheetView$configureOutputSelectors$2(onAudioOutputClick));
    }

    /* JADX INFO: renamed from: configureRaiseHandButton-fw_bWyM, reason: not valid java name */
    private final void m63configureRaiseHandButtonfw_bWyM(CallModel model, StageRoles stageRoles, int requestingToSpeakCount, boolean isUpdatingRequestToSpeak, Function0<Unit> onRaiseHandClick) {
        int i;
        if (stageRoles == null || !(StageRoles.m32isModeratorimpl(stageRoles.m35unboximpl()) || StageRoles.m30isAudienceimpl(stageRoles.m35unboximpl()))) {
            NumericBadgingView numericBadgingView = this.binding.n;
            m.checkNotNullExpressionValue(numericBadgingView, "binding.raiseHandBadge");
            numericBadgingView.setVisibility(8);
            return;
        }
        NumericBadgingView numericBadgingView2 = this.binding.n;
        boolean z2 = false;
        numericBadgingView2.setVisibility(0);
        if (!StageRoles.m32isModeratorimpl(stageRoles.m35unboximpl())) {
            requestingToSpeakCount = 0;
        }
        numericBadgingView2.setBadgeNumber(requestingToSpeakCount);
        ImageView imageView = this.binding.o;
        if (StageRoles.m32isModeratorimpl(stageRoles.m35unboximpl())) {
            imageView.setContentDescription(imageView.getResources().getString(2131894813));
            ViewExtensions.setEnabledAndAlpha$default(imageView, true, 0.0f, 2, null);
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), 2131232156));
        } else {
            Resources resources = imageView.getResources();
            if (model.canRequestToSpeak()) {
                i = model.isMyHandRaised() ? 2131886891 : 2131886892;
            } else {
                i = 2131886893;
            }
            imageView.setContentDescription(resources.getString(i));
            ViewExtensions.setEnabledAndAlpha(imageView, !isUpdatingRequestToSpeak && model.canRequestToSpeak(), 0.2f);
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), 2131232153));
        }
        if (model.isMyHandRaised() && !StageRoles.m32isModeratorimpl(stageRoles.m35unboximpl())) {
            z2 = true;
        }
        Context context = imageView.getContext();
        m.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, z2);
        Context context2 = imageView.getContext();
        m.checkNotNullExpressionValue(context2, "context");
        int defaultButtonIconTint = getDefaultButtonIconTint(context2, z2);
        imageView.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        ColorCompatKt.tintWithColor(imageView, defaultButtonIconTint);
        imageView.setOnClickListener(new VoiceControlsSheetView$configureRaiseHandButton$$inlined$apply$lambda$1(this, stageRoles, model, isUpdatingRequestToSpeak, onRaiseHandClick));
    }

    private final void configureScreenshareButtons(CallModel model, Function0<Unit> onScreenshareClick, boolean showInTopRow) {
        boolean z2 = !ChannelUtils.D(model.getChannel());
        boolean zIsStreaming = model.isStreaming();
        int i = zIsStreaming ? 2131896004 : 2131893050;
        ImageView imageView = this.binding.p;
        m.checkNotNullExpressionValue(imageView, "binding.screenShareButton");
        imageView.setVisibility(z2 && showInTopRow ? 0 : 8);
        int i2 = zIsStreaming ? 2131231938 : 2131231937;
        int i3 = zIsStreaming ? ViewCompat.MEASURED_STATE_MASK : -1;
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, zIsStreaming);
        this.binding.p.setImageResource(i2);
        ImageView imageView2 = this.binding.p;
        m.checkNotNullExpressionValue(imageView2, "binding.screenShareButton");
        imageView2.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        ImageView imageView3 = this.binding.p;
        m.checkNotNullExpressionValue(imageView3, "binding.screenShareButton");
        imageView3.setImageTintList(ColorStateList.valueOf(i3));
        this.binding.p.setOnClickListener(new VoiceControlsSheetView$configureScreenshareButtons$1(onScreenshareClick));
        TextView textView = this.binding.q;
        m.checkNotNullExpressionValue(textView, "binding.screenShareSecondaryButton");
        textView.setVisibility(z2 && !showInTopRow ? 0 : 8);
        this.binding.q.setOnClickListener(new VoiceControlsSheetView$configureScreenshareButtons$2(onScreenshareClick));
        TextView textView2 = this.binding.q;
        m.checkNotNullExpressionValue(textView2, "binding.screenShareSecondaryButton");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, i2, 0, 0, 0, 14, null);
        this.binding.q.setText(i);
    }

    private final void configureStreamVolume(boolean showStreamVolume, float perceptualStreamVolume, Function2<? super Float, ? super Boolean, Unit> onStreamVolumeChange) {
        TextView textView = this.binding.u;
        m.checkNotNullExpressionValue(textView, "binding.streamVolumeLabel");
        textView.setVisibility(showStreamVolume ? 0 : 8);
        VolumeSliderView volumeSliderView = this.binding.v;
        m.checkNotNullExpressionValue(volumeSliderView, "binding.streamVolumeSlider");
        volumeSliderView.setVisibility(showStreamVolume ? 0 : 8);
        VolumeSliderView volumeSliderView2 = this.binding.v;
        int iRoundToInt = a.roundToInt(perceptualStreamVolume);
        SeekBar seekBar = volumeSliderView2.binding.d;
        m.checkNotNullExpressionValue(seekBar, "binding.volumeSliderSeekBar");
        seekBar.setProgress(iRoundToInt);
        this.binding.v.setOnVolumeChange(onStreamVolumeChange);
    }

    private final void configureVideoButton(CallModel model, Function0<Unit> onVideoClick, boolean isVideoEnabledForCall) {
        boolean z2 = model.getSelectedVideoDevice() != null;
        boolean z3 = !model.getVideoDevices().isEmpty();
        ImageView imageView = this.binding.w;
        m.checkNotNullExpressionValue(imageView, "binding.videoButton");
        imageView.setVisibility(z3 && isVideoEnabledForCall ? 0 : 8);
        int i = z2 ? ViewCompat.MEASURED_STATE_MASK : -1;
        ImageView imageView2 = this.binding.w;
        m.checkNotNullExpressionValue(imageView2, "binding.videoButton");
        imageView2.setImageTintList(ColorStateList.valueOf(i));
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, z2);
        ImageView imageView3 = this.binding.w;
        m.checkNotNullExpressionValue(imageView3, "binding.videoButton");
        imageView3.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        this.binding.w.setOnClickListener(new VoiceControlsSheetView$configureVideoButton$1(onVideoClick));
    }

    private final int getDefaultButtonBackgroundTint(Context context, boolean isActive) {
        if (isActive) {
            return ColorCompat.getColor(context, 2131100487);
        }
        if (isActive) {
            throw new NoWhenBranchMatchedException();
        }
        return ColorCompat.getColor(context, 2131100523);
    }

    private final int getDefaultButtonIconTint(Context context, boolean isActive) {
        if (!isActive) {
            return ColorCompat.getColor(context, 2131100487);
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130968764, typedValue, true);
        return ColorCompat.getColor(context, typedValue.resourceId);
    }

    /* JADX INFO: renamed from: configureUI-3jxq49Y, reason: not valid java name */
    public final void m64configureUI3jxq49Y(CallModel model, VoiceControlsOutputSelectorState outputSelectorState, boolean isVideoEnabledForCall, boolean isPttEnabled, boolean isDeafened, boolean startedAsVideo, boolean showStopWatching, boolean showDisconnect, Function0<Unit> onStopWatchingClick, Function0<Unit> onDisconnectClick, Function0<Unit> onAudioOutputClick, Function0<Unit> onVideoClick, Function0<Unit> onMuteClick, Function0<Unit> onInviteClick, Function0<Unit> onScreenshareClick, boolean showStreamVolume, float perceptualStreamVolume, Function2<? super Float, ? super Boolean, Unit> onStreamVolumeChange, Function0<Unit> onDeafenPressed, int requestingToSpeakCount, Function0<Unit> onRaiseHandClick, Function0<Unit> onMoveToAudienceClick, boolean isUpdatingRequestToSpeak, StageRoles stageRoles) {
        int i;
        m.checkNotNullParameter(model, "model");
        m.checkNotNullParameter(outputSelectorState, "outputSelectorState");
        m.checkNotNullParameter(onStopWatchingClick, "onStopWatchingClick");
        m.checkNotNullParameter(onDisconnectClick, "onDisconnectClick");
        m.checkNotNullParameter(onAudioOutputClick, "onAudioOutputClick");
        m.checkNotNullParameter(onVideoClick, "onVideoClick");
        m.checkNotNullParameter(onMuteClick, "onMuteClick");
        m.checkNotNullParameter(onInviteClick, "onInviteClick");
        m.checkNotNullParameter(onScreenshareClick, "onScreenshareClick");
        m.checkNotNullParameter(onStreamVolumeChange, "onStreamVolumeChange");
        m.checkNotNullParameter(onDeafenPressed, "onDeafenPressed");
        m.checkNotNullParameter(onRaiseHandClick, "onRaiseHandClick");
        m.checkNotNullParameter(onMoveToAudienceClick, "onMoveToAudienceClick");
        ImageView imageView = this.binding.t;
        m.checkNotNullExpressionValue(imageView, "binding.stopWatchingButton");
        imageView.setVisibility(showStopWatching ? 0 : 8);
        this.binding.t.setOnClickListener(new VoiceControlsSheetView$configureUI$1(onStopWatchingClick));
        if (stageRoles == null || StageRoles.m33isSpeakerimpl(stageRoles.m35unboximpl())) {
            MaterialTextView materialTextView = this.binding.f2218s;
            m.checkNotNullExpressionValue(materialTextView, "binding.stageDisconnectButtonLarge");
            i = 8;
            materialTextView.setVisibility(8);
            ImageView imageView2 = this.binding.g;
            imageView2.setImageResource(stageRoles == null ? 2131231590 : R$drawable.ic_stage_leave_20dp);
            imageView2.setVisibility(showDisconnect ? 0 : 8);
            imageView2.setOnClickListener(new VoiceControlsSheetView$configureUI$$inlined$apply$lambda$2(stageRoles, showDisconnect, onDisconnectClick));
            m.checkNotNullExpressionValue(imageView2, "binding.disconnectButton…sconnectClick() }\n      }");
        } else {
            ImageView imageView3 = this.binding.g;
            m.checkNotNullExpressionValue(imageView3, "binding.disconnectButton");
            imageView3.setVisibility(8);
            MaterialTextView materialTextView2 = this.binding.f2218s;
            materialTextView2.setVisibility(showDisconnect ? 0 : 8);
            materialTextView2.setOnClickListener(new VoiceControlsSheetView$configureUI$$inlined$apply$lambda$1(showDisconnect, onDisconnectClick));
            m.checkNotNullExpressionValue(materialTextView2, "binding.stageDisconnectB…Click()\n        }\n      }");
            i = 8;
        }
        Button button = this.binding.m;
        m.checkNotNullExpressionValue(button, "binding.pushToTalkButton");
        if ((stageRoles == null || StageRoles.m33isSpeakerimpl(stageRoles.m35unboximpl())) && isPttEnabled) {
            i = 0;
        }
        button.setVisibility(i);
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.deafenSecondaryButton");
        b.n(textView, isDeafened ? 2131896574 : 2131888355, new Object[0], null, 4);
        this.binding.f.setOnClickListener(new VoiceControlsSheetView$configureUI$4(onDeafenPressed));
        TextView textView2 = this.binding.f;
        m.checkNotNullExpressionValue(textView2, "binding.deafenSecondaryButton");
        textView2.setActivated(isDeafened);
        m61configureMoveToAudienceButtonyox5PQY(stageRoles, onMoveToAudienceClick);
        m63configureRaiseHandButtonfw_bWyM(model, stageRoles, requestingToSpeakCount, isUpdatingRequestToSpeak, onRaiseHandClick);
        m62configureMuteButtonP2fzehM(model, stageRoles, onMuteClick);
        configureOutputSelectors(outputSelectorState, onAudioOutputClick, (startedAsVideo || ChannelUtils.D(model.getChannel())) ? false : true);
        configureVideoButton(model, onVideoClick, isVideoEnabledForCall);
        configureScreenshareButtons(model, onScreenshareClick, startedAsVideo);
        configureStreamVolume(showStreamVolume, perceptualStreamVolume, onStreamVolumeChange);
        configureInviteButtons(model, onInviteClick, ChannelUtils.D(model.getChannel()));
    }

    public final int getPeekHeight() {
        LinearLayout linearLayout = this.binding.l;
        m.checkNotNullExpressionValue(linearLayout, "binding.peekContainer");
        return linearLayout.getMeasuredHeight();
    }

    public final void handleSheetState(int bottomSheetState) {
        CardView cardView = this.binding.r;
        m.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility((bottomSheetState != 4 || this.isGestureNavigationEnabled) ? 0 : 4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i;
        super.onAttachedToWindow();
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        if (resources.getConfiguration().orientation == 1) {
            Resources resources2 = getResources();
            m.checkNotNullExpressionValue(resources2, "resources");
            i = resources2.getDisplayMetrics().widthPixels;
        } else {
            Resources resources3 = getResources();
            m.checkNotNullExpressionValue(resources3, "resources");
            i = resources3.getDisplayMetrics().heightPixels;
        }
        ViewGroup$LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    public final void setOnPTTListener(OnPressListener listener) {
        m.checkNotNullParameter(listener, "listener");
        this.binding.m.setOnTouchListener(listener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceControlsSheetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        VoiceControlsSheetViewBinding voiceControlsSheetViewBindingA = VoiceControlsSheetViewBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(voiceControlsSheetViewBindingA, "VoiceControlsSheetViewBi…ater.from(context), this)");
        this.binding = voiceControlsSheetViewBindingA;
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        this.isGestureNavigationEnabled = DisplayUtils.isGestureNavigationEnabled(resources);
        CardView cardView = voiceControlsSheetViewBindingA.r;
        m.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility(this.isGestureNavigationEnabled ? 0 : 4);
    }

    public /* synthetic */ VoiceControlsSheetView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceControlsSheetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        VoiceControlsSheetViewBinding voiceControlsSheetViewBindingA = VoiceControlsSheetViewBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(voiceControlsSheetViewBindingA, "VoiceControlsSheetViewBi…ater.from(context), this)");
        this.binding = voiceControlsSheetViewBindingA;
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        this.isGestureNavigationEnabled = DisplayUtils.isGestureNavigationEnabled(resources);
        CardView cardView = voiceControlsSheetViewBindingA.r;
        m.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility(this.isGestureNavigationEnabled ? 0 : 4);
    }

    public /* synthetic */ VoiceControlsSheetView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
