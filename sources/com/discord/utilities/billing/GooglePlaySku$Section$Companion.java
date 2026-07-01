package com.discord.utilities.billing;

import androidx.annotation.StringRes;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GooglePlaySku.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GooglePlaySku$Section$Companion {
    private GooglePlaySku$Section$Companion() {
    }

    @StringRes
    public final int getHeaderResource(GooglePlaySku$Section section) {
        m.checkNotNullParameter(section, "section");
        int iOrdinal = section.ordinal();
        if (iOrdinal == 0) {
            return 2131887137;
        }
        if (iOrdinal == 1) {
            return 2131887133;
        }
        if (iOrdinal == 2) {
            return 2131887136;
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ GooglePlaySku$Section$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
