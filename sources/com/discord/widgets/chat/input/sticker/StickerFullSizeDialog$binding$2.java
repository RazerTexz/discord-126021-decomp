package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R$id;
import com.discord.databinding.StickerFullSizeDialogBinding;
import com.discord.views.sticker.StickerView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StickerFullSizeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StickerFullSizeDialog$binding$2 extends k implements Function1<View, StickerFullSizeDialogBinding> {
    public static final StickerFullSizeDialog$binding$2 INSTANCE = new StickerFullSizeDialog$binding$2();

    public StickerFullSizeDialog$binding$2() {
        super(1, StickerFullSizeDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/StickerFullSizeDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StickerFullSizeDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StickerFullSizeDialogBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        StickerView stickerView = (StickerView) view.findViewById(R$id.sticker_full_size_sticker);
        if (stickerView != null) {
            return new StickerFullSizeDialogBinding((FrameLayout) view, stickerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.sticker_full_size_sticker)));
    }
}
