package com.discord.widgets.chat.managereactions;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetManageReactionsBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12242q;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetManageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetManageReactions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetManageReactions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetManageReactionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_EMOJI_KEY = "com.discord.intent.extra.EXTRA_EMOJI_KEY";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ManageReactionsEmojisAdapter emojisAdapter;
    private ManageReactionsModelProvider modelProvider;
    private ManageReactionsResultsAdapter resultsAdapter;

    /* JADX INFO: compiled from: WidgetManageReactions.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void create$default(Companion companion, long j, long j2, Context context, MessageReaction messageReaction, int i, Object obj) {
            if ((i & 8) != 0) {
                messageReaction = null;
            }
            companion.create(j, j2, context, messageReaction);
        }

        public final void create(long channelId, long messageId, Context context, MessageReaction targetedReaction) {
            MessageReactionEmoji emoji;
            C12238m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId).putExtra("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId).putExtra(WidgetManageReactions.EXTRA_EMOJI_KEY, (targetedReaction == null || (emoji = targetedReaction.getEmoji()) == null) ? null : emoji.m8116c());
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…eaction?.emoji?.getKey())");
            C0870j.m156d(context, WidgetManageReactions.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.WidgetManageReactions$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetManageReactions.kt */
    public final /* synthetic */ class C81821 extends C12242q {
        public C81821(WidgetManageReactions widgetManageReactions) {
            super(widgetManageReactions, WidgetManageReactions.class, "modelProvider", "getModelProvider()Lcom/discord/widgets/chat/managereactions/ManageReactionsModelProvider;", 0);
        }

        @Override // p507d0.p592z.p594d.C12242q, kotlin.reflect.KProperty0
        public Object get() {
            return WidgetManageReactions.access$getModelProvider$p((WidgetManageReactions) this.receiver);
        }

        @Override // p507d0.p592z.p594d.C12242q
        public void set(Object obj) {
            ((WidgetManageReactions) this.receiver).modelProvider = (ManageReactionsModelProvider) obj;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.WidgetManageReactions$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetManageReactions.kt */
    public static final /* synthetic */ class C81832 extends C12236k implements Function1<String, Unit> {
        public C81832(ManageReactionsModelProvider manageReactionsModelProvider) {
            super(1, manageReactionsModelProvider, ManageReactionsModelProvider.class, "onEmojiTargeted", "onEmojiTargeted(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "p1");
            ((ManageReactionsModelProvider) this.receiver).onEmojiTargeted(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.WidgetManageReactions$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetManageReactions.kt */
    public static final class C81841 extends AbstractC12240o implements Function1<ManageReactionsModel, Unit> {
        public C81841() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ManageReactionsModel manageReactionsModel) {
            invoke2(manageReactionsModel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ManageReactionsModel manageReactionsModel) {
            WidgetManageReactions.this.configureUI(manageReactionsModel);
        }
    }

    public WidgetManageReactions() {
        super(C5419R.layout.widget_manage_reactions);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetManageReactions$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ ManageReactionsModelProvider access$getModelProvider$p(WidgetManageReactions widgetManageReactions) {
        ManageReactionsModelProvider manageReactionsModelProvider = widgetManageReactions.modelProvider;
        if (manageReactionsModelProvider == null) {
            C12238m.throwUninitializedPropertyAccessException("modelProvider");
        }
        return manageReactionsModelProvider;
    }

    private final void configureUI(ManageReactionsModel data) {
        if (data == null) {
            FragmentActivity fragmentActivityM95e = m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.finish();
                return;
            }
            return;
        }
        ManageReactionsEmojisAdapter manageReactionsEmojisAdapter = this.emojisAdapter;
        if (manageReactionsEmojisAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("emojisAdapter");
        }
        manageReactionsEmojisAdapter.setData(data.getReactionItems());
        ManageReactionsResultsAdapter manageReactionsResultsAdapter = this.resultsAdapter;
        if (manageReactionsResultsAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        manageReactionsResultsAdapter.setData(data.getUserItems());
    }

    public static final void create(long j, long j2, Context context, MessageReaction messageReaction) {
        INSTANCE.create(j, j2, context, messageReaction);
    }

    private final WidgetManageReactionsBinding getBinding() {
        return (WidgetManageReactionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.reactions);
        if (this.modelProvider == null) {
            this.modelProvider = new ManageReactionsModelProvider(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L), getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_MESSAGE_ID", 0L), getMostRecentIntent().getStringExtra(EXTRA_EMOJI_KEY), null, null, null, 56, null);
        }
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f17216b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.manageReactionsEmojisRecycler");
        this.emojisAdapter = (ManageReactionsEmojisAdapter) companion.configure(new ManageReactionsEmojisAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().f17217c;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.manageReactionsResultsRecycler");
        this.resultsAdapter = (ManageReactionsResultsAdapter) companion.configure(new ManageReactionsResultsAdapter(recyclerView2));
        ManageReactionsEmojisAdapter manageReactionsEmojisAdapter = this.emojisAdapter;
        if (manageReactionsEmojisAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("emojisAdapter");
        }
        ManageReactionsModelProvider manageReactionsModelProvider = this.modelProvider;
        if (manageReactionsModelProvider == null) {
            C12238m.throwUninitializedPropertyAccessException("modelProvider");
        }
        manageReactionsEmojisAdapter.setOnEmojiSelectedListener(new C81832(manageReactionsModelProvider));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ManageReactionsModelProvider manageReactionsModelProvider = this.modelProvider;
        if (manageReactionsModelProvider == null) {
            C12238m.throwUninitializedPropertyAccessException("modelProvider");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(manageReactionsModelProvider.get(), this, null, 2, null), (Class<?>) WidgetManageReactions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C81841());
    }
}
