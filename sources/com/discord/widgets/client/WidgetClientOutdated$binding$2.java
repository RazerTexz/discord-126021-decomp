package com.discord.widgets.client;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetClientOutdatedBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetClientOutdated.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetClientOutdated$binding$2 extends k implements Function1<View, WidgetClientOutdatedBinding> {
    public static final WidgetClientOutdated$binding$2 INSTANCE = new WidgetClientOutdated$binding$2();

    public WidgetClientOutdated$binding$2() {
        super(1, WidgetClientOutdatedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetClientOutdatedBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetClientOutdatedBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetClientOutdatedBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.client_outdated_anchor_wrap;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.client_outdated_anchor_wrap);
        if (linearLayout != null) {
            i = R$id.client_outdated_update;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.client_outdated_update);
            if (materialButton != null) {
                return new WidgetClientOutdatedBinding((RelativeLayout) view, linearLayout, materialButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
