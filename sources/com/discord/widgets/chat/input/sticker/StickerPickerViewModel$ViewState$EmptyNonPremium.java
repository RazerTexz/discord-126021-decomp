package com.discord.widgets.chat.input.sticker;

import b.d.b.a.a;
import com.discord.api.sticker.Sticker;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: StickerPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerPickerViewModel$ViewState$EmptyNonPremium extends StickerPickerViewModel$ViewState {
    private final List<Sticker> emptyStateStickers;
    private final boolean isStickersSelectedTab;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPickerViewModel$ViewState$EmptyNonPremium(List<Sticker> list, boolean z2) {
        super("", null);
        m.checkNotNullParameter(list, "emptyStateStickers");
        this.emptyStateStickers = list;
        this.isStickersSelectedTab = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StickerPickerViewModel$ViewState$EmptyNonPremium copy$default(StickerPickerViewModel$ViewState$EmptyNonPremium stickerPickerViewModel$ViewState$EmptyNonPremium, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = stickerPickerViewModel$ViewState$EmptyNonPremium.emptyStateStickers;
        }
        if ((i & 2) != 0) {
            z2 = stickerPickerViewModel$ViewState$EmptyNonPremium.isStickersSelectedTab;
        }
        return stickerPickerViewModel$ViewState$EmptyNonPremium.copy(list, z2);
    }

    public final List<Sticker> component1() {
        return this.emptyStateStickers;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsStickersSelectedTab() {
        return this.isStickersSelectedTab;
    }

    public final StickerPickerViewModel$ViewState$EmptyNonPremium copy(List<Sticker> emptyStateStickers, boolean isStickersSelectedTab) {
        m.checkNotNullParameter(emptyStateStickers, "emptyStateStickers");
        return new StickerPickerViewModel$ViewState$EmptyNonPremium(emptyStateStickers, isStickersSelectedTab);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerPickerViewModel$ViewState$EmptyNonPremium)) {
            return false;
        }
        StickerPickerViewModel$ViewState$EmptyNonPremium stickerPickerViewModel$ViewState$EmptyNonPremium = (StickerPickerViewModel$ViewState$EmptyNonPremium) other;
        return m.areEqual(this.emptyStateStickers, stickerPickerViewModel$ViewState$EmptyNonPremium.emptyStateStickers) && this.isStickersSelectedTab == stickerPickerViewModel$ViewState$EmptyNonPremium.isStickersSelectedTab;
    }

    public final List<Sticker> getEmptyStateStickers() {
        return this.emptyStateStickers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        List<Sticker> list = this.emptyStateStickers;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.isStickersSelectedTab;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isStickersSelectedTab() {
        return this.isStickersSelectedTab;
    }

    public String toString() {
        StringBuilder sbU = a.U("EmptyNonPremium(emptyStateStickers=");
        sbU.append(this.emptyStateStickers);
        sbU.append(", isStickersSelectedTab=");
        return a.O(sbU, this.isStickersSelectedTab, ")");
    }
}
