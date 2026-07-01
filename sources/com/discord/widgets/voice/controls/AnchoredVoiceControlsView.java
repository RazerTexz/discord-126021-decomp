package com.discord.widgets.voice.controls;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import b.a.j.FloatingViewManager;
import b.a.v.AcknowledgedTooltipsCache;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.databinding.AnchoredVoiceControlsViewBinding;
import com.discord.floating_view_manager.FloatingViewGravity;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.tooltips.SparkleView;
import com.discord.tooltips.TooltipManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.press.OnPressListener;
import com.discord.widgets.voice.controls.WidgetScreenShareNfxSheet;
import com.discord.widgets.voice.model.CameraState;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: AnchoredVoiceControlsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredVoiceControlsView extends FrameLayout {
    private final AnchoredVoiceControlsViewBinding binding;
    private final TooltipManager tooltipManager;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            MediaEngineConnection.InputMode.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[MediaEngineConnection.InputMode.PUSH_TO_TALK.ordinal()] = 1;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$setOnPttPressedListener$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnchoredVoiceControlsView.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ Function1 $onPttPressed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(1);
            this.$onPttPressed = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            this.$onPttPressed.invoke(Boolean.valueOf(z2));
        }
    }

    public AnchoredVoiceControlsView(Context context) {
        this(context, null, 0, 6, null);
    }

    public AnchoredVoiceControlsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ AnchoredVoiceControlsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
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
    private final void configureScreenShareButtonSparkle(boolean showSparkle, AppComponent appComponent, final FragmentManager fragmentManager, final long channelId, final long guildId, final boolean forwardToFullscreenIfVideoActivated, final WidgetVoiceBottomSheet.FeatureContext featureContext, final Function0<Unit> onNavigateToScreenShareNfxSheet, final Function0<Unit> onScreenSharePressed) {
        if (showSparkle) {
            TooltipManager tooltipManager = this.tooltipManager;
            TooltipManager.b bVar = ScreenShareButtonSparkleTooltip.INSTANCE;
            Objects.requireNonNull(tooltipManager);
            Intrinsics3.checkNotNullParameter(bVar, "tooltip");
            if (!(tooltipManager.tooltipNameToTooltipViewIdMap.get(bVar.getTooltipName()) != null)) {
                ImageView imageView = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.voiceFullscreenControlsScreenshare");
                Context context = imageView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.voiceFullscreenControlsScreenshare.context");
                SparkleView sparkleView = new SparkleView(context, null);
                sparkleView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.AnchoredVoiceControlsView.configureScreenShareButtonSparkle.1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AnchoredVoiceControlsView.this.tooltipManager.a(ScreenShareButtonSparkleTooltip.INSTANCE);
                        WidgetScreenShareNfxSheet.Companion companion = WidgetScreenShareNfxSheet.INSTANCE;
                        if (!companion.canShow()) {
                            onScreenSharePressed.invoke();
                        } else {
                            companion.show(fragmentManager, channelId, guildId, new WidgetScreenShareNfxSheet.VoiceBottomSheetParams(forwardToFullscreenIfVideoActivated, featureContext));
                            onNavigateToScreenShareNfxSheet.invoke();
                        }
                    }
                });
                TooltipManager tooltipManager2 = this.tooltipManager;
                View view = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(view, "binding.voiceFullscreenControlsScreenshare");
                FloatingViewGravity floatingViewGravity = FloatingViewGravity.CENTER;
                Observable<R> observableG = appComponent.getUnsubscribeSignal().G(new Func1<Void, Unit>() { // from class: com.discord.widgets.voice.controls.AnchoredVoiceControlsView.configureScreenShareButtonSparkle.2
                    @Override // j0.k.Func1
                    public /* bridge */ /* synthetic */ Unit call(Void r1) {
                        call2(r1);
                        return Unit.a;
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final void call2(Void r1) {
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableG, "appComponent.unsubscribeSignal.map { Unit }");
                tooltipManager2.d(view, sparkleView, bVar, floatingViewGravity, 0, 0, false, observableG);
                return;
            }
        }
        if (showSparkle) {
            return;
        }
        this.tooltipManager.c(ScreenShareButtonSparkleTooltip.INSTANCE);
    }

    public final void configureUI(MediaEngineConnection.InputMode inputMode, StoreAudioManagerV2.State audioManagerState, boolean isMuted, boolean isScreensharing, boolean showScreenShareSparkle, CameraState cameraState, final Function0<Unit> onMutePressed, final Function0<Unit> onScreenSharePressed, final Function0<Unit> onSpeakerButtonPressed, final Function0<Unit> onCameraButtonPressed, final Function0<Unit> onDisconnectPressed, AppComponent appComponent, FragmentManager fragmentManager, Function0<Unit> onNavigateToScreenShareNfxSheet, long channelId, long guildId, boolean forwardToFullscreenIfVideoActivated, WidgetVoiceBottomSheet.FeatureContext featureContext) {
        String string;
        Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
        Intrinsics3.checkNotNullParameter(audioManagerState, "audioManagerState");
        Intrinsics3.checkNotNullParameter(cameraState, "cameraState");
        Intrinsics3.checkNotNullParameter(onMutePressed, "onMutePressed");
        Intrinsics3.checkNotNullParameter(onScreenSharePressed, "onScreenSharePressed");
        Intrinsics3.checkNotNullParameter(onSpeakerButtonPressed, "onSpeakerButtonPressed");
        Intrinsics3.checkNotNullParameter(onCameraButtonPressed, "onCameraButtonPressed");
        Intrinsics3.checkNotNullParameter(onDisconnectPressed, "onDisconnectPressed");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(onNavigateToScreenShareNfxSheet, "onNavigateToScreenShareNfxSheet");
        Intrinsics3.checkNotNullParameter(featureContext, "featureContext");
        MaterialButton materialButton = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.voiceFullscreenControlsPtt");
        materialButton.setVisibility(inputMode.ordinal() != 1 ? 8 : 0);
        this.binding.f2088b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.AnchoredVoiceControlsView.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onCameraButtonPressed.invoke();
            }
        });
        ImageView imageView = this.binding.f2088b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.voiceFullscreenControlsCamera");
        imageView.setVisibility(cameraState != CameraState.CAMERA_DISABLED ? 0 : 8);
        if (cameraState == CameraState.CAMERA_ON) {
            ImageView imageView2 = this.binding.f2088b;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.voiceFullscreenControlsCamera");
            imageView2.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), R.attr.colorInteractiveActive)));
            ImageView imageView3 = this.binding.f2088b;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.voiceFullscreenControlsCamera");
            imageView3.setContentDescription(getContext().getString(R.string.camera_on));
        } else {
            ImageView imageView4 = this.binding.f2088b;
            Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.voiceFullscreenControlsCamera");
            imageView4.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), R.attr.colorInteractiveNormal)));
            ImageView imageView5 = this.binding.f2088b;
            Intrinsics3.checkNotNullExpressionValue(imageView5, "binding.voiceFullscreenControlsCamera");
            imageView5.setContentDescription(getContext().getString(R.string.camera_off));
        }
        if (audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET) {
            this.binding.g.setImageResource(R.drawable.ic_audio_output_bluetooth_white_24dp);
        } else {
            this.binding.g.setImageResource(R.drawable.ic_audio_output_white_24dp);
        }
        if (audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.EARPIECE || audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.WIRED_HEADSET) {
            ImageView imageView6 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(imageView6, "binding.voiceFullscreenControlsSpeaker");
            int themedColor = ColorCompat.getThemedColor(imageView6.getContext(), R.attr.colorInteractiveNormal);
            ImageView imageView7 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(imageView7, "binding.voiceFullscreenControlsSpeaker");
            imageView7.setImageTintList(ColorStateList.valueOf(themedColor));
        } else {
            ImageView imageView8 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(imageView8, "binding.voiceFullscreenControlsSpeaker");
            int themedColor2 = ColorCompat.getThemedColor(imageView8.getContext(), R.attr.colorInteractiveActive);
            ImageView imageView9 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(imageView9, "binding.voiceFullscreenControlsSpeaker");
            imageView9.setImageTintList(ColorStateList.valueOf(themedColor2));
        }
        ImageView imageView10 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(imageView10, "binding.voiceFullscreenControlsSpeaker");
        imageView10.setActivated(audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.SPEAKERPHONE);
        this.binding.g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.AnchoredVoiceControlsView.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onSpeakerButtonPressed.invoke();
            }
        });
        ImageView imageView11 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(imageView11, "binding.voiceFullscreenControlsMuteState");
        imageView11.setActivated(isMuted);
        ImageView imageView12 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(imageView12, "binding.voiceFullscreenControlsMuteState");
        imageView12.setContentDescription(getContext().getString(isMuted ? R.string.unmute : R.string.mute));
        this.binding.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.AnchoredVoiceControlsView.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onMutePressed.invoke();
            }
        });
        ImageView imageView13 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(imageView13, "binding.voiceFullscreenControlsScreenshare");
        imageView13.setActivated(isScreensharing);
        this.binding.f.setImageResource(isScreensharing ? R.drawable.ic_mobile_screenshare_end_24dp : R.drawable.ic_mobile_screenshare_24dp);
        ImageView imageView14 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(imageView14, "binding.voiceFullscreenControlsScreenshare");
        Context context = getContext();
        if (context != null) {
            string = context.getString(isScreensharing ? R.string.stop_streaming : R.string.screenshare_screen);
        } else {
            string = null;
        }
        imageView14.setContentDescription(string);
        this.binding.f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.AnchoredVoiceControlsView.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onScreenSharePressed.invoke();
            }
        });
        configureScreenShareButtonSparkle(showScreenShareSparkle, appComponent, fragmentManager, channelId, guildId, forwardToFullscreenIfVideoActivated, featureContext, onNavigateToScreenShareNfxSheet, onScreenSharePressed);
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.AnchoredVoiceControlsView.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onDisconnectPressed.invoke();
            }
        });
    }

    public final void hidePtt() {
        MaterialButton materialButton = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.voiceFullscreenControlsPtt");
        materialButton.setVisibility(8);
    }

    public final void setOnPttPressedListener(Function1<? super Boolean, Unit> onPttPressed) {
        Intrinsics3.checkNotNullParameter(onPttPressed, "onPttPressed");
        this.binding.e.setOnTouchListener(new OnPressListener(new AnonymousClass1(onPttPressed)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredVoiceControlsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.anchored_voice_controls_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i2 = R.id.voice_fullscreen_controls_camera;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.voice_fullscreen_controls_camera);
        if (imageView != null) {
            i2 = R.id.voice_fullscreen_controls_controls_wrap;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.voice_fullscreen_controls_controls_wrap);
            if (linearLayout != null) {
                i2 = R.id.voice_fullscreen_controls_disconnect;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.voice_fullscreen_controls_disconnect);
                if (imageView2 != null) {
                    i2 = R.id.voice_fullscreen_controls_mute_state;
                    ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.voice_fullscreen_controls_mute_state);
                    if (imageView3 != null) {
                        i2 = R.id.voice_fullscreen_controls_ptt;
                        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.voice_fullscreen_controls_ptt);
                        if (materialButton != null) {
                            i2 = R.id.voice_fullscreen_controls_screenshare;
                            ImageView imageView4 = (ImageView) viewInflate.findViewById(R.id.voice_fullscreen_controls_screenshare);
                            if (imageView4 != null) {
                                i2 = R.id.voice_fullscreen_controls_speaker;
                                ImageView imageView5 = (ImageView) viewInflate.findViewById(R.id.voice_fullscreen_controls_speaker);
                                if (imageView5 != null) {
                                    AnchoredVoiceControlsViewBinding anchoredVoiceControlsViewBinding = new AnchoredVoiceControlsViewBinding((LinearLayout) viewInflate, imageView, linearLayout, imageView2, imageView3, materialButton, imageView4, imageView5);
                                    Intrinsics3.checkNotNullExpressionValue(anchoredVoiceControlsViewBinding, "AnchoredVoiceControlsVie…rom(context), this, true)");
                                    this.binding = anchoredVoiceControlsViewBinding;
                                    AppLog appLog = AppLog.g;
                                    Intrinsics3.checkNotNullParameter(appLog, "logger");
                                    WeakReference<FloatingViewManager> weakReference = FloatingViewManager.b.a;
                                    FloatingViewManager floatingViewManager = weakReference != null ? weakReference.get() : null;
                                    if (floatingViewManager == null) {
                                        floatingViewManager = new FloatingViewManager(appLog);
                                        FloatingViewManager.b.a = new WeakReference<>(floatingViewManager);
                                    }
                                    FloatingViewManager floatingViewManager2 = floatingViewManager;
                                    TooltipManager.a aVar = TooltipManager.a.d;
                                    Intrinsics3.checkNotNullParameter(floatingViewManager2, "floatingViewManager");
                                    WeakReference<TooltipManager> weakReference2 = TooltipManager.a.a;
                                    TooltipManager tooltipManager = weakReference2 != null ? weakReference2.get() : null;
                                    if (tooltipManager == null) {
                                        tooltipManager = new TooltipManager((AcknowledgedTooltipsCache) TooltipManager.a.f2815b.getValue(), (Set) TooltipManager.a.c.getValue(), 0, floatingViewManager2, 4);
                                        TooltipManager.a.a = new WeakReference<>(tooltipManager);
                                    }
                                    this.tooltipManager = tooltipManager;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }
}
