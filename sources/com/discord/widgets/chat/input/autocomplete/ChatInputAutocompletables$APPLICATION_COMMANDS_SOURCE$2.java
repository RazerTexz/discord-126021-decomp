package com.discord.widgets.chat.input.autocomplete;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: InputAutocompletables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputAutocompletables$APPLICATION_COMMANDS_SOURCE$2 extends o implements Function0<ApplicationCommandsAutocompletableSource> {
    public static final ChatInputAutocompletables$APPLICATION_COMMANDS_SOURCE$2 INSTANCE = new ChatInputAutocompletables$APPLICATION_COMMANDS_SOURCE$2();

    public ChatInputAutocompletables$APPLICATION_COMMANDS_SOURCE$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ApplicationCommandsAutocompletableSource invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ApplicationCommandsAutocompletableSource invoke() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return new ApplicationCommandsAutocompletableSource(storeStream$Companion.getUsers(), storeStream$Companion.getGuilds(), storeStream$Companion.getApplicationCommands());
    }
}
