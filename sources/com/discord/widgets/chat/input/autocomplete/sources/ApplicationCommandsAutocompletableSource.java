package com.discord.widgets.chat.input.autocomplete.sources;

import com.discord.api.channel.Channel;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandKt;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandAutocompletable;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.o;
import d0.t.g0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import rx.Observable;

/* JADX INFO: compiled from: ApplicationCommandsAutocompletableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ApplicationCommandsAutocompletableSource {
    public static final ApplicationCommandsAutocompletableSource$Companion Companion = new ApplicationCommandsAutocompletableSource$Companion(null);
    private final StoreApplicationCommands storeApplicationCommands;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUsers;

    public ApplicationCommandsAutocompletableSource(StoreUser storeUser, StoreGuilds storeGuilds, StoreApplicationCommands storeApplicationCommands) {
        m.checkNotNullParameter(storeUser, "storeUsers");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeApplicationCommands, "storeApplicationCommands");
        this.storeUsers = storeUser;
        this.storeGuilds = storeGuilds;
        this.storeApplicationCommands = storeApplicationCommands;
    }

    public static final /* synthetic */ Map access$createAutocompletablesForApplicationCommands(ApplicationCommandsAutocompletableSource applicationCommandsAutocompletableSource, long j, List list, List list2, List list3) {
        return applicationCommandsAutocompletableSource.createAutocompletablesForApplicationCommands(j, list, list2, list3);
    }

    private final Map<LeadingIdentifier, TreeSet<Autocompletable>> createAutocompletablesForApplicationCommands(long myId, List<Long> myChannelRoles, List<Application> apps, List<? extends ApplicationCommand> appCommands) {
        TreeSet treeSet = new TreeSet(new AutocompletableComparator());
        HashMap map = new HashMap();
        for (Application application : apps) {
            map.put(Long.valueOf(application.getId()), application);
        }
        for (ApplicationCommand applicationCommand : appCommands) {
            treeSet.add(new ApplicationCommandAutocompletable((Application) map.get(Long.valueOf(applicationCommand.getApplicationId())), applicationCommand, ApplicationCommandKt.hasPermission(applicationCommand, myId, myChannelRoles), true));
        }
        return g0.mapOf(o.to(LeadingIdentifier.APP_COMMAND, treeSet));
    }

    public final StoreApplicationCommands getStoreApplicationCommands() {
        return this.storeApplicationCommands;
    }

    public final StoreGuilds getStoreGuilds() {
        return this.storeGuilds;
    }

    public final StoreUser getStoreUsers() {
        return this.storeUsers;
    }

    public final Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observeApplicationCommandAutocompletables(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        Observable observableH = Observable.h(ObservableExtensionsKt.computationLatest(this.storeUsers.observeMeId()), ObservableExtensionsKt.computationLatest(this.storeGuilds.observeComputed(channel.getGuildId())), ObservableExtensionsKt.computationLatest(this.storeApplicationCommands.observeGuildApplications(channel.getId())), ObservableExtensionsKt.computationLatest(this.storeApplicationCommands.observeQueryCommands(channel.getId())), new ApplicationCommandsAutocompletableSource$observeApplicationCommandAutocompletables$1(this));
        m.checkNotNullExpressionValue(observableH, "Observable.combineLatest… TreeSet())\n      }\n    }");
        Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observableR = ObservableExtensionsKt.computationLatest(observableH).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }
}
