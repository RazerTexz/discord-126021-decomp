package com.discord.widgets.settings;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsAuthorizedAppsBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAuthorizedApps$binding$2 extends C12236k implements Function1<View, WidgetSettingsAuthorizedAppsBinding> {
    public static final WidgetSettingsAuthorizedApps$binding$2 INSTANCE = new WidgetSettingsAuthorizedApps$binding$2();

    public WidgetSettingsAuthorizedApps$binding$2() {
        super(1, WidgetSettingsAuthorizedAppsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAuthorizedAppsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsAuthorizedAppsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.authorized_apps_list);
        if (recyclerView != null) {
            return new WidgetSettingsAuthorizedAppsBinding((CoordinatorLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.authorized_apps_list)));
    }
}
