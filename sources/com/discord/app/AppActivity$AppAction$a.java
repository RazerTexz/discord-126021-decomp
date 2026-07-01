package com.discord.app;

import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.tabs.WidgetTabsHost;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppActivity$AppAction$a extends o implements Function0<Class<? extends AppFragment>> {
    public final /* synthetic */ AppActivity$AppAction this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppActivity$AppAction$a(AppActivity$AppAction appActivity$AppAction) {
        super(0);
        this.this$0 = appActivity$AppAction;
    }

    @Override // kotlin.jvm.functions.Function0
    public Class<? extends AppFragment> invoke() {
        int iHashCode;
        String action = this.this$0.c().getAction();
        return (action != null && ((iHashCode = action.hashCode()) == -1173264947 ? action.equals("android.intent.action.SEND") : !(iHashCode == -1103390587 ? !action.equals("com.discord.intent.action.SDK") : !(iHashCode == -58484670 && action.equals("android.intent.action.SEND_MULTIPLE"))))) ? WidgetIncomingShare.class : WidgetTabsHost.class;
    }
}
