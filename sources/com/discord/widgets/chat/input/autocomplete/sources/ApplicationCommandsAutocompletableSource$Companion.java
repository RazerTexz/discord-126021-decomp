package com.discord.widgets.chat.input.autocomplete.sources;

import com.discord.api.channel.Channel;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandChoice;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandChoiceAutocompletable;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ApplicationCommandsAutocompletableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ApplicationCommandsAutocompletableSource$Companion {
    private ApplicationCommandsAutocompletableSource$Companion() {
    }

    public final List<Autocompletable> createFromCommandOption(ApplicationCommandOption option) {
        m.checkNotNullParameter(option, "option");
        ArrayList arrayList = new ArrayList();
        if (option.getType() == ApplicationCommandType.BOOLEAN) {
            arrayList.add(new ApplicationCommandChoiceAutocompletable(new CommandChoice("true", "true"), null, 2, null));
            arrayList.add(new ApplicationCommandChoiceAutocompletable(new CommandChoice("false", "false"), null, 2, null));
        } else {
            List<CommandChoice> choices = option.getChoices();
            if (!(choices == null || choices.isEmpty())) {
                List<CommandChoice> choices2 = option.getChoices();
                ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(choices2, 10));
                Iterator<T> it = choices2.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new ApplicationCommandChoiceAutocompletable((CommandChoice) it.next(), null, 2, null));
                }
                arrayList.addAll(arrayList2);
            }
        }
        return arrayList;
    }

    public final Observable<WidgetChatInputDiscoveryCommandsModel> getDiscoveryCommands(boolean includeHeaders, int placeholdersCount, Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetChatInputDiscoveryCommandsModel> observableG = Observable.g(storeStream$Companion.getUsers().observeMeId(), storeStream$Companion.getGuilds().observeComputed(channel.getGuildId()), storeStream$Companion.getApplicationCommands().observeDiscoverCommands(channel.getId()), storeStream$Companion.getApplicationCommands().observeGuildApplications(channel.getId()), storeStream$Companion.getApplicationCommands().observeFrecencyCommands(channel.getGuildId()), new ApplicationCommandsAutocompletableSource$Companion$getDiscoveryCommands$1(includeHeaders, placeholdersCount));
        m.checkNotNullExpressionValue(observableG, "Observable.combineLatest…recency\n        )\n      }");
        return observableG;
    }

    public /* synthetic */ ApplicationCommandsAutocompletableSource$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
