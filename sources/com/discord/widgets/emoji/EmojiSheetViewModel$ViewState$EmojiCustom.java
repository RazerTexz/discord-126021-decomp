package com.discord.widgets.emoji;

import b.d.b.a.a;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType$Custom;
import d0.z.d.m;

/* JADX INFO: compiled from: EmojiSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiSheetViewModel$ViewState$EmojiCustom extends EmojiSheetViewModel$ViewState {
    private final boolean canFavorite;
    private final EmojiNode$EmojiIdAndType$Custom emojiCustom;
    private final EmojiSheetViewModel$Companion$CustomEmojGuildInfo emojiGuildInfo;
    private final boolean isCurrentGuild;
    private final boolean isFavorite;
    private final boolean isUserPremium;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiSheetViewModel$ViewState$EmojiCustom(EmojiNode$EmojiIdAndType$Custom emojiNode$EmojiIdAndType$Custom, EmojiSheetViewModel$Companion$CustomEmojGuildInfo emojiSheetViewModel$Companion$CustomEmojGuildInfo, boolean z2, boolean z3, boolean z4, boolean z5) {
        super(null);
        m.checkNotNullParameter(emojiNode$EmojiIdAndType$Custom, "emojiCustom");
        m.checkNotNullParameter(emojiSheetViewModel$Companion$CustomEmojGuildInfo, "emojiGuildInfo");
        this.emojiCustom = emojiNode$EmojiIdAndType$Custom;
        this.emojiGuildInfo = emojiSheetViewModel$Companion$CustomEmojGuildInfo;
        this.isUserPremium = z2;
        this.isCurrentGuild = z3;
        this.canFavorite = z4;
        this.isFavorite = z5;
    }

    public static /* synthetic */ EmojiSheetViewModel$ViewState$EmojiCustom copy$default(EmojiSheetViewModel$ViewState$EmojiCustom emojiSheetViewModel$ViewState$EmojiCustom, EmojiNode$EmojiIdAndType$Custom emojiNode$EmojiIdAndType$Custom, EmojiSheetViewModel$Companion$CustomEmojGuildInfo emojiSheetViewModel$Companion$CustomEmojGuildInfo, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        if ((i & 1) != 0) {
            emojiNode$EmojiIdAndType$Custom = emojiSheetViewModel$ViewState$EmojiCustom.emojiCustom;
        }
        if ((i & 2) != 0) {
            emojiSheetViewModel$Companion$CustomEmojGuildInfo = emojiSheetViewModel$ViewState$EmojiCustom.emojiGuildInfo;
        }
        EmojiSheetViewModel$Companion$CustomEmojGuildInfo emojiSheetViewModel$Companion$CustomEmojGuildInfo2 = emojiSheetViewModel$Companion$CustomEmojGuildInfo;
        if ((i & 4) != 0) {
            z2 = emojiSheetViewModel$ViewState$EmojiCustom.isUserPremium;
        }
        boolean z6 = z2;
        if ((i & 8) != 0) {
            z3 = emojiSheetViewModel$ViewState$EmojiCustom.isCurrentGuild;
        }
        boolean z7 = z3;
        if ((i & 16) != 0) {
            z4 = emojiSheetViewModel$ViewState$EmojiCustom.canFavorite;
        }
        boolean z8 = z4;
        if ((i & 32) != 0) {
            z5 = emojiSheetViewModel$ViewState$EmojiCustom.isFavorite;
        }
        return emojiSheetViewModel$ViewState$EmojiCustom.copy(emojiNode$EmojiIdAndType$Custom, emojiSheetViewModel$Companion$CustomEmojGuildInfo2, z6, z7, z8, z5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EmojiNode$EmojiIdAndType$Custom getEmojiCustom() {
        return this.emojiCustom;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final EmojiSheetViewModel$Companion$CustomEmojGuildInfo getEmojiGuildInfo() {
        return this.emojiGuildInfo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsUserPremium() {
        return this.isUserPremium;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsCurrentGuild() {
        return this.isCurrentGuild;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanFavorite() {
        return this.canFavorite;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsFavorite() {
        return this.isFavorite;
    }

    public final EmojiSheetViewModel$ViewState$EmojiCustom copy(EmojiNode$EmojiIdAndType$Custom emojiCustom, EmojiSheetViewModel$Companion$CustomEmojGuildInfo emojiGuildInfo, boolean isUserPremium, boolean isCurrentGuild, boolean canFavorite, boolean isFavorite) {
        m.checkNotNullParameter(emojiCustom, "emojiCustom");
        m.checkNotNullParameter(emojiGuildInfo, "emojiGuildInfo");
        return new EmojiSheetViewModel$ViewState$EmojiCustom(emojiCustom, emojiGuildInfo, isUserPremium, isCurrentGuild, canFavorite, isFavorite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiSheetViewModel$ViewState$EmojiCustom)) {
            return false;
        }
        EmojiSheetViewModel$ViewState$EmojiCustom emojiSheetViewModel$ViewState$EmojiCustom = (EmojiSheetViewModel$ViewState$EmojiCustom) other;
        return m.areEqual(this.emojiCustom, emojiSheetViewModel$ViewState$EmojiCustom.emojiCustom) && m.areEqual(this.emojiGuildInfo, emojiSheetViewModel$ViewState$EmojiCustom.emojiGuildInfo) && this.isUserPremium == emojiSheetViewModel$ViewState$EmojiCustom.isUserPremium && this.isCurrentGuild == emojiSheetViewModel$ViewState$EmojiCustom.isCurrentGuild && this.canFavorite == emojiSheetViewModel$ViewState$EmojiCustom.canFavorite && this.isFavorite == emojiSheetViewModel$ViewState$EmojiCustom.isFavorite;
    }

    public final boolean getCanFavorite() {
        return this.canFavorite;
    }

    public final EmojiNode$EmojiIdAndType$Custom getEmojiCustom() {
        return this.emojiCustom;
    }

    public final EmojiSheetViewModel$Companion$CustomEmojGuildInfo getEmojiGuildInfo() {
        return this.emojiGuildInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        EmojiNode$EmojiIdAndType$Custom emojiNode$EmojiIdAndType$Custom = this.emojiCustom;
        int iHashCode = (emojiNode$EmojiIdAndType$Custom != null ? emojiNode$EmojiIdAndType$Custom.hashCode() : 0) * 31;
        EmojiSheetViewModel$Companion$CustomEmojGuildInfo emojiSheetViewModel$Companion$CustomEmojGuildInfo = this.emojiGuildInfo;
        int iHashCode2 = (iHashCode + (emojiSheetViewModel$Companion$CustomEmojGuildInfo != null ? emojiSheetViewModel$Companion$CustomEmojGuildInfo.hashCode() : 0)) * 31;
        boolean z2 = this.isUserPremium;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.isCurrentGuild;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.canFavorite;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.isFavorite;
        return i3 + (z5 ? 1 : z5);
    }

    public final boolean isCurrentGuild() {
        return this.isCurrentGuild;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    public final boolean isUserPremium() {
        return this.isUserPremium;
    }

    public String toString() {
        StringBuilder sbU = a.U("EmojiCustom(emojiCustom=");
        sbU.append(this.emojiCustom);
        sbU.append(", emojiGuildInfo=");
        sbU.append(this.emojiGuildInfo);
        sbU.append(", isUserPremium=");
        sbU.append(this.isUserPremium);
        sbU.append(", isCurrentGuild=");
        sbU.append(this.isCurrentGuild);
        sbU.append(", canFavorite=");
        sbU.append(this.canFavorite);
        sbU.append(", isFavorite=");
        return a.O(sbU, this.isFavorite, ")");
    }
}
