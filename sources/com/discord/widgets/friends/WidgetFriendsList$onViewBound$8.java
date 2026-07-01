package com.discord.widgets.friends;

import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.PopupMenu;
import com.discord.R$id;
import com.discord.R$menu;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsList$onViewBound$8 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetFriendsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsList$onViewBound$8(WidgetFriendsList widgetFriendsList) {
        super(1);
        this.this$0 = widgetFriendsList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "upsellView");
        PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(view.getContext(), 2131951663), view);
        popupMenu.getMenuInflater().inflate(R$menu.menu_contact_sync_upsell, popupMenu.getMenu());
        popupMenu.getMenu().findItem(R$id.menu_contact_sync_upsell_dismiss).setOnMenuItemClickListener(new WidgetFriendsList$onViewBound$8$1(this));
        popupMenu.show();
    }
}
