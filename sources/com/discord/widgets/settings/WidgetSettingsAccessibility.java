package com.discord.widgets.settings;

import android.content.Context;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.d.f;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccessibilityBinding;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import d0.t.n;
import d0.z.d.m;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccessibility extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsAccessibility.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccessibilityBinding;", 0)};
    public static final WidgetSettingsAccessibility$Companion Companion = new WidgetSettingsAccessibility$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager stickersAnimationRadioManager;

    public WidgetSettingsAccessibility() {
        super(R$layout.widget_settings_accessibility);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccessibility$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccessibility widgetSettingsAccessibility, WidgetSettingsAccessibility$Model widgetSettingsAccessibility$Model) {
        widgetSettingsAccessibility.configureUI(widgetSettingsAccessibility$Model);
    }

    public static final /* synthetic */ WidgetSettingsAccessibilityBinding access$getBinding$p(WidgetSettingsAccessibility widgetSettingsAccessibility) {
        return widgetSettingsAccessibility.getBinding();
    }

    private final void configureStickerAnimationRadio(int currentStickerAnimationSettings, CheckedSetting radio, int stickerAnimationSetting) {
        radio.e(new WidgetSettingsAccessibility$configureStickerAnimationRadio$1(this, stickerAnimationSetting));
        RadioManager radioManager = this.stickersAnimationRadioManager;
        if (radioManager == null || currentStickerAnimationSettings != stickerAnimationSetting || radioManager == null) {
            return;
        }
        radioManager.a(radio);
    }

    private final void configureUI(WidgetSettingsAccessibility$Model model) {
        CheckedSetting checkedSetting = getBinding().g;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsAccessibilityReducedMotionSwitch");
        checkedSetting.setChecked(model.getReducedMotionEnabled());
        if (!model.getReducedMotionEnabled()) {
            CheckedSetting checkedSetting2 = getBinding().f2589b;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsAccessib…tyAllowAnimateEmojiSwitch");
            checkedSetting2.setChecked(model.getAllowAnimatedEmoji());
            int currentStickerAnimationSettings = model.getCurrentStickerAnimationSettings();
            CheckedSetting checkedSetting3 = getBinding().i;
            m.checkNotNullExpressionValue(checkedSetting3, "binding.stickersAlwaysAnimate");
            configureStickerAnimationRadio(currentStickerAnimationSettings, checkedSetting3, 0);
            int currentStickerAnimationSettings2 = model.getCurrentStickerAnimationSettings();
            CheckedSetting checkedSetting4 = getBinding().j;
            m.checkNotNullExpressionValue(checkedSetting4, "binding.stickersAnimateOnInteraction");
            configureStickerAnimationRadio(currentStickerAnimationSettings2, checkedSetting4, 1);
            int currentStickerAnimationSettings3 = model.getCurrentStickerAnimationSettings();
            CheckedSetting checkedSetting5 = getBinding().k;
            m.checkNotNullExpressionValue(checkedSetting5, "binding.stickersNeverAnimate");
            configureStickerAnimationRadio(currentStickerAnimationSettings3, checkedSetting5, 2);
            CheckedSetting checkedSetting6 = getBinding().c;
            m.checkNotNullExpressionValue(checkedSetting6, "binding.settingsAccessib…ityAllowAutoplayGifSwitch");
            checkedSetting6.setChecked(model.getAutoPlayGifs());
            getBinding().f2589b.e(new WidgetSettingsAccessibility$configureUI$1(this));
            getBinding().c.e(new WidgetSettingsAccessibility$configureUI$2(this));
            return;
        }
        getBinding().f2589b.b(2131886173);
        CheckedSetting checkedSetting7 = getBinding().f2589b;
        m.checkNotNullExpressionValue(checkedSetting7, "binding.settingsAccessib…tyAllowAnimateEmojiSwitch");
        checkedSetting7.setChecked(false);
        Iterator it = n.listOf((Object[]) new CheckedSetting[]{getBinding().i, getBinding().j, getBinding().k}).iterator();
        while (it.hasNext()) {
            ((CheckedSetting) it.next()).b(2131895991);
        }
        if (model.getCurrentStickerAnimationSettings() != 2) {
            RadioManager radioManager = this.stickersAnimationRadioManager;
            if (radioManager != null) {
                CheckedSetting checkedSetting8 = getBinding().j;
                m.checkNotNullExpressionValue(checkedSetting8, "binding.stickersAnimateOnInteraction");
                radioManager.a(checkedSetting8);
            }
        } else {
            RadioManager radioManager2 = this.stickersAnimationRadioManager;
            if (radioManager2 != null) {
                CheckedSetting checkedSetting9 = getBinding().k;
                m.checkNotNullExpressionValue(checkedSetting9, "binding.stickersNeverAnimate");
                radioManager2.a(checkedSetting9);
            }
        }
        CheckedSetting checkedSetting10 = getBinding().c;
        m.checkNotNullExpressionValue(checkedSetting10, "binding.settingsAccessib…ityAllowAutoplayGifSwitch");
        checkedSetting10.setChecked(false);
        getBinding().c.b(2131886173);
    }

    private final WidgetSettingsAccessibilityBinding getBinding() {
        return (WidgetSettingsAccessibilityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetSettingsAccessibility$Model.Companion.get(), this, null, 2, null), WidgetSettingsAccessibility.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsAccessibility$onViewBoundOrOnResume$1(this), 62, (Object) null);
        setActionBarTitle(2131886139);
        setActionBarSubtitle(2131896797);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().g.setOnCheckedListener(WidgetSettingsAccessibility$onViewBoundOrOnResume$2.INSTANCE);
        LinkifiedTextView linkifiedTextView = getBinding().e;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsAccessib…yReducedMotionDescription");
        b.n(linkifiedTextView, 2131886171, new Object[]{f.a.a(360040613412L, null)}, null, 4);
        getBinding().f2589b.setOnCheckedListener(new WidgetSettingsAccessibility$onViewBoundOrOnResume$3(this));
        getBinding().c.setOnCheckedListener(WidgetSettingsAccessibility$onViewBoundOrOnResume$4.INSTANCE);
        this.stickersAnimationRadioManager = new RadioManager(n.listOf((Object[]) new CheckedSetting[]{getBinding().i, getBinding().j, getBinding().k}));
        for (TextView textView : n.listOf((Object[]) new TextView[]{getBinding().f, getBinding().d, getBinding().h})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
