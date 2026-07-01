package com.discord.widgets.servers;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetServerNotificationOverrideSelectorBinding;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerNotificationsOverrideSelector$binding$2 extends k implements Function1<View, WidgetServerNotificationOverrideSelectorBinding> {
    public static final WidgetServerNotificationsOverrideSelector$binding$2 INSTANCE = new WidgetServerNotificationsOverrideSelector$binding$2();

    public WidgetServerNotificationsOverrideSelector$binding$2() {
        super(1, WidgetServerNotificationOverrideSelectorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerNotificationOverrideSelectorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerNotificationOverrideSelectorBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerNotificationOverrideSelectorBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.guild_notifications_channel_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.guild_notifications_channel_list);
        if (recyclerView != null) {
            i = R$id.guild_notifications_channel_search;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.guild_notifications_channel_search);
            if (textInputLayout != null) {
                return new WidgetServerNotificationOverrideSelectorBinding((CoordinatorLayout) view, recyclerView, textInputLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
