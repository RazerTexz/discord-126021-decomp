package com.discord.utilities.analytics;

import com.discord.api.science.Science$Event;
import com.discord.app.AppLog;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AnalyticsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsUtils$Tracker$drainEventsQueue$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ ArrayList $copy;
    public final /* synthetic */ AnalyticsUtils$Tracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsUtils$Tracker$drainEventsQueue$2(AnalyticsUtils$Tracker analyticsUtils$Tracker, ArrayList arrayList) {
        super(1);
        this.this$0 = analyticsUtils$Tracker;
        this.$copy = arrayList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        ArrayList arrayList = this.$copy;
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Science$Event) it.next()).getType());
        }
        AppLog.g.w("failed to log events: " + arrayList2, error.getThrowable());
        AnalyticsUtils$Tracker.access$getEventsQueue$p(this.this$0).addAll(this.$copy);
    }
}
