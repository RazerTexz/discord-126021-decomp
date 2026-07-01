package com.discord.api.message.attachment;

import d0.t.Collections2;
import java.util.List;

/* JADX INFO: renamed from: com.discord.api.message.attachment.MessageAttachmentKt, reason: use source file name */
/* JADX INFO: compiled from: MessageAttachment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MessageAttachment2 {
    private static final List<String> IMAGE_MIME_TYPES = Collections2.listOf((Object[]) new String[]{".jpeg", ".jpg", ".gif", ".png", ".bmp", ".webp"});
    private static final List<String> VIDEO_MIME_TYPES = Collections2.listOf((Object[]) new String[]{".webm", ".mov", ".mpeg", ".mpg", ".mp4"});

    public static final List<String> a() {
        return IMAGE_MIME_TYPES;
    }

    public static final List<String> b() {
        return VIDEO_MIME_TYPES;
    }
}
