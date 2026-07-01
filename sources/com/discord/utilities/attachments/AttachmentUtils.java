package com.discord.utilities.attachments;

import android.content.ClipDescription;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import androidx.core.app.NotificationCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.discord.api.message.LocalAttachment;
import com.discord.utilities.string.StringUtils2;
import com.lytefast.flexinput.model.Attachment;
import d0.LazyJVM;
import d0.g0.StringsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import g0.Buffer3;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.Ranges2;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: renamed from: com.discord.utilities.attachments.AttachmentUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: AttachmentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentUtils {
    private static final int UTF_8_RANGE_END_EXCLUSIVE = 126;
    private static final int UTF_8_RANGE_START_EXCLUSIVE = 32;
    private static final Lazy REGEX_FILE_NAME_PATTERN$delegate = LazyJVM.lazy(AttachmentUtils2.INSTANCE);
    private static final Ranges2 UTF_8_RANGE_EXCLUSIVE = new Ranges2(32, 126);

    /* JADX INFO: renamed from: com.discord.utilities.attachments.AttachmentUtilsKt$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Bitmap.CompressFormat.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            $EnumSwitchMapping$1 = iArr;
            iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            iArr[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
            iArr[Bitmap.CompressFormat.JPEG.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.attachments.AttachmentUtilsKt$appendLinks$1, reason: invalid class name */
    /* JADX INFO: compiled from: AttachmentUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Attachment<?>, CharSequence> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(Attachment<?> attachment) {
            Intrinsics3.checkNotNullParameter(attachment, "it");
            Object data = attachment.getData();
            Objects.requireNonNull(data, "null cannot be cast to non-null type androidx.core.view.inputmethod.InputContentInfoCompat");
            InputContentInfoCompat inputContentInfoCompat = (InputContentInfoCompat) data;
            String strValueOf = String.valueOf(inputContentInfoCompat.getLinkUri());
            inputContentInfoCompat.releasePermission();
            return strValueOf;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.attachments.AttachmentUtilsKt$getMimeType$1, reason: invalid class name */
    /* JADX INFO: compiled from: AttachmentUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(String str) {
            Intrinsics3.checkNotNullParameter(str, "file");
            Matcher matcher = AttachmentUtils.getREGEX_FILE_NAME_PATTERN().matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(matcher.group(2));
        }
    }

    public static final String appendLinks(String str, List<? extends Attachment<?>> list) {
        Intrinsics3.checkNotNullParameter(str, "content");
        Intrinsics3.checkNotNullParameter(list, "links");
        return str + "\n" + _Collections.joinToString$default(list, "\n", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null);
    }

    public static final List<Attachment<?>> extractLinks(List<? extends Attachment<?>> list, ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(list, "$this$extractLinks");
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Attachment attachment = (Attachment) obj;
            Object data = attachment.getData();
            if (!(data instanceof InputContentInfoCompat)) {
                data = null;
            }
            InputContentInfoCompat inputContentInfoCompat = (InputContentInfoCompat) data;
            if ((inputContentInfoCompat == null || inputContentInfoCompat.getLinkUri() == null || !Intrinsics3.areEqual(getMimeType(attachment, contentResolver), "image/gif")) ? false : true) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static final String getExtension(Bitmap.CompressFormat compressFormat) {
        int i = WhenMappings.$EnumSwitchMapping$1[compressFormat.ordinal()];
        if (i != 1) {
            return i != 2 ? "jpg" : "webp";
        }
        return "png";
    }

    public static final String getMimeType(ContentResolver contentResolver, Uri uri, String str) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        String strInvoke = null;
        String type = contentResolver != null ? contentResolver.getType(uri) : null;
        if (type != null) {
            return type;
        }
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        try {
            String strInvoke2 = anonymousClass1.invoke(String.valueOf(uri));
            strInvoke = strInvoke2 != null ? strInvoke2 : anonymousClass1.invoke(String.valueOf(str));
        } catch (Exception unused) {
        }
        return strInvoke != null ? strInvoke : "application/octet-stream";
    }

    public static /* synthetic */ String getMimeType$default(ContentResolver contentResolver, Uri uri, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return getMimeType(contentResolver, uri, str);
    }

    private static final Pattern getREGEX_FILE_NAME_PATTERN() {
        return (Pattern) REGEX_FILE_NAME_PATTERN$delegate.getValue();
    }

    public static final String getSanitizedFileName(String str, Bitmap.CompressFormat compressFormat) {
        Intrinsics3.checkNotNullParameter(str, "fileName");
        if (compressFormat != null) {
            Matcher matcher = getREGEX_FILE_NAME_PATTERN().matcher(str);
            if (matcher.matches()) {
                str = matcher.group(1);
            }
            str = str + '.' + getExtension(compressFormat);
        }
        return toHumanReadableAscii(StringUtils2.stripAccents(str));
    }

    public static final boolean isGif(Attachment<?> attachment, ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(attachment, "$this$isGif");
        return Intrinsics3.areEqual(getMimeType(attachment, contentResolver), "image/gif");
    }

    public static final boolean isImage(ContentResolver contentResolver, Uri uri, String str) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        return StringsJVM.startsWith$default(getMimeType(contentResolver, uri, str), "image", false, 2, null);
    }

    public static /* synthetic */ boolean isImage$default(ContentResolver contentResolver, Uri uri, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return isImage(contentResolver, uri, str);
    }

    public static final boolean isImageAttachment(LocalAttachment localAttachment, ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(localAttachment, "$this$isImageAttachment");
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Uri uri = Uri.parse(localAttachment.getUriString());
        Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(uriString)");
        return isImage(contentResolver, uri, localAttachment.getDisplayName());
    }

    public static final boolean isVideo(ContentResolver contentResolver, Uri uri, String str) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        return StringsJVM.startsWith$default(getMimeType(contentResolver, uri, str), MediaStreamTrack.VIDEO_TRACK_KIND, false, 2, null);
    }

    public static /* synthetic */ boolean isVideo$default(ContentResolver contentResolver, Uri uri, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return isVideo(contentResolver, uri, str);
    }

    public static final boolean isVideoAttachment(LocalAttachment localAttachment, ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(localAttachment, "$this$isVideoAttachment");
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Uri uri = Uri.parse(localAttachment.getUriString());
        Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(uriString)");
        return isVideo(contentResolver, uri, localAttachment.getDisplayName());
    }

    public static final Attachment toAttachment(LocalAttachment localAttachment) {
        Intrinsics3.checkNotNullParameter(localAttachment, "$this$toAttachment");
        long jB = localAttachment.getId();
        Uri uri = Uri.parse(localAttachment.getUriString());
        Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(uriString)");
        return new Attachment(jB, uri, localAttachment.getDisplayName(), null, false, 16, null);
    }

    private static final String toHumanReadableAscii(String str) {
        int iCharCount = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (!UTF_8_RANGE_EXCLUSIVE.contains(iCodePointAt)) {
                Buffer3 buffer3 = new Buffer3();
                buffer3.c0(str, 0, iCharCount);
                while (iCharCount < str.length()) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    buffer3.d0(UTF_8_RANGE_EXCLUSIVE.contains(iCodePointAt2) ? iCodePointAt2 : 63);
                    iCharCount += Character.charCount(iCodePointAt2);
                }
                return buffer3.D();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    public static final LocalAttachment toLocalAttachment(Attachment<?> attachment) {
        Intrinsics3.checkNotNullParameter(attachment, "$this$toLocalAttachment");
        long id2 = attachment.getId();
        String string = attachment.getUri().toString();
        Intrinsics3.checkNotNullExpressionValue(string, "uri.toString()");
        return new LocalAttachment(id2, string, attachment.getDisplayName());
    }

    public static final boolean isImage(Attachment<?> attachment, ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(attachment, "$this$isImage");
        return StringsJVM.startsWith$default(getMimeType(attachment, contentResolver), "image", false, 2, null);
    }

    public static final boolean isVideo(Attachment<?> attachment, ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(attachment, "$this$isVideo");
        return StringsJVM.startsWith$default(getMimeType(attachment, contentResolver), MediaStreamTrack.VIDEO_TRACK_KIND, false, 2, null);
    }

    public static final String getMimeType(Attachment<?> attachment, ContentResolver contentResolver) {
        ClipDescription description;
        Intrinsics3.checkNotNullParameter(attachment, "$this$getMimeType");
        Object data = attachment.getData();
        String mimeType = null;
        if (!(data instanceof InputContentInfoCompat)) {
            data = null;
        }
        InputContentInfoCompat inputContentInfoCompat = (InputContentInfoCompat) data;
        if (inputContentInfoCompat != null && (description = inputContentInfoCompat.getDescription()) != null) {
            mimeType = description.getMimeType(0);
        }
        return mimeType != null ? mimeType : getMimeType(contentResolver, attachment.getUri(), attachment.getDisplayName());
    }
}
