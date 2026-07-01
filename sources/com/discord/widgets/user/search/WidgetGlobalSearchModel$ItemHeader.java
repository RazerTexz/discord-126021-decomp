package com.discord.widgets.user.search;

import androidx.annotation.StringRes;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGlobalSearchModel$ItemHeader implements WidgetGlobalSearchModel$ItemDataPayload {
    private final Channel channel;
    private final String key;
    private final WidgetGlobalSearchModel$MatchedResult matchedResult;
    private final int mentions;
    private final int name;
    private final int type;
    private final boolean unread;

    public WidgetGlobalSearchModel$ItemHeader(@StringRes int i, int i2, boolean z2) {
        this.name = i;
        this.mentions = i2;
        this.unread = z2;
        this.matchedResult = WidgetGlobalSearchModel.Companion.getEMPTY_MATCH_RESULT();
        this.type = -1;
        this.key = a.q("header", i);
    }

    public static /* synthetic */ WidgetGlobalSearchModel$ItemHeader copy$default(WidgetGlobalSearchModel$ItemHeader widgetGlobalSearchModel$ItemHeader, int i, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = widgetGlobalSearchModel$ItemHeader.name;
        }
        if ((i3 & 2) != 0) {
            i2 = widgetGlobalSearchModel$ItemHeader.getMentions();
        }
        if ((i3 & 4) != 0) {
            z2 = widgetGlobalSearchModel$ItemHeader.getUnread();
        }
        return widgetGlobalSearchModel$ItemHeader.copy(i, i2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getName() {
        return this.name;
    }

    public final int component2() {
        return getMentions();
    }

    public final boolean component3() {
        return getUnread();
    }

    public final WidgetGlobalSearchModel$ItemHeader copy(@StringRes int name, int mentions, boolean unread) {
        return new WidgetGlobalSearchModel$ItemHeader(name, mentions, unread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalSearchModel$ItemHeader)) {
            return false;
        }
        WidgetGlobalSearchModel$ItemHeader widgetGlobalSearchModel$ItemHeader = (WidgetGlobalSearchModel$ItemHeader) other;
        return this.name == widgetGlobalSearchModel$ItemHeader.name && getMentions() == widgetGlobalSearchModel$ItemHeader.getMentions() && getUnread() == widgetGlobalSearchModel$ItemHeader.getUnread();
    }

    @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload
    public Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload
    public WidgetGlobalSearchModel$MatchedResult getMatchedResult() {
        return this.matchedResult;
    }

    @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload
    public int getMentions() {
        return this.mentions;
    }

    public final int getName() {
        return this.name;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload
    public boolean getUnread() {
        return this.unread;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    public int hashCode() {
        int mentions = (getMentions() + (this.name * 31)) * 31;
        boolean unread = getUnread();
        ?? r0 = unread;
        if (unread) {
            r0 = 1;
        }
        return mentions + r0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ItemHeader(name=");
        sbU.append(this.name);
        sbU.append(", mentions=");
        sbU.append(getMentions());
        sbU.append(", unread=");
        sbU.append(getUnread());
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetGlobalSearchModel$ItemHeader(int i, int i2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z2);
    }
}
