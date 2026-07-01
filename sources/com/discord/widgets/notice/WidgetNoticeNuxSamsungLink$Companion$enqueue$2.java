package com.discord.widgets.notice;

import com.discord.models.user.MeUser;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink$Companion$enqueue$2 extends o implements Function1<Pair<? extends Boolean, ? extends MeUser>, Unit> {
    public final /* synthetic */ Clock $clock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoticeNuxSamsungLink$Companion$enqueue$2(Clock clock) {
        super(1);
        this.$clock = clock;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends MeUser> pair) {
        invoke2((Pair<Boolean, MeUser>) pair);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<Boolean, MeUser> pair) {
        Boolean boolComponent1 = pair.component1();
        MeUser meUserComponent2 = pair.component2();
        if (!boolComponent1.booleanValue()) {
            m.checkNotNullParameter("google", "flavorVendor");
            if (!m.areEqual("google", "samsung")) {
                StoreNotices.markSeen$default(StoreStream.Companion.getNotices(), "NUX/SamsungLink", 0L, 2, null);
            }
        }
        UserUtils userUtils = UserUtils.INSTANCE;
        m.checkNotNullExpressionValue(meUserComponent2, "meUser");
        if (userUtils.getAgeMs(meUserComponent2, this.$clock) > 2419200000L) {
            WidgetNoticeNuxSamsungLink$Companion.access$internalEnqueue(WidgetNoticeNuxSamsungLink.Companion);
        }
    }
}
