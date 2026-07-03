package com.discord.widgets.guild_automod;

import com.discord.api.message.embed.MessageEmbed;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildautomod.AutoModUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.guild_automod.ReportIssueWithAutoModViewModel;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: ReportIssueWithAutoModViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReportIssueWithAutoModViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final long messageId;

    /* JADX INFO: renamed from: com.discord.widgets.guild_automod.ReportIssueWithAutoModViewModel$1 */
    /* JADX INFO: compiled from: ReportIssueWithAutoModViewModel.kt */
    public static final /* synthetic */ class C84141 extends C12236k implements Function1<StoreState, Unit> {
        public C84141(ReportIssueWithAutoModViewModel reportIssueWithAutoModViewModel) {
            super(1, reportIssueWithAutoModViewModel, ReportIssueWithAutoModViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "p1");
            ((ReportIssueWithAutoModViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: ReportIssueWithAutoModViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(long channelId, long messageId, StoreMessages messageStore) {
            Observable observableM11083G = messageStore.observeMessagesForChannel(channelId, messageId).m11083G(new InterfaceC12589b<Message, StoreState>() { // from class: com.discord.widgets.guild_automod.ReportIssueWithAutoModViewModel$Companion$observeStores$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final ReportIssueWithAutoModViewModel.StoreState call(Message message) {
                    return new ReportIssueWithAutoModViewModel.StoreState(message);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11083G, "messageStore.observeMess…te(clientMessage)\n      }");
            return observableM11083G;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ReportIssueWithAutoModViewModel.kt */
    public static final /* data */ class StoreState {
        private final Message message;

        public StoreState(Message message) {
            this.message = message;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Message message, int i, Object obj) {
            if ((i & 1) != 0) {
                message = storeState.message;
            }
            return storeState.copy(message);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        public final StoreState copy(Message message) {
            return new StoreState(message);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && C12238m.areEqual(this.message, ((StoreState) other).message);
            }
            return true;
        }

        public final Message getMessage() {
            return this.message;
        }

        public int hashCode() {
            Message message = this.message;
            if (message != null) {
                return message.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(message=");
            sbM833U.append(this.message);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: ReportIssueWithAutoModViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: ReportIssueWithAutoModViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ReportIssueWithAutoModViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final Message message;
            private final String selectedOption;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Message message, String str) {
                super(null);
                C12238m.checkNotNullParameter(message, "message");
                C12238m.checkNotNullParameter(str, "selectedOption");
                this.message = message;
                this.selectedOption = str;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Message message, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    message = valid.message;
                }
                if ((i & 2) != 0) {
                    str = valid.selectedOption;
                }
                return valid.copy(message, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Message getMessage() {
                return this.message;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getSelectedOption() {
                return this.selectedOption;
            }

            public final Valid copy(Message message, String selectedOption) {
                C12238m.checkNotNullParameter(message, "message");
                C12238m.checkNotNullParameter(selectedOption, "selectedOption");
                return new Valid(message, selectedOption);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return C12238m.areEqual(this.message, valid.message) && C12238m.areEqual(this.selectedOption, valid.selectedOption);
            }

            public final Message getMessage() {
                return this.message;
            }

            public final String getSelectedOption() {
                return this.selectedOption;
            }

            public int hashCode() {
                Message message = this.message;
                int iHashCode = (message != null ? message.hashCode() : 0) * 31;
                String str = this.selectedOption;
                return iHashCode + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Valid(message=");
                sbM833U.append(this.message);
                sbM833U.append(", selectedOption=");
                return C1643a.m822J(sbM833U, this.selectedOption, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ReportIssueWithAutoModViewModel(long j, long j2, StoreMessages storeMessages, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeMessages = (i & 4) != 0 ? StoreStream.INSTANCE.getMessages() : storeMessages;
        this(j, j2, storeMessages, (i & 8) != 0 ? INSTANCE.observeStores(j, j2, storeMessages) : observable);
    }

    private final void handleStoreState(StoreState storeState) {
        String value;
        ViewState valid;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid2 = (ViewState.Valid) viewState;
        if (storeState.getMessage() == null) {
            valid = ViewState.Invalid.INSTANCE;
        } else {
            Message message = storeState.getMessage();
            if (valid2 == null || (value = valid2.getSelectedOption()) == null) {
                value = FeedbackType.ALLOWED.getValue();
            }
            valid = new ViewState.Valid(message, value);
        }
        updateViewState(valid);
    }

    public final void onFeedbackTypeSelected(FeedbackType feedbackType) {
        C12238m.checkNotNullParameter(feedbackType, "feedbackType");
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Valid) {
            updateViewState(ViewState.Valid.copy$default((ViewState.Valid) viewState, null, feedbackType.getValue(), 1, null));
        }
    }

    public final void onSubmit(Function0<Unit> onCompleted) {
        String embedFieldValue;
        C12238m.checkNotNullParameter(onCompleted, "onCompleted");
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Valid) {
            ViewState.Valid valid = (ViewState.Valid) viewState;
            List<MessageEmbed> embeds = valid.getMessage().getEmbeds();
            MessageEmbed messageEmbed = embeds != null ? (MessageEmbed) C12163u.first((List) embeds) : null;
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            if (messageEmbed == null || (embedFieldValue = AutoModUtils.INSTANCE.getEmbedFieldValue(messageEmbed, "decision_id")) == null) {
                embedFieldValue = "";
            }
            long id2 = valid.getMessage().getId();
            String content = valid.getMessage().getContent();
            analyticsTracker.trackReportIssueWithAutoMod(embedFieldValue, id2, valid.getSelectedOption(), content != null ? content : "");
            onCompleted.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportIssueWithAutoModViewModel(long j, long j2, StoreMessages storeMessages, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(storeMessages, "messageStore");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.messageId = j2;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) ReportIssueWithAutoModViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84141(this));
    }
}
