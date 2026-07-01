package com.discord.utilities.intent;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.user.search.WidgetGlobalSearchDialog;
import com.discord.widgets.user.search.WidgetGlobalSearchDialog$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RouteHandlers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RouteHandlers$selectFeature$settingMap$5 extends o implements Function1<FragmentActivity, Unit> {
    public static final RouteHandlers$selectFeature$settingMap$5 INSTANCE = new RouteHandlers$selectFeature$settingMap$5();

    public RouteHandlers$selectFeature$settingMap$5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity) {
        invoke2(fragmentActivity);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, "ctx");
        WidgetGlobalSearchDialog$Companion widgetGlobalSearchDialog$Companion = WidgetGlobalSearchDialog.Companion;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "ctx.supportFragmentManager");
        WidgetGlobalSearchDialog$Companion.show$default(widgetGlobalSearchDialog$Companion, supportFragmentManager, null, 2, null);
    }
}
