package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import com.discord.models.user.User;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import defpackage.l;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$configureProfileActionButtons$8 implements View$OnClickListener {
    public final /* synthetic */ int $userRelationshipType;
    public final /* synthetic */ WidgetUserSheetViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetUserSheet this$0;

    public WidgetUserSheet$configureProfileActionButtons$8(WidgetUserSheet widgetUserSheet, int i, WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded) {
        this.this$0 = widgetUserSheet;
        this.$userRelationshipType = i;
        this.$viewState = widgetUserSheetViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.$userRelationshipType;
        if (i == 3) {
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Context contextRequireContext = this.this$0.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetUserSheet$configureProfileActionButtons$8$2 widgetUserSheet$configureProfileActionButtons$8$2 = new WidgetUserSheet$configureProfileActionButtons$8$2(this);
            WidgetUserSheet$configureProfileActionButtons$8$3 widgetUserSheet$configureProfileActionButtons$8$3 = new WidgetUserSheet$configureProfileActionButtons$8$3(this);
            m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            m.checkNotNullParameter(contextRequireContext, "context");
            m.checkNotNullParameter(widgetUserSheet$configureProfileActionButtons$8$2, "onAccept");
            m.checkNotNullParameter(widgetUserSheet$configureProfileActionButtons$8$3, "onIgnore");
            WidgetNoticeDialog$Companion.show$default(WidgetNoticeDialog.Companion, parentFragmentManager, b.h(contextRequireContext, 2131892031, new Object[0], null, 4), b.h(contextRequireContext, 2131896782, new Object[0], null, 4), b.h(contextRequireContext, 2131889453, new Object[0], null, 4), b.h(contextRequireContext, 2131889459, new Object[0], null, 4), h0.mapOf(o.to(2131364555, new l(0, widgetUserSheet$configureProfileActionButtons$8$2)), o.to(2131364550, new l(1, widgetUserSheet$configureProfileActionButtons$8$3))), null, null, null, null, null, null, 0, null, 16320, null);
            return;
        }
        if (i != 4) {
            return;
        }
        User user = this.$viewState.getUser();
        Context contextRequireContext2 = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        FragmentManager parentFragmentManager2 = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
        WidgetUserSheet$configureProfileActionButtons$8$1 widgetUserSheet$configureProfileActionButtons$8$1 = new WidgetUserSheet$configureProfileActionButtons$8$1(WidgetUserSheet.access$getViewModel$p(this.this$0));
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(contextRequireContext2, "context");
        m.checkNotNullParameter(parentFragmentManager2, "fragmentManager");
        m.checkNotNullParameter(widgetUserSheet$configureProfileActionButtons$8$1, "onConfirm");
        WidgetNoticeDialog$Companion.show$default(WidgetNoticeDialog.Companion, parentFragmentManager2, b.h(contextRequireContext2, 2131893553, new Object[0], null, 4), b.h(contextRequireContext2, 2131893554, new Object[]{user.getUsername()}, null, 4), b.h(contextRequireContext2, 2131888369, new Object[0], null, 4), b.h(contextRequireContext2, 2131887437, new Object[0], null, 4), g0.mapOf(o.to(2131364555, new b.a.a.l(widgetUserSheet$configureProfileActionButtons$8$1))), null, null, null, 2130969885, null, null, 0, null, 15808, null);
    }
}
