package com.discord.widgets.botuikit.views.select;

import androidx.annotation.MainThread;
import com.discord.api.botuikit.SelectItem;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p507d0.p580t.C12146m0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: SelectComponentBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentBottomSheetViewModel extends AbstractC0859d0<ViewState> {
    private final ComponentContext componentContext;
    private final int componentIndex;
    private final String customId;
    private final boolean emojiAnimationsEnabled;
    private final PublishSubject<Event> eventSubject;
    private final boolean isMultiSelect;
    private final List<SelectItem> items;
    private final int max;
    private final int min;
    private final String placeholder;
    private final Set<SelectItem> selectedItems;
    private final List<SelectItem> selectedOptions;

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
        private final List<SelectComponentBottomSheetItem> items;
        private final int maxSelections;
        private final int minSelections;
        private final boolean showSelectButton;
        private final String title;

        public ViewState(String str, List<SelectComponentBottomSheetItem> list, boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5) {
            C12238m.checkNotNullParameter(list, "items");
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

        public final List<SelectComponentBottomSheetItem> getItems() {
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
    public SelectComponentBottomSheetViewModel(ComponentContext componentContext, int i, String str, String str2, List<SelectItem> list, int i2, int i3, List<SelectItem> list2, boolean z2) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(componentContext, "componentContext");
        C12238m.checkNotNullParameter(str, "customId");
        C12238m.checkNotNullParameter(list, "items");
        C12238m.checkNotNullParameter(list2, "selectedOptions");
        this.componentContext = componentContext;
        this.componentIndex = i;
        this.customId = str;
        this.placeholder = str2;
        this.items = list;
        this.min = i2;
        this.max = i3;
        this.selectedOptions = list2;
        this.emojiAnimationsEnabled = z2;
        this.isMultiSelect = i3 > 1;
        this.selectedItems = C12163u.toMutableSet(list2);
        updateViewState();
        this.eventSubject = PublishSubject.m11133k0();
    }

    private final boolean isValidSelection() {
        int i = this.min;
        int i2 = this.max;
        int size = this.selectedItems.size();
        return i <= size && i2 >= size;
    }

    private final void sendSelectInteraction(Set<SelectItem> selection) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getLocalActionComponentState().setSelectComponentSelection(this.componentContext.getMessageId(), this.componentIndex, C12163u.toList(selection));
        StoreApplicationInteractions interactions = companion.getInteractions();
        long applicationId = this.componentContext.getApplicationId();
        Long guildId = this.componentContext.getGuildId();
        long channelId = this.componentContext.getChannelId();
        long messageId = this.componentContext.getMessageId();
        Long messageFlags = this.componentContext.getMessageFlags();
        int i = this.componentIndex;
        String str = this.customId;
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(selection, 10));
        Iterator<T> it = selection.iterator();
        while (it.hasNext()) {
            arrayList.add(((SelectItem) it.next()).getValue());
        }
        interactions.sendComponentInteraction(applicationId, guildId, channelId, messageId, i, new RestAPIParams.ComponentInteractionData.SelectComponentInteractionData(null, str, C12163u.toList(arrayList), 1, null), messageFlags);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.CloseSheet.INSTANCE);
    }

    public final ComponentContext getComponentContext() {
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

    public final List<SelectItem> getItems() {
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

    public final Set<SelectItem> getSelectedItems() {
        return this.selectedItems;
    }

    public final List<SelectItem> getSelectedOptions() {
        return this.selectedOptions;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onClickSelect() {
        sendSelectInteraction(C12163u.toSet(this.selectedItems));
    }

    @MainThread
    public final void selectItem(SelectItem selectItem, boolean selected) {
        C12238m.checkNotNullParameter(selectItem, "selectItem");
        if (!this.isMultiSelect) {
            sendSelectInteraction(C12146m0.setOf(selectItem));
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
        List<SelectItem> list = this.items;
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
        for (SelectItem selectItem : list) {
            arrayList.add(new SelectComponentBottomSheetItem(selectItem, this.selectedItems.contains(selectItem)));
        }
        updateViewState(new ViewState(str, arrayList, this.isMultiSelect, this.isMultiSelect, this.min, this.max, isValidSelection(), this.emojiAnimationsEnabled));
    }
}
