package com.discord.models.experiments.domain;

import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: ExperimentHash.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ExperimentHash {
    public static final ExperimentHash INSTANCE = new ExperimentHash();

    private ExperimentHash() {
    }

    public final long from(CharSequence name) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int iA = j0.l.e.m.a(name, 0, name.length(), 0);
        return iA < 0 ? ((long) iA) + Permission.REQUEST_TO_SPEAK : iA;
    }
}
