package com.discord.views.calls;

import android.widget.ImageView;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class SpeakerPulseView$a extends o implements Function0<ImageView> {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakerPulseView$a(int i, Object obj) {
        super(0);
        this.j = i;
        this.k = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ImageView invoke() {
        int i = this.j;
        if (i == 0) {
            return SpeakerPulseView.a((SpeakerPulseView) this.k, 0);
        }
        if (i == 1) {
            return SpeakerPulseView.a((SpeakerPulseView) this.k, 1);
        }
        throw null;
    }
}
