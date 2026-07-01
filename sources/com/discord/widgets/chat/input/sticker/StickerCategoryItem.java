package com.discord.widgets.chat.input.sticker;

import com.discord.utilities.recycler.DiffKeyProvider;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StickerCategoryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StickerCategoryItem implements DiffKeyProvider {
    public static final StickerCategoryItem$Companion Companion = new StickerCategoryItem$Companion(null);
    public static final int TYPE_GUILD = 2;
    public static final int TYPE_PACK = 1;
    public static final int TYPE_RECENT = 0;
    private final long categoryId;
    private final Pair<Integer, Integer> categoryRange;
    private final boolean isSelected;

    private StickerCategoryItem(boolean z2, Pair<Integer, Integer> pair, long j) {
        this.isSelected = z2;
        this.categoryRange = pair;
        this.categoryId = j;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public Pair<Integer, Integer> getCategoryRange() {
        return this.categoryRange;
    }

    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public boolean getIsSelected() {
        return this.isSelected;
    }

    public /* synthetic */ StickerCategoryItem(boolean z2, Pair pair, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, pair, j);
    }
}
