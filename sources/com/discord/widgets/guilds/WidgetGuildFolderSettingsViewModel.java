package com.discord.widgets.guilds;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.models.domain.ModelUserSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettingsViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long folderId;
    private StoreState previousStoreState;
    private final StoreUserSettings storeUserSettings;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetGuildFolderSettingsViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final long folderId, StoreUserSettings storeUserSettings, StoreGuildsSorted storeGuildsSorted) {
            Observable<StoreState> observableJ = Observable.j(storeUserSettings.observeGuildFolders(), storeGuildsSorted.observeEntries(), new Func2<List<? extends ModelGuildFolder>, List<? extends StoreGuildsSorted.Entry>, StoreState>() { // from class: com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel$Companion$observeStoreState$1
                @Override // rx.functions.Func2
                public /* bridge */ /* synthetic */ WidgetGuildFolderSettingsViewModel.StoreState call(List<? extends ModelGuildFolder> list, List<? extends StoreGuildsSorted.Entry> list2) {
                    return call2((List<ModelGuildFolder>) list, list2);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetGuildFolderSettingsViewModel.StoreState call2(List<ModelGuildFolder> list, List<? extends StoreGuildsSorted.Entry> list2) {
                    Object next;
                    Long id2;
                    Intrinsics3.checkNotNullExpressionValue(list, "guildFolders");
                    Iterator<T> it = list.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        id2 = ((ModelGuildFolder) next).getId();
                    } while (!(id2 != null && id2.longValue() == folderId));
                    ModelGuildFolder modelGuildFolder = (ModelGuildFolder) next;
                    if (modelGuildFolder == null) {
                        return WidgetGuildFolderSettingsViewModel.StoreState.Invalid.INSTANCE;
                    }
                    Intrinsics3.checkNotNullExpressionValue(list2, "sortedGuilds");
                    return new WidgetGuildFolderSettingsViewModel.StoreState.Valid(modelGuildFolder, list2);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…Guilds)\n        }\n      }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
        public static final /* data */ class UpdateFolderSettingsFailure extends Event {
            private final int failureMessageStringRes;

            public UpdateFolderSettingsFailure(int i) {
                super(null);
                this.failureMessageStringRes = i;
            }

            public static /* synthetic */ UpdateFolderSettingsFailure copy$default(UpdateFolderSettingsFailure updateFolderSettingsFailure, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = updateFolderSettingsFailure.failureMessageStringRes;
                }
                return updateFolderSettingsFailure.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public final UpdateFolderSettingsFailure copy(int failureMessageStringRes) {
                return new UpdateFolderSettingsFailure(failureMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof UpdateFolderSettingsFailure) && this.failureMessageStringRes == ((UpdateFolderSettingsFailure) other).failureMessageStringRes;
                }
                return true;
            }

            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public int hashCode() {
                return this.failureMessageStringRes;
            }

            public String toString() {
                return outline.B(outline.U("UpdateFolderSettingsFailure(failureMessageStringRes="), this.failureMessageStringRes, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
        public static final /* data */ class UpdateFolderSettingsSuccess extends Event {
            private final int successMessageStringRes;

            public UpdateFolderSettingsSuccess(int i) {
                super(null);
                this.successMessageStringRes = i;
            }

            public static /* synthetic */ UpdateFolderSettingsSuccess copy$default(UpdateFolderSettingsSuccess updateFolderSettingsSuccess, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = updateFolderSettingsSuccess.successMessageStringRes;
                }
                return updateFolderSettingsSuccess.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public final UpdateFolderSettingsSuccess copy(int successMessageStringRes) {
                return new UpdateFolderSettingsSuccess(successMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof UpdateFolderSettingsSuccess) && this.successMessageStringRes == ((UpdateFolderSettingsSuccess) other).successMessageStringRes;
                }
                return true;
            }

            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public int hashCode() {
                return this.successMessageStringRes;
            }

            public String toString() {
                return outline.B(outline.U("UpdateFolderSettingsSuccess(successMessageStringRes="), this.successMessageStringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
    public static final /* data */ class FormState {
        private final Integer color;
        private final String name;

        public FormState(String str, Integer num) {
            this.name = str;
            this.color = num;
        }

        public static /* synthetic */ FormState copy$default(FormState formState, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = formState.name;
            }
            if ((i & 2) != 0) {
                num = formState.color;
            }
            return formState.copy(str, num);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getColor() {
            return this.color;
        }

        public final FormState copy(String name, Integer color) {
            return new FormState(name, color);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FormState)) {
                return false;
            }
            FormState formState = (FormState) other;
            return Intrinsics3.areEqual(this.name, formState.name) && Intrinsics3.areEqual(this.color, formState.color);
        }

        public final Integer getColor() {
            return this.color;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.color;
            return iHashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("FormState(name=");
            sbU.append(this.name);
            sbU.append(", color=");
            return outline.F(sbU, this.color, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final ModelGuildFolder folder;
            private final List<StoreGuildsSorted.Entry> sortedGuilds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Valid(ModelGuildFolder modelGuildFolder, List<? extends StoreGuildsSorted.Entry> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGuildFolder, "folder");
                Intrinsics3.checkNotNullParameter(list, "sortedGuilds");
                this.folder = modelGuildFolder;
                this.sortedGuilds = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Valid copy$default(Valid valid, ModelGuildFolder modelGuildFolder, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildFolder = valid.folder;
                }
                if ((i & 2) != 0) {
                    list = valid.sortedGuilds;
                }
                return valid.copy(modelGuildFolder, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelGuildFolder getFolder() {
                return this.folder;
            }

            public final List<StoreGuildsSorted.Entry> component2() {
                return this.sortedGuilds;
            }

            public final Valid copy(ModelGuildFolder folder, List<? extends StoreGuildsSorted.Entry> sortedGuilds) {
                Intrinsics3.checkNotNullParameter(folder, "folder");
                Intrinsics3.checkNotNullParameter(sortedGuilds, "sortedGuilds");
                return new Valid(folder, sortedGuilds);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.folder, valid.folder) && Intrinsics3.areEqual(this.sortedGuilds, valid.sortedGuilds);
            }

            public final ModelGuildFolder getFolder() {
                return this.folder;
            }

            public final List<StoreGuildsSorted.Entry> getSortedGuilds() {
                return this.sortedGuilds;
            }

            public int hashCode() {
                ModelGuildFolder modelGuildFolder = this.folder;
                int iHashCode = (modelGuildFolder != null ? modelGuildFolder.hashCode() : 0) * 31;
                List<StoreGuildsSorted.Entry> list = this.sortedGuilds;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(folder=");
                sbU.append(this.folder);
                sbU.append(", sortedGuilds=");
                return outline.L(sbU, this.sortedGuilds, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final FormState formState;
            private final boolean showSave;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(FormState formState, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(formState, "formState");
                this.formState = formState;
                this.showSave = z2;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, FormState formState, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    formState = loaded.formState;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.showSave;
                }
                return loaded.copy(formState, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FormState getFormState() {
                return this.formState;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getShowSave() {
                return this.showSave;
            }

            public final Loaded copy(FormState formState, boolean showSave) {
                Intrinsics3.checkNotNullParameter(formState, "formState");
                return new Loaded(formState, showSave);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.formState, loaded.formState) && this.showSave == loaded.showSave;
            }

            public final FormState getFormState() {
                return this.formState;
            }

            public final boolean getShowSave() {
                return this.showSave;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                FormState formState = this.formState;
                int iHashCode = (formState != null ? formState.hashCode() : 0) * 31;
                boolean z2 = this.showSave;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(formState=");
                sbU.append(this.formState);
                sbU.append(", showSave=");
                return outline.O(sbU, this.showSave, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel$saveFolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelUserSettings, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
            WidgetGuildFolderSettingsViewModel.this.emitUpdateSuccessEvent();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel$saveFolder$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetGuildFolderSettingsViewModel.this.emitUpdateFailureEvent();
        }
    }

    public /* synthetic */ WidgetGuildFolderSettingsViewModel(long j, StoreUserSettings storeUserSettings, StoreGuildsSorted storeGuildsSorted, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings, (i & 4) != 0 ? StoreStream.INSTANCE.getGuildsSorted() : storeGuildsSorted);
    }

    private final void emitUpdateFailureEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.UpdateFolderSettingsFailure(R.string.default_failure_to_perform_action_message));
    }

    private final void emitUpdateSuccessEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.UpdateFolderSettingsSuccess(R.string.guild_folder_updated_success));
    }

    private final void handleStoreState(StoreState storeState) {
        this.previousStoreState = storeState;
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid = (StoreState.Valid) storeState;
            FormState formState = new FormState(valid.getFolder().getName(), valid.getFolder().getColor());
            updateViewState(new ViewState.Loaded(formState, shouldShowSave(valid, formState)));
        }
    }

    private final boolean shouldShowSave(StoreState.Valid storeState, FormState formState) {
        return (Intrinsics3.areEqual(storeState.getFolder().getColor(), formState.getColor()) ^ true) || (Intrinsics3.areEqual(storeState.getFolder().getName(), formState.getName()) ^ true);
    }

    private final void updateFormState(FormState formState) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            StoreState storeState = this.previousStoreState;
            updateViewState(loaded.copy(formState, storeState instanceof StoreState.Valid ? shouldShowSave((StoreState.Valid) storeState, formState) : false));
        }
    }

    public final long getFolderId() {
        return this.folderId;
    }

    public final StoreState getPreviousStoreState() {
        return this.previousStoreState;
    }

    public final StoreUserSettings getStoreUserSettings() {
        return this.storeUserSettings;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void saveFolder() {
        ModelGuildFolder modelGuildFolderAsModelGuildFolder;
        StoreState storeState = this.previousStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null) {
            ViewState viewState = getViewState();
            if (!(viewState instanceof ViewState.Loaded)) {
                viewState = null;
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewState;
            if (loaded != null) {
                FormState formState = loaded.getFormState();
                List<StoreGuildsSorted.Entry> sortedGuilds = valid.getSortedGuilds();
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(sortedGuilds, 10));
                for (StoreGuildsSorted.Entry entry : sortedGuilds) {
                    if (entry instanceof StoreGuildsSorted.Entry.SingletonGuild) {
                        modelGuildFolderAsModelGuildFolder = entry.asModelGuildFolder();
                    } else {
                        if (!(entry instanceof StoreGuildsSorted.Entry.Folder)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        StoreGuildsSorted.Entry.Folder folder = (StoreGuildsSorted.Entry.Folder) entry;
                        modelGuildFolderAsModelGuildFolder = folder.getId() == this.folderId ? StoreGuildsSorted.Entry.Folder.copy$default(folder, 0L, null, formState.getColor(), formState.getName(), 3, null).asModelGuildFolder() : entry.asModelGuildFolder();
                    }
                    arrayList.add(modelGuildFolderAsModelGuildFolder);
                }
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithGuildFolders(arrayList)), false, 1, null), this, null, 2, null), (Class<?>) WidgetGuildFolderSettingsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
            }
        }
    }

    public final void setColor(Integer color) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), null, color, 1, null));
        }
    }

    public final void setName(String name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), name, null, 2, null));
        }
    }

    public final void setPreviousStoreState(StoreState storeState) {
        this.previousStoreState = storeState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildFolderSettingsViewModel(long j, StoreUserSettings storeUserSettings, StoreGuildsSorted storeGuildsSorted) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        Intrinsics3.checkNotNullParameter(storeGuildsSorted, "storeGuildsSorted");
        this.folderId = j;
        this.storeUserSettings = storeUserSettings;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(INSTANCE.observeStoreState(j, storeUserSettings, storeGuildsSorted)), this, null, 2, null), (Class<?>) WidgetGuildFolderSettingsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        this.eventSubject = PublishSubject.k0();
    }
}
