package com.discord.widgets.chat.input.expression;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ExpressionTrayViewModel$Event$ShowStickerPicker extends ExpressionTrayViewModel$Event {
    private final boolean inline;
    private final String searchText;
    private final Long stickerPackId;

    public /* synthetic */ ExpressionTrayViewModel$Event$ShowStickerPicker(Long l, String str, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, str, (i & 4) != 0 ? false : z2);
    }

    public static /* synthetic */ ExpressionTrayViewModel$Event$ShowStickerPicker copy$default(ExpressionTrayViewModel$Event$ShowStickerPicker expressionTrayViewModel$Event$ShowStickerPicker, Long l, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = expressionTrayViewModel$Event$ShowStickerPicker.stickerPackId;
        }
        if ((i & 2) != 0) {
            str = expressionTrayViewModel$Event$ShowStickerPicker.searchText;
        }
        if ((i & 4) != 0) {
            z2 = expressionTrayViewModel$Event$ShowStickerPicker.inline;
        }
        return expressionTrayViewModel$Event$ShowStickerPicker.copy(l, str, z2);
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

    public final ExpressionTrayViewModel$Event$ShowStickerPicker copy(Long stickerPackId, String searchText, boolean inline) {
        return new ExpressionTrayViewModel$Event$ShowStickerPicker(stickerPackId, searchText, inline);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpressionTrayViewModel$Event$ShowStickerPicker)) {
            return false;
        }
        ExpressionTrayViewModel$Event$ShowStickerPicker expressionTrayViewModel$Event$ShowStickerPicker = (ExpressionTrayViewModel$Event$ShowStickerPicker) other;
        return m.areEqual(this.stickerPackId, expressionTrayViewModel$Event$ShowStickerPicker.stickerPackId) && m.areEqual(this.searchText, expressionTrayViewModel$Event$ShowStickerPicker.searchText) && this.inline == expressionTrayViewModel$Event$ShowStickerPicker.inline;
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
        StringBuilder sbU = a.U("ShowStickerPicker(stickerPackId=");
        sbU.append(this.stickerPackId);
        sbU.append(", searchText=");
        sbU.append(this.searchText);
        sbU.append(", inline=");
        return a.O(sbU, this.inline, ")");
    }

    public ExpressionTrayViewModel$Event$ShowStickerPicker(Long l, String str, boolean z2) {
        super(null);
        this.stickerPackId = l;
        this.searchText = str;
        this.inline = z2;
    }
}
