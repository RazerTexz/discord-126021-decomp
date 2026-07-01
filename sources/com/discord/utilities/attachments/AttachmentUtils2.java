package com.discord.utilities.attachments;

import d0.z.d.Lambda;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.attachments.AttachmentUtilsKt$REGEX_FILE_NAME_PATTERN$2, reason: use source file name */
/* JADX INFO: compiled from: AttachmentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentUtils2 extends Lambda implements Function0<Pattern> {
    public static final AttachmentUtils2 INSTANCE = new AttachmentUtils2();

    public AttachmentUtils2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Pattern invoke() {
        return Pattern.compile("(.*)\\.(\\w+)$");
    }
}
