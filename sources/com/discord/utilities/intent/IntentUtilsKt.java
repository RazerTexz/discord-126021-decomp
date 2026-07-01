package com.discord.utilities.intent;

import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentUtilsKt {
    public static final Long getLongExtraOrNull(Intent intent, String str) {
        Intrinsics3.checkNotNullParameter(intent, "$this$getLongExtraOrNull");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        long longExtra = intent.getLongExtra(str, RecyclerView.FOREVER_NS);
        if (longExtra != RecyclerView.FOREVER_NS) {
            return Long.valueOf(longExtra);
        }
        return null;
    }

    public static final String getStringExtraOrDefault(Intent intent, String str, String str2) {
        Intrinsics3.checkNotNullParameter(intent, "$this$getStringExtraOrDefault");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "default");
        String stringExtra = intent.getStringExtra(str);
        if (stringExtra != null) {
            str2 = stringExtra;
        }
        Intrinsics3.checkNotNullExpressionValue(str2, "getStringExtra(name) ?: default");
        return str2;
    }

    public static /* synthetic */ String getStringExtraOrDefault$default(Intent intent, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return getStringExtraOrDefault(intent, str, str2);
    }
}
