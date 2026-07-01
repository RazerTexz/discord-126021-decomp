package com.discord.widgets.user.presence;

import androidx.core.app.NotificationCompat;
import com.discord.api.application.Application;
import com.discord.models.presence.Presence;
import j0.k.b;

/* JADX INFO: compiled from: ModelRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelRichPresence$Companion$get$1$$special$$inlined$let$lambda$1<T, R> implements b<Application, ModelRichPresence> {
    public final /* synthetic */ Presence $presence$inlined;

    public ModelRichPresence$Companion$get$1$$special$$inlined$let$lambda$1(Presence presence) {
        this.$presence$inlined = presence;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ ModelRichPresence call(Application application) {
        return call2(application);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ModelRichPresence call2(Application application) {
        return new ModelRichPresence(this.$presence$inlined, application);
    }
}
