package com.discord.widgets.guilds.profile;

import b.d.b.a.a;
import com.discord.models.domain.emoji.Emoji;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildProfileSheetViewModel$EmojisData {
    private final List<Emoji> emojis;
    private final boolean isExpanded;
    private final boolean isPremium;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGuildProfileSheetViewModel$EmojisData(boolean z2, boolean z3, List<? extends Emoji> list) {
        m.checkNotNullParameter(list, "emojis");
        this.isPremium = z2;
        this.isExpanded = z3;
        this.emojis = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGuildProfileSheetViewModel$EmojisData copy$default(WidgetGuildProfileSheetViewModel$EmojisData widgetGuildProfileSheetViewModel$EmojisData, boolean z2, boolean z3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetGuildProfileSheetViewModel$EmojisData.isPremium;
        }
        if ((i & 2) != 0) {
            z3 = widgetGuildProfileSheetViewModel$EmojisData.isExpanded;
        }
        if ((i & 4) != 0) {
            list = widgetGuildProfileSheetViewModel$EmojisData.emojis;
        }
        return widgetGuildProfileSheetViewModel$EmojisData.copy(z2, z3, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsPremium() {
        return this.isPremium;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsExpanded() {
        return this.isExpanded;
    }

    public final List<Emoji> component3() {
        return this.emojis;
    }

    public final WidgetGuildProfileSheetViewModel$EmojisData copy(boolean isPremium, boolean isExpanded, List<? extends Emoji> emojis) {
        m.checkNotNullParameter(emojis, "emojis");
        return new WidgetGuildProfileSheetViewModel$EmojisData(isPremium, isExpanded, emojis);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildProfileSheetViewModel$EmojisData)) {
            return false;
        }
        WidgetGuildProfileSheetViewModel$EmojisData widgetGuildProfileSheetViewModel$EmojisData = (WidgetGuildProfileSheetViewModel$EmojisData) other;
        return this.isPremium == widgetGuildProfileSheetViewModel$EmojisData.isPremium && this.isExpanded == widgetGuildProfileSheetViewModel$EmojisData.isExpanded && m.areEqual(this.emojis, widgetGuildProfileSheetViewModel$EmojisData.emojis);
    }

    public final List<Emoji> getEmojis() {
        return this.emojis;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        boolean z2 = this.isPremium;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.isExpanded;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        List<Emoji> list = this.emojis;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public final boolean isExpanded() {
        return this.isExpanded;
    }

    public final boolean isPremium() {
        return this.isPremium;
    }

    public String toString() {
        StringBuilder sbU = a.U("EmojisData(isPremium=");
        sbU.append(this.isPremium);
        sbU.append(", isExpanded=");
        sbU.append(this.isExpanded);
        sbU.append(", emojis=");
        return a.L(sbU, this.emojis, ")");
    }
}
