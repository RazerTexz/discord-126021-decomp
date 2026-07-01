package com.discord.simpleast.core.parser;

import d0.z.d.m;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Parser$ParseException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Parser$ParseException(String str, CharSequence charSequence, Throwable th) {
        super("Error while parsing: " + str + " \n Source: " + charSequence, th);
        m.checkNotNullParameter(str, "message");
    }
}
