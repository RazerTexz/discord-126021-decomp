package com.discord.widgets.user;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetUserPasswordVerifyBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserPasswordVerify$binding$2 extends C12236k implements Function1<View, WidgetUserPasswordVerifyBinding> {
    public static final WidgetUserPasswordVerify$binding$2 INSTANCE = new WidgetUserPasswordVerify$binding$2();

    public WidgetUserPasswordVerify$binding$2() {
        super(1, WidgetUserPasswordVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserPasswordVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserPasswordVerifyBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
        if (dimmerView != null) {
            i = C5419R.id.edit_account_password_wrap;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.edit_account_password_wrap);
            if (textInputLayout != null) {
                i = C5419R.id.settings_account_save;
                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.settings_account_save);
                if (floatingActionButton != null) {
                    return new WidgetUserPasswordVerifyBinding((CoordinatorLayout) view, dimmerView, textInputLayout, floatingActionButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
