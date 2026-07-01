package com.discord.widgets.user.search;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGlobalSearchModel$MatchedResult {
    private final int filterLength;
    private final int firstMatchIndex;
    private final CharSequence value;

    public WidgetGlobalSearchModel$MatchedResult(CharSequence charSequence, int i, int i2) {
        m.checkNotNullParameter(charSequence, "value");
        this.value = charSequence;
        this.firstMatchIndex = i;
        this.filterLength = i2;
    }

    public static /* synthetic */ WidgetGlobalSearchModel$MatchedResult copy$default(WidgetGlobalSearchModel$MatchedResult widgetGlobalSearchModel$MatchedResult, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = widgetGlobalSearchModel$MatchedResult.value;
        }
        if ((i3 & 2) != 0) {
            i = widgetGlobalSearchModel$MatchedResult.firstMatchIndex;
        }
        if ((i3 & 4) != 0) {
            i2 = widgetGlobalSearchModel$MatchedResult.filterLength;
        }
        return widgetGlobalSearchModel$MatchedResult.copy(charSequence, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CharSequence getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFirstMatchIndex() {
        return this.firstMatchIndex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFilterLength() {
        return this.filterLength;
    }

    public final WidgetGlobalSearchModel$MatchedResult copy(CharSequence value, int firstMatchIndex, int filterLength) {
        m.checkNotNullParameter(value, "value");
        return new WidgetGlobalSearchModel$MatchedResult(value, firstMatchIndex, filterLength);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalSearchModel$MatchedResult)) {
            return false;
        }
        WidgetGlobalSearchModel$MatchedResult widgetGlobalSearchModel$MatchedResult = (WidgetGlobalSearchModel$MatchedResult) other;
        return m.areEqual(this.value, widgetGlobalSearchModel$MatchedResult.value) && this.firstMatchIndex == widgetGlobalSearchModel$MatchedResult.firstMatchIndex && this.filterLength == widgetGlobalSearchModel$MatchedResult.filterLength;
    }

    public final int getFilterLength() {
        return this.filterLength;
    }

    public final int getFirstMatchIndex() {
        return this.firstMatchIndex;
    }

    public final CharSequence getValue() {
        return this.value;
    }

    public int hashCode() {
        CharSequence charSequence = this.value;
        return ((((charSequence != null ? charSequence.hashCode() : 0) * 31) + this.firstMatchIndex) * 31) + this.filterLength;
    }

    public String toString() {
        StringBuilder sbU = a.U("MatchedResult(value=");
        sbU.append(this.value);
        sbU.append(", firstMatchIndex=");
        sbU.append(this.firstMatchIndex);
        sbU.append(", filterLength=");
        return a.B(sbU, this.filterLength, ")");
    }
}
