package com.discord.widgets.chat.managereactions;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetManageReactionsBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.MutablePropertyReference0Impl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetManageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetManageReactions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetManageReactions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetManageReactionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_EMOJI_KEY = "com.discord.intent.extra.EXTRA_EMOJI_KEY";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ManageReactionsEmojisAdapter emojisAdapter;
    private ManageReactionsModel2 modelProvider;
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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId).putExtra("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId).putExtra(WidgetManageReactions.EXTRA_EMOJI_KEY, (targetedReaction == null || (emoji = targetedReaction.getEmoji()) == null) ? null : emoji.c());
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…eaction?.emoji?.getKey())");
            AppScreen2.d(context, WidgetManageReactions.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.WidgetManageReactions$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetManageReactions.kt */
    public final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(WidgetManageReactions widgetManageReactions) {
            super(widgetManageReactions, WidgetManageReactions.class, "modelProvider", "getModelProvider()Lcom/discord/widgets/chat/managereactions/ManageReactionsModelProvider;", 0);
        }

        @Override // d0.z.d.MutablePropertyReference0Impl, kotlin.reflect.KProperty6
        public Object get() {
            return WidgetManageReactions.access$getModelProvider$p((WidgetManageReactions) this.receiver);
        }

        @Override // d0.z.d.MutablePropertyReference0Impl
        public void set(Object obj) {
            ((WidgetManageReactions) this.receiver).modelProvider = (ManageReactionsModel2) obj;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.WidgetManageReactions$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetManageReactions.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass2(ManageReactionsModel2 manageReactionsModel2) {
            super(1, manageReactionsModel2, ManageReactionsModel2.class, "onEmojiTargeted", "onEmojiTargeted(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            ((ManageReactionsModel2) this.receiver).onEmojiTargeted(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.WidgetManageReactions$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetManageReactions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ManageReactionsModel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ManageReactionsModel manageReactionsModel) {
            invoke2(manageReactionsModel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ManageReactionsModel manageReactionsModel) {
            WidgetManageReactions.this.configureUI(manageReactionsModel);
        }
    }

    public WidgetManageReactions() {
        super(R.layout.widget_manage_reactions);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetManageReactions2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ ManageReactionsModel2 access$getModelProvider$p(WidgetManageReactions widgetManageReactions) {
        ManageReactionsModel2 manageReactionsModel2 = widgetManageReactions.modelProvider;
        if (manageReactionsModel2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("modelProvider");
        }
        return manageReactionsModel2;
    }

    private final void configureUI(ManageReactionsModel data) {
        if (data == null) {
            FragmentActivity fragmentActivityE = e();
            if (fragmentActivityE != null) {
                fragmentActivityE.finish();
                return;
            }
            return;
        }
        ManageReactionsEmojisAdapter manageReactionsEmojisAdapter = this.emojisAdapter;
        if (manageReactionsEmojisAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojisAdapter");
        }
        manageReactionsEmojisAdapter.setData(data.getReactionItems());
        ManageReactionsResultsAdapter manageReactionsResultsAdapter = this.resultsAdapter;
        if (manageReactionsResultsAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.reactions);
        if (this.modelProvider == null) {
            this.modelProvider = new ManageReactionsModel2(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L), getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_MESSAGE_ID", 0L), getMostRecentIntent().getStringExtra(EXTRA_EMOJI_KEY), null, null, null, 56, null);
        }
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2482b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.manageReactionsEmojisRecycler");
        this.emojisAdapter = (ManageReactionsEmojisAdapter) companion.configure(new ManageReactionsEmojisAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.manageReactionsResultsRecycler");
        this.resultsAdapter = (ManageReactionsResultsAdapter) companion.configure(new ManageReactionsResultsAdapter(recyclerView2));
        ManageReactionsEmojisAdapter manageReactionsEmojisAdapter = this.emojisAdapter;
        if (manageReactionsEmojisAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojisAdapter");
        }
        ManageReactionsModel2 manageReactionsModel2 = this.modelProvider;
        if (manageReactionsModel2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("modelProvider");
        }
        manageReactionsEmojisAdapter.setOnEmojiSelectedListener(new AnonymousClass2(manageReactionsModel2));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ManageReactionsModel2 manageReactionsModel2 = this.modelProvider;
        if (manageReactionsModel2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("modelProvider");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(manageReactionsModel2.get(), this, null, 2, null), (Class<?>) WidgetManageReactions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
