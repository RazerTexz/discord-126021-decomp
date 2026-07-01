package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.commands.ApplicationCommand;
import java.util.List;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$observeDiscoverCommands$2<T1, T2, R> implements Func2<DiscoverCommands, Long, DiscoverCommands> {
    public final /* synthetic */ StoreApplicationCommands this$0;

    public StoreApplicationCommands$observeDiscoverCommands$2(StoreApplicationCommands storeApplicationCommands) {
        this.this$0 = storeApplicationCommands;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ DiscoverCommands call(DiscoverCommands discoverCommands, Long l) {
        return call2(discoverCommands, l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final DiscoverCommands call2(DiscoverCommands discoverCommands, Long l) {
        if (StoreApplicationCommands.access$shouldReturnApplicationCommands(this.this$0, l)) {
            return discoverCommands;
        }
        List<ApplicationCommand> builtInCommands = StoreApplicationCommands.access$getBuiltInCommandsProvider$p(this.this$0).getBuiltInCommands();
        return new DiscoverCommands(builtInCommands, 0, builtInCommands.size(), false, false, 0, null, null, 128, null);
    }
}
