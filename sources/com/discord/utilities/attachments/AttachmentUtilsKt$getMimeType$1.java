package com.discord.utilities.attachments;

import android.webkit.MimeTypeMap;
import d0.z.d.m;
import d0.z.d.o;
import java.util.regex.Matcher;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AttachmentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentUtilsKt$getMimeType$1 extends o implements Function1<String, String> {
    public static final AttachmentUtilsKt$getMimeType$1 INSTANCE = new AttachmentUtilsKt$getMimeType$1();

    public AttachmentUtilsKt$getMimeType$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String str) {
        return invoke2(str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String str) {
        m.checkNotNullParameter(str, "file");
        Matcher matcher = AttachmentUtilsKt.access$getREGEX_FILE_NAME_PATTERN$p().matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(matcher.group(2));
    }
}
