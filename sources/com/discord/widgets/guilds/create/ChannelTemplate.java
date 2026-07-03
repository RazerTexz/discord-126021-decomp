package com.discord.widgets.guilds.create;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StockGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ChannelTemplate {
    private final Long id;
    private final String name;

    /* JADX INFO: compiled from: StockGuildTemplate.kt */
    public static final class NormalChannel extends ChannelTemplate {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public NormalChannel(String str) {
            super(null, str, 0 == true ? 1 : 0);
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        }
    }

    /* JADX INFO: compiled from: StockGuildTemplate.kt */
    public static final class SystemChannel extends ChannelTemplate {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SystemChannel(String str) {
            super(11L, str, null);
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        }
    }

    private ChannelTemplate(Long l, String str) {
        this.id = l;
        this.name = str;
    }

    public final Long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ ChannelTemplate(Long l, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, str);
    }
}
