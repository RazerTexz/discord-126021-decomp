package com.discord.utilities.attachments;

import d0.z.d.o;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AttachmentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentUtilsKt$REGEX_FILE_NAME_PATTERN$2 extends o implements Function0<Pattern> {
    public static final AttachmentUtilsKt$REGEX_FILE_NAME_PATTERN$2 INSTANCE = new AttachmentUtilsKt$REGEX_FILE_NAME_PATTERN$2();

    public AttachmentUtilsKt$REGEX_FILE_NAME_PATTERN$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Pattern invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pattern invoke2() {
        return Pattern.compile("(.*)\\.(\\w+)$");
    }
}
