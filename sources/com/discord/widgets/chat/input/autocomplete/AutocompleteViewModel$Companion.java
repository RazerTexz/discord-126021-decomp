package com.discord.widgets.chat.input.autocomplete;

import com.discord.stores.StoreApplicationCommandFrecency;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteViewModel$Companion {
    private AutocompleteViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(AutocompleteViewModel$Companion autocompleteViewModel$Companion, Long l, StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandFrecency) {
        return autocompleteViewModel$Companion.observeStores(l, storeApplicationCommands, storeApplicationCommandFrecency);
    }

    private final Observable<AutocompleteViewModel$StoreState> observeStores(Long inputChannelId, StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandsFrecency) {
        Observable observableG;
        if (inputChannelId != null) {
            observableG = StoreStream.Companion.getChannels().observeChannel(inputChannelId.longValue()).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        } else {
            observableG = StoreStream.Companion.getChannelsSelected().observeSelectedChannel().y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        }
        Observable<AutocompleteViewModel$StoreState> observableY = observableG.Y(new AutocompleteViewModel$Companion$observeStores$1(storeApplicationCommands, storeApplicationCommandsFrecency));
        m.checkNotNullExpressionValue(observableY, "inputChannel.switchMap {…      )\n        }\n      }");
        return observableY;
    }

    public /* synthetic */ AutocompleteViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
