package com.discord.widgets.chat.input.autocomplete;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.i.c.m.d.k.h;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatInputApplicationCommandsBinding;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.stores.LoadState$JustLoadedUp;
import com.discord.stores.LoadState$Loading;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.ChatInputApplicationsAdapter;
import com.discord.widgets.chat.input.WidgetChatInputAutocompleteStickerAdapter;
import com.discord.widgets.chat.input.WidgetChatInputEditText;
import com.discord.widgets.chat.input.WidgetChatInputEditText$Companion;
import com.discord.widgets.chat.input.applicationcommands.SelectedApplicationCommandAdapter;
import com.discord.widgets.chat.input.attachments.AttachmentBottomSheet;
import com.discord.widgets.chat.input.attachments.AttachmentBottomSheet$Companion;
import com.discord.widgets.chat.input.autocomplete.adapter.ChatInputAutocompleteAdapter;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.g0.t;
import d0.t.n;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import rx.Observable;

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

    public InputAutocomplete(AppFragment appFragment, FlexInputFragment flexInputFragment, AppFlexInputViewModel appFlexInputViewModel, FlexEditText flexEditText, Long l, TextView textView, RecyclerView recyclerView, RecyclerView recyclerView2, View view, RecyclerView recyclerView3, TextView textView2, WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding) {
        m.checkNotNullParameter(appFragment, "fragment");
        m.checkNotNullParameter(flexInputFragment, "flexInputFragment");
        m.checkNotNullParameter(appFlexInputViewModel, "flexInputViewModel");
        m.checkNotNullParameter(flexEditText, "editText");
        m.checkNotNullParameter(textView, "autocompleteHeader");
        m.checkNotNullParameter(recyclerView, "autocompleteRecyclerView");
        m.checkNotNullParameter(recyclerView2, "commandBrowserAppsRecyclerView");
        m.checkNotNullParameter(view, "stickersContainer");
        m.checkNotNullParameter(recyclerView3, "stickersRecyclerView");
        m.checkNotNullParameter(textView2, "stickerHeader");
        m.checkNotNullParameter(widgetChatInputApplicationCommandsBinding, "selectedApplicationCommandUiBinding");
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
        g0 g0Var = new g0(appFragment);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(appFragment, a0.getOrCreateKotlinClass(AutocompleteViewModel.class), new InputAutocomplete$appViewModels$$inlined$viewModels$1(g0Var), new i0(inputAutocomplete$viewModel$2));
        appFlexInputViewModel.setAttachmentSelectedListener(new InputAutocomplete$1(this));
        flexEditText.addTextChangedListener(new InputAutocomplete$2(this));
        flexEditText.setOnSelectionChangedListener(new InputAutocomplete$3(this));
        ChatInputApplicationsAdapter chatInputApplicationsAdapter = new ChatInputApplicationsAdapter();
        this.categoriesAdapter = chatInputApplicationsAdapter;
        chatInputApplicationsAdapter.setOnClickApplication(new InputAutocomplete$4(this));
        RecyclerView$LayoutManager selfHealingLinearLayoutManager = new SelfHealingLinearLayoutManager(recyclerView2, chatInputApplicationsAdapter, 0, false, 8, null);
        recyclerView2.setAdapter(chatInputApplicationsAdapter);
        recyclerView2.setLayoutManager(selfHealingLinearLayoutManager);
        recyclerView2.setItemAnimator(null);
        chatInputAutocompleteAdapter.setOnItemSelected(new InputAutocomplete$5(this));
        recyclerView.setAdapter(chatInputAutocompleteAdapter);
        recyclerView.setItemAnimator(null);
        recyclerView.setBackgroundColor(ColorCompat.getThemedColor(flexEditText, 2130968912));
        WidgetChatInputAutocompleteStickerAdapter widgetChatInputAutocompleteStickerAdapter = (WidgetChatInputAutocompleteStickerAdapter) MGRecyclerAdapter.Companion.configure(new WidgetChatInputAutocompleteStickerAdapter(recyclerView3, new InputAutocomplete$6(this)));
        this.stickersAdapter = widgetChatInputAutocompleteStickerAdapter;
        recyclerView3.setLayoutManager(new SelfHealingLinearLayoutManager(recyclerView3, widgetChatInputAutocompleteStickerAdapter, 0, false, 8, null));
        recyclerView3.setAdapter(widgetChatInputAutocompleteStickerAdapter);
        RecyclerView recyclerView4 = widgetChatInputApplicationCommandsBinding.c;
        m.checkNotNullExpressionValue(recyclerView4, "selectedApplicationComma…plicationCommandsRecycler");
        SelectedApplicationCommandAdapter selectedApplicationCommandAdapter = new SelectedApplicationCommandAdapter(recyclerView4, new InputAutocomplete$7(this));
        this.selectedApplicationCommandAdapter = selectedApplicationCommandAdapter;
        selectedApplicationCommandAdapter.getRecycler().setLayoutManager(new SelfHealingLinearLayoutManager(selectedApplicationCommandAdapter.getRecycler(), selectedApplicationCommandAdapter, 0, false, 8, null));
        selectedApplicationCommandAdapter.getRecycler().setAdapter(selectedApplicationCommandAdapter);
        selectedApplicationCommandAdapter.getRecycler().setItemAnimator(null);
    }

    public static final /* synthetic */ void access$applyEditTextAction(InputAutocomplete inputAutocomplete, InputEditTextAction inputEditTextAction) {
        inputAutocomplete.applyEditTextAction(inputEditTextAction);
    }

    public static final /* synthetic */ void access$configureUI(InputAutocomplete inputAutocomplete, ViewState viewState) {
        inputAutocomplete.configureUI(viewState);
    }

    public static final /* synthetic */ ChatInputAutocompleteAdapter access$getAutocompleteAdapter$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.autocompleteAdapter;
    }

    public static final /* synthetic */ ChatInputApplicationsAdapter access$getCategoriesAdapter$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.categoriesAdapter;
    }

    public static final /* synthetic */ Long access$getChannel$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.channel;
    }

    public static final /* synthetic */ RecyclerView access$getCommandBrowserAppsRecyclerView$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.commandBrowserAppsRecyclerView;
    }

    public static final /* synthetic */ Long access$getCurrentlySelectedCategory(InputAutocomplete inputAutocomplete, int i) {
        return inputAutocomplete.getCurrentlySelectedCategory(i);
    }

    public static final /* synthetic */ FlexEditText access$getEditText$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.editText;
    }

    public static final /* synthetic */ AppFlexInputViewModel access$getFlexInputViewModel$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.flexInputViewModel;
    }

    public static final /* synthetic */ AppFragment access$getFragment$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.fragment;
    }

    public static final /* synthetic */ AutocompleteViewModel access$getViewModel$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(InputAutocomplete inputAutocomplete, Event event) {
        inputAutocomplete.handleEvent(event);
    }

    private final void applyEditTextAction(InputEditTextAction action) {
        if (!m.areEqual(this.editText.getEditableText().toString(), action.getAssumedInput().toString())) {
            return;
        }
        if (action instanceof InputEditTextAction$ClearSpans) {
            Editable editableText = this.editText.getEditableText();
            m.checkNotNullExpressionValue(editableText, "editText.editableText");
            removeSpans$default(this, editableText, null, 2, null);
            Editable editableText2 = this.editText.getEditableText();
            m.checkNotNullExpressionValue(editableText2, "editText.editableText");
            removePillSpans(editableText2);
            return;
        }
        if (action instanceof InputEditTextAction$ReplaceCharacterStyleSpans) {
            Editable editableText3 = this.editText.getEditableText();
            m.checkNotNullExpressionValue(editableText3, "editText.editableText");
            removeSpans$default(this, editableText3, null, 2, null);
            for (Map$Entry<IntRange, List<CharacterStyle>> map$Entry : ((InputEditTextAction$ReplaceCharacterStyleSpans) action).getSpans().entrySet()) {
                IntRange key = map$Entry.getKey();
                Iterator<T> it = map$Entry.getValue().iterator();
                while (it.hasNext()) {
                    this.editText.getEditableText().setSpan((CharacterStyle) it.next(), key.getFirst(), key.getLast(), 33);
                }
            }
            return;
        }
        if (action instanceof InputEditTextAction$InsertText) {
            InputEditTextAction$InsertText inputEditTextAction$InsertText = (InputEditTextAction$InsertText) action;
            this.editText.getEditableText().replace(inputEditTextAction$InsertText.getInsertRange().getFirst(), inputEditTextAction$InsertText.getInsertRange().getLast(), inputEditTextAction$InsertText.getToAppend());
            this.editText.setSelection(Math.min(inputEditTextAction$InsertText.getSelectionIndex(), this.editText.getEditableText().length()));
            return;
        }
        if (action instanceof InputEditTextAction$RemoveText) {
            InputEditTextAction$RemoveText inputEditTextAction$RemoveText = (InputEditTextAction$RemoveText) action;
            this.editText.getEditableText().replace(inputEditTextAction$RemoveText.getRange().getFirst(), inputEditTextAction$RemoveText.getRange().getLast(), "");
            this.editText.setSelection(inputEditTextAction$RemoveText.getSelectionIndex());
            return;
        }
        if (!(action instanceof InputEditTextAction$ReplacePillSpans)) {
            if (action instanceof InputEditTextAction$SelectText) {
                InputEditTextAction$SelectText inputEditTextAction$SelectText = (InputEditTextAction$SelectText) action;
                this.editText.setSelection(inputEditTextAction$SelectText.getSelection().getFirst(), inputEditTextAction$SelectText.getSelection().getLast());
                return;
            } else {
                if (!(action instanceof InputEditTextAction$ReplaceText)) {
                    boolean z2 = action instanceof InputEditTextAction$None;
                    return;
                }
                InputEditTextAction$ReplaceText inputEditTextAction$ReplaceText = (InputEditTextAction$ReplaceText) action;
                this.editText.setText(inputEditTextAction$ReplaceText.getNewText());
                this.editText.setSelection(inputEditTextAction$ReplaceText.getSelectionIndex());
                return;
            }
        }
        Editable editableText4 = this.editText.getEditableText();
        m.checkNotNullExpressionValue(editableText4, "editText.editableText");
        removePillSpans(editableText4);
        for (Map$Entry<IntRange, List<CharacterStyle>> map$Entry2 : ((InputEditTextAction$ReplacePillSpans) action).getSpans().entrySet()) {
            IntRange key2 = map$Entry2.getKey();
            Iterator<T> it2 = map$Entry2.getValue().iterator();
            while (it2.hasNext()) {
                this.editText.getEditableText().setSpan((CharacterStyle) it2.next(), key2.getFirst(), key2.getLast(), 33);
            }
        }
    }

    private final void configureAutocomplete(AutocompleteViewState autocompleteViewState) {
        if (autocompleteViewState instanceof AutocompleteViewState$Autocomplete) {
            configureAutocompleteBrowser((AutocompleteViewState$Autocomplete) autocompleteViewState);
        } else if (autocompleteViewState instanceof AutocompleteViewState$CommandBrowser) {
            configureCommandBrowser((AutocompleteViewState$CommandBrowser) autocompleteViewState);
        } else if (m.areEqual(autocompleteViewState, AutocompleteViewState$Hidden.INSTANCE)) {
            hideAutocomplete();
        }
        if (!(autocompleteViewState instanceof AutocompleteViewState$CommandBrowser)) {
            this.commandBrowserOpen = false;
        }
        StoreStream.Companion.getAutocomplete().setAutocompleteVisible(!(autocompleteViewState instanceof AutocompleteViewState$Hidden));
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00e6  */
    private final void configureAutocompleteBrowser(AutocompleteViewState$Autocomplete autocomplete) {
        List<Autocompletable> autocompletables;
        boolean z2 = !autocomplete.getStickers().isEmpty();
        if (!(this.autocompleteRecyclerView.getVisibility() == 0)) {
            this.autocompleteRecyclerView.setVisibility(0);
        }
        if (this.commandBrowserAppsRecyclerView.getVisibility() == 0) {
            this.commandBrowserAppsRecyclerView.setVisibility(8);
        }
        if (t.startsWith$default(autocomplete.getToken(), String.valueOf(LeadingIdentifier.EMOJI_AND_STICKERS.getIdentifier()), false, 2, null) && (!autocomplete.getAutocompletables().isEmpty())) {
            this.autocompleteHeader.setVisibility(0);
            TextView textView = this.autocompleteHeader;
            textView.setText(b.j(textView, 2131888768, new Object[]{autocomplete.getToken()}, null, 4));
        } else {
            this.autocompleteHeader.setVisibility(8);
        }
        this.autocompleteHeader.setTextColor(ColorCompat.getThemedColor(this.autocompleteHeader, 2130969057));
        if (autocomplete.isAutocomplete()) {
            this.autocompleteHeader.setVisibility(t.isBlank(autocomplete.getToken()) ^ true ? 0 : 8);
            if (autocomplete.isError()) {
                TextView textView2 = this.autocompleteHeader;
                textView2.setText(b.j(textView2, 2131886508, new Object[0], null, 4));
                this.autocompleteHeader.setTextColor(ColorCompat.getThemedColor(this.autocompleteHeader, 2130969053));
            } else if (autocomplete.isLoading()) {
                TextView textView3 = this.autocompleteHeader;
                textView3.setText(b.j(textView3, 2131893532, new Object[]{autocomplete.getToken()}, null, 4));
            } else {
                List<Autocompletable> autocompletables2 = autocomplete.getAutocompletables();
                if (autocompletables2 == null || autocompletables2.isEmpty()) {
                    TextView textView4 = this.autocompleteHeader;
                    textView4.setText(b.j(textView4, 2131886509, new Object[0], null, 4));
                } else {
                    TextView textView5 = this.autocompleteHeader;
                    textView5.setText(b.j(textView5, 2131893532, new Object[]{autocomplete.getToken()}, null, 4));
                }
            }
        }
        this.autocompleteAdapter.setVisiblePositionListener(new InputAutocomplete$configureAutocompleteBrowser$1(this));
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
            textView6.setText(b.j(textView6, 2131895994, new Object[]{t.replace$default(autocomplete.getToken(), String.valueOf(LeadingIdentifier.EMOJI_AND_STICKERS.getIdentifier()), "", false, 4, (Object) null)}, null, 4));
            this.stickersAdapter.setData(autocomplete.getStickers());
        }
    }

    private final void configureCommandBrowser(AutocompleteViewState$CommandBrowser browser) {
        this.autocompleteHeader.setVisibility(8);
        this.stickersContainer.setVisibility(8);
        List<Autocompletable> flattenCommandsModel = browser.getDiscoverCommands().getFlattenCommandsModel();
        boolean z2 = (flattenCommandsModel.isEmpty() ^ true) || browser.getDiscoverCommands().getLoadState().isLoading();
        if (!this.commandBrowserOpen && z2) {
            this.commandBrowserOpen = true;
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            storeStream$Companion.getAnalytics().trackApplicationCommandBrowserOpened(storeStream$Companion.getChannelsSelected().getId());
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
        this.autocompleteAdapter.setVisiblePositionListener(new InputAutocomplete$configureCommandBrowser$1(this));
        if (this.autocompleteAdapter.getPageSize() > 3 && (browser.getDiscoverCommands().getLoadState() instanceof LoadState$JustLoadedUp)) {
            RecyclerView recyclerView = this.autocompleteRecyclerView;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0));
            View childAt = this.autocompleteRecyclerView.getChildAt(0);
            m.checkNotNullExpressionValue(childAt, "autocompleteRecyclerView.getChildAt(0)");
            this.autocompleteAdapter.scrollToPosition((flattenCommandsModel.size() - this.autocompleteAdapter.getPageSize()) + childAdapterPosition, childAt.getTop(), false);
        }
        if ((!flattenCommandsModel.isEmpty()) && this.autocompleteAdapter.getPageSize() == 4 && (this.autocompleteAdapter.getItem(0) instanceof ApplicationCommandLoadingPlaceholder) && (this.autocompleteAdapter.getItem(3) instanceof ApplicationCommandLoadingPlaceholder) && (flattenCommandsModel.get(0) instanceof ApplicationCommandLoadingPlaceholder)) {
            this.autocompleteAdapter.scrollToPosition(3, 0, false);
        }
        ChatInputAutocompleteAdapter chatInputAutocompleteAdapter = this.autocompleteAdapter;
        if (browser.getDiscoverCommands().getLoadState() instanceof LoadState$Loading) {
            flattenCommandsModel = new ArrayList<>();
            int iCount = u.count(new IntRange(1, 4));
            for (int i = 0; i < iCount; i++) {
                flattenCommandsModel.add(new ApplicationCommandLoadingPlaceholder(null, 1, null));
            }
        }
        chatInputAutocompleteAdapter.setData(flattenCommandsModel, false, browser.getDiscoverCommands().getLoadState() instanceof LoadState$Loading);
    }

    private final void configureSelectedCommand(SelectedCommandViewState selectedCommandViewState) {
        if (m.areEqual(selectedCommandViewState, SelectedCommandViewState$Hidden.INSTANCE)) {
            hideSelectedCommand();
        } else if (selectedCommandViewState instanceof SelectedCommandViewState$SelectedCommand) {
            configureSelectedCommand((SelectedCommandViewState$SelectedCommand) selectedCommandViewState);
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
        if (event instanceof Event$ScrollAutocompletablesToApplication) {
            Event$ScrollAutocompletablesToApplication event$ScrollAutocompletablesToApplication = (Event$ScrollAutocompletablesToApplication) event;
            ChatInputAutocompleteAdapter.scrollToPosition$default(this.autocompleteAdapter, event$ScrollAutocompletablesToApplication.getTargetPosition(), 0, false, 6, null);
            this.categoriesAdapter.selectApplication(event$ScrollAutocompletablesToApplication.getApplicationId());
            if (this.categoriesAdapter.getPositionOfApplication(event$ScrollAutocompletablesToApplication.getApplicationId()) != -1) {
                this.commandBrowserAppsRecyclerView.smoothScrollToPosition(this.categoriesAdapter.getPositionOfApplication(event$ScrollAutocompletablesToApplication.getApplicationId()));
                return;
            }
            return;
        }
        if (event instanceof Event$RequestAutocompleteData) {
            Function1<? super ApplicationCommandOption, Unit> function1 = this.onPerformCommandAutocomplete;
            if (function1 != null) {
                function1.invoke(((Event$RequestAutocompleteData) event).getOption());
                return;
            }
            return;
        }
        if (event instanceof Event$PickAttachment) {
            this.flexInputViewModel.onGalleryButtonClicked();
            return;
        }
        if (event instanceof Event$PreviewAttachment) {
            h.r(this.flexInputFragment.requireContext(), this.flexInputFragment.l());
            AttachmentBottomSheet$Companion attachmentBottomSheet$Companion = AttachmentBottomSheet.Companion;
            FragmentManager childFragmentManager = this.flexInputFragment.getChildFragmentManager();
            m.checkNotNullExpressionValue(childFragmentManager, "flexInputFragment.childFragmentManager");
            Attachment<?> attachment = ((Event$PreviewAttachment) event).getAttachment();
            Objects.requireNonNull(attachment, "null cannot be cast to non-null type com.lytefast.flexinput.model.Attachment<kotlin.Any>");
            attachmentBottomSheet$Companion.show(childFragmentManager, attachment, new InputAutocomplete$handleEvent$1(this, event), new InputAutocomplete$handleEvent$2(event), new InputAutocomplete$handleEvent$3(this));
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
        ConstraintLayout constraintLayout = this.selectedApplicationCommandUiBinding.a;
        m.checkNotNullExpressionValue(constraintLayout, "selectedApplicationCommandUiBinding.root");
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
        WidgetChatInputEditText$Companion widgetChatInputEditText$Companion = WidgetChatInputEditText.Companion;
        String stringSafe = widgetChatInputEditText$Companion.toStringSafe(this.editText);
        String stringSafe2 = widgetChatInputEditText$Companion.toStringSafe(this.editText);
        int length = stringSafe2.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = m.compare(stringSafe2.charAt(!z2 ? i : length), 32) <= 0;
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
        return !TextUtils.isEmpty(string) ? getViewModel().replaceAutocompletableDataWithServerValues(stringSafe) : new MessageContent(string, n.emptyList());
    }

    public final Function1<ApplicationCommandOption, Unit> getOnPerformCommandAutocomplete() {
        return this.onPerformCommandAutocomplete;
    }

    public final void onCommandInputsSendError() {
        getViewModel().onApplicationCommandSendError();
    }

    public final void onViewBoundOrOnResume() {
        this.autocompleteAdapter.configureSubscriptions(this.fragment);
        Observable<ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this.fragment, null, 2, null), InputAutocomplete.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new InputAutocomplete$onViewBoundOrOnResume$1(this), 62, (Object) null);
        Observable<InputEditTextAction> observableR2 = getViewModel().observeEditTextActions().r();
        m.checkNotNullExpressionValue(observableR2, "viewModel.observeEditTex…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR2, this.fragment, null, 2, null), InputAutocomplete.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new InputAutocomplete$onViewBoundOrOnResume$2(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeEvents(), this.fragment, null, 2, null), InputAutocomplete.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new InputAutocomplete$onViewBoundOrOnResume$3(this), 62, (Object) null);
    }

    public final void setOnPerformCommandAutocomplete(Function1<? super ApplicationCommandOption, Unit> function1) {
        this.onPerformCommandAutocomplete = function1;
    }

    private final void configureSelectedCommand(SelectedCommandViewState$SelectedCommand viewState) {
        this.flexInputViewModel.setModeSingleSelect(true);
        this.flexInputViewModel.setAttachmentViewEnabled(false);
        ConstraintLayout constraintLayout = this.selectedApplicationCommandUiBinding.a;
        m.checkNotNullExpressionValue(constraintLayout, "selectedApplicationCommandUiBinding.root");
        constraintLayout.setVisibility(0);
        this.selectedApplicationCommandAdapter.clear();
        this.selectedApplicationCommandAdapter.setApplicationCommand(viewState.getSelectedCommand(), viewState.getSelectedApplication());
        ApplicationCommandOption selectedCommandOption = viewState.getSelectedCommandOption();
        if (selectedCommandOption != null) {
            if (viewState.getSelectedCommandOptionErrors().contains(selectedCommandOption)) {
                TextView textView = this.selectedApplicationCommandUiBinding.f2301b;
                m.checkNotNullExpressionValue(textView, "selectedApplicationComma…CommandsOptionDescription");
                Resources resources = this.editText.getResources();
                m.checkNotNullExpressionValue(resources, "editText.resources");
                textView.setText(StoreApplicationCommandsKt.getErrorText(selectedCommandOption, resources));
                WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding = this.selectedApplicationCommandUiBinding;
                TextView textView2 = widgetChatInputApplicationCommandsBinding.f2301b;
                ConstraintLayout constraintLayout2 = widgetChatInputApplicationCommandsBinding.a;
                m.checkNotNullExpressionValue(constraintLayout2, "selectedApplicationCommandUiBinding.root");
                textView2.setTextColor(ColorCompat.getColor(constraintLayout2.getContext(), 2131100382));
            } else {
                TextView textView3 = this.selectedApplicationCommandUiBinding.f2301b;
                m.checkNotNullExpressionValue(textView3, "selectedApplicationComma…CommandsOptionDescription");
                Resources resources2 = this.editText.getResources();
                m.checkNotNullExpressionValue(resources2, "editText.resources");
                textView3.setText(StoreApplicationCommandsKt.getDescriptionText(selectedCommandOption, resources2));
                this.selectedApplicationCommandUiBinding.f2301b.setTextColor(ColorCompat.getThemedColor(this.editText.getContext(), 2130969057));
            }
            this.selectedApplicationCommandAdapter.highlightOption(selectedCommandOption);
        } else {
            TextView textView4 = this.selectedApplicationCommandUiBinding.f2301b;
            m.checkNotNullExpressionValue(textView4, "selectedApplicationComma…CommandsOptionDescription");
            ApplicationCommand selectedCommand = viewState.getSelectedCommand();
            Resources resources3 = this.editText.getResources();
            m.checkNotNullExpressionValue(resources3, "editText.resources");
            textView4.setText(StoreApplicationCommandsKt.getDescriptionText(selectedCommand, resources3));
            this.selectedApplicationCommandUiBinding.f2301b.setTextColor(ColorCompat.getThemedColor(this.editText.getContext(), 2130969057));
            this.selectedApplicationCommandAdapter.clearParamOptionHighlight();
        }
        this.selectedApplicationCommandAdapter.setVerified(viewState.getValidSelectedCommandOptions(), viewState.getSelectedCommandOptionErrors());
    }

    public /* synthetic */ InputAutocomplete(AppFragment appFragment, FlexInputFragment flexInputFragment, AppFlexInputViewModel appFlexInputViewModel, FlexEditText flexEditText, Long l, TextView textView, RecyclerView recyclerView, RecyclerView recyclerView2, View view, RecyclerView recyclerView3, TextView textView2, WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appFragment, flexInputFragment, appFlexInputViewModel, flexEditText, (i & 16) != 0 ? null : l, textView, recyclerView, recyclerView2, view, recyclerView3, textView2, widgetChatInputApplicationCommandsBinding);
    }
}
