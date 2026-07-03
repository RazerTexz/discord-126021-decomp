package com.discord.utilities.presence;

import com.discord.api.activity.Activity;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PresenceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PresenceUtils$ACTIVITY_COMPARATOR$3 extends AbstractC12240o implements Function1<Activity, Comparable<?>> {
    public static final PresenceUtils$ACTIVITY_COMPARATOR$3 INSTANCE = new PresenceUtils$ACTIVITY_COMPARATOR$3();

    public PresenceUtils$ACTIVITY_COMPARATOR$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Comparable<?> invoke(Activity activity) {
        C12238m.checkNotNullParameter(activity, "it");
        return Long.valueOf(activity.getCreatedAt());
    }
}
