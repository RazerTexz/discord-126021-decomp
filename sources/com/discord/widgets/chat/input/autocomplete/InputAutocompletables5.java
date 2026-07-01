package com.discord.widgets.chat.input.autocomplete;

import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.autocomplete.sources.UserMentionableSource;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables$USERS_SOURCE$2, reason: use source file name */
/* JADX INFO: compiled from: InputAutocompletables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocompletables5 extends Lambda implements Function0<UserMentionableSource> {
    public static final InputAutocompletables5 INSTANCE = new InputAutocompletables5();

    public InputAutocompletables5() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final UserMentionableSource invoke() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return new UserMentionableSource(companion.getUsers(), companion.getGuilds(), companion.getPresences(), companion.getPermissions(), companion.getChannels());
    }
}
