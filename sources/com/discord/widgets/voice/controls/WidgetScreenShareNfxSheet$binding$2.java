package com.discord.widgets.voice.controls;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetScreenShareNfxSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetScreenShareNfxSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetScreenShareNfxSheet$binding$2 extends k implements Function1<View, WidgetScreenShareNfxSheetBinding> {
    public static final WidgetScreenShareNfxSheet$binding$2 INSTANCE = new WidgetScreenShareNfxSheet$binding$2();

    public WidgetScreenShareNfxSheet$binding$2() {
        super(1, WidgetScreenShareNfxSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetScreenShareNfxSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetScreenShareNfxSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetScreenShareNfxSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.screen_share_nfx_cancel_button;
        TextView textView = (TextView) view.findViewById(R$id.screen_share_nfx_cancel_button);
        if (textView != null) {
            i = R$id.screen_share_nfx_cta;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.screen_share_nfx_cta);
            if (materialButton != null) {
                return new WidgetScreenShareNfxSheetBinding((NestedScrollView) view, textView, materialButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
