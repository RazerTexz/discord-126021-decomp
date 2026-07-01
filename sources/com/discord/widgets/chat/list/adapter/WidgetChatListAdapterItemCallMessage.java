package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.message.call.MessageCall;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.WidgetChatListAdapterItemCallBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.duration.DurationUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.channels.list.WidgetCollapsedUsersListAdapter;
import com.discord.widgets.channels.list.items.CollapsedUser;
import com.discord.widgets.chat.list.FragmentLifecycleListener;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import d0.d0._Ranges;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemCallMessage extends WidgetChatListItem implements FragmentLifecycleListener {
    private final WidgetChatListAdapterItemCallBinding binding;
    private ChatListEntry chatListEntry;
    private final Clock clock;
    private Subscription ongoingCallDurationSubscription;
    private Subscription stateSubscription;
    private final WidgetCollapsedUsersListAdapter usersAdapter;

    /* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
    public enum CallStatus {
        ACTIVE_UNJOINED,
        ACTIVE_JOINED,
        INACTIVE_UNJOINED,
        INACTIVE_JOINED
    }

    /* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
    public static final /* data */ class State {
        private final MessageEntry messageEntry;
        private final Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants;

        public State(Map<Long, StoreVoiceParticipants.VoiceUser> map, MessageEntry messageEntry) {
            Intrinsics3.checkNotNullParameter(map, "voiceParticipants");
            Intrinsics3.checkNotNullParameter(messageEntry, "messageEntry");
            this.voiceParticipants = map;
            this.messageEntry = messageEntry;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Map map, MessageEntry messageEntry, int i, Object obj) {
            if ((i & 1) != 0) {
                map = state.voiceParticipants;
            }
            if ((i & 2) != 0) {
                messageEntry = state.messageEntry;
            }
            return state.copy(map, messageEntry);
        }

        public final Map<Long, StoreVoiceParticipants.VoiceUser> component1() {
            return this.voiceParticipants;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MessageEntry getMessageEntry() {
            return this.messageEntry;
        }

        public final State copy(Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, MessageEntry messageEntry) {
            Intrinsics3.checkNotNullParameter(voiceParticipants, "voiceParticipants");
            Intrinsics3.checkNotNullParameter(messageEntry, "messageEntry");
            return new State(voiceParticipants, messageEntry);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics3.areEqual(this.voiceParticipants, state.voiceParticipants) && Intrinsics3.areEqual(this.messageEntry, state.messageEntry);
        }

        public final MessageEntry getMessageEntry() {
            return this.messageEntry;
        }

        public final Map<Long, StoreVoiceParticipants.VoiceUser> getVoiceParticipants() {
            return this.voiceParticipants;
        }

        public int hashCode() {
            Map<Long, StoreVoiceParticipants.VoiceUser> map = this.voiceParticipants;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            MessageEntry messageEntry = this.messageEntry;
            return iHashCode + (messageEntry != null ? messageEntry.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("State(voiceParticipants=");
            sbU.append(this.voiceParticipants);
            sbU.append(", messageEntry=");
            sbU.append(this.messageEntry);
            sbU.append(")");
            return sbU.toString();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            CallStatus.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            CallStatus callStatus = CallStatus.INACTIVE_UNJOINED;
            iArr[callStatus.ordinal()] = 1;
            CallStatus callStatus2 = CallStatus.INACTIVE_JOINED;
            iArr[callStatus2.ordinal()] = 2;
            CallStatus callStatus3 = CallStatus.ACTIVE_JOINED;
            iArr[callStatus3.ordinal()] = 3;
            CallStatus callStatus4 = CallStatus.ACTIVE_UNJOINED;
            iArr[callStatus4.ordinal()] = 4;
            CallStatus.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[callStatus.ordinal()] = 1;
            iArr2[callStatus2.ordinal()] = 2;
            iArr2[callStatus3.ordinal()] = 3;
            iArr2[callStatus4.ordinal()] = 4;
            CallStatus.values();
            int[] iArr3 = new int[4];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[callStatus.ordinal()] = 1;
            iArr3[callStatus2.ordinal()] = 2;
            iArr3[callStatus3.ordinal()] = 3;
            iArr3[callStatus4.ordinal()] = 4;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$configure$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetChatListAdapterItemCallMessage.this.stateSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$configure$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<State, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(State state) {
            invoke2(state);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(State state) {
            Intrinsics3.checkNotNullParameter(state, "state");
            WidgetChatListAdapterItemCallMessage.this.handleState(state);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$configureSubtitle$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ long $callJoinedTimestampMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$callJoinedTimestampMs = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            String string = TimeUtils.toFriendlyString$default(TimeUtils.INSTANCE, this.$callJoinedTimestampMs, WidgetChatListAdapterItemCallMessage.this.clock.currentTimeMillis(), null, null, 12, null).toString();
            int minWidthPxForTime = WidgetChatListAdapterItemCallMessage.this.getMinWidthPxForTime(string);
            TextView textView = WidgetChatListAdapterItemCallMessage.this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemCallSubtitle");
            textView.setText(string);
            TextView textView2 = WidgetChatListAdapterItemCallMessage.this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemUnjoinedCallDuration");
            textView2.setText(string);
            TextView textView3 = WidgetChatListAdapterItemCallMessage.this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemUnjoinedCallDuration");
            TextView textView4 = WidgetChatListAdapterItemCallMessage.this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.chatListAdapterItemUnjoinedCallDuration");
            textView3.setMinWidth(textView4.getPaddingStart() + minWidthPxForTime);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$configureSubtitle$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
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
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetChatListAdapterItemCallMessage.this.ongoingCallDurationSubscription = subscription;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemCallMessage(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_call, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_call_icon;
        ImageView imageView = (ImageView) view.findViewById(R.id.chat_list_adapter_item_call_icon);
        if (imageView != null) {
            i = R.id.chat_list_adapter_item_call_participants;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.chat_list_adapter_item_call_participants);
            if (recyclerView != null) {
                i = R.id.chat_list_adapter_item_call_subtitle;
                TextView textView = (TextView) view.findViewById(R.id.chat_list_adapter_item_call_subtitle);
                if (textView != null) {
                    i = R.id.chat_list_adapter_item_call_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.chat_list_adapter_item_call_title);
                    if (textView2 != null) {
                        i = R.id.chat_list_adapter_item_call_unjoined_ongoing_subtitle;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.chat_list_adapter_item_call_unjoined_ongoing_subtitle);
                        if (linearLayout != null) {
                            i = R.id.chat_list_adapter_item_unjoined_call_duration;
                            TextView textView3 = (TextView) view.findViewById(R.id.chat_list_adapter_item_unjoined_call_duration);
                            if (textView3 != null) {
                                WidgetChatListAdapterItemCallBinding widgetChatListAdapterItemCallBinding = new WidgetChatListAdapterItemCallBinding((CardView) view, imageView, recyclerView, textView, textView2, linearLayout, textView3);
                                Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemCallBinding, "WidgetChatListAdapterIte…allBinding.bind(itemView)");
                                this.binding = widgetChatListAdapterItemCallBinding;
                                this.clock = ClockFactory.get();
                                MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
                                Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatListAdapterItemCallParticipants");
                                this.usersAdapter = (WidgetCollapsedUsersListAdapter) companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
                                this.itemView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage.1
                                    @Override // android.view.View.OnAttachStateChangeListener
                                    public void onViewAttachedToWindow(View v) {
                                        Intrinsics3.checkNotNullParameter(v, "v");
                                        WidgetChatListAdapterItemCallMessage.this.resetCurrentChatListEntry();
                                    }

                                    @Override // android.view.View.OnAttachStateChangeListener
                                    public void onViewDetachedFromWindow(View v) {
                                        Intrinsics3.checkNotNullParameter(v, "v");
                                        WidgetChatListAdapterItemCallMessage.this.clearSubscriptions();
                                    }
                                });
                                recyclerView.setHasFixedSize(false);
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    private final void clearSubscriptions() {
        Subscription subscription = this.ongoingCallDurationSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.stateSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
    }

    private final void configure(ChatListEntry data) {
        this.chatListEntry = data;
        Objects.requireNonNull(data, "null cannot be cast to non-null type com.discord.widgets.chat.list.entries.MessageEntry");
        clearSubscriptions();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationLatest(observeState((MessageEntry) data))), (Class<?>) WidgetChatListAdapterItemCallMessage.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass1()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    private final void configureSubtitle(MessageEntry messageEntry, CallStatus callStatus, Context context) {
        Subscription subscription = this.ongoingCallDurationSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Message message = messageEntry.getMessage();
        CharSequence charSequenceHumanizeDuration = DurationUtils.humanizeDuration(context, message.getCallDuration());
        Context contextX = outline.x(this.itemView, "itemView", "itemView.context");
        UtcDateTime timestamp = message.getTimestamp();
        String string = TimeUtils.toReadableTimeString$default(contextX, timestamp != null ? timestamp.getDateTimeMillis() : 0L, null, 4, null).toString();
        LinearLayout linearLayout = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatListAdapterI…llUnjoinedOngoingSubtitle");
        linearLayout.setVisibility(callStatus == CallStatus.ACTIVE_UNJOINED ? 0 : 8);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemCallSubtitle");
        LinearLayout linearLayout2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.chatListAdapterI…llUnjoinedOngoingSubtitle");
        textView.setVisibility((linearLayout2.getVisibility() == 0) ^ true ? 0 : 8);
        int iOrdinal = callStatus.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            UtcDateTime timestamp2 = message.getTimestamp();
            long dateTimeMillis = timestamp2 != null ? timestamp2.getDateTimeMillis() : 0L;
            Observable<Long> observableE = Observable.E(0L, 1L, TimeUnit.SECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableE, "Observable\n            .…0L, 1L, TimeUnit.SECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(observableE), (Class<?>) WidgetChatListAdapterItemCallMessage.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass2()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(dateTimeMillis));
            return;
        }
        if (iOrdinal == 2) {
            TextView textView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemCallSubtitle");
            FormatUtils.m(textView2, R.string.call_ended_description, new Object[]{charSequenceHumanizeDuration, string}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            TextView textView3 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemCallSubtitle");
            FormatUtils.m(textView3, R.string.call_ended_description, new Object[]{charSequenceHumanizeDuration, string}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        }
    }

    private final List<CollapsedUser> createCallParticipantUsers(Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, CallStatus callStatus, User messageAuthor) {
        if (callStatus == CallStatus.INACTIVE_JOINED || callStatus == CallStatus.INACTIVE_UNJOINED) {
            return CollectionsJVM.listOf(new CollapsedUser(messageAuthor, false, 0L, 6, null));
        }
        List list = _Collections.toList(voiceParticipants.values());
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((StoreVoiceParticipants.VoiceUser) next).getVoiceState() != null) {
                arrayList.add(next);
            }
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        int i = size - 3;
        Iterator<Integer> it2 = _Ranges.until(0, Math.min(size, 3)).iterator();
        while (it2.hasNext()) {
            arrayList2.add(new CollapsedUser(((StoreVoiceParticipants.VoiceUser) arrayList.get(((Iterators4) it2).nextInt())).getUser(), false, 0L, 6, null));
        }
        if (i > 0) {
            arrayList2.add(CollapsedUser.INSTANCE.createEmptyUser(i));
        }
        return arrayList2;
    }

    private final Drawable getCallDrawable(CallStatus callStatus, Context context) {
        Drawable drawable;
        int iOrdinal = callStatus.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            drawable = AppCompatResources.getDrawable(context, R.drawable.ic_call_24dp);
            if (drawable == null) {
                return null;
            }
            ColorCompat2.setTint(drawable, ColorCompat.getColor(context, R.color.status_green_600), false);
        } else if (iOrdinal == 2) {
            drawable = AppCompatResources.getDrawable(context, R.drawable.ic_call_disconnect_24dp);
            if (drawable == null) {
                return null;
            }
            ColorCompat2.setTint(drawable, ColorCompat.getColor(context, R.color.status_red), false);
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            drawable = AppCompatResources.getDrawable(context, R.drawable.ic_call_24dp);
            if (drawable == null) {
                return null;
            }
            ColorCompat2.setTint(drawable, ColorCompat.getThemedColor(context, R.attr.colorInteractiveNormal), false);
        }
        return drawable;
    }

    private final CallStatus getCallStatus(Message message, Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants) {
        MessageCall call = message.getCall();
        if (call == null) {
            return CallStatus.INACTIVE_UNJOINED;
        }
        long userId = ((WidgetChatListAdapter) this.adapter).getData().getUserId();
        List list = _Collections.toList(voiceParticipants.entrySet());
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((StoreVoiceParticipants.VoiceUser) ((Map.Entry) next).getValue()).getVoiceState() != null) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Long.valueOf(((Number) ((Map.Entry) it2.next()).getKey()).longValue()));
        }
        boolean zContains = call.b().contains(Long.valueOf(userId));
        boolean zContains2 = arrayList2.contains(Long.valueOf(userId));
        boolean z2 = call.getEndedTimestamp() == null;
        if (z2 && zContains2) {
            return CallStatus.ACTIVE_JOINED;
        }
        if (z2) {
            return CallStatus.ACTIVE_UNJOINED;
        }
        return zContains ? CallStatus.INACTIVE_JOINED : CallStatus.INACTIVE_UNJOINED;
    }

    private final int getMinWidthPxForTime(String time) {
        int i = 0;
        for (int i2 = 0; i2 < time.length(); i2++) {
            if (time.charAt(i2) == ':') {
                i++;
            }
        }
        return (i * DimenUtils.dpToPixels(3.047619f)) + ((time.length() - i) * DimenUtils.dpToPixels(7.6190476f));
    }

    private final CharSequence getTitleString(CallStatus callStatus, Resources resources) {
        int iOrdinal = callStatus.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return FormatUtils.c(resources, R.string.ongoing_call, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null);
        }
        if (iOrdinal == 2) {
            return FormatUtils.c(resources, R.string.missed_call, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null);
        }
        if (iOrdinal == 3) {
            return FormatUtils.c(resources, R.string.call_ended, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void handleState(State state) {
        MessageEntry messageEntry = state.getMessageEntry();
        final Message message = messageEntry.getMessage();
        Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants = state.getVoiceParticipants();
        final CallStatus callStatus = getCallStatus(message, voiceParticipants);
        com.discord.api.user.User author = message.getAuthor();
        Intrinsics3.checkNotNull(author);
        List<CollapsedUser> listCreateCallParticipantUsers = createCallParticipantUsers(voiceParticipants, callStatus, new CoreUser(author));
        configureSubtitle(messageEntry, callStatus, outline.I(this.binding.d, "binding.chatListAdapterItemCallSubtitle", "binding.chatListAdapterItemCallSubtitle.context"));
        this.binding.f2314b.setImageDrawable(getCallDrawable(callStatus, outline.x(this.itemView, "itemView", "itemView.context")));
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemCallTitle");
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "itemView.resources");
        textView.setText(getTitleString(callStatus, resources));
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage.handleState.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChatListAdapterItemCallMessage.this.onItemClick(callStatus, message.getChannelId());
            }
        });
        this.usersAdapter.setData(_Collections.toList(listCreateCallParticipantUsers));
    }

    private final Observable<State> observeState(final MessageEntry messageEntry) {
        Observable observableG = StoreStream.INSTANCE.getVoiceParticipants().get(messageEntry.getMessage().getChannelId()).G(new Func1<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, State>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage.observeState.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ State call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map) {
                return call2((Map<Long, StoreVoiceParticipants.VoiceUser>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final State call2(Map<Long, StoreVoiceParticipants.VoiceUser> map) {
                Intrinsics3.checkNotNullExpressionValue(map, "voiceParticipants");
                return new State(map, messageEntry);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream.getVoicePart…, messageEntry)\n        }");
        return observableG;
    }

    private final void onItemClick(CallStatus callStatus, long channelId) {
        ((WidgetChatListAdapter) this.adapter).getEventHandler().onCallMessageClicked(channelId, callStatus);
    }

    private final void resetCurrentChatListEntry() {
        ChatListEntry chatListEntry = this.chatListEntry;
        if (chatListEntry != null) {
            configure(chatListEntry);
        }
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onPause() {
        clearSubscriptions();
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onResume() {
        resetCurrentChatListEntry();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        configure(data);
    }
}
