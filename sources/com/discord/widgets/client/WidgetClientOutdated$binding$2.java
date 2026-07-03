package com.discord.widgets.client;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetClientOutdatedBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetClientOutdated.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetClientOutdated$binding$2 extends C12236k implements Function1<View, WidgetClientOutdatedBinding> {
    public static final WidgetClientOutdated$binding$2 INSTANCE = new WidgetClientOutdated$binding$2();

    public WidgetClientOutdated$binding$2() {
        super(1, WidgetClientOutdatedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetClientOutdatedBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetClientOutdatedBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.client_outdated_anchor_wrap;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.client_outdated_anchor_wrap);
        if (linearLayout != null) {
            i = C5419R.id.client_outdated_update;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.client_outdated_update);
            if (materialButton != null) {
                return new WidgetClientOutdatedBinding((RelativeLayout) view, linearLayout, materialButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
