package com.discord.widgets.stickers;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.StickerPackDetailsDialogBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerPackDetailsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetStickerPackDetailsDialog$binding$2 extends k implements Function1<View, StickerPackDetailsDialogBinding> {
    public static final WidgetStickerPackDetailsDialog$binding$2 INSTANCE = new WidgetStickerPackDetailsDialog$binding$2();

    public WidgetStickerPackDetailsDialog$binding$2() {
        super(1, StickerPackDetailsDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/StickerPackDetailsDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StickerPackDetailsDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StickerPackDetailsDialogBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.sticker_pack_details_animated;
        TextView textView = (TextView) view.findViewById(R$id.sticker_pack_details_animated);
        if (textView != null) {
            i = R$id.sticker_pack_details_close;
            TextView textView2 = (TextView) view.findViewById(R$id.sticker_pack_details_close);
            if (textView2 != null) {
                i = R$id.sticker_pack_details_limited;
                TextView textView3 = (TextView) view.findViewById(R$id.sticker_pack_details_limited);
                if (textView3 != null) {
                    i = R$id.sticker_pack_details_pack;
                    TextView textView4 = (TextView) view.findViewById(R$id.sticker_pack_details_pack);
                    if (textView4 != null) {
                        i = R$id.sticker_pack_details_premium;
                        TextView textView5 = (TextView) view.findViewById(R$id.sticker_pack_details_premium);
                        if (textView5 != null) {
                            return new StickerPackDetailsDialogBinding((FrameLayout) view, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
