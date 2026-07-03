package com.discord.widgets.chat.input;

import com.discord.api.sticker.Sticker;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatInputAutocompleteStickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AutocompleteStickerItem implements MGRecyclerDataPayload {
    public static final int TYPE = 0;
    private final String key;
    private final Sticker sticker;
    private final int type;

    public AutocompleteStickerItem(Sticker sticker, String str, int i) {
        C12238m.checkNotNullParameter(sticker, "sticker");
        C12238m.checkNotNullParameter(str, "key");
        this.sticker = sticker;
        this.key = str;
        this.type = i;
    }

    public static /* synthetic */ AutocompleteStickerItem copy$default(AutocompleteStickerItem autocompleteStickerItem, Sticker sticker, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sticker = autocompleteStickerItem.sticker;
        }
        if ((i2 & 2) != 0) {
            str = autocompleteStickerItem.getKey();
        }
        if ((i2 & 4) != 0) {
            i = autocompleteStickerItem.getType();
        }
        return autocompleteStickerItem.copy(sticker, str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Sticker getSticker() {
        return this.sticker;
    }

    public final String component2() {
        return getKey();
    }

    public final int component3() {
        return getType();
    }

    public final AutocompleteStickerItem copy(Sticker sticker, String key, int type) {
        C12238m.checkNotNullParameter(sticker, "sticker");
        C12238m.checkNotNullParameter(key, "key");
        return new AutocompleteStickerItem(sticker, key, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutocompleteStickerItem)) {
            return false;
        }
        AutocompleteStickerItem autocompleteStickerItem = (AutocompleteStickerItem) other;
        return C12238m.areEqual(this.sticker, autocompleteStickerItem.sticker) && C12238m.areEqual(getKey(), autocompleteStickerItem.getKey()) && getType() == autocompleteStickerItem.getType();
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Sticker getSticker() {
        return this.sticker;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Sticker sticker = this.sticker;
        int iHashCode = (sticker != null ? sticker.hashCode() : 0) * 31;
        String key = getKey();
        return getType() + ((iHashCode + (key != null ? key.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("AutocompleteStickerItem(sticker=");
        sbM833U.append(this.sticker);
        sbM833U.append(", key=");
        sbM833U.append(getKey());
        sbM833U.append(", type=");
        sbM833U.append(getType());
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ AutocompleteStickerItem(Sticker sticker, String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(sticker, (i2 & 2) != 0 ? String.valueOf(sticker.getId()) : str, (i2 & 4) != 0 ? 0 : i);
    }
}
