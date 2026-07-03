package com.discord.widgets.servers.settings.invites;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsInstantInvitesBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsInstantInvites$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsInstantInvitesBinding> {
    public static final WidgetServerSettingsInstantInvites$binding$2 INSTANCE = new WidgetServerSettingsInstantInvites$binding$2();

    public WidgetServerSettingsInstantInvites$binding$2() {
        super(1, WidgetServerSettingsInstantInvitesBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsInstantInvitesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsInstantInvitesBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.no_invites_body;
        TextView textView = (TextView) view.findViewById(C5419R.id.no_invites_body);
        if (textView != null) {
            i = C5419R.id.no_invites_header;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.no_invites_header);
            if (textView2 != null) {
                i = C5419R.id.server_settings_instant_invites_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.server_settings_instant_invites_recycler);
                if (recyclerView != null) {
                    i = C5419R.id.server_settings_instant_invites_view_flipper;
                    AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.server_settings_instant_invites_view_flipper);
                    if (appViewFlipper != null) {
                        return new WidgetServerSettingsInstantInvitesBinding((CoordinatorLayout) view, textView, textView2, recyclerView, appViewFlipper);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
