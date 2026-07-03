package com.discord.utilities.analytics;

import com.discord.api.science.Science;
import com.discord.app.AppLog;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.error.Error;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AnalyticsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsUtils$Tracker$drainEventsQueue$2 extends AbstractC12240o implements Function1<Error, Unit> {
    public final /* synthetic */ ArrayList $copy;
    public final /* synthetic */ AnalyticsUtils.Tracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsUtils$Tracker$drainEventsQueue$2(AnalyticsUtils.Tracker tracker, ArrayList arrayList) {
        super(1);
        this.this$0 = tracker;
        this.$copy = arrayList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        C12238m.checkNotNullParameter(error, "error");
        ArrayList arrayList = this.$copy;
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Science.Event) it.next()).getType());
        }
        AppLog.f14950g.mo8370w("failed to log events: " + arrayList2, error.getThrowable());
        this.this$0.eventsQueue.addAll(this.$copy);
    }
}
