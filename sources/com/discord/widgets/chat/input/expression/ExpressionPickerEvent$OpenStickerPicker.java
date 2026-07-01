package com.discord.widgets.chat.input.expression;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ExpressionPickerEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ExpressionPickerEvent$OpenStickerPicker extends ExpressionPickerEvent {
    private final boolean inline;
    private final String searchText;
    private final Long stickerPackId;

    public ExpressionPickerEvent$OpenStickerPicker() {
        this(null, null, false, 7, null);
    }

    public /* synthetic */ ExpressionPickerEvent$OpenStickerPicker(Long l, String str, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z2);
    }

    public static /* synthetic */ ExpressionPickerEvent$OpenStickerPicker copy$default(ExpressionPickerEvent$OpenStickerPicker expressionPickerEvent$OpenStickerPicker, Long l, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = expressionPickerEvent$OpenStickerPicker.stickerPackId;
        }
        if ((i & 2) != 0) {
            str = expressionPickerEvent$OpenStickerPicker.searchText;
        }
        if ((i & 4) != 0) {
            z2 = expressionPickerEvent$OpenStickerPicker.inline;
        }
        return expressionPickerEvent$OpenStickerPicker.copy(l, str, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getStickerPackId() {
        return this.stickerPackId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSearchText() {
        return this.searchText;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getInline() {
        return this.inline;
    }

    public final ExpressionPickerEvent$OpenStickerPicker copy(Long stickerPackId, String searchText, boolean inline) {
        return new ExpressionPickerEvent$OpenStickerPicker(stickerPackId, searchText, inline);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpressionPickerEvent$OpenStickerPicker)) {
            return false;
        }
        ExpressionPickerEvent$OpenStickerPicker expressionPickerEvent$OpenStickerPicker = (ExpressionPickerEvent$OpenStickerPicker) other;
        return m.areEqual(this.stickerPackId, expressionPickerEvent$OpenStickerPicker.stickerPackId) && m.areEqual(this.searchText, expressionPickerEvent$OpenStickerPicker.searchText) && this.inline == expressionPickerEvent$OpenStickerPicker.inline;
    }

    public final boolean getInline() {
        return this.inline;
    }

    public final String getSearchText() {
        return this.searchText;
    }

    public final Long getStickerPackId() {
        return this.stickerPackId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Long l = this.stickerPackId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.searchText;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.inline;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("OpenStickerPicker(stickerPackId=");
        sbU.append(this.stickerPackId);
        sbU.append(", searchText=");
        sbU.append(this.searchText);
        sbU.append(", inline=");
        return a.O(sbU, this.inline, ")");
    }

    public ExpressionPickerEvent$OpenStickerPicker(Long l, String str, boolean z2) {
        super(null);
        this.stickerPackId = l;
        this.searchText = str;
        this.inline = z2;
    }
}
