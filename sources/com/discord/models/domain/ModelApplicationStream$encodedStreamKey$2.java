package com.discord.models.domain;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelApplicationStream$encodedStreamKey$2 extends AbstractC12240o implements Function0<String> {
    public final /* synthetic */ ModelApplicationStream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelApplicationStream$encodedStreamKey$2(ModelApplicationStream modelApplicationStream) {
        super(0);
        this.this$0 = modelApplicationStream;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.encodeStreamKey();
    }
}
