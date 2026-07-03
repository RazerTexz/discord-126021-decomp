package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelSettingsPermissionsAdvancedBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsPermissionsAdvanced$viewBinding$2 extends C12236k implements Function1<View, WidgetChannelSettingsPermissionsAdvancedBinding> {
    public static final WidgetChannelSettingsPermissionsAdvanced$viewBinding$2 INSTANCE = new WidgetChannelSettingsPermissionsAdvanced$viewBinding$2();

    public WidgetChannelSettingsPermissionsAdvanced$viewBinding$2() {
        super(1, WidgetChannelSettingsPermissionsAdvancedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsPermissionsAdvancedBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelSettingsPermissionsAdvancedBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.add_member;
        TextView textView = (TextView) view.findViewById(C5419R.id.add_member);
        if (textView != null) {
            i = C5419R.id.add_role;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.add_role);
            if (textView2 != null) {
                i = C5419R.id.members_container;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.members_container);
                if (linearLayout != null) {
                    i = C5419R.id.members_recycler;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.members_recycler);
                    if (recyclerView != null) {
                        i = C5419R.id.roles_container;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C5419R.id.roles_container);
                        if (linearLayout2 != null) {
                            i = C5419R.id.roles_recycler;
                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(C5419R.id.roles_recycler);
                            if (recyclerView2 != null) {
                                return new WidgetChannelSettingsPermissionsAdvancedBinding((CoordinatorLayout) view, textView, textView2, linearLayout, recyclerView, linearLayout2, recyclerView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
