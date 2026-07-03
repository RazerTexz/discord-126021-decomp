package com.discord.widgets.voice.controls;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetScreenShareNfxSheetBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetScreenShareNfxSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetScreenShareNfxSheet$binding$2 extends C12236k implements Function1<View, WidgetScreenShareNfxSheetBinding> {
    public static final WidgetScreenShareNfxSheet$binding$2 INSTANCE = new WidgetScreenShareNfxSheet$binding$2();

    public WidgetScreenShareNfxSheet$binding$2() {
        super(1, WidgetScreenShareNfxSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetScreenShareNfxSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetScreenShareNfxSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.screen_share_nfx_cancel_button;
        TextView textView = (TextView) view.findViewById(C5419R.id.screen_share_nfx_cancel_button);
        if (textView != null) {
            i = C5419R.id.screen_share_nfx_cta;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.screen_share_nfx_cta);
            if (materialButton != null) {
                return new WidgetScreenShareNfxSheetBinding((NestedScrollView) view, textView, materialButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
