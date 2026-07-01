package androidx.core.view;

import android.content.ClipData;
import android.content.ClipData$Item;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import b.d.b.a.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;

    @NonNull
    public final ClipData mClip;

    @Nullable
    public final Bundle mExtras;
    public final int mFlags;

    @Nullable
    public final Uri mLinkUri;
    public final int mSource;

    public ContentInfoCompat(ContentInfoCompat$Builder contentInfoCompat$Builder) {
        this.mClip = (ClipData) Preconditions.checkNotNull(contentInfoCompat$Builder.mClip);
        this.mSource = Preconditions.checkArgumentInRange(contentInfoCompat$Builder.mSource, 0, 3, "source");
        this.mFlags = Preconditions.checkFlagsArgument(contentInfoCompat$Builder.mFlags, 1);
        this.mLinkUri = contentInfoCompat$Builder.mLinkUri;
        this.mExtras = contentInfoCompat$Builder.mExtras;
    }

    private static ClipData buildClipData(ClipDescription clipDescription, List<ClipData$Item> list) {
        ClipData clipData = new ClipData(new ClipDescription(clipDescription), list.get(0));
        for (int i = 1; i < list.size(); i++) {
            clipData.addItem(list.get(i));
        }
        return clipData;
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public static String flagsToString(int i) {
        return (i & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i);
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public static String sourceToString(int i) {
        if (i == 0) {
            return "SOURCE_APP";
        }
        if (i == 1) {
            return "SOURCE_CLIPBOARD";
        }
        if (i != 2) {
            return i != 3 ? String.valueOf(i) : "SOURCE_DRAG_AND_DROP";
        }
        return "SOURCE_INPUT_METHOD";
    }

    @NonNull
    public ClipData getClip() {
        return this.mClip;
    }

    @Nullable
    public Bundle getExtras() {
        return this.mExtras;
    }

    public int getFlags() {
        return this.mFlags;
    }

    @Nullable
    public Uri getLinkUri() {
        return this.mLinkUri;
    }

    public int getSource() {
        return this.mSource;
    }

    @NonNull
    public Pair<ContentInfoCompat, ContentInfoCompat> partition(@NonNull Predicate<ClipData$Item> predicate) {
        if (this.mClip.getItemCount() == 1) {
            boolean zTest = predicate.test(this.mClip.getItemAt(0));
            return Pair.create(zTest ? this : null, zTest ? null : this);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.mClip.getItemCount(); i++) {
            ClipData$Item itemAt = this.mClip.getItemAt(i);
            if (predicate.test(itemAt)) {
                arrayList.add(itemAt);
            } else {
                arrayList2.add(itemAt);
            }
        }
        if (arrayList.isEmpty()) {
            return Pair.create(null, this);
        }
        return arrayList2.isEmpty() ? Pair.create(this, null) : Pair.create(new ContentInfoCompat$Builder(this).setClip(buildClipData(this.mClip.getDescription(), arrayList)).build(), new ContentInfoCompat$Builder(this).setClip(buildClipData(this.mClip.getDescription(), arrayList2)).build());
    }

    @NonNull
    public String toString() {
        String string;
        StringBuilder sbU = a.U("ContentInfoCompat{clip=");
        sbU.append(this.mClip.getDescription());
        sbU.append(", source=");
        sbU.append(sourceToString(this.mSource));
        sbU.append(", flags=");
        sbU.append(flagsToString(this.mFlags));
        if (this.mLinkUri == null) {
            string = "";
        } else {
            StringBuilder sbU2 = a.U(", hasLinkUri(");
            sbU2.append(this.mLinkUri.toString().length());
            sbU2.append(")");
            string = sbU2.toString();
        }
        sbU.append(string);
        return a.J(sbU, this.mExtras != null ? ", hasExtras" : "", "}");
    }
}
