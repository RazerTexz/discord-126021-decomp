package com.discord.widgets.quickmentions;

import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.user.search.WidgetGlobalSearch;
import d0.o;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetQuickMentionsDialog$Companion {
    private WidgetQuickMentionsDialog$Companion() {
    }

    public static /* synthetic */ void show$default(WidgetQuickMentionsDialog$Companion widgetQuickMentionsDialog$Companion, FragmentManager fragmentManager, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        widgetQuickMentionsDialog$Companion.show(fragmentManager, str);
    }

    public final void dismiss(FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag("javaClass");
        if (fragmentFindFragmentByTag instanceof WidgetQuickMentionsDialog) {
            ((WidgetQuickMentionsDialog) fragmentFindFragmentByTag).dismiss();
        }
    }

    public final void show(FragmentManager fragmentManager, String searchText) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        dismiss(fragmentManager);
        WidgetQuickMentionsDialog widgetQuickMentionsDialog = new WidgetQuickMentionsDialog();
        widgetQuickMentionsDialog.setArguments(BundleKt.bundleOf(o.to(WidgetGlobalSearch.EXTRA_SEARCH_TEXT, searchText)));
        widgetQuickMentionsDialog.show(fragmentManager, "javaClass");
        AnalyticsTracker.INSTANCE.quickSwitcherOpen();
    }

    public /* synthetic */ WidgetQuickMentionsDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
