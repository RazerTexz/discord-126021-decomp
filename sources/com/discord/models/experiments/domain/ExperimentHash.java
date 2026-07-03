package com.discord.models.experiments.domain;

import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p647e.C12723m;

/* JADX INFO: compiled from: ExperimentHash.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ExperimentHash {
    public static final ExperimentHash INSTANCE = new ExperimentHash();

    private ExperimentHash() {
    }

    public final long from(CharSequence name) {
        C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int iM10822a = C12723m.m10822a(name, 0, name.length(), 0);
        return iM10822a < 0 ? ((long) iM10822a) + Permission.REQUEST_TO_SPEAK : iM10822a;
    }
}
