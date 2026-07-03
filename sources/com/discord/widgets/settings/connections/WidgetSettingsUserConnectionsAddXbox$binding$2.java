package com.discord.widgets.settings.connections;

import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetConnectionsAddXboxBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsUserConnectionsAddXbox$binding$2 extends C12236k implements Function1<View, WidgetConnectionsAddXboxBinding> {
    public static final WidgetSettingsUserConnectionsAddXbox$binding$2 INSTANCE = new WidgetSettingsUserConnectionsAddXbox$binding$2();

    public WidgetSettingsUserConnectionsAddXbox$binding$2() {
        super(1, WidgetConnectionsAddXboxBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetConnectionsAddXboxBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetConnectionsAddXboxBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.connections_xbox_code;
        CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(C5419R.id.connections_xbox_code);
        if (codeVerificationView != null) {
            i = C5419R.id.connections_xbox_login;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.connections_xbox_login);
            if (linearLayout != null) {
                i = C5419R.id.dimmer_view;
                DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
                if (dimmerView != null) {
                    return new WidgetConnectionsAddXboxBinding((CoordinatorLayout) view, codeVerificationView, linearLayout, dimmerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
