package com.discord.models.domain;

import d0.g0.w;
import d0.z.d.m;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelApplicationStream$Companion {
    private ModelApplicationStream$Companion() {
    }

    public final ModelApplicationStream decodeStreamKey(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        List listSplit$default = w.split$default((CharSequence) streamKey, new String[]{":"}, false, 0, 6, (Object) null);
        int iOrdinal = StreamType.Companion.fromString((String) listSplit$default.get(0)).ordinal();
        if (iOrdinal == 0) {
            return new ModelApplicationStream$GuildStream(Long.parseLong((String) listSplit$default.get(1)), Long.parseLong((String) listSplit$default.get(2)), Long.parseLong((String) listSplit$default.get(3)));
        }
        if (iOrdinal == 1) {
            return new ModelApplicationStream$CallStream(Long.parseLong((String) listSplit$default.get(1)), Long.parseLong((String) listSplit$default.get(2)));
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ ModelApplicationStream$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
