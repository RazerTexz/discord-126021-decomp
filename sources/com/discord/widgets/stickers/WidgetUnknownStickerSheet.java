package com.discord.widgets.stickers;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.sticker.StickerPartial;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUnknownStickerSheetBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import java.io.Serializable;
import java.util.Objects;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUnknownStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUnknownStickerSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUnknownStickerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUnknownStickerSheetBinding;", 0)};
    public static final WidgetUnknownStickerSheet$Companion Companion = new WidgetUnknownStickerSheet$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetUnknownStickerSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUnknownStickerSheet$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetUnknownStickerSheetBinding getBinding() {
        return (WidgetUnknownStickerSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager, StickerPartial stickerPartial) {
        Companion.show(fragmentManager, stickerPartial);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_unknown_sticker_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Serializable serializable = getArgumentsOrDefault().getSerializable("com.discord.intent.extra.EXTRA_STICKER");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.api.sticker.StickerPartial");
        StickerPartial stickerPartial = (StickerPartial) serializable;
        getBinding().f2677b.d(stickerPartial, 0);
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.unknownStickerSheetStickerName");
        textView.setText(stickerPartial.getName());
    }
}
