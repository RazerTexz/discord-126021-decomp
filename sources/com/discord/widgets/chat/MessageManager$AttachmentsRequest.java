package com.discord.widgets.chat;

import com.lytefast.flexinput.model.Attachment;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageManager$AttachmentsRequest {
    private final List<Attachment<?>> attachments;
    private final float currentFileSizeMB;
    private final int maxFileSizeMB;

    /* JADX WARN: Multi-variable type inference failed */
    public MessageManager$AttachmentsRequest(float f, int i, List<? extends Attachment<?>> list) {
        this.currentFileSizeMB = f;
        this.maxFileSizeMB = i;
        this.attachments = list;
    }

    public final List<Attachment<?>> getAttachments() {
        return this.attachments;
    }

    public final float getCurrentFileSizeMB() {
        return this.currentFileSizeMB;
    }

    public final int getMaxFileSizeMB() {
        return this.maxFileSizeMB;
    }

    public /* synthetic */ MessageManager$AttachmentsRequest(float f, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, i, (i2 & 4) != 0 ? null : list);
    }
}
