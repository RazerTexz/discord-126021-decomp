package com.discord.widgets.chat.input.sticker;

import b.d.b.a.a;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: StickerPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerPickerViewModel$ViewState$Stickers extends StickerPickerViewModel$ViewState {
    private final List<StickerCategoryItem> categoryItems;
    private final boolean isOnCooldown;
    private final boolean isStickersSelectedTab;
    private final String searchQuery;
    private final List<MGRecyclerDataPayload> stickerItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StickerPickerViewModel$ViewState$Stickers(String str, List<? extends MGRecyclerDataPayload> list, List<? extends StickerCategoryItem> list2, boolean z2, boolean z3) {
        super(str, null);
        m.checkNotNullParameter(str, "searchQuery");
        m.checkNotNullParameter(list, "stickerItems");
        m.checkNotNullParameter(list2, "categoryItems");
        this.searchQuery = str;
        this.stickerItems = list;
        this.categoryItems = list2;
        this.isStickersSelectedTab = z2;
        this.isOnCooldown = z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StickerPickerViewModel$ViewState$Stickers copy$default(StickerPickerViewModel$ViewState$Stickers stickerPickerViewModel$ViewState$Stickers, String str, List list, List list2, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stickerPickerViewModel$ViewState$Stickers.getSearchQuery();
        }
        if ((i & 2) != 0) {
            list = stickerPickerViewModel$ViewState$Stickers.stickerItems;
        }
        List list3 = list;
        if ((i & 4) != 0) {
            list2 = stickerPickerViewModel$ViewState$Stickers.categoryItems;
        }
        List list4 = list2;
        if ((i & 8) != 0) {
            z2 = stickerPickerViewModel$ViewState$Stickers.isStickersSelectedTab;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            z3 = stickerPickerViewModel$ViewState$Stickers.isOnCooldown;
        }
        return stickerPickerViewModel$ViewState$Stickers.copy(str, list3, list4, z4, z3);
    }

    public final String component1() {
        return getSearchQuery();
    }

    public final List<MGRecyclerDataPayload> component2() {
        return this.stickerItems;
    }

    public final List<StickerCategoryItem> component3() {
        return this.categoryItems;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsStickersSelectedTab() {
        return this.isStickersSelectedTab;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsOnCooldown() {
        return this.isOnCooldown;
    }

    public final StickerPickerViewModel$ViewState$Stickers copy(String searchQuery, List<? extends MGRecyclerDataPayload> stickerItems, List<? extends StickerCategoryItem> categoryItems, boolean isStickersSelectedTab, boolean isOnCooldown) {
        m.checkNotNullParameter(searchQuery, "searchQuery");
        m.checkNotNullParameter(stickerItems, "stickerItems");
        m.checkNotNullParameter(categoryItems, "categoryItems");
        return new StickerPickerViewModel$ViewState$Stickers(searchQuery, stickerItems, categoryItems, isStickersSelectedTab, isOnCooldown);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerPickerViewModel$ViewState$Stickers)) {
            return false;
        }
        StickerPickerViewModel$ViewState$Stickers stickerPickerViewModel$ViewState$Stickers = (StickerPickerViewModel$ViewState$Stickers) other;
        return m.areEqual(getSearchQuery(), stickerPickerViewModel$ViewState$Stickers.getSearchQuery()) && m.areEqual(this.stickerItems, stickerPickerViewModel$ViewState$Stickers.stickerItems) && m.areEqual(this.categoryItems, stickerPickerViewModel$ViewState$Stickers.categoryItems) && this.isStickersSelectedTab == stickerPickerViewModel$ViewState$Stickers.isStickersSelectedTab && this.isOnCooldown == stickerPickerViewModel$ViewState$Stickers.isOnCooldown;
    }

    public final List<StickerCategoryItem> getCategoryItems() {
        return this.categoryItems;
    }

    @Override // com.discord.widgets.chat.input.sticker.StickerPickerViewModel$ViewState
    public String getSearchQuery() {
        return this.searchQuery;
    }

    public final List<MGRecyclerDataPayload> getStickerItems() {
        return this.stickerItems;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public int hashCode() {
        String searchQuery = getSearchQuery();
        int iHashCode = (searchQuery != null ? searchQuery.hashCode() : 0) * 31;
        List<MGRecyclerDataPayload> list = this.stickerItems;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<StickerCategoryItem> list2 = this.categoryItems;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z2 = this.isStickersSelectedTab;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode3 + r1) * 31;
        boolean z3 = this.isOnCooldown;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isOnCooldown() {
        return this.isOnCooldown;
    }

    public final boolean isStickersSelectedTab() {
        return this.isStickersSelectedTab;
    }

    public String toString() {
        StringBuilder sbU = a.U("Stickers(searchQuery=");
        sbU.append(getSearchQuery());
        sbU.append(", stickerItems=");
        sbU.append(this.stickerItems);
        sbU.append(", categoryItems=");
        sbU.append(this.categoryItems);
        sbU.append(", isStickersSelectedTab=");
        sbU.append(this.isStickersSelectedTab);
        sbU.append(", isOnCooldown=");
        return a.O(sbU, this.isOnCooldown, ")");
    }
}
