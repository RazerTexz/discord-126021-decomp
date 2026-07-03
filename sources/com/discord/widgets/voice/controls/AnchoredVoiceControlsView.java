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
import com.discord.C5419R;
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
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p026j.C1100a;
import p007b.p008a.p058v.C1311a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;

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

    /* JADX INFO: renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$setOnPttPressedListener$1 */
    /* JADX INFO: compiled from: AnchoredVoiceControlsView.kt */
    public static final class C104341 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public final /* synthetic */ Function1 $onPttPressed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C104341(Function1 function1) {
            super(1);
            this.$onPttPressed = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
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
            TooltipManager.C6648b c6648b = ScreenShareButtonSparkleTooltip.INSTANCE;
            Objects.requireNonNull(tooltipManager);
            C12238m.checkNotNullParameter(c6648b, "tooltip");
            if (!(tooltipManager.tooltipNameToTooltipViewIdMap.get(c6648b.getTooltipName()) != null)) {
                ImageView imageView = this.binding.f15012f;
                C12238m.checkNotNullExpressionValue(imageView, "binding.voiceFullscreenControlsScreenshare");
                Context context = imageView.getContext();
                C12238m.checkNotNullExpressionValue(context, "binding.voiceFullscreenControlsScreenshare.context");
                SparkleView sparkleView = new SparkleView(context, null);
                sparkleView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.AnchoredVoiceControlsView.configureScreenShareButtonSparkle.1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AnchoredVoiceControlsView.this.tooltipManager.m8512a(ScreenShareButtonSparkleTooltip.INSTANCE);
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
                View view = this.binding.f15012f;
                C12238m.checkNotNullExpressionValue(view, "binding.voiceFullscreenControlsScreenshare");
                FloatingViewGravity floatingViewGravity = FloatingViewGravity.CENTER;
                Observable<R> observableM11083G = appComponent.getUnsubscribeSignal().m11083G(new InterfaceC12589b<Void, Unit>() { // from class: com.discord.widgets.voice.controls.AnchoredVoiceControlsView.configureScreenShareButtonSparkle.2
                    @Override // p637j0.p641k.InterfaceC12589b
                    public /* bridge */ /* synthetic */ Unit call(Void r1) {
                        call2(r1);
                        return Unit.f27425a;
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final void call2(Void r1) {
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11083G, "appComponent.unsubscribeSignal.map { Unit }");
                tooltipManager2.m8515d(view, sparkleView, c6648b, floatingViewGravity, 0, 0, false, observableM11083G);
                return;
            }
        }
        if (showSparkle) {
            return;
        }
        this.tooltipManager.m8514c(ScreenShareButtonSparkleTooltip.INSTANCE);
    }

    public final void configureUI(MediaEngineConnection.InputMode inputMode, StoreAudioManagerV2.State audioManagerState, boolean isMuted, boolean isScreensharing, boolean showScreenShareSparkle, CameraState cameraState, final Function0<Unit> onMutePressed, final Function0<Unit> onScreenSharePressed, final Function0<Unit> onSpeakerButtonPressed, final Function0<Unit> onCameraButtonPressed, final Function0<Unit> onDisconnectPressed, AppComponent appComponent, FragmentManager fragmentManager, Function0<Unit> onNavigateToScreenShareNfxSheet, long channelId, long guildId, boolean forwardToFullscreenIfVideoActivated, WidgetVoiceBottomSheet.FeatureContext featureContext) {
        String string;
        C12238m.checkNotNullParameter(inputMode, "inputMode");
        C12238m.checkNotNullParameter(audioManagerState, "audioManagerState");
        C12238m.checkNotNullParameter(cameraState, "cameraState");
        C12238m.checkNotNullParameter(onMutePressed, "onMutePressed");
        C12238m.checkNotNullParameter(onScreenSharePressed, "onScreenSharePressed");
        C12238m.checkNotNullParameter(onSpeakerButtonPressed, "onSpeakerButtonPressed");
        C12238m.checkNotNullParameter(onCameraButtonPressed, "onCameraButtonPressed");
        C12238m.checkNotNullParameter(onDisconnectPressed, "onDisconnectPressed");
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(onNavigateToScreenShareNfxSheet, "onNavigateToScreenShareNfxSheet");
        C12238m.checkNotNullParameter(featureContext, "featureContext");
        MaterialButton materialButton = this.binding.f15011e;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.voiceFullscreenControlsPtt");
        materialButton.setVisibility(inputMode.ordinal() != 1 ? 8 : 0);
        this.binding.f15008b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.AnchoredVoiceControlsView.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onCameraButtonPressed.invoke();
            }
        });
        ImageView imageView = this.binding.f15008b;
        C12238m.checkNotNullExpressionValue(imageView, "binding.voiceFullscreenControlsCamera");
        imageView.setVisibility(cameraState != CameraState.CAMERA_DISABLED ? 0 : 8);
        if (cameraState == CameraState.CAMERA_ON) {
            ImageView imageView2 = this.binding.f15008b;
            C12238m.checkNotNullExpressionValue(imageView2, "binding.voiceFullscreenControlsCamera");
            imageView2.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorInteractiveActive)));
            ImageView imageView3 = this.binding.f15008b;
            C12238m.checkNotNullExpressionValue(imageView3, "binding.voiceFullscreenControlsCamera");
            imageView3.setContentDescription(getContext().getString(C5419R.string.camera_on));
        } else {
            ImageView imageView4 = this.binding.f15008b;
            C12238m.checkNotNullExpressionValue(imageView4, "binding.voiceFullscreenControlsCamera");
            imageView4.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorInteractiveNormal)));
            ImageView imageView5 = this.binding.f15008b;
            C12238m.checkNotNullExpressionValue(imageView5, "binding.voiceFullscreenControlsCamera");
            imageView5.setContentDescription(getContext().getString(C5419R.string.camera_off));
        }
        if (audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET) {
            this.binding.f15013g.setImageResource(C5419R.drawable.ic_audio_output_bluetooth_white_24dp);
        } else {
            this.binding.f15013g.setImageResource(C5419R.drawable.ic_audio_output_white_24dp);
        }
        if (audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.EARPIECE || audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.WIRED_HEADSET) {
            ImageView imageView6 = this.binding.f15013g;
            C12238m.checkNotNullExpressionValue(imageView6, "binding.voiceFullscreenControlsSpeaker");
            int themedColor = ColorCompat.getThemedColor(imageView6.getContext(), C5419R.attr.colorInteractiveNormal);
            ImageView imageView7 = this.binding.f15013g;
            C12238m.checkNotNullExpressionValue(imageView7, "binding.voiceFullscreenControlsSpeaker");
            imageView7.setImageTintList(ColorStateList.valueOf(themedColor));
        } else {
            ImageView imageView8 = this.binding.f15013g;
            C12238m.checkNotNullExpressionValue(imageView8, "binding.voiceFullscreenControlsSpeaker");
            int themedColor2 = ColorCompat.getThemedColor(imageView8.getContext(), C5419R.attr.colorInteractiveActive);
            ImageView imageView9 = this.binding.f15013g;
            C12238m.checkNotNullExpressionValue(imageView9, "binding.voiceFullscreenControlsSpeaker");
            imageView9.setImageTintList(ColorStateList.valueOf(themedColor2));
        }
        ImageView imageView10 = this.binding.f15013g;
        C12238m.checkNotNullExpressionValue(imageView10, "binding.voiceFullscreenControlsSpeaker");
        imageView10.setActivated(audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.SPEAKERPHONE);
        this.binding.f15013g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.AnchoredVoiceControlsView.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onSpeakerButtonPressed.invoke();
            }
        });
        ImageView imageView11 = this.binding.f15010d;
        C12238m.checkNotNullExpressionValue(imageView11, "binding.voiceFullscreenControlsMuteState");
        imageView11.setActivated(isMuted);
        ImageView imageView12 = this.binding.f15010d;
        C12238m.checkNotNullExpressionValue(imageView12, "binding.voiceFullscreenControlsMuteState");
        imageView12.setContentDescription(getContext().getString(isMuted ? C5419R.string.unmute : C5419R.string.mute));
        this.binding.f15010d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.AnchoredVoiceControlsView.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onMutePressed.invoke();
            }
        });
        ImageView imageView13 = this.binding.f15012f;
        C12238m.checkNotNullExpressionValue(imageView13, "binding.voiceFullscreenControlsScreenshare");
        imageView13.setActivated(isScreensharing);
        this.binding.f15012f.setImageResource(isScreensharing ? C5419R.drawable.ic_mobile_screenshare_end_24dp : C5419R.drawable.ic_mobile_screenshare_24dp);
        ImageView imageView14 = this.binding.f15012f;
        C12238m.checkNotNullExpressionValue(imageView14, "binding.voiceFullscreenControlsScreenshare");
        Context context = getContext();
        if (context != null) {
            string = context.getString(isScreensharing ? C5419R.string.stop_streaming : C5419R.string.screenshare_screen);
        } else {
            string = null;
        }
        imageView14.setContentDescription(string);
        this.binding.f15012f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.AnchoredVoiceControlsView.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onScreenSharePressed.invoke();
            }
        });
        configureScreenShareButtonSparkle(showScreenShareSparkle, appComponent, fragmentManager, channelId, guildId, forwardToFullscreenIfVideoActivated, featureContext, onNavigateToScreenShareNfxSheet, onScreenSharePressed);
        this.binding.f15009c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.AnchoredVoiceControlsView.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onDisconnectPressed.invoke();
            }
        });
    }

    public final void hidePtt() {
        MaterialButton materialButton = this.binding.f15011e;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.voiceFullscreenControlsPtt");
        materialButton.setVisibility(8);
    }

    public final void setOnPttPressedListener(Function1<? super Boolean, Unit> onPttPressed) {
        C12238m.checkNotNullParameter(onPttPressed, "onPttPressed");
        this.binding.f15011e.setOnTouchListener(new OnPressListener(new C104341(onPttPressed)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredVoiceControlsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.anchored_voice_controls_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i2 = C5419R.id.voice_fullscreen_controls_camera;
        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.voice_fullscreen_controls_camera);
        if (imageView != null) {
            i2 = C5419R.id.voice_fullscreen_controls_controls_wrap;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.voice_fullscreen_controls_controls_wrap);
            if (linearLayout != null) {
                i2 = C5419R.id.voice_fullscreen_controls_disconnect;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(C5419R.id.voice_fullscreen_controls_disconnect);
                if (imageView2 != null) {
                    i2 = C5419R.id.voice_fullscreen_controls_mute_state;
                    ImageView imageView3 = (ImageView) viewInflate.findViewById(C5419R.id.voice_fullscreen_controls_mute_state);
                    if (imageView3 != null) {
                        i2 = C5419R.id.voice_fullscreen_controls_ptt;
                        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.voice_fullscreen_controls_ptt);
                        if (materialButton != null) {
                            i2 = C5419R.id.voice_fullscreen_controls_screenshare;
                            ImageView imageView4 = (ImageView) viewInflate.findViewById(C5419R.id.voice_fullscreen_controls_screenshare);
                            if (imageView4 != null) {
                                i2 = C5419R.id.voice_fullscreen_controls_speaker;
                                ImageView imageView5 = (ImageView) viewInflate.findViewById(C5419R.id.voice_fullscreen_controls_speaker);
                                if (imageView5 != null) {
                                    AnchoredVoiceControlsViewBinding anchoredVoiceControlsViewBinding = new AnchoredVoiceControlsViewBinding((LinearLayout) viewInflate, imageView, linearLayout, imageView2, imageView3, materialButton, imageView4, imageView5);
                                    C12238m.checkNotNullExpressionValue(anchoredVoiceControlsViewBinding, "AnchoredVoiceControlsVie…rom(context), this, true)");
                                    this.binding = anchoredVoiceControlsViewBinding;
                                    AppLog appLog = AppLog.f14950g;
                                    C12238m.checkNotNullParameter(appLog, "logger");
                                    WeakReference<C1100a> weakReference = C1100a.b.f1460a;
                                    C1100a c1100a = weakReference != null ? weakReference.get() : null;
                                    if (c1100a == null) {
                                        c1100a = new C1100a(appLog);
                                        C1100a.b.f1460a = new WeakReference<>(c1100a);
                                    }
                                    C1100a c1100a2 = c1100a;
                                    TooltipManager.C6647a c6647a = TooltipManager.C6647a.f18975d;
                                    C12238m.checkNotNullParameter(c1100a2, "floatingViewManager");
                                    WeakReference<TooltipManager> weakReference2 = TooltipManager.C6647a.f18972a;
                                    TooltipManager tooltipManager = weakReference2 != null ? weakReference2.get() : null;
                                    if (tooltipManager == null) {
                                        tooltipManager = new TooltipManager((C1311a) TooltipManager.C6647a.f18973b.getValue(), (Set) TooltipManager.C6647a.f18974c.getValue(), 0, c1100a2, 4);
                                        TooltipManager.C6647a.f18972a = new WeakReference<>(tooltipManager);
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
