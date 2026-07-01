package com.discord.widgets.user;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$WidgetUserMentionFilter$Companion {
    private WidgetUserMentions$WidgetUserMentionFilter$Companion() {
    }

    public final WidgetUserMentions$WidgetUserMentionFilter show(FragmentManager fragmentManager, String guildName, WidgetUserMentions$Model$MessageLoader$Filters filters, Function1<? super WidgetUserMentions$Model$MessageLoader$Filters, Unit> onFiltersUpdated) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(filters, "filters");
        m.checkNotNullParameter(onFiltersUpdated, "onFiltersUpdated");
        WidgetUserMentions$WidgetUserMentionFilter widgetUserMentions$WidgetUserMentionFilter = new WidgetUserMentions$WidgetUserMentionFilter();
        WidgetUserMentions$WidgetUserMentionFilter.access$setOnFiltersUpdated$p(widgetUserMentions$WidgetUserMentionFilter, onFiltersUpdated);
        WidgetUserMentions$WidgetUserMentionFilter.access$setFilters$p(widgetUserMentions$WidgetUserMentionFilter, filters);
        WidgetUserMentions$WidgetUserMentionFilter.access$setGuildName$p(widgetUserMentions$WidgetUserMentionFilter, guildName);
        widgetUserMentions$WidgetUserMentionFilter.show(fragmentManager, WidgetUserMentions$WidgetUserMentionFilter.class.getName());
        return widgetUserMentions$WidgetUserMentionFilter;
    }

    public /* synthetic */ WidgetUserMentions$WidgetUserMentionFilter$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
