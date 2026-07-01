package com.discord.widgets.notice;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.R;
import com.discord.databinding.WidgetNoticeNuxOverlayBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.notice.WidgetNoticeNuxOverlay$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetNoticeNuxOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetNoticeNuxOverlay3 extends FunctionReferenceImpl implements Function1<View, WidgetNoticeNuxOverlayBinding> {
    public static final WidgetNoticeNuxOverlay3 INSTANCE = new WidgetNoticeNuxOverlay3();

    public WidgetNoticeNuxOverlay3() {
        super(1, WidgetNoticeNuxOverlayBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNoticeNuxOverlayBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetNoticeNuxOverlayBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.cancel_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.cancel_button);
        if (materialButton != null) {
            i = R.id.enable_button;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.enable_button);
            if (materialButton2 != null) {
                return new WidgetNoticeNuxOverlayBinding((LinearLayout) view, materialButton, materialButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
