package com.discord.widgets.stage;

import android.graphics.Bitmap;
import com.discord.utilities.images.MGImagesBitmap;
import com.discord.utilities.p501rx.RxCoroutineUtilsKt;
import com.discord.widgets.stage.StageChannelNotifications;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12620f1;
import p637j0.p642l.p643a.C12666r;
import p658rx.Observable;

/* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelNotifications$onInvitedToSpeak$1$invokeSuspend$$inlined$let$lambda$1 */
/* JADX INFO: compiled from: StageChannelNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
@InterfaceC12188e(m10084c = "com.discord.widgets.stage.StageChannelNotifications$onInvitedToSpeak$1$bitmap$1$1", m10085f = "StageChannelNotifications.kt", m10086l = {51}, m10087m = "invokeSuspend")
public final class C10014xb1a69f5f extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    public final /* synthetic */ String $iconUrl$inlined;
    public int label;
    public final /* synthetic */ StageChannelNotifications.C100131 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10014xb1a69f5f(Continuation continuation, StageChannelNotifications.C100131 c100131, String str) {
        super(2, continuation);
        this.this$0 = c100131;
        this.$iconUrl$inlined = str;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C12238m.checkNotNullParameter(continuation, "completion");
        return new C10014xb1a69f5f(continuation, this.this$0, this.$iconUrl$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((C10014xb1a69f5f) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            C12113l.throwOnFailure(obj);
            Observable<Bitmap> bitmap = MGImagesBitmap.INSTANCE.getBitmap(this.$iconUrl$inlined, true);
            Observable observableM11074h0 = Observable.m11074h0(new C12666r(bitmap.f27640j, new C12620f1(new InterfaceC12589b<Throwable, Observable<? extends Bitmap>>() { // from class: com.discord.widgets.stage.StageChannelNotifications$onInvitedToSpeak$1$bitmap$1$1$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends Bitmap> call(Throwable th) {
                    return null;
                }
            })));
            C12238m.checkNotNullExpressionValue(observableM11074h0, "MGImagesBitmap.getBitmap…nErrorResumeNext { null }");
            this.label = 1;
            obj = RxCoroutineUtilsKt.awaitSingle(observableM11074h0, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
        }
        return obj;
    }
}
