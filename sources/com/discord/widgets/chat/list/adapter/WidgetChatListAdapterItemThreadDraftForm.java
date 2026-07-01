package com.discord.widgets.chat.list.adapter;

import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import b.a.k.b;
import com.discord.R$drawable;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.databinding.WidgetChatListAdapterItemThreadDraftFormBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft;
import com.discord.stores.StoreThreadDraft$ThreadDraftState;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Obj;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.premium.PremiumUtils$BoostFeatureBadgeData;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.ThreadDraftFormEntry;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadDraftForm extends WidgetChatListItem {
    private final WidgetChatListAdapterItemThreadDraftFormBinding binding;
    private final AppFlexInputViewModel flexInputViewModel;
    private TextWatcher nameTextWatcher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemThreadDraftForm(WidgetChatListAdapter widgetChatListAdapter, AppFlexInputViewModel appFlexInputViewModel) {
        super(R$layout.widget_chat_list_adapter_item_thread_draft_form, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        this.flexInputViewModel = appFlexInputViewModel;
        View view = this.itemView;
        int i = R$id.auto_archive_duration;
        TextView textView = (TextView) view.findViewById(R$id.auto_archive_duration);
        if (textView != null) {
            i = R$id.divider_stroke;
            View viewFindViewById = view.findViewById(R$id.divider_stroke);
            if (viewFindViewById != null) {
                i = R$id.private_thread_toggle;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.private_thread_toggle);
                if (constraintLayout != null) {
                    i = R$id.private_thread_toggle_badge;
                    TextView textView2 = (TextView) view.findViewById(R$id.private_thread_toggle_badge);
                    if (textView2 != null) {
                        i = R$id.private_thread_toggle_switch;
                        SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(R$id.private_thread_toggle_switch);
                        if (switchMaterial != null) {
                            i = R$id.private_thread_toggle_text;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.private_thread_toggle_text);
                            if (linearLayout != null) {
                                i = R$id.thread_icon;
                                ImageView imageView = (ImageView) view.findViewById(R$id.thread_icon);
                                if (imageView != null) {
                                    i = R$id.thread_name_input;
                                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.thread_name_input);
                                    if (textInputLayout != null) {
                                        WidgetChatListAdapterItemThreadDraftFormBinding widgetChatListAdapterItemThreadDraftFormBinding = new WidgetChatListAdapterItemThreadDraftFormBinding((LinearLayout) view, textView, viewFindViewById, constraintLayout, textView2, switchMaterial, linearLayout, imageView, textInputLayout);
                                        m.checkNotNullExpressionValue(widgetChatListAdapterItemThreadDraftFormBinding, "WidgetChatListAdapterIte…ormBinding.bind(itemView)");
                                        this.binding = widgetChatListAdapterItemThreadDraftFormBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm widgetChatListAdapterItemThreadDraftForm) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemThreadDraftForm.adapter;
    }

    private final void configureAutoArchive(ThreadDraftFormEntry data) {
        StoreThreadDraft$ThreadDraftState threadDraftState = data.getThreadDraftState();
        TextView textView = this.binding.f2340b;
        m.checkNotNullExpressionValue(textView, "binding.autoArchiveDuration");
        b.m(textView, 2131888267, new Object[0], new WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1(this, threadDraftState, data));
        this.binding.f2340b.setOnClickListener(new WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$2(this, data));
    }

    private final void configureIcon(ThreadDraftFormEntry data) {
        int i;
        StoreThreadDraft$ThreadDraftState threadDraftState = data.getThreadDraftState();
        if (ChannelUtils.q(data.getParentChannel())) {
            i = R$drawable.ic_channel_forum_post;
        } else {
            i = threadDraftState.isPrivate() ? 2131232196 : 2131232193;
        }
        this.binding.f.setImageResource(i);
    }

    private final void configurePrivateThreadOption(ThreadDraftFormEntry data) {
        StoreThreadDraft$ThreadDraftState threadDraftState = data.getThreadDraftState();
        StoreThreadDraft threadDraft = StoreStream.Companion.getThreadDraft();
        if (ChannelUtils.q(data.getParentChannel())) {
            ConstraintLayout constraintLayout = this.binding.c;
            m.checkNotNullExpressionValue(constraintLayout, "binding.privateThreadToggle");
            constraintLayout.setVisibility(8);
            return;
        }
        ConstraintLayout constraintLayout2 = this.binding.c;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.privateThreadToggle");
        constraintLayout2.setVisibility(data.getParentMessageId() == null && data.getCanSeePrivateThreadOption() ? 0 : 8);
        if (!data.getCanCreatePublicThread() && !threadDraftState.isPrivate()) {
            threadDraft.setDraftState(StoreThreadDraft$ThreadDraftState.copy$default(threadDraftState, true, null, null, false, false, 30, null));
            this.binding.c.setOnClickListener(null);
        } else if (data.getCanCreatePrivateThread()) {
            this.binding.c.setOnClickListener(new WidgetChatListAdapterItemThreadDraftForm$configurePrivateThreadOption$2(threadDraft, threadDraftState));
        } else {
            this.binding.c.setOnClickListener(new WidgetChatListAdapterItemThreadDraftForm$configurePrivateThreadOption$1(this, data));
        }
        SwitchMaterial switchMaterial = this.binding.e;
        m.checkNotNullExpressionValue(switchMaterial, "binding.privateThreadToggleSwitch");
        switchMaterial.setChecked(threadDraftState.isPrivate());
        PremiumUtils$BoostFeatureBadgeData boostFeatureBadgeDataForGuildFeature$default = PremiumUtils.getBoostFeatureBadgeDataForGuildFeature$default(PremiumUtils.INSTANCE, data.getGuild(), Long.valueOf(data.getParentChannel().getId()), GuildFeature.PRIVATE_THREADS, ((WidgetChatListAdapter) this.adapter).getContext(), ((WidgetChatListAdapter) this.adapter).getFragmentManager(), null, new Traits$Location(null, Traits$Location$Section.THREAD_CREATION_OPTIONS, Traits$Location$Obj.PRIVATE_THREAD_CHECKBOX, null, null, 25, null), 32, null);
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.privateThreadToggleBadge");
        textView.setText(boostFeatureBadgeDataForGuildFeature$default.getText());
        TextView textView2 = this.binding.d;
        Drawable drawable = ContextCompat.getDrawable(((WidgetChatListAdapter) this.adapter).getContext(), 2131231581);
        if (drawable != null) {
            drawable.setTint(boostFeatureBadgeDataForGuildFeature$default.getIconColor());
        } else {
            drawable = null;
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private final void configureThreadNameInput(ThreadDraftFormEntry data) {
        StoreThreadDraft$ThreadDraftState threadDraftState = data.getThreadDraftState();
        StoreThreadDraft threadDraft = StoreStream.Companion.getThreadDraft();
        String threadName = threadDraftState.getThreadName();
        if (threadName == null || threadName.length() == 0) {
            TextInputLayout textInputLayout = this.binding.g;
            m.checkNotNullExpressionValue(textInputLayout, "binding.threadNameInput");
            ViewExtensions.clear(textInputLayout);
        }
        TextInputLayout textInputLayout2 = this.binding.g;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.threadNameInput");
        EditText editText = textInputLayout2.getEditText();
        if (editText != null) {
            editText.removeTextChangedListener(this.nameTextWatcher);
            WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$1 widgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$1 = new WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$1(this, threadDraft, threadDraftState);
            editText.addTextChangedListener(widgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$1);
            this.nameTextWatcher = widgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$1;
            editText.setOnFocusChangeListener(new WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$2(this, threadDraft, threadDraftState));
            editText.setOnEditorActionListener(new WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$3(this, threadDraft, threadDraftState));
        }
        if (!threadDraftState.getShouldDisplayNameError()) {
            TextInputLayout textInputLayout3 = this.binding.g;
            m.checkNotNullExpressionValue(textInputLayout3, "binding.threadNameInput");
            textInputLayout3.setErrorEnabled(false);
            return;
        }
        TextInputLayout textInputLayout4 = this.binding.g;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.threadNameInput");
        TextInputLayout textInputLayout5 = this.binding.g;
        m.checkNotNullExpressionValue(textInputLayout5, "binding.threadNameInput");
        textInputLayout4.setError(textInputLayout5.getContext().getString(2131892854));
        TextInputLayout textInputLayout6 = this.binding.g;
        m.checkNotNullExpressionValue(textInputLayout6, "binding.threadNameInput");
        textInputLayout6.setErrorEnabled(true);
    }

    public final AppFlexInputViewModel getFlexInputViewModel() {
        return this.flexInputViewModel;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ThreadDraftFormEntry threadDraftFormEntry = (ThreadDraftFormEntry) data;
        configureThreadNameInput(threadDraftFormEntry);
        configureAutoArchive(threadDraftFormEntry);
        configureIcon(threadDraftFormEntry);
        configurePrivateThreadOption(threadDraftFormEntry);
        this.binding.g.requestFocus();
    }
}
