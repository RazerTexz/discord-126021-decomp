package com.discord.widgets.user.search;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGlobalSearchModel {
    public static final WidgetGlobalSearchModel$Companion Companion = new WidgetGlobalSearchModel$Companion(null);
    private static final Function2<Channel, Map<Long, Long>, Boolean> DEFAULT_PERMISSIONS_PREDICATE;
    private static final Pattern DISCRIMINATOR_PATTERN;
    private static final int MAX_RESULTS = 50;
    public static final int SEARCH_TYPE_GENERAL = 0;
    public static final int SEARCH_TYPE_GUILD = 3;
    public static final int SEARCH_TYPE_TEXT_CHANNEL = 2;
    public static final int SEARCH_TYPE_USER = 1;
    public static final int SEARCH_TYPE_VOICE_CHANNEL = 4;
    public static final int TYPE_CHANNEL = 0;
    public static final int TYPE_GUILD = 2;
    public static final int TYPE_HEADER = -1;
    public static final int TYPE_USER = 1;
    private final List<WidgetGlobalSearchModel$ItemDataPayload> data;
    private final String filter;
    private final List<WidgetGlobalSearchGuildsModel$Item> guildsList;
    private final int searchType;

    static {
        Pattern patternCompile = Pattern.compile("[^\\s]#\\d{0,4}$", 0);
        m.checkNotNullExpressionValue(patternCompile, "java.util.regex.Pattern.compile(this, flags)");
        DISCRIMINATOR_PATTERN = patternCompile;
        DEFAULT_PERMISSIONS_PREDICATE = WidgetGlobalSearchModel$Companion$DEFAULT_PERMISSIONS_PREDICATE$1.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGlobalSearchModel(String str, int i, List<? extends WidgetGlobalSearchModel$ItemDataPayload> list, List<WidgetGlobalSearchGuildsModel$Item> list2) {
        m.checkNotNullParameter(str, "filter");
        m.checkNotNullParameter(list, "data");
        this.filter = str;
        this.searchType = i;
        this.data = list;
        this.guildsList = list2;
    }

    public static final /* synthetic */ Function2 access$getDEFAULT_PERMISSIONS_PREDICATE$cp() {
        return DEFAULT_PERMISSIONS_PREDICATE;
    }

    public static final /* synthetic */ Pattern access$getDISCRIMINATOR_PATTERN$cp() {
        return DISCRIMINATOR_PATTERN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGlobalSearchModel copy$default(WidgetGlobalSearchModel widgetGlobalSearchModel, String str, int i, List list, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = widgetGlobalSearchModel.filter;
        }
        if ((i2 & 2) != 0) {
            i = widgetGlobalSearchModel.searchType;
        }
        if ((i2 & 4) != 0) {
            list = widgetGlobalSearchModel.data;
        }
        if ((i2 & 8) != 0) {
            list2 = widgetGlobalSearchModel.guildsList;
        }
        return widgetGlobalSearchModel.copy(str, i, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFilter() {
        return this.filter;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSearchType() {
        return this.searchType;
    }

    public final List<WidgetGlobalSearchModel$ItemDataPayload> component3() {
        return this.data;
    }

    public final List<WidgetGlobalSearchGuildsModel$Item> component4() {
        return this.guildsList;
    }

    public final WidgetGlobalSearchModel copy(String filter, int searchType, List<? extends WidgetGlobalSearchModel$ItemDataPayload> data, List<WidgetGlobalSearchGuildsModel$Item> guildsList) {
        m.checkNotNullParameter(filter, "filter");
        m.checkNotNullParameter(data, "data");
        return new WidgetGlobalSearchModel(filter, searchType, data, guildsList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalSearchModel)) {
            return false;
        }
        WidgetGlobalSearchModel widgetGlobalSearchModel = (WidgetGlobalSearchModel) other;
        return m.areEqual(this.filter, widgetGlobalSearchModel.filter) && this.searchType == widgetGlobalSearchModel.searchType && m.areEqual(this.data, widgetGlobalSearchModel.data) && m.areEqual(this.guildsList, widgetGlobalSearchModel.guildsList);
    }

    public final List<WidgetGlobalSearchModel$ItemDataPayload> getData() {
        return this.data;
    }

    public final String getFilter() {
        return this.filter;
    }

    public final List<WidgetGlobalSearchGuildsModel$Item> getGuildsList() {
        return this.guildsList;
    }

    public final int getSearchType() {
        return this.searchType;
    }

    public int hashCode() {
        String str = this.filter;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.searchType) * 31;
        List<WidgetGlobalSearchModel$ItemDataPayload> list = this.data;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<WidgetGlobalSearchGuildsModel$Item> list2 = this.guildsList;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("WidgetGlobalSearchModel(filter=");
        sbU.append(this.filter);
        sbU.append(", searchType=");
        sbU.append(this.searchType);
        sbU.append(", data=");
        sbU.append(this.data);
        sbU.append(", guildsList=");
        return a.L(sbU, this.guildsList, ")");
    }

    public /* synthetic */ WidgetGlobalSearchModel(String str, int i, List list, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, list, (i2 & 8) != 0 ? null : list2);
    }
}
