package com.discord.utilities.view.text;

import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LinkifiedTextView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LinkifiedTextView$Companion$logger$2 extends o implements Function0<Logger> {
    public static final LinkifiedTextView$Companion$logger$2 INSTANCE = new LinkifiedTextView$Companion$logger$2();

    public LinkifiedTextView$Companion$logger$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Logger invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Logger invoke() {
        return LoggingProvider.INSTANCE.get();
    }
}
