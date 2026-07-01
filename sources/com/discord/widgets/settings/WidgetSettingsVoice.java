package com.discord.widgets.settings;

import android.content.Context;
import android.content.Intent;
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
import b.a.d.f;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsVoiceBinding;
import com.discord.rtcconnection.RtcConnection$StateChange;
import com.discord.rtcconnection.mediaengine.MediaEngine$LocalVoiceStatus;
import com.discord.rtcconnection.mediaengine.MediaEngine$OpenSLESConfig;
import com.discord.stores.StoreMediaSettings$NoiseProcessing;
import com.discord.stores.StoreMediaSettings$VadUseKrisp;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.utilities.voice.DiscordOverlayService;
import com.discord.utilities.voice.PerceptualVolumeUtils;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.google.android.material.button.MaterialButton;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsVoice.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsVoiceBinding;", 0)};
    public static final WidgetSettingsVoice$Companion Companion = new WidgetSettingsVoice$Companion(null);
    private static final MediaEngine$LocalVoiceStatus LOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED = new MediaEngine$LocalVoiceStatus(-1.0f, false);

    public WidgetSettingsVoice() {
        super(R$layout.widget_settings_voice);
        this.requestListenForSensitivitySubject = BehaviorSubject.l0(Boolean.FALSE);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsVoice$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsVoice widgetSettingsVoice, WidgetSettingsVoice$Model widgetSettingsVoice$Model) {
        widgetSettingsVoice.configureUI(widgetSettingsVoice$Model);
    }

    public static final /* synthetic */ WidgetSettingsVoiceBinding access$getBinding$p(WidgetSettingsVoice widgetSettingsVoice) {
        return widgetSettingsVoice.getBinding();
    }

    public static final /* synthetic */ MediaEngine$LocalVoiceStatus access$getLOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED$cp() {
        return LOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED;
    }

    public static final /* synthetic */ RadioManager access$getOpenSLESConfigRadioManager$p(WidgetSettingsVoice widgetSettingsVoice) {
        RadioManager radioManager = widgetSettingsVoice.openSLESConfigRadioManager;
        if (radioManager == null) {
            m.throwUninitializedPropertyAccessException("openSLESConfigRadioManager");
        }
        return radioManager;
    }

    public static final /* synthetic */ BehaviorSubject access$getRequestListenForSensitivitySubject$p(WidgetSettingsVoice widgetSettingsVoice) {
        return widgetSettingsVoice.requestListenForSensitivitySubject;
    }

    public static final /* synthetic */ void access$onOpenSLESConfigChanged(WidgetSettingsVoice widgetSettingsVoice) {
        widgetSettingsVoice.onOpenSLESConfigChanged();
    }

    public static final /* synthetic */ void access$onOverlayToggled(WidgetSettingsVoice widgetSettingsVoice, Context context) {
        widgetSettingsVoice.onOverlayToggled(context);
    }

    public static final /* synthetic */ void access$setOpenSLESConfigRadioManager$p(WidgetSettingsVoice widgetSettingsVoice, RadioManager radioManager) {
        widgetSettingsVoice.openSLESConfigRadioManager = radioManager;
    }

    private final void configureUI(WidgetSettingsVoice$Model model) {
        CheckedSetting checkedSetting;
        SeekBar seekBar = getBinding().f2642s;
        m.checkNotNullExpressionValue(seekBar, "binding.settingsVoiceOutputVolume");
        seekBar.setProgress(d0.a0.a.roundToInt(PerceptualVolumeUtils.amplitudeToPerceptual$default(PerceptualVolumeUtils.INSTANCE, model.getVoiceConfig().getOutputVolume(), 0.0f, 2, null)));
        getBinding().i.setOnClickListener(new WidgetSettingsVoice$configureUI$1(this));
        getBinding().j.setText(model.getModePTT() ? 2131892044 : model.getModeVAD() ? 2131892047 : 0);
        String strJ = a.J(new StringBuilder(), f.a.a(360045138471L, null), "?utm_source=discord&utm_medium=blog&utm_campaign=2020-06_help-voice-video&utm_content=--t%3Apm");
        LinkifiedTextView linkifiedTextView = getBinding().D;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsVoiceVideoTroubleshootingGuide");
        b.n(linkifiedTextView, 2131889124, new Object[]{strJ}, null, 4);
        RadioManager radioManager = this.openSLESConfigRadioManager;
        if (radioManager == null) {
            m.throwUninitializedPropertyAccessException("openSLESConfigRadioManager");
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
        m.checkNotNullExpressionValue(checkedSetting, "when (model.openSLESConf…esForceDisabled\n        }");
        radioManager.a(checkedSetting);
        List<CheckedSetting> list = this.openSLESConfigRadioButtons;
        if (list == null) {
            m.throwUninitializedPropertyAccessException("openSLESConfigRadioButtons");
        }
        for (CheckedSetting checkedSetting2 : list) {
            checkedSetting2.setOnCheckedListener(new WidgetSettingsVoice$configureUI$$inlined$forEach$lambda$1(checkedSetting2, this));
        }
        CheckedSetting checkedSetting3 = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.settingsVoiceGainControlToggle");
        checkedSetting3.setChecked(model.getVoiceConfig().getAutomaticGainControl());
        getBinding().e.setOnCheckedListener(WidgetSettingsVoice$configureUI$3.INSTANCE);
        CheckedSetting checkedSetting4 = getBinding().k;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.settingsVoiceNoiseCancellationToggle");
        StoreMediaSettings$NoiseProcessing noiseProcessing = model.getVoiceConfig().getNoiseProcessing();
        StoreMediaSettings$NoiseProcessing storeMediaSettings$NoiseProcessing = StoreMediaSettings$NoiseProcessing.Cancellation;
        checkedSetting4.setChecked(noiseProcessing == storeMediaSettings$NoiseProcessing);
        getBinding().k.setOnCheckedListener(WidgetSettingsVoice$configureUI$4.INSTANCE);
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.settingsVoiceKrispInfo");
        b.n(textView, 2131892523, new Object[]{f.a.a(360040843952L, null)}, null, 4);
        TextView textView2 = getBinding().g;
        m.checkNotNullExpressionValue(textView2, "binding.settingsVoiceKrispInfo");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        CheckedSetting checkedSetting5 = getBinding().l;
        m.checkNotNullExpressionValue(checkedSetting5, "binding.settingsVoiceNoiseSuppressionToggle");
        checkedSetting5.setChecked(model.getVoiceConfig().getNoiseProcessing() == StoreMediaSettings$NoiseProcessing.Suppression);
        if (model.getVoiceConfig().getNoiseProcessing() == storeMediaSettings$NoiseProcessing) {
            getBinding().l.b(2131896874);
            CheckedSetting.i(getBinding().l, b.k(this, 2131896874, new Object[0], null, 4), false, 2);
        } else {
            getBinding().l.e(WidgetSettingsVoice$configureUI$5.INSTANCE);
            CheckedSetting.i(getBinding().l, null, false, 2);
        }
        CheckedSetting checkedSetting6 = getBinding().h;
        m.checkNotNullExpressionValue(checkedSetting6, "binding.settingsVoiceKrispVadToggle");
        checkedSetting6.setChecked(model.getVoiceConfig().getVadUseKrisp() == StoreMediaSettings$VadUseKrisp.Enabled);
        getBinding().h.setOnCheckedListener(WidgetSettingsVoice$configureUI$6.INSTANCE);
        CheckedSetting checkedSetting7 = getBinding().c;
        m.checkNotNullExpressionValue(checkedSetting7, "binding.settingsVoiceEchoCancellationToggle");
        checkedSetting7.setChecked(model.getVoiceConfig().getEchoCancellation());
        getBinding().c.setOnCheckedListener(WidgetSettingsVoice$configureUI$7.INSTANCE);
        CheckedSetting checkedSetting8 = getBinding().f2641b;
        m.checkNotNullExpressionValue(checkedSetting8, "binding.settingsVoiceAutoVadToggle");
        checkedSetting8.setChecked(model.getVoiceConfig().getAutomaticVad());
        CheckedSetting checkedSetting9 = getBinding().f2641b;
        m.checkNotNullExpressionValue(checkedSetting9, "binding.settingsVoiceAutoVadToggle");
        checkedSetting9.setVisibility(model.getModeVAD() ? 0 : 8);
        getBinding().f2641b.setOnCheckedListener(WidgetSettingsVoice$configureUI$8.INSTANCE);
        CheckedSetting checkedSetting10 = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting10, "binding.settingsVoiceEnableHardwareScalingToggle");
        checkedSetting10.setChecked(model.getVoiceConfig().getEnableVideoHardwareScaling());
        getBinding().d.setOnCheckedListener(WidgetSettingsVoice$configureUI$9.INSTANCE);
        configureVoiceSensitivity(model);
    }

    private final void configureVoiceSensitivity(WidgetSettingsVoice$Model model) {
        RelativeLayout relativeLayout = getBinding().B;
        m.checkNotNullExpressionValue(relativeLayout, "binding.settingsVoiceSensitivityWrap");
        relativeLayout.setVisibility(model.getModeVAD() ? 0 : 8);
        TextView textView = getBinding().f2643x;
        m.checkNotNullExpressionValue(textView, "binding.settingsVoiceSensitivityLabel");
        textView.setVisibility(model.getVoiceConfig().getAutomaticVad() ? 0 : 8);
        boolean z2 = !m.areEqual(model.getLocalVoiceStatus(), LOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED);
        LinearLayout linearLayout = getBinding().A;
        m.checkNotNullExpressionValue(linearLayout, "binding.settingsVoiceSensitivityTestingContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().f2645z;
        m.checkNotNullExpressionValue(materialButton, "binding.settingsVoiceSensitivityTestButton");
        materialButton.setVisibility(z2 ^ true ? 0 : 8);
        getBinding().f2645z.setOnClickListener(new WidgetSettingsVoice$configureVoiceSensitivity$1(this));
        if (model.getVoiceConfig().getAutomaticVad()) {
            View view = getBinding().w;
            m.checkNotNullExpressionValue(view, "binding.settingsVoiceSensitivityAutomatic");
            view.setVisibility(0);
            SeekBar seekBar = getBinding().f2644y;
            m.checkNotNullExpressionValue(seekBar, "binding.settingsVoiceSensitivityManual");
            seekBar.setVisibility(4);
            int i = model.getLocalVoiceStatus().isSpeaking ? 2131231371 : 2131231370;
            View view2 = getBinding().w;
            m.checkNotNullExpressionValue(view2, "binding.settingsVoiceSensitivityAutomatic");
            view2.setBackground(ContextCompat.getDrawable(requireContext(), i));
            return;
        }
        View view3 = getBinding().w;
        m.checkNotNullExpressionValue(view3, "binding.settingsVoiceSensitivityAutomatic");
        view3.setVisibility(4);
        SeekBar seekBar2 = getBinding().f2644y;
        m.checkNotNullExpressionValue(seekBar2, "binding.settingsVoiceSensitivityManual");
        seekBar2.setVisibility(0);
        SeekBar seekBar3 = getBinding().f2644y;
        m.checkNotNullExpressionValue(seekBar3, "binding.settingsVoiceSensitivityManual");
        seekBar3.setSecondaryProgress(((int) model.getLocalVoiceStatus().amplitude) + 100);
        SeekBar seekBar4 = getBinding().f2644y;
        m.checkNotNullExpressionValue(seekBar4, "binding.settingsVoiceSensitivityManual");
        seekBar4.setProgress(((int) model.getVoiceConfig().getSensitivity()) + 100);
    }

    private final WidgetSettingsVoiceBinding getBinding() {
        return (WidgetSettingsVoiceBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context, @IdRes Integer num, boolean z2) {
        Companion.launch(context, num, z2);
    }

    private final void onOpenSLESConfigChanged() {
        MediaEngine$OpenSLESConfig mediaEngine$OpenSLESConfig;
        RadioManager radioManager = this.openSLESConfigRadioManager;
        if (radioManager == null) {
            m.throwUninitializedPropertyAccessException("openSLESConfigRadioManager");
        }
        Checkable checkable = radioManager.buttons.get(radioManager.b());
        if (m.areEqual(checkable, getBinding().n)) {
            mediaEngine$OpenSLESConfig = MediaEngine$OpenSLESConfig.DEFAULT;
        } else if (m.areEqual(checkable, getBinding().p)) {
            mediaEngine$OpenSLESConfig = MediaEngine$OpenSLESConfig.FORCE_ENABLED;
        } else {
            mediaEngine$OpenSLESConfig = m.areEqual(checkable, getBinding().o) ? MediaEngine$OpenSLESConfig.FORCE_DISABLED : null;
        }
        if (mediaEngine$OpenSLESConfig != null) {
            StoreStream.Companion.getMediaEngine().setOpenSLESConfig(mediaEngine$OpenSLESConfig);
        }
        b.a.d.m.i(this, 2131896964, 0, 4);
    }

    private final void onOverlayToggled(Context context) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        if (!storeStream$Companion.getUserSettings().getIsMobileOverlayEnabled()) {
            DiscordOverlayService.Companion.launchForClose(context);
            return;
        }
        Observable<RtcConnection$StateChange> observableY = storeStream$Companion.getRtcConnection().getConnectionState().y(WidgetSettingsVoice$onOverlayToggled$1.INSTANCE);
        Observable<R> observableG = storeStream$Companion.getVoiceChannelSelected().observeSelectedChannel().y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableJ = Observable.j(observableY, observableG, WidgetSettingsVoice$onOverlayToggled$2.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable\n          .co… -> rtcState to channel }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout(observableJ, 200L, false), this, null, 2, null), WidgetSettingsVoice.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsVoice$onOverlayToggled$3(context), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != OVERLAY_PERMISSION_REQUEST_CODE) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        boolean zAccess$hasOverlayPermission = WidgetSettingsVoice$Companion.access$hasOverlayPermission(Companion, requireContext());
        StoreStream.Companion.getUserSettings().setIsMobileOverlayEnabled(zAccess$hasOverlayPermission);
        CheckedSetting checkedSetting = getBinding().u;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsVoiceOverlayToggle");
        checkedSetting.setChecked(zAccess$hasOverlayPermission);
        CheckedSetting checkedSetting2 = getBinding().u;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsVoiceOverlayToggle");
        Context context = checkedSetting2.getContext();
        m.checkNotNullExpressionValue(context, "binding.settingsVoiceOverlayToggle.context");
        onOverlayToggled(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().q;
        m.checkNotNullExpressionValue(textView, "binding.settingsVoiceOpenslesHelp");
        b.n(textView, 2131889135, new Object[0], null, 4);
        CheckedSetting checkedSetting = getBinding().n;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsVoiceOpenslesDefault");
        CheckedSetting checkedSetting2 = getBinding().p;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsVoiceOpenslesForceEnabled");
        CheckedSetting checkedSetting3 = getBinding().o;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.settingsVoiceOpenslesForceDisabled");
        List<CheckedSetting> listListOf = n.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3});
        this.openSLESConfigRadioButtons = listListOf;
        if (listListOf == null) {
            m.throwUninitializedPropertyAccessException("openSLESConfigRadioButtons");
        }
        this.openSLESConfigRadioManager = new RadioManager(listListOf);
        CheckedSetting checkedSetting4 = getBinding().u;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.settingsVoiceOverlayToggle");
        checkedSetting4.setChecked(StoreStream.Companion.getUserSettings().getIsMobileOverlayEnabled() && WidgetSettingsVoice$Companion.access$hasOverlayPermission(Companion, requireContext()));
        getBinding().u.setOnCheckedListener(new WidgetSettingsVoice$onViewBound$1(this));
        for (TextView textView2 : n.listOf((Object[]) new TextView[]{getBinding().f, getBinding().r, getBinding().t, getBinding().v, getBinding().C, getBinding().m})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView2, "header");
            accessibilityUtils.setViewIsHeading(textView2);
        }
        Integer numValueOf = Integer.valueOf(getMostRecentIntent().getIntExtra(ARG_TARGET_RES_ID, 0));
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            View viewFindViewById = view.findViewById(numValueOf.intValue());
            m.checkNotNullExpressionValue(viewFindViewById, "target");
            CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(viewFindViewById);
            if (coroutineScope != null) {
                b.i.a.f.e.o.f.H0(coroutineScope, null, null, new WidgetSettingsVoice$onViewBound$3$1(viewFindViewById, null), 3, null);
            }
            if (m.areEqual(viewFindViewById, getBinding().u)) {
                CheckedSetting checkedSetting5 = getBinding().u;
                m.checkNotNullExpressionValue(checkedSetting5, "binding.settingsVoiceOverlayToggle");
                if (checkedSetting5.isChecked() || !getMostRecentIntent().getBooleanExtra(ARG_TARGET_AUTO_TOGGLE, false)) {
                    return;
                }
                viewFindViewById.post(new WidgetSettingsVoice$onViewBound$$inlined$let$lambda$1(this, view));
            }
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().f2642s.setOnSeekBarChangeListener(new WidgetSettingsVoice$onViewBoundOrOnResume$1());
        getBinding().f2644y.setOnSeekBarChangeListener(new WidgetSettingsVoice$onViewBoundOrOnResume$2());
        WidgetSettingsVoice$Model$Companion widgetSettingsVoice$Model$Companion = WidgetSettingsVoice$Model.Companion;
        BehaviorSubject<Boolean> behaviorSubject = this.requestListenForSensitivitySubject;
        m.checkNotNullExpressionValue(behaviorSubject, "requestListenForSensitivitySubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(widgetSettingsVoice$Model$Companion.get(behaviorSubject), this, null, 2, null), WidgetSettingsVoice.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsVoice$onViewBoundOrOnResume$3(this), 62, (Object) null);
    }
}
