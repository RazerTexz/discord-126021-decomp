package com.discord.widgets.botuikit.views.select;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import com.discord.api.botuikit.SelectComponent2;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreStream;
import d0.t.Iterables2;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: SelectComponentBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentBottomSheetViewModel extends AppViewModel<ViewState> {
    private final SelectComponentBottomSheet2 componentContext;
    private final int componentIndex;
    private final String customId;
    private final boolean emojiAnimationsEnabled;
    private final PublishSubject<Event> eventSubject;
    private final boolean isMultiSelect;
    private final List<SelectComponent2> items;
    private final int max;
    private final int min;
    private final String placeholder;
    private final Set<SelectComponent2> selectedItems;
    private final List<SelectComponent2> selectedOptions;

    /* JADX INFO: compiled from: SelectComponentBottomSheetViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: SelectComponentBottomSheetViewModel.kt */
        public static final class CloseSheet extends Event {
            public static final CloseSheet INSTANCE = new CloseSheet();

            private CloseSheet() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: SelectComponentBottomSheetViewModel.kt */
    public static final class ViewState {
        private final boolean emojiAnimationsEnabled;
        private final boolean isMultiSelect;
        private final boolean isValidSelection;
        private final List<SelectComponentBottomSheetAdapter2> items;
        private final int maxSelections;
        private final int minSelections;
        private final boolean showSelectButton;
        private final String title;

        public ViewState(String str, List<SelectComponentBottomSheetAdapter2> list, boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5) {
            Intrinsics3.checkNotNullParameter(list, "items");
            this.title = str;
            this.items = list;
            this.showSelectButton = z2;
            this.isMultiSelect = z3;
            this.minSelections = i;
            this.maxSelections = i2;
            this.isValidSelection = z4;
            this.emojiAnimationsEnabled = z5;
        }

        public final boolean getEmojiAnimationsEnabled() {
            return this.emojiAnimationsEnabled;
        }

        public final List<SelectComponentBottomSheetAdapter2> getItems() {
            return this.items;
        }

        public final int getMaxSelections() {
            return this.maxSelections;
        }

        public final int getMinSelections() {
            return this.minSelections;
        }

        public final boolean getShowSelectButton() {
            return this.showSelectButton;
        }

        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: isMultiSelect, reason: from getter */
        public final boolean getIsMultiSelect() {
            return this.isMultiSelect;
        }

        /* JADX INFO: renamed from: isValidSelection, reason: from getter */
        public final boolean getIsValidSelection() {
            return this.isValidSelection;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectComponentBottomSheetViewModel(SelectComponentBottomSheet2 selectComponentBottomSheet2, int i, String str, String str2, List<SelectComponent2> list, int i2, int i3, List<SelectComponent2> list2, boolean z2) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(selectComponentBottomSheet2, "componentContext");
        Intrinsics3.checkNotNullParameter(str, "customId");
        Intrinsics3.checkNotNullParameter(list, "items");
        Intrinsics3.checkNotNullParameter(list2, "selectedOptions");
        this.componentContext = selectComponentBottomSheet2;
        this.componentIndex = i;
        this.customId = str;
        this.placeholder = str2;
        this.items = list;
        this.min = i2;
        this.max = i3;
        this.selectedOptions = list2;
        this.emojiAnimationsEnabled = z2;
        this.isMultiSelect = i3 > 1;
        this.selectedItems = _Collections.toMutableSet(list2);
        updateViewState();
        this.eventSubject = PublishSubject.k0();
    }

    private final boolean isValidSelection() {
        int i = this.min;
        int i2 = this.max;
        int size = this.selectedItems.size();
        return i <= size && i2 >= size;
    }

    private final void sendSelectInteraction(Set<SelectComponent2> selection) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getLocalActionComponentState().setSelectComponentSelection(this.componentContext.getMessageId(), this.componentIndex, _Collections.toList(selection));
        StoreApplicationInteractions interactions = companion.getInteractions();
        long applicationId = this.componentContext.getApplicationId();
        Long guildId = this.componentContext.getGuildId();
        long channelId = this.componentContext.getChannelId();
        long messageId = this.componentContext.getMessageId();
        Long messageFlags = this.componentContext.getMessageFlags();
        int i = this.componentIndex;
        String str = this.customId;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(selection, 10));
        Iterator<T> it = selection.iterator();
        while (it.hasNext()) {
            arrayList.add(((SelectComponent2) it.next()).getValue());
        }
        interactions.sendComponentInteraction(applicationId, guildId, channelId, messageId, i, new RestAPIParams.ComponentInteractionData.SelectComponentInteractionData(null, str, _Collections.toList(arrayList), 1, null), messageFlags);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.CloseSheet.INSTANCE);
    }

    public final SelectComponentBottomSheet2 getComponentContext() {
        return this.componentContext;
    }

    public final int getComponentIndex() {
        return this.componentIndex;
    }

    public final String getCustomId() {
        return this.customId;
    }

    public final boolean getEmojiAnimationsEnabled() {
        return this.emojiAnimationsEnabled;
    }

    public final List<SelectComponent2> getItems() {
        return this.items;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final Set<SelectComponent2> getSelectedItems() {
        return this.selectedItems;
    }

    public final List<SelectComponent2> getSelectedOptions() {
        return this.selectedOptions;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onClickSelect() {
        sendSelectInteraction(_Collections.toSet(this.selectedItems));
    }

    @MainThread
    public final void selectItem(SelectComponent2 selectItem, boolean selected) {
        Intrinsics3.checkNotNullParameter(selectItem, "selectItem");
        if (!this.isMultiSelect) {
            sendSelectInteraction(SetsJVM.setOf(selectItem));
            return;
        }
        if (selected) {
            this.selectedItems.add(selectItem);
        } else {
            this.selectedItems.remove(selectItem);
        }
        updateViewState();
    }

    public final void updateViewState() {
        String str = this.placeholder;
        List<SelectComponent2> list = this.items;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        for (SelectComponent2 selectComponent2 : list) {
            arrayList.add(new SelectComponentBottomSheetAdapter2(selectComponent2, this.selectedItems.contains(selectComponent2)));
        }
        updateViewState(new ViewState(str, arrayList, this.isMultiSelect, this.isMultiSelect, this.min, this.max, isValidSelection(), this.emojiAnimationsEnabled));
    }
}
