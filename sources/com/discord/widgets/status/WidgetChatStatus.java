package com.discord.widgets.status;

import a0.a.a.b;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatStatusBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.application.Unread;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.d0._Ranges;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetChatStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChatStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatStatusBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetChatStatus.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean isUnreadEstimate;
        private final long unreadChannelId;
        private final int unreadCount;
        private final long unreadMessageId;
        private final boolean unreadVisible;

        /* JADX INFO: compiled from: WidgetChatStatus.kt */
        public static final class Companion {
            private Companion() {
            }

            private final Model createModel(boolean isUnreadValid, Set<Long> detachedChannels, Unread unread) {
                Unread.Marker marker = unread.getMarker();
                boolean zContains = detachedChannels.contains(Long.valueOf(marker.getChannelId()));
                int count = unread.getCount();
                int i = zContains ? 25 : 50;
                boolean z2 = isUnreadValid && unread.getCount() > 0 && marker.getChannelId() > 0;
                long channelId = marker.getChannelId();
                Long messageId = marker.getMessageId();
                return new Model(z2, messageId != null ? messageId.longValue() : 0L, channelId, _Ranges.coerceIn(count, 0, i), count >= i);
            }

            public final Observable<Model> get() {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableR = companion.getChannelsSelected().observeId().r().Y(new Func1<Long, Observable<? extends Boolean>>() { // from class: com.discord.widgets.status.WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1
                    @Override // j0.k.Func1
                    public final Observable<? extends Boolean> call(Long l) {
                        StoreStream.Companion companion2 = StoreStream.INSTANCE;
                        StoreMessageAck messageAck = companion2.getMessageAck();
                        Intrinsics3.checkNotNullExpressionValue(l, "selectedChannelId");
                        Observable<StoreMessageAck.Ack> observableObserveForChannel = messageAck.observeForChannel(l.longValue());
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        return Observable.m(new ScalarSynchronousObservable(Boolean.FALSE), Observable.j(observableObserveForChannel.p(200L, timeUnit), companion2.getMessagesMostRecent().observeRecentMessageIds(l.longValue()).p(200L, timeUnit).Z(1), new Func2<StoreMessageAck.Ack, Long, Boolean>() { // from class: com.discord.widgets.status.WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$1
                            @Override // rx.functions.Func2
                            public final Boolean call(StoreMessageAck.Ack ack, Long l2) {
                                long messageId = ack != null ? ack.getMessageId() : 0L;
                                Intrinsics3.checkNotNullExpressionValue(l2, "mostRecentIdSnapshot");
                                return Boolean.valueOf(messageId < l2.longValue());
                            }
                        }).b0(new Func1<Boolean, Boolean>() { // from class: com.discord.widgets.status.WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$2
                            @Override // j0.k.Func1
                            public final Boolean call(Boolean bool) {
                                return Boolean.valueOf(Intrinsics3.areEqual(bool, Boolean.FALSE));
                            }
                        }));
                    }
                }).r();
                Observable<Set<Long>> allDetached = companion.getMessages().getAllDetached();
                Observable<Unread> unreadMarkerForSelectedChannel = companion.getReadStates().getUnreadMarkerForSelectedChannel();
                final WidgetChatStatus2 widgetChatStatus2 = new WidgetChatStatus2(this);
                Observable observableCombineLatest = ObservableWithLeadingEdgeThrottle.combineLatest(observableR, allDetached, unreadMarkerForSelectedChannel, new Func3() { // from class: com.discord.widgets.status.WidgetChatStatus$sam$rx_functions_Func3$0
                    @Override // rx.functions.Func3
                    public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3) {
                        return widgetChatStatus2.invoke(obj, obj2, obj3);
                    }
                }, 500L, TimeUnit.MILLISECONDS);
                Intrinsics3.checkNotNullExpressionValue(observableCombineLatest, "ObservableWithLeadingEdg…ILLISECONDS\n            )");
                Observable<Model> observableR2 = ObservableExtensionsKt.computationLatest(observableCombineLatest).r();
                Intrinsics3.checkNotNullExpressionValue(observableR2, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
                return observableR2;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(boolean z2, long j, long j2, int i, boolean z3) {
            this.unreadVisible = z2;
            this.unreadMessageId = j;
            this.unreadChannelId = j2;
            this.unreadCount = i;
            this.isUnreadEstimate = z3;
        }

        public static /* synthetic */ Model copy$default(Model model, boolean z2, long j, long j2, int i, boolean z3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = model.unreadVisible;
            }
            if ((i2 & 2) != 0) {
                j = model.unreadMessageId;
            }
            long j3 = j;
            if ((i2 & 4) != 0) {
                j2 = model.unreadChannelId;
            }
            long j4 = j2;
            if ((i2 & 8) != 0) {
                i = model.unreadCount;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                z3 = model.isUnreadEstimate;
            }
            return model.copy(z2, j3, j4, i3, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getUnreadVisible() {
            return this.unreadVisible;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getUnreadMessageId() {
            return this.unreadMessageId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getUnreadChannelId() {
            return this.unreadChannelId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getUnreadCount() {
            return this.unreadCount;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsUnreadEstimate() {
            return this.isUnreadEstimate;
        }

        public final Model copy(boolean unreadVisible, long unreadMessageId, long unreadChannelId, int unreadCount, boolean isUnreadEstimate) {
            return new Model(unreadVisible, unreadMessageId, unreadChannelId, unreadCount, isUnreadEstimate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.unreadVisible == model.unreadVisible && this.unreadMessageId == model.unreadMessageId && this.unreadChannelId == model.unreadChannelId && this.unreadCount == model.unreadCount && this.isUnreadEstimate == model.isUnreadEstimate;
        }

        public final long getUnreadChannelId() {
            return this.unreadChannelId;
        }

        public final int getUnreadCount() {
            return this.unreadCount;
        }

        public final long getUnreadMessageId() {
            return this.unreadMessageId;
        }

        public final boolean getUnreadVisible() {
            return this.unreadVisible;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public int hashCode() {
            boolean z2 = this.unreadVisible;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int iA = (((b.a(this.unreadChannelId) + ((b.a(this.unreadMessageId) + (r0 * 31)) * 31)) * 31) + this.unreadCount) * 31;
            boolean z3 = this.isUnreadEstimate;
            return iA + (z3 ? 1 : z3);
        }

        public final boolean isUnreadEstimate() {
            return this.isUnreadEstimate;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(unreadVisible=");
            sbU.append(this.unreadVisible);
            sbU.append(", unreadMessageId=");
            sbU.append(this.unreadMessageId);
            sbU.append(", unreadChannelId=");
            sbU.append(this.unreadChannelId);
            sbU.append(", unreadCount=");
            sbU.append(this.unreadCount);
            sbU.append(", isUnreadEstimate=");
            return outline.O(sbU, this.isUnreadEstimate, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetChatStatus$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatStatus.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetChatStatus.this.configureUI(model);
        }
    }

    public WidgetChatStatus() {
        super(R.layout.widget_chat_status);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChatStatus6.INSTANCE, null, 2, null);
    }

    @MainThread
    private final void configureUI(final Model data) {
        LinearLayout linearLayout = getBinding().f2346b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatStatusUnreadMessages");
        linearLayout.setVisibility(data.getUnreadVisible() ? 0 : 8);
        getBinding().f2346b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.status.WidgetChatStatus.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(data.getUnreadChannelId(), data.getUnreadMessageId());
            }
        });
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatStatusUnreadMessagesText");
        textView.setText(getUnreadMessageText(data.isUnreadEstimate(), data.getUnreadCount(), data.getUnreadMessageId()));
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.status.WidgetChatStatus.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getReadStates().markAsRead(Long.valueOf(data.getUnreadChannelId()));
            }
        });
    }

    private final WidgetChatStatusBinding getBinding() {
        return (WidgetChatStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getUnreadMessageText(boolean isEstimate, int count, long messageId) {
        String strRenderUtcDate$default = TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, TimeUtils.parseSnowflake(Long.valueOf(messageId)), requireContext(), 0, 4, null);
        if (isEstimate) {
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            return FormatUtils.c(resources, R.string.new_messages_estimated, new Object[0], new AnonymousClass1(count, strRenderUtcDate$default));
        }
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        CharSequence quantityString = StringResourceUtils.getQuantityString(resources2, requireContext(), R.plurals.new_messages_count, count, Integer.valueOf(count));
        Resources resources3 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
        return FormatUtils.c(resources3, R.string.new_messages, new Object[0], new AnonymousClass2(quantityString, strRenderUtcDate$default));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), (Class<?>) WidgetChatStatus.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetChatStatus$getUnreadMessageText$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatStatus.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ int $count;
        public final /* synthetic */ String $utcDateTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, String str) {
            super(1);
            this.$count = i;
            this.$utcDateTime = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("count", String.valueOf(this.$count));
            renderContext.args.put("timestamp", this.$utcDateTime);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetChatStatus$getUnreadMessageText$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatStatus.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ CharSequence $countPlural;
        public final /* synthetic */ String $utcDateTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(CharSequence charSequence, String str) {
            super(1);
            this.$countPlural = charSequence;
            this.$utcDateTime = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("count", this.$countPlural.toString());
            renderContext.args.put("timestamp", this.$utcDateTime);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }
}
