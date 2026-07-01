package com.discord.widgets.chat.input.autocomplete;

import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables$APPLICATION_COMMANDS_SOURCE$2, reason: use source file name */
/* JADX INFO: compiled from: InputAutocompletables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocompletables2 extends Lambda implements Function0<ApplicationCommandsAutocompletableSource> {
    public static final InputAutocompletables2 INSTANCE = new InputAutocompletables2();

    public InputAutocompletables2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ApplicationCommandsAutocompletableSource invoke() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return new ApplicationCommandsAutocompletableSource(companion.getUsers(), companion.getGuilds(), companion.getApplicationCommands());
    }
}
