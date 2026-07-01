package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import b.a.i.v5;
import b.a.i.w5;
import b.a.i.x5;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetRemoteAuthBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetRemoteAuth.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetRemoteAuth$binding$2 extends k implements Function1<View, WidgetRemoteAuthBinding> {
    public static final WidgetRemoteAuth$binding$2 INSTANCE = new WidgetRemoteAuth$binding$2();

    public WidgetRemoteAuth$binding$2() {
        super(1, WidgetRemoteAuthBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetRemoteAuthBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetRemoteAuthBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetRemoteAuthBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.auth_success;
        View viewFindViewById = view.findViewById(R$id.auth_success);
        if (viewFindViewById != null) {
            MaterialButton materialButton = (MaterialButton) viewFindViewById.findViewById(R$id.remote_auth_finish_button);
            if (materialButton == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(R$id.remote_auth_finish_button)));
            }
            x5 x5Var = new x5((LinearLayout) viewFindViewById, materialButton);
            i = R$id.not_found;
            View viewFindViewById2 = view.findViewById(R$id.not_found);
            if (viewFindViewById2 != null) {
                MaterialButton materialButton2 = (MaterialButton) viewFindViewById2.findViewById(R$id.remote_auth_not_found_cancel_button);
                if (materialButton2 == null) {
                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById2.getResources().getResourceName(R$id.remote_auth_not_found_cancel_button)));
                }
                v5 v5Var = new v5((LinearLayout) viewFindViewById2, materialButton2);
                i = R$id.pending_login;
                View viewFindViewById3 = view.findViewById(R$id.pending_login);
                if (viewFindViewById3 != null) {
                    int i2 = R$id.remote_auth_cancel_button;
                    MaterialButton materialButton3 = (MaterialButton) viewFindViewById3.findViewById(R$id.remote_auth_cancel_button);
                    if (materialButton3 != null) {
                        i2 = R$id.remote_auth_login_button;
                        MaterialButton materialButton4 = (MaterialButton) viewFindViewById3.findViewById(R$id.remote_auth_login_button);
                        if (materialButton4 != null) {
                            i2 = R$id.remote_auth_temporary_switch;
                            SwitchMaterial switchMaterial = (SwitchMaterial) viewFindViewById3.findViewById(R$id.remote_auth_temporary_switch);
                            if (switchMaterial != null) {
                                w5 w5Var = new w5((LinearLayout) viewFindViewById3, materialButton3, materialButton4, switchMaterial);
                                i = R$id.remote_auth_view_flipper;
                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.remote_auth_view_flipper);
                                if (appViewFlipper != null) {
                                    return new WidgetRemoteAuthBinding((RelativeLayout) view, x5Var, v5Var, w5Var, appViewFlipper);
                                }
                            }
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById3.getResources().getResourceName(i2)));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
