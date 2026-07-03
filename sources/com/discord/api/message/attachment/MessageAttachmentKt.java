package com.discord.api.message.attachment;

import java.util.List;
import p507d0.p580t.C12147n;

/* JADX INFO: compiled from: MessageAttachment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MessageAttachmentKt {
    private static final List<String> IMAGE_MIME_TYPES = C12147n.listOf((Object[]) new String[]{".jpeg", ".jpg", ".gif", ".png", ".bmp", ".webp"});
    private static final List<String> VIDEO_MIME_TYPES = C12147n.listOf((Object[]) new String[]{".webm", ".mov", ".mpeg", ".mpg", ".mp4"});

    /* JADX INFO: renamed from: a */
    public static final List<String> m8072a() {
        return IMAGE_MIME_TYPES;
    }

    /* JADX INFO: renamed from: b */
    public static final List<String> m8073b() {
        return VIDEO_MIME_TYPES;
    }
}
