package com.discord.widgets.user.presence;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserPresence;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ModelStageRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelStageRichPresence$Companion {
    private ModelStageRichPresence$Companion() {
    }

    public static /* synthetic */ Observable observeStageRichPresence$default(ModelStageRichPresence$Companion modelStageRichPresence$Companion, StoreUserPresence storeUserPresence, int i, Object obj) {
        if ((i & 1) != 0) {
            storeUserPresence = StoreStream.Companion.getPresences();
        }
        return modelStageRichPresence$Companion.observeStageRichPresence(storeUserPresence);
    }

    public final Observable<List<ModelStageRichPresence>> observeStageRichPresence(StoreUserPresence storeUserPresence) {
        m.checkNotNullParameter(storeUserPresence, "storeUserPresence");
        Observable observableG = storeUserPresence.observeAllPresences().G(ModelStageRichPresence$Companion$observeStageRichPresence$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "storeUserPresence\n      …   }.toList()\n          }");
        return observableG;
    }

    public /* synthetic */ ModelStageRichPresence$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
