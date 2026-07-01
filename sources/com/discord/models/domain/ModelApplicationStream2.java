package com.discord.models.domain;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.models.domain.ModelApplicationStream$encodedStreamKey$2, reason: use source file name */
/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelApplicationStream2 extends Lambda implements Function0<String> {
    public final /* synthetic */ ModelApplicationStream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelApplicationStream2(ModelApplicationStream modelApplicationStream) {
        super(0);
        this.this$0 = modelApplicationStream;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.encodeStreamKey();
    }
}
