package com.discord.widgets.chat.input.sticker;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.api.sticker.Sticker;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StickerFullSizeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerFullSizeDialog$Companion {
    private StickerFullSizeDialog$Companion() {
    }

    public final void show(FragmentManager fragmentManager, Sticker sticker) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(sticker, "sticker");
        Bundle bundle = new Bundle();
        bundle.putSerializable("com.discord.intent.extra.EXTRA_STICKER", sticker);
        StickerFullSizeDialog stickerFullSizeDialog = new StickerFullSizeDialog();
        stickerFullSizeDialog.setArguments(bundle);
        stickerFullSizeDialog.show(fragmentManager, StickerFullSizeDialog.class.getSimpleName());
    }

    public /* synthetic */ StickerFullSizeDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
