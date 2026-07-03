package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.C5419R;
import com.discord.databinding.StickerFullSizeDialogBinding;
import com.discord.views.sticker.StickerView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerFullSizeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StickerFullSizeDialog$binding$2 extends C12236k implements Function1<View, StickerFullSizeDialogBinding> {
    public static final StickerFullSizeDialog$binding$2 INSTANCE = new StickerFullSizeDialog$binding$2();

    public StickerFullSizeDialog$binding$2() {
        super(1, StickerFullSizeDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/StickerFullSizeDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final StickerFullSizeDialogBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        StickerView stickerView = (StickerView) view.findViewById(C5419R.id.sticker_full_size_sticker);
        if (stickerView != null) {
            return new StickerFullSizeDialogBinding((FrameLayout) view, stickerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.sticker_full_size_sticker)));
    }
}
