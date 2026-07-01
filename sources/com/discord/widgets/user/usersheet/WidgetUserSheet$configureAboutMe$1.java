package com.discord.widgets.user.usersheet;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.k.b;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$configureAboutMe$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserSheetViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetUserSheet this$0;

    public WidgetUserSheet$configureAboutMe$1(WidgetUserSheet widgetUserSheet, WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded) {
        this.this$0 = widgetUserSheet;
        this.$viewState = widgetUserSheetViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$viewState.getHasGuildMemberBio()) {
            m.checkNotNullExpressionValue(view, "it");
            b.a.d.m.h(view.getContext(), b.k(this.this$0, 2131890263, new Object[]{this.$viewState.getGuildName()}, null, 4), 0, null, 12);
        }
    }
}
