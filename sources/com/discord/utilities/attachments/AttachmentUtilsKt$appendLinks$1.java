package com.discord.utilities.attachments;

import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AttachmentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentUtilsKt$appendLinks$1 extends o implements Function1<Attachment<?>, CharSequence> {
    public static final AttachmentUtilsKt$appendLinks$1 INSTANCE = new AttachmentUtilsKt$appendLinks$1();

    public AttachmentUtilsKt$appendLinks$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Attachment<?> attachment) {
        m.checkNotNullParameter(attachment, "it");
        Object data = attachment.getData();
        Objects.requireNonNull(data, "null cannot be cast to non-null type androidx.core.view.inputmethod.InputContentInfoCompat");
        InputContentInfoCompat inputContentInfoCompat = (InputContentInfoCompat) data;
        String strValueOf = String.valueOf(inputContentInfoCompat.getLinkUri());
        inputContentInfoCompat.releasePermission();
        return strValueOf;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Attachment<?> attachment) {
        return invoke2(attachment);
    }
}
