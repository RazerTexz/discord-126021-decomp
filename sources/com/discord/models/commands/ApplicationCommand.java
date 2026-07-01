package com.discord.models.commands;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ApplicationCommand.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class ApplicationCommand {
    private final long applicationId;
    private final boolean builtIn;
    private final Boolean defaultPermissions;
    private final String description;
    private final Integer descriptionRes;
    private final Function1<Map<String, ? extends Object>, String> execute;
    private final Long guildId;
    private final String id;
    private final String name;
    private final List<ApplicationCommandOption> options;
    private final Map<Long, Boolean> permissions;
    private final String version;

    /* JADX WARN: Multi-variable type inference failed */
    private ApplicationCommand(String str, long j, String str2, String str3, Integer num, List<ApplicationCommandOption> list, boolean z2, Long l, String str4, Boolean bool, Map<Long, Boolean> map, Function1<? super Map<String, ? extends Object>, String> function1) {
        this.id = str;
        this.applicationId = j;
        this.name = str2;
        this.description = str3;
        this.descriptionRes = num;
        this.options = list;
        this.builtIn = z2;
        this.guildId = l;
        this.version = str4;
        this.defaultPermissions = bool;
        this.permissions = map;
        this.execute = function1;
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final Boolean getDefaultPermissions() {
        return this.defaultPermissions;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getDescriptionRes() {
        return this.descriptionRes;
    }

    public final Function1<Map<String, ? extends Object>, String> getExecute() {
        return this.execute;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<ApplicationCommandOption> getOptions() {
        return this.options;
    }

    public final Map<Long, Boolean> getPermissions() {
        return this.permissions;
    }

    public final String getVersion() {
        return this.version;
    }

    public /* synthetic */ ApplicationCommand(String str, long j, String str2, String str3, Integer num, List list, boolean z2, Long l, String str4, Boolean bool, Map map, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num, list, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? null : l, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? null : map, (i & 2048) != 0 ? null : function1);
    }
}
