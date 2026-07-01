package com.discord.widgets.auth;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetAuthUndeleteAccountBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthUndeleteAccount$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthUndeleteAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthUndeleteAccount3 extends FunctionReferenceImpl implements Function1<View, WidgetAuthUndeleteAccountBinding> {
    public static final WidgetAuthUndeleteAccount3 INSTANCE = new WidgetAuthUndeleteAccount3();

    public WidgetAuthUndeleteAccount3() {
        super(1, WidgetAuthUndeleteAccountBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthUndeleteAccountBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAuthUndeleteAccountBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.auth_undelete_cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.auth_undelete_cancel);
        if (materialButton != null) {
            i = R.id.auth_undelete_delete;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.auth_undelete_delete);
            if (materialButton2 != null) {
                i = R.id.auth_undelete_title;
                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.auth_undelete_title);
                if (screenTitleView != null) {
                    return new WidgetAuthUndeleteAccountBinding((CoordinatorLayout) view, materialButton, materialButton2, screenTitleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
