package com.discord.stores;

import co.discord.media_engine.VideoInputDeviceDescription;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.stores.StoreMediaEngine$selectDefaultVideoDevice$1", f = "StoreMediaEngine.kt", l = {Opcodes.ANEWARRAY}, m = "invokeSuspend")
public final class StoreMediaEngine$selectDefaultVideoDevice$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function1 $onSelected;
    public int label;
    public final /* synthetic */ StoreMediaEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMediaEngine$selectDefaultVideoDevice$1(StoreMediaEngine storeMediaEngine, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = storeMediaEngine;
        this.$onSelected = function1;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new StoreMediaEngine$selectDefaultVideoDevice$1(this.this$0, this.$onSelected, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoreMediaEngine$selectDefaultVideoDevice$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            StoreMediaEngine storeMediaEngine = this.this$0;
            this.label = 1;
            obj = storeMediaEngine.awaitVideoInputDevicesNativeAsync(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
        }
        VideoInputDeviceDescription[] videoInputDeviceDescriptionArr = (VideoInputDeviceDescription[]) obj;
        StoreMediaEngine.access$handleVideoInputDevices(this.this$0, videoInputDeviceDescriptionArr, StoreMediaEngine.access$pickDefaultDeviceGUID(this.this$0, videoInputDeviceDescriptionArr), this.$onSelected);
        return Unit.a;
    }
}
