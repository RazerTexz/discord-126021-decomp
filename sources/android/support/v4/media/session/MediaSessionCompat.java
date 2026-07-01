package android.support.v4.media.session;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.os.BuildCompat;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat {

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public static final int a;

    static {
        a = BuildCompat.isAtLeastS() ? 33554432 : 0;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public static void a(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    @Nullable
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public static Bundle b(@Nullable Bundle bundle) {
        a(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }
}
