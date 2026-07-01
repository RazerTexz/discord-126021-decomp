package com.discord.widgets.auth;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetAuthLandingBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLanding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthLanding$binding$2 extends k implements Function1<View, WidgetAuthLandingBinding> {
    public static final WidgetAuthLanding$binding$2 INSTANCE = new WidgetAuthLanding$binding$2();

    public WidgetAuthLanding$binding$2() {
        super(1, WidgetAuthLandingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthLandingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthLandingBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthLandingBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.auth_bottom_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.auth_bottom_container);
        if (linearLayout != null) {
            i = R$id.auth_landing_invite_info;
            AuthInviteInfoView authInviteInfoView = (AuthInviteInfoView) view.findViewById(R$id.auth_landing_invite_info);
            if (authInviteInfoView != null) {
                i = R$id.auth_landing_login;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.auth_landing_login);
                if (materialButton != null) {
                    i = R$id.auth_landing_logo;
                    ImageView imageView = (ImageView) view.findViewById(R$id.auth_landing_logo);
                    if (imageView != null) {
                        i = R$id.auth_landing_register;
                        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.auth_landing_register);
                        if (materialButton2 != null) {
                            i = R$id.auth_landing_switch_flipper;
                            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.auth_landing_switch_flipper);
                            if (appViewFlipper != null) {
                                i = R$id.auth_landing_title;
                                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R$id.auth_landing_title);
                                if (screenTitleView != null) {
                                    return new WidgetAuthLandingBinding((RelativeLayout) view, linearLayout, authInviteInfoView, materialButton, imageView, materialButton2, appViewFlipper, screenTitleView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
