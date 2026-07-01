package com.google.android.gms.nearby.messages;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.f.j.b.d;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscribeOptions {
    public final Strategy a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MessageFilter f3019b;

    @Nullable
    public final d c = null;
    public final boolean d = false;

    static {
        Strategy strategy = Strategy.j;
        MessageFilter messageFilter = MessageFilter.j;
    }

    public SubscribeOptions(Strategy strategy, MessageFilter messageFilter, d dVar) {
        this.a = strategy;
        this.f3019b = messageFilter;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.a);
        String strValueOf2 = String.valueOf(this.f3019b);
        StringBuilder sbS = outline.S(strValueOf2.length() + strValueOf.length() + 36, "SubscribeOptions{strategy=", strValueOf, ", filter=", strValueOf2);
        sbS.append('}');
        return sbS.toString();
    }
}
