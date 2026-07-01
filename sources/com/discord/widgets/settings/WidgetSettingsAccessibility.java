package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccessibilityBinding;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.settings.WidgetSettingsAccessibility;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccessibility extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsAccessibility.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccessibilityBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsAccessibility.class, null, 4);
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
                Observable<Model> observableH = Observable.h(companion.getAccessibility().observeReducedMotionEnabled(), companion.getUserSettings().observeIsAnimatedEmojisEnabled(false), companion.getUserSettings().observeIsAutoPlayGifsEnabled(false), companion.getUserSettings().observeStickerAnimationSettings(false), new Func4<Boolean, Boolean, Boolean, Integer, Model>() { // from class: com.discord.widgets.settings.WidgetSettingsAccessibility$Model$Companion$get$1
                    @Override // rx.functions.Func4
                    public final WidgetSettingsAccessibility.Model call(Boolean bool, Boolean bool2, Boolean bool3, Integer num) {
                        Intrinsics3.checkNotNullExpressionValue(bool, "reducedMotionEnabled");
                        boolean zBooleanValue = bool.booleanValue();
                        Intrinsics3.checkNotNullExpressionValue(bool2, "allowAnimatedEmoji");
                        boolean zBooleanValue2 = bool2.booleanValue();
                        Intrinsics3.checkNotNullExpressionValue(bool3, "autoPlayGifs");
                        boolean zBooleanValue3 = bool3.booleanValue();
                        Intrinsics3.checkNotNullExpressionValue(num, "currentStickerAnimationSettings");
                        return new WidgetSettingsAccessibility.Model(zBooleanValue, zBooleanValue2, zBooleanValue3, num.intValue());
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…ngs\n          )\n        }");
                return observableH;
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
            StringBuilder sbU = outline.U("Model(reducedMotionEnabled=");
            sbU.append(this.reducedMotionEnabled);
            sbU.append(", allowAnimatedEmoji=");
            sbU.append(this.allowAnimatedEmoji);
            sbU.append(", autoPlayGifs=");
            sbU.append(this.autoPlayGifs);
            sbU.append(", currentStickerAnimationSettings=");
            return outline.B(sbU, this.currentStickerAnimationSettings, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetSettingsAccessibility widgetSettingsAccessibility) {
            super(1, widgetSettingsAccessibility, WidgetSettingsAccessibility.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            ((WidgetSettingsAccessibility) this.receiver).configureUI(model);
        }
    }

    public WidgetSettingsAccessibility() {
        super(R.layout.widget_settings_accessibility);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccessibility3.INSTANCE, null, 2, null);
    }

    private final void configureStickerAnimationRadio(int currentStickerAnimationSettings, CheckedSetting radio, final int stickerAnimationSetting) {
        radio.e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsAccessibility.configureStickerAnimationRadio.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getUserSettings().setStickerAnimationSettings(WidgetSettingsAccessibility.this.getAppActivity(), stickerAnimationSetting);
            }
        });
        RadioManager radioManager = this.stickersAnimationRadioManager;
        if (radioManager == null || currentStickerAnimationSettings != stickerAnimationSetting || radioManager == null) {
            return;
        }
        radioManager.a(radio);
    }

    private final void configureUI(Model model) {
        CheckedSetting checkedSetting = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsAccessibilityReducedMotionSwitch");
        checkedSetting.setChecked(model.getReducedMotionEnabled());
        if (!model.getReducedMotionEnabled()) {
            CheckedSetting checkedSetting2 = getBinding().f2589b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsAccessib…tyAllowAnimateEmojiSwitch");
            checkedSetting2.setChecked(model.getAllowAnimatedEmoji());
            int currentStickerAnimationSettings = model.getCurrentStickerAnimationSettings();
            CheckedSetting checkedSetting3 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.stickersAlwaysAnimate");
            configureStickerAnimationRadio(currentStickerAnimationSettings, checkedSetting3, 0);
            int currentStickerAnimationSettings2 = model.getCurrentStickerAnimationSettings();
            CheckedSetting checkedSetting4 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.stickersAnimateOnInteraction");
            configureStickerAnimationRadio(currentStickerAnimationSettings2, checkedSetting4, 1);
            int currentStickerAnimationSettings3 = model.getCurrentStickerAnimationSettings();
            CheckedSetting checkedSetting5 = getBinding().k;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.stickersNeverAnimate");
            configureStickerAnimationRadio(currentStickerAnimationSettings3, checkedSetting5, 2);
            CheckedSetting checkedSetting6 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.settingsAccessib…ityAllowAutoplayGifSwitch");
            checkedSetting6.setChecked(model.getAutoPlayGifs());
            getBinding().f2589b.e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsAccessibility.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting7 = WidgetSettingsAccessibility.this.getBinding().f2589b;
                    CheckedSetting checkedSetting8 = WidgetSettingsAccessibility.this.getBinding().f2589b;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting8, "binding.settingsAccessib…tyAllowAnimateEmojiSwitch");
                    checkedSetting7.g(!checkedSetting8.isChecked(), true);
                }
            });
            getBinding().c.e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsAccessibility.configureUI.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting7 = WidgetSettingsAccessibility.this.getBinding().c;
                    CheckedSetting checkedSetting8 = WidgetSettingsAccessibility.this.getBinding().c;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting8, "binding.settingsAccessib…ityAllowAutoplayGifSwitch");
                    checkedSetting7.g(!checkedSetting8.isChecked(), true);
                }
            });
            return;
        }
        getBinding().f2589b.b(R.string.accessibility_reduced_motion_settings_override);
        CheckedSetting checkedSetting7 = getBinding().f2589b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting7, "binding.settingsAccessib…tyAllowAnimateEmojiSwitch");
        checkedSetting7.setChecked(false);
        Iterator it = Collections2.listOf((Object[]) new CheckedSetting[]{getBinding().i, getBinding().j, getBinding().k}).iterator();
        while (it.hasNext()) {
            ((CheckedSetting) it.next()).b(R.string.stickers_auto_play_help_disabled);
        }
        if (model.getCurrentStickerAnimationSettings() != 2) {
            RadioManager radioManager = this.stickersAnimationRadioManager;
            if (radioManager != null) {
                CheckedSetting checkedSetting8 = getBinding().j;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting8, "binding.stickersAnimateOnInteraction");
                radioManager.a(checkedSetting8);
            }
        } else {
            RadioManager radioManager2 = this.stickersAnimationRadioManager;
            if (radioManager2 != null) {
                CheckedSetting checkedSetting9 = getBinding().k;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting9, "binding.stickersNeverAnimate");
                radioManager2.a(checkedSetting9);
            }
        }
        CheckedSetting checkedSetting10 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting10, "binding.settingsAccessib…ityAllowAutoplayGifSwitch");
        checkedSetting10.setChecked(false);
        getBinding().c.b(R.string.accessibility_reduced_motion_settings_override);
    }

    private final WidgetSettingsAccessibilityBinding getBinding() {
        return (WidgetSettingsAccessibilityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), (Class<?>) WidgetSettingsAccessibility.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        setActionBarTitle(R.string.accessibility);
        setActionBarSubtitle(R.string.user_settings);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().g.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsAccessibility.onViewBoundOrOnResume.2
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreAccessibility accessibility = StoreStream.INSTANCE.getAccessibility();
                Intrinsics3.checkNotNullExpressionValue(bool, "it");
                accessibility.setReducedMotionEnabled(bool.booleanValue());
            }
        });
        LinkifiedTextView linkifiedTextView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsAccessib…yReducedMotionDescription");
        FormatUtils.m(linkifiedTextView, R.string.accessibility_prefers_reduced_motion_description, new Object[]{AppHelpDesk.a.a(360040613412L, null)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        getBinding().f2589b.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsAccessibility.onViewBoundOrOnResume.3
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
                AppActivity appActivity = WidgetSettingsAccessibility.this.getAppActivity();
                Intrinsics3.checkNotNullExpressionValue(bool, "checked");
                userSettings.setIsAnimatedEmojisEnabled(appActivity, bool.booleanValue());
            }
        });
        getBinding().c.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsAccessibility.onViewBoundOrOnResume.4
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
                Intrinsics3.checkNotNullExpressionValue(bool, "checked");
                userSettings.setIsAutoPlayGifsEnabled(bool.booleanValue());
            }
        });
        this.stickersAnimationRadioManager = new RadioManager(Collections2.listOf((Object[]) new CheckedSetting[]{getBinding().i, getBinding().j, getBinding().k}));
        for (TextView textView : Collections2.listOf((Object[]) new TextView[]{getBinding().f, getBinding().d, getBinding().h})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
