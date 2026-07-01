package com.discord.widgets.chat.input.attachments;

import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import com.lytefast.flexinput.model.Attachment;
import d0.o;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AttachmentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentBottomSheet$Companion {
    private AttachmentBottomSheet$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AttachmentBottomSheet show$default(AttachmentBottomSheet$Companion attachmentBottomSheet$Companion, FragmentManager fragmentManager, Attachment attachment, Function0 function0, Function1 function1, Function0 function2, int i, Object obj) {
        if ((i & 16) != 0) {
            function2 = null;
        }
        return attachmentBottomSheet$Companion.show(fragmentManager, attachment, function0, function1, function2);
    }

    public final AttachmentBottomSheet show(FragmentManager fragmentManager, Attachment<? extends Object> attachment, Function0<Unit> onFileRemoved, Function1<? super Boolean, Unit> onMarkSpoiler, Function0<Unit> onDismissed) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(attachment, "attachment");
        m.checkNotNullParameter(onFileRemoved, "onFileRemoved");
        m.checkNotNullParameter(onMarkSpoiler, "onMarkSpoiler");
        AttachmentBottomSheet attachmentBottomSheet = new AttachmentBottomSheet();
        attachmentBottomSheet.setArguments(BundleKt.bundleOf(o.to("EXTRA_ATTACHMENT", attachment)));
        AttachmentBottomSheet.access$setOnFileRemoved$p(attachmentBottomSheet, onFileRemoved);
        AttachmentBottomSheet.access$setOnMarkSpoiler$p(attachmentBottomSheet, onMarkSpoiler);
        AttachmentBottomSheet.access$setOnDismissed$p(attachmentBottomSheet, onDismissed);
        AttachmentBottomSheet.access$setSpoiler$p(attachmentBottomSheet, attachment.getSpoiler());
        attachmentBottomSheet.show(fragmentManager, a0.getOrCreateKotlinClass(AttachmentBottomSheet.class).toString());
        return attachmentBottomSheet;
    }

    public /* synthetic */ AttachmentBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
