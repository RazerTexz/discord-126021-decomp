package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.databinding.WidgetChatListAdapterItemThreadDraftFormBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.ThreadDraftFormEntry;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Locale;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.p012b.C0813e;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadDraftForm extends WidgetChatListItem {
    private final WidgetChatListAdapterItemThreadDraftFormBinding binding;
    private final AppFlexInputViewModel flexInputViewModel;
    private TextWatcher nameTextWatcher;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
    public static final class C81391 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ ThreadDraftFormEntry $data;
        public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState;

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
            public static final class C132811 extends AbstractC12240o implements Function1<View, Unit> {
                public C132811() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    C12238m.checkNotNullParameter(view, "it");
                    WidgetThreadDraftArchiveSheet.INSTANCE.show(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm.this).getFragmentManager(), C81391.this.$data.getGuildId());
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                C12238m.checkNotNullParameter(hook, "$receiver");
                ThreadUtils threadUtils = ThreadUtils.INSTANCE;
                Context context = WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm.this).getContext();
                Integer autoArchiveDuration = C81391.this.$draftState.getAutoArchiveDuration();
                if (autoArchiveDuration == null) {
                    autoArchiveDuration = C81391.this.$data.getDefaultAutoArchiveDuration();
                }
                String strAutoArchiveDurationName = threadUtils.autoArchiveDurationName(context, autoArchiveDuration != null ? autoArchiveDuration.intValue() : 1440);
                Locale locale = Locale.getDefault();
                C12238m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
                Objects.requireNonNull(strAutoArchiveDurationName, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = strAutoArchiveDurationName.toLowerCase(locale);
                C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                hook.replacementText = lowerCase;
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm.this).getContext(), C5419R.attr.colorHeaderPrimary)), true, null, new C132811(), 4, null));
                hook.styles.add(new StyleSpan(1));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C81391(StoreThreadDraft.ThreadDraftState threadDraftState, ThreadDraftFormEntry threadDraftFormEntry) {
            super(1);
            this.$draftState = threadDraftState;
            this.$data = threadDraftFormEntry;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8422a("durationHook", new AnonymousClass1());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemThreadDraftForm(WidgetChatListAdapter widgetChatListAdapter, AppFlexInputViewModel appFlexInputViewModel) {
        super(C5419R.layout.widget_chat_list_adapter_item_thread_draft_form, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        this.flexInputViewModel = appFlexInputViewModel;
        View view = this.itemView;
        int i = C5419R.id.auto_archive_duration;
        TextView textView = (TextView) view.findViewById(C5419R.id.auto_archive_duration);
        if (textView != null) {
            i = C5419R.id.divider_stroke;
            View viewFindViewById = view.findViewById(C5419R.id.divider_stroke);
            if (viewFindViewById != null) {
                i = C5419R.id.private_thread_toggle;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.private_thread_toggle);
                if (constraintLayout != null) {
                    i = C5419R.id.private_thread_toggle_badge;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.private_thread_toggle_badge);
                    if (textView2 != null) {
                        i = C5419R.id.private_thread_toggle_switch;
                        SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(C5419R.id.private_thread_toggle_switch);
                        if (switchMaterial != null) {
                            i = C5419R.id.private_thread_toggle_text;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.private_thread_toggle_text);
                            if (linearLayout != null) {
                                i = C5419R.id.thread_icon;
                                ImageView imageView = (ImageView) view.findViewById(C5419R.id.thread_icon);
                                if (imageView != null) {
                                    i = C5419R.id.thread_name_input;
                                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.thread_name_input);
                                    if (textInputLayout != null) {
                                        WidgetChatListAdapterItemThreadDraftFormBinding widgetChatListAdapterItemThreadDraftFormBinding = new WidgetChatListAdapterItemThreadDraftFormBinding((LinearLayout) view, textView, viewFindViewById, constraintLayout, textView2, switchMaterial, linearLayout, imageView, textInputLayout);
                                        C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemThreadDraftFormBinding, "WidgetChatListAdapterIte…ormBinding.bind(itemView)");
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

    private final void configureAutoArchive(final ThreadDraftFormEntry data) {
        StoreThreadDraft.ThreadDraftState threadDraftState = data.getThreadDraftState();
        TextView textView = this.binding.f16330b;
        C12238m.checkNotNullExpressionValue(textView, "binding.autoArchiveDuration");
        C1107b.m221m(textView, C5419R.string.create_thread_header_2, new Object[0], new C81391(threadDraftState, data));
        this.binding.f16330b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm.configureAutoArchive.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadDraftArchiveSheet.INSTANCE.show(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm.this).getFragmentManager(), data.getGuildId());
            }
        });
    }

    private final void configureIcon(ThreadDraftFormEntry data) {
        int i;
        StoreThreadDraft.ThreadDraftState threadDraftState = data.getThreadDraftState();
        if (ChannelUtils.m7693q(data.getParentChannel())) {
            i = C5419R.drawable.ic_channel_forum_post;
        } else {
            i = threadDraftState.isPrivate() ? C5419R.drawable.ic_thread_locked : C5419R.drawable.ic_thread;
        }
        this.binding.f16334f.setImageResource(i);
    }

    private final void configurePrivateThreadOption(final ThreadDraftFormEntry data) {
        final StoreThreadDraft.ThreadDraftState threadDraftState = data.getThreadDraftState();
        final StoreThreadDraft threadDraft = StoreStream.INSTANCE.getThreadDraft();
        if (ChannelUtils.m7693q(data.getParentChannel())) {
            ConstraintLayout constraintLayout = this.binding.f16331c;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.privateThreadToggle");
            constraintLayout.setVisibility(8);
            return;
        }
        ConstraintLayout constraintLayout2 = this.binding.f16331c;
        C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.privateThreadToggle");
        constraintLayout2.setVisibility(data.getParentMessageId() == null && data.getCanSeePrivateThreadOption() ? 0 : 8);
        if (!data.getCanCreatePublicThread() && !threadDraftState.isPrivate()) {
            threadDraft.setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(threadDraftState, true, null, null, false, false, 30, null));
            this.binding.f16331c.setOnClickListener(null);
        } else if (data.getCanCreatePrivateThread()) {
            this.binding.f16331c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm.configurePrivateThreadOption.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StoreThreadDraft storeThreadDraft = threadDraft;
                    StoreThreadDraft.ThreadDraftState threadDraftState2 = threadDraftState;
                    storeThreadDraft.setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(threadDraftState2, !threadDraftState2.isPrivate(), null, null, false, false, 30, null));
                }
            });
        } else {
            this.binding.f16331c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm.configurePrivateThreadOption.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C0813e.INSTANCE.m119a(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm.this).getFragmentManager(), data.getGuildId(), Long.valueOf(data.getParentChannel().getId()), PremiumUtils.INSTANCE.getMinimumBoostTierForGuildFeature(GuildFeature.PRIVATE_THREADS), new Traits.Location(Traits.Location.Page.GUILD_CHANNEL, Traits.Location.Section.THREAD_CREATION_OPTIONS, Traits.Location.Obj.PRIVATE_THREAD_CHECKBOX, null, null, 24, null));
                }
            });
        }
        SwitchMaterial switchMaterial = this.binding.f16333e;
        C12238m.checkNotNullExpressionValue(switchMaterial, "binding.privateThreadToggleSwitch");
        switchMaterial.setChecked(threadDraftState.isPrivate());
        PremiumUtils.BoostFeatureBadgeData boostFeatureBadgeDataForGuildFeature = PremiumUtils.INSTANCE.getBoostFeatureBadgeDataForGuildFeature(data.getGuild(), Long.valueOf(data.getParentChannel().getId()), GuildFeature.PRIVATE_THREADS, ((WidgetChatListAdapter) this.adapter).getContext(), ((WidgetChatListAdapter) this.adapter).getFragmentManager(), (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? null : new Traits.Location(null, Traits.Location.Section.THREAD_CREATION_OPTIONS, Traits.Location.Obj.PRIVATE_THREAD_CHECKBOX, null, null, 25, null));
        TextView textView = this.binding.f16332d;
        C12238m.checkNotNullExpressionValue(textView, "binding.privateThreadToggleBadge");
        textView.setText(boostFeatureBadgeDataForGuildFeature.getText());
        TextView textView2 = this.binding.f16332d;
        Drawable drawable = ContextCompat.getDrawable(((WidgetChatListAdapter) this.adapter).getContext(), C5419R.drawable.ic_boosted_badge_12dp);
        if (drawable != null) {
            drawable.setTint(boostFeatureBadgeDataForGuildFeature.getIconColor());
        } else {
            drawable = null;
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private final void configureThreadNameInput(ThreadDraftFormEntry data) {
        final StoreThreadDraft.ThreadDraftState threadDraftState = data.getThreadDraftState();
        final StoreThreadDraft threadDraft = StoreStream.INSTANCE.getThreadDraft();
        String threadName = threadDraftState.getThreadName();
        if (threadName == null || threadName.length() == 0) {
            TextInputLayout textInputLayout = this.binding.f16335g;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.threadNameInput");
            ViewExtensions.clear(textInputLayout);
        }
        TextInputLayout textInputLayout2 = this.binding.f16335g;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.threadNameInput");
        EditText editText = textInputLayout2.getEditText();
        if (editText != null) {
            editText.removeTextChangedListener(this.nameTextWatcher);
            TextWatcher textWatcher = new TextWatcher() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$1
                /* JADX WARN: Code duplicated, block: B:15:0x0026  */
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s2) {
                    boolean z2;
                    StoreThreadDraft storeThreadDraft = threadDraft;
                    StoreThreadDraft.ThreadDraftState threadDraftState2 = threadDraftState;
                    String string = s2 != null ? s2.toString() : null;
                    if (threadDraftState.getShouldDisplayNameError() && s2 != null) {
                        z2 = s2.length() == 0;
                    }
                    storeThreadDraft.setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(threadDraftState2, false, null, string, false, z2, 11, null));
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence text, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence text, int start, int before, int count) {
                }
            };
            editText.addTextChangedListener(textWatcher);
            this.nameTextWatcher = textWatcher;
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$2
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z2) {
                    if (z2 || !threadDraftState.getShouldDisplayNameError()) {
                        return;
                    }
                    threadDraft.setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(threadDraftState, false, null, null, false, false, 15, null));
                }
            });
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$3
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    AppFlexInputViewModel flexInputViewModel;
                    if (i != 5 || (flexInputViewModel = this.this$0.getFlexInputViewModel()) == null) {
                        return false;
                    }
                    flexInputViewModel.focus();
                    return false;
                }
            });
        }
        if (!threadDraftState.getShouldDisplayNameError()) {
            TextInputLayout textInputLayout3 = this.binding.f16335g;
            C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.threadNameInput");
            textInputLayout3.setErrorEnabled(false);
            return;
        }
        TextInputLayout textInputLayout4 = this.binding.f16335g;
        C12238m.checkNotNullExpressionValue(textInputLayout4, "binding.threadNameInput");
        TextInputLayout textInputLayout5 = this.binding.f16335g;
        C12238m.checkNotNullExpressionValue(textInputLayout5, "binding.threadNameInput");
        textInputLayout4.setError(textInputLayout5.getContext().getString(C5419R.string.member_verification_form_required_item));
        TextInputLayout textInputLayout6 = this.binding.f16335g;
        C12238m.checkNotNullExpressionValue(textInputLayout6, "binding.threadNameInput");
        textInputLayout6.setErrorEnabled(true);
    }

    public final AppFlexInputViewModel getFlexInputViewModel() {
        return this.flexInputViewModel;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ThreadDraftFormEntry threadDraftFormEntry = (ThreadDraftFormEntry) data;
        configureThreadNameInput(threadDraftFormEntry);
        configureAutoArchive(threadDraftFormEntry);
        configureIcon(threadDraftFormEntry);
        configurePrivateThreadOption(threadDraftFormEntry);
        this.binding.f16335g.requestFocus();
    }
}
