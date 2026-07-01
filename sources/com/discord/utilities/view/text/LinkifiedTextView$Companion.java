package com.discord.utilities.view.text;

import android.view.View;
import com.discord.utilities.logging.Logger;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LinkifiedTextView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LinkifiedTextView$Companion {
    private LinkifiedTextView$Companion() {
    }

    public static final /* synthetic */ Logger access$getLogger$p(LinkifiedTextView$Companion linkifiedTextView$Companion) {
        return linkifiedTextView$Companion.getLogger();
    }

    private final Logger getLogger() {
        Lazy lazyAccess$getLogger$cp = LinkifiedTextView.access$getLogger$cp();
        LinkifiedTextView$Companion linkifiedTextView$Companion = LinkifiedTextView.Companion;
        return (Logger) lazyAccess$getLogger$cp.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Unit init$default(LinkifiedTextView$Companion linkifiedTextView$Companion, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = null;
        }
        return linkifiedTextView$Companion.init(function2);
    }

    public final Unit init(Function2<? super View, ? super String, Unit> onURLSpanClicked) {
        if (onURLSpanClicked == null) {
            return null;
        }
        LinkifiedTextView.access$setOnURLSpanClicked$cp(onURLSpanClicked);
        return Unit.a;
    }

    public /* synthetic */ LinkifiedTextView$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
