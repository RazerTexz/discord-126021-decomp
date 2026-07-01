package com.discord.widgets.user;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetUserPasswordVerifyBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserPasswordVerify$binding$2 extends k implements Function1<View, WidgetUserPasswordVerifyBinding> {
    public static final WidgetUserPasswordVerify$binding$2 INSTANCE = new WidgetUserPasswordVerify$binding$2();

    public WidgetUserPasswordVerify$binding$2() {
        super(1, WidgetUserPasswordVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserPasswordVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserPasswordVerifyBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserPasswordVerifyBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131363051;
        DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
        if (dimmerView != null) {
            i = R$id.edit_account_password_wrap;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.edit_account_password_wrap);
            if (textInputLayout != null) {
                i = R$id.settings_account_save;
                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.settings_account_save);
                if (floatingActionButton != null) {
                    return new WidgetUserPasswordVerifyBinding((CoordinatorLayout) view, dimmerView, textInputLayout, floatingActionButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
