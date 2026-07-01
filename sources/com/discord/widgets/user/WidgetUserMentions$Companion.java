package com.discord.widgets.user;

import androidx.core.os.BundleKt;
import d0.o;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$Companion {
    private WidgetUserMentions$Companion() {
    }

    public static /* synthetic */ WidgetUserMentions create$default(WidgetUserMentions$Companion widgetUserMentions$Companion, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return widgetUserMentions$Companion.create(z2);
    }

    public final WidgetUserMentions create(boolean isEmbedded) {
        WidgetUserMentions widgetUserMentions = new WidgetUserMentions();
        widgetUserMentions.setArguments(BundleKt.bundleOf(o.to("EXTRA_HIDE_TITLE", Boolean.valueOf(isEmbedded))));
        return widgetUserMentions;
    }

    public /* synthetic */ WidgetUserMentions$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
