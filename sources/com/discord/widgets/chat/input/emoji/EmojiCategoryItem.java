package com.discord.widgets.chat.input.emoji;

import com.discord.utilities.recycler.DiffKeyProvider;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EmojiCategoryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class EmojiCategoryItem implements DiffKeyProvider {
    public static final EmojiCategoryItem$Companion Companion = new EmojiCategoryItem$Companion(null);
    public static final int TYPE_GUILD = 1;
    public static final int TYPE_STANDARD = 0;
    private final Pair<Integer, Integer> categoryRange;
    private final boolean isSelected;
    private final String key;
    private final long stableId;

    private EmojiCategoryItem(long j, Pair<Integer, Integer> pair, boolean z2) {
        this.stableId = j;
        this.categoryRange = pair;
        this.isSelected = z2;
        this.key = String.valueOf(j);
    }

    public final boolean containsOnlyUnicodeEmoji() {
        return (this instanceof EmojiCategoryItem$StandardItem) && ((EmojiCategoryItem$StandardItem) this).getEmojiCategory().containsOnlyUnicode;
    }

    public Pair<Integer, Integer> getCategoryRange() {
        return this.categoryRange;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getStableId() {
        return this.stableId;
    }

    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public boolean getIsSelected() {
        return this.isSelected;
    }

    public /* synthetic */ EmojiCategoryItem(long j, Pair pair, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, pair, z2);
    }
}
