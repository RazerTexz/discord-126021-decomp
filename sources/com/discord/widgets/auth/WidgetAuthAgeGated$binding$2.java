package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetAuthAgeGatedBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthAgeGated.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthAgeGated$binding$2 extends k implements Function1<View, WidgetAuthAgeGatedBinding> {
    public static final WidgetAuthAgeGated$binding$2 INSTANCE = new WidgetAuthAgeGated$binding$2();

    public WidgetAuthAgeGated$binding$2() {
        super(1, WidgetAuthAgeGatedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthAgeGatedBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthAgeGatedBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthAgeGatedBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.auth_register_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.auth_register_container);
        if (linearLayout != null) {
            i = R$id.auth_register_underage_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.auth_register_underage_button);
            if (materialButton != null) {
                i = R$id.auth_register_underage_description;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.auth_register_underage_description);
                if (linkifiedTextView != null) {
                    return new WidgetAuthAgeGatedBinding((CoordinatorLayout) view, linearLayout, materialButton, linkifiedTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
