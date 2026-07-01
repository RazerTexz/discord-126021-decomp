package com.discord.widgets.stickers;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetUnknownStickerSheetBinding;
import com.discord.views.sticker.StickerView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.stickers.WidgetUnknownStickerSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetUnknownStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUnknownStickerSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetUnknownStickerSheetBinding> {
    public static final WidgetUnknownStickerSheet2 INSTANCE = new WidgetUnknownStickerSheet2();

    public WidgetUnknownStickerSheet2() {
        super(1, WidgetUnknownStickerSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUnknownStickerSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUnknownStickerSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.unknown_sticker_sheet_sticker;
        StickerView stickerView = (StickerView) view.findViewById(R.id.unknown_sticker_sheet_sticker);
        if (stickerView != null) {
            i = R.id.unknown_sticker_sheet_sticker_name;
            TextView textView = (TextView) view.findViewById(R.id.unknown_sticker_sheet_sticker_name);
            if (textView != null) {
                return new WidgetUnknownStickerSheetBinding((LinearLayout) view, stickerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
