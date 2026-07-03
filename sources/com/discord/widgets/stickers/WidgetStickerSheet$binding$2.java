package com.discord.widgets.stickers;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetStickerSheetBinding;
import com.discord.views.LoadingButton;
import com.discord.views.sticker.StickerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetStickerSheet$binding$2 extends C12236k implements Function1<View, WidgetStickerSheetBinding> {
    public static final WidgetStickerSheet$binding$2 INSTANCE = new WidgetStickerSheet$binding$2();

    public WidgetStickerSheet$binding$2() {
        super(1, WidgetStickerSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStickerSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetStickerSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.sticker_sheet_buy_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(C5419R.id.sticker_sheet_buy_button);
        if (loadingButton != null) {
            i = C5419R.id.sticker_sheet_sticker_info;
            TextView textView = (TextView) view.findViewById(C5419R.id.sticker_sheet_sticker_info);
            if (textView != null) {
                i = C5419R.id.sticker_sheet_sticker_name;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.sticker_sheet_sticker_name);
                if (textView2 != null) {
                    i = C5419R.id.sticker_sheet_stickers_container;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.sticker_sheet_stickers_container);
                    if (linearLayout != null) {
                        i = C5419R.id.sticker_sheet_view_button;
                        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.sticker_sheet_view_button);
                        if (materialButton != null) {
                            i = C5419R.id.sticker_sheet_view_limited_chip;
                            Chip chip = (Chip) view.findViewById(C5419R.id.sticker_sheet_view_limited_chip);
                            if (chip != null) {
                                i = C5419R.id.sticker_sheet_view_limited_container;
                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C5419R.id.sticker_sheet_view_limited_container);
                                if (relativeLayout != null) {
                                    i = C5419R.id.stickers_sheet_sticker_1;
                                    StickerView stickerView = (StickerView) view.findViewById(C5419R.id.stickers_sheet_sticker_1);
                                    if (stickerView != null) {
                                        i = C5419R.id.stickers_sheet_sticker_2;
                                        StickerView stickerView2 = (StickerView) view.findViewById(C5419R.id.stickers_sheet_sticker_2);
                                        if (stickerView2 != null) {
                                            i = C5419R.id.stickers_sheet_sticker_3;
                                            StickerView stickerView3 = (StickerView) view.findViewById(C5419R.id.stickers_sheet_sticker_3);
                                            if (stickerView3 != null) {
                                                i = C5419R.id.stickers_sheet_sticker_4;
                                                StickerView stickerView4 = (StickerView) view.findViewById(C5419R.id.stickers_sheet_sticker_4);
                                                if (stickerView4 != null) {
                                                    return new WidgetStickerSheetBinding((LinearLayout) view, loadingButton, textView, textView2, linearLayout, materialButton, chip, relativeLayout, stickerView, stickerView2, stickerView3, stickerView4);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
