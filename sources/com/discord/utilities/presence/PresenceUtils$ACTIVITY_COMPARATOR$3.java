package com.discord.utilities.presence;

import com.discord.api.activity.Activity;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PresenceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PresenceUtils$ACTIVITY_COMPARATOR$3 extends o implements Function1<Activity, Comparable<?>> {
    public static final PresenceUtils$ACTIVITY_COMPARATOR$3 INSTANCE = new PresenceUtils$ACTIVITY_COMPARATOR$3();

    public PresenceUtils$ACTIVITY_COMPARATOR$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Comparable<?> invoke(Activity activity) {
        return invoke2(activity);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Comparable<?> invoke2(Activity activity) {
        m.checkNotNullParameter(activity, "it");
        return Long.valueOf(activity.getCreatedAt());
    }
}
