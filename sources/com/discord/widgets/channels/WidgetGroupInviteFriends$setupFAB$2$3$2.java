package com.discord.widgets.channels;

import com.discord.stores.StoreStream;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$setupFAB$2$3$2 extends o implements Function0<Unit> {
    public static final WidgetGroupInviteFriends$setupFAB$2$3$2 INSTANCE = new WidgetGroupInviteFriends$setupFAB$2$3$2();

    public WidgetGroupInviteFriends$setupFAB$2$3$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStream.Companion.getMediaEngine().selectVideoInputDevice(null);
    }
}
