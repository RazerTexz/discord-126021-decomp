package com.discord.stores;

import android.content.Context;
import com.discord.api.botuikit.ComponentType;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.restapi.RestAPIParams$ModalInteraction;
import com.discord.restapi.RestAPIParams$ModalInteractionData;
import com.discord.restapi.RestAPIParams$ModalInteractionDataComponent;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationInteractions$sendModalInteraction$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $components;
    public final /* synthetic */ StoreApplicationInteractions$SentInteraction $localSendData;
    public final /* synthetic */ InteractionModalCreate $modal;
    public final /* synthetic */ long $nonce;
    public final /* synthetic */ Function0 $onError;
    public final /* synthetic */ Function1 $onNext;
    public final /* synthetic */ StoreApplicationInteractions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationInteractions$sendModalInteraction$1(StoreApplicationInteractions storeApplicationInteractions, InteractionModalCreate interactionModalCreate, StoreApplicationInteractions$SentInteraction storeApplicationInteractions$SentInteraction, long j, List list, Function1 function1, Function0 function0) {
        super(0);
        this.this$0 = storeApplicationInteractions;
        this.$modal = interactionModalCreate;
        this.$localSendData = storeApplicationInteractions$SentInteraction;
        this.$nonce = j;
        this.$components = list;
        this.$onNext = function1;
        this.$onError = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        RestAPI restAPIAccess$getRestAPI$p = StoreApplicationInteractions.access$getRestAPI$p(this.this$0);
        long id2 = this.$modal.getApplication().getId();
        long channelId = this.$localSendData.getChannelId();
        Long guildId = this.$localSendData.getGuildId();
        long j = this.$nonce;
        String strAccess$getSessionId$p = StoreApplicationInteractions.access$getSessionId$p(this.this$0);
        long id3 = this.$modal.getId();
        String customId = this.$modal.getCustomId();
        List list = this.$components;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(new RestAPIParams$ModalInteractionDataComponent(ComponentType.ACTION_ROW, m.listOf(new RestAPIParams$ModalInteractionDataComponent(ComponentType.TEXT, null, (String) pair.getFirst(), (String) pair.getSecond())), null, null));
            it = it;
            restAPIAccess$getRestAPI$p = restAPIAccess$getRestAPI$p;
            j = j;
            strAccess$getSessionId$p = strAccess$getSessionId$p;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(restAPIAccess$getRestAPI$p.sendModalInteraction(new RestAPIParams$ModalInteraction(5L, id2, null, channelId, guildId, strAccess$getSessionId$p, j, new RestAPIParams$ModalInteractionData(id3, customId, arrayList))), false, 1, null), this.this$0.getClass(), (Context) null, (Function1) null, new StoreApplicationInteractions$sendModalInteraction$1$3(this), (Function0) null, (Function0) null, new StoreApplicationInteractions$sendModalInteraction$1$2(this), 54, (Object) null);
    }
}
