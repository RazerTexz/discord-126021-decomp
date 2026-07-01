package com.discord.widgets.settings;

import d0.t.n;
import d0.t.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguageSelect$Model {
    public static final WidgetSettingsLanguageSelect$Model INSTANCE = new WidgetSettingsLanguageSelect$Model();

    private WidgetSettingsLanguageSelect$Model() {
    }

    public final List<WidgetSettingsLanguageSelect$Model$Item> getLocales() {
        List listListOf = n.listOf((Object[]) new String[]{"da", "de", "en-GB", "en-US", "es-ES", "fr", "hr", "it", "lt", "hu", "nl", "no", "pl", "pt-BR", "ro", "fi", "sv-SE", "vi", "tr", "cs", "el", "bg", "ru", "uk", "ja", "zh-TW", "th", "zh-CN", "ko", "hi"});
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listListOf, 10));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(new WidgetSettingsLanguageSelect$Model$Item((String) it.next()));
        }
        return arrayList;
    }
}
