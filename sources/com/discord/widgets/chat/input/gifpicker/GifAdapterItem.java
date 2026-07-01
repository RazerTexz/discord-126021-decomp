package com.discord.widgets.chat.input.gifpicker;

import com.discord.utilities.recycler.DiffKeyProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GifAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GifAdapterItem implements DiffKeyProvider {
    private final GifAdapterItem$ViewType type;

    private GifAdapterItem(GifAdapterItem$ViewType gifAdapterItem$ViewType) {
        this.type = gifAdapterItem$ViewType;
    }

    public final GifAdapterItem$ViewType getType() {
        return this.type;
    }

    public /* synthetic */ GifAdapterItem(GifAdapterItem$ViewType gifAdapterItem$ViewType, DefaultConstructorMarker defaultConstructorMarker) {
        this(gifAdapterItem$ViewType);
    }
}
