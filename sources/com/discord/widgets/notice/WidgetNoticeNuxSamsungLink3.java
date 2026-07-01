package com.discord.widgets.notice;

import com.discord.models.user.MeUser;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink$Companion$enqueue$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink3 extends Lambda implements Function1<Tuples2<? extends Boolean, ? extends MeUser>, Unit> {
    public final /* synthetic */ Clock $clock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoticeNuxSamsungLink3(Clock clock) {
        super(1);
        this.$clock = clock;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends Boolean, ? extends MeUser> tuples2) {
        invoke2((Tuples2<Boolean, MeUser>) tuples2);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Tuples2<Boolean, MeUser> tuples2) {
        Boolean boolComponent1 = tuples2.component1();
        MeUser meUserComponent2 = tuples2.component2();
        if (!boolComponent1.booleanValue()) {
            Intrinsics3.checkNotNullParameter("google", "flavorVendor");
            if (!Intrinsics3.areEqual("google", "samsung")) {
                StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), "NUX/SamsungLink", 0L, 2, null);
            }
        }
        UserUtils userUtils = UserUtils.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(meUserComponent2, "meUser");
        if (userUtils.getAgeMs(meUserComponent2, this.$clock) > 2419200000L) {
            WidgetNoticeNuxSamsungLink.INSTANCE.internalEnqueue();
        }
    }
}
