package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsLanguageBinding;
import com.discord.models.domain.ModelUserSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguage extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsLanguage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsLanguageBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
    public static final class Companion {
        private Companion() {
        }

        public final String getAsStringInLocale(String locale) {
            if (locale == null) {
                return "English, USA";
            }
            switch (locale.hashCode()) {
                case 3141:
                    return locale.equals("bg") ? "български" : "English, USA";
                case 3184:
                    return locale.equals("cs") ? "Čeština" : "English, USA";
                case 3197:
                    return locale.equals("da") ? "Dansk" : "English, USA";
                case 3201:
                    return locale.equals("de") ? "Deutsch" : "English, USA";
                case 3239:
                    return locale.equals("el") ? "Ελληνικά" : "English, USA";
                case 3267:
                    return locale.equals("fi") ? "Suomi" : "English, USA";
                case 3276:
                    return locale.equals("fr") ? "Français" : "English, USA";
                case 3329:
                    return locale.equals("hi") ? "हिंदी" : "English, USA";
                case 3338:
                    return locale.equals("hr") ? "Hrvatski" : "English, USA";
                case 3341:
                    return locale.equals("hu") ? "Magyar" : "English, USA";
                case 3371:
                    return locale.equals("it") ? "Italiano" : "English, USA";
                case 3383:
                    return locale.equals("ja") ? "日本語" : "English, USA";
                case 3428:
                    return locale.equals("ko") ? "한국어" : "English, USA";
                case 3464:
                    return locale.equals("lt") ? "Lietuviškai" : "English, USA";
                case 3518:
                    return locale.equals("nl") ? "Nederlands" : "English, USA";
                case 3521:
                    return locale.equals("no") ? "Norsk" : "English, USA";
                case 3580:
                    return locale.equals("pl") ? "Polski" : "English, USA";
                case 3645:
                    return locale.equals("ro") ? "Română" : "English, USA";
                case 3651:
                    return locale.equals("ru") ? "Русский" : "English, USA";
                case 3700:
                    return locale.equals("th") ? "ไทย" : "English, USA";
                case 3710:
                    return locale.equals("tr") ? "Türkçe" : "English, USA";
                case 3734:
                    return locale.equals("uk") ? "Українська" : "English, USA";
                case 3763:
                    return locale.equals("vi") ? "Tiếng Việt" : "English, USA";
                case 96598143:
                    return locale.equals("en-GB") ? "English, UK" : "English, USA";
                case 96598594:
                    locale.equals("en-US");
                    return "English, USA";
                case 96747053:
                    return locale.equals("es-ES") ? "Español" : "English, USA";
                case 106935481:
                    return locale.equals("pt-BR") ? "Português do Brasil" : "English, USA";
                case 109766140:
                    return locale.equals("sv-SE") ? "Svenska" : "English, USA";
                case 115813226:
                    return locale.equals("zh-CN") ? "中文" : "English, USA";
                case 115813762:
                    return locale.equals("zh-TW") ? "繁體中文" : "English, USA";
                default:
                    return "English, USA";
            }
        }

        @DrawableRes
        public final int getLocaleFlagResId(String locale) {
            if (locale == null) {
                return C5419R.drawable.icon_flag_en_us;
            }
            switch (locale.hashCode()) {
                case 3141:
                    return locale.equals("bg") ? C5419R.drawable.icon_flag_bg : C5419R.drawable.icon_flag_en_us;
                case 3184:
                    return locale.equals("cs") ? C5419R.drawable.icon_flag_cs : C5419R.drawable.icon_flag_en_us;
                case 3197:
                    return locale.equals("da") ? C5419R.drawable.icon_flag_da : C5419R.drawable.icon_flag_en_us;
                case 3201:
                    return locale.equals("de") ? C5419R.drawable.icon_flag_de : C5419R.drawable.icon_flag_en_us;
                case 3239:
                    return locale.equals("el") ? C5419R.drawable.icon_flag_el : C5419R.drawable.icon_flag_en_us;
                case 3267:
                    return locale.equals("fi") ? C5419R.drawable.icon_flag_fi : C5419R.drawable.icon_flag_en_us;
                case 3276:
                    return locale.equals("fr") ? C5419R.drawable.icon_flag_fr : C5419R.drawable.icon_flag_en_us;
                case 3329:
                    return locale.equals("hi") ? C5419R.drawable.icon_flag_hi : C5419R.drawable.icon_flag_en_us;
                case 3338:
                    return locale.equals("hr") ? C5419R.drawable.icon_flag_hr : C5419R.drawable.icon_flag_en_us;
                case 3341:
                    return locale.equals("hu") ? C5419R.drawable.icon_flag_hu : C5419R.drawable.icon_flag_en_us;
                case 3371:
                    return locale.equals("it") ? C5419R.drawable.icon_flag_it : C5419R.drawable.icon_flag_en_us;
                case 3383:
                    return locale.equals("ja") ? C5419R.drawable.icon_flag_ja : C5419R.drawable.icon_flag_en_us;
                case 3428:
                    return locale.equals("ko") ? C5419R.drawable.icon_flag_ko : C5419R.drawable.icon_flag_en_us;
                case 3464:
                    return locale.equals("lt") ? C5419R.drawable.icon_flag_lt : C5419R.drawable.icon_flag_en_us;
                case 3518:
                    return locale.equals("nl") ? C5419R.drawable.icon_flag_nl : C5419R.drawable.icon_flag_en_us;
                case 3521:
                    return locale.equals("no") ? C5419R.drawable.icon_flag_no : C5419R.drawable.icon_flag_en_us;
                case 3580:
                    return locale.equals("pl") ? C5419R.drawable.icon_flag_pl : C5419R.drawable.icon_flag_en_us;
                case 3645:
                    return locale.equals("ro") ? C5419R.drawable.icon_flag_ro : C5419R.drawable.icon_flag_en_us;
                case 3651:
                    return locale.equals("ru") ? C5419R.drawable.icon_flag_ru : C5419R.drawable.icon_flag_en_us;
                case 3700:
                    return locale.equals("th") ? C5419R.drawable.icon_flag_th : C5419R.drawable.icon_flag_en_us;
                case 3710:
                    return locale.equals("tr") ? C5419R.drawable.icon_flag_tr : C5419R.drawable.icon_flag_en_us;
                case 3734:
                    return locale.equals("uk") ? C5419R.drawable.icon_flag_uk : C5419R.drawable.icon_flag_en_us;
                case 3763:
                    return locale.equals("vi") ? C5419R.drawable.icon_flag_vi : C5419R.drawable.icon_flag_en_us;
                case 96598143:
                    return locale.equals("en-GB") ? C5419R.drawable.icon_flag_en_gb : C5419R.drawable.icon_flag_en_us;
                case 96598594:
                    locale.equals("en-US");
                    return C5419R.drawable.icon_flag_en_us;
                case 96747053:
                    return locale.equals("es-ES") ? C5419R.drawable.icon_flag_es_es : C5419R.drawable.icon_flag_en_us;
                case 106935481:
                    return locale.equals("pt-BR") ? C5419R.drawable.icon_flag_pt_br : C5419R.drawable.icon_flag_en_us;
                case 109766140:
                    return locale.equals("sv-SE") ? C5419R.drawable.icon_flag_sv_se : C5419R.drawable.icon_flag_en_us;
                case 115813226:
                    return locale.equals("zh-CN") ? C5419R.drawable.icon_flag_zh_cn : C5419R.drawable.icon_flag_en_us;
                case 115813762:
                    return locale.equals("zh-TW") ? C5419R.drawable.icon_flag_zh_tw : C5419R.drawable.icon_flag_en_us;
                default:
                    return C5419R.drawable.icon_flag_en_us;
            }
        }

        @StringRes
        public final int getLocaleResId(String locale) {
            if (locale == null) {
                return C5419R.string.en_us;
            }
            switch (locale.hashCode()) {
                case 3141:
                    return locale.equals("bg") ? C5419R.string.f14656bg : C5419R.string.en_us;
                case 3184:
                    return locale.equals("cs") ? C5419R.string.f14659cs : C5419R.string.en_us;
                case 3197:
                    return locale.equals("da") ? C5419R.string.f14660da : C5419R.string.en_us;
                case 3201:
                    return locale.equals("de") ? C5419R.string.f14661de : C5419R.string.en_us;
                case 3239:
                    return locale.equals("el") ? C5419R.string.f14663el : C5419R.string.en_us;
                case 3267:
                    return locale.equals("fi") ? C5419R.string.f14667fi : C5419R.string.en_us;
                case 3276:
                    return locale.equals("fr") ? C5419R.string.f14668fr : C5419R.string.en_us;
                case 3329:
                    return locale.equals("hi") ? C5419R.string.f14766hi : C5419R.string.en_us;
                case 3338:
                    return locale.equals("hr") ? C5419R.string.f14767hr : C5419R.string.en_us;
                case 3341:
                    return locale.equals("hu") ? C5419R.string.f14768hu : C5419R.string.en_us;
                case 3371:
                    return locale.equals("it") ? C5419R.string.f14773it : C5419R.string.en_us;
                case 3383:
                    return locale.equals("ja") ? C5419R.string.f14774ja : C5419R.string.en_us;
                case 3428:
                    return locale.equals("ko") ? C5419R.string.f14775ko : C5419R.string.en_us;
                case 3464:
                    return locale.equals("lt") ? C5419R.string.f14776lt : C5419R.string.en_us;
                case 3518:
                    return locale.equals("nl") ? C5419R.string.f14780nl : C5419R.string.en_us;
                case 3521:
                    return locale.equals("no") ? C5419R.string.f14781no : C5419R.string.en_us;
                case 3580:
                    return locale.equals("pl") ? C5419R.string.f14783pl : C5419R.string.en_us;
                case 3645:
                    return locale.equals("ro") ? C5419R.string.f14802ro : C5419R.string.en_us;
                case 3651:
                    return locale.equals("ru") ? C5419R.string.f14807ru : C5419R.string.en_us;
                case 3700:
                    return locale.equals("th") ? C5419R.string.f14813th : C5419R.string.en_us;
                case 3710:
                    return locale.equals("tr") ? C5419R.string.f14814tr : C5419R.string.en_us;
                case 3734:
                    return locale.equals("uk") ? C5419R.string.f14815uk : C5419R.string.en_us;
                case 3763:
                    return locale.equals("vi") ? C5419R.string.f14816vi : C5419R.string.en_us;
                case 96598143:
                    return locale.equals("en-GB") ? C5419R.string.en_gb : C5419R.string.en_us;
                case 96598594:
                    locale.equals("en-US");
                    return C5419R.string.en_us;
                case 96747053:
                    return locale.equals("es-ES") ? C5419R.string.es_es : C5419R.string.en_us;
                case 106935481:
                    return locale.equals("pt-BR") ? C5419R.string.pt_br : C5419R.string.en_us;
                case 109766140:
                    return locale.equals("sv-SE") ? C5419R.string.sv_se : C5419R.string.en_us;
                case 115813226:
                    return locale.equals("zh-CN") ? C5419R.string.zh_cn : C5419R.string.en_us;
                case 115813762:
                    return locale.equals("zh-TW") ? C5419R.string.zh_tw : C5419R.string.en_us;
                default:
                    return C5419R.string.en_us;
            }
        }

        public final void launch(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetSettingsLanguage.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
    public static final class C96411 extends AbstractC12240o implements Function1<String, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBound$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ String $locale;

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBound$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
            public static final class C132891 extends AbstractC12240o implements Function1<ModelUserSettings, Unit> {
                public C132891() {
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
                    C0876m.m169g(WidgetSettingsLanguage.this.requireContext(), C5419R.string.language_updated, 0, null, 12);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(String str) {
                super(0);
                this.$locale = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithLocale(this.$locale)), false, 1, null), WidgetSettingsLanguage.this, null, 2, null), (Class<?>) StoreUserSettings.class, (58 & 2) != 0 ? null : WidgetSettingsLanguage.this.requireContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C132891());
            }
        }

        public C96411() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "locale");
            StoreStream.INSTANCE.getUserSettingsSystem().setLocale(str, true, new AnonymousClass1(str));
            AppActivity appActivity = WidgetSettingsLanguage.this.getAppActivity();
            if (appActivity != null) {
                appActivity.recreate();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
    public static final class C96421 extends AbstractC12240o implements Function1<StoreUserSettingsSystem.Settings, Unit> {
        public C96421() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreUserSettingsSystem.Settings settings) {
            invoke2(settings);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreUserSettingsSystem.Settings settings) {
            C12238m.checkNotNullParameter(settings, "settings");
            WidgetSettingsLanguage.this.configureUI(settings.getLocale());
        }
    }

    public WidgetSettingsLanguage() {
        super(C5419R.layout.widget_settings_language);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsLanguage$binding$2.INSTANCE, null, 2, null);
    }

    private final void configureUI(String locale) {
        TextView textView = getBinding().f17995d;
        C12238m.checkNotNullExpressionValue(textView, "binding.settingsLanguageCurrentText");
        Companion companion = INSTANCE;
        textView.setText(getString(companion.getLocaleResId(locale)));
        getBinding().f17994c.setImageResource(companion.getLocaleFlagResId(locale));
    }

    private final WidgetSettingsLanguageBinding getBinding() {
        return (WidgetSettingsLanguageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.language);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        WidgetSettingsLanguageSelect.INSTANCE.registerForResult(this, new C96411());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion.getUserSettingsSystem().observeSettings(false), this, null, 2, null), (Class<?>) WidgetSettingsLanguage.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C96421());
        CheckedSetting checkedSetting = getBinding().f17997f;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsLanguageSyncCheck");
        checkedSetting.setChecked(companion.getUserSettingsSystem().getIsLocaleSyncEnabled());
        getBinding().f17997f.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsLanguage.onViewBoundOrOnResume.2
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettingsSystem userSettingsSystem = StoreStream.INSTANCE.getUserSettingsSystem();
                C12238m.checkNotNullExpressionValue(bool, "checked");
                userSettingsSystem.setIsLocaleSyncEnabled(bool.booleanValue());
            }
        });
        getBinding().f17993b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsLanguage.onViewBoundOrOnResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsLanguageSelect.INSTANCE.show(WidgetSettingsLanguage.this);
            }
        });
        for (TextView textView : C12147n.listOf((Object[]) new TextView[]{getBinding().f17996e, getBinding().f17998g})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            C12238m.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
