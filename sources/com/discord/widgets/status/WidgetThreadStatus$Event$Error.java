package com.discord.widgets.status;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: WidgetThreadStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadStatus$Event$Error extends WidgetThreadStatus$Event {
    private final int code;

    public WidgetThreadStatus$Event$Error(int i) {
        super(null);
        this.code = i;
    }

    public static /* synthetic */ WidgetThreadStatus$Event$Error copy$default(WidgetThreadStatus$Event$Error widgetThreadStatus$Event$Error, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetThreadStatus$Event$Error.code;
        }
        return widgetThreadStatus$Event$Error.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    public final WidgetThreadStatus$Event$Error copy(int code) {
        return new WidgetThreadStatus$Event$Error(code);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetThreadStatus$Event$Error) && this.code == ((WidgetThreadStatus$Event$Error) other).code;
        }
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public int hashCode() {
        return this.code;
    }

    public String toString() {
        return a.B(a.U("Error(code="), this.code, ")");
    }
}
