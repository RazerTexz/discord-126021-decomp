package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.TextView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$configureDeveloperSection$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ TextView $this_apply;
    public final /* synthetic */ WidgetUserSheetViewModel$ViewState$Loaded $viewState$inlined;
    public final /* synthetic */ WidgetUserSheet this$0;

    public WidgetUserSheet$configureDeveloperSection$$inlined$apply$lambda$1(TextView textView, WidgetUserSheet widgetUserSheet, WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded) {
        this.$this_apply = textView;
        this.this$0 = widgetUserSheet;
        this.$viewState$inlined = widgetUserSheetViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Context context = this.$this_apply.getContext();
        m.checkNotNullExpressionValue(context, "context");
        b.a.d.m.c(context, String.valueOf(this.$viewState$inlined.getUser().getId()), 0, 4);
        this.this$0.dismiss();
    }
}
