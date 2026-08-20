package com.discord.widgets.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetSettingsAppearanceBinding;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.error.Error;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.ToastManager;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.views.CheckedSetting;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12083g;
import p507d0.C12113l;
import p507d0.p580t.C12147n;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func3;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsAppearance.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAppearanceBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetSettingsAppearance.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canSeePureEvil;
        private final String currentTheme;
        private final int fontScale;
        private final MeUser meUser;

        /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(Observable<Boolean> easterEggPureEvil) {
                C12238m.checkNotNullParameter(easterEggPureEvil, "easterEggPureEvil");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableM11075i = Observable.m11075i(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getUserSettingsSystem().observeSettings(false), easterEggPureEvil, new Func3<MeUser, StoreUserSettingsSystem.Settings, Boolean, Model>() { // from class: com.discord.widgets.settings.WidgetSettingsAppearance$Model$Companion$get$1
                    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
                    @Override // p658rx.functions.Func3
                    public final WidgetSettingsAppearance.Model call(MeUser meUser, StoreUserSettingsSystem.Settings settings, Boolean bool) {
                        boolean z2;
                        String theme = settings.getTheme();
                        C12238m.checkNotNullExpressionValue(bool, "isPureEvilVisible");
                        if (bool.booleanValue()) {
                            z2 = true;
                        } else {
                            UserUtils userUtils = UserUtils.INSTANCE;
                            C12238m.checkNotNullExpressionValue(meUser, "meUser");
                            if (userUtils.isStaff(meUser)) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        }
                        int fontScale = settings.getFontScale();
                        C12238m.checkNotNullExpressionValue(meUser, "meUser");
                        return new WidgetSettingsAppearance.Model(theme, z2, fontScale, meUser);
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11075i, "Observable\n            .…          )\n            }");
                return observableM11075i;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(String str, boolean z2, int i, MeUser meUser) {
            C12238m.checkNotNullParameter(str, "currentTheme");
            C12238m.checkNotNullParameter(meUser, "meUser");
            this.currentTheme = str;
            this.canSeePureEvil = z2;
            this.fontScale = i;
            this.meUser = meUser;
        }

        public static /* synthetic */ Model copy$default(Model model, String str, boolean z2, int i, MeUser meUser, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = model.currentTheme;
            }
            if ((i2 & 2) != 0) {
                z2 = model.canSeePureEvil;
            }
            if ((i2 & 4) != 0) {
                i = model.fontScale;
            }
            if ((i2 & 8) != 0) {
                meUser = model.meUser;
            }
            return model.copy(str, z2, i, meUser);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCurrentTheme() {
            return this.currentTheme;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getCanSeePureEvil() {
            return this.canSeePureEvil;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getFontScale() {
            return this.fontScale;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final Model copy(String currentTheme, boolean canSeePureEvil, int fontScale, MeUser meUser) {
            C12238m.checkNotNullParameter(currentTheme, "currentTheme");
            C12238m.checkNotNullParameter(meUser, "meUser");
            return new Model(currentTheme, canSeePureEvil, fontScale, meUser);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.currentTheme, model.currentTheme) && this.canSeePureEvil == model.canSeePureEvil && this.fontScale == model.fontScale && C12238m.areEqual(this.meUser, model.meUser);
        }

        public final boolean getCanSeePureEvil() {
            return this.canSeePureEvil;
        }

        public final String getCurrentTheme() {
            return this.currentTheme;
        }

        public final int getFontScale() {
            return this.fontScale;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5 */
        public int hashCode() {
            String str = this.currentTheme;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.canSeePureEvil;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (((iHashCode + r2) * 31) + this.fontScale) * 31;
            MeUser meUser = this.meUser;
            return i + (meUser != null ? meUser.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(currentTheme=");
            sbM833U.append(this.currentTheme);
            sbM833U.append(", canSeePureEvil=");
            sbM833U.append(this.canSeePureEvil);
            sbM833U.append(", fontScale=");
            sbM833U.append(this.fontScale);
            sbM833U.append(", meUser=");
            sbM833U.append(this.meUser);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final /* synthetic */ class C96331 extends C12236k implements Function1<Model, Unit> {
        public C96331(WidgetSettingsAppearance widgetSettingsAppearance) {
            super(1, widgetSettingsAppearance, WidgetSettingsAppearance.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/WidgetSettingsAppearance$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "p1");
            ((WidgetSettingsAppearance) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final class C96342 extends AbstractC12240o implements Function1<Integer, Unit> {
        public static final C96342 INSTANCE = new C96342();

        public C96342() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            StoreUserSettingsSystem userSettingsSystem = StoreStream.INSTANCE.getUserSettingsSystem();
            C12238m.checkNotNullExpressionValue(num, "fontScale");
            userSettingsSystem.setFontScale(num.intValue());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$showHolyLight$1 */
    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final class C96361 extends AbstractC12240o implements Function1<Long, Unit> {
        public C96361() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            View view = WidgetSettingsAppearance.this.getBinding().f17854g;
            C12238m.checkNotNullExpressionValue(view, "binding.settingsAppearanceHolyLight");
            view.setVisibility(8);
            WidgetSettingsAppearance.this.tryEnableTorchMode(false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$updateTheme$1 */
    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final class C96371 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $theme;

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$updateTheme$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<ModelUserSettings, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
                invoke2(modelUserSettings);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelUserSettings modelUserSettings) {
                C12238m.checkNotNullParameter(modelUserSettings, "it");
                if (C12238m.areEqual(C96371.this.$theme, ModelUserSettings.THEME_PURE_EVIL)) {
                    C0876m.m169g(WidgetSettingsAppearance.this.m95e(), C5419R.string.theme_pure_evil_updated, 0, null, 12);
                } else {
                    C0876m.m169g(WidgetSettingsAppearance.this.m95e(), C5419R.string.theme_updated, 0, null, 12);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96371(String str) {
            super(0);
            this.$theme = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithTheme(C12238m.areEqual(this.$theme, ModelUserSettings.THEME_PURE_EVIL) ? ModelUserSettings.THEME_DARK : this.$theme)), false, 1, null), WidgetSettingsAppearance.this, null, 2, null), (Class<?>) StoreUserSettings.class, (58 & 2) != 0 ? null : WidgetSettingsAppearance.this.m95e(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1());
        }
    }

    public WidgetSettingsAppearance() {
        super(C5419R.layout.widget_settings_appearance);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAppearance$binding$2.INSTANCE, null, 2, null);
        this.newFontScaleSubject = BehaviorSubject.m11129k0();
        this.pureEvilEasterEggSubject = C12083g.lazy(WidgetSettingsAppearance$pureEvilEasterEggSubject$2.INSTANCE);
        this.pureEvilEasterEggCounter = new AtomicInteger(0);
        this.holyLightEasterEggCounter = new AtomicInteger(0);
        this.toastManager = new ToastManager();
    }

    private final void configureFontScalingUI(int fontScale) {
        FragmentActivity fragmentActivityM95e;
        ContentResolver contentResolver;
        int systemFontScaleInt = (fontScale != -1 || (fragmentActivityM95e = m95e()) == null || (contentResolver = fragmentActivityM95e.getContentResolver()) == null) ? fontScale : FontUtils.INSTANCE.getSystemFontScaleInt(contentResolver);
        TextView textView = getBinding().f17851d;
        C12238m.checkNotNullExpressionValue(textView, "binding.settingsAppearanceFontScalePlatform");
        textView.setText(getFontScaleString(systemFontScaleInt, fontScale == -1));
        SeekBar seekBar = getBinding().f17853f;
        C12238m.checkNotNullExpressionValue(seekBar, "binding.settingsAppearanceFontScalingSeekbar");
        seekBar.setProgress(systemFontScaleInt - 80);
    }

    private final void configureThemeOption(CheckedSetting checkedSetting, final String str) {
        checkedSetting.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsAppearance.configureThemeOption.1
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                C12238m.checkNotNullExpressionValue(bool, "checked");
                if (bool.booleanValue()) {
                    WidgetSettingsAppearance.this.updateTheme(str);
                }
            }
        });
    }

    private final void configureUI(final Model model) {
        boolean z2 = !C12238m.areEqual(model.getCurrentTheme(), ModelUserSettings.THEME_LIGHT);
        getBinding().f17859l.m8529g(!z2, false);
        CheckedSetting checkedSetting = getBinding().f17859l;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsAppearanceThemeLightRadio");
        configureThemeOption(checkedSetting, ModelUserSettings.THEME_LIGHT);
        getBinding().f17859l.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsAppearance.configureUI.1

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
            @InterfaceC12188e(m10084c = "com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$1$1", m10085f = "WidgetSettingsAppearance.kt", m10086l = {122}, m10087m = "invokeSuspend")
            public static final class AnonymousClass1 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                public int label;

                public AnonymousClass1(Continuation continuation) {
                    super(2, continuation);
                }

                @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C12238m.checkNotNullParameter(continuation, "completion");
                    return ViewOnClickListenerC96281.this.new AnonymousClass1(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
                }

                @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        C12113l.throwOnFailure(obj);
                        this.label = 1;
                        if (C3404f.m4234P(5000L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        C12113l.throwOnFailure(obj);
                    }
                    WidgetSettingsAppearance.this.holyLightEasterEggCounter.set(0);
                    return Unit.f27425a;
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsAppearance.this.getBinding().f17859l.m8529g(true, true);
                int andIncrement = WidgetSettingsAppearance.this.holyLightEasterEggCounter.getAndIncrement();
                if (andIncrement != 0) {
                    if (andIncrement != 5) {
                        return;
                    }
                    WidgetSettingsAppearance.this.showHolyLight();
                } else {
                    C12238m.checkNotNullExpressionValue(view, "it");
                    CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(view);
                    if (coroutineScope != null) {
                        C3404f.m4211H0(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
                    }
                }
            }
        });
        getBinding().f17857j.m8529g(z2, false);
        CheckedSetting checkedSetting2 = getBinding().f17857j;
        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsAppearanceThemeDarkRadio");
        configureThemeOption(checkedSetting2, ModelUserSettings.THEME_DARK);
        getBinding().f17857j.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsAppearance.configureUI.2

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
            @InterfaceC12188e(m10084c = "com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$2$1", m10085f = "WidgetSettingsAppearance.kt", m10086l = {Opcodes.F2I}, m10087m = "invokeSuspend")
            public static final class AnonymousClass1 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                public int label;

                public AnonymousClass1(Continuation continuation) {
                    super(2, continuation);
                }

                @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C12238m.checkNotNullParameter(continuation, "completion");
                    return ViewOnClickListenerC96292.this.new AnonymousClass1(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
                }

                @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        C12113l.throwOnFailure(obj);
                        this.label = 1;
                        if (C3404f.m4234P(5000L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        C12113l.throwOnFailure(obj);
                    }
                    WidgetSettingsAppearance.this.pureEvilEasterEggCounter.set(0);
                    return Unit.f27425a;
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsAppearance.this.getBinding().f17857j.m8529g(true, true);
                if (model.getCanSeePureEvil()) {
                    return;
                }
                int andIncrement = WidgetSettingsAppearance.this.pureEvilEasterEggCounter.getAndIncrement();
                if (andIncrement == 0) {
                    C12238m.checkNotNullExpressionValue(view, "it");
                    CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(view);
                    if (coroutineScope != null) {
                        C3404f.m4211H0(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
                        return;
                    }
                    return;
                }
                if (3 <= andIncrement && 8 > andIncrement) {
                    C12238m.checkNotNullExpressionValue(view, "it");
                    C0876m.m170h(view.getContext(), C1107b.m213e(WidgetSettingsAppearance.this, C5419R.string.theme_pure_evil_easter_hint, new Object[]{String.valueOf(8 - andIncrement)}, (4 & 4) != 0 ? C1107b.a.f1490j : null), 0, WidgetSettingsAppearance.this.toastManager, 4);
                } else if (andIncrement == 8) {
                    C0876m.m166d(WidgetSettingsAppearance.this.getContext(), C5419R.string.theme_pure_evil_easter_reveal, 0, WidgetSettingsAppearance.this.toastManager);
                    WidgetSettingsAppearance.this.getPureEvilEasterEggSubject().onNext(Boolean.TRUE);
                }
            }
        });
        if (C12238m.areEqual(model.getCurrentTheme(), ModelUserSettings.THEME_PURE_EVIL)) {
            CheckedSetting.m8523d(getBinding().f17860m, null, 1);
        }
        getBinding().f17860m.m8529g(C12238m.areEqual(model.getCurrentTheme(), ModelUserSettings.THEME_PURE_EVIL), false);
        CheckedSetting checkedSetting3 = getBinding().f17860m;
        C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.settingsAppearanceThemePureEvilSwitch");
        checkedSetting3.setVisibility(model.getCanSeePureEvil() ? 0 : 8);
        getBinding().f17860m.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsAppearance.configureUI.3
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                C12238m.checkNotNullExpressionValue(bool, "isChecked");
                if (bool.booleanValue() && C12238m.areEqual(model.getCurrentTheme(), ModelUserSettings.THEME_DARK)) {
                    WidgetSettingsAppearance.this.updateTheme(ModelUserSettings.THEME_PURE_EVIL);
                } else {
                    if (bool.booleanValue() || !C12238m.areEqual(model.getCurrentTheme(), ModelUserSettings.THEME_PURE_EVIL)) {
                        return;
                    }
                    WidgetSettingsAppearance.this.updateTheme(ModelUserSettings.THEME_DARK);
                }
            }
        });
        configureFontScalingUI(model.getFontScale());
        getBinding().f17853f.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.discord.widgets.settings.WidgetSettingsAppearance.configureUI.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    int i = progress + 80;
                    WidgetSettingsAppearance.this.newFontScaleSubject.onNext(Integer.valueOf(i));
                    TextView textView = WidgetSettingsAppearance.this.getBinding().f17851d;
                    C12238m.checkNotNullExpressionValue(textView, "binding.settingsAppearanceFontScalePlatform");
                    textView.setText(WidgetSettingsAppearance.this.getFontScaleString(i, false));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        getBinding().f17852e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsAppearance.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getUserSettingsSystem().setFontScale(-1);
            }
        });
        setupMessage(model);
        for (TextView textView : C12147n.listOf((Object[]) new TextView[]{getBinding().f17858k, getBinding().f17855h, getBinding().f17850c})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            C12238m.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }

    private final WidgetSettingsAppearanceBinding getBinding() {
        return (WidgetSettingsAppearanceBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getFontScaleString(int fontScale, boolean useSystemFontScale) {
        if (useSystemFontScale) {
            return fontScale + "% (" + getString(C5419R.string.accessibility_font_scaling_use_os) + ')';
        }
        return fontScale + "% (" + getString(C5419R.string.accessibility_font_scaling_use_app) + ')';
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

    private final void setupMessage(Model model) {
        SimpleDraweeView simpleDraweeView = getBinding().f17849b.f16319c;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatItem.chatListAdapterItemTextAvatar");
        IconUtils.setIcon$default(simpleDraweeView, model.getMeUser(), C5419R.dimen.avatar_size_standard, null, null, null, 56, null);
        TextView textView = getBinding().f17849b.f16322f;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatItem.chatListAdapterItemTextTag");
        textView.setVisibility(8);
        TextView textView2 = getBinding().f17849b.f16320d;
        C12238m.checkNotNullExpressionValue(textView2, "binding.chatItem.chatListAdapterItemTextName");
        textView2.setText(model.getMeUser().getUsername());
        TextView textView3 = getBinding().f17849b.f16323g;
        C12238m.checkNotNullExpressionValue(textView3, "binding.chatItem.chatListAdapterItemTextTimestamp");
        textView3.setText(TimeUtils.toReadableTimeString$default(requireContext(), ClockFactory.get().currentTimeMillis(), null, 4, null));
        LinkifiedTextView linkifiedTextView = getBinding().f17849b.f16318b;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.chatItem.chatListAdapterItemText");
        linkifiedTextView.setText(getString(C5419R.string.user_settings_appearance_preview_message_1));
    }

    private final void showHolyLight() {
        C0876m.m166d(getContext(), C5419R.string.theme_holy_light_reveal, 0, this.toastManager);
        tryEnableTorchMode(true);
        View view = getBinding().f17854g;
        C12238m.checkNotNullExpressionValue(view, "binding.settingsAppearanceHolyLight");
        view.setVisibility(0);
        Observable<Long> observableM11068d0 = Observable.m11068d0(3L, TimeUnit.SECONDS);
        C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable\n        .timer(3, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11068d0, this, null, 2, null), (Class<?>) WidgetSettingsAppearance.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C96361());
    }

    private final void tryEnableTorchMode(boolean enabled) {
        String str;
        if (Build.VERSION.SDK_INT >= 23) {
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
                    AppLog.f14950g.mo8370w("Unable to turn on flashlight", e);
                }
            }
        }
    }

    private final void updateTheme(String theme) {
        StoreStream.INSTANCE.getUserSettingsSystem().setTheme(theme, true, new C96371(theme));
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.toastManager.close();
        super.onDestroyView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(C5419R.string.appearance);
        setActionBarSubtitle(C5419R.string.user_settings);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        SeekBar seekBar = getBinding().f17853f;
        C12238m.checkNotNullExpressionValue(seekBar, "binding.settingsAppearanceFontScalingSeekbar");
        seekBar.setMax(70);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Model.Companion companion = Model.INSTANCE;
        BehaviorSubject<Boolean> pureEvilEasterEggSubject = getPureEvilEasterEggSubject();
        C12238m.checkNotNullExpressionValue(pureEvilEasterEggSubject, "pureEvilEasterEggSubject");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion.get(pureEvilEasterEggSubject), this, null, 2, null), (Class<?>) WidgetSettingsAppearance.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C96331(this));
        Observable<Integer> observableM11110p = this.newFontScaleSubject.m11110p(400L, TimeUnit.MILLISECONDS);
        C12238m.checkNotNullExpressionValue(observableM11110p, "newFontScaleSubject\n    …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11110p, this, null, 2, null), (Class<?>) WidgetSettingsAppearance.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C96342.INSTANCE);
        CheckedSetting checkedSetting = getBinding().f17856i;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsAppearanceSyncSwitch");
        checkedSetting.setChecked(StoreStream.INSTANCE.getUserSettingsSystem().getIsThemeSyncEnabled());
        getBinding().f17856i.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsAppearance.onViewBoundOrOnResume.3
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettingsSystem userSettingsSystem = StoreStream.INSTANCE.getUserSettingsSystem();
                C12238m.checkNotNullExpressionValue(bool, "it");
                userSettingsSystem.setIsSyncThemeEnabled(bool.booleanValue());
            }
        });
    }
}
