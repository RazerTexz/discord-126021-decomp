package com.discord.widgets.emoji;

import b.d.b.a.a;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import d0.z.d.m;

/* JADX INFO: compiled from: EmojiSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiSheetViewModel$ViewState$EmojiUnicode extends EmojiSheetViewModel$ViewState {
    private final boolean canFavorite;
    private final ModelEmojiUnicode emojiUnicode;
    private final boolean isFavorite;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiSheetViewModel$ViewState$EmojiUnicode(ModelEmojiUnicode modelEmojiUnicode, boolean z2, boolean z3) {
        super(null);
        m.checkNotNullParameter(modelEmojiUnicode, "emojiUnicode");
        this.emojiUnicode = modelEmojiUnicode;
        this.canFavorite = z2;
        this.isFavorite = z3;
    }

    public static /* synthetic */ EmojiSheetViewModel$ViewState$EmojiUnicode copy$default(EmojiSheetViewModel$ViewState$EmojiUnicode emojiSheetViewModel$ViewState$EmojiUnicode, ModelEmojiUnicode modelEmojiUnicode, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            modelEmojiUnicode = emojiSheetViewModel$ViewState$EmojiUnicode.emojiUnicode;
        }
        if ((i & 2) != 0) {
            z2 = emojiSheetViewModel$ViewState$EmojiUnicode.canFavorite;
        }
        if ((i & 4) != 0) {
            z3 = emojiSheetViewModel$ViewState$EmojiUnicode.isFavorite;
        }
        return emojiSheetViewModel$ViewState$EmojiUnicode.copy(modelEmojiUnicode, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelEmojiUnicode getEmojiUnicode() {
        return this.emojiUnicode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanFavorite() {
        return this.canFavorite;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsFavorite() {
        return this.isFavorite;
    }

    public final EmojiSheetViewModel$ViewState$EmojiUnicode copy(ModelEmojiUnicode emojiUnicode, boolean canFavorite, boolean isFavorite) {
        m.checkNotNullParameter(emojiUnicode, "emojiUnicode");
        return new EmojiSheetViewModel$ViewState$EmojiUnicode(emojiUnicode, canFavorite, isFavorite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiSheetViewModel$ViewState$EmojiUnicode)) {
            return false;
        }
        EmojiSheetViewModel$ViewState$EmojiUnicode emojiSheetViewModel$ViewState$EmojiUnicode = (EmojiSheetViewModel$ViewState$EmojiUnicode) other;
        return m.areEqual(this.emojiUnicode, emojiSheetViewModel$ViewState$EmojiUnicode.emojiUnicode) && this.canFavorite == emojiSheetViewModel$ViewState$EmojiUnicode.canFavorite && this.isFavorite == emojiSheetViewModel$ViewState$EmojiUnicode.isFavorite;
    }

    public final boolean getCanFavorite() {
        return this.canFavorite;
    }

    public final ModelEmojiUnicode getEmojiUnicode() {
        return this.emojiUnicode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        ModelEmojiUnicode modelEmojiUnicode = this.emojiUnicode;
        int iHashCode = (modelEmojiUnicode != null ? modelEmojiUnicode.hashCode() : 0) * 31;
        boolean z2 = this.canFavorite;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.isFavorite;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    public String toString() {
        StringBuilder sbU = a.U("EmojiUnicode(emojiUnicode=");
        sbU.append(this.emojiUnicode);
        sbU.append(", canFavorite=");
        sbU.append(this.canFavorite);
        sbU.append(", isFavorite=");
        return a.O(sbU, this.isFavorite, ")");
    }
}
