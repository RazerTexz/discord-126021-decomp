package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetChannelSettingsPermissionsAdvancedBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsPermissionsAdvanced$viewBinding$2 extends k implements Function1<View, WidgetChannelSettingsPermissionsAdvancedBinding> {
    public static final WidgetChannelSettingsPermissionsAdvanced$viewBinding$2 INSTANCE = new WidgetChannelSettingsPermissionsAdvanced$viewBinding$2();

    public WidgetChannelSettingsPermissionsAdvanced$viewBinding$2() {
        super(1, WidgetChannelSettingsPermissionsAdvancedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsPermissionsAdvancedBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelSettingsPermissionsAdvancedBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelSettingsPermissionsAdvancedBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.add_member;
        TextView textView = (TextView) view.findViewById(R$id.add_member);
        if (textView != null) {
            i = R$id.add_role;
            TextView textView2 = (TextView) view.findViewById(R$id.add_role);
            if (textView2 != null) {
                i = R$id.members_container;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.members_container);
                if (linearLayout != null) {
                    i = R$id.members_recycler;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.members_recycler);
                    if (recyclerView != null) {
                        i = R$id.roles_container;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.roles_container);
                        if (linearLayout2 != null) {
                            i = R$id.roles_recycler;
                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R$id.roles_recycler);
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
