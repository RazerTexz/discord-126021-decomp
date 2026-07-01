package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsChannelsSortActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannelsSortActions$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsChannelsSortActions this$0;

    public WidgetServerSettingsChannelsSortActions$configureUI$1(WidgetServerSettingsChannelsSortActions widgetServerSettingsChannelsSortActions) {
        this.this$0 = widgetServerSettingsChannelsSortActions;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1<Integer, Unit> sortTypeSelectedListener = this.this$0.getSortTypeSelectedListener();
        if (sortTypeSelectedListener != null) {
            sortTypeSelectedListener.invoke(4);
        }
        this.this$0.dismiss();
    }
}
