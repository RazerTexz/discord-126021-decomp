package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface InputContentInfoCompat$InputContentInfoCompatImpl {
    @NonNull
    Uri getContentUri();

    @NonNull
    ClipDescription getDescription();

    @Nullable
    Object getInputContentInfo();

    @Nullable
    Uri getLinkUri();

    void releasePermission();

    void requestPermission();
}
