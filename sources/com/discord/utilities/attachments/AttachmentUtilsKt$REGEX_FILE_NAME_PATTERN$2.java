package com.discord.utilities.attachments;

import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: AttachmentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentUtilsKt$REGEX_FILE_NAME_PATTERN$2 extends AbstractC12240o implements Function0<Pattern> {
    public static final AttachmentUtilsKt$REGEX_FILE_NAME_PATTERN$2 INSTANCE = new AttachmentUtilsKt$REGEX_FILE_NAME_PATTERN$2();

    public AttachmentUtilsKt$REGEX_FILE_NAME_PATTERN$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Pattern invoke() {
        return Pattern.compile("(.*)\\.(\\w+)$");
    }
}
