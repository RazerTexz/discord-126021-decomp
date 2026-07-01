package com.discord.widgets.forums;

import android.os.Bundle;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentKt;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetForumGuidelinesBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumGuidelinesBottomSheet$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ Bundle $bundle;
    public final /* synthetic */ WidgetForumGuidelinesBottomSheet this$0;

    public WidgetForumGuidelinesBottomSheet$configureUI$1(WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet, Bundle bundle) {
        this.this$0 = widgetForumGuidelinesBottomSheet;
        this.$bundle = bundle;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet = this.this$0;
        String strAccess$getRequestKey$p = WidgetForumGuidelinesBottomSheet.access$getRequestKey$p(widgetForumGuidelinesBottomSheet);
        m.checkNotNullExpressionValue(strAccess$getRequestKey$p, "requestKey");
        FragmentKt.setFragmentResult(widgetForumGuidelinesBottomSheet, strAccess$getRequestKey$p, this.$bundle);
    }
}
