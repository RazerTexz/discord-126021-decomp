package androidx.work;

import android.net.Uri;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ContentUriTriggers$Trigger {
    private final boolean mTriggerForDescendants;

    @NonNull
    private final Uri mUri;

    public ContentUriTriggers$Trigger(@NonNull Uri uri, boolean z2) {
        this.mUri = uri;
        this.mTriggerForDescendants = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ContentUriTriggers$Trigger.class != obj.getClass()) {
            return false;
        }
        ContentUriTriggers$Trigger contentUriTriggers$Trigger = (ContentUriTriggers$Trigger) obj;
        return this.mTriggerForDescendants == contentUriTriggers$Trigger.mTriggerForDescendants && this.mUri.equals(contentUriTriggers$Trigger.mUri);
    }

    @NonNull
    public Uri getUri() {
        return this.mUri;
    }

    public int hashCode() {
        return (this.mUri.hashCode() * 31) + (this.mTriggerForDescendants ? 1 : 0);
    }

    public boolean shouldTriggerForDescendants() {
        return this.mTriggerForDescendants;
    }
}
