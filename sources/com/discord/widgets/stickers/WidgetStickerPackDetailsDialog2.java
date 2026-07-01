package com.discord.widgets.stickers;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.StickerPackDetailsDialogBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.stickers.WidgetStickerPackDetailsDialog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetStickerPackDetailsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetStickerPackDetailsDialog2 extends FunctionReferenceImpl implements Function1<View, StickerPackDetailsDialogBinding> {
    public static final WidgetStickerPackDetailsDialog2 INSTANCE = new WidgetStickerPackDetailsDialog2();

    public WidgetStickerPackDetailsDialog2() {
        super(1, StickerPackDetailsDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/StickerPackDetailsDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final StickerPackDetailsDialogBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.sticker_pack_details_animated;
        TextView textView = (TextView) view.findViewById(R.id.sticker_pack_details_animated);
        if (textView != null) {
            i = R.id.sticker_pack_details_close;
            TextView textView2 = (TextView) view.findViewById(R.id.sticker_pack_details_close);
            if (textView2 != null) {
                i = R.id.sticker_pack_details_limited;
                TextView textView3 = (TextView) view.findViewById(R.id.sticker_pack_details_limited);
                if (textView3 != null) {
                    i = R.id.sticker_pack_details_pack;
                    TextView textView4 = (TextView) view.findViewById(R.id.sticker_pack_details_pack);
                    if (textView4 != null) {
                        i = R.id.sticker_pack_details_premium;
                        TextView textView5 = (TextView) view.findViewById(R.id.sticker_pack_details_premium);
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
