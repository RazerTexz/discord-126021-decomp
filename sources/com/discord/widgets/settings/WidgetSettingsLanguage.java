package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguage extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsLanguage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsLanguageBinding;", 0)};

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
                return R.drawable.icon_flag_en_us;
            }
            switch (locale.hashCode()) {
                case 3141:
                    return locale.equals("bg") ? R.drawable.icon_flag_bg : R.drawable.icon_flag_en_us;
                case 3184:
                    return locale.equals("cs") ? R.drawable.icon_flag_cs : R.drawable.icon_flag_en_us;
                case 3197:
                    return locale.equals("da") ? R.drawable.icon_flag_da : R.drawable.icon_flag_en_us;
                case 3201:
                    return locale.equals("de") ? R.drawable.icon_flag_de : R.drawable.icon_flag_en_us;
                case 3239:
                    return locale.equals("el") ? R.drawable.icon_flag_el : R.drawable.icon_flag_en_us;
                case 3267:
                    return locale.equals("fi") ? R.drawable.icon_flag_fi : R.drawable.icon_flag_en_us;
                case 3276:
                    return locale.equals("fr") ? R.drawable.icon_flag_fr : R.drawable.icon_flag_en_us;
                case 3329:
                    return locale.equals("hi") ? R.drawable.icon_flag_hi : R.drawable.icon_flag_en_us;
                case 3338:
                    return locale.equals("hr") ? R.drawable.icon_flag_hr : R.drawable.icon_flag_en_us;
                case 3341:
                    return locale.equals("hu") ? R.drawable.icon_flag_hu : R.drawable.icon_flag_en_us;
                case 3371:
                    return locale.equals("it") ? R.drawable.icon_flag_it : R.drawable.icon_flag_en_us;
                case 3383:
                    return locale.equals("ja") ? R.drawable.icon_flag_ja : R.drawable.icon_flag_en_us;
                case 3428:
                    return locale.equals("ko") ? R.drawable.icon_flag_ko : R.drawable.icon_flag_en_us;
                case 3464:
                    return locale.equals("lt") ? R.drawable.icon_flag_lt : R.drawable.icon_flag_en_us;
                case 3518:
                    return locale.equals("nl") ? R.drawable.icon_flag_nl : R.drawable.icon_flag_en_us;
                case 3521:
                    return locale.equals("no") ? R.drawable.icon_flag_no : R.drawable.icon_flag_en_us;
                case 3580:
                    return locale.equals("pl") ? R.drawable.icon_flag_pl : R.drawable.icon_flag_en_us;
                case 3645:
                    return locale.equals("ro") ? R.drawable.icon_flag_ro : R.drawable.icon_flag_en_us;
                case 3651:
                    return locale.equals("ru") ? R.drawable.icon_flag_ru : R.drawable.icon_flag_en_us;
                case 3700:
                    return locale.equals("th") ? R.drawable.icon_flag_th : R.drawable.icon_flag_en_us;
                case 3710:
                    return locale.equals("tr") ? R.drawable.icon_flag_tr : R.drawable.icon_flag_en_us;
                case 3734:
                    return locale.equals("uk") ? R.drawable.icon_flag_uk : R.drawable.icon_flag_en_us;
                case 3763:
                    return locale.equals("vi") ? R.drawable.icon_flag_vi : R.drawable.icon_flag_en_us;
                case 96598143:
                    return locale.equals("en-GB") ? R.drawable.icon_flag_en_gb : R.drawable.icon_flag_en_us;
                case 96598594:
                    locale.equals("en-US");
                    return R.drawable.icon_flag_en_us;
                case 96747053:
                    return locale.equals("es-ES") ? R.drawable.icon_flag_es_es : R.drawable.icon_flag_en_us;
                case 106935481:
                    return locale.equals("pt-BR") ? R.drawable.icon_flag_pt_br : R.drawable.icon_flag_en_us;
                case 109766140:
                    return locale.equals("sv-SE") ? R.drawable.icon_flag_sv_se : R.drawable.icon_flag_en_us;
                case 115813226:
                    return locale.equals("zh-CN") ? R.drawable.icon_flag_zh_cn : R.drawable.icon_flag_en_us;
                case 115813762:
                    return locale.equals("zh-TW") ? R.drawable.icon_flag_zh_tw : R.drawable.icon_flag_en_us;
                default:
                    return R.drawable.icon_flag_en_us;
            }
        }

        @StringRes
        public final int getLocaleResId(String locale) {
            if (locale == null) {
                return R.string.en_us;
            }
            switch (locale.hashCode()) {
                case 3141:
                    return locale.equals("bg") ? R.string.bg : R.string.en_us;
                case 3184:
                    return locale.equals("cs") ? R.string.cs : R.string.en_us;
                case 3197:
                    return locale.equals("da") ? R.string.da : R.string.en_us;
                case 3201:
                    return locale.equals("de") ? R.string.de : R.string.en_us;
                case 3239:
                    return locale.equals("el") ? R.string.el : R.string.en_us;
                case 3267:
                    return locale.equals("fi") ? R.string.fi : R.string.en_us;
                case 3276:
                    return locale.equals("fr") ? R.string.fr : R.string.en_us;
                case 3329:
                    return locale.equals("hi") ? R.string.hi : R.string.en_us;
                case 3338:
                    return locale.equals("hr") ? R.string.hr : R.string.en_us;
                case 3341:
                    return locale.equals("hu") ? R.string.hu : R.string.en_us;
                case 3371:
                    return locale.equals("it") ? R.string.it : R.string.en_us;
                case 3383:
                    return locale.equals("ja") ? R.string.ja : R.string.en_us;
                case 3428:
                    return locale.equals("ko") ? R.string.ko : R.string.en_us;
                case 3464:
                    return locale.equals("lt") ? R.string.lt : R.string.en_us;
                case 3518:
                    return locale.equals("nl") ? R.string.nl : R.string.en_us;
                case 3521:
                    return locale.equals("no") ? R.string.no : R.string.en_us;
                case 3580:
                    return locale.equals("pl") ? R.string.pl : R.string.en_us;
                case 3645:
                    return locale.equals("ro") ? R.string.ro : R.string.en_us;
                case 3651:
                    return locale.equals("ru") ? R.string.ru : R.string.en_us;
                case 3700:
                    return locale.equals("th") ? R.string.th : R.string.en_us;
                case 3710:
                    return locale.equals("tr") ? R.string.tr : R.string.en_us;
                case 3734:
                    return locale.equals("uk") ? R.string.uk : R.string.en_us;
                case 3763:
                    return locale.equals("vi") ? R.string.vi : R.string.en_us;
                case 96598143:
                    return locale.equals("en-GB") ? R.string.en_gb : R.string.en_us;
                case 96598594:
                    locale.equals("en-US");
                    return R.string.en_us;
                case 96747053:
                    return locale.equals("es-ES") ? R.string.es_es : R.string.en_us;
                case 106935481:
                    return locale.equals("pt-BR") ? R.string.pt_br : R.string.en_us;
                case 109766140:
                    return locale.equals("sv-SE") ? R.string.sv_se : R.string.en_us;
                case 115813226:
                    return locale.equals("zh-CN") ? R.string.zh_cn : R.string.en_us;
                case 115813762:
                    return locale.equals("zh-TW") ? R.string.zh_tw : R.string.en_us;
                default:
                    return R.string.en_us;
            }
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsLanguage.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBound$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
        public static final class C03251 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ String $locale;

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBound$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
            public static final class C03261 extends Lambda implements Function1<ModelUserSettings, Unit> {
                public C03261() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
                    invoke2(modelUserSettings);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ModelUserSettings modelUserSettings) {
                    Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
                    AppToast.g(WidgetSettingsLanguage.this.requireContext(), R.string.language_updated, 0, null, 12);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03251(String str) {
                super(0);
                this.$locale = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithLocale(this.$locale)), false, 1, null), WidgetSettingsLanguage.this, null, 2, null), (Class<?>) StoreUserSettings.class, (58 & 2) != 0 ? null : WidgetSettingsLanguage.this.requireContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C03261());
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "locale");
            StoreStream.INSTANCE.getUserSettingsSystem().setLocale(str, true, new C03251(str));
            AppActivity appActivity = WidgetSettingsLanguage.this.getAppActivity();
            if (appActivity != null) {
                appActivity.recreate();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreUserSettingsSystem.Settings, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreUserSettingsSystem.Settings settings) {
            invoke2(settings);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreUserSettingsSystem.Settings settings) {
            Intrinsics3.checkNotNullParameter(settings, "settings");
            WidgetSettingsLanguage.this.configureUI(settings.getLocale());
        }
    }

    public WidgetSettingsLanguage() {
        super(R.layout.widget_settings_language);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsLanguage2.INSTANCE, null, 2, null);
    }

    private final void configureUI(String locale) {
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsLanguageCurrentText");
        Companion companion = INSTANCE;
        textView.setText(getString(companion.getLocaleResId(locale)));
        getBinding().c.setImageResource(companion.getLocaleFlagResId(locale));
    }

    private final WidgetSettingsLanguageBinding getBinding() {
        return (WidgetSettingsLanguageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.language);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        WidgetSettingsLanguageSelect.INSTANCE.registerForResult(this, new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion.getUserSettingsSystem().observeSettings(false), this, null, 2, null), (Class<?>) WidgetSettingsLanguage.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        CheckedSetting checkedSetting = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsLanguageSyncCheck");
        checkedSetting.setChecked(companion.getUserSettingsSystem().getIsLocaleSyncEnabled());
        getBinding().f.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsLanguage.onViewBoundOrOnResume.2
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettingsSystem userSettingsSystem = StoreStream.INSTANCE.getUserSettingsSystem();
                Intrinsics3.checkNotNullExpressionValue(bool, "checked");
                userSettingsSystem.setIsLocaleSyncEnabled(bool.booleanValue());
            }
        });
        getBinding().f2627b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsLanguage.onViewBoundOrOnResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsLanguageSelect.INSTANCE.show(WidgetSettingsLanguage.this);
            }
        });
        for (TextView textView : Collections2.listOf((Object[]) new TextView[]{getBinding().e, getBinding().g})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
