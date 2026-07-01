package com.discord.utilities.view.text;

import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.view.text.LinkifiedTextView$Companion$logger$2, reason: use source file name */
/* JADX INFO: compiled from: LinkifiedTextView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LinkifiedTextView5 extends Lambda implements Function0<Logger> {
    public static final LinkifiedTextView5 INSTANCE = new LinkifiedTextView5();

    public LinkifiedTextView5() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Logger invoke() {
        return LoggingProvider.INSTANCE.get();
    }
}
