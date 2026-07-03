package com.discord.widgets.stickers;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetUnknownStickerSheetBinding;
import com.discord.views.sticker.StickerView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUnknownStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUnknownStickerSheet$binding$2 extends C12236k implements Function1<View, WidgetUnknownStickerSheetBinding> {
    public static final WidgetUnknownStickerSheet$binding$2 INSTANCE = new WidgetUnknownStickerSheet$binding$2();

    public WidgetUnknownStickerSheet$binding$2() {
        super(1, WidgetUnknownStickerSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUnknownStickerSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUnknownStickerSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.unknown_sticker_sheet_sticker;
        StickerView stickerView = (StickerView) view.findViewById(C5419R.id.unknown_sticker_sheet_sticker);
        if (stickerView != null) {
            i = C5419R.id.unknown_sticker_sheet_sticker_name;
            TextView textView = (TextView) view.findViewById(C5419R.id.unknown_sticker_sheet_sticker_name);
            if (textView != null) {
                return new WidgetUnknownStickerSheetBinding((LinearLayout) view, stickerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
