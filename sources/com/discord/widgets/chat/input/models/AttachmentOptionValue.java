package com.discord.widgets.chat.input.models;

import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: CommandOptionValue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentOptionValue extends CommandOptionValue {
    private final String filename;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttachmentOptionValue(String str) {
        super(str, null);
        Intrinsics3.checkNotNullParameter(str, "filename");
        this.filename = str;
    }

    public final String getFilename() {
        return this.filename;
    }
}
