package com.discord.widgets.servers;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerNotificationOverrideSelectorBinding;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerNotificationsOverrideSelector$binding$2 extends C12236k implements Function1<View, WidgetServerNotificationOverrideSelectorBinding> {
    public static final WidgetServerNotificationsOverrideSelector$binding$2 INSTANCE = new WidgetServerNotificationsOverrideSelector$binding$2();

    public WidgetServerNotificationsOverrideSelector$binding$2() {
        super(1, WidgetServerNotificationOverrideSelectorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerNotificationOverrideSelectorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerNotificationOverrideSelectorBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_notifications_channel_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.guild_notifications_channel_list);
        if (recyclerView != null) {
            i = C5419R.id.guild_notifications_channel_search;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.guild_notifications_channel_search);
            if (textInputLayout != null) {
                return new WidgetServerNotificationOverrideSelectorBinding((CoordinatorLayout) view, recyclerView, textInputLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
