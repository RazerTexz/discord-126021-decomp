package com.discord.widgets.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Build$VERSION;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetSettingsAppearanceBinding;
import com.discord.models.domain.ModelUserSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.ToastManager;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g;
import d0.t.n;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsAppearance.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAppearanceBinding;", 0)};
    public static final WidgetSettingsAppearance$Companion Companion = new WidgetSettingsAppearance$Companion(null);
    private static final int EASTER_EGG_UNLOCK_TIMEOUT = 5;
    private static final int HOLY_LIGHT_UNLOCK_COUNT = 5;
    private static final int PURE_EVIL_HINT_COUNT = 3;
    private static final int PURE_EVIL_UNLOCK_COUNT = 8;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AtomicInteger holyLightEasterEggCounter;
    private final BehaviorSubject<Integer> newFontScaleSubject;
    private final AtomicInteger pureEvilEasterEggCounter;

    /* JADX INFO: renamed from: pureEvilEasterEggSubject$delegate, reason: from kotlin metadata */
    private final Lazy pureEvilEasterEggSubject;
    private ToastManager toastManager;

    public WidgetSettingsAppearance() {
        super(R$layout.widget_settings_appearance);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAppearance$binding$2.INSTANCE, null, 2, null);
        this.newFontScaleSubject = BehaviorSubject.k0();
        this.pureEvilEasterEggSubject = g.lazy(WidgetSettingsAppearance$pureEvilEasterEggSubject$2.INSTANCE);
        this.pureEvilEasterEggCounter = new AtomicInteger(0);
        this.holyLightEasterEggCounter = new AtomicInteger(0);
        this.toastManager = new ToastManager();
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAppearance widgetSettingsAppearance, WidgetSettingsAppearance$Model widgetSettingsAppearance$Model) {
        widgetSettingsAppearance.configureUI(widgetSettingsAppearance$Model);
    }

    public static final /* synthetic */ WidgetSettingsAppearanceBinding access$getBinding$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.getBinding();
    }

    public static final /* synthetic */ String access$getFontScaleString(WidgetSettingsAppearance widgetSettingsAppearance, int i, boolean z2) {
        return widgetSettingsAppearance.getFontScaleString(i, z2);
    }

    public static final /* synthetic */ AtomicInteger access$getHolyLightEasterEggCounter$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.holyLightEasterEggCounter;
    }

    public static final /* synthetic */ BehaviorSubject access$getNewFontScaleSubject$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.newFontScaleSubject;
    }

    public static final /* synthetic */ AtomicInteger access$getPureEvilEasterEggCounter$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.pureEvilEasterEggCounter;
    }

    public static final /* synthetic */ BehaviorSubject access$getPureEvilEasterEggSubject$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.getPureEvilEasterEggSubject();
    }

    public static final /* synthetic */ ToastManager access$getToastManager$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.toastManager;
    }

    public static final /* synthetic */ void access$setToastManager$p(WidgetSettingsAppearance widgetSettingsAppearance, ToastManager toastManager) {
        widgetSettingsAppearance.toastManager = toastManager;
    }

    public static final /* synthetic */ void access$showHolyLight(WidgetSettingsAppearance widgetSettingsAppearance) {
        widgetSettingsAppearance.showHolyLight();
    }

    public static final /* synthetic */ void access$tryEnableTorchMode(WidgetSettingsAppearance widgetSettingsAppearance, boolean z2) {
        widgetSettingsAppearance.tryEnableTorchMode(z2);
    }

    public static final /* synthetic */ void access$updateTheme(WidgetSettingsAppearance widgetSettingsAppearance, String str) {
        widgetSettingsAppearance.updateTheme(str);
    }

    private final void configureFontScalingUI(int fontScale) {
        FragmentActivity activity;
        ContentResolver contentResolver;
        int systemFontScaleInt = (fontScale != -1 || (activity = getActivity()) == null || (contentResolver = activity.getContentResolver()) == null) ? fontScale : FontUtils.INSTANCE.getSystemFontScaleInt(contentResolver);
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.settingsAppearanceFontScalePlatform");
        textView.setText(getFontScaleString(systemFontScaleInt, fontScale == -1));
        SeekBar seekBar = getBinding().f;
        m.checkNotNullExpressionValue(seekBar, "binding.settingsAppearanceFontScalingSeekbar");
        seekBar.setProgress(systemFontScaleInt - 80);
    }

    private final void configureThemeOption(CheckedSetting checkedSetting, String str) {
        checkedSetting.setOnCheckedListener(new WidgetSettingsAppearance$configureThemeOption$1(this, str));
    }

    private final void configureUI(WidgetSettingsAppearance$Model model) {
        boolean z2 = !m.areEqual(model.getCurrentTheme(), ModelUserSettings.THEME_LIGHT);
        getBinding().l.g(!z2, false);
        CheckedSetting checkedSetting = getBinding().l;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsAppearanceThemeLightRadio");
        configureThemeOption(checkedSetting, ModelUserSettings.THEME_LIGHT);
        getBinding().l.e(new WidgetSettingsAppearance$configureUI$1(this));
        getBinding().j.g(z2, false);
        CheckedSetting checkedSetting2 = getBinding().j;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsAppearanceThemeDarkRadio");
        configureThemeOption(checkedSetting2, ModelUserSettings.THEME_DARK);
        getBinding().j.e(new WidgetSettingsAppearance$configureUI$2(this, model));
        if (m.areEqual(model.getCurrentTheme(), ModelUserSettings.THEME_PURE_EVIL)) {
            CheckedSetting.d(getBinding().m, null, 1);
        }
        getBinding().m.g(m.areEqual(model.getCurrentTheme(), ModelUserSettings.THEME_PURE_EVIL), false);
        CheckedSetting checkedSetting3 = getBinding().m;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.settingsAppearanceThemePureEvilSwitch");
        checkedSetting3.setVisibility(model.getCanSeePureEvil() ? 0 : 8);
        getBinding().m.setOnCheckedListener(new WidgetSettingsAppearance$configureUI$3(this, model));
        configureFontScalingUI(model.getFontScale());
        getBinding().f.setOnSeekBarChangeListener(new WidgetSettingsAppearance$configureUI$4(this));
        getBinding().e.setOnClickListener(WidgetSettingsAppearance$configureUI$5.INSTANCE);
        setupMessage(model);
        for (TextView textView : n.listOf((Object[]) new TextView[]{getBinding().k, getBinding().h, getBinding().c})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }

    private final WidgetSettingsAppearanceBinding getBinding() {
        return (WidgetSettingsAppearanceBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getFontScaleString(int fontScale, boolean useSystemFontScale) {
        if (useSystemFontScale) {
            return fontScale + "% (" + getString(2131886152) + ')';
        }
        return fontScale + "% (" + getString(2131886151) + ')';
    }

    public static /* synthetic */ String getFontScaleString$default(WidgetSettingsAppearance widgetSettingsAppearance, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return widgetSettingsAppearance.getFontScaleString(i, z2);
    }

    private final BehaviorSubject<Boolean> getPureEvilEasterEggSubject() {
        return (BehaviorSubject) this.pureEvilEasterEggSubject.getValue();
    }

    private final void setupMessage(WidgetSettingsAppearance$Model model) {
        SimpleDraweeView simpleDraweeView = getBinding().f2602b.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatItem.chatListAdapterItemTextAvatar");
        IconUtils.setIcon$default(simpleDraweeView, model.getMeUser(), 2131165300, null, null, null, 56, null);
        TextView textView = getBinding().f2602b.f;
        m.checkNotNullExpressionValue(textView, "binding.chatItem.chatListAdapterItemTextTag");
        textView.setVisibility(8);
        TextView textView2 = getBinding().f2602b.d;
        m.checkNotNullExpressionValue(textView2, "binding.chatItem.chatListAdapterItemTextName");
        textView2.setText(model.getMeUser().getUsername());
        TextView textView3 = getBinding().f2602b.g;
        m.checkNotNullExpressionValue(textView3, "binding.chatItem.chatListAdapterItemTextTimestamp");
        textView3.setText(TimeUtils.toReadableTimeString$default(requireContext(), ClockFactory.get().currentTimeMillis(), null, 4, null));
        LinkifiedTextView linkifiedTextView = getBinding().f2602b.f2338b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.chatItem.chatListAdapterItemText");
        linkifiedTextView.setText(getString(2131896841));
    }

    private final void showHolyLight() {
        b.a.d.m.d(getContext(), 2131896331, 0, this.toastManager);
        tryEnableTorchMode(true);
        View view = getBinding().g;
        m.checkNotNullExpressionValue(view, "binding.settingsAppearanceHolyLight");
        view.setVisibility(0);
        Observable<Long> observableD0 = Observable.d0(3L, TimeUnit.SECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable\n        .timer(3, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetSettingsAppearance.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsAppearance$showHolyLight$1(this), 62, (Object) null);
    }

    private final void tryEnableTorchMode(boolean enabled) {
        String str;
        if (Build$VERSION.SDK_INT >= 23) {
            Context context = getContext();
            CameraManager cameraManager = (CameraManager) (context != null ? context.getSystemService(ChatInputComponentTypes.CAMERA) : null);
            if (cameraManager != null) {
                try {
                    String[] cameraIdList = cameraManager.getCameraIdList();
                    if (cameraIdList == null || (str = cameraIdList[0]) == null) {
                        return;
                    }
                    cameraManager.setTorchMode(str, enabled);
                } catch (Exception e) {
                    AppLog.g.w("Unable to turn on flashlight", e);
                }
            }
        }
    }

    private final void updateTheme(String theme) {
        StoreStream.Companion.getUserSettingsSystem().setTheme(theme, true, new WidgetSettingsAppearance$updateTheme$1(this, theme));
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.toastManager.close();
        super.onDestroyView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(2131886497);
        setActionBarSubtitle(2131896797);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        SeekBar seekBar = getBinding().f;
        m.checkNotNullExpressionValue(seekBar, "binding.settingsAppearanceFontScalingSeekbar");
        seekBar.setMax(70);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        WidgetSettingsAppearance$Model$Companion widgetSettingsAppearance$Model$Companion = WidgetSettingsAppearance$Model.Companion;
        BehaviorSubject<Boolean> pureEvilEasterEggSubject = getPureEvilEasterEggSubject();
        m.checkNotNullExpressionValue(pureEvilEasterEggSubject, "pureEvilEasterEggSubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(widgetSettingsAppearance$Model$Companion.get(pureEvilEasterEggSubject), this, null, 2, null), WidgetSettingsAppearance.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsAppearance$onViewBoundOrOnResume$1(this), 62, (Object) null);
        Observable<Integer> observableP = this.newFontScaleSubject.p(400L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableP, "newFontScaleSubject\n    …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableP, this, null, 2, null), WidgetSettingsAppearance.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetSettingsAppearance$onViewBoundOrOnResume$2.INSTANCE, 62, (Object) null);
        CheckedSetting checkedSetting = getBinding().i;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsAppearanceSyncSwitch");
        checkedSetting.setChecked(StoreStream.Companion.getUserSettingsSystem().getIsThemeSyncEnabled());
        getBinding().i.setOnCheckedListener(WidgetSettingsAppearance$onViewBoundOrOnResume$3.INSTANCE);
    }
}
