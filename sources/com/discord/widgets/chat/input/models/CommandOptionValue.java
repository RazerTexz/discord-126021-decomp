package com.discord.widgets.chat.input.models;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CommandOptionValue.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CommandOptionValue {
    private final Object value;

    private CommandOptionValue(Object obj) {
        this.value = obj;
    }

    public final Object getValue() {
        return this.value;
    }

    public /* synthetic */ CommandOptionValue(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj);
    }
}
