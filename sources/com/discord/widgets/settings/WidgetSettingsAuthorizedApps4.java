package com.discord.widgets.settings;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsAuthorizedAppsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAuthorizedApps$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAuthorizedApps4 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAuthorizedAppsBinding> {
    public static final WidgetSettingsAuthorizedApps4 INSTANCE = new WidgetSettingsAuthorizedApps4();

    public WidgetSettingsAuthorizedApps4() {
        super(1, WidgetSettingsAuthorizedAppsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAuthorizedAppsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsAuthorizedAppsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.authorized_apps_list);
        if (recyclerView != null) {
            return new WidgetSettingsAuthorizedAppsBinding((CoordinatorLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.authorized_apps_list)));
    }
}
