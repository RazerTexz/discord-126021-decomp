package com.discord.widgets.user;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetPruneUsersViewModel$Event$RestClientFailed extends WidgetPruneUsersViewModel$Event {
    private final Throwable throwable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsersViewModel$Event$RestClientFailed(Throwable th) {
        super(null);
        m.checkNotNullParameter(th, "throwable");
        this.throwable = th;
    }

    public static /* synthetic */ WidgetPruneUsersViewModel$Event$RestClientFailed copy$default(WidgetPruneUsersViewModel$Event$RestClientFailed widgetPruneUsersViewModel$Event$RestClientFailed, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = widgetPruneUsersViewModel$Event$RestClientFailed.throwable;
        }
        return widgetPruneUsersViewModel$Event$RestClientFailed.copy(th);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final WidgetPruneUsersViewModel$Event$RestClientFailed copy(Throwable throwable) {
        m.checkNotNullParameter(throwable, "throwable");
        return new WidgetPruneUsersViewModel$Event$RestClientFailed(throwable);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetPruneUsersViewModel$Event$RestClientFailed) && m.areEqual(this.throwable, ((WidgetPruneUsersViewModel$Event$RestClientFailed) other).throwable);
        }
        return true;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public int hashCode() {
        Throwable th = this.throwable;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("RestClientFailed(throwable=");
        sbU.append(this.throwable);
        sbU.append(")");
        return sbU.toString();
    }
}
