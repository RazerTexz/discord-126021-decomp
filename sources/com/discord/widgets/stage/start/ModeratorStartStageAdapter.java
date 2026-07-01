package com.discord.widgets.stage.start;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.ModeratorStartStageContinueItemBinding;
import com.discord.databinding.ModeratorStartStageHeaderItemBinding;
import com.discord.databinding.ModeratorStartStageListItemBinding;
import com.discord.databinding.ModeratorStartStageWaitingItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.user.UserSummaryView;
import com.discord.widgets.guildscheduledevent.GuildEventPromptView;
import com.discord.widgets.stage.start.ModeratorStartStageItem;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModeratorStartStageAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModeratorStartStageAdapter extends MGRecyclerAdapterSimple<ModeratorStartStageItem> {
    private final Function1<ModeratorStartStageItem, Unit> onItemClicked;

    /* JADX INFO: compiled from: ModeratorStartStageAdapter.kt */
    public abstract class CreateStageEventViewHolder extends MGRecyclerViewHolder<ModeratorStartStageAdapter, ModeratorStartStageItem> {
        private final View rootView;
        public final /* synthetic */ ModeratorStartStageAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CreateStageEventViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, View view) {
            super(view, moderatorStartStageAdapter);
            Intrinsics3.checkNotNullParameter(view, "rootView");
            this.this$0 = moderatorStartStageAdapter;
            this.rootView = view;
        }

        public final View getRootView() {
            return this.rootView;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final ModeratorStartStageItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stage.start.ModeratorStartStageAdapter$CreateStageEventViewHolder$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.this$0.this$0.getOnItemClicked().invoke(data);
                }
            });
        }
    }

    /* JADX INFO: compiled from: ModeratorStartStageAdapter.kt */
    public final class ListItemViewHolder extends CreateStageEventViewHolder {
        private final ModeratorStartStageListItemBinding binding;
        public final /* synthetic */ ModeratorStartStageAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public ListItemViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageListItemBinding moderatorStartStageListItemBinding) {
            Intrinsics3.checkNotNullParameter(moderatorStartStageListItemBinding, "binding");
            this.this$0 = moderatorStartStageAdapter;
            GuildEventPromptView guildEventPromptView = moderatorStartStageListItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(guildEventPromptView, "binding.root");
            super(moderatorStartStageAdapter, guildEventPromptView);
            this.binding = moderatorStartStageListItemBinding;
        }

        public final ModeratorStartStageListItemBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.stage.start.ModeratorStartStageAdapter.CreateStageEventViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, ModeratorStartStageItem data) {
            Tuples2 tuples2;
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            ModeratorStartStageItem.ListItem listItem = (ModeratorStartStageItem.ListItem) data;
            if (listItem instanceof ModeratorStartStageItem.ListItem.StaticOption) {
                ModeratorStartStageItem.ListItem.StaticOption staticOption = (ModeratorStartStageItem.ListItem.StaticOption) listItem;
                tuples2 = new Tuples2(FormatUtils.b(this.this$0.getContext(), staticOption.getTitleRes(), new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), FormatUtils.b(this.this$0.getContext(), staticOption.getSubtitleRes(), new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null));
            } else {
                if (!(listItem instanceof ModeratorStartStageItem.ListItem.Event)) {
                    throw new NoWhenBranchMatchedException();
                }
                ModeratorStartStageItem.ListItem.Event event = (ModeratorStartStageItem.ListItem.Event) listItem;
                tuples2 = new Tuples2(event.getEvent().getName(), GuildScheduledEventUtilities5.getEventStartingTimeString(event.getEvent(), this.this$0.getContext()));
            }
            this.binding.a.configure(listItem.getIconRes(), listItem.getIconBgColorRes(), (CharSequence) tuples2.component1(), (CharSequence) tuples2.component2());
        }

        public ListItemViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageListItemBinding moderatorStartStageListItemBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                View viewInflate = LayoutInflater.from(moderatorStartStageAdapter.getContext()).inflate(R.layout.moderator_start_stage_list_item, (ViewGroup) moderatorStartStageAdapter.getRecycler(), false);
                Objects.requireNonNull(viewInflate, "rootView");
                ModeratorStartStageListItemBinding moderatorStartStageListItemBinding2 = new ModeratorStartStageListItemBinding((GuildEventPromptView) viewInflate);
                Intrinsics3.checkNotNullExpressionValue(moderatorStartStageListItemBinding2, "ModeratorStartStageListI…ontext), recycler, false)");
                moderatorStartStageListItemBinding = moderatorStartStageListItemBinding2;
            }
            this(moderatorStartStageAdapter, moderatorStartStageListItemBinding);
        }
    }

    /* JADX INFO: compiled from: ModeratorStartStageAdapter.kt */
    public final class WaitingViewHolder extends CreateStageEventViewHolder {
        private final ModeratorStartStageWaitingItemBinding binding;
        public final /* synthetic */ ModeratorStartStageAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public WaitingViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageWaitingItemBinding moderatorStartStageWaitingItemBinding) {
            Intrinsics3.checkNotNullParameter(moderatorStartStageWaitingItemBinding, "binding");
            this.this$0 = moderatorStartStageAdapter;
            ConstraintLayout constraintLayout = moderatorStartStageWaitingItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(moderatorStartStageAdapter, constraintLayout);
            this.binding = moderatorStartStageWaitingItemBinding;
        }

        public final ModeratorStartStageWaitingItemBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.stage.start.ModeratorStartStageAdapter.CreateStageEventViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, ModeratorStartStageItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            ModeratorStartStageItem.Waiting waiting = (ModeratorStartStageItem.Waiting) data;
            UserSummaryView.b(this.binding.f2129b, waiting.getUsers(), false, 2);
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.moderatorStartStageWaitingUserText");
            int size = waiting.getUsers().size();
            CharSequence charSequenceB = null;
            if (size == 1) {
                charSequenceB = FormatUtils.b(this.this$0.getContext(), R.string.stage_audience_waiting_one, new Object[]{waiting.getUsers().get(0).getNickOrUserName()}, (4 & 4) != 0 ? FormatUtils.b.j : null);
            } else if (size == 2) {
                charSequenceB = FormatUtils.b(this.this$0.getContext(), R.string.stage_audience_waiting_two, new Object[]{waiting.getUsers().get(0).getNickOrUserName(), waiting.getUsers().get(1).getNickOrUserName()}, (4 & 4) != 0 ? FormatUtils.b.j : null);
            } else if (size == 3) {
                charSequenceB = StringResourceUtils.getI18nPluralString(this.this$0.getContext(), R.plurals.stage_audience_waiting_many_numOthers, waiting.getUsers().size() - 2, waiting.getUsers().get(0).getNickOrUserName(), waiting.getUsers().get(1).getNickOrUserName());
            }
            ViewExtensions.setTextAndVisibilityBy(textView, charSequenceB);
        }

        public WaitingViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageWaitingItemBinding moderatorStartStageWaitingItemBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                View viewInflate = LayoutInflater.from(moderatorStartStageAdapter.getContext()).inflate(R.layout.moderator_start_stage_waiting_item, (ViewGroup) moderatorStartStageAdapter.getRecycler(), false);
                int i2 = R.id.moderator_start_stage_waiting_user_list;
                UserSummaryView userSummaryView = (UserSummaryView) viewInflate.findViewById(R.id.moderator_start_stage_waiting_user_list);
                if (userSummaryView != null) {
                    i2 = R.id.moderator_start_stage_waiting_user_text;
                    TextView textView = (TextView) viewInflate.findViewById(R.id.moderator_start_stage_waiting_user_text);
                    if (textView != null) {
                        ModeratorStartStageWaitingItemBinding moderatorStartStageWaitingItemBinding2 = new ModeratorStartStageWaitingItemBinding((ConstraintLayout) viewInflate, userSummaryView, textView);
                        Intrinsics3.checkNotNullExpressionValue(moderatorStartStageWaitingItemBinding2, "ModeratorStartStageWaiti…ontext), recycler, false)");
                        moderatorStartStageWaitingItemBinding = moderatorStartStageWaitingItemBinding2;
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
            }
            this(moderatorStartStageAdapter, moderatorStartStageWaitingItemBinding);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ModeratorStartStageAdapter(RecyclerView recyclerView, Function1<? super ModeratorStartStageItem, Unit> function1) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(function1, "onItemClicked");
        this.onItemClicked = function1;
    }

    public final Function1<ModeratorStartStageItem, Unit> getOnItemClicked() {
        return this.onItemClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, ModeratorStartStageItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new HeaderViewHolder(this, null, 1, null);
        }
        if (viewType == 1) {
            return new ListItemViewHolder(this, null, 1, null);
        }
        if (viewType == 2) {
            return new ContinueViewHolder(this, null, 1, null);
        }
        if (viewType == 3) {
            return new WaitingViewHolder(this, null, 1, null);
        }
        throw invalidViewTypeException(viewType);
    }

    /* JADX INFO: compiled from: ModeratorStartStageAdapter.kt */
    public final class ContinueViewHolder extends CreateStageEventViewHolder {
        private final ModeratorStartStageContinueItemBinding binding;
        public final /* synthetic */ ModeratorStartStageAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public ContinueViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageContinueItemBinding moderatorStartStageContinueItemBinding) {
            Intrinsics3.checkNotNullParameter(moderatorStartStageContinueItemBinding, "binding");
            this.this$0 = moderatorStartStageAdapter;
            ConstraintLayout constraintLayout = moderatorStartStageContinueItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(moderatorStartStageAdapter, constraintLayout);
            this.binding = moderatorStartStageContinueItemBinding;
        }

        public final ModeratorStartStageContinueItemBinding getBinding() {
            return this.binding;
        }

        public ContinueViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageContinueItemBinding moderatorStartStageContinueItemBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                View viewInflate = LayoutInflater.from(moderatorStartStageAdapter.getContext()).inflate(R.layout.moderator_start_stage_continue_item, (ViewGroup) moderatorStartStageAdapter.getRecycler(), false);
                Objects.requireNonNull(viewInflate, "rootView");
                ModeratorStartStageContinueItemBinding moderatorStartStageContinueItemBinding2 = new ModeratorStartStageContinueItemBinding((ConstraintLayout) viewInflate);
                Intrinsics3.checkNotNullExpressionValue(moderatorStartStageContinueItemBinding2, "ModeratorStartStageConti…ontext), recycler, false)");
                moderatorStartStageContinueItemBinding = moderatorStartStageContinueItemBinding2;
            }
            this(moderatorStartStageAdapter, moderatorStartStageContinueItemBinding);
        }
    }

    /* JADX INFO: compiled from: ModeratorStartStageAdapter.kt */
    public final class HeaderViewHolder extends CreateStageEventViewHolder {
        private final ModeratorStartStageHeaderItemBinding binding;
        public final /* synthetic */ ModeratorStartStageAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public HeaderViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageHeaderItemBinding moderatorStartStageHeaderItemBinding) {
            Intrinsics3.checkNotNullParameter(moderatorStartStageHeaderItemBinding, "binding");
            this.this$0 = moderatorStartStageAdapter;
            ConstraintLayout constraintLayout = moderatorStartStageHeaderItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(moderatorStartStageAdapter, constraintLayout);
            this.binding = moderatorStartStageHeaderItemBinding;
        }

        public final ModeratorStartStageHeaderItemBinding getBinding() {
            return this.binding;
        }

        public HeaderViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageHeaderItemBinding moderatorStartStageHeaderItemBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                View viewInflate = LayoutInflater.from(moderatorStartStageAdapter.getContext()).inflate(R.layout.moderator_start_stage_header_item, (ViewGroup) moderatorStartStageAdapter.getRecycler(), false);
                int i2 = R.id.moderator_start_stage_icon;
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.moderator_start_stage_icon);
                if (imageView != null) {
                    i2 = R.id.moderator_start_stage_subtitle;
                    TextView textView = (TextView) viewInflate.findViewById(R.id.moderator_start_stage_subtitle);
                    if (textView != null) {
                        i2 = R.id.moderator_start_stage_title;
                        TextView textView2 = (TextView) viewInflate.findViewById(R.id.moderator_start_stage_title);
                        if (textView2 != null) {
                            ModeratorStartStageHeaderItemBinding moderatorStartStageHeaderItemBinding2 = new ModeratorStartStageHeaderItemBinding((ConstraintLayout) viewInflate, imageView, textView, textView2);
                            Intrinsics3.checkNotNullExpressionValue(moderatorStartStageHeaderItemBinding2, "ModeratorStartStageHeade…ontext), recycler, false)");
                            moderatorStartStageHeaderItemBinding = moderatorStartStageHeaderItemBinding2;
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
            }
            this(moderatorStartStageAdapter, moderatorStartStageHeaderItemBinding);
        }
    }
}
