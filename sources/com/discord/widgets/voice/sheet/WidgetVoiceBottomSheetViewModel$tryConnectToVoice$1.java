package com.discord.widgets.voice.sheet;

import com.discord.stores.StoreMediaEngine;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@e(c = "com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel$tryConnectToVoice$1", f = "WidgetVoiceBottomSheetViewModel.kt", l = {Opcodes.IRETURN, 180}, m = "invokeSuspend")
public final class WidgetVoiceBottomSheetViewModel$tryConnectToVoice$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ StoreMediaEngine $mediaEngine;
    public int label;
    public final /* synthetic */ WidgetVoiceBottomSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheetViewModel$tryConnectToVoice$1(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel, StoreMediaEngine storeMediaEngine, Continuation continuation) {
        super(2, continuation);
        this.this$0 = widgetVoiceBottomSheetViewModel;
        this.$mediaEngine = storeMediaEngine;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new WidgetVoiceBottomSheetViewModel$tryConnectToVoice$1(this.this$0, this.$mediaEngine, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WidgetVoiceBottomSheetViewModel$tryConnectToVoice$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                l.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            return Unit.a;
        }
        l.throwOnFailure(obj);
        StoreMediaEngine storeMediaEngine = this.$mediaEngine;
        this.label = 1;
        obj = storeMediaEngine.getDefaultVideoDeviceGUID(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (obj != null) {
            WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel = this.this$0;
            WidgetVoiceBottomSheetViewModel.access$joinVoiceChannel(widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.access$getChannelId$p(widgetVoiceBottomSheetViewModel));
            StoreMediaEngine storeMediaEngine2 = this.$mediaEngine;
            this.label = 2;
            if (storeMediaEngine2.selectDefaultVideoDeviceAsync(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            WidgetVoiceBottomSheetViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) WidgetVoiceBottomSheetViewModel$Event$ShowNoVideoDevicesAvailableToast.INSTANCE);
        }
        return Unit.a;
    }
}
