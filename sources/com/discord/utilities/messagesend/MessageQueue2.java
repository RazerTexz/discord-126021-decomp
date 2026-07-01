package com.discord.utilities.messagesend;

import com.discord.utilities.error.Error;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1, reason: use source file name */
/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue2 extends Lambda implements Function1<MessageQueue4, Unit> {
    public final /* synthetic */ MessageQueue3 $request;
    public final /* synthetic */ MessageQueue this$0;

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            MessageQueue2.this.this$0.executorService.submit(new Runnable() { // from class: com.discord.utilities.messagesend.MessageQueue.processNextRequest.listener.1.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    MessageQueue2.this.this$0.queue.addFirst(MessageQueue2.this.$request);
                    MessageQueue2.this.this$0.retrySubscription = null;
                    MessageQueue2.this.this$0.onDrainingCompleted();
                    MessageQueue2.this.this$0.processNextRequest();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            MessageQueue2.this.this$0.retrySubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class AnonymousClass3 implements Runnable {

        /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: MessageQueue.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MessageQueue2.this.this$0.executorService.submit(new Runnable() { // from class: com.discord.utilities.messagesend.MessageQueue.processNextRequest.listener.1.3.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MessageQueue2.this.this$0.processNextRequest();
                    }
                });
            }
        }

        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageQueue2.this.this$0.onDrainingCompleted();
            MessageQueue2.this.this$0.queue.addFirst(MessageQueue2.this.$request);
            MessageQueue2.this.this$0.networkBackoff.fail(new AnonymousClass1());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageQueue2(MessageQueue messageQueue, MessageQueue3 messageQueue3) {
        super(1);
        this.this$0 = messageQueue;
        this.$request = messageQueue3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4) {
        invoke2(messageQueue4);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final MessageQueue4 messageQueue4) {
        Intrinsics3.checkNotNullParameter(messageQueue4, "result");
        if (messageQueue4 instanceof MessageQueue4.RateLimited) {
            Observable<Long> observableD0 = Observable.d0(((MessageQueue4.RateLimited) messageQueue4).getRetryAfterMs(), TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n             …s, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(observableD0, (Class<?>) this.this$0.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass2()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
            return;
        }
        if (messageQueue4 instanceof MessageQueue4.NetworkFailure) {
            this.this$0.executorService.submit(new AnonymousClass3());
        } else {
            this.this$0.executorService.submit(new Runnable() { // from class: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1.4
                @Override // java.lang.Runnable
                public final void run() {
                    MessageQueue2.this.this$0.onDrainingCompleted();
                    MessageQueue2.this.$request.getOnCompleted().invoke(messageQueue4, Boolean.valueOf(MessageQueue2.this.this$0.queue.isEmpty()));
                    MessageQueue2.this.this$0.networkBackoff.succeed();
                    MessageQueue2.this.this$0.processNextRequest();
                }
            });
        }
    }
}
