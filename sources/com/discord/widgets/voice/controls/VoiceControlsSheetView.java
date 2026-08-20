package com.discord.widgets.voice.controls;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.discord.C5419R;
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
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p507d0.p508a0.C11210a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: VoiceControlsSheetView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceControlsSheetView extends LinearLayout {
    private final VoiceControlsSheetViewBinding binding;
    private boolean isGestureNavigationEnabled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceControlsSheetView(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        VoiceControlsSheetViewBinding voiceControlsSheetViewBindingM8402a = VoiceControlsSheetViewBinding.m8402a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(voiceControlsSheetViewBindingM8402a, "VoiceControlsSheetViewBi…ater.from(context), this)");
        this.binding = voiceControlsSheetViewBindingM8402a;
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        this.isGestureNavigationEnabled = DisplayUtils.isGestureNavigationEnabled(resources);
        CardView cardView = voiceControlsSheetViewBindingM8402a.f15608r;
        C12238m.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility(this.isGestureNavigationEnabled ? 0 : 4);
    }

    private final void configureInviteButtons(CallModel callModel, final Function0<Unit> onInviteClick, boolean showInTopRow) {
        this.binding.f15598h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.VoiceControlsSheetView.configureInviteButtons.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onInviteClick.invoke();
            }
        });
        this.binding.f15599i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.VoiceControlsSheetView.configureInviteButtons.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onInviteClick.invoke();
            }
        });
        ImageView imageView = this.binding.f15598h;
        C12238m.checkNotNullExpressionValue(imageView, "binding.inviteButton");
        imageView.setVisibility(callModel.canInvite() && showInTopRow ? 0 : 8);
        TextView textView = this.binding.f15599i;
        C12238m.checkNotNullExpressionValue(textView, "binding.inviteSecondaryButton");
        textView.setVisibility(callModel.canInvite() && !showInTopRow ? 0 : 8);
        ImageView imageView2 = this.binding.f15598h;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.inviteButton");
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        imageView2.setBackgroundTintList(ColorStateList.valueOf(getDefaultButtonBackgroundTint(context, false)));
    }

    /* JADX INFO: renamed from: configureMoveToAudienceButton-yox5PQY, reason: not valid java name */
    private final void m11438configureMoveToAudienceButtonyox5PQY(final StageRoles stageRoles, final Function0<Unit> onMoveToAudienceClick) {
        ImageView imageView = this.binding.f15600j;
        imageView.setVisibility((stageRoles == null || !StageRoles.m11410isSpeakerimpl(stageRoles.m11412unboximpl()) || StageRoles.m11409isModeratorimpl(stageRoles.m11412unboximpl())) ? false : true ? 0 : 8);
        ImageView imageView2 = this.binding.f15600j;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.moveToAudienceButton");
        imageView2.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(imageView.getContext(), C5419R.color.white_alpha_24)));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureMoveToAudienceButton$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onMoveToAudienceClick.invoke();
            }
        });
    }

    /* JADX INFO: renamed from: configureMuteButton-P2fzehM, reason: not valid java name */
    private final void m11439configureMuteButtonP2fzehM(CallModel model, StageRoles stageRoles, final Function0<Unit> onMuteClick) {
        if (stageRoles != null && !StageRoles.m11410isSpeakerimpl(stageRoles.m11412unboximpl())) {
            ImageView imageView = this.binding.f15601k;
            C12238m.checkNotNullExpressionValue(imageView, "binding.muteButton");
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.binding.f15601k;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.muteButton");
        imageView2.setVisibility(0);
        boolean zIsMeMutedByAnySource = model.isMeMutedByAnySource();
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, zIsMeMutedByAnySource);
        ImageView imageView3 = this.binding.f15601k;
        C12238m.checkNotNullExpressionValue(imageView3, "binding.muteButton");
        imageView3.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        this.binding.f15601k.setImageResource(zIsMeMutedByAnySource ? C5419R.drawable.ic_mic_mute_red_strike_24dp : C5419R.drawable.ic_mic_white_24dp);
        this.binding.f15601k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureMuteButton$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onMuteClick.invoke();
            }
        });
        ImageView imageView4 = this.binding.f15601k;
        C12238m.checkNotNullExpressionValue(imageView4, "binding.muteButton");
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        imageView4.setContentDescription(C1107b.m216h(context2, zIsMeMutedByAnySource ? C5419R.string.unmute : C5419R.string.mute, new Object[0], null, 4));
    }

    private final void configureOutputSelectors(VoiceControlsOutputSelectorState outputSelectorState, final Function0<Unit> onAudioOutputClick, boolean showInTopRow) {
        FrameLayout frameLayout = this.binding.f15593c;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.audioOutputContainer");
        frameLayout.setVisibility(showInTopRow ? 0 : 8);
        this.binding.f15592b.setImageDrawable(ContextCompat.getDrawable(getContext(), outputSelectorState.getAudioOutputIconRes()));
        ImageView imageView = this.binding.f15592b;
        C12238m.checkNotNullExpressionValue(imageView, "binding.audioOutputButton");
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        imageView.setBackgroundTintList(ColorStateList.valueOf(getDefaultButtonBackgroundTint(context, outputSelectorState.getIsButtonActive())));
        TextView textView = this.binding.f15595e;
        C12238m.checkNotNullExpressionValue(textView, "binding.audioOutputSecondaryButton");
        textView.setVisibility(showInTopRow ^ true ? 0 : 8);
        TextView textView2 = this.binding.f15595e;
        C12238m.checkNotNullExpressionValue(textView2, "binding.audioOutputSecondaryButton");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, outputSelectorState.getAudioOutputIconRes(), 0, 0, 0, 14, null);
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        int defaultButtonIconTint = getDefaultButtonIconTint(context2, outputSelectorState.getIsButtonActive());
        ImageView imageView2 = this.binding.f15592b;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.audioOutputButton");
        ColorCompatKt.tintWithColor(imageView2, defaultButtonIconTint);
        ImageView imageView3 = this.binding.f15594d;
        C12238m.checkNotNullExpressionValue(imageView3, "binding.audioOutputMore");
        ColorCompatKt.tintWithColor(imageView3, defaultButtonIconTint);
        ImageView imageView4 = this.binding.f15594d;
        C12238m.checkNotNullExpressionValue(imageView4, "binding.audioOutputMore");
        imageView4.setVisibility(outputSelectorState.getShowMoreOptions() ? 0 : 8);
        this.binding.f15592b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.VoiceControlsSheetView.configureOutputSelectors.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onAudioOutputClick.invoke();
            }
        });
        this.binding.f15595e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.VoiceControlsSheetView.configureOutputSelectors.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onAudioOutputClick.invoke();
            }
        });
    }

    /* JADX INFO: renamed from: configureRaiseHandButton-fw_bWyM, reason: not valid java name */
    private final void m11440configureRaiseHandButtonfw_bWyM(final CallModel model, final StageRoles stageRoles, int requestingToSpeakCount, final boolean isUpdatingRequestToSpeak, final Function0<Unit> onRaiseHandClick) {
        int i;
        if (stageRoles == null || !(StageRoles.m11409isModeratorimpl(stageRoles.m11412unboximpl()) || StageRoles.m11407isAudienceimpl(stageRoles.m11412unboximpl()))) {
            NumericBadgingView numericBadgingView = this.binding.f15604n;
            C12238m.checkNotNullExpressionValue(numericBadgingView, "binding.raiseHandBadge");
            numericBadgingView.setVisibility(8);
            return;
        }
        NumericBadgingView numericBadgingView2 = this.binding.f15604n;
        boolean z2 = false;
        numericBadgingView2.setVisibility(0);
        if (!StageRoles.m11409isModeratorimpl(stageRoles.m11412unboximpl())) {
            requestingToSpeakCount = 0;
        }
        numericBadgingView2.setBadgeNumber(requestingToSpeakCount);
        ImageView imageView = this.binding.f15605o;
        if (StageRoles.m11409isModeratorimpl(stageRoles.m11412unboximpl())) {
            imageView.setContentDescription(imageView.getResources().getString(C5419R.string.request_to_speak_area_title));
            ViewExtensions.setEnabledAndAlpha$default(imageView, true, 0.0f, 2, null);
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), C5419R.drawable.ic_stage_raised_hand_list));
        } else {
            Resources resources = imageView.getResources();
            if (model.canRequestToSpeak()) {
                i = model.isMyHandRaised() ? C5419R.string.audience_lower_hand : C5419R.string.audience_raise_hand_cta;
            } else {
                i = C5419R.string.audience_raise_hand_no_permission;
            }
            imageView.setContentDescription(resources.getString(i));
            ViewExtensions.setEnabledAndAlpha(imageView, !isUpdatingRequestToSpeak && model.canRequestToSpeak(), 0.2f);
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), C5419R.drawable.ic_stage_raised_hand));
        }
        if (model.isMyHandRaised() && !StageRoles.m11409isModeratorimpl(stageRoles.m11412unboximpl())) {
            z2 = true;
        }
        Context context = imageView.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, z2);
        Context context2 = imageView.getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        int defaultButtonIconTint = getDefaultButtonIconTint(context2, z2);
        imageView.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        ColorCompatKt.tintWithColor(imageView, defaultButtonIconTint);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureRaiseHandButton$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onRaiseHandClick.invoke();
            }
        });
    }

    private final void configureScreenshareButtons(CallModel model, final Function0<Unit> onScreenshareClick, boolean showInTopRow) {
        boolean z2 = !ChannelUtils.m7669D(model.getChannel());
        boolean zIsStreaming = model.isStreaming();
        int i = zIsStreaming ? C5419R.string.stop_streaming : C5419R.string.mobile_stream_screen_share;
        ImageView imageView = this.binding.f15606p;
        C12238m.checkNotNullExpressionValue(imageView, "binding.screenShareButton");
        imageView.setVisibility(z2 && showInTopRow ? 0 : 8);
        int i2 = zIsStreaming ? C5419R.drawable.ic_mobile_screenshare_end_24dp : C5419R.drawable.ic_mobile_screenshare_24dp;
        int i3 = zIsStreaming ? ViewCompat.MEASURED_STATE_MASK : -1;
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, zIsStreaming);
        this.binding.f15606p.setImageResource(i2);
        ImageView imageView2 = this.binding.f15606p;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.screenShareButton");
        imageView2.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        ImageView imageView3 = this.binding.f15606p;
        C12238m.checkNotNullExpressionValue(imageView3, "binding.screenShareButton");
        imageView3.setImageTintList(ColorStateList.valueOf(i3));
        this.binding.f15606p.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.VoiceControlsSheetView.configureScreenshareButtons.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onScreenshareClick.invoke();
            }
        });
        TextView textView = this.binding.f15607q;
        C12238m.checkNotNullExpressionValue(textView, "binding.screenShareSecondaryButton");
        textView.setVisibility(z2 && !showInTopRow ? 0 : 8);
        this.binding.f15607q.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.VoiceControlsSheetView.configureScreenshareButtons.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onScreenshareClick.invoke();
            }
        });
        TextView textView2 = this.binding.f15607q;
        C12238m.checkNotNullExpressionValue(textView2, "binding.screenShareSecondaryButton");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, i2, 0, 0, 0, 14, null);
        this.binding.f15607q.setText(i);
    }

    private final void configureStreamVolume(boolean showStreamVolume, float perceptualStreamVolume, Function2<? super Float, ? super Boolean, Unit> onStreamVolumeChange) {
        TextView textView = this.binding.f15611u;
        C12238m.checkNotNullExpressionValue(textView, "binding.streamVolumeLabel");
        textView.setVisibility(showStreamVolume ? 0 : 8);
        VolumeSliderView volumeSliderView = this.binding.f15612v;
        C12238m.checkNotNullExpressionValue(volumeSliderView, "binding.streamVolumeSlider");
        volumeSliderView.setVisibility(showStreamVolume ? 0 : 8);
        VolumeSliderView volumeSliderView2 = this.binding.f15612v;
        int iRoundToInt = C11210a.roundToInt(perceptualStreamVolume);
        SeekBar seekBar = volumeSliderView2.binding.f1034d;
        C12238m.checkNotNullExpressionValue(seekBar, "binding.volumeSliderSeekBar");
        seekBar.setProgress(iRoundToInt);
        this.binding.f15612v.setOnVolumeChange(onStreamVolumeChange);
    }

    private final void configureVideoButton(CallModel model, final Function0<Unit> onVideoClick, boolean isVideoEnabledForCall) {
        boolean z2 = model.getSelectedVideoDevice() != null;
        boolean z3 = !model.getVideoDevices().isEmpty();
        ImageView imageView = this.binding.f15613w;
        C12238m.checkNotNullExpressionValue(imageView, "binding.videoButton");
        imageView.setVisibility(z3 && isVideoEnabledForCall ? 0 : 8);
        int i = z2 ? ViewCompat.MEASURED_STATE_MASK : -1;
        ImageView imageView2 = this.binding.f15613w;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.videoButton");
        imageView2.setImageTintList(ColorStateList.valueOf(i));
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, z2);
        ImageView imageView3 = this.binding.f15613w;
        C12238m.checkNotNullExpressionValue(imageView3, "binding.videoButton");
        imageView3.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        this.binding.f15613w.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.VoiceControlsSheetView.configureVideoButton.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onVideoClick.invoke();
            }
        });
    }

    private final int getDefaultButtonBackgroundTint(Context context, boolean isActive) {
        if (isActive) {
            return ColorCompat.getColor(context, C5419R.color.white);
        }
        if (isActive) {
            throw new NoWhenBranchMatchedException();
        }
        return ColorCompat.getColor(context, C5419R.color.white_alpha_24);
    }

    private final int getDefaultButtonIconTint(Context context, boolean isActive) {
        if (!isActive) {
            return ColorCompat.getColor(context, C5419R.color.white);
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C5419R.attr.call_controls_active_button_icon_color, typedValue, true);
        return ColorCompat.getColor(context, typedValue.resourceId);
    }

    /* JADX INFO: renamed from: configureUI-3jxq49Y, reason: not valid java name */
    public final void m11441configureUI3jxq49Y(CallModel model, VoiceControlsOutputSelectorState outputSelectorState, boolean isVideoEnabledForCall, boolean isPttEnabled, boolean isDeafened, boolean startedAsVideo, boolean showStopWatching, final boolean showDisconnect, final Function0<Unit> onStopWatchingClick, final Function0<Unit> onDisconnectClick, Function0<Unit> onAudioOutputClick, Function0<Unit> onVideoClick, Function0<Unit> onMuteClick, Function0<Unit> onInviteClick, Function0<Unit> onScreenshareClick, boolean showStreamVolume, float perceptualStreamVolume, Function2<? super Float, ? super Boolean, Unit> onStreamVolumeChange, final Function0<Unit> onDeafenPressed, int requestingToSpeakCount, Function0<Unit> onRaiseHandClick, Function0<Unit> onMoveToAudienceClick, boolean isUpdatingRequestToSpeak, final StageRoles stageRoles) {
        int i;
        C12238m.checkNotNullParameter(model, "model");
        C12238m.checkNotNullParameter(outputSelectorState, "outputSelectorState");
        C12238m.checkNotNullParameter(onStopWatchingClick, "onStopWatchingClick");
        C12238m.checkNotNullParameter(onDisconnectClick, "onDisconnectClick");
        C12238m.checkNotNullParameter(onAudioOutputClick, "onAudioOutputClick");
        C12238m.checkNotNullParameter(onVideoClick, "onVideoClick");
        C12238m.checkNotNullParameter(onMuteClick, "onMuteClick");
        C12238m.checkNotNullParameter(onInviteClick, "onInviteClick");
        C12238m.checkNotNullParameter(onScreenshareClick, "onScreenshareClick");
        C12238m.checkNotNullParameter(onStreamVolumeChange, "onStreamVolumeChange");
        C12238m.checkNotNullParameter(onDeafenPressed, "onDeafenPressed");
        C12238m.checkNotNullParameter(onRaiseHandClick, "onRaiseHandClick");
        C12238m.checkNotNullParameter(onMoveToAudienceClick, "onMoveToAudienceClick");
        ImageView imageView = this.binding.f15610t;
        C12238m.checkNotNullExpressionValue(imageView, "binding.stopWatchingButton");
        imageView.setVisibility(showStopWatching ? 0 : 8);
        this.binding.f15610t.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureUI$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onStopWatchingClick.invoke();
            }
        });
        if (stageRoles == null || StageRoles.m11410isSpeakerimpl(stageRoles.m11412unboximpl())) {
            MaterialTextView materialTextView = this.binding.f15609s;
            C12238m.checkNotNullExpressionValue(materialTextView, "binding.stageDisconnectButtonLarge");
            i = 8;
            materialTextView.setVisibility(8);
            ImageView imageView2 = this.binding.f15597g;
            imageView2.setImageResource(stageRoles == null ? C5419R.drawable.ic_call_disconnect_24dp : C5419R.drawable.ic_stage_leave_20dp);
            imageView2.setVisibility(showDisconnect ? 0 : 8);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureUI$$inlined$apply$lambda$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    onDisconnectClick.invoke();
                }
            });
            C12238m.checkNotNullExpressionValue(imageView2, "binding.disconnectButton…sconnectClick() }\n      }");
        } else {
            ImageView imageView3 = this.binding.f15597g;
            C12238m.checkNotNullExpressionValue(imageView3, "binding.disconnectButton");
            imageView3.setVisibility(8);
            MaterialTextView materialTextView2 = this.binding.f15609s;
            materialTextView2.setVisibility(showDisconnect ? 0 : 8);
            materialTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureUI$$inlined$apply$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    onDisconnectClick.invoke();
                }
            });
            C12238m.checkNotNullExpressionValue(materialTextView2, "binding.stageDisconnectB…Click()\n        }\n      }");
            i = 8;
        }
        Button button = this.binding.f15603m;
        C12238m.checkNotNullExpressionValue(button, "binding.pushToTalkButton");
        if ((stageRoles == null || StageRoles.m11410isSpeakerimpl(stageRoles.m11412unboximpl())) && isPttEnabled) {
            i = 0;
        }
        button.setVisibility(i);
        TextView textView = this.binding.f15596f;
        C12238m.checkNotNullExpressionValue(textView, "binding.deafenSecondaryButton");
        C1107b.m221m(textView, isDeafened ? C5419R.string.undeafen : C5419R.string.deafen, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        this.binding.f15596f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureUI$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onDeafenPressed.invoke();
            }
        });
        TextView textView2 = this.binding.f15596f;
        C12238m.checkNotNullExpressionValue(textView2, "binding.deafenSecondaryButton");
        textView2.setActivated(isDeafened);
        m11438configureMoveToAudienceButtonyox5PQY(stageRoles, onMoveToAudienceClick);
        m11440configureRaiseHandButtonfw_bWyM(model, stageRoles, requestingToSpeakCount, isUpdatingRequestToSpeak, onRaiseHandClick);
        m11439configureMuteButtonP2fzehM(model, stageRoles, onMuteClick);
        configureOutputSelectors(outputSelectorState, onAudioOutputClick, (startedAsVideo || ChannelUtils.m7669D(model.getChannel())) ? false : true);
        configureVideoButton(model, onVideoClick, isVideoEnabledForCall);
        configureScreenshareButtons(model, onScreenshareClick, startedAsVideo);
        configureStreamVolume(showStreamVolume, perceptualStreamVolume, onStreamVolumeChange);
        configureInviteButtons(model, onInviteClick, ChannelUtils.m7669D(model.getChannel()));
    }

    public final int getPeekHeight() {
        LinearLayout linearLayout = this.binding.f15602l;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.peekContainer");
        return linearLayout.getMeasuredHeight();
    }

    public final void handleSheetState(int bottomSheetState) {
        CardView cardView = this.binding.f15608r;
        C12238m.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility((bottomSheetState != 4 || this.isGestureNavigationEnabled) ? 0 : 4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i;
        super.onAttachedToWindow();
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        if (resources.getConfiguration().orientation == 1) {
            Resources resources2 = getResources();
            C12238m.checkNotNullExpressionValue(resources2, "resources");
            i = resources2.getDisplayMetrics().widthPixels;
        } else {
            Resources resources3 = getResources();
            C12238m.checkNotNullExpressionValue(resources3, "resources");
            i = resources3.getDisplayMetrics().heightPixels;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    public final void setOnPTTListener(OnPressListener listener) {
        C12238m.checkNotNullParameter(listener, "listener");
        this.binding.f15603m.setOnTouchListener(listener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceControlsSheetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        VoiceControlsSheetViewBinding voiceControlsSheetViewBindingM8402a = VoiceControlsSheetViewBinding.m8402a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(voiceControlsSheetViewBindingM8402a, "VoiceControlsSheetViewBi…ater.from(context), this)");
        this.binding = voiceControlsSheetViewBindingM8402a;
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        this.isGestureNavigationEnabled = DisplayUtils.isGestureNavigationEnabled(resources);
        CardView cardView = voiceControlsSheetViewBindingM8402a.f15608r;
        C12238m.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility(this.isGestureNavigationEnabled ? 0 : 4);
    }

    public /* synthetic */ VoiceControlsSheetView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceControlsSheetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        VoiceControlsSheetViewBinding voiceControlsSheetViewBindingM8402a = VoiceControlsSheetViewBinding.m8402a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(voiceControlsSheetViewBindingM8402a, "VoiceControlsSheetViewBi…ater.from(context), this)");
        this.binding = voiceControlsSheetViewBindingM8402a;
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        this.isGestureNavigationEnabled = DisplayUtils.isGestureNavigationEnabled(resources);
        CardView cardView = voiceControlsSheetViewBindingM8402a.f15608r;
        C12238m.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility(this.isGestureNavigationEnabled ? 0 : 4);
    }

    public /* synthetic */ VoiceControlsSheetView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
