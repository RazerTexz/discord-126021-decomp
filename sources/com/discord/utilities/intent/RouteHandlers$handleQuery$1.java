package com.discord.utilities.intent;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.user.search.WidgetGlobalSearchDialog;
import com.discord.widgets.user.search.WidgetGlobalSearchDialog$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RouteHandlers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RouteHandlers$handleQuery$1 extends o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ String $query;
    public final /* synthetic */ String $queryMessageText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteHandlers$handleQuery$1(String str, String str2) {
        super(1);
        this.$queryMessageText = str;
        this.$query = str2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, "ctx");
        if (this.$queryMessageText.length() > 0) {
            WidgetIncomingShare.Companion.launch(fragmentActivity, this.$queryMessageText, this.$query);
        } else {
            WidgetGlobalSearchDialog$Companion widgetGlobalSearchDialog$Companion = WidgetGlobalSearchDialog.Companion;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            m.checkNotNullExpressionValue(supportFragmentManager, "ctx.supportFragmentManager");
            widgetGlobalSearchDialog$Companion.show(supportFragmentManager, this.$query);
        }
        return true;
    }
}
