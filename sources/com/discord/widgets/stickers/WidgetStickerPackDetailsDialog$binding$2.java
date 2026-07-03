package com.discord.widgets.stickers;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.StickerPackDetailsDialogBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetStickerPackDetailsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetStickerPackDetailsDialog$binding$2 extends C12236k implements Function1<View, StickerPackDetailsDialogBinding> {
    public static final WidgetStickerPackDetailsDialog$binding$2 INSTANCE = new WidgetStickerPackDetailsDialog$binding$2();

    public WidgetStickerPackDetailsDialog$binding$2() {
        super(1, StickerPackDetailsDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/StickerPackDetailsDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final StickerPackDetailsDialogBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.sticker_pack_details_animated;
        TextView textView = (TextView) view.findViewById(C5419R.id.sticker_pack_details_animated);
        if (textView != null) {
            i = C5419R.id.sticker_pack_details_close;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.sticker_pack_details_close);
            if (textView2 != null) {
                i = C5419R.id.sticker_pack_details_limited;
                TextView textView3 = (TextView) view.findViewById(C5419R.id.sticker_pack_details_limited);
                if (textView3 != null) {
                    i = C5419R.id.sticker_pack_details_pack;
                    TextView textView4 = (TextView) view.findViewById(C5419R.id.sticker_pack_details_pack);
                    if (textView4 != null) {
                        i = C5419R.id.sticker_pack_details_premium;
                        TextView textView5 = (TextView) view.findViewById(C5419R.id.sticker_pack_details_premium);
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
