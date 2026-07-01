package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.commands.ApplicationCommand;
import com.discord.stores.StoreApplicationCommandFrecency;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource;
import d0.t.n;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteViewModel$Companion$observeStores$1<T, R> implements b<Channel, Observable<? extends AutocompleteViewModel$StoreState>> {
    public final /* synthetic */ StoreApplicationCommands $storeApplicationCommands;
    public final /* synthetic */ StoreApplicationCommandFrecency $storeApplicationCommandsFrecency;

    public AutocompleteViewModel$Companion$observeStores$1(StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandFrecency) {
        this.$storeApplicationCommands = storeApplicationCommands;
        this.$storeApplicationCommandsFrecency = storeApplicationCommandFrecency;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends AutocompleteViewModel$StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends AutocompleteViewModel$StoreState> call2(Channel channel) {
        m.checkNotNullExpressionValue(channel, "channel");
        Observable<List<ApplicationCommand>> kVar = ChannelUtils.j(channel) ? new k<>(n.emptyList()) : this.$storeApplicationCommands.observeQueryCommands(channel.getId());
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.c(storeStream$Companion.getUsers().observeMeId(), storeStream$Companion.getGuilds().observeComputed(channel.getGuildId()), ApplicationCommandsAutocompletableSource.Companion.getDiscoveryCommands(true, 3, channel), kVar, ChatInputAutocompletables.INSTANCE.observeChannelAutocompletables(channel.getId()), this.$storeApplicationCommands.observeGuildApplications(channel.getId()), this.$storeApplicationCommands.observeAutocompleteResults(), this.$storeApplicationCommandsFrecency.observeTopCommandIds(Long.valueOf(channel.getGuildId())), this.$storeApplicationCommands.observeFrecencyCommands(channel.getGuildId()), new AutocompleteViewModel$Companion$observeStores$1$1(channel));
    }
}
