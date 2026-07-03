package com.discord.widgets.auth;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetAuthLandingBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAuthLanding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthLanding$binding$2 extends C12236k implements Function1<View, WidgetAuthLandingBinding> {
    public static final WidgetAuthLanding$binding$2 INSTANCE = new WidgetAuthLanding$binding$2();

    public WidgetAuthLanding$binding$2() {
        super(1, WidgetAuthLandingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthLandingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAuthLandingBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.auth_bottom_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.auth_bottom_container);
        if (linearLayout != null) {
            i = C5419R.id.auth_landing_invite_info;
            AuthInviteInfoView authInviteInfoView = (AuthInviteInfoView) view.findViewById(C5419R.id.auth_landing_invite_info);
            if (authInviteInfoView != null) {
                i = C5419R.id.auth_landing_login;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.auth_landing_login);
                if (materialButton != null) {
                    i = C5419R.id.auth_landing_logo;
                    ImageView imageView = (ImageView) view.findViewById(C5419R.id.auth_landing_logo);
                    if (imageView != null) {
                        i = C5419R.id.auth_landing_register;
                        MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.auth_landing_register);
                        if (materialButton2 != null) {
                            i = C5419R.id.auth_landing_switch_flipper;
                            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.auth_landing_switch_flipper);
                            if (appViewFlipper != null) {
                                i = C5419R.id.auth_landing_title;
                                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(C5419R.id.auth_landing_title);
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
