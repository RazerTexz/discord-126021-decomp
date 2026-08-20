package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccessibilityBinding;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func4;

/* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccessibility extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsAccessibility.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccessibilityBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager stickersAnimationRadioManager;

    /* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetSettingsAccessibility.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean allowAnimatedEmoji;
        private final boolean autoPlayGifs;
        private final int currentStickerAnimationSettings;
        private final boolean reducedMotionEnabled;

        /* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableM11073h = Observable.m11073h(companion.getAccessibility().observeReducedMotionEnabled(), companion.getUserSettings().observeIsAnimatedEmojisEnabled(false), companion.getUserSettings().observeIsAutoPlayGifsEnabled(false), companion.getUserSettings().observeStickerAnimationSettings(false), new Func4<Boolean, Boolean, Boolean, Integer, Model>() { // from class: com.discord.widgets.settings.WidgetSettingsAccessibility$Model$Companion$get$1
                    @Override // p658rx.functions.Func4
                    public final WidgetSettingsAccessibility.Model call(Boolean bool, Boolean bool2, Boolean bool3, Integer num) {
                        C12238m.checkNotNullExpressionValue(bool, "reducedMotionEnabled");
                        boolean zBooleanValue = bool.booleanValue();
                        C12238m.checkNotNullExpressionValue(bool2, "allowAnimatedEmoji");
                        boolean zBooleanValue2 = bool2.booleanValue();
                        C12238m.checkNotNullExpressionValue(bool3, "autoPlayGifs");
                        boolean zBooleanValue3 = bool3.booleanValue();
                        C12238m.checkNotNullExpressionValue(num, "currentStickerAnimationSettings");
                        return new WidgetSettingsAccessibility.Model(zBooleanValue, zBooleanValue2, zBooleanValue3, num.intValue());
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11073h, "Observable.combineLatest…ngs\n          )\n        }");
                return observableM11073h;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(boolean z2, boolean z3, boolean z4, int i) {
            this.reducedMotionEnabled = z2;
            this.allowAnimatedEmoji = z3;
            this.autoPlayGifs = z4;
            this.currentStickerAnimationSettings = i;
        }

        public static /* synthetic */ Model copy$default(Model model, boolean z2, boolean z3, boolean z4, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = model.reducedMotionEnabled;
            }
            if ((i2 & 2) != 0) {
                z3 = model.allowAnimatedEmoji;
            }
            if ((i2 & 4) != 0) {
                z4 = model.autoPlayGifs;
            }
            if ((i2 & 8) != 0) {
                i = model.currentStickerAnimationSettings;
            }
            return model.copy(z2, z3, z4, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getReducedMotionEnabled() {
            return this.reducedMotionEnabled;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getAllowAnimatedEmoji() {
            return this.allowAnimatedEmoji;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getAutoPlayGifs() {
            return this.autoPlayGifs;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getCurrentStickerAnimationSettings() {
            return this.currentStickerAnimationSettings;
        }

        public final Model copy(boolean reducedMotionEnabled, boolean allowAnimatedEmoji, boolean autoPlayGifs, int currentStickerAnimationSettings) {
            return new Model(reducedMotionEnabled, allowAnimatedEmoji, autoPlayGifs, currentStickerAnimationSettings);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.reducedMotionEnabled == model.reducedMotionEnabled && this.allowAnimatedEmoji == model.allowAnimatedEmoji && this.autoPlayGifs == model.autoPlayGifs && this.currentStickerAnimationSettings == model.currentStickerAnimationSettings;
        }

        public final boolean getAllowAnimatedEmoji() {
            return this.allowAnimatedEmoji;
        }

        public final boolean getAutoPlayGifs() {
            return this.autoPlayGifs;
        }

        public final int getCurrentStickerAnimationSettings() {
            return this.currentStickerAnimationSettings;
        }

        public final boolean getReducedMotionEnabled() {
            return this.reducedMotionEnabled;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            boolean z2 = this.reducedMotionEnabled;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.allowAnimatedEmoji;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.autoPlayGifs;
            return ((i2 + (z4 ? 1 : z4)) * 31) + this.currentStickerAnimationSettings;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(reducedMotionEnabled=");
            sbM833U.append(this.reducedMotionEnabled);
            sbM833U.append(", allowAnimatedEmoji=");
            sbM833U.append(this.allowAnimatedEmoji);
            sbM833U.append(", autoPlayGifs=");
            sbM833U.append(this.autoPlayGifs);
            sbM833U.append(", currentStickerAnimationSettings=");
            return C1643a.m814B(sbM833U, this.currentStickerAnimationSettings, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
    public static final /* synthetic */ class C96211 extends C12236k implements Function1<Model, Unit> {
        public C96211(WidgetSettingsAccessibility widgetSettingsAccessibility) {
            super(1, widgetSettingsAccessibility, WidgetSettingsAccessibility.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "p1");
            ((WidgetSettingsAccessibility) this.receiver).configureUI(model);
        }
    }

    public WidgetSettingsAccessibility() {
        super(C5419R.layout.widget_settings_accessibility);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccessibility$binding$2.INSTANCE, null, 2, null);
    }

    private final void configureStickerAnimationRadio(int currentStickerAnimationSettings, CheckedSetting radio, final int stickerAnimationSetting) {
        radio.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsAccessibility.configureStickerAnimationRadio.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getUserSettings().setStickerAnimationSettings(WidgetSettingsAccessibility.this.getAppActivity(), stickerAnimationSetting);
            }
        });
        RadioManager radioManager = this.stickersAnimationRadioManager;
        if (radioManager == null || currentStickerAnimationSettings != stickerAnimationSetting || radioManager == null) {
            return;
        }
        radioManager.m8550a(radio);
    }

    private final void configureUI(Model model) {
        CheckedSetting checkedSetting = getBinding().f17775g;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsAccessibilityReducedMotionSwitch");
        checkedSetting.setChecked(model.getReducedMotionEnabled());
        if (!model.getReducedMotionEnabled()) {
            CheckedSetting checkedSetting2 = getBinding().f17770b;
            C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsAccessib…tyAllowAnimateEmojiSwitch");
            checkedSetting2.setChecked(model.getAllowAnimatedEmoji());
            int currentStickerAnimationSettings = model.getCurrentStickerAnimationSettings();
            CheckedSetting checkedSetting3 = getBinding().f17777i;
            C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.stickersAlwaysAnimate");
            configureStickerAnimationRadio(currentStickerAnimationSettings, checkedSetting3, 0);
            int currentStickerAnimationSettings2 = model.getCurrentStickerAnimationSettings();
            CheckedSetting checkedSetting4 = getBinding().f17778j;
            C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.stickersAnimateOnInteraction");
            configureStickerAnimationRadio(currentStickerAnimationSettings2, checkedSetting4, 1);
            int currentStickerAnimationSettings3 = model.getCurrentStickerAnimationSettings();
            CheckedSetting checkedSetting5 = getBinding().f17779k;
            C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.stickersNeverAnimate");
            configureStickerAnimationRadio(currentStickerAnimationSettings3, checkedSetting5, 2);
            CheckedSetting checkedSetting6 = getBinding().f17771c;
            C12238m.checkNotNullExpressionValue(checkedSetting6, "binding.settingsAccessib…ityAllowAutoplayGifSwitch");
            checkedSetting6.setChecked(model.getAutoPlayGifs());
            getBinding().f17770b.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsAccessibility.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting7 = WidgetSettingsAccessibility.this.getBinding().f17770b;
                    CheckedSetting checkedSetting8 = WidgetSettingsAccessibility.this.getBinding().f17770b;
                    C12238m.checkNotNullExpressionValue(checkedSetting8, "binding.settingsAccessib…tyAllowAnimateEmojiSwitch");
                    checkedSetting7.m8529g(!checkedSetting8.isChecked(), true);
                }
            });
            getBinding().f17771c.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsAccessibility.configureUI.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting7 = WidgetSettingsAccessibility.this.getBinding().f17771c;
                    CheckedSetting checkedSetting8 = WidgetSettingsAccessibility.this.getBinding().f17771c;
                    C12238m.checkNotNullExpressionValue(checkedSetting8, "binding.settingsAccessib…ityAllowAutoplayGifSwitch");
                    checkedSetting7.m8529g(!checkedSetting8.isChecked(), true);
                }
            });
            return;
        }
        getBinding().f17770b.m8525b(C5419R.string.accessibility_reduced_motion_settings_override);
        CheckedSetting checkedSetting7 = getBinding().f17770b;
        C12238m.checkNotNullExpressionValue(checkedSetting7, "binding.settingsAccessib…tyAllowAnimateEmojiSwitch");
        checkedSetting7.setChecked(false);
        Iterator it = C12147n.listOf((Object[]) new CheckedSetting[]{getBinding().f17777i, getBinding().f17778j, getBinding().f17779k}).iterator();
        while (it.hasNext()) {
            ((CheckedSetting) it.next()).m8525b(C5419R.string.stickers_auto_play_help_disabled);
        }
        if (model.getCurrentStickerAnimationSettings() != 2) {
            RadioManager radioManager = this.stickersAnimationRadioManager;
            if (radioManager != null) {
                CheckedSetting checkedSetting8 = getBinding().f17778j;
                C12238m.checkNotNullExpressionValue(checkedSetting8, "binding.stickersAnimateOnInteraction");
                radioManager.m8550a(checkedSetting8);
            }
        } else {
            RadioManager radioManager2 = this.stickersAnimationRadioManager;
            if (radioManager2 != null) {
                CheckedSetting checkedSetting9 = getBinding().f17779k;
                C12238m.checkNotNullExpressionValue(checkedSetting9, "binding.stickersNeverAnimate");
                radioManager2.m8550a(checkedSetting9);
            }
        }
        CheckedSetting checkedSetting10 = getBinding().f17771c;
        C12238m.checkNotNullExpressionValue(checkedSetting10, "binding.settingsAccessib…ityAllowAutoplayGifSwitch");
        checkedSetting10.setChecked(false);
        getBinding().f17771c.m8525b(C5419R.string.accessibility_reduced_motion_settings_override);
    }

    private final WidgetSettingsAccessibilityBinding getBinding() {
        return (WidgetSettingsAccessibilityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), (Class<?>) WidgetSettingsAccessibility.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C96211(this));
        setActionBarTitle(C5419R.string.accessibility);
        setActionBarSubtitle(C5419R.string.user_settings);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().f17775g.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsAccessibility.onViewBoundOrOnResume.2
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreAccessibility accessibility = StoreStream.INSTANCE.getAccessibility();
                C12238m.checkNotNullExpressionValue(bool, "it");
                accessibility.setReducedMotionEnabled(bool.booleanValue());
            }
        });
        LinkifiedTextView linkifiedTextView = getBinding().f17773e;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsAccessib…yReducedMotionDescription");
        C1107b.m221m(linkifiedTextView, C5419R.string.accessibility_prefers_reduced_motion_description, new Object[]{C0862f.f507a.m149a(360040613412L, null)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f17770b.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsAccessibility.onViewBoundOrOnResume.3
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
                AppActivity appActivity = WidgetSettingsAccessibility.this.getAppActivity();
                C12238m.checkNotNullExpressionValue(bool, "checked");
                userSettings.setIsAnimatedEmojisEnabled(appActivity, bool.booleanValue());
            }
        });
        getBinding().f17771c.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsAccessibility.onViewBoundOrOnResume.4
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
                C12238m.checkNotNullExpressionValue(bool, "checked");
                userSettings.setIsAutoPlayGifsEnabled(bool.booleanValue());
            }
        });
        this.stickersAnimationRadioManager = new RadioManager(C12147n.listOf((Object[]) new CheckedSetting[]{getBinding().f17777i, getBinding().f17778j, getBinding().f17779k}));
        for (TextView textView : C12147n.listOf((Object[]) new TextView[]{getBinding().f17774f, getBinding().f17772d, getBinding().f17776h})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            C12238m.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
