package com.discord.widgets.auth;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetAuthUndeleteAccountBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthUndeleteAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthUndeleteAccount$binding$2 extends k implements Function1<View, WidgetAuthUndeleteAccountBinding> {
    public static final WidgetAuthUndeleteAccount$binding$2 INSTANCE = new WidgetAuthUndeleteAccount$binding$2();

    public WidgetAuthUndeleteAccount$binding$2() {
        super(1, WidgetAuthUndeleteAccountBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthUndeleteAccountBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthUndeleteAccountBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthUndeleteAccountBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.auth_undelete_cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.auth_undelete_cancel);
        if (materialButton != null) {
            i = R$id.auth_undelete_delete;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.auth_undelete_delete);
            if (materialButton2 != null) {
                i = R$id.auth_undelete_title;
                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R$id.auth_undelete_title);
                if (screenTitleView != null) {
                    return new WidgetAuthUndeleteAccountBinding((CoordinatorLayout) view, materialButton, materialButton2, screenTitleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
