package com.discord.stores;

import android.content.Context;
import com.discord.restapi.RestAPIParams$ComponentInteraction;
import com.discord.restapi.RestAPIParams$ComponentInteractionData;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationInteractions$sendComponentInteraction$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $applicationId;
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ int $componentIndex;
    public final /* synthetic */ RestAPIParams$ComponentInteractionData $data;
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ Long $messageFlags;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ String $nonce;
    public final /* synthetic */ StoreApplicationInteractions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationInteractions$sendComponentInteraction$1(StoreApplicationInteractions storeApplicationInteractions, long j, int i, String str, long j2, Long l, long j3, Long l2, RestAPIParams$ComponentInteractionData restAPIParams$ComponentInteractionData) {
        super(0);
        this.this$0 = storeApplicationInteractions;
        this.$messageId = j;
        this.$componentIndex = i;
        this.$nonce = str;
        this.$channelId = j2;
        this.$guildId = l;
        this.$applicationId = j3;
        this.$messageFlags = l2;
        this.$data = restAPIParams$ComponentInteractionData;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean z2;
        boolean z3;
        Collection<StoreApplicationInteractions$ComponentLocation> collectionValues = this.this$0.getComponentInteractions().values();
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator<T> it = collectionValues.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                } else {
                    if (((StoreApplicationInteractions$ComponentLocation) it.next()).getMessageId() == this.$messageId) {
                        z2 = true;
                        break;
                    }
                }
            }
        } else {
            z2 = false;
            break;
        }
        if (!z2) {
            this.this$0.getComponentInteractions().put(this.$nonce, new StoreApplicationInteractions$ComponentLocation(this.$messageId, this.$componentIndex));
            StoreApplicationInteractions.access$addInteractionStateToComponent(this.this$0, this.$messageId, this.$componentIndex, StoreApplicationInteractions$InteractionSendState$Loading.INSTANCE);
            this.this$0.getSentInteractions$app_productionGoogleRelease().put(this.$nonce, new StoreApplicationInteractions$SentInteraction(this.$channelId, Long.valueOf(this.$messageId), this.$guildId, null, 8, null));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreApplicationInteractions.access$getRestAPI$p(this.this$0).sendComponentInteraction(new RestAPIParams$ComponentInteraction(3L, this.$channelId, this.$applicationId, this.$guildId, this.$messageId, this.$messageFlags, this.$data, StoreApplicationInteractions.access$getSessionId$p(this.this$0), this.$nonce)), false, 1, null), this.this$0.getClass(), (Context) null, (Function1) null, new StoreApplicationInteractions$sendComponentInteraction$1$4(this), (Function0) null, (Function0) null, StoreApplicationInteractions$sendComponentInteraction$1$3.INSTANCE, 54, (Object) null);
            return;
        }
        Collection<StoreApplicationInteractions$ComponentLocation> collectionValues2 = this.this$0.getComponentInteractions().values();
        if (!(collectionValues2 instanceof Collection) || !collectionValues2.isEmpty()) {
            Iterator<T> it2 = collectionValues2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = true;
                    break;
                }
                StoreApplicationInteractions$ComponentLocation storeApplicationInteractions$ComponentLocation = (StoreApplicationInteractions$ComponentLocation) it2.next();
                if (!(storeApplicationInteractions$ComponentLocation.getMessageId() == this.$messageId && storeApplicationInteractions$ComponentLocation.getComponentIndex() != this.$componentIndex)) {
                    z3 = false;
                    break;
                }
            }
        } else {
            z3 = true;
            break;
        }
        if (z3) {
            StoreApplicationInteractions.access$getStoreLocalActionComponentState$p(this.this$0).clearState(this.$messageId, Integer.valueOf(this.$componentIndex));
        }
    }
}
