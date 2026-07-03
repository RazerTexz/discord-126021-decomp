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
import com.discord.C5419R;
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
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.duration.DurationUtilsKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.channels.list.WidgetCollapsedUsersListAdapter;
import com.discord.widgets.channels.list.items.CollapsedUser;
import com.discord.widgets.chat.list.FragmentLifecycleListener;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
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
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

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
            C12238m.checkNotNullParameter(map, "voiceParticipants");
            C12238m.checkNotNullParameter(messageEntry, "messageEntry");
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
            C12238m.checkNotNullParameter(voiceParticipants, "voiceParticipants");
            C12238m.checkNotNullParameter(messageEntry, "messageEntry");
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
            return C12238m.areEqual(this.voiceParticipants, state.voiceParticipants) && C12238m.areEqual(this.messageEntry, state.messageEntry);
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
            StringBuilder sbM833U = C1643a.m833U("State(voiceParticipants=");
            sbM833U.append(this.voiceParticipants);
            sbM833U.append(", messageEntry=");
            sbM833U.append(this.messageEntry);
            sbM833U.append(")");
            return sbM833U.toString();
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

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$configure$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
    public static final class C80391 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C80391() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetChatListAdapterItemCallMessage.this.stateSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$configure$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
    public static final class C80402 extends AbstractC12240o implements Function1<State, Unit> {
        public C80402() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(State state) {
            invoke2(state);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(State state) {
            C12238m.checkNotNullParameter(state, "state");
            WidgetChatListAdapterItemCallMessage.this.handleState(state);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$configureSubtitle$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
    public static final class C80411 extends AbstractC12240o implements Function1<Long, Unit> {
        public final /* synthetic */ long $callJoinedTimestampMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80411(long j) {
            super(1);
            this.$callJoinedTimestampMs = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            String string = TimeUtils.toFriendlyString$default(TimeUtils.INSTANCE, this.$callJoinedTimestampMs, WidgetChatListAdapterItemCallMessage.this.clock.currentTimeMillis(), null, null, 12, null).toString();
            int minWidthPxForTime = WidgetChatListAdapterItemCallMessage.this.getMinWidthPxForTime(string);
            TextView textView = WidgetChatListAdapterItemCallMessage.this.binding.f16176d;
            C12238m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemCallSubtitle");
            textView.setText(string);
            TextView textView2 = WidgetChatListAdapterItemCallMessage.this.binding.f16179g;
            C12238m.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemUnjoinedCallDuration");
            textView2.setText(string);
            TextView textView3 = WidgetChatListAdapterItemCallMessage.this.binding.f16179g;
            C12238m.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemUnjoinedCallDuration");
            TextView textView4 = WidgetChatListAdapterItemCallMessage.this.binding.f16179g;
            C12238m.checkNotNullExpressionValue(textView4, "binding.chatListAdapterItemUnjoinedCallDuration");
            textView3.setMinWidth(textView4.getPaddingStart() + minWidthPxForTime);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$configureSubtitle$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
    public static final class C80422 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C80422() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetChatListAdapterItemCallMessage.this.ongoingCallDurationSubscription = subscription;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemCallMessage(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_call, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_adapter_item_call_icon;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.chat_list_adapter_item_call_icon);
        if (imageView != null) {
            i = C5419R.id.chat_list_adapter_item_call_participants;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.chat_list_adapter_item_call_participants);
            if (recyclerView != null) {
                i = C5419R.id.chat_list_adapter_item_call_subtitle;
                TextView textView = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_call_subtitle);
                if (textView != null) {
                    i = C5419R.id.chat_list_adapter_item_call_title;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_call_title);
                    if (textView2 != null) {
                        i = C5419R.id.chat_list_adapter_item_call_unjoined_ongoing_subtitle;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.chat_list_adapter_item_call_unjoined_ongoing_subtitle);
                        if (linearLayout != null) {
                            i = C5419R.id.chat_list_adapter_item_unjoined_call_duration;
                            TextView textView3 = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_unjoined_call_duration);
                            if (textView3 != null) {
                                WidgetChatListAdapterItemCallBinding widgetChatListAdapterItemCallBinding = new WidgetChatListAdapterItemCallBinding((CardView) view, imageView, recyclerView, textView, textView2, linearLayout, textView3);
                                C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemCallBinding, "WidgetChatListAdapterIte…allBinding.bind(itemView)");
                                this.binding = widgetChatListAdapterItemCallBinding;
                                this.clock = ClockFactory.get();
                                MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
                                C12238m.checkNotNullExpressionValue(recyclerView, "binding.chatListAdapterItemCallParticipants");
                                this.usersAdapter = (WidgetCollapsedUsersListAdapter) companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
                                this.itemView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage.1
                                    @Override // android.view.View.OnAttachStateChangeListener
                                    public void onViewAttachedToWindow(View v) {
                                        C12238m.checkNotNullParameter(v, "v");
                                        WidgetChatListAdapterItemCallMessage.this.resetCurrentChatListEntry();
                                    }

                                    @Override // android.view.View.OnAttachStateChangeListener
                                    public void onViewDetachedFromWindow(View v) {
                                        C12238m.checkNotNullParameter(v, "v");
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.computationLatest(observeState((MessageEntry) data))), (Class<?>) WidgetChatListAdapterItemCallMessage.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C80391()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C80402());
    }

    private final void configureSubtitle(MessageEntry messageEntry, CallStatus callStatus, Context context) {
        Subscription subscription = this.ongoingCallDurationSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Message message = messageEntry.getMessage();
        CharSequence charSequenceHumanizeDuration = DurationUtilsKt.humanizeDuration(context, message.getCallDuration());
        Context contextM885x = C1643a.m885x(this.itemView, "itemView", "itemView.context");
        UtcDateTime timestamp = message.getTimestamp();
        String string = TimeUtils.toReadableTimeString$default(contextM885x, timestamp != null ? timestamp.getDateTimeMillis() : 0L, null, 4, null).toString();
        LinearLayout linearLayout = this.binding.f16178f;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.chatListAdapterI…llUnjoinedOngoingSubtitle");
        linearLayout.setVisibility(callStatus == CallStatus.ACTIVE_UNJOINED ? 0 : 8);
        TextView textView = this.binding.f16176d;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemCallSubtitle");
        LinearLayout linearLayout2 = this.binding.f16178f;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.chatListAdapterI…llUnjoinedOngoingSubtitle");
        textView.setVisibility((linearLayout2.getVisibility() == 0) ^ true ? 0 : 8);
        int iOrdinal = callStatus.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            UtcDateTime timestamp2 = message.getTimestamp();
            long dateTimeMillis = timestamp2 != null ? timestamp2.getDateTimeMillis() : 0L;
            Observable<Long> observableM11061E = Observable.m11061E(0L, 1L, TimeUnit.SECONDS);
            C12238m.checkNotNullExpressionValue(observableM11061E, "Observable\n            .…0L, 1L, TimeUnit.SECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(observableM11061E), (Class<?>) WidgetChatListAdapterItemCallMessage.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C80422()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C80411(dateTimeMillis));
            return;
        }
        if (iOrdinal == 2) {
            TextView textView2 = this.binding.f16176d;
            C12238m.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemCallSubtitle");
            C1107b.m221m(textView2, C5419R.string.call_ended_description, new Object[]{charSequenceHumanizeDuration, string}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            TextView textView3 = this.binding.f16176d;
            C12238m.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemCallSubtitle");
            C1107b.m221m(textView3, C5419R.string.call_ended_description, new Object[]{charSequenceHumanizeDuration, string}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        }
    }

    private final List<CollapsedUser> createCallParticipantUsers(Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, CallStatus callStatus, User messageAuthor) {
        if (callStatus == CallStatus.INACTIVE_JOINED || callStatus == CallStatus.INACTIVE_UNJOINED) {
            return C12145m.listOf(new CollapsedUser(messageAuthor, false, 0L, 6, null));
        }
        List list = C12163u.toList(voiceParticipants.values());
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
        Iterator<Integer> it2 = C11226f.until(0, Math.min(size, 3)).iterator();
        while (it2.hasNext()) {
            arrayList2.add(new CollapsedUser(((StoreVoiceParticipants.VoiceUser) arrayList.get(((AbstractC12126c0) it2).nextInt())).getUser(), false, 0L, 6, null));
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
            drawable = AppCompatResources.getDrawable(context, C5419R.drawable.ic_call_24dp);
            if (drawable == null) {
                return null;
            }
            ColorCompatKt.setTint(drawable, ColorCompat.getColor(context, C5419R.color.status_green_600), false);
        } else if (iOrdinal == 2) {
            drawable = AppCompatResources.getDrawable(context, C5419R.drawable.ic_call_disconnect_24dp);
            if (drawable == null) {
                return null;
            }
            ColorCompatKt.setTint(drawable, ColorCompat.getColor(context, C5419R.color.status_red), false);
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            drawable = AppCompatResources.getDrawable(context, C5419R.drawable.ic_call_24dp);
            if (drawable == null) {
                return null;
            }
            ColorCompatKt.setTint(drawable, ColorCompat.getThemedColor(context, C5419R.attr.colorInteractiveNormal), false);
        }
        return drawable;
    }

    private final CallStatus getCallStatus(Message message, Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants) {
        MessageCall call = message.getCall();
        if (call == null) {
            return CallStatus.INACTIVE_UNJOINED;
        }
        long userId = ((WidgetChatListAdapter) this.adapter).getData().getUserId();
        List list = C12163u.toList(voiceParticipants.entrySet());
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
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Long.valueOf(((Number) ((Map.Entry) it2.next()).getKey()).longValue()));
        }
        boolean zContains = call.m8075b().contains(Long.valueOf(userId));
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
            return C1107b.m211c(resources, C5419R.string.ongoing_call, new Object[0], (4 & 4) != 0 ? C1107b.d.f1493j : null);
        }
        if (iOrdinal == 2) {
            return C1107b.m211c(resources, C5419R.string.missed_call, new Object[0], (4 & 4) != 0 ? C1107b.d.f1493j : null);
        }
        if (iOrdinal == 3) {
            return C1107b.m211c(resources, C5419R.string.call_ended, new Object[0], (4 & 4) != 0 ? C1107b.d.f1493j : null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void handleState(State state) {
        MessageEntry messageEntry = state.getMessageEntry();
        final Message message = messageEntry.getMessage();
        Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants = state.getVoiceParticipants();
        final CallStatus callStatus = getCallStatus(message, voiceParticipants);
        com.discord.api.user.User author = message.getAuthor();
        C12238m.checkNotNull(author);
        List<CollapsedUser> listCreateCallParticipantUsers = createCallParticipantUsers(voiceParticipants, callStatus, new CoreUser(author));
        configureSubtitle(messageEntry, callStatus, C1643a.m821I(this.binding.f16176d, "binding.chatListAdapterItemCallSubtitle", "binding.chatListAdapterItemCallSubtitle.context"));
        this.binding.f16174b.setImageDrawable(getCallDrawable(callStatus, C1643a.m885x(this.itemView, "itemView", "itemView.context")));
        TextView textView = this.binding.f16177e;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemCallTitle");
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        C12238m.checkNotNullExpressionValue(resources, "itemView.resources");
        textView.setText(getTitleString(callStatus, resources));
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage.handleState.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChatListAdapterItemCallMessage.this.onItemClick(callStatus, message.getChannelId());
            }
        });
        this.usersAdapter.setData(C12163u.toList(listCreateCallParticipantUsers));
    }

    private final Observable<State> observeState(final MessageEntry messageEntry) {
        Observable observableM11083G = StoreStream.INSTANCE.getVoiceParticipants().get(messageEntry.getMessage().getChannelId()).m11083G(new InterfaceC12589b<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, State>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage.observeState.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ State call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map) {
                return call2((Map<Long, StoreVoiceParticipants.VoiceUser>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final State call2(Map<Long, StoreVoiceParticipants.VoiceUser> map) {
                C12238m.checkNotNullExpressionValue(map, "voiceParticipants");
                return new State(map, messageEntry);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "StoreStream.getVoicePart…, messageEntry)\n        }");
        return observableM11083G;
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
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        configure(data);
    }
}
