package com.discord.widgets.chat.managereactions;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetManageReactionsBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetManageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetManageReactions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetManageReactions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetManageReactionsBinding;", 0)};
    public static final WidgetManageReactions$Companion Companion = new WidgetManageReactions$Companion(null);
    private static final String EXTRA_EMOJI_KEY = "com.discord.intent.extra.EXTRA_EMOJI_KEY";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ManageReactionsEmojisAdapter emojisAdapter;
    private ManageReactionsModelProvider modelProvider;
    private ManageReactionsResultsAdapter resultsAdapter;

    public WidgetManageReactions() {
        super(R$layout.widget_manage_reactions);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetManageReactions$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetManageReactions widgetManageReactions, ManageReactionsModel manageReactionsModel) {
        widgetManageReactions.configureUI(manageReactionsModel);
    }

    public static final /* synthetic */ ManageReactionsModelProvider access$getModelProvider$p(WidgetManageReactions widgetManageReactions) {
        ManageReactionsModelProvider manageReactionsModelProvider = widgetManageReactions.modelProvider;
        if (manageReactionsModelProvider == null) {
            m.throwUninitializedPropertyAccessException("modelProvider");
        }
        return manageReactionsModelProvider;
    }

    public static final /* synthetic */ void access$setModelProvider$p(WidgetManageReactions widgetManageReactions, ManageReactionsModelProvider manageReactionsModelProvider) {
        widgetManageReactions.modelProvider = manageReactionsModelProvider;
    }

    private final void configureUI(ManageReactionsModel data) {
        if (data == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        ManageReactionsEmojisAdapter manageReactionsEmojisAdapter = this.emojisAdapter;
        if (manageReactionsEmojisAdapter == null) {
            m.throwUninitializedPropertyAccessException("emojisAdapter");
        }
        manageReactionsEmojisAdapter.setData(data.getReactionItems());
        ManageReactionsResultsAdapter manageReactionsResultsAdapter = this.resultsAdapter;
        if (manageReactionsResultsAdapter == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        manageReactionsResultsAdapter.setData(data.getUserItems());
    }

    public static final void create(long j, long j2, Context context, MessageReaction messageReaction) {
        Companion.create(j, j2, context, messageReaction);
    }

    private final WidgetManageReactionsBinding getBinding() {
        return (WidgetManageReactionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131894700);
        if (this.modelProvider == null) {
            this.modelProvider = new ManageReactionsModelProvider(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L), getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_MESSAGE_ID", 0L), getMostRecentIntent().getStringExtra(EXTRA_EMOJI_KEY), null, null, null, 56, null);
        }
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().f2482b;
        m.checkNotNullExpressionValue(recyclerView, "binding.manageReactionsEmojisRecycler");
        this.emojisAdapter = (ManageReactionsEmojisAdapter) mGRecyclerAdapter$Companion.configure(new ManageReactionsEmojisAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView2, "binding.manageReactionsResultsRecycler");
        this.resultsAdapter = (ManageReactionsResultsAdapter) mGRecyclerAdapter$Companion.configure(new ManageReactionsResultsAdapter(recyclerView2));
        ManageReactionsEmojisAdapter manageReactionsEmojisAdapter = this.emojisAdapter;
        if (manageReactionsEmojisAdapter == null) {
            m.throwUninitializedPropertyAccessException("emojisAdapter");
        }
        ManageReactionsModelProvider manageReactionsModelProvider = this.modelProvider;
        if (manageReactionsModelProvider == null) {
            m.throwUninitializedPropertyAccessException("modelProvider");
        }
        manageReactionsEmojisAdapter.setOnEmojiSelectedListener(new WidgetManageReactions$onViewBound$2(manageReactionsModelProvider));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ManageReactionsModelProvider manageReactionsModelProvider = this.modelProvider;
        if (manageReactionsModelProvider == null) {
            m.throwUninitializedPropertyAccessException("modelProvider");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(manageReactionsModelProvider.get(), this, null, 2, null), WidgetManageReactions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetManageReactions$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
