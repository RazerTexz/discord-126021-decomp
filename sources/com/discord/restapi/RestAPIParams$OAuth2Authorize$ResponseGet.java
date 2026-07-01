package com.discord.restapi;

import com.discord.api.application.Application;
import com.discord.api.guild.Guild;
import com.discord.api.user.User;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$OAuth2Authorize$ResponseGet {
    private final Application application;
    private final List<RestAPIParams$ConnectedAccount> connections;
    private final List<Guild> guilds;
    private final User user;

    public RestAPIParams$OAuth2Authorize$ResponseGet(User user, Application application, List<RestAPIParams$ConnectedAccount> list, List<Guild> list2) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(application, "application");
        m.checkNotNullParameter(list, "connections");
        m.checkNotNullParameter(list2, "guilds");
        this.user = user;
        this.application = application;
        this.connections = list;
        this.guilds = list2;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final List<RestAPIParams$ConnectedAccount> getConnections() {
        return this.connections;
    }

    public final List<Guild> getGuilds() {
        return this.guilds;
    }

    public final User getUser() {
        return this.user;
    }
}
