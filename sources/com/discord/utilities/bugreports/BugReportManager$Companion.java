package com.discord.utilities.bugreports;

import com.discord.utilities.cache.SharedPreferencesProvider;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BugReportManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportManager$Companion {
    private BugReportManager$Companion() {
    }

    public final BugReportManager get() {
        BugReportManager bugReportManagerAccess$getBugReportManager$cp = BugReportManager.access$getBugReportManager$cp();
        if (bugReportManagerAccess$getBugReportManager$cp == null) {
            m.throwUninitializedPropertyAccessException("bugReportManager");
        }
        return bugReportManagerAccess$getBugReportManager$cp;
    }

    public final void init() {
        BugReportManager.access$setBugReportManager$cp(new BugReportManager(SharedPreferencesProvider.INSTANCE.get(), null, 2, null));
        BugReportManager bugReportManagerAccess$getBugReportManager$cp = BugReportManager.access$getBugReportManager$cp();
        if (bugReportManagerAccess$getBugReportManager$cp == null) {
            m.throwUninitializedPropertyAccessException("bugReportManager");
        }
        bugReportManagerAccess$getBugReportManager$cp.setupSubscriptions();
    }

    public /* synthetic */ BugReportManager$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
