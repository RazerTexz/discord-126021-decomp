package com.discord.widgets.settings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.a.y.OnSeekBarChangeListenerAdapter;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsVoiceBinding;
import com.discord.databinding.WidgetSettingsVoiceInputModeBinding;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ViewCoroutineScope;
import com.discord.utilities.voice.DiscordOverlayService;
import com.discord.utilities.voice.PerceptualVolumeUtils;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.google.android.material.button.MaterialButton;
import d0.Tuples;
import d0.a0.MathJVM;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice extends AppFragment {
    private static final String ARG_TARGET_AUTO_TOGGLE = "ARG_TARGET_AUTO_TOGGLE";
    private static final String ARG_TARGET_RES_ID = "ARG_TARGET_RES_ID";
    private static final int OVERLAY_PERMISSION_REQUEST_CODE = 2552;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private List<CheckedSetting> openSLESConfigRadioButtons;
    private RadioManager openSLESConfigRadioManager;
    private final BehaviorSubject<Boolean> requestListenForSensitivitySubject;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsVoice.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsVoiceBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MediaEngine.LocalVoiceStatus LOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED = new MediaEngine.LocalVoiceStatus(-1.0f, false);

    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class Companion {
        private Companion() {
        }

        private final boolean hasOverlayPermission(Context context) {
            return Build.VERSION.SDK_INT <= 22 || Settings.canDrawOverlays(context);
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, Integer num, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                num = null;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            companion.launch(context, num, z2);
        }

        public final void launch(Context context, @IdRes Integer targetResId, boolean isTargetAutoToggle) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            if (targetResId != null) {
                intent.putExtra(WidgetSettingsVoice.ARG_TARGET_RES_ID, targetResId.intValue());
            }
            if (isTargetAutoToggle) {
                intent.putExtra(WidgetSettingsVoice.ARG_TARGET_AUTO_TOGGLE, isTargetAutoToggle);
            }
            AppScreen2.d(context, WidgetSettingsVoice.class, intent);
            StoreAnalytics.onUserSettingsPaneViewed$default(StoreStream.INSTANCE.getAnalytics(), "Voice & Video", null, 2, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class InputModeSelector extends AppBottomSheet {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(InputModeSelector.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsVoiceInputModeBinding;", 0)};

        /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
        private final FragmentViewBindingDelegate binding;

        public InputModeSelector() {
            super(false, 1, null);
            this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsVoice$InputModeSelector$binding$2.INSTANCE, null, 2, null);
        }

        private final WidgetSettingsVoiceInputModeBinding getBinding() {
            return (WidgetSettingsVoiceInputModeBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
        }

        @Override // com.discord.app.AppBottomSheet
        public int getContentViewResId() {
            return R.layout.widget_settings_voice_input_mode;
        }

        @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle savedInstanceState) {
            Intrinsics3.checkNotNullParameter(view, "view");
            super.onViewCreated(view, savedInstanceState);
            setBottomSheetCollapsedStateDisabled();
            getBinding().f2646b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsVoice$InputModeSelector$onViewCreated$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    StoreStream.INSTANCE.getMediaSettings().setVoiceInputMode(MediaEngineConnection.InputMode.PUSH_TO_TALK);
                    this.this$0.dismiss();
                }
            });
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsVoice$InputModeSelector$onViewCreated$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    StoreStream.INSTANCE.getMediaSettings().setVoiceInputMode(MediaEngineConnection.InputMode.VOICE_ACTIVITY);
                    this.this$0.dismiss();
                }
            });
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            MediaEngine.OpenSLESConfig.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[MediaEngine.OpenSLESConfig.DEFAULT.ordinal()] = 1;
            iArr[MediaEngine.OpenSLESConfig.FORCE_ENABLED.ordinal()] = 2;
            iArr[MediaEngine.OpenSLESConfig.FORCE_DISABLED.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onOverlayToggled$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Tuples2<? extends RtcConnection.StateChange, ? extends Channel>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends RtcConnection.StateChange, ? extends Channel> tuples2) {
            invoke2((Tuples2<RtcConnection.StateChange, Channel>) tuples2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<RtcConnection.StateChange, Channel> tuples2) {
            DiscordOverlayService.INSTANCE.launchForVoice(this.$context);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onViewBoundOrOnResume$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetSettingsVoice.this.configureUI(model);
        }
    }

    public WidgetSettingsVoice() {
        super(R.layout.widget_settings_voice);
        this.requestListenForSensitivitySubject = BehaviorSubject.l0(Boolean.FALSE);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsVoice$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ RadioManager access$getOpenSLESConfigRadioManager$p(WidgetSettingsVoice widgetSettingsVoice) {
        RadioManager radioManager = widgetSettingsVoice.openSLESConfigRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("openSLESConfigRadioManager");
        }
        return radioManager;
    }

    private final void configureUI(Model model) {
        CheckedSetting checkedSetting;
        SeekBar seekBar = getBinding().f2642s;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.settingsVoiceOutputVolume");
        seekBar.setProgress(MathJVM.roundToInt(PerceptualVolumeUtils.amplitudeToPerceptual$default(PerceptualVolumeUtils.INSTANCE, model.getVoiceConfig().getOutputVolume(), 0.0f, 2, null)));
        getBinding().i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputModeSelector inputModeSelector = new InputModeSelector();
                FragmentManager childFragmentManager = WidgetSettingsVoice.this.getChildFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                inputModeSelector.show(childFragmentManager, String.valueOf(Reflection2.getOrCreateKotlinClass(InputModeSelector.class)));
            }
        });
        getBinding().j.setText(model.getModePTT() ? R.string.input_mode_ptt : model.getModeVAD() ? R.string.input_mode_vad : 0);
        String strJ = outline.J(new StringBuilder(), AppHelpDesk.a.a(360045138471L, null), "?utm_source=discord&utm_medium=blog&utm_campaign=2020-06_help-voice-video&utm_content=--t%3Apm");
        LinkifiedTextView linkifiedTextView = getBinding().D;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsVoiceVideoTroubleshootingGuide");
        FormatUtils.m(linkifiedTextView, R.string.form_help_voice_video_troubleshooting_guide, new Object[]{strJ}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        RadioManager radioManager = this.openSLESConfigRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("openSLESConfigRadioManager");
        }
        int iOrdinal = model.getOpenSLESConfig().ordinal();
        if (iOrdinal == 0) {
            checkedSetting = getBinding().n;
        } else if (iOrdinal == 1) {
            checkedSetting = getBinding().p;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            checkedSetting = getBinding().o;
        }
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "when (model.openSLESConf…esForceDisabled\n        }");
        radioManager.a(checkedSetting);
        List<CheckedSetting> list = this.openSLESConfigRadioButtons;
        if (list == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("openSLESConfigRadioButtons");
        }
        for (final CheckedSetting checkedSetting2 : list) {
            checkedSetting2.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$$inlined$forEach$lambda$1
                @Override // rx.functions.Action1
                public final void call(Boolean bool) {
                    WidgetSettingsVoice.access$getOpenSLESConfigRadioManager$p(this).a(checkedSetting2);
                    this.onOpenSLESConfigChanged();
                }
            });
        }
        CheckedSetting checkedSetting3 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.settingsVoiceGainControlToggle");
        checkedSetting3.setChecked(model.getVoiceConfig().getAutomaticGainControl());
        getBinding().e.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.3
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreStream.INSTANCE.getMediaSettings().toggleAutomaticGainControl();
            }
        });
        CheckedSetting checkedSetting4 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.settingsVoiceNoiseCancellationToggle");
        StoreMediaSettings.NoiseProcessing noiseProcessing = model.getVoiceConfig().getNoiseProcessing();
        StoreMediaSettings.NoiseProcessing noiseProcessing2 = StoreMediaSettings.NoiseProcessing.Cancellation;
        checkedSetting4.setChecked(noiseProcessing == noiseProcessing2);
        getBinding().k.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.4
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreStream.INSTANCE.getMediaSettings().toggleNoiseCancellation();
            }
        });
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsVoiceKrispInfo");
        FormatUtils.m(textView, R.string.learn_more_link, new Object[]{AppHelpDesk.a.a(360040843952L, null)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.settingsVoiceKrispInfo");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        CheckedSetting checkedSetting5 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.settingsVoiceNoiseSuppressionToggle");
        checkedSetting5.setChecked(model.getVoiceConfig().getNoiseProcessing() == StoreMediaSettings.NoiseProcessing.Suppression);
        if (model.getVoiceConfig().getNoiseProcessing() == noiseProcessing2) {
            getBinding().l.b(R.string.user_settings_disable_noise_suppression);
            CheckedSetting.i(getBinding().l, FormatUtils.e(this, R.string.user_settings_disable_noise_suppression, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), false, 2);
        } else {
            getBinding().l.e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StoreStream.INSTANCE.getMediaSettings().toggleNoiseSuppression();
                }
            });
            CheckedSetting.i(getBinding().l, null, false, 2);
        }
        CheckedSetting checkedSetting6 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.settingsVoiceKrispVadToggle");
        checkedSetting6.setChecked(model.getVoiceConfig().getVadUseKrisp() == StoreMediaSettings.VadUseKrisp.Enabled);
        getBinding().h.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.6
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreStream.INSTANCE.getMediaSettings().toggleVADUseKrisp();
            }
        });
        CheckedSetting checkedSetting7 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting7, "binding.settingsVoiceEchoCancellationToggle");
        checkedSetting7.setChecked(model.getVoiceConfig().getEchoCancellation());
        getBinding().c.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.7
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreStream.INSTANCE.getMediaSettings().toggleEchoCancellation();
            }
        });
        CheckedSetting checkedSetting8 = getBinding().f2641b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting8, "binding.settingsVoiceAutoVadToggle");
        checkedSetting8.setChecked(model.getVoiceConfig().getAutomaticVad());
        CheckedSetting checkedSetting9 = getBinding().f2641b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting9, "binding.settingsVoiceAutoVadToggle");
        checkedSetting9.setVisibility(model.getModeVAD() ? 0 : 8);
        getBinding().f2641b.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.8
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreStream.INSTANCE.getMediaSettings().toggleAutomaticVAD();
            }
        });
        CheckedSetting checkedSetting10 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting10, "binding.settingsVoiceEnableHardwareScalingToggle");
        checkedSetting10.setChecked(model.getVoiceConfig().getEnableVideoHardwareScaling());
        getBinding().d.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.9
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreStream.INSTANCE.getMediaSettings().toggleEnableVideoHardwareScaling();
            }
        });
        configureVoiceSensitivity(model);
    }

    private final void configureVoiceSensitivity(Model model) {
        RelativeLayout relativeLayout = getBinding().B;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.settingsVoiceSensitivityWrap");
        relativeLayout.setVisibility(model.getModeVAD() ? 0 : 8);
        TextView textView = getBinding().f2643x;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsVoiceSensitivityLabel");
        textView.setVisibility(model.getVoiceConfig().getAutomaticVad() ? 0 : 8);
        boolean z2 = !Intrinsics3.areEqual(model.getLocalVoiceStatus(), LOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED);
        LinearLayout linearLayout = getBinding().A;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsVoiceSensitivityTestingContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().f2645z;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.settingsVoiceSensitivityTestButton");
        materialButton.setVisibility(z2 ^ true ? 0 : 8);
        getBinding().f2645z.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureVoiceSensitivity.1

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureVoiceSensitivity$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
            public static final class C03331 extends Lambda implements Function0<Unit> {
                public C03331() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetSettingsVoice.this.requestListenForSensitivitySubject.onNext(Boolean.TRUE);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnimatableValueParser.S1(WidgetSettingsVoice.this, null, new C03331(), 1, null);
            }
        });
        if (model.getVoiceConfig().getAutomaticVad()) {
            View view = getBinding().w;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.settingsVoiceSensitivityAutomatic");
            view.setVisibility(0);
            SeekBar seekBar = getBinding().f2644y;
            Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.settingsVoiceSensitivityManual");
            seekBar.setVisibility(4);
            int i = model.getLocalVoiceStatus().isSpeaking ? R.drawable.drawable_voice_indicator_speaking : R.drawable.drawable_voice_indicator_not_speaking;
            View view2 = getBinding().w;
            Intrinsics3.checkNotNullExpressionValue(view2, "binding.settingsVoiceSensitivityAutomatic");
            view2.setBackground(ContextCompat.getDrawable(requireContext(), i));
            return;
        }
        View view3 = getBinding().w;
        Intrinsics3.checkNotNullExpressionValue(view3, "binding.settingsVoiceSensitivityAutomatic");
        view3.setVisibility(4);
        SeekBar seekBar2 = getBinding().f2644y;
        Intrinsics3.checkNotNullExpressionValue(seekBar2, "binding.settingsVoiceSensitivityManual");
        seekBar2.setVisibility(0);
        SeekBar seekBar3 = getBinding().f2644y;
        Intrinsics3.checkNotNullExpressionValue(seekBar3, "binding.settingsVoiceSensitivityManual");
        seekBar3.setSecondaryProgress(((int) model.getLocalVoiceStatus().amplitude) + 100);
        SeekBar seekBar4 = getBinding().f2644y;
        Intrinsics3.checkNotNullExpressionValue(seekBar4, "binding.settingsVoiceSensitivityManual");
        seekBar4.setProgress(((int) model.getVoiceConfig().getSensitivity()) + 100);
    }

    private final WidgetSettingsVoiceBinding getBinding() {
        return (WidgetSettingsVoiceBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context, @IdRes Integer num, boolean z2) {
        INSTANCE.launch(context, num, z2);
    }

    private final void onOpenSLESConfigChanged() {
        MediaEngine.OpenSLESConfig openSLESConfig;
        RadioManager radioManager = this.openSLESConfigRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("openSLESConfigRadioManager");
        }
        Checkable checkable = radioManager.buttons.get(radioManager.b());
        if (Intrinsics3.areEqual(checkable, getBinding().n)) {
            openSLESConfig = MediaEngine.OpenSLESConfig.DEFAULT;
        } else if (Intrinsics3.areEqual(checkable, getBinding().p)) {
            openSLESConfig = MediaEngine.OpenSLESConfig.FORCE_ENABLED;
        } else {
            openSLESConfig = Intrinsics3.areEqual(checkable, getBinding().o) ? MediaEngine.OpenSLESConfig.FORCE_DISABLED : null;
        }
        if (openSLESConfig != null) {
            StoreStream.INSTANCE.getMediaEngine().setOpenSLESConfig(openSLESConfig);
        }
        AppToast.i(this, R.string.user_settings_restart_app_mobile, 0, 4);
    }

    private final void onOverlayToggled(Context context) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        if (!companion.getUserSettings().getIsMobileOverlayEnabled()) {
            DiscordOverlayService.INSTANCE.launchForClose(context);
            return;
        }
        Observable<RtcConnection.StateChange> observableY = companion.getRtcConnection().getConnectionState().y(new Func1<RtcConnection.StateChange, Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.onOverlayToggled.1
            @Override // j0.k.Func1
            public final Boolean call(RtcConnection.StateChange stateChange) {
                return Boolean.valueOf(Intrinsics3.areEqual(stateChange.state, RtcConnection.State.f.a));
            }
        });
        Observable<R> observableG = companion.getVoiceChannelSelected().observeSelectedChannel().y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableJ = Observable.j(observableY, observableG, new Func2<RtcConnection.StateChange, Channel, Tuples2<? extends RtcConnection.StateChange, ? extends Channel>>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.onOverlayToggled.2
            @Override // rx.functions.Func2
            public final Tuples2<RtcConnection.StateChange, Channel> call(RtcConnection.StateChange stateChange, Channel channel) {
                return Tuples.to(stateChange, channel);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n          .co… -> rtcState to channel }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout(observableJ, 200L, false), this, null, 2, null), (Class<?>) WidgetSettingsVoice.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3(context));
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != OVERLAY_PERMISSION_REQUEST_CODE) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        boolean zHasOverlayPermission = INSTANCE.hasOverlayPermission(requireContext());
        StoreStream.INSTANCE.getUserSettings().setIsMobileOverlayEnabled(zHasOverlayPermission);
        CheckedSetting checkedSetting = getBinding().u;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsVoiceOverlayToggle");
        checkedSetting.setChecked(zHasOverlayPermission);
        CheckedSetting checkedSetting2 = getBinding().u;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsVoiceOverlayToggle");
        Context context = checkedSetting2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.settingsVoiceOverlayToggle.context");
        onOverlayToggled(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(final View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsVoiceOpenslesHelp");
        FormatUtils.m(textView, R.string.form_label_android_opensl_desc, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        CheckedSetting checkedSetting = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsVoiceOpenslesDefault");
        CheckedSetting checkedSetting2 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsVoiceOpenslesForceEnabled");
        CheckedSetting checkedSetting3 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.settingsVoiceOpenslesForceDisabled");
        List<CheckedSetting> listListOf = Collections2.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3});
        this.openSLESConfigRadioButtons = listListOf;
        if (listListOf == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("openSLESConfigRadioButtons");
        }
        this.openSLESConfigRadioManager = new RadioManager(listListOf);
        CheckedSetting checkedSetting4 = getBinding().u;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.settingsVoiceOverlayToggle");
        checkedSetting4.setChecked(StoreStream.INSTANCE.getUserSettings().getIsMobileOverlayEnabled() && INSTANCE.hasOverlayPermission(requireContext()));
        getBinding().u.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.onViewBound.1
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                if (!bool.booleanValue() || WidgetSettingsVoice.INSTANCE.hasOverlayPermission(WidgetSettingsVoice.this.requireContext())) {
                    StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
                    Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
                    userSettings.setIsMobileOverlayEnabled(bool.booleanValue());
                    WidgetSettingsVoice widgetSettingsVoice = WidgetSettingsVoice.this;
                    CheckedSetting checkedSetting5 = widgetSettingsVoice.getBinding().u;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.settingsVoiceOverlayToggle");
                    Context context = checkedSetting5.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "binding.settingsVoiceOverlayToggle.context");
                    widgetSettingsVoice.onOverlayToggled(context);
                    return;
                }
                CheckedSetting checkedSetting6 = WidgetSettingsVoice.this.getBinding().u;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.settingsVoiceOverlayToggle");
                checkedSetting6.setChecked(false);
                AnalyticsTracker.INSTANCE.permissionsRequested("overlay");
                WidgetSettingsVoice widgetSettingsVoice2 = WidgetSettingsVoice.this;
                StringBuilder sbU = outline.U("package:");
                CheckedSetting checkedSetting7 = WidgetSettingsVoice.this.getBinding().u;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting7, "binding.settingsVoiceOverlayToggle");
                Context context2 = checkedSetting7.getContext();
                Intrinsics3.checkNotNullExpressionValue(context2, "binding.settingsVoiceOverlayToggle.context");
                sbU.append(context2.getPackageName());
                widgetSettingsVoice2.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(sbU.toString())), WidgetSettingsVoice.OVERLAY_PERMISSION_REQUEST_CODE);
            }
        });
        for (TextView textView2 : Collections2.listOf((Object[]) new TextView[]{getBinding().f, getBinding().r, getBinding().t, getBinding().v, getBinding().C, getBinding().m})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView2, "header");
            accessibilityUtils.setViewIsHeading(textView2);
        }
        Integer numValueOf = Integer.valueOf(getMostRecentIntent().getIntExtra(ARG_TARGET_RES_ID, 0));
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            View viewFindViewById = view.findViewById(numValueOf.intValue());
            Intrinsics3.checkNotNullExpressionValue(viewFindViewById, "target");
            CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(viewFindViewById);
            if (coroutineScope != null) {
                f.H0(coroutineScope, null, null, new WidgetSettingsVoice$onViewBound$3$1(viewFindViewById, null), 3, null);
            }
            if (Intrinsics3.areEqual(viewFindViewById, getBinding().u)) {
                CheckedSetting checkedSetting5 = getBinding().u;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.settingsVoiceOverlayToggle");
                if (checkedSetting5.isChecked() || !getMostRecentIntent().getBooleanExtra(ARG_TARGET_AUTO_TOGGLE, false)) {
                    return;
                }
                viewFindViewById.post(new Runnable() { // from class: com.discord.widgets.settings.WidgetSettingsVoice$onViewBound$$inlined$let$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.this$0.getBinding().u.g(true, true);
                    }
                });
            }
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().f2642s.setOnSeekBarChangeListener(new OnSeekBarChangeListenerAdapter() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.onViewBoundOrOnResume.1
            @Override // b.a.y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
                if (fromUser) {
                    StoreStream.INSTANCE.getMediaSettings().setOutputVolume(PerceptualVolumeUtils.perceptualToAmplitude$default(PerceptualVolumeUtils.INSTANCE, progress, 0.0f, 2, null));
                }
            }
        });
        getBinding().f2644y.setOnSeekBarChangeListener(new OnSeekBarChangeListenerAdapter() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.onViewBoundOrOnResume.2
            @Override // b.a.y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
                if (fromUser) {
                    StoreStream.INSTANCE.getMediaSettings().setSensitivity(progress - 100.0f);
                }
            }
        });
        Model.Companion companion = Model.INSTANCE;
        BehaviorSubject<Boolean> behaviorSubject = this.requestListenForSensitivitySubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "requestListenForSensitivitySubject");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion.get(behaviorSubject), this, null, 2, null), (Class<?>) WidgetSettingsVoice.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }

    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final MediaEngine.LocalVoiceStatus localVoiceStatus;
        private final boolean modePTT;
        private final boolean modeVAD;
        private final MediaEngine.OpenSLESConfig openSLESConfig;
        private final StoreMediaSettings.VoiceConfiguration voiceConfig;

        /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(Observable<Boolean> requestListenForSensitivity) {
                Intrinsics3.checkNotNullParameter(requestListenForSensitivity, "requestListenForSensitivity");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableJ = Observable.j(requestListenForSensitivity, companion.getMediaEngine().getIsNativeEngineInitialized(), new Func2<Boolean, Boolean, Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice$Model$Companion$get$shouldListenForSensitivity$1
                    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
                    @Override // rx.functions.Func2
                    public final Boolean call(Boolean bool, Boolean bool2) {
                        boolean z2;
                        Intrinsics3.checkNotNullExpressionValue(bool, "userRequestedListenForSensitivity");
                        if (bool.booleanValue()) {
                            z2 = true;
                        } else {
                            Intrinsics3.checkNotNullExpressionValue(bool2, "isNativeEngineInitialized");
                            if (bool2.booleanValue()) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        }
                        return Boolean.valueOf(z2);
                    }
                });
                Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig = companion.getMediaSettings().getVoiceConfig();
                Observable<MediaEngine.OpenSLESConfig> openSLESConfig = companion.getMediaEngine().getOpenSLESConfig();
                Observable observableY = observableJ.Y(new Func1<Boolean, Observable<? extends MediaEngine.LocalVoiceStatus>>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice$Model$Companion$get$1
                    @Override // j0.k.Func1
                    public final Observable<? extends MediaEngine.LocalVoiceStatus> call(Boolean bool) {
                        Intrinsics3.checkNotNullExpressionValue(bool, "isListeningForSensitivity");
                        return bool.booleanValue() ? StoreStream.INSTANCE.getMediaEngine().getLocalVoiceStatus() : new ScalarSynchronousObservable(WidgetSettingsVoice.LOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED);
                    }
                });
                final WidgetSettingsVoice$Model$Companion$get$2 widgetSettingsVoice$Model$Companion$get$2 = WidgetSettingsVoice$Model$Companion$get$2.INSTANCE;
                Object obj = widgetSettingsVoice$Model$Companion$get$2;
                if (widgetSettingsVoice$Model$Companion$get$2 != null) {
                    obj = new Func3() { // from class: com.discord.widgets.settings.WidgetSettingsVoice$sam$rx_functions_Func3$0
                        @Override // rx.functions.Func3
                        public final /* synthetic */ Object call(Object obj2, Object obj3, Object obj4) {
                            return widgetSettingsVoice$Model$Companion$get$2.invoke(obj2, obj3, obj4);
                        }
                    };
                }
                Observable observableI = Observable.i(voiceConfig, openSLESConfig, observableY, (Func3) obj);
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n            .…    ::Model\n            )");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Model(StoreMediaSettings.VoiceConfiguration voiceConfiguration, MediaEngine.OpenSLESConfig openSLESConfig, MediaEngine.LocalVoiceStatus localVoiceStatus) {
            this.voiceConfig = voiceConfiguration;
            this.openSLESConfig = openSLESConfig;
            this.localVoiceStatus = localVoiceStatus;
            this.modePTT = voiceConfiguration.getInputMode() == MediaEngineConnection.InputMode.PUSH_TO_TALK;
            this.modeVAD = voiceConfiguration.getInputMode() == MediaEngineConnection.InputMode.VOICE_ACTIVITY;
        }

        public final MediaEngine.LocalVoiceStatus getLocalVoiceStatus() {
            return this.localVoiceStatus;
        }

        public final boolean getModePTT() {
            return this.modePTT;
        }

        public final boolean getModeVAD() {
            return this.modeVAD;
        }

        public final MediaEngine.OpenSLESConfig getOpenSLESConfig() {
            return this.openSLESConfig;
        }

        public final StoreMediaSettings.VoiceConfiguration getVoiceConfig() {
            return this.voiceConfig;
        }

        public /* synthetic */ Model(StoreMediaSettings.VoiceConfiguration voiceConfiguration, MediaEngine.OpenSLESConfig openSLESConfig, MediaEngine.LocalVoiceStatus localVoiceStatus, DefaultConstructorMarker defaultConstructorMarker) {
            this(voiceConfiguration, openSLESConfig, localVoiceStatus);
        }
    }
}
