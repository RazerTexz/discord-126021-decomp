package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetStickerPackStoreSheetBinding;
import com.discord.views.LoadingButton;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetStickerPackStoreSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStickerPackStoreSheet3 extends FunctionReferenceImpl implements Function1<View, WidgetStickerPackStoreSheetBinding> {
    public static final WidgetStickerPackStoreSheet3 INSTANCE = new WidgetStickerPackStoreSheet3();

    public WidgetStickerPackStoreSheet3() {
        super(1, WidgetStickerPackStoreSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStickerPackStoreSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetStickerPackStoreSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.sticker_pack_store_sheet_buy_button_container;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.sticker_pack_store_sheet_buy_button_container);
        if (frameLayout != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i = R.id.sticker_pack_store_sheet_recycler;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.sticker_pack_store_sheet_recycler);
            if (recyclerView != null) {
                i = R.id.sticker_pack_view_all_banner;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.sticker_pack_view_all_banner);
                if (simpleDraweeView != null) {
                    i = R.id.sticker_store_buy_button_premium;
                    LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.sticker_store_buy_button_premium);
                    if (loadingButton != null) {
                        return new WidgetStickerPackStoreSheetBinding(relativeLayout, frameLayout, relativeLayout, recyclerView, simpleDraweeView, loadingButton);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
