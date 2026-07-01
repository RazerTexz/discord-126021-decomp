package com.discord.widgets.settings.account.mfa;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetEnableMFAViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetEnableMFAViewModel$ViewState {
    private final boolean isLoading;
    private final Integer screenIndex;

    public WidgetEnableMFAViewModel$ViewState() {
        this(false, null, 3, null);
    }

    public WidgetEnableMFAViewModel$ViewState(boolean z2, Integer num) {
        this.isLoading = z2;
        this.screenIndex = num;
    }

    public static /* synthetic */ WidgetEnableMFAViewModel$ViewState copy$default(WidgetEnableMFAViewModel$ViewState widgetEnableMFAViewModel$ViewState, boolean z2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetEnableMFAViewModel$ViewState.isLoading;
        }
        if ((i & 2) != 0) {
            num = widgetEnableMFAViewModel$ViewState.screenIndex;
        }
        return widgetEnableMFAViewModel$ViewState.copy(z2, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getScreenIndex() {
        return this.screenIndex;
    }

    public final WidgetEnableMFAViewModel$ViewState copy(boolean isLoading, Integer screenIndex) {
        return new WidgetEnableMFAViewModel$ViewState(isLoading, screenIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetEnableMFAViewModel$ViewState)) {
            return false;
        }
        WidgetEnableMFAViewModel$ViewState widgetEnableMFAViewModel$ViewState = (WidgetEnableMFAViewModel$ViewState) other;
        return this.isLoading == widgetEnableMFAViewModel$ViewState.isLoading && m.areEqual(this.screenIndex, widgetEnableMFAViewModel$ViewState.screenIndex);
    }

    public final Integer getScreenIndex() {
        return this.screenIndex;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.isLoading;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        Integer num = this.screenIndex;
        return i + (num != null ? num.hashCode() : 0);
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(isLoading=");
        sbU.append(this.isLoading);
        sbU.append(", screenIndex=");
        return a.F(sbU, this.screenIndex, ")");
    }

    public /* synthetic */ WidgetEnableMFAViewModel$ViewState(boolean z2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : num);
    }
}
