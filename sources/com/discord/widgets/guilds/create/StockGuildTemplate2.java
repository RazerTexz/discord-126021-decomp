package com.discord.widgets.guilds.create;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.guilds.create.ChannelTemplate, reason: use source file name */
/* JADX INFO: compiled from: StockGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StockGuildTemplate2 {
    private final Long id;
    private final String name;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.create.ChannelTemplate$NormalChannel */
    /* JADX INFO: compiled from: StockGuildTemplate.kt */
    public static final class NormalChannel extends StockGuildTemplate2 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public NormalChannel(String str) {
            super(null, str, 0 == true ? 1 : 0);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.create.ChannelTemplate$SystemChannel */
    /* JADX INFO: compiled from: StockGuildTemplate.kt */
    public static final class SystemChannel extends StockGuildTemplate2 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SystemChannel(String str) {
            super(11L, str, null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        }
    }

    private StockGuildTemplate2(Long l, String str) {
        this.id = l;
        this.name = str;
    }

    public final Long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ StockGuildTemplate2(Long l, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, str);
    }
}
