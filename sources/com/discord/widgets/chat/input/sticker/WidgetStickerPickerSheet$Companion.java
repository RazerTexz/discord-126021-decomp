package com.discord.widgets.chat.input.sticker;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetStickerPickerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPickerSheet$Companion {
    private WidgetStickerPickerSheet$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetStickerPickerSheet show$default(WidgetStickerPickerSheet$Companion widgetStickerPickerSheet$Companion, FragmentManager fragmentManager, StickerPickerListener stickerPickerListener, Long l, String str, Function0 function0, int i, Object obj) {
        return widgetStickerPickerSheet$Companion.show(fragmentManager, stickerPickerListener, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : function0);
    }

    public final WidgetStickerPickerSheet show(FragmentManager fragmentManager, StickerPickerListener stickerPickerListener, Long initialStickerPackId, String searchText, Function0<Unit> onCancel) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        System.gc();
        Bundle bundle = new Bundle();
        if (initialStickerPackId != null) {
            initialStickerPackId.longValue();
            bundle.putLong("com.discord.intent.EXTRA_STICKER_PACK_ID", initialStickerPackId.longValue());
        }
        bundle.putString("com.discord.intent.extra.EXTRA_TEXT", searchText);
        WidgetStickerPickerSheet widgetStickerPickerSheet = new WidgetStickerPickerSheet();
        widgetStickerPickerSheet.setStickerPickerListener(stickerPickerListener);
        widgetStickerPickerSheet.setOnCancel(onCancel);
        widgetStickerPickerSheet.setArguments(bundle);
        widgetStickerPickerSheet.show(fragmentManager, WidgetStickerPickerSheet.class.getSimpleName());
        return widgetStickerPickerSheet;
    }

    public /* synthetic */ WidgetStickerPickerSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
