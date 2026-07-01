package com.discord.widgets.chat.list.actions;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.models.message.Message;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.PublishActionDialog;
import com.discord.widgets.notice.WidgetNoticeDialog;
import d0.Tuples;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: MessageActionDialogs.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageActionDialogs {
    public static final MessageActionDialogs INSTANCE = new MessageActionDialogs();

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.MessageActionDialogs$showDeleteMessageConfirmation$1, reason: invalid class name */
    /* JADX INFO: compiled from: MessageActionDialogs.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Message $message;
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Message message, Function0 function0) {
            super(1);
            this.$message = message;
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            StoreStream.INSTANCE.getMessages().deleteMessage(this.$message);
            this.$onSuccess.invoke();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.MessageActionDialogs$showPinMessageConfirmation$1, reason: invalid class name */
    /* JADX INFO: compiled from: MessageActionDialogs.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ boolean $isPinned;
        public final /* synthetic */ Message $message;
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.MessageActionDialogs$showPinMessageConfirmation$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: MessageActionDialogs.kt */
        public static final class C02611 extends Lambda implements Function1<Void, Unit> {
            public C02611() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r5) {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                AppToast.g(anonymousClass1.$context, anonymousClass1.$isPinned ? R.string.message_unpinned : R.string.message_pinned, 0, null, 12);
                AnonymousClass1.this.$onSuccess.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Message message, boolean z2, AppComponent appComponent, Context context, Function0 function0) {
            super(1);
            this.$message = message;
            this.$isPinned = z2;
            this.$appComponent = appComponent;
            this.$context = context;
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            long channelId = this.$message.getChannelId();
            long id2 = this.$message.getId();
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.$isPinned ? RestAPI.INSTANCE.getApi().deleteChannelPin(channelId, id2) : RestAPI.INSTANCE.getApi().addChannelPin(channelId, id2), false, 1, null), this.$appComponent, null, 2, null), (Class<?>) MessageActionDialogs.INSTANCE.getClass(), (58 & 2) != 0 ? null : view.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C02611());
        }
    }

    private MessageActionDialogs() {
    }

    public final void showDeleteMessageConfirmation(FragmentManager fragmentManager, Context context, Message message, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = context.getString(R.string.delete_message);
        String string2 = context.getString(R.string.delete_message_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.string.delete_message_body)");
        WidgetNoticeDialog.Companion.show$default(companion, fragmentManager, string, string2, context.getString(R.string.delete), context.getString(R.string.cancel), MapsJVM.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass1(message, onSuccess))), null, null, null, Integer.valueOf(R.attr.notice_theme_positive_red), null, null, 0, null, 15808, null);
    }

    public final void showPinMessageConfirmation(FragmentManager fragmentManager, Context context, Message message, AppComponent appComponent, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        boolean zAreEqual = Intrinsics3.areEqual(message.getPinned(), Boolean.TRUE);
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = context.getString(zAreEqual ? R.string.unpin_message_title : R.string.pin_message_title);
        String string2 = context.getString(zAreEqual ? R.string.unpin_message_body : R.string.pin_message_body_mobile);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(\n     …age_body_mobile\n        )");
        WidgetNoticeDialog.Companion.show$default(companion, fragmentManager, string, string2, context.getString(zAreEqual ? R.string.unpin : R.string.pin), context.getString(R.string.cancel), MapsJVM.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass1(message, zAreEqual, appComponent, context, onSuccess))), null, null, null, null, null, null, 0, null, 16320, null);
    }

    public final void showPublishMessageConfirmation(FragmentManager fragmentManager, Message message, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        PublishActionDialog.INSTANCE.show(fragmentManager, message.getId(), message.getChannelId(), onSuccess, (16 & 16) != 0 ? null : null);
    }
}
