package com.discord.widgets.notice;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetNoticeNuxOverlayBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNoticeNuxOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetNoticeNuxOverlay$binding$2 extends k implements Function1<View, WidgetNoticeNuxOverlayBinding> {
    public static final WidgetNoticeNuxOverlay$binding$2 INSTANCE = new WidgetNoticeNuxOverlay$binding$2();

    public WidgetNoticeNuxOverlay$binding$2() {
        super(1, WidgetNoticeNuxOverlayBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNoticeNuxOverlayBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetNoticeNuxOverlayBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetNoticeNuxOverlayBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131362294;
        MaterialButton materialButton = (MaterialButton) view.findViewById(2131362294);
        if (materialButton != null) {
            i = R$id.enable_button;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.enable_button);
            if (materialButton2 != null) {
                return new WidgetNoticeNuxOverlayBinding((LinearLayout) view, materialButton, materialButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
