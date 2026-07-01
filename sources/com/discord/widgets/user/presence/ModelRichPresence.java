package com.discord.widgets.user.presence;

import b.d.b.a.outline;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.presence.PresenceUtils;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ModelRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelRichPresence {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Presence presence;
    private final Application primaryApplication;

    /* JADX INFO: compiled from: ModelRichPresence.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ Observable get$default(Companion companion, long j, StoreUserPresence storeUserPresence, int i, Object obj) {
            if ((i & 2) != 0) {
                storeUserPresence = StoreStream.INSTANCE.getPresences();
            }
            return companion.get(j, storeUserPresence);
        }

        public final Observable<ModelRichPresence> get(long userId, StoreUserPresence storeUserPresence) {
            Intrinsics3.checkNotNullParameter(storeUserPresence, "storeUserPresence");
            Observable observableY = storeUserPresence.observePresenceForUser(userId).Y(new Func1<Presence, Observable<? extends ModelRichPresence>>() { // from class: com.discord.widgets.user.presence.ModelRichPresence$Companion$get$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // j0.k.Func1
                public final Observable<? extends ModelRichPresence> call(final Presence presence) {
                    Long applicationId;
                    Application application = null;
                    Object[] objArr = 0;
                    if (presence == null) {
                        return new ScalarSynchronousObservable(null);
                    }
                    Activity primaryActivity = PresenceUtils.INSTANCE.getPrimaryActivity(presence);
                    return (primaryActivity == null || (applicationId = primaryActivity.getApplicationId()) == null) ? new ScalarSynchronousObservable(new ModelRichPresence(presence, application, 2, objArr == true ? 1 : 0)) : StoreStream.INSTANCE.getApplication().observeApplication(Long.valueOf(applicationId.longValue())).G(new Func1<Application, ModelRichPresence>() { // from class: com.discord.widgets.user.presence.ModelRichPresence$Companion$get$1$$special$$inlined$let$lambda$1
                        @Override // j0.k.Func1
                        public final ModelRichPresence call(Application application2) {
                            return new ModelRichPresence(presence, application2);
                        }
                    });
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeUserPresence\n      …          }\n            }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ModelRichPresence(Presence presence, Application application) {
        Intrinsics3.checkNotNullParameter(presence, "presence");
        this.presence = presence;
        this.primaryApplication = application;
    }

    public static /* synthetic */ ModelRichPresence copy$default(ModelRichPresence modelRichPresence, Presence presence, Application application, int i, Object obj) {
        if ((i & 1) != 0) {
            presence = modelRichPresence.presence;
        }
        if ((i & 2) != 0) {
            application = modelRichPresence.primaryApplication;
        }
        return modelRichPresence.copy(presence, application);
    }

    public static final Observable<ModelRichPresence> get(long j, StoreUserPresence storeUserPresence) {
        return INSTANCE.get(j, storeUserPresence);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Application getPrimaryApplication() {
        return this.primaryApplication;
    }

    public final ModelRichPresence copy(Presence presence, Application primaryApplication) {
        Intrinsics3.checkNotNullParameter(presence, "presence");
        return new ModelRichPresence(presence, primaryApplication);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelRichPresence)) {
            return false;
        }
        ModelRichPresence modelRichPresence = (ModelRichPresence) other;
        return Intrinsics3.areEqual(this.presence, modelRichPresence.presence) && Intrinsics3.areEqual(this.primaryApplication, modelRichPresence.primaryApplication);
    }

    public final Presence getPresence() {
        return this.presence;
    }

    public final Activity getPrimaryActivity() {
        return PresenceUtils.INSTANCE.getPrimaryActivity(this.presence);
    }

    public final Application getPrimaryApplication() {
        return this.primaryApplication;
    }

    public int hashCode() {
        Presence presence = this.presence;
        int iHashCode = (presence != null ? presence.hashCode() : 0) * 31;
        Application application = this.primaryApplication;
        return iHashCode + (application != null ? application.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelRichPresence(presence=");
        sbU.append(this.presence);
        sbU.append(", primaryApplication=");
        sbU.append(this.primaryApplication);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ ModelRichPresence(Presence presence, Application application, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(presence, (i & 2) != 0 ? null : application);
    }
}
