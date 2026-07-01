package com.discord.widgets.chat.input.sticker;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: StickerPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerPickerViewModel$Event$ScrollToStickerItemPosition extends StickerPickerViewModel$Event {
    private final int position;

    public StickerPickerViewModel$Event$ScrollToStickerItemPosition(int i) {
        super(null);
        this.position = i;
    }

    public static /* synthetic */ StickerPickerViewModel$Event$ScrollToStickerItemPosition copy$default(StickerPickerViewModel$Event$ScrollToStickerItemPosition stickerPickerViewModel$Event$ScrollToStickerItemPosition, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = stickerPickerViewModel$Event$ScrollToStickerItemPosition.position;
        }
        return stickerPickerViewModel$Event$ScrollToStickerItemPosition.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    public final StickerPickerViewModel$Event$ScrollToStickerItemPosition copy(int position) {
        return new StickerPickerViewModel$Event$ScrollToStickerItemPosition(position);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StickerPickerViewModel$Event$ScrollToStickerItemPosition) && this.position == ((StickerPickerViewModel$Event$ScrollToStickerItemPosition) other).position;
        }
        return true;
    }

    public final int getPosition() {
        return this.position;
    }

    public int hashCode() {
        return this.position;
    }

    public String toString() {
        return a.B(a.U("ScrollToStickerItemPosition(position="), this.position, ")");
    }
}
