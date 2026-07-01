package com.discord.widgets.user.presence;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserPresence;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ModelRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelRichPresence$Companion {
    private ModelRichPresence$Companion() {
    }

    public static /* synthetic */ Observable get$default(ModelRichPresence$Companion modelRichPresence$Companion, long j, StoreUserPresence storeUserPresence, int i, Object obj) {
        if ((i & 2) != 0) {
            storeUserPresence = StoreStream.Companion.getPresences();
        }
        return modelRichPresence$Companion.get(j, storeUserPresence);
    }

    public final Observable<ModelRichPresence> get(long userId, StoreUserPresence storeUserPresence) {
        m.checkNotNullParameter(storeUserPresence, "storeUserPresence");
        Observable observableY = storeUserPresence.observePresenceForUser(userId).Y(ModelRichPresence$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "storeUserPresence\n      …          }\n            }");
        return observableY;
    }

    public /* synthetic */ ModelRichPresence$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
