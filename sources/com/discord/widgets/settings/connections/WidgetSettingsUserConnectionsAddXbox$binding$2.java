package com.discord.widgets.settings.connections;

import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetConnectionsAddXboxBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsUserConnectionsAddXbox$binding$2 extends k implements Function1<View, WidgetConnectionsAddXboxBinding> {
    public static final WidgetSettingsUserConnectionsAddXbox$binding$2 INSTANCE = new WidgetSettingsUserConnectionsAddXbox$binding$2();

    public WidgetSettingsUserConnectionsAddXbox$binding$2() {
        super(1, WidgetConnectionsAddXboxBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetConnectionsAddXboxBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetConnectionsAddXboxBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetConnectionsAddXboxBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.connections_xbox_code;
        CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(R$id.connections_xbox_code);
        if (codeVerificationView != null) {
            i = R$id.connections_xbox_login;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.connections_xbox_login);
            if (linearLayout != null) {
                i = 2131363051;
                DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
                if (dimmerView != null) {
                    return new WidgetConnectionsAddXboxBinding((CoordinatorLayout) view, codeVerificationView, linearLayout, dimmerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
