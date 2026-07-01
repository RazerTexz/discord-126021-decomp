package com.discord.stores;

import co.discord.media_engine.DeviceDescription4;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.discord.stores.StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1", f = "StoreMediaEngine.kt", l = {266}, m = "invokeSuspend")
public final class StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super DeviceDescription4[]>, Object> {
    public int label;
    public final /* synthetic */ StoreMediaEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1(StoreMediaEngine storeMediaEngine, Continuation continuation) {
        super(2, continuation);
        this.this$0 = storeMediaEngine;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DeviceDescription4[]> continuation) {
        return ((StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0027 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x0028  */
    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    /* JADX WARN: Code duplicated, block: B:20:0x0038  */
    /* JADX WARN: Code duplicated, block: B:22:0x0040 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0042  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0028 -> B:13:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // d0.w.i.a.ContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = d0.w.h.Intrinsics2.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L19
            if (r1 != r2) goto L11
            d0.Result3.throwOnFailure(r6)
            r1 = r0
            r0 = r5
            goto L2c
        L11:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L19:
            d0.Result3.throwOnFailure(r6)
            r6 = r5
        L1d:
            com.discord.stores.StoreMediaEngine r1 = r6.this$0
            r6.label = r2
            java.lang.Object r1 = r1.getVideoInputDevicesNativeAsync(r6)
            if (r1 != r0) goto L28
            return r0
        L28:
            r4 = r0
            r0 = r6
            r6 = r1
            r1 = r4
        L2c:
            co.discord.media_engine.VideoInputDeviceDescription[] r6 = (co.discord.media_engine.DeviceDescription4[]) r6
            int r3 = r6.length
            if (r3 != 0) goto L33
            r3 = 1
            goto L34
        L33:
            r3 = 0
        L34:
            r3 = r3 ^ r2
            if (r3 == 0) goto L38
            return r6
        L38:
            com.discord.stores.StoreMediaEngine r6 = r0.this$0
            boolean r6 = com.discord.stores.StoreMediaEngine.access$getHasTimedOutAwaitingDevice$p(r6)
            if (r6 == 0) goto L42
            r6 = 0
            return r6
        L42:
            r6 = r0
            r0 = r1
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.discord.stores.StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
