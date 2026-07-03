package com.discord.widgets.notice;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetNoticeNuxSamsungLinkBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetNoticeNuxSamsungLink$binding$2 extends C12236k implements Function1<View, WidgetNoticeNuxSamsungLinkBinding> {
    public static final WidgetNoticeNuxSamsungLink$binding$2 INSTANCE = new WidgetNoticeNuxSamsungLink$binding$2();

    public WidgetNoticeNuxSamsungLink$binding$2() {
        super(1, WidgetNoticeNuxSamsungLinkBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNoticeNuxSamsungLinkBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetNoticeNuxSamsungLinkBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.cancel_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.cancel_button);
        if (materialButton != null) {
            i = C5419R.id.enable_button;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.enable_button);
            if (materialButton2 != null) {
                return new WidgetNoticeNuxSamsungLinkBinding((LinearLayout) view, materialButton, materialButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
