package com.discord.widgets.notice;

import com.discord.models.user.MeUser;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink$Companion$enqueue$2 extends AbstractC12240o implements Function1<Pair<? extends Boolean, ? extends MeUser>, Unit> {
    public final /* synthetic */ Clock $clock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoticeNuxSamsungLink$Companion$enqueue$2(Clock clock) {
        super(1);
        this.$clock = clock;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends MeUser> pair) {
        invoke2((Pair<Boolean, MeUser>) pair);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<Boolean, MeUser> pair) {
        Boolean boolComponent1 = pair.component1();
        MeUser meUserComponent2 = pair.component2();
        if (!boolComponent1.booleanValue()) {
            C12238m.checkNotNullParameter("google", "flavorVendor");
            if (!C12238m.areEqual("google", "samsung")) {
                StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), "NUX/SamsungLink", 0L, 2, null);
            }
        }
        UserUtils userUtils = UserUtils.INSTANCE;
        C12238m.checkNotNullExpressionValue(meUserComponent2, "meUser");
        if (userUtils.getAgeMs(meUserComponent2, this.$clock) > 2419200000L) {
            WidgetNoticeNuxSamsungLink.INSTANCE.internalEnqueue();
        }
    }
}
