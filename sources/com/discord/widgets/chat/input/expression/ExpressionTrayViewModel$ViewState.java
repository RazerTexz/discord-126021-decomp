package com.discord.widgets.chat.input.expression;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ExpressionTrayViewModel$ViewState {
    private final ExpressionDetailPage expressionDetailPage;
    private final ExpressionTrayTab selectedExpressionTab;
    private final boolean showGifsAndStickers;
    private final boolean showLandingPage;
    private final boolean showSearchBar;
    private final boolean showStickersSearchBar;

    public ExpressionTrayViewModel$ViewState(ExpressionTrayTab expressionTrayTab, ExpressionDetailPage expressionDetailPage, boolean z2, boolean z3) {
        m.checkNotNullParameter(expressionTrayTab, "selectedExpressionTab");
        this.selectedExpressionTab = expressionTrayTab;
        this.expressionDetailPage = expressionDetailPage;
        this.showStickersSearchBar = z2;
        this.showGifsAndStickers = z3;
        this.showLandingPage = expressionDetailPage == null;
        int iOrdinal = expressionTrayTab.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            z2 = true;
        } else if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        this.showSearchBar = z2;
    }

    public static /* synthetic */ ExpressionTrayViewModel$ViewState copy$default(ExpressionTrayViewModel$ViewState expressionTrayViewModel$ViewState, ExpressionTrayTab expressionTrayTab, ExpressionDetailPage expressionDetailPage, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            expressionTrayTab = expressionTrayViewModel$ViewState.selectedExpressionTab;
        }
        if ((i & 2) != 0) {
            expressionDetailPage = expressionTrayViewModel$ViewState.expressionDetailPage;
        }
        if ((i & 4) != 0) {
            z2 = expressionTrayViewModel$ViewState.showStickersSearchBar;
        }
        if ((i & 8) != 0) {
            z3 = expressionTrayViewModel$ViewState.showGifsAndStickers;
        }
        return expressionTrayViewModel$ViewState.copy(expressionTrayTab, expressionDetailPage, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ExpressionTrayTab getSelectedExpressionTab() {
        return this.selectedExpressionTab;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ExpressionDetailPage getExpressionDetailPage() {
        return this.expressionDetailPage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowStickersSearchBar() {
        return this.showStickersSearchBar;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowGifsAndStickers() {
        return this.showGifsAndStickers;
    }

    public final ExpressionTrayViewModel$ViewState copy(ExpressionTrayTab selectedExpressionTab, ExpressionDetailPage expressionDetailPage, boolean showStickersSearchBar, boolean showGifsAndStickers) {
        m.checkNotNullParameter(selectedExpressionTab, "selectedExpressionTab");
        return new ExpressionTrayViewModel$ViewState(selectedExpressionTab, expressionDetailPage, showStickersSearchBar, showGifsAndStickers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpressionTrayViewModel$ViewState)) {
            return false;
        }
        ExpressionTrayViewModel$ViewState expressionTrayViewModel$ViewState = (ExpressionTrayViewModel$ViewState) other;
        return m.areEqual(this.selectedExpressionTab, expressionTrayViewModel$ViewState.selectedExpressionTab) && m.areEqual(this.expressionDetailPage, expressionTrayViewModel$ViewState.expressionDetailPage) && this.showStickersSearchBar == expressionTrayViewModel$ViewState.showStickersSearchBar && this.showGifsAndStickers == expressionTrayViewModel$ViewState.showGifsAndStickers;
    }

    public final ExpressionDetailPage getExpressionDetailPage() {
        return this.expressionDetailPage;
    }

    public final ExpressionTrayTab getSelectedExpressionTab() {
        return this.selectedExpressionTab;
    }

    public final boolean getShowGifsAndStickers() {
        return this.showGifsAndStickers;
    }

    public final boolean getShowLandingPage() {
        return this.showLandingPage;
    }

    public final boolean getShowSearchBar() {
        return this.showSearchBar;
    }

    public final boolean getShowStickersSearchBar() {
        return this.showStickersSearchBar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        ExpressionTrayTab expressionTrayTab = this.selectedExpressionTab;
        int iHashCode = (expressionTrayTab != null ? expressionTrayTab.hashCode() : 0) * 31;
        ExpressionDetailPage expressionDetailPage = this.expressionDetailPage;
        int iHashCode2 = (iHashCode + (expressionDetailPage != null ? expressionDetailPage.hashCode() : 0)) * 31;
        boolean z2 = this.showStickersSearchBar;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.showGifsAndStickers;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(selectedExpressionTab=");
        sbU.append(this.selectedExpressionTab);
        sbU.append(", expressionDetailPage=");
        sbU.append(this.expressionDetailPage);
        sbU.append(", showStickersSearchBar=");
        sbU.append(this.showStickersSearchBar);
        sbU.append(", showGifsAndStickers=");
        return a.O(sbU, this.showGifsAndStickers, ")");
    }

    public /* synthetic */ ExpressionTrayViewModel$ViewState(ExpressionTrayTab expressionTrayTab, ExpressionDetailPage expressionDetailPage, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(expressionTrayTab, (i & 2) != 0 ? null : expressionDetailPage, z2, z3);
    }
}
