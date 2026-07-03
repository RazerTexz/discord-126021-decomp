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
import com.discord.C5419R;
import com.discord.api.message.LocalAttachment;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.file.FileUtilsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.SendUtilsKt;
import com.lytefast.flexinput.model.Attachment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p025i.C0938d2;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FailedUploadList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FailedUploadList extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C0938d2 binding;

    /* JADX INFO: renamed from: com.discord.views.FailedUploadList$a */
    /* JADX INFO: compiled from: FailedUploadList.kt */
    public static final class C7076a {

        /* JADX INFO: renamed from: a */
        public final String f19064a;

        /* JADX INFO: renamed from: b */
        public final long f19065b;

        /* JADX INFO: renamed from: c */
        public final String f19066c;

        public C7076a(String str, long j, String str2) {
            C12238m.checkNotNullParameter(str, "displayName");
            C12238m.checkNotNullParameter(str2, "mimeType");
            this.f19064a = str;
            this.f19065b = j;
            this.f19066c = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C7076a)) {
                return false;
            }
            C7076a c7076a = (C7076a) obj;
            return C12238m.areEqual(this.f19064a, c7076a.f19064a) && this.f19065b == c7076a.f19065b && C12238m.areEqual(this.f19066c, c7076a.f19066c);
        }

        public int hashCode() {
            String str = this.f19064a;
            int iM3a = (C0002b.m3a(this.f19065b) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
            String str2 = this.f19066c;
            return iM3a + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("SingleFailedUpload(displayName=");
            sbM833U.append(this.f19064a);
            sbM833U.append(", sizeBytes=");
            sbM833U.append(this.f19065b);
            sbM833U.append(", mimeType=");
            return C1643a.m822J(sbM833U, this.f19066c, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.views.FailedUploadList$b */
    /* JADX INFO: compiled from: FailedUploadList.kt */
    public static abstract class AbstractC7077b {

        /* JADX INFO: renamed from: com.discord.views.FailedUploadList$b$a */
        /* JADX INFO: compiled from: FailedUploadList.kt */
        public static final class a extends AbstractC7077b {

            /* JADX INFO: renamed from: a */
            public final List<C7076a> f19067a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(List<C7076a> list) {
                super(null);
                C12238m.checkNotNullParameter(list, "uploads");
                this.f19067a = list;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && C12238m.areEqual(this.f19067a, ((a) obj).f19067a);
                }
                return true;
            }

            public int hashCode() {
                List<C7076a> list = this.f19067a;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m824L(C1643a.m833U("FewFailedUploads(uploads="), this.f19067a, ")");
            }
        }

        /* JADX INFO: renamed from: com.discord.views.FailedUploadList$b$b */
        /* JADX INFO: compiled from: FailedUploadList.kt */
        public static final class b extends AbstractC7077b {

            /* JADX INFO: renamed from: a */
            public final int f19068a;

            /* JADX INFO: renamed from: b */
            public final long f19069b;

            public b(int i, long j) {
                super(null);
                this.f19068a = i;
                this.f19069b = j;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return this.f19068a == bVar.f19068a && this.f19069b == bVar.f19069b;
            }

            public int hashCode() {
                return C0002b.m3a(this.f19069b) + (this.f19068a * 31);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("ManyFailedUploads(uploadCount=");
                sbM833U.append(this.f19068a);
                sbM833U.append(", sizeBytes=");
                return C1643a.m815C(sbM833U, this.f19069b, ")");
            }
        }

        public AbstractC7077b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public FailedUploadList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.view_chat_upload_list, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.chat_upload_1;
        FailedUploadView failedUploadView = (FailedUploadView) viewInflate.findViewById(C5419R.id.chat_upload_1);
        if (failedUploadView != null) {
            i = C5419R.id.chat_upload_2;
            FailedUploadView failedUploadView2 = (FailedUploadView) viewInflate.findViewById(C5419R.id.chat_upload_2);
            if (failedUploadView2 != null) {
                i = C5419R.id.chat_upload_3;
                FailedUploadView failedUploadView3 = (FailedUploadView) viewInflate.findViewById(C5419R.id.chat_upload_3);
                if (failedUploadView3 != null) {
                    C0938d2 c0938d2 = new C0938d2((LinearLayout) viewInflate, failedUploadView, failedUploadView2, failedUploadView3);
                    C12238m.checkNotNullExpressionValue(c0938d2, "ViewChatUploadListBindin…rom(context), this, true)");
                    this.binding = c0938d2;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final List<FailedUploadView> getFailedUploadViews() {
        FailedUploadView failedUploadView = this.binding.f779b;
        C12238m.checkNotNullExpressionValue(failedUploadView, "binding.chatUpload1");
        FailedUploadView failedUploadView2 = this.binding.f780c;
        C12238m.checkNotNullExpressionValue(failedUploadView2, "binding.chatUpload2");
        FailedUploadView failedUploadView3 = this.binding.f781d;
        C12238m.checkNotNullExpressionValue(failedUploadView3, "binding.chatUpload3");
        return C12147n.listOf((Object[]) new FailedUploadView[]{failedUploadView, failedUploadView2, failedUploadView3});
    }

    public final void setUp(List<LocalAttachment> localAttachments) {
        Object bVar;
        C12238m.checkNotNullParameter(localAttachments, "localAttachments");
        Iterator<T> it = getFailedUploadViews().iterator();
        while (it.hasNext()) {
            ((FailedUploadView) it.next()).setVisibility(8);
        }
        if (!localAttachments.isEmpty()) {
            ArrayList<Attachment> arrayList = new ArrayList(C12149o.collectionSizeOrDefault(localAttachments, 10));
            Iterator<T> it2 = localAttachments.iterator();
            while (it2.hasNext()) {
                arrayList.add(AttachmentUtilsKt.toAttachment((LocalAttachment) it2.next()));
            }
            if (arrayList.size() <= 3) {
                ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
                for (Attachment attachment : arrayList) {
                    String displayName = attachment.getDisplayName();
                    Uri uri = attachment.getUri();
                    Context context = getContext();
                    C12238m.checkNotNullExpressionValue(context, "context");
                    ContentResolver contentResolver = context.getContentResolver();
                    C12238m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                    long jComputeFileSizeBytes = SendUtilsKt.computeFileSizeBytes(uri, contentResolver);
                    Context context2 = getContext();
                    C12238m.checkNotNullExpressionValue(context2, "context");
                    arrayList2.add(new C7076a(displayName, jComputeFileSizeBytes, AttachmentUtilsKt.getMimeType(attachment, context2.getContentResolver())));
                }
                bVar = new AbstractC7077b.a(arrayList2);
            } else {
                long jComputeFileSizeBytes2 = 0;
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    Uri uri2 = ((Attachment) it3.next()).getUri();
                    Context context3 = getContext();
                    C12238m.checkNotNullExpressionValue(context3, "context");
                    ContentResolver contentResolver2 = context3.getContentResolver();
                    C12238m.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
                    jComputeFileSizeBytes2 += SendUtilsKt.computeFileSizeBytes(uri2, contentResolver2);
                }
                bVar = new AbstractC7077b.b(arrayList.size(), jComputeFileSizeBytes2);
            }
            if (bVar instanceof AbstractC7077b.a) {
                List<C7076a> list = ((AbstractC7077b.a) bVar).f19067a;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    C7076a c7076a = list.get(i);
                    FailedUploadView failedUploadView = getFailedUploadViews().get(i);
                    failedUploadView.setVisibility(0);
                    String str = c7076a.f19064a;
                    Context context4 = failedUploadView.getContext();
                    C12238m.checkNotNullExpressionValue(context4, "context");
                    failedUploadView.m8544a(str, FileUtilsKt.getIconForFiletype(context4, c7076a.f19066c), FileUtilsKt.getSizeSubtitle(c7076a.f19065b));
                }
                return;
            }
            if (bVar instanceof AbstractC7077b.b) {
                AbstractC7077b.b bVar2 = (AbstractC7077b.b) bVar;
                int i2 = bVar2.f19068a;
                long j = bVar2.f19069b;
                ((View) C12163u.first((List) getFailedUploadViews())).setVisibility(0);
                FailedUploadView failedUploadView2 = (FailedUploadView) C12163u.first((List) getFailedUploadViews());
                Resources resources = failedUploadView2.getResources();
                C12238m.checkNotNullExpressionValue(resources, "resources");
                Context context5 = failedUploadView2.getContext();
                C12238m.checkNotNullExpressionValue(context5, "context");
                CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources, context5, C5419R.plurals.uploading_files_failed_count, i2, Integer.valueOf(i2));
                Context context6 = failedUploadView2.getContext();
                C12238m.checkNotNullExpressionValue(context6, "context");
                failedUploadView2.m8544a(quantityString, DrawableCompat.getThemedDrawableRes$default(context6, C5419R.attr.ic_uploads_generic, 0, 2, (Object) null), FileUtilsKt.getSizeSubtitle(j));
            }
        }
    }
}
