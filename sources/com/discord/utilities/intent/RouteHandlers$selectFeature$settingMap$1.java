package com.discord.utilities.intent;

import androidx.fragment.app.FragmentActivity;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.discord.widgets.settings.account.WidgetSettingsAccount$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RouteHandlers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RouteHandlers$selectFeature$settingMap$1 extends o implements Function1<FragmentActivity, Unit> {
    public static final RouteHandlers$selectFeature$settingMap$1 INSTANCE = new RouteHandlers$selectFeature$settingMap$1();

    public RouteHandlers$selectFeature$settingMap$1() {
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
        WidgetSettingsAccount$Companion.launch$default(WidgetSettingsAccount.Companion, fragmentActivity, false, null, 6, null);
    }
}
