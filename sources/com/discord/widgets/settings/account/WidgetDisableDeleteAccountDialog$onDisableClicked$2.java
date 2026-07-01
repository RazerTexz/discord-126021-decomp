package com.discord.widgets.settings.account;

import com.discord.stores.StoreStream;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableDeleteAccountDialog$onDisableClicked$2 extends o implements Function1<Void, Unit> {
    public static final WidgetDisableDeleteAccountDialog$onDisableClicked$2 INSTANCE = new WidgetDisableDeleteAccountDialog$onDisableClicked$2();

    public WidgetDisableDeleteAccountDialog$onDisableClicked$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r1) {
        StoreStream.Companion.getAuthentication().logout();
    }
}
