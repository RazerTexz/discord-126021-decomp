package com.discord.widgets.notice;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetNoticeNuxOverlayBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetNoticeNuxOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetNoticeNuxOverlay$binding$2 extends C12236k implements Function1<View, WidgetNoticeNuxOverlayBinding> {
    public static final WidgetNoticeNuxOverlay$binding$2 INSTANCE = new WidgetNoticeNuxOverlay$binding$2();

    public WidgetNoticeNuxOverlay$binding$2() {
        super(1, WidgetNoticeNuxOverlayBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNoticeNuxOverlayBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetNoticeNuxOverlayBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.cancel_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.cancel_button);
        if (materialButton != null) {
            i = C5419R.id.enable_button;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.enable_button);
            if (materialButton2 != null) {
                return new WidgetNoticeNuxOverlayBinding((LinearLayout) view, materialButton, materialButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
