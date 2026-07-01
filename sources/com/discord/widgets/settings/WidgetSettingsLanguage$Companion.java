package com.discord.widgets.settings;

import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguage$Companion {
    private WidgetSettingsLanguage$Companion() {
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
            return 2131232276;
        }
        switch (locale.hashCode()) {
            case 3141:
                return locale.equals("bg") ? 2131232270 : 2131232276;
            case 3184:
                return locale.equals("cs") ? 2131232271 : 2131232276;
            case 3197:
                return locale.equals("da") ? 2131232272 : 2131232276;
            case 3201:
                return locale.equals("de") ? 2131232273 : 2131232276;
            case 3239:
                return locale.equals("el") ? 2131232274 : 2131232276;
            case 3267:
                return locale.equals("fi") ? 2131232279 : 2131232276;
            case 3276:
                return locale.equals("fr") ? 2131232280 : 2131232276;
            case 3329:
                return locale.equals("hi") ? 2131232282 : 2131232276;
            case 3338:
                return locale.equals("hr") ? 2131232284 : 2131232276;
            case 3341:
                return locale.equals("hu") ? 2131232285 : 2131232276;
            case 3371:
                return locale.equals("it") ? 2131232286 : 2131232276;
            case 3383:
                return locale.equals("ja") ? 2131232287 : 2131232276;
            case 3428:
                return locale.equals("ko") ? 2131232288 : 2131232276;
            case 3464:
                return locale.equals("lt") ? 2131232289 : 2131232276;
            case 3518:
                return locale.equals("nl") ? 2131232290 : 2131232276;
            case 3521:
                return locale.equals("no") ? 2131232291 : 2131232276;
            case 3580:
                return locale.equals("pl") ? 2131232292 : 2131232276;
            case 3645:
                return locale.equals("ro") ? 2131232294 : 2131232276;
            case 3651:
                return locale.equals("ru") ? 2131232295 : 2131232276;
            case 3700:
                return locale.equals("th") ? 2131232298 : 2131232276;
            case 3710:
                return locale.equals("tr") ? 2131232299 : 2131232276;
            case 3734:
                return locale.equals("uk") ? 2131232300 : 2131232276;
            case 3763:
                return locale.equals("vi") ? 2131232302 : 2131232276;
            case 96598143:
                return locale.equals("en-GB") ? 2131232275 : 2131232276;
            case 96598594:
                locale.equals("en-US");
                return 2131232276;
            case 96747053:
                return locale.equals("es-ES") ? 2131232277 : 2131232276;
            case 106935481:
                return locale.equals("pt-BR") ? 2131232293 : 2131232276;
            case 109766140:
                return locale.equals("sv-SE") ? 2131232297 : 2131232276;
            case 115813226:
                return locale.equals("zh-CN") ? 2131232303 : 2131232276;
            case 115813762:
                return locale.equals("zh-TW") ? 2131232304 : 2131232276;
            default:
                return 2131232276;
        }
    }

    @StringRes
    public final int getLocaleResId(String locale) {
        if (locale == null) {
            return 2131888823;
        }
        switch (locale.hashCode()) {
            case 3141:
                return locale.equals("bg") ? 2131887027 : 2131888823;
            case 3184:
                return locale.equals("cs") ? 2131888291 : 2131888823;
            case 3197:
                return locale.equals("da") ? 2131888322 : 2131888823;
            case 3201:
                return locale.equals("de") ? 2131888354 : 2131888823;
            case 3239:
                return locale.equals("el") ? 2131888650 : 2131888823;
            case 3267:
                return locale.equals("fi") ? 2131889020 : 2131888823;
            case 3276:
                return locale.equals("fr") ? 2131889435 : 2131888823;
            case 3329:
                return locale.equals("hi") ? 2131891711 : 2131888823;
            case 3338:
                return locale.equals("hr") ? 2131891733 : 2131888823;
            case 3341:
                return locale.equals("hu") ? 2131891734 : 2131888823;
            case 3371:
                return locale.equals("it") ? 2131892375 : 2131888823;
            case 3383:
                return locale.equals("ja") ? 2131892377 : 2131888823;
            case 3428:
                return locale.equals("ko") ? 2131892505 : 2131888823;
            case 3464:
                return locale.equals("lt") ? 2131892657 : 2131888823;
            case 3518:
                return locale.equals("nl") ? 2131893232 : 2131888823;
            case 3521:
                return locale.equals("no") ? 2131893233 : 2131888823;
            case 3580:
                return locale.equals("pl") ? 2131893821 : 2131888823;
            case 3645:
                return locale.equals("ro") ? 2131894852 : 2131888823;
            case 3651:
                return locale.equals("ru") ? 2131895185 : 2131888823;
            case 3700:
                return locale.equals("th") ? 2131896325 : 2131888823;
            case 3710:
                return locale.equals("tr") ? 2131896466 : 2131888823;
            case 3734:
                return locale.equals("uk") ? 2131896557 : 2131888823;
            case 3763:
                return locale.equals("vi") ? 2131897077 : 2131888823;
            case 96598143:
                return locale.equals("en-GB") ? 2131888822 : 2131888823;
            case 96598594:
                locale.equals("en-US");
                return 2131888823;
            case 96747053:
                return locale.equals("es-ES") ? 2131888892 : 2131888823;
            case 106935481:
                return locale.equals("pt-BR") ? 2131894611 : 2131888823;
            case 109766140:
                return locale.equals("sv-SE") ? 2131896123 : 2131888823;
            case 115813226:
                return locale.equals("zh-CN") ? 2131897281 : 2131888823;
            case 115813762:
                return locale.equals("zh-TW") ? 2131897282 : 2131888823;
            default:
                return 2131888823;
        }
    }

    public final void launch(Context context) {
        m.checkNotNullParameter(context, "context");
        j.e(context, WidgetSettingsLanguage.class, null, 4);
    }

    public /* synthetic */ WidgetSettingsLanguage$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
