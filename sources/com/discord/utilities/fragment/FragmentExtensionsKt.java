package com.discord.utilities.fragment;

import androidx.fragment.app.Fragment;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;

/* JADX INFO: compiled from: FragmentExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FragmentExtensionsKt {
    public static final Lazy<Boolean> booleanExtra(Fragment fragment, String str, boolean z2) {
        m.checkNotNullParameter(fragment, "$this$booleanExtra");
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return g.lazy(new FragmentExtensionsKt$booleanExtra$1(fragment, str, z2));
    }

    public static /* synthetic */ Lazy booleanExtra$default(Fragment fragment, String str, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return booleanExtra(fragment, str, z2);
    }
}
