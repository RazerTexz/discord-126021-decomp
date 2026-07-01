package com.discord.widgets.chat.input.expression;

import b.d.b.a.a;
import com.discord.api.sticker.Sticker;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ExpressionTrayViewModel$StoreState {
    private final Long guildId;
    private final Map<Long, Map<Long, Sticker>> guildStickers;
    private final boolean isThreadDraft;
    private final MeUser meUser;
    private final ExpressionTrayTab selectedExpressionTab;
    private final Set<Long> userGuildIds;

    /* JADX WARN: Multi-variable type inference failed */
    public ExpressionTrayViewModel$StoreState(ExpressionTrayTab expressionTrayTab, Long l, MeUser meUser, Map<Long, ? extends Map<Long, Sticker>> map, Set<Long> set, boolean z2) {
        m.checkNotNullParameter(expressionTrayTab, "selectedExpressionTab");
        m.checkNotNullParameter(map, "guildStickers");
        m.checkNotNullParameter(set, "userGuildIds");
        this.selectedExpressionTab = expressionTrayTab;
        this.guildId = l;
        this.meUser = meUser;
        this.guildStickers = map;
        this.userGuildIds = set;
        this.isThreadDraft = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExpressionTrayViewModel$StoreState copy$default(ExpressionTrayViewModel$StoreState expressionTrayViewModel$StoreState, ExpressionTrayTab expressionTrayTab, Long l, MeUser meUser, Map map, Set set, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            expressionTrayTab = expressionTrayViewModel$StoreState.selectedExpressionTab;
        }
        if ((i & 2) != 0) {
            l = expressionTrayViewModel$StoreState.guildId;
        }
        Long l2 = l;
        if ((i & 4) != 0) {
            meUser = expressionTrayViewModel$StoreState.meUser;
        }
        MeUser meUser2 = meUser;
        if ((i & 8) != 0) {
            map = expressionTrayViewModel$StoreState.guildStickers;
        }
        Map map2 = map;
        if ((i & 16) != 0) {
            set = expressionTrayViewModel$StoreState.userGuildIds;
        }
        Set set2 = set;
        if ((i & 32) != 0) {
            z2 = expressionTrayViewModel$StoreState.isThreadDraft;
        }
        return expressionTrayViewModel$StoreState.copy(expressionTrayTab, l2, meUser2, map2, set2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ExpressionTrayTab getSelectedExpressionTab() {
        return this.selectedExpressionTab;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final Map<Long, Map<Long, Sticker>> component4() {
        return this.guildStickers;
    }

    public final Set<Long> component5() {
        return this.userGuildIds;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsThreadDraft() {
        return this.isThreadDraft;
    }

    public final ExpressionTrayViewModel$StoreState copy(ExpressionTrayTab selectedExpressionTab, Long guildId, MeUser meUser, Map<Long, ? extends Map<Long, Sticker>> guildStickers, Set<Long> userGuildIds, boolean isThreadDraft) {
        m.checkNotNullParameter(selectedExpressionTab, "selectedExpressionTab");
        m.checkNotNullParameter(guildStickers, "guildStickers");
        m.checkNotNullParameter(userGuildIds, "userGuildIds");
        return new ExpressionTrayViewModel$StoreState(selectedExpressionTab, guildId, meUser, guildStickers, userGuildIds, isThreadDraft);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpressionTrayViewModel$StoreState)) {
            return false;
        }
        ExpressionTrayViewModel$StoreState expressionTrayViewModel$StoreState = (ExpressionTrayViewModel$StoreState) other;
        return m.areEqual(this.selectedExpressionTab, expressionTrayViewModel$StoreState.selectedExpressionTab) && m.areEqual(this.guildId, expressionTrayViewModel$StoreState.guildId) && m.areEqual(this.meUser, expressionTrayViewModel$StoreState.meUser) && m.areEqual(this.guildStickers, expressionTrayViewModel$StoreState.guildStickers) && m.areEqual(this.userGuildIds, expressionTrayViewModel$StoreState.userGuildIds) && this.isThreadDraft == expressionTrayViewModel$StoreState.isThreadDraft;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final Map<Long, Map<Long, Sticker>> getGuildStickers() {
        return this.guildStickers;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final ExpressionTrayTab getSelectedExpressionTab() {
        return this.selectedExpressionTab;
    }

    public final Set<Long> getUserGuildIds() {
        return this.userGuildIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        ExpressionTrayTab expressionTrayTab = this.selectedExpressionTab;
        int iHashCode = (expressionTrayTab != null ? expressionTrayTab.hashCode() : 0) * 31;
        Long l = this.guildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        MeUser meUser = this.meUser;
        int iHashCode3 = (iHashCode2 + (meUser != null ? meUser.hashCode() : 0)) * 31;
        Map<Long, Map<Long, Sticker>> map = this.guildStickers;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        Set<Long> set = this.userGuildIds;
        int iHashCode5 = (iHashCode4 + (set != null ? set.hashCode() : 0)) * 31;
        boolean z2 = this.isThreadDraft;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode5 + r1;
    }

    public final boolean isThreadDraft() {
        return this.isThreadDraft;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(selectedExpressionTab=");
        sbU.append(this.selectedExpressionTab);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", meUser=");
        sbU.append(this.meUser);
        sbU.append(", guildStickers=");
        sbU.append(this.guildStickers);
        sbU.append(", userGuildIds=");
        sbU.append(this.userGuildIds);
        sbU.append(", isThreadDraft=");
        return a.O(sbU, this.isThreadDraft, ")");
    }

    public /* synthetic */ ExpressionTrayViewModel$StoreState(ExpressionTrayTab expressionTrayTab, Long l, MeUser meUser, Map map, Set set, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(expressionTrayTab, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : meUser, map, set, z2);
    }
}
