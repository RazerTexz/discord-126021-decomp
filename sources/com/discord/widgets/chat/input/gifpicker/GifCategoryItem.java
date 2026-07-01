package com.discord.widgets.chat.input.gifpicker;

import com.discord.utilities.recycler.DiffKeyProvider;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GifCategoryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GifCategoryItem implements DiffKeyProvider, Serializable {
    private final String key;

    private GifCategoryItem() {
        this.key = String.valueOf(hashCode());
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public /* synthetic */ GifCategoryItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
