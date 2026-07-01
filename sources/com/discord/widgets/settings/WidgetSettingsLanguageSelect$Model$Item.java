package com.discord.widgets.settings;

import b.d.b.a.a;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsLanguageSelect$Model$Item implements MGRecyclerDataPayload {
    private final String key;
    private final String locale;
    private final int type;

    public WidgetSettingsLanguageSelect$Model$Item(String str) {
        m.checkNotNullParameter(str, "locale");
        this.locale = str;
        this.key = str;
    }

    public static /* synthetic */ WidgetSettingsLanguageSelect$Model$Item copy$default(WidgetSettingsLanguageSelect$Model$Item widgetSettingsLanguageSelect$Model$Item, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetSettingsLanguageSelect$Model$Item.locale;
        }
        return widgetSettingsLanguageSelect$Model$Item.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLocale() {
        return this.locale;
    }

    public final WidgetSettingsLanguageSelect$Model$Item copy(String locale) {
        m.checkNotNullParameter(locale, "locale");
        return new WidgetSettingsLanguageSelect$Model$Item(locale);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetSettingsLanguageSelect$Model$Item) && m.areEqual(this.locale, ((WidgetSettingsLanguageSelect$Model$Item) other).locale);
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getLocale() {
        return this.locale;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.locale;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("Item(locale="), this.locale, ")");
    }
}
