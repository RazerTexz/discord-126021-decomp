package com.discord.utilities.presence;

import com.discord.api.activity.Activity;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.presence.PresenceUtils$ACTIVITY_COMPARATOR$2, reason: use source file name */
/* JADX INFO: compiled from: PresenceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PresenceUtils3 extends Lambda implements Function1<Activity, Comparable<?>> {
    public static final PresenceUtils3 INSTANCE = new PresenceUtils3();

    public PresenceUtils3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Comparable<?> invoke(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, "it");
        return Boolean.valueOf(ActivityUtils.isRichPresence(activity));
    }
}
