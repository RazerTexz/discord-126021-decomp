package com.discord.widgets.stickers;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetUnknownStickerSheetBinding;
import com.discord.views.sticker.StickerView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUnknownStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUnknownStickerSheet$binding$2 extends k implements Function1<View, WidgetUnknownStickerSheetBinding> {
    public static final WidgetUnknownStickerSheet$binding$2 INSTANCE = new WidgetUnknownStickerSheet$binding$2();

    public WidgetUnknownStickerSheet$binding$2() {
        super(1, WidgetUnknownStickerSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUnknownStickerSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUnknownStickerSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUnknownStickerSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.unknown_sticker_sheet_sticker;
        StickerView stickerView = (StickerView) view.findViewById(R$id.unknown_sticker_sheet_sticker);
        if (stickerView != null) {
            i = R$id.unknown_sticker_sheet_sticker_name;
            TextView textView = (TextView) view.findViewById(R$id.unknown_sticker_sheet_sticker_name);
            if (textView != null) {
                return new WidgetUnknownStickerSheetBinding((LinearLayout) view, stickerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
