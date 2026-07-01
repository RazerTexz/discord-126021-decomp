package com.discord.widgets.servers;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetServerNotificationOverrideSelectorBinding;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerNotificationsOverrideSelector$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerNotificationsOverrideSelector3 extends FunctionReferenceImpl implements Function1<View, WidgetServerNotificationOverrideSelectorBinding> {
    public static final WidgetServerNotificationsOverrideSelector3 INSTANCE = new WidgetServerNotificationsOverrideSelector3();

    public WidgetServerNotificationsOverrideSelector3() {
        super(1, WidgetServerNotificationOverrideSelectorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerNotificationOverrideSelectorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerNotificationOverrideSelectorBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_notifications_channel_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.guild_notifications_channel_list);
        if (recyclerView != null) {
            i = R.id.guild_notifications_channel_search;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.guild_notifications_channel_search);
            if (textInputLayout != null) {
                return new WidgetServerNotificationOverrideSelectorBinding((CoordinatorLayout) view, recyclerView, textInputLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
