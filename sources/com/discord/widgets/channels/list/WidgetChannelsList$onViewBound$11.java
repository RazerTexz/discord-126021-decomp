package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.user.search.WidgetGlobalSearchDialog;
import com.discord.widgets.user.search.WidgetGlobalSearchDialog$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$onViewBound$11 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelsList this$0;

    public WidgetChannelsList$onViewBound$11(WidgetChannelsList widgetChannelsList) {
        this.this$0 = widgetChannelsList;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGlobalSearchDialog$Companion widgetGlobalSearchDialog$Companion = WidgetGlobalSearchDialog.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetGlobalSearchDialog$Companion.show(parentFragmentManager, "@");
    }
}
