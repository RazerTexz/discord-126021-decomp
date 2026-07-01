package com.discord.stores.updates;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.u;
import d0.z.d.m;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ObservationDeck.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObservationDeck$Observer {
    private boolean isStale;

    public abstract String getName();

    public abstract Set<ObservationDeck$UpdateSource> getObservingUpdates();

    public abstract Function0<Unit> getOnUpdate();

    /* JADX INFO: renamed from: isStale, reason: from getter */
    public final boolean getIsStale() {
        return this.isStale;
    }

    public final void markStale() {
        this.isStale = true;
        setOnUpdate(ObservationDeck.access$getON_UPDATE_EMPTY$cp());
    }

    public abstract void setOnUpdate(Function0<Unit> function0);

    public final String toDebugLogString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbU = a.U("Observer name: ");
        String name = getName();
        if (name == null) {
            name = "Unknown";
        }
        sbU.append(name);
        sbU.append('\n');
        sb.append(sbU.toString());
        sb.append(u.joinToString$default(getObservingUpdates(), ", ", null, null, 0, null, null, 62, null));
        String string = sb.toString();
        m.checkNotNullExpressionValue(string, "stringBuilder.toString()");
        return string;
    }
}
