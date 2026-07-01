package com.discord.widgets.voice.controls;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetScreenShareNfxSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.voice.controls.WidgetScreenShareNfxSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetScreenShareNfxSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetScreenShareNfxSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetScreenShareNfxSheetBinding> {
    public static final WidgetScreenShareNfxSheet2 INSTANCE = new WidgetScreenShareNfxSheet2();

    public WidgetScreenShareNfxSheet2() {
        super(1, WidgetScreenShareNfxSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetScreenShareNfxSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetScreenShareNfxSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.screen_share_nfx_cancel_button;
        TextView textView = (TextView) view.findViewById(R.id.screen_share_nfx_cancel_button);
        if (textView != null) {
            i = R.id.screen_share_nfx_cta;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.screen_share_nfx_cta);
            if (materialButton != null) {
                return new WidgetScreenShareNfxSheetBinding((NestedScrollView) view, textView, materialButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
