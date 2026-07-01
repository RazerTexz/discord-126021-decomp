package com.discord.widgets.chat.input.autocomplete;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: InputAutocompletables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputAutocompletables$USERS_SOURCE$2 extends o implements Function0<UserAutocompletableSource> {
    public static final ChatInputAutocompletables$USERS_SOURCE$2 INSTANCE = new ChatInputAutocompletables$USERS_SOURCE$2();

    public ChatInputAutocompletables$USERS_SOURCE$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ UserAutocompletableSource invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final UserAutocompletableSource invoke() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return new UserAutocompletableSource(storeStream$Companion.getUsers(), storeStream$Companion.getGuilds(), storeStream$Companion.getPresences(), storeStream$Companion.getPermissions(), storeStream$Companion.getChannels());
    }
}
