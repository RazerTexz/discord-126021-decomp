package com.discord.widgets.user.search;

import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.o;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGlobalSearchDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchDialog$Companion {
    private WidgetGlobalSearchDialog$Companion() {
    }

    public static /* synthetic */ void show$default(WidgetGlobalSearchDialog$Companion widgetGlobalSearchDialog$Companion, FragmentManager fragmentManager, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        widgetGlobalSearchDialog$Companion.show(fragmentManager, str);
    }

    public final void dismiss(FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag("javaClass");
        if (fragmentFindFragmentByTag == null || !(fragmentFindFragmentByTag instanceof WidgetGlobalSearchDialog)) {
            return;
        }
        ((WidgetGlobalSearchDialog) fragmentFindFragmentByTag).dismiss();
    }

    public final void show(FragmentManager fragmentManager, String searchText) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        dismiss(fragmentManager);
        WidgetGlobalSearchDialog widgetGlobalSearchDialog = new WidgetGlobalSearchDialog();
        widgetGlobalSearchDialog.setArguments(BundleKt.bundleOf(o.to(WidgetGlobalSearch.EXTRA_SEARCH_TEXT, searchText)));
        widgetGlobalSearchDialog.show(fragmentManager, "javaClass");
        AnalyticsTracker.INSTANCE.quickSwitcherOpen();
    }

    public /* synthetic */ WidgetGlobalSearchDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
