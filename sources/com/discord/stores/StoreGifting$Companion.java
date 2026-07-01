package com.discord.stores;

import com.discord.widgets.chat.input.MentionUtilsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$Companion {
    private StoreGifting$Companion() {
    }

    public final String makeComboId(long skuId, Long planId) {
        StringBuilder sb = new StringBuilder();
        sb.append(skuId);
        sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        sb.append(planId);
        return sb.toString();
    }

    public /* synthetic */ StoreGifting$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
