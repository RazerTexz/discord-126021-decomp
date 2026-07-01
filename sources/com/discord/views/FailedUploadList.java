package com.discord.views;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import b.a.i.d2;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.api.message.LocalAttachment;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.file.FileUtilsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.SendUtilsKt;
import com.lytefast.flexinput.model.Attachment;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FailedUploadList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FailedUploadList extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final d2 binding;

    public FailedUploadList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.view_chat_upload_list, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.chat_upload_1;
        FailedUploadView failedUploadView = (FailedUploadView) viewInflate.findViewById(R$id.chat_upload_1);
        if (failedUploadView != null) {
            i = R$id.chat_upload_2;
            FailedUploadView failedUploadView2 = (FailedUploadView) viewInflate.findViewById(R$id.chat_upload_2);
            if (failedUploadView2 != null) {
                i = R$id.chat_upload_3;
                FailedUploadView failedUploadView3 = (FailedUploadView) viewInflate.findViewById(R$id.chat_upload_3);
                if (failedUploadView3 != null) {
                    d2 d2Var = new d2((LinearLayout) viewInflate, failedUploadView, failedUploadView2, failedUploadView3);
                    m.checkNotNullExpressionValue(d2Var, "ViewChatUploadListBindin…rom(context), this, true)");
                    this.binding = d2Var;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final List<FailedUploadView> getFailedUploadViews() {
        FailedUploadView failedUploadView = this.binding.f98b;
        m.checkNotNullExpressionValue(failedUploadView, "binding.chatUpload1");
        FailedUploadView failedUploadView2 = this.binding.c;
        m.checkNotNullExpressionValue(failedUploadView2, "binding.chatUpload2");
        FailedUploadView failedUploadView3 = this.binding.d;
        m.checkNotNullExpressionValue(failedUploadView3, "binding.chatUpload3");
        return n.listOf((Object[]) new FailedUploadView[]{failedUploadView, failedUploadView2, failedUploadView3});
    }

    public final void setUp(List<LocalAttachment> localAttachments) {
        Object failedUploadList$b$b;
        m.checkNotNullParameter(localAttachments, "localAttachments");
        Iterator<T> it = getFailedUploadViews().iterator();
        while (it.hasNext()) {
            ((FailedUploadView) it.next()).setVisibility(8);
        }
        if (!localAttachments.isEmpty()) {
            ArrayList<Attachment> arrayList = new ArrayList(o.collectionSizeOrDefault(localAttachments, 10));
            Iterator<T> it2 = localAttachments.iterator();
            while (it2.hasNext()) {
                arrayList.add(AttachmentUtilsKt.toAttachment((LocalAttachment) it2.next()));
            }
            if (arrayList.size() <= 3) {
                ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
                for (Attachment attachment : arrayList) {
                    String displayName = attachment.getDisplayName();
                    Uri uri = attachment.getUri();
                    Context context = getContext();
                    m.checkNotNullExpressionValue(context, "context");
                    ContentResolver contentResolver = context.getContentResolver();
                    m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                    long jComputeFileSizeBytes = SendUtilsKt.computeFileSizeBytes(uri, contentResolver);
                    Context context2 = getContext();
                    m.checkNotNullExpressionValue(context2, "context");
                    arrayList2.add(new FailedUploadList$a(displayName, jComputeFileSizeBytes, AttachmentUtilsKt.getMimeType(attachment, context2.getContentResolver())));
                }
                failedUploadList$b$b = new FailedUploadList$b$a(arrayList2);
            } else {
                long jComputeFileSizeBytes2 = 0;
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    Uri uri2 = ((Attachment) it3.next()).getUri();
                    Context context3 = getContext();
                    m.checkNotNullExpressionValue(context3, "context");
                    ContentResolver contentResolver2 = context3.getContentResolver();
                    m.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
                    jComputeFileSizeBytes2 += SendUtilsKt.computeFileSizeBytes(uri2, contentResolver2);
                }
                failedUploadList$b$b = new FailedUploadList$b$b(arrayList.size(), jComputeFileSizeBytes2);
            }
            if (failedUploadList$b$b instanceof FailedUploadList$b$a) {
                List<FailedUploadList$a> list = ((FailedUploadList$b$a) failedUploadList$b$b).a;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    FailedUploadList$a failedUploadList$a = list.get(i);
                    FailedUploadView failedUploadView = getFailedUploadViews().get(i);
                    failedUploadView.setVisibility(0);
                    String str = failedUploadList$a.a;
                    Context context4 = failedUploadView.getContext();
                    m.checkNotNullExpressionValue(context4, "context");
                    failedUploadView.a(str, FileUtilsKt.getIconForFiletype(context4, failedUploadList$a.c), FileUtilsKt.getSizeSubtitle(failedUploadList$a.f2828b));
                }
                return;
            }
            if (failedUploadList$b$b instanceof FailedUploadList$b$b) {
                FailedUploadList$b$b failedUploadList$b$b2 = (FailedUploadList$b$b) failedUploadList$b$b;
                int i2 = failedUploadList$b$b2.a;
                long j = failedUploadList$b$b2.f2829b;
                ((View) u.first((List) getFailedUploadViews())).setVisibility(0);
                FailedUploadView failedUploadView2 = (FailedUploadView) u.first((List) getFailedUploadViews());
                Resources resources = failedUploadView2.getResources();
                m.checkNotNullExpressionValue(resources, "resources");
                Context context5 = failedUploadView2.getContext();
                m.checkNotNullExpressionValue(context5, "context");
                CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources, context5, R$plurals.uploading_files_failed_count, i2, Integer.valueOf(i2));
                Context context6 = failedUploadView2.getContext();
                m.checkNotNullExpressionValue(context6, "context");
                failedUploadView2.a(quantityString, DrawableCompat.getThemedDrawableRes$default(context6, 2130969555, 0, 2, (Object) null), FileUtilsKt.getSizeSubtitle(j));
            }
        }
    }
}
