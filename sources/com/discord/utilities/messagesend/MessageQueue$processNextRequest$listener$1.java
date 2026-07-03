package com.discord.utilities.messagesend;

import com.discord.utilities.error.Error;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$processNextRequest$listener$1 extends AbstractC12240o implements Function1<MessageResult, Unit> {
    public final /* synthetic */ MessageRequest $request;
    public final /* synthetic */ MessageQueue this$0;

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$1 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class C68111 extends AbstractC12240o implements Function1<Long, Unit> {
        public C68111() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            MessageQueue$processNextRequest$listener$1.this.this$0.executorService.submit(new Runnable() { // from class: com.discord.utilities.messagesend.MessageQueue.processNextRequest.listener.1.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    MessageQueue$processNextRequest$listener$1.this.this$0.queue.addFirst(MessageQueue$processNextRequest$listener$1.this.$request);
                    MessageQueue$processNextRequest$listener$1.this.this$0.retrySubscription = null;
                    MessageQueue$processNextRequest$listener$1.this.this$0.onDrainingCompleted();
                    MessageQueue$processNextRequest$listener$1.this.this$0.processNextRequest();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$2 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class C68122 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C68122() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            MessageQueue$processNextRequest$listener$1.this.this$0.retrySubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$3 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class RunnableC68133 implements Runnable {

        /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: MessageQueue.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MessageQueue$processNextRequest$listener$1.this.this$0.executorService.submit(new Runnable() { // from class: com.discord.utilities.messagesend.MessageQueue.processNextRequest.listener.1.3.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MessageQueue$processNextRequest$listener$1.this.this$0.processNextRequest();
                    }
                });
            }
        }

        public RunnableC68133() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageQueue$processNextRequest$listener$1.this.this$0.onDrainingCompleted();
            MessageQueue$processNextRequest$listener$1.this.this$0.queue.addFirst(MessageQueue$processNextRequest$listener$1.this.$request);
            MessageQueue$processNextRequest$listener$1.this.this$0.networkBackoff.fail(new AnonymousClass1());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageQueue$processNextRequest$listener$1(MessageQueue messageQueue, MessageRequest messageRequest) {
        super(1);
        this.this$0 = messageQueue;
        this.$request = messageRequest;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult) {
        invoke2(messageResult);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final MessageResult messageResult) {
        C12238m.checkNotNullParameter(messageResult, "result");
        if (messageResult instanceof MessageResult.RateLimited) {
            Observable<Long> observableM11068d0 = Observable.m11068d0(((MessageResult.RateLimited) messageResult).getRetryAfterMs(), TimeUnit.MILLISECONDS);
            C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable\n             …s, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(observableM11068d0, (Class<?>) this.this$0.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C68122()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C68111());
            return;
        }
        if (messageResult instanceof MessageResult.NetworkFailure) {
            this.this$0.executorService.submit(new RunnableC68133());
        } else {
            this.this$0.executorService.submit(new Runnable() { // from class: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1.4
                @Override // java.lang.Runnable
                public final void run() {
                    MessageQueue$processNextRequest$listener$1.this.this$0.onDrainingCompleted();
                    MessageQueue$processNextRequest$listener$1.this.$request.getOnCompleted().invoke(messageResult, Boolean.valueOf(MessageQueue$processNextRequest$listener$1.this.this$0.queue.isEmpty()));
                    MessageQueue$processNextRequest$listener$1.this.this$0.networkBackoff.succeed();
                    MessageQueue$processNextRequest$listener$1.this.this$0.processNextRequest();
                }
            });
        }
    }
}
