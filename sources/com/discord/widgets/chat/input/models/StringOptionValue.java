package com.discord.widgets.chat.input.models;

import d0.z.d.m;

/* JADX INFO: compiled from: CommandOptionValue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StringOptionValue extends CommandOptionValue {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringOptionValue(String str) {
        super(str, null);
        m.checkNotNullParameter(str, "value");
    }
}
