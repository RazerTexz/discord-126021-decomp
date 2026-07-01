package com.discord.models.domain;

import b.a.m.a.b;
import b.a.m.a.c;
import b.a.m.a.d;
import b.a.m.a.e;
import b.a.m.a.f;
import b.a.m.a.g;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.user.User;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ModelAuditLog implements Model {
    private List<ModelAuditLogEntry> auditLogEntries;
    private List<GuildScheduledEvent> guildScheduledEvents;
    private List<ModelGuildIntegration> integrations;
    private List<Channel> threads;
    private List<User> users;
    private List<ModelWebhook> webhooks;

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "threads":
                this.threads = model$JsonReader.nextList(new f(model$JsonReader));
                break;
            case "guild_scheduled_events":
                this.guildScheduledEvents = model$JsonReader.nextList(new c(model$JsonReader));
                break;
            case "webhooks":
                this.webhooks = model$JsonReader.nextList(new e(model$JsonReader));
                break;
            case "audit_log_entries":
                this.auditLogEntries = model$JsonReader.nextList(new b(model$JsonReader));
                break;
            case "users":
                this.users = model$JsonReader.nextList(new g(model$JsonReader));
                break;
            case "integrations":
                this.integrations = model$JsonReader.nextList(new d(model$JsonReader));
                break;
            default:
                model$JsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelAuditLog;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelAuditLog)) {
            return false;
        }
        ModelAuditLog modelAuditLog = (ModelAuditLog) obj;
        if (!modelAuditLog.canEqual(this)) {
            return false;
        }
        List<User> users = getUsers();
        List<User> users2 = modelAuditLog.getUsers();
        if (users != null ? !users.equals(users2) : users2 != null) {
            return false;
        }
        List<ModelWebhook> webhooks = getWebhooks();
        List<ModelWebhook> webhooks2 = modelAuditLog.getWebhooks();
        if (webhooks != null ? !webhooks.equals(webhooks2) : webhooks2 != null) {
            return false;
        }
        List<ModelGuildIntegration> integrations = getIntegrations();
        List<ModelGuildIntegration> integrations2 = modelAuditLog.getIntegrations();
        if (integrations != null ? !integrations.equals(integrations2) : integrations2 != null) {
            return false;
        }
        List<ModelAuditLogEntry> auditLogEntries = getAuditLogEntries();
        List<ModelAuditLogEntry> auditLogEntries2 = modelAuditLog.getAuditLogEntries();
        if (auditLogEntries != null ? !auditLogEntries.equals(auditLogEntries2) : auditLogEntries2 != null) {
            return false;
        }
        List<GuildScheduledEvent> guildScheduledEvents = getGuildScheduledEvents();
        List<GuildScheduledEvent> guildScheduledEvents2 = modelAuditLog.getGuildScheduledEvents();
        if (guildScheduledEvents != null ? !guildScheduledEvents.equals(guildScheduledEvents2) : guildScheduledEvents2 != null) {
            return false;
        }
        List<Channel> threads = getThreads();
        List<Channel> threads2 = modelAuditLog.getThreads();
        return threads != null ? threads.equals(threads2) : threads2 == null;
    }

    public List<ModelAuditLogEntry> getAuditLogEntries() {
        return this.auditLogEntries;
    }

    public List<GuildScheduledEvent> getGuildScheduledEvents() {
        return this.guildScheduledEvents;
    }

    public List<ModelGuildIntegration> getIntegrations() {
        return this.integrations;
    }

    public List<Channel> getThreads() {
        return this.threads;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public List<ModelWebhook> getWebhooks() {
        return this.webhooks;
    }

    public int hashCode() {
        List<User> users = getUsers();
        int iHashCode = users == null ? 43 : users.hashCode();
        List<ModelWebhook> webhooks = getWebhooks();
        int iHashCode2 = ((iHashCode + 59) * 59) + (webhooks == null ? 43 : webhooks.hashCode());
        List<ModelGuildIntegration> integrations = getIntegrations();
        int iHashCode3 = (iHashCode2 * 59) + (integrations == null ? 43 : integrations.hashCode());
        List<ModelAuditLogEntry> auditLogEntries = getAuditLogEntries();
        int iHashCode4 = (iHashCode3 * 59) + (auditLogEntries == null ? 43 : auditLogEntries.hashCode());
        List<GuildScheduledEvent> guildScheduledEvents = getGuildScheduledEvents();
        int iHashCode5 = (iHashCode4 * 59) + (guildScheduledEvents == null ? 43 : guildScheduledEvents.hashCode());
        List<Channel> threads = getThreads();
        return (iHashCode5 * 59) + (threads != null ? threads.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelAuditLog(users=");
        sbU.append(getUsers());
        sbU.append(", webhooks=");
        sbU.append(getWebhooks());
        sbU.append(", integrations=");
        sbU.append(getIntegrations());
        sbU.append(", auditLogEntries=");
        sbU.append(getAuditLogEntries());
        sbU.append(", guildScheduledEvents=");
        sbU.append(getGuildScheduledEvents());
        sbU.append(", threads=");
        sbU.append(getThreads());
        sbU.append(")");
        return sbU.toString();
    }
}
