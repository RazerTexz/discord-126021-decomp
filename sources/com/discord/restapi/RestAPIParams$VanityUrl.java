package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$VanityUrl {
    private final String code;

    public RestAPIParams$VanityUrl() {
        this(null, 1, null);
    }

    public RestAPIParams$VanityUrl(String str) {
        this.code = str;
    }

    public /* synthetic */ RestAPIParams$VanityUrl(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}
