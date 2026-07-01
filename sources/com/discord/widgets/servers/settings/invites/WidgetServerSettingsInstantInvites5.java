package com.discord.widgets.servers.settings.invites;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsInstantInvitesBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsInstantInvites5 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsInstantInvitesBinding> {
    public static final WidgetServerSettingsInstantInvites5 INSTANCE = new WidgetServerSettingsInstantInvites5();

    public WidgetServerSettingsInstantInvites5() {
        super(1, WidgetServerSettingsInstantInvitesBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsInstantInvitesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsInstantInvitesBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.no_invites_body;
        TextView textView = (TextView) view.findViewById(R.id.no_invites_body);
        if (textView != null) {
            i = R.id.no_invites_header;
            TextView textView2 = (TextView) view.findViewById(R.id.no_invites_header);
            if (textView2 != null) {
                i = R.id.server_settings_instant_invites_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.server_settings_instant_invites_recycler);
                if (recyclerView != null) {
                    i = R.id.server_settings_instant_invites_view_flipper;
                    AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.server_settings_instant_invites_view_flipper);
                    if (appViewFlipper != null) {
                        return new WidgetServerSettingsInstantInvitesBinding((CoordinatorLayout) view, textView, textView2, recyclerView, appViewFlipper);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
