package com.discord.stores;

import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreMaskedLinks.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMaskedLinks$Companion {
    private StoreMaskedLinks$Companion() {
    }

    public static final /* synthetic */ String access$getDomainName(StoreMaskedLinks$Companion storeMaskedLinks$Companion, String str) {
        return storeMaskedLinks$Companion.getDomainName(str);
    }

    private final String getDomainName(String url) {
        try {
            Uri uri = Uri.parse(url);
            m.checkNotNullExpressionValue(uri, "Uri.parse(url)");
            return uri.getHost();
        } catch (Exception unused) {
            return null;
        }
    }

    @VisibleForTesting
    public final boolean isImplicitlyTrustedDomain$app_productionGoogleRelease(String name) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return StoreMaskedLinks.access$getTRUSTED_DOMAINS$cp().contains(name) || StoreMaskedLinks.access$getDISCORD_DOMAINS_REGEX$cp().containsMatchIn(name);
    }

    public /* synthetic */ StoreMaskedLinks$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
