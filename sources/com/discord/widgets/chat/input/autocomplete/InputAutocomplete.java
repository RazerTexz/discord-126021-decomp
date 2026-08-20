package com.discord.widgets.chat.input.autocomplete;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatInputApplicationCommandsBinding;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.stores.LoadState;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.ChatInputApplicationsAdapter;
import com.discord.widgets.chat.input.WidgetChatInputAutocompleteStickerAdapter;
import com.discord.widgets.chat.input.WidgetChatInputEditText;
import com.discord.widgets.chat.input.applicationcommands.SelectedApplicationCommandAdapter;
import com.discord.widgets.chat.input.attachments.AttachmentBottomSheet;
import com.discord.widgets.chat.input.autocomplete.adapter.ChatInputAutocompleteAdapter;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.lytefast.flexinput.FlexInputAttachmentListener;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.widget.FlexEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p027k.C1107b;
import p007b.p225i.p361c.p369m.p370d.p373k.C4628h;
import p507d0.p579g0.C12103t;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocomplete {
    private final ChatInputAutocompleteAdapter autocompleteAdapter;
    private final TextView autocompleteHeader;
    private final RecyclerView autocompleteRecyclerView;
    private final ChatInputApplicationsAdapter categoriesAdapter;
    private final Long channel;
    private final RecyclerView commandBrowserAppsRecyclerView;
    private boolean commandBrowserOpen;
    private final FlexEditText editText;
    private final FlexInputFragment flexInputFragment;
    private final AppFlexInputViewModel flexInputViewModel;
    private final AppFragment fragment;
    private Function1<? super ApplicationCommandOption, Unit> onPerformCommandAutocomplete;
    private final SelectedApplicationCommandAdapter selectedApplicationCommandAdapter;
    private final WidgetChatInputApplicationCommandsBinding selectedApplicationCommandUiBinding;
    private final TextView stickerHeader;
    private final WidgetChatInputAutocompleteStickerAdapter stickersAdapter;
    private final View stickersContainer;
    private final RecyclerView stickersRecyclerView;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$3 */
    /* JADX INFO: compiled from: InputAutocomplete.kt */
    public static final class C77793 extends AbstractC12240o implements Function2<Integer, Integer, Unit> {
        public C77793() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i, int i2) {
            InputAutocomplete.this.getViewModel().onSelectionChanged(InputAutocomplete.this.editText.getEditableText().toString(), i, i2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$4 */
    /* JADX INFO: compiled from: InputAutocomplete.kt */
    public static final class C77804 extends AbstractC12240o implements Function1<Application, Unit> {
        public C77804() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Application application) {
            invoke2(application);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Application application) {
            C12238m.checkNotNullParameter(application, "it");
            InputAutocomplete.this.getViewModel().selectCommandBrowserApplication(application);
            InputAutocomplete.this.categoriesAdapter.selectApplication(application.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$5 */
    /* JADX INFO: compiled from: InputAutocomplete.kt */
    public static final class C77815 extends AbstractC12240o implements Function1<Autocompletable, Unit> {
        public C77815() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Autocompletable autocompletable) {
            invoke2(autocompletable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Autocompletable autocompletable) {
            C12238m.checkNotNullParameter(autocompletable, "it");
            InputAutocomplete.this.getViewModel().selectAutocompleteItem(autocompletable);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$6 */
    /* JADX INFO: compiled from: InputAutocomplete.kt */
    public static final class C77826 extends AbstractC12240o implements Function1<Sticker, Unit> {
        public C77826() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Sticker sticker) {
            invoke2(sticker);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Sticker sticker) {
            C12238m.checkNotNullParameter(sticker, "sticker");
            InputAutocomplete.this.getViewModel().selectStickerItem(sticker);
            Context context = InputAutocomplete.this.editText.getContext();
            C12238m.checkNotNullExpressionValue(context, "editText.context");
            MessageManager messageManager = new MessageManager(context, null, null, null, null, null, null, null, null, 510, null);
            messageManager.sendMessage((510 & 1) != 0 ? "" : null, (510 & 2) != 0 ? null : null, (510 & 4) != 0 ? null : null, (510 & 8) != 0 ? null : null, (510 & 16) != 0 ? C12147n.emptyList() : C12145m.listOf(sticker), (510 & 32) != 0, (510 & 64) != 0 ? null : null, (510 & 128) == 0 ? null : null, (510 & 256) != 0 ? messageManager.defaultMessageResultHandler : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$7 */
    /* JADX INFO: compiled from: InputAutocomplete.kt */
    public static final class C77837 extends AbstractC12240o implements Function1<ApplicationCommandOption, Unit> {
        public C77837() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandOption applicationCommandOption) {
            invoke2(applicationCommandOption);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ApplicationCommandOption applicationCommandOption) {
            C12238m.checkNotNullParameter(applicationCommandOption, "it");
            InputAutocomplete.this.getViewModel().selectCommandOption(applicationCommandOption);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$configureAutocompleteBrowser$1 */
    /* JADX INFO: compiled from: InputAutocomplete.kt */
    public static final class C77841 extends AbstractC12240o implements Function2<Integer, Integer, Unit> {
        public C77841() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i, int i2) {
            int iMin = Math.min(i2, InputAutocomplete.this.autocompleteAdapter.getPageSize() - 1);
            if (i >= 0 && iMin >= i) {
                IntRange intRange = new IntRange(i, iMin);
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(intRange, 10));
                Iterator<Integer> it = intRange.iterator();
                while (it.hasNext()) {
                    arrayList.add(InputAutocomplete.this.autocompleteAdapter.getItem(((AbstractC12126c0) it).nextInt()));
                }
                InputAutocomplete.this.getViewModel().checkEmojiAutocompleteUpsellViewed(arrayList);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$configureCommandBrowser$1 */
    /* JADX INFO: compiled from: InputAutocomplete.kt */
    public static final class C77851 extends AbstractC12240o implements Function2<Integer, Integer, Unit> {
        public C77851() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i, int i2) {
            Long currentlySelectedCategory;
            if (i >= 0 && (currentlySelectedCategory = InputAutocomplete.this.getCurrentlySelectedCategory(i)) != null) {
                long jLongValue = currentlySelectedCategory.longValue();
                InputAutocomplete.this.categoriesAdapter.selectApplication(jLongValue);
                int positionOfApplication = InputAutocomplete.this.categoriesAdapter.getPositionOfApplication(jLongValue);
                if (positionOfApplication >= 0) {
                    InputAutocomplete.this.commandBrowserAppsRecyclerView.smoothScrollToPosition(positionOfApplication);
                }
            }
            InputAutocomplete.this.getViewModel().onCommandsBrowserScroll(i, i2, InputAutocomplete.this.autocompleteAdapter.getPageSize());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$handleEvent$1 */
    /* JADX INFO: compiled from: InputAutocomplete.kt */
    public static final class C77861 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Event $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77861(Event event) {
            super(0);
            this.$event = event;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            InputAutocomplete.this.getViewModel().onAttachmentRemoved(((Event.PreviewAttachment) this.$event).getAttachment());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$handleEvent$2 */
    /* JADX INFO: compiled from: InputAutocomplete.kt */
    public static final class C77872 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public final /* synthetic */ Event $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77872(Event event) {
            super(1);
            this.$event = event;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            ((Event.PreviewAttachment) this.$event).getAttachment().setSpoiler(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$handleEvent$3 */
    /* JADX INFO: compiled from: InputAutocomplete.kt */
    public static final class C77883 extends AbstractC12240o implements Function0<Unit> {
        public C77883() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            InputAutocomplete.this.fragment.showKeyboard(InputAutocomplete.this.editText);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: InputAutocomplete.kt */
    public static final /* synthetic */ class C77891 extends C12236k implements Function1<ViewState, Unit> {
        public C77891(InputAutocomplete inputAutocomplete) {
            super(1, inputAutocomplete, InputAutocomplete.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/input/autocomplete/ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((InputAutocomplete) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: InputAutocomplete.kt */
    public static final class C77902 extends AbstractC12240o implements Function1<InputEditTextAction, Unit> {
        public C77902() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InputEditTextAction inputEditTextAction) {
            invoke2(inputEditTextAction);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InputEditTextAction inputEditTextAction) {
            InputAutocomplete inputAutocomplete = InputAutocomplete.this;
            C12238m.checkNotNullExpressionValue(inputEditTextAction, "it");
            inputAutocomplete.applyEditTextAction(inputEditTextAction);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: InputAutocomplete.kt */
    public static final /* synthetic */ class C77913 extends C12236k implements Function1<Event, Unit> {
        public C77913(InputAutocomplete inputAutocomplete) {
            super(1, inputAutocomplete, InputAutocomplete.class, "handleEvent", "handleEvent(Lcom/discord/widgets/chat/input/autocomplete/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((InputAutocomplete) this.receiver).handleEvent(event);
        }
    }

    public InputAutocomplete(AppFragment appFragment, FlexInputFragment flexInputFragment, AppFlexInputViewModel appFlexInputViewModel, FlexEditText flexEditText, Long l, TextView textView, RecyclerView recyclerView, RecyclerView recyclerView2, View view, RecyclerView recyclerView3, TextView textView2, WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding) {
        C12238m.checkNotNullParameter(appFragment, "fragment");
        C12238m.checkNotNullParameter(flexInputFragment, "flexInputFragment");
        C12238m.checkNotNullParameter(appFlexInputViewModel, "flexInputViewModel");
        C12238m.checkNotNullParameter(flexEditText, "editText");
        C12238m.checkNotNullParameter(textView, "autocompleteHeader");
        C12238m.checkNotNullParameter(recyclerView, "autocompleteRecyclerView");
        C12238m.checkNotNullParameter(recyclerView2, "commandBrowserAppsRecyclerView");
        C12238m.checkNotNullParameter(view, "stickersContainer");
        C12238m.checkNotNullParameter(recyclerView3, "stickersRecyclerView");
        C12238m.checkNotNullParameter(textView2, "stickerHeader");
        C12238m.checkNotNullParameter(widgetChatInputApplicationCommandsBinding, "selectedApplicationCommandUiBinding");
        this.fragment = appFragment;
        this.flexInputFragment = flexInputFragment;
        this.flexInputViewModel = appFlexInputViewModel;
        this.editText = flexEditText;
        this.channel = l;
        this.autocompleteHeader = textView;
        this.autocompleteRecyclerView = recyclerView;
        this.commandBrowserAppsRecyclerView = recyclerView2;
        this.stickersContainer = view;
        this.stickersRecyclerView = recyclerView3;
        this.stickerHeader = textView2;
        this.selectedApplicationCommandUiBinding = widgetChatInputApplicationCommandsBinding;
        ChatInputAutocompleteAdapter chatInputAutocompleteAdapter = new ChatInputAutocompleteAdapter();
        this.autocompleteAdapter = chatInputAutocompleteAdapter;
        InputAutocomplete$viewModel$2 inputAutocomplete$viewModel$2 = new InputAutocomplete$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(appFragment);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(appFragment, C12216a0.getOrCreateKotlinClass(AutocompleteViewModel.class), new InputAutocomplete$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(inputAutocomplete$viewModel$2));
        appFlexInputViewModel.setAttachmentSelectedListener(new FlexInputAttachmentListener() { // from class: com.discord.widgets.chat.input.autocomplete.InputAutocomplete.1
            @Override // com.lytefast.flexinput.FlexInputAttachmentListener
            public void onAttachmentSelected(Attachment<?> attachment) {
                C12238m.checkNotNullParameter(attachment, "attachment");
                InputAutocomplete.this.getViewModel().setAttachment(attachment);
            }
        });
        flexEditText.addTextChangedListener(new TextWatcher() { // from class: com.discord.widgets.chat.input.autocomplete.InputAutocomplete.2
            private int before;
            private int count;
            private int start;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s2) {
                C12238m.checkNotNullParameter(s2, "s");
                InputAutocomplete.this.applyEditTextAction(InputAutocomplete.this.getViewModel().onInputTextChanged(s2, this.start, this.before, this.count));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s2, int start, int count, int after) {
            }

            public final int getBefore() {
                return this.before;
            }

            public final int getCount() {
                return this.count;
            }

            public final int getStart() {
                return this.start;
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s2, int start, int before, int count) {
                this.start = start;
                this.before = before;
                this.count = count;
            }

            public final void setBefore(int i) {
                this.before = i;
            }

            public final void setCount(int i) {
                this.count = i;
            }

            public final void setStart(int i) {
                this.start = i;
            }
        });
        flexEditText.setOnSelectionChangedListener(new C77793());
        ChatInputApplicationsAdapter chatInputApplicationsAdapter = new ChatInputApplicationsAdapter();
        this.categoriesAdapter = chatInputApplicationsAdapter;
        chatInputApplicationsAdapter.setOnClickApplication(new C77804());
        RecyclerView.LayoutManager selfHealingLinearLayoutManager = new SelfHealingLinearLayoutManager(recyclerView2, chatInputApplicationsAdapter, 0, false, 8, null);
        recyclerView2.setAdapter(chatInputApplicationsAdapter);
        recyclerView2.setLayoutManager(selfHealingLinearLayoutManager);
        recyclerView2.setItemAnimator(null);
        chatInputAutocompleteAdapter.setOnItemSelected(new C77815());
        recyclerView.setAdapter(chatInputAutocompleteAdapter);
        recyclerView.setItemAnimator(null);
        recyclerView.setBackgroundColor(ColorCompat.getThemedColor(flexEditText, C5419R.attr.colorBackgroundSecondary));
        WidgetChatInputAutocompleteStickerAdapter widgetChatInputAutocompleteStickerAdapter = (WidgetChatInputAutocompleteStickerAdapter) MGRecyclerAdapter.INSTANCE.configure(new WidgetChatInputAutocompleteStickerAdapter(recyclerView3, new C77826()));
        this.stickersAdapter = widgetChatInputAutocompleteStickerAdapter;
        recyclerView3.setLayoutManager(new SelfHealingLinearLayoutManager(recyclerView3, widgetChatInputAutocompleteStickerAdapter, 0, false, 8, null));
        recyclerView3.setAdapter(widgetChatInputAutocompleteStickerAdapter);
        RecyclerView recyclerView4 = widgetChatInputApplicationCommandsBinding.f16086c;
        C12238m.checkNotNullExpressionValue(recyclerView4, "selectedApplicationComma…plicationCommandsRecycler");
        SelectedApplicationCommandAdapter selectedApplicationCommandAdapter = new SelectedApplicationCommandAdapter(recyclerView4, new C77837());
        this.selectedApplicationCommandAdapter = selectedApplicationCommandAdapter;
        selectedApplicationCommandAdapter.getRecycler().setLayoutManager(new SelfHealingLinearLayoutManager(selectedApplicationCommandAdapter.getRecycler(), selectedApplicationCommandAdapter, 0, false, 8, null));
        selectedApplicationCommandAdapter.getRecycler().setAdapter(selectedApplicationCommandAdapter);
        selectedApplicationCommandAdapter.getRecycler().setItemAnimator(null);
    }

    private final void applyEditTextAction(InputEditTextAction action) {
        if (!C12238m.areEqual(this.editText.getEditableText().toString(), action.getAssumedInput().toString())) {
            return;
        }
        if (action instanceof InputEditTextAction.ClearSpans) {
            Editable editableText = this.editText.getEditableText();
            C12238m.checkNotNullExpressionValue(editableText, "editText.editableText");
            removeSpans$default(this, editableText, null, 2, null);
            Editable editableText2 = this.editText.getEditableText();
            C12238m.checkNotNullExpressionValue(editableText2, "editText.editableText");
            removePillSpans(editableText2);
            return;
        }
        if (action instanceof InputEditTextAction.ReplaceCharacterStyleSpans) {
            Editable editableText3 = this.editText.getEditableText();
            C12238m.checkNotNullExpressionValue(editableText3, "editText.editableText");
            removeSpans$default(this, editableText3, null, 2, null);
            for (Map.Entry<IntRange, List<CharacterStyle>> entry : ((InputEditTextAction.ReplaceCharacterStyleSpans) action).getSpans().entrySet()) {
                IntRange key = entry.getKey();
                Iterator<T> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    this.editText.getEditableText().setSpan((CharacterStyle) it.next(), key.getFirst(), key.getLast(), 33);
                }
            }
            return;
        }
        if (action instanceof InputEditTextAction.InsertText) {
            InputEditTextAction.InsertText insertText = (InputEditTextAction.InsertText) action;
            this.editText.getEditableText().replace(insertText.getInsertRange().getFirst(), insertText.getInsertRange().getLast(), insertText.getToAppend());
            this.editText.setSelection(Math.min(insertText.getSelectionIndex(), this.editText.getEditableText().length()));
            return;
        }
        if (action instanceof InputEditTextAction.RemoveText) {
            InputEditTextAction.RemoveText removeText = (InputEditTextAction.RemoveText) action;
            this.editText.getEditableText().replace(removeText.getRange().getFirst(), removeText.getRange().getLast(), "");
            this.editText.setSelection(removeText.getSelectionIndex());
            return;
        }
        if (!(action instanceof InputEditTextAction.ReplacePillSpans)) {
            if (action instanceof InputEditTextAction.SelectText) {
                InputEditTextAction.SelectText selectText = (InputEditTextAction.SelectText) action;
                this.editText.setSelection(selectText.getSelection().getFirst(), selectText.getSelection().getLast());
                return;
            } else {
                if (!(action instanceof InputEditTextAction.ReplaceText)) {
                    boolean z2 = action instanceof InputEditTextAction.None;
                    return;
                }
                InputEditTextAction.ReplaceText replaceText = (InputEditTextAction.ReplaceText) action;
                this.editText.setText(replaceText.getNewText());
                this.editText.setSelection(replaceText.getSelectionIndex());
                return;
            }
        }
        Editable editableText4 = this.editText.getEditableText();
        C12238m.checkNotNullExpressionValue(editableText4, "editText.editableText");
        removePillSpans(editableText4);
        for (Map.Entry<IntRange, List<CharacterStyle>> entry2 : ((InputEditTextAction.ReplacePillSpans) action).getSpans().entrySet()) {
            IntRange key2 = entry2.getKey();
            Iterator<T> it2 = entry2.getValue().iterator();
            while (it2.hasNext()) {
                this.editText.getEditableText().setSpan((CharacterStyle) it2.next(), key2.getFirst(), key2.getLast(), 33);
            }
        }
    }

    private final void configureAutocomplete(AutocompleteViewState autocompleteViewState) {
        if (autocompleteViewState instanceof AutocompleteViewState.Autocomplete) {
            configureAutocompleteBrowser((AutocompleteViewState.Autocomplete) autocompleteViewState);
        } else if (autocompleteViewState instanceof AutocompleteViewState.CommandBrowser) {
            configureCommandBrowser((AutocompleteViewState.CommandBrowser) autocompleteViewState);
        } else if (C12238m.areEqual(autocompleteViewState, AutocompleteViewState.Hidden.INSTANCE)) {
            hideAutocomplete();
        }
        if (!(autocompleteViewState instanceof AutocompleteViewState.CommandBrowser)) {
            this.commandBrowserOpen = false;
        }
        StoreStream.INSTANCE.getAutocomplete().setAutocompleteVisible(!(autocompleteViewState instanceof AutocompleteViewState.Hidden));
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00e6  */
    private final void configureAutocompleteBrowser(AutocompleteViewState.Autocomplete autocomplete) {
        List<Autocompletable> autocompletables;
        boolean z2 = !autocomplete.getStickers().isEmpty();
        if (!(this.autocompleteRecyclerView.getVisibility() == 0)) {
            this.autocompleteRecyclerView.setVisibility(0);
        }
        if (this.commandBrowserAppsRecyclerView.getVisibility() == 0) {
            this.commandBrowserAppsRecyclerView.setVisibility(8);
        }
        if (C12103t.startsWith$default(autocomplete.getToken(), String.valueOf(LeadingIdentifier.EMOJI_AND_STICKERS.getIdentifier()), false, 2, null) && (!autocomplete.getAutocompletables().isEmpty())) {
            this.autocompleteHeader.setVisibility(0);
            TextView textView = this.autocompleteHeader;
            textView.setText(C1107b.m212d(textView, C5419R.string.emoji_matching, new Object[]{autocomplete.getToken()}, (4 & 4) != 0 ? C1107b.c.f1492j : null));
        } else {
            this.autocompleteHeader.setVisibility(8);
        }
        this.autocompleteHeader.setTextColor(ColorCompat.getThemedColor(this.autocompleteHeader, C5419R.attr.colorTextNormal));
        if (autocomplete.isAutocomplete()) {
            this.autocompleteHeader.setVisibility(C12103t.isBlank(autocomplete.getToken()) ^ true ? 0 : 8);
            if (autocomplete.isError()) {
                TextView textView2 = this.autocompleteHeader;
                textView2.setText(C1107b.m212d(textView2, C5419R.string.application_command_autocomplete_failed, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null));
                this.autocompleteHeader.setTextColor(ColorCompat.getThemedColor(this.autocompleteHeader, C5419R.attr.colorTextDanger));
            } else if (autocomplete.isLoading()) {
                TextView textView3 = this.autocompleteHeader;
                textView3.setText(C1107b.m212d(textView3, C5419R.string.options_matching, new Object[]{autocomplete.getToken()}, (4 & 4) != 0 ? C1107b.c.f1492j : null));
            } else {
                List<Autocompletable> autocompletables2 = autocomplete.getAutocompletables();
                if (autocompletables2 == null || autocompletables2.isEmpty()) {
                    TextView textView4 = this.autocompleteHeader;
                    textView4.setText(C1107b.m212d(textView4, C5419R.string.application_command_autocomplete_no_options, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null));
                } else {
                    TextView textView5 = this.autocompleteHeader;
                    textView5.setText(C1107b.m212d(textView5, C5419R.string.options_matching, new Object[]{autocomplete.getToken()}, (4 & 4) != 0 ? C1107b.c.f1492j : null));
                }
            }
        }
        this.autocompleteAdapter.setVisiblePositionListener(new C77841());
        getViewModel().onAutocompleteItemsUpdated();
        if (!autocomplete.isLoading() || autocomplete.isError()) {
            autocompletables = autocomplete.getAutocompletables();
        } else {
            autocompletables = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                autocompletables.add(new ApplicationCommandLoadingPlaceholder(null, 1, null));
            }
        }
        ChatInputAutocompleteAdapter.setData$default(this.autocompleteAdapter, autocompletables, z2, false, 4, null);
        this.stickersRecyclerView.setVisibility(z2 ? 0 : 8);
        this.stickersContainer.setVisibility(z2 ? 0 : 8);
        if (z2) {
            TextView textView6 = this.stickerHeader;
            textView6.setText(C1107b.m212d(textView6, C5419R.string.stickers_matching, new Object[]{C12103t.replace$default(autocomplete.getToken(), String.valueOf(LeadingIdentifier.EMOJI_AND_STICKERS.getIdentifier()), "", false, 4, (Object) null)}, (4 & 4) != 0 ? C1107b.c.f1492j : null));
            this.stickersAdapter.setData(autocomplete.getStickers());
        }
    }

    private final void configureCommandBrowser(AutocompleteViewState.CommandBrowser browser) {
        this.autocompleteHeader.setVisibility(8);
        this.stickersContainer.setVisibility(8);
        List<Autocompletable> flattenCommandsModel = browser.getDiscoverCommands().getFlattenCommandsModel();
        boolean z2 = (flattenCommandsModel.isEmpty() ^ true) || browser.getDiscoverCommands().getLoadState().isLoading();
        if (!this.commandBrowserOpen && z2) {
            this.commandBrowserOpen = true;
            StoreStream.Companion companion = StoreStream.INSTANCE;
            companion.getAnalytics().trackApplicationCommandBrowserOpened(companion.getChannelsSelected().getId());
        }
        if ((this.autocompleteRecyclerView.getVisibility() == 0) != z2) {
            this.autocompleteRecyclerView.setVisibility(z2 ? 0 : 8);
        }
        boolean z3 = browser.getApplications().size() > 1;
        if ((this.commandBrowserAppsRecyclerView.getVisibility() == 0) != z3) {
            this.commandBrowserAppsRecyclerView.setVisibility(z3 ? 0 : 8);
            if (z3) {
                this.categoriesAdapter.selectApplication(0L);
                this.commandBrowserAppsRecyclerView.smoothScrollToPosition(0);
            }
        }
        this.categoriesAdapter.setApplicationData(browser.getApplications());
        this.autocompleteAdapter.setVisiblePositionListener(new C77851());
        if (this.autocompleteAdapter.getPageSize() > 3 && (browser.getDiscoverCommands().getLoadState() instanceof LoadState.JustLoadedUp)) {
            RecyclerView recyclerView = this.autocompleteRecyclerView;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0));
            View childAt = this.autocompleteRecyclerView.getChildAt(0);
            C12238m.checkNotNullExpressionValue(childAt, "autocompleteRecyclerView.getChildAt(0)");
            this.autocompleteAdapter.scrollToPosition((flattenCommandsModel.size() - this.autocompleteAdapter.getPageSize()) + childAdapterPosition, childAt.getTop(), false);
        }
        if ((!flattenCommandsModel.isEmpty()) && this.autocompleteAdapter.getPageSize() == 4 && (this.autocompleteAdapter.getItem(0) instanceof ApplicationCommandLoadingPlaceholder) && (this.autocompleteAdapter.getItem(3) instanceof ApplicationCommandLoadingPlaceholder) && (flattenCommandsModel.get(0) instanceof ApplicationCommandLoadingPlaceholder)) {
            this.autocompleteAdapter.scrollToPosition(3, 0, false);
        }
        ChatInputAutocompleteAdapter chatInputAutocompleteAdapter = this.autocompleteAdapter;
        if (browser.getDiscoverCommands().getLoadState() instanceof LoadState.Loading) {
            flattenCommandsModel = new ArrayList<>();
            int iCount = C12163u.count(new IntRange(1, 4));
            for (int i = 0; i < iCount; i++) {
                flattenCommandsModel.add(new ApplicationCommandLoadingPlaceholder(null, 1, null));
            }
        }
        chatInputAutocompleteAdapter.setData(flattenCommandsModel, false, browser.getDiscoverCommands().getLoadState() instanceof LoadState.Loading);
    }

    private final void configureSelectedCommand(SelectedCommandViewState selectedCommandViewState) {
        if (C12238m.areEqual(selectedCommandViewState, SelectedCommandViewState.Hidden.INSTANCE)) {
            hideSelectedCommand();
        } else if (selectedCommandViewState instanceof SelectedCommandViewState.SelectedCommand) {
            configureSelectedCommand((SelectedCommandViewState.SelectedCommand) selectedCommandViewState);
        }
    }

    private final void configureUI(ViewState viewState) {
        configureAutocomplete(viewState.getAutocompleteViewState());
        configureSelectedCommand(viewState.getSelectedCommandViewState());
    }

    public static /* synthetic */ ApplicationCommandData getApplicationCommandData$default(InputAutocomplete inputAutocomplete, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
        if ((i & 1) != 0) {
            applicationCommandOption = null;
        }
        return inputAutocomplete.getApplicationCommandData(applicationCommandOption);
    }

    private final Long getCurrentlySelectedCategory(int topPosition) {
        Application application;
        ChatInputAutocompleteAdapter chatInputAutocompleteAdapter = this.autocompleteAdapter;
        Integer headerPositionForItem = chatInputAutocompleteAdapter.getHeaderPositionForItem(topPosition);
        Autocompletable item = chatInputAutocompleteAdapter.getItem(headerPositionForItem != null ? headerPositionForItem.intValue() : 0);
        if (!(item instanceof ApplicationPlaceholder)) {
            item = null;
        }
        ApplicationPlaceholder applicationPlaceholder = (ApplicationPlaceholder) item;
        if (applicationPlaceholder == null || (application = applicationPlaceholder.getApplication()) == null) {
            return null;
        }
        return Long.valueOf(application.getId());
    }

    private final AutocompleteViewModel getViewModel() {
        return (AutocompleteViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleEvent(Event event) {
        if (event instanceof Event.ScrollAutocompletablesToApplication) {
            Event.ScrollAutocompletablesToApplication scrollAutocompletablesToApplication = (Event.ScrollAutocompletablesToApplication) event;
            ChatInputAutocompleteAdapter.scrollToPosition$default(this.autocompleteAdapter, scrollAutocompletablesToApplication.getTargetPosition(), 0, false, 6, null);
            this.categoriesAdapter.selectApplication(scrollAutocompletablesToApplication.getApplicationId());
            if (this.categoriesAdapter.getPositionOfApplication(scrollAutocompletablesToApplication.getApplicationId()) != -1) {
                this.commandBrowserAppsRecyclerView.smoothScrollToPosition(this.categoriesAdapter.getPositionOfApplication(scrollAutocompletablesToApplication.getApplicationId()));
                return;
            }
            return;
        }
        if (event instanceof Event.RequestAutocompleteData) {
            Function1<? super ApplicationCommandOption, Unit> function1 = this.onPerformCommandAutocomplete;
            if (function1 != null) {
                function1.invoke(((Event.RequestAutocompleteData) event).getOption());
                return;
            }
            return;
        }
        if (event instanceof Event.PickAttachment) {
            this.flexInputViewModel.onGalleryButtonClicked();
            return;
        }
        if (event instanceof Event.PreviewAttachment) {
            C4628h.m6424r(this.flexInputFragment.requireContext(), this.flexInputFragment.m9293l());
            AttachmentBottomSheet.Companion companion = AttachmentBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = this.flexInputFragment.getChildFragmentManager();
            C12238m.checkNotNullExpressionValue(childFragmentManager, "flexInputFragment.childFragmentManager");
            Attachment<?> attachment = ((Event.PreviewAttachment) event).getAttachment();
            Objects.requireNonNull(attachment, "null cannot be cast to non-null type com.lytefast.flexinput.model.Attachment<kotlin.Any>");
            companion.show(childFragmentManager, attachment, new C77861(event), new C77872(event), new C77883());
        }
    }

    private final void hideAutocomplete() {
        this.autocompleteRecyclerView.setVisibility(8);
        this.commandBrowserAppsRecyclerView.setVisibility(8);
        this.stickersContainer.setVisibility(8);
        this.autocompleteHeader.setVisibility(8);
    }

    private final void hideSelectedCommand() {
        this.flexInputViewModel.setModeSingleSelect(false);
        this.flexInputViewModel.setAttachmentViewEnabled(true);
        ConstraintLayout constraintLayout = this.selectedApplicationCommandUiBinding.f16084a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "selectedApplicationCommandUiBinding.root");
        constraintLayout.setVisibility(8);
    }

    private final void removePillSpans(Spannable spannable) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (obj instanceof SimpleRoundedBackgroundSpan) {
                spannable.removeSpan(obj);
            }
        }
    }

    private final void removeSpans(Spannable spannable, IntRange spanRange) {
        for (Object obj : spannable.getSpans(spanRange.getFirst(), spanRange.getLast(), Object.class)) {
            if ((obj instanceof CharacterStyle) && !(obj instanceof SimpleRoundedBackgroundSpan)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static /* synthetic */ void removeSpans$default(InputAutocomplete inputAutocomplete, Spannable spannable, IntRange intRange, int i, Object obj) {
        if ((i & 2) != 0) {
            intRange = new IntRange(0, spannable.length());
        }
        inputAutocomplete.removeSpans(spannable, intRange);
    }

    public final ApplicationCommandData getApplicationCommandData(ApplicationCommandOption focusedOption) {
        return getViewModel().getApplicationSendData(focusedOption);
    }

    public final Map<ApplicationCommandOption, Attachment<?>> getCommandAttachments() {
        return getViewModel().getCommandAttachments();
    }

    public final MessageContent getInputContent() {
        WidgetChatInputEditText.Companion companion = WidgetChatInputEditText.INSTANCE;
        String stringSafe = companion.toStringSafe(this.editText);
        String stringSafe2 = companion.toStringSafe(this.editText);
        int length = stringSafe2.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = C12238m.compare(stringSafe2.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                }
                length--;
            } else if (z3) {
                i++;
            } else {
                z2 = true;
            }
        }
        String string = stringSafe2.subSequence(i, length + 1).toString();
        return !TextUtils.isEmpty(string) ? getViewModel().replaceAutocompletableDataWithServerValues(stringSafe) : new MessageContent(string, C12147n.emptyList());
    }

    public final Function1<ApplicationCommandOption, Unit> getOnPerformCommandAutocomplete() {
        return this.onPerformCommandAutocomplete;
    }

    public final void onCommandInputsSendError() {
        getViewModel().onApplicationCommandSendError();
    }

    public final void onViewBoundOrOnResume() {
        this.autocompleteAdapter.configureSubscriptions(this.fragment);
        Observable<ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11112r, this.fragment, null, 2, null), (Class<?>) InputAutocomplete.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C77891(this));
        Observable<InputEditTextAction> observableM11112r2 = getViewModel().observeEditTextActions().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r2, "viewModel.observeEditTex…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11112r2, this.fragment, null, 2, null), (Class<?>) InputAutocomplete.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C77902());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getViewModel().observeEvents(), this.fragment, null, 2, null), (Class<?>) InputAutocomplete.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C77913(this));
    }

    public final void setOnPerformCommandAutocomplete(Function1<? super ApplicationCommandOption, Unit> function1) {
        this.onPerformCommandAutocomplete = function1;
    }

    private final void configureSelectedCommand(SelectedCommandViewState.SelectedCommand viewState) {
        this.flexInputViewModel.setModeSingleSelect(true);
        this.flexInputViewModel.setAttachmentViewEnabled(false);
        ConstraintLayout constraintLayout = this.selectedApplicationCommandUiBinding.f16084a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "selectedApplicationCommandUiBinding.root");
        constraintLayout.setVisibility(0);
        this.selectedApplicationCommandAdapter.clear();
        this.selectedApplicationCommandAdapter.setApplicationCommand(viewState.getSelectedCommand(), viewState.getSelectedApplication());
        ApplicationCommandOption selectedCommandOption = viewState.getSelectedCommandOption();
        if (selectedCommandOption != null) {
            if (viewState.getSelectedCommandOptionErrors().contains(selectedCommandOption)) {
                TextView textView = this.selectedApplicationCommandUiBinding.f16085b;
                C12238m.checkNotNullExpressionValue(textView, "selectedApplicationComma…CommandsOptionDescription");
                Resources resources = this.editText.getResources();
                C12238m.checkNotNullExpressionValue(resources, "editText.resources");
                textView.setText(StoreApplicationCommandsKt.getErrorText(selectedCommandOption, resources));
                WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding = this.selectedApplicationCommandUiBinding;
                TextView textView2 = widgetChatInputApplicationCommandsBinding.f16085b;
                ConstraintLayout constraintLayout2 = widgetChatInputApplicationCommandsBinding.f16084a;
                C12238m.checkNotNullExpressionValue(constraintLayout2, "selectedApplicationCommandUiBinding.root");
                textView2.setTextColor(ColorCompat.getColor(constraintLayout2.getContext(), C5419R.color.status_red_500));
            } else {
                TextView textView3 = this.selectedApplicationCommandUiBinding.f16085b;
                C12238m.checkNotNullExpressionValue(textView3, "selectedApplicationComma…CommandsOptionDescription");
                Resources resources2 = this.editText.getResources();
                C12238m.checkNotNullExpressionValue(resources2, "editText.resources");
                textView3.setText(StoreApplicationCommandsKt.getDescriptionText(selectedCommandOption, resources2));
                this.selectedApplicationCommandUiBinding.f16085b.setTextColor(ColorCompat.getThemedColor(this.editText.getContext(), C5419R.attr.colorTextNormal));
            }
            this.selectedApplicationCommandAdapter.highlightOption(selectedCommandOption);
        } else {
            TextView textView4 = this.selectedApplicationCommandUiBinding.f16085b;
            C12238m.checkNotNullExpressionValue(textView4, "selectedApplicationComma…CommandsOptionDescription");
            ApplicationCommand selectedCommand = viewState.getSelectedCommand();
            Resources resources3 = this.editText.getResources();
            C12238m.checkNotNullExpressionValue(resources3, "editText.resources");
            textView4.setText(StoreApplicationCommandsKt.getDescriptionText(selectedCommand, resources3));
            this.selectedApplicationCommandUiBinding.f16085b.setTextColor(ColorCompat.getThemedColor(this.editText.getContext(), C5419R.attr.colorTextNormal));
            this.selectedApplicationCommandAdapter.clearParamOptionHighlight();
        }
        this.selectedApplicationCommandAdapter.setVerified(viewState.getValidSelectedCommandOptions(), viewState.getSelectedCommandOptionErrors());
    }

    public /* synthetic */ InputAutocomplete(AppFragment appFragment, FlexInputFragment flexInputFragment, AppFlexInputViewModel appFlexInputViewModel, FlexEditText flexEditText, Long l, TextView textView, RecyclerView recyclerView, RecyclerView recyclerView2, View view, RecyclerView recyclerView3, TextView textView2, WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appFragment, flexInputFragment, appFlexInputViewModel, flexEditText, (i & 16) != 0 ? null : l, textView, recyclerView, recyclerView2, view, recyclerView3, textView2, widgetChatInputApplicationCommandsBinding);
    }
}
