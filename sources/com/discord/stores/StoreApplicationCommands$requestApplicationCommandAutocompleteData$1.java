package com.discord.stores;

import android.content.Context;
import com.discord.models.commands.ApplicationCommandLocalSendDataKt;
import com.discord.restapi.RestAPIParams$ApplicationCommand;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$requestApplicationCommandAutocompleteData$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ ApplicationCommandData $data;
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ StoreApplicationCommands this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$requestApplicationCommandAutocompleteData$1(StoreApplicationCommands storeApplicationCommands, ApplicationCommandData applicationCommandData, long j, Long l) {
        super(0);
        this.this$0 = storeApplicationCommands;
        this.$data = applicationCommandData;
        this.$channelId = j;
        this.$guildId = l;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Object next;
        String strAccess$generateNonce = StoreApplicationCommands.access$generateNonce(this.this$0);
        String version = this.$data.getApplicationCommand().getVersion();
        Long guildId = this.$data.getApplicationCommand().getGuildId();
        com.discord.api.commands.ApplicationCommandData applicationCommandData = new com.discord.api.commands.ApplicationCommandData(version, guildId != null ? String.valueOf(guildId.longValue()) : null, this.$data.getApplicationCommand().getId(), this.$data.getApplicationCommand().getName(), ApplicationCommandLocalSendDataKt.toRestParams(this.$data.getValues(), StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$apiCommandData$1.INSTANCE), null);
        String strValueOf = String.valueOf(this.$channelId);
        String strValueOf2 = String.valueOf(this.$data.getApplication().getId());
        Long l = this.$guildId;
        RestAPIParams$ApplicationCommand restAPIParams$ApplicationCommand = new RestAPIParams$ApplicationCommand(4L, strValueOf, strValueOf2, l != null ? String.valueOf(l.longValue()) : null, applicationCommandData, StoreApplicationCommands.access$getSessionId$p(this.this$0), strAccess$generateNonce);
        Iterator<T> it = StoreApplicationCommandsKt.flatten(this.$data.getValues()).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!m.areEqual(((ApplicationCommandValue) next).getFocused(), Boolean.TRUE));
        ApplicationCommandValue applicationCommandValue = (ApplicationCommandValue) next;
        if (applicationCommandValue != null) {
            StoreApplicationCommands.access$getAutocompleteNonceData$p(this.this$0).put(strAccess$generateNonce, new CommandOptionAutocompleteQuery(String.valueOf(applicationCommandValue.getValue()), applicationCommandValue.getName()));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreApplicationCommands.access$getRestApi$p(this.this$0).sendApplicationCommand(restAPIParams$ApplicationCommand), false, 1, null), this.this$0.getClass(), (Context) null, (Function1) null, new StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$1(this, applicationCommandValue), (Function0) null, (Function0) null, StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$2.INSTANCE, 54, (Object) null);
        }
    }
}
