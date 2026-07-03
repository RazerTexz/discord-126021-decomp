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
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.utilities.voice.DiscordOverlayService;
import com.discord.utilities.voice.PerceptualVolumeUtils;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p062y.C1337j;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12116o;
import p507d0.p508a0.C11210a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.subjects.BehaviorSubject;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsVoice.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsVoiceBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            if (targetResId != null) {
                intent.putExtra(WidgetSettingsVoice.ARG_TARGET_RES_ID, targetResId.intValue());
            }
            if (isTargetAutoToggle) {
                intent.putExtra(WidgetSettingsVoice.ARG_TARGET_AUTO_TOGGLE, isTargetAutoToggle);
            }
            C0870j.m156d(context, WidgetSettingsVoice.class, intent);
            StoreAnalytics.onUserSettingsPaneViewed$default(StoreStream.INSTANCE.getAnalytics(), "Voice & Video", null, 2, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class InputModeSelector extends AppBottomSheet {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(InputModeSelector.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsVoiceInputModeBinding;", 0)};

        /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
        private final FragmentViewBindingDelegate binding;

        public InputModeSelector() {
            super(false, 1, null);
            this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsVoice$InputModeSelector$binding$2.INSTANCE, null, 2, null);
        }

        private final WidgetSettingsVoiceInputModeBinding getBinding() {
            return (WidgetSettingsVoiceInputModeBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
        }

        @Override // com.discord.app.AppBottomSheet
        public int getContentViewResId() {
            return C5419R.layout.widget_settings_voice_input_mode;
        }

        @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle savedInstanceState) {
            C12238m.checkNotNullParameter(view, "view");
            super.onViewCreated(view, savedInstanceState);
            setBottomSheetCollapsedStateDisabled();
            getBinding().f18122b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsVoice$InputModeSelector$onViewCreated$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    StoreStream.INSTANCE.getMediaSettings().setVoiceInputMode(MediaEngineConnection.InputMode.PUSH_TO_TALK);
                    this.this$0.dismiss();
                }
            });
            getBinding().f18123c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsVoice$InputModeSelector$onViewCreated$2
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

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onOverlayToggled$3 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class C97013 extends AbstractC12240o implements Function1<Pair<? extends RtcConnection.StateChange, ? extends Channel>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C97013(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends RtcConnection.StateChange, ? extends Channel> pair) {
            invoke2((Pair<RtcConnection.StateChange, Channel>) pair);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<RtcConnection.StateChange, Channel> pair) {
            DiscordOverlayService.INSTANCE.launchForVoice(this.$context);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class C97053 extends AbstractC12240o implements Function1<Model, Unit> {
        public C97053() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "it");
            WidgetSettingsVoice.this.configureUI(model);
        }
    }

    public WidgetSettingsVoice() {
        super(C5419R.layout.widget_settings_voice);
        this.requestListenForSensitivitySubject = BehaviorSubject.m11130l0(Boolean.FALSE);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsVoice$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ RadioManager access$getOpenSLESConfigRadioManager$p(WidgetSettingsVoice widgetSettingsVoice) {
        RadioManager radioManager = widgetSettingsVoice.openSLESConfigRadioManager;
        if (radioManager == null) {
            C12238m.throwUninitializedPropertyAccessException("openSLESConfigRadioManager");
        }
        return radioManager;
    }

    private final void configureUI(Model model) {
        CheckedSetting checkedSetting;
        SeekBar seekBar = getBinding().f18113s;
        C12238m.checkNotNullExpressionValue(seekBar, "binding.settingsVoiceOutputVolume");
        seekBar.setProgress(C11210a.roundToInt(PerceptualVolumeUtils.amplitudeToPerceptual$default(PerceptualVolumeUtils.INSTANCE, model.getVoiceConfig().getOutputVolume(), 0.0f, 2, null)));
        getBinding().f18103i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputModeSelector inputModeSelector = new InputModeSelector();
                FragmentManager childFragmentManager = WidgetSettingsVoice.this.getChildFragmentManager();
                C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                inputModeSelector.show(childFragmentManager, String.valueOf(C12216a0.getOrCreateKotlinClass(InputModeSelector.class)));
            }
        });
        getBinding().f18104j.setText(model.getModePTT() ? C5419R.string.input_mode_ptt : model.getModeVAD() ? C5419R.string.input_mode_vad : 0);
        String strM822J = C1643a.m822J(new StringBuilder(), C0862f.f507a.m149a(360045138471L, null), "?utm_source=discord&utm_medium=blog&utm_campaign=2020-06_help-voice-video&utm_content=--t%3Apm");
        LinkifiedTextView linkifiedTextView = getBinding().f18094D;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsVoiceVideoTroubleshootingGuide");
        C1107b.m221m(linkifiedTextView, C5419R.string.form_help_voice_video_troubleshooting_guide, new Object[]{strM822J}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        RadioManager radioManager = this.openSLESConfigRadioManager;
        if (radioManager == null) {
            C12238m.throwUninitializedPropertyAccessException("openSLESConfigRadioManager");
        }
        int iOrdinal = model.getOpenSLESConfig().ordinal();
        if (iOrdinal == 0) {
            checkedSetting = getBinding().f18108n;
        } else if (iOrdinal == 1) {
            checkedSetting = getBinding().f18110p;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            checkedSetting = getBinding().f18109o;
        }
        C12238m.checkNotNullExpressionValue(checkedSetting, "when (model.openSLESConf…esForceDisabled\n        }");
        radioManager.m8550a(checkedSetting);
        List<CheckedSetting> list = this.openSLESConfigRadioButtons;
        if (list == null) {
            C12238m.throwUninitializedPropertyAccessException("openSLESConfigRadioButtons");
        }
        for (final CheckedSetting checkedSetting2 : list) {
            checkedSetting2.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$$inlined$forEach$lambda$1
                @Override // p658rx.functions.Action1
                public final void call(Boolean bool) {
                    WidgetSettingsVoice.access$getOpenSLESConfigRadioManager$p(this).m8550a(checkedSetting2);
                    this.onOpenSLESConfigChanged();
                }
            });
        }
        CheckedSetting checkedSetting3 = getBinding().f18099e;
        C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.settingsVoiceGainControlToggle");
        checkedSetting3.setChecked(model.getVoiceConfig().getAutomaticGainControl());
        getBinding().f18099e.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.3
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreStream.INSTANCE.getMediaSettings().toggleAutomaticGainControl();
            }
        });
        CheckedSetting checkedSetting4 = getBinding().f18105k;
        C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.settingsVoiceNoiseCancellationToggle");
        StoreMediaSettings.NoiseProcessing noiseProcessing = model.getVoiceConfig().getNoiseProcessing();
        StoreMediaSettings.NoiseProcessing noiseProcessing2 = StoreMediaSettings.NoiseProcessing.Cancellation;
        checkedSetting4.setChecked(noiseProcessing == noiseProcessing2);
        getBinding().f18105k.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.4
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreStream.INSTANCE.getMediaSettings().toggleNoiseCancellation();
            }
        });
        TextView textView = getBinding().f18101g;
        C12238m.checkNotNullExpressionValue(textView, "binding.settingsVoiceKrispInfo");
        C1107b.m221m(textView, C5419R.string.learn_more_link, new Object[]{C0862f.f507a.m149a(360040843952L, null)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView2 = getBinding().f18101g;
        C12238m.checkNotNullExpressionValue(textView2, "binding.settingsVoiceKrispInfo");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        CheckedSetting checkedSetting5 = getBinding().f18106l;
        C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.settingsVoiceNoiseSuppressionToggle");
        checkedSetting5.setChecked(model.getVoiceConfig().getNoiseProcessing() == StoreMediaSettings.NoiseProcessing.Suppression);
        if (model.getVoiceConfig().getNoiseProcessing() == noiseProcessing2) {
            getBinding().f18106l.m8525b(C5419R.string.user_settings_disable_noise_suppression);
            CheckedSetting.m8524i(getBinding().f18106l, C1107b.m213e(this, C5419R.string.user_settings_disable_noise_suppression, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), false, 2);
        } else {
            getBinding().f18106l.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StoreStream.INSTANCE.getMediaSettings().toggleNoiseSuppression();
                }
            });
            CheckedSetting.m8524i(getBinding().f18106l, null, false, 2);
        }
        CheckedSetting checkedSetting6 = getBinding().f18102h;
        C12238m.checkNotNullExpressionValue(checkedSetting6, "binding.settingsVoiceKrispVadToggle");
        checkedSetting6.setChecked(model.getVoiceConfig().getVadUseKrisp() == StoreMediaSettings.VadUseKrisp.Enabled);
        getBinding().f18102h.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.6
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreStream.INSTANCE.getMediaSettings().toggleVADUseKrisp();
            }
        });
        CheckedSetting checkedSetting7 = getBinding().f18097c;
        C12238m.checkNotNullExpressionValue(checkedSetting7, "binding.settingsVoiceEchoCancellationToggle");
        checkedSetting7.setChecked(model.getVoiceConfig().getEchoCancellation());
        getBinding().f18097c.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.7
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreStream.INSTANCE.getMediaSettings().toggleEchoCancellation();
            }
        });
        CheckedSetting checkedSetting8 = getBinding().f18096b;
        C12238m.checkNotNullExpressionValue(checkedSetting8, "binding.settingsVoiceAutoVadToggle");
        checkedSetting8.setChecked(model.getVoiceConfig().getAutomaticVad());
        CheckedSetting checkedSetting9 = getBinding().f18096b;
        C12238m.checkNotNullExpressionValue(checkedSetting9, "binding.settingsVoiceAutoVadToggle");
        checkedSetting9.setVisibility(model.getModeVAD() ? 0 : 8);
        getBinding().f18096b.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.8
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreStream.INSTANCE.getMediaSettings().toggleAutomaticVAD();
            }
        });
        CheckedSetting checkedSetting10 = getBinding().f18098d;
        C12238m.checkNotNullExpressionValue(checkedSetting10, "binding.settingsVoiceEnableHardwareScalingToggle");
        checkedSetting10.setChecked(model.getVoiceConfig().getEnableVideoHardwareScaling());
        getBinding().f18098d.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureUI.9
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreStream.INSTANCE.getMediaSettings().toggleEnableVideoHardwareScaling();
            }
        });
        configureVoiceSensitivity(model);
    }

    private final void configureVoiceSensitivity(Model model) {
        RelativeLayout relativeLayout = getBinding().f18092B;
        C12238m.checkNotNullExpressionValue(relativeLayout, "binding.settingsVoiceSensitivityWrap");
        relativeLayout.setVisibility(model.getModeVAD() ? 0 : 8);
        TextView textView = getBinding().f18118x;
        C12238m.checkNotNullExpressionValue(textView, "binding.settingsVoiceSensitivityLabel");
        textView.setVisibility(model.getVoiceConfig().getAutomaticVad() ? 0 : 8);
        boolean z2 = !C12238m.areEqual(model.getLocalVoiceStatus(), LOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED);
        LinearLayout linearLayout = getBinding().f18091A;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.settingsVoiceSensitivityTestingContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().f18120z;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.settingsVoiceSensitivityTestButton");
        materialButton.setVisibility(z2 ^ true ? 0 : 8);
        getBinding().f18120z.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.configureVoiceSensitivity.1

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureVoiceSensitivity$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
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
                    WidgetSettingsVoice.this.requestListenForSensitivitySubject.onNext(Boolean.TRUE);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1460d.m473S1(WidgetSettingsVoice.this, null, new AnonymousClass1(), 1, null);
            }
        });
        if (model.getVoiceConfig().getAutomaticVad()) {
            View view = getBinding().f18117w;
            C12238m.checkNotNullExpressionValue(view, "binding.settingsVoiceSensitivityAutomatic");
            view.setVisibility(0);
            SeekBar seekBar = getBinding().f18119y;
            C12238m.checkNotNullExpressionValue(seekBar, "binding.settingsVoiceSensitivityManual");
            seekBar.setVisibility(4);
            int i = model.getLocalVoiceStatus().isSpeaking ? C5419R.drawable.drawable_voice_indicator_speaking : C5419R.drawable.drawable_voice_indicator_not_speaking;
            View view2 = getBinding().f18117w;
            C12238m.checkNotNullExpressionValue(view2, "binding.settingsVoiceSensitivityAutomatic");
            view2.setBackground(ContextCompat.getDrawable(requireContext(), i));
            return;
        }
        View view3 = getBinding().f18117w;
        C12238m.checkNotNullExpressionValue(view3, "binding.settingsVoiceSensitivityAutomatic");
        view3.setVisibility(4);
        SeekBar seekBar2 = getBinding().f18119y;
        C12238m.checkNotNullExpressionValue(seekBar2, "binding.settingsVoiceSensitivityManual");
        seekBar2.setVisibility(0);
        SeekBar seekBar3 = getBinding().f18119y;
        C12238m.checkNotNullExpressionValue(seekBar3, "binding.settingsVoiceSensitivityManual");
        seekBar3.setSecondaryProgress(((int) model.getLocalVoiceStatus().amplitude) + 100);
        SeekBar seekBar4 = getBinding().f18119y;
        C12238m.checkNotNullExpressionValue(seekBar4, "binding.settingsVoiceSensitivityManual");
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
            C12238m.throwUninitializedPropertyAccessException("openSLESConfigRadioManager");
        }
        Checkable checkable = radioManager.buttons.get(radioManager.m8551b());
        if (C12238m.areEqual(checkable, getBinding().f18108n)) {
            openSLESConfig = MediaEngine.OpenSLESConfig.DEFAULT;
        } else if (C12238m.areEqual(checkable, getBinding().f18110p)) {
            openSLESConfig = MediaEngine.OpenSLESConfig.FORCE_ENABLED;
        } else {
            openSLESConfig = C12238m.areEqual(checkable, getBinding().f18109o) ? MediaEngine.OpenSLESConfig.FORCE_DISABLED : null;
        }
        if (openSLESConfig != null) {
            StoreStream.INSTANCE.getMediaEngine().setOpenSLESConfig(openSLESConfig);
        }
        C0876m.m171i(this, C5419R.string.user_settings_restart_app_mobile, 0, 4);
    }

    private final void onOverlayToggled(Context context) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        if (!companion.getUserSettings().getIsMobileOverlayEnabled()) {
            DiscordOverlayService.INSTANCE.launchForClose(context);
            return;
        }
        Observable<RtcConnection.StateChange> observableM11118y = companion.getRtcConnection().getConnectionState().m11118y(new InterfaceC12589b<RtcConnection.StateChange, Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.onOverlayToggled.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(RtcConnection.StateChange stateChange) {
                return Boolean.valueOf(C12238m.areEqual(stateChange.state, RtcConnection.State.C5612f.f18814a));
            }
        });
        Observable<R> observableM11083G = companion.getVoiceChannelSelected().observeSelectedChannel().m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        Observable observableM11076j = Observable.m11076j(observableM11118y, observableM11083G, new Func2<RtcConnection.StateChange, Channel, Pair<? extends RtcConnection.StateChange, ? extends Channel>>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.onOverlayToggled.2
            @Override // p658rx.functions.Func2
            public final Pair<RtcConnection.StateChange, Channel> call(RtcConnection.StateChange stateChange, Channel channel) {
                return C12116o.m10073to(stateChange, channel);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable\n          .co… -> rtcState to channel }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout(observableM11076j, 200L, false), this, null, 2, null), (Class<?>) WidgetSettingsVoice.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C97013(context));
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != OVERLAY_PERMISSION_REQUEST_CODE) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        boolean zHasOverlayPermission = INSTANCE.hasOverlayPermission(requireContext());
        StoreStream.INSTANCE.getUserSettings().setIsMobileOverlayEnabled(zHasOverlayPermission);
        CheckedSetting checkedSetting = getBinding().f18115u;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsVoiceOverlayToggle");
        checkedSetting.setChecked(zHasOverlayPermission);
        CheckedSetting checkedSetting2 = getBinding().f18115u;
        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsVoiceOverlayToggle");
        Context context = checkedSetting2.getContext();
        C12238m.checkNotNullExpressionValue(context, "binding.settingsVoiceOverlayToggle.context");
        onOverlayToggled(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(final View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f18111q;
        C12238m.checkNotNullExpressionValue(textView, "binding.settingsVoiceOpenslesHelp");
        C1107b.m221m(textView, C5419R.string.form_label_android_opensl_desc, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        CheckedSetting checkedSetting = getBinding().f18108n;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsVoiceOpenslesDefault");
        CheckedSetting checkedSetting2 = getBinding().f18110p;
        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsVoiceOpenslesForceEnabled");
        CheckedSetting checkedSetting3 = getBinding().f18109o;
        C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.settingsVoiceOpenslesForceDisabled");
        List<CheckedSetting> listListOf = C12147n.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3});
        this.openSLESConfigRadioButtons = listListOf;
        if (listListOf == null) {
            C12238m.throwUninitializedPropertyAccessException("openSLESConfigRadioButtons");
        }
        this.openSLESConfigRadioManager = new RadioManager(listListOf);
        CheckedSetting checkedSetting4 = getBinding().f18115u;
        C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.settingsVoiceOverlayToggle");
        checkedSetting4.setChecked(StoreStream.INSTANCE.getUserSettings().getIsMobileOverlayEnabled() && INSTANCE.hasOverlayPermission(requireContext()));
        getBinding().f18115u.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.onViewBound.1
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                if (!bool.booleanValue() || WidgetSettingsVoice.INSTANCE.hasOverlayPermission(WidgetSettingsVoice.this.requireContext())) {
                    StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
                    C12238m.checkNotNullExpressionValue(bool, "isChecked");
                    userSettings.setIsMobileOverlayEnabled(bool.booleanValue());
                    WidgetSettingsVoice widgetSettingsVoice = WidgetSettingsVoice.this;
                    CheckedSetting checkedSetting5 = widgetSettingsVoice.getBinding().f18115u;
                    C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.settingsVoiceOverlayToggle");
                    Context context = checkedSetting5.getContext();
                    C12238m.checkNotNullExpressionValue(context, "binding.settingsVoiceOverlayToggle.context");
                    widgetSettingsVoice.onOverlayToggled(context);
                    return;
                }
                CheckedSetting checkedSetting6 = WidgetSettingsVoice.this.getBinding().f18115u;
                C12238m.checkNotNullExpressionValue(checkedSetting6, "binding.settingsVoiceOverlayToggle");
                checkedSetting6.setChecked(false);
                AnalyticsTracker.INSTANCE.permissionsRequested("overlay");
                WidgetSettingsVoice widgetSettingsVoice2 = WidgetSettingsVoice.this;
                StringBuilder sbM833U = C1643a.m833U("package:");
                CheckedSetting checkedSetting7 = WidgetSettingsVoice.this.getBinding().f18115u;
                C12238m.checkNotNullExpressionValue(checkedSetting7, "binding.settingsVoiceOverlayToggle");
                Context context2 = checkedSetting7.getContext();
                C12238m.checkNotNullExpressionValue(context2, "binding.settingsVoiceOverlayToggle.context");
                sbM833U.append(context2.getPackageName());
                widgetSettingsVoice2.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(sbM833U.toString())), WidgetSettingsVoice.OVERLAY_PERMISSION_REQUEST_CODE);
            }
        });
        for (TextView textView2 : C12147n.listOf((Object[]) new TextView[]{getBinding().f18100f, getBinding().f18112r, getBinding().f18114t, getBinding().f18116v, getBinding().f18093C, getBinding().f18107m})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            C12238m.checkNotNullExpressionValue(textView2, "header");
            accessibilityUtils.setViewIsHeading(textView2);
        }
        Integer numValueOf = Integer.valueOf(getMostRecentIntent().getIntExtra(ARG_TARGET_RES_ID, 0));
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            View viewFindViewById = view.findViewById(numValueOf.intValue());
            C12238m.checkNotNullExpressionValue(viewFindViewById, "target");
            CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(viewFindViewById);
            if (coroutineScope != null) {
                C3404f.m4211H0(coroutineScope, null, null, new WidgetSettingsVoice$onViewBound$3$1(viewFindViewById, null), 3, null);
            }
            if (C12238m.areEqual(viewFindViewById, getBinding().f18115u)) {
                CheckedSetting checkedSetting5 = getBinding().f18115u;
                C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.settingsVoiceOverlayToggle");
                if (checkedSetting5.isChecked() || !getMostRecentIntent().getBooleanExtra(ARG_TARGET_AUTO_TOGGLE, false)) {
                    return;
                }
                viewFindViewById.post(new Runnable() { // from class: com.discord.widgets.settings.WidgetSettingsVoice$onViewBound$$inlined$let$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.this$0.getBinding().f18115u.m8529g(true, true);
                    }
                });
            }
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().f18113s.setOnSeekBarChangeListener(new C1337j() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.onViewBoundOrOnResume.1
            @Override // p007b.p008a.p062y.C1337j, android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                C12238m.checkNotNullParameter(seekBar, "seekBar");
                if (fromUser) {
                    StoreStream.INSTANCE.getMediaSettings().setOutputVolume(PerceptualVolumeUtils.perceptualToAmplitude$default(PerceptualVolumeUtils.INSTANCE, progress, 0.0f, 2, null));
                }
            }
        });
        getBinding().f18119y.setOnSeekBarChangeListener(new C1337j() { // from class: com.discord.widgets.settings.WidgetSettingsVoice.onViewBoundOrOnResume.2
            @Override // p007b.p008a.p062y.C1337j, android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                C12238m.checkNotNullParameter(seekBar, "seekBar");
                if (fromUser) {
                    StoreStream.INSTANCE.getMediaSettings().setSensitivity(progress - 100.0f);
                }
            }
        });
        Model.Companion companion = Model.INSTANCE;
        BehaviorSubject<Boolean> behaviorSubject = this.requestListenForSensitivitySubject;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "requestListenForSensitivitySubject");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion.get(behaviorSubject), this, null, 2, null), (Class<?>) WidgetSettingsVoice.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C97053());
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
                C12238m.checkNotNullParameter(requestListenForSensitivity, "requestListenForSensitivity");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11076j = Observable.m11076j(requestListenForSensitivity, companion.getMediaEngine().getIsNativeEngineInitialized(), new Func2<Boolean, Boolean, Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice$Model$Companion$get$shouldListenForSensitivity$1
                    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
                    @Override // p658rx.functions.Func2
                    public final Boolean call(Boolean bool, Boolean bool2) {
                        boolean z2;
                        C12238m.checkNotNullExpressionValue(bool, "userRequestedListenForSensitivity");
                        if (bool.booleanValue()) {
                            z2 = true;
                        } else {
                            C12238m.checkNotNullExpressionValue(bool2, "isNativeEngineInitialized");
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
                Observable observableM11099Y = observableM11076j.m11099Y(new InterfaceC12589b<Boolean, Observable<? extends MediaEngine.LocalVoiceStatus>>() { // from class: com.discord.widgets.settings.WidgetSettingsVoice$Model$Companion$get$1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends MediaEngine.LocalVoiceStatus> call(Boolean bool) {
                        C12238m.checkNotNullExpressionValue(bool, "isListeningForSensitivity");
                        return bool.booleanValue() ? StoreStream.INSTANCE.getMediaEngine().getLocalVoiceStatus() : new C12721k(WidgetSettingsVoice.LOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED);
                    }
                });
                final WidgetSettingsVoice$Model$Companion$get$2 widgetSettingsVoice$Model$Companion$get$2 = WidgetSettingsVoice$Model$Companion$get$2.INSTANCE;
                Object obj = widgetSettingsVoice$Model$Companion$get$2;
                if (widgetSettingsVoice$Model$Companion$get$2 != null) {
                    obj = new Func3() { // from class: com.discord.widgets.settings.WidgetSettingsVoice$sam$rx_functions_Func3$0
                        @Override // p658rx.functions.Func3
                        public final /* synthetic */ Object call(Object obj2, Object obj3, Object obj4) {
                            return widgetSettingsVoice$Model$Companion$get$2.invoke(obj2, obj3, obj4);
                        }
                    };
                }
                Observable observableM11075i = Observable.m11075i(voiceConfig, openSLESConfig, observableM11099Y, (Func3) obj);
                C12238m.checkNotNullExpressionValue(observableM11075i, "Observable\n            .…    ::Model\n            )");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11075i).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "Observable\n            .…  .distinctUntilChanged()");
                return observableM11112r;
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
